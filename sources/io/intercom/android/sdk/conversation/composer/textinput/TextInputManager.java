package io.intercom.android.sdk.conversation.composer.textinput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;
import com.intercom.composer.input.text.SendTextCallback;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.conversation.composer.ComposerInputIndentifier;
import io.intercom.android.sdk.conversation.composer.ComposerPresenter;
import io.intercom.android.sdk.conversation.composer.InputDrawableManager;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricsComposerTextWatcher;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;

public class TextInputManager {
    private final EditText composerText;
    private final Context context;
    private String conversationId;
    private String initialMessage;
    private final ComposerPresenter.Listener listener;
    private final MetricsComposerTextWatcher metricsTextWatcher;
    private final Store<State> store;
    private final Drawable textIcon;
    private final TextInputWatcher textWatcher;

    public TextInputManager(Context context2, LayoutInflater layoutInflater, UserIdentity userIdentity, NexusClient nexusClient, MetricTracker metricTracker, String str, String str2, InputDrawableManager inputDrawableManager, Store<State> store2, ComposerPresenter.Listener listener2, String str3) {
        this.context = context2;
        this.listener = listener2;
        this.conversationId = str;
        this.initialMessage = str2;
        this.store = store2;
        this.textIcon = inputDrawableManager.createDrawable(context2, R.drawable.intercom_input_text);
        this.composerText = (EditText) layoutInflater.inflate(R.layout.intercom_composer_edit_text, (ViewGroup) null);
        this.textWatcher = new TextInputWatcher(userIdentity.getIntercomId(), nexusClient, store2, new Handler(Looper.getMainLooper()));
        MetricsComposerTextWatcher metricsComposerTextWatcher = new MetricsComposerTextWatcher(metricTracker, str3);
        this.metricsTextWatcher = metricsComposerTextWatcher;
        metricsComposerTextWatcher.setConversationId(str);
        this.composerText.addTextChangedListener(this.textWatcher);
        this.composerText.addTextChangedListener(this.metricsTextWatcher);
    }

    public void setConversationId(String str) {
        this.textWatcher.setConversationId(str);
        this.metricsTextWatcher.setConversationId(str);
    }

    public void setHint(int i) {
        this.composerText.setHint(i);
    }

    public void requestFocus() {
        this.composerText.requestFocus();
    }

    public void clearFocus() {
        this.composerText.clearFocus();
    }

    public Input createInput() {
        String str;
        if (TextUtils.isEmpty(this.conversationId)) {
            str = this.context.getResources().getString(R.string.intercom_start_conversation);
        } else {
            str = this.context.getResources().getString(R.string.intercom_reply_to_conversation);
        }
        return new MessengerTextInput(ComposerInputIndentifier.TEXT, new IconProvider() {
            public final Drawable getIconDrawable(String str, Context context) {
                return TextInputManager.this.lambda$createInput$0$TextInputManager(str, context);
            }
        }, str, Integer.valueOf(this.context.getResources().getColor(R.color.intercom_accessibility_grey)), this.initialMessage, new SendTextCallback() {
            public final void textToBeSent(Input input, CharSequence charSequence) {
                TextInputManager.this.lambda$createInput$1$TextInputManager(input, charSequence);
            }
        }, this.composerText);
    }

    public /* synthetic */ Drawable lambda$createInput$0$TextInputManager(String str, Context context2) {
        return this.textIcon;
    }

    public /* synthetic */ void lambda$createInput$1$TextInputManager(Input input, CharSequence charSequence) {
        this.listener.onSendButtonPressed(charSequence);
        this.store.dispatch(Actions.composerSendButtonPressed());
    }

    public void updateMaxLines() {
        this.composerText.setMaxLines(this.context.getResources().getInteger(R.integer.intercom_max_composer_lines));
    }

    public void cleanup() {
        this.store.dispatch(Actions.composerCleared(this.conversationId));
        this.composerText.removeTextChangedListener(this.textWatcher);
        this.composerText.removeTextChangedListener(this.metricsTextWatcher);
        this.composerText.clearFocus();
        this.metricsTextWatcher.reset();
    }
}
