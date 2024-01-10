package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Location;
import io.intercom.android.sdk.models.SocialAccount;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.List;

public class LastParticipatingAdmin implements Parcelable {
    public static final Parcelable.Creator<LastParticipatingAdmin> CREATOR = new Parcelable.Creator<LastParticipatingAdmin>() {
        public LastParticipatingAdmin createFromParcel(Parcel parcel) {
            return new LastParticipatingAdmin(parcel);
        }

        public LastParticipatingAdmin[] newArray(int i) {
            return new LastParticipatingAdmin[i];
        }
    };
    private static final String LINKED_IN = "linkedin";
    public static final LastParticipatingAdmin NONE = new LastParticipatingAdmin(new Builder());
    public static final LastParticipatingAdmin NULL = new LastParticipatingAdmin(new Builder());
    private static final String TWITTER = "twitter";
    private final Avatar avatar;
    private final String firstName;
    private final String intro;
    private final boolean isActive;
    private final boolean isBot;
    private final String jobTitle;
    private final long lastActiveAt;
    private final SocialAccount linkedIn;
    private final Location location;
    private final SocialAccount twitter;

    public int describeContents() {
        return 0;
    }

    public LastParticipatingAdmin(Builder builder) {
        this.avatar = (builder.avatar == null ? new Avatar.Builder() : builder.avatar).build();
        this.firstName = NullSafety.valueOrEmpty(builder.first_name);
        this.intro = NullSafety.valueOrEmpty(builder.intro);
        this.jobTitle = NullSafety.valueOrEmpty(builder.job_title);
        this.location = (builder.location == null ? new Location.Builder() : builder.location).build();
        this.lastActiveAt = builder.last_active_at;
        this.isActive = builder.is_active;
        this.isBot = builder.is_bot;
        SocialAccount socialAccount = SocialAccount.NULL;
        SocialAccount socialAccount2 = SocialAccount.NULL;
        if (builder.social_accounts != null) {
            for (SocialAccount.Builder build : builder.social_accounts) {
                SocialAccount build2 = build.build();
                if (TWITTER.equals(build2.getProvider())) {
                    socialAccount = build2;
                } else if (LINKED_IN.equals(build2.getProvider())) {
                    socialAccount2 = build2;
                }
            }
        }
        this.twitter = socialAccount;
        this.linkedIn = socialAccount2;
    }

    public long getLastActiveAt() {
        return this.lastActiveAt;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public Location getLocation() {
        return this.location;
    }

    public SocialAccount getTwitter() {
        return this.twitter;
    }

    public SocialAccount getLinkedIn() {
        return this.linkedIn;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isBot() {
        return this.isBot;
    }

    LastParticipatingAdmin(Parcel parcel) {
        this.lastActiveAt = parcel.readLong();
        boolean z = true;
        this.isActive = parcel.readByte() != 0;
        this.avatar = (Avatar) parcel.readValue(Avatar.class.getClassLoader());
        this.firstName = parcel.readString();
        this.intro = parcel.readString();
        this.jobTitle = parcel.readString();
        this.location = (Location) parcel.readValue(Location.class.getClassLoader());
        this.twitter = (SocialAccount) parcel.readValue(SocialAccount.class.getClassLoader());
        this.linkedIn = (SocialAccount) parcel.readValue(SocialAccount.class.getClassLoader());
        this.isBot = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.lastActiveAt);
        parcel.writeByte(this.isActive ? (byte) 1 : 0);
        parcel.writeValue(this.avatar);
        parcel.writeString(this.firstName);
        parcel.writeString(this.intro);
        parcel.writeString(this.jobTitle);
        parcel.writeValue(this.location);
        parcel.writeValue(this.twitter);
        parcel.writeValue(this.linkedIn);
        parcel.writeByte(this.isBot ? (byte) 1 : 0);
    }

    public static boolean isNull(LastParticipatingAdmin lastParticipatingAdmin) {
        return lastParticipatingAdmin != NONE && (NULL.equals(lastParticipatingAdmin) || lastParticipatingAdmin == null);
    }

    public static final class Builder {
        Avatar.Builder avatar;
        String first_name;
        String intro;
        boolean is_active;
        boolean is_bot;
        String job_title;
        long last_active_at;
        Location.Builder location;
        List<SocialAccount.Builder> social_accounts;

        public LastParticipatingAdmin build() {
            return new LastParticipatingAdmin(this);
        }

        public Builder withJobTitle(String str) {
            this.job_title = str;
            return this;
        }

        public Builder withIntro(String str) {
            this.intro = str;
            return this;
        }

        public Builder withFirstName(String str) {
            this.first_name = str;
            return this;
        }

        public Builder withAvatar(Avatar.Builder builder) {
            this.avatar = builder;
            return this;
        }
    }
}
