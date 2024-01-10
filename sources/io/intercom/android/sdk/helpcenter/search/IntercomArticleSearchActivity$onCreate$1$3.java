package io.intercom.android.sdk.helpcenter.search;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import io.intercom.android.sdk.databinding.IntercomActivityArticleSearchBinding;
import io.intercom.android.sdk.utilities.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"io/intercom/android/sdk/helpcenter/search/IntercomArticleSearchActivity$onCreate$1$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "text", "before", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomArticleSearchActivity.kt */
public final class IntercomArticleSearchActivity$onCreate$1$3 implements TextWatcher {
    final /* synthetic */ IntercomActivityArticleSearchBinding $this_with;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    IntercomArticleSearchActivity$onCreate$1$3(IntercomActivityArticleSearchBinding intercomActivityArticleSearchBinding) {
        this.$this_with = intercomActivityArticleSearchBinding;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).length() == 0) {
            ImageButton imageButton = this.$this_with.clearSearch;
            Intrinsics.checkNotNullExpressionValue(imageButton, "clearSearch");
            ViewExtensionsKt.hide(imageButton);
            return;
        }
        ImageButton imageButton2 = this.$this_with.clearSearch;
        Intrinsics.checkNotNullExpressionValue(imageButton2, "clearSearch");
        ViewExtensionsKt.show(imageButton2);
    }
}
