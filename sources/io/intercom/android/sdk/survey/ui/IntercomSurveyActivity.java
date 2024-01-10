package io.intercom.android.sdk.survey.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.LifecycleOwnerKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.activities.IntercomBaseActivity;
import io.intercom.android.sdk.survey.SurveyLaunchMode;
import io.intercom.android.sdk.survey.SurveyViewModel;
import io.intercom.android.sdk.utilities.PhoneNumberValidator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0014R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lio/intercom/android/sdk/survey/ui/IntercomSurveyActivity;", "Lio/intercom/android/sdk/activities/IntercomBaseActivity;", "()V", "injector", "Lio/intercom/android/sdk/Injector;", "kotlin.jvm.PlatformType", "viewModel", "Lio/intercom/android/sdk/survey/SurveyViewModel;", "getViewModel", "()Lio/intercom/android/sdk/survey/SurveyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createVM", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomSurveyActivity.kt */
public final class IntercomSurveyActivity extends IntercomBaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARCEL_SURVEY_ID = "parcel_survey_id";
    /* access modifiers changed from: private */
    public final Injector injector = Injector.get();
    private final Lazy viewModel$delegate = LazyKt.lazy(new IntercomSurveyActivity$viewModel$2(this));

    @JvmStatic
    public static final Intent buildIntent(Context context) {
        return Companion.buildIntent(context);
    }

    @JvmStatic
    public static final Intent buildIntent(Context context, String str) {
        return Companion.buildIntent(context, str);
    }

    public void onBackPressed() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/survey/ui/IntercomSurveyActivity$Companion;", "", "()V", "PARCEL_SURVEY_ID", "", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "surveyId", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntercomSurveyActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Intent buildIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return buildIntent$default(this, context, (String) null, 2, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Intent buildIntent$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.buildIntent(context, str);
        }

        @JvmStatic
        public final Intent buildIntent(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, IntercomSurveyActivity.class);
            intent.putExtra(IntercomSurveyActivity.PARCEL_SURVEY_ID, str);
            intent.setFlags(268435456);
            return intent;
        }
    }

    /* access modifiers changed from: private */
    public final SurveyViewModel getViewModel() {
        return (SurveyViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SurveyViewModel createVM() {
        SurveyLaunchMode surveyLaunchMode;
        String stringExtra = getIntent().getStringExtra(PARCEL_SURVEY_ID);
        if (stringExtra != null) {
            surveyLaunchMode = new SurveyLaunchMode.Programmatic(stringExtra);
        } else {
            surveyLaunchMode = new SurveyLaunchMode.Automatic(this.injector.getStore().state().surveyState().getSurveyData());
        }
        return SurveyViewModel.Companion.create(this, surveyLaunchMode);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PhoneNumberValidator.loadCountryAreaCodes(this);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-179321000, true, new IntercomSurveyActivity$onCreate$1(this)), 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new IntercomSurveyActivity$onStart$1(this, (Continuation<? super IntercomSurveyActivity$onStart$1>) null), 3, (Object) null);
        getViewModel().onUiLoaded();
    }
}
