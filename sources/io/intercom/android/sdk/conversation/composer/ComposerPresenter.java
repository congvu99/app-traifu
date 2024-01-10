package io.intercom.android.sdk.conversation.composer;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.intercom.composer.ComposerFragment;
import com.intercom.composer.ComposerHost;
import com.intercom.composer.OnInputSelectedListener;
import com.intercom.composer.input.Input;
import com.intercom.input.gallery.GalleryImage;
import io.intercom.android.nexus.NexusClient;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.actions.Actions;
import io.intercom.android.sdk.conversation.composer.galleryinput.GalleryInputManager;
import io.intercom.android.sdk.conversation.composer.textinput.TextInputManager;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import java.util.ArrayList;
import java.util.List;

public class ComposerPresenter implements OnInputSelectedListener {
    private static final int SELECT_INPUT_DELAY_MS = 100;
    /* access modifiers changed from: private */
    public final ComposerFragment composerFragment;
    private final FrameLayout composerLayout;
    private String conversationId;
    private final Runnable defaultInputRunnable = new Runnable() {
        public void run() {
            ComposerPresenter.this.composerFragment.selectInput(ComposerInputIndentifier.TEXT, true);
        }
    };
    private final GalleryInputManager galleryInputManager;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final InputDrawableManager inputDrawableManager;
    InputProvider inputProvider;
    private final MetricTracker metricTracker;
    private final Store<State> store;
    private final TextInputManager textInputManager;

    public interface Listener {
        void onRemoteImageSelected(GalleryImage galleryImage);

        void onSendButtonPressed(CharSequence charSequence);

        void onUploadImageSelected(GalleryImage galleryImage);
    }

    public ComposerPresenter(Listener listener, FrameLayout frameLayout, FragmentManager fragmentManager, LayoutInflater layoutInflater, NexusClient nexusClient, UserIdentity userIdentity, Provider<AppConfig> provider, MetricTracker metricTracker2, String str, String str2, Store<State> store2, Context context, int i, String str3) {
        FragmentManager fragmentManager2 = fragmentManager;
        Context context2 = context;
        this.store = store2;
        this.composerLayout = frameLayout;
        this.metricTracker = metricTracker2;
        this.conversationId = str;
        int color = provider.get().primaryColorRenderDarkText() ? ContextCompat.getColor(context2, R.color.intercom_black) : i;
        this.inputDrawableManager = new InputDrawableManager(context2, color);
        Fragment findFragmentByTag = fragmentManager2.findFragmentByTag(ComposerFragment.class.getName());
        if (findFragmentByTag instanceof ComposerFragment) {
            this.composerFragment = (ComposerFragment) findFragmentByTag;
        } else {
            this.composerFragment = ComposerFragment.newInstance((String) null, false, color);
            fragmentManager.beginTransaction().replace(R.id.composer_container, (Fragment) this.composerFragment, ComposerFragment.class.getName()).commit();
        }
        this.composerFragment.setComposerHost(new ComposerHost() {
            public final List getInputs() {
                return ComposerPresenter.this.lambda$new$0$ComposerPresenter();
            }
        });
        this.composerFragment.setOnInputSelectedListener(this);
        Context context3 = context;
        TextInputManager textInputManager2 = r2;
        TextInputManager textInputManager3 = new TextInputManager(context3, layoutInflater, userIdentity, nexusClient, metricTracker2, str, str2, this.inputDrawableManager, store2, listener, str3);
        this.textInputManager = textInputManager2;
        this.galleryInputManager = new GalleryInputManager(context3, this.inputDrawableManager, listener, metricTracker2, str);
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23 && ContextCompat.checkSelfPermission(context2, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        setUpInputs(fragmentManager2, z, provider.get());
    }

    public /* synthetic */ List lambda$new$0$ComposerPresenter() {
        return this.inputProvider.getInputs();
    }

    private void setUpInputs(FragmentManager fragmentManager, boolean z, AppConfig appConfig) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.textInputManager.createInput());
        if (appConfig.isGifsEnabled()) {
            arrayList.add(this.galleryInputManager.createGifInput());
        }
        if (z && appConfig.isAttachmentsEnabled()) {
            arrayList.add(this.galleryInputManager.createGalleryInput());
        }
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(InputProvider.class.getName());
        if (findFragmentByTag == null) {
            this.inputProvider = new InputProvider();
            addInputsToProvider(arrayList);
            fragmentManager.beginTransaction().add((Fragment) this.inputProvider, InputProvider.class.getName()).commit();
            return;
        }
        InputProvider inputProvider2 = (InputProvider) findFragmentByTag;
        this.inputProvider = inputProvider2;
        if (inputProvider2.getInputs().isEmpty()) {
            addInputsToProvider(arrayList);
        }
    }

    private void addInputsToProvider(List list) {
        this.inputProvider.addInputs(list);
    }

    public void setConversationId(String str) {
        this.conversationId = str;
        this.textInputManager.setConversationId(str);
        this.galleryInputManager.setConversationId(str);
    }

    public void setHint(int i) {
        this.textInputManager.setHint(i);
    }

    public void requestFocus() {
        this.textInputManager.requestFocus();
    }

    public void clearFocus() {
        this.textInputManager.clearFocus();
    }

    public void showComposer() {
        this.composerLayout.setVisibility(0);
    }

    public void hideComposer() {
        this.composerLayout.setVisibility(8);
    }

    public void updateMaxLines() {
        this.textInputManager.updateMaxLines();
    }

    public void cleanup() {
        this.textInputManager.cleanup();
    }

    public void onBackPressed() {
        this.composerFragment.onBackPressed();
    }

    public boolean isOpen() {
        return this.composerFragment.isOpen();
    }

    public void returnToDefaultInput() {
        this.handler.postDelayed(this.defaultInputRunnable, 100);
    }

    public void onInputSelected(Input input) {
        this.store.dispatch(Actions.composerInputChanged());
        this.metricTracker.clickedInput(this.conversationId, input.getUniqueIdentifier());
    }
}
