package io.intercom.android.sdk.utilities.extensions;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"clearDecorations", "", "Landroidx/recyclerview/widget/RecyclerView;", "hide", "Landroid/view/View;", "show", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final void hide(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void show(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void clearDecorations(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        if (recyclerView.getItemDecorationCount() > 0) {
            int itemDecorationCount = recyclerView.getItemDecorationCount();
            while (true) {
                itemDecorationCount--;
                if (-1 < itemDecorationCount) {
                    recyclerView.removeItemDecorationAt(itemDecorationCount);
                } else {
                    return;
                }
            }
        }
    }
}
