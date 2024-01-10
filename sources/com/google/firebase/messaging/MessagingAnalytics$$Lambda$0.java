package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class MessagingAnalytics$$Lambda$0 implements Transformer {
    static final Transformer $instance = new MessagingAnalytics$$Lambda$0();

    private MessagingAnalytics$$Lambda$0() {
    }

    public Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}
