package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListAdapter;
import com.afollestad.materialdialogs.MaterialDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertDialogWrapper {

    public static class Builder {
        private final MaterialDialog.Builder builder;
        /* access modifiers changed from: private */
        public DialogInterface.OnClickListener negativeDialogListener;
        /* access modifiers changed from: private */
        public DialogInterface.OnClickListener neutralDialogListener;
        /* access modifiers changed from: private */
        public DialogInterface.OnClickListener onClickListener;
        /* access modifiers changed from: private */
        public DialogInterface.OnClickListener positiveDialogListener;

        public Builder(Context context) {
            this.builder = new MaterialDialog.Builder(context);
        }

        public Builder autoDismiss(boolean z) {
            this.builder.autoDismiss(z);
            return this;
        }

        public Builder setMessage(int i) {
            this.builder.content(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.builder.content(charSequence);
            return this;
        }

        public Builder setTitle(int i) {
            this.builder.title(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.builder.title(charSequence);
            return this;
        }

        public Builder setIcon(int i) {
            this.builder.iconRes(i);
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.builder.icon(drawable);
            return this;
        }

        public Builder setIconAttribute(int i) {
            this.builder.iconAttr(i);
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener2) {
            this.builder.negativeText(i);
            this.negativeDialogListener = onClickListener2;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener2) {
            this.builder.negativeText(charSequence);
            this.negativeDialogListener = onClickListener2;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener2) {
            this.builder.positiveText(i);
            this.positiveDialogListener = onClickListener2;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener2) {
            this.builder.positiveText(charSequence);
            this.positiveDialogListener = onClickListener2;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener2) {
            this.builder.neutralText(i);
            this.neutralDialogListener = onClickListener2;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener2) {
            this.builder.neutralText(charSequence);
            this.neutralDialogListener = onClickListener2;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.builder.cancelable(z);
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener2) {
            this.builder.items(i);
            this.onClickListener = onClickListener2;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener2) {
            this.builder.items(charSequenceArr);
            this.onClickListener = onClickListener2;
            return this;
        }

        @Deprecated
        public Builder setAdapter(ListAdapter listAdapter) {
            return setAdapter(listAdapter, (DialogInterface.OnClickListener) null);
        }

        public Builder setAdapter(ListAdapter listAdapter, final DialogInterface.OnClickListener onClickListener2) {
            this.builder.adapter = listAdapter;
            this.builder.listCallbackCustom = new MaterialDialog.ListCallback() {
                public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                    onClickListener2.onClick(materialDialog, i);
                }
            };
            return this;
        }

        public Dialog create() {
            addButtonsCallback();
            addListCallbacks();
            return this.builder.build();
        }

        public Dialog show() {
            Dialog create = create();
            create.show();
            return create;
        }

        private void addListCallbacks() {
            if (this.onClickListener != null) {
                this.builder.itemsCallback(new MaterialDialog.ListCallback() {
                    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        Builder.this.onClickListener.onClick(materialDialog, i);
                    }
                });
            }
        }

        private void addButtonsCallback() {
            if (this.positiveDialogListener != null || this.negativeDialogListener != null) {
                this.builder.callback(new MaterialDialog.ButtonCallback() {
                    public void onNeutral(MaterialDialog materialDialog) {
                        if (Builder.this.neutralDialogListener != null) {
                            Builder.this.neutralDialogListener.onClick(materialDialog, -3);
                        }
                    }

                    public void onPositive(MaterialDialog materialDialog) {
                        if (Builder.this.positiveDialogListener != null) {
                            Builder.this.positiveDialogListener.onClick(materialDialog, -1);
                        }
                    }

                    public void onNegative(MaterialDialog materialDialog) {
                        if (Builder.this.negativeDialogListener != null) {
                            Builder.this.negativeDialogListener.onClick(materialDialog, -2);
                        }
                    }
                });
            }
        }

        public Builder setView(View view) {
            this.builder.customView(view, false);
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.builder.items(i);
            setUpMultiChoiceCallback(zArr, onMultiChoiceClickListener);
            return this;
        }

        public Builder setMultiChoiceItems(String[] strArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.builder.items((CharSequence[]) strArr);
            setUpMultiChoiceCallback(zArr, onMultiChoiceClickListener);
            return this;
        }

        public Builder alwaysCallSingleChoiceCallback() {
            this.builder.alwaysCallSingleChoiceCallback();
            return this;
        }

        public Builder alwaysCallMultiChoiceCallback() {
            this.builder.alwaysCallMultiChoiceCallback();
            return this;
        }

        private void setUpMultiChoiceCallback(final boolean[] zArr, final DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            Integer[] numArr;
            if (zArr != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < zArr.length; i++) {
                    if (zArr[i]) {
                        arrayList.add(Integer.valueOf(i));
                    }
                }
                numArr = (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
            } else {
                numArr = null;
            }
            this.builder.itemsCallbackMultiChoice(numArr, new MaterialDialog.ListCallbackMultiChoice() {
                public boolean onSelection(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr) {
                    List asList = Arrays.asList(numArr);
                    if (zArr == null) {
                        return true;
                    }
                    int i = 0;
                    while (true) {
                        boolean[] zArr = zArr;
                        if (i >= zArr.length) {
                            return true;
                        }
                        boolean z = zArr[i];
                        zArr[i] = asList.contains(Integer.valueOf(i));
                        boolean[] zArr2 = zArr;
                        if (z != zArr2[i]) {
                            onMultiChoiceClickListener.onClick(materialDialog, i, zArr2[i]);
                        }
                        i++;
                    }
                }
            });
        }

        public Builder setSingleChoiceItems(String[] strArr, int i, final DialogInterface.OnClickListener onClickListener2) {
            this.builder.items((CharSequence[]) strArr);
            this.builder.itemsCallbackSingleChoice(i, new MaterialDialog.ListCallbackSingleChoice() {
                public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                    onClickListener2.onClick(materialDialog, i);
                    return true;
                }
            });
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, final DialogInterface.OnClickListener onClickListener2) {
            this.builder.items(i);
            this.builder.itemsCallbackSingleChoice(i2, new MaterialDialog.ListCallbackSingleChoice() {
                public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                    onClickListener2.onClick(materialDialog, i);
                    return true;
                }
            });
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.builder.cancelListener(onCancelListener);
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.builder.dismissListener(onDismissListener);
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.builder.showListener(onShowListener);
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.builder.keyListener(onKeyListener);
            return this;
        }
    }
}
