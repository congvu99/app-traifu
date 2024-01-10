package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationItem.kt */
final class ConversationItemKt$ConversationItem$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Conversation $conversation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationItemKt$ConversationItem$3(Modifier modifier, Conversation conversation, PaddingValues paddingValues, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$conversation = conversation;
        this.$contentPadding = paddingValues;
        this.$onClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ConversationItemKt.ConversationItem(this.$modifier, this.$conversation, this.$contentPadding, this.$onClick, composer, this.$$changed | 1, this.$$default);
    }
}
