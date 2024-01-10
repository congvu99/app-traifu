package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.intercom.commons.utilities.HtmlCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.activities.IntercomVideoActivity;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.VideoFileBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.AccessibilityUtils;
import io.intercom.android.sdk.utilities.BlockUtils;

public class VideoFile implements VideoFileBlock {
    private static final int PLAY_ARROW_OFFSET_DP = 3;
    private static final int PLAY_BUTTON_DIAMETER_DP = 36;
    private final Provider<AppConfig> appConfigProvider;
    private final MetricTracker metricTracker;
    private final StyleType style;

    VideoFile(StyleType styleType, Provider<AppConfig> provider, MetricTracker metricTracker2) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.metricTracker = metricTracker2;
    }

    public View addVideoFile(String str, String str2, String str3, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        if (TextUtils.isEmpty(str2)) {
            return textFallback(str, viewGroup);
        }
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        WebView webView = new WebView(viewGroup.getContext());
        BlockUtils.createLayoutParams(webView, -1, 480);
        BlockUtils.setMarginBottom(webView, 16);
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(true);
        webView.loadUrl(str3);
        ImageView playButtonView = getPlayButtonView(viewGroup.getContext());
        playButtonView.setOnClickListener(new View.OnClickListener(playButtonView, webView, str2) {
            public final /* synthetic */ ImageView f$0;
            public final /* synthetic */ WebView f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                VideoFile.lambda$addVideoFile$0(this.f$0, this.f$1, this.f$2, view);
            }
        });
        relativeLayout.addView(webView);
        relativeLayout.addView(playButtonView);
        return relativeLayout;
    }

    static /* synthetic */ void lambda$addVideoFile$0(ImageView imageView, WebView webView, String str, View view) {
        imageView.setVisibility(8);
        webView.loadUrl(str);
    }

    private View textFallback(String str, ViewGroup viewGroup) {
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(str));
        return paragraphView;
    }

    private void addClickListenerOnThumbnailView(ImageView imageView, String str) {
        if (this.style != StyleType.CHAT_FULL) {
            imageView.setOnClickListener(new View.OnClickListener(imageView, str) {
                public final /* synthetic */ ImageView f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    VideoFile.this.lambda$addClickListenerOnThumbnailView$1$VideoFile(this.f$1, this.f$2, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$addClickListenerOnThumbnailView$1$VideoFile(ImageView imageView, String str, View view) {
        this.metricTracker.startedToPlayVideo();
        Context context = imageView.getContext();
        context.startActivity(IntercomVideoActivity.buildIntent(context, str));
    }

    private ImageView getPlayButtonView(Context context) {
        int dpToPx = ScreenUtils.dpToPx(36.0f, context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.addRule(13);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.intercom_play_arrow);
        imageView.setPadding(ScreenUtils.dpToPx(3.0f, context), 0, 0, 0);
        imageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        imageView.setVisibility(0);
        imageView.setId(R.id.intercom_video_thumbnail_play_button);
        AccessibilityUtils.INSTANCE.addClickAbilityAnnouncement(imageView);
        return imageView;
    }
}
