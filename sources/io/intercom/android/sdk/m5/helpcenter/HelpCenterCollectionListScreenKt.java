package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0001¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0002¨\u0006\u000f"}, d2 = {"HelpCenterCollectionListScreen", "", "viewModel", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;", "collectionIds", "", "", "onCollectionClick", "Lkotlin/Function1;", "onAutoNavigateToCollection", "(Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "helpCenterCollectionItems", "Landroidx/compose/foundation/lazy/LazyListScope;", "state", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionListContent;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterCollectionListScreen.kt */
public final class HelpCenterCollectionListScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HelpCenterCollectionListScreen(io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel r17, java.util.List<java.lang.String> r18, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r19, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22) {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "collectionIds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onCollectionClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onAutoNavigateToCollection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 753229444(0x2ce55e84, float:6.519065E-12)
            r5 = r21
            androidx.compose.runtime.Composer r0 = r5.startRestartGroup(r0)
            io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1 r5 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1
            r6 = 0
            r5.<init>(r1, r2, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.String r7 = ""
            r8 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5, (androidx.compose.runtime.Composer) r0, (int) r8)
            io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2 r5 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2
            r5.<init>(r1, r4, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5, (androidx.compose.runtime.Composer) r0, (int) r8)
            kotlinx.coroutines.flow.StateFlow r5 = r17.getState()
            r7 = 8
            r8 = 1
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r5, r6, r0, r7, r8)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r7.getCenterHorizontally()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            r9 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r7, r9, r8, r6)
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            boolean r7 = r0.changed((java.lang.Object) r5)
            boolean r8 = r0.changed((java.lang.Object) r3)
            r7 = r7 | r8
            java.lang.Object r8 = r0.rememberedValue()
            if (r7 != 0) goto L_0x007a
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r8 != r7) goto L_0x0085
        L_0x007a:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$3$1 r7 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$3$1
            r7.<init>(r5, r3)
            r8 = r7
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r0.updateRememberedValue(r8)
        L_0x0085:
            r0.endReplaceableGroup()
            r13 = r8
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r15 = 196614(0x30006, float:2.75515E-40)
            r16 = 222(0xde, float:3.11E-43)
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r11 = r12
            r12 = r14
            r14 = r0
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00a8
            goto L_0x00bd
        L_0x00a8:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$4 r7 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$4
            r0 = r7
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt.HelpCenterCollectionListScreen(io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel, java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final void helpCenterCollectionItems(LazyListScope lazyListScope, CollectionViewState.Content.CollectionListContent collectionListContent, Function1<? super String, Unit> function1) {
        LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1683105735, true, new HelpCenterCollectionListScreenKt$helpCenterCollectionItems$1(collectionListContent)), 3, (Object) null);
        List<CollectionListRow> collections = collectionListContent.getCollections();
        lazyListScope.items(collections.size(), (Function1<? super Integer, ? extends Object>) null, new HelpCenterCollectionListScreenKt$helpCenterCollectionItems$$inlined$itemsIndexed$default$2(collections), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new HelpCenterCollectionListScreenKt$helpCenterCollectionItems$$inlined$itemsIndexed$default$3(collections, function1)));
    }
}
