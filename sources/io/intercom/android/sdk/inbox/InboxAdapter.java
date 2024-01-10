package io.intercom.android.sdk.inbox;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.InboxRowLayout;
import java.util.Locale;

class InboxAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static final int CONVERSATION = 0;
    static final int LOADING = 1;
    private final Provider<AppConfig> appConfigProvider;
    private final ConversationClickListener conversationClickListener;
    private InboxState inboxState;
    private final LayoutInflater inflater;
    private final Store<State> store;
    private final TimeFormatter timeFormatter;
    private UserIdentity userIdentity;

    InboxAdapter(LayoutInflater layoutInflater, ConversationClickListener conversationClickListener2, Store<State> store2, TimeFormatter timeFormatter2, Provider<AppConfig> provider, UserIdentity userIdentity2) {
        this.inflater = layoutInflater;
        this.conversationClickListener = conversationClickListener2;
        this.store = store2;
        this.timeFormatter = timeFormatter2;
        this.appConfigProvider = provider;
        this.userIdentity = userIdentity2;
        setHasStableIds(true);
    }

    /* access modifiers changed from: package-private */
    public void setInboxState(InboxState inboxState2) {
        this.inboxState = inboxState2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            InboxRowLayout inboxRowLayout = new InboxRowLayout(viewGroup.getContext());
            inboxRowLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return new InboxRowViewHolder(inboxRowLayout, this.conversationClickListener, this.timeFormatter);
        } else if (i == 1) {
            return new LoadingViewHolder(this.inflater.inflate(R.layout.intercom_row_loading, viewGroup, false));
        } else {
            throw new RuntimeException(String.format(Locale.getDefault(), "View type %d not supported", new Object[]{Integer.valueOf(i)}));
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof InboxRowViewHolder) {
            ((InboxRowViewHolder) viewHolder).bindData(this.inboxState.conversations().get(i), this.userIdentity, this.appConfigProvider.get(), (TeamPresence) this.store.select(Selectors.TEAM_PRESENCE));
        }
    }

    public int getItemCount() {
        return conversationCount() + (this.inboxState.status() == InboxState.Status.LOADING ? 1 : 0);
    }

    public int getItemViewType(int i) {
        return i == conversationCount() ? 1 : 0;
    }

    public long getItemId(int i) {
        if (i == conversationCount()) {
            return -1;
        }
        String id = this.inboxState.conversations().get(i).getId();
        if (TextUtils.isEmpty(id) || !TextUtils.isDigitsOnly(id)) {
            return (long) id.hashCode();
        }
        return Long.valueOf(id).longValue();
    }

    private int conversationCount() {
        return this.inboxState.conversations().size();
    }
}
