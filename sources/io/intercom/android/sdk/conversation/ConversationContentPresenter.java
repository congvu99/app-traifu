package io.intercom.android.sdk.conversation;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.intercom.commons.utilities.TimeProvider;
import com.intercom.input.gallery.GalleryImage;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.nexus.NexusEvent;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.annotations.SeenState;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.LinkOpeningButtonClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.function.TimestampAdder;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.blocks.lib.BlocksViewHolder;
import io.intercom.android.sdk.blocks.lib.models.Author;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockAttachment;
import io.intercom.android.sdk.conversation.attribute.AttributeAnimateEndListener;
import io.intercom.android.sdk.helpcenter.articles.ArticleStatsArguments;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.m5.components.TopActionBar;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.models.Attachments;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.BotIntro;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.models.SocialAccount;
import io.intercom.android.sdk.models.Suggestion;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.FormSubmitSuccessEvent;
import io.intercom.android.sdk.models.events.NewConversationEvent;
import io.intercom.android.sdk.models.events.NewTriggerConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.UploadEvent;
import io.intercom.android.sdk.models.events.failure.FormSubmitFailedEvent;
import io.intercom.android.sdk.models.events.failure.NewConversationFailedEvent;
import io.intercom.android.sdk.models.events.failure.ReplyFailedEvent;
import io.intercom.android.sdk.models.events.failure.UploadFailedEvent;
import io.intercom.android.sdk.models.events.realtime.UserContentSeenByAdminEvent;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.tickets.IntercomTicketActivity;
import io.intercom.android.sdk.tickets.TicketProgressRow;
import io.intercom.android.sdk.utilities.GroupConversationTextFormatter;
import io.intercom.android.sdk.utilities.KeyboardUtils;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.views.AdminIsTypingView;
import io.intercom.android.sdk.views.AttributeCollectorCardView;
import io.intercom.android.sdk.views.BaseAttributeView;
import io.intercom.android.sdk.views.decoration.ConversationItemDecoration;
import io.intercom.android.sdk.views.holder.GroupParticipants;
import io.intercom.android.sdk.views.holder.QuickReplyClickListener;
import io.intercom.android.sdk.views.holder.TeamPresenceState;
import io.intercom.android.sdk.views.holder.TeamPresenceViewHolderKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

class ConversationContentPresenter implements QuickReplyClickListener, SuggestionsClickListener {
    private static final String IMAGE_MIME_TYPE = "image";
    private static final long PART_DISPLAY_DELIVERED_TIMEOUT = TimeUnit.MINUTES.toMillis(1);
    private final ConversationPartAdapter adapter;
    /* access modifiers changed from: private */
    public final Api api;
    private Provider<AppConfig> appConfigProvider;
    private ArticleStatsArguments articleStatsArguments;
    private final Blocks blocks;
    private final BlocksViewHolder blocksAdminViewHolder;
    private final BlocksViewHolder blocksAnnouncementViewHolder;
    private final BlocksViewHolder blocksConversationRatingViewHolder;
    private final BlocksViewHolder blocksLinkListHolder;
    private final BlocksViewHolder blocksLinkViewHolder;
    private final BlocksViewHolder blocksPreviewViewHolder;
    private final BlocksViewHolder blocksUserViewHolder;
    private BotIntro botIntro;
    private final Bus bus;
    private final Context context;
    private String conversationId;
    /* access modifiers changed from: private */
    public RecyclerView conversationList;
    private Host host;
    private final Map<String, AdminIsTypingView> isTypingViews = new ArrayMap();
    private final LinearLayoutManager layoutManager;
    private final Part loadingPart = new Part.Builder().withStyle(Part.LOADING_LAYOUT).build();
    private final MetricTracker metricTracker;
    private final NexusClient nexusClient;
    /* access modifiers changed from: private */
    public final OpsMetricTracker opsMetricTracker;
    private final List<Part> parts;
    private Runnable replyDeliveredUpdater;
    final List<Part> sendingParts = new ArrayList();
    private final SoundPlayer soundPlayer;
    private final Store<State> store;
    private final TeamPresence teamPresence;
    private final TicketProgressRow ticketProgressRow;
    private final TimestampAdder timestampAdder = TimestampAdder.create();
    private final TopActionBar topActionBar;
    private final UploadingImageCache uploadingImageCache;
    private final UserIdentity userIdentity;

    interface Host {
        Conversation getConversation();

        String getConversationId();

        void onConversationCreated(Conversation conversation);

        void onFormSubmitted();
    }

    static ConversationContentPresenter create(Host host2, RecyclerView recyclerView, TicketProgressRow ticketProgressRow2, TopActionBar topActionBar2, ConversationPartAdapter conversationPartAdapter, Provider<AppConfig> provider, Api api2, List<Part> list, String str, SoundPlayer soundPlayer2, Blocks blocks2, UserIdentity userIdentity2, OpsMetricTracker opsMetricTracker2, Activity activity, Store store2, NexusClient nexusClient2, ArticleStatsArguments articleStatsArguments2) {
        Api api3 = api2;
        Api api4 = api2;
        List<Part> list2 = list;
        String str2 = str;
        SoundPlayer soundPlayer3 = soundPlayer2;
        Blocks blocks3 = blocks2;
        UserIdentity userIdentity3 = userIdentity2;
        OpsMetricTracker opsMetricTracker3 = opsMetricTracker2;
        Activity activity2 = activity;
        Store store3 = store2;
        NexusClient nexusClient3 = nexusClient2;
        Injector injector = Injector.get();
        LinearLayoutManager linearLayoutManager = r0;
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(recyclerView.getContext());
        UploadingImageCache uploadingImageCache2 = r1;
        UploadingImageCache uploadingImageCache3 = new UploadingImageCache();
        ViewHolderGenerator viewHolderGenerator = r0;
        ViewHolderGenerator viewHolderGenerator2 = new ViewHolderGenerator(uploadingImageCache3, api3, provider, str, new LightboxOpeningImageClickListener(api3), new LinkOpeningButtonClickListener(api3), injector.getGson(), injector.getBus(), injector.getMetricTracker(), activity);
        return new ConversationContentPresenter(host2, recyclerView, ticketProgressRow2, topActionBar2, conversationPartAdapter, linearLayoutManager, list2, soundPlayer3, blocks3, viewHolderGenerator, userIdentity3, api4, opsMetricTracker3, uploadingImageCache2, activity2, str2, injector.getMetricTracker(), injector.getBus(), store3, nexusClient3, provider, articleStatsArguments2, injector.getStore().state().teamPresence());
    }

