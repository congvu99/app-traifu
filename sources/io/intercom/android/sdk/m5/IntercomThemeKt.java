package io.intercom.android.sdk.m5;

import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0002\u0010\u0016\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0007\u001a\u00020\u00018BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0017\u0010\t\u001a\u00020\u00018BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\n\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"ContentBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getContentBackgroundColor", "()J", "J", "defaultFontFamily", "Landroidx/compose/ui/text/font/SystemFontFamily;", "defaultOnPrimary", "getDefaultOnPrimary", "defaultPrimary", "getDefaultPrimary", "IntercomTheme", "", "lightColors", "Landroidx/compose/material/Colors;", "shapes", "Landroidx/compose/material/Shapes;", "typography", "Landroidx/compose/material/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Shapes;Landroidx/compose/material/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTheme.kt */
public final class IntercomThemeKt {
    private static final long ContentBackgroundColor = ColorKt.Color(4294572537L);
    private static final SystemFontFamily defaultFontFamily = FontFamily.Companion.getDefault();

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long getDefaultPrimary() {
        /*
            boolean r0 = io.intercom.android.sdk.Injector.isNotInitialised()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.Provider r0 = r0.getAppConfigProvider()
            java.lang.Object r0 = r0.get()
            io.intercom.android.sdk.identity.AppConfig r0 = (io.intercom.android.sdk.identity.AppConfig) r0
            io.intercom.android.sdk.models.ConfigModules r0 = r0.getConfigModules()
            if (r0 == 0) goto L_0x0021
            io.intercom.android.sdk.models.CustomizationModel r0 = r0.getCustomization()
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            if (r0 == 0) goto L_0x0030
            io.intercom.android.sdk.models.CustomizationColorsModel r0 = r0.getAction()
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.getBackgroundColor()
            if (r0 != 0) goto L_0x0032
        L_0x0030:
            java.lang.String r0 = "#FF6061EC"
        L_0x0032:
            r2 = 0
            r3 = 1
            long r0 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r0, r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomThemeKt.getDefaultPrimary():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 != null) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long getDefaultOnPrimary() {
        /*
            boolean r0 = io.intercom.android.sdk.Injector.isNotInitialised()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            goto L_0x0030
        L_0x0008:
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.Provider r0 = r0.getAppConfigProvider()
            java.lang.Object r0 = r0.get()
            io.intercom.android.sdk.identity.AppConfig r0 = (io.intercom.android.sdk.identity.AppConfig) r0
            io.intercom.android.sdk.models.ConfigModules r0 = r0.getConfigModules()
            if (r0 == 0) goto L_0x0021
            io.intercom.android.sdk.models.CustomizationModel r0 = r0.getCustomization()
            goto L_0x0022
        L_0x0021:
            r0 = r1
        L_0x0022:
            if (r0 == 0) goto L_0x0030
            io.intercom.android.sdk.models.CustomizationColorsModel r0 = r0.getAction()
            if (r0 == 0) goto L_0x0030
            java.lang.String r0 = r0.getForegroundColor()
            if (r0 != 0) goto L_0x0032
        L_0x0030:
            java.lang.String r0 = "#FFFFFFFF"
        L_0x0032:
            r2 = 0
            r3 = 1
            long r0 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r0, r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomThemeKt.getDefaultOnPrimary():long");
    }

    public static final long getContentBackgroundColor() {
        return ContentBackgroundColor;
    }

    public static final void IntercomTheme(Colors colors, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        int i3;
        Colors colors2;
        Shapes shapes2;
        Typography typography2;
        Typography typography3;
        Colors colors3;
        Typography typography4;
        Shapes shapes3;
        Colors colors4;
        int i4;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i7 = i;
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1680250561);
        if ((i7 & 14) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                if (startRestartGroup.changed((Object) colors2)) {
                    i6 = 4;
                    i3 = i6 | i7;
                }
            } else {
                colors2 = colors;
            }
            i6 = 2;
            i3 = i6 | i7;
        } else {
            colors2 = colors;
            i3 = i7;
        }
        if ((i7 & 112) == 0) {
            if ((i2 & 2) == 0) {
                shapes2 = shapes;
                if (startRestartGroup.changed((Object) shapes2)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                shapes2 = shapes;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            shapes2 = shapes;
        }
        if ((i7 & 896) == 0) {
            if ((i2 & 4) == 0) {
                typography2 = typography;
                if (startRestartGroup.changed((Object) typography2)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                typography2 = typography;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            typography2 = typography;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i7 & 7168) == 0) {
            i3 |= startRestartGroup.changed((Object) function22) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i7 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    colors2 = ColorsKt.m1236lightColors2qZNXz8$default(getDefaultPrimary(), 0, 0, 0, 0, 0, 0, getDefaultOnPrimary(), 0, 0, 0, 0, 3966, (Object) null);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    float f = (float) 16;
                    shapes2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 8).copy(RoundedCornerShapeKt.RoundedCornerShape(50), RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(Dp.m4704constructorimpl((float) 8)), RoundedCornerShapeKt.m857RoundedCornerShapea9UjIt4$default(Dp.m4704constructorimpl(f), Dp.m4704constructorimpl(f), 0.0f, 0.0f, 12, (Object) null));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    colors4 = colors2;
                    shapes3 = shapes2;
                    typography4 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).copy(TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH2(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH3(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH4(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH5(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getH6(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle2(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody1(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getButton(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getCaption(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null), TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getOverline(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultFontFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null));
                    startRestartGroup.endDefaults();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    shapes2 = shapes3;
                    MaterialThemeKt.MaterialTheme((DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0) || !((View) consume).isInEditMode()) ? colors4 : ColorsKt.m1234darkColors2qZNXz8$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, (Object) null), typography4, shapes2, function2, startRestartGroup, ((i3 >> 3) & 112) | ((i3 << 3) & 896) | (i3 & 7168), 0);
                    colors3 = colors4;
                    typography3 = typography4;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            }
            colors4 = colors2;
            shapes3 = shapes2;
            typography4 = typography2;
            startRestartGroup.endDefaults();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            shapes2 = shapes3;
            MaterialThemeKt.MaterialTheme((DarkThemeKt.isSystemInDarkTheme(startRestartGroup, 0) || !((View) consume2).isInEditMode()) ? colors4 : ColorsKt.m1234darkColors2qZNXz8$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, (Object) null), typography4, shapes2, function2, startRestartGroup, ((i3 >> 3) & 112) | ((i3 << 3) & 896) | (i3 & 7168), 0);
            colors3 = colors4;
            typography3 = typography4;
        } else {
            startRestartGroup.skipToGroupEnd();
            colors3 = colors2;
            typography3 = typography2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IntercomThemeKt$IntercomTheme$1(colors3, shapes2, typography3, function2, i, i2));
        }
    }
}
