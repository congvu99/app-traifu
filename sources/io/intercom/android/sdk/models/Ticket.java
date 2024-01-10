package io.intercom.android.sdk.models;

import androidx.core.app.FrameMetricsAggregator;
import com.brentvatne.react.ReactVideoView;
import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.models.Participant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u0000 /2\u00020\u0001:\u0003/01Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\nHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0010HÆ\u0003Jo\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000eHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00062"}, d2 = {"Lio/intercom/android/sdk/models/Ticket;", "", "title", "", "description", "iconUrl", "emoji", "currentStatus", "Lio/intercom/android/sdk/models/Ticket$Status;", "statusList", "", "attributes", "Lio/intercom/android/sdk/models/Ticket$TicketAttribute;", "ticketTypeId", "", "assignee", "Lio/intercom/android/sdk/models/Participant$Builder;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/intercom/android/sdk/models/Ticket$Status;Ljava/util/List;Ljava/util/List;ILio/intercom/android/sdk/models/Participant$Builder;)V", "getAssignee", "()Lio/intercom/android/sdk/models/Participant$Builder;", "getAttributes", "()Ljava/util/List;", "getCurrentStatus", "()Lio/intercom/android/sdk/models/Ticket$Status;", "getDescription", "()Ljava/lang/String;", "getEmoji", "getIconUrl", "getStatusList", "getTicketTypeId", "()I", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "Status", "TicketAttribute", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Ticket.kt */
public final class Ticket {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Ticket NULL = new Ticket((String) null, (String) null, (String) null, (String) null, (Status) null, (List) null, (List) null, 0, (Participant.Builder) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    @SerializedName("assignee")
    private final Participant.Builder assignee;
    @SerializedName("attributes")
    private final List<TicketAttribute> attributes;
    @SerializedName("current_status")
    private final Status currentStatus;
    @SerializedName("description")
    private final String description;
    @SerializedName("emoji")
    private final String emoji;
    @SerializedName("icon_url")
    private final String iconUrl;
    @SerializedName("status_list")
    private final List<Status> statusList;
    @SerializedName("ticket_type_id")
    private final int ticketTypeId;
    @SerializedName("title")
    private final String title;

    public Ticket() {
        this((String) null, (String) null, (String) null, (String) null, (Status) null, (List) null, (List) null, 0, (Participant.Builder) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Ticket copy$default(Ticket ticket, String str, String str2, String str3, String str4, Status status, List list, List list2, int i, Participant.Builder builder, int i2, Object obj) {
        Ticket ticket2 = ticket;
        int i3 = i2;
        return ticket.copy((i3 & 1) != 0 ? ticket2.title : str, (i3 & 2) != 0 ? ticket2.description : str2, (i3 & 4) != 0 ? ticket2.iconUrl : str3, (i3 & 8) != 0 ? ticket2.emoji : str4, (i3 & 16) != 0 ? ticket2.currentStatus : status, (i3 & 32) != 0 ? ticket2.statusList : list, (i3 & 64) != 0 ? ticket2.attributes : list2, (i3 & 128) != 0 ? ticket2.ticketTypeId : i, (i3 & 256) != 0 ? ticket2.assignee : builder);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final String component4() {
        return this.emoji;
    }

    public final Status component5() {
        return this.currentStatus;
    }

    public final List<Status> component6() {
        return this.statusList;
    }

    public final List<TicketAttribute> component7() {
        return this.attributes;
    }

    public final int component8() {
        return this.ticketTypeId;
    }

    public final Participant.Builder component9() {
        return this.assignee;
    }

    public final Ticket copy(String str, String str2, String str3, String str4, Status status, List<Status> list, List<TicketAttribute> list2, int i, Participant.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "iconUrl");
        Intrinsics.checkNotNullParameter(str4, "emoji");
        Status status2 = status;
        Intrinsics.checkNotNullParameter(status2, "currentStatus");
        List<Status> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "statusList");
        List<TicketAttribute> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "attributes");
        Participant.Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(builder2, "assignee");
        return new Ticket(str, str2, str3, str4, status2, list3, list4, i, builder2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ticket)) {
            return false;
        }
        Ticket ticket = (Ticket) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) ticket.title) && Intrinsics.areEqual((Object) this.description, (Object) ticket.description) && Intrinsics.areEqual((Object) this.iconUrl, (Object) ticket.iconUrl) && Intrinsics.areEqual((Object) this.emoji, (Object) ticket.emoji) && Intrinsics.areEqual((Object) this.currentStatus, (Object) ticket.currentStatus) && Intrinsics.areEqual((Object) this.statusList, (Object) ticket.statusList) && Intrinsics.areEqual((Object) this.attributes, (Object) ticket.attributes) && this.ticketTypeId == ticket.ticketTypeId && Intrinsics.areEqual((Object) this.assignee, (Object) ticket.assignee);
    }

    public int hashCode() {
        return (((((((((((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.emoji.hashCode()) * 31) + this.currentStatus.hashCode()) * 31) + this.statusList.hashCode()) * 31) + this.attributes.hashCode()) * 31) + this.ticketTypeId) * 31) + this.assignee.hashCode();
    }

    public String toString() {
        return "Ticket(title=" + this.title + ", description=" + this.description + ", iconUrl=" + this.iconUrl + ", emoji=" + this.emoji + ", currentStatus=" + this.currentStatus + ", statusList=" + this.statusList + ", attributes=" + this.attributes + ", ticketTypeId=" + this.ticketTypeId + ", assignee=" + this.assignee + ')';
    }

    public Ticket(String str, String str2, String str3, String str4, Status status, List<Status> list, List<TicketAttribute> list2, int i, Participant.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "iconUrl");
        Intrinsics.checkNotNullParameter(str4, "emoji");
        Intrinsics.checkNotNullParameter(status, "currentStatus");
        Intrinsics.checkNotNullParameter(list, "statusList");
        Intrinsics.checkNotNullParameter(list2, "attributes");
        Intrinsics.checkNotNullParameter(builder, "assignee");
        this.title = str;
        this.description = str2;
        this.iconUrl = str3;
        this.emoji = str4;
        this.currentStatus = status;
        this.statusList = list;
        this.attributes = list2;
        this.ticketTypeId = i;
        this.assignee = builder;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Ticket(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, io.intercom.android.sdk.models.Ticket.Status r20, java.util.List r21, java.util.List r22, int r23, io.intercom.android.sdk.models.Participant.Builder r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r15 = this;
            r0 = r25
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r16
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r17
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r18
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r2 = r19
        L_0x0023:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0037
            io.intercom.android.sdk.models.Ticket$Status r5 = new io.intercom.android.sdk.models.Ticket$Status
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 31
            r14 = 0
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11, r13, r14)
            goto L_0x0039
        L_0x0037:
            r5 = r20
        L_0x0039:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0042
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0044
        L_0x0042:
            r6 = r21
        L_0x0044:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004d
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x004f
        L_0x004d:
            r7 = r22
        L_0x004f:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0055
            r8 = 0
            goto L_0x0057
        L_0x0055:
            r8 = r23
        L_0x0057:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0061
            io.intercom.android.sdk.models.Participant$Builder r0 = new io.intercom.android.sdk.models.Participant$Builder
            r0.<init>()
            goto L_0x0063
        L_0x0061:
            r0 = r24
        L_0x0063:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r4
            r20 = r2
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.Ticket.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, io.intercom.android.sdk.models.Ticket$Status, java.util.List, java.util.List, int, io.intercom.android.sdk.models.Participant$Builder, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Status getCurrentStatus() {
        return this.currentStatus;
    }

    public final List<Status> getStatusList() {
        return this.statusList;
    }

    public final List<TicketAttribute> getAttributes() {
        return this.attributes;
    }

    public final int getTicketTypeId() {
        return this.ticketTypeId;
    }

    public final Participant.Builder getAssignee() {
        return this.assignee;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/intercom/android/sdk/models/Ticket$Status;", "", "title", "", "type", "statusDetail", "isCurrentStatus", "", "createdDate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getCreatedDate", "()J", "()Z", "getStatusDetail", "()Ljava/lang/String;", "getTitle", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Ticket.kt */
    public static final class Status {
        @SerializedName("created_date")
        private final long createdDate;
        @SerializedName("is_current_status")
        private final boolean isCurrentStatus;
        @SerializedName("status_detail")
        private final String statusDetail;
        @SerializedName("title")
        private final String title;
        @SerializedName("type")
        private final String type;

        public Status() {
            this((String) null, (String) null, (String) null, false, 0, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Status copy$default(Status status, String str, String str2, String str3, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = status.title;
            }
            if ((i & 2) != 0) {
                str2 = status.type;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                str3 = status.statusDetail;
            }
            String str5 = str3;
            if ((i & 8) != 0) {
                z = status.isCurrentStatus;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                j = status.createdDate;
            }
            return status.copy(str, str4, str5, z2, j);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.statusDetail;
        }

        public final boolean component4() {
            return this.isCurrentStatus;
        }

        public final long component5() {
            return this.createdDate;
        }

        public final Status copy(String str, String str2, String str3, boolean z, long j) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "type");
            Intrinsics.checkNotNullParameter(str3, "statusDetail");
            return new Status(str, str2, str3, z, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Status)) {
                return false;
            }
            Status status = (Status) obj;
            return Intrinsics.areEqual((Object) this.title, (Object) status.title) && Intrinsics.areEqual((Object) this.type, (Object) status.type) && Intrinsics.areEqual((Object) this.statusDetail, (Object) status.statusDetail) && this.isCurrentStatus == status.isCurrentStatus && this.createdDate == status.createdDate;
        }

        public int hashCode() {
            int hashCode = ((((this.title.hashCode() * 31) + this.type.hashCode()) * 31) + this.statusDetail.hashCode()) * 31;
            boolean z = this.isCurrentStatus;
            if (z) {
                z = true;
            }
            return ((hashCode + (z ? 1 : 0)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.createdDate);
        }

        public String toString() {
            return "Status(title=" + this.title + ", type=" + this.type + ", statusDetail=" + this.statusDetail + ", isCurrentStatus=" + this.isCurrentStatus + ", createdDate=" + this.createdDate + ')';
        }

        public Status(String str, String str2, String str3, boolean z, long j) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "type");
            Intrinsics.checkNotNullParameter(str3, "statusDetail");
            this.title = str;
            this.type = str2;
            this.statusDetail = str3;
            this.isCurrentStatus = z;
            this.createdDate = j;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Status(java.lang.String r4, java.lang.String r5, java.lang.String r6, boolean r7, long r8, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r3 = this;
                r11 = r10 & 1
                java.lang.String r0 = ""
                if (r11 == 0) goto L_0x0008
                r11 = r0
                goto L_0x0009
            L_0x0008:
                r11 = r4
            L_0x0009:
                r4 = r10 & 2
                if (r4 == 0) goto L_0x000f
                r1 = r0
                goto L_0x0010
            L_0x000f:
                r1 = r5
            L_0x0010:
                r4 = r10 & 4
                if (r4 == 0) goto L_0x0015
                goto L_0x0016
            L_0x0015:
                r0 = r6
            L_0x0016:
                r4 = r10 & 8
                if (r4 == 0) goto L_0x001d
                r7 = 0
                r2 = 0
                goto L_0x001e
            L_0x001d:
                r2 = r7
            L_0x001e:
                r4 = r10 & 16
                if (r4 == 0) goto L_0x0024
                r8 = 0
            L_0x0024:
                r9 = r8
                r4 = r3
                r5 = r11
                r6 = r1
                r7 = r0
                r8 = r2
                r4.<init>(r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.Ticket.Status.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final String getStatusDetail() {
            return this.statusDetail;
        }

        public final boolean isCurrentStatus() {
            return this.isCurrentStatus;
        }

        public final long getCreatedDate() {
            return this.createdDate;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lio/intercom/android/sdk/models/Ticket$TicketAttribute;", "", "id", "", "identifier", "name", "required", "", "type", "value", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIdentifier", "getName", "getRequired", "()Z", "getType", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Ticket.kt */
    public static final class TicketAttribute {
        public static final int $stable = 0;
        @SerializedName("id")
        private final String id;
        @SerializedName("identifier")
        private final String identifier;
        @SerializedName("name")
        private final String name;
        @SerializedName("required")
        private final boolean required;
        @SerializedName("type")
        private final String type;
        @SerializedName("value")
        private final String value;

        public TicketAttribute() {
            this((String) null, (String) null, (String) null, false, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ TicketAttribute copy$default(TicketAttribute ticketAttribute, String str, String str2, String str3, boolean z, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ticketAttribute.id;
            }
            if ((i & 2) != 0) {
                str2 = ticketAttribute.identifier;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = ticketAttribute.name;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                z = ticketAttribute.required;
            }
            boolean z2 = z;
            if ((i & 16) != 0) {
                str4 = ticketAttribute.type;
            }
            String str8 = str4;
            if ((i & 32) != 0) {
                str5 = ticketAttribute.value;
            }
            return ticketAttribute.copy(str, str6, str7, z2, str8, str5);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.identifier;
        }

        public final String component3() {
            return this.name;
        }

        public final boolean component4() {
            return this.required;
        }

        public final String component5() {
            return this.type;
        }

        public final String component6() {
            return this.value;
        }

        public final TicketAttribute copy(String str, String str2, String str3, boolean z, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "type");
            Intrinsics.checkNotNullParameter(str5, "value");
            return new TicketAttribute(str, str2, str3, z, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TicketAttribute)) {
                return false;
            }
            TicketAttribute ticketAttribute = (TicketAttribute) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) ticketAttribute.id) && Intrinsics.areEqual((Object) this.identifier, (Object) ticketAttribute.identifier) && Intrinsics.areEqual((Object) this.name, (Object) ticketAttribute.name) && this.required == ticketAttribute.required && Intrinsics.areEqual((Object) this.type, (Object) ticketAttribute.type) && Intrinsics.areEqual((Object) this.value, (Object) ticketAttribute.value);
        }

        public int hashCode() {
            int hashCode = ((((this.id.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.name.hashCode()) * 31;
            boolean z = this.required;
            if (z) {
                z = true;
            }
            return ((((hashCode + (z ? 1 : 0)) * 31) + this.type.hashCode()) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "TicketAttribute(id=" + this.id + ", identifier=" + this.identifier + ", name=" + this.name + ", required=" + this.required + ", type=" + this.type + ", value=" + this.value + ')';
        }

        public TicketAttribute(String str, String str2, String str3, boolean z, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
            Intrinsics.checkNotNullParameter(str3, "name");
            Intrinsics.checkNotNullParameter(str4, "type");
            Intrinsics.checkNotNullParameter(str5, "value");
            this.id = str;
            this.identifier = str2;
            this.name = str3;
            this.required = z;
            this.type = str4;
            this.value = str5;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TicketAttribute(java.lang.String r6, java.lang.String r7, java.lang.String r8, boolean r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                java.lang.String r0 = ""
                if (r13 == 0) goto L_0x0008
                r13 = r0
                goto L_0x0009
            L_0x0008:
                r13 = r6
            L_0x0009:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000f
                r1 = r0
                goto L_0x0010
            L_0x000f:
                r1 = r7
            L_0x0010:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0016
                r2 = r0
                goto L_0x0017
            L_0x0016:
                r2 = r8
            L_0x0017:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001e
                r9 = 0
                r3 = 0
                goto L_0x001f
            L_0x001e:
                r3 = r9
            L_0x001f:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0025
                r4 = r0
                goto L_0x0026
            L_0x0025:
                r4 = r10
            L_0x0026:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002c
                r12 = r0
                goto L_0x002d
            L_0x002c:
                r12 = r11
            L_0x002d:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.Ticket.TicketAttribute.<init>(java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getId() {
            return this.id;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final String getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/models/Ticket$Companion;", "", "()V", "NULL", "Lio/intercom/android/sdk/models/Ticket;", "getNULL", "()Lio/intercom/android/sdk/models/Ticket;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Ticket.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Ticket getNULL() {
            return Ticket.NULL;
        }
    }
}
