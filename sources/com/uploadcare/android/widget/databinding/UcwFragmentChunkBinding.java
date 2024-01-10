package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel;

public abstract class UcwFragmentChunkBinding extends ViewDataBinding {
    @Bindable
    protected UploadcareChunkViewModel mViewModel;
    public final ProgressBar progress;
    public final TextView ucwAdditionalLoading;
    public final ImageView ucwEmptyImage;
    public final TextView ucwEmptyText;
    public final RecyclerView ucwRecyclerView;
    public final SearchView ucwSearchView;

    public abstract void setViewModel(UploadcareChunkViewModel uploadcareChunkViewModel);

    protected UcwFragmentChunkBinding(Object obj, View view, int i, ProgressBar progressBar, TextView textView, ImageView imageView, TextView textView2, RecyclerView recyclerView, SearchView searchView) {
        super(obj, view, i);
        this.progress = progressBar;
        this.ucwAdditionalLoading = textView;
        this.ucwEmptyImage = imageView;
        this.ucwEmptyText = textView2;
        this.ucwRecyclerView = recyclerView;
        this.ucwSearchView = searchView;
    }

    public UploadcareChunkViewModel getViewModel() {
        return this.mViewModel;
    }

    public static UcwFragmentChunkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentChunkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwFragmentChunkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_chunk, viewGroup, z, obj);
    }

    public static UcwFragmentChunkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentChunkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwFragmentChunkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_fragment_chunk, (ViewGroup) null, false, obj);
    }

    public static UcwFragmentChunkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFragmentChunkBinding bind(View view, Object obj) {
        return (UcwFragmentChunkBinding) bind(obj, view, R.layout.ucw_fragment_chunk);
    }
}
