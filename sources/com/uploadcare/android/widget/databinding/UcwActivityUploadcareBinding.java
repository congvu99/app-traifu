package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;

public abstract class UcwActivityUploadcareBinding extends ViewDataBinding {
    public final ConstraintLayout activityRoot;

    protected UcwActivityUploadcareBinding(Object obj, View view, int i, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.activityRoot = constraintLayout;
    }

    public static UcwActivityUploadcareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwActivityUploadcareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwActivityUploadcareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_activity_uploadcare, viewGroup, z, obj);
    }

    public static UcwActivityUploadcareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwActivityUploadcareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwActivityUploadcareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_activity_uploadcare, (ViewGroup) null, false, obj);
    }

    public static UcwActivityUploadcareBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwActivityUploadcareBinding bind(View view, Object obj) {
        return (UcwActivityUploadcareBinding) bind(obj, view, R.layout.ucw_activity_uploadcare);
    }
}
