package io.intercom.android.sdk.blocks.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.AccessibilityUtils;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;

public class VideoPreviewView extends RelativeLayout {
    private static final int PLAY_ARROW_OFFSET_DP = 3;
    private static final int PLAY_BUTTON_DIAMETER_DP = 48;
    /* access modifiers changed from: private */
    public final ProgressBar loadingSpinner = getLoadingSpinner();
    /* access modifiers changed from: private */
    public final ImageView playButton;
    /* access modifiers changed from: private */
    public final ImageView thumbnailImageView;

    public VideoPreviewView(Context context, Provider<AppConfig> provider, StyleType styleType) {
        super(context);
        BlockUtils.createLayoutParams(this, -2, -2);
        BlockUtils.setDefaultMarginBottom(this);
        this.thumbnailImageView = getVideoImageView(context);
        this.playButton = getPlayButtonView(context);
        addView(this.thumbnailImageView);
        addView(this.playButton);
        addView(this.loadingSpinner);
        int primaryColor = provider.get().getPrimaryColor();
        primaryColor = styleType == StyleType.POST ? ColorUtils.lightenColor(primaryColor) : primaryColor;
        if (ColorUtils.isColorLight(primaryColor)) {
            this.playButton.setColorFilter(ContextCompat.getColor(context, R.color.intercom_accessibility_black), PorterDuff.Mode.SRC_ATOP);
        } else {
            this.playButton.setColorFilter(primaryColor, PorterDuff.Mode.SRC_ATOP);
        }
        AccessibilityUtils.INSTANCE.removeClickAbilityAnnouncement(this);
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(this.playButton);
    }

    public ImageView getThumbnailImageView() {
        return this.thumbnailImageView;
    }

    public void displayThumbnail(String str) {
        this.loadingSpinner.setVisibility(0);
        this.thumbnailImageView.setVisibility(4);
        IntercomCoilKt.loadIntercomImage(getContext(), new ImageRequest.Builder(getContext()).data(str).placeholder(R.drawable.intercom_video_thumbnail_fallback).error(R.drawable.intercom_video_thumbnail_fallback).crossfade(true).target(this.thumbnailImageView).listener(new ImageRequest.Listener() {
            public void onCancel(ImageRequest imageRequest) {
            }

            public void onStart(ImageRequest imageRequest) {
            }

            public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
                VideoPreviewView.this.loadingSpinner.setVisibility(8);
                VideoPreviewView.this.thumbnailImageView.setVisibility(0);
                VideoPreviewView.this.updateThumbnailAspectRatio();
                VideoPreviewView.this.playButton.setVisibility(8);
            }

            public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                VideoPreviewView.this.loadingSpinner.setVisibility(8);
                VideoPreviewView.this.thumbnailImageView.setVisibility(0);
                VideoPreviewView.this.updateThumbnailAspectRatio();
                VideoPreviewView.this.thumbnailImageView.setColorFilter(ContextCompat.getColor(VideoPreviewView.this.thumbnailImageView.getContext(), R.color.intercom_semi_transparent), PorterDuff.Mode.DARKEN);
                VideoPreviewView.this.playButton.setVisibility(0);
            }
        }).build());
    }

    /* access modifiers changed from: private */
    public void updateThumbnailAspectRatio() {
        this.thumbnailImageView.getLayoutParams().height = (this.thumbnailImageView.getWidth() * 3) / 4;
    }

    public /* synthetic */ void lambda$showFailedImage$0$VideoPreviewView() {
        BackgroundUtils.setBackground(this.thumbnailImageView, ContextCompat.getDrawable(getContext(), R.drawable.intercom_video_thumbnail_fallback));
    }

    public void showFailedImage() {
        this.thumbnailImageView.post(new Runnable() {
            public final void run() {
                VideoPreviewView.this.lambda$showFailedImage$0$VideoPreviewView();
            }
        });
    }

    private ImageView getPlayButtonView(Context context) {
        int dpToPx = ScreenUtils.dpToPx(48.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.addRule(13);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.intercom_play_arrow);
        imageView.setPadding(ScreenUtils.dpToPx(3.0f, context), 0, 0, 0);
        imageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        imageView.setVisibility(8);
        imageView.setId(R.id.intercom_video_thumbnail_play_button);
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(imageView);
        return imageView;
    }

    private ImageView getVideoImageView(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setId(R.id.intercom_video_thumbnail);
        return imageView;
    }

    private ProgressBar getLoadingSpinner() {
        return (ProgressBar) inflate(getContext(), R.layout.intercom_progress_bar, (ViewGroup) null).findViewById(R.id.progressBar);
    }
}
