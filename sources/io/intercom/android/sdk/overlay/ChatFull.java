package io.intercom.android.sdk.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.ButtonClickListener;
import io.intercom.android.sdk.blocks.ImageClickListener;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.blocks.lib.Blocks;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.overlay.InAppNotification;

class ChatFull extends ChatNotification {
    private final Activity activity;
    private final MetricTracker metricTracker;

    public void update(Conversation conversation, Runnable runnable) {
    }

    /* access modifiers changed from: protected */
    public void updateContentContainer(Part part) {
    }

    /* access modifiers changed from: protected */
    public void updateViewDataDuringReplyPulse(int i) {
    }

    ChatFull(Context context, Conversation conversation, int i, int i2, InAppNotification.Listener listener, MetricTracker metricTracker2, Provider<AppConfig> provider, Activity activity2) {
        super(context, conversation, i, i2, listener, provider);
        this.metricTracker = metricTracker2;
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public ViewGroup inflateChatRootView(ViewGroup viewGroup, LayoutInflater layoutInflater) {
        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.intercom_preview_chat_full_overlay, viewGroup, false);
        Blocks blocks = new Blocks(this.localisedContext, LumberMill.getBlocksTwig());
        Injector injector = Injector.get();
        Api api = injector.getApi();
        LinearLayout createBlocks = blocks.createBlocks(this.conversation.getLastPart().getBlocks(), new ViewHolderGenerator(new UploadingImageCache(), api, this.appConfigProvider, this.conversation.getId(), new ChatFullImageClickListener(), new ChatFullButtonClickListener(), injector.getGson(), injector.getBus(), this.metricTracker, this.activity).getChatFullHolder());
        final ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.chathead_text_container);
        viewGroup3.addView(createBlocks);
        viewGroup3.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                viewGroup3.getViewTreeObserver().removeOnPreDrawListener(this);
                int measuredHeight = viewGroup3.getMeasuredHeight();
                int i = ((ViewGroup.MarginLayoutParams) viewGroup3.getLayoutParams()).bottomMargin;
                Resources resources = ChatFull.this.localisedContext.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.intercom_chat_full_top_margin);
                if (measuredHeight < ((ChatFull.this.screenHeight - dimensionPixelSize) - i) - resources.getDimensionPixelSize(R.dimen.intercom_bottom_padding)) {
                    return true;
                }
                viewGroup2.findViewById(R.id.chat_overlay_overflow_fade).setVisibility(0);
                return false;
            }
        });
        api.markConversationAsRead(this.conversation.getId());
        this.metricTracker.viewedInApp(this.conversation.getId(), this.conversation.getLastPart().getId(), 1);
        return viewGroup2;
    }

    /* access modifiers changed from: protected */
    public View getContentContainer() {
        return ((ViewGroup) this.overlayRoot.findViewById(R.id.chathead_text_container)).getChildAt(1);
    }

    private static class ChatFullImageClickListener implements ImageClickListener {
        public void onImageClicked(String str, String str2, View view, int i, int i2) {
        }

        private ChatFullImageClickListener() {
        }
    }

    private static class ChatFullButtonClickListener implements ButtonClickListener {
        public void onButtonClicked(View view, String str) {
        }

        public boolean shouldHandleClicks() {
            return false;
        }

        private ChatFullButtonClickListener() {
        }
    }
}
