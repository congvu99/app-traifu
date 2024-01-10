package androidx.compose.ui.platform;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 implements ComponentCallbacks2 {
    final /* synthetic */ Configuration $currentConfiguration;
    final /* synthetic */ ImageVectorCache $imageVectorCache;

    AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(Configuration configuration, ImageVectorCache imageVectorCache) {
        this.$currentConfiguration = configuration;
        this.$imageVectorCache = imageVectorCache;
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.$imageVectorCache.prune(this.$currentConfiguration.updateFrom(configuration));
        this.$currentConfiguration.setTo(configuration);
    }

    public void onLowMemory() {
        this.$imageVectorCache.clear();
    }

    public void onTrimMemory(int i) {
        this.$imageVectorCache.clear();
    }
}
