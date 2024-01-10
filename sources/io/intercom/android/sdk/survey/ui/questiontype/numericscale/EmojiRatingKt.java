package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"EmojiRating", "", "emojiUrl", "", "contentDescription", "showInColor", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectedEmoji", "(Landroidx/compose/runtime/Composer;I)V", "UnSelectedEmoji", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmojiRating.kt */
public final class EmojiRatingKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void EmojiRating(java.lang.String r17, java.lang.String r18, boolean r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r1 = r17
            r12 = r18
            r13 = r20
            r14 = r22
            java.lang.String r0 = "emojiUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "contentDescription"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -538688650(0xffffffffdfe44376, float:-3.289624E19)
            r2 = r21
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r23 & 1
            if (r2 == 0) goto L_0x0027
            r2 = r14 | 6
            goto L_0x0037
        L_0x0027:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0033
            r2 = 4
            goto L_0x0034
        L_0x0033:
            r2 = 2
        L_0x0034:
            r2 = r2 | r14
            goto L_0x0037
        L_0x0036:
            r2 = r14
        L_0x0037:
            r3 = r23 & 2
            if (r3 == 0) goto L_0x003e
            r2 = r2 | 48
            goto L_0x004e
        L_0x003e:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004e
            boolean r3 = r0.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x004b
            r3 = 32
            goto L_0x004d
        L_0x004b:
            r3 = 16
        L_0x004d:
            r2 = r2 | r3
        L_0x004e:
            r3 = r23 & 4
            if (r3 == 0) goto L_0x0055
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r19
            boolean r5 = r0.changed((boolean) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r2 = r2 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r19
        L_0x006a:
            r5 = r23 & 8
            if (r5 == 0) goto L_0x0071
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r5 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0081
            boolean r5 = r0.changed((java.lang.Object) r13)
            if (r5 == 0) goto L_0x007e
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r2 = r2 | r5
        L_0x0081:
            r11 = r2
            r2 = r11 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r2 != r5) goto L_0x0095
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x008f
            goto L_0x0095
        L_0x008f:
            r0.skipToGroupEnd()
            r3 = r4
            goto L_0x0124
        L_0x0095:
            r15 = 1
            if (r3 == 0) goto L_0x009b
            r16 = 1
            goto L_0x009d
        L_0x009b:
            r16 = r4
        L_0x009d:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r3, r4)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r2 = (android.content.Context) r2
            coil.ImageLoader r3 = io.intercom.android.sdk.utilities.IntercomCoilKt.getImageLoader(r2)
            r2 = 604401124(0x24066de4, float:2.91497E-17)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(rememberImagePainter)P(1,2)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            coil.request.ImageRequest$Builder r2 = new coil.request.ImageRequest$Builder
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r4)
            java.lang.Object r4 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r4 = (android.content.Context) r4
            r2.<init>((android.content.Context) r4)
            coil.request.ImageRequest$Builder r2 = r2.data(r1)
            r2.crossfade((boolean) r15)
            coil.request.ImageRequest r2 = r2.build()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 72
            r10 = 60
            r8 = r0
            coil.compose.AsyncImagePainter r2 = coil.compose.AsyncImagePainterKt.m4998rememberAsyncImagePainter5jETZwI(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.painter.Painter r2 = (androidx.compose.ui.graphics.painter.Painter) r2
            r7 = 0
            androidx.compose.ui.graphics.ColorFilter$Companion r3 = androidx.compose.ui.graphics.ColorFilter.Companion
            float[] r4 = androidx.compose.ui.graphics.ColorMatrix.m1990constructorimpl$default(r4, r15, r4)
            if (r16 == 0) goto L_0x0106
            r8 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0107
        L_0x0106:
            r8 = 0
        L_0x0107:
            androidx.compose.ui.graphics.ColorMatrix.m2005setToSaturationimpl(r4, r8)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            androidx.compose.ui.graphics.ColorFilter r8 = r3.m1974colorMatrixjHGOpc(r4)
            r3 = r11 & 112(0x70, float:1.57E-43)
            int r4 = r11 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r10 = r3 | r4
            r11 = 56
            r3 = r18
            r4 = r20
            r9 = r0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r2, (java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (androidx.compose.ui.Alignment) r5, (androidx.compose.ui.layout.ContentScale) r6, (float) r7, (androidx.compose.ui.graphics.ColorFilter) r8, (androidx.compose.runtime.Composer) r9, (int) r10, (int) r11)
            r3 = r16
        L_0x0124:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x012b
            goto L_0x0140
        L_0x012b:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiRatingKt$EmojiRating$2 r8 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiRatingKt$EmojiRating$2
            r0 = r8
            r1 = r17
            r2 = r18
            r4 = r20
            r5 = r22
            r6 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.numericscale.EmojiRatingKt.EmojiRating(java.lang.String, java.lang.String, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SelectedEmoji(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1230381561);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            EmojiRating("https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "🤩", true, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 44)), startRestartGroup, 3510, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmojiRatingKt$SelectedEmoji$1(i));
        }
    }

    public static final void UnSelectedEmoji(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(2043776160);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            EmojiRating("https://js.intercomcdn.com/images/emojis/v2/72x72/1f929.png", "🤩", false, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 44)), startRestartGroup, 3510, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmojiRatingKt$UnSelectedEmoji$1(i));
        }
    }
}
