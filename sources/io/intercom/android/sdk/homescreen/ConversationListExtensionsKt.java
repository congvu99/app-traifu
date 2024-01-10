package io.intercom.android.sdk.homescreen;

import io.intercom.android.sdk.models.Conversation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0000\u001a \u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0000\u001a\u001a\u0010\r\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"MAX_CONVERSATIONS_TO_DISPLAY", "", "THREE_DAYS_MILLISECONDS", "", "filterRecentConversations", "", "Lio/intercom/android/sdk/models/Conversation;", "currentTime", "preventMultipleInbound", "", "hasOlderUnreadConversations", "unReadConversationIds", "", "hasRecentInboundConversation", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationListExtensions.kt */
public final class ConversationListExtensionsKt {
    private static final int MAX_CONVERSATIONS_TO_DISPLAY = 3;
    private static final long THREE_DAYS_MILLISECONDS = 259200000;

    public static final List<Conversation> filterRecentConversations(List<? extends Conversation> list, long j, boolean z) {
        List list2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        long j2 = j - THREE_DAYS_MILLISECONDS;
        if (z) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object next : CollectionsKt.sortedWith(list, new ConversationListExtensionsKt$filterRecentConversations$$inlined$sortedByDescending$1())) {
                if (((Conversation) next).isRecentInboundConversation(j)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            Collection collection = (List) pair.component1();
            Collection arrayList3 = new ArrayList();
            for (Object next2 : (List) pair.component2()) {
                if (((Conversation) next2).createdSince(j2)) {
                    arrayList3.add(next2);
                }
            }
            list2 = CollectionsKt.plus(collection, (List) arrayList3);
        } else {
            Collection arrayList4 = new ArrayList();
            for (Object next3 : list) {
                if (((Conversation) next3).createdSince(j2)) {
                    arrayList4.add(next3);
                }
            }
            list2 = (List) arrayList4;
        }
        return CollectionsKt.take(list2, 3);
    }

    public static final boolean hasOlderUnreadConversations(List<? extends Conversation> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "unReadConversationIds");
        Iterable set = CollectionsKt.toSet(list2);
        Iterable<Conversation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Conversation id : iterable) {
            arrayList.add(id.getId());
        }
        return !CollectionsKt.subtract(set, (List) arrayList).isEmpty();
    }

    public static final boolean hasRecentInboundConversation(List<? extends Conversation> list, long j) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<Conversation> iterable = list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Conversation isRecentInboundConversation : iterable) {
            if (isRecentInboundConversation.isRecentInboundConversation(j)) {
                return true;
            }
        }
        return false;
    }
}
