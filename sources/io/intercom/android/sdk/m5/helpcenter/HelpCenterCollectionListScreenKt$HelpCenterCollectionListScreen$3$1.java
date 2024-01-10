package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterCollectionListScreen.kt */
final class HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$3$1 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ Function1<String, Unit> $onCollectionClick;
    final /* synthetic */ State<CollectionViewState> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$3$1(State<? extends CollectionViewState> state, Function1<? super String, Unit> function1) {
        super(1);
        this.$state = state;
        this.$onCollectionClick = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyColumn");
        final CollectionViewState value = this.$state.getValue();
        if (Intrinsics.areEqual((Object) value, (Object) CollectionViewState.Initial.INSTANCE) ? true : Intrinsics.areEqual((Object) value, (Object) CollectionViewState.Loading.INSTANCE)) {
            LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$HelpCenterCollectionListScreenKt.INSTANCE.m5182getLambda1$intercom_sdk_base_release(), 3, (Object) null);
        } else if (value instanceof CollectionViewState.Error) {
            LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1642019961, true, new Function3<LazyItemScope, Composer, Integer, Unit>() {
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
                        HelpCenterErrorScreenKt.HelpCenterErrorScreen(((CollectionViewState.Error) value).getErrorState(), LazyItemScope.CC.fillParentMaxHeight$default(lazyItemScope, Modifier.Companion, 0.0f, 1, (Object) null), composer, 0, 0);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), 3, (Object) null);
        } else if (value instanceof CollectionViewState.Content) {
            CollectionViewState.Content content = (CollectionViewState.Content) value;
            if (!(content instanceof CollectionViewState.Content.CollectionContent) && (content instanceof CollectionViewState.Content.CollectionListContent)) {
                CollectionViewState.Content.CollectionListContent collectionListContent = (CollectionViewState.Content.CollectionListContent) value;
                if (collectionListContent.getCollections().isEmpty()) {
                    LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$HelpCenterCollectionListScreenKt.INSTANCE.m5183getLambda2$intercom_sdk_base_release(), 3, (Object) null);
                } else {
                    HelpCenterCollectionListScreenKt.helpCenterCollectionItems(lazyListScope, collectionListContent, this.$onCollectionClick);
                }
            }
        }
    }
}
