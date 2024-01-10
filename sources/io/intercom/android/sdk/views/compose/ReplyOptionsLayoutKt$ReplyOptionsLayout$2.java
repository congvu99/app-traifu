package io.intercom.android.sdk.views.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.models.ReplyOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReplyOptionsLayout.kt */
final class ReplyOptionsLayoutKt$ReplyOptionsLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $backgroundColor;
    final /* synthetic */ Function1<ReplyOption, Unit> $onReplyClicked;
    final /* synthetic */ List<ReplyOption> $replyOptions;
    final /* synthetic */ int $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyOptionsLayoutKt$ReplyOptionsLayout$2(List<? extends ReplyOption> list, int i, int i2, Function1<? super ReplyOption, Unit> function1) {
        super(2);
        this.$replyOptions = list;
        this.$backgroundColor = i;
        this.$textColor = i2;
        this.$onReplyClicked = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            int i2 = this.$backgroundColor;
            int i3 = this.$textColor;
            Function1<ReplyOption, Unit> function1 = this.$onReplyClicked;
            for (ReplyOption replyOption : this.$replyOptions) {
                Modifier r2 = PaddingKt.m510padding3ABfNKs(ClickableKt.m196clickableXHw0xAI$default(BackgroundKt.m176backgroundbw27NRU(ClipKt.clip(Modifier.Companion, MaterialTheme.INSTANCE.getShapes(composer2, 8).getMedium()), ColorKt.Color(i2), MaterialTheme.INSTANCE.getShapes(composer2, 8).getMedium()), false, (String) null, (Role) null, new ReplyOptionsLayoutKt$ReplyOptionsLayout$2$1$1(function1, replyOption), 7, (Object) null), Dp.m4704constructorimpl((float) 8));
                String text = replyOption.text();
                long Color = ColorKt.Color(i3);
                Intrinsics.checkNotNullExpressionValue(text, "text()");
                TextKt.m1496TextfLXpl1I(text, r2, Color, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 65528);
                composer2 = composer;
                function1 = function1;
                i3 = i3;
                i2 = i2;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
