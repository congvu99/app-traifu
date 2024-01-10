package com.uploadcare.android.widget.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.squareup.moshi.Json;
import com.uploadcare.android.widget.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B*\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000b\u0010\u0007\u001a\u00070\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000e\u0010\u0013\u001a\u00070\b¢\u0006\u0002\b\tHÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\r\b\u0002\u0010\u0007\u001a\u00070\b¢\u0006\u0002\b\tHÆ\u0001J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u001aJ\u0006\u0010!\u001a\u00020\u001aJ\t\u0010\"\u001a\u00020\u001aHÖ\u0001J\u0016\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0006J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0019\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00070\b¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/uploadcare/android/widget/data/SocialSource;", "Landroid/os/Parcelable;", "rootChunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "name", "", "urls", "Lcom/uploadcare/android/widget/data/Urls;", "Lkotlinx/android/parcel/RawValue;", "(Ljava/util/List;Ljava/lang/String;Lcom/uploadcare/android/widget/data/Urls;)V", "getName", "()Ljava/lang/String;", "getRootChunks", "()Ljava/util/List;", "getUrls", "()Lcom/uploadcare/android/widget/data/Urls;", "component1", "component2", "component3", "copy", "deleteCookie", "", "context", "Landroid/content/Context;", "describeContents", "", "equals", "", "other", "", "getCookie", "getNetworkIconResource", "getNetworkNameResource", "hashCode", "saveCookie", "cookie", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialSource.kt */
public final class SocialSource implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String name;
    private final List<Chunk> rootChunks;
    private final Urls urls;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Chunk) Chunk.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new SocialSource(arrayList, parcel.readString(), (Urls) Urls.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i) {
            return new SocialSource[i];
        }
    }

    public static /* synthetic */ SocialSource copy$default(SocialSource socialSource, List<Chunk> list, String str, Urls urls2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = socialSource.rootChunks;
        }
        if ((i & 2) != 0) {
            str = socialSource.name;
        }
        if ((i & 4) != 0) {
            urls2 = socialSource.urls;
        }
        return socialSource.copy(list, str, urls2);
    }

    public final List<Chunk> component1() {
        return this.rootChunks;
    }

    public final String component2() {
        return this.name;
    }

    public final Urls component3() {
        return this.urls;
    }

    public final SocialSource copy(@Json(name = "root_chunks") List<Chunk> list, String str, Urls urls2) {
        Intrinsics.checkNotNullParameter(list, "rootChunks");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(urls2, "urls");
        return new SocialSource(list, str, urls2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SocialSource)) {
            return false;
        }
        SocialSource socialSource = (SocialSource) obj;
        return Intrinsics.areEqual((Object) this.rootChunks, (Object) socialSource.rootChunks) && Intrinsics.areEqual((Object) this.name, (Object) socialSource.name) && Intrinsics.areEqual((Object) this.urls, (Object) socialSource.urls);
    }

    public int hashCode() {
        List<Chunk> list = this.rootChunks;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Urls urls2 = this.urls;
        if (urls2 != null) {
            i = urls2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SocialSource(rootChunks=" + this.rootChunks + ", name=" + this.name + ", urls=" + this.urls + ")";
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<Chunk> list = this.rootChunks;
        parcel.writeInt(list.size());
        for (Chunk writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.name);
        this.urls.writeToParcel(parcel, 0);
    }

    public SocialSource(@Json(name = "root_chunks") List<Chunk> list, String str, Urls urls2) {
        Intrinsics.checkNotNullParameter(list, "rootChunks");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(urls2, "urls");
        this.rootChunks = list;
        this.name = str;
        this.urls = urls2;
    }

    public final List<Chunk> getRootChunks() {
        return this.rootChunks;
    }

    public final String getName() {
        return this.name;
    }

    public final Urls getUrls() {
        return this.urls;
    }

    public final void saveCookie(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "cookie");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString("UCW_PREF_" + this.name, str).apply();
    }

    public final String getCookie(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("UCW_PREF_" + this.name, (String) null);
        return string != null ? string : "";
    }

    public final void deleteCookie(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        CookieManager.getInstance().removeAllCookies((ValueCallback) null);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.remove("UCW_PREF_" + this.name).apply();
    }

    public final int getNetworkNameResource() {
        String str = this.name;
        switch (str.hashCode()) {
            case -1701648119:
                if (str.equals("skydrive")) {
                    return R.string.ucw_social_skydrive;
                }
                break;
            case -1271827001:
                if (str.equals("flickr")) {
                    return R.string.ucw_social_flickr;
                }
                break;
            case -1250311805:
                if (str.equals("gdrive")) {
                    return R.string.ucw_social_gdrive;
                }
                break;
            case -1206404986:
                if (str.equals("huddle")) {
                    return R.string.ucw_social_huddle;
                }
                break;
            case 3765:
                if (str.equals("vk")) {
                    return R.string.ucw_social_vk;
                }
                break;
            case 97739:
                if (str.equals("box")) {
                    return R.string.ucw_social_box;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    return R.string.ucw_social_file;
                }
                break;
            case 28903346:
                if (str.equals("instagram")) {
                    return R.string.ucw_social_instagram;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    return R.string.ucw_social_image;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    return R.string.ucw_social_video;
                }
                break;
            case 229531560:
                if (str.equals("gphotos")) {
                    return R.string.ucw_social_gphotos;
                }
                break;
            case 281649680:
                if (str.equals("evernote")) {
                    return R.string.ucw_social_evernote;
                }
                break;
            case 497130182:
                if (str.equals("facebook")) {
                    return R.string.ucw_social_facebook;
                }
                break;
            case 1925723260:
                if (str.equals("dropbox")) {
                    return R.string.ucw_social_dropbox;
                }
                break;
            case 2006973156:
                if (str.equals("onedrive")) {
                    return R.string.ucw_social_onedrive;
                }
                break;
        }
        return R.string.ucw_social_unknown;
    }

    public final int getNetworkIconResource() {
        String str = this.name;
        switch (str.hashCode()) {
            case -1701648119:
                if (str.equals("skydrive")) {
                    return R.drawable.ucw_onedrive_icon;
                }
                break;
            case -1271827001:
                if (str.equals("flickr")) {
                    return R.drawable.ucw_flickr_icon;
                }
                break;
            case -1250311805:
                if (str.equals("gdrive")) {
                    return R.drawable.ucw_googledrive_icon;
                }
                break;
            case -1206404986:
                if (str.equals("huddle")) {
                    return R.drawable.ucw_huddle_icon;
                }
                break;
            case 3765:
                if (str.equals("vk")) {
                    return R.drawable.ucw_vkontakte_icon;
                }
                break;
            case 97739:
                if (str.equals("box")) {
                    return R.drawable.ucw_box_icon;
                }
                break;
            case 3143036:
                if (str.equals("file")) {
                    return R.drawable.ic_insert_photo_white_24dp;
                }
                break;
            case 28903346:
                if (str.equals("instagram")) {
                    return R.drawable.ucw_instagram_icon;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    return R.drawable.ic_photo_camera_white_24dp;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    return R.drawable.ic_videocam_white_24dp;
                }
                break;
            case 229531560:
                if (str.equals("gphotos")) {
                    return R.drawable.ucw_gphotos_icon;
                }
                break;
            case 281649680:
                if (str.equals("evernote")) {
                    return R.drawable.ucw_evenote_icon;
                }
                break;
            case 497130182:
                if (str.equals("facebook")) {
                    return R.drawable.ucw_facebook_icon;
                }
                break;
            case 1925723260:
                if (str.equals("dropbox")) {
                    return R.drawable.ucw_dropbox_icon;
                }
                break;
            case 2006973156:
                if (str.equals("onedrive")) {
                    return R.drawable.ucw_onedrive_icon;
                }
                break;
        }
        return -1;
    }
}
