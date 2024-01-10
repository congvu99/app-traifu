package com.trainerfu.story;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class LinkView extends SectionPartView {
    private String currentImageUrl;
    /* access modifiers changed from: private */
    public String url;

    public LinkView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentImageUrl = "";
        this.url = "";
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.link_view, this);
        findViewById(R.id.image_view).getLayoutParams().height = Util.sizeInPx(getContext(), (int) (((double) SectionBaseViewModel.getSectionWidthInDpi(context)) * 0.52d));
        findViewById(R.id.link_view).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LinkView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(LinkView.this.url)));
            }
        });
    }

    public void setMeta(JSONObject jSONObject) {
        try {
            if (jSONObject.has("purl")) {
                SmartImageView smartImageView = (SmartImageView) findViewById(R.id.image_view);
                smartImageView.setVisibility(0);
                String string = jSONObject.getString("purl");
                if (!string.equals(this.currentImageUrl)) {
                    smartImageView.setImageUrl(jSONObject.getString("purl"));
                    this.currentImageUrl = string;
                }
            } else {
                findViewById(R.id.image_view).setVisibility(8);
            }
            if (jSONObject.has("ti")) {
                TextView textView = (TextView) findViewById(R.id.title_view);
                textView.setVisibility(0);
                textView.setText(jSONObject.getString("ti"));
            } else {
                findViewById(R.id.title_view).setVisibility(8);
            }
            ((TextView) findViewById(R.id.url_view)).setText(jSONObject.getString("url"));
            this.url = jSONObject.getString("url");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
