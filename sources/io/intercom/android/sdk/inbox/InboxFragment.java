package io.intercom.android.sdk.inbox;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.state.InboxState;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Selectors;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.StoreUtils;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.utilities.ViewUtils;
import io.intercom.android.sdk.utilities.WindowUtils;
import io.intercom.android.sdk.views.EndlessRecyclerScrollListener;
import io.intercom.android.sdk.views.EndlessScrollListener;
import io.intercom.android.sdk.views.IntercomErrorView;
import io.intercom.android.sdk.views.IntercomToolbar;
import java.util.List;

public class InboxFragment extends Fragment implements ConversationClickListener, EndlessScrollListener, IntercomToolbar.Listener, Store.Subscriber<InboxState> {
    private static final int FADE_DURATION_MS = 150;
    private InboxAdapter adapter;
    private Provider<AppConfig> appConfigProvider;
    private EndlessRecyclerScrollListener endlessRecyclerScrollListener;
    private IntercomErrorView inboxErrorView;
    RecyclerView inboxView;
    private IntercomToolbar intercomToolbar;
    private LinearLayoutManager layoutManager;
    Listener listener = Listener.EMPTY;
    private ProgressBar progressBar;
    private View rootView;
    /* access modifiers changed from: private */
    public Store<State> store;
    private Store.Subscription subscription;
    private final Twig twig = LumberMill.getLogger();
    private WallpaperLoader wallpaperLoader;

    public interface Listener {
        public static final Listener EMPTY = new Listener() {
            public void onBackClicked() {
            }

            public void onConversationSelected(Conversation conversation) {
            }

            public void onToolbarCloseClicked() {
            }
        };

        void onBackClicked();

        void onConversationSelected(Conversation conversation);

        void onToolbarCloseClicked();
    }

