package com.joanzapata.iconify.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.joanzapata.iconify.internal.HasOnViewAttachListener;
import java.util.List;

public final class ParsingUtil {
    private static final String ANDROID_PACKAGE_NAME = "android";

    private ParsingUtil() {
    }

    public static CharSequence parse(Context context, List<IconFontDescriptorWrapper> list, CharSequence charSequence, final TextView textView) {
        Context applicationContext = context.getApplicationContext();
        if (charSequence == null) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        recursivePrepareSpannableIndexes(applicationContext, charSequence.toString(), spannableStringBuilder, list, 0);
        if (hasAnimatedSpans(spannableStringBuilder)) {
            if (textView == null) {
                throw new IllegalArgumentException("You can't use \"spin\" without providing the target TextView.");
            } else if (textView instanceof HasOnViewAttachListener) {
                ((HasOnViewAttachListener) textView).setOnViewAttachListener(new HasOnViewAttachListener.OnViewAttachListener() {
                    boolean isAttached = false;

                    public void onAttach() {
                        this.isAttached = true;
                        ViewCompat.postOnAnimation(textView, new Runnable() {
                            public void run() {
                                if (AnonymousClass1.this.isAttached) {
                                    textView.invalidate();
                                    ViewCompat.postOnAnimation(textView, this);
                                }
                            }
                        });
                    }

                    public void onDetach() {
                        this.isAttached = false;
                    }
                });
            } else {
                throw new IllegalArgumentException(textView.getClass().getSimpleName() + " does not implement " + "HasOnViewAttachListener. Please use IconTextView, IconButton or IconToggleButton.");
            }
        } else if (textView instanceof HasOnViewAttachListener) {
            ((HasOnViewAttachListener) textView).setOnViewAttachListener((HasOnViewAttachListener.OnViewAttachListener) null);
        }
        return spannableStringBuilder;
    }

