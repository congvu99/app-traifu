package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.utilities.NullSafety;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Attribute implements Parcelable {
    private static final String BOOLEAN_TYPE = "boolean";
    public static final Parcelable.Creator<Attribute> CREATOR = new Parcelable.Creator<Attribute>() {
        public Attribute createFromParcel(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, String.class.getClassLoader());
            return Attribute.create(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), arrayList);
        }

        public Attribute[] newArray(int i) {
            return new Attribute[i];
        }
    };
    private static final String DATE_TYPE = "date";
    private static final String FLOAT_TYPE = "float";
    private static final String INTEGER_TYPE = "integer";
    public static final Attribute NULL = create("", "", "", "", "");
    private static final String STRING_TYPE = "string";

    public int describeContents() {
        return 0;
    }

    public abstract String getCustomBotControlId();

    public abstract String getIdentifier();

    public abstract String getName();

    public abstract List<String> getOptions();

    public abstract String getType();

    public abstract String getValue();

    static Attribute create(String str, String str2, String str3, String str4, String str5) {
        return new AutoValue_Attribute(str, str2, str3, str4, str5, Collections.emptyList());
    }

    static Attribute create(String str, String str2, String str3, String str4, String str5, List<String> list) {
        return new AutoValue_Attribute(str, str2, str3, str4, str5, list);
    }

    public boolean hasValue() {
        return !TextUtils.isEmpty(getValue());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getRenderType() {
        /*
            r9 = this;
            java.lang.String r0 = r9.getType()
            int r1 = r0.hashCode()
            java.lang.String r2 = "float"
            java.lang.String r3 = "boolean"
            java.lang.String r4 = "date"
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            switch(r1) {
                case -891985903: goto L_0x0038;
                case 3076014: goto L_0x0030;
                case 64711720: goto L_0x0028;
                case 97526364: goto L_0x0020;
                case 1958052158: goto L_0x0016;
                default: goto L_0x0015;
            }
        L_0x0015:
            goto L_0x0042
        L_0x0016:
            java.lang.String r1 = "integer"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 1
            goto L_0x0043
        L_0x0020:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0042
            r0 = 2
            goto L_0x0043
        L_0x0028:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0042
            r0 = 3
            goto L_0x0043
        L_0x0030:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0042
            r0 = 4
            goto L_0x0043
        L_0x0038:
            java.lang.String r1 = "string"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0042
            r0 = 0
            goto L_0x0043
        L_0x0042:
            r0 = -1
        L_0x0043:
            if (r0 == 0) goto L_0x0056
            if (r0 == r8) goto L_0x0053
            if (r0 == r7) goto L_0x0052
            if (r0 == r6) goto L_0x0051
            if (r0 == r5) goto L_0x0050
            java.lang.String r0 = "unknown"
            return r0
        L_0x0050:
            return r4
        L_0x0051:
            return r3
        L_0x0052:
            return r2
        L_0x0053:
            java.lang.String r0 = "number"
            return r0
        L_0x0056:
            java.util.List r0 = r9.getOptions()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "list"
            return r0
        L_0x0063:
            java.lang.String r0 = r9.getIdentifier()
            java.lang.String r1 = "email"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0070
            return r1
        L_0x0070:
            java.lang.String r0 = r9.getIdentifier()
            java.lang.String r1 = "phone"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x007d
            return r1
        L_0x007d:
            java.lang.String r0 = r9.getIdentifier()
            java.lang.String r1 = "company.website"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x008a
            return r1
        L_0x008a:
            java.lang.String r0 = "text"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.models.Attribute.getRenderType():java.lang.String");
    }

    public static final class Builder {
        String custom_bot_control_id;
        String identifier;
        String name;
        List<String> options;
        String type;
        String value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Builder builder = (Builder) obj;
            if (!Objects.equals(this.custom_bot_control_id, builder.custom_bot_control_id) || !Objects.equals(this.identifier, builder.identifier) || !Objects.equals(this.name, builder.name) || !Objects.equals(this.type, builder.type) || !Objects.equals(this.value, builder.value) || !Objects.equals(this.options, builder.options)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.custom_bot_control_id, this.identifier, this.name, this.type, this.value, this.options});
        }

        public Builder withCustomBotControlId(String str) {
            this.custom_bot_control_id = str;
            return this;
        }

        public Builder withIdentifier(String str) {
            this.identifier = str;
            return this;
        }

        public Builder withName(String str) {
            this.name = str;
            return this;
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withValue(String str) {
            this.value = str;
            return this;
        }

        public Builder withOptions(List<String> list) {
            this.options = list;
            return this;
        }

        public Attribute build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.options));
            List<String> list = this.options;
            if (list != null) {
                for (String next : list) {
                    if (next != null) {
                        arrayList.add(next);
                    }
                }
            }
            return Attribute.create(NullSafety.valueOrEmpty(this.custom_bot_control_id), NullSafety.valueOrEmpty(this.identifier), NullSafety.valueOrEmpty(this.name), NullSafety.valueOrEmpty(this.type), NullSafety.valueOrEmpty(this.value), arrayList);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(getOptions());
        parcel.writeString(getCustomBotControlId());
        parcel.writeString(getIdentifier());
        parcel.writeString(getName());
        parcel.writeString(getType());
        parcel.writeString(getValue());
    }
}
