package com.trainerfu.android;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.work.WorkRequest;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import io.intercom.android.sdk.models.Part;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatFragment extends Fragment implements View.OnClickListener {
    /* access modifiers changed from: private */
    public String channelId = null;
    /* access modifiers changed from: private */
    public List<JSONObject> chatLines;
    /* access modifiers changed from: private */
    public ListView chatView;
    private Runnable fetchChat;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean loadedOnce;
    private EditText messageET;
    /* access modifiers changed from: private */
    public String myFirstName;
    /* access modifiers changed from: private */
    public int myUserId = 0;
    private IconTextView sendBtn;
    /* access modifiers changed from: private */
    public StableArrayAdapter stableArrayAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.chatLines = new ArrayList();
        this.loadedOnce = false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.channelId = getArguments().getString("channel_id");
        View inflate = layoutInflater.inflate(R.layout.chat_view, viewGroup, false);
        this.messageET = (EditText) inflate.findViewById(R.id.messageET);
        this.sendBtn = (IconTextView) inflate.findViewById(R.id.sendBtn);
        if (Integer.valueOf(this.channelId.split("-")[0]).intValue() == 2) {
            this.sendBtn.setText(getString(R.string.Add));
            this.messageET.setHint(getString(R.string.NewNote));
        }
        this.sendBtn.setOnClickListener(this);
        this.chatView = (ListView) inflate.findViewById(R.id.chatView);
        StableArrayAdapter stableArrayAdapter2 = new StableArrayAdapter(getActivity(), R.layout.chat_view, this.chatLines);
        this.stableArrayAdapter = stableArrayAdapter2;
        this.chatView.setAdapter(stableArrayAdapter2);
        this.fetchChat = new Runnable() {
            public void run() {
                try {
                    new BaseHttpClient().get(String.format("/channels/%s/messages", new Object[]{ChatFragment.this.channelId}), (Map<String, Object>) null, new BaseResponseHandler() {
                        public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                            return true;
                        }

                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                            try {
                                if (!ChatFragment.this.isAdded()) {
                                    return true;
                                }
                                boolean unused = ChatFragment.this.loadedOnce = true;
                                int unused2 = ChatFragment.this.myUserId = jSONObject.getInt("my_user_id");
                                String unused3 = ChatFragment.this.myFirstName = jSONObject.getString("my_first_name");
                                JSONArray jSONArray = jSONObject.getJSONArray("messages");
                                if (jSONArray.length() == 0) {
                                    return true;
                                }
                                ChatFragment.this.chatLines.clear();
                                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                    ChatFragment.this.chatLines.add(jSONArray.getJSONObject(i2));
                                }
                                ChatFragment.this.bind();
                                return true;
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                } catch (Exception unused) {
                }
                ChatFragment.this.handler.postDelayed(this, WorkRequest.MIN_BACKOFF_MILLIS);
            }
        };
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            try {
                this.chatLines.clear();
                JSONArray jSONArray = new JSONArray(bundle.getString(Part.CHAT_MESSAGE_STYLE));
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.chatLines.add(new JSONObject(jSONArray.getString(i)));
                }
                this.loadedOnce = bundle.getBoolean("loaded_once");
                bind();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.chatLines.size(); i++) {
            jSONArray.put(this.chatLines.get(i).toString());
        }
        bundle.putString(Part.CHAT_MESSAGE_STYLE, jSONArray.toString());
        bundle.putBoolean("loaded_once", this.loadedOnce);
    }

    /* access modifiers changed from: private */
    public void bind() {
        this.stableArrayAdapter.notifyDataSetChanged();
        finishReceivingMessages();
    }

    public void onResume() {
        super.onResume();
        this.handler.post(this.fetchChat);
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.fetchChat);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sendBtn && this.loadedOnce) {
            String trim = this.messageET.getText().toString().trim();
            if (trim.length() != 0) {
                this.messageET.setText("");
                HashMap hashMap = new HashMap();
                hashMap.put("message", trim);
                hashMap.put("first_name", this.myFirstName);
                hashMap.put("user_id", Integer.valueOf(this.myUserId));
                this.chatLines.add(new JSONObject(hashMap));
                bind();
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("message", trim);
                baseHttpClient.put(String.format("/channels/%s/messages/new", new Object[]{this.channelId}), hashMap2, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            }
        }
    }

    private void finishReceivingMessages() {
        scrollToBottom();
    }

    private void finishSendingMessages() {
        scrollToBottom();
    }

    private void scrollToBottom() {
        this.chatView.post(new Runnable() {
            public void run() {
                ChatFragment.this.chatView.setSelection(ChatFragment.this.stableArrayAdapter.getCount() - 1);
            }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<JSONObject> {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEnabled(int i) {
            return false;
        }

        public StableArrayAdapter(Context context2, int i, List<JSONObject> list) {
            super(context2, i, list);
            this.context = context2;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            try {
                JSONObject jSONObject = (JSONObject) ChatFragment.this.chatLines.get(i);
                boolean z = jSONObject.getInt("user_id") == ChatFragment.this.myUserId;
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
                if (z) {
                    view2 = layoutInflater.inflate(R.layout.chat_row_right, (ViewGroup) null);
                } else {
                    View inflate = layoutInflater.inflate(R.layout.chat_row_left, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.firstNameTV)).setText(jSONObject.getString("first_name"));
                    view2 = inflate;
                }
                ((TextView) view2.findViewById(R.id.chatLineTV)).setText(((JSONObject) ChatFragment.this.chatLines.get(i)).getString("message"));
                return view2;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