    ConversationContentPresenter(Host host2, RecyclerView recyclerView, TicketProgressRow ticketProgressRow2, TopActionBar topActionBar2, ConversationPartAdapter conversationPartAdapter, LinearLayoutManager linearLayoutManager, List<Part> list, SoundPlayer soundPlayer2, Blocks blocks2, ViewHolderGenerator viewHolderGenerator, UserIdentity userIdentity2, Api api2, OpsMetricTracker opsMetricTracker2, UploadingImageCache uploadingImageCache2, Context context2, String str, MetricTracker metricTracker2, Bus bus2, Store store2, NexusClient nexusClient2, Provider<AppConfig> provider, ArticleStatsArguments articleStatsArguments2, TeamPresence teamPresence2) {
        this.host = host2;
        this.conversationList = recyclerView;
        this.ticketProgressRow = ticketProgressRow2;
        this.topActionBar = topActionBar2;
        this.adapter = conversationPartAdapter;
        this.layoutManager = linearLayoutManager;
        this.parts = list;
        this.soundPlayer = soundPlayer2;
        this.blocks = blocks2;
        this.userIdentity = userIdentity2;
        this.api = api2;
        this.opsMetricTracker = opsMetricTracker2;
        this.uploadingImageCache = uploadingImageCache2;
        this.context = context2;
        this.conversationId = str;
        this.metricTracker = metricTracker2;
        this.bus = bus2;
        this.store = store2;
        this.nexusClient = nexusClient2;
        this.appConfigProvider = provider;
        this.articleStatsArguments = articleStatsArguments2;
        this.teamPresence = teamPresence2;
        this.blocksUserViewHolder = viewHolderGenerator.getUserHolder();
        this.blocksAnnouncementViewHolder = viewHolderGenerator.getContainerCardHolder();
        this.blocksAdminViewHolder = viewHolderGenerator.getAdminHolder();
        this.blocksLinkViewHolder = viewHolderGenerator.getLinkHolder();
        this.blocksConversationRatingViewHolder = viewHolderGenerator.getConversationRatingHolder();
        this.blocksPreviewViewHolder = viewHolderGenerator.getPreviewHolder();
        this.blocksLinkListHolder = viewHolderGenerator.getLinkListHolder();
        conversationPartAdapter.setQuickReplyClickListener(this);
        conversationPartAdapter.setSuggesstionsClickListener(this);
    }

