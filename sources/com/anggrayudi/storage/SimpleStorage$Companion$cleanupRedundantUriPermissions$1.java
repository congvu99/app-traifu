package com.anggrayudi.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.file.DocumentFileCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleStorage.kt */
final class SimpleStorage$Companion$cleanupRedundantUriPermissions$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleStorage$Companion$cleanupRedundantUriPermissions$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final void invoke() {
        ContentResolver contentResolver = this.$context.getContentResolver();
        List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "resolver.persistedUriPermissions");
        Collection arrayList = new ArrayList();
        Iterator it = persistedUriPermissions.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            UriPermission uriPermission = (UriPermission) next;
            if (uriPermission.isReadPermission() && uriPermission.isWritePermission()) {
                Uri uri = uriPermission.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "it.uri");
                if (UriUtils.isExternalStorageDocument(uri)) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        Iterable<UriPermission> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (UriPermission uri2 : iterable) {
            arrayList2.add(uri2.getUri());
        }
        Context context = this.$context;
        Iterable<Uri> iterable2 = (List) arrayList2;
        Collection arrayList3 = new ArrayList();
        Iterator it2 = iterable2.iterator();
        while (true) {
            String str = null;
            if (!it2.hasNext()) {
                break;
            }
            String path = ((Uri) it2.next()).getPath();
            if (path != null) {
                str = StringsKt.substringAfter$default(path, "/tree/", (String) null, 2, (Object) null);
            }
            if (str != null) {
                arrayList3.add(str);
            }
        }
        List<String> findUniqueParents = DocumentFileCompat.findUniqueParents(context, (List) arrayList3);
        Context context2 = this.$context;
        for (Uri uri3 : iterable2) {
            String path2 = uri3.getPath();
            if (path2 == null) {
                path2 = "";
            }
            if (!findUniqueParents.contains(DocumentFileCompat.buildAbsolutePath(context2, StringsKt.substringAfter$default(path2, "/tree/", (String) null, 2, (Object) null)))) {
                contentResolver.releasePersistableUriPermission(uri3, 3);
                Timber.d(Intrinsics.stringPlus("Removed redundant URI permission => ", uri3), new Object[0]);
            }
        }
    }
}
