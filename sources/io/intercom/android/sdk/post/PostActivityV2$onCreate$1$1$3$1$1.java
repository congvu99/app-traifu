package io.intercom.android.sdk.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.ConversationReactionListener;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReactionReply;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
final class PostActivityV2$onCreate$1$1$3$1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ Part $part;
    final /* synthetic */ PostActivityV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostActivityV2$onCreate$1$1$3$1$1(Part part, PostActivityV2 postActivityV2) {
        super(3);
        this.$part = part;
        this.this$0 = postActivityV2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$BottomBarContent");
        if ((i & 81) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (!ReactionReply.isNull(this.$part.getReactionReply())) {
            composer2.startReplaceableGroup(851085889);
            final Part part = this.$part;
            final PostActivityV2 postActivityV2 = this.this$0;
            AndroidView_androidKt.AndroidView(new Function1<Context, ReactionInputView>() {
                public final ReactionInputView invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "it");
                    ReactionInputView reactionInputView = new ReactionInputView(context, (AttributeSet) null);
                    Part part = part;
                    PostActivityV2 postActivityV2 = postActivityV2;
                    reactionInputView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    reactionInputView.setUpReactions(part.getReactionReply(), true, new ConversationReactionListener(MetricTracker.ReactionLocation.IN_APP, part.getId(), postActivityV2.getCOnversationId(), postActivityV2.getInjector().getApi(), postActivityV2.getInjector().getMetricTracker()));
                    return reactionInputView;
                }
            }, (Modifier) null, (Function1) null, composer, 0, 6);
            composer.endReplaceableGroup();
        } else if (this.this$0.isComposerVisible()) {
            composer2.startReplaceableGroup(851087716);
            final PostActivityV2 postActivityV22 = this.this$0;
            Modifier r2 = ClickableKt.m196clickableXHw0xAI$default(Modifier.Companion, false, (String) null, (Role) null, new Function0<Unit>() {
                public final void invoke() {
                    postActivityV22.openConversation();
                }
            }, 7, (Object) null);
            String string = this.this$0.getString(R.string.intercom_reply_to_conversation);
            long sp = TextUnitKt.getSp(12);
            long Color = ColorKt.Color(4288585374L);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.intercom_reply_to_conversation)");
            Composer composer3 = composer;
            TextKt.m1496TextfLXpl1I(string, r2, Color, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3456, 0, 65520);
            final PostActivityV2 postActivityV23 = this.this$0;
            Modifier r22 = ClickableKt.m196clickableXHw0xAI$default(Modifier.Companion, false, (String) null, (Role) null, new Function0<Unit>() {
                public final void invoke() {
                    postActivityV23.openConversation();
                }
            }, 7, (Object) null);
            String string2 = this.this$0.getString(R.string.intercom_send);
            long sp2 = TextUnitKt.getSp(12);
            long Color2 = ColorKt.Color(4288585374L);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.intercom_send)");
            TextKt.m1496TextfLXpl1I(string2, r22, Color2, sp2, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 3456, 0, 65520);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(851088670);
            composer.endReplaceableGroup();
        }
    }
}
