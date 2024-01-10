package io.intercom.android.sdk.m5.components.intercombadge;

import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeStateReducer;", "", "config", "Lio/intercom/android/sdk/identity/AppConfig;", "appIdentity", "Lio/intercom/android/sdk/identity/AppIdentity;", "userIdentity", "Lio/intercom/android/sdk/identity/UserIdentity;", "(Lio/intercom/android/sdk/identity/AppConfig;Lio/intercom/android/sdk/identity/AppIdentity;Lio/intercom/android/sdk/identity/UserIdentity;)V", "getAppIdentity", "()Lio/intercom/android/sdk/identity/AppIdentity;", "getConfig", "()Lio/intercom/android/sdk/identity/AppConfig;", "getUserIdentity", "()Lio/intercom/android/sdk/identity/UserIdentity;", "computeIntercomBadgeState", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomBadgeState;", "fromHomeScreen", "", "solution", "Lio/intercom/android/sdk/m5/components/intercombadge/IntercomLinkSolution;", "getCompanyForUrl", "", "companyName", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomBadgeStateReducer.kt */
public final class IntercomBadgeStateReducer {
    private final AppIdentity appIdentity;
    private final AppConfig config;
    private final UserIdentity userIdentity;

    public IntercomBadgeStateReducer() {
        this((AppConfig) null, (AppIdentity) null, (UserIdentity) null, 7, (DefaultConstructorMarker) null);
    }

    public IntercomBadgeStateReducer(AppConfig appConfig, AppIdentity appIdentity2, UserIdentity userIdentity2) {
        Intrinsics.checkNotNullParameter(appConfig, "config");
        Intrinsics.checkNotNullParameter(appIdentity2, "appIdentity");
        Intrinsics.checkNotNullParameter(userIdentity2, "userIdentity");
        this.config = appConfig;
        this.appIdentity = appIdentity2;
        this.userIdentity = userIdentity2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IntercomBadgeStateReducer(io.intercom.android.sdk.identity.AppConfig r1, io.intercom.android.sdk.identity.AppIdentity r2, io.intercom.android.sdk.identity.UserIdentity r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0017
            io.intercom.android.sdk.Injector r1 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.Provider r1 = r1.getAppConfigProvider()
            java.lang.Object r1 = r1.get()
            java.lang.String r5 = "get().appConfigProvider.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            io.intercom.android.sdk.identity.AppConfig r1 = (io.intercom.android.sdk.identity.AppConfig) r1
        L_0x0017:
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0028
            io.intercom.android.sdk.Injector r2 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.identity.AppIdentity r2 = r2.getAppIdentity()
            java.lang.String r5 = "get().appIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x0028:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0039
            io.intercom.android.sdk.Injector r3 = io.intercom.android.sdk.Injector.get()
            io.intercom.android.sdk.identity.UserIdentity r3 = r3.getUserIdentity()
            java.lang.String r4 = "get().userIdentity"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x0039:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeStateReducer.<init>(io.intercom.android.sdk.identity.AppConfig, io.intercom.android.sdk.identity.AppIdentity, io.intercom.android.sdk.identity.UserIdentity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AppConfig getConfig() {
        return this.config;
    }

    public final AppIdentity getAppIdentity() {
        return this.appIdentity;
    }

    public final UserIdentity getUserIdentity() {
        return this.userIdentity;
    }

    public final IntercomBadgeState computeIntercomBadgeState(boolean z, IntercomLinkSolution intercomLinkSolution) {
        Intrinsics.checkNotNullParameter(intercomLinkSolution, "solution");
        if (!this.config.shouldShowIntercomLink()) {
            return IntercomBadgeState.Hidden.INSTANCE;
        }
        String str = z ? "4+home-screen+we-run-on-intercom" : "4+conversation+we-run-on-intercom";
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.intercom.io/intercom-link?user_id=");
        sb.append(this.userIdentity.getUserId());
        sb.append("&powered_by_app_id=");
        sb.append(this.appIdentity.appId());
        sb.append("&company=");
        String name = this.config.getName();
        Intrinsics.checkNotNullExpressionValue(name, "config.name");
        sb.append(getCompanyForUrl(name));
        sb.append("&solution=");
        sb.append(intercomLinkSolution.getType());
        sb.append("&utm_source=android-sdk&utm_campaign=intercom-link&utm_content=");
        sb.append(str);
        sb.append("&utm_medium=messenger");
        return new IntercomBadgeState.Shown(sb.toString());
    }

    private final String getCompanyForUrl(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "{\n            URLEncoder…yName, \"UTF-8\")\n        }");
            return encode;
        } catch (UnsupportedEncodingException unused) {
            LumberMill.getLogger().i("Could not url encode the app name", new Object[0]);
            return "";
        }
    }
}
