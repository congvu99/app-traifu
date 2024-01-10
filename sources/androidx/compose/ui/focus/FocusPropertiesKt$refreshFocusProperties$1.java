package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusProperties.kt */
final class FocusPropertiesKt$refreshFocusProperties$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusModifier $this_refreshFocusProperties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusPropertiesKt$refreshFocusProperties$1(FocusModifier focusModifier) {
        super(0);
        this.$this_refreshFocusProperties = focusModifier;
    }

    public final void invoke() {
        FocusPropertiesModifier focusPropertiesModifier = this.$this_refreshFocusProperties.getFocusPropertiesModifier();
        if (focusPropertiesModifier != null) {
            focusPropertiesModifier.calculateProperties(this.$this_refreshFocusProperties.getFocusProperties());
        }
    }
}
