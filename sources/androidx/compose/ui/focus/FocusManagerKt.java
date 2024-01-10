package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"findActiveItem", "Landroidx/compose/ui/focus/FocusModifier;", "updateProperties", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusManager.kt */
public final class FocusManagerKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FocusManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final void updateProperties(FocusModifier focusModifier) {
        FocusPropertiesKt.refreshFocusProperties(focusModifier);
        MutableVector<FocusModifier> children = focusModifier.getChildren();
        int size = children.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = children.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                updateProperties((FocusModifier) content[i]);
                i++;
            } while (i < size);
        }
    }

    /* access modifiers changed from: private */
    public static final FocusModifier findActiveItem(FocusModifier focusModifier) {
        FocusModifier findActiveItem;
        switch (WhenMappings.$EnumSwitchMapping$0[focusModifier.getFocusState().ordinal()]) {
            case 1:
            case 2:
                return focusModifier;
            case 3:
            case 4:
                FocusModifier focusedChild = focusModifier.getFocusedChild();
                if (focusedChild != null && (findActiveItem = findActiveItem(focusedChild)) != null) {
                    return findActiveItem;
                }
                throw new IllegalStateException("no child".toString());
            case 5:
            case 6:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
