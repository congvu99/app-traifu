package io.intercom.android.sdk.m5.components;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlocksLayoutCard.kt */
final class BlocksLayoutCardKt$BlocksLayoutCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ViewGroup $blocksLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlocksLayoutCardKt$BlocksLayoutCard$1(ViewGroup viewGroup) {
        super(2);
        this.$blocksLayout = viewGroup;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final ViewGroup viewGroup = this.$blocksLayout;
            AndroidView_androidKt.AndroidView(new Function1<Context, ViewGroup>() {
                public final ViewGroup invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "it");
                    ViewGroup viewGroup = viewGroup;
                    viewGroup.setPadding(0, 0, 0, 0);
                    return viewGroup;
                }
            }, (Modifier) null, (Function1) null, composer, 0, 6);
            return;
        }
        composer.skipToGroupEnd();
    }
}
