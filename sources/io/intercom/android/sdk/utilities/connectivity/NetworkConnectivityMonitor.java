package io.intercom.android.sdk.utilities.connectivity;

import android.content.Context;
import android.content.IntentFilter;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import io.intercom.android.sdk.utilities.connectivity.ConnectivityBroadcastReceiver;

public class NetworkConnectivityMonitor implements ConnectivityBroadcastReceiver.ConnectivityUpdateListener {
    private boolean didRegister = false;
    private NetworkState lastState = NetworkState.UNKNOWN;
    private ConnectivityEventListener listener;
    private final ConnectivityBroadcastReceiver receiver = new ConnectivityBroadcastReceiver(this);

    public interface ConnectivityEventListener {
        void onDisconnect();

        void onReconnect();
    }

    public void onUpdate(NetworkState networkState) {
        if (networkState != this.lastState) {
            if (this.listener != null) {
                if (networkState == NetworkState.NOT_CONNECTED) {
                    this.listener.onDisconnect();
                } else if (networkState == NetworkState.CONNECTED && this.lastState == NetworkState.NOT_CONNECTED) {
                    this.listener.onReconnect();
                }
            }
            this.lastState = networkState;
        }
    }

    public synchronized void startListening(Context context) {
        if (!this.didRegister) {
            context.registerReceiver(this.receiver, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
            this.didRegister = true;
        }
    }

    public synchronized void stopListening(Context context) {
        if (this.didRegister) {
            context.unregisterReceiver(this.receiver);
            this.didRegister = false;
        }
    }

    public void setListener(ConnectivityEventListener connectivityEventListener) {
        this.listener = connectivityEventListener;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityEventListener getListener() {
        return this.listener;
    }
}
