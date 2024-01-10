package io.intercom.android.sdk.m5.components;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.http.message.TokenParser;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextWithSeparator.kt */
final class TextWithSeparatorKt$TextWithSeparator$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $firstText;
    final /* synthetic */ String $secondText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextWithSeparatorKt$TextWithSeparator$1$1(String str, String str2) {
        super(1);
        this.$firstText = str;
        this.$secondText = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.$firstText + TokenParser.SP + this.$secondText);
    }
}
