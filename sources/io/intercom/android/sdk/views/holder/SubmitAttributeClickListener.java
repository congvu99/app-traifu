package io.intercom.android.sdk.views.holder;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.AttributeValidatorUtils;
import io.intercom.android.sdk.views.TextAttributeView;

public class SubmitAttributeClickListener implements View.OnClickListener {
    private final ConversationListener conversationListener;
    private final String partId;
    private final TextAttributeView textAttributeView;

    public SubmitAttributeClickListener(TextAttributeView textAttributeView2, String str, ConversationListener conversationListener2) {
        this.textAttributeView = textAttributeView2;
        this.partId = str;
        this.conversationListener = conversationListener2;
    }

    public void onClick(View view) {
        String inputValue = this.textAttributeView.getInputValue();
        Attribute attribute = this.textAttributeView.getAttribute();
        if (TextUtils.isEmpty(inputValue)) {
            this.textAttributeView.displayErrorState(this.textAttributeView.getContext().getResources().getString(R.string.intercom_string_is_incorrect));
            return;
        }
        int validateAttribute = AttributeValidatorUtils.validateAttribute(inputValue, attribute.getRenderType());
        if (validateAttribute == 0) {
            this.textAttributeView.displayLoadingState();
            this.conversationListener.onSubmitAttribute(this.partId, attribute.getIdentifier(), inputValue, attribute.getType());
            return;
        }
        this.textAttributeView.displayErrorState(getErrorStringFromCode(validateAttribute, this.textAttributeView.getContext().getResources()));
    }

    /* access modifiers changed from: package-private */
    public String getErrorStringFromCode(int i, Resources resources) {
        switch (i) {
            case 1:
                return resources.getString(R.string.intercom_string_is_incorrect);
            case 2:
                return resources.getString(R.string.intercom_that_email_address_doesnt_look_quite_right);
            case 3:
                return resources.getString(R.string.intercom_that_number_doesnt_look_quite_right);
            case 4:
                return resources.getString(R.string.intercom_that_number_needs_a_prefix);
            case 5:
                return resources.getString(R.string.intercom_that_number_has_too_many_digits);
            case 6:
                return resources.getString(R.string.intercom_that_country_code_doesnt_look_quite_right);
            case 7:
                return resources.getString(R.string.intercom_that_number_is_missing_a_few_digits);
            default:
                return "";
        }
    }
}
