package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.intercom.composer.Creator;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.GalleryInput;
import com.intercom.input.gallery.GalleryInputExpandedListener;
import com.intercom.input.gallery.GalleryInputFragment;
import com.intercom.input.gallery.GalleryOutputListener;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.composer.ComposerInputIndentifier;
import io.intercom.android.sdk.conversation.composer.ComposerPresenter;
import io.intercom.android.sdk.conversation.composer.InputDrawableManager;
import io.intercom.android.sdk.metrics.MetricTracker;

public class GalleryInputManager {
    /* access modifiers changed from: private */
    public String conversationId;
    /* access modifiers changed from: private */
    public final Drawable galleryIcon;
    /* access modifiers changed from: private */
    public final Drawable gifIcon;
    /* access modifiers changed from: private */
    public final ComposerPresenter.Listener listener;
    /* access modifiers changed from: private */
    public final MetricTracker metricTracker;

    public GalleryInputManager(Context context, InputDrawableManager inputDrawableManager, ComposerPresenter.Listener listener2, MetricTracker metricTracker2, String str) {
        this.listener = listener2;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        this.galleryIcon = inputDrawableManager.createDrawable(context, R.drawable.intercom_input_gallery);
        this.gifIcon = inputDrawableManager.createDrawable(context, R.drawable.intercom_input_gif);
    }

    public Input createGalleryInput() {
        return new GalleryInput(ComposerInputIndentifier.GALLERY, new IconProvider() {
            public Drawable getIconDrawable(String str, Context context) {
                return GalleryInputManager.this.galleryIcon;
            }
        }, new GalleryOutputListener() {
            public void onGalleryOutputReceived(GalleryImage galleryImage) {
                GalleryInputManager.this.listener.onUploadImageSelected(galleryImage);
            }
        }, new GalleryInputExpandedListener() {
            public void onInputExpanded() {
                GalleryInputManager.this.metricTracker.expandedInput(GalleryInputManager.this.conversationId);
            }
        }, new Creator<GalleryInputFragment>() {
            public GalleryInputFragment create() {
                return new LocalGalleryInputFragment();
            }
        });
    }

    public Input createGifInput() {
        return new GalleryInput("gif_input", new IconProvider() {
            public Drawable getIconDrawable(String str, Context context) {
                return GalleryInputManager.this.gifIcon;
            }
        }, new GalleryOutputListener() {
            public void onGalleryOutputReceived(GalleryImage galleryImage) {
                GalleryInputManager.this.listener.onRemoteImageSelected(galleryImage);
            }
        }, new GalleryInputExpandedListener() {
            public void onInputExpanded() {
                GalleryInputManager.this.metricTracker.expandedInput(GalleryInputManager.this.conversationId);
            }
        }, new Creator<GalleryInputFragment>() {
            public GalleryInputFragment create() {
                return new GifInputFragment();
            }
        });
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }
}
