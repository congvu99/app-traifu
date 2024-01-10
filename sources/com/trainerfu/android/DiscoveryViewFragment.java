package com.trainerfu.android;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.joanzapata.iconify.widget.IconTextView;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.IntercomContent;
import io.intercom.android.sdk.IntercomSpace;
import java.util.Arrays;

public class DiscoveryViewFragment extends Fragment {
    /* access modifiers changed from: private */
    public ContentType contentType;
    private String description;
    private TextView descriptionView;
    private IconTextView learnMoreBtn;
    private String linkUrl;
    private String title;
    private TextView titleView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.contentType = ContentType.getContentType(getArguments().getInt(FirebaseAnalytics.Param.CONTENT_TYPE));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.fragment_discovery_view, viewGroup, false);
        this.titleView = (TextView) inflate.findViewById(R.id.discovery_title);
        this.descriptionView = (TextView) inflate.findViewById(R.id.discovery_description);
        this.learnMoreBtn = (IconTextView) inflate.findViewById(R.id.learn_more_btn);
        int i = AnonymousClass2.$SwitchMap$com$trainerfu$android$ContentType[this.contentType.ordinal()];
        if (i == 1) {
            this.title = "Deliver Habit Coaching At Scale";
            this.description = "Trainerfu can help you deliver habit coaching to hundreds of clients in just a few clicks.";
        } else if (i == 2) {
            this.title = "Automate your messaging with Scheduled Messages";
            this.description = "ou can use scheduled messages to:\n\t- Automate Paperwork.\n\t- Automate Check-Ins.\n\t- Automate Reminder.";
        } else if (i != 3) {
            this.title = "";
            this.description = "";
        } else {
            this.title = "Sell More With Training Packages";
            this.description = "You can use Training packages to:\n- Sell fitness programs online.\n- Collect one-time or recurring payments.\n- Offer free trials.\n- Automate everything from registration, onboarding, to delivery of your fitness program.";
        }
        this.titleView.setText(this.title);
        this.descriptionView.setText(this.description);
        this.learnMoreBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (DiscoveryViewFragment.this.contentType == ContentType.HABIT) {
                    Intercom.client().presentContent(new IntercomContent.HelpCenterCollections(Arrays.asList(new String[]{"3848111"})));
                } else if (DiscoveryViewFragment.this.contentType == ContentType.TRAINING_PACKAGES) {
                    Intercom.client().presentContent(new IntercomContent.HelpCenterCollections(Arrays.asList(new String[]{"3848365"})));
                } else if (DiscoveryViewFragment.this.contentType == ContentType.SCHEDULED_MESSAGES) {
                    Intercom.client().presentContent(new IntercomContent.HelpCenterCollections(Arrays.asList(new String[]{"3850593"})));
                } else {
                    Intercom.client().present(IntercomSpace.HelpCenter);
                }
            }
        });
        return inflate;
    }

    /* renamed from: com.trainerfu.android.DiscoveryViewFragment$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$trainerfu$android$ContentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.SCHEDULED_MESSAGES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$trainerfu$android$ContentType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.trainerfu.android.ContentType r1 = com.trainerfu.android.ContentType.TRAINING_PACKAGES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.DiscoveryViewFragment.AnonymousClass2.<clinit>():void");
        }
    }

    public void onResume() {
        super.onResume();
    }
}
