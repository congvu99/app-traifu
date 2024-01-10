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

public class ArcProgress extends View {
    private static final String INSTANCE_ARC_ANGLE = "arc_angle";
    private static final String INSTANCE_BOTTOM_TEXT = "bottom_text";
    private static final String INSTANCE_BOTTOM_TEXT_SIZE = "bottom_text_size";
    private static final String INSTANCE_FINISHED_STROKE_COLOR = "finished_stroke_color";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_STROKE_WIDTH = "stroke_width";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_SUFFIX_TEXT_PADDING = "suffix_text_padding";
    private static final String INSTANCE_SUFFIX_TEXT_SIZE = "suffix_text_size";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_UNFINISHED_STROKE_COLOR = "unfinished_stroke_color";
    private float arcAngle;
    private float arcBottomHeight;
    private String bottomText;
    private float bottomTextSize;
    private final float default_arc_angle;
    private final float default_bottom_text_size;
    private final int default_finished_color;
    private final int default_max;
    private final float default_stroke_width;
    private final float default_suffix_padding;
    private final String default_suffix_text;
    private final float default_suffix_text_size;
    private final int default_text_color;
    private float default_text_size;
    private final int default_unfinished_color;
    private int finishedStrokeColor;
    private int max;
    private final int min_size;
    private Paint paint;
    private int progress;
    private RectF rectF;
    private float strokeWidth;
    private String suffixText;
    private float suffixTextPadding;
    private float suffixTextSize;
    private int textColor;
    protected Paint textPaint;
    private float textSize;
    private int unfinishedStrokeColor;

    public ArcProgress(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArcProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectF = new RectF();
        this.progress = 0;
        this.suffixText = "%";
        this.default_finished_color = -1;
        this.default_unfinished_color = Color.rgb(72, 106, 176);
        this.default_text_color = Color.rgb(66, 145, 241);
        this.default_max = 100;
        this.default_arc_angle = 288.0f;
        this.default_text_size = Utils.sp2px(getResources(), 18.0f);
        this.min_size = (int) Utils.dp2px(getResources(), 100.0f);
        this.default_text_size = Utils.sp2px(getResources(), 40.0f);
        this.default_suffix_text_size = Utils.sp2px(getResources(), 15.0f);
        this.default_suffix_padding = Utils.dp2px(getResources(), 4.0f);
        this.default_suffix_text = "%";
        this.default_bottom_text_size = Utils.sp2px(getResources(), 10.0f);
        this.default_stroke_width = Utils.dp2px(getResources(), 4.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ArcProgress, i, 0);
        initByAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        initPainters();
    }

    /* access modifiers changed from: protected */
    public void initByAttributes(TypedArray typedArray) {
        this.finishedStrokeColor = typedArray.getColor(R.styleable.ArcProgress_arc_finished_color, -1);
        this.unfinishedStrokeColor = typedArray.getColor(R.styleable.ArcProgress_arc_unfinished_color, this.default_unfinished_color);
        this.textColor = typedArray.getColor(R.styleable.ArcProgress_arc_text_color, this.default_text_color);
        this.textSize = typedArray.getDimension(R.styleable.ArcProgress_arc_text_size, this.default_text_size);
        this.arcAngle = typedArray.getFloat(R.styleable.ArcProgress_arc_angle, 288.0f);
        setMax(typedArray.getInt(R.styleable.ArcProgress_arc_max, 100));
        setProgress(typedArray.getInt(R.styleable.ArcProgress_arc_progress, 0));
        this.strokeWidth = typedArray.getDimension(R.styleable.ArcProgress_arc_stroke_width, this.default_stroke_width);
        this.suffixTextSize = typedArray.getDimension(R.styleable.ArcProgress_arc_suffix_text_size, this.default_suffix_text_size);
        this.suffixText = TextUtils.isEmpty(typedArray.getString(R.styleable.ArcProgress_arc_suffix_text)) ? this.default_suffix_text : typedArray.getString(R.styleable.ArcProgress_arc_suffix_text);
        this.suffixTextPadding = typedArray.getDimension(R.styleable.ArcProgress_arc_suffix_text_padding, this.default_suffix_padding);
        this.bottomTextSize = typedArray.getDimension(R.styleable.ArcProgress_arc_bottom_text_size, this.default_bottom_text_size);
        this.bottomText = typedArray.getString(R.styleable.ArcProgress_arc_bottom_text);
    }

