package com.trainerfu.android;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import com.google.firebase.analytics.FirebaseAnalytics;

public class DiscoveryActivity extends BaseActivity {
    private ContentType contentType;
    private String title;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (bundle == null) {
            DiscoveryViewFragment discoveryViewFragment = new DiscoveryViewFragment();
            Bundle bundle2 = new Bundle();
            Bundle extras = getIntent().getExtras();
            ContentType contentType2 = ContentType.getContentType(extras.getInt(FirebaseAnalytics.Param.CONTENT_TYPE));
            this.contentType = contentType2;
            bundle2.putInt(FirebaseAnalytics.Param.CONTENT_TYPE, contentType2.getMask());
            discoveryViewFragment.setArguments(extras);
            getFragmentManager().beginTransaction().add(16908290, discoveryViewFragment, "dvf").commit();
        }
        if (bundle != null) {
            this.contentType = ContentType.getContentType(bundle.getInt(FirebaseAnalytics.Param.CONTENT_TYPE));
        }
        int i = AnonymousClass1.$SwitchMap$com$trainerfu$android$ContentType[this.contentType.ordinal()];
        if (i == 1) {
            this.title = "Habit";
        } else if (i == 2) {
            this.title = "Auto Responder";
        } else if (i == 3) {
            this.title = "Scheduled Messages";
        } else if (i == 4) {
            this.title = "Training Packages";
        }
        supportActionBar.setTitle((CharSequence) this.title);
        supportActionBar.setElevation(10.0f);
    }

    /* renamed from: com.trainerfu.android.DiscoveryActivity$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$trainerfu$android$ContentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.trainerfu.android.ContentType[] r0 = com.trainerfu.android.ContentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$trainerfu$android$ContentType = r0
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.HABIT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$trainerfu$android$ContentType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.AUTO_RESPONDERS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$trainerfu$android$ContentType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.SCHEDULED_MESSAGES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$trainerfu$android$ContentType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.TRAINING_PACKAGES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.DiscoveryActivity.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(FirebaseAnalytics.Param.CONTENT_TYPE, this.contentType.getMask());
    }
}
