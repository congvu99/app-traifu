package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.intercom.commons.utilities.HtmlCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.ButtonBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.FacebookBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.TwitterBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.AccessibilityUtils;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.views.ButtonSelector;

class Button implements ButtonBlock, FacebookBlock, TwitterBlock {
    private static final int FACEBOOK_LOGO_PADDING_LEFT_DP = 20;
    private static final int TWITTER_LOGO_PADDING_LEFT_DP = 16;
    private final Provider<AppConfig> appConfigProvider;
    /* access modifiers changed from: private */
    public final ButtonClickListener buttonClickListener;
    private final StyleType style;

    public Button(StyleType styleType, Provider<AppConfig> provider, ButtonClickListener buttonClickListener2) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.buttonClickListener = buttonClickListener2;
    }

    public View addButton(Spanned spanned, String str, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        if (this.style == StyleType.NOTE || this.style == StyleType.ARTICLE || this.style == StyleType.POST || this.style == StyleType.CONTAINER_CARD) {
            view = createFullWidthButton(context, spanned);
        } else {
            view = createDefaultTextView(context, spanned, blockAlignment);
        }
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(view);
        return setButtonDefaults(view, str, blockAlignment, blockMetadata.isLastObject());
    }

    public View addFacebookButton(String str, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        String string = context.getString(R.string.intercom_facebook_like);
        if (this.style == StyleType.NOTE || this.style == StyleType.ARTICLE || this.style == StyleType.POST || this.style == StyleType.CONTAINER_CARD) {
            view = createButtonWithLogo(context, string, ScreenUtils.dpToPx(20.0f, context), R.drawable.intercom_icn_fb);
        } else {
            view = createDefaultTextView(context, HtmlCompat.fromHtml(string), blockAlignment);
        }
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(view);
        return setButtonDefaults(view, str, blockAlignment, blockMetadata.isLastObject());
    }

    public View addTwitterButton(String str, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        View view;
        Context context = viewGroup.getContext();
        String string = context.getString(R.string.intercom_twitter_follow);
        if (this.style == StyleType.NOTE || this.style == StyleType.ARTICLE || this.style == StyleType.POST || this.style == StyleType.CONTAINER_CARD) {
            view = createButtonWithLogo(context, string, ScreenUtils.dpToPx(16.0f, context), R.drawable.intercom_icn_twitter);
        } else {
            view = createDefaultTextView(context, HtmlCompat.fromHtml(string), blockAlignment);
        }
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(view);
        return setButtonDefaults(view, str, blockAlignment, blockMetadata.isLastObject());
    }

    private View setButtonDefaults(View view, final String str, BlockAlignment blockAlignment, boolean z) {
        ButtonClickListener buttonClickListener2 = this.buttonClickListener;
        if (buttonClickListener2 != null && buttonClickListener2.shouldHandleClicks()) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Button.this.buttonClickListener.onButtonClicked(view, str);
                }
            });
        }
        BlockUtils.setLayoutMarginsAndGravity(view, blockAlignment.getGravity(), z);
        return view;
    }

    private TextView createDefaultTextView(Context context, Spanned spanned, BlockAlignment blockAlignment) {
        AppConfig appConfig = this.appConfigProvider.get();
        ParagraphView paragraphView = new ParagraphView(context, this.style, blockAlignment, appConfig);
        paragraphView.setTextColor(appConfig.getPrimaryColor());
        paragraphView.setPaintFlags(paragraphView.getPaintFlags() | 8);
        paragraphView.setGravity(blockAlignment.getGravity());
        paragraphView.setText(spanned);
        return paragraphView;
    }

    private android.widget.Button createFullWidthButton(Context context, Spanned spanned) {
        AppConfig appConfig = this.appConfigProvider.get();
        android.widget.Button button = new android.widget.Button(context);
        button.setTextSize(16.0f);
        button.setTextColor(ColorUtils.whiteOrDarkColor(context, appConfig.primaryColorRenderDarkText()));
        button.setAllCaps(false);
        button.setGravity(17);
        button.setText(spanned);
        BlockUtils.createLayoutParams(button, -1, -2);
        BlockUtils.setDefaultMarginBottom(button);
        BackgroundUtils.setBackground(button, new ButtonSelector(context, R.drawable.intercom_border, appConfig.getPrimaryColor()));
        FontUtils.setRobotoMediumTypeface(button);
        return button;
    }

    private View createButtonWithLogo(Context context, String str, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(context);
        BlockUtils.createLayoutParams(frameLayout, -1, ScreenUtils.dpToPx(44.0f, context));
        BlockUtils.setDefaultMarginBottom(frameLayout);
        BackgroundUtils.setBackground(frameLayout, new ButtonSelector(context, R.drawable.intercom_border, this.appConfigProvider.get().getPrimaryColor()));
        ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
        ImageView imageView = new ImageView(context);
        BlockUtils.createLayoutParams(imageView, -2, -1);
        imageView.setImageResource(i2);
        imageView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        if (ColorUtils.isColorLight(this.appConfigProvider.get().getPrimaryColor())) {
            DrawableCompat.setTint(imageView.getDrawable(), ContextCompat.getColor(context, R.color.intercom_accessibility_black));
        }
        imageView.setPadding(i, 0, 0, 0);
        ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 8388627;
        TextView textView = new TextView(context);
        BlockUtils.createLayoutParams(textView, -1, -1);
        textView.setText(str);
        textView.setTextSize(16.0f);
        textView.setTextColor(ColorUtils.whiteOrBlackAccessibility(context, this.appConfigProvider.get()));
        textView.setBackgroundResource(R.color.intercom_full_transparent_full_black);
        textView.setGravity(17);
        FontUtils.setRobotoMediumTypeface(textView);
        frameLayout.addView(imageView);
        frameLayout.addView(textView);
        return frameLayout;
    }
}
