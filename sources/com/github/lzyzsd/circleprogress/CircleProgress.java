package com.github.lzyzsd.circleprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgress extends View {
    private static final String INSTANCE_FINISHED_STROKE_COLOR = "finished_stroke_color";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_UNFINISHED_STROKE_COLOR = "unfinished_stroke_color";
    private final int default_finished_color;
    private final int default_max;
    private final int default_text_color;
    private final float default_text_size;
    private final int default_unfinished_color;
    private int finishedColor;
    private int max;
    private final int min_size;
    private Paint paint;
    private String prefixText;
    private int progress;
    private RectF rectF;
    private String suffixText;
    private int textColor;
    private Paint textPaint;
    private float textSize;
    private int unfinishedColor;

    public CircleProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectF = new RectF();
        this.progress = 0;
        this.prefixText = "";
        this.suffixText = "%";
        this.default_finished_color = Color.rgb(66, 145, 241);
        this.default_unfinished_color = Color.rgb(204, 204, 204);
        this.default_text_color = -1;
        this.default_max = 100;
        this.paint = new Paint();
        this.default_text_size = Utils.sp2px(getResources(), 18.0f);
        this.min_size = (int) Utils.dp2px(getResources(), 100.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgress, i, 0);
        initByAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        initPainters();
    }

    /* access modifiers changed from: protected */
    public void initByAttributes(TypedArray typedArray) {
        this.finishedColor = typedArray.getColor(R.styleable.CircleProgress_circle_finished_color, this.default_finished_color);
        this.unfinishedColor = typedArray.getColor(R.styleable.CircleProgress_circle_unfinished_color, this.default_unfinished_color);
        this.textColor = typedArray.getColor(R.styleable.CircleProgress_circle_text_color, -1);
        this.textSize = typedArray.getDimension(R.styleable.CircleProgress_circle_text_size, this.default_text_size);
        setMax(typedArray.getInt(R.styleable.CircleProgress_circle_max, 100));
        setProgress(typedArray.getInt(R.styleable.CircleProgress_circle_progress, 0));
        if (typedArray.getString(R.styleable.CircleProgress_circle_prefix_text) != null) {
            setPrefixText(typedArray.getString(R.styleable.CircleProgress_circle_prefix_text));
        }
        if (typedArray.getString(R.styleable.CircleProgress_circle_suffix_text) != null) {
            setSuffixText(typedArray.getString(R.styleable.CircleProgress_circle_suffix_text));
        }
    }

    /* access modifiers changed from: protected */
    public void initPainters() {
        TextPaint textPaint2 = new TextPaint();
        this.textPaint = textPaint2;
        textPaint2.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setAntiAlias(true);
        this.paint.setAntiAlias(true);
    }

    public void invalidate() {
        initPainters();
        super.invalidate();
    }

    public int getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
        if (i > getMax()) {
            this.progress %= getMax();
        }
        invalidate();
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.max = i;
            invalidate();
        }
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
        invalidate();
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
        invalidate();
    }

    public int getFinishedColor() {
        return this.finishedColor;
    }

    public void setFinishedColor(int i) {
        this.finishedColor = i;
        invalidate();
    }

    public int getUnfinishedColor() {
        return this.unfinishedColor;
    }

    public void setUnfinishedColor(int i) {
        this.unfinishedColor = i;
        invalidate();
    }

    public String getPrefixText() {
        return this.prefixText;
    }

    public void setPrefixText(String str) {
        this.prefixText = str;
        invalidate();
    }

    public String getSuffixText() {
        return this.suffixText;
    }

    public void setSuffixText(String str) {
        this.suffixText = str;
        invalidate();
    }

    public String getDrawText() {
        return getPrefixText() + getProgress() + getSuffixText();
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return this.min_size;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return this.min_size;
    }

    public float getProgressPercentage() {
        return ((float) getProgress()) / ((float) getMax());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.rectF.set(0.0f, 0.0f, (float) View.MeasureSpec.getSize(i), (float) View.MeasureSpec.getSize(i2));
        setMeasuredDimension(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float progress2 = (((float) getProgress()) / ((float) getMax())) * ((float) getHeight());
        float width = ((float) getWidth()) / 2.0f;
        float acos = (float) ((Math.acos((double) ((width - progress2) / width)) * 180.0d) / 3.141592653589793d);
        float f = acos * 2.0f;
        this.paint.setColor(getUnfinishedColor());
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.rectF, acos + 90.0f, 360.0f - f, false, this.paint);
        canvas.save();
        canvas.rotate(180.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        this.paint.setColor(getFinishedColor());
        canvas.drawArc(this.rectF, 270.0f - acos, f, false, this.paint);
        canvas.restore();
        String drawText = getDrawText();
        if (!TextUtils.isEmpty(drawText)) {
            canvas.drawText(drawText, (((float) getWidth()) - this.textPaint.measureText(drawText)) / 2.0f, (((float) getWidth()) - (this.textPaint.descent() + this.textPaint.ascent())) / 2.0f, this.textPaint);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putInt(INSTANCE_TEXT_COLOR, getTextColor());
        bundle.putFloat(INSTANCE_TEXT_SIZE, getTextSize());
        bundle.putInt(INSTANCE_FINISHED_STROKE_COLOR, getFinishedColor());
        bundle.putInt(INSTANCE_UNFINISHED_STROKE_COLOR, getUnfinishedColor());
        bundle.putInt(INSTANCE_MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString(INSTANCE_SUFFIX, getSuffixText());
        bundle.putString(INSTANCE_PREFIX, getPrefixText());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.textColor = bundle.getInt(INSTANCE_TEXT_COLOR);
            this.textSize = bundle.getFloat(INSTANCE_TEXT_SIZE);
            this.finishedColor = bundle.getInt(INSTANCE_FINISHED_STROKE_COLOR);
            this.unfinishedColor = bundle.getInt(INSTANCE_UNFINISHED_STROKE_COLOR);
            initPainters();
            setMax(bundle.getInt(INSTANCE_MAX));
            setProgress(bundle.getInt("progress"));
            this.prefixText = bundle.getString(INSTANCE_PREFIX);
            this.suffixText = bundle.getString(INSTANCE_SUFFIX);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
