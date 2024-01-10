package io.intercom.android.sdk.m5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "Landroid/os/Parcelable;", "()V", "route", "", "getRoute", "()Ljava/lang/String;", "HelpCenterCollection", "HelpCenterCollections", "HomeScreen", "MessagesScreen", "NoContent", "Lio/intercom/android/sdk/m5/IntercomScreenScenario$HelpCenterCollection;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario$HelpCenterCollections;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario$HomeScreen;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario$MessagesScreen;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario$NoContent;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivityLauncher.kt */
public abstract class IntercomScreenScenario implements Parcelable {
    public /* synthetic */ IntercomScreenScenario(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getRoute();

    private IntercomScreenScenario() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario$HomeScreen;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "()V", "route", "", "getRoute", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomRootActivityLauncher.kt */
    public static final class HomeScreen extends IntercomScreenScenario {
        public static final int $stable = 8;
        public static final Parcelable.Creator<HomeScreen> CREATOR = new Creator();
        public static final HomeScreen INSTANCE = new HomeScreen();

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: IntercomRootActivityLauncher.kt */
        public static final class Creator implements Parcelable.Creator<HomeScreen> {
            public final HomeScreen createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return HomeScreen.INSTANCE;
            }

            public final HomeScreen[] newArray(int i) {
                return new HomeScreen[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private HomeScreen() {
            super((DefaultConstructorMarker) null);
        }

        public String getRoute() {
            return IntercomDestination.HOME.name();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario$MessagesScreen;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "()V", "route", "", "getRoute", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomRootActivityLauncher.kt */
    public static final class MessagesScreen extends IntercomScreenScenario {
        public static final int $stable = 8;
        public static final Parcelable.Creator<MessagesScreen> CREATOR = new Creator();
        public static final MessagesScreen INSTANCE = new MessagesScreen();

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: IntercomRootActivityLauncher.kt */
        public static final class Creator implements Parcelable.Creator<MessagesScreen> {
            public final MessagesScreen createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return MessagesScreen.INSTANCE;
            }

            public final MessagesScreen[] newArray(int i) {
                return new MessagesScreen[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private MessagesScreen() {
            super((DefaultConstructorMarker) null);
        }

        public String getRoute() {
            return IntercomDestination.MESSAGES.name();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u001d"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario$HelpCenterCollections;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "collectionIds", "", "", "metricPlace", "(Ljava/util/List;Ljava/lang/String;)V", "getCollectionIds", "()Ljava/util/List;", "getMetricPlace", "()Ljava/lang/String;", "route", "getRoute", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomRootActivityLauncher.kt */
    public static final class HelpCenterCollections extends IntercomScreenScenario {
        public static final int $stable = 8;
        public static final Parcelable.Creator<HelpCenterCollections> CREATOR = new Creator();
        private final List<String> collectionIds;
        private final String metricPlace;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: IntercomRootActivityLauncher.kt */
        public static final class Creator implements Parcelable.Creator<HelpCenterCollections> {
            public final HelpCenterCollections createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HelpCenterCollections(parcel.createStringArrayList(), parcel.readString());
            }

            public final HelpCenterCollections[] newArray(int i) {
                return new HelpCenterCollections[i];
            }
        }

        public static /* synthetic */ HelpCenterCollections copy$default(HelpCenterCollections helpCenterCollections, List<String> list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = helpCenterCollections.collectionIds;
            }
            if ((i & 2) != 0) {
                str = helpCenterCollections.metricPlace;
            }
            return helpCenterCollections.copy(list, str);
        }

        public final List<String> component1() {
            return this.collectionIds;
        }

        public final String component2() {
            return this.metricPlace;
        }

        public final HelpCenterCollections copy(List<String> list, String str) {
            Intrinsics.checkNotNullParameter(list, "collectionIds");
            Intrinsics.checkNotNullParameter(str, "metricPlace");
            return new HelpCenterCollections(list, str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HelpCenterCollections)) {
                return false;
            }
            HelpCenterCollections helpCenterCollections = (HelpCenterCollections) obj;
            return Intrinsics.areEqual((Object) this.collectionIds, (Object) helpCenterCollections.collectionIds) && Intrinsics.areEqual((Object) this.metricPlace, (Object) helpCenterCollections.metricPlace);
        }

        public int hashCode() {
            return (this.collectionIds.hashCode() * 31) + this.metricPlace.hashCode();
        }

        public String toString() {
            return "HelpCenterCollections(collectionIds=" + this.collectionIds + ", metricPlace=" + this.metricPlace + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeStringList(this.collectionIds);
            parcel.writeString(this.metricPlace);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HelpCenterCollections(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, str);
        }

        public final List<String> getCollectionIds() {
            return this.collectionIds;
        }

        public final String getMetricPlace() {
            return this.metricPlace;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HelpCenterCollections(List<String> list, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "collectionIds");
            Intrinsics.checkNotNullParameter(str, "metricPlace");
            this.collectionIds = list;
            this.metricPlace = str;
        }

        public String getRoute() {
            return IntercomDestination.HELP_CENTER.name();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007¨\u0006\u001b"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario$HelpCenterCollection;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "collectionId", "", "metricPlace", "(Ljava/lang/String;Ljava/lang/String;)V", "getCollectionId", "()Ljava/lang/String;", "getMetricPlace", "route", "getRoute", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomRootActivityLauncher.kt */
    public static final class HelpCenterCollection extends IntercomScreenScenario {
        public static final int $stable = 8;
        public static final Parcelable.Creator<HelpCenterCollection> CREATOR = new Creator();
        private final String collectionId;
        private final String metricPlace;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: IntercomRootActivityLauncher.kt */
        public static final class Creator implements Parcelable.Creator<HelpCenterCollection> {
            public final HelpCenterCollection createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HelpCenterCollection(parcel.readString(), parcel.readString());
            }

            public final HelpCenterCollection[] newArray(int i) {
                return new HelpCenterCollection[i];
            }
        }

        public static /* synthetic */ HelpCenterCollection copy$default(HelpCenterCollection helpCenterCollection, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = helpCenterCollection.collectionId;
            }
            if ((i & 2) != 0) {
                str2 = helpCenterCollection.metricPlace;
            }
            return helpCenterCollection.copy(str, str2);
        }

        public final String component1() {
            return this.collectionId;
        }

        public final String component2() {
            return this.metricPlace;
        }

        public final HelpCenterCollection copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "collectionId");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            return new HelpCenterCollection(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HelpCenterCollection)) {
                return false;
            }
            HelpCenterCollection helpCenterCollection = (HelpCenterCollection) obj;
            return Intrinsics.areEqual((Object) this.collectionId, (Object) helpCenterCollection.collectionId) && Intrinsics.areEqual((Object) this.metricPlace, (Object) helpCenterCollection.metricPlace);
        }

        public int hashCode() {
            return (this.collectionId.hashCode() * 31) + this.metricPlace.hashCode();
        }

        public String toString() {
            return "HelpCenterCollection(collectionId=" + this.collectionId + ", metricPlace=" + this.metricPlace + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.collectionId);
            parcel.writeString(this.metricPlace);
        }

        public final String getCollectionId() {
            return this.collectionId;
        }

        public final String getMetricPlace() {
            return this.metricPlace;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HelpCenterCollection(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "collectionId");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            this.collectionId = str;
            this.metricPlace = str2;
        }

        public String getRoute() {
            return IntercomDestination.HELP_CENTER.name();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomScreenScenario$NoContent;", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "()V", "route", "", "getRoute", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomRootActivityLauncher.kt */
    public static final class NoContent extends IntercomScreenScenario {
        public static final int $stable = 8;
        public static final Parcelable.Creator<NoContent> CREATOR = new Creator();
        public static final NoContent INSTANCE = new NoContent();

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: IntercomRootActivityLauncher.kt */
        public static final class Creator implements Parcelable.Creator<NoContent> {
            public final NoContent createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return NoContent.INSTANCE;
            }

            public final NoContent[] newArray(int i) {
                return new NoContent[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public String getRoute() {
            return "";
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private NoContent() {
            super((DefaultConstructorMarker) null);
        }
    }
}
