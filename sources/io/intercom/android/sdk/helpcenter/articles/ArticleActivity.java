package io.intercom.android.sdk.helpcenter.articles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.IntercomHelpCenterBaseActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\n"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity;", "Lio/intercom/android/sdk/helpcenter/IntercomHelpCenterBaseActivity;", "()V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ArticleActivityArguments", "Companion", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleActivity.kt */
public final class ArticleActivity extends IntercomHelpCenterBaseActivity {
    private static final String ARTICLE_ID = "ARTICLE_ID";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String IS_SEARCH_BROWSE = "IS_FROM_SEARCH_BROWSE";
    private static final String METRIC_PLACE = "METRIC_PLACE";

    @JvmStatic
    public static final Intent buildIntent(Context context, ArticleActivityArguments articleActivityArguments) {
        return Companion.buildIntent(context, articleActivityArguments);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_help_center_article);
        overridePendingTransition(R.anim.intercom_composer_slide_up, R.anim.intercom_donothing);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.intercom_donothing, R.anim.intercom_composer_slide_down);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$Companion;", "", "()V", "ARTICLE_ID", "", "IS_SEARCH_BROWSE", "METRIC_PLACE", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "articleActivityArguments", "Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$ArticleActivityArguments;", "getArguments", "intent", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Intent buildIntent(Context context, ArticleActivityArguments articleActivityArguments) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(articleActivityArguments, "articleActivityArguments");
            Intent intent = new Intent(context, ArticleActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(ArticleActivity.ARTICLE_ID, articleActivityArguments.getArticleId());
            intent.putExtra(ArticleActivity.METRIC_PLACE, articleActivityArguments.getMetricPlace());
            intent.putExtra(ArticleActivity.IS_SEARCH_BROWSE, articleActivityArguments.isFromSearchBrowse());
            return intent;
        }

        public final ArticleActivityArguments getArguments(Intent intent) {
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
            String stringExtra = intent.getStringExtra(ArticleActivity.ARTICLE_ID);
            String str = "";
            if (stringExtra == null) {
                stringExtra = str;
            }
            String stringExtra2 = intent.getStringExtra(ArticleActivity.METRIC_PLACE);
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            return new ArticleActivityArguments(stringExtra, str, intent.getBooleanExtra(ArticleActivity.IS_SEARCH_BROWSE, false));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lio/intercom/android/sdk/helpcenter/articles/ArticleActivity$ArticleActivityArguments;", "", "articleId", "", "metricPlace", "isFromSearchBrowse", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getArticleId", "()Ljava/lang/String;", "()Z", "getMetricPlace", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ArticleActivity.kt */
    public static final class ArticleActivityArguments {
        private final String articleId;
        private final boolean isFromSearchBrowse;
        private final String metricPlace;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ArticleActivityArguments(String str, String str2) {
            this(str, str2, false, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "articleId");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
        }

        public static /* synthetic */ ArticleActivityArguments copy$default(ArticleActivityArguments articleActivityArguments, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = articleActivityArguments.articleId;
            }
            if ((i & 2) != 0) {
                str2 = articleActivityArguments.metricPlace;
            }
            if ((i & 4) != 0) {
                z = articleActivityArguments.isFromSearchBrowse;
            }
            return articleActivityArguments.copy(str, str2, z);
        }

        public final String component1() {
            return this.articleId;
        }

        public final String component2() {
            return this.metricPlace;
        }

        public final boolean component3() {
            return this.isFromSearchBrowse;
        }

        public final ArticleActivityArguments copy(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "articleId");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            return new ArticleActivityArguments(str, str2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArticleActivityArguments)) {
                return false;
            }
            ArticleActivityArguments articleActivityArguments = (ArticleActivityArguments) obj;
            return Intrinsics.areEqual((Object) this.articleId, (Object) articleActivityArguments.articleId) && Intrinsics.areEqual((Object) this.metricPlace, (Object) articleActivityArguments.metricPlace) && this.isFromSearchBrowse == articleActivityArguments.isFromSearchBrowse;
        }

        public int hashCode() {
            int hashCode = ((this.articleId.hashCode() * 31) + this.metricPlace.hashCode()) * 31;
            boolean z = this.isFromSearchBrowse;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "ArticleActivityArguments(articleId=" + this.articleId + ", metricPlace=" + this.metricPlace + ", isFromSearchBrowse=" + this.isFromSearchBrowse + ')';
        }

        public ArticleActivityArguments(String str, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "articleId");
            Intrinsics.checkNotNullParameter(str2, "metricPlace");
            this.articleId = str;
            this.metricPlace = str2;
            this.isFromSearchBrowse = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ArticleActivityArguments(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? false : z);
        }

        public final String getArticleId() {
            return this.articleId;
        }

        public final String getMetricPlace() {
            return this.metricPlace;
        }

        public final boolean isFromSearchBrowse() {
            return this.isFromSearchBrowse;
        }
    }
}
