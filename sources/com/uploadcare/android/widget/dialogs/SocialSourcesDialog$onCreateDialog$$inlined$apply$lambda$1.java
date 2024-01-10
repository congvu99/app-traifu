package com.uploadcare.android.widget.dialogs;

import android.content.DialogInterface;
import com.uploadcare.android.widget.controller.FileType;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/uploadcare/android/widget/dialogs/SocialSourcesDialog$onCreateDialog$dialogBuilder$1$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: SocialSourcesDialog.kt */
final class SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$1 implements DialogInterface.OnClickListener {
    final /* synthetic */ FileType $fileType$inlined;
    final /* synthetic */ List $sources$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ SocialSourcesDialog this$0;

    SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$1(SocialSourcesDialog socialSourcesDialog, String str, FileType fileType, List list) {
        this.this$0 = socialSourcesDialog;
        this.$title$inlined = str;
        this.$fileType$inlined = fileType;
        this.$sources$inlined = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        SocialSourcesDialog.access$getSocialSourcesListener$p(this.this$0).onSelectSourceCanceled();
    }
}
