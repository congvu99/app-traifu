package com.intercom.composer;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.intercom.composer.animation.AnimationStatus;
import com.intercom.composer.animation.EditTextLayoutAnimator;
import com.intercom.composer.animation.EditTextLayoutAnimatorInternalListener;
import com.intercom.composer.animation.HideSendButtonAnimatorListener;
import com.intercom.composer.animation.SendButtonAnimator;
import com.intercom.composer.animation.ShowSendButtonAnimatorListener;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.iconbar.InputClickedListener;
import com.intercom.composer.input.iconbar.InputIconRecyclerDecoration;
import com.intercom.composer.input.iconbar.InputIconsRecyclerAdapter;
import com.intercom.composer.input.iconbar.InputSelectedListener;
import com.intercom.composer.input.text.TextInput;
import com.intercom.composer.input.text.listener.OnSendButtonClickedListener;
import com.intercom.composer.input.text.listener.SendButtonClickListener;
import com.intercom.composer.input.text.options.InputOptionImageViewClickListener;
import com.intercom.composer.input.text.options.TextInputOption;
import com.intercom.composer.keyboard.KeyboardHelper;
import com.intercom.composer.keyboard.OrientationProvider;
import com.intercom.composer.pager.ComposerPagerAdapter;
import com.intercom.composer.watcher.OnSendButtonStateChangedListener;
import com.intercom.composer.watcher.SendButtonTextWatcher;
import java.util.ArrayList;
import java.util.List;

public class ComposerView extends LinearLayout implements OnSendButtonStateChangedListener, OnSendButtonClickedListener, InputSelectedListener, InputClickedListener, ComposerAnimationStateListener {
    View composerLowerBorder;
    View composerUpperBorder;
    LinearLayout editTextLayout;
    EditTextLayoutAnimator editTextLayoutAnimator;
    InputIconsRecyclerAdapter inputIconsRecyclerAdapter;
    RecyclerView inputIconsRecyclerView;
    OnInputSelectedListener inputSelectedListener;
    private final List<Input> inputs;
    KeyboardHelper keyboardHelper;
    private final LinearLayoutManager layoutManager;
    private OnSendButtonClickedListener onSendButtonClickListener;
    private final OrientationProvider orientationProvider;
    ImageView sendButton;
    AnimationStatus sendButtonAnimationStatus;
    SendButtonAnimator sendButtonAnimator;
    View sendButtonFadingBackground;
    final SendButtonTextWatcher sendButtonTextWatcher;
    ViewPager viewPager;

    public ComposerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inputs = new ArrayList();
        this.sendButtonAnimationStatus = AnimationStatus.UNKNOWN;
        setOrientation(1);
        inflate(context, R.layout.intercom_composer_view_layout, this);
        this.composerUpperBorder = findViewById(R.id.composer_upper_border);
        this.composerLowerBorder = findViewById(R.id.composer_lower_border);
        this.editTextLayout = (LinearLayout) findViewById(R.id.composer_edit_text_layout);
        this.inputIconsRecyclerView = (RecyclerView) findViewById(R.id.composer_input_icons_recycler_view);
        this.viewPager = (ViewPager) findViewById(R.id.composer_view_pager);
        this.sendButton = (ImageView) findViewById(R.id.send_button);
        this.sendButtonFadingBackground = findViewById(R.id.send_button_fading_background);
        OrientationProvider orientationProvider2 = new OrientationProvider(context);
        this.orientationProvider = orientationProvider2;
        this.keyboardHelper = new KeyboardHelper((Activity) context, orientationProvider2, this.editTextLayout, this.viewPager);
        this.editTextLayoutAnimator = new EditTextLayoutAnimator(this.editTextLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.layoutManager = linearLayoutManager;
        this.inputIconsRecyclerView.setLayoutManager(linearLayoutManager);
        this.inputIconsRecyclerView.addItemDecoration(new InputIconRecyclerDecoration(context));
        this.sendButtonTextWatcher = new SendButtonTextWatcher(this);
    }

