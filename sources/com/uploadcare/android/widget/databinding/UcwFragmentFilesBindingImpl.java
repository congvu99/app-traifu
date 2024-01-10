package com.uploadcare.android.widget.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.widget.BR;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.utils.BindingAdapters;
import com.uploadcare.android.widget.viewmodels.UploadcareFilesViewModel;

public class UcwFragmentFilesBindingImpl extends UcwFragmentFilesBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.app_bar_layout, 2);
        sViewsWithIds.put(R.id.ucw_toolbar, 3);
        sViewsWithIds.put(R.id.chunkHolder, 4);
    }

    public UcwFragmentFilesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private UcwFragmentFilesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[2], objArr[4], objArr[0], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.ucwConstraintLayout.setTag((Object) null);
        this.ucwSpinner.setTag((Object) null);
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
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((UploadcareFilesViewModel) obj);
        return true;
    }

    public void setViewModel(UploadcareFilesViewModel uploadcareFilesViewModel) {
        this.mViewModel = uploadcareFilesViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeViewModelIsRoot((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelIsRoot(MutableLiveData<Boolean> mutableLiveData, int i) {
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
        UploadcareFilesViewModel uploadcareFilesViewModel = this.mViewModel;
        boolean z = false;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i != 0) {
            Boolean bool = null;
            MutableLiveData<Boolean> isRoot = uploadcareFilesViewModel != null ? uploadcareFilesViewModel.isRoot() : null;
            updateLiveDataRegistration(0, isRoot);
            if (isRoot != null) {
                bool = isRoot.getValue();
            }
            z = ViewDataBinding.safeUnbox(bool);
        }
        if (i != 0) {
            BindingAdapters.setIsVisible(this.ucwSpinner, z);
        }
    }
}
