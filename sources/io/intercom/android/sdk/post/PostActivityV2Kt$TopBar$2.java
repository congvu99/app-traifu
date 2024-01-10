package io.intercom.android.sdk.post;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
final class PostActivityV2Kt$TopBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onCloseClick;
    final /* synthetic */ String $subTitle;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostActivityV2Kt$TopBar$2(Modifier modifier, Avatar avatar, String str, String str2, Function0<Unit> function0, int i) {
        super(2);
        this.$modifier = modifier;
        this.$avatar = avatar;
        this.$title = str;
        this.$subTitle = str2;
        this.$onCloseClick = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PostActivityV2Kt.TopBar(this.$modifier, this.$avatar, this.$title, this.$subTitle, this.$onCloseClick, composer, this.$$changed | 1);
    }
}
