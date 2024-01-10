package io.intercom.android.sdk.views;

import android.content.res.Resources;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.annotations.SeenState;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.TimeFormatter;

public class PartMetadataFormatter {
    private final TimeFormatter timeFormatter;

    public PartMetadataFormatter(TimeFormatter timeFormatter2) {
        this.timeFormatter = timeFormatter2;
    }

    /* renamed from: io.intercom.android.sdk.views.PartMetadataFormatter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$models$Part$MessageState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.intercom.android.sdk.models.Part$MessageState[] r0 = io.intercom.android.sdk.models.Part.MessageState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$models$Part$MessageState = r0
                io.intercom.android.sdk.models.Part$MessageState r1 = io.intercom.android.sdk.models.Part.MessageState.SENDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$models$Part$MessageState     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.models.Part$MessageState r1 = io.intercom.android.sdk.models.Part.MessageState.FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$models$Part$MessageState     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.models.Part$MessageState r1 = io.intercom.android.sdk.models.Part.MessageState.UPLOAD_FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$models$Part$MessageState     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.models.Part$MessageState r1 = io.intercom.android.sdk.models.Part.MessageState.NORMAL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.PartMetadataFormatter.AnonymousClass1.<clinit>():void");
        }
    }

    public String getMetadataString(Part part, boolean z, Resources resources) {
        int i = AnonymousClass1.$SwitchMap$io$intercom$android$sdk$models$Part$MessageState[part.getMessageState().ordinal()];
        if (i == 1) {
            return resources.getString(R.string.intercom_message_state_sending);
        }
        if (i == 2 || i == 3) {
            return resources.getString(R.string.intercom_message_failed_try_again);
        }
        if (z) {
            return formatLastPart(part, resources);
        }
        return formatPart(part);
    }

    private String formatLastPart(Part part, Resources resources) {
        StringBuilder sb = new StringBuilder();
        if (part.isDisplayDelivered()) {
            sb.append(resources.getString(R.string.intercom_delivered));
        } else {
            sb.append(this.timeFormatter.getFormattedTime(part.getCreatedAt()));
        }
        if (SeenState.SEEN.equalsIgnoreCase(part.getSeenByAdmin())) {
            sb.append(". ");
            sb.append(resources.getString(R.string.intercom_message_seen));
        } else if (SeenState.UNSEEN.equalsIgnoreCase(part.getSeenByAdmin())) {
            sb.append(". ");
            sb.append(resources.getString(R.string.intercom_message_unseen));
        }
        return sb.toString();
    }

    private String formatPart(Part part) {
        if (part.isDisplayDelivered()) {
            return "";
        }
        return this.timeFormatter.getAbsoluteTime(part.getCreatedAt());
    }
}
