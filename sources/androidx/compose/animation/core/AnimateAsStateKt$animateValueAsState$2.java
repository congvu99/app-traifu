package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnimateAsState.kt */
final class AnimateAsStateKt$animateValueAsState$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ T $targetValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimateAsStateKt$animateValueAsState$2(Channel<T> channel, T t) {
        super(0);
        this.$channel = channel;
        this.$targetValue = t;
    }

    public final void invoke() {
        this.$channel.m6954trySendJP2dKIU(this.$targetValue);
    }
}
