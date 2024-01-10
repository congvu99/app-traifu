package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SelectionRegistrarImpl $registrarImpl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$3(SelectionRegistrarImpl selectionRegistrarImpl, Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$registrarImpl = selectionRegistrarImpl;
        this.$modifier = modifier;
        this.$manager = selectionManager;
        this.$children = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@3396L1911:SelectionContainer.kt#eksfi3");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-123806316, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:94)");
            }
            ProvidedValue[] providedValueArr = {SelectionRegistrarKt.getLocalSelectionRegistrar().provides(this.$registrarImpl)};
            final Modifier modifier = this.$modifier;
            final SelectionManager selectionManager = this.$manager;
            final Function2<Composer, Integer, Unit> function2 = this.$children;
            final int i2 = this.$$dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 935424596, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C98@3620L1677:SelectionContainer.kt#eksfi3");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935424596, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:95)");
                        }
                        Modifier then = modifier.then(selectionManager.getModifier());
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i2 = i2;
                        final SelectionManager selectionManager = selectionManager;
                        SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer, 1375295262, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                Selection selection;
                                Offset offset;
                                ResolvedTextDirection resolvedTextDirection;
                                Composer composer2 = composer;
                                int i2 = i;
                                ComposerKt.sourceInformation(composer2, "C99@3695L10,*103@3926L129,119@4623L564:SelectionContainer.kt#eksfi3");
                                if ((i2 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1375295262, i2, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:98)");
                                    }
                                    function2.invoke(composer2, Integer.valueOf((i2 >> 9) & 14));
                                    if (TouchMode_androidKt.isInTouchMode() && selectionManager.getHasFocus() && (selection = selectionManager.getSelection()) != null) {
                                        SelectionManager selectionManager = selectionManager;
                                        List listOf = CollectionsKt.listOf(true, false);
                                        int size = listOf.size();
                                        for (int i3 = 0; i3 < size; i3++) {
                                            boolean booleanValue = ((Boolean) listOf.get(i3)).booleanValue();
                                            Boolean valueOf = Boolean.valueOf(booleanValue);
                                            composer2.startReplaceableGroup(1157296644);
                                            ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
                                            boolean changed = composer2.changed((Object) valueOf);
                                            Object rememberedValue = composer.rememberedValue();
                                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = selectionManager.handleDragObserver(booleanValue);
                                                composer2.updateRememberedValue(rememberedValue);
                                            }
                                            composer.endReplaceableGroup();
                                            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                            if (booleanValue) {
                                                offset = selectionManager.m1046getStartHandlePosition_m7T9E();
                                            } else {
                                                offset = selectionManager.m1045getEndHandlePosition_m7T9E();
                                            }
                                            if (booleanValue) {
                                                resolvedTextDirection = selection.getStart().getDirection();
                                            } else {
                                                resolvedTextDirection = selection.getEnd().getDirection();
                                            }
                                            if (offset != null) {
                                                AndroidSelectionHandles_androidKt.m978SelectionHandle8fL75g(offset.m1693unboximpl(), booleanValue, resolvedTextDirection, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, composer, 196608);
                                            }
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
