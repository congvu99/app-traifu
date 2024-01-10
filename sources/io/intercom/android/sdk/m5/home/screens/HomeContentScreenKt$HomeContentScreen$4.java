package io.intercom.android.sdk.m5.home.screens;

import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeContentScreen.kt */
final class HomeContentScreenKt$HomeContentScreen$4 extends Lambda implements Function1<Conversation, Unit> {
    public static final HomeContentScreenKt$HomeContentScreen$4 INSTANCE = new HomeContentScreenKt$HomeContentScreen$4();

    HomeContentScreenKt$HomeContentScreen$4() {
        super(1);
    }

    public final void invoke(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Conversation) obj);
        return Unit.INSTANCE;
    }
}
