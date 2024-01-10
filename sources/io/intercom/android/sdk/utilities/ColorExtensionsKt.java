package io.intercom.android.sdk.utilities;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0004*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006\u001a\u0019\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a\u0019\u0010\u000b\u001a\u00020\u0004*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0006\u001a\u0019\u0010\r\u001a\u00020\u000e*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u000e*\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u0019\u0010\u0013\u001a\u00020\u000e*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u0019\u0010\u0015\u001a\u00020\u000e*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u0019\u0010\u0017\u001a\u00020\u000e*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0010\u001a\u0019\u0010\u0019\u001a\u00020\u0004*\u00020\u0004H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0006\u001a\u001e\u0010\u001b\u001a\u00020\u0004*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"BRIGHTNESS_CUTOFF", "", "WHITENESS_CUTOFF", "darken", "Landroidx/compose/ui/graphics/Color;", "darken-8_81llA", "(J)J", "generateTextColor", "generateTextColor-8_81llA", "getAccessibleBorderColor", "getAccessibleBorderColor-8_81llA", "getAccessibleColorOnWhiteBackground", "getAccessibleColorOnWhiteBackground-8_81llA", "isBlack", "", "isBlack-8_81llA", "(J)Z", "isColorTooWhite", "isColorTooWhite-8_81llA", "isDarkColor", "isDarkColor-8_81llA", "isLightColor", "isLightColor-8_81llA", "isWhite", "isWhite-8_81llA", "lighten", "lighten-8_81llA", "toComposeColor", "", "opacity", "(Ljava/lang/String;F)J", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ColorExtensions.kt */
public final class ColorExtensionsKt {
    private static final float BRIGHTNESS_CUTOFF = 0.6f;
    private static final float WHITENESS_CUTOFF = 0.9411765f;

    /* renamed from: darken-8_81llA  reason: not valid java name */
    public static final long m5395darken8_81llA(long j) {
        return ColorKt.Color(ColorUtils.darkenColor(ColorKt.m1987toArgb8_81llA(j)));
    }

    /* renamed from: lighten-8_81llA  reason: not valid java name */
    public static final long m5404lighten8_81llA(long j) {
        return ColorKt.Color(ColorUtils.lightenColor(ColorKt.m1987toArgb8_81llA(j)));
    }

    /* renamed from: isDarkColor-8_81llA  reason: not valid java name */
    public static final boolean m5401isDarkColor8_81llA(long j) {
        return ColorKt.m1985luminance8_81llA(j) < 0.6f;
    }

    /* renamed from: isLightColor-8_81llA  reason: not valid java name */
    public static final boolean m5402isLightColor8_81llA(long j) {
        return !m5401isDarkColor8_81llA(j);
    }

    /* renamed from: isWhite-8_81llA  reason: not valid java name */
    public static final boolean m5403isWhite8_81llA(long j) {
        return Color.m1933equalsimpl0(j, Color.Companion.m1969getWhite0d7_KjU());
    }

    /* renamed from: isBlack-8_81llA  reason: not valid java name */
    public static final boolean m5399isBlack8_81llA(long j) {
        return Color.m1933equalsimpl0(j, Color.Companion.m1958getBlack0d7_KjU());
    }

    /* renamed from: generateTextColor-8_81llA  reason: not valid java name */
    public static final long m5396generateTextColor8_81llA(long j) {
        return m5401isDarkColor8_81llA(j) ? Color.Companion.m1969getWhite0d7_KjU() : Color.Companion.m1958getBlack0d7_KjU();
    }

    /* renamed from: getAccessibleBorderColor-8_81llA  reason: not valid java name */
    public static final long m5397getAccessibleBorderColor8_81llA(long j) {
        return m5401isDarkColor8_81llA(j) ? m5404lighten8_81llA(j) : m5395darken8_81llA(j);
    }

    /* renamed from: getAccessibleColorOnWhiteBackground-8_81llA  reason: not valid java name */
    public static final long m5398getAccessibleColorOnWhiteBackground8_81llA(long j) {
        return m5400isColorTooWhite8_81llA(j) ? Color.Companion.m1958getBlack0d7_KjU() : j;
    }

    /* renamed from: isColorTooWhite-8_81llA  reason: not valid java name */
    private static final boolean m5400isColorTooWhite8_81llA(long j) {
        return Color.m1938getRedimpl(j) >= WHITENESS_CUTOFF && Color.m1937getGreenimpl(j) >= WHITENESS_CUTOFF && Color.m1935getBlueimpl(j) >= WHITENESS_CUTOFF;
    }

    public static /* synthetic */ long toComposeColor$default(String str, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return toComposeColor(str, f);
    }

    public static final long toComposeColor(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Color.m1931copywmQWz5c$default(ColorKt.Color(ColorUtils.parseColor(str)), f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }
}
