package io.intercom.android.sdk.m5.helpcenter;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.m5.components.IntercomDividerKt;
import io.intercom.android.sdk.utilities.Phrase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterCollectionListScreen.kt */
final class HelpCenterCollectionListScreenKt$helpCenterCollectionItems$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ CollectionViewState.Content.CollectionListContent $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterCollectionListScreenKt$helpCenterCollectionItems$1(CollectionViewState.Content.CollectionListContent collectionListContent) {
        super(3);
        this.$state = collectionListContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
        String str;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            if (this.$state.getCollections().size() == 1) {
                composer2.startReplaceableGroup(-1048360587);
                str = StringResources_androidKt.stringResource(R.string.intercom_single_collection, composer2, 0);
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-1048360501);
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(composer);
                str = Phrase.from((Context) consume, R.string.intercom_multiple_collections).put("total_collection", this.$state.getCollections().size()).format().toString();
                composer.endReplaceableGroup();
            }
            String str2 = str;
            Modifier r2 = PaddingKt.m510padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.m4704constructorimpl((float) 16));
            TextStyle subtitle1 = MaterialTheme.INSTANCE.getTypography(composer2, 8).getSubtitle1();
            TextKt.m1496TextfLXpl1I(str2, r2, 0, 0, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, subtitle1, composer, 196656, 0, 32732);
            IntercomDividerKt.IntercomDivider((Modifier) null, composer, 0, 1);
            return;
        }
        composer.skipToGroupEnd();
    }
}
