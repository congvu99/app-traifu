package com.uploadcare.android.widget.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.uploadcare.android.widget.BR;
import com.uploadcare.android.widget.adapter.SocialNetworksAdapter;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.generated.callback.OnClickListener;

public class UcwDialogNetworkItemBindingImpl extends UcwDialogNetworkItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public UcwDialogNetworkItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private UcwDialogNetworkItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.ucwNetworkIcon.setTag((Object) null);
        this.ucwNetworkName.setTag((Object) null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
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
        if (BR.adapter == i) {
            setAdapter((SocialNetworksAdapter) obj);
        } else if (BR.socialSource != i) {
            return false;
        } else {
            setSocialSource((SocialSource) obj);
        }
        return true;
    }

    public void setAdapter(SocialNetworksAdapter socialNetworksAdapter) {
        this.mAdapter = socialNetworksAdapter;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }

    public void setSocialSource(SocialSource socialSource) {
        this.mSocialSource = socialSource;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.socialSource);
        super.requestRebind();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: int} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.mDirtyFlags     // Catch:{ all -> 0x0051 }
            r2 = 0
            r12.mDirtyFlags = r2     // Catch:{ all -> 0x0051 }
            monitor-exit(r12)     // Catch:{ all -> 0x0051 }
            com.uploadcare.android.widget.adapter.SocialNetworksAdapter r4 = r12.mAdapter
            com.uploadcare.android.widget.data.SocialSource r4 = r12.mSocialSource
            r5 = 6
            long r5 = r5 & r0
            r7 = 0
            int r8 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x002b
            if (r4 == 0) goto L_0x001f
            int r5 = r4.getNetworkIconResource()
            int r4 = r4.getNetworkNameResource()
            goto L_0x0021
        L_0x001f:
            r4 = 0
            r5 = 0
        L_0x0021:
            r6 = -1
            if (r5 == r6) goto L_0x0026
            r6 = 1
            r7 = 1
        L_0x0026:
            r11 = r5
            r5 = r4
            r4 = r7
            r7 = r11
            goto L_0x002d
        L_0x002b:
            r4 = 0
            r5 = 0
        L_0x002d:
            r9 = 4
            long r0 = r0 & r9
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x003b
            androidx.constraintlayout.widget.ConstraintLayout r0 = r12.mboundView0
            android.view.View$OnClickListener r1 = r12.mCallback3
            r0.setOnClickListener(r1)
        L_0x003b:
            if (r8 == 0) goto L_0x0050
            android.widget.ImageView r0 = r12.ucwNetworkIcon
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            com.uploadcare.android.widget.utils.BindingAdapters.setImageBitmap(r0, r1)
            android.widget.ImageView r0 = r12.ucwNetworkIcon
            com.uploadcare.android.widget.utils.BindingAdapters.setIsVisible(r0, r4)
            android.widget.TextView r0 = r12.ucwNetworkName
            r0.setText(r5)
        L_0x0050:
            return
        L_0x0051:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0051 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.databinding.UcwDialogNetworkItemBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        SocialNetworksAdapter socialNetworksAdapter = this.mAdapter;
        SocialSource socialSource = this.mSocialSource;
        if (socialNetworksAdapter != null) {
            socialNetworksAdapter.onSocialSourceSelected(socialSource);
        }
    }
}
