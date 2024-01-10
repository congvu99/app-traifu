package io.intercom.android.sdk.helpcenter.utils;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/HelpCenterEligibilityChecker;", "", "()V", "isEligibleUser", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterEligibilityChecker.kt */
public final class HelpCenterEligibilityChecker {
    public static final HelpCenterEligibilityChecker INSTANCE = new HelpCenterEligibilityChecker();

    private HelpCenterEligibilityChecker() {
    }

    public final boolean isEligibleUser() {
        Twig logger = LumberMill.getLogger();
        UserIdentity userIdentity = Injector.get().getUserIdentity();
        if (userIdentity.identityExists() && !userIdentity.isSoftReset()) {
            return true;
        }
        logger.e("The app config has not been retrieved, please call registerUnidentifiedUser() or registerIdentifiedUser(Registration) before calling displayHelpCenter().", new Object[0]);
        return false;
    }
}
