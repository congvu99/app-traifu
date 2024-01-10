package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0007\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001H\u0007\u001a-\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/focus/FocusModifier;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusModifier;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "focusOrder", "Landroidx/compose/ui/Modifier;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "focusRequester", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusOrderModifier.kt */
public final class FocusOrderModifierKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FocusOrderModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "Use focusProperties() instead", replaceWith = @ReplaceWith(expression = "this.focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties"}))
    public static final Modifier focusOrder(Modifier modifier, Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(modifier, new FocusOrderToProperties(function1));
    }

    @Deprecated(message = "Use focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester)", imports = {"androidx.compose.ui.focus.focusRequester"}))
    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester(modifier, focusRequester);
    }

    @Deprecated(message = "Use focusProperties() and focusRequester() instead", replaceWith = @ReplaceWith(expression = "this.focusRequester(focusRequester).focusProperties(focusOrderReceiver)", imports = {"androidx.compose.ui.focus.focusProperties, androidx.compose.ui.focus.focusRequester"}))
    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester, Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), new FocusOrderToProperties(function1));
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m1628customFocusSearchOMvw8(FocusModifier focusModifier, int i, LayoutDirection layoutDirection) {
        FocusRequester focusRequester;
        FocusRequester focusRequester2;
        Intrinsics.checkNotNullParameter(focusModifier, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1620getNextdhqQ8s())) {
            return focusModifier.getFocusProperties().getNext();
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1622getPreviousdhqQ8s())) {
            return focusModifier.getFocusProperties().getPrevious();
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1624getUpdhqQ8s())) {
            return focusModifier.getFocusProperties().getUp();
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1615getDowndhqQ8s())) {
            return focusModifier.getFocusProperties().getDown();
        }
        if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1619getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                focusRequester2 = focusModifier.getFocusProperties().getStart();
            } else if (i2 == 2) {
                focusRequester2 = focusModifier.getFocusProperties().getEnd();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) focusRequester2, (Object) FocusRequester.Companion.getDefault())) {
                focusRequester2 = null;
            }
            if (focusRequester2 == null) {
                return focusModifier.getFocusProperties().getLeft();
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1623getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                focusRequester = focusModifier.getFocusProperties().getEnd();
            } else if (i3 == 2) {
                focusRequester = focusModifier.getFocusProperties().getStart();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) focusRequester, (Object) FocusRequester.Companion.getDefault())) {
                focusRequester = null;
            }
            if (focusRequester2 == null) {
                return focusModifier.getFocusProperties().getRight();
            }
        } else if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1616getEnterdhqQ8s())) {
            return focusModifier.getFocusProperties().getEnter().invoke(FocusDirection.m1604boximpl(i));
        } else {
            if (FocusDirection.m1607equalsimpl0(i, FocusDirection.Companion.m1617getExitdhqQ8s())) {
                return focusModifier.getFocusProperties().getExit().invoke(FocusDirection.m1604boximpl(i));
            }
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
        return focusRequester2;
    }
}
