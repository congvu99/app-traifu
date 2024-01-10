package com.intercom.input.gallery;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u000eHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\t\u0010+\u001a\u00020\nHÖ\u0001J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\u0006\u0010/\u001a\u00020\u0003J\t\u00100\u001a\u00020\nHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\nHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00067"}, d2 = {"Lcom/intercom/input/gallery/GalleryImage;", "Landroid/os/Parcelable;", "fileName", "", "mimeType", "uri", "Landroid/net/Uri;", "previewPath", "attribution", "imageWidth", "", "imageHeight", "fileSize", "isGif", "", "isVideo", "duration", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;IIIZZLjava/lang/String;)V", "getAttribution", "()Ljava/lang/String;", "getDuration", "getFileName", "getFileSize", "()I", "getImageHeight", "getImageWidth", "()Z", "getMimeType", "getPreviewPath", "getUri", "()Landroid/net/Uri;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getImageWidthXHeight", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "input-gallery_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GalleryImage.kt */
public final class GalleryImage implements Parcelable {
    public static final Parcelable.Creator<GalleryImage> CREATOR = new Creator();
    private final String attribution;
    private final String duration;
    private final String fileName;
    private final int fileSize;
    private final int imageHeight;
    private final int imageWidth;
    private final boolean isGif;
    private final boolean isVideo;
    private final String mimeType;
    private final String previewPath;
    private final Uri uri;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GalleryImage.kt */
    public static final class Creator implements Parcelable.Creator<GalleryImage> {
        public final GalleryImage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Uri uri = (Uri) parcel.readParcelable(GalleryImage.class.getClassLoader());
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new GalleryImage(readString, readString2, uri, readString3, readString4, readInt, readInt2, readInt3, z2, z, parcel.readString());
        }

