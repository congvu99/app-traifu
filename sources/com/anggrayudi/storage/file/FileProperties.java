package com.anggrayudi.storage.file;

import android.content.Context;
import android.text.format.Formatter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001@Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003Jo\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=J\t\u0010>\u001a\u00020\nHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001c\"\u0004\b\u001f\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006A"}, d2 = {"Lcom/anggrayudi/storage/file/FileProperties;", "", "name", "", "location", "size", "", "isFolder", "", "folders", "", "files", "emptyFiles", "emptyFolders", "isVirtual", "lastModified", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;JZIIIIZLjava/util/Date;)V", "getEmptyFiles", "()I", "setEmptyFiles", "(I)V", "getEmptyFolders", "setEmptyFolders", "getFiles", "setFiles", "getFolders", "setFolders", "()Z", "setFolder", "(Z)V", "setVirtual", "getLastModified", "()Ljava/util/Date;", "setLastModified", "(Ljava/util/Date;)V", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "getName", "setName", "getSize", "()J", "setSize", "(J)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "formattedSize", "context", "Landroid/content/Context;", "hashCode", "toString", "CalculationCallback", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileProperties.kt */
public final class FileProperties {
    private int emptyFiles;
    private int emptyFolders;
    private int files;
    private int folders;
    private boolean isFolder;
    private boolean isVirtual;
    private Date lastModified;
    private String location;
    private String name;
    private long size;

