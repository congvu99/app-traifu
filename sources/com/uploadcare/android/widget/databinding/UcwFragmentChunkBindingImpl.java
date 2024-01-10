package com.uploadcare.android.widget.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.widget.BR;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.utils.BindingAdapters;
import com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel;

public class UcwFragmentChunkBindingImpl extends UcwFragmentChunkBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ucw_recycler_view, 6);
    }

    public UcwFragmentChunkBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private UcwFragmentChunkBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, objArr[2], objArr[5], objArr[3], objArr[4], objArr[6], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.progress.setTag((Object) null);
        this.ucwAdditionalLoading.setTag((Object) null);
        this.ucwEmptyImage.setTag((Object) null);
        this.ucwEmptyText.setTag((Object) null);
        this.ucwSearchView.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        setViewModel((UploadcareChunkViewModel) obj);
        return true;
    }

    public void setViewModel(UploadcareChunkViewModel uploadcareChunkViewModel) {
        this.mViewModel = uploadcareChunkViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeViewModelLoading((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return onChangeViewModelIsSearch((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelIsEmpty((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeViewModelLoadingMore((MutableLiveData) obj, i2);
    }

    private boolean onChangeViewModelLoading(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelIsSearch(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsEmpty(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelLoadingMore(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UploadcareChunkViewModel uploadcareChunkViewModel = this.mViewModel;
        if ((63 & j) != 0) {
            if ((j & 49) != 0) {
                MutableLiveData<Boolean> loading = uploadcareChunkViewModel != null ? uploadcareChunkViewModel.getLoading() : null;
                updateLiveDataRegistration(0, loading);
                z5 = ViewDataBinding.safeUnbox(loading != null ? loading.getValue() : null);
            } else {
                z5 = false;
            }
            if ((j & 50) != 0) {
                MutableLiveData<Boolean> isSearch = uploadcareChunkViewModel != null ? uploadcareChunkViewModel.isSearch() : null;
                updateLiveDataRegistration(1, isSearch);
                z2 = ViewDataBinding.safeUnbox(isSearch != null ? isSearch.getValue() : null);
            } else {
                z2 = false;
            }
            if ((j & 52) != 0) {
                MutableLiveData<Boolean> isEmpty = uploadcareChunkViewModel != null ? uploadcareChunkViewModel.isEmpty() : null;
                updateLiveDataRegistration(2, isEmpty);
                z6 = ViewDataBinding.safeUnbox(isEmpty != null ? isEmpty.getValue() : null);
            } else {
                z6 = false;
            }
            if ((j & 56) != 0) {
                MutableLiveData<Boolean> loadingMore = uploadcareChunkViewModel != null ? uploadcareChunkViewModel.getLoadingMore() : null;
                updateLiveDataRegistration(3, loadingMore);
                z4 = ViewDataBinding.safeUnbox(loadingMore != null ? loadingMore.getValue() : null);
            } else {
                z4 = false;
            }
            boolean z7 = z6;
            z = z5;
            z3 = z7;
        } else {
            z4 = false;
            z3 = false;
            z2 = false;
            z = false;
        }
        if ((j & 49) != 0) {
            BindingAdapters.setIsVisible(this.progress, z);
        }
        if ((56 & j) != 0) {
            BindingAdapters.setIsVisible(this.ucwAdditionalLoading, z4);
        }
        if ((52 & j) != 0) {
            BindingAdapters.setIsVisible(this.ucwEmptyImage, z3);
            BindingAdapters.setIsVisible(this.ucwEmptyText, z3);
        }
        if ((j & 50) != 0) {
            BindingAdapters.setIsVisible(this.ucwSearchView, z2);
        }
    }
}
