package io.intercom.android.sdk.m5.inbox;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.home.screens.HomeLoadingContentKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"HomeLoadingContentPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "InboxLoadingScreen", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxLoadingScreen.kt */
public final class InboxLoadingScreenKt {
    public static final void InboxLoadingScreen(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-469887068);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            HomeLoadingContentKt.HomeLoadingContent((Modifier) null, R.drawable.intercom_inbox_loading_state, startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxLoadingScreenKt$InboxLoadingScreen$1(i));
        }
    }

    public static final void HomeLoadingContentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-916861710);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            InboxLoadingScreen(startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxLoadingScreenKt$HomeLoadingContentPreview$1(i));
        }
    }
}
