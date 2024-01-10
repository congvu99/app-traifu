package io.intercom.android.sdk.models;

import com.google.gson.annotations.SerializedName;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.models.Participant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lio/intercom/android/sdk/models/BotIntro;", "", "id", "", "operator", "Lio/intercom/android/sdk/models/Participant$Builder;", "blocks", "", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "(Ljava/lang/String;Lio/intercom/android/sdk/models/Participant$Builder;Ljava/util/List;)V", "getBlocks", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getOperator", "()Lio/intercom/android/sdk/models/Participant$Builder;", "component1", "component2", "component3", "copy", "equals", "", "other", "getBuiltParticipant", "Lio/intercom/android/sdk/models/Participant;", "hashCode", "", "toString", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BotIntro.kt */
public final class BotIntro {
    public static final BotIntro BOT_INTRO_NULL = new BotIntro("", new Participant.Builder(), CollectionsKt.emptyList());
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("parts")
    private final List<List<Block.Builder>> blocks;
    @SerializedName("id")
    private final String id;
    @SerializedName("operator")
    private final Participant.Builder operator;

    public BotIntro() {
        this((String) null, (Participant.Builder) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BotIntro copy$default(BotIntro botIntro, String str, Participant.Builder builder, List<List<Block.Builder>> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = botIntro.id;
        }
        if ((i & 2) != 0) {
            builder = botIntro.operator;
        }
        if ((i & 4) != 0) {
            list = botIntro.blocks;
        }
        return botIntro.copy(str, builder, list);
    }

    public final String component1() {
        return this.id;
    }

    public final Participant.Builder component2() {
        return this.operator;
    }

    public final List<List<Block.Builder>> component3() {
        return this.blocks;
    }

    public final BotIntro copy(String str, Participant.Builder builder, List<? extends List<Block.Builder>> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(builder, "operator");
        Intrinsics.checkNotNullParameter(list, "blocks");
        return new BotIntro(str, builder, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BotIntro)) {
            return false;
        }
        BotIntro botIntro = (BotIntro) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) botIntro.id) && Intrinsics.areEqual((Object) this.operator, (Object) botIntro.operator) && Intrinsics.areEqual((Object) this.blocks, (Object) botIntro.blocks);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.operator.hashCode()) * 31) + this.blocks.hashCode();
    }

    public String toString() {
        return "BotIntro(id=" + this.id + ", operator=" + this.operator + ", blocks=" + this.blocks + ')';
    }

    public BotIntro(String str, Participant.Builder builder, List<? extends List<Block.Builder>> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(builder, "operator");
        Intrinsics.checkNotNullParameter(list, "blocks");
        this.id = str;
        this.operator = builder;
        this.blocks = list;
    }

    public final String getId() {
        return this.id;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BotIntro(String str, Participant.Builder builder, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new Participant.Builder() : builder, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Participant.Builder getOperator() {
        return this.operator;
    }

    public final List<List<Block.Builder>> getBlocks() {
        return this.blocks;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/models/BotIntro$Companion;", "", "()V", "BOT_INTRO_NULL", "Lio/intercom/android/sdk/models/BotIntro;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BotIntro.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Participant getBuiltParticipant() {
        Participant build = this.operator.build();
        Intrinsics.checkNotNullExpressionValue(build, "operator.build()");
        return build;
    }
}
