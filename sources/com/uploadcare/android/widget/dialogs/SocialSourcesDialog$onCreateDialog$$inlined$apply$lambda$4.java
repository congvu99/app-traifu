package com.uploadcare.android.widget.dialogs;

import android.app.Dialog;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.SocialSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "invoke", "com/uploadcare/android/widget/dialogs/SocialSourcesDialog$onCreateDialog$dialogBuilder$1$adapter$1"}, k = 3, mv = {1, 4, 0})
/* compiled from: SocialSourcesDialog.kt */
final class SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$4 extends Lambda implements Function1<SocialSource, Unit> {
    final /* synthetic */ FileType $fileType$inlined;
    final /* synthetic */ List $sources$inlined;
    final /* synthetic */ String $title$inlined;
    final /* synthetic */ SocialSourcesDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SocialSourcesDialog$onCreateDialog$$inlined$apply$lambda$4(SocialSourcesDialog socialSourcesDialog, String str, FileType fileType, List list) {
        super(1);
        this.this$0 = socialSourcesDialog;
        this.$title$inlined = str;
        this.$fileType$inlined = fileType;
        this.$sources$inlined = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SocialSource) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SocialSource socialSource) {
        Intrinsics.checkNotNullParameter(socialSource, "socialSource");
        Dialog dialog = this.this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        SocialSourcesDialog.access$getSocialSourcesListener$p(this.this$0).onSocialSourceSelected(socialSource);
    }
}
