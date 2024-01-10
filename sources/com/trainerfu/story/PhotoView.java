package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.trainerfu.android.OnSwipeTouchListener;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoView extends SectionPartView {
    private static int sectionWidth;
    private String currentUrl;
    private EventListener eventListener;
    private JSONObject photo;
    private ImageView photoView;

    public interface EventListener {
        void onAddComment(int i);

        void onGoNext(int i);

        void onGoPrev(int i);

        void onLikeStory(int i);

        void onShare(int i);

        void onShowMoreOptions(int i);

        void onUnlikeStory(int i);
    }

    public PhotoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentUrl = "";
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.photo_view, this);
        ImageView imageView = (ImageView) findViewById(R.id.photo_view);
        this.photoView = imageView;
        imageView.setOnTouchListener(new OnSwipeTouchListener(getContext()) {
            public void onSwipeUp() {
                Toast.makeText(PhotoView.this.getContext(), "up", 0).show();
            }

            public void onSwipeDown() {
                Toast.makeText(PhotoView.this.getContext(), "down", 0).show();
            }

            public void onSwipeRight() {
                Toast.makeText(PhotoView.this.getContext(), "right", 0).show();
            }

            public void onSwipeLeft() {
                Toast.makeText(PhotoView.this.getContext(), "left", 0).show();
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                return super.onTouch(view, motionEvent);
            }
        });
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateLayout();
    }

    public void setPhoto(JSONObject jSONObject) {
        String str;
        try {
            this.photo = jSONObject;
            if (jSONObject.has("photo_id")) {
                str = Util.getUrlForPhoto(jSONObject.getInt("photo_id"));
            } else {
                str = Util.getUrlForPhoto(jSONObject.getInt("id"));
            }
            if (!this.currentUrl.equals(str)) {
                this.currentUrl = str;
                updateLayout();
                this.photoView.setImageResource(17170445);
                Glide.with(getContext()).load(str).into(this.photoView);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLayout() {
        int i;
        int i2;
        if (sectionWidth == 0) {
            sectionWidth = SectionBaseViewModel.getSectionWidthInDpi(getContext());
        }
        try {
            if (this.photo.has("width")) {
                i = this.photo.getInt("width");
            } else {
                i = this.photo.getInt("w");
            }
            if (this.photo.has("height")) {
                i2 = this.photo.getInt("height");
            } else {
                i2 = this.photo.getInt("h");
            }
            double d = i2 > 0 ? (((double) i) * 1.0d) / ((double) i2) : 1.0d;
            ViewGroup.LayoutParams layoutParams = this.photoView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = Util.sizeInPx(getContext(), (int) ((((double) (sectionWidth - 10)) * 1.0d) / d));
                this.photoView.setLayoutParams(layoutParams);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
