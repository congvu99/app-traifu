package com.afollestad.materialdialogs.simplelist;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDAdapter;

public class MaterialSimpleListAdapter extends ArrayAdapter<MaterialSimpleListItem> implements MDAdapter {
    private MaterialDialog dialog;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public MaterialSimpleListAdapter(Context context) {
        super(context, R.layout.md_simplelist_item, 16908310);
    }

    public void setDialog(MaterialDialog materialDialog) {
        this.dialog = materialDialog;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.dialog != null) {
            MaterialSimpleListItem materialSimpleListItem = (MaterialSimpleListItem) getItem(i);
            ImageView imageView = (ImageView) view2.findViewById(16908294);
            if (materialSimpleListItem.getIcon() != null) {
                imageView.setImageDrawable(materialSimpleListItem.getIcon());
                imageView.setPadding(materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding(), materialSimpleListItem.getIconPadding());
                imageView.getBackground().setColorFilter(materialSimpleListItem.getBackgroundColor(), PorterDuff.Mode.SRC_ATOP);
            } else {
                imageView.setVisibility(8);
            }
            TextView textView = (TextView) view2.findViewById(16908310);
            textView.setTextColor(this.dialog.getBuilder().getItemColor());
            textView.setText(materialSimpleListItem.getContent());
            MaterialDialog materialDialog = this.dialog;
            materialDialog.setTypeface(textView, materialDialog.getBuilder().getRegularFont());
        }
        return view2;
    }
}
