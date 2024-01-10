package io.intercom.android.sdk.models.carousel;

import android.os.Parcel;
import android.os.Parcelable;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.models.carousel.ScreenAction;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class CarouselScreen implements Parcelable {
    public static final Parcelable.Creator<CarouselScreen> CREATOR = new Parcelable.Creator<CarouselScreen>() {
        public CarouselScreen createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, ScreenAction.class.getClassLoader());
            ArrayList arrayList2 = new ArrayList();
            parcel.readList(arrayList2, ScreenAction.class.getClassLoader());
            return CarouselScreen.create(parcel.readString(), parcel.readString(), parcel.readString(), arrayList, arrayList2, parcel.readString());
        }

        public CarouselScreen[] newArray(int i) {
            return new CarouselScreen[i];
        }
    };
    public static CarouselScreen NULL = new Builder().build();

    public int describeContents() {
        return 0;
    }

    public abstract List<ScreenAction> getActions();

    public abstract String getBackgroundColor();

    public abstract List<Block> getBlocks();

    public abstract String getId();

    public abstract String getTextColor();

    public abstract String getVerticalAlignment();

    public static CarouselScreen create(String str, String str2, String str3, List<Block> list, List<ScreenAction> list2, String str4) {
        return new AutoValue_CarouselScreen(str, str2, str3, list, list2, str4);
    }

    public int getGravity() {
        if ("bottom".equals(getVerticalAlignment())) {
            return 80;
        }
        return "center".equals(getVerticalAlignment()) ? 16 : 48;
    }

    public ScreenAction getPermissionAction() {
        for (ScreenAction next : getActions()) {
            if (next.isPermissionAction()) {
                return next;
            }
        }
        return ScreenAction.NULL;
    }

    public static final class Builder {
        List<ScreenAction.Builder> actions;
        String background_color;
        List<Block.Builder> blocks;
        String id;
        String text_color;
        String vertical_alignment;

        public Builder withId(String str) {
            this.id = str;
            return this;
        }

        public Builder withBackgroundColor(String str) {
            this.background_color = str;
            return this;
        }

        public Builder withTextColor(String str) {
            this.text_color = str;
            return this;
        }

        public Builder withBlocks(List<Block.Builder> list) {
            this.blocks = list;
            return this;
        }

        public Builder withActions(List<ScreenAction.Builder> list) {
            this.actions = list;
            return this;
        }

        public Builder withVerticalAlignment(String str) {
            this.vertical_alignment = str;
            return this;
        }

        public CarouselScreen build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.actions));
            List<ScreenAction.Builder> list = this.actions;
            if (list != null) {
                for (ScreenAction.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionUtils.capacityFor(this.blocks));
            List<Block.Builder> list2 = this.blocks;
            if (list2 != null) {
                for (Block.Builder next2 : list2) {
                    if (next2 != null) {
                        arrayList2.add(next2.build());
                    }
                }
            }
            return CarouselScreen.create(NullSafety.valueOrEmpty(this.id), NullSafety.valueOrEmpty(this.background_color), NullSafety.valueOrEmpty(this.text_color), arrayList2, arrayList, NullSafety.valueOrEmpty(this.vertical_alignment));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getBlocks());
        parcel.writeList(getActions());
        parcel.writeString(getId());
        parcel.writeString(getBackgroundColor());
        parcel.writeString(getTextColor());
        parcel.writeString(getVerticalAlignment());
    }
}
