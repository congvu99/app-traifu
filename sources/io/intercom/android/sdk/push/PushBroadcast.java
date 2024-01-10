package io.intercom.android.sdk.push;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.logger.LumberMill;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class PushBroadcast {
    private final Uri pushData;
    private final String pushOnlyId;
    private int pushOnlyIdType;
    private final Twig twig;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PushOnlyIdType {
        public static final int CONVERSATION_ID = 0;
        public static final int INSTANCE_ID = 1;
        public static final int INVALID = -1;
    }

    PushBroadcast() {
        this.twig = LumberMill.getLogger();
        this.pushData = Uri.EMPTY;
        this.pushOnlyId = "";
        this.pushOnlyIdType = -1;
    }

    PushBroadcast(Intent intent) {
        this.twig = LumberMill.getLogger();
        String stringExtra = intent.getStringExtra(IntercomPushManager.PUSH_ONLY_INSTANCE_ID);
        String stringExtra2 = intent.getStringExtra(IntercomPushManager.PUSH_ONLY_CONVO_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.pushOnlyId = stringExtra;
            this.pushOnlyIdType = 1;
        } else if (!TextUtils.isEmpty(stringExtra2)) {
            this.pushOnlyId = stringExtra2;
            this.pushOnlyIdType = 0;
        } else {
            this.twig.internal("The uri had no push only id");
            this.pushOnlyId = "";
            this.pushOnlyIdType = -1;
        }
        Uri data = intent.getData();
        if (data == null) {
            this.twig.internal("The uri had no push data");
            this.pushData = Uri.EMPTY;
            return;
        }
        this.pushData = data;
    }

    /* access modifiers changed from: package-private */
    public Uri getPushData() {
        return this.pushData;
    }

    /* access modifiers changed from: package-private */
    public String getPushOnlyId() {
        return this.pushOnlyId;
    }

    /* access modifiers changed from: package-private */
    public int getPushOnlyIdType() {
        return this.pushOnlyIdType;
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return Uri.EMPTY.equals(this.pushData) && this.pushOnlyId.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean hasPushOnlyId() {
        return !TextUtils.isEmpty(this.pushOnlyId);
    }
}
