package io.intercom.android.sdk.conversation;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.conversation.attribute.AttributeInputListener;
import io.intercom.android.sdk.conversation.attribute.OnDateAttributeSetListener;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Attribute;
import io.intercom.android.sdk.models.Link;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.models.Suggestion;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.LinkOpener;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.ListAttributeSelectorDialogBuilder;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import io.intercom.android.sdk.views.holder.AdminIsTypingViewHolder;
import io.intercom.android.sdk.views.holder.AttributeCollectorViewHolder;
import io.intercom.android.sdk.views.holder.BigTicketViewHolder;
import io.intercom.android.sdk.views.holder.ComposerSuggestionsViewHolder;
import io.intercom.android.sdk.views.holder.ContainerCardViewHolder;
import io.intercom.android.sdk.views.holder.ConversationListener;
import io.intercom.android.sdk.views.holder.ConversationLoadingViewHolder;
import io.intercom.android.sdk.views.holder.ConversationPartViewHolder;
import io.intercom.android.sdk.views.holder.ConversationRatingViewHolder;
import io.intercom.android.sdk.views.holder.EventViewHolder;
import io.intercom.android.sdk.views.holder.LinkListViewHolder;
import io.intercom.android.sdk.views.holder.LinkViewHolder;
import io.intercom.android.sdk.views.holder.PartViewHolder;
import io.intercom.android.sdk.views.holder.PartViewHolderCompose;
import io.intercom.android.sdk.views.holder.QuickReplyClickListener;
import io.intercom.android.sdk.views.holder.QuickReplyViewHolder;
import io.intercom.android.sdk.views.holder.TeamPresenceState;
import io.intercom.android.sdk.views.holder.TeamPresenceViewHolder;
import io.intercom.android.sdk.views.holder.TemporaryExpectationsViewHolder;
import io.intercom.android.sdk.views.holder.TicketStatusViewHolder;
import io.intercom.android.sdk.views.holder.TimeStampViewHolder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class ConversationPartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ConversationListener {
    private boolean allowExpansionArrow = false;
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final ClipboardManager clipboardManager;
    private String conversationId;
    Boolean isBigTicketCardVisible = false;
    private final Map<Part, List<ViewGroup>> legacyBlocksViewMap;
    private Listener listener;
    private final Locale locale;
    private final MetricTracker metricTracker;
    private final List<Part> partList;
    private final PartMetadataFormatter partMetadataFormatter;
    private final Map<Part, ViewGroup> partViewMap;
    private QuickReplyClickListener quickReplyClickListener;
    private final Activity rootActivity;
    private Part selectedPart;
    private SuggestionsClickListener suggestionsClickListener;
    private TeamPresenceState teamPresenceState = null;
    private Ticket ticket = null;
    private final TimeFormatter timeFormatter;
    private final UserIdentity userIdentity;

    interface Listener {
        void onPartClicked(Part part);

        void onPostCardClicked(Part part);
    }

    public static ConversationPartAdapter create(Activity activity, List<Part> list, Listener listener2, Api api2, String str, Provider<AppConfig> provider, UserIdentity userIdentity2, TimeProvider timeProvider, ContextLocaliser contextLocaliser, MetricTracker metricTracker2, Locale locale2) {
        Activity activity2 = activity;
        TimeFormatter timeFormatter2 = new TimeFormatter(contextLocaliser.createLocalisedContext(activity2), timeProvider);
        return new ConversationPartAdapter(list, (ClipboardManager) activity2.getSystemService("clipboard"), listener2, new PartMetadataFormatter(timeFormatter2), timeFormatter2, new HashMap(), api2, activity2, str, provider, userIdentity2, metricTracker2, locale2, new HashMap());
    }

    ConversationPartAdapter(List<Part> list, ClipboardManager clipboardManager2, Listener listener2, PartMetadataFormatter partMetadataFormatter2, TimeFormatter timeFormatter2, Map<Part, ViewGroup> map, Api api2, Activity activity, String str, Provider<AppConfig> provider, UserIdentity userIdentity2, MetricTracker metricTracker2, Locale locale2, Map<Part, List<ViewGroup>> map2) {
        this.partList = list;
        this.clipboardManager = clipboardManager2;
        this.listener = listener2;
        this.partMetadataFormatter = partMetadataFormatter2;
        this.timeFormatter = timeFormatter2;
        this.partViewMap = map;
        this.legacyBlocksViewMap = map2;
        this.api = api2;
        this.rootActivity = activity;
        this.conversationId = str;
        this.appConfigProvider = provider;
        this.userIdentity = userIdentity2;
        this.metricTracker = metricTracker2;
        this.locale = locale2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 2:
                return new ContainerCardViewHolder(from.inflate(R.layout.intercom_row_post, viewGroup, false), i, this, this.clipboardManager, false, this.appConfigProvider);
            case 3:
                return new ContainerCardViewHolder(from.inflate(R.layout.intercom_row_note, viewGroup, false), i, this, this.clipboardManager, this.allowExpansionArrow, this.appConfigProvider);
            case 5:
                return new AdminIsTypingViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false));
            case 6:
                return new TimeStampViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false), this.timeFormatter);
            case 7:
                return new ConversationLoadingViewHolder(from.inflate(R.layout.intercom_row_loading, viewGroup, false));
            case 8:
                return new LinkViewHolder(from.inflate(R.layout.intercom_row_link, viewGroup, false), i, this, this.clipboardManager, this.appConfigProvider);
            case 9:
                return new LinkViewHolder(from.inflate(R.layout.intercom_row_link_reply, viewGroup, false), i, this, this.clipboardManager, this.appConfigProvider);
            case 10:
                return new ConversationRatingViewHolder(from.inflate(R.layout.intercom_row_conversation_rating, viewGroup, false), this, this.appConfigProvider);
            case 12:
                return new EventViewHolder(from.inflate(R.layout.intercom_row_event, viewGroup, false));
            case 13:
                return new LinkListViewHolder(from.inflate(R.layout.intercom_row_link_list, viewGroup, false), this, this.appConfigProvider);
            case 14:
                return new QuickReplyViewHolder(from.inflate(R.layout.intercom_row_quick_reply_part, viewGroup, false), i, this, this.clipboardManager, this.partMetadataFormatter, this.appConfigProvider, this.metricTracker);
            case 15:
                return new AttributeCollectorViewHolder(from.inflate(R.layout.intercom_row_attribute_collector_part, viewGroup, false), this.appConfigProvider, this, this.locale);
            case 16:
                return new ComposerSuggestionsViewHolder(from.inflate(R.layout.intercom_row_composer_suggestions_part, viewGroup, false), i, this, this.clipboardManager, this.partMetadataFormatter, this.appConfigProvider, this.metricTracker);
            case 17:
                return new TemporaryExpectationsViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false));
            case 18:
                return new TicketStatusViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false), this.timeFormatter);
            case 19:
                return new BigTicketViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false), this.ticket);
            case 20:
                return new TeamPresenceViewHolder(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false));
            default:
                return new PartViewHolderCompose(from.inflate(R.layout.intercom_row_compose_view, viewGroup, false), this, this.partMetadataFormatter);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ConversationPartViewHolder) {
            Part part = getPart(i);
            ViewGroup viewGroup = this.partViewMap.get(part);
            if (viewGroup == null) {
                viewGroup = new FrameLayout(viewHolder.itemView.getContext());
            }
            ((ConversationPartViewHolder) viewHolder).bind(part, viewGroup);
        } else if (viewHolder instanceof BigTicketViewHolder) {
            ((BigTicketViewHolder) viewHolder).bind(this.isBigTicketCardVisible.booleanValue(), this.ticket);
        } else if (viewHolder instanceof TeamPresenceViewHolder) {
            ((TeamPresenceViewHolder) viewHolder).bind(this.teamPresenceState);
        } else if (viewHolder instanceof PartViewHolderCompose) {
            Part part2 = getPart(i);
            ((PartViewHolderCompose) viewHolder).bind(part2, this.legacyBlocksViewMap.get(part2));
        }
    }

    public int getItemViewType(int i) {
        Part part = this.partList.get(i);
        String messageStyle = part.getMessageStyle();
        if (Part.TICKET_UPDATED_MESSAGE_STYLE.equals(messageStyle)) {
            return 18;
        }
        if (part.isEvent().booleanValue()) {
            return 12;
        }
        if (Part.ADMIN_IS_TYPING_STYLE.equals(messageStyle)) {
            return 5;
        }
        if (Part.DAY_DIVIDER_STYLE.equals(messageStyle)) {
            return 6;
        }
        if (Part.LOADING_LAYOUT.equals(messageStyle)) {
            return 7;
        }
        if (Part.COMPOSER_SUGGESTIONS_STYLE.equals(messageStyle)) {
            return 16;
        }
        if (Part.TEMPORARY_EXPECTATIONS_LAYOUT.equals(messageStyle)) {
            return 17;
        }
        if (Part.BIG_TICKET_STYLE.equals(messageStyle)) {
            return 19;
        }
        if (Part.TEAM_PRESENCE_STYLE.equals(messageStyle)) {
            return 20;
        }
        Participant participant = part.getParticipant();
        if (!participant.isAdmin()) {
            return participant.isUserWithId(this.userIdentity.getIntercomId()) ? 0 : 4;
        }
        if (part.isLinkCard()) {
            return part.isInitialMessage() ? 8 : 9;
        }
        if (part.isSingleBlockPartOfType(BlockType.CONVERSATIONRATING)) {
            return 10;
        }
        if (part.isSingleBlockPartOfType(BlockType.LINKLIST)) {
            return 13;
        }
        if (Part.POST_MESSAGE_STYLE.equals(messageStyle)) {
            return 2;
        }
        if (Part.NOTE_MESSAGE_STYLE.equals(messageStyle)) {
            startAllowingExpansionArrowIfPositionIsNotLast(i);
            return 3;
        } else if (Part.ATTRIBUTE_COLLECTOR_STYLE.equals(messageStyle)) {
            return 15;
        } else {
            return "quick_reply".equals(messageStyle) ? 14 : 1;
        }
    }

    private void startAllowingExpansionArrowIfPositionIsNotLast(int i) {
        boolean z = this.allowExpansionArrow;
        boolean z2 = true;
        if (i == this.partList.size() - 1) {
            z2 = false;
        }
        this.allowExpansionArrow = z | z2;
    }

    public int getItemCount() {
        return this.partList.size();
    }

    public int getCount() {
        return getItemCount();
    }

    public Part getPart(int i) {
        return this.partList.get(i);
    }

    public Part getSelectedPart() {
        return this.selectedPart;
    }

    public void onPartClicked(int i, PartViewHolder partViewHolder) {
        Part part = this.partList.get(i);
        if (part.getMessageState() == Part.MessageState.FAILED || part.getMessageState() == Part.MessageState.UPLOAD_FAILED) {
            this.listener.onPartClicked(part);
        } else if (i < getCount() - 1) {
            Part part2 = this.selectedPart;
            if (part == part2) {
                this.selectedPart = null;
                partViewHolder.setExpanded(false);
                return;
            }
            notifyItemChanged(this.partList.indexOf(part2));
            this.selectedPart = part;
            partViewHolder.setExpanded(true);
        }
    }

    public void onContainerCardClicked(int i, ContainerCardViewHolder containerCardViewHolder) {
        Part part = this.partList.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 2) {
            this.listener.onPostCardClicked(part);
        } else if (itemViewType == 3 && this.allowExpansionArrow) {
            containerCardViewHolder.toggleExpanded();
        }
    }

    public void onLinkClicked(int i, View view) {
        Block linkBlock = this.partList.get(i).getLinkBlock();
        if (Link.ARTICLE_TYPE.equals(linkBlock.getLinkType())) {
            openArticleActivity(linkBlock);
        } else {
            LinkOpener.handleUrl(linkBlock.getUrl(), this.rootActivity, this.api);
        }
    }

    public void onSubmitAttribute(String str, String str2, Object obj, String str3) {
        this.api.submitForm(this.conversationId, str, str2, obj, str3);
    }

    public void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption) {
        QuickReplyClickListener quickReplyClickListener2 = this.quickReplyClickListener;
        if (quickReplyClickListener2 != null) {
            quickReplyClickListener2.onQuickReplyClicked(participant, part, replyOption);
        }
    }

    public void onComposerSuggestionClicked(Part part, Suggestion suggestion) {
        SuggestionsClickListener suggestionsClickListener2 = this.suggestionsClickListener;
        if (suggestionsClickListener2 != null) {
            suggestionsClickListener2.onSuggestionClicked(part, suggestion);
        }
    }

    public void onListAttributeClicked(String str, Attribute attribute, AttributeInputListener attributeInputListener) {
        new ListAttributeSelectorDialogBuilder(this.rootActivity, str, attribute, this, attributeInputListener).show();
    }

    public void onDateAttributeClicked(String str, String str2, String str3, AttributeInputListener attributeInputListener) {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.rootActivity, R.style.Intercom_DatePicker, new OnDateAttributeSetListener(str, str2, str3, this, attributeInputListener), instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.show();
        int primaryColor = this.appConfigProvider.get().getPrimaryColor();
        Button button = datePickerDialog.getButton(-1);
        button.setText(17039370);
        button.setTextColor(primaryColor);
        datePickerDialog.getButton(-2).setTextColor(primaryColor);
    }

    public void setTicket(Ticket ticket2) {
        this.ticket = ticket2;
    }

    public void setTeamPresenceState(TeamPresenceState teamPresenceState2) {
        this.teamPresenceState = teamPresenceState2;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    private void openArticleActivity(Block block) {
        this.rootActivity.startActivity(ArticleActivity.buildIntent(this.rootActivity, new ArticleActivity.ArticleActivityArguments(block.getArticleId(), "conversation")));
    }

    public void setQuickReplyClickListener(QuickReplyClickListener quickReplyClickListener2) {
        this.quickReplyClickListener = quickReplyClickListener2;
    }

    public void setSuggesstionsClickListener(SuggestionsClickListener suggestionsClickListener2) {
        this.suggestionsClickListener = suggestionsClickListener2;
    }

    /* access modifiers changed from: package-private */
    public void setViewForPart(Part part, ViewGroup viewGroup) {
        this.partViewMap.put(part, viewGroup);
    }

    /* access modifiers changed from: package-private */
    public void setLegacyBlocksForPart(Part part, List<ViewGroup> list) {
        this.legacyBlocksViewMap.put(part, list);
    }

    /* access modifiers changed from: package-private */
    public void removeViewForPart(Part part) {
        this.partViewMap.remove(part);
    }

    /* access modifiers changed from: package-private */
    public ViewGroup getViewForPart(Part part) {
        return this.partViewMap.get(part);
    }

    public void setListener(Listener listener2) {
        this.listener = listener2;
    }
}
