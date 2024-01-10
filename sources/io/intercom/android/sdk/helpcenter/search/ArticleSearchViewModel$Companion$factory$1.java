package io.intercom.android.sdk.helpcenter.search;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.store.Selectors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"io/intercom/android/sdk/helpcenter/search/ArticleSearchViewModel$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleSearchViewModel.kt */
public final class ArticleSearchViewModel$Companion$factory$1 implements ViewModelProvider.Factory {
    final /* synthetic */ HelpCenterApi $helpCenterApi;
    final /* synthetic */ boolean $isFromSearchBrowse;

    public /* synthetic */ <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
    }

    ArticleSearchViewModel$Companion$factory$1(HelpCenterApi helpCenterApi, boolean z) {
        this.$helpCenterApi = helpCenterApi;
        this.$isFromSearchBrowse = z;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        AppConfig appConfig = Injector.get().getAppConfigProvider().get();
        TeamPresence teamPresence = (TeamPresence) Injector.get().getStore().select(Selectors.TEAM_PRESENCE);
        MetricTracker metricTracker = Injector.get().getMetricTracker();
        Bus bus = Injector.get().getBus();
        HelpCenterApi helpCenterApi = this.$helpCenterApi;
        Intrinsics.checkNotNullExpressionValue(appConfig, "get()");
        Intrinsics.checkNotNullExpressionValue(teamPresence, "select(Selectors.TEAM_PRESENCE)");
        Intrinsics.checkNotNullExpressionValue(metricTracker, "metricTracker");
        boolean z = this.$isFromSearchBrowse;
        Intrinsics.checkNotNullExpressionValue(bus, "bus");
        return (ViewModel) new ArticleSearchViewModel(helpCenterApi, appConfig, teamPresence, metricTracker, z, bus, (CoroutineDispatcher) null, 64, (DefaultConstructorMarker) null);
    }
}
