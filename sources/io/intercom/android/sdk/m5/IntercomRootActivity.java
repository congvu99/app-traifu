package io.intercom.android.sdk.m5;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomRootActivity;", "Landroidx/activity/ComponentActivity;", "()V", "confirmStateChange", "", "value", "Landroidx/compose/material/ModalBottomSheetValue;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
public final class IntercomRootActivity extends ComponentActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(1535831366, true, new IntercomRootActivity$onCreate$1(this)), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean confirmStateChange(ModalBottomSheetValue modalBottomSheetValue) {
        if (modalBottomSheetValue != ModalBottomSheetValue.Hidden) {
            return true;
        }
        finish();
        return true;
    }
}
