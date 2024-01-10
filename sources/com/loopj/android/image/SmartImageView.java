package com.loopj.android.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.loopj.android.image.SmartImageTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SmartImageView extends ImageView {
    private static final int LOADING_THREADS = 4;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
    private SmartImageTask currentTask;

    public SmartImageView(Context context) {
        super(context);
    }

    public SmartImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SmartImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static void cancelAllTasks() {
        threadPool.shutdownNow();
        threadPool = Executors.newFixedThreadPool(4);
    }

    public void setImage(SmartImage smartImage) {
        setImage(smartImage, (Integer) null, (Integer) null);
    }

    public void setImage(SmartImage smartImage, Integer num) {
        setImage(smartImage, num, num);
    }

    public void setImage(SmartImage smartImage, final Integer num, Integer num2) {
        if (num2 != null) {
            setImageResource(num2.intValue());
        }
        SmartImageTask smartImageTask = this.currentTask;
        if (smartImageTask != null) {
            smartImageTask.cancel();
            this.currentTask = null;
        }
        SmartImageTask smartImageTask2 = new SmartImageTask(getContext(), smartImage);
        this.currentTask = smartImageTask2;
        smartImageTask2.setOnCompleteHandler(new SmartImageTask.OnCompleteHandler() {
            public void onComplete(Bitmap bitmap) {
                if (bitmap != null) {
                    SmartImageView.this.setImageBitmap(bitmap);
                    return;
                }
                Integer num = num;
                if (num != null) {
                    SmartImageView.this.setImageResource(num.intValue());
                }
            }
        });
        threadPool.execute(this.currentTask);
    }

    public void setImageContact(long j) {
        setImage(new ContactImage(j));
    }

    public void setImageContact(long j, Integer num) {
        setImage(new ContactImage(j), num);
    }

    public void setImageContact(long j, Integer num, Integer num2) {
        setImage(new ContactImage(j), num, num);
    }

    public void setImageUrl(String str) {
        setImage(new WebImage(str));
    }

    public void setImageUrl(String str, Integer num) {
        setImage(new WebImage(str), num);
    }

    public void setImageUrl(String str, Integer num, Integer num2) {
        setImage(new WebImage(str), num, num2);
    }
}
