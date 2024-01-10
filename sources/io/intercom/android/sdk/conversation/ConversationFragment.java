package io.intercom.android.sdk.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
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
import io.intercom.android.sdk.activities.ConversationReactionListener;
import io.intercom.android.sdk.activities.IntercomPostActivity;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.BlockFactory;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.BlockAttachment;
import io.intercom.android.sdk.blocks.logic.TextSplittingStrategy;
import io.intercom.android.sdk.conversation.ConversationContentPresenter;
import io.intercom.android.sdk.conversation.ConversationPartAdapter;
import io.intercom.android.sdk.conversation.composer.ComposerPresenter;
import io.intercom.android.sdk.conversation.events.AdminIsTypingEvent;
import io.intercom.android.sdk.helpcenter.articles.ArticleStatsArguments;
import io.intercom.android.sdk.homescreen.ConversationListExtensionsKt;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.m5.components.NewConversationCard;
import io.intercom.android.sdk.m5.components.TopActionBar;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.Ticket;
import io.intercom.android.sdk.models.events.ConversationEvent;
import io.intercom.android.sdk.models.events.ReplyEvent;
import io.intercom.android.sdk.models.events.failure.ConversationFailedEvent;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.tickets.TicketProgressRow;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import io.intercom.android.sdk.utilities.KeyboardUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.StoreUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.utilities.connectivity.NetworkConnectivityMonitor;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.android.sdk.views.IntercomToolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class ConversationFragment extends Fragment implements ConversationPartAdapter.Listener, IntercomToolbar.Listener, Store.Subscriber2<Integer, TeamPresence>, ConversationContentPresenter.Host {
    private static final String ARG_ARTICLE_ARGS = "articleArgs";
    private static final String ARG_CLOSED_CONVERSATION_ID = "closed_conversation_id";
    private static final String ARG_CONVERSATION_ID = "conversationId";
    private static final String ARG_GROUP_PARTICIPANTS = "group_participants";
    private static final String ARG_INITIAL_MESSAGE = "initial_message";
    private static final String ARG_IS_READ = "intercomsdk-isRead";
    private static final String ARG_LAST_PARTICIPANT = "last_participant";
    private static final int COMPOSER_LIGHTBOX_REQUEST_CODE = 25;
    private static final String EXTRA_GALLERY_IMAGE = "gallery_image";
    private static final String IMAGE_MIME_TYPE = "image";
    Provider<AppConfig> appConfigProvider;
    ArticleStatsArguments articleStatsArguments;
    private Bus bus;
    private boolean canOpenProfile = true;
    private String closedConversationId = "";
    private RelativeLayout composerHolder;
    private final ComposerPresenter.Listener composerListener = new ComposerPresenter.Listener() {
        private final BlockFactory blockFactory = new BlockFactory(new TextSplittingStrategy());

        static /* synthetic */ void lambda$showUploadError$0(DialogInterface dialogInterface, int i) {
        }

        public void onSendButtonPressed(CharSequence charSequence) {
            String trim = charSequence.toString().trim();
            if (!trim.isEmpty()) {
                ConversationFragment.this.opsMetricTracker.trackEvent("start", OpsMetricTracker.SEND_PART_TIME_TO_PROCESS_ACTION);
                ConversationFragment.this.contentPresenter.sendPart(this.blockFactory.getBlocksForText(trim));
                if (TextUtils.isEmpty(ConversationFragment.this.conversationId)) {
                    ConversationFragment.this.rootView.findViewById(R.id.disabled_view).setVisibility(0);
                }
            }
        }

        public void onUploadImageSelected(GalleryImage galleryImage) {
            if (((long) galleryImage.getFileSize()) > ConversationFragment.this.appConfigProvider.get().getUploadSizeLimit()) {
                showUploadError();
            } else {
                ConversationFragment.this.contentPresenter.uploadImage(createBlocks(galleryImage), galleryImage);
            }
        }

        private List<Block.Builder> createBlocks(GalleryImage galleryImage) {
            ArrayList arrayList = new ArrayList();
            if (galleryImage.getMimeType().contains("image")) {
                arrayList.add(new Block.Builder().withUri(galleryImage.getUri()).withType(BlockType.LOCALIMAGE.name()).withWidth(galleryImage.getImageWidth()).withHeight(galleryImage.getImageHeight()));
            } else {
                arrayList.add(new Block.Builder().withAttachments(Collections.singletonList(new BlockAttachment.Builder().withName(galleryImage.getFileName()).withUrl(galleryImage.getUri().toString()).withContentType(galleryImage.getMimeType()).build())).withType(BlockType.LOCAL_ATTACHMENT.name()));
            }
            return arrayList;
        }

        private void showUploadError() {
            new AlertDialog.Builder(ConversationFragment.this.getActivity()).setTitle(R.string.intercom_failed_to_send).setMessage(Phrase.from(ConversationFragment.this.getContext(), R.string.intercom_file_too_big).put("limit", (CharSequence) String.valueOf((ConversationFragment.this.appConfigProvider.get().getUploadSizeLimit() / 1024) / 1024)).format()).setPositiveButton(17039370, (DialogInterface.OnClickListener) $$Lambda$ConversationFragment$6$a0uPpO9y93QmiAtvEZkpOz9cA60.INSTANCE).show();
        }

        public void onRemoteImageSelected(GalleryImage galleryImage) {
            ConversationFragment.this.contentPresenter.sendPart(Collections.singletonList(new Block.Builder().withType("image").withUrl(galleryImage.getUri().toString()).withAttribution(galleryImage.getAttribution()).withHeight(galleryImage.getImageHeight()).withWidth(galleryImage.getImageWidth())));
            ConversationFragment.this.composerPresenter.returnToDefaultInput();
        }
    };
    ComposerPresenter composerPresenter;
    private Store.Subscription composerSuggestionsSubscription;
    private final NetworkConnectivityMonitor.ConnectivityEventListener connectivityEventListener = new NetworkConnectivityMonitor.ConnectivityEventListener() {
        public void onDisconnect() {
            Snackbar.make(ConversationFragment.this.rootView, R.string.intercom_no_network_connection, -2).show();
        }

        public void onReconnect() {
            Snackbar.make(ConversationFragment.this.rootView, R.string.intercom_connected, 0).setActionTextColor(ConversationFragment.this.appConfigProvider.get().getPrimaryColor()).setAction(R.string.intercom_dismiss, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                }
            }).show();
        }
    };
    ConversationContentPresenter contentPresenter;
    Conversation conversation;
    String conversationId;
    private ConversationPartAdapter conversationPartAdapter;
    private int currentOrientation;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        private int previousHeight;

        public void onGlobalLayout() {
            int height = ConversationFragment.this.rootView.getHeight();
            if (this.previousHeight != 0 && !ConversationFragment.this.orientationChanged && this.previousHeight > height && ConversationFragment.this.shouldStayAtBottom) {
                ConversationFragment.this.contentPresenter.scrollToBottom();
                ConversationFragment.this.shouldStayAtBottom = false;
            }
            if (ConversationFragment.this.orientationChanged && this.previousHeight != height) {
                ConversationFragment.this.orientationChanged = false;
            }
            this.previousHeight = height;
        }
    };
    private List<Participant> groupParticipants;
    private boolean hasLoadedConversation = false;
    private String initialMessage = "";
    private IntercomErrorView intercomErrorView;
    private CharSequence lastActiveTime;
    private LastParticipatingAdmin lastParticipant;
    Listener listener;
    private MetricTracker metricTracker;
    final NetworkConnectivityMonitor networkConnectivityMonitor = new NetworkConnectivityMonitor();
    private NewConversationCard newConversationCard;
    private NexusClient nexusClient;
    /* access modifiers changed from: private */
    public OpsMetricTracker opsMetricTracker;
    boolean orientationChanged = false;
    private final ProfileExpansionLogic profileExpansionLogic = new ProfileExpansionLogic();
    private ReactionInputView reactionComposer;
    View rootView;
    boolean shouldStayAtBottom = false;
    Store<State> store;
    private Store.Subscription subscription;
    private TimeProvider timeProvider;
    private UserIdentity userIdentity;

    public interface Listener {
        void onBackClicked();

        void onStartAnotherConversation(String str);

        void onToolbarCloseClicked();
    }

    public void onToolbarClicked() {
    }

    public static ConversationFragment newInstance(String str, LastParticipatingAdmin lastParticipatingAdmin, boolean z, String str2, List<Participant> list, String str3, ArticleStatsArguments articleStatsArguments2) {
        ConversationFragment conversationFragment = new ConversationFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CONVERSATION_ID, str);
        bundle.putString(ARG_INITIAL_MESSAGE, str2);
        bundle.putString(ARG_CLOSED_CONVERSATION_ID, str3);
        bundle.putParcelable(ARG_LAST_PARTICIPANT, lastParticipatingAdmin);
        bundle.putParcelableArrayList(ARG_GROUP_PARTICIPANTS, new ArrayList(list));
        bundle.putBoolean(ARG_IS_READ, z);
        bundle.putParcelable(ARG_ARTICLE_ARGS, articleStatsArguments2);
        bundle.setClassLoader(Part.class.getClassLoader());
        conversationFragment.setArguments(bundle);
        return conversationFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (Listener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context + " must implement ConversationFragment.Listener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Injector injector = Injector.get();
        this.bus = injector.getBus();
        this.nexusClient = injector.getNexusClient();
        this.appConfigProvider = injector.getAppConfigProvider();
        this.userIdentity = injector.getUserIdentity();
        this.store = injector.getStore();
        this.timeProvider = injector.getTimeProvider();
        this.metricTracker = injector.getMetricTracker();
        OpsMetricTracker opsMetricTracker2 = injector.getOpsMetricTracker();
        this.opsMetricTracker = opsMetricTracker2;
        opsMetricTracker2.trackEvent("start", OpsMetricTracker.LOAD_CONVERSATION_TIME_TO_PROCESS_ACTION);
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.setClassLoader(Part.class.getClassLoader());
            this.conversationId = arguments.getString(ARG_CONVERSATION_ID, "");
            this.initialMessage = arguments.getString(ARG_INITIAL_MESSAGE, "");
            ArticleStatsArguments articleStatsArguments2 = (ArticleStatsArguments) arguments.getParcelable(ARG_ARTICLE_ARGS);
            this.articleStatsArguments = articleStatsArguments2;
            if (articleStatsArguments2 == null) {
                this.articleStatsArguments = new ArticleStatsArguments();
            }
            LastParticipatingAdmin lastParticipatingAdmin = (LastParticipatingAdmin) arguments.getParcelable(ARG_LAST_PARTICIPANT);
            this.lastParticipant = lastParticipatingAdmin;
            if (lastParticipatingAdmin == null) {
                this.lastParticipant = LastParticipatingAdmin.NULL;
            }
            ArrayList parcelableArrayList = arguments.getParcelableArrayList(ARG_GROUP_PARTICIPANTS);
            this.groupParticipants = parcelableArrayList;
            if (parcelableArrayList == null) {
                this.groupParticipants = new ArrayList();
            }
            if (!arguments.getBoolean(ARG_IS_READ, false)) {
                this.store.dispatch(Actions.conversationMarkedAsRead(this.conversationId));
            }
            this.closedConversationId = arguments.getString(ARG_CLOSED_CONVERSATION_ID, "");
            if (TextUtils.isEmpty(this.conversationId)) {
                this.store.dispatch(Actions.composerOpened());
            } else {
                this.store.dispatch(Actions.conversationOpened(this.conversationId));
            }
        }
        this.conversation = new Conversation();
        this.currentOrientation = getResources().getConfiguration().orientation;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25 && intent != null && intent.hasExtra("gallery_image")) {
            this.composerListener.onUploadImageSelected((GalleryImage) intent.getParcelableExtra("gallery_image"));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.rootView;
        if (view == null) {
            this.rootView = layoutInflater.inflate(R.layout.intercom_fragment_conversation, viewGroup, false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
        }
        this.composerHolder = (RelativeLayout) this.rootView.findViewById(R.id.composer_holder);
        IntercomErrorView intercomErrorView2 = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_conversation);
        this.intercomErrorView = intercomErrorView2;
        intercomErrorView2.setActionButtonTextColor(this.appConfigProvider.get().getPrimaryColor());
        this.intercomErrorView.setActionButtonClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationFragment.this.displayLoadingView();
                ConversationFragment.this.contentPresenter.fetchConversation(ConversationFragment.this.conversationId);
            }
        });
        this.reactionComposer = (ReactionInputView) this.rootView.findViewById(R.id.reaction_input_view);
        this.newConversationCard = (NewConversationCard) this.rootView.findViewById(R.id.new_conversation_card);
        this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        return this.rootView;
    }

    /* access modifiers changed from: package-private */
    public void displayLoadingView() {
        if (isAdded()) {
            this.intercomErrorView.setVisibility(8);
            this.composerPresenter.hideComposer();
            this.contentPresenter.showLoadingView();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        View view2 = view;
        super.onViewCreated(view, bundle);
        this.contentPresenter = createContentPresenter(view);
        FrameLayout frameLayout = (FrameLayout) this.rootView.findViewById(R.id.composer_container);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ConversationFragment.this.contentPresenter.isAtBottom()) {
                    ConversationFragment.this.shouldStayAtBottom = true;
                }
            }
        });
        TopActionBar topActionBar = (TopActionBar) view2.findViewById(R.id.conversation_top_action_bar);
        topActionBar.setOnBackClick(new Function0() {
            public final Object invoke() {
                return ConversationFragment.this.lambda$onViewCreated$0$ConversationFragment();
            }
        });
        topActionBar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ConversationFragment.this.lambda$onViewCreated$1$ConversationFragment(view);
            }
        });
        this.composerPresenter = new ComposerPresenter(this.composerListener, frameLayout, getChildFragmentManager(), LayoutInflater.from(view.getContext()), this.nexusClient, this.userIdentity, this.appConfigProvider, this.metricTracker, this.conversationId, this.initialMessage, this.store, getActivity(), this.appConfigProvider.get().getPrimaryColor(), this.closedConversationId);
        this.contentPresenter.setup();
        this.composerPresenter.requestFocus();
        configureInputView(this.conversation);
        if (this.conversationId.isEmpty()) {
            this.contentPresenter.addTemporaryExpectationsMessage(true);
            this.contentPresenter.addTeamPresencePart(true);
            this.contentPresenter.addBotIntro();
            showSuggestionsIfAvailable();
            this.contentPresenter.setUpTopActionBar();
        } else {
            this.composerPresenter.setConversationId(this.conversationId);
            displayLoadingView();
        }
        if (this.conversationId.isEmpty()) {
            this.canOpenProfile = false;
            view2.postDelayed(new Runnable() {
                public void run() {
                    if (ConversationFragment.this.getActivity() != null) {
                        ConversationFragment.this.contentPresenter.smoothScrollToTop();
                    }
                }
            }, 50);
        }
    }

    public /* synthetic */ Unit lambda$onViewCreated$0$ConversationFragment() {
        this.listener.onBackClicked();
        return null;
    }

    public /* synthetic */ void lambda$onViewCreated$1$ConversationFragment(View view) {
        this.contentPresenter.smoothScrollToTop();
    }

    private void showSuggestionsIfAvailable() {
        showConversationWithSuggestions((ComposerSuggestions) this.store.select(Selectors.COMPOSER_SUGGESTIONS));
        this.composerSuggestionsSubscription = this.store.subscribeToChanges(Selectors.COMPOSER_SUGGESTIONS, new Store.Subscriber() {
            public final void onStateChange(Object obj) {
                ConversationFragment.this.showConversationWithSuggestions((ComposerSuggestions) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showConversationWithSuggestions(ComposerSuggestions composerSuggestions) {
        if (!ComposerSuggestions.UNKNOWN.equals(composerSuggestions) && this.conversationId.isEmpty() && !composerSuggestions.isLoading()) {
            this.contentPresenter.addComposerSuggestionsPart(composerSuggestions);
        }
    }

    private ConversationContentPresenter createContentPresenter(View view) {
        View view2 = view;
        Injector injector = Injector.get();
        Blocks blocks = r0;
        Blocks blocks2 = new Blocks(getActivity(), LumberMill.getBlocksTwig());
        Api api = injector.getApi();
        ArrayList arrayList = r1;
        ArrayList arrayList2 = new ArrayList();
        this.conversationPartAdapter = ConversationPartAdapter.create(getActivity(), arrayList2, this, api, this.conversationId, this.appConfigProvider, this.userIdentity, this.timeProvider, new ContextLocaliser(this.appConfigProvider), this.metricTracker, getActivity().getApplication().getResources().getConfiguration().locale);
        SoundPlayer soundPlayer = r0;
        SoundPlayer soundPlayer2 = new SoundPlayer(getActivity(), this.appConfigProvider);
        return ConversationContentPresenter.create(this, (RecyclerView) view2.findViewById(R.id.conversation_list), (TicketProgressRow) view2.findViewById(R.id.conversation_ticket_progress_row), (TopActionBar) view2.findViewById(R.id.conversation_top_action_bar), this.conversationPartAdapter, this.appConfigProvider, api, arrayList, this.conversationId, soundPlayer, blocks, this.userIdentity, this.opsMetricTracker, getActivity(), this.store, this.nexusClient, this.articleStatsArguments);
    }

    private void configureInputView(Conversation conversation2) {
        Part lastPart = conversation2.getLastPart();
        if (((ComposerSuggestions) this.store.select(Selectors.COMPOSER_SUGGESTIONS)).isComposerDisabled() && this.conversationId.isEmpty()) {
            this.composerPresenter.hideComposer();
            this.reactionComposer.setVisibility(8);
        } else if (conversation2.shouldPreventEndUserReplies()) {
            showConversationEndedView();
        } else if (!ReactionReply.isNull(lastPart.getReactionReply()) || !conversation2.getComposerState().isVisible()) {
            this.reactionComposer.setUpReactions(lastPart.getReactionReply(), true, new ConversationReactionListener(MetricTracker.ReactionLocation.CONVERSATION, lastPart.getId(), conversation2.getId(), Injector.get().getApi(), this.metricTracker));
            this.composerPresenter.hideComposer();
        } else {
            this.composerPresenter.showComposer();
            this.composerPresenter.requestFocus();
            this.reactionComposer.setVisibility(8);
        }
    }

    private void showConversationEndedView() {
        KeyboardUtils.hideKeyboard(this.composerHolder);
        this.composerPresenter.hideComposer();
        this.newConversationCard.setVisibility(0);
        if (!shouldHideNewConversationButton()) {
            this.newConversationCard.setOnNewConversationClick(new Function0() {
                public final Object invoke() {
                    return ConversationFragment.this.lambda$showConversationEndedView$2$ConversationFragment();
                }
            });
        }
    }

    public /* synthetic */ Unit lambda$showConversationEndedView$2$ConversationFragment() {
        this.listener.onStartAnotherConversation(this.conversationId);
        return null;
    }

    private boolean shouldHideNewConversationButton() {
        boolean z = this.appConfigProvider.get().isPreventMultipleInboundConversationsEnabled() && ConversationListExtensionsKt.hasRecentInboundConversation(this.store.state().inboxState().conversations(), this.timeProvider.currentTimeMillis());
        if (!this.appConfigProvider.get().isInboundMessages() || this.conversation.getInboundConversationsDisabled() || z) {
            return true;
        }
        return false;
    }

    private void animateComposerIn() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.intercom_composer_slide_up);
        this.composerHolder.setVisibility(0);
        this.composerHolder.startAnimation(loadAnimation);
    }

    /* access modifiers changed from: package-private */
    public void displayConversation() {
        if (isAdded()) {
            this.intercomErrorView.setVisibility(8);
            this.contentPresenter.showContentView();
            configureInputView(this.conversation);
        }
    }

    public void onStart() {
        super.onStart();
        this.networkConnectivityMonitor.startListening(getActivity());
        this.networkConnectivityMonitor.setListener(this.connectivityEventListener);
        this.subscription = this.store.subscribeToChanges(Selectors.UNREAD_COUNT, Selectors.TEAM_PRESENCE, this);
        this.bus.register(this);
        this.bus.register(this.contentPresenter);
        this.contentPresenter.fetchConversation(this.conversationId);
    }

    /* access modifiers changed from: package-private */
    public boolean hasNotLoadedLastAdminForExistingConversation() {
        return !this.hasLoadedConversation && !this.conversationId.isEmpty() && LastParticipatingAdmin.isNull(this.lastParticipant);
    }

    private void updateProfileToolbar(TeamPresence teamPresence) {
        if (getActivity() != null && !LastParticipatingAdmin.isNull(this.lastParticipant) && this.lastParticipant != LastParticipatingAdmin.NONE) {
            updateLastActiveTime();
        }
    }

    private void updateLastActiveTime() {
        if (this.conversation.getLastParticipatingAdmin() != null && getActivity() != null) {
            this.lastActiveTime = new TimeFormatter(getActivity(), this.timeProvider).getAdminActiveStatus(this.lastParticipant, this.appConfigProvider);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation != this.currentOrientation) {
            this.orientationChanged = true;
            this.composerPresenter.updateMaxLines();
        }
        this.currentOrientation = configuration.orientation;
    }

    public void onStateChange(Integer num, TeamPresence teamPresence) {
        if (!hasNotLoadedLastAdminForExistingConversation()) {
            updateProfileToolbar(teamPresence);
        }
    }

    public void onStop() {
        StoreUtils.safeUnsubscribe(this.subscription);
        this.bus.unregister(this);
        this.bus.unregister(this.contentPresenter);
        this.networkConnectivityMonitor.setListener((NetworkConnectivityMonitor.ConnectivityEventListener) null);
        this.networkConnectivityMonitor.stopListening(getActivity());
        this.opsMetricTracker.clear();
        super.onStop();
    }

    public void onDestroyView() {
        StoreUtils.safeUnsubscribe(this.composerSuggestionsSubscription);
        ViewUtils.removeGlobalLayoutListener(this.rootView, this.globalLayoutListener);
        this.composerPresenter.cleanup();
        this.contentPresenter.cleanup();
        super.onDestroyView();
    }

    public void onDestroy() {
        this.store.dispatch(Actions.conversationClosed());
        super.onDestroy();
    }

    public void sdkWindowFinishedAnimating() {
        if (getView() != null && this.profileExpansionLogic.shouldExpandProfile(this.conversation)) {
            this.contentPresenter.smoothScrollToTop();
        }
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Conversation getConversation() {
        return this.conversation;
    }

    public void onConversationCreated(Conversation conversation2) {
        this.rootView.findViewById(R.id.disabled_view).setVisibility(8);
        this.conversation = conversation2;
        String id = conversation2.getId();
        this.conversationId = id;
        this.composerPresenter.setConversationId(id);
        this.composerPresenter.setHint(R.string.intercom_reply_to_conversation);
        this.nexusClient.fire(NexusEvent.getNewCommentEvent(this.conversationId, this.userIdentity.getIntercomId()));
        Part part = conversation2.getParts().get(0);
        if (TextUtils.isEmpty(this.closedConversationId)) {
            this.metricTracker.sentInNewConversation(part.hasAttachments(), part.isGifOnlyPart(), part.getId(), this.conversationId, ((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE)).getOfficeHours().isEmpty());
            this.metricTracker.startConversation(this.conversationId);
        } else {
            this.metricTracker.sentInNewFollowupConversation(part.hasAttachments(), part.isGifOnlyPart(), part.getId(), this.conversationId, ((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE)).getOfficeHours().isEmpty(), this.closedConversationId);
            this.metricTracker.startFollowupConversation(this.conversationId, this.closedConversationId);
        }
        this.hasLoadedConversation = true;
        configureInputView(conversation2);
    }

    public void onFormSubmitted() {
        this.composerPresenter.clearFocus();
        this.composerPresenter.requestFocus();
    }

    @Subscribe
    public void conversationSuccess(ConversationEvent conversationEvent) {
        int size = this.conversation.getParts().size();
        boolean z = false;
        boolean z2 = size == 0 && this.conversation.getTicket() == Ticket.Companion.getNULL();
        List<Part> parts = conversationEvent.getResponse().getParts();
        if (parts.size() > size) {
            z = true;
        }
        if (conversationEvent.getResponse().getId().equals(this.conversationId)) {
            this.conversation = conversationEvent.getResponse();
            if (isAdded()) {
                this.contentPresenter.onConversationFetched(conversationEvent, z2);
                displayConversation();
            }
            boolean z3 = !this.conversation.isRead();
            if (z3) {
                markConversationAsRead();
            }
            if (z2) {
                animateComposerIn();
                if (parts.size() > 0) {
                    Part part = parts.get(parts.size() - 1);
                    if (part.isReply() && z3) {
                        trackLastPart(part);
                    }
                }
                this.contentPresenter.scrollToBottom();
            } else if (z) {
                List<Part> subList = parts.subList(size, parts.size());
                this.contentPresenter.playSoundForNewAdminPart(subList);
                this.contentPresenter.onNewPartReceived(this.conversation);
                trackLastPart(subList.get(subList.size() - 1));
            }
        }
        this.lastParticipant = this.conversation.getLastParticipatingAdmin();
        this.groupParticipants = this.conversation.getGroupConversationParticipants();
        if (this.lastParticipant != null) {
            updateLastActiveTime();
        }
        updateProfileToolbar((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE));
        this.hasLoadedConversation = true;
    }

    private void markConversationAsRead() {
        Injector.get().getApi().markConversationAsRead(this.conversationId);
        this.store.dispatch(Actions.conversationMarkedAsRead(this.conversationId));
        this.nexusClient.fire(NexusEvent.getConversationSeenEvent(this.conversationId, this.userIdentity.getIntercomId()));
    }

    private void trackLastPart(Part part) {
        if (part.isLinkList()) {
            this.metricTracker.receivedOperatorReply(this.conversationId);
        } else {
            this.metricTracker.receivedReply(part.hasAttachments(), part.isLinkCard(), part.getId(), this.conversationId);
        }
    }

    @Subscribe
    public void conversationFailure(ConversationFailedEvent conversationFailedEvent) {
        if (isAdded()) {
            displayErrorView();
        }
    }

    private void displayErrorView() {
        this.intercomErrorView.setVisibility(0);
        this.composerHolder.setVisibility(8);
        this.contentPresenter.showErrorView();
    }

    @Subscribe
    public void replySuccess(ReplyEvent replyEvent) {
        if (replyEvent.getConversationId().equals(this.conversationId)) {
            this.nexusClient.fire(NexusEvent.getNewCommentEvent(this.conversationId, this.userIdentity.getIntercomId()));
            Part response = replyEvent.getResponse();
            Participant participant = this.conversation.getParticipant(response.getParticipantId());
            if (participant == Participant.NULL) {
                participant = new Participant.Builder().withId(response.getParticipantId()).build();
                this.conversation.getParticipants().put(response.getParticipantId(), participant);
            }
            response.setParticipant(participant);
            this.contentPresenter.onReplyDelivered(replyEvent);
            this.metricTracker.sentInConversation(response.hasAttachments(), response.isGifOnlyPart(), response.getId(), this.conversationId, ((TeamPresence) this.store.select(Selectors.TEAM_PRESENCE)).getOfficeHours().isEmpty(), this.lastParticipant.isActive(), new TimeFormatter(getActivity(), this.timeProvider).getLastActiveMinutes(this.lastParticipant.getLastActiveAt()));
        }
    }

    @Subscribe
    public void adminIsTyping(AdminIsTypingEvent adminIsTypingEvent) {
        if (this.conversationId.equals(adminIsTypingEvent.getConversationId())) {
            this.contentPresenter.onAdminStartedTyping(adminIsTypingEvent);
        }
    }

    public void onPartClicked(Part part) {
        this.contentPresenter.onPartClicked(part);
    }

    public void onPostCardClicked(Part part) {
        startActivity(IntercomPostActivity.buildPostIntent(getContext(), part, "", this.lastParticipant, this.conversation.getComposerState().isVisible(), false));
    }

    public void onCloseClicked() {
        this.listener.onToolbarCloseClicked();
    }

    public void onInboxClicked() {
        this.composerPresenter.cleanup();
        this.listener.onBackClicked();
    }

    public boolean shouldHandleOnBackPressed() {
        ComposerPresenter composerPresenter2 = this.composerPresenter;
        return composerPresenter2 != null && composerPresenter2.isOpen();
    }

    public void handleOnBackPressed() {
        this.composerPresenter.onBackPressed();
    }
}
