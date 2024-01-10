package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.adapter.SocialNetworksAdapter;
import com.uploadcare.android.widget.data.SocialSource;

public abstract class UcwDialogNetworkItemBinding extends ViewDataBinding {
    @Bindable
    protected SocialNetworksAdapter mAdapter;
    @Bindable
    protected SocialSource mSocialSource;
    public final ImageView ucwNetworkIcon;
    public final TextView ucwNetworkName;

    public abstract void setAdapter(SocialNetworksAdapter socialNetworksAdapter);

    public abstract void setSocialSource(SocialSource socialSource);

    protected UcwDialogNetworkItemBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.ucwNetworkIcon = imageView;
        this.ucwNetworkName = textView;
    }

    public SocialNetworksAdapter getAdapter() {
        return this.mAdapter;
    }

    public SocialSource getSocialSource() {
        return this.mSocialSource;
    }

    public static UcwDialogNetworkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogNetworkItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwDialogNetworkItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_dialog_network_item, viewGroup, z, obj);
    }

    public static UcwDialogNetworkItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogNetworkItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwDialogNetworkItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_dialog_network_item, (ViewGroup) null, false, obj);
    }

    public static UcwDialogNetworkItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwDialogNetworkItemBinding bind(View view, Object obj) {
        return (UcwDialogNetworkItemBinding) bind(obj, view, R.layout.ucw_dialog_network_item);
    }
}
