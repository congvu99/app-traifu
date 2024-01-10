package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/tooling/data/Group;", "invoke", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
final class ComposeViewAdapter$findAndTrackTransitions$1$2 extends Lambda implements Function1<Group, Boolean> {
    public static final ComposeViewAdapter$findAndTrackTransitions$1$2 INSTANCE = new ComposeViewAdapter$findAndTrackTransitions$1$2();

    ComposeViewAdapter$findAndTrackTransitions$1$2() {
        super(1);
    }

    public final Boolean invoke(Group group) {
        Intrinsics.checkNotNullParameter(group, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) group.getName(), (Object) "AnimatedVisibility") && group.getLocation() != null);
    }
}
