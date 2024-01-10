package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$commonKeyMapping$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeyMapping.kt */
public final class KeyMappingKt$commonKeyMapping$1 implements KeyMapping {
    final /* synthetic */ Function1<KeyEvent, Boolean> $shortcutModifier;

    KeyMappingKt$commonKeyMapping$1(Function1<? super KeyEvent, Boolean> function1) {
        this.$shortcutModifier = function1;
    }

    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m886mapZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (!this.$shortcutModifier.invoke(KeyEvent.m3265boximpl(keyEvent)).booleanValue() || !KeyEvent_androidKt.m3288isShiftPressedZmokQxo(keyEvent)) {
            if (this.$shortcutModifier.invoke(KeyEvent.m3265boximpl(keyEvent)).booleanValue()) {
                long r2 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
                if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m903getCEK5gGoQ()) ? true : Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m912getInsertEK5gGoQ())) {
                    return KeyCommand.COPY;
                }
                if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m919getVEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m920getXEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m900getAEK5gGoQ())) {
                    return KeyCommand.SELECT_ALL;
                }
                if (Key.m2687equalsimpl0(r2, MappedKeys.INSTANCE.m921getZEK5gGoQ())) {
                    return KeyCommand.UNDO;
                }
                return null;
            } else if (KeyEvent_androidKt.m3286isCtrlPressedZmokQxo(keyEvent)) {
                return null;
            } else {
                if (KeyEvent_androidKt.m3288isShiftPressedZmokQxo(keyEvent)) {
                    long r22 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m907getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m908getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m909getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m906getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m916getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m915getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m914getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m913getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m2687equalsimpl0(r22, MappedKeys.INSTANCE.m912getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long r23 = KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent);
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m907getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m908getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m909getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m906getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m916getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m915getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m914getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m913getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m910getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m902getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m905getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m917getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m904getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m2687equalsimpl0(r23, MappedKeys.INSTANCE.m918getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        } else if (Key.m2687equalsimpl0(KeyEvent_androidKt.m3282getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m921getZEK5gGoQ())) {
            return KeyCommand.REDO;
        } else {
            return null;
        }
    }
}
