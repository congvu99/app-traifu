package com.anggrayudi.storage.extension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u001a\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\u0002¨\u0006\f"}, d2 = {"count", "", "", "text", "hasParent", "", "parentPath", "replaceCompletely", "match", "replaceWith", "trimFileSeparator", "trimWhiteSpace", "storage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextExt.kt */
public final class TextUtils {
    public static final int count(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "text");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        if ((str2.length() == 0) || indexOf$default == -1) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            indexOf$default = StringsKt.indexOf$default(charSequence, str2, indexOf$default + str2.length(), false, 4, (Object) null);
            if (!(1 <= indexOf$default && indexOf$default < str.length())) {
                return i2;
            }
            i = i2;
        }
    }

    public static final String trimFileSeparator(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.trim(str, '/');
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String replaceCompletely(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "match"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "replaceWith"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r1 = r7
        L_0x0010:
            r4 = 0
            r5 = 4
            r6 = 0
            r2 = r8
            r3 = r9
            java.lang.String r1 = kotlin.text.StringsKt.replace$default((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (boolean) r4, (int) r5, (java.lang.Object) r6)
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r0 = r7.length()
            r2 = 0
            if (r0 <= 0) goto L_0x0025
            r0 = 1
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            if (r0 == 0) goto L_0x0033
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3 = 2
            r4 = 0
            boolean r7 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) r0, (boolean) r2, (int) r3, (java.lang.Object) r4)
            if (r7 != 0) goto L_0x0010
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.extension.TextUtils.replaceCompletely(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final boolean hasParent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "parentPath");
        Iterable<String> split$default = StringsKt.split$default((CharSequence) str2, new char[]{'/'}, false, 0, 6, (Object) null);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String trimFileSeparator : split$default) {
            arrayList.add(trimFileSeparator(trimFileSeparator));
        }
        Collection arrayList2 = new ArrayList();
        for (Object next : (List) arrayList) {
            if (((String) next).length() > 0) {
                arrayList2.add(next);
            }
        }
        List list = (List) arrayList2;
        Iterable<String> split$default2 = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
        for (String trimFileSeparator2 : split$default2) {
            arrayList3.add(trimFileSeparator(trimFileSeparator2));
        }
        Collection arrayList4 = new ArrayList();
        for (Object next2 : (List) arrayList3) {
            if (((String) next2).length() > 0) {
                arrayList4.add(next2);
            }
        }
        List list2 = (List) arrayList4;
        if (list.size() > list2.size() || !Intrinsics.areEqual((Object) CollectionsKt.take(list2, list.size()), (Object) list)) {
            return false;
        }
        return true;
    }

    public static final String trimWhiteSpace(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i : length), 32) <= 0;
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i, length + 1).toString();
    }
}
