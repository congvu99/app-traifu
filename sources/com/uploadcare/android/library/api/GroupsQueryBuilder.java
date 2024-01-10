package com.uploadcare.android.library.api;

import android.content.Context;
import com.uploadcare.android.library.callbacks.UploadcareAllGroupsCallback;
import com.uploadcare.android.library.callbacks.UploadcareGroupsCallback;
import com.uploadcare.android.library.data.GroupPageData;
import com.uploadcare.android.library.urls.FilesFromParameter;
import com.uploadcare.android.library.urls.FilesLimitParameter;
import com.uploadcare.android.library.urls.FilesOrderParameter;
import com.uploadcare.android.library.urls.Order;
import com.uploadcare.android.library.urls.UrlParameter;
import com.uploadcare.android.library.urls.Urls;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/library/api/GroupsQueryBuilder;", "Lcom/uploadcare/android/library/api/PaginatedQueryBuilder;", "Lcom/uploadcare/android/library/api/UploadcareGroup;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "(Lcom/uploadcare/android/library/api/UploadcareClient;)V", "parameters", "", "Lcom/uploadcare/android/library/urls/UrlParameter;", "asIterable", "", "asList", "", "asListAsync", "", "context", "Landroid/content/Context;", "limit", "", "next", "Ljava/net/URI;", "callback", "Lcom/uploadcare/android/library/callbacks/UploadcareGroupsCallback;", "Lcom/uploadcare/android/library/callbacks/UploadcareAllGroupsCallback;", "from", "Ljava/util/Date;", "ordering", "order", "Lcom/uploadcare/android/library/urls/Order;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: GroupsQueryBuilder.kt */
public final class GroupsQueryBuilder implements PaginatedQueryBuilder<UploadcareGroup> {
    private final UploadcareClient client;
    private final List<UrlParameter> parameters = new ArrayList();

    public GroupsQueryBuilder(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        this.client = uploadcareClient;
    }

    public final GroupsQueryBuilder from(Date date) {
        Intrinsics.checkNotNullParameter(date, "from");
        this.parameters.add(new FilesFromParameter(date));
        return this;
    }

    public final GroupsQueryBuilder ordering(Order order) {
        Intrinsics.checkNotNullParameter(order, "order");
        this.parameters.add(new FilesOrderParameter(order));
        return this;
    }

    public Iterable<UploadcareGroup> asIterable() {
        return this.client.getRequestHelper().executePaginatedQuery(Urls.Companion.apiGroups(), this.parameters, true, GroupPageData.class);
    }

    public List<UploadcareGroup> asList() {
        ArrayList arrayList = new ArrayList();
        for (UploadcareGroup add : asIterable()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final void asListAsync(Context context, int i, URI uri, UploadcareGroupsCallback uploadcareGroupsCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            this.parameters.add(new FilesLimitParameter(i));
        }
        if (uri == null) {
            uri = Urls.Companion.apiGroups();
        }
        this.client.getRequestHelper().executeGroupsPaginatedQueryWithOffsetLimitAsync(context, uri, this.parameters, true, uploadcareGroupsCallback);
    }

    public final void asListAsync(UploadcareAllGroupsCallback uploadcareAllGroupsCallback) {
        new PaginatedGroupQueryTask(this, uploadcareAllGroupsCallback).execute(new Void[0]);
    }
}
