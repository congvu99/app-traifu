package com.afollestad.materialdialogs.color;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ColorChooserDialog extends DialogFragment implements View.OnClickListener, View.OnLongClickListener {
    public static final String TAG_ACCENT = "[MD_COLOR_CHOOSER]";
    public static final String TAG_CUSTOM = "[MD_COLOR_CHOOSER]";
    public static final String TAG_PRIMARY = "[MD_COLOR_CHOOSER]";
    /* access modifiers changed from: private */
    public ColorCallback mCallback;
    /* access modifiers changed from: private */
    public int mCircleSize;
    private View mColorChooserCustomFrame;
    /* access modifiers changed from: private */
    public int[][] mColorsSub;
    /* access modifiers changed from: private */
    public int[] mColorsTop;
    /* access modifiers changed from: private */
    public EditText mCustomColorHex;
    /* access modifiers changed from: private */
    public View mCustomColorIndicator;
    private SeekBar.OnSeekBarChangeListener mCustomColorRgbListener;
    private TextWatcher mCustomColorTextWatcher;
    /* access modifiers changed from: private */
    public SeekBar mCustomSeekA;
    /* access modifiers changed from: private */
    public TextView mCustomSeekAValue;
    /* access modifiers changed from: private */
    public SeekBar mCustomSeekB;
    /* access modifiers changed from: private */
    public TextView mCustomSeekBValue;
    /* access modifiers changed from: private */
    public SeekBar mCustomSeekG;
    /* access modifiers changed from: private */
    public TextView mCustomSeekGValue;
    /* access modifiers changed from: private */
    public SeekBar mCustomSeekR;
    /* access modifiers changed from: private */
    public TextView mCustomSeekRValue;
    private GridView mGrid;
    /* access modifiers changed from: private */
    public int mSelectedCustomColor;

    public interface ColorCallback {
        void onColorSelection(ColorChooserDialog colorChooserDialog, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorChooserTag {
    }

    private void generateColors() {
        Builder builder = getBuilder();
        if (builder.mColorsTop != null) {
            this.mColorsTop = builder.mColorsTop;
            this.mColorsSub = builder.mColorsSub;
        } else if (builder.mAccentMode) {
            this.mColorsTop = ColorPalette.ACCENT_COLORS;
            this.mColorsSub = ColorPalette.ACCENT_COLORS_SUB;
        } else {
            this.mColorsTop = ColorPalette.PRIMARY_COLORS;
            this.mColorsSub = ColorPalette.PRIMARY_COLORS_SUB;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("top_index", topIndex());
        bundle.putBoolean("in_sub", isInSub());
        bundle.putInt("sub_index", subIndex());
        View view = this.mColorChooserCustomFrame;
        bundle.putBoolean("in_custom", view != null && view.getVisibility() == 0);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ColorCallback) {
            this.mCallback = (ColorCallback) activity;
            return;
        }
        throw new IllegalStateException("ColorChooserDialog needs to be shown from an Activity implementing ColorCallback.");
    }

    /* access modifiers changed from: private */
    public boolean isInSub() {
        return getArguments().getBoolean("in_sub", false);
    }

    /* access modifiers changed from: private */
    public void isInSub(boolean z) {
        getArguments().putBoolean("in_sub", z);
    }

    /* access modifiers changed from: private */
    public int topIndex() {
        return getArguments().getInt("top_index", -1);
    }

    /* access modifiers changed from: private */
    public void topIndex(int i) {
        if (topIndex() != i && i > -1) {
            findSubIndexForColor(i, this.mColorsTop[i]);
        }
        getArguments().putInt("top_index", i);
    }

    /* access modifiers changed from: private */
    public int subIndex() {
        if (this.mColorsSub == null) {
            return -1;
        }
        return getArguments().getInt("sub_index", -1);
    }

    /* access modifiers changed from: private */
    public void subIndex(int i) {
        if (this.mColorsSub != null) {
            getArguments().putInt("sub_index", i);
        }
    }

    public int getTitle() {
        int i;
        Builder builder = getBuilder();
        if (isInSub()) {
            i = builder.mTitleSub;
        } else {
            i = builder.mTitle;
        }
        return i == 0 ? builder.mTitle : i;
    }

    public boolean isAccentMode() {
        return getBuilder().mAccentMode;
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            int parseInt = Integer.parseInt(((String) view.getTag()).split(CertificateUtil.DELIMITER)[0]);
            MaterialDialog materialDialog = (MaterialDialog) getDialog();
            Builder builder = getBuilder();
            if (isInSub()) {
                subIndex(parseInt);
            } else {
                topIndex(parseInt);
                int[][] iArr = this.mColorsSub;
                if (iArr != null && parseInt < iArr.length) {
                    materialDialog.setActionButton(DialogAction.NEGATIVE, builder.mBackBtn);
                    isInSub(true);
                }
            }
            if (builder.mAllowUserCustom) {
                this.mSelectedCustomColor = getSelectedColor();
            }
            invalidateDynamicButtonColors();
            invalidate();
        }
    }

    public boolean onLongClick(View view) {
        if (view.getTag() == null) {
            return false;
        }
        ((CircleView) view).showHint(Integer.parseInt(((String) view.getTag()).split(CertificateUtil.DELIMITER)[1]));
        return true;
    }

    /* access modifiers changed from: private */
    public void invalidateDynamicButtonColors() {
        MaterialDialog materialDialog = (MaterialDialog) getDialog();
        if (materialDialog != null && getBuilder().mDynamicButtonColor) {
            int selectedColor = getSelectedColor();
            if (Color.alpha(selectedColor) < 64 || (Color.red(selectedColor) > 247 && Color.green(selectedColor) > 247 && Color.blue(selectedColor) > 247)) {
                selectedColor = Color.parseColor("#DEDEDE");
            }
            if (getBuilder().mDynamicButtonColor) {
                materialDialog.getActionButton(DialogAction.POSITIVE).setTextColor(selectedColor);
                materialDialog.getActionButton(DialogAction.NEGATIVE).setTextColor(selectedColor);
                materialDialog.getActionButton(DialogAction.NEUTRAL).setTextColor(selectedColor);
            }
            if (this.mCustomSeekR != null) {
                if (this.mCustomSeekA.getVisibility() == 0) {
                    MDTintHelper.setTint(this.mCustomSeekA, selectedColor);
                }
                MDTintHelper.setTint(this.mCustomSeekR, selectedColor);
                MDTintHelper.setTint(this.mCustomSeekG, selectedColor);
                MDTintHelper.setTint(this.mCustomSeekB, selectedColor);
            }
        }
    }

    /* access modifiers changed from: private */
    public int getSelectedColor() {
        int i;
        View view = this.mColorChooserCustomFrame;
        if (view != null && view.getVisibility() == 0) {
            return this.mSelectedCustomColor;
        }
        int i2 = 0;
        if (subIndex() > -1) {
            i = this.mColorsSub[topIndex()][subIndex()];
        } else {
            i = topIndex() > -1 ? this.mColorsTop[topIndex()] : 0;
        }
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            i2 = DialogUtils.resolveColor(getActivity(), 16843829);
        }
        return DialogUtils.resolveColor(getActivity(), R.attr.colorAccent, i2);
    }

    private void findSubIndexForColor(int i, int i2) {
        int[][] iArr = this.mColorsSub;
        if (iArr != null && iArr.length - 1 >= i) {
            int[] iArr2 = iArr[i];
            for (int i3 = 0; i3 < iArr2.length; i3++) {
                if (iArr2[i3] == i2) {
                    subIndex(i3);
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0080, code lost:
        r8 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.app.Dialog onCreateDialog(android.os.Bundle r8) {
        /*
            r7 = this;
            android.os.Bundle r0 = r7.getArguments()
            if (r0 == 0) goto L_0x01bc
            android.os.Bundle r0 = r7.getArguments()
            java.lang.String r1 = "builder"
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x01bc
            r7.generateColors()
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0025
            java.lang.String r2 = "in_custom"
            boolean r8 = r8.getBoolean(r2, r1)
            r8 = r8 ^ r0
            int r2 = r7.getSelectedColor()
            goto L_0x0085
        L_0x0025:
            com.afollestad.materialdialogs.color.ColorChooserDialog$Builder r8 = r7.getBuilder()
            boolean r8 = r8.mSetPreselectionColor
            if (r8 == 0) goto L_0x0082
            com.afollestad.materialdialogs.color.ColorChooserDialog$Builder r8 = r7.getBuilder()
            int r2 = r8.mPreselect
            r8 = 0
            if (r2 == 0) goto L_0x0085
            r3 = 0
        L_0x0037:
            int[] r4 = r7.mColorsTop
            int r5 = r4.length
            if (r8 >= r5) goto L_0x0080
            r4 = r4[r8]
            if (r4 != r2) goto L_0x005d
            r7.topIndex(r8)
            com.afollestad.materialdialogs.color.ColorChooserDialog$Builder r3 = r7.getBuilder()
            boolean r3 = r3.mAccentMode
            if (r3 == 0) goto L_0x0050
            r8 = 2
            r7.subIndex(r8)
            goto L_0x0084
        L_0x0050:
            int[][] r3 = r7.mColorsSub
            if (r3 == 0) goto L_0x0058
            r7.findSubIndexForColor(r8, r2)
            goto L_0x0084
        L_0x0058:
            r8 = 5
            r7.subIndex(r8)
            goto L_0x0084
        L_0x005d:
            int[][] r4 = r7.mColorsSub
            if (r4 == 0) goto L_0x007d
            r4 = 0
        L_0x0062:
            int[][] r5 = r7.mColorsSub
            r6 = r5[r8]
            int r6 = r6.length
            if (r4 >= r6) goto L_0x007a
            r5 = r5[r8]
            r5 = r5[r4]
            if (r5 != r2) goto L_0x0077
            r7.topIndex(r8)
            r7.subIndex(r4)
            r3 = 1
            goto L_0x007a
        L_0x0077:
            int r4 = r4 + 1
            goto L_0x0062
        L_0x007a:
            if (r3 == 0) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            int r8 = r8 + 1
            goto L_0x0037
        L_0x0080:
            r8 = r3
            goto L_0x0085
        L_0x0082:
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0084:
            r8 = 1
        L_0x0085:
            android.content.res.Resources r3 = r7.getResources()
            int r4 = com.afollestad.materialdialogs.commons.R.dimen.md_colorchooser_circlesize
            int r3 = r3.getDimensionPixelSize(r4)
            r7.mCircleSize = r3
            com.afollestad.materialdialogs.color.ColorChooserDialog$Builder r3 = r7.getBuilder()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = new com.afollestad.materialdialogs.MaterialDialog$Builder
            androidx.fragment.app.FragmentActivity r5 = r7.getActivity()
            r4.<init>(r5)
            int r5 = r7.getTitle()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.title((int) r5)
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.autoDismiss(r1)
            int r5 = com.afollestad.materialdialogs.commons.R.layout.md_dialog_colorchooser
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.customView((int) r5, (boolean) r1)
            int r5 = r3.mCancelBtn
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.negativeText((int) r5)
            int r5 = r3.mDoneBtn
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.positiveText((int) r5)
            boolean r5 = r3.mAllowUserCustom
            if (r5 == 0) goto L_0x00c3
            int r5 = r3.mCustomBtn
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.neutralText((int) r5)
            com.afollestad.materialdialogs.color.ColorChooserDialog$4 r5 = new com.afollestad.materialdialogs.color.ColorChooserDialog$4
            r5.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.onPositive(r5)
            com.afollestad.materialdialogs.color.ColorChooserDialog$3 r5 = new com.afollestad.materialdialogs.color.ColorChooserDialog$3
            r5.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.onNegative(r5)
            com.afollestad.materialdialogs.color.ColorChooserDialog$2 r5 = new com.afollestad.materialdialogs.color.ColorChooserDialog$2
            r5.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.onNeutral(r5)
            com.afollestad.materialdialogs.color.ColorChooserDialog$1 r5 = new com.afollestad.materialdialogs.color.ColorChooserDialog$1
            r5.<init>()
            com.afollestad.materialdialogs.MaterialDialog$Builder r4 = r4.showListener(r5)
            com.afollestad.materialdialogs.MaterialDialog r4 = r4.build()
            android.view.View r5 = r4.getCustomView()
            int r6 = com.afollestad.materialdialogs.commons.R.id.grid
            android.view.View r6 = r5.findViewById(r6)
            android.widget.GridView r6 = (android.widget.GridView) r6
            r7.mGrid = r6
            boolean r6 = r3.mAllowUserCustom
            if (r6 == 0) goto L_0x01b8
            r7.mSelectedCustomColor = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorChooserCustomFrame
            android.view.View r2 = r5.findViewById(r2)
            r7.mColorChooserCustomFrame = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.hexInput
            android.view.View r2 = r5.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            r7.mCustomColorHex = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorIndicator
            android.view.View r2 = r5.findViewById(r2)
            r7.mCustomColorIndicator = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorA
            android.view.View r2 = r5.findViewById(r2)
            android.widget.SeekBar r2 = (android.widget.SeekBar) r2
            r7.mCustomSeekA = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorAValue
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.mCustomSeekAValue = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorR
            android.view.View r2 = r5.findViewById(r2)
            android.widget.SeekBar r2 = (android.widget.SeekBar) r2
            r7.mCustomSeekR = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorRValue
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.mCustomSeekRValue = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorG
            android.view.View r2 = r5.findViewById(r2)
            android.widget.SeekBar r2 = (android.widget.SeekBar) r2
            r7.mCustomSeekG = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorGValue
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.mCustomSeekGValue = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorB
            android.view.View r2 = r5.findViewById(r2)
            android.widget.SeekBar r2 = (android.widget.SeekBar) r2
            r7.mCustomSeekB = r2
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorBValue
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r7.mCustomSeekBValue = r2
            boolean r2 = r3.mAllowUserCustomAlpha
            r3 = 8
            if (r2 != 0) goto L_0x019e
            int r2 = com.afollestad.materialdialogs.commons.R.id.colorALabel
            android.view.View r2 = r5.findViewById(r2)
            r2.setVisibility(r3)
            android.widget.SeekBar r2 = r7.mCustomSeekA
            r2.setVisibility(r3)
            android.widget.TextView r2 = r7.mCustomSeekAValue
            r2.setVisibility(r3)
            android.widget.EditText r2 = r7.mCustomColorHex
            java.lang.String r3 = "2196F3"
            r2.setHint(r3)
            android.widget.EditText r2 = r7.mCustomColorHex
            android.text.InputFilter[] r0 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r3 = new android.text.InputFilter$LengthFilter
            r5 = 6
            r3.<init>(r5)
            r0[r1] = r3
            r2.setFilters(r0)
            goto L_0x01b3
        L_0x019e:
            android.widget.EditText r2 = r7.mCustomColorHex
            java.lang.String r5 = "FF2196F3"
            r2.setHint(r5)
            android.widget.EditText r2 = r7.mCustomColorHex
            android.text.InputFilter[] r0 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r3)
            r0[r1] = r5
            r2.setFilters(r0)
        L_0x01b3:
            if (r8 != 0) goto L_0x01b8
            r7.toggleCustom(r4)
        L_0x01b8:
            r7.invalidate()
            return r4
        L_0x01bc:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "ColorChooserDialog should be created using its Builder interface."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.color.ColorChooserDialog.onCreateDialog(android.os.Bundle):android.app.Dialog");
    }

    /* access modifiers changed from: private */
    public void toggleCustom(MaterialDialog materialDialog) {
        if (materialDialog == null) {
            materialDialog = (MaterialDialog) getDialog();
        }
        if (this.mGrid.getVisibility() == 0) {
            materialDialog.setTitle(getBuilder().mCustomBtn);
            materialDialog.setActionButton(DialogAction.NEUTRAL, getBuilder().mPresetsBtn);
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mCancelBtn);
            this.mGrid.setVisibility(4);
            this.mColorChooserCustomFrame.setVisibility(0);
            AnonymousClass5 r5 = new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    try {
                        ColorChooserDialog colorChooserDialog = ColorChooserDialog.this;
                        int unused = colorChooserDialog.mSelectedCustomColor = Color.parseColor("#" + charSequence.toString());
                    } catch (IllegalArgumentException unused2) {
                        int unused3 = ColorChooserDialog.this.mSelectedCustomColor = ViewCompat.MEASURED_STATE_MASK;
                    }
                    ColorChooserDialog.this.mCustomColorIndicator.setBackgroundColor(ColorChooserDialog.this.mSelectedCustomColor);
                    if (ColorChooserDialog.this.mCustomSeekA.getVisibility() == 0) {
                        int alpha = Color.alpha(ColorChooserDialog.this.mSelectedCustomColor);
                        ColorChooserDialog.this.mCustomSeekA.setProgress(alpha);
                        ColorChooserDialog.this.mCustomSeekAValue.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(alpha)}));
                    }
                    if (ColorChooserDialog.this.mCustomSeekA.getVisibility() == 0) {
                        ColorChooserDialog.this.mCustomSeekA.setProgress(Color.alpha(ColorChooserDialog.this.mSelectedCustomColor));
                    }
                    ColorChooserDialog.this.mCustomSeekR.setProgress(Color.red(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.mCustomSeekG.setProgress(Color.green(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.mCustomSeekB.setProgress(Color.blue(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.isInSub(false);
                    ColorChooserDialog.this.topIndex(-1);
                    ColorChooserDialog.this.subIndex(-1);
                    ColorChooserDialog.this.invalidateDynamicButtonColors();
                }
            };
            this.mCustomColorTextWatcher = r5;
            this.mCustomColorHex.addTextChangedListener(r5);
            AnonymousClass6 r52 = new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        if (ColorChooserDialog.this.getBuilder().mAllowUserCustomAlpha) {
                            int argb = Color.argb(ColorChooserDialog.this.mCustomSeekA.getProgress(), ColorChooserDialog.this.mCustomSeekR.getProgress(), ColorChooserDialog.this.mCustomSeekG.getProgress(), ColorChooserDialog.this.mCustomSeekB.getProgress());
                            ColorChooserDialog.this.mCustomColorHex.setText(String.format("%08X", new Object[]{Integer.valueOf(argb)}));
                        } else {
                            int rgb = Color.rgb(ColorChooserDialog.this.mCustomSeekR.getProgress(), ColorChooserDialog.this.mCustomSeekG.getProgress(), ColorChooserDialog.this.mCustomSeekB.getProgress());
                            ColorChooserDialog.this.mCustomColorHex.setText(String.format("%06X", new Object[]{Integer.valueOf(rgb & 16777215)}));
                        }
                    }
                    ColorChooserDialog.this.mCustomSeekAValue.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(ColorChooserDialog.this.mCustomSeekA.getProgress())}));
                    ColorChooserDialog.this.mCustomSeekRValue.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(ColorChooserDialog.this.mCustomSeekR.getProgress())}));
                    ColorChooserDialog.this.mCustomSeekGValue.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(ColorChooserDialog.this.mCustomSeekG.getProgress())}));
                    ColorChooserDialog.this.mCustomSeekBValue.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(ColorChooserDialog.this.mCustomSeekB.getProgress())}));
                }
            };
            this.mCustomColorRgbListener = r52;
            this.mCustomSeekR.setOnSeekBarChangeListener(r52);
            this.mCustomSeekG.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
            this.mCustomSeekB.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
            if (this.mCustomSeekA.getVisibility() == 0) {
                this.mCustomSeekA.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
                this.mCustomColorHex.setText(String.format("%08X", new Object[]{Integer.valueOf(this.mSelectedCustomColor)}));
                return;
            }
            this.mCustomColorHex.setText(String.format("%06X", new Object[]{Integer.valueOf(16777215 & this.mSelectedCustomColor)}));
            return;
        }
        materialDialog.setTitle(getBuilder().mTitle);
        materialDialog.setActionButton(DialogAction.NEUTRAL, getBuilder().mCustomBtn);
        if (isInSub()) {
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mBackBtn);
        } else {
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mCancelBtn);
        }
        this.mGrid.setVisibility(0);
        this.mColorChooserCustomFrame.setVisibility(8);
        this.mCustomColorHex.removeTextChangedListener(this.mCustomColorTextWatcher);
        this.mCustomColorTextWatcher = null;
        this.mCustomSeekR.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        this.mCustomSeekG.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        this.mCustomSeekB.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        this.mCustomColorRgbListener = null;
    }

    /* access modifiers changed from: private */
    public void invalidate() {
        if (this.mGrid.getAdapter() == null) {
            this.mGrid.setAdapter(new ColorGridAdapter());
            this.mGrid.setSelector(ResourcesCompat.getDrawable(getResources(), R.drawable.md_transparent, (Resources.Theme) null));
        } else {
            ((BaseAdapter) this.mGrid.getAdapter()).notifyDataSetChanged();
        }
        if (getDialog() != null) {
            getDialog().setTitle(getTitle());
        }
    }

    private class ColorGridAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        public ColorGridAdapter() {
        }

        public int getCount() {
            if (ColorChooserDialog.this.isInSub()) {
                return ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()].length;
            }
            return ColorChooserDialog.this.mColorsTop.length;
        }

        public Object getItem(int i) {
            if (ColorChooserDialog.this.isInSub()) {
                return Integer.valueOf(ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()][i]);
            }
            return Integer.valueOf(ColorChooserDialog.this.mColorsTop[i]);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new CircleView(ColorChooserDialog.this.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(ColorChooserDialog.this.mCircleSize, ColorChooserDialog.this.mCircleSize));
            }
            CircleView circleView = (CircleView) view;
            int i2 = ColorChooserDialog.this.isInSub() ? ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()][i] : ColorChooserDialog.this.mColorsTop[i];
            circleView.setBackgroundColor(i2);
            if (ColorChooserDialog.this.isInSub()) {
                circleView.setSelected(ColorChooserDialog.this.subIndex() == i);
            } else {
                circleView.setSelected(ColorChooserDialog.this.topIndex() == i);
            }
            circleView.setTag(String.format("%d:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            circleView.setOnClickListener(ColorChooserDialog.this);
            circleView.setOnLongClickListener(ColorChooserDialog.this);
            return view;
        }
    }

    public static class Builder implements Serializable {
        protected boolean mAccentMode = false;
        protected boolean mAllowUserCustom = true;
        protected boolean mAllowUserCustomAlpha = true;
        protected int mBackBtn = R.string.md_back_label;
        protected int mCancelBtn = R.string.md_cancel_label;
        protected int[][] mColorsSub;
        protected int[] mColorsTop;
        protected final transient AppCompatActivity mContext;
        protected int mCustomBtn = R.string.md_custom_label;
        protected int mDoneBtn = R.string.md_done_label;
        protected boolean mDynamicButtonColor = true;
        protected int mPreselect;
        protected int mPresetsBtn = R.string.md_presets_label;
        protected boolean mSetPreselectionColor = false;
        protected final int mTitle;
        protected int mTitleSub;

        public <ActivityType extends AppCompatActivity & ColorCallback> Builder(ActivityType activitytype, int i) {
            this.mContext = activitytype;
            this.mTitle = i;
        }

        public Builder titleSub(int i) {
            this.mTitleSub = i;
            return this;
        }

        public Builder preselect(int i) {
            this.mPreselect = i;
            this.mSetPreselectionColor = true;
            return this;
        }

        public Builder accentMode(boolean z) {
            this.mAccentMode = z;
            return this;
        }

        public Builder doneButton(int i) {
            this.mDoneBtn = i;
            return this;
        }

        public Builder backButton(int i) {
            this.mBackBtn = i;
            return this;
        }

        public Builder cancelButton(int i) {
            this.mCancelBtn = i;
            return this;
        }

        public Builder customButton(int i) {
            this.mCustomBtn = i;
            return this;
        }

        public Builder presetsButton(int i) {
            this.mPresetsBtn = i;
            return this;
        }

        public Builder dynamicButtonColor(boolean z) {
            this.mDynamicButtonColor = z;
            return this;
        }

        public Builder customColors(int[] iArr, int[][] iArr2) {
            this.mColorsTop = iArr;
            this.mColorsSub = iArr2;
            return this;
        }

        public Builder customColors(int i, int[][] iArr) {
            this.mColorsTop = DialogUtils.getColorArray(this.mContext, i);
            this.mColorsSub = iArr;
            return this;
        }

        public Builder allowUserColorInput(boolean z) {
            this.mAllowUserCustom = z;
            return this;
        }

        public Builder allowUserColorInputAlpha(boolean z) {
            this.mAllowUserCustomAlpha = z;
            return this;
        }

        public ColorChooserDialog build() {
            ColorChooserDialog colorChooserDialog = new ColorChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            colorChooserDialog.setArguments(bundle);
            return colorChooserDialog;
        }

        public ColorChooserDialog show() {
            ColorChooserDialog build = build();
            build.show(this.mContext);
            return build;
        }
    }

    /* access modifiers changed from: private */
    public Builder getBuilder() {
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            return null;
        }
        return (Builder) getArguments().getSerializable("builder");
    }

    private void dismissIfNecessary(AppCompatActivity appCompatActivity, String str) {
        Fragment findFragmentByTag = appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
            appCompatActivity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
        }
    }

    public static ColorChooserDialog findVisible(AppCompatActivity appCompatActivity, String str) {
        Fragment findFragmentByTag = appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (findFragmentByTag == null || !(findFragmentByTag instanceof ColorChooserDialog)) {
            return null;
        }
        return (ColorChooserDialog) findFragmentByTag;
    }

    public ColorChooserDialog show(AppCompatActivity appCompatActivity) {
        Builder builder = getBuilder();
        if (builder.mColorsTop == null) {
            boolean z = builder.mAccentMode;
        }
        dismissIfNecessary(appCompatActivity, "[MD_COLOR_CHOOSER]");
        show(appCompatActivity.getSupportFragmentManager(), "[MD_COLOR_CHOOSER]");
        return this;
    }
}
