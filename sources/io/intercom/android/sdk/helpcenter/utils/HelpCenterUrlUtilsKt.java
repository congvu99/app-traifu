package io.intercom.android.sdk.helpcenter.utils;

import android.content.Context;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000\u001a\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000\u001a\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0002\u001a \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a&\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¨\u0006\u0015"}, d2 = {"extractIdFromLastSegment", "", "lastSegment", "isHelpCenterArticleUrl", "", "url", "helpCenterUrls", "", "isHelpCenterCollectionUrl", "isHelpCenterUrl", "openArticle", "", "context", "Landroid/content/Context;", "articleId", "place", "openCollection", "collectionId", "openCollections", "collectionIds", "", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterUrlUtils.kt */
public final class HelpCenterUrlUtilsKt {
    public static final boolean isHelpCenterArticleUrl(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(set, "helpCenterUrls");
        return isHelpCenterUrl(str, set) && StringsKt.contains$default((CharSequence) str, (CharSequence) "/articles/", false, 2, (Object) null);
    }

    public static final boolean isHelpCenterCollectionUrl(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(set, "helpCenterUrls");
        return isHelpCenterUrl(str, set) && StringsKt.contains$default((CharSequence) str, (CharSequence) "/collections/", false, 2, (Object) null);
    }

    public static final String extractIdFromLastSegment(String str) {
        Intrinsics.checkNotNullParameter(str, "lastSegment");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{"-"}, false, 0, 6, (Object) null);
        return split$default.isEmpty() ^ true ? (String) split$default.get(0) : "";
    }

    public static final void openArticle(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "articleId");
        Intrinsics.checkNotNullParameter(str2, "place");
        context.startActivity(ArticleActivity.Companion.buildIntent(context, new ArticleActivity.ArticleActivityArguments(str, str2, false, 4, (DefaultConstructorMarker) null)));
    }

    public static final void openCollection(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "collectionId");
        Intrinsics.checkNotNullParameter(str2, "place");
        IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollection(context, str, str2);
    }

    public static final void openCollections(Context context, List<String> list, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "collectionIds");
        Intrinsics.checkNotNullParameter(str, "place");
        if (list.size() == 1) {
            IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollection(context, (String) CollectionsKt.first(list), str);
        } else {
            IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollections(context, list, str);
        }
    }

    private static final boolean isHelpCenterUrl(String str, Set<String> set) {
        Iterable<String> iterable = set;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (String startsWith$default : iterable) {
            if (StringsKt.startsWith$default(str, startsWith$default, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
