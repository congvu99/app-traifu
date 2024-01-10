package io.intercom.android.sdk.helpcenter.search;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2 implements Flow<ArticleSearchState> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ArticleSearchViewModel this$0;

    public ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2(Flow flow, ArticleSearchViewModel articleSearchViewModel) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = articleSearchViewModel;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final ArticleSearchViewModel articleSearchViewModel = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r12
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2$2$1 r0 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r12 = r0.label
                    int r12 = r12 - r2
                    r0.label = r12
                    goto L_0x0019
                L_0x0014:
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2$2$1 r0 = new io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2$2$1
                    r0.<init>(r10, r12)
                L_0x0019:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00dc
                L_0x002b:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse r11 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse) r11
                    boolean r2 = r11 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.ServerError
                    if (r2 == 0) goto L_0x0056
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r2 = r2
                    io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse$ServerError r11 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.ServerError) r11
                    int r11 = r11.getCode()
                    java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
                    r2.sendFailedSearchMetric(r11)
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState$Error r11 = io.intercom.android.sdk.helpcenter.search.ArticleSearchState.Error.INSTANCE
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState r11 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchState) r11
                    goto L_0x00d3
                L_0x0056:
                    boolean r2 = r11 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.ClientError
                    if (r2 == 0) goto L_0x005c
                    r2 = 1
                    goto L_0x005e
                L_0x005c:
                    boolean r2 = r11 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.NetworkError
                L_0x005e:
                    if (r2 == 0) goto L_0x006b
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r11 = r2
                    r2 = 0
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel.sendFailedSearchMetric$default(r11, r2, r3, r2)
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState$Error r11 = io.intercom.android.sdk.helpcenter.search.ArticleSearchState.Error.INSTANCE
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState r11 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchState) r11
                    goto L_0x00d3
                L_0x006b:
                    boolean r2 = r11 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.Success
                    if (r2 == 0) goto L_0x00df
                    io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse$Success r11 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.Success) r11
                    java.lang.Object r11 = r11.getBody()
                    java.util.List r11 = (java.util.List) r11
                    r2 = r11
                    java.util.Collection r2 = (java.util.Collection) r2
                    boolean r2 = r2.isEmpty()
                    r2 = r2 ^ r3
                    if (r2 == 0) goto L_0x0090
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState$Content r2 = new io.intercom.android.sdk.helpcenter.search.ArticleSearchState$Content
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r4 = r2
                    java.util.List r11 = r4.transformToUiModel(r11)
                    r2.<init>(r11)
                    r11 = r2
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState r11 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchState) r11
                    goto L_0x00d3
                L_0x0090:
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r11 = r2
                    boolean r11 = r11.shouldAddSendMessageRow()
                    if (r11 == 0) goto L_0x00c6
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState$NoResults r11 = new io.intercom.android.sdk.helpcenter.search.ArticleSearchState$NoResults
                    io.intercom.android.sdk.helpcenter.articles.ArticleViewState$TeamPresenceState$Companion r2 = io.intercom.android.sdk.helpcenter.articles.ArticleViewState.TeamPresenceState.Companion
                    io.intercom.android.sdk.helpcenter.articles.ArticleViewState$TeamPresenceState r5 = r2.getDefaultTeamPresenceState()
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r2 = r2
                    io.intercom.android.sdk.identity.AppConfig r6 = r2.appConfig
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r2 = r2
                    io.intercom.android.sdk.models.TeamPresence r7 = r2.teamPresence
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r2 = r2
                    boolean r9 = r2.isFromSearchBrowse
                    java.lang.String r4 = ""
                    java.lang.String r8 = "search_results"
                    io.intercom.android.sdk.helpcenter.articles.ArticleViewState$TeamPresenceState r2 = io.intercom.android.sdk.helpcenter.component.TeammateHelpKt.computeViewState(r4, r5, r6, r7, r8, r9)
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r4 = r2
                    java.lang.String r4 = r4.lastSearchedInput
                    r11.<init>(r2, r4)
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState r11 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchState) r11
                    goto L_0x00d3
                L_0x00c6:
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState$NoResultsNoTeamHelp r11 = new io.intercom.android.sdk.helpcenter.search.ArticleSearchState$NoResultsNoTeamHelp
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel r2 = r2
                    java.lang.String r2 = r2.lastSearchedInput
                    r11.<init>(r2)
                    io.intercom.android.sdk.helpcenter.search.ArticleSearchState r11 = (io.intercom.android.sdk.helpcenter.search.ArticleSearchState) r11
                L_0x00d3:
                    r0.label = r3
                    java.lang.Object r11 = r12.emit(r11, r0)
                    if (r11 != r1) goto L_0x00dc
                    return r1
                L_0x00dc:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                L_0x00df:
                    kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
                    r11.<init>()
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
