package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.semantics.SemanticsModifier;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\rJ\u0013\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsModifierCore;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "mergeDescendants", "", "clearAndSetSemantics", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "(ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "equals", "other", "", "hashCode", "", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SemanticsModifier.kt */
public final class SemanticsModifierCore extends InspectorValueInfo implements SemanticsModifier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static AtomicInteger lastIdentifier = new AtomicInteger(0);
    private final SemanticsConfiguration semanticsConfiguration;

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

    public /* synthetic */ int getId() {
        return SemanticsModifier.CC.$default$getId(this);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemanticsModifierCore(boolean z, boolean z2, Function1 function1, Function1<InspectorInfo, Unit> function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, function1, (i & 8) != 0 ? InspectableValueKt.getNoInspectorInfo() : function12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SemanticsModifierCore(boolean z, boolean z2, Function1<? super SemanticsPropertyReceiver, Unit> function1, Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "properties");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        SemanticsConfiguration semanticsConfiguration2 = new SemanticsConfiguration();
        semanticsConfiguration2.setMergingSemanticsOfDescendants(z);
        semanticsConfiguration2.setClearingSemantics(z2);
        function1.invoke(semanticsConfiguration2);
        this.semanticsConfiguration = semanticsConfiguration2;
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        return this.semanticsConfiguration;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsModifierCore$Companion;", "", "()V", "lastIdentifier", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/compose/ui/platform/AtomicInt;", "generateSemanticsId", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SemanticsModifier.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int generateSemanticsId() {
            return SemanticsModifierCore.lastIdentifier.addAndGet(1);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SemanticsModifierCore) && Intrinsics.areEqual((Object) getSemanticsConfiguration(), (Object) ((SemanticsModifierCore) obj).getSemanticsConfiguration());
    }

    public int hashCode() {
        return getSemanticsConfiguration().hashCode();
    }
}