    public void setup() {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_PROCESS_ACTION);
        this.conversationList.setLayoutManager(this.layoutManager);
        this.conversationList.setAdapter(this.adapter);
        RecyclerView recyclerView = this.conversationList;
        recyclerView.addItemDecoration(new ConversationItemDecoration(recyclerView.getContext(), this.parts));
        ((SimpleItemAnimator) this.conversationList.getItemAnimator()).setSupportsChangeAnimations(false);
        this.conversationList.setNestedScrollingEnabled(true);
        this.conversationList.setVisibility(0);
        this.ticketProgressRow.setVisible(false);
    }

    public void smoothScrollToTop() {
        this.conversationList.smoothScrollToPosition(0);
    }

    private void smoothScrollToBottom() {
        this.conversationList.smoothScrollToPosition(this.adapter.getCount() - 1);
    }

    public void scrollToTop() {
        this.conversationList.scrollToPosition(0);
    }

    public void scrollToBottom() {
        this.conversationList.scrollToPosition(this.adapter.getCount() - 1);
    }

    public boolean isAtBottom() {
        return !this.conversationList.canScrollVertically(1);
    }

    public void onNewPartReceived(Conversation conversation) {
        for (AdminIsTypingView next : this.isTypingViews.values()) {
            if (next != null) {
                next.cancelTypingAnimation();
            }
        }
        boolean z = true;
        if (hasTicket(conversation).booleanValue() && (!hasTicket(conversation).booleanValue() || nonTicketPartsSize(conversation) <= 1)) {
            z = false;
        }
        if (z) {
            smoothScrollToBottom();
        }
    }

    public void showErrorView() {
        hideLoadingIndicator();
        this.conversationList.setVisibility(8);
    }

    public void showLoadingView() {
        showLoadingIndicator();
        this.conversationList.setVisibility(0);
    }

    public void showContentView() {
        hideLoadingIndicator();
        this.conversationList.setVisibility(0);
    }

    private void showLoadingIndicator() {
        this.parts.add(0, this.loadingPart);
        this.adapter.notifyItemInserted(0);
    }

    private void hideLoadingIndicator() {
        int indexOf = this.parts.indexOf(this.loadingPart);
        if (indexOf >= 0) {
            this.parts.remove(indexOf);
            this.adapter.notifyItemRemoved(indexOf);
        }
    }

    private int positionOfPart(int i, String str) {
        if (i < 0 || i >= this.parts.size()) {
            return -1;
        }
        if (this.parts.get(i).getId().equals(str)) {
            return i;
        }
        return positionOfPartById(str);
    }

    private int positionOfPartById(String str) {
        for (int size = this.parts.size() - 1; size >= 0; size--) {
            if (this.parts.get(size).getId().equals(str)) {
                return size;
            }
        }
        return -1;
    }

    private void markAsFailed(int i, String str, boolean z) {
        int positionOfPart = positionOfPart(i, str);
        if (positionOfPart >= 0) {
            Part part = this.parts.get(positionOfPart);
            View childAt = this.adapter.getViewForPart(part).getChildAt(0);
            if (childAt instanceof UploadProgressListener) {
                ((UploadProgressListener) childAt).uploadStopped();
            }
            part.setMessageState(z ? Part.MessageState.UPLOAD_FAILED : Part.MessageState.FAILED);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Subscribe
    public void newConversationFailure(NewConversationFailedEvent newConversationFailedEvent) {
        markAsFailed(newConversationFailedEvent.getPosition(), newConversationFailedEvent.getPartId(), false);
    }

    @Subscribe
    public void replyFailure(ReplyFailedEvent replyFailedEvent) {
        markAsFailed(replyFailedEvent.getPosition(), replyFailedEvent.getPartId(), replyFailedEvent.isUpload());
        this.soundPlayer.playReplyFailedSound();
    }

    @Subscribe
    public void uploadFailure(UploadFailedEvent uploadFailedEvent) {
        markAsFailed(uploadFailedEvent.getPosition(), uploadFailedEvent.getPartId(), true);
        this.soundPlayer.playReplyFailedSound();
    }

    @Subscribe
    public void formSubmitFailed(FormSubmitFailedEvent formSubmitFailedEvent) {
        ViewGroup viewForPart;
        int positionOfPartById = positionOfPartById(formSubmitFailedEvent.getPartId());
        if (positionOfPartById >= 0 && (viewForPart = this.adapter.getViewForPart(this.parts.get(positionOfPartById))) != null && viewForPart.getChildCount() > 0) {
            int childCount = viewForPart.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewForPart.getChildAt(i);
                String string = this.context.getResources().getString(R.string.intercom_something_went_wrong_try_again);
                BaseAttributeView baseAttributeView = (BaseAttributeView) childAt;
                if (baseAttributeView.getAttribute().getIdentifier().equals(formSubmitFailedEvent.getAttributeIdentifier())) {
                    baseAttributeView.displayEmptyState();
                    baseAttributeView.displayErrorState(string);
                    return;
                }
            }
        }
    }

    @Subscribe
    public void formSubmitSuccess(FormSubmitSuccessEvent formSubmitSuccessEvent) {
        ViewGroup viewForPart;
        int positionOfPartById = positionOfPartById(formSubmitSuccessEvent.getPartId());
        if (positionOfPartById >= 0 && (viewForPart = this.adapter.getViewForPart(this.parts.get(positionOfPartById))) != null && viewForPart.getParent() != null) {
            ViewParent parent = viewForPart.getParent();
            if (parent instanceof AttributeCollectorCardView) {
                AttributeCollectorCardView attributeCollectorCardView = (AttributeCollectorCardView) parent;
                if (attributeCollectorCardView.isExpanded()) {
                    attributeCollectorCardView.animateBack(new AttributeAnimateEndListener(formSubmitSuccessEvent.getConversation(), this.bus));
                    KeyboardUtils.hideKeyboard(attributeCollectorCardView);
                    this.host.onFormSubmitted();
                    return;
                }
                this.bus.post(new ConversationEvent.Builder(formSubmitSuccessEvent.getConversation()).isAttributeUpdated(true).build());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addViewForPart(Part part) {
        if (!"quick_reply".equals(part.getMessageStyle()) && !Part.COMPOSER_SUGGESTIONS_STYLE.equals(part.getMessageStyle())) {
            List<Block> blocks2 = part.getBlocks();
            if (!part.getAttachments().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Attachments next : part.getAttachments()) {
                    arrayList.add(new BlockAttachment.Builder().withName(next.getName()).withUrl(next.getUrl()).withContentType(next.getContentType()).build());
                }
                blocks2.add(new Block.Builder().withType(BlockType.ATTACHMENTLIST.name()).withAttachments(arrayList).build());
            }
            if (part.getParticipant().isUserWithId(this.userIdentity.getIntercomId())) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksUserViewHolder));
            } else if (Part.POST_MESSAGE_STYLE.equals(part.getMessageStyle()) || Part.NOTE_MESSAGE_STYLE.equals(part.getMessageStyle())) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksAnnouncementViewHolder));
            } else if (part.isLinkCard()) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksLinkViewHolder));
            } else if (part.isSingleBlockPartOfType(BlockType.CONVERSATIONRATING)) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksConversationRatingViewHolder));
            } else if (part.isSingleBlockPartOfType(BlockType.LINKLIST)) {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksLinkListHolder));
            } else if (Part.ATTRIBUTE_COLLECTOR_STYLE.equals(part.getMessageStyle())) {
                LinearLayout linearLayout = new LinearLayout(this.context);
                linearLayout.setOrientation(1);
                this.adapter.setViewForPart(part, linearLayout);
            } else {
                this.adapter.setViewForPart(part, this.blocks.createBlocks(blocks2, this.blocksAdminViewHolder));
            }
            if (hasMessengerCardBlock(blocks2)) {
                ArrayList arrayList2 = new ArrayList();
                for (Block singletonList : blocks2) {
                    arrayList2.add(this.blocks.createBlocks(Collections.singletonList(singletonList), this.blocksAdminViewHolder));
                }
                this.adapter.setLegacyBlocksForPart(part, arrayList2);
            }
        }
    }

    private boolean hasMessengerCardBlock(List<Block> list) {
        for (Block type : list) {
            if (type.getType() == BlockType.MESSENGERCARD) {
                return true;
            }
        }
        return false;
    }

    private void displaySendingPart(Part part) {
        this.soundPlayer.playReplySentSound();
        ArrayList arrayList = new ArrayList(this.parts);
        this.parts.add(part);
        this.adapter.setViewForPart(part, this.blocks.createBlocks(part.getBlocks(), this.blocksPreviewViewHolder));
        this.adapter.isBigTicketCardVisible = false;
        showTicketProgressRowIfNeeded();
        updateAdapterWithAnimations(arrayList, this.parts);
        smoothScrollToBottom();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x009b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onAdminStartedTyping(io.intercom.android.sdk.conversation.events.AdminIsTypingEvent r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r6 = r10.getAdminId()     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, io.intercom.android.sdk.views.AdminIsTypingView> r0 = r9.isTypingViews     // Catch:{ all -> 0x009c }
            boolean r0 = r0.containsKey(r6)     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x001a
            java.util.Map<java.lang.String, io.intercom.android.sdk.views.AdminIsTypingView> r10 = r9.isTypingViews     // Catch:{ all -> 0x009c }
            java.lang.Object r10 = r10.get(r6)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.views.AdminIsTypingView r10 = (io.intercom.android.sdk.views.AdminIsTypingView) r10     // Catch:{ all -> 0x009c }
            r10.renewTypingAnimation()     // Catch:{ all -> 0x009c }
            monitor-exit(r9)
            return
        L_0x001a:
            io.intercom.android.sdk.models.Part$Builder r0 = new io.intercom.android.sdk.models.Part$Builder     // Catch:{ all -> 0x009c }
            r0.<init>()     // Catch:{ all -> 0x009c }
            r7 = 1
            io.intercom.android.sdk.models.Part$Builder r0 = r0.withParticipantIsAdmin(r7)     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "admin_is_typing_style"
            io.intercom.android.sdk.models.Part$Builder r0 = r0.withStyle(r1)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.models.Part r8 = r0.build()     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.conversation.ConversationContentPresenter$Host r0 = r9.host     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.models.Conversation r0 = r0.getConversation()     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.models.Participant r0 = r0.getParticipant(r6)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.models.Participant r1 = io.intercom.android.sdk.models.Participant.NULL     // Catch:{ all -> 0x009c }
            if (r0 != r1) goto L_0x0058
            java.lang.String r1 = r10.getAdminName()     // Catch:{ all -> 0x009c }
            java.lang.String r2 = "admin"
            java.lang.String r3 = ""
            java.lang.String r10 = r10.getAdminAvatarUrl()     // Catch:{ all -> 0x009c }
            java.lang.String r0 = ""
            io.intercom.android.sdk.models.Avatar r4 = io.intercom.android.sdk.models.Avatar.create(r10, r0)     // Catch:{ all -> 0x009c }
            r10 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r10)     // Catch:{ all -> 0x009c }
            r0 = r6
            io.intercom.android.sdk.models.Participant r0 = io.intercom.android.sdk.models.Participant.create(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x009c }
        L_0x0058:
            r8.setParticipant(r0)     // Catch:{ all -> 0x009c }
            r8.setEntranceAnimation(r7)     // Catch:{ all -> 0x009c }
            boolean r10 = r9.isAtBottom()     // Catch:{ all -> 0x009c }
            java.util.List<io.intercom.android.sdk.models.Part> r0 = r9.parts     // Catch:{ all -> 0x009c }
            r0.add(r8)     // Catch:{ all -> 0x009c }
            androidx.recyclerview.widget.RecyclerView r0 = r9.conversationList     // Catch:{ all -> 0x009c }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x009c }
            int r1 = io.intercom.android.sdk.R.layout.intercom_blocks_admin_layout     // Catch:{ all -> 0x009c }
            r2 = 0
            android.view.View r1 = android.view.View.inflate(r0, r1, r2)     // Catch:{ all -> 0x009c }
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.views.AdminIsTypingView r2 = new io.intercom.android.sdk.views.AdminIsTypingView     // Catch:{ all -> 0x009c }
            r2.<init>(r0)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.conversation.-$$Lambda$ConversationContentPresenter$iJ4Xh4yXUl16GFs82gJibzGgx5E r0 = new io.intercom.android.sdk.conversation.-$$Lambda$ConversationContentPresenter$iJ4Xh4yXUl16GFs82gJibzGgx5E     // Catch:{ all -> 0x009c }
            r0.<init>(r6, r8)     // Catch:{ all -> 0x009c }
            r2.setListener(r0)     // Catch:{ all -> 0x009c }
            r1.addView(r2)     // Catch:{ all -> 0x009c }
            java.util.Map<java.lang.String, io.intercom.android.sdk.views.AdminIsTypingView> r0 = r9.isTypingViews     // Catch:{ all -> 0x009c }
            r0.put(r6, r2)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.conversation.ConversationPartAdapter r0 = r9.adapter     // Catch:{ all -> 0x009c }
            r0.setViewForPart(r8, r1)     // Catch:{ all -> 0x009c }
            io.intercom.android.sdk.conversation.ConversationPartAdapter r0 = r9.adapter     // Catch:{ all -> 0x009c }
            r0.notifyDataSetChanged()     // Catch:{ all -> 0x009c }
            if (r10 == 0) goto L_0x009a
            r9.smoothScrollToBottom()     // Catch:{ all -> 0x009c }
        L_0x009a:
            monitor-exit(r9)
            return
        L_0x009c:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.conversation.ConversationContentPresenter.onAdminStartedTyping(io.intercom.android.sdk.conversation.events.AdminIsTypingEvent):void");
    }

    public /* synthetic */ void lambda$onAdminStartedTyping$0$ConversationContentPresenter(String str, Part part, AdminIsTypingView adminIsTypingView) {
        onAdminStoppedTyping(str, part.getId());
    }

    /* access modifiers changed from: package-private */
    public void onAdminStoppedTyping(String str, String str2) {
        this.isTypingViews.remove(str);
        int positionOfPart = positionOfPart(this.parts.size() - 1, str2);
        if (positionOfPart >= 0) {
            this.parts.remove(positionOfPart);
            this.adapter.notifyDataSetChanged();
        }
    }

    public void fetchConversation(final String str) {
        if (!str.isEmpty()) {
            this.opsMetricTracker.trackEvent("start", OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_COMPLETE_REQUEST);
            this.conversationId = str;
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    ConversationContentPresenter.this.api.getConversation(str, (String) null);
                }
            });
        }
    }

    public void onPartClicked(Part part) {
        if (part.getMessageState() == Part.MessageState.FAILED) {
            showRetryDialog(part);
        } else if (part.getMessageState() == Part.MessageState.UPLOAD_FAILED) {
            retryFailedUpload(part);
        }
    }

    private void retryFailedUpload(Part part) {
        UploadProgressListener uploadProgressListener;
        int positionOfPart = positionOfPart(this.parts.size() - 1, part.getId());
        if (positionOfPart >= 0) {
            uploadProgressListener = (UploadProgressListener) this.adapter.getViewForPart(this.parts.get(positionOfPart)).getChildAt(0);
            uploadProgressListener.uploadStarted();
        } else {
            uploadProgressListener = new UploadProgressListener() {
                public void uploadNotice(byte b) {
                }

                public void uploadSmoothEnd() {
                }

                public void uploadStarted() {
                }

                public void uploadStopped() {
                }
            };
        }
        UploadProgressListener uploadProgressListener2 = uploadProgressListener;
        part.setMessageState(Part.MessageState.SENDING);
        List<Part> list = this.parts;
        list.remove(list.indexOf(part));
        this.parts.add(part);
        this.adapter.notifyDataSetChanged();
        this.api.uploadFile(part.getUpload(), positionOfPart, part.getId(), this.uploadingImageCache, uploadProgressListener2, this.context);
    }

    private void showRetryDialog(Part part) {
        new AlertDialog.Builder(this.conversationList.getContext()).setTitle(R.string.intercom_inbox_error_state_title).setMessage(R.string.intercom_failed_delivery).setPositiveButton(R.string.intercom_retry, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(part) {
            public final /* synthetic */ Part f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                ConversationContentPresenter.this.lambda$showRetryDialog$1$ConversationContentPresenter(this.f$1, dialogInterface, i);
            }
        }).show();
    }

    public /* synthetic */ void lambda$showRetryDialog$1$ConversationContentPresenter(Part part, DialogInterface dialogInterface, int i) {
        retryTapped(part);
    }

    /* access modifiers changed from: package-private */
    public void retryTapped(Part part) {
        part.setMessageState(Part.MessageState.SENDING);
        this.parts.remove(part);
        this.parts.add(part);
        this.adapter.notifyDataSetChanged();
        List<Block> blocks2 = part.getBlocks();
        int size = blocks2.size();
        ArrayList arrayList = new ArrayList(blocks2.size());
        for (int i = 0; i < size; i++) {
            arrayList.add(blocks2.get(i).toBuilder());
        }
        sendPart(arrayList);
    }

    private Part addSendingPart(List<Block.Builder> list) {
        Part createSendingPart = createSendingPart(list);
        this.sendingParts.add(createSendingPart);
        displaySendingPart(createSendingPart);
        return createSendingPart;
    }

    private Part createSendingPart(List<Block.Builder> list) {
        Part build = new Part.Builder().withCreatedAt(TimeUnit.MILLISECONDS.toSeconds(TimeProvider.SYSTEM.currentTimeMillis())).withStyle(Part.CHAT_MESSAGE_STYLE).withBlocks(list).build();
        build.setMessageState(Part.MessageState.SENDING);
        build.setParticipant(getUserParticipant());
        build.setEntranceAnimation(true);
        return build;
    }

    /* access modifiers changed from: package-private */
    public void addComposerSuggestionsPart(ComposerSuggestions composerSuggestions) {
        if (!composerSuggestions.getSuggestions().isEmpty()) {
            Part createComposerSuggestionsPart = createComposerSuggestionsPart(composerSuggestions);
            boolean z = false;
            if (!this.parts.isEmpty()) {
                List<Part> list = this.parts;
                Part part = list.get(list.size() - 1);
                if (Part.COMPOSER_SUGGESTIONS_STYLE.equals(part.getMessageStyle())) {
                    this.parts.remove(part);
                    z = true;
                }
            }
            this.parts.add(createComposerSuggestionsPart);
            if (z) {
                this.adapter.notifyItemChanged(this.parts.indexOf(createComposerSuggestionsPart));
            } else {
                this.adapter.notifyItemInserted(this.parts.indexOf(createComposerSuggestionsPart));
            }
        }
    }

    private Part createComposerSuggestionsPart(ComposerSuggestions composerSuggestions) {
        Part build = new Part.Builder().withCreatedAt(TimeUnit.MILLISECONDS.toSeconds(TimeProvider.SYSTEM.currentTimeMillis())).withStyle(Part.COMPOSER_SUGGESTIONS_STYLE).build();
        build.setComposerSuggestions(composerSuggestions);
        return build;
    }

    /* access modifiers changed from: package-private */
    public Participant getUserParticipant() {
        String intercomId = this.userIdentity.getIntercomId();
        Participant participant = this.host.getConversation().getParticipant(intercomId);
        return participant == Participant.NULL ? new Participant.Builder().withId(intercomId).build() : participant;
    }

    public void sendPart(List<Block.Builder> list) {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_PROCESS_ACTION);
        this.opsMetricTracker.trackEvent("start", OpsMetricTracker.SEND_PART_TIME_TO_COMPLETE_REQUEST);
        Part addSendingPart = addSendingPart(list);
        if (TextUtils.isEmpty(this.conversationId)) {
            startConversationOnServer(list, addSendingPart.getId());
            return;
        }
        this.api.replyToConversation(this.conversationId, list, this.parts.size() - 1, addSendingPart.getId(), false);
    }

    @Subscribe
    public void uploadSuccess(UploadEvent uploadEvent) {
        String tempPartId = uploadEvent.getTempPartId();
        int positionOfPart = positionOfPart(uploadEvent.getTempPartPosition(), tempPartId);
        if (positionOfPart >= 0) {
            Part part = this.parts.get(positionOfPart);
            if (!part.getBlocks().isEmpty() && tempPartId.equals(part.getId())) {
                List<Block.Builder> createBlocksForUpload = createBlocksForUpload(uploadEvent, part.getBlocks().get(0));
                if (TextUtils.isEmpty(this.conversationId)) {
                    startConversationOnServer(createBlocksForUpload, tempPartId);
                } else {
                    this.api.replyToConversation(this.conversationId, createBlocksForUpload, positionOfPart, part.getId(), true);
                }
            }
        }
    }

    private void startConversationOnServer(List<Block.Builder> list, String str) {
        BotIntro botIntro2 = this.botIntro;
        this.api.startNewConversation(list, this.parts.size() - 1, str, ((ComposerSuggestions) this.store.select(Selectors.COMPOSER_SUGGESTIONS)).getSuggestions(), botIntro2 != null ? botIntro2.getId() : null, this.articleStatsArguments);
    }

    private List<Block.Builder> createBlocksForUpload(UploadEvent uploadEvent, Block block) {
        if (uploadEvent.getUpload().getContentType().contains("image")) {
            return Collections.singletonList(block.toBuilder().withType(BlockType.IMAGE.getSerializedName()).withUrl(uploadEvent.getUpload().getPublicUrl()));
        }
        List<BlockAttachment> attachments = block.getAttachments();
        if (attachments.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.singletonList(block.toBuilder().withAttachments(Collections.singletonList(attachments.get(0).toBuilder().withSize(uploadEvent.getSize()).withId(uploadEvent.getUpload().getId()).withUrl(uploadEvent.getUpload().getPublicUrl()).build())).withType(BlockType.ATTACHMENTLIST.getSerializedName()));
    }

    public void uploadImage(List<Block.Builder> list, GalleryImage galleryImage) {
        Part addSendingPart = addSendingPart(list);
        addSendingPart.setUpload(galleryImage);
        this.api.uploadFile(galleryImage, this.parts.size() - 1, addSendingPart.getId(), this.uploadingImageCache, (UploadProgressListener) this.adapter.getViewForPart(addSendingPart).getChildAt(0), this.context);
    }

    public void onNewConversation(NewConversationEvent newConversationEvent) {
        updateSendPartOpsMetric();
        Conversation conversation = newConversationEvent.getConversation();
        this.parts.clear();
        addTemporaryExpectationsMessage(true);
        addTeamPresencePart(true);
        setUpTopActionBar(newConversationEvent.getConversation());
        this.parts.addAll(newConversationEvent.getConversation().getParts());
        for (Part addViewForPart : this.parts) {
            addViewForPart(addViewForPart);
        }
        String id = conversation.getId();
        this.conversationId = id;
        this.adapter.setConversationId(id);
        this.sendingParts.clear();
        this.adapter.notifyDataSetChanged();
    }

    public void onReplyDelivered(ReplyEvent replyEvent) {
        updateSendPartOpsMetric();
        Part response = replyEvent.getResponse();
        int positionOfPart = positionOfPart(replyEvent.getPosition(), replyEvent.getPartId());
        if (positionOfPart >= 0 && this.parts.get(positionOfPart).isSendingPart()) {
            this.sendingParts.remove(this.parts.remove(positionOfPart));
        }
        if (!this.parts.contains(response)) {
            addViewForPart(response);
            response.setDisplayDelivered(true);
            this.parts.add(response);
            this.adapter.notifyDataSetChanged();
        }
        this.conversationList.removeCallbacks(this.replyDeliveredUpdater);
        $$Lambda$ConversationContentPresenter$klTrN1TQPSbyORgP78s75C5Bc r4 = new Runnable(response) {
            public final /* synthetic */ Part f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ConversationContentPresenter.this.lambda$onReplyDelivered$2$ConversationContentPresenter(this.f$1);
            }
        };
        this.replyDeliveredUpdater = r4;
        this.conversationList.postDelayed(r4, PART_DISPLAY_DELIVERED_TIMEOUT);
    }

    public /* synthetic */ void lambda$onReplyDelivered$2$ConversationContentPresenter(Part part) {
        part.setDisplayDelivered(false);
        this.adapter.notifyDataSetChanged();
    }

    private void updateSendPartOpsMetric() {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_COMPLETE_REQUEST);
        this.opsMetricTracker.trackEvent("start", OpsMetricTracker.SEND_PART_TIME_TO_RENDER_RESULT);
        this.conversationList.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ConversationContentPresenter.this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.SEND_PART_TIME_TO_RENDER_RESULT);
                ViewUtils.removeGlobalLayoutListener(ConversationContentPresenter.this.conversationList, this);
            }
        });
    }

    public void onConversationFetched(ConversationEvent conversationEvent, boolean z) {
        this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_COMPLETE_REQUEST);
        this.opsMetricTracker.trackEvent("start", OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_RENDER_RESULT);
        Conversation response = conversationEvent.getResponse();
        ArrayList arrayList = new ArrayList(this.parts);
        this.parts.clear();
        if (z) {
            RecyclerView recyclerView = this.conversationList;
            recyclerView.startAnimation(AnimationUtils.loadAnimation(recyclerView.getContext(), R.anim.intercom_conversation_slide_in));
        }
        setUpTopActionBar(response);
        addTemporaryExpectationsMessage(false);
        if (hasTicket(response).booleanValue()) {
            addBigTicketCard(response);
            setupTicketProgressRow(response.getTicket());
        }
        if (hasNonTicketParts(response)) {
            processLastParticipatingAdmin(response);
            processConversationParts(response);
            this.adapter.isBigTicketCardVisible = false;
            showTicketProgressRowIfNeeded();
        } else {
            this.adapter.isBigTicketCardVisible = true;
        }
        removeSendingPartsIfNeeded();
        this.timestampAdder.addDayDividers(this.parts);
        updateAdapterWithAnimations(arrayList, this.parts);
        this.conversationList.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                ConversationContentPresenter.this.opsMetricTracker.trackEvent(OpsMetricTracker.FINISH, OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_RENDER_RESULT);
                ViewUtils.removeGlobalLayoutListener(ConversationContentPresenter.this.conversationList, this);
            }
        });
    }

    private List<Avatar> getGroupConversationAvatars(List<Participant> list) {
        ArrayList arrayList = new ArrayList();
        for (Participant avatar : list) {
            arrayList.add(avatar.getAvatar());
        }
        return arrayList;
    }

    private void processLastParticipatingAdmin(Conversation conversation) {
        TeamPresenceState teamPresenceState;
        if (LastParticipatingAdmin.isNull(conversation.getLastParticipatingAdmin())) {
            addTeamPresencePart(false);
            return;
        }
        LastParticipatingAdmin lastParticipatingAdmin = conversation.getLastParticipatingAdmin();
        if (lastParticipatingAdmin.isBot()) {
            teamPresenceState = TeamPresenceViewHolderKt.getBotTeamPresence(lastParticipatingAdmin.getAvatar(), lastParticipatingAdmin.getFirstName(), lastParticipatingAdmin.getIntro(), getGroupParticipants(conversation));
        } else {
            teamPresenceState = TeamPresenceViewHolderKt.getAdminTeamPresence(lastParticipatingAdmin.getAvatar(), lastParticipatingAdmin.getFirstName(), lastParticipatingAdmin.getJobTitle(), lastParticipatingAdmin.getLocation().getCityName(), lastParticipatingAdmin.getLocation().getCountryName(), lastParticipatingAdmin.getIntro(), getGroupParticipants(conversation), lastParticipatingAdmin.getTwitter());
        }
        addTeamPresencePart(false, teamPresenceState);
    }

    private GroupParticipants getGroupParticipants(Conversation conversation) {
        if (!conversation.getGroupConversationParticipants().isEmpty()) {
            return new GroupParticipants(getGroupConversationAvatars(conversation.getGroupConversationParticipants()), GroupConversationTextFormatter.groupConversationLabel(this.context, conversation.getGroupConversationParticipants()).toString());
        }
        return null;
    }

    private void updateAdapterWithAnimations(List<Part> list, List<Part> list2) {
        int firstDifferentPartIndex = getFirstDifferentPartIndex(list, list2);
        if (firstDifferentPartIndex > -1) {
            this.adapter.notifyItemRangeChanged(0, firstDifferentPartIndex);
            int size = list.size() - firstDifferentPartIndex;
            if (size > 0) {
                this.adapter.notifyItemRangeRemoved(firstDifferentPartIndex, size);
            }
            int size2 = list2.size() - firstDifferentPartIndex;
            if (size2 > 0) {
                this.adapter.notifyItemRangeInserted(firstDifferentPartIndex, size2);
            }
        }
    }

    private int getFirstDifferentPartIndex(List<Part> list, List<Part> list2) {
        List<Part> list3 = list2.size() < list.size() ? list2 : list;
        int i = 0;
        int i2 = -1;
        while (true) {
            if (i >= list3.size()) {
                i = i2;
                break;
            } else if (!list.get(i).getMessageStyle().equals(list2.get(i).getMessageStyle())) {
                break;
            } else {
                i2 = i;
                i++;
            }
        }
        return list3.size() + -1 == i ? i + 1 : i;
    }

    private void processConversationParts(Conversation conversation) {
        for (int i = 0; i < conversation.getParts().size(); i++) {
            Part part = conversation.getParts().get(i);
            part.setParentConversation(conversation);
            if (i >= conversation.getParts().size() - 1 || !"quick_reply".equals(part.getMessageStyle())) {
                if (this.adapter.getViewForPart(part) == null) {
                    addViewForPart(part);
                }
                this.parts.add(part);
            }
        }
    }

    private void setupTicketProgressRow(Ticket ticket) {
        if (ticket != Ticket.Companion.getNULL()) {
            this.ticketProgressRow.setOnClick(new Function0() {
                public final Object invoke() {
                    return ConversationContentPresenter.this.lambda$setupTicketProgressRow$3$ConversationContentPresenter();
                }
            });
            this.ticketProgressRow.setName(ticket.getTitle());
            this.ticketProgressRow.setStatus(ticket.getCurrentStatus().getTitle());
        }
    }

    public /* synthetic */ Unit lambda$setupTicketProgressRow$3$ConversationContentPresenter() {
        this.context.startActivity(new Intent(this.context, IntercomTicketActivity.class));
        return null;
    }

    private void showTicketProgressRowIfNeeded() {
        if (!this.ticketProgressRow.getName().equals("") && !this.ticketProgressRow.getVisible()) {
            this.ticketProgressRow.setVisible(true);
            addConversationListTopPadding();
        }
    }

    public void addConversationListTopPadding() {
        int dimensionPixelSize = this.conversationList.getResources().getDimensionPixelSize(R.dimen.intercom_ticket_progress_row_padding);
        RecyclerView recyclerView = this.conversationList;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), this.conversationList.getPaddingTop() + dimensionPixelSize, this.conversationList.getPaddingRight(), this.conversationList.getPaddingBottom());
    }

    private boolean hasNonTicketParts(Conversation conversation) {
        for (Part messageStyle : conversation.getParts()) {
            if (!messageStyle.getMessageStyle().equals(Part.TICKET_UPDATED_MESSAGE_STYLE)) {
                return true;
            }
        }
        return false;
    }

    private int nonTicketPartsSize(Conversation conversation) {
        int i = 0;
        for (Part messageStyle : conversation.getParts()) {
            if (!messageStyle.getMessageStyle().equals(Part.TICKET_UPDATED_MESSAGE_STYLE)) {
                i++;
            }
        }
        return i;
    }

    private Boolean hasTicket(Conversation conversation) {
        return Boolean.valueOf(conversation.getTicket() != Ticket.Companion.getNULL());
    }

    private void addBigTicketCard(Conversation conversation) {
        Part build = new Part.Builder().withParticipantIsAdmin(true).withStyle(Part.BIG_TICKET_STYLE).withBlocks(Collections.singletonList(new Block.Builder())).build();
        this.adapter.setTicket(conversation.getTicket());
        this.parts.add(build);
    }

    private void setUpTopActionBar(Conversation conversation) {
        LastParticipatingAdmin lastParticipatingAdmin = conversation.getLastParticipatingAdmin();
        if (LastParticipatingAdmin.isNull(lastParticipatingAdmin)) {
            this.topActionBar.setAvatars(getTeamPresenceAvatars());
            setUpTopActionBar();
            return;
        }
        this.topActionBar.setActive(lastParticipatingAdmin.isActive());
        this.topActionBar.setTitle(lastParticipatingAdmin.getFirstName());
        if (!conversation.getGroupConversationParticipants().isEmpty()) {
            this.topActionBar.setSubtitle(GroupConversationTextFormatter.groupConversationTitle("", conversation.getGroupConversationParticipants().size(), this.context).toString());
        }
        this.topActionBar.setAvatars(Collections.singletonList(lastParticipatingAdmin.getAvatar()));
    }

    /* access modifiers changed from: package-private */
    public void setUpTopActionBar() {
        this.topActionBar.setTitle(this.appConfigProvider.get().getName());
    }

    /* access modifiers changed from: package-private */
    public void addTemporaryExpectationsMessage(Boolean bool) {
        String temporaryExpectationsMessage = this.appConfigProvider.get().getTemporaryExpectationsMessage();
        if (!temporaryExpectationsMessage.isEmpty()) {
            this.parts.add(0, new Part.Builder().withStyle(Part.TEMPORARY_EXPECTATIONS_LAYOUT).withBlocks(Collections.singletonList(new Block.Builder().withText(temporaryExpectationsMessage))).build());
            if (bool.booleanValue()) {
                this.adapter.notifyItemInserted(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void addTeamPresencePart(Boolean bool) {
        addTeamPresencePart(bool, new TeamPresenceState(getTeamPresenceAvatars(), this.teamPresence.getExpectedResponseDelayLongText(), this.appConfigProvider.get().getTeamProfileBio(), (String) null, (String) null, (GroupParticipants) null, (SocialAccount) null));
    }

    private List<Avatar> getTeamPresenceAvatars() {
        ArrayList arrayList = new ArrayList();
        for (Participant avatar : this.teamPresence.getActiveAdmins()) {
            arrayList.add(avatar.getAvatar());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void addTeamPresencePart(Boolean bool, TeamPresenceState teamPresenceState) {
        Part build = new Part.Builder().withStyle(Part.TEAM_PRESENCE_STYLE).build();
        this.adapter.setTeamPresenceState(teamPresenceState);
        this.parts.add(build);
        if (bool.booleanValue()) {
            this.adapter.notifyItemInserted(this.parts.indexOf(build));
        }
    }

    private void removeSendingPartsIfNeeded() {
        Iterator<Part> it = this.sendingParts.iterator();
        while (it.hasNext()) {
            Part next = it.next();
            if (next.getUpload() == null) {
                it.remove();
            } else {
                this.parts.add(next);
            }
        }
    }

    @Subscribe
    public void onUserContentSeenByAdmin(UserContentSeenByAdminEvent userContentSeenByAdminEvent) {
        if (userContentSeenByAdminEvent.getConversationId().equals(this.conversationId) && !this.parts.isEmpty()) {
            boolean z = false;
            for (int size = this.parts.size() - 1; size >= 0; size--) {
                Part part = this.parts.get(size);
                if (z || part.isAdmin()) {
                    part.setSeenByAdmin("hide");
                } else {
                    part.setSeenByAdmin(SeenState.SEEN);
                    z = true;
                }
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    public void cleanup() {
        this.conversationList.removeCallbacks(this.replyDeliveredUpdater);
    }

    @Subscribe
    public void newConversationSuccess(NewConversationEvent newConversationEvent) {
        if (!this.parts.isEmpty()) {
            List<Part> list = this.parts;
            if (list.get(list.size() - 1).getId().equals(newConversationEvent.getPartId())) {
                onNewConversation(newConversationEvent);
                this.host.onConversationCreated(newConversationEvent.getConversation());
            }
        }
    }

    @Subscribe
    public void newTriggerConversationSuccess(NewTriggerConversationEvent newTriggerConversationEvent) {
        updateSendPartOpsMetric();
        Conversation conversation = newTriggerConversationEvent.getConversation();
        this.conversationId = conversation.getId();
        this.parts.clear();
        this.sendingParts.clear();
        addTemporaryExpectationsMessage(false);
        processLastParticipatingAdmin(conversation);
        for (int i = 0; i < conversation.getParts().size(); i++) {
            addViewForPart(conversation.getParts().get(i));
            this.parts.add(conversation.getParts().get(i));
        }
        this.adapter.setConversationId(this.conversationId);
        this.adapter.notifyDataSetChanged();
        this.host.onConversationCreated(newTriggerConversationEvent.getConversation());
        this.store.dispatch(Actions.conversationMarkedAsRead(this.conversationId));
        this.nexusClient.fire(NexusEvent.getConversationSeenEvent(this.conversationId, this.userIdentity.getIntercomId()));
    }

    public void onQuickReplyClicked(Participant participant, Part part, ReplyOption replyOption) {
        Author.Builder builder = new Author.Builder();
        builder.withFirstName(participant.getForename()).withName(participant.getName()).withAvatar(participant.getAvatar().getImageUrl());
        Block.Builder builder2 = new Block.Builder();
        builder2.withText(replyOption.text()).withAuthor(builder.build()).withType(BlockType.PARAGRAPH.getSerializedName());
        ArrayList arrayList = new ArrayList();
        arrayList.add(builder2);
        Part addSendingPart = addSendingPart(arrayList);
        Part part2 = part;
        this.api.addConversationQuickReply(this.conversationId, part2, replyOption.uuid(), positionOfPart(this.parts.size() - 1, addSendingPart.getId()), addSendingPart.getId());
        this.metricTracker.clickedQuickReply(replyOption.uuid(), this.conversationId, part.getId());
    }

    /* access modifiers changed from: package-private */
    public void playSoundForNewAdminPart(List<Part> list) {
        for (Part next : list) {
            if (next.isAdmin()) {
                if (next.getParticipant().isBot().booleanValue()) {
                    this.soundPlayer.playOperatorReceivedSound();
                    return;
                } else {
                    this.soundPlayer.playMessageReceivedSound();
                    return;
                }
            }
        }
    }

    public void onSuggestionClicked(Part part, Suggestion suggestion) {
        Block.Builder builder = new Block.Builder();
        builder.withText(suggestion.getText()).withType(BlockType.PARAGRAPH.getSerializedName());
        ArrayList arrayList = new ArrayList();
        arrayList.add(builder);
        Part addSendingPart = addSendingPart(arrayList);
        String uuid = UUID.randomUUID().toString();
        this.store.dispatch(Actions.composerSuggestionSelected(uuid));
        this.api.triggerInboundCustomBot(addSendingPart, suggestion.getUuid(), positionOfPart(this.parts.size() - 1, addSendingPart.getId()), uuid);
        this.metricTracker.clickedComposerSuggestion(suggestion.getUuid(), this.conversationId, part.getId());
    }

    public void addBotIntro() {
        this.botIntro = this.store.state().botIntroState().getBotIntro();
        int size = this.parts.size();
        if (!BotIntro.BOT_INTRO_NULL.equals(this.botIntro)) {
            ArrayList arrayList = new ArrayList();
            for (List<Block.Builder> withBlocks : this.botIntro.getBlocks()) {
                Part build = new Part.Builder().withBlocks(withBlocks).build();
                build.setParticipant(this.botIntro.getBuiltParticipant());
                arrayList.add(build);
            }
            this.parts.addAll(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                addViewForPart((Part) it.next());
            }
            if (this.parts.size() > size) {
                this.adapter.notifyItemRangeInserted(size, this.parts.size() - size);
            }
        }
    }
}
