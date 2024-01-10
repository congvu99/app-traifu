package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.views.holder.ConversationListener;

public class BooleanAttributeView extends BaseAttributeView {
    final TextView no;
    final TextView yes;

    public BooleanAttributeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BooleanAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yes = (TextView) findViewById(R.id.yes);
        this.no = (TextView) findViewById(R.id.no);
    }

    public int getLayoutRes() {
        return R.layout.intercom_view_boolean_attribute;
    }

    public void displayErrorState(String str) {
        setError(str);
    }

    public void displayEmptyState() {
        ColorStateList colorStateList = ContextCompat.getColorStateList(getContext(), R.color.intercom_boolean_attribute_selected_text_selector);
        this.yes.setTextColor(colorStateList);
        this.no.setTextColor(colorStateList);
        int color = ContextCompat.getColor(getContext(), R.color.intercom_white);
        int color2 = ContextCompat.getColor(getContext(), R.color.intercom_attribute_input_outline);
        BackgroundUtils.setRippleButtonBackgroundColor(this.yes.getBackground(), R.id.background, color);
        BackgroundUtils.setRippleButtonBackgroundColor(this.no.getBackground(), R.id.background, color);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.yes.getBackground(), R.id.background, color2);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.no.getBackground(), R.id.background, color2);
        this.yes.setAlpha(1.0f);
        this.no.setAlpha(1.0f);
        this.yes.setEnabled(true);
        this.no.setEnabled(true);
    }

    public void updateAttributeContent(Attribute attribute) {
        setAttribute(attribute);
        if (attribute.hasValue()) {
            showSelectedState(attribute.getValue().equals(Boolean.TRUE.toString()));
        } else {
            displayEmptyState();
        }
    }

    /* access modifiers changed from: private */
    public void showSelectedState(boolean z) {
        ColorStateList colorStateList = ContextCompat.getColorStateList(getContext(), R.color.intercom_boolean_attribute_selected_text_selector);
        ColorStateList colorStateList2 = ContextCompat.getColorStateList(getContext(), R.color.intercom_boolean_attribute_nonselected_text_selector);
        int color = ContextCompat.getColor(getContext(), R.color.intercom_attribute_selected_background);
        int color2 = ContextCompat.getColor(getContext(), R.color.intercom_white);
        int color3 = ContextCompat.getColor(getContext(), R.color.intercom_attribute_input_outline);
        this.yes.setTextColor(z ? colorStateList : colorStateList2);
        TextView textView = this.no;
        if (z) {
            colorStateList = colorStateList2;
        }
        textView.setTextColor(colorStateList);
        float f = 1.0f;
        this.yes.setAlpha(z ? 1.0f : 0.5f);
        TextView textView2 = this.no;
        if (z) {
            f = 0.5f;
        }
        textView2.setAlpha(f);
        BackgroundUtils.setRippleButtonBackgroundColor(this.yes.getBackground(), R.id.background, z ? color : color2);
        Drawable background = this.no.getBackground();
        int i = R.id.background;
        if (z) {
            color = color2;
        }
        BackgroundUtils.setRippleButtonBackgroundColor(background, i, color);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.yes.getBackground(), R.id.background, color3);
        BackgroundUtils.setRippleButtonStroke(getContext(), this.no.getBackground(), R.id.background, color3);
        this.yes.setEnabled(false);
        this.no.setEnabled(false);
    }

    public void setOnSubmitClickListener(final String str, final ConversationListener conversationListener) {
        this.yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BooleanAttributeView.this.showSelectedState(true);
                Attribute attribute = BooleanAttributeView.this.getAttribute();
                conversationListener.onSubmitAttribute(str, attribute.getIdentifier(), true, attribute.getType());
            }
        });
        this.no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BooleanAttributeView.this.showSelectedState(false);
                Attribute attribute = BooleanAttributeView.this.getAttribute();
                conversationListener.onSubmitAttribute(str, attribute.getIdentifier(), false, attribute.getType());
            }
        });
    }
}
