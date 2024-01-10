package com.trainerfu.android;

import android.content.Context;
import android.content.SharedPreferences;

public class LocalDB {
    private static boolean didReadFirstLaunchValue = false;
    private static boolean isFirstLaunch = false;

    public static boolean isFirstLaunch(Context context) {
        if (didReadFirstLaunchValue) {
            return isFirstLaunch;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0);
        if (sharedPreferences.contains("did_launch_once")) {
            isFirstLaunch = false;
        } else {
            sharedPreferences.edit().putBoolean("did_launch_once", true).apply();
            isFirstLaunch = true;
        }
        didReadFirstLaunchValue = true;
        return isFirstLaunch;
    }

    public static boolean didCOClientApp(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("did_co_client_app");
    }

    public static void userCOClientApp(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("did_co_client_app", true).apply();
    }

    public static boolean didSeeProgressPhotoTooltip(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("did_see_pp_tooltip");
    }

    public static void userDidSeeProgressPhotoTooltip(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("did_see_pp_tooltip", true).apply();
    }

    public static boolean didSendRegistrationEventForPPC(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("sent_registration_event_for_ppc");
    }

    public static void sentRegistrationEventForPPC(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("sent_registration_event_for_ppc", true).apply();
    }

    public static boolean didSendAddedClient1EventForPPC(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("sent_added_client_1_event_for_ppc");
    }

    public static void sentAddedClient1EventForPPC(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("sent_added_client_1_event_for_ppc", true).apply();
    }

    public static boolean didSendAddedClient2EventForPPC(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("sent_added_client_2_event_for_ppc");
    }

    public static void sentAddedClient2EventForPPC(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("sent_added_client_2_event_for_ppc", true).apply();
    }

    public static boolean didSendActivatedClientEventForPPC(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("sent_activated_client_event_for_ppc");
    }

    public static void sentActivatedClientEventForPPC(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("sent_activated_client_event_for_ppc", true).apply();
    }

    public static boolean didSendShowedPayIntentEventForPPC(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).contains("sent_showed_pay_intent_event_for_ppc");
    }

    public static void sentShowedPayIntentEventForPPC(Context context) {
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, 0).edit().putBoolean("sent_showed_pay_intent_event_for_ppc", true).apply();
    }
}
