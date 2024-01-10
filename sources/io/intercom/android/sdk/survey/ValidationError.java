package io.intercom.android.sdk.survey;

import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lio/intercom/android/sdk/survey/ValidationError;", "", "()V", "NoValidationError", "Unchecked", "ValidationStringError", "Lio/intercom/android/sdk/survey/ValidationError$NoValidationError;", "Lio/intercom/android/sdk/survey/ValidationError$Unchecked;", "Lio/intercom/android/sdk/survey/ValidationError$ValidationStringError;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public abstract class ValidationError {
    public /* synthetic */ ValidationError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ValidationError$Unchecked;", "Lio/intercom/android/sdk/survey/ValidationError;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Unchecked extends ValidationError {
        public static final int $stable = 0;
        public static final Unchecked INSTANCE = new Unchecked();

        private Unchecked() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ValidationError() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001b\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u001a\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lio/intercom/android/sdk/survey/ValidationError$ValidationStringError;", "Lio/intercom/android/sdk/survey/ValidationError;", "stringRes", "", "params", "", "Lkotlin/Pair;", "", "(ILjava/util/List;)V", "getParams", "()Ljava/util/List;", "getStringRes", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class ValidationStringError extends ValidationError {
        public static final int $stable = 8;
        private final List<Pair<String, String>> params;
        private final int stringRes;

        public static /* synthetic */ ValidationStringError copy$default(ValidationStringError validationStringError, int i, List<Pair<String, String>> list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = validationStringError.stringRes;
            }
            if ((i2 & 2) != 0) {
                list = validationStringError.params;
            }
            return validationStringError.copy(i, list);
        }

        public final int component1() {
            return this.stringRes;
        }

        public final List<Pair<String, String>> component2() {
            return this.params;
        }

        public final ValidationStringError copy(int i, List<Pair<String, String>> list) {
            Intrinsics.checkNotNullParameter(list, NativeProtocol.WEB_DIALOG_PARAMS);
            return new ValidationStringError(i, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ValidationStringError)) {
                return false;
            }
            ValidationStringError validationStringError = (ValidationStringError) obj;
            return this.stringRes == validationStringError.stringRes && Intrinsics.areEqual((Object) this.params, (Object) validationStringError.params);
        }

        public int hashCode() {
            return (this.stringRes * 31) + this.params.hashCode();
        }

        public String toString() {
            return "ValidationStringError(stringRes=" + this.stringRes + ", params=" + this.params + ')';
        }

        public final int getStringRes() {
            return this.stringRes;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ValidationStringError(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Pair<String, String>> getParams() {
            return this.params;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValidationStringError(int i, List<Pair<String, String>> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, NativeProtocol.WEB_DIALOG_PARAMS);
            this.stringRes = i;
            this.params = list;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/survey/ValidationError$NoValidationError;", "Lio/intercom/android/sdk/survey/ValidationError;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class NoValidationError extends ValidationError {
        public static final int $stable = 0;
        public static final NoValidationError INSTANCE = new NoValidationError();

        private NoValidationError() {
            super((DefaultConstructorMarker) null);
        }
    }
}
