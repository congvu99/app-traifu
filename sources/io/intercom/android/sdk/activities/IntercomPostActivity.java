package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.intercom.commons.utilities.ScreenUtils;
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
import io.intercom.android.sdk.blocks.views.AttachmentView;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.FeatureFlag;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReactionReply;
import io.intercom.android.sdk.post.PostActivityV2;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.Phrase;
import io.intercom.android.sdk.utilities.TimeFormatter;
import io.intercom.android.sdk.views.ActiveStatePresenter;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import io.intercom.android.sdk.views.IntercomToolbar;

public class IntercomPostActivity extends IntercomBaseActivity implements View.OnClickListener {
    private static final String COMPOSER_IS_VISIBLE = "composer_is_visible";
    private static final String LAST_PARTICIPANT = "last_participant";
    private static final String PARCEL_CONVERSATION_ID = "parcel_conversation_id";
    private static final String PARCEL_PART = "parcel_part";
    private static final String POST_PREVIEW = "is_post_preview";
    /* access modifiers changed from: private */
    public boolean composerIsVisible = true;
    View composerLayout;
    String conversationId;
    private boolean isPreview = false;
    private LastParticipatingAdmin lastParticipatingAdmin;
    MetricTracker metricTracker;
    Part part;
    private FrameLayout postContainer;
    ContentAwareScrollView postView;
    private final FullScreenInAppPresenter presenter = new FullScreenInAppPresenter();
    ReactionInputView reactionComposer;
    private EditText textComposer;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_post);
        Injector injector = Injector.get();
        Api api = injector.getApi();
        this.metricTracker = injector.getMetricTracker();
        Provider<AppConfig> appConfigProvider = injector.getAppConfigProvider();
        final IntercomToolbar intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
        intercomToolbar.setListener(new InAppToolbarListener(this));
        this.part = new Part();
        this.lastParticipatingAdmin = LastParticipatingAdmin.NULL;
        TimeFormatter timeFormatter = new TimeFormatter(this, injector.getTimeProvider());
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extras.setClassLoader(Part.class.getClassLoader());
            if (extras.containsKey(PARCEL_PART)) {
                Part part2 = (Part) extras.getParcelable(PARCEL_PART);
                this.part = part2;
                if (part2 == null || part2.getParticipant() == null) {
                    str = "";
                } else {
                    str = this.part.getParticipant().getForename();
                }
                intercomToolbar.setTitle(Phrase.from((Context) this, R.string.intercom_teammate_from_company).put("name", (CharSequence) str).put("company", (CharSequence) appConfigProvider.get().getName()).format());
            }
            if (extras.containsKey(PARCEL_CONVERSATION_ID)) {
                this.conversationId = extras.getString(PARCEL_CONVERSATION_ID, "");
                injector.getStore().dispatch(Actions.conversationMarkedAsRead(this.conversationId));
                api.markConversationAsRead(this.conversationId);
            }
            if (extras.containsKey(COMPOSER_IS_VISIBLE)) {
                this.composerIsVisible = extras.getBoolean(COMPOSER_IS_VISIBLE, true);
            }
            if (extras.containsKey(POST_PREVIEW)) {
                this.isPreview = extras.getBoolean(POST_PREVIEW, false);
            }
            if (extras.containsKey(LAST_PARTICIPANT)) {
                LastParticipatingAdmin lastParticipatingAdmin2 = (LastParticipatingAdmin) extras.getParcelable(LAST_PARTICIPANT);
                this.lastParticipatingAdmin = lastParticipatingAdmin2;
                if (!LastParticipatingAdmin.isNull(lastParticipatingAdmin2)) {
                    intercomToolbar.setSubtitle(timeFormatter.getAdminActiveStatus(this.lastParticipatingAdmin, appConfigProvider));
                }
            }
        }
        intercomToolbar.setVisibility(8);
        intercomToolbar.setUpPostToolbar(this.part.getParticipant(), this.lastParticipatingAdmin.isActive(), new ActiveStatePresenter(), appConfigProvider.get());
        int primaryColor = appConfigProvider.get().getPrimaryColor();
        View decorView = getWindow().getDecorView();
        decorView.setBackgroundColor(Color.argb(153, Color.red(primaryColor), Color.green(primaryColor), Color.blue(primaryColor)));
        BlocksViewHolder postHolder = new ViewHolderGenerator(new UploadingImageCache(), api, appConfigProvider, this.conversationId, new LightboxOpeningImageClickListener(api), new LinkOpeningButtonClickListener(api), injector.getGson(), injector.getBus(), this.metricTracker, this).getPostHolder();
        this.postContainer = (FrameLayout) findViewById(R.id.post_container);
        this.composerLayout = findViewById(R.id.conversation_coordinator);
        EditText editText = (EditText) findViewById(R.id.composer_input_view);
        this.textComposer = editText;
        applyAccessibilityFullScreenPostStyling(editText);
        this.reactionComposer = (ReactionInputView) findViewById(R.id.reaction_input_view);
        this.postView = (ContentAwareScrollView) findViewById(R.id.post_view);
        LinearLayout createPartsLayout = ViewHolderGenerator.createPartsLayout(postHolder, this.part, this);
        ensureColorConformanceForViews(createPartsLayout);
        ContentAwareScrollView contentAwareScrollView = this.postView;
        contentAwareScrollView.addView(BlockUtils.getBlockView(contentAwareScrollView, createPartsLayout, this));
        if (this.isPreview && !ReactionReply.isNull(this.part.getReactionReply())) {
            final ConversationReactionListener conversationReactionListener = new ConversationReactionListener(MetricTracker.ReactionLocation.IN_APP, this.part.getId(), this.conversationId, Injector.get().getApi(), this.metricTracker);
            this.postView.setListener(new ContentAwareScrollView.Listener() {
                public void onScrollChanged(int i) {
                }

                public void onBottomReached() {
                    IntercomPostActivity.this.postView.setListener((ContentAwareScrollView.Listener) null);
                    if (IntercomPostActivity.this.composerLayout.getVisibility() != 0) {
                        IntercomPostActivity.this.composerLayout.setVisibility(0);
                        IntercomPostActivity.this.reactionComposer.setUpReactions(IntercomPostActivity.this.part.getReactionReply(), true, conversationReactionListener);
                    }
                }
            });
            this.reactionComposer.preloadReactionImages(this.part.getReactionReply());
        }
        if (openedFromConversation()) {
            this.metricTracker.viewedInAppFromMessenger(this.part.getMessageStyle(), this.conversationId, this.part.getId());
        }
        decorView.setAlpha(0.0f);
        decorView.animate().alpha(1.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                IntercomPostActivity.this.animateToolbar(intercomToolbar);
                IntercomPostActivity.this.animateContent();
                if (IntercomPostActivity.this.openedFromConversation()) {
                    IntercomPostActivity.this.composerLayout.setVisibility(8);
                } else if (IntercomPostActivity.this.composerIsVisible && ReactionReply.isNull(IntercomPostActivity.this.part.getReactionReply())) {
                    IntercomPostActivity.this.findViewById(R.id.post_touch_target).setOnClickListener(IntercomPostActivity.this);
                    IntercomPostActivity.this.animateComposer();
                }
            }
        }).start();
    }

    private void ensureColorConformanceForViews(LinearLayout linearLayout) {
        Provider<AppConfig> appConfigProvider = Injector.get().getAppConfigProvider();
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof Button) {
                ensureButtonCorrectness((Button) childAt, appConfigProvider);
            } else if (childAt instanceof ParagraphView) {
                ensureTextViewCorrectness((TextView) childAt);
            } else if (childAt instanceof TextView) {
                ensureTextViewCorrectness((TextView) childAt);
            } else if (childAt instanceof AttachmentView) {
                ensureWhiteAttachmentView((AttachmentView) childAt);
            } else if (childAt instanceof LinearLayout) {
                ensureColorConformanceForViews((LinearLayout) childAt);
            }
        }
    }

    private void ensureTextViewCorrectness(TextView textView) {
        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.intercom_white));
        textView.setLinkTextColor(getResources().getColor(R.color.intercom_white));
    }

    private void ensureButtonCorrectness(Button button, Provider<AppConfig> provider) {
        if (ColorUtils.isColorLight(provider.get().getPrimaryColor())) {
            button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.intercom_accessibility_black));
        } else {
            button.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.intercom_white));
        }
    }

    private void ensureWhiteAttachmentView(AttachmentView attachmentView) {
        for (int i = 0; i < attachmentView.getChildCount(); i++) {
            View childAt = attachmentView.getChildAt(i);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.intercom_white));
            } else if (childAt instanceof ImageView) {
                ((ImageView) childAt).setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.intercom_white));
            }
        }
    }

    private void applyAccessibilityFullScreenPostStyling(EditText editText) {
        int color = getResources().getColor(R.color.intercom_white);
        editText.setHintTextColor(color);
        editText.setTextColor(color);
    }

    /* access modifiers changed from: package-private */
    public void animateToolbar(IntercomToolbar intercomToolbar) {
        intercomToolbar.setY(intercomToolbar.getY() + ((float) ScreenUtils.dpToPx(200.0f, this)));
        intercomToolbar.setVisibility(0);
        intercomToolbar.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    /* access modifiers changed from: package-private */
    public void animateContent() {
        FrameLayout frameLayout = this.postContainer;
        frameLayout.setY(frameLayout.getY() + ((float) ScreenUtils.dpToPx(400.0f, this)));
        this.postContainer.setVisibility(0);
        this.postContainer.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    /* access modifiers changed from: package-private */
    public void animateComposer() {
        View view = this.composerLayout;
        view.setY(view.getY() + ((float) ScreenUtils.dpToPx(156.0f, this)));
        this.composerLayout.setVisibility(0);
        this.textComposer.setVisibility(0);
        this.composerLayout.animate().setInterpolator(new OvershootInterpolator(0.6f)).translationY(0.0f).setDuration(300).start();
    }

    public static Intent buildPostIntent(Context context, Part part2, String str, LastParticipatingAdmin lastParticipatingAdmin2, boolean z, boolean z2) {
        Class cls;
        if (Injector.isNotInitialised() || !Injector.get().getAppConfigProvider().get().hasFeature(FeatureFlag.POST_V2_RENDERING_ENABLED)) {
            cls = IntercomPostActivity.class;
        } else {
            cls = PostActivityV2.class;
        }
        Intent putExtra = new Intent(context, cls).putExtra(PARCEL_PART, part2).putExtra(LAST_PARTICIPANT, lastParticipatingAdmin2).putExtra(COMPOSER_IS_VISIBLE, z).putExtra(POST_PREVIEW, z2);
        if (!TextUtils.isEmpty(str)) {
            putExtra.putExtra(PARCEL_CONVERSATION_ID, str);
        }
        putExtra.setExtrasClassLoader(Part.class.getClassLoader());
        return putExtra;
    }

    /* access modifiers changed from: package-private */
    public boolean openedFromConversation() {
        return !this.isPreview;
    }

    public void onBackPressed() {
        this.presenter.closeWindow(this);
        if (this.isPreview) {
            this.metricTracker.closedInAppFromFull(this.conversationId, this.part.getId());
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.post_touch_target) {
            this.presenter.closeWindow(this);
            if (this.isPreview) {
                this.metricTracker.openedConversationFromFull(this.conversationId, this.part.getId());
                startActivity(IntercomConversationActivity.Companion.openConversation(this, this.conversationId, this.lastParticipatingAdmin));
            }
        }
    }
}
