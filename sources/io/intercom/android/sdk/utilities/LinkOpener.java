package io.intercom.android.sdk.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.activities.IntercomCarouselActivity;
import io.intercom.android.sdk.activities.IntercomConversationActivity;
import io.intercom.android.sdk.activities.IntercomNoteActivity;
import io.intercom.android.sdk.activities.IntercomPostActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.helpcenter.utils.HelpCenterUrlUtilsKt;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.survey.ui.IntercomSurveyActivity;
import java.util.Locale;
import java.util.Set;

public class LinkOpener {
    private static final Twig twig = LumberMill.getLogger();

    public static void handleUrl(String str, Context context, Api api) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (isTrackingUrl(str)) {
                api.hitTrackingUrl(str);
                uri = getTargetUriFromTrackingUrl(str);
            } else {
                uri = parseUrl(str);
            }
            Set<String> helpCenterUrls = Injector.get().getAppConfigProvider().get().getHelpCenterUrls();
            String uri2 = uri.toString();
            String placeFromContext = getPlaceFromContext(context);
            if (HelpCenterUrlUtilsKt.isHelpCenterArticleUrl(uri2, helpCenterUrls)) {
                HelpCenterUrlUtilsKt.openArticle(context, HelpCenterUrlUtilsKt.extractIdFromLastSegment(uri.getLastPathSegment()), placeFromContext);
            } else if (HelpCenterUrlUtilsKt.isHelpCenterCollectionUrl(uri2, helpCenterUrls)) {
                HelpCenterUrlUtilsKt.openCollection(context, HelpCenterUrlUtilsKt.extractIdFromLastSegment(uri.getLastPathSegment()), placeFromContext);
            } else {
                openUrl(uri, context);
            }
        }
    }

    private static String getPlaceFromContext(Context context) {
        if (context instanceof IntercomCarouselActivity) {
            return "carousel_message";
        }
        if ((context instanceof IntercomPostActivity) || (context instanceof IntercomNoteActivity)) {
            return MetricTracker.Place.IN_APP;
        }
        if (context instanceof IntercomConversationActivity) {
            return "conversation";
        }
        return context instanceof IntercomSurveyActivity ? "survey" : MetricTracker.Place.PUSH;
    }

    static Uri getTargetUriFromTrackingUrl(String str) {
        Uri parse = Uri.parse(str);
        String queryParameter = parse.isHierarchical() ? parse.getQueryParameter("url") : str;
        if (queryParameter != null) {
            str = queryParameter;
        }
        return parseUrl(str);
    }

    private static Uri parseUrl(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null) {
            parse = Uri.parse("http://" + str);
        }
        return (parse.getScheme().equalsIgnoreCase("http") || parse.getScheme().equalsIgnoreCase("https")) ? normalizeScheme(parse) : parse;
    }

    private static Uri normalizeScheme(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return uri;
        }
        String lowerCase = scheme.toLowerCase(Locale.ROOT);
        if (scheme.equals(lowerCase)) {
            return uri;
        }
        return uri.buildUpon().scheme(lowerCase).build();
    }

    private static boolean isTrackingUrl(String str) {
        return str.contains("via.intercom.io");
    }

    private static void openUrl(Uri uri, Context context) {
        Intent intent = new Intent("mailto".equals(uri.getScheme()) ? "android.intent.action.SENDTO" : "android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        try {
            IntentUtils.safelyOpenIntent(context, intent);
        } catch (ActivityNotFoundException unused) {
            Twig twig2 = twig;
            twig2.e("No Activity found to handle the URL '" + uri.toString() + "'", new Object[0]);
        } catch (SecurityException e) {
            Twig twig3 = twig;
            twig3.e("Couldn't open link because of error: " + e.getMessage(), new Object[0]);
        }
    }
}
