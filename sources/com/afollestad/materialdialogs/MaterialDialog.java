package com.afollestad.materialdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.internal.ThemeSingleton;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.afollestad.materialdialogs.util.RippleHelper;
import com.afollestad.materialdialogs.util.TypefaceHelper;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MaterialDialog extends DialogBase implements View.OnClickListener, AdapterView.OnItemClickListener {
    protected TextView content;
    protected FrameLayout customViewFrame;
    protected ImageView icon;
    protected EditText input;
    protected TextView inputMinMax;
    protected ListType listType;
    protected ListView listView;
    protected final Builder mBuilder;
    private final Handler mHandler = new Handler();
    protected ProgressBar mProgress;
    protected TextView mProgressLabel;
    protected TextView mProgressMinMax;
    protected MDButton negativeButton;
    protected MDButton neutralButton;
    protected MDButton positiveButton;
    protected List<Integer> selectedIndicesList;
    protected TextView title;
    protected View titleFrame;

    public interface InputCallback {
        void onInput(MaterialDialog materialDialog, CharSequence charSequence);
    }

    public interface ListCallback {
        void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence);
    }

    public interface ListCallbackMultiChoice {
        boolean onSelection(MaterialDialog materialDialog, Integer[] numArr, CharSequence[] charSequenceArr);
    }

    public interface ListCallbackSingleChoice {
        boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence);
    }

    public interface SingleButtonCallback {
        void onClick(MaterialDialog materialDialog, DialogAction dialogAction);
    }

    public /* bridge */ /* synthetic */ View findViewById(int i) {
        return super.findViewById(i);
    }

    public /* bridge */ /* synthetic */ void setContentView(int i) throws IllegalAccessError {
        super.setContentView(i);
    }

    public /* bridge */ /* synthetic */ void setContentView(View view) throws IllegalAccessError {
        super.setContentView(view);
    }

    public /* bridge */ /* synthetic */ void setContentView(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        super.setContentView(view, layoutParams);
    }

    public final Builder getBuilder() {
        return this.mBuilder;
    }

    protected MaterialDialog(Builder builder) {
        super(builder.context, DialogInit.getTheme(builder));
        this.mBuilder = builder;
        this.view = (MDRootLayout) LayoutInflater.from(builder.context).inflate(DialogInit.getInflateLayout(builder), (ViewGroup) null);
        DialogInit.init(this);
    }

    public final void setTypeface(TextView textView, Typeface typeface) {
        if (typeface != null) {
            textView.setPaintFlags(textView.getPaintFlags() | 128);
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: protected */
    public final void checkIfListInitScroll() {
        ListView listView2 = this.listView;
        if (listView2 != null) {
            listView2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    int i;
                    if (Build.VERSION.SDK_INT < 16) {
                        MaterialDialog.this.listView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        MaterialDialog.this.listView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    if (MaterialDialog.this.listType == ListType.SINGLE || MaterialDialog.this.listType == ListType.MULTI) {
                        final int i2 = 0;
                        if (MaterialDialog.this.listType == ListType.SINGLE) {
                            if (MaterialDialog.this.mBuilder.selectedIndex >= 0) {
                                i = MaterialDialog.this.mBuilder.selectedIndex;
                            } else {
                                return;
                            }
                        } else if (MaterialDialog.this.selectedIndicesList != null && MaterialDialog.this.selectedIndicesList.size() != 0) {
                            Collections.sort(MaterialDialog.this.selectedIndicesList);
                            i = MaterialDialog.this.selectedIndicesList.get(0).intValue();
                        } else {
                            return;
                        }
                        if (MaterialDialog.this.listView.getLastVisiblePosition() < i) {
                            int lastVisiblePosition = i - ((MaterialDialog.this.listView.getLastVisiblePosition() - MaterialDialog.this.listView.getFirstVisiblePosition()) / 2);
                            if (lastVisiblePosition >= 0) {
                                i2 = lastVisiblePosition;
                            }
                            MaterialDialog.this.listView.post(new Runnable() {
                                public void run() {
                                    MaterialDialog.this.listView.requestFocus();
                                    MaterialDialog.this.listView.setSelection(i2);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void invalidateList() {
        if (this.listView != null) {
            if ((this.mBuilder.items != null && this.mBuilder.items.length != 0) || this.mBuilder.adapter != null) {
                this.listView.setAdapter(this.mBuilder.adapter);
                if (this.listType != null || this.mBuilder.listCallbackCustom != null) {
                    this.listView.setOnItemClickListener(this);
                }
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.mBuilder.listCallbackCustom != null) {
            CharSequence charSequence = null;
            if (view instanceof TextView) {
                charSequence = ((TextView) view).getText();
            }
            this.mBuilder.listCallbackCustom.onSelection(this, view, i, charSequence);
            return;
        }
        ListType listType2 = this.listType;
        if (listType2 == null || listType2 == ListType.REGULAR) {
            if (this.mBuilder.autoDismiss) {
                dismiss();
            }
            if (this.mBuilder.listCallback != null) {
                this.mBuilder.listCallback.onSelection(this, view, i, this.mBuilder.items[i]);
                return;
            }
            return;
        }
        boolean z = false;
        if (this.listType == ListType.MULTI) {
            boolean z2 = !this.selectedIndicesList.contains(Integer.valueOf(i));
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.control);
            if (z2) {
                this.selectedIndicesList.add(Integer.valueOf(i));
                if (!this.mBuilder.alwaysCallMultiChoiceCallback) {
                    checkBox.setChecked(true);
                } else if (sendMultichoiceCallback()) {
                    checkBox.setChecked(true);
                } else {
                    this.selectedIndicesList.remove(Integer.valueOf(i));
                }
            } else {
                this.selectedIndicesList.remove(Integer.valueOf(i));
                checkBox.setChecked(false);
                if (this.mBuilder.alwaysCallMultiChoiceCallback) {
                    sendMultichoiceCallback();
                }
            }
        } else if (this.listType == ListType.SINGLE) {
            DefaultAdapter defaultAdapter = (DefaultAdapter) this.mBuilder.adapter;
            RadioButton radioButton = (RadioButton) view.findViewById(R.id.control);
            if (this.mBuilder.autoDismiss && this.mBuilder.positiveText == null) {
                dismiss();
                this.mBuilder.selectedIndex = i;
                sendSingleChoiceCallback(view);
            } else if (this.mBuilder.alwaysCallSingleChoiceCallback) {
                int i2 = this.mBuilder.selectedIndex;
                this.mBuilder.selectedIndex = i;
                boolean sendSingleChoiceCallback = sendSingleChoiceCallback(view);
                this.mBuilder.selectedIndex = i2;
                z = sendSingleChoiceCallback;
            } else {
                z = true;
            }
            if (z) {
                this.mBuilder.selectedIndex = i;
                radioButton.setChecked(true);
                defaultAdapter.notifyDataSetChanged();
            }
        }
    }

    public static class NotImplementedException extends Error {
        public NotImplementedException(String str) {
            super(str);
        }
    }

    public static class DialogException extends WindowManager.BadTokenException {
        public DialogException(String str) {
            super(str);
        }
    }

    /* access modifiers changed from: protected */
    public final Drawable getListSelector() {
        if (this.mBuilder.listSelector != 0) {
            return ResourcesCompat.getDrawable(this.mBuilder.context.getResources(), this.mBuilder.listSelector, (Resources.Theme) null);
        }
        Drawable resolveDrawable = DialogUtils.resolveDrawable(this.mBuilder.context, R.attr.md_list_selector);
        if (resolveDrawable != null) {
            return resolveDrawable;
        }
        return DialogUtils.resolveDrawable(getContext(), R.attr.md_list_selector);
    }

    /* access modifiers changed from: package-private */
    public Drawable getButtonSelector(DialogAction dialogAction, boolean z) {
        if (!z) {
            int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (this.mBuilder.btnSelectorPositive != 0) {
                        return ResourcesCompat.getDrawable(this.mBuilder.context.getResources(), this.mBuilder.btnSelectorPositive, (Resources.Theme) null);
                    }
                    Drawable resolveDrawable = DialogUtils.resolveDrawable(this.mBuilder.context, R.attr.md_btn_positive_selector);
                    if (resolveDrawable != null) {
                        return resolveDrawable;
                    }
                    Drawable resolveDrawable2 = DialogUtils.resolveDrawable(getContext(), R.attr.md_btn_positive_selector);
                    if (Build.VERSION.SDK_INT >= 21) {
                        RippleHelper.applyColor(resolveDrawable2, this.mBuilder.buttonRippleColor);
                    }
                    return resolveDrawable2;
                } else if (this.mBuilder.btnSelectorNegative != 0) {
                    return ResourcesCompat.getDrawable(this.mBuilder.context.getResources(), this.mBuilder.btnSelectorNegative, (Resources.Theme) null);
                } else {
                    Drawable resolveDrawable3 = DialogUtils.resolveDrawable(this.mBuilder.context, R.attr.md_btn_negative_selector);
                    if (resolveDrawable3 != null) {
                        return resolveDrawable3;
                    }
                    Drawable resolveDrawable4 = DialogUtils.resolveDrawable(getContext(), R.attr.md_btn_negative_selector);
                    if (Build.VERSION.SDK_INT >= 21) {
                        RippleHelper.applyColor(resolveDrawable4, this.mBuilder.buttonRippleColor);
                    }
                    return resolveDrawable4;
                }
            } else if (this.mBuilder.btnSelectorNeutral != 0) {
                return ResourcesCompat.getDrawable(this.mBuilder.context.getResources(), this.mBuilder.btnSelectorNeutral, (Resources.Theme) null);
            } else {
                Drawable resolveDrawable5 = DialogUtils.resolveDrawable(this.mBuilder.context, R.attr.md_btn_neutral_selector);
                if (resolveDrawable5 != null) {
                    return resolveDrawable5;
                }
                Drawable resolveDrawable6 = DialogUtils.resolveDrawable(getContext(), R.attr.md_btn_neutral_selector);
                if (Build.VERSION.SDK_INT >= 21) {
                    RippleHelper.applyColor(resolveDrawable6, this.mBuilder.buttonRippleColor);
                }
                return resolveDrawable6;
            }
        } else if (this.mBuilder.btnSelectorStacked != 0) {
            return ResourcesCompat.getDrawable(this.mBuilder.context.getResources(), this.mBuilder.btnSelectorStacked, (Resources.Theme) null);
        } else {
            Drawable resolveDrawable7 = DialogUtils.resolveDrawable(this.mBuilder.context, R.attr.md_btn_stacked_selector);
            if (resolveDrawable7 != null) {
                return resolveDrawable7;
            }
            return DialogUtils.resolveDrawable(getContext(), R.attr.md_btn_stacked_selector);
        }
    }

    private boolean sendSingleChoiceCallback(View view) {
        if (this.mBuilder.listCallbackSingleChoice == null) {
            return false;
        }
        CharSequence charSequence = null;
        if (this.mBuilder.selectedIndex >= 0 && this.mBuilder.selectedIndex < this.mBuilder.items.length) {
            charSequence = this.mBuilder.items[this.mBuilder.selectedIndex];
        }
        return this.mBuilder.listCallbackSingleChoice.onSelection(this, view, this.mBuilder.selectedIndex, charSequence);
    }

    private boolean sendMultichoiceCallback() {
        if (this.mBuilder.listCallbackMultiChoice == null) {
            return false;
        }
        Collections.sort(this.selectedIndicesList);
        ArrayList arrayList = new ArrayList();
        for (Integer next : this.selectedIndicesList) {
            if (next.intValue() >= 0 && next.intValue() <= this.mBuilder.items.length - 1) {
                arrayList.add(this.mBuilder.items[next.intValue()]);
            }
        }
        ListCallbackMultiChoice listCallbackMultiChoice = this.mBuilder.listCallbackMultiChoice;
        List<Integer> list = this.selectedIndicesList;
        return listCallbackMultiChoice.onSelection(this, (Integer[]) list.toArray(new Integer[list.size()]), (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
    }

    public final void onClick(View view) {
        DialogAction dialogAction = (DialogAction) view.getTag();
        int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
        if (i == 1) {
            if (this.mBuilder.callback != null) {
                this.mBuilder.callback.onAny(this);
                this.mBuilder.callback.onNeutral(this);
            }
            if (this.mBuilder.onNeutralCallback != null) {
                this.mBuilder.onNeutralCallback.onClick(this, dialogAction);
            }
            if (this.mBuilder.autoDismiss) {
                dismiss();
            }
        } else if (i == 2) {
            if (this.mBuilder.callback != null) {
                this.mBuilder.callback.onAny(this);
                this.mBuilder.callback.onNegative(this);
            }
            if (this.mBuilder.onNegativeCallback != null) {
                this.mBuilder.onNegativeCallback.onClick(this, dialogAction);
            }
            if (this.mBuilder.autoDismiss) {
                dismiss();
            }
        } else if (i == 3) {
            if (this.mBuilder.callback != null) {
                this.mBuilder.callback.onAny(this);
                this.mBuilder.callback.onPositive(this);
            }
            if (this.mBuilder.onPositiveCallback != null) {
                this.mBuilder.onPositiveCallback.onClick(this, dialogAction);
            }
            if (!this.mBuilder.alwaysCallSingleChoiceCallback) {
                sendSingleChoiceCallback(view);
            }
            if (!this.mBuilder.alwaysCallMultiChoiceCallback) {
                sendMultichoiceCallback();
            }
            if (!(this.mBuilder.inputCallback == null || this.input == null || this.mBuilder.alwaysCallInputCallback)) {
                this.mBuilder.inputCallback.onInput(this, this.input.getText());
            }
            if (this.mBuilder.autoDismiss) {
                dismiss();
            }
        }
        if (this.mBuilder.onAnyCallback != null) {
            this.mBuilder.onAnyCallback.onClick(this, dialogAction);
        }
    }

    public static class Builder {
        protected ListAdapter adapter;
        protected boolean alwaysCallInputCallback;
        protected boolean alwaysCallMultiChoiceCallback = false;
        protected boolean alwaysCallSingleChoiceCallback = false;
        protected boolean autoDismiss = true;
        protected int backgroundColor;
        protected int btnSelectorNegative;
        protected int btnSelectorNeutral;
        protected int btnSelectorPositive;
        protected int btnSelectorStacked;
        protected GravityEnum btnStackedGravity = GravityEnum.END;
        protected int buttonRippleColor = 0;
        protected GravityEnum buttonsGravity = GravityEnum.START;
        protected ButtonCallback callback;
        protected DialogInterface.OnCancelListener cancelListener;
        protected boolean cancelable = true;
        protected boolean canceledOnTouchOutside = true;
        protected CharSequence content;
        protected int contentColor = -1;
        protected boolean contentColorSet = false;
        protected GravityEnum contentGravity = GravityEnum.START;
        protected float contentLineSpacingMultiplier = 1.2f;
        protected final Context context;
        protected View customView;
        protected DialogInterface.OnDismissListener dismissListener;
        protected int dividerColor;
        protected boolean dividerColorSet = false;
        protected boolean forceStacking;
        protected Drawable icon;
        protected boolean indeterminateIsHorizontalProgress;
        protected boolean indeterminateProgress;
        protected boolean inputAllowEmpty;
        protected InputCallback inputCallback;
        protected CharSequence inputHint;
        protected int inputMaxLength = -1;
        protected int inputMinLength = -1;
        protected CharSequence inputPrefill;
        protected int inputRangeErrorColor = 0;
        protected int inputType = -1;
        protected int itemColor;
        protected boolean itemColorSet = false;
        protected int[] itemIds;
        protected CharSequence[] items;
        protected GravityEnum itemsGravity = GravityEnum.START;
        protected DialogInterface.OnKeyListener keyListener;
        protected boolean limitIconToDefaultSize;
        protected ColorStateList linkColor;
        protected ListCallback listCallback;
        protected ListCallback listCallbackCustom;
        protected ListCallbackMultiChoice listCallbackMultiChoice;
        protected ListCallbackSingleChoice listCallbackSingleChoice;
        protected int listSelector;
        protected int maxIconSize = -1;
        protected Typeface mediumFont;
        protected ColorStateList negativeColor;
        protected boolean negativeColorSet = false;
        protected CharSequence negativeText;
        protected ColorStateList neutralColor;
        protected boolean neutralColorSet = false;
        protected CharSequence neutralText;
        protected SingleButtonCallback onAnyCallback;
        protected SingleButtonCallback onNegativeCallback;
        protected SingleButtonCallback onNeutralCallback;
        protected SingleButtonCallback onPositiveCallback;
        protected ColorStateList positiveColor;
        protected boolean positiveColorSet = false;
        protected CharSequence positiveText;
        protected int progress = -2;
        protected int progressMax = 0;
        protected String progressNumberFormat;
        protected NumberFormat progressPercentFormat;
        protected Typeface regularFont;
        protected int selectedIndex = -1;
        protected Integer[] selectedIndices = null;
        protected DialogInterface.OnShowListener showListener;
        protected boolean showMinMax;
        protected Theme theme = Theme.LIGHT;
        protected CharSequence title;
        protected int titleColor = -1;
        protected boolean titleColorSet = false;
        protected GravityEnum titleGravity = GravityEnum.START;
        protected int widgetColor;
        protected boolean widgetColorSet = false;
        protected boolean wrapCustomViewInScroll;

        public final Context getContext() {
            return this.context;
        }

        public final int getItemColor() {
            return this.itemColor;
        }

        public final Typeface getRegularFont() {
            return this.regularFont;
        }

        public Builder(Context context2) {
            this.context = context2;
            this.widgetColor = DialogUtils.resolveColor(context2, R.attr.colorAccent, DialogUtils.getColor(context2, R.color.md_material_blue_600));
            if (Build.VERSION.SDK_INT >= 21) {
                this.widgetColor = DialogUtils.resolveColor(context2, 16843829, this.widgetColor);
            }
            this.positiveColor = DialogUtils.getActionTextStateList(context2, this.widgetColor);
            this.negativeColor = DialogUtils.getActionTextStateList(context2, this.widgetColor);
            this.neutralColor = DialogUtils.getActionTextStateList(context2, this.widgetColor);
            this.linkColor = DialogUtils.getActionTextStateList(context2, DialogUtils.resolveColor(context2, R.attr.md_link_color, this.widgetColor));
            this.buttonRippleColor = DialogUtils.resolveColor(context2, R.attr.md_btn_ripple_color, DialogUtils.resolveColor(context2, R.attr.colorControlHighlight, Build.VERSION.SDK_INT >= 21 ? DialogUtils.resolveColor(context2, 16843820) : 0));
            this.progressPercentFormat = NumberFormat.getPercentInstance();
            this.progressNumberFormat = "%1d/%2d";
            this.theme = DialogUtils.isColorDark(DialogUtils.resolveColor(context2, 16842806)) ? Theme.LIGHT : Theme.DARK;
            checkSingleton();
            this.titleGravity = DialogUtils.resolveGravityEnum(context2, R.attr.md_title_gravity, this.titleGravity);
            this.contentGravity = DialogUtils.resolveGravityEnum(context2, R.attr.md_content_gravity, this.contentGravity);
            this.btnStackedGravity = DialogUtils.resolveGravityEnum(context2, R.attr.md_btnstacked_gravity, this.btnStackedGravity);
            this.itemsGravity = DialogUtils.resolveGravityEnum(context2, R.attr.md_items_gravity, this.itemsGravity);
            this.buttonsGravity = DialogUtils.resolveGravityEnum(context2, R.attr.md_buttons_gravity, this.buttonsGravity);
            typeface(DialogUtils.resolveString(context2, R.attr.md_medium_font), DialogUtils.resolveString(context2, R.attr.md_regular_font));
            if (this.mediumFont == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.mediumFont = Typeface.create("sans-serif-medium", 0);
                    } else {
                        this.mediumFont = Typeface.create("sans-serif", 1);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.regularFont == null) {
                try {
                    this.regularFont = Typeface.create("sans-serif", 0);
                } catch (Exception unused2) {
                }
            }
        }

        private void checkSingleton() {
            if (ThemeSingleton.get(false) != null) {
                ThemeSingleton themeSingleton = ThemeSingleton.get();
                if (themeSingleton.darkTheme) {
                    this.theme = Theme.DARK;
                }
                if (themeSingleton.titleColor != 0) {
                    this.titleColor = themeSingleton.titleColor;
                }
                if (themeSingleton.contentColor != 0) {
                    this.contentColor = themeSingleton.contentColor;
                }
                if (themeSingleton.positiveColor != null) {
                    this.positiveColor = themeSingleton.positiveColor;
                }
                if (themeSingleton.neutralColor != null) {
                    this.neutralColor = themeSingleton.neutralColor;
                }
                if (themeSingleton.negativeColor != null) {
                    this.negativeColor = themeSingleton.negativeColor;
                }
                if (themeSingleton.itemColor != 0) {
                    this.itemColor = themeSingleton.itemColor;
                }
                if (themeSingleton.icon != null) {
                    this.icon = themeSingleton.icon;
                }
                if (themeSingleton.backgroundColor != 0) {
                    this.backgroundColor = themeSingleton.backgroundColor;
                }
                if (themeSingleton.dividerColor != 0) {
                    this.dividerColor = themeSingleton.dividerColor;
                }
                if (themeSingleton.btnSelectorStacked != 0) {
                    this.btnSelectorStacked = themeSingleton.btnSelectorStacked;
                }
                if (themeSingleton.listSelector != 0) {
                    this.listSelector = themeSingleton.listSelector;
                }
                if (themeSingleton.btnSelectorPositive != 0) {
                    this.btnSelectorPositive = themeSingleton.btnSelectorPositive;
                }
                if (themeSingleton.btnSelectorNeutral != 0) {
                    this.btnSelectorNeutral = themeSingleton.btnSelectorNeutral;
                }
                if (themeSingleton.btnSelectorNegative != 0) {
                    this.btnSelectorNegative = themeSingleton.btnSelectorNegative;
                }
                if (themeSingleton.widgetColor != 0) {
                    this.widgetColor = themeSingleton.widgetColor;
                }
                if (themeSingleton.linkColor != null) {
                    this.linkColor = themeSingleton.linkColor;
                }
                this.titleGravity = themeSingleton.titleGravity;
                this.contentGravity = themeSingleton.contentGravity;
                this.btnStackedGravity = themeSingleton.btnStackedGravity;
                this.itemsGravity = themeSingleton.itemsGravity;
                this.buttonsGravity = themeSingleton.buttonsGravity;
            }
        }

        public Builder title(int i) {
            title(this.context.getText(i));
            return this;
        }

        public Builder title(CharSequence charSequence) {
            this.title = charSequence;
            return this;
        }

        public Builder titleGravity(GravityEnum gravityEnum) {
            this.titleGravity = gravityEnum;
            return this;
        }

        public Builder buttonRippleColor(int i) {
            this.buttonRippleColor = i;
            return this;
        }

        public Builder buttonRippleColorRes(int i) {
            return buttonRippleColor(DialogUtils.getColor(this.context, i));
        }

        public Builder buttonRippleColorAttr(int i) {
            return buttonRippleColor(DialogUtils.resolveColor(this.context, i));
        }

        public Builder titleColor(int i) {
            this.titleColor = i;
            this.titleColorSet = true;
            return this;
        }

        public Builder titleColorRes(int i) {
            return titleColor(DialogUtils.getColor(this.context, i));
        }

        public Builder titleColorAttr(int i) {
            return titleColor(DialogUtils.resolveColor(this.context, i));
        }

        public Builder typeface(Typeface typeface, Typeface typeface2) {
            this.mediumFont = typeface;
            this.regularFont = typeface2;
            return this;
        }

        public Builder typeface(String str, String str2) {
            if (str != null) {
                Typeface typeface = TypefaceHelper.get(this.context, str);
                this.mediumFont = typeface;
                if (typeface == null) {
                    throw new IllegalArgumentException("No font asset found for " + str);
                }
            }
            if (str2 != null) {
                Typeface typeface2 = TypefaceHelper.get(this.context, str2);
                this.regularFont = typeface2;
                if (typeface2 == null) {
                    throw new IllegalArgumentException("No font asset found for " + str2);
                }
            }
            return this;
        }

        public Builder icon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Builder iconRes(int i) {
            this.icon = ResourcesCompat.getDrawable(this.context.getResources(), i, (Resources.Theme) null);
            return this;
        }

        public Builder iconAttr(int i) {
            this.icon = DialogUtils.resolveDrawable(this.context, i);
            return this;
        }

        public Builder content(int i) {
            content(this.context.getText(i));
            return this;
        }

        public Builder content(CharSequence charSequence) {
            if (this.customView == null) {
                this.content = charSequence;
                return this;
            }
            throw new IllegalStateException("You cannot set content() when you're using a custom view.");
        }

        public Builder content(int i, Object... objArr) {
            content((CharSequence) this.context.getString(i, objArr));
            return this;
        }

        public Builder contentColor(int i) {
            this.contentColor = i;
            this.contentColorSet = true;
            return this;
        }

        public Builder contentColorRes(int i) {
            contentColor(DialogUtils.getColor(this.context, i));
            return this;
        }

        public Builder contentColorAttr(int i) {
            contentColor(DialogUtils.resolveColor(this.context, i));
            return this;
        }

        public Builder contentGravity(GravityEnum gravityEnum) {
            this.contentGravity = gravityEnum;
            return this;
        }

        public Builder contentLineSpacing(float f) {
            this.contentLineSpacingMultiplier = f;
            return this;
        }

        public Builder items(Collection collection) {
            if (collection.size() > 0) {
                String[] strArr = new String[collection.size()];
                int i = 0;
                for (Object obj : collection) {
                    strArr[i] = obj.toString();
                    i++;
                }
                items((CharSequence[]) strArr);
            }
            return this;
        }

        public Builder items(int i) {
            items(this.context.getResources().getTextArray(i));
            return this;
        }

        public Builder items(CharSequence... charSequenceArr) {
            if (this.customView == null) {
                this.items = charSequenceArr;
                return this;
            }
            throw new IllegalStateException("You cannot set items() when you're using a custom view.");
        }

        public Builder itemsCallback(ListCallback listCallback2) {
            this.listCallback = listCallback2;
            this.listCallbackSingleChoice = null;
            this.listCallbackMultiChoice = null;
            return this;
        }

        public Builder itemsColor(int i) {
            this.itemColor = i;
            this.itemColorSet = true;
            return this;
        }

        @Deprecated
        public Builder itemColor(int i) {
            return itemsColor(i);
        }

        public Builder itemsColorRes(int i) {
            return itemsColor(DialogUtils.getColor(this.context, i));
        }

        @Deprecated
        public Builder itemColorRes(int i) {
            return itemsColorRes(i);
        }

        public Builder itemsColorAttr(int i) {
            return itemsColor(DialogUtils.resolveColor(this.context, i));
        }

        @Deprecated
        public Builder itemColorAttr(int i) {
            return itemsColorAttr(i);
        }

        public Builder itemsGravity(GravityEnum gravityEnum) {
            this.itemsGravity = gravityEnum;
            return this;
        }

        public Builder itemsIds(int[] iArr) {
            this.itemIds = iArr;
            return this;
        }

        public Builder itemsIds(int i) {
            return itemsIds(this.context.getResources().getIntArray(i));
        }

        public Builder buttonsGravity(GravityEnum gravityEnum) {
            this.buttonsGravity = gravityEnum;
            return this;
        }

        public Builder itemsCallbackSingleChoice(int i, ListCallbackSingleChoice listCallbackSingleChoice2) {
            this.selectedIndex = i;
            this.listCallback = null;
            this.listCallbackSingleChoice = listCallbackSingleChoice2;
            this.listCallbackMultiChoice = null;
            return this;
        }

        public Builder alwaysCallSingleChoiceCallback() {
            this.alwaysCallSingleChoiceCallback = true;
            return this;
        }

        public Builder itemsCallbackMultiChoice(Integer[] numArr, ListCallbackMultiChoice listCallbackMultiChoice2) {
            this.selectedIndices = numArr;
            this.listCallback = null;
            this.listCallbackSingleChoice = null;
            this.listCallbackMultiChoice = listCallbackMultiChoice2;
            return this;
        }

        public Builder alwaysCallMultiChoiceCallback() {
            this.alwaysCallMultiChoiceCallback = true;
            return this;
        }

        public Builder positiveText(int i) {
            if (i == 0) {
                return this;
            }
            positiveText(this.context.getText(i));
            return this;
        }

        public Builder positiveText(CharSequence charSequence) {
            this.positiveText = charSequence;
            return this;
        }

        public Builder positiveColor(int i) {
            return positiveColor(DialogUtils.getActionTextStateList(this.context, i));
        }

        public Builder positiveColorRes(int i) {
            return positiveColor(DialogUtils.getActionTextColorStateList(this.context, i));
        }

        public Builder positiveColorAttr(int i) {
            return positiveColor(DialogUtils.resolveActionTextColorStateList(this.context, i, (ColorStateList) null));
        }

        public Builder positiveColor(ColorStateList colorStateList) {
            this.positiveColor = colorStateList;
            this.positiveColorSet = true;
            return this;
        }

        public Builder neutralText(int i) {
            return i == 0 ? this : neutralText(this.context.getText(i));
        }

        public Builder neutralText(CharSequence charSequence) {
            this.neutralText = charSequence;
            return this;
        }

        public Builder negativeColor(int i) {
            return negativeColor(DialogUtils.getActionTextStateList(this.context, i));
        }

        public Builder negativeColorRes(int i) {
            return negativeColor(DialogUtils.getActionTextColorStateList(this.context, i));
        }

        public Builder negativeColorAttr(int i) {
            return negativeColor(DialogUtils.resolveActionTextColorStateList(this.context, i, (ColorStateList) null));
        }

        public Builder negativeColor(ColorStateList colorStateList) {
            this.negativeColor = colorStateList;
            this.negativeColorSet = true;
            return this;
        }

        public Builder negativeText(int i) {
            return i == 0 ? this : negativeText(this.context.getText(i));
        }

        public Builder negativeText(CharSequence charSequence) {
            this.negativeText = charSequence;
            return this;
        }

        public Builder neutralColor(int i) {
            return neutralColor(DialogUtils.getActionTextStateList(this.context, i));
        }

        public Builder neutralColorRes(int i) {
            return neutralColor(DialogUtils.getActionTextColorStateList(this.context, i));
        }

        public Builder neutralColorAttr(int i) {
            return neutralColor(DialogUtils.resolveActionTextColorStateList(this.context, i, (ColorStateList) null));
        }

        public Builder neutralColor(ColorStateList colorStateList) {
            this.neutralColor = colorStateList;
            this.neutralColorSet = true;
            return this;
        }

        public Builder linkColor(int i) {
            return linkColor(DialogUtils.getActionTextStateList(this.context, i));
        }

        public Builder linkColorRes(int i) {
            return linkColor(DialogUtils.getActionTextColorStateList(this.context, i));
        }

        public Builder linkColorAttr(int i) {
            return linkColor(DialogUtils.resolveActionTextColorStateList(this.context, i, (ColorStateList) null));
        }

        public Builder linkColor(ColorStateList colorStateList) {
            this.linkColor = colorStateList;
            return this;
        }

        public Builder listSelector(int i) {
            this.listSelector = i;
            return this;
        }

        public Builder btnSelectorStacked(int i) {
            this.btnSelectorStacked = i;
            return this;
        }

        public Builder btnSelector(int i) {
            this.btnSelectorPositive = i;
            this.btnSelectorNeutral = i;
            this.btnSelectorNegative = i;
            return this;
        }

        public Builder btnSelector(int i, DialogAction dialogAction) {
            int i2 = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
            if (i2 == 1) {
                this.btnSelectorNeutral = i;
            } else if (i2 != 2) {
                this.btnSelectorPositive = i;
            } else {
                this.btnSelectorNegative = i;
            }
            return this;
        }

        public Builder btnStackedGravity(GravityEnum gravityEnum) {
            this.btnStackedGravity = gravityEnum;
            return this;
        }

        public Builder customView(int i, boolean z) {
            return customView(LayoutInflater.from(this.context).inflate(i, (ViewGroup) null), z);
        }

        public Builder customView(View view, boolean z) {
            if (this.content != null) {
                throw new IllegalStateException("You cannot use customView() when you have content set.");
            } else if (this.items != null) {
                throw new IllegalStateException("You cannot use customView() when you have items set.");
            } else if (this.inputCallback != null) {
                throw new IllegalStateException("You cannot use customView() with an input dialog");
            } else if (this.progress > -2 || this.indeterminateProgress) {
                throw new IllegalStateException("You cannot use customView() with a progress dialog");
            } else {
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                this.customView = view;
                this.wrapCustomViewInScroll = z;
                return this;
            }
        }

        public Builder progress(boolean z, int i) {
            if (this.customView == null) {
                if (z) {
                    this.indeterminateProgress = true;
                    this.progress = -2;
                } else {
                    this.indeterminateProgress = false;
                    this.progress = -1;
                    this.progressMax = i;
                }
                return this;
            }
            throw new IllegalStateException("You cannot set progress() when you're using a custom view.");
        }

        public Builder progress(boolean z, int i, boolean z2) {
            this.showMinMax = z2;
            return progress(z, i);
        }

        public Builder progressNumberFormat(String str) {
            this.progressNumberFormat = str;
            return this;
        }

        public Builder progressPercentFormat(NumberFormat numberFormat) {
            this.progressPercentFormat = numberFormat;
            return this;
        }

        public Builder progressIndeterminateStyle(boolean z) {
            this.indeterminateIsHorizontalProgress = z;
            return this;
        }

        public Builder widgetColor(int i) {
            this.widgetColor = i;
            this.widgetColorSet = true;
            return this;
        }

        public Builder widgetColorRes(int i) {
            return widgetColor(DialogUtils.getColor(this.context, i));
        }

        public Builder widgetColorAttr(int i) {
            return widgetColorRes(DialogUtils.resolveColor(this.context, i));
        }

        public Builder dividerColor(int i) {
            this.dividerColor = i;
            this.dividerColorSet = true;
            return this;
        }

        public Builder dividerColorRes(int i) {
            return dividerColor(DialogUtils.getColor(this.context, i));
        }

        public Builder dividerColorAttr(int i) {
            return dividerColor(DialogUtils.resolveColor(this.context, i));
        }

        public Builder backgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder backgroundColorRes(int i) {
            return backgroundColor(DialogUtils.getColor(this.context, i));
        }

        public Builder backgroundColorAttr(int i) {
            return backgroundColor(DialogUtils.resolveColor(this.context, i));
        }

        public Builder callback(ButtonCallback buttonCallback) {
            this.callback = buttonCallback;
            return this;
        }

        public Builder onPositive(SingleButtonCallback singleButtonCallback) {
            this.onPositiveCallback = singleButtonCallback;
            return this;
        }

        public Builder onNegative(SingleButtonCallback singleButtonCallback) {
            this.onNegativeCallback = singleButtonCallback;
            return this;
        }

        public Builder onNeutral(SingleButtonCallback singleButtonCallback) {
            this.onNeutralCallback = singleButtonCallback;
            return this;
        }

        public Builder onAny(SingleButtonCallback singleButtonCallback) {
            this.onAnyCallback = singleButtonCallback;
            return this;
        }

        public Builder theme(Theme theme2) {
            this.theme = theme2;
            return this;
        }

        public Builder cancelable(boolean z) {
            this.cancelable = z;
            this.canceledOnTouchOutside = z;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean z) {
            this.canceledOnTouchOutside = z;
            return this;
        }

        public Builder autoDismiss(boolean z) {
            this.autoDismiss = z;
            return this;
        }

        public Builder adapter(ListAdapter listAdapter, ListCallback listCallback2) {
            if (this.customView == null) {
                this.adapter = listAdapter;
                this.listCallbackCustom = listCallback2;
                return this;
            }
            throw new IllegalStateException("You cannot set adapter() when you're using a custom view.");
        }

        public Builder limitIconToDefaultSize() {
            this.limitIconToDefaultSize = true;
            return this;
        }

        public Builder maxIconSize(int i) {
            this.maxIconSize = i;
            return this;
        }

        public Builder maxIconSizeRes(int i) {
            return maxIconSize((int) this.context.getResources().getDimension(i));
        }

        public Builder showListener(DialogInterface.OnShowListener onShowListener) {
            this.showListener = onShowListener;
            return this;
        }

        public Builder dismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public Builder cancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.cancelListener = onCancelListener;
            return this;
        }

        public Builder keyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.keyListener = onKeyListener;
            return this;
        }

        public Builder forceStacking(boolean z) {
            this.forceStacking = z;
            return this;
        }

        public Builder input(CharSequence charSequence, CharSequence charSequence2, boolean z, InputCallback inputCallback2) {
            if (this.customView == null) {
                this.inputCallback = inputCallback2;
                this.inputHint = charSequence;
                this.inputPrefill = charSequence2;
                this.inputAllowEmpty = z;
                return this;
            }
            throw new IllegalStateException("You cannot set content() when you're using a custom view.");
        }

        public Builder input(CharSequence charSequence, CharSequence charSequence2, InputCallback inputCallback2) {
            return input(charSequence, charSequence2, true, inputCallback2);
        }

        public Builder input(int i, int i2, boolean z, InputCallback inputCallback2) {
            CharSequence charSequence = null;
            CharSequence text = i == 0 ? null : this.context.getText(i);
            if (i2 != 0) {
                charSequence = this.context.getText(i2);
            }
            return input(text, charSequence, z, inputCallback2);
        }

        public Builder input(int i, int i2, InputCallback inputCallback2) {
            return input(i, i2, true, inputCallback2);
        }

        public Builder inputType(int i) {
            this.inputType = i;
            return this;
        }

        @Deprecated
        public Builder inputMaxLength(int i) {
            return inputRange(0, i, 0);
        }

        @Deprecated
        public Builder inputMaxLength(int i, int i2) {
            return inputRange(0, i, i2);
        }

        @Deprecated
        public Builder inputMaxLengthRes(int i, int i2) {
            return inputRangeRes(0, i, i2);
        }

        public Builder inputRange(int i, int i2) {
            return inputRange(i, i2, 0);
        }

        public Builder inputRange(int i, int i2, int i3) {
            if (i >= 0) {
                this.inputMinLength = i;
                this.inputMaxLength = i2;
                if (i3 == 0) {
                    this.inputRangeErrorColor = DialogUtils.getColor(this.context, R.color.md_edittext_error);
                } else {
                    this.inputRangeErrorColor = i3;
                }
                return this;
            }
            throw new IllegalArgumentException("Min length for input dialogs cannot be less than 0.");
        }

        public Builder inputRangeRes(int i, int i2, int i3) {
            return inputRange(i, i2, DialogUtils.getColor(this.context, i3));
        }

        public Builder alwaysCallInputCallback() {
            this.alwaysCallInputCallback = true;
            return this;
        }

        public MaterialDialog build() {
            return new MaterialDialog(this);
        }

        public MaterialDialog show() {
            MaterialDialog build = build();
            build.show();
            return build;
        }
    }

    public void show() {
        try {
            super.show();
        } catch (WindowManager.BadTokenException unused) {
            throw new DialogException("Bad window token, you cannot show a dialog before an Activity is created or after it's hidden.");
        }
    }

    public final MDButton getActionButton(DialogAction dialogAction) {
        int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
        if (i == 1) {
            return this.neutralButton;
        }
        if (i != 2) {
            return this.positiveButton;
        }
        return this.negativeButton;
    }

    public final View getView() {
        return this.view;
    }

    public final ListView getListView() {
        return this.listView;
    }

    public final EditText getInputEditText() {
        return this.input;
    }

    public final TextView getTitleView() {
        return this.title;
    }

    public ImageView getIconView() {
        return this.icon;
    }

    public final TextView getContentView() {
        return this.content;
    }

    public final View getCustomView() {
        return this.mBuilder.customView;
    }

    public final void setActionButton(DialogAction dialogAction, CharSequence charSequence) {
        int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
        int i2 = 8;
        if (i == 1) {
            this.mBuilder.neutralText = charSequence;
            this.neutralButton.setText(charSequence);
            MDButton mDButton = this.neutralButton;
            if (charSequence != null) {
                i2 = 0;
            }
            mDButton.setVisibility(i2);
        } else if (i != 2) {
            this.mBuilder.positiveText = charSequence;
            this.positiveButton.setText(charSequence);
            MDButton mDButton2 = this.positiveButton;
            if (charSequence != null) {
                i2 = 0;
            }
            mDButton2.setVisibility(i2);
        } else {
            this.mBuilder.negativeText = charSequence;
            this.negativeButton.setText(charSequence);
            MDButton mDButton3 = this.negativeButton;
            if (charSequence != null) {
                i2 = 0;
            }
            mDButton3.setVisibility(i2);
        }
    }

    public final void setActionButton(DialogAction dialogAction, int i) {
        setActionButton(dialogAction, getContext().getText(i));
    }

    public final boolean hasActionButtons() {
        return numberOfActionButtons() > 0;
    }

    public final int numberOfActionButtons() {
        int i = (this.mBuilder.positiveText == null || this.positiveButton.getVisibility() != 0) ? 0 : 1;
        if (this.mBuilder.neutralText != null && this.neutralButton.getVisibility() == 0) {
            i++;
        }
        return (this.mBuilder.negativeText == null || this.negativeButton.getVisibility() != 0) ? i : i + 1;
    }

    public final void setTitle(CharSequence charSequence) {
        this.title.setText(charSequence);
    }

    public final void setTitle(int i) {
        setTitle((CharSequence) this.mBuilder.context.getString(i));
    }

    public final void setTitle(int i, Object... objArr) {
        setTitle((CharSequence) this.mBuilder.context.getString(i, objArr));
    }

    public void setIcon(int i) {
        this.icon.setImageResource(i);
        this.icon.setVisibility(i != 0 ? 0 : 8);
    }

    public void setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
        this.icon.setVisibility(drawable != null ? 0 : 8);
    }

    public void setIconAttribute(int i) {
        setIcon(DialogUtils.resolveDrawable(this.mBuilder.context, i));
    }

    public final void setContent(CharSequence charSequence) {
        this.content.setText(charSequence);
        this.content.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public final void setContent(int i) {
        setContent((CharSequence) this.mBuilder.context.getString(i));
    }

    public final void setContent(int i, Object... objArr) {
        setContent((CharSequence) this.mBuilder.context.getString(i, objArr));
    }

    @Deprecated
    public void setMessage(CharSequence charSequence) {
        setContent(charSequence);
    }

    public final void setItems(CharSequence... charSequenceArr) {
        if (this.mBuilder.adapter != null) {
            this.mBuilder.items = charSequenceArr;
            if (this.mBuilder.adapter instanceof DefaultAdapter) {
                this.mBuilder.adapter = new DefaultAdapter(this, ListType.getLayoutForType(this.listType));
                this.listView.setAdapter(this.mBuilder.adapter);
                return;
            }
            throw new IllegalStateException("When using a custom adapter, setItems() cannot be used. Set items through the adapter instead.");
        }
        throw new IllegalStateException("This MaterialDialog instance does not yet have an adapter set to it. You cannot use setItems().");
    }

    public final int getCurrentProgress() {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            return -1;
        }
        return progressBar.getProgress();
    }

    public ProgressBar getProgressBar() {
        return this.mProgress;
    }

    public final void incrementProgress(int i) {
        setProgress(getCurrentProgress() + i);
    }

    public final void setProgress(int i) {
        if (this.mBuilder.progress > -2) {
            this.mProgress.setProgress(i);
            this.mHandler.post(new Runnable() {
                public void run() {
                    if (MaterialDialog.this.mProgressLabel != null) {
                        MaterialDialog.this.mProgressLabel.setText(MaterialDialog.this.mBuilder.progressPercentFormat.format((double) (((float) MaterialDialog.this.getCurrentProgress()) / ((float) MaterialDialog.this.getMaxProgress()))));
                    }
                    if (MaterialDialog.this.mProgressMinMax != null) {
                        MaterialDialog.this.mProgressMinMax.setText(String.format(MaterialDialog.this.mBuilder.progressNumberFormat, new Object[]{Integer.valueOf(MaterialDialog.this.getCurrentProgress()), Integer.valueOf(MaterialDialog.this.getMaxProgress())}));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Cannot use setProgress() on this dialog.");
    }

    public final void setMaxProgress(int i) {
        if (this.mBuilder.progress > -2) {
            this.mProgress.setMax(i);
            return;
        }
        throw new IllegalStateException("Cannot use setMaxProgress() on this dialog.");
    }

    public final boolean isIndeterminateProgress() {
        return this.mBuilder.indeterminateProgress;
    }

    public final int getMaxProgress() {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            return -1;
        }
        return progressBar.getMax();
    }

    public final void setProgressPercentFormat(NumberFormat numberFormat) {
        this.mBuilder.progressPercentFormat = numberFormat;
        setProgress(getCurrentProgress());
    }

    public final void setProgressNumberFormat(String str) {
        this.mBuilder.progressNumberFormat = str;
        setProgress(getCurrentProgress());
    }

    public final boolean isCancelled() {
        return !isShowing();
    }

    public int getSelectedIndex() {
        if (this.mBuilder.listCallbackSingleChoice != null) {
            return this.mBuilder.selectedIndex;
        }
        return -1;
    }

    public Integer[] getSelectedIndices() {
        if (this.mBuilder.listCallbackMultiChoice == null) {
            return null;
        }
        List<Integer> list = this.selectedIndicesList;
        return (Integer[]) list.toArray(new Integer[list.size()]);
    }

    public void setSelectedIndex(int i) {
        this.mBuilder.selectedIndex = i;
        if (this.mBuilder.adapter == null || !(this.mBuilder.adapter instanceof DefaultAdapter)) {
            throw new IllegalStateException("You can only use setSelectedIndex() with the default adapter implementation.");
        }
        ((DefaultAdapter) this.mBuilder.adapter).notifyDataSetChanged();
    }

    public void setSelectedIndices(Integer[] numArr) {
        this.selectedIndicesList = new ArrayList(Arrays.asList(numArr));
        if (this.mBuilder.adapter == null || !(this.mBuilder.adapter instanceof DefaultAdapter)) {
            throw new IllegalStateException("You can only use setSelectedIndices() with the default adapter implementation.");
        }
        ((DefaultAdapter) this.mBuilder.adapter).notifyDataSetChanged();
    }

    public void clearSelectedIndices() {
        clearSelectedIndices(true);
    }

    public void clearSelectedIndices(boolean z) {
        ListType listType2 = this.listType;
        if (listType2 == null || listType2 != ListType.MULTI) {
            throw new IllegalStateException("You can only use clearSelectedIndices() with multi choice list dialogs.");
        } else if (this.mBuilder.adapter == null || !(this.mBuilder.adapter instanceof DefaultAdapter)) {
            throw new IllegalStateException("You can only use clearSelectedIndices() with the default adapter implementation.");
        } else {
            List<Integer> list = this.selectedIndicesList;
            if (list != null) {
                list.clear();
            }
            ((DefaultAdapter) this.mBuilder.adapter).notifyDataSetChanged();
            if (z && this.mBuilder.listCallbackMultiChoice != null) {
                sendMultichoiceCallback();
            }
        }
    }

    public void selectAllIndicies() {
        selectAllIndicies(true);
    }

    public void selectAllIndicies(boolean z) {
        ListType listType2 = this.listType;
        if (listType2 == null || listType2 != ListType.MULTI) {
            throw new IllegalStateException("You can only use selectAllIndicies() with multi choice list dialogs.");
        } else if (this.mBuilder.adapter == null || !(this.mBuilder.adapter instanceof DefaultAdapter)) {
            throw new IllegalStateException("You can only use selectAllIndicies() with the default adapter implementation.");
        } else {
            if (this.selectedIndicesList == null) {
                this.selectedIndicesList = new ArrayList();
            }
            for (int i = 0; i < this.mBuilder.adapter.getCount(); i++) {
                if (!this.selectedIndicesList.contains(Integer.valueOf(i))) {
                    this.selectedIndicesList.add(Integer.valueOf(i));
                }
            }
            ((DefaultAdapter) this.mBuilder.adapter).notifyDataSetChanged();
            if (z && this.mBuilder.listCallbackMultiChoice != null) {
                sendMultichoiceCallback();
            }
        }
    }

    public final void onShow(DialogInterface dialogInterface) {
        if (this.input != null) {
            DialogUtils.showKeyboard(this, this.mBuilder);
            if (this.input.getText().length() > 0) {
                EditText editText = this.input;
                editText.setSelection(editText.getText().length());
            }
        }
        super.onShow(dialogInterface);
    }

    /* access modifiers changed from: protected */
    public void setInternalInputCallback() {
        EditText editText = this.input;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    int length = charSequence.toString().length();
                    boolean z = false;
                    if (!MaterialDialog.this.mBuilder.inputAllowEmpty) {
                        if (length == 0) {
                            z = true;
                        }
                        MaterialDialog.this.getActionButton(DialogAction.POSITIVE).setEnabled(!z);
                    }
                    MaterialDialog.this.invalidateInputMinMaxIndicator(length, z);
                    if (MaterialDialog.this.mBuilder.alwaysCallInputCallback) {
                        MaterialDialog.this.mBuilder.inputCallback.onInput(MaterialDialog.this, charSequence);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void invalidateInputMinMaxIndicator(int i, boolean z) {
        if (this.inputMinMax != null) {
            boolean z2 = false;
            if (this.mBuilder.inputMaxLength > 0) {
                this.inputMinMax.setText(String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mBuilder.inputMaxLength)}));
                this.inputMinMax.setVisibility(0);
            } else {
                this.inputMinMax.setVisibility(8);
            }
            if ((z && i == 0) || ((this.mBuilder.inputMaxLength > 0 && i > this.mBuilder.inputMaxLength) || i < this.mBuilder.inputMinLength)) {
                z2 = true;
            }
            Builder builder = this.mBuilder;
            int i2 = z2 ? builder.inputRangeErrorColor : builder.contentColor;
            Builder builder2 = this.mBuilder;
            int i3 = z2 ? builder2.inputRangeErrorColor : builder2.widgetColor;
            if (this.mBuilder.inputMaxLength > 0) {
                this.inputMinMax.setTextColor(i2);
            }
            MDTintHelper.setTint(this.input, i3);
            getActionButton(DialogAction.POSITIVE).setEnabled(!z2);
        }
    }

    public void dismiss() {
        if (this.input != null) {
            DialogUtils.hideKeyboard(this, this.mBuilder);
        }
        super.dismiss();
    }

    /* renamed from: com.afollestad.materialdialogs.MaterialDialog$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$DialogAction;
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.afollestad.materialdialogs.MaterialDialog$ListType[] r0 = com.afollestad.materialdialogs.MaterialDialog.ListType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType = r0
                r1 = 1
                com.afollestad.materialdialogs.MaterialDialog$ListType r2 = com.afollestad.materialdialogs.MaterialDialog.ListType.REGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.afollestad.materialdialogs.MaterialDialog$ListType r3 = com.afollestad.materialdialogs.MaterialDialog.ListType.SINGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.afollestad.materialdialogs.MaterialDialog$ListType r4 = com.afollestad.materialdialogs.MaterialDialog.ListType.MULTI     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.afollestad.materialdialogs.DialogAction[] r3 = com.afollestad.materialdialogs.DialogAction.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$afollestad$materialdialogs$DialogAction = r3
                com.afollestad.materialdialogs.DialogAction r4 = com.afollestad.materialdialogs.DialogAction.NEUTRAL     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$afollestad$materialdialogs$DialogAction     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.afollestad.materialdialogs.DialogAction r3 = com.afollestad.materialdialogs.DialogAction.NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$afollestad$materialdialogs$DialogAction     // Catch:{ NoSuchFieldError -> 0x004d }
                com.afollestad.materialdialogs.DialogAction r1 = com.afollestad.materialdialogs.DialogAction.POSITIVE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.MaterialDialog.AnonymousClass4.<clinit>():void");
        }
    }

    protected enum ListType {
        REGULAR,
        SINGLE,
        MULTI;

        public static int getLayoutForType(ListType listType) {
            int i = AnonymousClass4.$SwitchMap$com$afollestad$materialdialogs$MaterialDialog$ListType[listType.ordinal()];
            if (i == 1) {
                return R.layout.md_listitem;
            }
            if (i == 2) {
                return R.layout.md_listitem_singlechoice;
            }
            if (i == 3) {
                return R.layout.md_listitem_multichoice;
            }
            throw new IllegalArgumentException("Not a valid list type");
        }
    }

    @Deprecated
    public static abstract class ButtonCallback {
        @Deprecated
        public void onAny(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onNegative(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onNeutral(MaterialDialog materialDialog) {
        }

        @Deprecated
        public void onPositive(MaterialDialog materialDialog) {
        }

        /* access modifiers changed from: protected */
        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            super.finalize();
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final String toString() {
            return super.toString();
        }
    }
}
