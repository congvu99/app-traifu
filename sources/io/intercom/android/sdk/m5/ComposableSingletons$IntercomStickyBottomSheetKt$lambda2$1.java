package io.intercom.android.sdk.m5;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.ComposableSingletons$IntercomStickyBottomSheetKt$lambda-2$1  reason: invalid class name */
/* compiled from: IntercomStickyBottomSheet.kt */
final class ComposableSingletons$IntercomStickyBottomSheetKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$IntercomStickyBottomSheetKt$lambda2$1 INSTANCE = new ComposableSingletons$IntercomStickyBottomSheetKt$lambda2$1();

    ComposableSingletons$IntercomStickyBottomSheetKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            IntercomStickyBottomSheetKt.m5107IntercomStickyBottomSheeteVqBt0c((Modifier) null, ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.HalfExpanded, (AnimationSpec<Float>) null, (Function1<? super ModalBottomSheetValue, Boolean>) null, composer, 6, 6), (Shape) null, 0.0f, 0, 0, (Function0<Unit>) null, ComposableSingletons$IntercomStickyBottomSheetKt.INSTANCE.m5104getLambda1$intercom_sdk_base_release(), composer, 12582912, 125);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
