package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TextLayoutManagerMapBuffer {
    public static final short AS_KEY_CACHE_ID = 3;
    public static final short AS_KEY_FRAGMENTS = 2;
    public static final short AS_KEY_HASH = 0;
    public static final short AS_KEY_STRING = 1;
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING = false;
    public static final short FR_KEY_HEIGHT = 4;
    public static final short FR_KEY_IS_ATTACHMENT = 2;
    public static final short FR_KEY_REACT_TAG = 1;
    public static final short FR_KEY_STRING = 0;
    public static final short FR_KEY_TEXT_ATTRIBUTES = 5;
    public static final short FR_KEY_WIDTH = 3;
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    public static final short PA_KEY_ADJUST_FONT_SIZE_TO_FIT = 3;
    public static final short PA_KEY_ELLIPSIZE_MODE = 1;
    public static final short PA_KEY_INCLUDE_FONT_PADDING = 4;
    public static final short PA_KEY_MAX_NUMBER_OF_LINES = 0;
    public static final short PA_KEY_TEXT_BREAK_STRATEGY = 2;
    private static final String TAG = TextLayoutManagerMapBuffer.class.getSimpleName();
    private static final LruCache<ReadableMapBuffer, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache = new ConcurrentHashMap<>();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final short spannableCacheSize = 100;

    public static void setCachedSpannabledForTag(int i, Spannable spannable) {
        sTagToSpannableCache.put(Integer.valueOf(i), spannable);
    }

    public static void deleteCachedSpannableForTag(int i) {
        sTagToSpannableCache.remove(Integer.valueOf(i));
    }

    public static boolean isRTL(ReadableMapBuffer readableMapBuffer) {
        ReadableMapBuffer mapBuffer = readableMapBuffer.getMapBuffer(2);
        if (mapBuffer.getCount() != 0 && TextAttributeProps.getLayoutDirection(mapBuffer.getMapBuffer(0).getMapBuffer(5).getString(21)) == 1) {
            return true;
        }
        return false;
    }

    private static void buildSpannableFromFragment(Context context, ReadableMapBuffer readableMapBuffer, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        List<SetSpanOperation> list2 = list;
        short count = readableMapBuffer.getCount();
        for (short s = 0; s < count; s = (short) (s + 1)) {
            ReadableMapBuffer mapBuffer = readableMapBuffer.getMapBuffer(s);
            int length = spannableStringBuilder.length();
            TextAttributeProps fromReadableMapBuffer = TextAttributeProps.fromReadableMapBuffer(mapBuffer.getMapBuffer(5));
            spannableStringBuilder.append(TextTransform.apply(mapBuffer.getString(0), fromReadableMapBuffer.mTextTransform));
            int length2 = spannableStringBuilder.length();
            int i = mapBuffer.hasKey(1) ? mapBuffer.getInt(1) : -1;
            if (mapBuffer.hasKey(2) && mapBuffer.getBoolean(2)) {
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i, (int) PixelUtil.toPixelFromSP(mapBuffer.getDouble(3)), (int) PixelUtil.toPixelFromSP(mapBuffer.getDouble(4)))));
            } else if (length2 >= length) {
                if (ReactAccessibilityDelegate.AccessibilityRole.LINK.equals(fromReadableMapBuffer.mAccessibilityRole)) {
                    list2.add(new SetSpanOperation(length, length2, new ReactClickableSpan(i, fromReadableMapBuffer.mColor)));
                } else if (fromReadableMapBuffer.mIsColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(fromReadableMapBuffer.mColor)));
                }
                if (fromReadableMapBuffer.mIsBackgroundColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(fromReadableMapBuffer.mBackgroundColor)));
                }
                if (!Float.isNaN(fromReadableMapBuffer.getLetterSpacing())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(fromReadableMapBuffer.getLetterSpacing())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(fromReadableMapBuffer.mFontSize)));
                if (!(fromReadableMapBuffer.mFontStyle == -1 && fromReadableMapBuffer.mFontWeight == -1 && fromReadableMapBuffer.mFontFamily == null)) {
                    list2.add(new SetSpanOperation(length, length2, new CustomStyleSpan(fromReadableMapBuffer.mFontStyle, fromReadableMapBuffer.mFontWeight, fromReadableMapBuffer.mFontFeatureSettings, fromReadableMapBuffer.mFontFamily, context.getAssets())));
                }
                if (fromReadableMapBuffer.mIsUnderlineTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (fromReadableMapBuffer.mIsLineThroughTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!(fromReadableMapBuffer.mTextShadowOffsetDx == 0.0f && fromReadableMapBuffer.mTextShadowOffsetDy == 0.0f)) {
                    list2.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(fromReadableMapBuffer.mTextShadowOffsetDx, fromReadableMapBuffer.mTextShadowOffsetDy, fromReadableMapBuffer.mTextShadowRadius, fromReadableMapBuffer.mTextShadowColor)));
                }
                if (!Float.isNaN(fromReadableMapBuffer.getEffectiveLineHeight())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(fromReadableMapBuffer.getEffectiveLineHeight())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactTagSpan(i)));
            }
        }
    }

    public static Spannable getOrCreateSpannableForText(Context context, ReadableMapBuffer readableMapBuffer, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        synchronized (sSpannableCacheLock) {
            Spannable spannable = sSpannableCache.get(readableMapBuffer);
            if (spannable != null) {
                return spannable;
            }
            Spannable createSpannableFromAttributedString = createSpannableFromAttributedString(context, readableMapBuffer, reactTextViewManagerCallback);
            synchronized (sSpannableCacheLock) {
                sSpannableCache.put(readableMapBuffer, createSpannableFromAttributedString);
            }
            return createSpannableFromAttributedString;
        }
    }

    private static Spannable createSpannableFromAttributedString(Context context, ReadableMapBuffer readableMapBuffer, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        buildSpannableFromFragment(context, readableMapBuffer.getMapBuffer(2), spannableStringBuilder, arrayList);
        int i = 0;
        for (SetSpanOperation execute : arrayList) {
            execute.execute(spannableStringBuilder, i);
            i++;
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f, YogaMeasureMode yogaMeasureMode, boolean z, int i) {
        int i2;
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f2 = f;
        boolean z2 = z;
        int i3 = i;
        int length = spannable.length();
        boolean z3 = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f;
        TextPaint textPaint = sTextPaintInstance;
        float desiredWidth = metrics2 == null ? Layout.getDesiredWidth(spannable2, textPaint) : Float.NaN;
        if (metrics2 == null && (z3 || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f2))) {
            int ceil = (int) Math.ceil((double) desiredWidth);
            if (Build.VERSION.SDK_INT < 23) {
                return new StaticLayout(spannable, textPaint, ceil, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
            }
            return StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, ceil).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i3).setHyphenationFrequency(1).build();
        } else if (metrics2 != null && (z3 || ((float) metrics2.width) <= f2)) {
            int i4 = metrics2.width;
            if (metrics2.width < 0) {
                String str = TAG;
                ReactSoftExceptionLogger.logSoftException(str, new ReactNoCrashSoftException("Text width is invalid: " + metrics2.width));
                i2 = 0;
            } else {
                i2 = i4;
            }
            return BoringLayout.make(spannable, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, metrics, z);
        } else if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(spannable, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, z);
        } else {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable2, 0, length, textPaint, (int) f2).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i3).setHyphenationFrequency(1);
            if (Build.VERSION.SDK_INT >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a6, code lost:
        if (r11 > r21) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ba, code lost:
        if (r1 > r23) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r18, com.facebook.react.common.mapbuffer.ReadableMapBuffer r19, com.facebook.react.common.mapbuffer.ReadableMapBuffer r20, float r21, com.facebook.yoga.YogaMeasureMode r22, float r23, com.facebook.yoga.YogaMeasureMode r24, com.facebook.react.views.text.ReactTextViewManagerCallback r25, float[] r26) {
        /*
            r0 = r19
            r1 = r20
            r8 = r22
            r9 = r24
            android.text.TextPaint r2 = sTextPaintInstance
            r3 = 3
            boolean r4 = r0.hasKey(r3)
            if (r4 == 0) goto L_0x0031
            int r0 = r0.getInt(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r3 = sTagToSpannableCache
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x002e
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r3 = sTagToSpannableCache
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r3.get(r0)
            android.text.Spannable r0 = (android.text.Spannable) r0
            goto L_0x0039
        L_0x002e:
            r0 = 0
            return r0
        L_0x0031:
            r3 = r18
            r4 = r25
            android.text.Spannable r0 = getOrCreateSpannableForText(r3, r0, r4)
        L_0x0039:
            r3 = 2
            java.lang.String r3 = r1.getString(r3)
            int r7 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r3)
            r3 = 4
            boolean r4 = r1.hasKey(r3)
            r10 = 1
            if (r4 == 0) goto L_0x0050
            boolean r3 = r1.getBoolean(r3)
            r6 = r3
            goto L_0x0051
        L_0x0050:
            r6 = 1
        L_0x0051:
            if (r0 == 0) goto L_0x0187
            android.text.BoringLayout$Metrics r3 = android.text.BoringLayout.isBoring(r0, r2)
            if (r3 != 0) goto L_0x005c
            android.text.Layout.getDesiredWidth(r0, r2)
        L_0x005c:
            com.facebook.yoga.YogaMeasureMode r2 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
            r11 = 0
            if (r8 == r2) goto L_0x0063
            int r2 = (r21 > r11 ? 1 : (r21 == r11 ? 0 : -1))
        L_0x0063:
            r2 = r0
            r4 = r21
            r5 = r22
            android.text.Layout r2 = createLayout(r2, r3, r4, r5, r6, r7)
            r3 = 0
            boolean r4 = r1.hasKey(r3)
            r5 = -1
            if (r4 == 0) goto L_0x0079
            int r1 = r1.getInt(r3)
            goto L_0x007a
        L_0x0079:
            r1 = -1
        L_0x007a:
            if (r1 == r5) goto L_0x0088
            if (r1 != 0) goto L_0x007f
            goto L_0x0088
        L_0x007f:
            int r4 = r2.getLineCount()
            int r1 = java.lang.Math.min(r1, r4)
            goto L_0x008c
        L_0x0088:
            int r1 = r2.getLineCount()
        L_0x008c:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r8 != r4) goto L_0x0091
            goto L_0x00a8
        L_0x0091:
            r4 = 0
        L_0x0092:
            if (r4 >= r1) goto L_0x00a0
            float r6 = r2.getLineWidth(r4)
            int r7 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x009d
            r11 = r6
        L_0x009d:
            int r4 = r4 + 1
            goto L_0x0092
        L_0x00a0:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r8 != r4) goto L_0x00aa
            int r4 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r4 <= 0) goto L_0x00aa
        L_0x00a8:
            r11 = r21
        L_0x00aa:
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r9 == r4) goto L_0x00bc
            int r1 = r1 - r10
            int r1 = r2.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.YogaMeasureMode r4 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r9 != r4) goto L_0x00be
            int r4 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r4 <= 0) goto L_0x00be
        L_0x00bc:
            r1 = r23
        L_0x00be:
            r4 = 0
            r6 = 0
        L_0x00c0:
            int r7 = r0.length()
            if (r4 >= r7) goto L_0x017a
            int r7 = r0.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            int r7 = r0.nextSpanTransition(r4, r7, r8)
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r8 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            java.lang.Object[] r4 = r0.getSpans(r4, r7, r8)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r4 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r4
            int r8 = r4.length
            r9 = 0
        L_0x00da:
            if (r9 >= r8) goto L_0x0177
            r12 = r4[r9]
            int r13 = r0.getSpanStart(r12)
            int r14 = r2.getLineForOffset(r13)
            int r15 = r2.getEllipsisCount(r14)
            if (r15 <= 0) goto L_0x00ee
            r15 = 1
            goto L_0x00ef
        L_0x00ee:
            r15 = 0
        L_0x00ef:
            if (r15 == 0) goto L_0x0107
            int r15 = r2.getLineStart(r14)
            int r16 = r2.getEllipsisStart(r14)
            int r15 = r15 + r16
            if (r13 < r15) goto L_0x0107
            int r15 = r2.getLineEnd(r14)
            if (r13 < r15) goto L_0x0104
            goto L_0x0107
        L_0x0104:
            r5 = 1
            goto L_0x0170
        L_0x0107:
            int r15 = r12.getWidth()
            float r15 = (float) r15
            int r12 = r12.getHeight()
            float r12 = (float) r12
            boolean r3 = r2.isRtlCharAt(r13)
            int r10 = r2.getParagraphDirection(r14)
            if (r10 != r5) goto L_0x011d
            r10 = 1
            goto L_0x011e
        L_0x011d:
            r10 = 0
        L_0x011e:
            int r16 = r0.length()
            r17 = 1
            int r5 = r16 + -1
            if (r13 != r5) goto L_0x0137
            if (r10 == 0) goto L_0x0131
            float r3 = r2.getLineWidth(r14)
            float r3 = r11 - r3
            goto L_0x0158
        L_0x0131:
            float r3 = r2.getLineRight(r14)
            float r3 = r3 - r15
            goto L_0x0158
        L_0x0137:
            if (r10 != r3) goto L_0x013c
            r17 = 1
            goto L_0x013e
        L_0x013c:
            r17 = 0
        L_0x013e:
            if (r17 == 0) goto L_0x0145
            float r5 = r2.getPrimaryHorizontal(r13)
            goto L_0x0149
        L_0x0145:
            float r5 = r2.getSecondaryHorizontal(r13)
        L_0x0149:
            if (r10 == 0) goto L_0x0152
            float r10 = r2.getLineRight(r14)
            float r10 = r10 - r5
            float r5 = r11 - r10
        L_0x0152:
            if (r3 == 0) goto L_0x0157
            float r3 = r5 - r15
            goto L_0x0158
        L_0x0157:
            r3 = r5
        L_0x0158:
            int r5 = r2.getLineBaseline(r14)
            float r5 = (float) r5
            float r5 = r5 - r12
            int r10 = r6 * 2
            float r5 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r5)
            r26[r10] = r5
            r5 = 1
            int r10 = r10 + r5
            float r3 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r3)
            r26[r10] = r3
            int r6 = r6 + 1
        L_0x0170:
            int r9 = r9 + 1
            r3 = 0
            r5 = -1
            r10 = 1
            goto L_0x00da
        L_0x0177:
            r4 = r7
            goto L_0x00c0
        L_0x017a:
            float r0 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r11)
            float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
            long r0 = com.facebook.yoga.YogaMeasureOutput.make((float) r0, (float) r1)
            return r0
        L_0x0187:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Spannable element has not been prepared in onBeforeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManagerMapBuffer.measureText(android.content.Context, com.facebook.react.common.mapbuffer.ReadableMapBuffer, com.facebook.react.common.mapbuffer.ReadableMapBuffer, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, com.facebook.react.views.text.ReactTextViewManagerCallback, float[]):long");
    }

    public static WritableArray measureLines(Context context, ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, float f) {
        TextPaint textPaint = sTextPaintInstance;
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, readableMapBuffer, (ReactTextViewManagerCallback) null);
        return FontMetricsUtil.getFontMetrics(orCreateSpannableForText, createLayout(orCreateSpannableForText, BoringLayout.isBoring(orCreateSpannableForText, textPaint), f, YogaMeasureMode.EXACTLY, readableMapBuffer2.hasKey(4) ? readableMapBuffer2.getBoolean(4) : true, TextAttributeProps.getTextBreakStrategy(readableMapBuffer2.getString(2))), sTextPaintInstance, context);
    }

    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        public SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }

        public void execute(Spannable spannable, int i) {
            spannable.setSpan(this.what, this.start, this.end, ((i << 16) & 16711680) | ((this.start == 0 ? 18 : 34) & -16711681));
        }
    }
}
