package com.uploadcare.android.widget.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareException;
import com.uploadcare.android.widget.controller.UploadcareWidgetResult;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "uploadcareFile", "Lcom/uploadcare/android/library/api/UploadcareFile;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareFilesFragment.kt */
final class UploadcareFilesFragment$onCreateView$6<T> implements Observer<UploadcareFile> {
    final /* synthetic */ UploadcareFilesFragment this$0;

    UploadcareFilesFragment$onCreateView$6(UploadcareFilesFragment uploadcareFilesFragment) {
        this.this$0 = uploadcareFilesFragment;
    }

    public final void onChanged(UploadcareFile uploadcareFile) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("result", new UploadcareWidgetResult(uploadcareFile, (UUID) null, (UploadcareException) null, 6, (DefaultConstructorMarker) null));
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }
}
