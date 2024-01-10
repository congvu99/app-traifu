package com.uploadcare.android.widget.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/uploadcare/android/widget/data/SocialSourcesResponse;", "Landroid/os/Parcelable;", "sources", "", "Lcom/uploadcare/android/widget/data/SocialSource;", "(Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialSourcesResponse.kt */
public final class SocialSourcesResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<SocialSource> sources;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((SocialSource) SocialSource.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new SocialSourcesResponse(arrayList);
        }

        public final Object[] newArray(int i) {
            return new SocialSourcesResponse[i];
        }
    }

    public static /* synthetic */ SocialSourcesResponse copy$default(SocialSourcesResponse socialSourcesResponse, List<SocialSource> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = socialSourcesResponse.sources;
        }
        return socialSourcesResponse.copy(list);
    }

    public final List<SocialSource> component1() {
        return this.sources;
    }

    public final SocialSourcesResponse copy(List<SocialSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        return new SocialSourcesResponse(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SocialSourcesResponse) && Intrinsics.areEqual((Object) this.sources, (Object) ((SocialSourcesResponse) obj).sources);
        }
        return true;
    }

    public int hashCode() {
        List<SocialSource> list = this.sources;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SocialSourcesResponse(sources=" + this.sources + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<SocialSource> list = this.sources;
        parcel.writeInt(list.size());
        for (SocialSource writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public SocialSourcesResponse(List<SocialSource> list) {
        Intrinsics.checkNotNullParameter(list, "sources");
        this.sources = list;
    }

    public final List<SocialSource> getSources() {
        return this.sources;
    }
}
