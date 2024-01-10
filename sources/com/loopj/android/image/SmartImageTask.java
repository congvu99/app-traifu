package com.loopj.android.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class SmartImageTask implements Runnable {
    private static final int BITMAP_READY = 0;
    private boolean cancelled = false;
    private Context context;
    private SmartImage image;
    private OnCompleteHandler onCompleteHandler;

    public static class OnCompleteHandler extends Handler {
        public void handleMessage(Message message) {
            onComplete((Bitmap) message.obj);
        }

        public void onComplete(Bitmap bitmap) {
        }
    }

    public SmartImageTask(Context context2, SmartImage smartImage) {
        this.image = smartImage;
        this.context = context2;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void complete(Bitmap bitmap) {
        OnCompleteHandler onCompleteHandler2 = this.onCompleteHandler;
        if (onCompleteHandler2 != null && !this.cancelled) {
            onCompleteHandler2.sendMessage(onCompleteHandler2.obtainMessage(0, bitmap));
        }
    }

    public void run() {
        SmartImage smartImage = this.image;
        if (smartImage != null) {
            complete(smartImage.getBitmap(this.context));
            this.context = null;
        }
    }

    public void setOnCompleteHandler(OnCompleteHandler onCompleteHandler2) {
        this.onCompleteHandler = onCompleteHandler2;
    }
}
