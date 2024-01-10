package io.intercom.android.sdk.m5.components;

import io.intercom.android.sdk.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/m5/components/ErrorState;", "", "()V", "additionalMessageResId", "", "getAdditionalMessageResId", "()Ljava/lang/Integer;", "iconId", "getIconId", "()I", "messageResId", "getMessageResId", "WithCTA", "WithoutCTA", "Lio/intercom/android/sdk/m5/components/ErrorState$WithCTA;", "Lio/intercom/android/sdk/m5/components/ErrorState$WithoutCTA;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomErrorScreen.kt */
public abstract class ErrorState {
    public /* synthetic */ ErrorState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Integer getAdditionalMessageResId();

    public abstract int getIconId();

    public abstract int getMessageResId();

    private ErrorState() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JH\u0010\u0019\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lio/intercom/android/sdk/m5/components/ErrorState$WithCTA;", "Lio/intercom/android/sdk/m5/components/ErrorState;", "iconId", "", "messageResId", "additionalMessageResId", "ctaResId", "onCtaClick", "Lkotlin/Function0;", "", "(IILjava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "getAdditionalMessageResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCtaResId", "()I", "getIconId", "getMessageResId", "getOnCtaClick", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "copy", "(IILjava/lang/Integer;ILkotlin/jvm/functions/Function0;)Lio/intercom/android/sdk/m5/components/ErrorState$WithCTA;", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomErrorScreen.kt */
    public static final class WithCTA extends ErrorState {
        public static final int $stable = 0;
        private final Integer additionalMessageResId;
        private final int ctaResId;
        private final int iconId;
        private final int messageResId;
        private final Function0<Unit> onCtaClick;

        public static /* synthetic */ WithCTA copy$default(WithCTA withCTA, int i, int i2, Integer num, int i3, Function0<Unit> function0, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = withCTA.getIconId();
            }
            if ((i4 & 2) != 0) {
                i2 = withCTA.getMessageResId();
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                num = withCTA.getAdditionalMessageResId();
            }
            Integer num2 = num;
            if ((i4 & 8) != 0) {
                i3 = withCTA.ctaResId;
            }
            int i6 = i3;
            if ((i4 & 16) != 0) {
                function0 = withCTA.onCtaClick;
            }
            return withCTA.copy(i, i5, num2, i6, function0);
        }

        public final int component1() {
            return getIconId();
        }

        public final int component2() {
            return getMessageResId();
        }

        public final Integer component3() {
            return getAdditionalMessageResId();
        }

        public final int component4() {
            return this.ctaResId;
        }

        public final Function0<Unit> component5() {
            return this.onCtaClick;
        }

        public final WithCTA copy(int i, int i2, Integer num, int i3, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onCtaClick");
            return new WithCTA(i, i2, num, i3, function0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WithCTA)) {
                return false;
            }
            WithCTA withCTA = (WithCTA) obj;
            return getIconId() == withCTA.getIconId() && getMessageResId() == withCTA.getMessageResId() && Intrinsics.areEqual((Object) getAdditionalMessageResId(), (Object) withCTA.getAdditionalMessageResId()) && this.ctaResId == withCTA.ctaResId && Intrinsics.areEqual((Object) this.onCtaClick, (Object) withCTA.onCtaClick);
        }

        public int hashCode() {
            return (((((((getIconId() * 31) + getMessageResId()) * 31) + (getAdditionalMessageResId() == null ? 0 : getAdditionalMessageResId().hashCode())) * 31) + this.ctaResId) * 31) + this.onCtaClick.hashCode();
        }

        public String toString() {
            return "WithCTA(iconId=" + getIconId() + ", messageResId=" + getMessageResId() + ", additionalMessageResId=" + getAdditionalMessageResId() + ", ctaResId=" + this.ctaResId + ", onCtaClick=" + this.onCtaClick + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WithCTA(int i, int i2, Integer num, int i3, Function0 function0, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? R.drawable.intercom_ic_warning : i, (i4 & 2) != 0 ? R.string.intercom_spaces_error_title : i2, (i4 & 4) != 0 ? Integer.valueOf(R.string.intercom_spaces_error_description) : num, (i4 & 8) != 0 ? R.string.intercom_reload : i3, function0);
        }

