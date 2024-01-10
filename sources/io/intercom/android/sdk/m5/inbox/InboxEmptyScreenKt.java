package io.intercom.android.sdk.m5.inbox;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a5\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"EmptyScreenBotPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "EmptyScreenHelpPreview", "EmptyScreenMessagePreview", "EmptyScreenWithoutActionPreview", "InboxEmptyScreen", "emptyState", "Lio/intercom/android/sdk/models/EmptyState;", "showActionButton", "", "onActionButtonClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/models/EmptyState;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxEmptyScreen.kt */
public final class InboxEmptyScreenKt {
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void InboxEmptyScreen(io.intercom.android.sdk.models.EmptyState r15, boolean r16, kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r20
            java.lang.String r0 = "emptyState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onActionButtonClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -452795077(0xffffffffe502e53b, float:-3.8633512E22)
            r4 = r19
            androidx.compose.runtime.Composer r0 = r4.startRestartGroup(r0)
            r4 = r21 & 1
            if (r4 == 0) goto L_0x0021
            r4 = r5 | 6
            goto L_0x0031
        L_0x0021:
            r4 = r5 & 14
            if (r4 != 0) goto L_0x0030
            boolean r4 = r0.changed((java.lang.Object) r15)
            if (r4 == 0) goto L_0x002d
            r4 = 4
            goto L_0x002e
        L_0x002d:
            r4 = 2
        L_0x002e:
            r4 = r4 | r5
            goto L_0x0031
        L_0x0030:
            r4 = r5
        L_0x0031:
            r6 = r21 & 2
            if (r6 == 0) goto L_0x0038
            r4 = r4 | 48
            goto L_0x0048
        L_0x0038:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0048
            boolean r6 = r0.changed((boolean) r2)
            if (r6 == 0) goto L_0x0045
            r6 = 32
            goto L_0x0047
        L_0x0045:
            r6 = 16
        L_0x0047:
            r4 = r4 | r6
        L_0x0048:
            r6 = r21 & 4
            if (r6 == 0) goto L_0x004f
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004f:
            r6 = r5 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x005f
            boolean r6 = r0.changed((java.lang.Object) r3)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r4 = r4 | r6
        L_0x005f:
            r6 = r21 & 8
            if (r6 == 0) goto L_0x0066
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0079
        L_0x0066:
            r7 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0079
            r7 = r18
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0075
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0075:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r4 = r4 | r8
            goto L_0x007b
        L_0x0079:
            r7 = r18
        L_0x007b:
            r8 = r4 & 5851(0x16db, float:8.199E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r8 != r9) goto L_0x008d
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            r0.skipToGroupEnd()
            r4 = r7
            goto L_0x00c1
        L_0x008d:
            if (r6 == 0) goto L_0x0095
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r14 = r6
            goto L_0x0096
        L_0x0095:
            r14 = r7
        L_0x0096:
            java.lang.String r6 = r15.getTitle()
            java.lang.String r8 = r15.getText()
            int r7 = io.intercom.android.sdk.R.drawable.intercom_messages_icon
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r7 = -1768973744(0xffffffff968f9a50, float:-2.320028E-25)
            io.intercom.android.sdk.m5.inbox.InboxEmptyScreenKt$InboxEmptyScreen$1 r10 = new io.intercom.android.sdk.m5.inbox.InboxEmptyScreenKt$InboxEmptyScreen$1
            r10.<init>(r2, r15, r3, r4)
            r11 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r11, r10)
            r10 = r7
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            int r4 = r4 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r12 = r4 | 24576(0x6000, float:3.4438E-41)
            r13 = 0
            r7 = r14
            r11 = r0
            io.intercom.android.sdk.m5.components.EmptyStateKt.EmptyState(r6, r7, r8, r9, r10, r11, r12, r13)
            r4 = r14
        L_0x00c1:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00c8
            goto L_0x00dc
        L_0x00c8:
            io.intercom.android.sdk.m5.inbox.InboxEmptyScreenKt$InboxEmptyScreen$2 r8 = new io.intercom.android.sdk.m5.inbox.InboxEmptyScreenKt$InboxEmptyScreen$2
            r0 = r8
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.inbox.InboxEmptyScreenKt.InboxEmptyScreen(io.intercom.android.sdk.models.EmptyState, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void EmptyScreenMessagePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(163744303);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxEmptyScreenKt.INSTANCE.m5245getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxEmptyScreenKt$EmptyScreenMessagePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void EmptyScreenHelpPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-139252097);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxEmptyScreenKt.INSTANCE.m5247getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxEmptyScreenKt$EmptyScreenHelpPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void EmptyScreenWithoutActionPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-176401288);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxEmptyScreenKt.INSTANCE.m5249getLambda6$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxEmptyScreenKt$EmptyScreenWithoutActionPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void EmptyScreenBotPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1607447023);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxEmptyScreenKt.INSTANCE.m5251getLambda8$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxEmptyScreenKt$EmptyScreenBotPreview$1(i));
        }
    }
}
