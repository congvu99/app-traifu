package io.intercom.android.sdk.views.holder;

import androidx.compose.runtime.Composer;
import androidx.exifinterface.media.ExifInterface;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.SocialAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.views.holder.ComposableSingletons$TeamPresenceViewHolderKt$lambda-3$1  reason: invalid class name */
/* compiled from: TeamPresenceViewHolder.kt */
final class ComposableSingletons$TeamPresenceViewHolderKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TeamPresenceViewHolderKt$lambda3$1 INSTANCE = new ComposableSingletons$TeamPresenceViewHolderKt$lambda3$1();

    ComposableSingletons$TeamPresenceViewHolderKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TeamPresenceViewHolderKt.TeamPresenceAvatars(new TeamPresenceState(CollectionsKt.listOf(Avatar.create("", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS), Avatar.create("", "B"), Avatar.create("", "C")), "Typically replies in under 1m", "Send us a message and one of our teammates will be happy to help you", (String) null, (String) null, (GroupParticipants) null, (SocialAccount) null, 104, (DefaultConstructorMarker) null), composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
