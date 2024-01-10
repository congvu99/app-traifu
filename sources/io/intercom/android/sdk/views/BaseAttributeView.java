package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeMetadata;
import io.intercom.android.sdk.models.Attribute;

public abstract class BaseAttributeView extends LinearLayout {
    private Attribute attribute;
    protected final TextView attributeErrorView;
    protected final TextView attributeNameView;
    public final TextView attributePositionLabel;
    private AttributeMetadata metadata;

    public abstract void displayEmptyState();

    public abstract void displayErrorState(String str);

    public abstract int getLayoutRes();

    public BaseAttributeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BaseAttributeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.attribute = Attribute.NULL;
        this.metadata = AttributeMetadata.SINGLE_ATTRIBUTE_METADATA;
        inflate(getContext(), getLayoutRes(), this);
        this.attributeNameView = (TextView) findViewById(R.id.attribute_name);
        this.attributeErrorView = (TextView) findViewById(R.id.error_text);
        this.attributePositionLabel = (TextView) findViewById(R.id.multi_attribute_label);
    }

    public void setMetadata(AttributeMetadata attributeMetadata) {
        this.metadata = attributeMetadata;
    }

    public AttributeMetadata getMetadata() {
        return this.metadata;
    }

    public void showLabel(int i) {
        this.attributePositionLabel.setVisibility(0);
        TextView textView = this.attributePositionLabel;
        textView.setText("(" + i + " / " + this.metadata.getTotalCount() + ")");
    }

    /* access modifiers changed from: protected */
    public void setAttribute(Attribute attribute2) {
        this.attribute = attribute2;
        String name = attribute2.getName();
        int position = this.metadata.getPosition() + 1;
        if (this.metadata.getTotalCount() > 1) {
            TextView textView = this.attributeNameView;
            textView.setText(position + ". " + name);
            return;
        }
        this.attributeNameView.setText(name);
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    /* access modifiers changed from: protected */
    public void setError(String str) {
        this.attributeErrorView.setText(str);
        this.attributeErrorView.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void hideErrorView() {
        this.attributeErrorView.setVisibility(8);
    }
}
