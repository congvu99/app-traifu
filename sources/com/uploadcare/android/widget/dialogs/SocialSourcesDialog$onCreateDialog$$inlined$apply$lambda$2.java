package com.uploadcare.android.widget.dialogs;

import android.content.DialogInterface;
import com.uploadcare.android.widget.controller.FileType;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel", "com/uploadcare/android/widget/dialogs/SocialSourcesDialog$onCreateDialog$dialogBuilder$1$2"}, k = 3, mv = {1, 4, 0})
/* compiled from: SocialSourcesDialog.kt */
final class SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$2 implements DialogInterface.OnCancelListener {
    final /* synthetic */ FileType $fileType$inlined;
    final /* synthetic */ List $sources$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ SocialSourcesDialog this$0;

    SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$2(SocialSourcesDialog socialSourcesDialog, String str, FileType fileType, List list) {
        this.this$0 = socialSourcesDialog;
        this.$title$inlined = str;
        this.$fileType$inlined = fileType;
        this.$sources$inlined = list;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SocialSourcesDialog.access$getSocialSourcesListener$p(this.this$0).onSelectSourceCanceled();
    }
}
