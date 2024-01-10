package io.intercom.android.sdk.m5.components.intercombadge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState;", "", "()V", "Hidden", "Shown", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState$Hidden;", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState$Shown;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomBadgeStateReducer.kt */
public abstract class IntercomBadgeState {
    public /* synthetic */ IntercomBadgeState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState$Hidden;", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomBadgeStateReducer.kt */
    public static final class Hidden extends IntercomBadgeState {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    private IntercomBadgeState() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState$Shown;", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomBadgeStateReducer.kt */
    public static final class Shown extends IntercomBadgeState {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ Shown copy$default(Shown shown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = shown.url;
            }
            return shown.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final Shown copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new Shown(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Shown) && Intrinsics.areEqual((Object) this.url, (Object) ((Shown) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "Shown(url=" + this.url + ')';
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Shown(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.url = str;
        }
    }
}
