package net.hockeyapp.android.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.utils.ConnectionManager;
import net.hockeyapp.android.utils.Util;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendFeedbackTask extends AsyncTask<Void, Void, HashMap<String, String>> {
    private Context context;
    private String email;
    private Handler handler;
    private boolean isFetchMessages;
    private String name;
    private ProgressDialog progressDialog;
    private String subject;
    private String text;
    private String token;
    private String urlString;

    public SendFeedbackTask(Context context2, String str, String str2, String str3, String str4, String str5, String str6, Handler handler2, boolean z) {
        this.context = context2;
        this.urlString = str;
        this.name = str2;
        this.email = str3;
        this.subject = str4;
        this.text = str5;
        this.token = str6;
        this.handler = handler2;
        this.isFetchMessages = z;
        if (context2 != null) {
            Constants.loadFromContext(context2);
        }
    }

    public void attach(Context context2) {
        this.context = context2;
    }

    public void detach() {
        this.context = null;
        this.progressDialog = null;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        String str = this.isFetchMessages ? "Retrieving discussions..." : "Sending feedback..";
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 == null || !progressDialog2.isShowing()) {
            this.progressDialog = ProgressDialog.show(this.context, "", str, true, false);
        }
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> doInBackground(Void... voidArr) {
        HttpClient httpClient = ConnectionManager.getInstance().getHttpClient();
        if (this.isFetchMessages && this.token != null) {
            return doGet(httpClient);
        }
        if (!this.isFetchMessages) {
            return doPostPut(httpClient);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(HashMap<String, String> hashMap) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            try {
                progressDialog2.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.handler != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("request_type", hashMap.get("type"));
            bundle.putString("feedback_response", hashMap.get("response"));
            bundle.putString("feedback_status", hashMap.get("status"));
            message.setData(bundle);
            this.handler.sendMessage(message);
        }
    }

    private HashMap<String, String> doPostPut(HttpClient httpClient) {
        HttpPost httpPost;
        HttpPut httpPut;
        HttpResponse httpResponse;
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("name", this.name));
            arrayList.add(new BasicNameValuePair("email", this.email));
            arrayList.add(new BasicNameValuePair("subject", this.subject));
            arrayList.add(new BasicNameValuePair("text", this.text));
            arrayList.add(new BasicNameValuePair("bundle_identifier", Constants.APP_PACKAGE));
            arrayList.add(new BasicNameValuePair("bundle_short_version", Constants.APP_VERSION_NAME));
            arrayList.add(new BasicNameValuePair("bundle_version", Constants.APP_VERSION));
            arrayList.add(new BasicNameValuePair("os_version", Constants.ANDROID_VERSION));
            arrayList.add(new BasicNameValuePair("oem", Constants.PHONE_MANUFACTURER));
            arrayList.add(new BasicNameValuePair("model", Constants.PHONE_MODEL));
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
            urlEncodedFormEntity.setContentEncoding("UTF-8");
            if (this.token != null) {
                this.urlString += this.token + "/";
                httpPut = new HttpPut(this.urlString);
                httpPost = null;
            } else {
                httpPost = new HttpPost(this.urlString);
                httpPut = null;
            }
            if (httpPut != null) {
                httpPut.setEntity(urlEncodedFormEntity);
                httpResponse = httpClient.execute(httpPut);
            } else if (httpPost != null) {
                httpPost.setEntity(urlEncodedFormEntity);
                httpResponse = httpClient.execute(httpPost);
            } else {
                httpResponse = null;
            }
            if (httpResponse == null) {
                return null;
            }
            HttpEntity entity = httpResponse.getEntity();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "send");
            hashMap.put("response", EntityUtils.toString(entity));
            hashMap.put("status", "" + httpResponse.getStatusLine().getStatusCode());
            return hashMap;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private HashMap<String, String> doGet(HttpClient httpClient) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urlString + Util.encodeParam(this.token));
        try {
            HttpResponse execute = httpClient.execute(new HttpGet(sb.toString()));
            HttpEntity entity = execute.getEntity();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "fetch");
            hashMap.put("response", EntityUtils.toString(entity));
            hashMap.put("status", "" + execute.getStatusLine().getStatusCode());
            return hashMap;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
