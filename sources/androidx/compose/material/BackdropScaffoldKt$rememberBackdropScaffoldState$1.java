package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$rememberBackdropScaffoldState$1 extends Lambda implements Function1<BackdropValue, Boolean> {
    public static final BackdropScaffoldKt$rememberBackdropScaffoldState$1 INSTANCE = new BackdropScaffoldKt$rememberBackdropScaffoldState$1();

    BackdropScaffoldKt$rememberBackdropScaffoldState$1() {
        super(1);
    }

    public final Boolean invoke(BackdropValue backdropValue) {
        Intrinsics.checkNotNullParameter(backdropValue, "it");
        return true;
    }
}
