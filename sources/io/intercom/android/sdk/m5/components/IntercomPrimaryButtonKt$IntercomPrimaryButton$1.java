package io.intercom.android.sdk.m5.components;

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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomPrimaryButton.kt */
final class IntercomPrimaryButtonKt$IntercomPrimaryButton$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ String $text;
    final /* synthetic */ Integer $trailingIconId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomPrimaryButtonKt$IntercomPrimaryButton$1(String str, int i, Integer num) {
        super(3);
        this.$text = str;
        this.$$dirty = i;
        this.$trailingIconId = num;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            Composer composer3 = composer2;
            TextKt.m1496TextfLXpl1I(this.$text, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m4228copyHL5avdY$default(MaterialTheme.INSTANCE.getTypography(composer3, 8).getButton(), MaterialTheme.INSTANCE.getColors(composer3, 8).m1211getOnPrimary0d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer, this.$$dirty & 14, 0, 32766);
            Integer num = this.$trailingIconId;
            if (num != null) {
                int intValue = num.intValue();
                Composer composer4 = composer;
                SpacerKt.Spacer(SizeKt.m587width3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 6)), composer4, 6);
                IconKt.m1313Iconww6aTOc(PainterResources_androidKt.painterResource(intValue, composer4, 0), (String) null, SizeKt.m582size3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), MaterialTheme.INSTANCE.getColors(composer4, 8).m1211getOnPrimary0d7_KjU(), composer4, 440, 0);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
