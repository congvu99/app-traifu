package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a3\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"GradientHeaderBackdropPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "GradientHeaderBackdropWithFadePreview", "HomeHeaderBackdrop", "headerHeight", "Landroidx/compose/ui/unit/Dp;", "backdropStyle", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;", "onImageLoaded", "Lkotlin/Function0;", "HomeHeaderBackdrop--orJrPs", "(FLio/intercom/android/sdk/m5/home/viewmodel/HeaderState$HeaderBackdropStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SolidHeaderBackdropPreview", "SolidHeaderBackdropWithFadePreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeaderBackdrop.kt */
public final class HomeHeaderBackdropKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: HomeHeaderBackdrop--orJrPs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5232HomeHeaderBackdroporJrPs(float r28, io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32) {
        /*
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r32
            java.lang.String r4 = "backdropStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "onImageLoaded"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            r4 = -506138896(0xffffffffe1d4eef0, float:-4.9099088E20)
            r5 = r31
            androidx.compose.runtime.Composer r4 = r5.startRestartGroup(r4)
            r5 = r3 & 14
            if (r5 != 0) goto L_0x002a
            boolean r5 = r4.changed((float) r0)
            if (r5 == 0) goto L_0x0027
            r5 = 4
            goto L_0x0028
        L_0x0027:
            r5 = 2
        L_0x0028:
            r5 = r5 | r3
            goto L_0x002b
        L_0x002a:
            r5 = r3
        L_0x002b:
            r6 = r3 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x003b
            boolean r6 = r4.changed((java.lang.Object) r1)
            if (r6 == 0) goto L_0x0038
            r6 = 32
            goto L_0x003a
        L_0x0038:
            r6 = 16
        L_0x003a:
            r5 = r5 | r6
        L_0x003b:
            r6 = r3 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x004b
            boolean r6 = r4.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x0048
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x004a
        L_0x0048:
            r6 = 128(0x80, float:1.794E-43)
        L_0x004a:
            r5 = r5 | r6
        L_0x004b:
            r5 = r5 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r5 != r6) goto L_0x005d
            boolean r5 = r4.getSkipping()
            if (r5 != 0) goto L_0x0058
            goto L_0x005d
        L_0x0058:
            r4.skipToGroupEnd()
            goto L_0x0350
        L_0x005d:
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r11, r4, r11)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r7 = r4.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r10 = r4.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r13 = r4.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r15 = r4.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x00d2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00d2:
            r4.startReusableNode()
            boolean r15 = r4.getInserting()
            if (r15 == 0) goto L_0x00df
            r4.createNode(r14)
            goto L_0x00e2
        L_0x00df:
            r4.useNode()
        L_0x00e2:
            r4.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m1543constructorimpl(r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r6, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r7, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r14, r13, r6)
            r4.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            r5.invoke(r6, r4, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r5)
            r5 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r4.startReplaceableGroup(r5)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r10 = r5
            androidx.compose.foundation.layout.BoxScope r10 = (androidx.compose.foundation.layout.BoxScope) r10
            boolean r5 = r1 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Gradient
            r7 = 160(0xa0, float:2.24E-43)
            r6 = 0
            r15 = 0
            r14 = 80
            r13 = 1
            if (r5 == 0) goto L_0x019a
            r5 = 13604537(0xcf96b9, float:1.9064017E-38)
            r4.startReplaceableGroup(r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r16 = r5
            androidx.compose.ui.Modifier r16 = (androidx.compose.ui.Modifier) r16
            androidx.compose.ui.graphics.Brush$Companion r17 = androidx.compose.ui.graphics.Brush.Companion
            r5 = r1
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderBackdropStyle$Gradient r5 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Gradient) r5
            java.util.List r18 = r5.getColors()
            r19 = 0
            r21 = 0
            r23 = 0
            r24 = 14
            r25 = 0
            androidx.compose.ui.graphics.Brush r17 = androidx.compose.ui.graphics.Brush.Companion.m1872linearGradientmHitzGk$default((androidx.compose.ui.graphics.Brush.Companion) r17, (java.util.List) r18, (long) r19, (long) r21, (int) r23, (int) r24, (java.lang.Object) r25)
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.BackgroundKt.background$default(r16, r17, r18, r19, r20, r21)
            boolean r8 = r29.getFade()
            if (r8 == 0) goto L_0x0177
            float r8 = (float) r7
            goto L_0x0178
        L_0x0177:
            float r8 = (float) r14
        L_0x0178:
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            float r8 = r8 + r0
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r5, r8)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r15, r13, r6)
            androidx.compose.foundation.layout.BoxKt.Box(r5, r4, r11)
            r4.endReplaceableGroup()
            r8 = r6
            r27 = r10
            r6 = 160(0xa0, float:2.24E-43)
            r7 = 80
            r9 = 0
            r10 = 1
            goto L_0x02d7
        L_0x019a:
            boolean r5 = r1 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Image
            if (r5 == 0) goto L_0x0275
            r5 = 13604981(0xcf9875, float:1.9064639E-38)
            r4.startReplaceableGroup(r5)
            coil.request.ImageRequest$Builder r5 = new coil.request.ImageRequest$Builder
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            r7 = r16
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r7 = r4.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            android.content.Context r7 = (android.content.Context) r7
            r5.<init>((android.content.Context) r7)
            r7 = r1
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderBackdropStyle$Image r7 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Image) r7
            java.lang.String r11 = r7.getImageUrl()
            coil.request.ImageRequest$Builder r5 = r5.data(r11)
            coil.request.ImageRequest$Builder r5 = r5.crossfade((boolean) r13)
            coil.request.ImageRequest r5 = r5.build()
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r8, r9)
            java.lang.Object r8 = r4.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            android.content.Context r8 = (android.content.Context) r8
            coil.ImageLoader r8 = io.intercom.android.sdk.utilities.IntercomCoilKt.getImageLoader(r8)
            androidx.compose.ui.layout.ContentScale$Companion r9 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r20 = r9.getCrop()
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            r21 = r9
            androidx.compose.ui.Modifier r21 = (androidx.compose.ui.Modifier) r21
            long r22 = r7.m5238getFallbackColor0d7_KjU()
            r24 = 0
            r25 = 2
            r26 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r21, r22, r24, r25, r26)
            float r9 = (float) r14
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            float r9 = r9 + r0
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r7, r9)
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r7, r15, r13, r6)
            r7 = 0
            r11 = 0
            r25 = 0
            r6 = 1157296644(0x44faf204, float:2007.563)
            r4.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r6)
            boolean r6 = r4.changed((java.lang.Object) r2)
            java.lang.Object r12 = r4.rememberedValue()
            if (r6 != 0) goto L_0x0233
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r12 != r6) goto L_0x023e
        L_0x0233:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt$HomeHeaderBackdrop$1$1$1 r6 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt$HomeHeaderBackdrop$1$1$1
            r6.<init>(r2)
            r12 = r6
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r4.updateRememberedValue(r12)
        L_0x023e:
            r4.endReplaceableGroup()
            r6 = r12
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r12 = 1
            r13 = r6
            r6 = 0
            r14 = r6
            r15 = r6
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 568(0x238, float:7.96E-43)
            r22 = 48
            r23 = 30448(0x76f0, float:4.2667E-41)
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r11 = r10
            r10 = r24
            r27 = r11
            r11 = r25
            r12 = r26
            r16 = r20
            r20 = r4
            coil.compose.SubcomposeAsyncImageKt.m5024SubcomposeAsyncImageQ4Kwu38(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r4.endReplaceableGroup()
            r6 = 160(0xa0, float:2.24E-43)
            r7 = 80
            r8 = 0
            r9 = 0
            r10 = 1
            r11 = 0
            goto L_0x02d7
        L_0x0275:
            r27 = r10
            boolean r5 = r1 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Solid
            if (r5 == 0) goto L_0x02c6
            r5 = 13605795(0xcf9ba3, float:1.906578E-38)
            r4.startReplaceableGroup(r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r6 = r5
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r5 = r1
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderBackdropStyle$Solid r5 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Solid) r5
            long r7 = r5.m5242getColor0d7_KjU()
            r9 = 0
            r10 = 2
            r11 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r6, r7, r9, r10, r11)
            boolean r6 = r29.getFade()
            if (r6 == 0) goto L_0x02a5
            r6 = 160(0xa0, float:2.24E-43)
            float r7 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r8 = r7
            r7 = 80
            goto L_0x02ae
        L_0x02a5:
            r6 = 160(0xa0, float:2.24E-43)
            r7 = 80
            float r8 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
        L_0x02ae:
            float r8 = r8 + r0
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r5, r8)
            r8 = 0
            r9 = 0
            r10 = 1
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r9, r10, r8)
            r11 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r5, r4, r11)
            r4.endReplaceableGroup()
            goto L_0x02d7
        L_0x02c6:
            r6 = 160(0xa0, float:2.24E-43)
            r7 = 80
            r8 = 0
            r9 = 0
            r10 = 1
            r11 = 0
            r5 = 13606106(0xcf9cda, float:1.9066215E-38)
            r4.startReplaceableGroup(r5)
            r4.endReplaceableGroup()
        L_0x02d7:
            boolean r5 = r29.getFade()
            if (r5 == 0) goto L_0x0341
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            r12 = r5
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            androidx.compose.ui.graphics.Brush$Companion r13 = androidx.compose.ui.graphics.Brush.Companion
            r5 = 2
            androidx.compose.ui.graphics.Color[] r5 = new androidx.compose.ui.graphics.Color[r5]
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r14 = r14.m1967getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color r14 = androidx.compose.ui.graphics.Color.m1922boximpl(r14)
            r5[r11] = r14
            androidx.compose.material.MaterialTheme r14 = androidx.compose.material.MaterialTheme.INSTANCE
            r15 = 8
            androidx.compose.material.Colors r14 = r14.getColors(r4, r15)
            long r14 = r14.m1218getSurface0d7_KjU()
            androidx.compose.ui.graphics.Color r14 = androidx.compose.ui.graphics.Color.m1922boximpl(r14)
            r5[r10] = r14
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r5)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 14
            r19 = 0
            androidx.compose.ui.graphics.Brush r13 = androidx.compose.ui.graphics.Brush.Companion.m1878verticalGradient8A3gB4$default((androidx.compose.ui.graphics.Brush.Companion) r13, (java.util.List) r14, (float) r15, (float) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            r14 = 0
            r16 = 6
            r17 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.BackgroundKt.background$default(r12, r13, r14, r15, r16, r17)
            boolean r12 = r1 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderBackdropStyle.Image
            if (r12 == 0) goto L_0x0325
            float r6 = (float) r7
            goto L_0x0326
        L_0x0325:
            float r6 = (float) r6
        L_0x0326:
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r5, r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r9, r10, r8)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getBottomCenter()
            r7 = r27
            androidx.compose.ui.Modifier r5 = r7.align(r5, r6)
            androidx.compose.foundation.layout.BoxKt.Box(r5, r4, r11)
        L_0x0341:
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
        L_0x0350:
            androidx.compose.runtime.ScopeUpdateScope r4 = r4.endRestartGroup()
            if (r4 != 0) goto L_0x0357
            goto L_0x0361
        L_0x0357:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt$HomeHeaderBackdrop$2 r5 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt$HomeHeaderBackdrop$2
            r5.<init>(r0, r1, r2, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r4.updateScope(r5)
        L_0x0361:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.topbars.HomeHeaderBackdropKt.m5232HomeHeaderBackdroporJrPs(float, io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderBackdropStyle, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SolidHeaderBackdropPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1191283198);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderBackdropKt.INSTANCE.m5224getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderBackdropKt$SolidHeaderBackdropPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void GradientHeaderBackdropPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-254735137);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderBackdropKt.INSTANCE.m5225getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderBackdropKt$GradientHeaderBackdropPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void SolidHeaderBackdropWithFadePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-700018304);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderBackdropKt.INSTANCE.m5226getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderBackdropKt$SolidHeaderBackdropWithFadePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void GradientHeaderBackdropWithFadePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1369023329);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderBackdropKt.INSTANCE.m5227getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderBackdropKt$GradientHeaderBackdropWithFadePreview$1(i));
        }
    }
}