    /* access modifiers changed from: protected */
    public void initPainters() {
        TextPaint textPaint2 = new TextPaint();
        this.textPaint = textPaint2;
        textPaint2.setColor(this.textColor);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(this.default_unfinished_color);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void invalidate() {
        initPainters();
        super.invalidate();
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        invalidate();
    }

    public float getSuffixTextSize() {
        return this.suffixTextSize;
    }

    public void setSuffixTextSize(float f) {
        this.suffixTextSize = f;
        invalidate();
    }

    public String getBottomText() {
        return this.bottomText;
    }

    public void setBottomText(String str) {
        this.bottomText = str;
        invalidate();
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

    public float getBottomTextSize() {
        return this.bottomTextSize;
    }

    public void setBottomTextSize(float f) {
        this.bottomTextSize = f;
        invalidate();
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

    public int getFinishedStrokeColor() {
        return this.finishedStrokeColor;
    }

    public void setFinishedStrokeColor(int i) {
        this.finishedStrokeColor = i;
        invalidate();
    }

    public int getUnfinishedStrokeColor() {
        return this.unfinishedStrokeColor;
    }

    public void setUnfinishedStrokeColor(int i) {
        this.unfinishedStrokeColor = i;
        invalidate();
    }

    public float getArcAngle() {
        return this.arcAngle;
    }

    public void setArcAngle(float f) {
        this.arcAngle = f;
        invalidate();
    }

    public String getSuffixText() {
        return this.suffixText;
    }

    public void setSuffixText(String str) {
        this.suffixText = str;
        invalidate();
    }

    public float getSuffixTextPadding() {
        return this.suffixTextPadding;
    }

    public void setSuffixTextPadding(float f) {
        this.suffixTextPadding = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return this.min_size;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return this.min_size;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(i, i2);
        int size = View.MeasureSpec.getSize(i);
        RectF rectF2 = this.rectF;
        float f = this.strokeWidth;
        float f2 = (float) size;
        rectF2.set(f / 2.0f, f / 2.0f, f2 - (f / 2.0f), ((float) View.MeasureSpec.getSize(i2)) - (this.strokeWidth / 2.0f));
        this.arcBottomHeight = (f2 / 2.0f) * ((float) (1.0d - Math.cos(((double) (((360.0f - this.arcAngle) / 2.0f) / 180.0f)) * 3.141592653589793d)));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = 270.0f - (this.arcAngle / 2.0f);
        float max2 = (((float) this.progress) / ((float) getMax())) * this.arcAngle;
        float f2 = this.progress == 0 ? 0.01f : f;
        this.paint.setColor(this.unfinishedStrokeColor);
        canvas.drawArc(this.rectF, f, this.arcAngle, false, this.paint);
        this.paint.setColor(this.finishedStrokeColor);
        canvas.drawArc(this.rectF, f2, max2, false, this.paint);
        String valueOf = String.valueOf(getProgress());
        if (!TextUtils.isEmpty(valueOf)) {
            this.textPaint.setColor(this.textColor);
            this.textPaint.setTextSize(this.textSize);
            float descent = this.textPaint.descent() + this.textPaint.ascent();
            float height = (((float) getHeight()) - descent) / 2.0f;
            canvas.drawText(valueOf, (((float) getWidth()) - this.textPaint.measureText(valueOf)) / 2.0f, height, this.textPaint);
            this.textPaint.setTextSize(this.suffixTextSize);
            canvas.drawText(this.suffixText, (((float) getWidth()) / 2.0f) + this.textPaint.measureText(valueOf) + this.suffixTextPadding, (height + descent) - (this.textPaint.descent() + this.textPaint.ascent()), this.textPaint);
        }
        if (this.arcBottomHeight == 0.0f) {
            this.arcBottomHeight = (((float) getWidth()) / 2.0f) * ((float) (1.0d - Math.cos(((double) (((360.0f - this.arcAngle) / 2.0f) / 180.0f)) * 3.141592653589793d)));
        }
        if (!TextUtils.isEmpty(getBottomText())) {
            this.textPaint.setTextSize(this.bottomTextSize);
            canvas.drawText(getBottomText(), (((float) getWidth()) - this.textPaint.measureText(getBottomText())) / 2.0f, (((float) getHeight()) - this.arcBottomHeight) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putFloat(INSTANCE_STROKE_WIDTH, getStrokeWidth());
        bundle.putFloat(INSTANCE_SUFFIX_TEXT_SIZE, getSuffixTextSize());
        bundle.putFloat(INSTANCE_SUFFIX_TEXT_PADDING, getSuffixTextPadding());
        bundle.putFloat(INSTANCE_BOTTOM_TEXT_SIZE, getBottomTextSize());
        bundle.putString(INSTANCE_BOTTOM_TEXT, getBottomText());
        bundle.putFloat(INSTANCE_TEXT_SIZE, getTextSize());
        bundle.putInt(INSTANCE_TEXT_COLOR, getTextColor());
        bundle.putInt("progress", getProgress());
        bundle.putInt(INSTANCE_MAX, getMax());
        bundle.putInt(INSTANCE_FINISHED_STROKE_COLOR, getFinishedStrokeColor());
        bundle.putInt(INSTANCE_UNFINISHED_STROKE_COLOR, getUnfinishedStrokeColor());
        bundle.putFloat(INSTANCE_ARC_ANGLE, getArcAngle());
        bundle.putString(INSTANCE_SUFFIX, getSuffixText());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.strokeWidth = bundle.getFloat(INSTANCE_STROKE_WIDTH);
            this.suffixTextSize = bundle.getFloat(INSTANCE_SUFFIX_TEXT_SIZE);
            this.suffixTextPadding = bundle.getFloat(INSTANCE_SUFFIX_TEXT_PADDING);
            this.bottomTextSize = bundle.getFloat(INSTANCE_BOTTOM_TEXT_SIZE);
            this.bottomText = bundle.getString(INSTANCE_BOTTOM_TEXT);
            this.textSize = bundle.getFloat(INSTANCE_TEXT_SIZE);
            this.textColor = bundle.getInt(INSTANCE_TEXT_COLOR);
            setMax(bundle.getInt(INSTANCE_MAX));
            setProgress(bundle.getInt("progress"));
            this.finishedStrokeColor = bundle.getInt(INSTANCE_FINISHED_STROKE_COLOR);
            this.unfinishedStrokeColor = bundle.getInt(INSTANCE_UNFINISHED_STROKE_COLOR);
            this.suffixText = bundle.getString(INSTANCE_SUFFIX);
            initPainters();
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
