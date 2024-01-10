package com.uploadcare.android.widget.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.uploadcare.android.widget.BR;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.adapter.ThingLinearViewHolder;
import com.uploadcare.android.widget.data.Thing;
import com.uploadcare.android.widget.generated.callback.OnClickListener;

public class UcwFileLinearItemBindingImpl extends UcwFileLinearItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback2;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.ucw_item_tb, 2);
    }

    public UcwFileLinearItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private UcwFileLinearItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.ucwItemRoot.setTag((Object) null);
        this.ucwItemTitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
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
        if (BR.handler == i) {
            setHandler((ThingLinearViewHolder) obj);
        } else if (BR.thing != i) {
            return false;
        } else {
            setThing((Thing) obj);
        }
        return true;
    }

    public void setHandler(ThingLinearViewHolder thingLinearViewHolder) {
        this.mHandler = thingLinearViewHolder;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }

    public void setThing(Thing thing) {
        this.mThing = thing;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.thing);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        ThingLinearViewHolder thingLinearViewHolder = this.mHandler;
        String str = null;
        Thing thing = this.mThing;
        int i = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (!(i == 0 || thing == null)) {
            str = thing.getTitle();
        }
        if ((j & 4) != 0) {
            this.ucwItemRoot.setOnClickListener(this.mCallback2);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.ucwItemTitle, str);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        ThingLinearViewHolder thingLinearViewHolder = this.mHandler;
        Thing thing = this.mThing;
        if (thingLinearViewHolder != null) {
            thingLinearViewHolder.select(thing);
        }
    }
}
