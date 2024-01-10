package io.intercom.android.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercom.commons.utilities.TimeProvider;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.RetryInterceptor;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponseAdapterFactory;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.home.data.HomeCardType;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.tickets.create.data.TicketApi;
import io.intercom.android.sdk.utilities.UtilsKt;
import io.intercom.android.sdk.utilities.gson.RuntimeTypeAdapterFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static final String CACHE_NAME = "Intercom_SDK/HttpCache";
    private static final int CACHE_SIZE = 10485760;
    private static final String ENDPOINT = "/messenger/mobile/";
    private static final int INTERCOM_TRAFFIC_TAG = 46837266;
    private static final int MAX_DNS_SEGMENT_SIZE = 63;
    private static final String PARTIAL_HOSTNAME_AUS = ".mobile-messenger.au.intercom.io";
    private static final String PARTIAL_HOSTNAME_EU = ".mobile-messenger.eu.intercom.io";
    private static final String PARTIAL_HOSTNAME_US = ".mobile-messenger.intercom.com";
    private static final String PROTOCOL = "https://";
    private static Retrofit kotlinxRetrofit;
    private static Retrofit legacyRetrofit;
    public static MessengerApi messengerApi;
    private static OkHttpClient okHttpClient;

    public static Api create(Context context, AppIdentity appIdentity, UserIdentity userIdentity, Bus bus, Store<State> store, String str, Provider<AppConfig> provider, Gson gson, OpsMetricTracker opsMetricTracker) {
        return createWithNetworkClient(context, appIdentity, userIdentity, bus, createConfigurableHttpClient(context, appIdentity, userIdentity, (Interceptor) null), store, str, provider, gson, opsMetricTracker);
    }

    public static HelpCenterApi createHelpCenterApi(Context context, AppIdentity appIdentity, UserIdentity userIdentity, String str, Gson gson) {
        createRetrofit(str, createConfigurableHttpClient(context, appIdentity, userIdentity, (Interceptor) null), gson);
        return (HelpCenterApi) kotlinxRetrofit.create(HelpCenterApi.class);
    }

    public static SurveyApi createSurveyApi(Context context, AppIdentity appIdentity, UserIdentity userIdentity, String str, Gson gson) {
        createRetrofit(str, createConfigurableHttpClient(context, appIdentity, userIdentity, (Interceptor) null), gson);
        return (SurveyApi) legacyRetrofit.create(SurveyApi.class);
    }

    public static TicketApi createTicketApi(Context context, AppIdentity appIdentity, UserIdentity userIdentity, String str, Gson gson) {
        createRetrofit(str, createConfigurableHttpClient(context, appIdentity, userIdentity, (Interceptor) null), gson);
        return (TicketApi) kotlinxRetrofit.create(TicketApi.class);
    }

    public static Api createWithNetworkClient(Context context, AppIdentity appIdentity, UserIdentity userIdentity, Bus bus, OkHttpClient okHttpClient2, Store<State> store, String str, Provider<AppConfig> provider, Gson gson, OpsMetricTracker opsMetricTracker) {
        if (messengerApi == null) {
            messengerApi = createMessengerApi(okHttpClient2, str, gson);
        } else {
            OkHttpClient okHttpClient3 = okHttpClient2;
            Gson gson2 = gson;
        }
        Bus bus2 = bus;
        Store<State> store2 = store;
        return new Api(context, appIdentity, userIdentity, bus2, okHttpClient2, messengerApi, new CallbackHolder(bus2, store2), new RateLimiter(provider.get()), store2, provider, gson, opsMetricTracker);
    }

    public static OkHttpClient createConfigurableHttpClient(Context context, AppIdentity appIdentity, UserIdentity userIdentity, Interceptor interceptor) {
        if (okHttpClient == null) {
            OkHttpClient.Builder addNetworkInterceptor = new OkHttpClient.Builder().readTimeout(2, TimeUnit.MINUTES).connectTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).socketFactory(new TaggingSocketFactory(SocketFactory.getDefault(), INTERCOM_TRAFFIC_TAG)).addInterceptor(new UserIdentityInterceptor(userIdentity)).addInterceptor(new RetryInterceptor(new RetryInterceptor.Sleeper())).addInterceptor(new ShutdownInterceptor(new ShutdownState(context, appIdentity, TimeProvider.SYSTEM))).addNetworkInterceptor(HeaderInterceptor.create(context, appIdentity));
            if (interceptor != null) {
                addNetworkInterceptor.addNetworkInterceptor(interceptor);
            }
            File cacheDir = context.getCacheDir();
            if (cacheDir != null) {
                addNetworkInterceptor.cache(new Cache(new File(cacheDir.getAbsolutePath(), CACHE_NAME), 10485760));
            }
            okHttpClient = addNetworkInterceptor.build();
        }
        return okHttpClient;
    }

    private static MessengerApi createMessengerApi(OkHttpClient okHttpClient2, String str, Gson gson) {
        createRetrofit(str, okHttpClient2, new GsonBuilder().registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(HomeCards.class, "type").registerSubtype(HomeCards.HomeSpacesData.class, HomeCardType.SPACES.name().toLowerCase()).registerSubtype(HomeCards.HomeNewConversationData.class, HomeCardType.NEW_CONVERSATION.name().toLowerCase()).registerSubtype(HomeCards.HomeRecentConversationData.class, HomeCardType.RECENT_CONVERSATION.name().toLowerCase()).registerSubtype(HomeCards.HomeHelpCenterData.class, HomeCardType.HELP_CENTER.name().toLowerCase()).registerSubtype(HomeCards.HomeExternalLinkData.class, HomeCardType.EXTERNAL_LINKS.name().toLowerCase()).registerSubtype(HomeCards.HomeMessengerAppData.class, HomeCardType.MESSENGER_APP.name().toLowerCase()).registerIgnoredSubtype(HomeCards.UnSupported.class, "UnSupported")).create());
        return (MessengerApi) legacyRetrofit.create(MessengerApi.class);
    }

    private static void createRetrofit(String str, OkHttpClient okHttpClient2, Gson gson) {
        if (legacyRetrofit == null) {
            legacyRetrofit = new Retrofit.Builder().baseUrl(str).addCallAdapterFactory(new NetworkResponseAdapterFactory()).client(okHttpClient2).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        if (kotlinxRetrofit == null) {
            kotlinxRetrofit = new Retrofit.Builder().baseUrl(str).addCallAdapterFactory(new NetworkResponseAdapterFactory()).client(okHttpClient2).addConverterFactory(KotlinXConvertorFactory.INSTANCE.getConvertorFactory()).build();
        }
    }

    public static String getServerUrl(AppIdentity appIdentity, Context context) {
        String str;
        String readHostFromManifest = UtilsKt.readHostFromManifest(context);
        if (TextUtils.isEmpty(readHostFromManifest)) {
            str = getFullHostname(appIdentity.appId(), context);
        } else {
            str = createUniqueIdentifier(appIdentity.appId()) + readHostFromManifest;
        }
        return convertHostnameToUrl(str);
    }

    static String convertHostnameToUrl(String str) {
        return PROTOCOL + str + ENDPOINT;
    }

    static String getFullHostname(String str, Context context) {
        return createUniqueIdentifier(str) + getCorrectServerHostname(UtilsKt.getServerRegionFromManifest(context), context);
    }

    private static String getCorrectServerHostname(int i, Context context) {
        if (i == UtilsKt.getRegionCode(context, R.integer.intercom_server_region_aus)) {
            return PARTIAL_HOSTNAME_AUS;
        }
        if (i == UtilsKt.getRegionCode(context, R.integer.intercom_server_region_eu)) {
            return PARTIAL_HOSTNAME_EU;
        }
        if (i == UtilsKt.getRegionCode(context, R.integer.intercom_server_region_us) || i == 0) {
            LumberMill.getLogger().i("Defaulting to US region, since no explicit region was mentioned. For more info on regions, please visit Intercom Android SDK documentation", new Object[0]);
            return PARTIAL_HOSTNAME_US;
        }
        LumberMill.getLogger().e("Incorrect value for region is provided in AndroidManifest.xml file. Please use one of the available regions values from provided list. For more info on regions, please visit Intercom Android SDK documentation", new Object[0]);
        return "";
    }

    static String createUniqueIdentifier(String str) {
        String str2 = removeInvalidCharacters(str) + "-android";
        int i = 63;
        if (str2.length() <= 63) {
            return str2;
        }
        if (str2.charAt(62) == '-') {
            i = 62;
        }
        return str2.substring(0, i);
    }

    public static String removeInvalidCharacters(String str) {
        return str.replaceAll("[^A-Za-z0-9\\-$]", "");
    }
}
