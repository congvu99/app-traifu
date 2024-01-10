package io.intercom.android.sdk.utilities;

import android.content.Context;
import android.content.res.Configuration;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import java.util.Locale;

public class ContextLocaliser {
    private static final String FAKE_FORMAL_COUNTRY = "FO";
    private static final String FORMAL_TAG = "form";
    private static final String SIMPLIFIED_CHINESE_COUNTRY = "CN";
    private static final String SIMPLIFIED_CHINESE_ISO_15924 = "hans";
    private static final String TRADITIONAL_CHINESE_COUNTRY = "TW";
    private static final String TRADITIONAL_CHINESE_ISO_15924 = "hant";
    private static final Twig twig = LumberMill.getLogger();
    private final Provider<AppConfig> appConfigProvider;

    public ContextLocaliser(Provider<AppConfig> provider) {
        this.appConfigProvider = provider;
    }

    public Context createLocalisedContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(convertToLocale(this.appConfigProvider.get().getLocale()));
        return context.createConfigurationContext(configuration);
    }

    public static Locale convertToLocale(String str) {
        if (str.length() <= 2) {
            return new Locale(str);
        }
        String substring = str.substring(0, 2);
        String substring2 = str.substring(3);
        if (SIMPLIFIED_CHINESE_ISO_15924.equalsIgnoreCase(substring2)) {
            substring2 = SIMPLIFIED_CHINESE_COUNTRY;
        } else if (TRADITIONAL_CHINESE_ISO_15924.equalsIgnoreCase(substring2)) {
            substring2 = TRADITIONAL_CHINESE_COUNTRY;
        } else if (FORMAL_TAG.equalsIgnoreCase(substring2)) {
            substring2 = FAKE_FORMAL_COUNTRY;
        }
        return new Locale(substring, substring2);
    }
}