    /* access modifiers changed from: package-private */
    public void applyTheme(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.intercom_composer_send_background);
        drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        this.sendButton.setBackground(drawable);
    }

    public void onInputClicked(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition >= 0 && adapterPosition < this.inputs.size()) {
            selectInput(this.inputs.get(adapterPosition), true, true);
        }
    }

    public void onInputSelected(Input input, int i, boolean z, boolean z2) {
        if (input instanceof TextInput) {
            EditText replaceEditText = replaceEditText((TextInput) input);
            this.editTextLayoutAnimator.showEditText(z2);
            if (z) {
                showKeyboard(replaceEditText);
            }
            animateSendButtonVisibility(!TextUtils.isEmpty(replaceEditText.getText()));
        } else {
            this.keyboardHelper.showBehindKeyboardView();
            this.editTextLayout.clearFocus();
            this.editTextLayoutAnimator.hideEditText();
            animateSendButtonVisibility(false);
        }
        updateColors(input.getBackgroundColor(), input.getBorderColor());
        this.viewPager.setCurrentItem(i, false);
    }

    public void onAnimationStateChanged(AnimationStatus animationStatus) {
        this.sendButtonAnimationStatus = animationStatus;
    }

    public void setSendButtonVisibility(int i) {
        this.sendButton.setVisibility(i);
    }

    public void animateSendButtonVisibility(boolean z) {
        SendButtonAnimator sendButtonAnimator2 = this.sendButtonAnimator;
        if (sendButtonAnimator2 != null) {
            sendButtonAnimator2.animateButtonVisibility(z, this.sendButtonAnimationStatus);
        }
    }

    public void onSendButtonClicked(CharSequence charSequence) {
        OnSendButtonClickedListener onSendButtonClickedListener = this.onSendButtonClickListener;
        if (onSendButtonClickedListener != null) {
            onSendButtonClickedListener.onSendButtonClicked(charSequence);
        }
    }

    public void setOnSendButtonClickListener(OnSendButtonClickedListener onSendButtonClickedListener) {
        this.onSendButtonClickListener = onSendButtonClickedListener;
    }

    public void setInputSelectedListener(OnInputSelectedListener onInputSelectedListener) {
        this.inputSelectedListener = onInputSelectedListener;
    }

    public void setEditTextLayoutAnimationListener(EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorInternalListener) {
        this.editTextLayoutAnimator.setEditTextLayoutAnimatorListener(editTextLayoutAnimatorInternalListener);
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        InputIconsRecyclerAdapter inputIconsRecyclerAdapter2 = new InputIconsRecyclerAdapter(LayoutInflater.from(getContext()), this.inputs, this, this, fragmentManager);
        this.inputIconsRecyclerAdapter = inputIconsRecyclerAdapter2;
        this.inputIconsRecyclerView.setAdapter(inputIconsRecyclerAdapter2);
    }

    public void setComposerPagerAdapter(ComposerPagerAdapter composerPagerAdapter) {
        this.viewPager.setAdapter(composerPagerAdapter);
        this.viewPager.setOffscreenPageLimit(this.inputs.size());
        this.sendButtonAnimator = new SendButtonAnimator(this.sendButtonFadingBackground, this.sendButton, new ShowSendButtonAnimatorListener(this.inputs, composerPagerAdapter, this.inputIconsRecyclerAdapter, this.layoutManager, this), new HideSendButtonAnimatorListener(this.inputs, composerPagerAdapter, this.inputIconsRecyclerAdapter, this));
    }

    public void setInputs(List<? extends Input> list) {
        if (this.inputIconsRecyclerAdapter != null) {
            this.inputs.clear();
            this.inputs.addAll(list);
            setupTextInputs();
            this.inputIconsRecyclerAdapter.notifyDataSetChanged();
            return;
        }
        throw new IllegalStateException("Fragment manager should be set!");
    }

    public void updateColors(int i, int i2) {
        this.editTextLayout.setBackgroundResource(i);
        this.inputIconsRecyclerView.setBackgroundResource(i);
        this.sendButtonFadingBackground.setBackgroundResource(i);
        this.composerUpperBorder.setBackgroundResource(i2);
        this.composerLowerBorder.setBackgroundResource(i2);
    }

    public boolean selectInput(Input input, boolean z, boolean z2) {
        OnInputSelectedListener onInputSelectedListener = this.inputSelectedListener;
        if (onInputSelectedListener != null) {
            onInputSelectedListener.onInputSelected(input);
        }
        return this.inputIconsRecyclerAdapter.selectInput(input, z, z2);
    }

    public boolean onBackPressed() {
        Input selectedInput = getSelectedInput();
        if (selectedInput == null || selectedInput.equals(this.inputs.get(0))) {
            this.inputIconsRecyclerAdapter.deselectAllInputs();
        } else {
            selectInput(this.inputs.get(0), false, false);
        }
        return this.keyboardHelper.hideBehindKeyboardView();
    }

    public void onDestroy() {
        removeTextWatcher();
        this.keyboardHelper.onDestroy();
    }

    /* access modifiers changed from: package-private */
    public void removeTextWatcher() {
        int childCount = this.editTextLayout.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.editTextLayout.getChildAt(i);
                if (childAt instanceof EditText) {
                    ((EditText) childAt).removeTextChangedListener(this.sendButtonTextWatcher);
                }
            }
        }
    }

    private void setupTextInputs() {
        if (editTextNeededBySomeInput()) {
            this.editTextLayout.setVisibility(0);
            this.sendButton.setVisibility(0);
            this.sendButtonFadingBackground.setVisibility(0);
            return;
        }
        this.editTextLayout.setVisibility(8);
        this.sendButton.setVisibility(8);
        this.sendButtonFadingBackground.setVisibility(8);
    }

    private boolean editTextNeededBySomeInput() {
        for (Input input : this.inputs) {
            if (input instanceof TextInput) {
                return true;
            }
        }
        return false;
    }

    private void showKeyboard(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) editText.getContext().getSystemService("input_method")).showSoftInput(editText, 0);
        if (editText.getContext().getResources().getBoolean(R.bool.intercom_composer_keyboard_takes_full_screen_in_landscape) && this.orientationProvider.getOrientation() == 2) {
            this.keyboardHelper.hideBehindKeyboardView();
        }
    }

    /* access modifiers changed from: package-private */
    public EditText replaceEditText(TextInput textInput) {
        EditText editText = textInput.getEditText();
        List<TextInputOption> options = textInput.getOptions();
        this.editTextLayout.removeAllViews();
        removeViewFromParent(editText);
        this.editTextLayout.addView(editText, new LinearLayout.LayoutParams(0, -2, 1.0f));
        this.sendButton.setOnClickListener(new SendButtonClickListener(this, editText));
        editText.addTextChangedListener(this.sendButtonTextWatcher);
        animateSendButtonVisibility(!TextUtils.isEmpty(editText.getText()));
        if (options != null) {
            for (TextInputOption next : options) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.intercom_composer_editable_text_input_option_padding);
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.intercom_composer_editable_text_input_option_padding_bottom);
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(next.getResourceId());
                imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
                imageView.setOnClickListener(new InputOptionImageViewClickListener(next));
                this.editTextLayout.addView(imageView);
            }
        }
        return editText;
    }

    private void removeViewFromParent(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public Input getSelectedInput() {
        return this.inputIconsRecyclerAdapter.getSelectedInput();
    }

    public int getTextInputHeight() {
        return this.editTextLayout.getHeight();
    }

    public List<Input> getInputs() {
        return this.inputs;
    }

    public void hideAllInputsExcept(List<String> list) {
        this.inputIconsRecyclerAdapter.hideAllInputsExcept(list);
    }

    public void showAllInputs() {
        this.inputIconsRecyclerAdapter.showAllInputs();
    }
}
