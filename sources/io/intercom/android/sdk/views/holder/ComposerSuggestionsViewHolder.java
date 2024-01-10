package io.intercom.android.sdk.views.holder;

import android.content.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.PartMetadataFormatter;

public class ComposerSuggestionsViewHolder extends PartViewHolder {
    public ComposerSuggestionsViewHolder(View view, int i, ConversationListener conversationListener, ClipboardManager clipboardManager, PartMetadataFormatter partMetadataFormatter, Provider<AppConfig> provider, MetricTracker metricTracker) {
        super(view, i, conversationListener, clipboardManager, partMetadataFormatter, provider, metricTracker);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        TextView textView = (TextView) this.itemView.findViewById(R.id.prompt_text);
        textView.setText(part.getComposerSuggestions().getPrompt());
        FlexboxLayout flexboxLayout = (FlexboxLayout) this.itemView.findViewById(R.id.quick_reply_layout);
        if (flexboxLayout != null) {
            addComposerSuggestions(part, textView, flexboxLayout);
        }
    }
}
