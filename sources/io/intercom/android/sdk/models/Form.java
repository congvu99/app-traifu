package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.List;

public abstract class Form implements Parcelable {
    public static final Parcelable.Creator<Form> CREATOR = new Parcelable.Creator<Form>() {
        public Form createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Attribute.class.getClassLoader());
            return Form.create(arrayList, parcel.readString());
        }

        public Form[] newArray(int i) {
            return new Form[i];
        }
    };
    public static final Form NULL = create(new ArrayList(), "");

    public int describeContents() {
        return 0;
    }

    public abstract List<Attribute> getAttributes();

    public abstract String getType();

    static Form create(List<Attribute> list, String str) {
        return new AutoValue_Form(list, str);
    }

    public static final class Builder {
        List<Attribute.Builder> attributes;
        String type;

        public Builder withAttributes(List<Attribute.Builder> list) {
            this.attributes = list;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Form build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.attributes));
            List<Attribute.Builder> list = this.attributes;
            if (list != null) {
                for (Attribute.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            return Form.create(arrayList, NullSafety.valueOrEmpty(this.type));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getAttributes());
        parcel.writeString(getType());
    }
}
