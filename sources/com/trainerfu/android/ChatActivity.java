package com.trainerfu.android;

import android.os.Bundle;

public class ChatActivity extends BaseActivity {
    public ChatActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatFragment chatFragment = new ChatFragment();
        Bundle bundle2 = new Bundle();
        String string = getIntent().getExtras().getString("channel_id");
        int intValue = Integer.valueOf(string.split("-")[0]).intValue();
        if (intValue == 1) {
            setTitle(getString(R.string.Chat));
        } else if (intValue == 2) {
            setTitle(getString(R.string.notes));
        }
        bundle2.putString("channel_id", string);
        chatFragment.setArguments(bundle2);
        getFragmentManager().beginTransaction().add(16908290, chatFragment).commit();
    }
}
