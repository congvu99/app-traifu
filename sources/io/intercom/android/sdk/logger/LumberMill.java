package io.intercom.android.sdk.logger;

import com.intercom.twig.Twig;
import io.intercom.android.sdk.Intercom;

public class LumberMill {
    private static final Twig BLOCK_TWIG = new Twig(5, "Intercom", false);
    private static final Twig MESSENGER_TWIG = new Twig(5, "Intercom", false);
    private static final Twig NEXUS_TWIG = new Twig(5, "Intercom realtime", false);

    public static Twig getLogger() {
        return MESSENGER_TWIG;
    }

    public static Twig getNexusTwig() {
        return NEXUS_TWIG;
    }

    public static Twig getBlocksTwig() {
        return BLOCK_TWIG;
    }

    public static void setLogLevel(@Intercom.LogLevel int i) {
        MESSENGER_TWIG.setLogLevel(i);
        NEXUS_TWIG.setLogLevel(i);
        BLOCK_TWIG.setLogLevel(i);
    }
}
