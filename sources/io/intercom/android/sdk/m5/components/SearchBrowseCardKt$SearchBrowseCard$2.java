package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchBrowseCard.kt */
final class SearchBrowseCardKt$SearchBrowseCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $accessToTeammateEnabled;
    final /* synthetic */ List<Avatar> $avatars;
    final /* synthetic */ HomeCards.HomeHelpCenterData $helpCenterData;
    final /* synthetic */ boolean $isSearchFirstEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBrowseCardKt$SearchBrowseCard$2(HomeCards.HomeHelpCenterData homeHelpCenterData, boolean z, List<? extends Avatar> list, boolean z2, int i) {
        super(2);
        this.$helpCenterData = homeHelpCenterData;
        this.$isSearchFirstEnabled = z;
        this.$avatars = list;
        this.$accessToTeammateEnabled = z2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SearchBrowseCardKt.SearchBrowseCard(this.$helpCenterData, this.$isSearchFirstEnabled, this.$avatars, this.$accessToTeammateEnabled, composer, this.$$changed | 1);
    }
}
