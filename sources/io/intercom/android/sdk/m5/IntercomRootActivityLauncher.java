package io.intercom.android.sdk.m5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.m5.IntercomScreenScenario;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J&\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lio/intercom/android/sdk/m5/IntercomRootActivityLauncher;", "", "()V", "BUNDLE", "", "BUNDLE_SCENARIO", "getIntentForScenario", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "scenario", "Lio/intercom/android/sdk/m5/IntercomScreenScenario;", "getIntercomScreenScenario", "intent", "startHelpCenterCollection", "", "collectionId", "place", "startHelpCenterCollections", "collectionIds", "", "metricPlace", "startHome", "startMessages", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivityLauncher.kt */
public final class IntercomRootActivityLauncher {
    private static final String BUNDLE = "BUNDLE";
    private static final String BUNDLE_SCENARIO = "BUNDLE_SCENARIO";
    public static final IntercomRootActivityLauncher INSTANCE = new IntercomRootActivityLauncher();

    private IntercomRootActivityLauncher() {
    }

    public final void startHome(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, IntercomRootActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_SCENARIO, IntercomScreenScenario.HomeScreen.INSTANCE);
        intent.putExtra(BUNDLE, bundle);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final Intent getIntentForScenario(Context context, IntercomScreenScenario intercomScreenScenario) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intercomScreenScenario, "scenario");
        Intent intent = new Intent(context, IntercomRootActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_SCENARIO, intercomScreenScenario);
        intent.putExtra(BUNDLE, bundle);
        intent.setFlags(268435456);
        return intent;
    }

    public final void startMessages(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(context, IntercomRootActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_SCENARIO, IntercomScreenScenario.MessagesScreen.INSTANCE);
        intent.putExtra(BUNDLE, bundle);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final IntercomScreenScenario getIntercomScreenScenario(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        Bundle bundleExtra = intent.getBundleExtra(BUNDLE);
        if (bundleExtra == null) {
            return IntercomScreenScenario.NoContent.INSTANCE;
        }
        IntercomScreenScenario intercomScreenScenario = (IntercomScreenScenario) bundleExtra.getParcelable(BUNDLE_SCENARIO);
        if (intercomScreenScenario == null) {
            return IntercomScreenScenario.NoContent.INSTANCE;
        }
        return intercomScreenScenario;
    }

    public static /* synthetic */ void startHelpCenterCollections$default(IntercomRootActivityLauncher intercomRootActivityLauncher, Context context, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        intercomRootActivityLauncher.startHelpCenterCollections(context, list, str);
    }

    public final void startHelpCenterCollections(Context context, List<String> list, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "collectionIds");
        Intrinsics.checkNotNullParameter(str, "metricPlace");
        Intent intent = new Intent(context, IntercomRootActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_SCENARIO, new IntercomScreenScenario.HelpCenterCollections(list, str));
        intent.putExtra(BUNDLE, bundle);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final void startHelpCenterCollection(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Intrinsics.checkNotNullParameter(str2, "place");
        Intent intent = new Intent(context, IntercomRootActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_SCENARIO, new IntercomScreenScenario.HelpCenterCollection(str, str2));
        intent.putExtra(BUNDLE, bundle);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
