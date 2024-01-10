package io.intercom.android.sdk.tickets;

import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.survey.ui.questiontype.choice.SingleChoiceQuestionKt;
import io.intercom.android.sdk.tickets.TicketDetailState;
import io.intercom.android.sdk.tickets.TicketTimelineCardState;
import io.intercom.android.sdk.utilities.TimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0000\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a\f\u0010\r\u001a\u00020\n*\u00020\u000eH\u0002\u001a\f\u0010\u000f\u001a\u00020\u000b*\u00020\u0010H\u0000¨\u0006\u0011"}, d2 = {"computeTicketViewState", "Lio/intercom/android/sdk/tickets/TicketDetailState$TicketDetailContentState;", "ticket", "Lio/intercom/android/sdk/models/Ticket;", "user", "Lio/intercom/android/sdk/identity/UserIdentity;", "activeAdminsAvatars", "", "Lio/intercom/android/sdk/models/Avatar;", "isDone", "", "Lio/intercom/android/sdk/tickets/TicketStatus;", "currentTicketStatus", "isUnassignedOrBot", "Lio/intercom/android/sdk/models/Participant;", "toTicketStatus", "Lio/intercom/android/sdk/models/Ticket$Status;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailReducer.kt */
public final class TicketDetailReducerKt {
    public static /* synthetic */ TicketDetailState.TicketDetailContentState computeTicketViewState$default(Ticket ticket, UserIdentity userIdentity, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return computeTicketViewState(ticket, userIdentity, list);
    }

    public static final TicketDetailState.TicketDetailContentState computeTicketViewState(Ticket ticket, UserIdentity userIdentity, List<? extends Avatar> list) {
        List list2;
        TicketAttribute ticketAttribute;
        TicketTimelineCardState.ActualStringOrRes actualStringOrRes;
        TicketTimelineCardState.ActualStringOrRes actualStringOrRes2;
        List<? extends Avatar> list3 = list;
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(userIdentity, Participant.USER_TYPE);
        Intrinsics.checkNotNullParameter(list3, "activeAdminsAvatars");
        String title = ticket.getTitle();
        Participant build = ticket.getAssignee().build();
        Intrinsics.checkNotNullExpressionValue(build, "ticket.assignee.build()");
        if (!isUnassignedOrBot(build) || !(!list3.isEmpty())) {
            list2 = CollectionsKt.listOf(ticket.getAssignee().build().getAvatar());
        } else {
            list2 = CollectionsKt.take(list3, 3);
        }
        List list4 = list2;
        String statusDetail = ticket.getCurrentStatus().getStatusDetail();
        long r10 = toTicketStatus(ticket.getCurrentStatus()).m5382getColor0d7_KjU();
        Iterable<Ticket.Status> statusList = ticket.getStatusList();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(statusList, 10));
        for (Ticket.Status status : statusList) {
            boolean isDone = isDone(toTicketStatus(status), toTicketStatus(ticket.getCurrentStatus()));
            if (toTicketStatus(status) == TicketStatus.WaitingOnCustomer) {
                actualStringOrRes2 = new TicketTimelineCardState.ActualStringOrRes.StringRes(R.string.intercom_tickets_status_in_progress);
            } else {
                actualStringOrRes2 = new TicketTimelineCardState.ActualStringOrRes.ActualString(status.getTitle());
            }
            arrayList.add(new TicketTimelineCardState.ProgressSection(isDone, actualStringOrRes2, (toTicketStatus(status) == TicketStatus.InProgress || toTicketStatus(status) == TicketStatus.WaitingOnCustomer) ? 0 : status.getCreatedDate(), status.isCurrentStatus()));
        }
        TicketTimelineCardState ticketTimelineCardState = new TicketTimelineCardState(list4, statusDetail, "", r10, (List) arrayList, toTicketStatus(ticket.getCurrentStatus()) == TicketStatus.WaitingOnCustomer ? Integer.valueOf(R.string.intercom_tickets_status_waiting_on_you) : null, (DefaultConstructorMarker) null);
        Collection arrayList2 = new ArrayList();
        for (Ticket.TicketAttribute ticketAttribute2 : ticket.getAttributes()) {
            if (ticketAttribute2.getValue().length() > 0) {
                if (Intrinsics.areEqual((Object) ticketAttribute2.getType(), (Object) "datetime")) {
                    String formatTimeInMillisAsDate = TimeFormatter.formatTimeInMillisAsDate(Long.parseLong(ticketAttribute2.getValue()) * ((long) 1000), "dd-MM-yyy, HH:mm");
                    Intrinsics.checkNotNullExpressionValue(formatTimeInMillisAsDate, "formatTimeInMillisAsDate…1000, \"dd-MM-yyy, HH:mm\")");
                    actualStringOrRes = new TicketTimelineCardState.ActualStringOrRes.ActualString(formatTimeInMillisAsDate);
                } else if (Intrinsics.areEqual((Object) ticketAttribute2.getType(), (Object) "boolean")) {
                    actualStringOrRes = new TicketTimelineCardState.ActualStringOrRes.StringRes(SingleChoiceQuestionKt.booleanToQuestion(ticketAttribute2.getValue()));
                } else {
                    actualStringOrRes = new TicketTimelineCardState.ActualStringOrRes.ActualString(ticketAttribute2.getValue());
                }
                ticketAttribute = new TicketAttribute(ticketAttribute2.getName(), actualStringOrRes);
            } else {
                ticketAttribute = null;
            }
            if (ticketAttribute != null) {
                arrayList2.add(ticketAttribute);
            }
        }
        String email = userIdentity.getEmail();
        Intrinsics.checkNotNullExpressionValue(email, "user.email");
        return new TicketDetailState.TicketDetailContentState(title, ticketTimelineCardState, (List) arrayList2, email);
    }

    private static final boolean isUnassignedOrBot(Participant participant) {
        if (!Intrinsics.areEqual((Object) participant, (Object) Participant.create("", "", Participant.USER_TYPE, "", Avatar.create("", ""), false))) {
            Boolean isBot = participant.isBot();
            Intrinsics.checkNotNullExpressionValue(isBot, "this.isBot");
            return isBot.booleanValue();
        }
    }

    public static final boolean isDone(TicketStatus ticketStatus, TicketStatus ticketStatus2) {
        Intrinsics.checkNotNullParameter(ticketStatus, "<this>");
        Intrinsics.checkNotNullParameter(ticketStatus2, "currentTicketStatus");
        return ticketStatus2.ordinal() >= ticketStatus.ordinal();
    }

    public static final TicketStatus toTicketStatus(Ticket.Status status) {
        Intrinsics.checkNotNullParameter(status, "<this>");
        String type = status.getType();
        switch (type.hashCode()) {
            case -882067636:
                if (type.equals("waiting_on_customer")) {
                    return TicketStatus.WaitingOnCustomer;
                }
                break;
            case -753541113:
                if (type.equals("in_progress")) {
                    return TicketStatus.InProgress;
                }
                break;
            case -341328904:
                if (type.equals("resolved")) {
                    return TicketStatus.Resolved;
                }
                break;
            case 348678395:
                if (type.equals(MetricTracker.Action.SUBMITTED)) {
                    return TicketStatus.Submitted;
                }
                break;
        }
        return TicketStatus.Submitted;
    }
}
