package com.trainerfu.android;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONObject;

public class FitbitFragment extends Fragment {
    /* access modifiers changed from: private */
    public static String CALLBACK_URL = "http://app.trainerfu.com/fitbit";
    /* access modifiers changed from: private */
    public View mainView;
    /* access modifiers changed from: private */
    public OAuth20Service service;
    /* access modifiers changed from: private */
    public View view;
    /* access modifiers changed from: private */
    public WebView webView;
    private WebViewClient webViewClient = new WebViewClient() {
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (FitbitFragment.this.isAdded() && str != null && str.startsWith(FitbitFragment.CALLBACK_URL)) {
                FitbitFragment.this.webView.stopLoading();
                FitbitFragment.this.webView.setVisibility(4);
                FitbitFragment.this.mainView.setVisibility(0);
                final String queryParameter = Uri.parse(str).getQueryParameter(OAuthConstants.CODE);
                new AsyncTask<Void, Void, AsyncTaskResult<OAuth2AccessToken>>() {
                    /* access modifiers changed from: protected */
                    public AsyncTaskResult<OAuth2AccessToken> doInBackground(Void... voidArr) {
                        OAuth2AccessToken oAuth2AccessToken;
                        Exception exc = null;
                        try {
                            oAuth2AccessToken = FitbitFragment.this.service.getAccessToken(queryParameter);
                        } catch (Exception e) {
                            Exception exc2 = e;
                            oAuth2AccessToken = null;
                            exc = exc2;
                        }
                        if (exc != null) {
                            return new AsyncTaskResult<>(exc);
                        }
                        return new AsyncTaskResult<>(oAuth2AccessToken);
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(AsyncTaskResult<OAuth2AccessToken> asyncTaskResult) {
                        if (asyncTaskResult.getError() != null) {
                            Util.sendGack(asyncTaskResult.getError());
                            Util.showToast(MyApplication.getAppContext(), R.string.errorcode_message_3);
                            return;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("fitbit_access_token", asyncTaskResult.getResult().getAccessToken());
                        hashMap.put("fitbit_refresh_token", asyncTaskResult.getResult().getRefreshToken());
                        new BaseHttpClient().post("/users/myself/fitbit_credential", hashMap, new BaseResponseHandler() {
                            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                                return false;
                            }

                            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                                new BaseHttpClient().put("/users/myself/fitbit_subscription", (Map<String, Object>) null, new BaseResponseHandler() {
                                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                                        return false;
                                    }

                                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                                        FitbitFragment.this.onResume();
                                        return true;
                                    }
                                });
                                return true;
                            }
                        });
                    }
                }.execute(new Void[0]);
            }
        }
    };

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.service = (OAuth20Service) ((ServiceBuilder) ((ServiceBuilder) ((ServiceBuilder) ((ServiceBuilder) ((ServiceBuilder) new ServiceBuilder().apiKey("229F8B")).apiSecret("abefe3fc2d0c4a8d9c0e24c9a1707791")).scope("nutrition")).callback(CALLBACK_URL)).grantType(OAuthConstants.AUTHORIZATION_CODE)).build(FitbitApi.instance());
        View inflate = layoutInflater.inflate(R.layout.fitbit_view, viewGroup, false);
        this.view = inflate;
        ((TextView) inflate.findViewById(R.id.fitbit_headline)).setText(Html.fromHtml(getString(R.string.fitbitHeadline1)));
        ((TextView) this.view.findViewById(R.id.instructions_footer)).setText(Html.fromHtml(getString(R.string.fitbitInstructionFooter)));
        TextView textView = (TextView) this.view.findViewById(R.id.instruction1);
        textView.setText(Html.fromHtml(getString(R.string.fitbitInstruction1)));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) this.view.findViewById(R.id.integrationEnabled)).setText(Html.fromHtml(getString(R.string.fitbitIntegrationEnabled)));
        TextView textView2 = (TextView) this.view.findViewById(R.id.instruction1);
        TextView textView3 = (TextView) this.view.findViewById(R.id.instruction2);
        WebView webView2 = (WebView) this.view.findViewById(R.id.webView);
        this.webView = webView2;
        webView2.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setBuiltInZoomControls(true);
        this.webView.getSettings().setDisplayZoomControls(false);
        this.webView.getSettings().setCacheMode(2);
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.setWebViewClient(this.webViewClient);
        this.mainView = this.view.findViewById(R.id.mainView);
        SpannableString spannableString = new SpannableString(getString(R.string.fitbitInstruction1));
        spannableString.setSpan(new ClickableSpan() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }

            public void onClick(View view) {
                FitbitFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.fitbit.FitbitMobile&hl=en\"")));
            }
        }, 0, 10, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 0, 10, 33);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString2 = new SpannableString(getString(R.string.fitbitInstruction2));
        spannableString2.setSpan(new ClickableSpan() {
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }

            public void onClick(View view) {
                String authorizationUrl = FitbitFragment.this.service.getAuthorizationUrl();
                FitbitFragment.this.webView.setVisibility(0);
                FitbitFragment.this.mainView.setVisibility(8);
                FitbitFragment.this.webView.loadUrl(authorizationUrl);
            }
        }, 0, 10, 33);
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 0, 10, 33);
        textView3.setText(spannableString2);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        return this.view;
    }

    public void onResume() {
        super.onResume();
        new BaseHttpClient().get("/users/myself/fitbit_credential", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    if (FitbitFragment.this.view == null || !FitbitFragment.this.isAdded()) {
                        return true;
                    }
                    View findViewById = FitbitFragment.this.getView().findViewById(R.id.notEnabled);
                    View findViewById2 = FitbitFragment.this.getView().findViewById(R.id.enabled);
                    if (!jSONObject.getBoolean("integration_enabled")) {
                        findViewById.setVisibility(0);
                        findViewById2.setVisibility(8);
                        return true;
                    }
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(0);
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
