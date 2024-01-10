package com.uploadcare.android.widget.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.widget.BR;
import com.uploadcare.android.widget.dialogs.ProgressDialog;

public class UcwDialogProgressHorizontalBindingImpl extends UcwDialogProgressHorizontalBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public UcwDialogProgressHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private UcwDialogProgressHorizontalBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.progress.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (BR.dialog != i) {
            return false;
        }
        setDialog((ProgressDialog) obj);
        return true;
    }

    public void setDialog(ProgressDialog progressDialog) {
        this.mDialog = progressDialog;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.dialog);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeDialogUploadProgress((MutableLiveData) obj, i2);
    }

    private boolean onChangeDialogUploadProgress(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ProgressDialog progressDialog = this.mDialog;
        int i = 0;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            Integer num = null;
            MutableLiveData<Integer> uploadProgress = progressDialog != null ? progressDialog.getUploadProgress() : null;
            updateLiveDataRegistration(0, uploadProgress);
            if (uploadProgress != null) {
                num = uploadProgress.getValue();
            }
            i = ViewDataBinding.safeUnbox(num);
        }
        if (i2 != 0) {
            this.progress.setProgress(i);
        }
    }
}
