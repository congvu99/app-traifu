package io.intercom.android.sdk.views.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageRow$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $showMeta$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRowKt$MessageRow$2$1$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$showMeta$delegate = mutableState;
    }

    public final void invoke() {
        MutableState<Boolean> mutableState = this.$showMeta$delegate;
        MessageRowKt.m5408MessageRow$lambda2(mutableState, !MessageRowKt.m5407MessageRow$lambda1(mutableState));
    }
}
