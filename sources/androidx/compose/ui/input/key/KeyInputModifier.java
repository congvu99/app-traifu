package androidx.compose.ui.input.key;

import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B4\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u001b\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u001b\u0010*\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010'R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/ui/input/key/KeyInputModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "<set-?>", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreviewKeyEvent", "parent", "getParent", "()Landroidx/compose/ui/input/key/KeyInputModifier;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPlaced", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "processKeyInput", "keyEvent", "processKeyInput-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "propagateKeyEvent", "propagateKeyEvent-ZmokQxo", "propagatePreviewKeyEvent", "propagatePreviewKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeyInputModifier.kt */
public final class KeyInputModifier implements ModifierLocalConsumer, ModifierLocalProvider<KeyInputModifier>, OnPlacedModifier {
    private FocusModifier focusModifier;
    private LayoutNode layoutNode;
    private final Function1<KeyEvent, Boolean> onKeyEvent;
    private final Function1<KeyEvent, Boolean> onPreviewKeyEvent;
    private KeyInputModifier parent;

    public /* synthetic */ boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldIn(this, r, function2);
    }

    public /* synthetic */ <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldOut(this, r, function2);
    }

    public KeyInputModifier getValue() {
        return this;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public KeyInputModifier(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function12) {
        this.onKeyEvent = function1;
        this.onPreviewKeyEvent = function12;
    }

    public final Function1<KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final Function1<KeyEvent, Boolean> getOnPreviewKeyEvent() {
        return this.onPreviewKeyEvent;
    }

    public final KeyInputModifier getParent() {
        return this.parent;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public ProvidableModifierLocal<KeyInputModifier> getKey() {
        return KeyInputModifierKt.getModifierLocalKeyInput();
    }

    /* renamed from: processKeyInput-ZmokQxo  reason: not valid java name */
    public final boolean m3289processKeyInputZmokQxo(KeyEvent keyEvent) {
        FocusModifier findActiveFocusNode;
        KeyInputModifier findLastKeyInputModifier;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusModifier focusModifier2 = this.focusModifier;
        if (focusModifier2 == null || (findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusModifier2)) == null || (findLastKeyInputModifier = FocusTraversalKt.findLastKeyInputModifier(findActiveFocusNode)) == null) {
            throw new IllegalStateException("KeyEvent can't be processed because this key input node is not active.".toString());
        } else if (findLastKeyInputModifier.m3291propagatePreviewKeyEventZmokQxo(keyEvent)) {
            return true;
        } else {
            return findLastKeyInputModifier.m3290propagateKeyEventZmokQxo(keyEvent);
        }
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        MutableVector<KeyInputModifier> keyInputChildren;
        MutableVector<KeyInputModifier> keyInputChildren2;
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        FocusModifier focusModifier2 = this.focusModifier;
        if (!(focusModifier2 == null || (keyInputChildren2 = focusModifier2.getKeyInputChildren()) == null)) {
            keyInputChildren2.remove(this);
        }
        FocusModifier focusModifier3 = (FocusModifier) modifierLocalReadScope.getCurrent(FocusModifierKt.getModifierLocalParentFocusModifier());
        this.focusModifier = focusModifier3;
        if (!(focusModifier3 == null || (keyInputChildren = focusModifier3.getKeyInputChildren()) == null)) {
            keyInputChildren.add(this);
        }
        this.parent = (KeyInputModifier) modifierLocalReadScope.getCurrent(KeyInputModifierKt.getModifierLocalKeyInput());
    }

    /* renamed from: propagatePreviewKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m3291propagatePreviewKeyEventZmokQxo(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        KeyInputModifier keyInputModifier = this.parent;
        Boolean valueOf = keyInputModifier != null ? Boolean.valueOf(keyInputModifier.m3291propagatePreviewKeyEventZmokQxo(keyEvent)) : null;
        if (Intrinsics.areEqual((Object) valueOf, (Object) true)) {
            return valueOf.booleanValue();
        }
        Function1<KeyEvent, Boolean> function1 = this.onPreviewKeyEvent;
        if (function1 != null) {
            return function1.invoke(KeyEvent.m3265boximpl(keyEvent)).booleanValue();
        }
        return false;
    }

    /* renamed from: propagateKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m3290propagateKeyEventZmokQxo(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Function1<KeyEvent, Boolean> function1 = this.onKeyEvent;
        Boolean invoke = function1 != null ? function1.invoke(KeyEvent.m3265boximpl(keyEvent)) : null;
        if (Intrinsics.areEqual((Object) invoke, (Object) true)) {
            return invoke.booleanValue();
        }
        KeyInputModifier keyInputModifier = this.parent;
        if (keyInputModifier != null) {
            return keyInputModifier.m3290propagateKeyEventZmokQxo(keyEvent);
        }
        return false;
    }

    public void onPlaced(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.layoutNode = ((NodeCoordinator) layoutCoordinates).getLayoutNode();
    }
}
