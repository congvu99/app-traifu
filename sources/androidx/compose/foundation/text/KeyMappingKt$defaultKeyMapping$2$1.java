package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$defaultKeyMapping$2$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeyMapping.kt */
public final class KeyMappingKt$defaultKeyMapping$2$1 implements KeyMapping {
    final /* synthetic */ KeyMapping $common;

    KeyMappingKt$defaultKeyMapping$2$1(KeyMapping keyMapping) {
        this.$common = keyMapping;
    }

    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m887mapZmokQxo(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        KeyCommand keyCommand = null;
        if (KeyEvent_androidKt.m3288isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m3286isCtrlPressedZmokQxo(keyEvent)) {
            long r2 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
            if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m907getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LEFT_WORD;
            } else if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m908getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_RIGHT_WORD;
            } else if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m909getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
            } else if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m906getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
            }
        } else if (KeyEvent_androidKt.m3286isCtrlPressedZmokQxo(keyEvent)) {
            long r22 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
            if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m907getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.LEFT_WORD;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m908getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.RIGHT_WORD;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m909getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.PREV_PARAGRAPH;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m906getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.NEXT_PARAGRAPH;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m911getHEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_CHAR;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m905getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_NEXT_WORD;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m902getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_WORD;
            } else if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m901getBackslashEK5gGoQ())) {
                keyCommand = KeyCommand.DESELECT;
            }
        } else if (KeyEvent_androidKt.m3288isShiftPressedZmokQxo(keyEvent)) {
            long r23 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
            if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m914getMoveHomeEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_HOME;
            } else if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m913getMoveEndEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_END;
            }
        }
        return keyCommand == null ? this.$common.m885mapZmokQxo(keyEvent) : keyCommand;
    }
}
