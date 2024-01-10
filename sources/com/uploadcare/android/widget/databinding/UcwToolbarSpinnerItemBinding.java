package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;

public abstract class UcwToolbarSpinnerItemBinding extends ViewDataBinding {
    @Bindable
    protected String mText;
    public final TextView ucwSpinnerTitle;

    public abstract void setText(String str);

    protected UcwToolbarSpinnerItemBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.ucwSpinnerTitle = textView;
    }

    public String getText() {
        return this.mText;
    }

    public static UcwToolbarSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwToolbarSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwToolbarSpinnerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_toolbar_spinner_item, viewGroup, z, obj);
    }

    public static UcwToolbarSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwToolbarSpinnerItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwToolbarSpinnerItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_toolbar_spinner_item, (ViewGroup) null, false, obj);
    }

    public static UcwToolbarSpinnerItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwToolbarSpinnerItemBinding bind(View view, Object obj) {
        return (UcwToolbarSpinnerItemBinding) bind(obj, view, R.layout.ucw_toolbar_spinner_item);
    }
}
