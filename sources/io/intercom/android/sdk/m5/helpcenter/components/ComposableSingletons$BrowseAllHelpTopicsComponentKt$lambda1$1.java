package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.helpcenter.components.ComposableSingletons$BrowseAllHelpTopicsComponentKt$lambda-1$1  reason: invalid class name */
/* compiled from: BrowseAllHelpTopicsComponent.kt */
final class ComposableSingletons$BrowseAllHelpTopicsComponentKt$lambda1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$BrowseAllHelpTopicsComponentKt$lambda1$1 INSTANCE = new ComposableSingletons$BrowseAllHelpTopicsComponentKt$lambda1$1();

    ComposableSingletons$BrowseAllHelpTopicsComponentKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$OutlinedButton");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.intercom_article_book_icon, composer2, 0), (String) null, (Modifier) null, 0, composer, 56, 12);
            SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 6)), composer2, 6);
            Composer composer3 = composer2;
            TextKt.m1496TextfLXpl1I(StringResources_androidKt.stringResource(R.string.intercom_browse_all_help_topics, composer2, 0), (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 8).getSubtitle2(), MaterialTheme.INSTANCE.getColors(composer3, 8).m1209getOnBackground0d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer, 0, 0, 32766);
            return;
        }
        composer.skipToGroupEnd();
    }
}
