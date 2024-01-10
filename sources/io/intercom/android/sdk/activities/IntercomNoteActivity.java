package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.LightboxOpeningImageClickListener;
import io.intercom.android.sdk.blocks.LinkOpeningButtonClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.lib.BlocksViewHolder;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.ActiveStatePresenter;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import io.intercom.android.sdk.views.IntercomToolbar;

public class IntercomNoteActivity extends IntercomBaseActivity implements View.OnClickListener {
    private static final String COMPOSER_IS_VISIBLE = "composer_is_visible";
    private static final String LAST_PARTICIPANT = "last_participant";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_PART = "parcel_part";
    /* access modifiers changed from: private */
    public boolean composerIsVisible = true;
    View composerLayout;
    String conversationId;
    private LastParticipatingAdmin lastParticipatingAdmin;
    MetricTracker metricTracker;
    private LinearLayout noteLayout;
    Part part;
    private final FullScreenInAppPresenter presenter = new FullScreenInAppPresenter();
    ReactionInputView reactionComposer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_note);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.note_layout);
        this.noteLayout = linearLayout;
        linearLayout.setVisibility(4);
        this.reactionComposer = (ReactionInputView) findViewById(R.id.reaction_input_view);
        IntercomToolbar intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
        intercomToolbar.setListener(new InAppToolbarListener(this));
        this.part = new Part();
        this.lastParticipatingAdmin = LastParticipatingAdmin.NULL;
        Injector injector = Injector.get();
        Api api = injector.getApi();
        this.metricTracker = injector.getMetricTracker();
        Provider<AppConfig> appConfigProvider = injector.getAppConfigProvider();
        TimeFormatter timeFormatter = new TimeFormatter(this, injector.getTimeProvider());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            if (extras.containsKey(PARCEL_PART)) {
                Part part2 = (Part) extras.getParcelable(PARCEL_PART);
                this.part = part2;
                intercomToolbar.setTitle(Phrase.from((Context) this, R.string.intercom_teammate_from_company).put("name", (CharSequence) (part2 == null || part2.getParticipant() == null) ? "" : this.part.getParticipant().getForename()).put("company", (CharSequence) appConfigProvider.get().getName()).format());
            }
            if (extras.containsKey(PARCEL_CONVERSATION_ID)) {
                this.conversationId = extras.getString(PARCEL_CONVERSATION_ID);
                injector.getStore().dispatch(Actions.conversationMarkedAsRead(this.conversationId));
                api.markConversationAsRead(this.conversationId);
            }
            if (extras.containsKey(LAST_PARTICIPANT)) {
                LastParticipatingAdmin lastParticipatingAdmin2 = (LastParticipatingAdmin) extras.getParcelable(LAST_PARTICIPANT);
                this.lastParticipatingAdmin = lastParticipatingAdmin2;
                if (!LastParticipatingAdmin.isNull(lastParticipatingAdmin2)) {
                    intercomToolbar.setSubtitle(timeFormatter.getAdminActiveStatus(this.lastParticipatingAdmin, appConfigProvider));
                }
            }
            if (extras.containsKey(COMPOSER_IS_VISIBLE)) {
                this.composerIsVisible = extras.getBoolean(COMPOSER_IS_VISIBLE, true);
            }
        }
        intercomToolbar.setUpNoteToolbar(this.part.getParticipant(), this.lastParticipatingAdmin.isActive(), new ActiveStatePresenter(), appConfigProvider.get());
        BlocksViewHolder noteHolder = new ViewHolderGenerator(new UploadingImageCache(), api, appConfigProvider, this.conversationId, new LightboxOpeningImageClickListener(api), new LinkOpeningButtonClickListener(api), injector.getGson(), injector.getBus(), this.metricTracker, this).getNoteHolder();
        this.composerLayout = findViewById(R.id.note_composer_container);
        final ContentAwareScrollView contentAwareScrollView = (ContentAwareScrollView) findViewById(R.id.note_view);
        contentAwareScrollView.addView(BlockUtils.getBlockView(contentAwareScrollView, ViewHolderGenerator.createPartsLayout(noteHolder, this.part, this), this));
        if (!ReactionReply.isNull(this.part.getReactionReply())) {
            final ConversationReactionListener conversationReactionListener = new ConversationReactionListener(MetricTracker.ReactionLocation.IN_APP, this.part.getId(), this.conversationId, Injector.get().getApi(), this.metricTracker);
            contentAwareScrollView.setListener(new ContentAwareScrollView.Listener() {
                public void onScrollChanged(int i) {
                }

                public void onBottomReached() {
                    contentAwareScrollView.setListener((ContentAwareScrollView.Listener) null);
                    IntercomNoteActivity.this.composerLayout.setVisibility(0);
                    IntercomNoteActivity.this.reactionComposer.setUpReactions(IntercomNoteActivity.this.part.getReactionReply(), true, conversationReactionListener);
                }
            });
            this.reactionComposer.preloadReactionImages(this.part.getReactionReply());
        }
        View decorView = getWindow().getDecorView();
        decorView.setAlpha(0.0f);
        decorView.animate().alpha(1.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomNoteActivity.this.animateContent();
                if (IntercomNoteActivity.this.composerIsVisible && ReactionReply.isNull(IntercomNoteActivity.this.part.getReactionReply())) {
                    IntercomNoteActivity.this.composerLayout.setVisibility(0);
                    EditText editText = (EditText) IntercomNoteActivity.this.findViewById(R.id.composer_input_view);
                    IntercomNoteActivity.this.findViewById(R.id.note_touch_target).setOnClickListener(IntercomNoteActivity.this);
                    IntercomNoteActivity.this.applyAccessibilityStyling(editText);
                    editText.setVisibility(0);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void applyAccessibilityStyling(EditText editText) {
        int color = getResources().getColor(R.color.intercom_accessibility_grey);
        editText.setTextColor(color);
        editText.setHintTextColor(color);
    }

    /* access modifiers changed from: package-private */
    public void animateContent() {
        this.noteLayout.setScaleX(0.9f);
        this.noteLayout.setScaleY(0.9f);
        this.noteLayout.setAlpha(0.0f);
        this.noteLayout.setVisibility(0);
        this.noteLayout.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).start();
    }

    public static Intent buildNoteIntent(Context context, Part part2, String str, LastParticipatingAdmin lastParticipatingAdmin2, boolean z) {
        Intent putExtra = new Intent(context, IntercomNoteActivity.class).putExtra(PARCEL_PART, part2).putExtra(LAST_PARTICIPANT, lastParticipatingAdmin2).putExtra(COMPOSER_IS_VISIBLE, z);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_CONVERSATION_ID, str);
        }
        putExtra.setExtrasClassLoader(Part.class.getClassLoader());
        return putExtra;
    }

    public void onBackPressed() {
        this.presenter.closeWindow(this);
        this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
    }

    public void onClick(View view) {
        if (view.getId() == R.id.note_touch_target) {
            this.presenter.closeWindow(this);
            this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
            startActivity(IntercomConversationActivity.Companion.openConversation(this, this.conversationId, this.lastParticipatingAdmin));
        }
    }
}
