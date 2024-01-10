package io.intercom.android.sdk.models.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.carousel.PermissionManager;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class ScreenAction implements Parcelable {
    public static final Parcelable.Creator<ScreenAction> CREATOR = new Parcelable.Creator<ScreenAction>() {
        public ScreenAction createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, String.class.getClassLoader());
            return ScreenAction.create(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), arrayList);
        }

        public ScreenAction[] newArray(int i) {
            return new ScreenAction[i];
        }
    };
    public static ScreenAction NULL = new Builder().build();
    private static final String PERMISSION_TYPE_SUFFIX = "permission";

    public int describeContents() {
        return 0;
    }

    public abstract List<String> getAndroidPermissions();

    public abstract String getBackgroundColor();

    public abstract String getId();

    public abstract String getTextColor();

    public abstract String getTitle();

    public abstract String getType();

    public abstract String getUri();

    public static ScreenAction create(String str, String str2, String str3, String str4, String str5, String str6, List<String> list) {
        return new AutoValue_ScreenAction(str, str2, str3, str4, str5, str6, list);
    }

    public boolean isPermissionAction() {
        return getType().contains(PERMISSION_TYPE_SUFFIX);
    }

    public List<String> getValidPermissions(PermissionManager permissionManager) {
        return permissionManager.permissionsExistInManifest(getAndroidPermissions());
    }

    public static final class Builder {
        List<String> android_permissions;
        String background_color;
        String id;
        String text_color;
        String title;
        String type;
        String uri;

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder withTextColor(String str) {
            this.text_color = str;
            return this;
        }

        public Builder withBackgroundColor(String str) {
            this.background_color = str;
            return this;
        }

        public Builder withUri(String str) {
            this.uri = str;
            return this;
        }

        public Builder withPermissions(List<String> list) {
            this.android_permissions = list;
            return this;
        }

        public ScreenAction build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.android_permissions));
            List<String> list = this.android_permissions;
            if (list != null) {
                for (String next : list) {
                    if (next != null) {
                        arrayList.add(next);
                    }
                }
            }
            return ScreenAction.create(NullSafety.valueOrEmpty(this.id), NullSafety.valueOrEmpty(this.type), NullSafety.valueOrEmpty(this.title), NullSafety.valueOrEmpty(this.text_color), NullSafety.valueOrEmpty(this.background_color), NullSafety.valueOrEmpty(this.uri), arrayList);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getAndroidPermissions());
        parcel.writeString(getId());
        parcel.writeString(getType());
        parcel.writeString(getTitle());
        parcel.writeString(getTextColor());
        parcel.writeString(getBackgroundColor());
        parcel.writeString(getUri());
    }
}
