package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import com.google.zxing.pdf417.PDF417Common;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopActionBar.kt */
final class TopActionBar$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TopActionBar this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopActionBar$Content$1(TopActionBar topActionBar) {
        super(2);
        this.this$0 = topActionBar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TopActionBarKt.m5180TopActionBar6oU6zVQ((Modifier) null, this.this$0.getTitle(), this.this$0.getSubtitle(), this.this$0.getAvatars(), this.this$0.getOnBackClick(), (Painter) null, this.this$0.isActive(), 0, 0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, composer, 4096, PDF417Common.NUMBER_OF_CODEWORDS);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
