package io.intercom.android.sdk.views.compose;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageBubbleRow$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ Function4<ColumnScope, Color, Composer, Integer, Unit> $bubbleContent;
    final /* synthetic */ PaddingValues $bubbleContentPadding;
    final /* synthetic */ Shape $bubbleShape;
    final /* synthetic */ boolean $isAdmin;
    final /* synthetic */ boolean $isAdminOrAltParticipant;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $showAvatarIfAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRowKt$MessageBubbleRow$4(boolean z, boolean z2, Shape shape, Modifier modifier, PaddingValues paddingValues, Avatar avatar, Function0<Unit> function0, boolean z3, Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function4, int i, int i2) {
        super(2);
        this.$isAdmin = z;
        this.$isAdminOrAltParticipant = z2;
        this.$bubbleShape = shape;
        this.$modifier = modifier;
        this.$bubbleContentPadding = paddingValues;
        this.$avatar = avatar;
        this.$onClick = function0;
        this.$showAvatarIfAvailable = z3;
        this.$bubbleContent = function4;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        MessageRowKt.MessageBubbleRow(this.$isAdmin, this.$isAdminOrAltParticipant, this.$bubbleShape, this.$modifier, this.$bubbleContentPadding, this.$avatar, this.$onClick, this.$showAvatarIfAvailable, this.$bubbleContent, composer, this.$$changed | 1, this.$$default);
    }
}
