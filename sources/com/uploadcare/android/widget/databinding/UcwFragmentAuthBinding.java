package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;

public abstract class UcwFragmentAuthBinding extends ViewDataBinding {
    public final ProgressBar progress;
    public final WebView ucwWebview;

    protected UcwFragmentAuthBinding(Object obj, View view, int i, ProgressBar progressBar, WebView webView) {
        super(obj, view, i);
        this.progress = progressBar;
        this.ucwWebview = webView;
    }

    public static UcwFragmentAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwFragmentAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_auth, viewGroup, z, obj);
    }

    public static UcwFragmentAuthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentAuthBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwFragmentAuthBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_auth, (ViewGroup) null, false, obj);
    }

    public static UcwFragmentAuthBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentAuthBinding bind(View view, Object obj) {
        return (UcwFragmentAuthBinding) bind(obj, view, R.layout.ucw_fragment_auth);
    }
}
