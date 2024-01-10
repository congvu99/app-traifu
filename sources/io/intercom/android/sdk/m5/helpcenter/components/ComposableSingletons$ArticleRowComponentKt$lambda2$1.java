package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.helpcenter.components.ComposableSingletons$ArticleRowComponentKt$lambda-2$1  reason: invalid class name */
/* compiled from: ArticleRowComponent.kt */
final class ComposableSingletons$ArticleRowComponentKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ArticleRowComponentKt$lambda2$1 INSTANCE = new ComposableSingletons$ArticleRowComponentKt$lambda2$1();

    ComposableSingletons$ArticleRowComponentKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ArticleRowComponentKt.ArticleRowComponent(BackgroundKt.m177backgroundbw27NRU$default(Modifier.Companion, MaterialTheme.INSTANCE.getColors(composer, 8).m1218getSurface0d7_KjU(), (Shape) null, 2, (Object) null), new ArticleSectionRow.ArticleRow("", "Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum"), (Function1<? super String, Unit>) null, composer, 0, 4);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
