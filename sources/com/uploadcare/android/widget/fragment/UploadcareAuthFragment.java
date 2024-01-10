package com.uploadcare.android.widget.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.uploadcare.android.widget.databinding.UcwFragmentAuthBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareAuthFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/uploadcare/android/widget/databinding/UcwFragmentAuthBinding;", "mOnAuthListener", "Lcom/uploadcare/android/widget/fragment/OnAuthListener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareAuthFragment.kt */
public final class UploadcareAuthFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public UcwFragmentAuthBinding binding;
    /* access modifiers changed from: private */
    public OnAuthListener mOnAuthListener;

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

    public static final /* synthetic */ UcwFragmentAuthBinding access$getBinding$p(UploadcareAuthFragment uploadcareAuthFragment) {
        UcwFragmentAuthBinding ucwFragmentAuthBinding = uploadcareAuthFragment.binding;
        if (ucwFragmentAuthBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return ucwFragmentAuthBinding;
    }

    public static final /* synthetic */ OnAuthListener access$getMOnAuthListener$p(UploadcareAuthFragment uploadcareAuthFragment) {
        OnAuthListener onAuthListener = uploadcareAuthFragment.mOnAuthListener;
        if (onAuthListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOnAuthListener");
        }
        return onAuthListener;
    }

    public void onAttach(Context context) {
        OnAuthListener onAuthListener;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            if (getParentFragment() != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    onAuthListener = (OnAuthListener) parentFragment;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.uploadcare.android.widget.fragment.OnAuthListener");
                }
            } else {
                onAuthListener = (OnAuthListener) context;
            }
            this.mOnAuthListener = onAuthListener;
        } catch (ClassCastException unused) {
            throw new ClassCastException("Parent must implement OnAuthListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String string;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UcwFragmentAuthBinding inflate = UcwFragmentAuthBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UcwFragmentAuthBinding.i…flater, container, false)");
        this.binding = inflate;
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager instance = CookieManager.getInstance();
        UcwFragmentAuthBinding ucwFragmentAuthBinding = this.binding;
        if (ucwFragmentAuthBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        instance.setAcceptThirdPartyCookies(ucwFragmentAuthBinding.ucwWebview, true);
        UcwFragmentAuthBinding ucwFragmentAuthBinding2 = this.binding;
        if (ucwFragmentAuthBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        WebView webView = ucwFragmentAuthBinding2.ucwWebview;
        Intrinsics.checkNotNullExpressionValue(webView, "binding.ucwWebview");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUserAgentString("Chrome/56.0.0.0 Mobile");
        UcwFragmentAuthBinding ucwFragmentAuthBinding3 = this.binding;
        if (ucwFragmentAuthBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        WebView webView2 = ucwFragmentAuthBinding3.ucwWebview;
        Intrinsics.checkNotNullExpressionValue(webView2, "binding.ucwWebview");
        webView2.setWebViewClient(new UploadcareWebViewClient(new UploadcareAuthFragment$onCreateView$2(this), new UploadcareAuthFragment$onCreateView$3(this)));
        Bundle arguments = getArguments();
        if (!(arguments == null || (string = arguments.getString("loginLink")) == null)) {
            UcwFragmentAuthBinding ucwFragmentAuthBinding4 = this.binding;
            if (ucwFragmentAuthBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ucwFragmentAuthBinding4.ucwWebview.loadUrl(string);
        }
        UcwFragmentAuthBinding ucwFragmentAuthBinding5 = this.binding;
        if (ucwFragmentAuthBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = ucwFragmentAuthBinding5.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareAuthFragment$Companion;", "", "()V", "newInstance", "Lcom/uploadcare/android/widget/fragment/UploadcareAuthFragment;", "loginLink", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareAuthFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UploadcareAuthFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "loginLink");
            UploadcareAuthFragment uploadcareAuthFragment = new UploadcareAuthFragment();
            Bundle bundle = new Bundle();
            bundle.putString("loginLink", str);
            uploadcareAuthFragment.setArguments(bundle);
            return uploadcareAuthFragment;
        }
    }
}
