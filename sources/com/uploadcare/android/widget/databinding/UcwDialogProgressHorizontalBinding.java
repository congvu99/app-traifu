package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.dialogs.ProgressDialog;

public abstract class UcwDialogProgressHorizontalBinding extends ViewDataBinding {
    @Bindable
    protected ProgressDialog mDialog;
    public final ProgressBar progress;

    public abstract void setDialog(ProgressDialog progressDialog);

    protected UcwDialogProgressHorizontalBinding(Object obj, View view, int i, ProgressBar progressBar) {
        super(obj, view, i);
        this.progress = progressBar;
    }

    public ProgressDialog getDialog() {
        return this.mDialog;
    }

    public static UcwDialogProgressHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogProgressHorizontalBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwDialogProgressHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_dialog_progress_horizontal, viewGroup, z, obj);
    }

    public static UcwDialogProgressHorizontalBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogProgressHorizontalBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwDialogProgressHorizontalBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_dialog_progress_horizontal, (ViewGroup) null, false, obj);
    }

    public static UcwDialogProgressHorizontalBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogProgressHorizontalBinding bind(View view, Object obj) {
        return (UcwDialogProgressHorizontalBinding) bind(obj, view, R.layout.ucw_dialog_progress_horizontal);
    }
}
