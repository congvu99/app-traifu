package com.trainerfu.story;

import android.content.Context;

public class RecordBinder extends SectionPartBinder {
    private String record;

    public RecordBinder(Context context, String str) {
        super(context);
        this.record = str;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof RecordView) {
            ((RecordView) sectionPartView).setRecord(this.record);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
