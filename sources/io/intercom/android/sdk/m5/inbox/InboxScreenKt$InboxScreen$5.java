package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.inbox.InboxScreenState;
import io.intercom.android.sdk.inbox.IntercomInboxViewModel;
import io.intercom.android.sdk.models.ActionType;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.EmptyState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$5 extends Lambda implements Function3<PaddingValues, Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function0<Unit> $onBrowseHelpCenterButtonClick;
    final /* synthetic */ Function0<Unit> $onSendMessageButtonClick;
    final /* synthetic */ State<InboxScreenState> $state;
    final /* synthetic */ IntercomInboxViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$5(LazyListState lazyListState, State<? extends InboxScreenState> state, IntercomInboxViewModel intercomInboxViewModel, Function0<Unit> function0, Function0<Unit> function02) {
        super(3);
        this.$lazyListState = lazyListState;
        this.$state = state;
        this.$viewModel = intercomInboxViewModel;
        this.$onSendMessageButtonClick = function0;
        this.$onBrowseHelpCenterButtonClick = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "it");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) paddingValues) ? 4 : 2;
        }
        if ((i & 91) != 18 || !composer.getSkipping()) {
            paddingValues.m520calculateBottomPaddingD9Ej5fM();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null));
            LazyListState lazyListState = this.$lazyListState;
            final State<InboxScreenState> state = this.$state;
            final IntercomInboxViewModel intercomInboxViewModel = this.$viewModel;
            final Function0<Unit> function0 = this.$onSendMessageButtonClick;
            final Function0<Unit> function02 = this.$onBrowseHelpCenterButtonClick;
            LazyDslKt.LazyColumn(navigationBarsPadding, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, centerHorizontally, (FlingBehavior) null, false, new Function1<LazyListScope, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LazyListScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyListScope lazyListScope) {
                    Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
                    final InboxScreenState value = state.getValue();
                    if (value instanceof InboxScreenState.Content) {
                        List<Conversation> inboxConversations = ((InboxScreenState.Content) value).getInboxConversations();
                        final IntercomInboxViewModel intercomInboxViewModel = intercomInboxViewModel;
                        final IntercomInboxViewModel intercomInboxViewModel2 = intercomInboxViewModel;
                        InboxContentScreenItemsKt.inboxContentScreenItems(lazyListScope, inboxConversations, new Function1<Conversation, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Conversation) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Conversation conversation) {
                                Intrinsics.checkNotNullParameter(conversation, "conversation");
                                intercomInboxViewModel.onConversationClick(conversation);
                            }
                        }, new Function1<Long, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j) {
                                intercomInboxViewModel2.fetchMoreInboxDataIfAvailable(j);
                            }
                        });
                        return;
                    }
                    boolean z = true;
                    if (value instanceof InboxScreenState.Empty) {
                        final Function0<Unit> function0 = function0;
                        final Function0<Unit> function02 = function02;
                        LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-75032882, true, new Function3<LazyItemScope, Composer, Integer, Unit>() {

                            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                            /* renamed from: io.intercom.android.sdk.m5.inbox.InboxScreenKt$InboxScreen$5$1$3$WhenMappings */
                            /* compiled from: InboxScreen.kt */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[ActionType.values().length];
                                    iArr[ActionType.MESSAGE.ordinal()] = 1;
                                    iArr[ActionType.HELP.ordinal()] = 2;
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
                                Function0<Unit> function0;
                                Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
                                if ((i & 14) == 0) {
                                    i |= composer.changed((Object) lazyItemScope) ? 4 : 2;
                                }
                                if ((i & 91) != 18 || !composer.getSkipping()) {
                                    EmptyState emptyState = ((InboxScreenState.Empty) value).getEmptyState();
                                    boolean showActionButton = ((InboxScreenState.Empty) value).getShowActionButton();
                                    int i2 = WhenMappings.$EnumSwitchMapping$0[((InboxScreenState.Empty) value).getEmptyState().getAction().getType().ordinal()];
                                    if (i2 == 1) {
                                        function0 = function0;
                                    } else if (i2 == 2) {
                                        function0 = function02;
                                    } else {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    InboxEmptyScreenKt.InboxEmptyScreen(emptyState, showActionButton, function0, LazyItemScope.CC.fillParentMaxHeight$default(lazyItemScope, Modifier.Companion, 0.0f, 1, (Object) null), composer, 0, 0);
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), 3, (Object) null);
                    } else if (value instanceof InboxScreenState.Error) {
                        LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1126108461, true, new Function3<LazyItemScope, Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
                                Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
                                if ((i & 14) == 0) {
                                    i |= composer.changed((Object) lazyItemScope) ? 4 : 2;
                                }
                                if ((i & 91) != 18 || !composer.getSkipping()) {
                                    InboxErrorScreenKt.InboxErrorScreen(((InboxScreenState.Error) value).getErrorState(), LazyItemScope.CC.fillParentMaxHeight$default(lazyItemScope, Modifier.Companion, 0.0f, 1, (Object) null), composer, 0, 0);
                                } else {
                                    composer.skipToGroupEnd();
                                }
                            }
                        }), 3, (Object) null);
                    } else {
                        if (!Intrinsics.areEqual((Object) value, (Object) InboxScreenState.Initial.INSTANCE)) {
                            z = Intrinsics.areEqual((Object) value, (Object) InboxScreenState.Loading.INSTANCE);
                        }
                        if (z) {
                            LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$InboxScreenKt.INSTANCE.m5255getLambda2$intercom_sdk_base_release(), 3, (Object) null);
                        }
                    }
                }
            }, composer, 196608, 220);
            return;
        }
        composer.skipToGroupEnd();
    }
}
