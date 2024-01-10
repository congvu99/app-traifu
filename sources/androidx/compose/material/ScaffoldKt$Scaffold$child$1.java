package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$Scaffold$child$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$Scaffold$child$1(long j, long j2, int i, boolean z, int i2, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, ScaffoldState scaffoldState) {
        super(3);
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty1 = i;
        this.$isFloatingActionButtonDocked = z;
        this.$floatingActionButtonPosition = i2;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$bottomBar = function23;
        this.$$dirty = i3;
        this.$snackbarHost = function32;
        this.$scaffoldState = scaffoldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Modifier modifier, Composer composer, int i) {
        int i2;
        Modifier modifier2 = modifier;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier2, "childModifier");
        ComposerKt.sourceInformation(composer2, "C179@8062L525:Scaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) modifier2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            long j = this.$backgroundColor;
            long j2 = this.$contentColor;
            final boolean z = this.$isFloatingActionButtonDocked;
            int i3 = this.$floatingActionButtonPosition;
            Function2<Composer, Integer, Unit> function2 = this.$topBar;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
            Function2<Composer, Integer, Unit> function23 = this.$bottomBar;
            int i4 = this.$$dirty;
            long j3 = j;
            AnonymousClass1 r4 = r13;
            final int i5 = i3;
            final Function2<Composer, Integer, Unit> function24 = function2;
            final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
            final Function2<Composer, Integer, Unit> function25 = function22;
            final Function2<Composer, Integer, Unit> function26 = function23;
            final int i6 = i4;
            final int i7 = this.$$dirty1;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
            final ScaffoldState scaffoldState = this.$scaffoldState;
            AnonymousClass1 r13 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C180@8164L413:Scaffold.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        boolean z = z;
                        int i2 = i5;
                        Function2<Composer, Integer, Unit> function2 = function24;
                        Function3<PaddingValues, Composer, Integer, Unit> function3 = function32;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function32 = function33;
                        final ScaffoldState scaffoldState = scaffoldState;
                        final int i3 = i6;
                        Function2<Composer, Integer, Unit> function22 = function25;
                        Function2<Composer, Integer, Unit> function23 = function26;
                        int i4 = i6;
                        ScaffoldKt.m1389ScaffoldLayoutMDYNRJg(z, i2, function2, function3, ComposableLambdaKt.composableLambda(composer, 533782017, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                ComposerKt.sourceInformation(composer, "C186@8417L45:Scaffold.kt#jmzs0o");
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    function32.invoke(scaffoldState.getSnackbarHostState(), composer, Integer.valueOf((i3 >> 9) & 112));
                                } else {
                                    composer.skipToGroupEnd();
                                }
                            }
                        }), function22, function23, composer, ((i4 >> 21) & 14) | 24576 | ((i4 >> 15) & 112) | (i4 & 896) | ((i7 >> 12) & 7168) | (458752 & i4) | ((i4 << 9) & 3670016));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            int i8 = 1572864 | (i2 & 14);
            int i9 = this.$$dirty1;
            SurfaceKt.m1419SurfaceFjzlyU(modifier, (Shape) null, j3, j2, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -1128984656, true, r4), composer, i8 | ((i9 >> 9) & 896) | ((i9 >> 9) & 7168), 50);
            return;
        }
        composer.skipToGroupEnd();
    }
}
