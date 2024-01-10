package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: AbstractTypeChecker.kt */
final class AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1 extends Lambda implements Function3<SimpleTypeMarker, SimpleTypeMarker, Boolean, Boolean> {
    final /* synthetic */ AbstractTypeCheckerContext $this_checkSubtypeForIntegerLiteralType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1(AbstractTypeCheckerContext abstractTypeCheckerContext) {
        super(3);
        this.$this_checkSubtypeForIntegerLiteralType = abstractTypeCheckerContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return Boolean.valueOf(invoke((SimpleTypeMarker) obj, (SimpleTypeMarker) obj2, ((Boolean) obj3).booleanValue()));
    }

    public final boolean invoke(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "integerLiteralType");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "type");
        Iterable<KotlinTypeMarker> possibleIntegerTypes = this.$this_checkSubtypeForIntegerLiteralType.possibleIntegerTypes(simpleTypeMarker);
        if (!(possibleIntegerTypes instanceof Collection) || !((Collection) possibleIntegerTypes).isEmpty()) {
            for (KotlinTypeMarker kotlinTypeMarker : possibleIntegerTypes) {
                if (Intrinsics.areEqual((Object) this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(kotlinTypeMarker), (Object) this.$this_checkSubtypeForIntegerLiteralType.typeConstructor(simpleTypeMarker2)) || (z && AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, this.$this_checkSubtypeForIntegerLiteralType, simpleTypeMarker2, kotlinTypeMarker, false, 8, (Object) null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }
}
