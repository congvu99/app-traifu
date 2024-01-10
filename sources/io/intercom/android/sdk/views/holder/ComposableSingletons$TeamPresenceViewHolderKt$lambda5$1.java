package io.intercom.android.sdk.views.holder;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.SocialAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.views.holder.ComposableSingletons$TeamPresenceViewHolderKt$lambda-5$1  reason: invalid class name */
/* compiled from: TeamPresenceViewHolder.kt */
final class ComposableSingletons$TeamPresenceViewHolderKt$lambda5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TeamPresenceViewHolderKt$lambda5$1 INSTANCE = new ComposableSingletons$TeamPresenceViewHolderKt$lambda5$1();

    ComposableSingletons$TeamPresenceViewHolderKt$lambda5$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Avatar create = Avatar.create("", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            GroupParticipants groupParticipants = new GroupParticipants(CollectionsKt.listOf(Avatar.create("", "B1"), Avatar.create("", "C2"), Avatar.create("", "B3"), Avatar.create("", "C4"), Avatar.create("", "B5"), Avatar.create("", "C6"), Avatar.create("", "B7"), Avatar.create("", "C8"), Avatar.create("", "B9"), Avatar.create("", "CC")), "Brian and 9 others are also participating");
            Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"A\")");
            TeamPresenceViewHolderKt.TeamPresenceAvatars(TeamPresenceViewHolderKt.getAdminTeamPresence(create, "Anna", "Job Title", "London", "UK", "", groupParticipants, (SocialAccount) null), composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
