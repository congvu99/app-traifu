package io.intercom.android.sdk.tickets.create.ui;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.WindowCompat;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/tickets/create/ui/IntercomCreateTicketActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel;", "getViewModel", "()Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomCreateTicketActivity.kt */
public final class IntercomCreateTicketActivity extends AppCompatActivity {
    private final Lazy viewModel$delegate = LazyKt.lazy(new IntercomCreateTicketActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final CreateTicketViewModel getViewModel() {
        return (CreateTicketViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(2109426885, true, new IntercomCreateTicketActivity$onCreate$1(this)), 1, (Object) null);
    }
}
