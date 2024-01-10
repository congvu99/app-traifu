package io.intercom.android.sdk.views.compose;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.models.ReplyOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.views.compose.ComposableSingletons$ReplyOptionsLayoutKt$lambda-1$1  reason: invalid class name */
/* compiled from: ReplyOptionsLayout.kt */
final class ComposableSingletons$ReplyOptionsLayoutKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ReplyOptionsLayoutKt$lambda1$1 INSTANCE = new ComposableSingletons$ReplyOptionsLayoutKt$lambda1$1();

    ComposableSingletons$ReplyOptionsLayoutKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            List createListBuilder = CollectionsKt.createListBuilder();
            for (int i2 = 0; i2 < 10; i2++) {
                ReplyOption.Builder builder = new ReplyOption.Builder();
                ReplyOption build = builder.withText("button" + i2).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder().withText(\"button$it\").build()");
                createListBuilder.add(build);
            }
            ReplyOptionsLayoutKt.ReplyOptionsLayout(CollectionsKt.build(createListBuilder), (Function1<? super ReplyOption, Unit>) null, composer, 8, 2);
            return;
        }
        composer.skipToGroupEnd();
    }
}
