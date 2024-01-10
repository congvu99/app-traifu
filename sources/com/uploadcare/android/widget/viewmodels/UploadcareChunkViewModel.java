package com.uploadcare.android.widget.viewmodels;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.data.Chunk;
import com.uploadcare.android.widget.data.Path;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.data.Thing;
import com.uploadcare.android.widget.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u000eJ\u001e\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u00100\u001a\u00020\u001cH\u0002J\u0006\u0010.\u001a\u00020+J\u0010\u00101\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010\u001cJ\u000e\u00102\u001a\u00020+2\u0006\u00103\u001a\u000204R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\tR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00065"}, d2 = {"Lcom/uploadcare/android/widget/viewmodels/UploadcareChunkViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allowLoadMore", "Landroidx/lifecycle/MutableLiveData;", "", "getAllowLoadMore", "()Landroidx/lifecycle/MutableLiveData;", "chunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "currentChunk", "", "errorCommand", "Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "getErrorCommand", "()Lcom/uploadcare/android/widget/utils/SingleLiveEvent;", "isEmpty", "isRoot", "isSearch", "loading", "getLoading", "loadingMore", "getLoadingMore", "needAuthCommand", "", "getNeedAuthCommand", "nextPath", "Lcom/uploadcare/android/widget/data/Path;", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "things", "Lcom/uploadcare/android/widget/data/Thing;", "getThings", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "changeChunk", "", "position", "getChunkData", "loadMore", "query", "getNext", "search", "start", "arguments", "Landroid/os/Bundle;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareChunkViewModel.kt */
public final class UploadcareChunkViewModel extends AndroidViewModel {
    private final MutableLiveData<Boolean> allowLoadMore;
    private List<Chunk> chunks;
    private int currentChunk;
    private final SingleLiveEvent<UploadcareApiException> errorCommand;
    private final MutableLiveData<Boolean> isEmpty;
    private boolean isRoot;
    private final MutableLiveData<Boolean> isSearch;
    private final MutableLiveData<Boolean> loading;
    private final MutableLiveData<Boolean> loadingMore;
    private final SingleLiveEvent<String> needAuthCommand;
    /* access modifiers changed from: private */
    public Path nextPath;
    private SocialSource socialSource;
    private final MutableLiveData<List<Thing>> things = new MutableLiveData<>();
    private String title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UploadcareChunkViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(false);
        Unit unit = Unit.INSTANCE;
        this.allowLoadMore = mutableLiveData;
        this.errorCommand = new SingleLiveEvent<>();
        this.needAuthCommand = new SingleLiveEvent<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(false);
        Unit unit2 = Unit.INSTANCE;
        this.loading = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(false);
        Unit unit3 = Unit.INSTANCE;
        this.loadingMore = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        mutableLiveData4.setValue(false);
        Unit unit4 = Unit.INSTANCE;
        this.isEmpty = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        mutableLiveData5.setValue(false);
        Unit unit5 = Unit.INSTANCE;
        this.isSearch = mutableLiveData5;
        this.chunks = CollectionsKt.emptyList();
    }

    public final MutableLiveData<List<Thing>> getThings() {
        return this.things;
    }

    public final MutableLiveData<Boolean> getAllowLoadMore() {
        return this.allowLoadMore;
    }

    public final SingleLiveEvent<UploadcareApiException> getErrorCommand() {
        return this.errorCommand;
    }

    public final SingleLiveEvent<String> getNeedAuthCommand() {
        return this.needAuthCommand;
    }

    public final MutableLiveData<Boolean> getLoading() {
        return this.loading;
    }

    public final MutableLiveData<Boolean> getLoadingMore() {
        return this.loadingMore;
    }

    public final MutableLiveData<Boolean> isEmpty() {
        return this.isEmpty;
    }

    public final MutableLiveData<Boolean> isSearch() {
        return this.isSearch;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void start(Bundle bundle) {
        List<Chunk> list;
        Intrinsics.checkNotNullParameter(bundle, "arguments");
        this.currentChunk = bundle.getInt("currentChunk", 0);
        this.socialSource = (SocialSource) bundle.getParcelable("socialSource");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("chunks");
        if (parcelableArrayList == null || (list = CollectionsKt.toList(parcelableArrayList)) == null) {
            list = CollectionsKt.emptyList();
        }
        this.chunks = list;
        this.title = bundle.getString("title");
        this.isRoot = bundle.getBoolean("isRoot", false);
        getChunkData$default(this, false, (String) null, 3, (Object) null);
    }

    public final void search(String str) {
        getChunkData$default(this, false, str, 1, (Object) null);
    }

    public final void loadMore() {
        if (this.nextPath != null) {
            getChunkData$default(this, true, (String) null, 2, (Object) null);
        }
    }

    public final void changeChunk(int i) {
        if (i != this.currentChunk) {
            this.isSearch.setValue(false);
            this.currentChunk = i;
            getChunkData$default(this, false, (String) null, 3, (Object) null);
        }
    }

    static /* synthetic */ void getChunkData$default(UploadcareChunkViewModel uploadcareChunkViewModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        uploadcareChunkViewModel.getChunkData(z, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0108, code lost:
        if (r0 != null) goto L_0x010c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void getChunkData(boolean r7, java.lang.String r8) {
        /*
            r6 = this;
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r6.isEmpty
            r1 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r0.setValue(r2)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r0 = r6.allowLoadMore
            r0.postValue(r2)
            r0 = 0
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            if (r7 != 0) goto L_0x0022
            androidx.lifecycle.MutableLiveData<java.util.List<com.uploadcare.android.widget.data.Thing>> r4 = r6.things
            r4.postValue(r0)
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r4 = r6.loading
            r4.setValue(r3)
            goto L_0x0027
        L_0x0022:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r4 = r6.loadingMore
            r4.setValue(r3)
        L_0x0027:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "/"
            if (r8 == 0) goto L_0x005b
            com.uploadcare.android.widget.data.SocialSource r1 = r6.socialSource
            if (r1 == 0) goto L_0x0048
            java.util.List r1 = r1.getRootChunks()
            if (r1 == 0) goto L_0x0048
            int r2 = r6.currentChunk
            java.lang.Object r1 = r1.get(r2)
            com.uploadcare.android.widget.data.Chunk r1 = (com.uploadcare.android.widget.data.Chunk) r1
            if (r1 == 0) goto L_0x0048
            java.lang.String r0 = r1.getPathChunk()
        L_0x0048:
            r4.append(r0)
            r4.append(r5)
            java.lang.String r0 = "-"
            r4.append(r0)
            r4.append(r5)
            r4.append(r8)
            goto L_0x00e9
        L_0x005b:
            androidx.lifecycle.MutableLiveData<java.lang.Boolean> r8 = r6.isSearch
            java.lang.Object r8 = r8.getValue()
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r3)
            if (r8 == 0) goto L_0x007d
            if (r7 == 0) goto L_0x007d
            java.util.List<com.uploadcare.android.widget.data.Chunk> r8 = r6.chunks
            int r0 = r6.currentChunk
            java.lang.Object r8 = r8.get(r0)
            com.uploadcare.android.widget.data.Chunk r8 = (com.uploadcare.android.widget.data.Chunk) r8
            java.lang.String r8 = r8.getPathChunk()
            r4.append(r8)
            goto L_0x00e9
        L_0x007d:
            boolean r8 = r6.isRoot
            if (r8 == 0) goto L_0x0093
            java.util.List<com.uploadcare.android.widget.data.Chunk> r8 = r6.chunks
            int r0 = r6.currentChunk
            java.lang.Object r8 = r8.get(r0)
            com.uploadcare.android.widget.data.Chunk r8 = (com.uploadcare.android.widget.data.Chunk) r8
            java.lang.String r8 = r8.getPathChunk()
            r4.append(r8)
            goto L_0x00e9
        L_0x0093:
            com.uploadcare.android.widget.data.SocialSource r8 = r6.socialSource
            if (r8 == 0) goto L_0x00ab
            java.util.List r8 = r8.getRootChunks()
            if (r8 == 0) goto L_0x00ab
            int r3 = r6.currentChunk
            java.lang.Object r8 = r8.get(r3)
            com.uploadcare.android.widget.data.Chunk r8 = (com.uploadcare.android.widget.data.Chunk) r8
            if (r8 == 0) goto L_0x00ab
            java.lang.String r0 = r8.getPathChunk()
        L_0x00ab:
            r4.append(r0)
            r4.append(r5)
            java.util.List<com.uploadcare.android.widget.data.Chunk> r8 = r6.chunks
            java.util.Collection r8 = (java.util.Collection) r8
            int r8 = r8.size()
        L_0x00b9:
            if (r1 >= r8) goto L_0x00e9
            java.util.List<com.uploadcare.android.widget.data.Chunk> r0 = r6.chunks
            int r0 = r0.size()
            int r0 = r0 - r2
            if (r1 == r0) goto L_0x00d7
            java.util.List<com.uploadcare.android.widget.data.Chunk> r0 = r6.chunks
            java.lang.Object r0 = r0.get(r1)
            com.uploadcare.android.widget.data.Chunk r0 = (com.uploadcare.android.widget.data.Chunk) r0
            java.lang.String r0 = r0.getPathChunk()
            r4.append(r0)
            r4.append(r5)
            goto L_0x00e6
        L_0x00d7:
            java.util.List<com.uploadcare.android.widget.data.Chunk> r0 = r6.chunks
            java.lang.Object r0 = r0.get(r1)
            com.uploadcare.android.widget.data.Chunk r0 = (com.uploadcare.android.widget.data.Chunk) r0
            java.lang.String r0 = r0.getPathChunk()
            r4.append(r0)
        L_0x00e6:
            int r1 = r1 + 1
            goto L_0x00b9
        L_0x00e9:
            com.uploadcare.android.widget.controller.UploadcareWidget$Companion r8 = com.uploadcare.android.widget.controller.UploadcareWidget.Companion
            com.uploadcare.android.widget.controller.UploadcareWidget r8 = r8.getInstance()
            com.uploadcare.android.widget.interfaces.SocialApi r8 = r8.getSocialApi$widget_release()
            com.uploadcare.android.widget.data.SocialSource r0 = r6.socialSource
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x010b
            android.app.Application r2 = r6.getApplication()
            java.lang.String r3 = "getApplication()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r0 = r0.getCookie(r2)
            if (r0 == 0) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r0 = r1
        L_0x010c:
            com.uploadcare.android.widget.data.SocialSource r2 = r6.socialSource
            if (r2 == 0) goto L_0x011d
            com.uploadcare.android.widget.data.Urls r2 = r2.getUrls()
            if (r2 == 0) goto L_0x011d
            java.lang.String r2 = r2.getSourceBase()
            if (r2 == 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r2 = r1
        L_0x011e:
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "stringBuilder.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r7 == 0) goto L_0x012d
            java.lang.String r1 = r6.getNext()
        L_0x012d:
            retrofit2.Call r8 = r8.getSourceChunk(r0, r2, r3, r1)
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel$getChunkData$1 r0 = new com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel$getChunkData$1
            r0.<init>(r6, r7)
            retrofit2.Callback r0 = (retrofit2.Callback) r0
            r8.enqueue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel.getChunkData(boolean, java.lang.String):void");
    }

    private final String getNext() {
        List<Chunk> chunks2;
        StringBuilder sb = new StringBuilder();
        Path path = this.nextPath;
        if (!(path == null || (chunks2 = path.getChunks()) == null)) {
            int size = chunks2.size();
            for (int i = 0; i < size; i++) {
                if (i != chunks2.size() - 1) {
                    sb.append(chunks2.get(i).getPathChunk());
                    sb.append("/");
                } else {
                    sb.append(chunks2.get(i).getPathChunk());
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }
}
