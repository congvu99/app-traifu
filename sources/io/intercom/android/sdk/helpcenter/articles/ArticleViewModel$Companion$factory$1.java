package io.intercom.android.sdk.helpcenter.articles;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
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

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"io/intercom/android/sdk/helpcenter/articles/ArticleViewModel$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleViewModel.kt */
public final class ArticleViewModel$Companion$factory$1 implements ViewModelProvider.Factory {
    final /* synthetic */ String $baseUrl;
    final /* synthetic */ HelpCenterApi $helpCenterApi;
    final /* synthetic */ boolean $isFromSearchBrowse;
    final /* synthetic */ String $metricPlace;

    public /* synthetic */ <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
    }

    ArticleViewModel$Companion$factory$1(HelpCenterApi helpCenterApi, String str, String str2, boolean z) {
        this.$helpCenterApi = helpCenterApi;
        this.$baseUrl = str;
        this.$metricPlace = str2;
        this.$isFromSearchBrowse = z;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        HelpCenterApi helpCenterApi = this.$helpCenterApi;
        String str = this.$baseUrl;
        AppConfig appConfig = Injector.get().getAppConfigProvider().get();
        Intrinsics.checkNotNullExpressionValue(appConfig, "get().appConfigProvider.get()");
        Object select = Injector.get().getStore().select(Selectors.TEAM_PRESENCE);
        Intrinsics.checkNotNullExpressionValue(select, "get().store.select(Selectors.TEAM_PRESENCE)");
        MetricTracker metricTracker = Injector.get().getMetricTracker();
        Intrinsics.checkNotNullExpressionValue(metricTracker, "get().metricTracker");
        return (ViewModel) new ArticleViewModel(helpCenterApi, str, appConfig, (TeamPresence) select, metricTracker, this.$metricPlace, this.$isFromSearchBrowse, (CoroutineDispatcher) null, (Bus) null, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, (DefaultConstructorMarker) null);
    }
}
