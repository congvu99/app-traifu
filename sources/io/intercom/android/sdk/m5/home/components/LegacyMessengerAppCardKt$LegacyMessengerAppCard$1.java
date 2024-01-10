package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LegacyMessengerAppCard.kt */
final class LegacyMessengerAppCardKt$LegacyMessengerAppCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ String $url;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyMessengerAppCardKt$LegacyMessengerAppCard$1(String str, int i) {
        super(2);
        this.$url = str;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r9, int r10) {
        /*
            r8 = this;
            r10 = r10 & 11
            r0 = 2
            if (r10 != r0) goto L_0x0010
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x000c
            goto L_0x0010
        L_0x000c:
            r9.skipToGroupEnd()
            goto L_0x0048
        L_0x0010:
            java.lang.String r10 = r8.$url
            r0 = 1157296644(0x44faf204, float:2007.563)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            boolean r0 = r9.changed((java.lang.Object) r10)
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x002f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x003a
        L_0x002f:
            io.intercom.android.sdk.m5.home.components.LegacyMessengerAppCardKt$LegacyMessengerAppCard$1$1$1 r0 = new io.intercom.android.sdk.m5.home.components.LegacyMessengerAppCardKt$LegacyMessengerAppCard$1$1$1
            r0.<init>(r10)
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r9.updateRememberedValue(r1)
        L_0x003a:
            r9.endReplaceableGroup()
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 6
            r5 = r9
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r2, r3, r4, r5, r6, r7)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.components.LegacyMessengerAppCardKt$LegacyMessengerAppCard$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
