package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import coil.compose.AsyncImagePainter;
import coil.compose.SubcomposeAsyncImageScope;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarIcon.kt */
final class AvatarIconKt$AvatarIcon$1$1$1 extends Lambda implements Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $placeHolderTextSize;
    final /* synthetic */ long $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarIconKt$AvatarIcon$1$1$1(Modifier modifier, Avatar avatar, long j, long j2, int i) {
        super(4);
        this.$modifier = modifier;
        this.$avatar = avatar;
        this.$textColor = j;
        this.$placeHolderTextSize = j2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((SubcomposeAsyncImageScope) obj, (AsyncImagePainter.State.Loading) obj2, (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, AsyncImagePainter.State.Loading loading, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(subcomposeAsyncImageScope, "$this$SubcomposeAsyncImage");
        Intrinsics.checkNotNullParameter(loading, "it");
        if ((i & 14) == 0) {
            i |= composer.changed((Object) subcomposeAsyncImageScope) ? 4 : 2;
        }
        if ((i & 651) != 130 || !composer.getSkipping()) {
            AvatarIconKt.m5125AvatarPlaceholdermhOCef0(subcomposeAsyncImageScope.align(this.$modifier, Alignment.Companion.getCenter()), this.$avatar, this.$textColor, this.$placeHolderTextSize, composer, ((this.$$dirty >> 3) & 7168) | 64, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
