package androidx.compose.ui.platform;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R#\u0010\u0005\u001a\u00020\u00068WX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/WindowInfo;", "", "isWindowFocused", "", "()Z", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A$annotations", "()V", "getKeyboardModifiers-k7X9c1A", "()I", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInfo.kt */
public interface WindowInfo {
    @ExperimentalComposeUiApi
    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    int m4068getKeyboardModifiersk7X9c1A();

    boolean isWindowFocused();

    /* renamed from: androidx.compose.ui.platform.WindowInfo$-CC  reason: invalid class name */
    /* compiled from: WindowInfo.kt */
    public final /* synthetic */ class CC {
        /* renamed from: getKeyboardModifiers-k7X9c1A$annotations  reason: not valid java name */
        public static /* synthetic */ void m4070getKeyboardModifiersk7X9c1A$annotations() {
        }

        @ExperimentalComposeUiApi
        /* renamed from: $default$getKeyboardModifiers-k7X9c1A  reason: not valid java name */
        public static int m4069$default$getKeyboardModifiersk7X9c1A(WindowInfo _this) {
            return WindowInfoImpl.Companion.getGlobalKeyboardModifiers$ui_release().getValue().m3498unboximpl();
        }
    }
}
