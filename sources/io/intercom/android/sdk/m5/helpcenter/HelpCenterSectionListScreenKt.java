package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\b\u001a(\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0002¨\u0006\r"}, d2 = {"HelpCenterSectionListScreen", "", "viewModel", "Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;", "collectionId", "", "onArticleClicked", "Lkotlin/Function1;", "(Lio/intercom/android/sdk/helpcenter/collections/HelpCenterViewModel;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "helpCenterSectionItems", "Landroidx/compose/foundation/lazy/LazyListScope;", "state", "Lio/intercom/android/sdk/helpcenter/collections/CollectionViewState$Content$CollectionContent;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterSectionListScreen.kt */
public final class HelpCenterSectionListScreenKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HelpCenterSectionListScreen(io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel r16, java.lang.String r17, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r1 = r16
            r2 = r17
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "collectionId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -1047132436(0xffffffffc19606ec, float:-18.75338)
            r3 = r19
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            r3 = r21 & 4
            if (r3 == 0) goto L_0x0021
            io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$1 r3 = io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r15 = r3
            goto L_0x0023
        L_0x0021:
            r15 = r18
        L_0x0023:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2 r3 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2
            r4 = 0
            r3.<init>(r1, r2, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r5 = 70
            java.lang.String r6 = ""
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r6, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r3, (androidx.compose.runtime.Composer) r0, (int) r5)
            kotlinx.coroutines.flow.StateFlow r3 = r16.getState()
            r5 = 8
            r6 = 1
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r3, r4, r0, r5, r6)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r8 = r5.getCenterHorizontally()
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r7 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r5, r7, r6, r4)
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r12 = r0.changed((java.lang.Object) r3)
            boolean r13 = r0.changed((java.lang.Object) r15)
            r12 = r12 | r13
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x0074
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x007f
        L_0x0074:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$3$1 r12 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$3$1
            r12.<init>(r3, r15)
            r13 = r12
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            r0.updateRememberedValue(r13)
        L_0x007f:
            r0.endReplaceableGroup()
            r12 = r13
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r13 = 196614(0x30006, float:2.75515E-40)
            r14 = 222(0xde, float:3.11E-43)
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r0
            androidx.compose.foundation.lazy.LazyDslKt.LazyColumn(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x009d
            goto L_0x00b1
        L_0x009d:
            io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$4 r7 = new io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$4
            r0 = r7
            r1 = r16
            r2 = r17
            r3 = r15
            r4 = r20
            r5 = r21
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt.HelpCenterSectionListScreen(io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void helpCenterSectionItems(LazyListScope lazyListScope, CollectionViewState.Content.CollectionContent collectionContent, Function1<? super String, Unit> function1) {
        LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1503347771, true, new HelpCenterSectionListScreenKt$helpCenterSectionItems$1(collectionContent)), 3, (Object) null);
        List<ArticleSectionRow> sectionsUiModel = collectionContent.getSectionsUiModel();
        int i = 0;
        for (Object next : sectionsUiModel) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ArticleSectionRow articleSectionRow = (ArticleSectionRow) next;
            if (articleSectionRow instanceof ArticleSectionRow.ArticleRow) {
                LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1742265347, true, new HelpCenterSectionListScreenKt$helpCenterSectionItems$2$1(i, articleSectionRow, function1, sectionsUiModel)), 3, (Object) null);
            } else if (Intrinsics.areEqual((Object) articleSectionRow, (Object) ArticleSectionRow.FullHelpCenterRow.INSTANCE)) {
                LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableSingletons$HelpCenterSectionListScreenKt.INSTANCE.m5191getLambda3$intercom_sdk_base_release(), 3, (Object) null);
            } else if (articleSectionRow instanceof ArticleSectionRow.SectionRow) {
                LazyListScope.CC.stickyHeader$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1809195182, true, new HelpCenterSectionListScreenKt$helpCenterSectionItems$2$2(articleSectionRow)), 3, (Object) null);
            } else if (articleSectionRow instanceof ArticleSectionRow.SendMessageRow) {
                LazyListScope.CC.item$default(lazyListScope, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-780672842, true, new HelpCenterSectionListScreenKt$helpCenterSectionItems$2$3(articleSectionRow)), 3, (Object) null);
            }
            i = i2;
        }
    }
}
