package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/material/SnackbarHostState;", "invoke", "(Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.compose.material.ComposableSingletons$BackdropScaffoldKt$lambda-1$1  reason: invalid class name */
/* compiled from: BackdropScaffold.kt */
final class ComposableSingletons$BackdropScaffoldKt$lambda1$1 extends Lambda implements Function3<SnackbarHostState, Composer, Integer, Unit> {
    public static final ComposableSingletons$BackdropScaffoldKt$lambda1$1 INSTANCE = new ComposableSingletons$BackdropScaffoldKt$lambda1$1();

    ComposableSingletons$BackdropScaffoldKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SnackbarHostState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SnackbarHostState snackbarHostState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(snackbarHostState, "it");
        ComposerKt.sourceInformation(composer, "C273@12626L16:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) snackbarHostState) ? 4 : 2;
        }
        if ((i & 91) != 18 || !composer.getSkipping()) {
            SnackbarHostKt.SnackbarHost(snackbarHostState, (Modifier) null, (Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit>) null, composer, i & 14, 6);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
