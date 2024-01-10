package io.intercom.android.sdk.tickets.create.model;

import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.tickets.create.data.TicketAttributeRequest;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "content", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketViewModel.kt */
final class CreateTicketViewModel$getAttributeRequest$1 extends Lambda implements Function1<CreateTicketViewModel.CreateTicketFormUiState.Content, Unit> {
    final /* synthetic */ List<TicketAttributeRequest> $list;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateTicketViewModel$getAttributeRequest$1(List<TicketAttributeRequest> list) {
        super(1);
        this.$list = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CreateTicketViewModel.CreateTicketFormUiState.Content) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CreateTicketViewModel.CreateTicketFormUiState.Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Collection arrayList = new ArrayList();
        for (Object next : content.getQuestions()) {
            if (!Intrinsics.areEqual((Object) ((QuestionState) next).getQuestionModel().getId(), (Object) CreateTicketViewModelKt.EmailId)) {
                arrayList.add(next);
            }
        }
        List<TicketAttributeRequest> list = this.$list;
        for (QuestionState questionState : (List) arrayList) {
            Object access$formatAnswerForServer = CreateTicketViewModelKt.formatAnswerForServer(questionState);
            if (!Intrinsics.areEqual(access$formatAnswerForServer, (Object) Unit.INSTANCE)) {
                list.add(new TicketAttributeRequest(questionState.getQuestionModel().getId(), access$formatAnswerForServer));
            }
        }
    }
}
