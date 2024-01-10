package io.intercom.android.sdk.models;

import java.util.List;

final class AutoValue_TeamPresence extends TeamPresence {
    private final List<Participant> activeAdmins;
    private final String expectedResponseDelayLongText;
    private final String expectedResponseDelayShortText;
    private final String officeHours;

    AutoValue_TeamPresence(List<Participant> list, String str, String str2, String str3) {
        if (list != null) {
            this.activeAdmins = list;
            if (str != null) {
                this.expectedResponseDelayShortText = str;
                if (str2 != null) {
                    this.expectedResponseDelayLongText = str2;
                    if (str3 != null) {
                        this.officeHours = str3;
                        return;
                    }
                    throw new NullPointerException("Null officeHours");
                }
                throw new NullPointerException("Null expectedResponseDelayLongText");
            }
            throw new NullPointerException("Null expectedResponseDelayShortText");
        }
        throw new NullPointerException("Null activeAdmins");
    }

    public List<Participant> getActiveAdmins() {
        return this.activeAdmins;
    }

    public String getExpectedResponseDelayShortText() {
        return this.expectedResponseDelayShortText;
    }

    public String getExpectedResponseDelayLongText() {
        return this.expectedResponseDelayLongText;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public String toString() {
        return "TeamPresence{activeAdmins=" + this.activeAdmins + ", expectedResponseDelayShortText=" + this.expectedResponseDelayShortText + ", expectedResponseDelayLongText=" + this.expectedResponseDelayLongText + ", officeHours=" + this.officeHours + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TeamPresence)) {
            return false;
        }
        TeamPresence teamPresence = (TeamPresence) obj;
        if (!this.activeAdmins.equals(teamPresence.getActiveAdmins()) || !this.expectedResponseDelayShortText.equals(teamPresence.getExpectedResponseDelayShortText()) || !this.expectedResponseDelayLongText.equals(teamPresence.getExpectedResponseDelayLongText()) || !this.officeHours.equals(teamPresence.getOfficeHours())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((this.activeAdmins.hashCode() ^ 1000003) * 1000003) ^ this.expectedResponseDelayShortText.hashCode()) * 1000003) ^ this.expectedResponseDelayLongText.hashCode()) * 1000003) ^ this.officeHours.hashCode();
    }
}
