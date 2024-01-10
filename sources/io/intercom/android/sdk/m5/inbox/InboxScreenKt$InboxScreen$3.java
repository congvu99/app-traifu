package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.StringResources_androidKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.TopActionBarKt;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function0<Unit> $onBackButtonClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$3(Function0<Unit> function0, int i) {
        super(2);
        this.$onBackButtonClick = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Composer composer2 = composer;
            TopActionBarKt.m5180TopActionBar6oU6zVQ((Modifier) null, StringResources_androidKt.stringResource(R.string.intercom_messages_space_title, composer2, 0), (String) null, (List<? extends Avatar>) null, this.$onBackButtonClick, (Painter) null, false, 0, 0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, composer2, (this.$$dirty << 3) & 57344, WebSocketProtocol.CLOSE_NO_STATUS_CODE);
            return;
        }
        composer.skipToGroupEnd();
    }
}
