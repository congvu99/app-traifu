package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.attribute.AttributeMetadata;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.AttributeCollectorCardView;
import io.intercom.android.sdk.views.BaseAttributeView;
import java.util.List;
import java.util.Locale;

public class AttributeCollectorViewHolder extends BlocksPartViewHolder implements ConversationPartViewHolder {
    private final Provider<AppConfig> appConfigProvider;
    private final ConversationListener conversationListener;
    private final View.OnFocusChangeListener inputFocusChangeListener = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (z) {
                AttributeCollectorViewHolder.this.expandAttributeCard();
            }
        }
    };
    private final Locale locale;

    public void onClick(View view) {
    }

    public /* bridge */ /* synthetic */ boolean onLongClick(View view) {
        return super.onLongClick(view);
    }

    public AttributeCollectorViewHolder(View view, Provider<AppConfig> provider, ConversationListener conversationListener2, Locale locale2) {
        super(view, conversationListener2);
        this.conversationListener = conversationListener2;
        this.appConfigProvider = provider;
        this.locale = locale2;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cellLayout.getLayoutParams();
        int dimensionPixelSize = this.cellLayout.getContext().getResources().getDimensionPixelSize(R.dimen.intercom_attribute_part_left_margin);
        MarginLayoutParamsCompat.setMarginStart(layoutParams, dimensionPixelSize);
        MarginLayoutParamsCompat.setMarginEnd(layoutParams, dimensionPixelSize);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        if (this.networkAvatar != null) {
            showAvatar(part.getParticipant(), this.networkAvatar, this.appConfigProvider.get());
            updateAvatarMarginForCard(part);
        }
        renderAttributes(viewGroup, part.getForm().getAttributes(), part.getId());
        if (this.cellLayout.getChildCount() > 0) {
            this.cellLayout.removeAllViews();
        }
        if (viewGroup.getParent() != null) {
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        }
        this.cellLayout.addView(viewGroup);
    }

    /* access modifiers changed from: package-private */
    public void renderAttributes(ViewGroup viewGroup, List<Attribute> list, String str) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            Attribute attribute = list.get(i);
            addAttributeView(viewGroup, attribute, new AttributeMetadata.Builder().withPosition(i).withTotalCount(size).build(), str);
            if (size <= 1 || attribute.hasValue()) {
                i++;
            } else {
                updateMultiAttributesLabel(viewGroup);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateMultiAttributesLabel(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        if (childCount > 0) {
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof BaseAttributeView) {
                ((BaseAttributeView) childAt).showLabel(childCount);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addAttributeView(android.view.ViewGroup r4, io.intercom.android.sdk.models.Attribute r5, io.intercom.android.sdk.conversation.attribute.AttributeMetadata r6, java.lang.String r7) {
        /*
            r3 = this;
            android.content.Context r0 = r4.getContext()
            java.lang.String r1 = r5.getRenderType()
            int r2 = r1.hashCode()
            switch(r2) {
                case -1034364087: goto L_0x0061;
                case 3076014: goto L_0x0056;
                case 3322014: goto L_0x004c;
                case 3556653: goto L_0x0042;
                case 64711720: goto L_0x0038;
                case 75849770: goto L_0x002e;
                case 96619420: goto L_0x0024;
                case 97526364: goto L_0x001a;
                case 106642798: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x006b
        L_0x0010:
            java.lang.String r2 = "phone"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 5
            goto L_0x006c
        L_0x001a:
            java.lang.String r2 = "float"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 4
            goto L_0x006c
        L_0x0024:
            java.lang.String r2 = "email"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 1
            goto L_0x006c
        L_0x002e:
            java.lang.String r2 = "company.website"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 2
            goto L_0x006c
        L_0x0038:
            java.lang.String r2 = "boolean"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 6
            goto L_0x006c
        L_0x0042:
            java.lang.String r2 = "text"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 0
            goto L_0x006c
        L_0x004c:
            java.lang.String r2 = "list"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 7
            goto L_0x006c
        L_0x0056:
            java.lang.String r2 = "date"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 8
            goto L_0x006c
        L_0x0061:
            java.lang.String r2 = "number"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x006b
            r1 = 3
            goto L_0x006c
        L_0x006b:
            r1 = -1
        L_0x006c:
            switch(r1) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x00ac;
                case 2: goto L_0x00ac;
                case 3: goto L_0x00ac;
                case 4: goto L_0x00ac;
                case 5: goto L_0x00ac;
                case 6: goto L_0x0098;
                case 7: goto L_0x0084;
                case 8: goto L_0x0070;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x00d1
        L_0x0070:
            io.intercom.android.sdk.views.DateAttributeView r1 = new io.intercom.android.sdk.views.DateAttributeView
            r1.<init>(r0)
            r1.setMetadata(r6)
            r1.updateAttributeContent(r5)
            io.intercom.android.sdk.views.holder.ConversationListener r5 = r3.conversationListener
            r1.setOnClickListener(r7, r5)
            r4.addView(r1)
            goto L_0x00d1
        L_0x0084:
            io.intercom.android.sdk.views.ListAttributeView r1 = new io.intercom.android.sdk.views.ListAttributeView
            r1.<init>(r0)
            r1.setMetadata(r6)
            r1.updateAttributeContent(r5)
            io.intercom.android.sdk.views.holder.ConversationListener r5 = r3.conversationListener
            r1.setOnClickListener(r7, r5)
            r4.addView(r1)
            goto L_0x00d1
        L_0x0098:
            io.intercom.android.sdk.views.BooleanAttributeView r1 = new io.intercom.android.sdk.views.BooleanAttributeView
            r1.<init>(r0)
            r1.setMetadata(r6)
            r1.updateAttributeContent(r5)
            io.intercom.android.sdk.views.holder.ConversationListener r5 = r3.conversationListener
            r1.setOnSubmitClickListener(r7, r5)
            r4.addView(r1)
            goto L_0x00d1
        L_0x00ac:
            io.intercom.android.sdk.views.TextAttributeView r1 = new io.intercom.android.sdk.views.TextAttributeView
            r1.<init>(r0)
            r1.setMetadata(r6)
            io.intercom.android.sdk.Provider<io.intercom.android.sdk.identity.AppConfig> r6 = r3.appConfigProvider
            java.lang.Object r6 = r6.get()
            io.intercom.android.sdk.identity.AppConfig r6 = (io.intercom.android.sdk.identity.AppConfig) r6
            r1.updateSubmitButtonColor(r6)
            io.intercom.android.sdk.views.holder.ConversationListener r6 = r3.conversationListener
            r1.setOnSubmitClickListener(r7, r6)
            java.util.Locale r6 = r3.locale
            r1.setUpAttribute(r5, r6)
            android.view.View$OnFocusChangeListener r5 = r3.inputFocusChangeListener
            r1.setOnFocusChangeListener(r5)
            r4.addView(r1)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.holder.AttributeCollectorViewHolder.addAttributeView(android.view.ViewGroup, io.intercom.android.sdk.models.Attribute, io.intercom.android.sdk.conversation.attribute.AttributeMetadata, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void expandAttributeCard() {
        if (this.cellLayout instanceof AttributeCollectorCardView) {
            ((AttributeCollectorCardView) this.cellLayout).animateToExpand();
            this.networkAvatar.setVisibility(8);
        }
    }
}
