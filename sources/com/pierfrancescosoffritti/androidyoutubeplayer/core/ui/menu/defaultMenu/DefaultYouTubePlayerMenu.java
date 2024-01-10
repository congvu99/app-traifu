package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.defaultMenu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.MenuItem;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu.YouTubePlayerMenu;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/defaultMenu/DefaultYouTubePlayerMenu;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/YouTubePlayerMenu;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemCount", "", "getItemCount", "()I", "menuItems", "Ljava/util/ArrayList;", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/MenuItem;", "popupWindow", "Landroid/widget/PopupWindow;", "addItem", "menuItem", "createPopupWindow", "dismiss", "", "removeItem", "itemIndex", "show", "anchorView", "Landroid/view/View;", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: DefaultYouTubePlayerMenu.kt */
public final class DefaultYouTubePlayerMenu implements YouTubePlayerMenu {
    private final Context context;
    private final ArrayList<MenuItem> menuItems = new ArrayList<>();
    private PopupWindow popupWindow;

    public DefaultYouTubePlayerMenu(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public int getItemCount() {
        return this.menuItems.size();
    }

    public void show(View view) {
        Intrinsics.checkParameterIsNotNull(view, "anchorView");
        PopupWindow createPopupWindow = createPopupWindow();
        this.popupWindow = createPopupWindow;
        if (createPopupWindow != null) {
            createPopupWindow.showAsDropDown(view, (-this.context.getResources().getDimensionPixelSize(R.dimen.ayp_8dp)) * 12, (-this.context.getResources().getDimensionPixelSize(R.dimen.ayp_8dp)) * 12);
        }
        if (this.menuItems.size() == 0) {
            Log.e(YouTubePlayerMenu.class.getName(), "The menu is empty");
        }
    }

    public void dismiss() {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public YouTubePlayerMenu addItem(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        this.menuItems.add(menuItem);
        return this;
    }

    public YouTubePlayerMenu removeItem(int i) {
        this.menuItems.remove(i);
        return this;
    }

    public YouTubePlayerMenu removeItem(MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        this.menuItems.remove(menuItem);
        return this;
    }

    private final PopupWindow createPopupWindow() {
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.ayp_player_menu, (ViewGroup) null);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "recyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
            recyclerView.setAdapter(new MenuAdapter(this.context, this.menuItems));
            recyclerView.setHasFixedSize(true);
            PopupWindow popupWindow2 = new PopupWindow(inflate, -2, -2);
            popupWindow2.setContentView(inflate);
            popupWindow2.setFocusable(true);
            popupWindow2.setWidth(-2);
            popupWindow2.setHeight(-2);
            return popupWindow2;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
