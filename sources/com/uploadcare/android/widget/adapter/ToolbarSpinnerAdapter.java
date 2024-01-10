package com.uploadcare.android.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.databinding.DataBindingUtil;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.data.Chunk;
import com.uploadcare.android.widget.databinding.UcwSpinnerRowBinding;
import com.uploadcare.android.widget.databinding.UcwToolbarSpinnerItemBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\rH\u0002J\"\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001cR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/uploadcare/android/widget/adapter/ToolbarSpinnerAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/uploadcare/android/widget/data/Chunk;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "chunks", "", "inflater", "Landroid/view/LayoutInflater;", "clear", "", "getCount", "", "getDropDownView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getItem", "getItemId", "", "getTitle", "", "getView", "updateItems", "data", "", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ToolbarSpinnerAdapter.kt */
public final class ToolbarSpinnerAdapter extends ArrayAdapter<Chunk> {
    private final List<Chunk> chunks = new ArrayList();
    private final LayoutInflater inflater;

    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToolbarSpinnerAdapter(Context context) {
        super(context, R.layout.ucw_spinner_row);
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.inflater = (LayoutInflater) systemService;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public void clear() {
        super.clear();
        this.chunks.clear();
    }

    public final void updateItems(List<Chunk> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        this.chunks.clear();
        this.chunks.addAll(list);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.chunks.size();
    }

    public Chunk getItem(int i) {
        return this.chunks.get(i);
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        UcwSpinnerRowBinding ucwSpinnerRowBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null || (ucwSpinnerRowBinding = (UcwSpinnerRowBinding) DataBindingUtil.getBinding(view)) == null) {
            ucwSpinnerRowBinding = UcwSpinnerRowBinding.inflate(this.inflater, viewGroup, false);
        }
        Intrinsics.checkNotNullExpressionValue(ucwSpinnerRowBinding, "convertView?.let {\n     …(inflater, parent, false)");
        ucwSpinnerRowBinding.setText(getTitle(i));
        ucwSpinnerRowBinding.executePendingBindings();
        View root = ucwSpinnerRowBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        UcwToolbarSpinnerItemBinding ucwToolbarSpinnerItemBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null || (ucwToolbarSpinnerItemBinding = (UcwToolbarSpinnerItemBinding) DataBindingUtil.getBinding(view)) == null) {
            ucwToolbarSpinnerItemBinding = UcwToolbarSpinnerItemBinding.inflate(this.inflater, viewGroup, false);
        }
        Intrinsics.checkNotNullExpressionValue(ucwToolbarSpinnerItemBinding, "convertView?.let {\n     …(inflater, parent, false)");
        ucwToolbarSpinnerItemBinding.setText(getTitle(i));
        ucwToolbarSpinnerItemBinding.executePendingBindings();
        View root = ucwToolbarSpinnerItemBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final String getTitle(int i) {
        return this.chunks.get(i).getTitle();
    }
}
