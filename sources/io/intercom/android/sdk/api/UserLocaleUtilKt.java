package io.intercom.android.sdk.api;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"getUserLocaleString", "", "context", "Landroid/content/Context;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserLocaleUtil.kt */
public final class UserLocaleUtilKt {
    public static final String getUserLocaleString(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = context.getResources().getConfiguration().getLocales();
            Intrinsics.checkNotNullExpressionValue(locales, "context.resources.configuration.locales");
            List arrayList = new ArrayList();
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                Locale locale = locales.get(i);
                arrayList.add(locale.getLanguage() + '-' + locale.getCountry());
            }
            return CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        Locale locale2 = context.getResources().getConfiguration().locale;
        return locale2.getLanguage() + '-' + locale2.getCountry();
    }
}
