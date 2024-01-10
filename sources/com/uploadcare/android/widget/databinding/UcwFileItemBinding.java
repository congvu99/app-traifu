package com.uploadcare.android.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.adapter.ThingGridViewHolder;
import com.uploadcare.android.widget.data.Thing;
import com.uploadcare.android.widget.view.SquaredImageView;

public abstract class UcwFileItemBinding extends ViewDataBinding {
    @Bindable
    protected ThingGridViewHolder mHandler;
    @Bindable
    protected Thing mThing;
    public final ConstraintLayout ucwItemRoot;
    public final SquaredImageView ucwItemTb;
    public final TextView ucwItemTitle;

    public abstract void setHandler(ThingGridViewHolder thingGridViewHolder);

    public abstract void setThing(Thing thing);

    protected UcwFileItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, SquaredImageView squaredImageView, TextView textView) {
        super(obj, view, i);
        this.ucwItemRoot = constraintLayout;
        this.ucwItemTb = squaredImageView;
        this.ucwItemTitle = textView;
    }

    public Thing getThing() {
        return this.mThing;
    }

    public ThingGridViewHolder getHandler() {
        return this.mHandler;
    }

    public static UcwFileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFileItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (UcwFileItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_file_item, viewGroup, z, obj);
    }

    public static UcwFileItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFileItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (UcwFileItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ucw_file_item, (ViewGroup) null, false, obj);
    }

    public static UcwFileItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UcwFileItemBinding bind(View view, Object obj) {
        return (UcwFileItemBinding) bind(obj, view, R.layout.ucw_file_item);
    }
}
