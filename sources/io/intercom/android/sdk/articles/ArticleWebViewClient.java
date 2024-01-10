package io.intercom.android.sdk.articles;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.intercom.android.sdk.helpcenter.utils.HelpCenterUrlUtilsKt;
import java.util.Set;

public class ArticleWebViewClient extends WebViewClient {
    private final String articleUrl;
    private final ArticleWebViewListener articleWebViewListener;
    private final Set<String> helpCenterUrls;
    private boolean isArticleNotFound = false;
    private boolean isLoadError;

    public ArticleWebViewClient(String str, ArticleWebViewListener articleWebViewListener2, Set<String> set) {
        this.articleUrl = str;
        this.articleWebViewListener = articleWebViewListener2;
        this.helpCenterUrls = set;
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceResponse.getStatusCode() == 404 || webResourceResponse.getStatusCode() == 401) {
            this.isLoadError = true;
            this.isArticleNotFound = true;
            this.articleWebViewListener.articleNotFound();
        }
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.isLoadError && !this.isArticleNotFound) {
            this.articleWebViewListener.onArticleFinishedLoading();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!this.isArticleNotFound) {
            this.isLoadError = false;
            this.articleWebViewListener.onArticleStartedLoading();
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        this.isLoadError = true;
        this.articleWebViewListener.onArticleLoadingError();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        Uri parse2 = Uri.parse(this.articleUrl);
        String lastPathSegment = parse.getLastPathSegment();
        String lastPathSegment2 = parse2.getLastPathSegment();
        Context context = webView.getContext();
        if (!TextUtils.isEmpty(lastPathSegment) && !TextUtils.isEmpty(lastPathSegment2) && lastPathSegment.contains(lastPathSegment2)) {
            return false;
        }
        if (HelpCenterUrlUtilsKt.isHelpCenterArticleUrl(str, this.helpCenterUrls)) {
            HelpCenterUrlUtilsKt.openArticle(context, HelpCenterUrlUtilsKt.extractIdFromLastSegment(lastPathSegment), "article");
            return true;
        } else if (HelpCenterUrlUtilsKt.isHelpCenterCollectionUrl(str, this.helpCenterUrls)) {
            HelpCenterUrlUtilsKt.openCollection(context, HelpCenterUrlUtilsKt.extractIdFromLastSegment(lastPathSegment), "article");
            return true;
        } else {
            context.startActivity(new Intent("android.intent.action.VIEW", parse));
            return true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
