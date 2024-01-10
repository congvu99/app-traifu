package io.intercom.android.sdk.carousel.permission;

public interface PermissionResultListener {
    void requestBackgroundLocationPermission();

    void showDeniedPermanently();

    void showDeniedTemporarily();

    void showGranted();
}
