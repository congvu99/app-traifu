package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextInputPill.kt */
final class TextInputPillKt$TextInputPill$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $showTrailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextInputPillKt$TextInputPill$4(boolean z) {
        super(2);
        this.$showTrailingIcon = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.$showTrailingIcon) {
            IconKt.m1314Iconww6aTOc(CheckKt.getCheck(Icons.INSTANCE.getDefault()), "Looks good!", PaddingKt.m510padding3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 16)), ColorKt.Color(4280004951L), composer, 3504, 0);
        }
    }
}
