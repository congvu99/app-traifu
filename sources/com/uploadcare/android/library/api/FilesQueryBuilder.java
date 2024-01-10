package com.uploadcare.android.library.api;

import android.content.Context;
import com.facebook.GraphRequest;
import com.uploadcare.android.library.callbacks.UploadcareAllFilesCallback;
import com.uploadcare.android.library.callbacks.UploadcareFilesCallback;
import com.uploadcare.android.library.data.FilePageData;
import com.uploadcare.android.library.urls.AddFieldsParameter;
import com.uploadcare.android.library.urls.FilesFromParameter;
import com.uploadcare.android.library.urls.FilesLimitParameter;
import com.uploadcare.android.library.urls.FilesOrderParameter;
import com.uploadcare.android.library.urls.FilesRemovedParameter;
import com.uploadcare.android.library.urls.FilesStoredParameter;
import com.uploadcare.android.library.urls.Order;
import com.uploadcare.android.library.urls.UrlParameter;
import com.uploadcare.android.library.urls.Urls;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u001dJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/uploadcare/android/library/api/FilesQueryBuilder;", "Lcom/uploadcare/android/library/api/PaginatedQueryBuilder;", "Lcom/uploadcare/android/library/api/UploadcareFile;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "(Lcom/uploadcare/android/library/api/UploadcareClient;)V", "parameters", "", "", "Lcom/uploadcare/android/library/urls/UrlParameter;", "addFields", "fields", "asIterable", "", "asList", "", "asListAsync", "", "context", "Landroid/content/Context;", "limit", "", "next", "Ljava/net/URI;", "callback", "Lcom/uploadcare/android/library/callbacks/UploadcareFilesCallback;", "Lcom/uploadcare/android/library/callbacks/UploadcareAllFilesCallback;", "from", "fromDate", "Ljava/util/Date;", "fromSize", "", "ordering", "order", "Lcom/uploadcare/android/library/urls/Order;", "removed", "", "stored", "to", "toDate", "toSize", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesQueryBuilder.kt */
public final class FilesQueryBuilder implements PaginatedQueryBuilder<UploadcareFile> {
    private final UploadcareClient client;
    private final Map<String, UrlParameter> parameters = new LinkedHashMap();

    public FilesQueryBuilder(UploadcareClient uploadcareClient) {
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        this.client = uploadcareClient;
    }

    public final FilesQueryBuilder removed(boolean z) {
        this.parameters.put("removed", new FilesRemovedParameter(z));
        return this;
    }

    public final FilesQueryBuilder stored(boolean z) {
        this.parameters.put("stored", new FilesStoredParameter(z));
        return this;
    }

    public final FilesQueryBuilder ordering(Order order) {
        Intrinsics.checkNotNullParameter(order, "order");
        this.parameters.put("ordering", new FilesOrderParameter(order));
        this.parameters.remove("from");
        return this;
    }

    public final FilesQueryBuilder from(Date date) {
        Intrinsics.checkNotNullParameter(date, "fromDate");
        this.parameters.put("ordering", new FilesOrderParameter(Order.UPLOAD_TIME_ASC));
        this.parameters.put("from", new FilesFromParameter(date));
        return this;
    }

    public final FilesQueryBuilder from(long j) {
        this.parameters.put("ordering", new FilesOrderParameter(Order.SIZE_ASC));
        this.parameters.put("from", new FilesFromParameter(j));
        return this;
    }

    public final FilesQueryBuilder to(Date date) {
        Intrinsics.checkNotNullParameter(date, "toDate");
        this.parameters.put("ordering", new FilesOrderParameter(Order.UPLOAD_TIME_DESC));
        this.parameters.put("from", new FilesFromParameter(date));
        return this;
    }

    public final FilesQueryBuilder to(long j) {
        this.parameters.put("ordering", new FilesOrderParameter(Order.SIZE_DESC));
        this.parameters.put("from", new FilesFromParameter(j));
        return this;
    }

    public final FilesQueryBuilder addFields(String str) {
        Intrinsics.checkNotNullParameter(str, GraphRequest.FIELDS_PARAM);
        this.parameters.put("add_fields", new AddFieldsParameter(str));
        return this;
    }

    public Iterable<UploadcareFile> asIterable() {
        return this.client.getRequestHelper().executePaginatedQuery(Urls.Companion.apiFiles(), this.parameters.values(), true, FilePageData.class);
    }

    public List<UploadcareFile> asList() {
        ArrayList arrayList = new ArrayList();
        for (UploadcareFile add : asIterable()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final void asListAsync(Context context, int i, URI uri, UploadcareFilesCallback uploadcareFilesCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            this.parameters.put("limit", new FilesLimitParameter(i));
        }
        if (uri == null) {
            uri = Urls.Companion.apiFiles();
        }
        this.client.getRequestHelper().executePaginatedQueryWithOffsetLimitAsync(context, uri, this.parameters.values(), true, uploadcareFilesCallback);
    }

    public final void asListAsync(UploadcareAllFilesCallback uploadcareAllFilesCallback) {
        new PaginatedQueryTask(this, uploadcareAllFilesCallback).execute(new Void[0]);
    }
}
