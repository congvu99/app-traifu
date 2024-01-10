package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;

public abstract class UcwFragmentUploadcareBinding extends ViewDataBinding {
    protected UcwFragmentUploadcareBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static UcwFragmentUploadcareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentUploadcareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwFragmentUploadcareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_uploadcare, viewGroup, z, obj);
    }

    public static UcwFragmentUploadcareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentUploadcareBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwFragmentUploadcareBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_uploadcare, (ViewGroup) null, false, obj);
    }

    public static UcwFragmentUploadcareBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentUploadcareBinding bind(View view, Object obj) {
        return (UcwFragmentUploadcareBinding) bind(obj, view, R.layout.ucw_fragment_uploadcare);
    }
}
