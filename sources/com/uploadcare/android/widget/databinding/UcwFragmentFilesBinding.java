package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.viewmodels.UploadcareFilesViewModel;

public abstract class UcwFragmentFilesBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final FrameLayout chunkHolder;
    @Bindable
    protected UploadcareFilesViewModel mViewModel;
    public final ConstraintLayout ucwConstraintLayout;
    public final Spinner ucwSpinner;
    public final MaterialToolbar ucwToolbar;

    public abstract void setViewModel(UploadcareFilesViewModel uploadcareFilesViewModel);

    protected UcwFragmentFilesBinding(Object obj, View view, int i, AppBarLayout appBarLayout2, FrameLayout frameLayout, ConstraintLayout constraintLayout, Spinner spinner, MaterialToolbar materialToolbar) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout2;
        this.chunkHolder = frameLayout;
        this.ucwConstraintLayout = constraintLayout;
        this.ucwSpinner = spinner;
        this.ucwToolbar = materialToolbar;
    }

    public UploadcareFilesViewModel getViewModel() {
        return this.mViewModel;
    }

    public static UcwFragmentFilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentFilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwFragmentFilesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_files, viewGroup, z, obj);
    }

    public static UcwFragmentFilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentFilesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwFragmentFilesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_files, (ViewGroup) null, false, obj);
    }

    public static UcwFragmentFilesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentFilesBinding bind(View view, Object obj) {
        return (UcwFragmentFilesBinding) bind(obj, view, R.layout.ucw_fragment_files);
    }
}
