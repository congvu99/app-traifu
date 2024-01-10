package io.intercom.android.sdk.m5.home.screens;

import io.intercom.android.sdk.m5.home.data.SpaceItemType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeContentScreen.kt */
final class HomeContentScreenKt$HomeContentScreen$5$1$1$1 extends Lambda implements Function1<SpaceItemType, Unit> {
    final /* synthetic */ Function0<Unit> $onHelpClicked;
    final /* synthetic */ Function0<Unit> $onMessagesClicked;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: HomeContentScreen.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpaceItemType.values().length];
            iArr[SpaceItemType.MESSAGES.ordinal()] = 1;
            iArr[SpaceItemType.HELP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeContentScreenKt$HomeContentScreen$5$1$1$1(Function0<Unit> function0, Function0<Unit> function02) {
        super(1);
        this.$onMessagesClicked = function0;
        this.$onHelpClicked = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SpaceItemType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SpaceItemType spaceItemType) {
        Intrinsics.checkNotNullParameter(spaceItemType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[spaceItemType.ordinal()];
        if (i == 1) {
            this.$onMessagesClicked.invoke();
        } else if (i == 2) {
            this.$onHelpClicked.invoke();
        }
    }
}
