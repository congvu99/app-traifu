package com.facebook.react.animated;

import androidx.compose.animation.core.AnimationKt;
import com.facebook.react.bridge.ReadableMap;
import com.github.mikephil.charting.utils.Utils;

public class DecayAnimation extends AnimationDriver {
    private int mCurrentLoop;
    private double mDeceleration;
    private double mFromValue;
    private int mIterations;
    private double mLastValue;
    private long mStartFrameTimeMillis;
    private final double mVelocity;

    public DecayAnimation(ReadableMap readableMap) {
        this.mVelocity = readableMap.getDouble("velocity");
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        this.mDeceleration = readableMap.getDouble("deceleration");
        boolean z = true;
        int i = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : 1;
        this.mIterations = i;
        this.mCurrentLoop = 1;
        if (i != 0) {
            z = false;
        }
        this.mHasFinished = z;
        this.mStartFrameTimeMillis = -1;
        this.mFromValue = Utils.DOUBLE_EPSILON;
        this.mLastValue = Utils.DOUBLE_EPSILON;
    }

    public void runAnimationStep(long j) {
        long j2 = j / AnimationKt.MillisToNanos;
        if (this.mStartFrameTimeMillis == -1) {
            this.mStartFrameTimeMillis = j2 - 16;
            if (this.mFromValue == this.mLastValue) {
                this.mFromValue = this.mAnimatedValue.mValue;
            } else {
                this.mAnimatedValue.mValue = this.mFromValue;
            }
            this.mLastValue = this.mAnimatedValue.mValue;
        }
        double d = this.mFromValue;
        double d2 = this.mVelocity;
        double d3 = this.mDeceleration;
        double exp = d + ((d2 / (1.0d - d3)) * (1.0d - Math.exp((-(1.0d - d3)) * ((double) (j2 - this.mStartFrameTimeMillis)))));
        if (Math.abs(this.mLastValue - exp) < 0.1d) {
            int i = this.mIterations;
            if (i == -1 || this.mCurrentLoop < i) {
                this.mStartFrameTimeMillis = -1;
                this.mCurrentLoop++;
            } else {
                this.mHasFinished = true;
                return;
            }
        }
        this.mLastValue = exp;
        this.mAnimatedValue.mValue = exp;
    }
}
