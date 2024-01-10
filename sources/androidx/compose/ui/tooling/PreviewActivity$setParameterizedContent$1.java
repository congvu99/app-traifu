package androidx.compose.ui.tooling;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.FloatingActionButtonElevation;
import androidx.compose.material.FloatingActionButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
final class PreviewActivity$setParameterizedContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Object[] $previewParameters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$setParameterizedContent$1(Object[] objArr, String str, String str2) {
        super(2);
        this.$previewParameters = objArr;
        this.$className = str;
        this.$methodName = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C105@4452L30,107@4500L632:PreviewActivity.kt#hevd2p");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState = (MutableState) rememberedValue;
            final Object[] objArr = this.$previewParameters;
            final MutableState mutableState2 = mutableState;
            final String str = this.$className;
            final String str2 = this.$methodName;
            final Object[] objArr2 = this.$previewParameters;
            ScaffoldKt.m1388Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(composer2, 2137630662, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C117@4885L207:PreviewActivity.kt#hevd2p");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        Function2<Composer, Integer, Unit> r2 = ComposableSingletons$PreviewActivityKt.INSTANCE.m4596getLambda1$ui_tooling_release();
                        final MutableState<Integer> mutableState = mutableState;
                        final Object[] objArr = objArr;
                        FloatingActionButtonKt.m1310ExtendedFloatingActionButtonwqdebIU(r2, new Function0<Unit>() {
                            public final void invoke() {
                                MutableState<Integer> mutableState = mutableState;
                                mutableState.setValue(Integer.valueOf((mutableState.getValue().intValue() + 1) % objArr.length));
                            }
                        }, (Modifier) null, (Function2<? super Composer, ? super Integer, Unit>) null, (MutableInteractionSource) null, (Shape) null, 0, 0, (FloatingActionButtonElevation) null, composer, 6, TypedValues.PositionType.TYPE_CURVE_FIT);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1578412612, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(paddingValues, "it");
                    ComposerKt.sourceInformation(composer, "C:PreviewActivity.kt#hevd2p");
                    if ((i & 81) != 16 || !composer.getSkipping()) {
                        ComposableInvoker.INSTANCE.invokeComposable(str, str2, composer, objArr2[mutableState2.getValue().intValue()]);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 196608, 12582912, 131039);
            return;
        }
        composer.skipToGroupEnd();
    }
}
