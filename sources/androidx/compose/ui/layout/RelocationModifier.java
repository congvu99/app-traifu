package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nø\u0001\u0001\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/RelocationModifier;", "Landroidx/compose/ui/Modifier$Element;", "computeDestination", "Landroidx/compose/ui/geometry/Rect;", "source", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "performRelocation", "", "destination", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.ERROR, message = "Please use BringIntoViewResponder instead.")
/* compiled from: RelocationModifier.kt */
public interface RelocationModifier extends Modifier.Element {

    /* renamed from: androidx.compose.ui.layout.RelocationModifier$-CC  reason: invalid class name */
    /* compiled from: RelocationModifier.kt */
    public final /* synthetic */ class CC {
    }

    Rect computeDestination(Rect rect, LayoutCoordinates layoutCoordinates);

    Object performRelocation(Rect rect, Rect rect2, Continuation<? super Unit> continuation);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RelocationModifier.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(RelocationModifier relocationModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.CC.$default$all(relocationModifier, function1);
        }

        @Deprecated
        public static boolean any(RelocationModifier relocationModifier, Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return Modifier.Element.CC.$default$any(relocationModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(RelocationModifier relocationModifier, R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.CC.$default$foldIn(relocationModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(RelocationModifier relocationModifier, R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return Modifier.Element.CC.$default$foldOut(relocationModifier, r, function2);
        }

        @Deprecated
        public static Modifier then(RelocationModifier relocationModifier, Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return Modifier.CC.$default$then(relocationModifier, modifier);
        }
    }
}
