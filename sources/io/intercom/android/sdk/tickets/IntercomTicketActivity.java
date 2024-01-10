package io.intercom.android.sdk.tickets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/tickets/IntercomTicketActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ticketViewModel", "Lio/intercom/android/sdk/tickets/TicketDetailViewModel;", "getTicketViewModel", "()Lio/intercom/android/sdk/tickets/TicketDetailViewModel;", "ticketViewModel$delegate", "Lkotlin/Lazy;", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomTicketActivity.kt */
public final class IntercomTicketActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SHOW_SUBMISSION_CARD = "SHOW_SUBMISSION_CARD";
    private final Lazy ticketViewModel$delegate = LazyKt.lazy(new IntercomTicketActivity$ticketViewModel$2(this));

    /* access modifiers changed from: private */
    public final TicketDetailViewModel getTicketViewModel() {
        return (TicketDetailViewModel) this.ticketViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.intercom_composer_slide_up, R.anim.intercom_donothing);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-898780523, true, new IntercomTicketActivity$onCreate$1(this)), 1, (Object) null);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.intercom_donothing, R.anim.intercom_composer_slide_down);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/tickets/IntercomTicketActivity$Companion;", "", "()V", "SHOW_SUBMISSION_CARD", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "showSubmissionCard", "", "getShowSubmissionCardArgument", "intent", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomTicketActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createIntent(context, z);
        }

        public final Intent createIntent(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, IntercomTicketActivity.class);
            intent.putExtra(IntercomTicketActivity.SHOW_SUBMISSION_CARD, z);
            return intent;
        }

        public final boolean getShowSubmissionCardArgument(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            return intent.getBooleanExtra(IntercomTicketActivity.SHOW_SUBMISSION_CARD, false);
        }
    }
}
