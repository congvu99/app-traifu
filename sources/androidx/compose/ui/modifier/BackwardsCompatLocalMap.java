package androidx.compose.ui.modifier;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\b\fJ&\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u000b2\u0006\u0010\u0013\u001a\u0002H\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "element", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "(Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "getElement", "()Landroidx/compose/ui/modifier/ModifierLocalProvider;", "setElement", "contains", "", "key", "Landroidx/compose/ui/modifier/ModifierLocal;", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModifierLocalNode.kt */
public final class BackwardsCompatLocalMap extends ModifierLocalMap {
    private ModifierLocalProvider<?> element;

    public final ModifierLocalProvider<?> getElement() {
        return this.element;
    }

    public final void setElement(ModifierLocalProvider<?> modifierLocalProvider) {
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "<set-?>");
        this.element = modifierLocalProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackwardsCompatLocalMap(ModifierLocalProvider<?> modifierLocalProvider) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "element");
        this.element = modifierLocalProvider;
    }

    public <T> void set$ui_release(ModifierLocal<T> modifierLocal, T t) {
        Intrinsics.checkNotNullParameter(modifierLocal, SDKConstants.PARAM_KEY);
        throw new IllegalStateException("Set is not allowed on a backwards compat provider".toString());
    }

    public <T> T get$ui_release(ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, SDKConstants.PARAM_KEY);
        if (modifierLocal == this.element.getKey()) {
            return this.element.getValue();
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean contains$ui_release(ModifierLocal<?> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, SDKConstants.PARAM_KEY);
        return modifierLocal == this.element.getKey();
    }
}
