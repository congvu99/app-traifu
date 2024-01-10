package com.uploadcare.android.widget.dialogs;

import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import com.uploadcare.android.widget.controller.FileType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onKey", "com/uploadcare/android/widget/dialogs/SocialSourcesDialog$onCreateDialog$dialogBuilder$1$3"}, k = 3, mv = {1, 4, 0})
/* compiled from: SocialSourcesDialog.kt */
final class SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$3 implements DialogInterface.OnKeyListener {
    final /* synthetic */ FileType $fileType$inlined;
    final /* synthetic */ List $sources$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ SocialSourcesDialog this$0;

    SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$3(SocialSourcesDialog socialSourcesDialog, String str, FileType fileType, List list) {
        this.this$0 = socialSourcesDialog;
        this.$title$inlined = str;
        this.$fileType$inlined = fileType;
        this.$sources$inlined = list;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullExpressionValue(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        dialogInterface.dismiss();
        SocialSourcesDialog.access$getSocialSourcesListener$p(this.this$0).onSelectSourceCanceled();
        return true;
    }
}
