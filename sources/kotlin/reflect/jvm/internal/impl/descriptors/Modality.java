package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Modality.kt */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    /* compiled from: Modality.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Modality convertFromFlags(boolean z, boolean z2) {
            if (z) {
                return Modality.ABSTRACT;
            }
            if (z2) {
                return Modality.OPEN;
            }
            return Modality.FINAL;
        }
    }
}