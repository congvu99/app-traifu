package com.uploadcare.android.widget.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.exceptions.UploadcareException;
import com.uploadcare.android.widget.controller.UploadcareWidgetResult;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "exception", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
final class UploadcareFragment$onCreateView$7<T> implements Observer<UploadcareApiException> {
    final /* synthetic */ UploadcareFragment this$0;

    UploadcareFragment$onCreateView$7(UploadcareFragment uploadcareFragment) {
        this.this$0 = uploadcareFragment;
    }

    public final void onChanged(UploadcareApiException uploadcareApiException) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("result", new UploadcareWidgetResult((UploadcareFile) null, (UUID) null, new UploadcareException(uploadcareApiException != null ? uploadcareApiException.getMessage() : null), 3, (DefaultConstructorMarker) null));
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }
}
