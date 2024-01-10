package io.intercom.android.sdk.api;

import android.net.TrafficStats;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.SocketFactory;

public class TaggingSocketFactory extends SocketFactory {
    private final SocketFactory defaultFactory;
    private final int threadStatsTag;

    public TaggingSocketFactory(SocketFactory socketFactory, int i) {
        this.defaultFactory = socketFactory;
        this.threadStatsTag = i;
    }

    public Socket createSocket() throws IOException {
        return withTag(this.defaultFactory.createSocket());
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return withTag(this.defaultFactory.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return withTag(this.defaultFactory.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return withTag(this.defaultFactory.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return withTag(this.defaultFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket withTag(Socket socket) throws IOException {
        TrafficStats.setThreadStatsTag(this.threadStatsTag);
        return socket;
    }
}
