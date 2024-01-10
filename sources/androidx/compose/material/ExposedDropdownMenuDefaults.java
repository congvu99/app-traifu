package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TrailingIcon(boolean r13, kotlin.jvm.functions.Function0<kotlin.Unit> r14, androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r12 = this;
            r2 = r13
            r0 = 876077373(0x3437e13d, float:1.7125144E-7)
            r1 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            java.lang.String r1 = "C(TrailingIcon)294@11256L394:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r17 & 1
            if (r1 == 0) goto L_0x0015
            r1 = r16 | 6
            goto L_0x0027
        L_0x0015:
            r1 = r16 & 14
            if (r1 != 0) goto L_0x0025
            boolean r1 = r0.changed((boolean) r13)
            if (r1 == 0) goto L_0x0021
            r1 = 4
            goto L_0x0022
        L_0x0021:
            r1 = 2
        L_0x0022:
            r1 = r16 | r1
            goto L_0x0027
        L_0x0025:
            r1 = r16
        L_0x0027:
            r3 = r17 & 2
            if (r3 == 0) goto L_0x002e
            r1 = r1 | 48
            goto L_0x0040
        L_0x002e:
            r4 = r16 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0040
            r4 = r14
            boolean r5 = r0.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x003c
            r5 = 32
            goto L_0x003e
        L_0x003c:
            r5 = 16
        L_0x003e:
            r1 = r1 | r5
            goto L_0x0041
        L_0x0040:
            r4 = r14
        L_0x0041:
            r5 = r1 & 91
            r6 = 18
            if (r5 != r6) goto L_0x0053
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            r0.skipToGroupEnd()
            r3 = r4
            goto L_0x0087
        L_0x0053:
            if (r3 == 0) goto L_0x005b
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1 r3 = androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1.INSTANCE
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r11 = r3
            goto L_0x005c
        L_0x005b:
            r11 = r4
        L_0x005c:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2 r4 = androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r3, r4)
            r5 = 0
            r6 = 0
            r3 = 726122713(0x2b47c0d9, float:7.096663E-13)
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3 r7 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
            r7.<init>(r13)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r8, r7)
            r7 = r3
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            int r1 = r1 >> 3
            r1 = r1 & 14
            r9 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = 12
            r3 = r11
            r8 = r0
            androidx.compose.material.IconButtonKt.IconButton(r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x0087:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x008e
            goto L_0x009f
        L_0x008e:
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4 r7 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
            r0 = r7
            r1 = r12
            r2 = r13
            r4 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon(boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: textFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m1287textFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long j23;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(1208167904);
        ComposerKt.sourceInformation(composer2, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)353@14329L7,353@14360L7,354@14433L8,356@14503L6,357@14614L6,358@14678L6,360@14757L6,360@14798L4,362@14872L6,365@15072L8,366@15134L6,368@15208L6,369@15355L8,372@15484L6,374@15614L6,374@15655L4,375@15749L8,376@15814L6,378@15889L6,378@15930L4,379@15988L6,379@16023L6,380@16106L8,381@16164L6,382@16226L6,382@16261L6,383@16347L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1942unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j23 = Color.m1931copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1931copywmQWz5c$default(j23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r35 = (i5 & 4) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1931copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1931copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j24 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r33 = (i5 & 16384) != 0 ? Color.m1931copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long r37 = (32768 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? Color.m1931copywmQWz5c$default(r41, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        long r45 = (524288 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j20;
        long r47 = (1048576 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(j23, r7, r9, r13, r15, r17, r21, r19, r23, r25, j24, r29, r31, r33, r37, r35, r39, r41, r43, r45, r47, (i5 & 2097152) != 0 ? Color.m1931copywmQWz5c$default(r47, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j22, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* renamed from: outlinedTextFieldColors-DlUQjxs  reason: not valid java name */
    public final TextFieldColors m1286outlinedTextFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long j23;
        Composer composer2 = composer;
        int i5 = i4;
        composer2.startReplaceableGroup(1162641182);
        ComposerKt.sourceInformation(composer2, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)456@20314L7,456@20345L7,457@20418L8,459@20524L6,460@20588L6,462@20664L6,462@20705L4,464@20776L6,464@20819L8,465@20914L8,466@20973L6,468@21047L6,469@21194L8,472@21323L6,474@21453L6,474@21494L4,475@21588L8,476@21653L6,478@21728L6,478@21769L4,479@21827L6,479@21862L6,480@21945L8,481@22003L6,482@22065L6,482@22100L6,483@22186L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i5 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(composer);
            long r5 = ((Color) consume).m1942unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer2.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            j23 = Color.m1931copywmQWz5c$default(r5, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j23 = j;
        }
        long r7 = (i5 & 2) != 0 ? Color.m1931copywmQWz5c$default(j23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r35 = (i5 & 4) != 0 ? Color.Companion.m1967getTransparent0d7_KjU() : j3;
        long r9 = (i5 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j4;
        long r13 = (i5 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j5;
        long r15 = (i5 & 32) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r17 = (i5 & 64) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        long r19 = (i5 & 128) != 0 ? Color.m1931copywmQWz5c$default(r17, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8;
        long r21 = (i5 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j9;
        long r23 = (i5 & 512) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10;
        long r25 = (i5 & 1024) != 0 ? Color.m1931copywmQWz5c$default(r23, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        long j24 = (i5 & 2048) != 0 ? r23 : j12;
        long r29 = (i5 & 4096) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j13;
        long r31 = (i5 & 8192) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j14;
        long r33 = (i5 & 16384) != 0 ? Color.m1931copywmQWz5c$default(r29, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j15;
        long r37 = (32768 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j16;
        long r39 = (65536 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j17;
        long r41 = (131072 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long r43 = (262144 & i5) != 0 ? Color.m1931copywmQWz5c$default(r41, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j19;
        long r45 = (524288 & i5) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1208getError0d7_KjU() : j20;
        long r47 = (1048576 & i5) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j21;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(j23, r7, r9, r13, r15, r17, r21, r19, r23, r25, j24, r29, r31, r33, r37, r35, r39, r41, r43, r45, r47, (i5 & 2097152) != 0 ? Color.m1931copywmQWz5c$default(r47, ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j22, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
