package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.views.holder.ConversationListener;
import java.util.List;

public class ListAttributeSelectorDialogBuilder extends AlertDialog.Builder {
    public ListAttributeSelectorDialogBuilder(Context context, String str, Attribute attribute, ConversationListener conversationListener, AttributeInputListener attributeInputListener) {
        super(context);
        setupDialog(attribute, str, conversationListener, attributeInputListener);
    }

    private void setupDialog(Attribute attribute, String str, ConversationListener conversationListener, AttributeInputListener attributeInputListener) {
        final List<String> options = attribute.getOptions();
        final String identifier = attribute.getIdentifier();
        setSingleChoiceItems((CharSequence[]) (String[]) options.toArray(new String[0]), 0, (DialogInterface.OnClickListener) null);
        setTitle((CharSequence) attribute.getName());
        final ConversationListener conversationListener2 = conversationListener;
        final String str2 = str;
        final Attribute attribute2 = attribute;
        final AttributeInputListener attributeInputListener2 = attributeInputListener;
        setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = (String) options.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition());
                conversationListener2.onSubmitAttribute(str2, identifier, str, attribute2.getType());
                attributeInputListener2.populateSelectedValue(str);
            }
        });
        setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        setCancelable(false);
    }
}
