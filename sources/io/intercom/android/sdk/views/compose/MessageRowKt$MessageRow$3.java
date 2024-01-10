package io.intercom.android.sdk.views.compose;

import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReplyOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageRow$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Shape $bubbleShape;
    final /* synthetic */ Part $conversationPart;
    final /* synthetic */ boolean $isAdminOrAltParticipant;
    final /* synthetic */ boolean $isLastPart;
    final /* synthetic */ List<ViewGroup> $legacyBlocks;
    final /* synthetic */ String $metaString;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<ReplyOption, Unit> $onReplyClicked;
    final /* synthetic */ boolean $showAvatarIfAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRowKt$MessageRow$3(Modifier modifier, Part part, boolean z, Function1<? super ReplyOption, Unit> function1, String str, boolean z2, List<? extends ViewGroup> list, Shape shape, boolean z3, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$conversationPart = part;
        this.$isLastPart = z;
        this.$onReplyClicked = function1;
        this.$metaString = str;
        this.$isAdminOrAltParticipant = z2;
        this.$legacyBlocks = list;
        this.$bubbleShape = shape;
        this.$showAvatarIfAvailable = z3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        MessageRowKt.MessageRow(this.$modifier, this.$conversationPart, this.$isLastPart, this.$onReplyClicked, this.$metaString, this.$isAdminOrAltParticipant, this.$legacyBlocks, this.$bubbleShape, this.$showAvatarIfAvailable, composer, this.$$changed | 1, this.$$default);
    }
}
