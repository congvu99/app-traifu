package com.uploadcare.android.widget.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import com.uploadcare.android.widget.adapter.FilesAdapter;
import com.uploadcare.android.widget.data.Chunk;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding;
import com.uploadcare.android.widget.utils.RecyclerViewOnScrollListener;
import com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareChunkFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/appcompat/widget/SearchView$OnQueryTextListener;", "()V", "binding", "Lcom/uploadcare/android/widget/databinding/UcwFragmentChunkBinding;", "mAdapter", "Lcom/uploadcare/android/widget/adapter/FilesAdapter;", "mOnFileActionsListener", "Lcom/uploadcare/android/widget/fragment/OnFileActionsListener;", "mOnScrollListener", "Lcom/uploadcare/android/widget/utils/RecyclerViewOnScrollListener;", "viewModel", "Lcom/uploadcare/android/widget/viewmodels/UploadcareChunkViewModel;", "changeChunk", "", "position", "", "getTitle", "", "itemSelected", "thing", "Lcom/uploadcare/android/widget/data/Thing;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onQueryTextChange", "", "newText", "onQueryTextSubmit", "query", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareChunkFragment.kt */
public final class UploadcareChunkFragment extends Fragment implements SearchView.OnQueryTextListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public UcwFragmentChunkBinding binding;
    /* access modifiers changed from: private */
    public FilesAdapter<?> mAdapter;
    /* access modifiers changed from: private */
    public OnFileActionsListener mOnFileActionsListener;
    /* access modifiers changed from: private */
    public RecyclerViewOnScrollListener mOnScrollListener;
    /* access modifiers changed from: private */
    public UploadcareChunkViewModel viewModel;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public boolean onQueryTextChange(String str) {
        return false;
    }

    public static final /* synthetic */ UcwFragmentChunkBinding access$getBinding$p(UploadcareChunkFragment uploadcareChunkFragment) {
        UcwFragmentChunkBinding ucwFragmentChunkBinding = uploadcareChunkFragment.binding;
        if (ucwFragmentChunkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return ucwFragmentChunkBinding;
    }

    public static final /* synthetic */ OnFileActionsListener access$getMOnFileActionsListener$p(UploadcareChunkFragment uploadcareChunkFragment) {
        OnFileActionsListener onFileActionsListener = uploadcareChunkFragment.mOnFileActionsListener;
        if (onFileActionsListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOnFileActionsListener");
        }
        return onFileActionsListener;
    }

    public static final /* synthetic */ UploadcareChunkViewModel access$getViewModel$p(UploadcareChunkFragment uploadcareChunkFragment) {
        UploadcareChunkViewModel uploadcareChunkViewModel = uploadcareChunkFragment.viewModel;
        if (uploadcareChunkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return uploadcareChunkViewModel;
    }

    public void onAttach(Context context) {
        OnFileActionsListener onFileActionsListener;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            if (getParentFragment() != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    onFileActionsListener = (OnFileActionsListener) parentFragment;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.uploadcare.android.widget.fragment.OnFileActionsListener");
                }
            } else {
                onFileActionsListener = (OnFileActionsListener) context;
            }
            this.mOnFileActionsListener = onFileActionsListener;
        } catch (ClassCastException unused) {
            throw new ClassCastException("Parent must implement OnFileActionsListener");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r6, android.view.ViewGroup r7, android.os.Bundle r8) {
        /*
            r5 = this;
            java.lang.String r8 = "inflater"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r8)
            r8 = 0
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding.inflate(r6, r7, r8)
            java.lang.String r7 = "UcwFragmentChunkBinding.…flater, container, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r5.binding = r6
            androidx.lifecycle.ViewModelProvider r6 = new androidx.lifecycle.ViewModelProvider
            r7 = r5
            androidx.lifecycle.ViewModelStoreOwner r7 = (androidx.lifecycle.ViewModelStoreOwner) r7
            r6.<init>(r7)
            java.lang.Class<com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel> r7 = com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel.class
            androidx.lifecycle.ViewModel r6 = r6.get(r7)
            java.lang.String r7 = "get(VM::class.java)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r6 = (com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel) r6
            r5.viewModel = r6
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = r5.binding
            java.lang.String r7 = "binding"
            if (r6 != 0) goto L_0x0031
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0031:
            androidx.lifecycle.LifecycleOwner r0 = r5.getViewLifecycleOwner()
            r6.setLifecycleOwner(r0)
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = r5.binding
            if (r6 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x003f:
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r0 = r5.viewModel
            java.lang.String r1 = "viewModel"
            if (r0 != 0) goto L_0x0048
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0048:
            r6.setViewModel(r0)
            android.os.Bundle r6 = r5.getArguments()
            r0 = 0
            if (r6 == 0) goto L_0x005b
            java.lang.String r2 = "socialSource"
            android.os.Parcelable r6 = r6.getParcelable(r2)
            com.uploadcare.android.widget.data.SocialSource r6 = (com.uploadcare.android.widget.data.SocialSource) r6
            goto L_0x005c
        L_0x005b:
            r6 = r0
        L_0x005c:
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r2 = r5.binding
            if (r2 != 0) goto L_0x0063
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0063:
            androidx.recyclerview.widget.RecyclerView r2 = r2.ucwRecyclerView
            if (r6 == 0) goto L_0x006c
            java.lang.String r3 = r6.getName()
            goto L_0x006d
        L_0x006c:
            r3 = r0
        L_0x006d:
            com.uploadcare.android.widget.controller.SocialNetwork r4 = com.uploadcare.android.widget.controller.SocialNetwork.SOCIAL_NETWORK_BOX
            java.lang.String r4 = r4.getRawValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0100
            if (r6 == 0) goto L_0x0080
            java.lang.String r3 = r6.getName()
            goto L_0x0081
        L_0x0080:
            r3 = r0
        L_0x0081:
            com.uploadcare.android.widget.controller.SocialNetwork r4 = com.uploadcare.android.widget.controller.SocialNetwork.SOCIAL_NETWORK_DROPBOX
            java.lang.String r4 = r4.getRawValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0100
            if (r6 == 0) goto L_0x0094
            java.lang.String r3 = r6.getName()
            goto L_0x0095
        L_0x0094:
            r3 = r0
        L_0x0095:
            com.uploadcare.android.widget.controller.SocialNetwork r4 = com.uploadcare.android.widget.controller.SocialNetwork.SOCIAL_NETWORK_EVERNOTE
            java.lang.String r4 = r4.getRawValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0100
            if (r6 == 0) goto L_0x00a8
            java.lang.String r3 = r6.getName()
            goto L_0x00a9
        L_0x00a8:
            r3 = r0
        L_0x00a9:
            com.uploadcare.android.widget.controller.SocialNetwork r4 = com.uploadcare.android.widget.controller.SocialNetwork.SOCIAL_NETWORK_SKYDRIVE
            java.lang.String r4 = r4.getRawValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 != 0) goto L_0x0100
            if (r6 == 0) goto L_0x00bb
            java.lang.String r0 = r6.getName()
        L_0x00bb:
            com.uploadcare.android.widget.controller.SocialNetwork r3 = com.uploadcare.android.widget.controller.SocialNetwork.SOCIAL_NETWORK_GDRIVE
            java.lang.String r3 = r3.getRawValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x00c8
            goto L_0x0100
        L_0x00c8:
            androidx.recyclerview.widget.GridLayoutManager r8 = new androidx.recyclerview.widget.GridLayoutManager
            android.content.Context r0 = r2.getContext()
            android.content.res.Resources r3 = r2.getResources()
            int r4 = com.uploadcare.android.widget.R.integer.columns
            int r3 = r3.getInteger(r4)
            r8.<init>(r0, r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r8 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r8
            r2.setLayoutManager(r8)
            com.uploadcare.android.widget.adapter.FilesGridAdapter r8 = new com.uploadcare.android.widget.adapter.FilesGridAdapter
            com.uploadcare.android.widget.controller.FileType r0 = com.uploadcare.android.widget.controller.FileType.any
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$2 r3 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$2
            r3.<init>(r5, r6)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r8.<init>(r0, r3)
            com.uploadcare.android.widget.adapter.FilesAdapter r8 = (com.uploadcare.android.widget.adapter.FilesAdapter) r8
            r5.mAdapter = r8
            android.content.res.Resources r6 = r2.getResources()
            int r8 = com.uploadcare.android.widget.R.dimen.ucw_list_grid_padding
            int r6 = r6.getDimensionPixelSize(r8)
            r2.setPadding(r6, r6, r6, r6)
            goto L_0x012d
        L_0x0100:
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r2.getContext()
            r0.<init>(r3)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r2.setLayoutManager(r0)
            com.uploadcare.android.widget.adapter.FilesLinearAdapter r0 = new com.uploadcare.android.widget.adapter.FilesLinearAdapter
            com.uploadcare.android.widget.controller.FileType r3 = com.uploadcare.android.widget.controller.FileType.any
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$1 r4 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$apply$lambda$1
            r4.<init>(r5, r6)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r0.<init>(r3, r4)
            com.uploadcare.android.widget.adapter.FilesAdapter r0 = (com.uploadcare.android.widget.adapter.FilesAdapter) r0
            r5.mAdapter = r0
            android.content.res.Resources r6 = r2.getResources()
            int r0 = com.uploadcare.android.widget.R.dimen.ucw_list_linear_padding
            int r6 = r6.getDimensionPixelSize(r0)
            r2.setPadding(r8, r6, r8, r6)
        L_0x012d:
            com.uploadcare.android.widget.adapter.FilesAdapter<?> r6 = r5.mAdapter
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = (androidx.recyclerview.widget.RecyclerView.Adapter) r6
            r2.setAdapter(r6)
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = r5.binding
            if (r6 != 0) goto L_0x013b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x013b:
            androidx.appcompat.widget.SearchView r6 = r6.ucwSearchView
            r8 = r5
            androidx.appcompat.widget.SearchView$OnQueryTextListener r8 = (androidx.appcompat.widget.SearchView.OnQueryTextListener) r8
            r6.setOnQueryTextListener(r8)
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = r5.binding
            if (r6 != 0) goto L_0x014a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x014a:
            androidx.recyclerview.widget.RecyclerView r6 = r6.ucwRecyclerView
            java.lang.String r8 = "binding.ucwRecyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = r6.getLayoutManager()
            java.lang.String r8 = "it"
            if (r6 == 0) goto L_0x016a
            com.uploadcare.android.widget.utils.RecyclerViewOnScrollListener r0 = new com.uploadcare.android.widget.utils.RecyclerViewOnScrollListener
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$let$lambda$1 r2 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$$inlined$let$lambda$1
            r2.<init>(r5)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.<init>(r6, r2)
            r5.mOnScrollListener = r0
        L_0x016a:
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r6 = r5.viewModel
            if (r6 != 0) goto L_0x0171
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0171:
            androidx.lifecycle.MutableLiveData r6 = r6.getThings()
            androidx.lifecycle.LifecycleOwner r0 = r5.getViewLifecycleOwner()
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$3 r2 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$3
            r2.<init>(r5)
            androidx.lifecycle.Observer r2 = (androidx.lifecycle.Observer) r2
            r6.observe(r0, r2)
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r6 = r5.viewModel
            if (r6 != 0) goto L_0x018a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x018a:
            androidx.lifecycle.MutableLiveData r6 = r6.getAllowLoadMore()
            androidx.lifecycle.LifecycleOwner r0 = r5.getViewLifecycleOwner()
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$4 r2 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$4
            r2.<init>(r5)
            androidx.lifecycle.Observer r2 = (androidx.lifecycle.Observer) r2
            r6.observe(r0, r2)
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r6 = r5.viewModel
            if (r6 != 0) goto L_0x01a3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01a3:
            com.uploadcare.android.widget.utils.SingleLiveEvent r6 = r6.getErrorCommand()
            androidx.lifecycle.LifecycleOwner r0 = r5.getViewLifecycleOwner()
            java.lang.String r2 = "this.viewLifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$5 r3 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$5
            r3.<init>(r5)
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            r6.observe((androidx.lifecycle.LifecycleOwner) r0, r3)
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r6 = r5.viewModel
            if (r6 != 0) goto L_0x01c1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01c1:
            com.uploadcare.android.widget.utils.SingleLiveEvent r6 = r6.getNeedAuthCommand()
            androidx.lifecycle.LifecycleOwner r0 = r5.getViewLifecycleOwner()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$6 r2 = new com.uploadcare.android.widget.fragment.UploadcareChunkFragment$onCreateView$6
            r2.<init>(r5)
            androidx.lifecycle.Observer r2 = (androidx.lifecycle.Observer) r2
            r6.observe((androidx.lifecycle.LifecycleOwner) r0, r2)
            android.os.Bundle r6 = r5.getArguments()
            if (r6 == 0) goto L_0x01e9
            com.uploadcare.android.widget.viewmodels.UploadcareChunkViewModel r0 = r5.viewModel
            if (r0 != 0) goto L_0x01e3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01e3:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            r0.start(r6)
        L_0x01e9:
            com.uploadcare.android.widget.databinding.UcwFragmentChunkBinding r6 = r5.binding
            if (r6 != 0) goto L_0x01f0
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x01f0:
            android.view.View r6 = r6.getRoot()
            java.lang.String r7 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.fragment.UploadcareChunkFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public boolean onQueryTextSubmit(String str) {
        UploadcareChunkViewModel uploadcareChunkViewModel = this.viewModel;
        if (uploadcareChunkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareChunkViewModel.search(str);
        return false;
    }

    public final String getTitle() {
        UploadcareChunkViewModel uploadcareChunkViewModel = this.viewModel;
        if (uploadcareChunkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return uploadcareChunkViewModel.getTitle();
    }

    public final void changeChunk(int i) {
        UploadcareChunkViewModel uploadcareChunkViewModel = this.viewModel;
        if (uploadcareChunkViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareChunkViewModel.changeChunk(i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r0 = r0.getUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4.getAction().getAction(), (java.lang.Object) com.uploadcare.android.widget.data.Action.ACTION_SELECT_FILE) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        r4 = r3.mOnFileActionsListener;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r4 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mOnFileActionsListener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r4.onFileSelected(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r0 = r4.getAction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0067, code lost:
        r0 = r0.getPath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006d, code lost:
        r0 = r0.getChunks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r1 = r3.mOnFileActionsListener;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r1 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("mOnFileActionsListener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        r4 = r4.getTitle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (r4 == null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        r4 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        r1.onChunkSelected(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = r4.getAction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r0 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void itemSelected(com.uploadcare.android.widget.data.Thing r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.getObjectType()
            int r1 = r0.hashCode()
            java.lang.String r2 = "mOnFileActionsListener"
            switch(r1) {
                case -1268966290: goto L_0x0059;
                case -1266283874: goto L_0x0050;
                case 3143036: goto L_0x0021;
                case 92896879: goto L_0x0018;
                case 106642994: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0086
        L_0x000f:
            java.lang.String r1 = "photo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0086
            goto L_0x0029
        L_0x0018:
            java.lang.String r1 = "album"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0086
            goto L_0x0061
        L_0x0021:
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0086
        L_0x0029:
            com.uploadcare.android.widget.data.Action r0 = r4.getAction()
            if (r0 == 0) goto L_0x0086
            java.lang.String r0 = r0.getUrl()
            if (r0 == 0) goto L_0x0086
            com.uploadcare.android.widget.data.Action r4 = r4.getAction()
            java.lang.String r4 = r4.getAction()
            java.lang.String r1 = "select_file"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
            if (r4 == 0) goto L_0x0086
            com.uploadcare.android.widget.fragment.OnFileActionsListener r4 = r3.mOnFileActionsListener
            if (r4 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x004c:
            r4.onFileSelected(r0)
            goto L_0x0086
        L_0x0050:
            java.lang.String r1 = "friend"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0086
            goto L_0x0061
        L_0x0059:
            java.lang.String r1 = "folder"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0086
        L_0x0061:
            com.uploadcare.android.widget.data.Action r0 = r4.getAction()
            if (r0 == 0) goto L_0x0086
            com.uploadcare.android.widget.data.Path r0 = r0.getPath()
            if (r0 == 0) goto L_0x0086
            java.util.List r0 = r0.getChunks()
            if (r0 == 0) goto L_0x0086
            com.uploadcare.android.widget.fragment.OnFileActionsListener r1 = r3.mOnFileActionsListener
            if (r1 != 0) goto L_0x007a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x007a:
            java.lang.String r4 = r4.getTitle()
            if (r4 == 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            java.lang.String r4 = ""
        L_0x0083:
            r1.onChunkSelected(r0, r4)
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.fragment.UploadcareChunkFragment.itemSelected(com.uploadcare.android.widget.data.Thing):void");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareChunkFragment$Companion;", "", "()V", "newInstance", "Lcom/uploadcare/android/widget/fragment/UploadcareChunkFragment;", "currentRootChunk", "", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "chunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "title", "", "isRoot", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareChunkFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ UploadcareChunkFragment newInstance$default(Companion companion, int i, SocialSource socialSource, List list, String str, boolean z, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                str = null;
            }
            return companion.newInstance(i, socialSource, list, str, (i2 & 16) != 0 ? false : z);
        }

        public final UploadcareChunkFragment newInstance(int i, SocialSource socialSource, List<Chunk> list, String str, boolean z) {
            Intrinsics.checkNotNullParameter(socialSource, "socialSource");
            Intrinsics.checkNotNullParameter(list, "chunks");
            UploadcareChunkFragment uploadcareChunkFragment = new UploadcareChunkFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("currentChunk", i);
            bundle.putParcelable("socialSource", socialSource);
            bundle.putParcelableArrayList("chunks", new ArrayList(list));
            bundle.putString("title", str);
            bundle.putBoolean("isRoot", z);
            uploadcareChunkFragment.setArguments(bundle);
            return uploadcareChunkFragment;
        }
    }
}
