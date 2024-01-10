package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

public class HorizontalProgressDrawable extends LayerDrawable implements IntrinsicPaddingDrawable, ShowTrackDrawable, TintableDrawable {
    private SingleHorizontalProgressDrawable mProgressDrawable;
    private int mSecondaryAlpha;
    private SingleHorizontalProgressDrawable mSecondaryProgressDrawable;
    private SingleHorizontalProgressDrawable mTrackDrawable = ((SingleHorizontalProgressDrawable) getDrawable(0));

    public HorizontalProgressDrawable(Context context) {
        super(new Drawable[]{new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context)});
        setId(0, 16908288);
        setId(1, 16908303);
        this.mSecondaryProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(1);
        int round = Math.round(ThemeUtils.getFloatFromAttrRes(16842803, context) * 255.0f);
        this.mSecondaryAlpha = round;
        this.mSecondaryProgressDrawable.setAlpha(round);
        this.mSecondaryProgressDrawable.setShowTrack(false);
        setId(2, 16908301);
        SingleHorizontalProgressDrawable singleHorizontalProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(2);
        this.mProgressDrawable = singleHorizontalProgressDrawable;
        singleHorizontalProgressDrawable.setShowTrack(false);
    }

    public boolean getShowTrack() {
        return this.mTrackDrawable.getShowTrack();
    }

    public void setShowTrack(boolean z) {
        if (this.mTrackDrawable.getShowTrack() != z) {
            this.mTrackDrawable.setShowTrack(z);
            this.mSecondaryProgressDrawable.setAlpha(z ? this.mSecondaryAlpha : this.mSecondaryAlpha * 2);
        }
    }

    public boolean getUseIntrinsicPadding() {
        return this.mTrackDrawable.getUseIntrinsicPadding();
    }

    public void setUseIntrinsicPadding(boolean z) {
        this.mTrackDrawable.setUseIntrinsicPadding(z);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z);
        this.mProgressDrawable.setUseIntrinsicPadding(z);
    }

    public void setTint(int i) {
        this.mTrackDrawable.setTint(i);
        this.mSecondaryProgressDrawable.setTint(i);
        this.mProgressDrawable.setTint(i);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTrackDrawable.setTintList(colorStateList);
        this.mSecondaryProgressDrawable.setTintList(colorStateList);
        this.mProgressDrawable.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mTrackDrawable.setTintMode(mode);
        this.mSecondaryProgressDrawable.setTintMode(mode);
        this.mProgressDrawable.setTintMode(mode);
    }
}
