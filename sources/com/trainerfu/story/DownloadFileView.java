package com.trainerfu.story;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class DownloadFileView extends SectionPartView {
    /* access modifiers changed from: private */
    public JSONObject file;

    public DownloadFileView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DownloadFileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadFileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews();
    }

    public void initializeViews() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.download_file_view, this);
        findViewById(R.id.main_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    DownloadFileView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(DownloadFileView.this.file.getString("url"))));
                } catch (JSONException unused) {
                    throw new RuntimeException("Invalid file url");
                }
            }
        });
    }

    public void setFile(JSONObject jSONObject) {
        this.file = jSONObject;
        TextView textView = (TextView) findViewById(R.id.file_name_view);
        IconTextView iconTextView = (IconTextView) findViewById(R.id.file_icon_view);
        try {
            String string = jSONObject.getString("name");
            textView.setText(string);
            String[] mimeType = Util.getMimeType(string);
            String str = "{fa-file}";
            if (mimeType[0].equals("image")) {
                str = "{fa-file-image-o}";
            } else if (mimeType[0].equals("video")) {
                str = "{fa-file-video-o}";
            } else if (mimeType[0].equals("audio")) {
                str = "{fa-file-audio-o}";
            } else if (mimeType[1].equals("pdf")) {
                str = "{fa-file-pdf-o}";
            } else if (mimeType[1].equals("msword")) {
                str = "{fa-file-word-o}";
            } else if (mimeType[1].equals("vnd.ms-excel")) {
                str = "{fa-file-excel-o}";
            } else if (mimeType[1].equals("zip")) {
                str = "{fa-file-zip-o}";
            }
            iconTextView.setText(str);
        } catch (JSONException unused) {
            throw new RuntimeException("Invalid File Name");
        }
    }
}