    public void onToolbarClicked() {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (Listener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context + " must implement InboxFragment.Listener");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Injector injector = Injector.get();
        this.store = injector.getStore();
        this.appConfigProvider = injector.getAppConfigProvider();
        FragmentActivity activity = getActivity();
        this.adapter = new InboxAdapter(LayoutInflater.from(activity), this, this.store, new TimeFormatter(activity, injector.getTimeProvider()), this.appConfigProvider, injector.getUserIdentity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        this.layoutManager = linearLayoutManager;
        this.endlessRecyclerScrollListener = new EndlessRecyclerScrollListener(linearLayoutManager, this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.twig.internal("inbox frag", "creating view for fragment");
        View view = this.rootView;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.intercom_fragment_inbox, viewGroup, false);
            this.rootView = inflate;
            this.progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
            setUpRecyclerView();
            IntercomErrorView intercomErrorView = (IntercomErrorView) this.rootView.findViewById(R.id.error_layout_inbox);
            this.inboxErrorView = intercomErrorView;
            intercomErrorView.setActionButtonTextColor(this.appConfigProvider.get().getPrimaryColor());
            this.inboxErrorView.setActionButtonClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    InboxFragment.this.store.dispatch(Actions.fetchInboxRequest());
                }
            });
            setUpToolbar();
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    InboxFragment.this.store.dispatch(Actions.fetchInboxRequest());
                }
            });
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.rootView);
            }
            setToolbarTitle();
            this.inboxView.setAdapter(this.adapter);
            this.inboxView.scheduleLayoutAnimation();
        }
        return this.rootView;
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.inbox_recycler_view);
        this.inboxView = recyclerView;
        recyclerView.setLayoutManager(this.layoutManager);
        this.inboxView.addOnScrollListener(this.endlessRecyclerScrollListener);
        this.inboxView.setAdapter(this.adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.intercom_list_divider));
        this.inboxView.addItemDecoration(dividerItemDecoration);
    }

    private void setUpToolbar() {
        IntercomToolbar intercomToolbar2 = (IntercomToolbar) this.rootView.findViewById(R.id.intercom_toolbar);
        this.intercomToolbar = intercomToolbar2;
        intercomToolbar2.updateToolbarSize();
        this.intercomToolbar.updateToolbarColors(this.appConfigProvider.get());
        this.intercomToolbar.setListener(this);
        this.intercomToolbar.setSubtitleVisibility(8);
        this.intercomToolbar.setLeftNavigationItemVisibility(0);
        setToolbarTitle();
        View findViewById = this.rootView.findViewById(R.id.intercom_inbox_content);
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingTop() + WindowUtils.getStatusBarHeight(getResources()), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        WallpaperLoader create = WallpaperLoader.create(getContext(), this.appConfigProvider);
        this.wallpaperLoader = create;
        this.intercomToolbar.loadWallpaper(create);
    }

    private boolean isInboundMessageEnabled() {
        return this.appConfigProvider.get().isInboundMessages();
    }

    public void onStart() {
        super.onStart();
        this.subscription = this.store.subscribeToChanges(Selectors.INBOX, this);
    }

    public void onResume() {
        this.store.dispatch(Actions.inboxOpened());
        this.inboxView.setAlpha(1.0f);
        setColorScheme();
        super.onResume();
    }

    public void onDestroyView() {
        this.intercomToolbar.closeWallpaperLoader(this.wallpaperLoader);
        super.onDestroyView();
    }

    private void setToolbarTitle() {
        this.intercomToolbar.setTitle(getString(R.string.intercom_conversations));
        animateHeaderIn();
    }

    private void animateHeaderIn() {
        this.intercomToolbar.findViewById(R.id.intercom_toolbar_title).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.intercom_profile_slide_in));
    }

    private void setColorScheme() {
        AppConfig appConfig = this.appConfigProvider.get();
        appConfig.getPrimaryColor();
        this.intercomToolbar.setBackgroundColor(appConfig.getSecondaryColor());
    }

    public void onStop() {
        StoreUtils.safeUnsubscribe(this.subscription);
        super.onStop();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = Listener.EMPTY;
    }

    private void fadeOutInbox(Animator.AnimatorListener animatorListener) {
        this.intercomToolbar.fadeOutTitle(150);
        this.inboxView.animate().alpha(0.0f).setDuration(150).setListener(animatorListener).start();
    }

    public void onConversationClicked(int i) {
        final Conversation conversation = this.store.state().inboxState().conversations().get(i);
        fadeOutInbox(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                InboxFragment.this.listener.onConversationSelected(conversation);
            }
        });
    }

    public void onLoadMore() {
        InboxState inboxState = this.store.state().inboxState();
        List<Conversation> conversations = inboxState.conversations();
        boolean z = conversations.size() <= 3;
        if (inboxState.status() != InboxState.Status.LOADING && !z) {
            this.store.dispatch(Actions.fetchInboxBeforeDateRequest(conversations.get(conversations.size() - 1).getLastPart().getCreatedAt()));
        }
    }

    public void setOverScrollColour() {
        ViewUtils.setOverScrollColour(this.inboxView, this.appConfigProvider.get().getPrimaryColor());
    }

    public void onCloseClicked() {
        this.listener.onToolbarCloseClicked();
    }

    public void onInboxClicked() {
        this.listener.onBackClicked();
    }

    public void onStateChange(InboxState inboxState) {
        this.adapter.setInboxState(inboxState);
        this.adapter.notifyDataSetChanged();
        this.endlessRecyclerScrollListener.setMorePagesAvailable(inboxState.hasMorePages());
        if (isAdded() && getView() != null) {
            int i = AnonymousClass4.$SwitchMap$io$intercom$android$sdk$state$InboxState$Status[inboxState.status().ordinal()];
            if (i == 1) {
                displayLoadingView();
            } else if (i != 2) {
                if (i != 3) {
                    displayErrorView();
                    return;
                }
                if (this.layoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    this.layoutManager.scrollToPosition(0);
                }
                if (inboxState.conversations().isEmpty()) {
                    displayEmptyView();
                } else {
                    displayInbox();
                }
            } else if (inboxState.conversations().isEmpty()) {
                displayLoadingView();
            } else {
                displayInbox();
            }
        }
    }

    /* renamed from: io.intercom.android.sdk.inbox.InboxFragment$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$state$InboxState$Status;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.intercom.android.sdk.state.InboxState$Status[] r0 = io.intercom.android.sdk.state.InboxState.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$state$InboxState$Status = r0
                io.intercom.android.sdk.state.InboxState$Status r1 = io.intercom.android.sdk.state.InboxState.Status.INITIAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$state$InboxState$Status     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.state.InboxState$Status r1 = io.intercom.android.sdk.state.InboxState.Status.LOADING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$state$InboxState$Status     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.state.InboxState$Status r1 = io.intercom.android.sdk.state.InboxState.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$state$InboxState$Status     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.state.InboxState$Status r1 = io.intercom.android.sdk.state.InboxState.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.inbox.InboxFragment.AnonymousClass4.<clinit>():void");
        }
    }

    private void displayLoadingView() {
        this.inboxErrorView.setVisibility(8);
        this.inboxView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    private void displayInbox() {
        this.inboxView.setVisibility(0);
        this.inboxErrorView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    private void displayEmptyView() {
        this.inboxErrorView.setTitle(R.string.intercom_no_conversations);
        this.inboxErrorView.setSubtitle(Phrase.from(getContext(), R.string.intercom_empty_conversations).put("name", (CharSequence) this.appConfigProvider.get().getName()).format());
        this.inboxErrorView.setActionButtonVisibility(8);
        this.inboxErrorView.setVisibility(0);
        this.inboxView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }

    private void displayErrorView() {
        this.inboxErrorView.setTitle(R.string.intercom_inbox_error_state_title);
        this.inboxErrorView.setSubtitle(R.string.intercom_failed_to_load_conversation);
        this.inboxErrorView.setActionButtonText(R.string.intercom_retry);
        this.inboxErrorView.setActionButtonVisibility(0);
        this.inboxErrorView.setVisibility(0);
        this.inboxView.setVisibility(8);
        this.progressBar.setVisibility(8);
    }
}
