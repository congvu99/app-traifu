package io.intercom.android.sdk.utilities.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;

class ConnectivityBroadcastReceiver extends BroadcastReceiver {
    private final ConnectivityUpdateListener connectivityUpdateListener;

    interface ConnectivityUpdateListener {
        void onUpdate(NetworkState networkState);
    }

    ConnectivityBroadcastReceiver(ConnectivityUpdateListener connectivityUpdateListener2) {
        this.connectivityUpdateListener = connectivityUpdateListener2;
    }

    public void onReceive(Context context, Intent intent) {
        NetworkState networkState;
        if (intent != null && BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                networkState = NetworkState.NOT_CONNECTED;
            } else {
                networkState = NetworkState.CONNECTED;
            }
            this.connectivityUpdateListener.onUpdate(networkState);
        }
    }
}
