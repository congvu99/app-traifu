package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.sections.Author;
import io.intercom.android.sdk.helpcenter.sections.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.helpcenter.components.ComposableSingletons$CollectionSummaryComponentKt$lambda-1$1  reason: invalid class name */
/* compiled from: CollectionSummaryComponent.kt */
final class ComposableSingletons$CollectionSummaryComponentKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$CollectionSummaryComponentKt$lambda1$1 INSTANCE = new ComposableSingletons$CollectionSummaryComponentKt$lambda1$1();

    ComposableSingletons$CollectionSummaryComponentKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            CollectionSummaryComponentKt.CollectionSummaryComponent(new CollectionViewState.Content.CollectionContent("Recording videos", "How to set up screen and camera recording through our app or Chrome extension.", 5, CollectionsKt.listOf(new Author("", "Hannah", new Avatar("", "SK")), new Author("", "Bob", new Avatar("", "PS")), new Author("", "Anna", new Avatar("", "VR"))), CollectionsKt.emptyList()), (Modifier) null, composer, 8, 2);
            return;
        }
        composer.skipToGroupEnd();
    }
}
