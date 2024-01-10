package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a=\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"SelectedStar", "", "(Landroidx/compose/runtime/Composer;I)V", "StarRating", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "strokeColor", "StarRating-tAjK0ZQ", "(Landroidx/compose/ui/Modifier;JFJLandroidx/compose/runtime/Composer;II)V", "UnSelectedStar", "getStarPath", "Landroidx/compose/ui/graphics/Path;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: StarRating.kt */
public final class StarRatingKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* renamed from: StarRating-tAjK0ZQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5342StarRatingtAjK0ZQ(androidx.compose.ui.Modifier r14, long r15, float r17, long r18, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r7 = r21
            r0 = -1509251218(0xffffffffa60aa76e, float:-4.810528E-16)
            r1 = r20
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x0014
            r2 = r7 | 6
            r3 = r2
            r2 = r14
            goto L_0x0026
        L_0x0014:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0024
            r2 = r14
            boolean r3 = r0.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0021
            r3 = 4
            goto L_0x0022
        L_0x0021:
            r3 = 2
        L_0x0022:
            r3 = r3 | r7
            goto L_0x0026
        L_0x0024:
            r2 = r14
            r3 = r7
        L_0x0026:
            r4 = r22 & 2
            if (r4 == 0) goto L_0x002d
            r3 = r3 | 48
            goto L_0x003f
        L_0x002d:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x003f
            r5 = r15
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x003b
            r8 = 32
            goto L_0x003d
        L_0x003b:
            r8 = 16
        L_0x003d:
            r3 = r3 | r8
            goto L_0x0040
        L_0x003f:
            r5 = r15
        L_0x0040:
            r8 = r22 & 4
            if (r8 == 0) goto L_0x0047
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005a
        L_0x0047:
            r9 = r7 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x005a
            r9 = r17
            boolean r10 = r0.changed((float) r9)
            if (r10 == 0) goto L_0x0056
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r3 = r3 | r10
            goto L_0x005c
        L_0x005a:
            r9 = r17
        L_0x005c:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0075
            r10 = r22 & 8
            if (r10 != 0) goto L_0x006f
            r10 = r18
            boolean r12 = r0.changed((long) r10)
            if (r12 == 0) goto L_0x0071
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x006f:
            r10 = r18
        L_0x0071:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r3 = r3 | r12
            goto L_0x0077
        L_0x0075:
            r10 = r18
        L_0x0077:
            r12 = r3 & 5851(0x16db, float:8.199E-42)
            r13 = 1170(0x492, float:1.64E-42)
            if (r12 != r13) goto L_0x008d
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x0084
            goto L_0x008d
        L_0x0084:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r5
        L_0x0089:
            r4 = r9
            r5 = r10
            goto L_0x0120
        L_0x008d:
            r0.startDefaults()
            r12 = r7 & 1
            if (r12 == 0) goto L_0x00a7
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x009b
            goto L_0x00a7
        L_0x009b:
            r0.skipToGroupEnd()
            r1 = r22 & 8
            if (r1 == 0) goto L_0x00a4
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a4:
            r1 = r2
            r4 = r5
            goto L_0x00cc
        L_0x00a7:
            if (r1 == 0) goto L_0x00ae
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00af
        L_0x00ae:
            r1 = r2
        L_0x00af:
            if (r4 == 0) goto L_0x00b8
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r2.m1969getWhite0d7_KjU()
            goto L_0x00b9
        L_0x00b8:
            r4 = r5
        L_0x00b9:
            if (r8 == 0) goto L_0x00c2
            r2 = 1
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            r9 = r2
        L_0x00c2:
            r2 = r22 & 8
            if (r2 == 0) goto L_0x00cc
            long r10 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5397getAccessibleBorderColor8_81llA(r4)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00cc:
            r0.endDefaults()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1922boximpl(r10)
            androidx.compose.ui.unit.Dp r6 = androidx.compose.ui.unit.Dp.m4702boximpl(r9)
            androidx.compose.ui.graphics.Color r8 = androidx.compose.ui.graphics.Color.m1922boximpl(r4)
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r2 = r0.changed((java.lang.Object) r2)
            boolean r6 = r0.changed((java.lang.Object) r6)
            r2 = r2 | r6
            boolean r6 = r0.changed((java.lang.Object) r8)
            r2 = r2 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r2 != 0) goto L_0x0102
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r6 != r2) goto L_0x0113
        L_0x0102:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt$StarRating$1$1 r2 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt$StarRating$1$1
            r14 = r2
            r15 = r10
            r17 = r9
            r18 = r4
            r14.<init>(r15, r17, r18)
            r6 = r2
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x0113:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r2 = r3 & 14
            androidx.compose.foundation.CanvasKt.Canvas(r1, r6, r0, r2)
            r2 = r4
            goto L_0x0089
        L_0x0120:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0127
            goto L_0x0136
        L_0x0127:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt$StarRating$2 r10 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt$StarRating$2
            r0 = r10
            r7 = r21
            r8 = r22
            r0.<init>(r1, r2, r4, r5, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.numericscale.StarRatingKt.m5342StarRatingtAjK0ZQ(androidx.compose.ui.Modifier, long, float, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SelectedStar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-596392123);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            float f = (float) 44;
            m5342StarRatingtAjK0ZQ(SizeKt.m568height3ABfNKs(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f)), Dp.m4704constructorimpl(f)), Color.Companion.m1970getYellow0d7_KjU(), 0.0f, 0, startRestartGroup, 54, 12);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StarRatingKt$SelectedStar$1(i));
        }
    }

    public static final void UnSelectedStar(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(843558828);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            float f = (float) 44;
            m5342StarRatingtAjK0ZQ(SizeKt.m568height3ABfNKs(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl(f)), Dp.m4704constructorimpl(f)), 0, 0.0f, 0, startRestartGroup, 6, 14);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StarRatingKt$UnSelectedStar$1(i));
        }
    }

    public static final Path getStarPath() {
        Path Path = AndroidPath_androidKt.Path();
        Path.moveTo(31.9f, 11.25f);
        Path.cubicTo(32.95f, 11.39f, 33.38f, 12.71f, 32.6f, 13.46f);
        Path.lineTo(25.33f, 20.47f);
        Path.lineTo(27.16f, 30.48f);
        Path.cubicTo(27.35f, 31.54f, 26.25f, 32.36f, 25.31f, 31.84f);
        Path.lineTo(16.5f, 26.98f);
        Path.lineTo(7.69f, 31.84f);
        Path.cubicTo(6.75f, 32.36f, 5.65f, 31.54f, 5.84f, 30.48f);
        Path.lineTo(7.67f, 20.47f);
        Path.lineTo(0.4f, 13.46f);
        Path.cubicTo(-0.38f, 12.71f, 0.05f, 11.39f, 1.1f, 11.25f);
        Path.lineTo(11.04f, 9.92f);
        Path.lineTo(15.36f, 0.73f);
        Path.cubicTo(15.82f, -0.24f, 17.18f, -0.24f, 17.64f, 0.73f);
        Path.lineTo(21.96f, 9.92f);
        Path.lineTo(31.9f, 11.25f);
        return Path;
    }
}
