package com.uploadcare.android.widget.dialogs;

import android.content.DialogInterface;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick", "com/uploadcare/android/widget/dialogs/ProgressDialog$onCreateDialog$dialogBuilder$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: ProgressDialog.kt */
final class ProgressDialog$onCreateDialog$$inlined$apply$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ boolean $cancelable$inlined;
    final /* synthetic */ String $message$inlined;
    final /* synthetic */ ProgressDialog this$0;

    ProgressDialog$onCreateDialog$$inlined$apply$lambda$1(ProgressDialog progressDialog, String str, boolean z) {
        this.this$0 = progressDialog;
        this.$message$inlined = str;
        this.$cancelable$inlined = z;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ProgressDialog.access$getCancelUploadListener$p(this.this$0).onCancelUpload();
    }
}
