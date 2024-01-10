package com.uploadcare.android.widget.viewmodels;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.data.Chunk;
import com.uploadcare.android.widget.data.ChunkResponse;
import com.uploadcare.android.widget.data.Thing;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/uploadcare/android/widget/viewmodels/UploadcareChunkViewModel$getChunkData$1", "Lretrofit2/Callback;", "Lcom/uploadcare/android/widget/data/ChunkResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareChunkViewModel.kt */
public final class UploadcareChunkViewModel$getChunkData$1 implements Callback<ChunkResponse> {
    final /* synthetic */ boolean $loadMore;
    final /* synthetic */ UploadcareChunkViewModel this$0;

    UploadcareChunkViewModel$getChunkData$1(UploadcareChunkViewModel uploadcareChunkViewModel, boolean z) {
        this.this$0 = uploadcareChunkViewModel;
        this.$loadMore = z;
    }

    public void onFailure(Call<ChunkResponse> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "t");
        boolean z = false;
        this.this$0.getLoadingMore().setValue(false);
        this.this$0.getLoading().setValue(false);
        MutableLiveData<Boolean> isEmpty = this.this$0.isEmpty();
        List value = this.this$0.getThings().getValue();
        if (value != null && value.isEmpty()) {
            z = true;
        }
        isEmpty.setValue(Boolean.valueOf(z));
        this.this$0.getErrorCommand().postValue(new UploadcareApiException(th));
    }

    public void onResponse(Call<ChunkResponse> call, Response<ChunkResponse> response) {
        List<Thing> things;
        String loginLink;
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        boolean z = false;
        this.this$0.getLoadingMore().setValue(false);
        this.this$0.getLoading().setValue(false);
        ChunkResponse body = response.body();
        Chunk chunk = null;
        if ((body != null ? body.getError() : null) != null) {
            ChunkResponse body2 = response.body();
            if (!(body2 == null || (loginLink = body2.getLoginLink()) == null)) {
                this.this$0.getNeedAuthCommand().postValue(loginLink);
            }
        } else {
            UploadcareChunkViewModel uploadcareChunkViewModel = this.this$0;
            ChunkResponse body3 = response.body();
            uploadcareChunkViewModel.nextPath = body3 != null ? body3.getNextPage() : null;
            if (!this.$loadMore) {
                MutableLiveData<List<Thing>> things2 = this.this$0.getThings();
                ChunkResponse body4 = response.body();
                things2.setValue(body4 != null ? body4.getThings() : null);
            } else {
                ChunkResponse body5 = response.body();
                if (!(body5 == null || (things = body5.getThings()) == null)) {
                    if (this.this$0.getThings().getValue() != null) {
                        MutableLiveData<List<Thing>> things3 = this.this$0.getThings();
                        List value = this.this$0.getThings().getValue();
                        things3.setValue(value != null ? CollectionsKt.plus(value, things) : null);
                    } else {
                        this.this$0.getThings().setValue(things);
                    }
                }
            }
            if (this.this$0.nextPath != null) {
                this.this$0.getAllowLoadMore().postValue(true);
            }
        }
        MutableLiveData<Boolean> isSearch = this.this$0.isSearch();
        ChunkResponse body6 = response.body();
        if (body6 != null) {
            chunk = body6.getSearchPath();
        }
        isSearch.setValue(Boolean.valueOf(chunk != null));
        MutableLiveData<Boolean> isEmpty = this.this$0.isEmpty();
        List value2 = this.this$0.getThings().getValue();
        if (value2 != null && value2.isEmpty()) {
            z = true;
        }
        isEmpty.setValue(Boolean.valueOf(z));
    }
}
