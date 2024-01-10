package io.intercom.android.sdk.tickets.create.model;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.models.TicketType;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.tickets.create.data.TicketAttributeRequest;
import io.intercom.android.sdk.tickets.create.data.TicketRepository;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u0003012B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\"\u001a\u00020\u0014H\u0002J\u0012\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0005H\u0002J\u001c\u0010,\u001a\u00020$2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020$0.H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel;", "Landroidx/lifecycle/ViewModel;", "ticketRepository", "Lio/intercom/android/sdk/tickets/create/data/TicketRepository;", "conversationId", "", "userIdentity", "Lio/intercom/android/sdk/identity/UserIdentity;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "metricTracker", "Lio/intercom/android/sdk/metrics/MetricTracker;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lio/intercom/android/sdk/tickets/create/data/TicketRepository;Ljava/lang/String;Lio/intercom/android/sdk/identity/UserIdentity;Lkotlinx/coroutines/CoroutineDispatcher;Lio/intercom/android/sdk/metrics/MetricTracker;Landroidx/lifecycle/SavedStateHandle;)V", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "ticketData", "Lio/intercom/android/sdk/blocks/lib/models/TicketType;", "ticketTypeId", "", "Ljava/lang/Integer;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "convertToUiState", "createTicket", "", "compositionAwareScope", "Lkotlinx/coroutines/CoroutineScope;", "getAttributeRequest", "", "Lio/intercom/android/sdk/tickets/create/data/TicketAttributeRequest;", "getPlaceholderText", "type", "withState", "operation", "Lkotlin/Function1;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "Companion", "CreateTicketFormUiState", "TicketSideEffect", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketViewModel.kt */
public final class CreateTicketViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final MutableSharedFlow<TicketSideEffect> _effect;
    /* access modifiers changed from: private */
    public final MutableStateFlow<CreateTicketFormUiState> _uiState;
    /* access modifiers changed from: private */
    public final String conversationId;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher dispatcher;
    private final SharedFlow<TicketSideEffect> effect;
    private final MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public final TicketType ticketData;
    /* access modifiers changed from: private */
    public final TicketRepository ticketRepository;
    private final Integer ticketTypeId;
    private final StateFlow<CreateTicketFormUiState> uiState;
    /* access modifiers changed from: private */
    public final UserIdentity userIdentity;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CreateTicketViewModel(io.intercom.android.sdk.tickets.create.data.TicketRepository r11, java.lang.String r12, io.intercom.android.sdk.identity.UserIdentity r13, kotlinx.coroutines.CoroutineDispatcher r14, io.intercom.android.sdk.metrics.MetricTracker r15, androidx.lifecycle.SavedStateHandle r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r10 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x000d
            io.intercom.android.sdk.tickets.create.data.TicketRepository r0 = new io.intercom.android.sdk.tickets.create.data.TicketRepository
            r1 = 3
            r2 = 0
            r0.<init>(r2, r2, r1, r2)
            r4 = r0
            goto L_0x000e
        L_0x000d:
            r4 = r11
        L_0x000e:
            r0 = r17 & 2
            if (r0 == 0) goto L_0x002f
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.store.Store r0 = r0.getStore()
            java.lang.Object r0 = r0.state()
            io.intercom.android.sdk.state.State r0 = (io.intercom.android.sdk.state.State) r0
            io.intercom.android.sdk.state.ActiveConversationState r0 = r0.activeConversationState()
            java.lang.String r0 = r0.getConversationId()
            java.lang.String r1 = "get().store.state()\n    …ionState().conversationId"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r5 = r0
            goto L_0x0030
        L_0x002f:
            r5 = r12
        L_0x0030:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0043
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.identity.UserIdentity r0 = r0.getUserIdentity()
            java.lang.String r1 = "get().userIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6 = r0
            goto L_0x0044
        L_0x0043:
            r6 = r13
        L_0x0044:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x004e
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            r7 = r0
            goto L_0x004f
        L_0x004e:
            r7 = r14
        L_0x004f:
            r0 = r17 & 16
            if (r0 == 0) goto L_0x0062
            io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.metrics.MetricTracker r0 = r0.getMetricTracker()
            java.lang.String r1 = "get().metricTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r8 = r0
            goto L_0x0063
        L_0x0062:
            r8 = r15
        L_0x0063:
            r3 = r10
            r9 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.<init>(io.intercom.android.sdk.tickets.create.data.TicketRepository, java.lang.String, io.intercom.android.sdk.identity.UserIdentity, kotlinx.coroutines.CoroutineDispatcher, io.intercom.android.sdk.metrics.MetricTracker, androidx.lifecycle.SavedStateHandle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public CreateTicketViewModel(TicketRepository ticketRepository2, String str, UserIdentity userIdentity2, CoroutineDispatcher coroutineDispatcher, MetricTracker metricTracker2, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(ticketRepository2, "ticketRepository");
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(userIdentity2, "userIdentity");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(metricTracker2, "metricTracker");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.ticketRepository = ticketRepository2;
        this.conversationId = str;
        this.userIdentity = userIdentity2;
        this.dispatcher = coroutineDispatcher;
        this.metricTracker = metricTracker2;
        this.ticketData = (TicketType) savedStateHandle.get("ticketData");
        this.ticketTypeId = (Integer) savedStateHandle.get("ticketTypeId");
        MutableStateFlow<CreateTicketFormUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(convertToUiState());
        this._uiState = MutableStateFlow;
        this.uiState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<TicketSideEffect> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._effect = MutableSharedFlow$default;
        this.effect = FlowKt.asSharedFlow(MutableSharedFlow$default);
        this.metricTracker.viewedCreateTicketForm(this.ticketTypeId, this.conversationId);
    }

    public final StateFlow<CreateTicketFormUiState> getUiState() {
        return this.uiState;
    }

    public final SharedFlow<TicketSideEffect> getEffect() {
        return this.effect;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01e4, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3.getIdentifier(), (java.lang.Object) "multiline") == false) goto L_0x0240;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01e6, code lost:
        r8 = new io.intercom.android.sdk.survey.QuestionState(new io.intercom.android.sdk.survey.model.SurveyData.Step.Question.LongTextQuestionModel(java.lang.String.valueOf(r3.getId()), kotlin.collections.CollectionsKt.listOf(new io.intercom.android.sdk.blocks.lib.models.Block.Builder().withType(io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH.getSerializedName()).withText(r3.getName())), r3.getRequired(), (java.lang.String) null, io.intercom.android.sdk.tickets.create.model.CreateTicketViewModelKt.getInputType(r3.getType()), (java.lang.Integer) null, androidx.compose.ui.unit.Dp.m4704constructorimpl((float) 120), 0, java.lang.Integer.valueOf(r5), 136, (kotlin.jvm.internal.DefaultConstructorMarker) null), io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(new io.intercom.android.sdk.survey.model.SurveyCustomization((java.lang.String) null, (java.lang.String) null, 3, (kotlin.jvm.internal.DefaultConstructorMarker) null)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0240, code lost:
        r8 = new io.intercom.android.sdk.survey.QuestionState(new io.intercom.android.sdk.survey.model.SurveyData.Step.Question.ShortTextQuestionModel(java.lang.String.valueOf(r3.getId()), kotlin.collections.CollectionsKt.listOf(new io.intercom.android.sdk.blocks.lib.models.Block.Builder().withType(io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH.getSerializedName()).withText(r3.getName())), r3.getRequired(), (java.lang.String) null, io.intercom.android.sdk.tickets.create.model.CreateTicketViewModelKt.getInputType(r3.getType()), (java.lang.Integer) null, false, java.lang.Integer.valueOf(r5), 72, (kotlin.jvm.internal.DefaultConstructorMarker) null), io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(new io.intercom.android.sdk.survey.model.SurveyCustomization((java.lang.String) null, (java.lang.String) null, 3, (kotlin.jvm.internal.DefaultConstructorMarker) null)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0292, code lost:
        r1.add(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.CreateTicketFormUiState convertToUiState() {
        /*
            r22 = this;
            r0 = r22
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4 = r1
            java.util.List r4 = (java.util.List) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            io.intercom.android.sdk.survey.QuestionState r2 = new io.intercom.android.sdk.survey.QuestionState
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r3 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r3.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r5 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r5 = r5.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r3 = r3.withType(r5)
            java.lang.String r5 = "Email"
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r3 = r3.withText(r5)
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r3)
            int r3 = io.intercom.android.sdk.R.string.intercom_placeholder_email_input
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r10 = io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionValidation.ValidationType.EMAIL
            io.intercom.android.sdk.identity.UserIdentity r5 = r0.userIdentity
            java.lang.String r5 = r5.getEmail()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r16 = 1
            if (r5 == 0) goto L_0x0042
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r5 = 0
            r12 = 0
            goto L_0x0043
        L_0x0042:
            r12 = 1
        L_0x0043:
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$ShortTextQuestionModel r17 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$ShortTextQuestionModel
            r8 = 1
            r9 = 0
            r11 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            r14 = 8
            r15 = 0
            java.lang.String r6 = "-1"
            r5 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r3 = r17
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r3 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r3
            io.intercom.android.sdk.survey.model.SurveyCustomization r5 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r6 = 0
            r7 = 3
            r5.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r5 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r5)
            r2.<init>(r3, r5)
            io.intercom.android.sdk.identity.UserIdentity r3 = r0.userIdentity
            java.lang.String r3 = r3.getEmail()
            java.lang.String r5 = "userIdentity.email"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x0090
            io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer r3 = new io.intercom.android.sdk.survey.ui.models.Answer$SingleAnswer
            io.intercom.android.sdk.identity.UserIdentity r8 = r0.userIdentity
            java.lang.String r8 = r8.getEmail()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            r3.<init>(r8)
            io.intercom.android.sdk.survey.ui.models.Answer r3 = (io.intercom.android.sdk.survey.ui.models.Answer) r3
            r2.setAnswer(r3)
        L_0x0090:
            r1.add(r2)
            io.intercom.android.sdk.blocks.lib.models.TicketType r2 = r0.ticketData
            if (r2 == 0) goto L_0x0297
            java.util.List r2 = r2.getAttributes()
            if (r2 == 0) goto L_0x0297
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00a3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0297
            java.lang.Object r3 = r2.next()
            io.intercom.android.sdk.blocks.lib.models.TicketAttribute r3 = (io.intercom.android.sdk.blocks.lib.models.TicketAttribute) r3
            java.lang.String r5 = r3.getType()
            int r5 = r0.getPlaceholderText(r5)
            java.lang.String r8 = r3.getType()
            int r9 = r8.hashCode()
            switch(r9) {
                case -891985903: goto L_0x01d0;
                case 3322014: goto L_0x0177;
                case 64711720: goto L_0x011e;
                case 97526364: goto L_0x0115;
                case 1793702779: goto L_0x00cc;
                case 1958052158: goto L_0x00c3;
                default: goto L_0x00c2;
            }
        L_0x00c2:
            goto L_0x00a3
        L_0x00c3:
            java.lang.String r9 = "integer"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01da
            goto L_0x00a3
        L_0x00cc:
            java.lang.String r5 = "datetime"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L_0x00d5
            goto L_0x00a3
        L_0x00d5:
            io.intercom.android.sdk.survey.QuestionState r5 = new io.intercom.android.sdk.survey.QuestionState
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DatePickerQuestionModel r8 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DatePickerQuestionModel
            int r9 = r3.getId()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r10 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r10.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r11 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r11 = r11.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r10 = r10.withType(r11)
            java.lang.String r11 = r3.getName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r10 = r10.withText(r11)
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r10)
            boolean r3 = r3.getRequired()
            r8.<init>(r9, r10, r3)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r8 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r8
            io.intercom.android.sdk.survey.model.SurveyCustomization r3 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r3.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r3 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r3)
            r5.<init>(r8, r3)
            r1.add(r5)
            goto L_0x00a3
        L_0x0115:
            java.lang.String r9 = "float"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01da
            goto L_0x00a3
        L_0x011e:
            java.lang.String r5 = "boolean"
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L_0x0128
            goto L_0x00a3
        L_0x0128:
            io.intercom.android.sdk.survey.QuestionState r5 = new io.intercom.android.sdk.survey.QuestionState
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$SingleChoiceQuestionModel r14 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$SingleChoiceQuestionModel
            int r8 = r3.getId()
            java.lang.String r9 = java.lang.String.valueOf(r8)
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r8 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r8.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r10 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r10 = r10.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r8 = r8.withType(r10)
            java.lang.String r10 = r3.getName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r8 = r8.withText(r10)
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r8)
            boolean r11 = r3.getRequired()
            java.lang.String r3 = "True"
            java.lang.String r8 = "False"
            java.lang.String[] r3 = new java.lang.String[]{r3, r8}
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r3)
            r13 = 0
            r8 = r14
            r8.<init>(r9, r10, r11, r12, r13)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r14 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r14
            io.intercom.android.sdk.survey.model.SurveyCustomization r3 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r3.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r3 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r3)
            r5.<init>(r14, r3)
            r1.add(r5)
            goto L_0x00a3
        L_0x0177:
            java.lang.String r9 = "list"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0181
            goto L_0x00a3
        L_0x0181:
            io.intercom.android.sdk.survey.QuestionState r8 = new io.intercom.android.sdk.survey.QuestionState
            int r9 = r3.getId()
            java.lang.String r11 = java.lang.String.valueOf(r9)
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r9.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r10 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r10 = r10.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withType(r10)
            java.lang.String r10 = r3.getName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withText(r10)
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r9)
            boolean r13 = r3.getRequired()
            java.util.List r14 = r3.getOptions()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DropDownQuestionModel r3 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$DropDownQuestionModel
            r15 = 0
            java.lang.Integer r16 = java.lang.Integer.valueOf(r5)
            r17 = 16
            r18 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r3 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r3
            io.intercom.android.sdk.survey.model.SurveyCustomization r5 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r5.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r5 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r5)
            r8.<init>(r3, r5)
            r1.add(r8)
            goto L_0x00a3
        L_0x01d0:
            java.lang.String r9 = "string"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x01da
            goto L_0x00a3
        L_0x01da:
            java.lang.String r8 = r3.getIdentifier()
            java.lang.String r9 = "multiline"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 == 0) goto L_0x0240
            io.intercom.android.sdk.survey.QuestionState r8 = new io.intercom.android.sdk.survey.QuestionState
            int r9 = r3.getId()
            java.lang.String r11 = java.lang.String.valueOf(r9)
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r9.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r10 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r10 = r10.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withType(r10)
            java.lang.String r10 = r3.getName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withText(r10)
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r9)
            boolean r13 = r3.getRequired()
            java.lang.String r3 = r3.getType()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r15 = io.intercom.android.sdk.tickets.create.model.CreateTicketViewModelKt.getInputType(r3)
            r3 = 120(0x78, float:1.68E-43)
            float r3 = (float) r3
            float r17 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$LongTextQuestionModel r3 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$LongTextQuestionModel
            r14 = 0
            r16 = 0
            r18 = 0
            java.lang.Integer r19 = java.lang.Integer.valueOf(r5)
            r20 = 136(0x88, float:1.9E-43)
            r21 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r3 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r3
            io.intercom.android.sdk.survey.model.SurveyCustomization r5 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r5.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r5 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r5)
            r8.<init>(r3, r5)
            goto L_0x0292
        L_0x0240:
            io.intercom.android.sdk.survey.QuestionState r8 = new io.intercom.android.sdk.survey.QuestionState
            int r9 = r3.getId()
            java.lang.String r11 = java.lang.String.valueOf(r9)
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = new io.intercom.android.sdk.blocks.lib.models.Block$Builder
            r9.<init>()
            io.intercom.android.sdk.blocks.lib.BlockType r10 = io.intercom.android.sdk.blocks.lib.BlockType.PARAGRAPH
            java.lang.String r10 = r10.getSerializedName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withType(r10)
            java.lang.String r10 = r3.getName()
            io.intercom.android.sdk.blocks.lib.models.Block$Builder r9 = r9.withText(r10)
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r9)
            boolean r13 = r3.getRequired()
            java.lang.String r3 = r3.getType()
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionValidation$ValidationType r15 = io.intercom.android.sdk.tickets.create.model.CreateTicketViewModelKt.getInputType(r3)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$ShortTextQuestionModel r3 = new io.intercom.android.sdk.survey.model.SurveyData$Step$Question$ShortTextQuestionModel
            r14 = 0
            r16 = 0
            r17 = 0
            java.lang.Integer r18 = java.lang.Integer.valueOf(r5)
            r19 = 72
            r20 = 0
            r10 = r3
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            io.intercom.android.sdk.survey.model.SurveyData$Step$Question$QuestionModel r3 = (io.intercom.android.sdk.survey.model.SurveyData.Step.Question.QuestionModel) r3
            io.intercom.android.sdk.survey.model.SurveyCustomization r5 = new io.intercom.android.sdk.survey.model.SurveyCustomization
            r5.<init>(r6, r6, r7, r6)
            io.intercom.android.sdk.survey.SurveyUiColors r5 = io.intercom.android.sdk.survey.SurveyViewModelKt.toSurveyUiColors(r5)
            r8.<init>(r3, r5)
        L_0x0292:
            r1.add(r8)
            goto L_0x00a3
        L_0x0297:
            io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$CreateTicketFormUiState$Content r1 = new io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$CreateTicketFormUiState$Content
            io.intercom.android.sdk.blocks.lib.models.TicketType r2 = r0.ticketData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = r2.getName()
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$CreateTicketFormUiState r1 = (io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.CreateTicketFormUiState) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.convertToUiState():io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$CreateTicketFormUiState");
    }

    public static /* synthetic */ void createTicket$default(CreateTicketViewModel createTicketViewModel, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineScope = null;
        }
        createTicketViewModel.createTicket(coroutineScope);
    }

    public final void createTicket(CoroutineScope coroutineScope) {
        this.metricTracker.submittedCreateTicketForm(this.ticketTypeId, this.conversationId);
        withState(new CreateTicketViewModel$createTicket$1(this, coroutineScope));
    }

    /* access modifiers changed from: private */
    public final void withState(Function1<? super CreateTicketFormUiState.Content, Unit> function1) {
        if (this._uiState.getValue() instanceof CreateTicketFormUiState.Content) {
            CreateTicketFormUiState value = this._uiState.getValue();
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.CreateTicketFormUiState.Content");
            function1.invoke((CreateTicketFormUiState.Content) value);
        }
    }

    /* access modifiers changed from: private */
    public final List<TicketAttributeRequest> getAttributeRequest() {
        List<TicketAttributeRequest> arrayList = new ArrayList<>();
        withState(new CreateTicketViewModel$getAttributeRequest$1(arrayList));
        return arrayList;
    }

    private final int getPlaceholderText(String str) {
        switch (str.hashCode()) {
            case 3322014:
                if (str.equals(AttributeType.LIST)) {
                    return R.string.intercom_please_select;
                }
                break;
            case 96619420:
                if (str.equals("email")) {
                    return R.string.intercom_placeholder_email_input;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    return R.string.intercom_placeholder_numerical_inputs;
                }
                break;
            case 1958052158:
                if (str.equals("integer")) {
                    return R.string.intercom_placeholder_numerical_inputs;
                }
                break;
        }
        return R.string.intercom_placeholder_text_inputs;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$Companion;", "", "()V", "create", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "registryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "args", "Landroid/os/Bundle;", "factory", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CreateTicketViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CreateTicketViewModel create$default(Companion companion, ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, Object obj) {
            if ((i & 4) != 0) {
                bundle = null;
            }
            return companion.create(viewModelStoreOwner, savedStateRegistryOwner, bundle);
        }

        public final CreateTicketViewModel create(ViewModelStoreOwner viewModelStoreOwner, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "registryOwner");
            return (CreateTicketViewModel) new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) factory(savedStateRegistryOwner, bundle)).get(CreateTicketViewModel.class);
        }

        public static /* synthetic */ AbstractSavedStateViewModelFactory factory$default(Companion companion, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, Object obj) {
            if ((i & 2) != 0) {
                bundle = null;
            }
            return companion.factory(savedStateRegistryOwner, bundle);
        }

        public final AbstractSavedStateViewModelFactory factory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            return new CreateTicketViewModel$Companion$factory$1(savedStateRegistryOwner, bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "", "()V", "Content", "Error", "Initial", "Loading", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Error;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Initial;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Loading;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CreateTicketViewModel.kt */
    public static abstract class CreateTicketFormUiState {
        public static final int $stable = 0;

        public /* synthetic */ CreateTicketFormUiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Initial;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class Initial extends CreateTicketFormUiState {
            public static final int $stable = 0;
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super((DefaultConstructorMarker) null);
            }
        }

        private CreateTicketFormUiState() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Loading;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class Loading extends CreateTicketFormUiState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Error;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class Error extends CreateTicketFormUiState {
            public static final int $stable = 0;
            public static final Error INSTANCE = new Error();

            private Error() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState;", "title", "", "questions", "", "Lio/intercom/android/sdk/survey/QuestionState;", "showCreatingTicketProgress", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getQuestions", "()Ljava/util/List;", "getShowCreatingTicketProgress", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class Content extends CreateTicketFormUiState {
            public static final int $stable = 8;
            private final List<QuestionState> questions;
            private final boolean showCreatingTicketProgress;
            private final String title;

            public static /* synthetic */ Content copy$default(Content content, String str, List<QuestionState> list, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.title;
                }
                if ((i & 2) != 0) {
                    list = content.questions;
                }
                if ((i & 4) != 0) {
                    z = content.showCreatingTicketProgress;
                }
                return content.copy(str, list, z);
            }

            public final String component1() {
                return this.title;
            }

            public final List<QuestionState> component2() {
                return this.questions;
            }

            public final boolean component3() {
                return this.showCreatingTicketProgress;
            }

            public final Content copy(String str, List<QuestionState> list, boolean z) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "questions");
                return new Content(str, list, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Content)) {
                    return false;
                }
                Content content = (Content) obj;
                return Intrinsics.areEqual((Object) this.title, (Object) content.title) && Intrinsics.areEqual((Object) this.questions, (Object) content.questions) && this.showCreatingTicketProgress == content.showCreatingTicketProgress;
            }

            public int hashCode() {
                int hashCode = ((this.title.hashCode() * 31) + this.questions.hashCode()) * 31;
                boolean z = this.showCreatingTicketProgress;
                if (z) {
                    z = true;
                }
                return hashCode + (z ? 1 : 0);
            }

            public String toString() {
                return "Content(title=" + this.title + ", questions=" + this.questions + ", showCreatingTicketProgress=" + this.showCreatingTicketProgress + ')';
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Content(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, list, (i & 4) != 0 ? false : z);
            }

            public final String getTitle() {
                return this.title;
            }

            public final List<QuestionState> getQuestions() {
                return this.questions;
            }

            public final boolean getShowCreatingTicketProgress() {
                return this.showCreatingTicketProgress;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Content(String str, List<QuestionState> list, boolean z) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "questions");
                this.title = str;
                this.questions = list;
                this.showCreatingTicketProgress = z;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect;", "", "()V", "Finish", "None", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect$Finish;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect$None;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CreateTicketViewModel.kt */
    public static abstract class TicketSideEffect {
        public /* synthetic */ TicketSideEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect$None;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class None extends TicketSideEffect {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }
        }

        private TicketSideEffect() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect$Finish;", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$TicketSideEffect;", "()V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: CreateTicketViewModel.kt */
        public static final class Finish extends TicketSideEffect {
            public static final int $stable = 0;
            public static final Finish INSTANCE = new Finish();

            private Finish() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
