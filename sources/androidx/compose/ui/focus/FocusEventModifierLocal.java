package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00012\u00020\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0006\u0010\u001a\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\tH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Landroidx/compose/ui/focus/FocusEventModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "onFocusEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "(Lkotlin/jvm/functions/Function1;)V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "focusModifiers", "Landroidx/compose/ui/focus/FocusModifier;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getOnFocusEvent", "()Lkotlin/jvm/functions/Function1;", "parent", "value", "getValue", "()Landroidx/compose/ui/focus/FocusEventModifierLocal;", "addFocusModifier", "focusModifier", "addFocusModifiers", "modifiers", "notifyIfNoFocusModifiers", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "propagateFocusEvent", "removeFocusModifier", "removeFocusModifiers", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusEventModifier.kt */
public final class FocusEventModifierLocal implements ModifierLocalProvider<FocusEventModifierLocal>, ModifierLocalConsumer {
    private final MutableVector<FocusEventModifierLocal> children = new MutableVector<>(new FocusEventModifierLocal[16], 0);
    private final MutableVector<FocusModifier> focusModifiers = new MutableVector<>(new FocusModifier[16], 0);
    private final Function1<FocusState, Unit> onFocusEvent;
    private FocusEventModifierLocal parent;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FocusEventModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            iArr[FocusStateImpl.Captured.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

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

    public FocusEventModifierLocal getValue() {
        return this;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public FocusEventModifierLocal(Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFocusEvent");
        this.onFocusEvent = function1;
    }

    public final Function1<FocusState, Unit> getOnFocusEvent() {
        return this.onFocusEvent;
    }

    public ProvidableModifierLocal<FocusEventModifierLocal> getKey() {
        return FocusEventModifierKt.getModifierLocalFocusEvent();
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        FocusEventModifierLocal focusEventModifierLocal = (FocusEventModifierLocal) modifierLocalReadScope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
        if (!Intrinsics.areEqual((Object) focusEventModifierLocal, (Object) this.parent)) {
            FocusEventModifierLocal focusEventModifierLocal2 = this.parent;
            if (focusEventModifierLocal2 != null) {
                focusEventModifierLocal2.children.remove(this);
                focusEventModifierLocal2.removeFocusModifiers(this.focusModifiers);
            }
            this.parent = focusEventModifierLocal;
            if (focusEventModifierLocal != null) {
                focusEventModifierLocal.children.add(this);
                focusEventModifierLocal.addFocusModifiers(this.focusModifiers);
            }
        }
        this.parent = (FocusEventModifierLocal) modifierLocalReadScope.getCurrent(FocusEventModifierKt.getModifierLocalFocusEvent());
    }

    public final void addFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.add(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifier(focusModifier);
        }
    }

    private final void addFocusModifiers(MutableVector<FocusModifier> mutableVector) {
        MutableVector<FocusModifier> mutableVector2 = this.focusModifiers;
        mutableVector2.addAll(mutableVector2.getSize(), mutableVector);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.addFocusModifiers(mutableVector);
        }
    }

    public final void removeFocusModifier(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        this.focusModifiers.remove(focusModifier);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifier(focusModifier);
        }
    }

    private final void removeFocusModifiers(MutableVector<FocusModifier> mutableVector) {
        this.focusModifiers.removeAll(mutableVector);
        FocusEventModifierLocal focusEventModifierLocal = this.parent;
        if (focusEventModifierLocal != null) {
            focusEventModifierLocal.removeFocusModifiers(mutableVector);
        }
    }

    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.Boolean] */
    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r4 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003b, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r5 = r7;
        r4 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void propagateFocusEvent() {
        /*
            r10 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r10.focusModifiers
            int r0 = r0.getSize()
            if (r0 == 0) goto L_0x0074
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0065
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r10.focusModifiers
            int r3 = r0.getSize()
            r4 = 0
            if (r3 <= 0) goto L_0x004c
            java.lang.Object[] r0 = r0.getContent()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r5)
            r5 = r4
            r6 = 0
        L_0x0020:
            r7 = r0[r6]
            androidx.compose.ui.focus.FocusModifier r7 = (androidx.compose.ui.focus.FocusModifier) r7
            androidx.compose.ui.focus.FocusStateImpl r8 = r7.getFocusState()
            int[] r9 = androidx.compose.ui.focus.FocusEventModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r9[r8]
            switch(r8) {
                case 1: goto L_0x0040;
                case 2: goto L_0x0040;
                case 3: goto L_0x0040;
                case 4: goto L_0x0040;
                case 5: goto L_0x0039;
                case 6: goto L_0x0034;
                default: goto L_0x0033;
            }
        L_0x0033:
            goto L_0x0045
        L_0x0034:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            goto L_0x0045
        L_0x0039:
            if (r4 != 0) goto L_0x0045
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            goto L_0x0045
        L_0x0040:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            r5 = r7
        L_0x0045:
            int r6 = r6 + 1
            if (r6 < r3) goto L_0x0020
            r0 = r4
            r4 = r5
            goto L_0x004d
        L_0x004c:
            r0 = r4
        L_0x004d:
            if (r4 == 0) goto L_0x0055
            androidx.compose.ui.focus.FocusStateImpl r1 = r4.getFocusState()
            if (r1 != 0) goto L_0x0076
        L_0x0055:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0062
            androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Deactivated
            goto L_0x0076
        L_0x0062:
            androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            goto L_0x0076
        L_0x0065:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusModifier> r0 = r10.focusModifiers
            java.lang.Object[] r0 = r0.getContent()
            r0 = r0[r1]
            androidx.compose.ui.focus.FocusModifier r0 = (androidx.compose.ui.focus.FocusModifier) r0
            androidx.compose.ui.focus.FocusStateImpl r1 = r0.getFocusState()
            goto L_0x0076
        L_0x0074:
            androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive
        L_0x0076:
            kotlin.jvm.functions.Function1<androidx.compose.ui.focus.FocusState, kotlin.Unit> r0 = r10.onFocusEvent
            r0.invoke(r1)
            androidx.compose.ui.focus.FocusEventModifierLocal r0 = r10.parent
            if (r0 == 0) goto L_0x0082
            r0.propagateFocusEvent()
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusEventModifierLocal.propagateFocusEvent():void");
    }

    public final void notifyIfNoFocusModifiers() {
        if (this.focusModifiers.isEmpty()) {
            this.onFocusEvent.invoke(FocusStateImpl.Inactive);
        }
    }
}
