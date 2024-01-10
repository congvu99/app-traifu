package io.intercom.android.sdk.tickets;

import android.content.Intent;
import android.view.Window;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.tickets.IntercomTicketActivity;
import io.intercom.android.sdk.tickets.TicketDetailState;
import io.intercom.android.sdk.utilities.ApplyStatusBarColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTicketActivity.kt */
final class IntercomTicketActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IntercomTicketActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomTicketActivity$onCreate$1(IntercomTicketActivity intercomTicketActivity) {
        super(2);
        this.this$0 = intercomTicketActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final IntercomTicketActivity intercomTicketActivity = this.this$0;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1539285569, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        ApplyStatusBarColorKt.m5394applyStatusBarColor4WTKRHQ(SystemUiControllerKt.rememberSystemUiController((Window) null, composer, 0, 1), MaterialTheme.INSTANCE.getColors(composer, 8).m1218getSurface0d7_KjU());
                        TicketDetailState value = SnapshotStateKt.collectAsState(intercomTicketActivity.getTicketViewModel().getStateFlow(), (CoroutineContext) null, composer, 8, 1).getValue();
                        if (!Intrinsics.areEqual((Object) value, (Object) TicketDetailState.Initial.INSTANCE) && (value instanceof TicketDetailState.TicketDetailContentState)) {
                            final IntercomTicketActivity intercomTicketActivity = intercomTicketActivity;
                            IntercomTicketActivity.Companion companion = IntercomTicketActivity.Companion;
                            Intent intent = intercomTicketActivity.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, SDKConstants.PARAM_INTENT);
                            TicketDetailScreenKt.TicketDetailScreen((TicketDetailState.TicketDetailContentState) value, new Function0<Unit>() {
                                public final void invoke() {
                                    intercomTicketActivity.finish();
                                }
                            }, companion.getShowSubmissionCardArgument(intent), composer, 8, 0);
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
