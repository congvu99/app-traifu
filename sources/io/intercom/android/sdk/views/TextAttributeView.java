package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.CountryAreaCode;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.PhoneNumberValidator;
import io.intercom.android.sdk.views.holder.AttributeType;
import io.intercom.android.sdk.views.holder.ConversationListener;
import io.intercom.android.sdk.views.holder.SubmitAttributeClickListener;
import java.util.Locale;
import net.hockeyapp.android.views.FeedbackMessageView;

public class TextAttributeView extends BaseAttributeView {
    private static final int PHONE_INPUT_INSET_DP = 46;
    private static final String SAMPLE_NUMBER = " 123 456 7890";
    EditText attributeValueInput;
    final TextView flagView;
    final ProgressBar loadingView;
    ImageView submitButton;
    final ImageView verifiedTick;

    public TextAttributeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flagView = (TextView) findViewById(R.id.flag_view);
        this.attributeValueInput = (EditText) findViewById(R.id.attribute_input);
        this.submitButton = (ImageView) findViewById(R.id.attribute_submit);
        this.verifiedTick = (ImageView) findViewById(R.id.attribute_verified_tick);
        this.loadingView = (ProgressBar) findViewById(R.id.loading_view);
    }

    public int getLayoutRes() {
        return R.layout.intercom_view_text_attribute;
    }

    public void setOnSubmitClickListener(String str, ConversationListener conversationListener) {
        this.submitButton.setOnClickListener(new SubmitAttributeClickListener(this, str, conversationListener));
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.attributeValueInput.setOnFocusChangeListener(onFocusChangeListener);
    }

    public String getInputValue() {
        return this.attributeValueInput.getText().toString().trim();
    }

    public void setUpAttribute(Attribute attribute, Locale locale) {
        setAttribute(attribute);
        this.attributeValueInput.setInputType(1);
        this.attributeValueInput.setHint((CharSequence) null);
        this.attributeValueInput.setText("");
        if ("email".equals(attribute.getRenderType())) {
            setUpEmailAttribute();
        } else if ("phone".equals(attribute.getRenderType())) {
            setUpPhoneAttribute(locale);
        } else if (AttributeType.NUMBER.equals(attribute.getRenderType())) {
            setUpNumberAttribute();
        } else if ("float".equals(attribute.getRenderType())) {
            setUpFloatAttribute();
        }
        updateAttributeContent();
    }

    private void updateAttributeContent() {
        if (getAttribute().hasValue()) {
            displayVerifiedState();
        } else {
            displayEmptyState();
        }
    }

    public void updateSubmitButtonColor(AppConfig appConfig) {
        int primaryColor = appConfig.getPrimaryColor();
        boolean z = false;
        if (ColorUtils.isColorLight(primaryColor)) {
            if (appConfig.getConfigModules().getCustomization() != null) {
                primaryColor = Color.parseColor(appConfig.getConfigModules().getCustomization().getActionContrastWhite().getBackgroundColor());
                z = true;
            } else {
                primaryColor = ViewCompat.MEASURED_STATE_MASK;
            }
        }
        this.submitButton.getBackground().setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
        ColorUtils.setImageSrcColorWhiteOrDark(this.submitButton, z);
    }

    public void displayLoadingState() {
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        this.loadingView.setVisibility(0);
        this.submitButton.setImageDrawable((Drawable) null);
        hideErrorView();
    }

    public void displayErrorState(String str) {
        updateTextInputStrokeColor(R.color.intercom_attribute_collector_error);
        setError(str);
        this.submitButton.setImageResource(R.drawable.intercom_attribute_submit_arrow);
        this.loadingView.setVisibility(8);
    }

    public void displayEmptyState() {
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        this.attributeValueInput.setEnabled(true);
        this.submitButton.setImageResource(R.drawable.intercom_attribute_submit_arrow);
        this.submitButton.setVisibility(0);
        this.verifiedTick.setVisibility(8);
        hideErrorView();
    }

    private void displayVerifiedState() {
        this.attributeValueInput.setText(getAttribute().getValue());
        this.attributeValueInput.setEnabled(false);
        this.attributeValueInput.setKeyListener((KeyListener) null);
        this.submitButton.setVisibility(8);
        this.verifiedTick.setVisibility(0);
        this.loadingView.setVisibility(8);
        updateTextInputStrokeColor(R.color.intercom_attribute_input_outline);
        hideErrorView();
    }

    private void updateTextInputStrokeColor(int i) {
        Context context = this.attributeValueInput.getContext();
        ((GradientDrawable) this.attributeValueInput.getBackground()).setStroke(ScreenUtils.dpToPx(1.0f, context), ContextCompat.getColor(context, i));
    }

    private void setUpEmailAttribute() {
        this.attributeValueInput.setInputType(32);
        this.attributeValueInput.setHint("email@domain.com");
    }

    private void setUpNumberAttribute() {
        this.attributeValueInput.setInputType(4098);
    }

    private void setUpFloatAttribute() {
        this.attributeValueInput.setInputType(FeedbackMessageView.DATE_TEXT_VIEW_ID);
    }

    private void setUpPhoneAttribute(Locale locale) {
        this.attributeValueInput.setInputType(3);
        PhoneNumberValidator.loadCountryAreaCodes(getContext());
        CountryAreaCode countryAreaCodeFromLocale = PhoneNumberValidator.getCountryAreaCodeFromLocale(locale.getCountry());
        if (countryAreaCodeFromLocale.equals(CountryAreaCode.UNKNOWN)) {
            this.attributeValueInput.setHint("+1 123 456 7890");
        } else {
            String str = "+" + countryAreaCodeFromLocale.getDialCode();
            this.attributeValueInput.setHint(str + SAMPLE_NUMBER);
            this.attributeValueInput.setText(str);
        }
        updateFlag(countryAreaCodeFromLocale);
    }

    private void updateFlag(CountryAreaCode countryAreaCode) {
        this.flagView.setVisibility(0);
        this.flagView.setText(countryAreaCode.getEmoji());
        this.attributeValueInput.setPadding(ScreenUtils.dpToPx(46.0f, getContext()), this.attributeValueInput.getPaddingTop(), this.attributeValueInput.getPaddingRight(), this.attributeValueInput.getPaddingBottom());
        this.attributeValueInput.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                TextAttributeView.this.flagView.setText(PhoneNumberValidator.getCountryAreaCodeFromNumber(PhoneNumberValidator.stripPrefix(PhoneNumberValidator.normalizeNumber(editable.toString()))).getEmoji());
            }
        });
    }
}
