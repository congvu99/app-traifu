package io.intercom.android.sdk.inbox;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"lastActionCreatedAt", "", "Lio/intercom/android/sdk/models/Conversation;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomInboxViewModel.kt */
public final class IntercomInboxViewModelKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: io.intercom.android.sdk.models.Ticket$Status} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long lastActionCreatedAt(io.intercom.android.sdk.models.Conversation r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            io.intercom.android.sdk.models.Part r0 = r7.getLastPart()
            io.intercom.android.sdk.models.Part r1 = io.intercom.android.sdk.models.Part.NULL
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 != 0) goto L_0x001a
            io.intercom.android.sdk.models.Part r7 = r7.getLastPart()
            long r0 = r7.getCreatedAt()
            goto L_0x0066
        L_0x001a:
            io.intercom.android.sdk.models.Ticket r7 = r7.getTicket()
            java.util.List r7 = r7.getStatusList()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            boolean r0 = r7.hasNext()
            if (r0 != 0) goto L_0x0030
            r7 = 0
            goto L_0x005b
        L_0x0030:
            java.lang.Object r0 = r7.next()
            boolean r1 = r7.hasNext()
            if (r1 != 0) goto L_0x003c
        L_0x003a:
            r7 = r0
            goto L_0x005b
        L_0x003c:
            r1 = r0
            io.intercom.android.sdk.models.Ticket$Status r1 = (io.intercom.android.sdk.models.Ticket.Status) r1
            long r1 = r1.getCreatedDate()
        L_0x0043:
            java.lang.Object r3 = r7.next()
            r4 = r3
            io.intercom.android.sdk.models.Ticket$Status r4 = (io.intercom.android.sdk.models.Ticket.Status) r4
            long r4 = r4.getCreatedDate()
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0054
            r0 = r3
            r1 = r4
        L_0x0054:
            boolean r3 = r7.hasNext()
            if (r3 != 0) goto L_0x0043
            goto L_0x003a
        L_0x005b:
            io.intercom.android.sdk.models.Ticket$Status r7 = (io.intercom.android.sdk.models.Ticket.Status) r7
            if (r7 == 0) goto L_0x0064
            long r0 = r7.getCreatedDate()
            goto L_0x0066
        L_0x0064:
            r0 = 0
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.inbox.IntercomInboxViewModelKt.lastActionCreatedAt(io.intercom.android.sdk.models.Conversation):long");
    }
}
