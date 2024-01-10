package io.intercom.android.sdk.views.compose;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.models.ReplyOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReplyOptionsLayout.kt */
final class ReplyOptionsLayoutKt$ReplyOptionsLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<ReplyOption, Unit> $onReplyClicked;
    final /* synthetic */ List<ReplyOption> $replyOptions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyOptionsLayoutKt$ReplyOptionsLayout$3(List<? extends ReplyOption> list, Function1<? super ReplyOption, Unit> function1, int i, int i2) {
        super(2);
        this.$replyOptions = list;
        this.$onReplyClicked = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ReplyOptionsLayoutKt.ReplyOptionsLayout(this.$replyOptions, this.$onReplyClicked, composer, this.$$changed | 1, this.$$default);
    }
}
