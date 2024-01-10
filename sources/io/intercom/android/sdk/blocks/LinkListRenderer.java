package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.lib.interfaces.LinkListBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.Link;
import io.intercom.android.sdk.blocks.lib.models.LinkList;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.m5.IntercomRootActivityLauncher;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.LinkOpener;
import java.util.Collections;

class LinkListRenderer implements LinkListBlock {
    /* access modifiers changed from: private */
    public final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final String conversationId;

    LinkListRenderer(Api api2, Provider<AppConfig> provider, String str) {
        this.api = api2;
        this.appConfigProvider = provider;
        this.conversationId = str;
    }

    public View addLinkListBlock(LinkList linkList, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.intercom_card_list_block, viewGroup, false);
        int primaryOrDarkColor = ColorUtils.primaryOrDarkColor(context, this.appConfigProvider.get());
        LinearLayout linearLayout = (LinearLayout) frameLayout.findViewById(R.id.card_links);
        linearLayout.setShowDividers(2);
        linearLayout.setDividerDrawable(new ColorDrawable(ContextCompat.getColor(context, R.color.intercom_container_border)));
        linearLayout.setOrientation(1);
        for (Link addLinkToLayout : linkList.getLinks()) {
            addLinkToLayout(linearLayout, addLinkToLayout, primaryOrDarkColor, context, false);
        }
        Link footerLink = linkList.getFooterLink();
        if (!footerLink.getText().isEmpty()) {
            addLinkToLayout(linearLayout, footerLink, primaryOrDarkColor, context, true);
        }
        return frameLayout;
    }

    private void addLinkToLayout(LinearLayout linearLayout, final Link link, int i, final Context context, boolean z) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        if (z) {
            layoutParams.gravity = 17;
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(i);
        textView.setTextSize(16.0f);
        textView.setText(link.getTitle());
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(ScreenUtils.dpToPx(24.0f, context), ScreenUtils.dpToPx(16.0f, context), ScreenUtils.dpToPx(16.0f, context), ScreenUtils.dpToPx(16.0f, context));
        if (io.intercom.android.sdk.models.Link.HELP_CENTER_TYPE.equals(link.getLinkType())) {
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.intercom_open_help_center);
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(ScreenUtils.dpToPx(8.0f, context));
        }
        frameLayout.addView(textView);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (io.intercom.android.sdk.models.Link.ARTICLE_TYPE.equals(link.getLinkType()) || io.intercom.android.sdk.models.Link.SUGGESTION_TYPE.equals(link.getLinkType())) {
                    Context context = context;
                    if (context instanceof Activity) {
                        context.startActivity(ArticleActivity.buildIntent(context, new ArticleActivity.ArticleActivityArguments(link.getArticleId(), "conversation")));
                        return;
                    }
                }
                if (!io.intercom.android.sdk.models.Link.HELP_CENTER_TYPE.equals(link.getLinkType()) || !(context instanceof Activity)) {
                    LinkOpener.handleUrl(link.getUrl(), context, LinkListRenderer.this.api);
                } else {
                    IntercomRootActivityLauncher.INSTANCE.startHelpCenterCollections(context, Collections.emptyList(), "conversation");
                }
            }
        });
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843534, typedValue, true);
        frameLayout.setBackgroundResource(typedValue.resourceId);
        linearLayout.addView(frameLayout);
    }
}
