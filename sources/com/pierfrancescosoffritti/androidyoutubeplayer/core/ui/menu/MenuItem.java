package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.menu;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/MenuItem;", "", "text", "", "icon", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)V", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Landroid/view/View$OnClickListener;)Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/menu/MenuItem;", "equals", "", "other", "hashCode", "toString", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: MenuItem.kt */
public final class MenuItem {
    private final Integer icon;
    private final View.OnClickListener onClickListener;
    private final String text;

    public MenuItem(String str, View.OnClickListener onClickListener2) {
        this(str, (Integer) null, onClickListener2, 2, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MenuItem copy$default(MenuItem menuItem, String str, Integer num, View.OnClickListener onClickListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = menuItem.text;
        }
        if ((i & 2) != 0) {
            num = menuItem.icon;
        }
        if ((i & 4) != 0) {
            onClickListener2 = menuItem.onClickListener;
        }
        return menuItem.copy(str, num, onClickListener2);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.icon;
    }

    public final View.OnClickListener component3() {
        return this.onClickListener;
    }

    public final MenuItem copy(String str, Integer num, View.OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        return new MenuItem(str, num, onClickListener2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MenuItem)) {
            return false;
        }
        MenuItem menuItem = (MenuItem) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) menuItem.text) && Intrinsics.areEqual((Object) this.icon, (Object) menuItem.icon) && Intrinsics.areEqual((Object) this.onClickListener, (Object) menuItem.onClickListener);
    }

    public int hashCode() {
        String str = this.text;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.icon;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener2 = this.onClickListener;
        if (onClickListener2 != null) {
            i = onClickListener2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MenuItem(text=" + this.text + ", icon=" + this.icon + ", onClickListener=" + this.onClickListener + ")";
    }

    public MenuItem(String str, Integer num, View.OnClickListener onClickListener2) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(onClickListener2, "onClickListener");
        this.text = str;
        this.icon = num;
        this.onClickListener = onClickListener2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MenuItem(String str, Integer num, View.OnClickListener onClickListener2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, onClickListener2);
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final String getText() {
        return this.text;
    }
}
