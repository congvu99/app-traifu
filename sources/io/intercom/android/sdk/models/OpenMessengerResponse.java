package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.models.ComposerSuggestions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/models/OpenMessengerResponse;", "", "composerSuggestions", "Lio/intercom/android/sdk/models/ComposerSuggestions$Builder;", "(Lio/intercom/android/sdk/models/ComposerSuggestions$Builder;)V", "getComposerSuggestions", "()Lio/intercom/android/sdk/models/ComposerSuggestions$Builder;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OpenMessengerResponse.kt */
public final class OpenMessengerResponse {
    @SerializedName("composer_suggestions")
    private final ComposerSuggestions.Builder composerSuggestions;

    public OpenMessengerResponse() {
        this((ComposerSuggestions.Builder) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OpenMessengerResponse copy$default(OpenMessengerResponse openMessengerResponse, ComposerSuggestions.Builder builder, int i, Object obj) {
        if ((i & 1) != 0) {
            builder = openMessengerResponse.composerSuggestions;
        }
        return openMessengerResponse.copy(builder);
    }

    public final ComposerSuggestions.Builder component1() {
        return this.composerSuggestions;
    }

    public final OpenMessengerResponse copy(ComposerSuggestions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "composerSuggestions");
        return new OpenMessengerResponse(builder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OpenMessengerResponse) && Intrinsics.areEqual((Object) this.composerSuggestions, (Object) ((OpenMessengerResponse) obj).composerSuggestions);
    }

    public int hashCode() {
        return this.composerSuggestions.hashCode();
    }

    public String toString() {
        return "OpenMessengerResponse(composerSuggestions=" + this.composerSuggestions + ')';
    }

    public OpenMessengerResponse(ComposerSuggestions.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "composerSuggestions");
        this.composerSuggestions = builder;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OpenMessengerResponse(ComposerSuggestions.Builder builder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ComposerSuggestions.Builder() : builder);
    }

    public final ComposerSuggestions.Builder getComposerSuggestions() {
        return this.composerSuggestions;
    }
}
