package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmojiRating.kt */
final class EmojiRatingKt$EmojiRating$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ String $emojiUrl;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ boolean $showInColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmojiRatingKt$EmojiRating$2(String str, String str2, boolean z, Modifier modifier, int i, int i2) {
        super(2);
        this.$emojiUrl = str;
        this.$contentDescription = str2;
        this.$showInColor = z;
        this.$modifier = modifier;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        EmojiRatingKt.EmojiRating(this.$emojiUrl, this.$contentDescription, this.$showInColor, this.$modifier, composer, this.$$changed | 1, this.$$default);
    }
}
