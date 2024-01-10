package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.defaultMenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.MenuItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/defaultMenu/MenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/defaultMenu/MenuAdapter$ViewHolder;", "context", "Landroid/content/Context;", "menuItems", "", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/MenuItem;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: MenuAdapter.kt */
public final class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final List<MenuItem> menuItems;

    public MenuAdapter(Context context2, List<MenuItem> list) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(list, "menuItems");
        this.context = context2;
        this.menuItems = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ayp_menu_item, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, ViewHierarchyConstants.VIEW_KEY);
        return new ViewHolder(this, inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        viewHolder.getRoot().setOnClickListener(this.menuItems.get(i).getOnClickListener());
        viewHolder.getTextView().setText(this.menuItems.get(i).getText());
        Integer icon = this.menuItems.get(i).getIcon();
        if (icon != null) {
            viewHolder.getTextView().setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this.context, icon.intValue()), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public int getItemCount() {
        return this.menuItems.size();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/defaultMenu/MenuAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "root", "Landroid/view/View;", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/defaultMenu/MenuAdapter;Landroid/view/View;)V", "getRoot", "()Landroid/view/View;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "core_release"}, k = 1, mv = {1, 1, 15})
    /* compiled from: MenuAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final View root;
        private final TextView textView;
        final /* synthetic */ MenuAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(MenuAdapter menuAdapter, View view) {
            super(view);
            Intrinsics.checkParameterIsNotNull(view, "root");
            this.this$0 = menuAdapter;
            this.root = view;
            View findViewById = view.findViewById(R.id.text);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.text)");
            this.textView = (TextView) findViewById;
        }

        public final View getRoot() {
            return this.root;
        }

        public final TextView getTextView() {
            return this.textView;
        }
    }
}
