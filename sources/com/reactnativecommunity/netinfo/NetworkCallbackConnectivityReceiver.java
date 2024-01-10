package com.reactnativecommunity.netinfo;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.facebook.react.bridge.ReactApplicationContext;
import com.reactnativecommunity.netinfo.types.CellularGeneration;
import com.reactnativecommunity.netinfo.types.ConnectionType;

class NetworkCallbackConnectivityReceiver extends ConnectivityReceiver {
    private final ConnectivityNetworkCallback mNetworkCallback = new ConnectivityNetworkCallback();

    public NetworkCallbackConnectivityReceiver(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: package-private */
    public void register() {
        try {
            getConnectivityManager().registerNetworkCallback(new NetworkRequest.Builder().build(), this.mNetworkCallback);
        } catch (SecurityException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void unregister() {
        try {
            getConnectivityManager().unregisterNetworkCallback(this.mNetworkCallback);
        } catch (IllegalArgumentException | SecurityException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void updateAndSend() {
        boolean z;
        Network activeNetwork = getConnectivityManager().getActiveNetwork();
        NetworkCapabilities networkCapabilities = getConnectivityManager().getNetworkCapabilities(activeNetwork);
        ConnectionType connectionType = ConnectionType.UNKNOWN;
        CellularGeneration cellularGeneration = null;
        boolean z2 = false;
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(2)) {
                connectionType = ConnectionType.BLUETOOTH;
            } else if (networkCapabilities.hasTransport(0)) {
                connectionType = ConnectionType.CELLULAR;
            } else if (networkCapabilities.hasTransport(3)) {
                connectionType = ConnectionType.ETHERNET;
            } else if (networkCapabilities.hasTransport(1)) {
                connectionType = ConnectionType.WIFI;
            } else if (networkCapabilities.hasTransport(4)) {
                connectionType = ConnectionType.VPN;
            }
            NetworkInfo networkInfo = activeNetwork != null ? getConnectivityManager().getNetworkInfo(activeNetwork) : null;
            if (Build.VERSION.SDK_INT >= 28) {
                z = !networkCapabilities.hasCapability(21);
            } else {
                z = (activeNetwork == null || networkInfo == null || networkInfo.getDetailedState().equals(NetworkInfo.DetailedState.CONNECTED)) ? false : true;
            }
            if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16) && !z) {
                z2 = true;
            }
            if (activeNetwork != null && connectionType == ConnectionType.CELLULAR && z2) {
                cellularGeneration = CellularGeneration.fromNetworkInfo(networkInfo);
            }
        } else {
            connectionType = ConnectionType.NONE;
        }
        updateConnectivity(connectionType, cellularGeneration, z2);
    }

    private class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
        private ConnectivityNetworkCallback() {
        }

        public void onAvailable(Network network) {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLosing(Network network, int i) {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLost(Network network) {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onUnavailable() {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }

        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            NetworkCallbackConnectivityReceiver.this.updateAndSend();
        }
    }
}
