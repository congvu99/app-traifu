package com.uploadcare.android.widget.controller;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.WorkInfo;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareException;
import com.uploadcare.android.widget.controller.UploadcareWidget;
import com.uploadcare.android.widget.worker.FileUploadWorker;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "workInfo", "Landroidx/work/WorkInfo;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareWidget.kt */
final class UploadcareWidget$backgroundUploadResult$1<T> implements Observer<WorkInfo> {
    final /* synthetic */ MediatorLiveData $result;
    final /* synthetic */ UUID $uuid;
    final /* synthetic */ LiveData $workerLiveData;
    final /* synthetic */ UploadcareWidget this$0;

    UploadcareWidget$backgroundUploadResult$1(UploadcareWidget uploadcareWidget, MediatorLiveData mediatorLiveData, LiveData liveData, UUID uuid) {
        this.this$0 = uploadcareWidget;
        this.$result = mediatorLiveData;
        this.$workerLiveData = liveData;
        this.$uuid = uuid;
    }

    public final void onChanged(WorkInfo workInfo) {
        UploadcareWidgetResult uploadcareWidgetResult;
        if (workInfo == null) {
            this.$result.setValue(null);
            this.$result.removeSource(this.$workerLiveData);
            return;
        }
        int i = UploadcareWidget.WhenMappings.$EnumSwitchMapping$0[workInfo.getState().ordinal()];
        if (i == 1) {
            String string = workInfo.getOutputData().getString(FileUploadWorker.KEY_UPLOADCARE_FILE);
            MediatorLiveData mediatorLiveData = this.$result;
            if (string != null) {
                uploadcareWidgetResult = new UploadcareWidgetResult((UploadcareFile) this.this$0.getUploadcareClient().getObjectMapper().fromJson(string, UploadcareFile.class), (UUID) null, (UploadcareException) null, 6, (DefaultConstructorMarker) null);
            } else {
                uploadcareWidgetResult = new UploadcareWidgetResult((UploadcareFile) null, (UUID) null, (UploadcareException) null, 6, (DefaultConstructorMarker) null);
            }
            mediatorLiveData.setValue(uploadcareWidgetResult);
        } else if (i == 2) {
            this.$result.setValue(new UploadcareWidgetResult((UploadcareFile) null, (UUID) null, new UploadcareException(workInfo.getOutputData().getString(FileUploadWorker.KEY_ERROR)), 3, (DefaultConstructorMarker) null));
        } else if (i != 3) {
            this.$result.setValue(new UploadcareWidgetResult((UploadcareFile) null, this.$uuid, (UploadcareException) null, 5, (DefaultConstructorMarker) null));
        } else {
            this.$result.setValue(new UploadcareWidgetResult((UploadcareFile) null, (UUID) null, new UploadcareException("Canceled"), 3, (DefaultConstructorMarker) null));
        }
        WorkInfo.State state = workInfo.getState();
        Intrinsics.checkNotNullExpressionValue(state, "workInfo.state");
        if (state.isFinished()) {
            this.$result.removeSource(this.$workerLiveData);
        }
    }
}
