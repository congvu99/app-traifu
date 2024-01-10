package com.uploadcare.android.widget.viewmodels;

import androidx.core.app.NotificationCompat;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.data.SelectedFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, d2 = {"com/uploadcare/android/widget/viewmodels/UploadcareFilesViewModel$selectFile$1$1", "Lretrofit2/Callback;", "Lcom/uploadcare/android/widget/data/SelectedFile;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFilesViewModel.kt */
public final class UploadcareFilesViewModel$selectFile$$inlined$let$lambda$1 implements Callback<SelectedFile> {
    final /* synthetic */ String $fileUrl$inlined;
    final /* synthetic */ UploadcareFilesViewModel this$0;

    UploadcareFilesViewModel$selectFile$$inlined$let$lambda$1(UploadcareFilesViewModel uploadcareFilesViewModel, String str) {
        this.this$0 = uploadcareFilesViewModel;
        this.$fileUrl$inlined = str;
    }

    public void onFailure(Call<SelectedFile> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "t");
        this.this$0.error(new UploadcareApiException(th));
    }

    public void onResponse(Call<SelectedFile> call, Response<SelectedFile> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        SelectedFile body = response.body();
        if (body != null) {
            UploadcareFilesViewModel uploadcareFilesViewModel = this.this$0;
            Intrinsics.checkNotNullExpressionValue(body, "it");
            uploadcareFilesViewModel.uploadFileFromUrl(body);
            return;
        }
        UploadcareFilesViewModel.error$default(this.this$0, (UploadcareApiException) null, 1, (Object) null);
    }
}
