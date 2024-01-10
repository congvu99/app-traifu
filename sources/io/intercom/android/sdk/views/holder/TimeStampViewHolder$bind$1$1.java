package io.intercom.android.sdk.views.holder;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.DayDividerKt;
import io.intercom.android.sdk.models.Part;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TimeStampViewHolder.kt */
final class TimeStampViewHolder$bind$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Part $part;
    final /* synthetic */ TimeStampViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeStampViewHolder$bind$1$1(TimeStampViewHolder timeStampViewHolder, Part part) {
        super(2);
        this.this$0 = timeStampViewHolder;
        this.$part = part;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final TimeStampViewHolder timeStampViewHolder = this.this$0;
            final Part part = this.$part;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1807096912, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        String absoluteDate = timeStampViewHolder.timeFormatter.getAbsoluteDate(part.getCreatedAt());
                        Intrinsics.checkNotNullExpressionValue(absoluteDate, "timeFormatter.getAbsoluteDate(part.createdAt)");
                        DayDividerKt.DayDivider(absoluteDate, (Modifier) null, composer, 0, 2);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
