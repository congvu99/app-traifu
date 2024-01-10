package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketContentScreen.kt */
final class CreateTicketContentScreenKt$CreateTicketContentScreen$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onCancel;
    final /* synthetic */ Function0<Unit> $onCreateTicket;
    final /* synthetic */ CreateTicketViewModel.CreateTicketFormUiState.Content $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateTicketContentScreenKt$CreateTicketContentScreen$2(Modifier modifier, CreateTicketViewModel.CreateTicketFormUiState.Content content, Function0<Unit> function0, Function0<Unit> function02, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$state = content;
        this.$onCreateTicket = function0;
        this.$onCancel = function02;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CreateTicketContentScreenKt.CreateTicketContentScreen(this.$modifier, this.$state, this.$onCreateTicket, this.$onCancel, composer, this.$$changed | 1, this.$$default);
    }
}
