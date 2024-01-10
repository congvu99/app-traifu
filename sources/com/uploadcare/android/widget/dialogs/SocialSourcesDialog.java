package com.uploadcare.android.widget.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.SocialSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/uploadcare/android/widget/dialogs/SocialSourcesDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "socialSourcesListener", "Lcom/uploadcare/android/widget/dialogs/SocialSourcesListener;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialSourcesDialog.kt */
public final class SocialSourcesDialog extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DIALOG_FILE_TYPE = "extras.dialog_file_type";
    private static final String DIALOG_SOUCES = "extras.dialog_sources";
    private static final String DIALOG_TITLE = "extras.dialog_title";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public SocialSourcesListener socialSourcesListener;

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

    public static final /* synthetic */ SocialSourcesListener access$getSocialSourcesListener$p(SocialSourcesDialog socialSourcesDialog) {
        SocialSourcesListener socialSourcesListener2 = socialSourcesDialog.socialSourcesListener;
        if (socialSourcesListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialSourcesListener");
        }
        return socialSourcesListener2;
    }

    public void onAttach(Context context) {
        SocialSourcesListener socialSourcesListener2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            if (getParentFragment() != null) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    socialSourcesListener2 = (SocialSourcesListener) parentFragment;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.uploadcare.android.widget.dialogs.SocialSourcesListener");
                }
            } else {
                socialSourcesListener2 = (SocialSourcesListener) context;
            }
            this.socialSourcesListener = socialSourcesListener2;
        } catch (ClassCastException unused) {
            throw new ClassCastException("Parent must implement SocialSourcesListener");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r1 != null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Dialog onCreateDialog(android.os.Bundle r9) {
        /*
            r8 = this;
            android.os.Bundle r9 = r8.getArguments()
            r0 = 0
            if (r9 == 0) goto L_0x000e
            java.lang.String r1 = "extras.dialog_title"
            java.lang.String r9 = r9.getString(r1)
            goto L_0x000f
        L_0x000e:
            r9 = r0
        L_0x000f:
            android.os.Bundle r1 = r8.getArguments()
            if (r1 == 0) goto L_0x0029
            java.lang.String r2 = "extras.dialog_file_type"
            java.lang.String r1 = r1.getString(r2)
            if (r1 == 0) goto L_0x0029
            java.lang.String r2 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.uploadcare.android.widget.controller.FileType r1 = com.uploadcare.android.widget.controller.FileType.valueOf(r1)
            if (r1 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            com.uploadcare.android.widget.controller.FileType r1 = com.uploadcare.android.widget.controller.FileType.any
        L_0x002b:
            android.os.Bundle r2 = r8.getArguments()
            if (r2 == 0) goto L_0x003c
            java.lang.String r3 = "extras.dialog_sources"
            java.util.ArrayList r2 = r2.getParcelableArrayList(r3)
            if (r2 == 0) goto L_0x003c
            java.util.List r2 = (java.util.List) r2
            goto L_0x0040
        L_0x003c:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0040:
            androidx.appcompat.app.AlertDialog$Builder r3 = new androidx.appcompat.app.AlertDialog$Builder
            android.content.Context r4 = r8.requireContext()
            int r5 = com.uploadcare.android.widget.R.style.UploadcareWidget_AlertDialogStyle
            r3.<init>(r4, r5)
            r4 = 1
            r3.setCancelable(r4)
            r4 = r9
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setTitle((java.lang.CharSequence) r4)
            int r4 = com.uploadcare.android.widget.R.string.ucw_cancel
            com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$1 r5 = new com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$1
            r5.<init>(r8, r9, r1, r2)
            android.content.DialogInterface$OnClickListener r5 = (android.content.DialogInterface.OnClickListener) r5
            r3.setNegativeButton((int) r4, (android.content.DialogInterface.OnClickListener) r5)
            com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$2 r4 = new com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$2
            r4.<init>(r8, r9, r1, r2)
            android.content.DialogInterface$OnCancelListener r4 = (android.content.DialogInterface.OnCancelListener) r4
            r3.setOnCancelListener(r4)
            com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$3 r4 = new com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$3
            r4.<init>(r8, r9, r1, r2)
            android.content.DialogInterface$OnKeyListener r4 = (android.content.DialogInterface.OnKeyListener) r4
            r3.setOnKeyListener(r4)
            com.uploadcare.android.widget.adapter.SocialNetworksAdapter r4 = new com.uploadcare.android.widget.adapter.SocialNetworksAdapter
            android.content.Context r5 = r3.getContext()
            java.lang.String r6 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)
            com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$4 r7 = new com.uploadcare.android.widget.dialogs.SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$4
            r7.<init>(r8, r9, r1, r2)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r4.<init>(r5, r1, r6, r7)
            android.widget.ListAdapter r4 = (android.widget.ListAdapter) r4
            r3.setAdapter(r4, r0)
            androidx.appcompat.app.AlertDialog r9 = r3.create()
            java.lang.String r0 = "dialogBuilder.create()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            android.app.Dialog r9 = (android.app.Dialog) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.dialogs.SocialSourcesDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/uploadcare/android/widget/dialogs/SocialSourcesDialog$Companion;", "", "()V", "DIALOG_FILE_TYPE", "", "DIALOG_SOUCES", "DIALOG_TITLE", "newInstance", "Lcom/uploadcare/android/widget/dialogs/SocialSourcesDialog;", "sources", "", "Lcom/uploadcare/android/widget/data/SocialSource;", "title", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SocialSourcesDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SocialSourcesDialog newInstance(List<SocialSource> list, String str, FileType fileType) {
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            Bundle bundle = new Bundle();
            bundle.putString(SocialSourcesDialog.DIALOG_TITLE, str);
            bundle.putString(SocialSourcesDialog.DIALOG_FILE_TYPE, fileType.name());
            bundle.putParcelableArrayList(SocialSourcesDialog.DIALOG_SOUCES, new ArrayList(list));
            SocialSourcesDialog socialSourcesDialog = new SocialSourcesDialog();
            socialSourcesDialog.setArguments(bundle);
            return socialSourcesDialog;
        }
    }
}
