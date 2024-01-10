package io.intercom.android.sdk.tickets;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0002*+BH\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u0019\u0010\u001e\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0012J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0016J`\u0010\"\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\rHÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketTimelineCardState;", "", "adminAvatars", "", "Lio/intercom/android/sdk/models/Avatar;", "statusTitle", "", "statusSubtitle", "progressColor", "Landroidx/compose/ui/graphics/Color;", "progressSections", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ProgressSection;", "statusLabel", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdminAvatars", "()Ljava/util/List;", "getProgressColor-0d7_KjU", "()J", "J", "getProgressSections", "getStatusLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusSubtitle", "()Ljava/lang/String;", "getStatusTitle", "component1", "component2", "component3", "component4", "component4-0d7_KjU", "component5", "component6", "copy", "copy-Bx497Mc", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/lang/Integer;)Lio/intercom/android/sdk/tickets/TicketTimelineCardState;", "equals", "", "other", "hashCode", "toString", "ActualStringOrRes", "ProgressSection", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TicketDetailState.kt */
public final class TicketTimelineCardState {
    private final List<Avatar> adminAvatars;
    private final long progressColor;
    private final List<ProgressSection> progressSections;
    private final Integer statusLabel;
    private final String statusSubtitle;
    private final String statusTitle;

    public /* synthetic */ TicketTimelineCardState(List list, String str, String str2, long j, List list2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, j, list2, num);
    }

    /* renamed from: copy-Bx497Mc$default  reason: not valid java name */
    public static /* synthetic */ TicketTimelineCardState m5383copyBx497Mc$default(TicketTimelineCardState ticketTimelineCardState, List<Avatar> list, String str, String str2, long j, List<ProgressSection> list2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ticketTimelineCardState.adminAvatars;
        }
        if ((i & 2) != 0) {
            str = ticketTimelineCardState.statusTitle;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = ticketTimelineCardState.statusSubtitle;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            j = ticketTimelineCardState.progressColor;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            list2 = ticketTimelineCardState.progressSections;
        }
        List<ProgressSection> list3 = list2;
        if ((i & 32) != 0) {
            num = ticketTimelineCardState.statusLabel;
        }
        return ticketTimelineCardState.m5385copyBx497Mc(list, str3, str4, j2, list3, num);
    }

    public final List<Avatar> component1() {
        return this.adminAvatars;
    }

    public final String component2() {
        return this.statusTitle;
    }

    public final String component3() {
        return this.statusSubtitle;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m5384component40d7_KjU() {
        return this.progressColor;
    }

    public final List<ProgressSection> component5() {
        return this.progressSections;
    }

    public final Integer component6() {
        return this.statusLabel;
    }

    /* renamed from: copy-Bx497Mc  reason: not valid java name */
    public final TicketTimelineCardState m5385copyBx497Mc(List<? extends Avatar> list, String str, String str2, long j, List<ProgressSection> list2, Integer num) {
        Intrinsics.checkNotNullParameter(list, "adminAvatars");
        Intrinsics.checkNotNullParameter(str, "statusTitle");
        Intrinsics.checkNotNullParameter(str2, "statusSubtitle");
        List<ProgressSection> list3 = list2;
        Intrinsics.checkNotNullParameter(list3, "progressSections");
        return new TicketTimelineCardState(list, str, str2, j, list3, num, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TicketTimelineCardState)) {
            return false;
        }
        TicketTimelineCardState ticketTimelineCardState = (TicketTimelineCardState) obj;
        return Intrinsics.areEqual((Object) this.adminAvatars, (Object) ticketTimelineCardState.adminAvatars) && Intrinsics.areEqual((Object) this.statusTitle, (Object) ticketTimelineCardState.statusTitle) && Intrinsics.areEqual((Object) this.statusSubtitle, (Object) ticketTimelineCardState.statusSubtitle) && Color.m1933equalsimpl0(this.progressColor, ticketTimelineCardState.progressColor) && Intrinsics.areEqual((Object) this.progressSections, (Object) ticketTimelineCardState.progressSections) && Intrinsics.areEqual((Object) this.statusLabel, (Object) ticketTimelineCardState.statusLabel);
    }

    public int hashCode() {
        int hashCode = ((((((((this.adminAvatars.hashCode() * 31) + this.statusTitle.hashCode()) * 31) + this.statusSubtitle.hashCode()) * 31) + Color.m1939hashCodeimpl(this.progressColor)) * 31) + this.progressSections.hashCode()) * 31;
        Integer num = this.statusLabel;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "TicketTimelineCardState(adminAvatars=" + this.adminAvatars + ", statusTitle=" + this.statusTitle + ", statusSubtitle=" + this.statusSubtitle + ", progressColor=" + Color.m1940toStringimpl(this.progressColor) + ", progressSections=" + this.progressSections + ", statusLabel=" + this.statusLabel + ')';
    }

    private TicketTimelineCardState(List<? extends Avatar> list, String str, String str2, long j, List<ProgressSection> list2, Integer num) {
        this.adminAvatars = list;
        this.statusTitle = str;
        this.statusSubtitle = str2;
        this.progressColor = j;
        this.progressSections = list2;
        this.statusLabel = num;
    }

    public final List<Avatar> getAdminAvatars() {
        return this.adminAvatars;
    }

    public final String getStatusTitle() {
        return this.statusTitle;
    }

    public final String getStatusSubtitle() {
        return this.statusSubtitle;
    }

    /* renamed from: getProgressColor-0d7_KjU  reason: not valid java name */
    public final long m5386getProgressColor0d7_KjU() {
        return this.progressColor;
    }

    public final List<ProgressSection> getProgressSections() {
        return this.progressSections;
    }

    public final Integer getStatusLabel() {
        return this.statusLabel;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ProgressSection;", "", "isDone", "", "title", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "timestamp", "", "isCurrentStatus", "(ZLio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;JZ)V", "()Z", "getTimestamp", "()J", "getTitle", "()Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketDetailState.kt */
    public static final class ProgressSection {
        public static final int $stable = 0;
        private final boolean isCurrentStatus;
        private final boolean isDone;
        private final long timestamp;
        private final ActualStringOrRes title;

        public static /* synthetic */ ProgressSection copy$default(ProgressSection progressSection, boolean z, ActualStringOrRes actualStringOrRes, long j, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = progressSection.isDone;
            }
            if ((i & 2) != 0) {
                actualStringOrRes = progressSection.title;
            }
            ActualStringOrRes actualStringOrRes2 = actualStringOrRes;
            if ((i & 4) != 0) {
                j = progressSection.timestamp;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                z2 = progressSection.isCurrentStatus;
            }
            return progressSection.copy(z, actualStringOrRes2, j2, z2);
        }

        public final boolean component1() {
            return this.isDone;
        }

        public final ActualStringOrRes component2() {
            return this.title;
        }

        public final long component3() {
            return this.timestamp;
        }

        public final boolean component4() {
            return this.isCurrentStatus;
        }

        public final ProgressSection copy(boolean z, ActualStringOrRes actualStringOrRes, long j, boolean z2) {
            Intrinsics.checkNotNullParameter(actualStringOrRes, "title");
            return new ProgressSection(z, actualStringOrRes, j, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProgressSection)) {
                return false;
            }
            ProgressSection progressSection = (ProgressSection) obj;
            return this.isDone == progressSection.isDone && Intrinsics.areEqual((Object) this.title, (Object) progressSection.title) && this.timestamp == progressSection.timestamp && this.isCurrentStatus == progressSection.isCurrentStatus;
        }

        public int hashCode() {
            boolean z = this.isDone;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int hashCode = (((((z ? 1 : 0) * true) + this.title.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.timestamp)) * 31;
            boolean z3 = this.isCurrentStatus;
            if (!z3) {
                z2 = z3;
            }
            return hashCode + (z2 ? 1 : 0);
        }

        public String toString() {
            return "ProgressSection(isDone=" + this.isDone + ", title=" + this.title + ", timestamp=" + this.timestamp + ", isCurrentStatus=" + this.isCurrentStatus + ')';
        }

        public ProgressSection(boolean z, ActualStringOrRes actualStringOrRes, long j, boolean z2) {
            Intrinsics.checkNotNullParameter(actualStringOrRes, "title");
            this.isDone = z;
            this.title = actualStringOrRes;
            this.timestamp = j;
            this.isCurrentStatus = z2;
        }

        public final boolean isDone() {
            return this.isDone;
        }

        public final ActualStringOrRes getTitle() {
            return this.title;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final boolean isCurrentStatus() {
            return this.isCurrentStatus;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "", "()V", "getText", "", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ActualString", "StringRes", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes$ActualString;", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes$StringRes;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TicketDetailState.kt */
    public static abstract class ActualStringOrRes {
        public static final int $stable = 0;

        public /* synthetic */ ActualStringOrRes(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ActualStringOrRes() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes$StringRes;", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "stringRes", "", "(I)V", "getStringRes", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: TicketDetailState.kt */
        public static final class StringRes extends ActualStringOrRes {
            public static final int $stable = 0;
            private final int stringRes;

            public static /* synthetic */ StringRes copy$default(StringRes stringRes2, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = stringRes2.stringRes;
                }
                return stringRes2.copy(i);
            }

            public final int component1() {
                return this.stringRes;
            }

            public final StringRes copy(int i) {
                return new StringRes(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof StringRes) && this.stringRes == ((StringRes) obj).stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return "StringRes(stringRes=" + this.stringRes + ')';
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public StringRes(int i) {
                super((DefaultConstructorMarker) null);
                this.stringRes = i;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes$ActualString;", "Lio/intercom/android/sdk/tickets/TicketTimelineCardState$ActualStringOrRes;", "string", "", "(Ljava/lang/String;)V", "getString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: TicketDetailState.kt */
        public static final class ActualString extends ActualStringOrRes {
            public static final int $stable = 0;
            private final String string;

            public static /* synthetic */ ActualString copy$default(ActualString actualString, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = actualString.string;
                }
                return actualString.copy(str);
            }

            public final String component1() {
                return this.string;
            }

            public final ActualString copy(String str) {
                Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
                return new ActualString(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ActualString) && Intrinsics.areEqual((Object) this.string, (Object) ((ActualString) obj).string);
            }

            public int hashCode() {
                return this.string.hashCode();
            }

            public String toString() {
                return "ActualString(string=" + this.string + ')';
            }

            public final String getString() {
                return this.string;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ActualString(String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
                this.string = str;
            }
        }

        public final String getText(Composer composer, int i) {
            String str;
            composer.startReplaceableGroup(796462681);
            ComposerKt.sourceInformation(composer, "C(getText)");
            if (this instanceof ActualString) {
                str = ((ActualString) this).getString();
            } else if (this instanceof StringRes) {
                str = StringResources_androidKt.stringResource(((StringRes) this).getStringRes(), composer, 0);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            composer.endReplaceableGroup();
            return str;
        }
    }
}
