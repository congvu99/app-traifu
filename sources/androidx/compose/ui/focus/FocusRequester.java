package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterModifierLocals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "getFocusRequesterModifierLocals$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "freeFocus", "performRequestFocus", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusModifier;", "performRequestFocus$ui_release", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "requestFocus", "", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusRequester.kt */
public final class FocusRequester {
    public static final int $stable = MutableVector.$stable;
    /* access modifiers changed from: private */
    public static final FocusRequester Cancel = new FocusRequester();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FocusRequester Default = new FocusRequester();
    private final MutableVector<FocusRequesterModifierLocal> focusRequesterModifierLocals = new MutableVector<>(new FocusRequesterModifierLocal[16], 0);

    public final MutableVector<FocusRequesterModifierLocal> getFocusRequesterModifierLocals$ui_release() {
        return this.focusRequesterModifierLocals;
    }

    public final void requestFocus() {
        if (this.focusRequesterModifierLocals.isNotEmpty()) {
            performRequestFocus$ui_release(FocusRequester$requestFocus$2.INSTANCE);
            return;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final Boolean performRequestFocus$ui_release(Function1<? super FocusModifier, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFound");
        boolean z = false;
        if (Intrinsics.areEqual((Object) this, (Object) Cancel)) {
            return false;
        }
        if (Intrinsics.areEqual((Object) this, (Object) Default)) {
            return null;
        }
        MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i = 0;
            boolean z2 = false;
            do {
                FocusModifier findFocusNode = ((FocusRequesterModifierLocal) content[i]).findFocusNode();
                if (findFocusNode != null) {
                    z2 = function1.invoke(findFocusNode).booleanValue() || z2;
                }
                i++;
            } while (i < size);
            z = z2;
        }
        return Boolean.valueOf(z);
    }

    public final boolean captureFocus() {
        if (this.focusRequesterModifierLocals.isNotEmpty()) {
            MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
            int size = mutableVector.getSize();
            int i = 0;
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            boolean z = false;
            do {
                FocusModifier findFocusNode = ((FocusRequesterModifierLocal) content[i]).findFocusNode();
                if (findFocusNode != null && FocusTransactionsKt.captureFocus(findFocusNode)) {
                    z = true;
                }
                i++;
            } while (i < size);
            return z;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean freeFocus() {
        if (this.focusRequesterModifierLocals.isNotEmpty()) {
            MutableVector<FocusRequesterModifierLocal> mutableVector = this.focusRequesterModifierLocals;
            int size = mutableVector.getSize();
            int i = 0;
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            boolean z = false;
            do {
                FocusModifier findFocusNode = ((FocusRequesterModifierLocal) content[i]).findFocusNode();
                if (findFocusNode != null && FocusTransactionsKt.freeFocus(findFocusNode)) {
                    z = true;
                }
                i++;
            } while (i < size);
            return z;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FocusRequester.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @ExperimentalComposeUiApi
        public static /* synthetic */ void getCancel$annotations() {
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        @ExperimentalComposeUiApi
        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        @ExperimentalComposeUiApi
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0004H\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002J\t\u0010\r\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FocusRequester.kt */
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }
        }

        @ExperimentalComposeUiApi
        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }
}
