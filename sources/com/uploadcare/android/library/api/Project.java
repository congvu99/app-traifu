package com.uploadcare.android.library.api;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/library/api/Project;", "", "name", "", "pubKey", "collaborators", "", "Lcom/uploadcare/android/library/api/Collaborator;", "autostoreEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getAutostoreEnabled", "()Z", "getCollaborators", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPubKey", "component1", "component2", "component3", "component4", "copy", "equals", "other", "getOwner", "hashCode", "", "toString", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Project.kt */
public final class Project {
    private final boolean autostoreEnabled;
    private final List<Collaborator> collaborators;
    private final String name;
    private final String pubKey;

    public static /* synthetic */ Project copy$default(Project project, String str, String str2, List<Collaborator> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = project.name;
        }
        if ((i & 2) != 0) {
            str2 = project.pubKey;
        }
        if ((i & 4) != 0) {
            list = project.collaborators;
        }
        if ((i & 8) != 0) {
            z = project.autostoreEnabled;
        }
        return project.copy(str, str2, list, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.pubKey;
    }

    public final List<Collaborator> component3() {
        return this.collaborators;
    }

    public final boolean component4() {
        return this.autostoreEnabled;
    }

    public final Project copy(String str, @Json(name = "pub_key") String str2, List<Collaborator> list, @Json(name = "autostore_enabled") boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "pubKey");
        Intrinsics.checkNotNullParameter(list, "collaborators");
        return new Project(str, str2, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Project)) {
            return false;
        }
        Project project = (Project) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) project.name) && Intrinsics.areEqual((Object) this.pubKey, (Object) project.pubKey) && Intrinsics.areEqual((Object) this.collaborators, (Object) project.collaborators) && this.autostoreEnabled == project.autostoreEnabled;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.pubKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Collaborator> list = this.collaborators;
        if (list != null) {
            i = list.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.autostoreEnabled;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "Project(name=" + this.name + ", pubKey=" + this.pubKey + ", collaborators=" + this.collaborators + ", autostoreEnabled=" + this.autostoreEnabled + ")";
    }

    public Project(String str, @Json(name = "pub_key") String str2, List<Collaborator> list, @Json(name = "autostore_enabled") boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "pubKey");
        Intrinsics.checkNotNullParameter(list, "collaborators");
        this.name = str;
        this.pubKey = str2;
        this.collaborators = list;
        this.autostoreEnabled = z;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPubKey() {
        return this.pubKey;
    }

    public final List<Collaborator> getCollaborators() {
        return this.collaborators;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Project(String str, String str2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, (i & 8) != 0 ? false : z);
    }

    public final boolean getAutostoreEnabled() {
        return this.autostoreEnabled;
    }

    public final Collaborator getOwner() {
        if (!this.collaborators.isEmpty()) {
            return this.collaborators.get(0);
        }
        return null;
    }
}
