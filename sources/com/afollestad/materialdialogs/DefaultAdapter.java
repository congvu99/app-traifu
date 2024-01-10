package com.afollestad.materialdialogs;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.facebook.internal.security.CertificateUtil;

class DefaultAdapter extends BaseAdapter {
    private final MaterialDialog dialog;
    private final GravityEnum itemGravity;
    private final int layout;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public DefaultAdapter(MaterialDialog materialDialog, int i) {
        this.dialog = materialDialog;
        this.layout = i;
        this.itemGravity = materialDialog.mBuilder.itemsGravity;
    }

    public int getCount() {
        if (this.dialog.mBuilder.items != null) {
            return this.dialog.mBuilder.items.length;
        }
        return 0;
    }

    public Object getItem(int i) {
        return this.dialog.mBuilder.items[i];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.dialog.getContext()).inflate(this.layout, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.title);
        int i2 = AnonymousClass1.$SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType[this.dialog.listType.ordinal()];
        if (i2 == 1) {
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.control);
            boolean z = this.dialog.mBuilder.selectedIndex == i;
            MDTintHelper.setTint(radioButton, this.dialog.mBuilder.widgetColor);
            radioButton.setChecked(z);
        } else if (i2 == 2) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.control);
            boolean contains = this.dialog.selectedIndicesList.contains(Integer.valueOf(i));
            MDTintHelper.setTint(checkBox, this.dialog.mBuilder.widgetColor);
            checkBox.setChecked(contains);
        }
        textView.setText(this.dialog.mBuilder.items[i]);
        textView.setTextColor(this.dialog.mBuilder.itemColor);
        MaterialDialog materialDialog = this.dialog;
        materialDialog.setTypeface(textView, materialDialog.mBuilder.regularFont);
        view.setTag(i + CertificateUtil.DELIMITER + this.dialog.mBuilder.items[i]);
        ViewGroup viewGroup2 = (ViewGroup) view;
        setupGravity(viewGroup2);
        if (this.dialog.mBuilder.itemIds != null) {
            if (i < this.dialog.mBuilder.itemIds.length) {
                view.setId(this.dialog.mBuilder.itemIds[i]);
            } else {
                view.setId(-1);
            }
        }
        if (Build.VERSION.SDK_INT >= 21 && viewGroup2.getChildCount() == 2) {
            if (viewGroup2.getChildAt(0) instanceof CompoundButton) {
                viewGroup2.getChildAt(0).setBackground((Drawable) null);
            } else if (viewGroup2.getChildAt(1) instanceof CompoundButton) {
                viewGroup2.getChildAt(1).setBackground((Drawable) null);
            }
        }
        return view;
    }

    /* renamed from: com.afollestad.materialdialogs.DefaultAdapter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.afollestad.materialdialogs.MaterialDialog$ListType[] r0 = com.afollestad.materialdialogs.MaterialDialog.ListType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType = r0
                com.afollestad.materialdialogs.MaterialDialog$ListType r1 = com.afollestad.materialdialogs.MaterialDialog.ListType.SINGLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.afollestad.materialdialogs.MaterialDialog$ListType r1 = com.afollestad.materialdialogs.MaterialDialog.ListType.MULTI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.DefaultAdapter.AnonymousClass1.<clinit>():void");
        }
    }

    private void setupGravity(ViewGroup viewGroup) {
        ((LinearLayout) viewGroup).setGravity(this.itemGravity.getGravityInt() | 16);
        if (viewGroup.getChildCount() != 2) {
            return;
        }
        if (this.itemGravity == GravityEnum.END && !isRTL() && (viewGroup.getChildAt(0) instanceof CompoundButton)) {
            CompoundButton compoundButton = (CompoundButton) viewGroup.getChildAt(0);
            viewGroup.removeView(compoundButton);
            TextView textView = (TextView) viewGroup.getChildAt(0);
            viewGroup.removeView(textView);
            textView.setPadding(textView.getPaddingRight(), textView.getPaddingTop(), textView.getPaddingLeft(), textView.getPaddingBottom());
            viewGroup.addView(textView);
            viewGroup.addView(compoundButton);
        } else if (this.itemGravity == GravityEnum.START && isRTL() && (viewGroup.getChildAt(1) instanceof CompoundButton)) {
            CompoundButton compoundButton2 = (CompoundButton) viewGroup.getChildAt(1);
            viewGroup.removeView(compoundButton2);
            TextView textView2 = (TextView) viewGroup.getChildAt(0);
            viewGroup.removeView(textView2);
            textView2.setPadding(textView2.getPaddingRight(), textView2.getPaddingTop(), textView2.getPaddingRight(), textView2.getPaddingBottom());
            viewGroup.addView(compoundButton2);
            viewGroup.addView(textView2);
        }
    }

    private boolean isRTL() {
        if (Build.VERSION.SDK_INT >= 17 && this.dialog.getBuilder().getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
