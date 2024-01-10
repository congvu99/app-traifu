package io.intercom.android.sdk.blocks.lib;

import androidx.core.view.GravityCompat;
import java.util.Locale;

public enum BlockAlignment {
    LEFT {
        public int getGravity() {
            return GravityCompat.START;
        }
    },
    CENTER {
        public int getGravity() {
            return 1;
        }
    },
    RIGHT {
        public int getGravity() {
            return GravityCompat.END;
        }
    };

    public abstract int getGravity();

    public static BlockAlignment alignValueOf(String str) {
        try {
            return valueOf(str.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException | NullPointerException unused) {
            return LEFT;
        }
    }
}
