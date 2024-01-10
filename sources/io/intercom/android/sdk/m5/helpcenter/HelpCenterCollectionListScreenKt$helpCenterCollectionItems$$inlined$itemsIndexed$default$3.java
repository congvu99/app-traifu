package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import io.intercom.android.sdk.m5.helpcenter.components.BrowseAllHelpTopicsComponentKt;
import io.intercom.android.sdk.m5.helpcenter.components.CollectionRowComponentKt;
import io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class HelpCenterCollectionListScreenKt$helpCenterCollectionItems$$inlined$itemsIndexed$default$3 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $onCollectionClick$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HelpCenterCollectionListScreenKt$helpCenterCollectionItems$$inlined$itemsIndexed$default$3(List list, Function1 function1) {
        super(4);
        this.$items = list;
        this.$onCollectionClick$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$items");
        ComposerKt.sourceInformation(composer, "C180@8239L26:LazyDsl.kt#428nma");
        if ((i2 & 14) == 0) {
            i3 = (composer.changed((Object) lazyItemScope) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if ((i3 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
            }
            int i4 = i3 & 14;
            CollectionListRow collectionListRow = (CollectionListRow) this.$items.get(i);
            if ((((i3 & 112) | i4) & 641) == 128 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else if (Intrinsics.areEqual((Object) collectionListRow, (Object) CollectionListRow.FullHelpCenterRow.INSTANCE)) {
                composer.startReplaceableGroup(-1048359838);
                BrowseAllHelpTopicsComponentKt.BrowseAllHelpTopicsComponent(PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl((float) 24), 0.0f, 0.0f, 13, (Object) null), composer, 6, 0);
                composer.endReplaceableGroup();
            } else if (collectionListRow instanceof CollectionListRow.SendMessageRow) {
                composer.startReplaceableGroup(-1048359684);
                TeamPresenceComponentKt.TeamPresenceComponent(((CollectionListRow.SendMessageRow) collectionListRow).getTeamPresenceState(), composer, 8);
                composer.endReplaceableGroup();
            } else if (collectionListRow instanceof CollectionListRow.CollectionRow) {
                composer.startReplaceableGroup(-1048359536);
                CollectionRowComponentKt.CollectionRowComponent((CollectionListRow.CollectionRow) collectionListRow, this.$onCollectionClick$inlined, (Modifier) null, composer, 0, 4);
                composer.endReplaceableGroup();
            } else if (Intrinsics.areEqual((Object) collectionListRow, (Object) CollectionListRow.BrowseAllHelpTopicsAsListItem.INSTANCE)) {
                composer.startReplaceableGroup(-1048359373);
                BrowseAllHelpTopicsComponentKt.BrowseAllHelpTopicsAsItem((Modifier) null, composer, 0, 1);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1048359304);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
