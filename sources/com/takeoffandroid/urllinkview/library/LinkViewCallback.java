package com.takeoffandroid.urllinkview.library;

public interface LinkViewCallback {
    void onAfterLoading(LinkSourceContent linkSourceContent, boolean z);

    void onBeforeLoading();
}
