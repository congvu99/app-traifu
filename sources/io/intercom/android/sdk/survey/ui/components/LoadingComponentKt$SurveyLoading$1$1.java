package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import com.facebook.shimmer.ShimmerFrameLayout;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.survey.SurveyState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoadingComponent.kt */
final class LoadingComponentKt$SurveyLoading$1$1 extends Lambda implements Function1<Context, ShimmerFrameLayout> {
    final /* synthetic */ SurveyState.Loading $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadingComponentKt$SurveyLoading$1$1(SurveyState.Loading loading) {
        super(1);
        this.$state = loading;
    }

    public final ShimmerFrameLayout invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShimmerFrameLayout buildLoadingContainer = LoadingComponentKt.buildLoadingContainer(context);
        buildLoadingContainer.addView(LoadingComponentKt.m5310buildLoadingContentbw27NRU(context, this.$state.getSurveyUiColors().m5277getOnBackground0d7_KjU(), R.drawable.intercom_survey_loading_state));
        return buildLoadingContainer;
    }
}