    private static boolean hasAnimatedSpans(SpannableStringBuilder spannableStringBuilder) {
        for (CustomTypefaceSpan isAnimated : (CustomTypefaceSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), CustomTypefaceSpan.class)) {
            if (isAnimated.isAnimated()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r12 = r3.get(r13);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void recursivePrepareSpannableIndexes(android.content.Context r23, java.lang.String r24, android.text.SpannableStringBuilder r25, java.util.List<com.joanzapata.iconify.internal.IconFontDescriptorWrapper> r26, int r27) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = r25.toString()
            java.lang.String r5 = "{"
            r6 = r27
            int r5 = r4.indexOf(r5, r6)
            r6 = -1
            if (r5 != r6) goto L_0x0018
            return
        L_0x0018:
            java.lang.String r7 = "}"
            int r7 = r4.indexOf(r7, r5)
            r8 = 1
            int r7 = r7 + r8
            if (r7 != r6) goto L_0x0023
            return
        L_0x0023:
            int r6 = r5 + 1
            int r9 = r7 + -1
            java.lang.String r4 = r4.substring(r6, r9)
            java.lang.String r9 = " "
            java.lang.String[] r4 = r4.split(r9)
            r9 = 0
            r10 = r4[r9]
            r11 = 0
            r12 = r11
            r13 = 0
        L_0x0037:
            int r14 = r26.size()
            if (r13 >= r14) goto L_0x004e
            java.lang.Object r11 = r3.get(r13)
            r12 = r11
            com.joanzapata.iconify.internal.IconFontDescriptorWrapper r12 = (com.joanzapata.iconify.internal.IconFontDescriptorWrapper) r12
            com.joanzapata.iconify.Icon r11 = r12.getIcon(r10)
            if (r11 == 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            int r13 = r13 + 1
            goto L_0x0037
        L_0x004e:
            r15 = r11
            if (r15 != 0) goto L_0x0055
            recursivePrepareSpannableIndexes(r0, r1, r2, r3, r7)
            return
        L_0x0055:
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = 1
            r17 = -1082130432(0xffffffffbf800000, float:-1.0)
            r18 = -1082130432(0xffffffffbf800000, float:-1.0)
            r19 = 2147483647(0x7fffffff, float:NaN)
            r20 = 0
            r21 = 0
        L_0x0063:
            int r13 = r4.length
            if (r10 >= r13) goto L_0x023b
            r13 = r4[r10]
            java.lang.String r14 = "spin"
            boolean r14 = r13.equalsIgnoreCase(r14)
            if (r14 == 0) goto L_0x007b
            r22 = r4
            r4 = 2147483647(0x7fffffff, float:NaN)
            r16 = 0
            r20 = 1
            goto L_0x01f3
        L_0x007b:
            java.lang.String r14 = "baseline"
            boolean r14 = r13.equalsIgnoreCase(r14)
            if (r14 == 0) goto L_0x008e
            r22 = r4
            r4 = 2147483647(0x7fffffff, float:NaN)
            r16 = 0
            r21 = 1
            goto L_0x01f3
        L_0x008e:
            java.lang.String r14 = "([0-9]*(\\.[0-9]*)?)dp"
            boolean r14 = r13.matches(r14)
            if (r14 == 0) goto L_0x00b5
            int r14 = r13.length()
            int r14 = r14 + -2
            java.lang.String r13 = r13.substring(r9, r14)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            float r13 = r13.floatValue()
            float r17 = dpToPx(r0, r13)
        L_0x00ac:
            r22 = r4
        L_0x00ae:
            r4 = 2147483647(0x7fffffff, float:NaN)
            r16 = 0
            goto L_0x01f3
        L_0x00b5:
            java.lang.String r14 = "([0-9]*(\\.[0-9]*)?)sp"
            boolean r14 = r13.matches(r14)
            if (r14 == 0) goto L_0x00d4
            int r14 = r13.length()
            int r14 = r14 + -2
            java.lang.String r13 = r13.substring(r9, r14)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            float r13 = r13.floatValue()
            float r17 = spToPx(r0, r13)
            goto L_0x00ac
        L_0x00d4:
            java.lang.String r14 = "([0-9]*)px"
            boolean r14 = r13.matches(r14)
            if (r14 == 0) goto L_0x00f4
            int r14 = r13.length()
            int r14 = r14 + -2
            java.lang.String r13 = r13.substring(r9, r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            int r13 = r13.intValue()
            float r13 = (float) r13
            r22 = r4
            r17 = r13
            goto L_0x00ae
        L_0x00f4:
            java.lang.String r14 = "@dimen/(.*)"
            boolean r14 = r13.matches(r14)
            r16 = 0
            java.lang.String r9 = "Unknown resource "
            java.lang.String r8 = "\""
            java.lang.String r11 = " in \""
            if (r14 == 0) goto L_0x0136
            java.lang.String r14 = r23.getPackageName()
            r22 = r4
            r4 = 7
            java.lang.String r4 = r13.substring(r4)
            float r17 = getPxFromDimen(r0, r14, r4)
            int r4 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r4 < 0) goto L_0x0118
        L_0x0117:
            goto L_0x00ae
        L_0x0118:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r13)
            r2.append(r11)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0136:
            r22 = r4
            java.lang.String r4 = "@android:dimen/(.*)"
            boolean r4 = r13.matches(r4)
            r14 = 15
            java.lang.String r3 = "android"
            if (r4 == 0) goto L_0x016f
            java.lang.String r4 = r13.substring(r14)
            float r17 = getPxFromDimen(r0, r3, r4)
            int r3 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r3 < 0) goto L_0x0151
            goto L_0x0117
        L_0x0151:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r13)
            r2.append(r11)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x016f:
            java.lang.String r4 = "([0-9]*(\\.[0-9]*)?)%"
            boolean r4 = r13.matches(r4)
            if (r4 == 0) goto L_0x0190
            int r3 = r13.length()
            r4 = 1
            int r3 = r3 - r4
            r8 = 0
            java.lang.String r3 = r13.substring(r8, r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            float r3 = r3.floatValue()
            r9 = 1120403456(0x42c80000, float:100.0)
            float r18 = r3 / r9
            goto L_0x00ae
        L_0x0190:
            r16 = 0
            java.lang.String r4 = "#([0-9A-Fa-f]{6}|[0-9A-Fa-f]{8})"
            boolean r4 = r13.matches(r4)
            if (r4 == 0) goto L_0x01a2
            int r19 = android.graphics.Color.parseColor(r13)
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x01f3
        L_0x01a2:
            java.lang.String r4 = "@color/(.*)"
            boolean r4 = r13.matches(r4)
            if (r4 == 0) goto L_0x01dd
            java.lang.String r3 = r23.getPackageName()
            r4 = 7
            java.lang.String r4 = r13.substring(r4)
            int r3 = getColorFromResource(r0, r3, r4)
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x01bf
        L_0x01bc:
            r19 = r3
            goto L_0x01f3
        L_0x01bf:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r13)
            r2.append(r11)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x01dd:
            java.lang.String r4 = "@android:color/(.*)"
            boolean r4 = r13.matches(r4)
            if (r4 == 0) goto L_0x021b
            java.lang.String r4 = r13.substring(r14)
            int r3 = getColorFromResource(r0, r3, r4)
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x01fd
            goto L_0x01bc
        L_0x01f3:
            int r10 = r10 + 1
            r3 = r26
            r4 = r22
            r8 = 1
            r9 = 0
            goto L_0x0063
        L_0x01fd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r13)
            r2.append(r11)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x021b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown expression "
            r2.append(r3)
            r2.append(r13)
            r2.append(r11)
            r2.append(r1)
            r2.append(r8)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x023b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            char r4 = r15.character()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.text.SpannableStringBuilder r2 = r2.replace(r5, r7, r3)
            com.joanzapata.iconify.internal.CustomTypefaceSpan r3 = new com.joanzapata.iconify.internal.CustomTypefaceSpan
            android.graphics.Typeface r16 = r12.getTypeface(r0)
            r14 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            r4 = 17
            r2.setSpan(r3, r5, r6, r4)
            r3 = r26
            recursivePrepareSpannableIndexes(r0, r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.joanzapata.iconify.internal.ParsingUtil.recursivePrepareSpannableIndexes(android.content.Context, java.lang.String, android.text.SpannableStringBuilder, java.util.List, int):void");
    }

    public static float getPxFromDimen(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str2, "dimen", str);
        if (identifier <= 0) {
            return -1.0f;
        }
        return resources.getDimension(identifier);
    }

    public static int getColorFromResource(Context context, String str, String str2) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(str2, "color", str);
        if (identifier <= 0) {
            return Integer.MAX_VALUE;
        }
        return resources.getColor(identifier);
    }

    public static float dpToPx(Context context, float f) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float spToPx(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
