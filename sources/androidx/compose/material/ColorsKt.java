package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0001\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0001\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001f\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Colors.kt */
public final class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(ColorsKt$LocalColors$1.INSTANCE);

    /* renamed from: lightColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1236lightColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        int i2 = i;
        return m1235lightColors2qZNXz8((i2 & 1) != 0 ? ColorKt.Color(4284612846L) : j, (i2 & 2) != 0 ? ColorKt.Color(4281794739L) : j2, (i2 & 4) != 0 ? ColorKt.Color(4278442694L) : j3, (i2 & 8) != 0 ? ColorKt.Color(4278290310L) : j4, (i2 & 16) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j5, (i2 & 32) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j6, (i2 & 64) != 0 ? ColorKt.Color(4289724448L) : j7, (i2 & 128) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j8, (i2 & 256) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j9, (i2 & 512) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j10, (i2 & 1024) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j11, (i2 & 2048) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j12);
    }

    /* renamed from: lightColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1235lightColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, true, (DefaultConstructorMarker) null);
    }

    /* renamed from: darkColors-2qZNXz8$default  reason: not valid java name */
    public static /* synthetic */ Colors m1234darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, int i, Object obj) {
        int i2 = i;
        long Color = (i2 & 1) != 0 ? ColorKt.Color(4290479868L) : j;
        long Color2 = (i2 & 2) != 0 ? ColorKt.Color(4281794739L) : j2;
        long Color3 = (i2 & 4) != 0 ? ColorKt.Color(4278442694L) : j3;
        return m1233darkColors2qZNXz8(Color, Color2, Color3, (i2 & 8) != 0 ? Color3 : j4, (i2 & 16) != 0 ? ColorKt.Color(4279374354L) : j5, (i2 & 32) != 0 ? ColorKt.Color(4279374354L) : j6, (i2 & 64) != 0 ? ColorKt.Color(4291782265L) : j7, (i2 & 128) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j8, (i2 & 256) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j9, (i2 & 512) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j10, (i2 & 1024) != 0 ? Color.Companion.m1969getWhite0d7_KjU() : j11, (i2 & 2048) != 0 ? Color.Companion.m1958getBlack0d7_KjU() : j12);
    }

    /* renamed from: darkColors-2qZNXz8  reason: not valid java name */
    public static final Colors m1233darkColors2qZNXz8(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, false, (DefaultConstructorMarker) null);
    }

    public static final long getPrimarySurface(Colors colors) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        return colors.isLight() ? colors.m1214getPrimary0d7_KjU() : colors.m1218getSurface0d7_KjU();
    }

    /* renamed from: contentColorFor-4WTKRHQ  reason: not valid java name */
    public static final long m1231contentColorFor4WTKRHQ(Colors colors, long j) {
        Intrinsics.checkNotNullParameter(colors, "$this$contentColorFor");
        if (Color.m1933equalsimpl0(j, colors.m1214getPrimary0d7_KjU())) {
            return colors.m1211getOnPrimary0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1215getPrimaryVariant0d7_KjU())) {
            return colors.m1211getOnPrimary0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1216getSecondary0d7_KjU())) {
            return colors.m1212getOnSecondary0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1217getSecondaryVariant0d7_KjU())) {
            return colors.m1212getOnSecondary0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1207getBackground0d7_KjU())) {
            return colors.m1209getOnBackground0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1218getSurface0d7_KjU())) {
            return colors.m1213getOnSurface0d7_KjU();
        }
        if (Color.m1933equalsimpl0(j, colors.m1208getError0d7_KjU())) {
            return colors.m1210getOnError0d7_KjU();
        }
        return Color.Companion.m1968getUnspecified0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U  reason: not valid java name */
    public static final long m1232contentColorForek8zF_U(long j, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 441849991, "C(contentColorFor)P(0:c#ui.graphics.Color)*296@11462L6,296@11533L7:Colors.kt#jmzs0o");
        long r2 = m1231contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j);
        if (!(r2 != Color.Companion.m1968getUnspecified0d7_KjU())) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            r2 = ((Color) consume).m1942unboximpl();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return r2;
    }

    public static final void updateColorsFrom(Colors colors, Colors colors2) {
        Intrinsics.checkNotNullParameter(colors, "<this>");
        Intrinsics.checkNotNullParameter(colors2, "other");
        colors.m1226setPrimary8_81llA$material_release(colors2.m1214getPrimary0d7_KjU());
        colors.m1227setPrimaryVariant8_81llA$material_release(colors2.m1215getPrimaryVariant0d7_KjU());
        colors.m1228setSecondary8_81llA$material_release(colors2.m1216getSecondary0d7_KjU());
        colors.m1229setSecondaryVariant8_81llA$material_release(colors2.m1217getSecondaryVariant0d7_KjU());
        colors.m1219setBackground8_81llA$material_release(colors2.m1207getBackground0d7_KjU());
        colors.m1230setSurface8_81llA$material_release(colors2.m1218getSurface0d7_KjU());
        colors.m1220setError8_81llA$material_release(colors2.m1208getError0d7_KjU());
        colors.m1223setOnPrimary8_81llA$material_release(colors2.m1211getOnPrimary0d7_KjU());
        colors.m1224setOnSecondary8_81llA$material_release(colors2.m1212getOnSecondary0d7_KjU());
        colors.m1221setOnBackground8_81llA$material_release(colors2.m1209getOnBackground0d7_KjU());
        colors.m1225setOnSurface8_81llA$material_release(colors2.m1213getOnSurface0d7_KjU());
        colors.m1222setOnError8_81llA$material_release(colors2.m1210getOnError0d7_KjU());
        colors.setLight$material_release(colors2.isLight());
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }
}
