package io.intercom.android.sdk.overlay;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.ConfigModules;
import io.intercom.android.sdk.models.CustomizationColorsModel;
import io.intercom.android.sdk.overlay.DefaultLauncher;
import io.intercom.android.sdk.utilities.ColorUtils;

public class DefaultLauncherPresenter implements DefaultLauncher.Listener {
    private int bottomPadding = 0;
    DefaultLauncher defaultLauncher;
    private final LayoutInflater inflater;
    private final MetricTracker metricTracker;
    private final LauncherOpenBehaviour openBehaviour;
    private int previousUnreadCount = 0;

    public DefaultLauncherPresenter(LayoutInflater layoutInflater, LauncherOpenBehaviour launcherOpenBehaviour, MetricTracker metricTracker2) {
        this.inflater = layoutInflater;
        this.openBehaviour = launcherOpenBehaviour;
        this.metricTracker = metricTracker2;
        this.bottomPadding = getDefaultPadding(layoutInflater.getContext().getResources());
    }

    public void displayLauncherOnAttachedRoot(ViewGroup viewGroup, AppConfig appConfig) {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null && !defaultLauncher2.isAttachedToRoot(viewGroup)) {
            this.defaultLauncher.removeView();
            this.defaultLauncher = null;
        }
        if (this.defaultLauncher == null) {
            DefaultLauncher defaultLauncher3 = new DefaultLauncher(viewGroup, this.inflater, this, this.bottomPadding);
            this.defaultLauncher = defaultLauncher3;
            defaultLauncher3.fadeOnScreen();
        }
        setLauncherBackgroundColor(appConfig);
        setLauncherLogo(appConfig);
        setUnreadCount(this.previousUnreadCount);
    }

    /* access modifiers changed from: package-private */
    public DefaultLauncher getAndUnsetLauncher() {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        this.defaultLauncher = null;
        return defaultLauncher2;
    }

    /* access modifiers changed from: package-private */
    public void setLauncherBackgroundColor(int i, int i2) {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null) {
            defaultLauncher2.setLauncherColor(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLauncherBackgroundColor(AppConfig appConfig) {
        ConfigModules configModules = appConfig.getConfigModules();
        if (configModules != null) {
            CustomizationColorsModel action = configModules.getCustomization().getAction();
            setLauncherBackgroundColor(ColorUtils.parseColor(action.getForegroundLowContrastColor()), ColorUtils.parseColor(action.getBackgroundColor()));
        }
    }

    /* access modifiers changed from: package-private */
    public void setLauncherLogo(AppConfig appConfig) {
        if (this.defaultLauncher != null && !TextUtils.isEmpty(appConfig.getLauncherLogoUrl())) {
            this.defaultLauncher.setLauncherLogo(appConfig);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeLauncher() {
        DefaultLauncher defaultLauncher2 = this.defaultLauncher;
        if (defaultLauncher2 != null) {
            defaultLauncher2.fadeOffScreen((Animator.AnimatorListener) null);
            this.defaultLauncher = null;
        }
    }

    public boolean isDisplaying() {
        return this.defaultLauncher != null;
    }

    public void setUnreadCount(int i) {
        if (isDisplaying()) {
            String valueOf = String.valueOf(i);
            if (i > this.previousUnreadCount) {
                this.metricTracker.receivedNotificationFromBadgeWhenMessengerClosed(valueOf);
            }
            if (i > 0) {
                this.defaultLauncher.setBadgeCount(valueOf);
            } else {
                this.defaultLauncher.hideBadgeCount();
            }
        }
        this.previousUnreadCount = i;
    }

    public void onLauncherClicked(Context context) {
        this.openBehaviour.openMessenger(context);
    }

    private int getDefaultPadding(Resources resources) {
        return resources.getDimensionPixelSize(R.dimen.intercom_launcher_padding_bottom) + resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding);
    }

    public void setBottomPadding(int i) {
        this.bottomPadding = getDefaultPadding(this.inflater.getContext().getResources()) + i;
        if (isDisplaying()) {
            this.defaultLauncher.updateBottomPadding(this.bottomPadding);
        }
    }
}
