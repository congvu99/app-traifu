package io.intercom.android.sdk.carousel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.ButtonClickListener;
import io.intercom.android.sdk.blocks.CarouselImageClickListener;
import io.intercom.android.sdk.blocks.ContentLayoutManager;
import io.intercom.android.sdk.blocks.UploadingImageCache;
import io.intercom.android.sdk.blocks.ViewHolderGenerator;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.carousel.ActionType;
import io.intercom.android.sdk.models.carousel.CarouselScreen;
import io.intercom.android.sdk.models.carousel.ScreenAction;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import java.util.List;

public class CarouselScreenFragment extends Fragment {
    public static final int CAROUSEL_ANIMATION_DELAY_MS = 300;
    public static final int CAROUSEL_ANIMATION_MS = 400;
    private static final String KEY_CAROUSEL_SCREEN = "carousel_screen";
    private LinearLayout actionLayout;
    private Bus bus;
    private CarouselScreen carouselScreen = CarouselScreen.NULL;
    private CarouselListener listener;
    private PermissionManager permissionManager;
    private boolean tickShouldAnimate = true;

    public static CarouselScreenFragment newInstance(CarouselScreen carouselScreen2) {
        CarouselScreenFragment carouselScreenFragment = new CarouselScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CAROUSEL_SCREEN, carouselScreen2);
        carouselScreenFragment.setArguments(bundle);
        return carouselScreenFragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.listener = (CarouselListener) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context + " must implement CarouselListener");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.carouselScreen = (CarouselScreen) arguments.getParcelable(KEY_CAROUSEL_SCREEN);
        }
        Injector injector = Injector.get();
        Api api = injector.getApi();
        Provider<AppConfig> appConfigProvider = injector.getAppConfigProvider();
        this.bus = injector.getBus();
        ContentLayoutManager contentLayoutManager = new ContentLayoutManager(getContext(), new ViewHolderGenerator(new UploadingImageCache(), api, appConfigProvider, "", new CarouselImageClickListener(api), (ButtonClickListener) null, injector.getGson(), injector.getBus(), injector.getMetricTracker(), getActivity()).getCarouselHolder());
        this.permissionManager = new PermissionManager(getActivity());
        View inflate = layoutInflater.inflate(R.layout.intercom_fragment_carousel_screen, viewGroup, false);
        this.actionLayout = (LinearLayout) inflate.findViewById(R.id.intercom_carousel_action_layout);
        int parseColor = Color.parseColor(this.carouselScreen.getBackgroundColor());
        applyBottomGradient(inflate.findViewById(R.id.intercom_carousel_gradient), (ContentAwareScrollView) inflate.findViewById(R.id.intercom_carousel_scroll_view), parseColor);
        ((LinearLayout) inflate.findViewById(R.id.intercom_carousel_fragment_root)).setBackgroundColor(parseColor);
        displayScreenActions();
        contentLayoutManager.renderCarouselScreen(this.carouselScreen, (FrameLayout) inflate.findViewById(R.id.intercom_carousel_content_container));
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.bus.register(this);
    }

    public void onStop() {
        this.bus.unregister(this);
        super.onStop();
    }

    public void onResume() {
        super.onResume();
        displayScreenActions();
    }

    private void displayScreenActions() {
        this.actionLayout.removeAllViews();
        List<ScreenAction> actions = this.carouselScreen.getActions();
        ScreenAction permissionAction = this.carouselScreen.getPermissionAction();
        for (ScreenAction next : actions) {
            TextView createButton = createButton(next);
            if (!ScreenAction.NULL.equals(permissionAction)) {
                PermissionManager permissionManager2 = this.permissionManager;
                if (permissionManager2.permissionsGranted(permissionAction.getValidPermissions(permissionManager2))) {
                    if (ActionType.SKIP.equals(next.getType())) {
                        this.actionLayout.addView(buttonWithTickIcon(createButton, Color.parseColor(next.getTextColor())));
                    } else {
                        boolean isPermissionAction = next.isPermissionAction();
                    }
                }
            }
            this.actionLayout.addView(createButton);
        }
    }

    private TextView createButton(ScreenAction screenAction) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.intercom_carousel_action_button, this.actionLayout, false);
        FontUtils.setRobotoMediumTypeface(textView);
        textView.setText(screenAction.getTitle());
        textView.getBackground().setColorFilter(Color.parseColor(screenAction.getBackgroundColor()), PorterDuff.Mode.SRC_IN);
        textView.setTextColor(Color.parseColor(screenAction.getTextColor()));
        textView.setOnClickListener(new ActionOnClickListener(screenAction, this.listener));
        textView.setContentDescription(screenAction.getTitle() + ", button");
        return textView;
    }

    private FrameLayout buttonWithTickIcon(TextView textView, int i) {
        textView.setText("");
        LayoutInflater from = LayoutInflater.from(getContext());
        FrameLayout frameLayout = new FrameLayout(textView.getContext());
        frameLayout.setLayoutParams(textView.getLayoutParams());
        ImageView imageView = (ImageView) from.inflate(R.layout.intercom_carousel_action_button_tick, frameLayout, false);
        imageView.getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
        frameLayout.addView(textView);
        frameLayout.addView(imageView);
        if (this.tickShouldAnimate) {
            animateTickIcon(imageView);
        }
        return frameLayout;
    }

    private void animateTickIcon(ImageView imageView) {
        imageView.clearAnimation();
        imageView.setAlpha(0.0f);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setRotation(-360.0f);
        imageView.animate().alpha(1.0f).rotationBy(360.0f).scaleX(1.0f).scaleY(1.0f).setStartDelay(300).setDuration(400).start();
        this.tickShouldAnimate = false;
    }

    private void applyBottomGradient(final View view, final ContentAwareScrollView contentAwareScrollView, int i) {
        view.setBackground(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, ColorUtils.setAlphaComponent(i, 0)}));
        contentAwareScrollView.setListener(new ContentAwareScrollView.Listener() {
            public void onBottomReached() {
                view.setVisibility(8);
            }

            public void onScrollChanged(int i) {
                if (!contentAwareScrollView.isAtBottom()) {
                    view.setVisibility(0);
                }
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (contentAwareScrollView.isAtBottom()) {
                    view.setVisibility(8);
                }
            }
        });
    }
}
