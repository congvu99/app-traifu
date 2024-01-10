package com.uploadcare.android.widget.viewmodels;

import androidx.core.app.NotificationCompat;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.data.SocialSourcesResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/uploadcare/android/widget/viewmodels/UploadcareViewModel$getAvailableNetworks$1", "Lretrofit2/Callback;", "Lcom/uploadcare/android/widget/data/SocialSourcesResponse;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareViewModel.kt */
public final class UploadcareViewModel$getAvailableNetworks$1 implements Callback<SocialSourcesResponse> {
    final /* synthetic */ UploadcareViewModel this$0;

    UploadcareViewModel$getAvailableNetworks$1(UploadcareViewModel uploadcareViewModel) {
        this.this$0 = uploadcareViewModel;
    }

    public void onFailure(Call<SocialSourcesResponse> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "t");
        this.this$0.getProgressDialogCommand().postValue(new ProgressData(false, (String) null, false, false, 14, (DefaultConstructorMarker) null));
        this.this$0.getCloseWidgetCommand().postValue(new UploadcareApiException(th));
    }

    public void onResponse(Call<SocialSourcesResponse> call, Response<SocialSourcesResponse> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        this.this$0.getProgressDialogCommand().postValue(new ProgressData(false, (String) null, false, false, 14, (DefaultConstructorMarker) null));
        SocialSourcesResponse body = response.body();
        this.this$0.sources = body != null ? body.getSources() : null;
        List access$getSources$p = this.this$0.sources;
        if (access$getSources$p != null) {
            this.this$0.showNetworks(access$getSources$p);
        } else {
            this.this$0.getCloseWidgetCommand().call();
        }
    }
}
