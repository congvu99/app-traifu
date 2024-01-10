package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0002:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPinningModifier;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "pinnableGrandParent", "getPinnableGrandParent", "()Landroidx/compose/foundation/lazy/layout/PinnableParent;", "setPinnableGrandParent", "(Landroidx/compose/foundation/lazy/layout/PinnableParent;)V", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "pinItems", "Landroidx/compose/foundation/lazy/layout/PinnableParent$PinnedItemsHandle;", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListPinningModifier.kt */
final class LazyListPinningModifier implements ModifierLocalProvider<PinnableParent>, ModifierLocalConsumer, PinnableParent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1 EmptyPinnedItemsHandle = new LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1();
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private PinnableParent pinnableGrandParent;
    /* access modifiers changed from: private */
    public final LazyListState state;

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

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public LazyListPinningModifier(LazyListState lazyListState, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        this.state = lazyListState;
        this.beyondBoundsInfo = lazyListBeyondBoundsInfo;
    }

    public final PinnableParent getPinnableGrandParent() {
        return this.pinnableGrandParent;
    }

    public final void setPinnableGrandParent(PinnableParent pinnableParent) {
        this.pinnableGrandParent = pinnableParent;
    }

    public ProvidableModifierLocal<PinnableParent> getKey() {
        return PinnableParentKt.getModifierLocalPinnableParent();
    }

    public PinnableParent getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.pinnableGrandParent = (PinnableParent) modifierLocalReadScope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r1 = r0.pinItems();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle pinItems() {
        /*
            r2 = this;
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r0 = r2.beyondBoundsInfo
            boolean r1 = r0.hasIntervals()
            if (r1 == 0) goto L_0x0010
            androidx.compose.foundation.lazy.LazyListPinningModifier$pinItems$1$1 r1 = new androidx.compose.foundation.lazy.LazyListPinningModifier$pinItems$1$1
            r1.<init>(r2, r0)
            androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r1 = (androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle) r1
            goto L_0x001f
        L_0x0010:
            androidx.compose.foundation.lazy.layout.PinnableParent r0 = r2.pinnableGrandParent
            if (r0 == 0) goto L_0x001a
            androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r1 = r0.pinItems()
            if (r1 != 0) goto L_0x001f
        L_0x001a:
            androidx.compose.foundation.lazy.LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1 r0 = EmptyPinnedItemsHandle
            r1 = r0
            androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle r1 = (androidx.compose.foundation.lazy.layout.PinnableParent.PinnedItemsHandle) r1
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListPinningModifier.pinItems():androidx.compose.foundation.lazy.layout.PinnableParent$PinnedItemsHandle");
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPinningModifier$Companion;", "", "()V", "EmptyPinnedItemsHandle", "androidx/compose/foundation/lazy/LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1", "Landroidx/compose/foundation/lazy/LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: LazyListPinningModifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
