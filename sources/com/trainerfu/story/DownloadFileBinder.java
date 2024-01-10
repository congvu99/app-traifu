package com.trainerfu.story;

import android.content.Context;
import org.json.JSONObject;

public class DownloadFileBinder extends SectionPartBinder {
    private JSONObject file;

    public DownloadFileBinder(Context context, JSONObject jSONObject) {
        super(context);
        this.file = jSONObject;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof DownloadFileView) {
            ((DownloadFileView) sectionPartView).setFile(this.file);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