        public final GalleryImage[] newArray(int i) {
            return new GalleryImage[i];
        }
    }

    public GalleryImage() {
        this((String) null, (String) null, (Uri) null, (String) null, (String) null, 0, 0, 0, false, false, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2046(0x7fe, float:2.867E-42)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2044(0x7fc, float:2.864E-42)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2040(0x7f8, float:2.859E-42)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2032(0x7f0, float:2.847E-42)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 2016(0x7e0, float:2.825E-42)
            r14 = 0
            r1 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20, int r21) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1984(0x7c0, float:2.78E-42)
            r14 = 0
            r1 = r15
            r7 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20, int r21, int r22) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1920(0x780, float:2.69E-42)
            r14 = 0
            r1 = r15
            r7 = r21
            r8 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20, int r21, int r22, int r23) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1792(0x700, float:2.511E-42)
            r14 = 0
            r1 = r15
            r7 = r21
            r8 = r22
            r9 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int, int, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20, int r21, int r22, int r23, boolean r24) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r11 = 0
            r12 = 0
            r13 = 1536(0x600, float:2.152E-42)
            r14 = 0
            r1 = r15
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int, int, int, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryImage(java.lang.String r16, java.lang.String r17, android.net.Uri r18, java.lang.String r19, java.lang.String r20, int r21, int r22, int r23, boolean r24, boolean r25) {
        /*
            r15 = this;
            java.lang.String r0 = "fileName"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "mimeType"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "uri"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "previewPath"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "attribution"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r12 = 0
            r13 = 1024(0x400, float:1.435E-42)
            r14 = 0
            r1 = r15
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int, int, int, boolean, boolean):void");
    }

    public static /* synthetic */ GalleryImage copy$default(GalleryImage galleryImage, String str, String str2, Uri uri2, String str3, String str4, int i, int i2, int i3, boolean z, boolean z2, String str5, int i4, Object obj) {
        GalleryImage galleryImage2 = galleryImage;
        int i5 = i4;
        return galleryImage.copy((i5 & 1) != 0 ? galleryImage2.fileName : str, (i5 & 2) != 0 ? galleryImage2.mimeType : str2, (i5 & 4) != 0 ? galleryImage2.uri : uri2, (i5 & 8) != 0 ? galleryImage2.previewPath : str3, (i5 & 16) != 0 ? galleryImage2.attribution : str4, (i5 & 32) != 0 ? galleryImage2.imageWidth : i, (i5 & 64) != 0 ? galleryImage2.imageHeight : i2, (i5 & 128) != 0 ? galleryImage2.fileSize : i3, (i5 & 256) != 0 ? galleryImage2.isGif : z, (i5 & 512) != 0 ? galleryImage2.isVideo : z2, (i5 & 1024) != 0 ? galleryImage2.duration : str5);
    }

    public final String component1() {
        return this.fileName;
    }

    public final boolean component10() {
        return this.isVideo;
    }

    public final String component11() {
        return this.duration;
    }

    public final String component2() {
        return this.mimeType;
    }

    public final Uri component3() {
        return this.uri;
    }

    public final String component4() {
        return this.previewPath;
    }

    public final String component5() {
        return this.attribution;
    }

    public final int component6() {
        return this.imageWidth;
    }

    public final int component7() {
        return this.imageHeight;
    }

    public final int component8() {
        return this.fileSize;
    }

    public final boolean component9() {
        return this.isGif;
    }

    public final GalleryImage copy(String str, String str2, Uri uri2, String str3, String str4, int i, int i2, int i3, boolean z, boolean z2, String str5) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Uri uri3 = uri2;
        Intrinsics.checkNotNullParameter(uri3, "uri");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, "previewPath");
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, "attribution");
        String str8 = str5;
        Intrinsics.checkNotNullParameter(str8, "duration");
        return new GalleryImage(str, str2, uri3, str6, str7, i, i2, i3, z, z2, str8);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GalleryImage)) {
            return false;
        }
        GalleryImage galleryImage = (GalleryImage) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) galleryImage.fileName) && Intrinsics.areEqual((Object) this.mimeType, (Object) galleryImage.mimeType) && Intrinsics.areEqual((Object) this.uri, (Object) galleryImage.uri) && Intrinsics.areEqual((Object) this.previewPath, (Object) galleryImage.previewPath) && Intrinsics.areEqual((Object) this.attribution, (Object) galleryImage.attribution) && this.imageWidth == galleryImage.imageWidth && this.imageHeight == galleryImage.imageHeight && this.fileSize == galleryImage.fileSize && this.isGif == galleryImage.isGif && this.isVideo == galleryImage.isVideo && Intrinsics.areEqual((Object) this.duration, (Object) galleryImage.duration);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.fileName.hashCode() * 31) + this.mimeType.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.previewPath.hashCode()) * 31) + this.attribution.hashCode()) * 31) + this.imageWidth) * 31) + this.imageHeight) * 31) + this.fileSize) * 31;
        boolean z = this.isGif;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isVideo;
        if (!z3) {
            z2 = z3;
        }
        return ((i + (z2 ? 1 : 0)) * 31) + this.duration.hashCode();
    }

    public String toString() {
        return "GalleryImage(fileName=" + this.fileName + ", mimeType=" + this.mimeType + ", uri=" + this.uri + ", previewPath=" + this.previewPath + ", attribution=" + this.attribution + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", fileSize=" + this.fileSize + ", isGif=" + this.isGif + ", isVideo=" + this.isVideo + ", duration=" + this.duration + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.fileName);
        parcel.writeString(this.mimeType);
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.previewPath);
        parcel.writeString(this.attribution);
        parcel.writeInt(this.imageWidth);
        parcel.writeInt(this.imageHeight);
        parcel.writeInt(this.fileSize);
        parcel.writeInt(this.isGif ? 1 : 0);
        parcel.writeInt(this.isVideo ? 1 : 0);
        parcel.writeString(this.duration);
    }

    public GalleryImage(String str, String str2, Uri uri2, String str3, String str4, int i, int i2, int i3, boolean z, boolean z2, String str5) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "mimeType");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intrinsics.checkNotNullParameter(str3, "previewPath");
        Intrinsics.checkNotNullParameter(str4, "attribution");
        Intrinsics.checkNotNullParameter(str5, "duration");
        this.fileName = str;
        this.mimeType = str2;
        this.uri = uri2;
        this.previewPath = str3;
        this.attribution = str4;
        this.imageWidth = i;
        this.imageHeight = i2;
        this.fileSize = i3;
        this.isGif = z;
        this.isVideo = z2;
        this.duration = str5;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GalleryImage(java.lang.String r14, java.lang.String r15, android.net.Uri r16, java.lang.String r17, java.lang.String r18, int r19, int r20, int r21, boolean r22, boolean r23, java.lang.String r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r13 = this;
            r0 = r25
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r14
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0012
        L_0x0011:
            r3 = r15
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001e
            android.net.Uri r4 = android.net.Uri.EMPTY
            java.lang.String r5 = "EMPTY"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            goto L_0x0020
        L_0x001e:
            r4 = r16
        L_0x0020:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            r5 = r2
            goto L_0x0028
        L_0x0026:
            r5 = r17
        L_0x0028:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002e
            r6 = r2
            goto L_0x0030
        L_0x002e:
            r6 = r18
        L_0x0030:
            r7 = r0 & 32
            r8 = 0
            if (r7 == 0) goto L_0x0037
            r7 = 0
            goto L_0x0039
        L_0x0037:
            r7 = r19
        L_0x0039:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003f
            r9 = 0
            goto L_0x0041
        L_0x003f:
            r9 = r20
        L_0x0041:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0047
            r10 = 0
            goto L_0x0049
        L_0x0047:
            r10 = r21
        L_0x0049:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004f
            r11 = 0
            goto L_0x0051
        L_0x004f:
            r11 = r22
        L_0x0051:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r8 = r23
        L_0x0058:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r2 = r24
        L_0x005f:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r9
            r22 = r10
            r23 = r11
            r24 = r8
            r25 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.GalleryImage.<init>(java.lang.String, java.lang.String, android.net.Uri, java.lang.String, java.lang.String, int, int, int, boolean, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getPreviewPath() {
        return this.previewPath;
    }

    public final String getAttribution() {
        return this.attribution;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getFileSize() {
        return this.fileSize;
    }

    public final boolean isGif() {
        return this.isGif;
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getImageWidthXHeight() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.imageWidth);
        sb.append('x');
        sb.append(this.imageHeight);
        return sb.toString();
    }
}