        public int getIconId() {
            return this.iconId;
        }

        public int getMessageResId() {
            return this.messageResId;
        }

        public Integer getAdditionalMessageResId() {
            return this.additionalMessageResId;
        }

        public final int getCtaResId() {
            return this.ctaResId;
        }

        public final Function0<Unit> getOnCtaClick() {
            return this.onCtaClick;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithCTA(int i, int i2, Integer num, int i3, Function0<Unit> function0) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "onCtaClick");
            this.iconId = i;
            this.messageResId = i2;
            this.additionalMessageResId = num;
            this.ctaResId = i3;
            this.onCtaClick = function0;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0019"}, d2 = {"Lio/intercom/android/sdk/m5/components/ErrorState$WithoutCTA;", "Lio/intercom/android/sdk/m5/components/ErrorState;", "iconId", "", "messageResId", "additionalMessageResId", "(IILjava/lang/Integer;)V", "getAdditionalMessageResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconId", "()I", "getMessageResId", "component1", "component2", "component3", "copy", "(IILjava/lang/Integer;)Lio/intercom/android/sdk/m5/components/ErrorState$WithoutCTA;", "equals", "", "other", "", "hashCode", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomErrorScreen.kt */
    public static final class WithoutCTA extends ErrorState {
        public static final int $stable = 0;
        private final Integer additionalMessageResId;
        private final int iconId;
        private final int messageResId;

        public WithoutCTA() {
            this(0, 0, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ WithoutCTA copy$default(WithoutCTA withoutCTA, int i, int i2, Integer num, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = withoutCTA.getIconId();
            }
            if ((i3 & 2) != 0) {
                i2 = withoutCTA.getMessageResId();
            }
            if ((i3 & 4) != 0) {
                num = withoutCTA.getAdditionalMessageResId();
            }
            return withoutCTA.copy(i, i2, num);
        }

        public final int component1() {
            return getIconId();
        }

        public final int component2() {
            return getMessageResId();
        }

        public final Integer component3() {
            return getAdditionalMessageResId();
        }

        public final WithoutCTA copy(int i, int i2, Integer num) {
            return new WithoutCTA(i, i2, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WithoutCTA)) {
                return false;
            }
            WithoutCTA withoutCTA = (WithoutCTA) obj;
            return getIconId() == withoutCTA.getIconId() && getMessageResId() == withoutCTA.getMessageResId() && Intrinsics.areEqual((Object) getAdditionalMessageResId(), (Object) withoutCTA.getAdditionalMessageResId());
        }

        public int hashCode() {
            return (((getIconId() * 31) + getMessageResId()) * 31) + (getAdditionalMessageResId() == null ? 0 : getAdditionalMessageResId().hashCode());
        }

        public String toString() {
            return "WithoutCTA(iconId=" + getIconId() + ", messageResId=" + getMessageResId() + ", additionalMessageResId=" + getAdditionalMessageResId() + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WithoutCTA(int i, int i2, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? R.drawable.intercom_ic_warning : i, (i3 & 2) != 0 ? R.string.intercom_spaces_error_title : i2, (i3 & 4) != 0 ? Integer.valueOf(R.string.intercom_spaces_error_description) : num);
        }

        public int getIconId() {
            return this.iconId;
        }

        public int getMessageResId() {
            return this.messageResId;
        }

        public Integer getAdditionalMessageResId() {
            return this.additionalMessageResId;
        }

        public WithoutCTA(int i, int i2, Integer num) {
            super((DefaultConstructorMarker) null);
            this.iconId = i;
            this.messageResId = i2;
            this.additionalMessageResId = num;
        }
    }
}