    public FileProperties() {
        this((String) null, (String) null, 0, false, 0, 0, 0, 0, false, (Date) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FileProperties copy$default(FileProperties fileProperties, String str, String str2, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date, int i5, Object obj) {
        FileProperties fileProperties2 = fileProperties;
        int i6 = i5;
        return fileProperties.copy((i6 & 1) != 0 ? fileProperties2.name : str, (i6 & 2) != 0 ? fileProperties2.location : str2, (i6 & 4) != 0 ? fileProperties2.size : j, (i6 & 8) != 0 ? fileProperties2.isFolder : z, (i6 & 16) != 0 ? fileProperties2.folders : i, (i6 & 32) != 0 ? fileProperties2.files : i2, (i6 & 64) != 0 ? fileProperties2.emptyFiles : i3, (i6 & 128) != 0 ? fileProperties2.emptyFolders : i4, (i6 & 256) != 0 ? fileProperties2.isVirtual : z2, (i6 & 512) != 0 ? fileProperties2.lastModified : date);
    }

    public final String component1() {
        return this.name;
    }

    public final Date component10() {
        return this.lastModified;
    }

    public final String component2() {
        return this.location;
    }

    public final long component3() {
        return this.size;
    }

    public final boolean component4() {
        return this.isFolder;
    }

    public final int component5() {
        return this.folders;
    }

    public final int component6() {
        return this.files;
    }

    public final int component7() {
        return this.emptyFiles;
    }

    public final int component8() {
        return this.emptyFolders;
    }

    public final boolean component9() {
        return this.isVirtual;
    }

    public final FileProperties copy(String str, String str2, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.LOCATION);
        return new FileProperties(str, str2, j, z, i, i2, i3, i4, z2, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileProperties)) {
            return false;
        }
        FileProperties fileProperties = (FileProperties) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) fileProperties.name) && Intrinsics.areEqual((Object) this.location, (Object) fileProperties.location) && this.size == fileProperties.size && this.isFolder == fileProperties.isFolder && this.folders == fileProperties.folders && this.files == fileProperties.files && this.emptyFiles == fileProperties.emptyFiles && this.emptyFolders == fileProperties.emptyFolders && this.isVirtual == fileProperties.isVirtual && Intrinsics.areEqual((Object) this.lastModified, (Object) fileProperties.lastModified);
    }

    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.location.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.size)) * 31;
        boolean z = this.isFolder;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (((((((((hashCode + (z ? 1 : 0)) * 31) + this.folders) * 31) + this.files) * 31) + this.emptyFiles) * 31) + this.emptyFolders) * 31;
        boolean z3 = this.isVirtual;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        Date date = this.lastModified;
        return i2 + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "FileProperties(name=" + this.name + ", location=" + this.location + ", size=" + this.size + ", isFolder=" + this.isFolder + ", folders=" + this.folders + ", files=" + this.files + ", emptyFiles=" + this.emptyFiles + ", emptyFolders=" + this.emptyFolders + ", isVirtual=" + this.isVirtual + ", lastModified=" + this.lastModified + ')';
    }

    public FileProperties(String str, String str2, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.LOCATION);
        this.name = str;
        this.location = str2;
        this.size = j;
        this.isFolder = z;
        this.folders = i;
        this.files = i2;
        this.emptyFiles = i3;
        this.emptyFolders = i4;
        this.isVirtual = z2;
        this.lastModified = date;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FileProperties(java.lang.String r13, java.lang.String r14, long r15, boolean r17, int r18, int r19, int r20, int r21, boolean r22, java.util.Date r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r2 = r14
        L_0x0011:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0018
            r3 = 0
            goto L_0x0019
        L_0x0018:
            r3 = r15
        L_0x0019:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r17
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r18
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r19
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r20
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r21
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r6 = r22
        L_0x0049:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004f
            r0 = 0
            goto L_0x0051
        L_0x004f:
            r0 = r23
        L_0x0051:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r3
            r18 = r5
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r23 = r6
            r24 = r0
            r13.<init>(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileProperties.<init>(java.lang.String, java.lang.String, long, boolean, int, int, int, int, boolean, java.util.Date, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final void setFolder(boolean z) {
        this.isFolder = z;
    }

    public final int getFolders() {
        return this.folders;
    }

    public final void setFolders(int i) {
        this.folders = i;
    }

    public final int getFiles() {
        return this.files;
    }

    public final void setFiles(int i) {
        this.files = i;
    }

    public final int getEmptyFiles() {
        return this.emptyFiles;
    }

    public final void setEmptyFiles(int i) {
        this.emptyFiles = i;
    }

    public final int getEmptyFolders() {
        return this.emptyFolders;
    }

    public final void setEmptyFolders(int i) {
        this.emptyFolders = i;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public final void setVirtual(boolean z) {
        this.isVirtual = z;
    }

    public final Date getLastModified() {
        return this.lastModified;
    }

    public final void setLastModified(Date date) {
        this.lastModified = date;
    }

    public final String formattedSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String formatFileSize = Formatter.formatFileSize(context, this.size);
        Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(context, size)");
        return formatFileSize;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J\b\u0010\u0012\u001a\u00020\u000eH\u0017J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/anggrayudi/storage/file/FileProperties$CalculationCallback;", "", "updateInterval", "", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(JLkotlinx/coroutines/CoroutineScope;)V", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "setUiScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "getUpdateInterval", "()J", "onCanceled", "", "properties", "Lcom/anggrayudi/storage/file/FileProperties;", "onComplete", "onError", "onUpdate", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileProperties.kt */
    public static abstract class CalculationCallback {
        private CoroutineScope uiScope;
        private final long updateInterval;

        public CalculationCallback() {
            this(0, (CoroutineScope) null, 3, (DefaultConstructorMarker) null);
        }

        public void onCanceled(FileProperties fileProperties) {
            Intrinsics.checkNotNullParameter(fileProperties, "properties");
        }

        public abstract void onComplete(FileProperties fileProperties);

        public void onError() {
        }

        public void onUpdate(FileProperties fileProperties) {
            Intrinsics.checkNotNullParameter(fileProperties, "properties");
        }

        public CalculationCallback(long j, CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "uiScope");
            this.updateInterval = j;
            this.uiScope = coroutineScope;
        }

        public final long getUpdateInterval() {
            return this.updateInterval;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CalculationCallback(long j, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 500 : j, (i & 2) != 0 ? GlobalScope.INSTANCE : coroutineScope);
        }

        public final CoroutineScope getUiScope() {
            return this.uiScope;
        }

        public final void setUiScope(CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
            this.uiScope = coroutineScope;
        }
    }
}
