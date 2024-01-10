package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.ComposeNavigator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavHost.kt */
final class NavHostKt$NavHost$4 extends Lambda implements Function3<String, Composer, Integer, Unit> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ MutableState<Boolean> $initialCrossfade$delegate;
    final /* synthetic */ SaveableStateHolder $saveableStateHolder;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$4(MutableState<Boolean> mutableState, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator, SaveableStateHolder saveableStateHolder) {
        super(3);
        this.$initialCrossfade$delegate = mutableState;
        this.$visibleEntries$delegate = state;
        this.$composeNavigator = composeNavigator;
        this.$saveableStateHolder = saveableStateHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, "it");
        ComposerKt.sourceInformation(composer, "C145@5657L600,145@5634L623,161@6281L147:NavHost.kt#opm8kd");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) str) ? 4 : 2;
        }
        if ((i & 91) != 18 || !composer.getSkipping()) {
            List r8 = NavHostKt.m4978NavHost$lambda5(this.$visibleEntries$delegate);
            ListIterator listIterator = r8.listIterator(r8.size());
            while (listIterator.hasPrevious()) {
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) listIterator.previous();
                if (Intrinsics.areEqual((Object) str, (Object) navBackStackEntry.getId())) {
                    Unit unit = Unit.INSTANCE;
                    MutableState<Boolean> mutableState = this.$initialCrossfade$delegate;
                    State<List<NavBackStackEntry>> state = this.$visibleEntries$delegate;
                    ComposeNavigator composeNavigator = this.$composeNavigator;
                    composer.startReplaceableGroup(-3686095);
                    ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) state) | composer.changed((Object) composeNavigator);
                    Object rememberedValue = composer.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new NavHostKt$NavHost$4$1$1(mutableState, state, composeNavigator);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceableGroup();
                    EffectsKt.DisposableEffect((Object) unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue, composer, 0);
                    NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry, this.$saveableStateHolder, ComposableLambdaKt.composableLambda(composer, 879893279, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C162@6396L18:NavHost.kt#opm8kd");
                            if ((i & 11) != 2 || !composer.getSkipping()) {
                                ((ComposeNavigator.Destination) navBackStackEntry.getDestination()).getContent$navigation_compose_release().invoke(navBackStackEntry, composer, 8);
                            } else {
                                composer.skipToGroupEnd();
                            }
                        }
                    }), composer, 456);
                    return;
                }
            }
            throw new NoSuchElementException("List contains no element matching the predicate.");
        }
        composer.skipToGroupEnd();
    }
}
