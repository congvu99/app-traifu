package io.intercom.android.sdk.post;

import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/Provider;", "Lio/intercom/android/sdk/identity/AppConfig;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
final class PostActivityV2$appConfigProvider$2 extends Lambda implements Function0<Provider<AppConfig>> {
    final /* synthetic */ PostActivityV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostActivityV2$appConfigProvider$2(PostActivityV2 postActivityV2) {
        super(0);
        this.this$0 = postActivityV2;
    }

    public final Provider<AppConfig> invoke() {
        return this.this$0.getInjector().getAppConfigProvider();
    }
}
