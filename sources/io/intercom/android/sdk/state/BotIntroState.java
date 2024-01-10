package io.intercom.android.sdk.state;

import io.intercom.android.sdk.models.BotIntro;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lio/intercom/android/sdk/state/BotIntroState;", "", "botIntro", "Lio/intercom/android/sdk/models/BotIntro;", "(Lio/intercom/android/sdk/models/BotIntro;)V", "getBotIntro", "()Lio/intercom/android/sdk/models/BotIntro;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BotIntroState.kt */
public final class BotIntroState {
    private final BotIntro botIntro;

    public BotIntroState() {
        this((BotIntro) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BotIntroState copy$default(BotIntroState botIntroState, BotIntro botIntro2, int i, Object obj) {
        if ((i & 1) != 0) {
            botIntro2 = botIntroState.botIntro;
        }
        return botIntroState.copy(botIntro2);
    }

    public final BotIntro component1() {
        return this.botIntro;
    }

    public final BotIntroState copy(BotIntro botIntro2) {
        Intrinsics.checkNotNullParameter(botIntro2, "botIntro");
        return new BotIntroState(botIntro2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BotIntroState) && Intrinsics.areEqual((Object) this.botIntro, (Object) ((BotIntroState) obj).botIntro);
    }

    public int hashCode() {
        return this.botIntro.hashCode();
    }

    public String toString() {
        return "BotIntroState(botIntro=" + this.botIntro + ')';
    }

    public BotIntroState(BotIntro botIntro2) {
        Intrinsics.checkNotNullParameter(botIntro2, "botIntro");
        this.botIntro = botIntro2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BotIntroState(BotIntro botIntro2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BotIntro.BOT_INTRO_NULL : botIntro2);
    }

    public final BotIntro getBotIntro() {
        return this.botIntro;
    }
}
