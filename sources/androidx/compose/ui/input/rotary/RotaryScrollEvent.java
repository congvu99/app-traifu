package androidx.compose.ui.input.rotary;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.input.focus.FocusDirectedInputEvent;
import kotlin.Metadata;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "verticalScrollPixels", "", "horizontalScrollPixels", "uptimeMillis", "", "(FFJ)V", "getHorizontalScrollPixels", "()F", "getUptimeMillis", "()J", "getVerticalScrollPixels", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RotaryScrollEvent.kt */
public final class RotaryScrollEvent implements FocusDirectedInputEvent {
    public static final int $stable = 0;
    private final float horizontalScrollPixels;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    public RotaryScrollEvent(float f, float f2, long j) {
        this.verticalScrollPixels = f;
        this.horizontalScrollPixels = f2;
        this.uptimeMillis = j;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public boolean equals(Object obj) {
        if (obj instanceof RotaryScrollEvent) {
            RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) obj;
            if (rotaryScrollEvent.verticalScrollPixels == this.verticalScrollPixels) {
                if (!(rotaryScrollEvent.horizontalScrollPixels == this.horizontalScrollPixels) || rotaryScrollEvent.uptimeMillis != this.uptimeMillis) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((0 + Float.floatToIntBits(this.verticalScrollPixels)) * 31) + Float.floatToIntBits(this.horizontalScrollPixels)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.uptimeMillis);
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ')';
    }
}
