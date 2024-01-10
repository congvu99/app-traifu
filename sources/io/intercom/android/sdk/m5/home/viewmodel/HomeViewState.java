package io.intercom.android.sdk.m5.home.viewmodel;

import io.intercom.android.sdk.m5.components.ErrorState;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "", "()V", "Content", "Error", "Initial", "Loading", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Content;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Error;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Initial;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Loading;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeViewModel.kt */
public abstract class HomeViewState {
    public /* synthetic */ HomeViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Initial;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class Initial extends HomeViewState {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    private HomeViewState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Loading;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class Loading extends HomeViewState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Content;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "cards", "", "Lio/intercom/android/sdk/m5/home/data/HomeCards;", "(Ljava/util/List;)V", "getCards", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class Content extends HomeViewState {
        public static final int $stable = 8;
        private final List<HomeCards> cards;

        public static /* synthetic */ Content copy$default(Content content, List<HomeCards> list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.cards;
            }
            return content.copy(list);
        }

        public final List<HomeCards> component1() {
            return this.cards;
        }

        public final Content copy(List<? extends HomeCards> list) {
            Intrinsics.checkNotNullParameter(list, "cards");
            return new Content(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Content) && Intrinsics.areEqual((Object) this.cards, (Object) ((Content) obj).cards);
        }

        public int hashCode() {
            return this.cards.hashCode();
        }

        public String toString() {
            return "Content(cards=" + this.cards + ')';
        }

        public final List<HomeCards> getCards() {
            return this.cards;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(List<? extends HomeCards> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "cards");
            this.cards = list;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState$Error;", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;", "errorState", "Lio/intercom/android/sdk/m5/components/ErrorState;", "(Lio/intercom/android/sdk/m5/components/ErrorState;)V", "getErrorState", "()Lio/intercom/android/sdk/m5/components/ErrorState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeViewModel.kt */
    public static final class Error extends HomeViewState {
        public static final int $stable = 0;
        private final ErrorState errorState;

        public static /* synthetic */ Error copy$default(Error error, ErrorState errorState2, int i, Object obj) {
            if ((i & 1) != 0) {
                errorState2 = error.errorState;
            }
            return error.copy(errorState2);
        }

        public final ErrorState component1() {
            return this.errorState;
        }

        public final Error copy(ErrorState errorState2) {
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            return new Error(errorState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual((Object) this.errorState, (Object) ((Error) obj).errorState);
        }

        public int hashCode() {
            return this.errorState.hashCode();
        }

        public String toString() {
            return "Error(errorState=" + this.errorState + ')';
        }

        public final ErrorState getErrorState() {
            return this.errorState;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(ErrorState errorState2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorState2, "errorState");
            this.errorState = errorState2;
        }
    }
}
