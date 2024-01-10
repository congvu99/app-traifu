package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "index", "", "data", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$deactivateToEndGroup$2 extends Lambda implements Function2<Integer, Object, Unit> {
    final /* synthetic */ int $group;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$deactivateToEndGroup$2(ComposerImpl composerImpl, int i) {
        super(2);
        this.this$0 = composerImpl;
        this.$group = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(final int i, final Object obj) {
        if (obj instanceof RememberObserver) {
            this.this$0.reader.reposition(this.$group);
            ComposerImpl composerImpl = this.this$0;
            final int i2 = this.$group;
            ComposerImpl.recordSlotTableOperation$default(composerImpl, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(slotWriter, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
                    if (Intrinsics.areEqual(obj, slotWriter.slot(i2, i))) {
                        rememberManager.forgetting((RememberObserver) obj);
                        slotWriter.set(i, Composer.Companion.getEmpty());
                        return;
                    }
                    ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                    throw new KotlinNothingValueException();
                }
            }, 1, (Object) null);
        } else if (obj instanceof RecomposeScopeImpl) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            CompositionImpl composition = recomposeScopeImpl.getComposition();
            if (composition != null) {
                composition.setPendingInvalidScopes$runtime_release(true);
                recomposeScopeImpl.release();
            }
            this.this$0.reader.reposition(this.$group);
            ComposerImpl composerImpl2 = this.this$0;
            final int i3 = this.$group;
            ComposerImpl.recordSlotTableOperation$default(composerImpl2, false, new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
                    Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(slotWriter, "slots");
                    Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
                    if (Intrinsics.areEqual(obj, slotWriter.slot(i3, i))) {
                        slotWriter.set(i, Composer.Companion.getEmpty());
                    } else {
                        ComposerKt.composeRuntimeError("Slot table is out of sync".toString());
                        throw new KotlinNothingValueException();
                    }
                }
            }, 1, (Object) null);
        }
    }
}
