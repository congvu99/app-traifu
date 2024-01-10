package io.intercom.android.sdk.survey;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.ValidationError;
import io.intercom.android.sdk.survey.model.SubmitSurveyRequestItem;
import io.intercom.android.sdk.survey.model.SurveyData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 =2\u00020\u0001:\u0001=BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J\b\u0010*\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020%H\u0002J\u0006\u0010/\u001a\u00020'J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020'2\u0006\u00104\u001a\u000205J\u0006\u00106\u001a\u00020'J!\u00107\u001a\u00020'2\u0006\u0010,\u001a\u00020-2\u0006\u00108\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0002J\u001c\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020%2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyViewModel;", "Landroidx/lifecycle/ViewModel;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "launchMode", "Lio/intercom/android/sdk/survey/SurveyLaunchMode;", "surveyRepository", "Lio/intercom/android/sdk/survey/SurveyRepository;", "store", "Lio/intercom/android/sdk/store/Store;", "Lio/intercom/android/sdk/state/State;", "appConfig", "Lio/intercom/android/sdk/identity/AppConfig;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lio/intercom/android/sdk/survey/SurveyLaunchMode;Lio/intercom/android/sdk/survey/SurveyRepository;Lio/intercom/android/sdk/store/Store;Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/metrics/MetricTracker;)V", "completedResponses", "", "Lio/intercom/android/sdk/survey/model/SubmitSurveyRequestItem;", "completedSteps", "Lio/intercom/android/sdk/survey/model/SurveyData$Step;", "currentStep", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "effects", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/intercom/android/sdk/survey/SurveyEffects;", "getEffects", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/survey/SurveyState;", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "surveyData", "Lio/intercom/android/sdk/survey/model/SurveyData;", "buildContentState", "Lio/intercom/android/sdk/survey/SurveyState$Content;", "continueClicked", "", "compositionAwareScope", "Lkotlinx/coroutines/CoroutineScope;", "emitLoading", "fetchAndShowSurvey", "surveyId", "", "getCurrentContentState", "onAnswerUpdated", "onCloseClicked", "triggerType", "Lio/intercom/android/sdk/survey/CloseEventTrigger;", "onSecondaryCtaClicked", "secondaryCta", "Lio/intercom/android/sdk/survey/SurveyState$Content$SecondaryCta;", "onUiLoaded", "reportFailure", "surveyProgressId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendDismissedEvent", "submitSurvey", "surveyContent", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SurveyViewModel.kt */
public final class SurveyViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AppConfig appConfig;
    /* access modifiers changed from: private */
    public final List<SubmitSurveyRequestItem> completedResponses;
    /* access modifiers changed from: private */
    public final List<SurveyData.Step> completedSteps;
    /* access modifiers changed from: private */
    public SurveyData.Step currentStep;
    private final CoroutineDispatcher dispatcher;
    private final MutableSharedFlow<SurveyEffects> effects;
    /* access modifiers changed from: private */
    public final SurveyLaunchMode launchMode;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;
    private final MutableStateFlow<SurveyState> state;
    /* access modifiers changed from: private */
    public final Store<State> store;
    /* access modifiers changed from: private */
    public SurveyData surveyData;
    /* access modifiers changed from: private */
    public final SurveyRepository surveyRepository;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SurveyData.StepType.values().length];
            iArr[SurveyData.StepType.QUESTION.ordinal()] = 1;
            iArr[SurveyData.StepType.INTRO.ordinal()] = 2;
            iArr[SurveyData.StepType.CONTENT.ordinal()] = 3;
            iArr[SurveyData.StepType.THANK_YOU.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CloseEventTrigger.values().length];
            iArr2[CloseEventTrigger.CTA.ordinal()] = 1;
            iArr2[CloseEventTrigger.CLOSE_BUTTON.ordinal()] = 2;
            iArr2[CloseEventTrigger.SECONDARY_CTA_EXTERNAL_LINK.ordinal()] = 3;
            iArr2[CloseEventTrigger.SECONDARY_CTA_DEEP_LINK.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SurveyViewModel(kotlinx.coroutines.CoroutineDispatcher r8, io.intercom.android.sdk.survey.SurveyLaunchMode r9, io.intercom.android.sdk.survey.SurveyRepository r10, io.intercom.android.sdk.store.Store<io.intercom.android.sdk.state.State> r11, io.intercom.android.sdk.identity.AppConfig r12, io.intercom.android.sdk.metrics.MetricTracker r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0008
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
        L_0x0008:
            r1 = r8
            r8 = r14 & 4
            if (r8 == 0) goto L_0x0014
            io.intercom.android.sdk.survey.SurveyRepository r10 = new io.intercom.android.sdk.survey.SurveyRepository
            r8 = 0
            r15 = 1
            r10.<init>(r8, r15, r8)
        L_0x0014:
            r3 = r10
            r8 = r14 & 8
            if (r8 == 0) goto L_0x0026
            io.intercom.android.sdk.Injector r8 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.store.Store r11 = r8.getStore()
            java.lang.String r8 = "get().store"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
        L_0x0026:
            r4 = r11
            r8 = r14 & 16
            if (r8 == 0) goto L_0x003f
            io.intercom.android.sdk.Injector r8 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.Provider r8 = r8.getAppConfigProvider()
            java.lang.Object r8 = r8.get()
            java.lang.String r10 = "get().appConfigProvider.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)
            r12 = r8
            io.intercom.android.sdk.identity.AppConfig r12 = (io.intercom.android.sdk.identity.AppConfig) r12
        L_0x003f:
            r5 = r12
            r8 = r14 & 32
            if (r8 == 0) goto L_0x0051
            io.intercom.android.sdk.Injector r8 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.metrics.MetricTracker r13 = r8.getMetricTracker()
            java.lang.String r8 = "get().metricTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r8)
        L_0x0051:
            r6 = r13
            r0 = r7
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.SurveyViewModel.<init>(kotlinx.coroutines.CoroutineDispatcher, io.intercom.android.sdk.survey.SurveyLaunchMode, io.intercom.android.sdk.survey.SurveyRepository, io.intercom.android.sdk.store.Store, io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.metrics.MetricTracker, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public SurveyViewModel(CoroutineDispatcher coroutineDispatcher, SurveyLaunchMode surveyLaunchMode, SurveyRepository surveyRepository2, Store<State> store2, AppConfig appConfig2, MetricTracker metricTracker2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(surveyLaunchMode, "launchMode");
        Intrinsics.checkNotNullParameter(surveyRepository2, "surveyRepository");
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        this.dispatcher = coroutineDispatcher;
        this.launchMode = surveyLaunchMode;
        this.surveyRepository = surveyRepository2;
        this.store = store2;
        this.appConfig = appConfig2;
        this.metricTracker = metricTracker2;
        this.surveyData = SurveyData.Companion.getNULL();
        this.state = StateFlowKt.MutableStateFlow(SurveyState.Initial.INSTANCE);
        this.effects = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this.completedResponses = new ArrayList();
        this.completedSteps = new ArrayList();
    }

    public final MutableStateFlow<SurveyState> getState() {
        return this.state;
    }

    public final MutableSharedFlow<SurveyEffects> getEffects() {
        return this.effects;
    }

    public final void onUiLoaded() {
        if (Intrinsics.areEqual((Object) this.state.getValue(), (Object) SurveyState.Initial.INSTANCE)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new SurveyViewModel$onUiLoaded$1(this, (Continuation<? super SurveyViewModel$onUiLoaded$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void fetchAndShowSurvey(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new SurveyViewModel$fetchAndShowSurvey$1(str, this, SurveyViewModelKt.toSurveyUiColors(this.surveyData.getCustomization()), (Continuation<? super SurveyViewModel$fetchAndShowSurvey$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        if (r3.getType() == io.intercom.android.sdk.survey.model.SurveyData.StepType.QUESTION) goto L_0x003e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f1 A[LOOP:0: B:38:0x00eb->B:40:0x00f1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.intercom.android.sdk.survey.SurveyState.Content buildContentState(io.intercom.android.sdk.survey.model.SurveyData r13) {
        /*
            r12 = this;
            io.intercom.android.sdk.survey.model.SurveyCustomization r0 = r13.getCustomization()
            io.intercom.android.sdk.survey.SurveyUiColors r0 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r0)
            int r1 = r13.getStepCount()
            float r1 = (float) r1
            java.util.List<io.intercom.android.sdk.survey.model.SurveyData$Step> r2 = r12.completedSteps
            int r2 = r2.size()
            boolean r3 = r13.getShowProgressBar()
            r8 = 1
            java.lang.String r9 = "currentStep"
            r10 = 0
            r11 = 0
            if (r3 == 0) goto L_0x0040
            io.intercom.android.sdk.survey.model.SurveyData$Step r3 = r12.currentStep
            if (r3 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r3 = r11
        L_0x0026:
            io.intercom.android.sdk.survey.model.SurveyData$StepType r3 = r3.getType()
            io.intercom.android.sdk.survey.model.SurveyData$StepType r4 = io.intercom.android.sdk.survey.model.SurveyData.StepType.CONTENT
            if (r3 == r4) goto L_0x003e
            io.intercom.android.sdk.survey.model.SurveyData$Step r3 = r12.currentStep
            if (r3 != 0) goto L_0x0036
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r3 = r11
        L_0x0036:
            io.intercom.android.sdk.survey.model.SurveyData$StepType r3 = r3.getType()
            io.intercom.android.sdk.survey.model.SurveyData$StepType r4 = io.intercom.android.sdk.survey.model.SurveyData.StepType.QUESTION
            if (r3 != r4) goto L_0x0040
        L_0x003e:
            r3 = 1
            goto L_0x0041
        L_0x0040:
            r3 = 0
        L_0x0041:
            io.intercom.android.sdk.survey.ProgressBarState r7 = new io.intercom.android.sdk.survey.ProgressBarState
            float r2 = (float) r2
            float r2 = r2 / r1
            r7.<init>(r3, r2)
            io.intercom.android.sdk.survey.model.SurveySenderData r1 = r13.getSender()
            if (r1 == 0) goto L_0x0053
            java.lang.String r1 = r1.getName()
            goto L_0x0054
        L_0x0053:
            r1 = r11
        L_0x0054:
            if (r1 != 0) goto L_0x0063
            io.intercom.android.sdk.survey.TopBarState$NoTopBarState r1 = new io.intercom.android.sdk.survey.TopBarState$NoTopBarState
            boolean r13 = r13.isDismissible()
            r1.<init>(r13, r0, r7)
            io.intercom.android.sdk.survey.TopBarState r1 = (io.intercom.android.sdk.survey.TopBarState) r1
            r7 = r1
            goto L_0x00b4
        L_0x0063:
            io.intercom.android.sdk.models.Avatar$Builder r1 = new io.intercom.android.sdk.models.Avatar$Builder
            r1.<init>()
            io.intercom.android.sdk.survey.model.SurveySenderData r2 = r13.getSender()
            io.intercom.android.sdk.survey.model.SurveySenderAvatar r2 = r2.getAvatar()
            if (r2 == 0) goto L_0x0077
            java.lang.String r2 = r2.getSquareImg128()
            goto L_0x0078
        L_0x0077:
            r2 = r11
        L_0x0078:
            io.intercom.android.sdk.models.Avatar$Builder r1 = r1.withImageUrl(r2)
            io.intercom.android.sdk.survey.model.SurveySenderData r2 = r13.getSender()
            java.lang.String r2 = r2.getInitials()
            io.intercom.android.sdk.models.Avatar$Builder r1 = r1.withInitials(r2)
            io.intercom.android.sdk.models.Avatar r2 = r1.build()
            io.intercom.android.sdk.survey.model.SurveySenderData r1 = r13.getSender()
            java.lang.String r1 = r1.getFirstName()
            if (r1 != 0) goto L_0x009e
            io.intercom.android.sdk.survey.model.SurveySenderData r1 = r13.getSender()
            java.lang.String r1 = r1.getName()
        L_0x009e:
            r3 = r1
            boolean r5 = r13.isDismissible()
            io.intercom.android.sdk.identity.AppConfig r4 = r12.appConfig
            io.intercom.android.sdk.survey.TopBarState$SenderTopBarState r13 = new io.intercom.android.sdk.survey.TopBarState$SenderTopBarState
            java.lang.String r1 = "build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            r1 = r13
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            io.intercom.android.sdk.survey.TopBarState r13 = (io.intercom.android.sdk.survey.TopBarState) r13
            r7 = r13
        L_0x00b4:
            io.intercom.android.sdk.survey.model.SurveyData$Step r13 = r12.currentStep
            if (r13 != 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r13 = r11
        L_0x00bc:
            java.lang.String r13 = r13.getCustomButtonText()
            io.intercom.android.sdk.survey.model.SurveyData$Step r1 = r12.currentStep
            if (r1 != 0) goto L_0x00c8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r11
        L_0x00c8:
            java.util.List r2 = r1.getBlocks()
            io.intercom.android.sdk.survey.model.SurveyData$Step r1 = r12.currentStep
            if (r1 != 0) goto L_0x00d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r11
        L_0x00d4:
            java.util.List r1 = r1.getQuestions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r5)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r1 = r1.iterator()
        L_0x00eb:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0104
            java.lang.Object r5 = r1.next()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question r5 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question) r5
            io.intercom.android.sdk.survey.QuestionState r6 = new io.intercom.android.sdk.survey.QuestionState
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r5 = r5.getQuestionModel()
            r6.<init>(r5, r0)
            r3.add(r6)
            goto L_0x00eb
        L_0x0104:
            java.util.List r3 = (java.util.List) r3
            io.intercom.android.sdk.survey.model.SurveyData$Step r1 = r12.currentStep
            if (r1 != 0) goto L_0x010e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r1 = r11
        L_0x010e:
            io.intercom.android.sdk.survey.model.SurveyData$StepType r1 = r1.getType()
            int[] r5 = io.intercom.android.sdk.survey.SurveyViewModel.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r5[r1]
            if (r1 == r8) goto L_0x0190
            r5 = 2
            if (r1 == r5) goto L_0x016d
            r5 = 3
            if (r1 == r5) goto L_0x016d
            r5 = 4
            if (r1 == r5) goto L_0x014a
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0133
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0131
            goto L_0x0133
        L_0x0131:
            r1 = 0
            goto L_0x0134
        L_0x0133:
            r1 = 1
        L_0x0134:
            if (r1 == 0) goto L_0x0141
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback r13 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback
            int r1 = io.intercom.android.sdk.R.string.intercom_surveys_next_button
            r13.<init>(r1)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r13 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r13
            goto L_0x01aa
        L_0x0141:
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom r1 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom
            r1.<init>(r13)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r1 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r1
            goto L_0x01b3
        L_0x014a:
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0158
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0156
            goto L_0x0158
        L_0x0156:
            r1 = 0
            goto L_0x0159
        L_0x0158:
            r1 = 1
        L_0x0159:
            if (r1 == 0) goto L_0x0165
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback r13 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback
            int r1 = io.intercom.android.sdk.R.string.intercom_surveys_done_button
            r13.<init>(r1)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r13 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r13
            goto L_0x01aa
        L_0x0165:
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom r1 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom
            r1.<init>(r13)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r1 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r1
            goto L_0x01b3
        L_0x016d:
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x017b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0179
            goto L_0x017b
        L_0x0179:
            r1 = 0
            goto L_0x017c
        L_0x017b:
            r1 = 1
        L_0x017c:
            if (r1 == 0) goto L_0x0188
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback r13 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback
            int r1 = io.intercom.android.sdk.R.string.intercom_surveys_next_button
            r13.<init>(r1)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r13 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r13
            goto L_0x01aa
        L_0x0188:
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom r1 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom
            r1.<init>(r13)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r1 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r1
            goto L_0x01b3
        L_0x0190:
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x019e
            int r1 = r1.length()
            if (r1 != 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r1 = 0
            goto L_0x019f
        L_0x019e:
            r1 = 1
        L_0x019f:
            if (r1 == 0) goto L_0x01ac
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback r13 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Fallback
            int r1 = io.intercom.android.sdk.R.string.intercom_submit
            r13.<init>(r1)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r13 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r13
        L_0x01aa:
            r5 = r13
            goto L_0x01b4
        L_0x01ac:
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom r1 = new io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta$Custom
            r1.<init>(r13)
            io.intercom.android.sdk.survey.SurveyState$Content$PrimaryCta r1 = (io.intercom.android.sdk.survey.SurveyState.Content.PrimaryCta) r1
        L_0x01b3:
            r5 = r1
        L_0x01b4:
            io.intercom.android.sdk.survey.model.SurveyData$Step r13 = r12.currentStep
            if (r13 != 0) goto L_0x01bc
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            goto L_0x01bd
        L_0x01bc:
            r11 = r13
        L_0x01bd:
            java.util.List r13 = r11.getActions()
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r1 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r4)
            r1.<init>(r4)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r13 = r13.iterator()
        L_0x01d2:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x0203
            java.lang.Object r4 = r13.next()
            io.intercom.android.sdk.survey.model.SurveyData$SurveyActions r4 = (io.intercom.android.sdk.survey.model.SurveyData.SurveyActions) r4
            java.lang.String r6 = r4.getAndroidUri()
            if (r6 != 0) goto L_0x01e6
            r6 = 1
            goto L_0x01e7
        L_0x01e6:
            r6 = 0
        L_0x01e7:
            if (r6 == 0) goto L_0x01ee
            java.lang.String r9 = r4.getWebUrl()
            goto L_0x01f2
        L_0x01ee:
            java.lang.String r9 = r4.getAndroidUri()
        L_0x01f2:
            io.intercom.android.sdk.survey.SurveyState$Content$SecondaryCta r11 = new io.intercom.android.sdk.survey.SurveyState$Content$SecondaryCta
            java.lang.String r4 = r4.getActionTitle()
            if (r9 != 0) goto L_0x01fc
            java.lang.String r9 = ""
        L_0x01fc:
            r11.<init>(r4, r9, r6)
            r1.add(r11)
            goto L_0x01d2
        L_0x0203:
            r4 = r1
            java.util.List r4 = (java.util.List) r4
            io.intercom.android.sdk.survey.SurveyState$Content r13 = new io.intercom.android.sdk.survey.SurveyState$Content
            r1 = r13
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.SurveyViewModel.buildContentState(io.intercom.android.sdk.survey.model.SurveyData):io.intercom.android.sdk.survey.SurveyState$Content");
    }

    public final void onCloseClicked(CloseEventTrigger closeEventTrigger) {
        Intrinsics.checkNotNullParameter(closeEventTrigger, "triggerType");
        if (this.surveyData.isDismissible() || (this.state.getValue() instanceof SurveyState.Error)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SurveyViewModel$onCloseClicked$1(this, closeEventTrigger, (Continuation<? super SurveyViewModel$onCloseClicked$1>) null), 3, (Object) null);
        }
    }

    public final void onSecondaryCtaClicked(SurveyState.Content.SecondaryCta secondaryCta) {
        CloseEventTrigger closeEventTrigger;
        Intrinsics.checkNotNullParameter(secondaryCta, "secondaryCta");
        if (secondaryCta.isExternalUrl()) {
            closeEventTrigger = CloseEventTrigger.SECONDARY_CTA_EXTERNAL_LINK;
        } else {
            closeEventTrigger = CloseEventTrigger.SECONDARY_CTA_DEEP_LINK;
        }
        if (closeEventTrigger == CloseEventTrigger.SECONDARY_CTA_DEEP_LINK) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new SurveyViewModel$onSecondaryCtaClicked$1(this, (Continuation<? super SurveyViewModel$onSecondaryCtaClicked$1>) null), 3, (Object) null);
        }
        onCloseClicked(closeEventTrigger);
    }

    static /* synthetic */ void submitSurvey$default(SurveyViewModel surveyViewModel, SurveyState.Content content, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineScope = null;
        }
        surveyViewModel.submitSurvey(content, coroutineScope);
    }

    /* access modifiers changed from: private */
    public final void submitSurvey(SurveyState.Content content, CoroutineScope coroutineScope) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, (CoroutineStart) null, new SurveyViewModel$submitSurvey$1(this, content, coroutineScope, (Continuation<? super SurveyViewModel$submitSurvey$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ void continueClicked$default(SurveyViewModel surveyViewModel, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = null;
        }
        surveyViewModel.continueClicked(coroutineScope);
    }

    public final void continueClicked(CoroutineScope coroutineScope) {
        submitSurvey(getCurrentContentState(), coroutineScope);
    }

    private final SurveyState.Content getCurrentContentState() {
        SurveyState value = this.state.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.intercom.android.sdk.survey.SurveyState.Content");
        return (SurveyState.Content) value;
    }

    public final void onAnswerUpdated() {
        int i;
        SurveyState.Content currentContentState = getCurrentContentState();
        float stepCount = (float) this.surveyData.getStepCount();
        int size = this.completedSteps.size();
        Iterable<QuestionState> questions = currentContentState.getQuestions();
        if (!(questions instanceof Collection) || !((Collection) questions).isEmpty()) {
            i = 0;
            for (QuestionState validationError : questions) {
                if ((validationError.getValidationError() instanceof ValidationError.NoValidationError) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        } else {
            i = 0;
        }
        float f = ((float) size) / stepCount;
        float f2 = (float) i;
        SurveyData.Step step = this.currentStep;
        if (step == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentStep");
            step = null;
        }
        this.state.setValue(SurveyState.Content.copy$default(currentContentState, (List) null, (List) null, (List) null, (SurveyState.Content.PrimaryCta) null, (SurveyUiColors) null, currentContentState.getTopBarState().withProgressBarState(ProgressBarState.copy$default(currentContentState.getTopBarState().getProgressBarState(), false, f + (f2 / (stepCount * ((float) step.getQuestions().size()))), 1, (Object) null)), 31, (Object) null));
    }

    @Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u0001\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lio/intercom/android/sdk/survey/SurveyViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/survey/SurveyViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "launchMode", "Lio/intercom/android/sdk/survey/SurveyLaunchMode;", "factory", "io/intercom/android/sdk/survey/SurveyViewModel$Companion$factory$1", "(Lio/intercom/android/sdk/survey/SurveyLaunchMode;)Lio/intercom/android/sdk/survey/SurveyViewModel$Companion$factory$1;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SurveyViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SurveyViewModel create(ViewModelStoreOwner viewModelStoreOwner, SurveyLaunchMode surveyLaunchMode) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(surveyLaunchMode, "launchMode");
            return (SurveyViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(surveyLaunchMode)).get(SurveyViewModel.class);
        }

        private final SurveyViewModel$Companion$factory$1 factory(SurveyLaunchMode surveyLaunchMode) {
            return new SurveyViewModel$Companion$factory$1(surveyLaunchMode);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object reportFailure(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.intercom.android.sdk.survey.SurveyViewModel$reportFailure$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.intercom.android.sdk.survey.SurveyViewModel$reportFailure$1 r0 = (io.intercom.android.sdk.survey.SurveyViewModel$reportFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.intercom.android.sdk.survey.SurveyViewModel$reportFailure$1 r0 = new io.intercom.android.sdk.survey.SurveyViewModel$reportFailure$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            io.intercom.android.sdk.survey.SurveyRepository r7 = r4.surveyRepository
            r0.label = r3
            java.lang.Object r7 = r7.reportFailure(r5, r6, r0)
            if (r7 != r1) goto L_0x0040
            return r1
        L_0x0040:
            io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse r7 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse) r7
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.SurveyViewModel.reportFailure(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void emitLoading() {
        MutableStateFlow<SurveyState> mutableStateFlow = this.state;
        mutableStateFlow.setValue(new SurveyState.Loading(this.state.getValue().getSurveyUiColors(), mutableStateFlow.getValue().getTopBarState()));
    }

    /* access modifiers changed from: private */
    public final void sendDismissedEvent(CloseEventTrigger closeEventTrigger) {
        String str;
        String str2;
        SurveyState value = this.state.getValue();
        if (value instanceof SurveyState.Loading) {
            str = MetricTracker.Object.SURVEY_STEP_LOADING;
        } else {
            str = value instanceof SurveyState.Error ? MetricTracker.Object.SURVEY_STEP_ERROR : "survey";
        }
        String str3 = str;
        int i = WhenMappings.$EnumSwitchMapping$1[closeEventTrigger.ordinal()];
        if (i == 1) {
            str2 = MetricTracker.Context.FROM_CTA;
        } else if (i == 2) {
            str2 = MetricTracker.Context.FROM_CLOSE_BUTTON;
        } else if (i == 3) {
            str2 = MetricTracker.Context.FROM_ONWARD_EXTERNAL_LINK;
        } else if (i == 4) {
            str2 = MetricTracker.Context.FROM_ONWARD_DEEP_LINK;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String str4 = str2;
        if (!this.surveyData.getSteps().isEmpty()) {
            SurveyData.Step step = this.currentStep;
            SurveyData.Step step2 = null;
            if (step == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentStep");
                step = null;
            }
            String str5 = step.getType() == SurveyData.StepType.THANK_YOU ? MetricTracker.Action.CLOSED : "dismissed";
            int i2 = 0;
            for (SurveyData.Step questions : this.completedSteps) {
                i2 += questions.getQuestions().size();
            }
            SurveyData.Step step3 = this.currentStep;
            if (step3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentStep");
            } else {
                step2 = step3;
            }
            this.metricTracker.surveyDismissed(str5, str3, str4, this.surveyData.getId(), this.surveyData.getFormatMetric(), this.completedSteps.size(), this.surveyData.getStepCount(), i2 + step2.getQuestions().size());
        }
    }
}
