package io.intercom.android.sdk.models;

import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class TeamPresence {
    public abstract List<Participant> getActiveAdmins();

    public abstract String getExpectedResponseDelayLongText();

    public abstract String getExpectedResponseDelayShortText();

    public abstract String getOfficeHours();

    public static TeamPresence create(List<Participant> list, String str, String str2, String str3) {
        return new AutoValue_TeamPresence(list, str, str2, str3);
    }

    public boolean isEmpty() {
        return getActiveAdmins().isEmpty() && getExpectedResponseDelayLongText().isEmpty();
    }

    public static final class Builder {
        List<Participant.Builder> active_admins;
        String expected_response_delay_long_text;
        String expected_response_delay_short_text;
        String office_hours;

        public TeamPresence build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.active_admins));
            List<Participant.Builder> list = this.active_admins;
            if (list != null) {
                for (Participant.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            return TeamPresence.create(arrayList, NullSafety.valueOrEmpty(this.expected_response_delay_short_text), NullSafety.valueOrEmpty(this.expected_response_delay_long_text), NullSafety.valueOrEmpty(this.office_hours));
        }
    }
}
