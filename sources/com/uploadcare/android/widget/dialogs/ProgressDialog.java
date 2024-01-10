package com.uploadcare.android.widget.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.databinding.UcwDialogProgressHorizontalBinding;
import com.uploadcare.android.widget.viewmodels.ProgressData;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/uploadcare/android/widget/dialogs/ProgressDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "cancelUploadListener", "Lcom/uploadcare/android/widget/dialogs/CancelUploadListener;", "showProgress", "", "uploadProgress", "Landroidx/lifecycle/MutableLiveData;", "", "getUploadProgress", "()Landroidx/lifecycle/MutableLiveData;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "updateProgress", "progress", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ProgressDialog.kt */
public final class ProgressDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DIALOG_CANCELABLE = "extras.dialog_cancelable";
    private static final String DIALOG_MESSAGE = "extras.dialog_message";
    private static final String DIALOG_SHOW_PROGRESS = "extras.dialog_show_progress";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public CancelUploadListener cancelUploadListener;
    private boolean showProgress;
    private final MutableLiveData<Integer> uploadProgress;

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

    public ProgressDialog() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(0);
        Unit unit = Unit.INSTANCE;
        this.uploadProgress = mutableLiveData;
    }

    public static final /* synthetic */ CancelUploadListener access$getCancelUploadListener$p(ProgressDialog progressDialog) {
        CancelUploadListener cancelUploadListener2 = progressDialog.cancelUploadListener;
        if (cancelUploadListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelUploadListener");
        }
        return cancelUploadListener2;
    }

    public final MutableLiveData<Integer> getUploadProgress() {
        return this.uploadProgress;
    }

    public void onAttach(Context context) {
        CancelUploadListener cancelUploadListener2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            if (getParentFragment() != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    cancelUploadListener2 = (CancelUploadListener) parentFragment;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.uploadcare.android.widget.dialogs.CancelUploadListener");
                }
            } else {
                cancelUploadListener2 = (CancelUploadListener) context;
            }
            this.cancelUploadListener = cancelUploadListener2;
        } catch (ClassCastException unused) {
            throw new ClassCastException("Parent must implement CancelUploadListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        setCancelable(false);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(DIALOG_MESSAGE) : null;
        Bundle arguments2 = getArguments();
        this.showProgress = arguments2 != null ? arguments2.getBoolean(DIALOG_SHOW_PROGRESS) : false;
        Bundle arguments3 = getArguments();
        boolean z = arguments3 != null ? arguments3.getBoolean(DIALOG_CANCELABLE) : false;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext(), R.style.UploadcareWidget_AlertDialogStyle);
        builder.setTitle((CharSequence) string);
        builder.setCancelable(false);
        if (this.showProgress) {
            UcwDialogProgressHorizontalBinding inflate = UcwDialogProgressHorizontalBinding.inflate(LayoutInflater.from(builder.getContext()), (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "UcwDialogProgressHorizon…om(context), null, false)");
            inflate.setLifecycleOwner(getActivity());
            inflate.setDialog(this);
            builder.setView(inflate.getRoot());
        } else {
            builder.setView(R.layout.ucw_dialog_progress);
        }
        if (z) {
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new ProgressDialog$onCreateDialog$$inlined$apply$lambda$1(this, string, z));
        }
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "dialogBuilder.create()");
        return create;
    }

    public final void updateProgress(int i) {
        if (this.showProgress) {
            this.uploadProgress.setValue(Integer.valueOf(i));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/uploadcare/android/widget/dialogs/ProgressDialog$Companion;", "", "()V", "DIALOG_CANCELABLE", "", "DIALOG_MESSAGE", "DIALOG_SHOW_PROGRESS", "newInstance", "Lcom/uploadcare/android/widget/dialogs/ProgressDialog;", "progressData", "Lcom/uploadcare/android/widget/viewmodels/ProgressData;", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ProgressDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProgressDialog newInstance(ProgressData progressData) {
            Intrinsics.checkNotNullParameter(progressData, "progressData");
            Bundle bundle = new Bundle();
            bundle.putString(ProgressDialog.DIALOG_MESSAGE, progressData.getMessage());
            bundle.putBoolean(ProgressDialog.DIALOG_SHOW_PROGRESS, progressData.getShowProgress());
            bundle.putBoolean(ProgressDialog.DIALOG_CANCELABLE, progressData.getCancelable());
            ProgressDialog progressDialog = new ProgressDialog();
            progressDialog.setArguments(bundle);
            return progressDialog;
        }
    }
}
