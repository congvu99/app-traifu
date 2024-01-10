package io.intercom.android.sdk.blocks;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.intercom.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.LinkBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.Link;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.helpcenter.articles.ArticleActivity;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.utilities.AvatarUtils;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;

class LinkCard implements LinkBlock {
    private final Provider<AppConfig> appConfigProvider;
    private final String conversationId;
    private final StyleType style;

    LinkCard(StyleType styleType, Provider<AppConfig> provider, String str) {
        this.style = styleType;
        this.appConfigProvider = provider;
        this.conversationId = str;
    }

    public View addLinkBlock(Link link, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        if (shouldDisplayLink()) {
            return createLinkBlock(link, viewGroup, blockMetadata.isSingleObject(), blockMetadata.isLastObject());
        }
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), StyleType.ADMIN, BlockAlignment.LEFT, this.appConfigProvider.get());
        paragraphView.setText(HtmlCompat.fromHtml(link.getText()));
        return paragraphView;
    }

    private boolean shouldDisplayLink() {
        return StyleType.ADMIN.equals(this.style) || StyleType.CHAT_FULL.equals(this.style);
    }

    private View createLinkBlock(final Link link, ViewGroup viewGroup, boolean z, boolean z2) {
        final Context context = viewGroup.getContext();
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.intercom_link_block, viewGroup, false);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        ColorUtils.setTextColorPrimaryOrDark(textView, this.appConfigProvider.get());
        textView.setText(link.getTitle());
        setUpDescription(link, (TextView) linearLayout.findViewById(R.id.description));
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.avatar);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.author);
        String firstName = link.getAuthor().getFirstName();
        if (TextUtils.isEmpty(firstName)) {
            imageView.setVisibility(8);
            textView2.setVisibility(8);
        } else {
            addAuthorDetails(link, imageView, textView2, firstName);
        }
        if (!z) {
            if (io.intercom.android.sdk.models.Link.ARTICLE_TYPE.equals(link.getLinkType())) {
                linearLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Context context = context;
                        if (context instanceof Activity) {
                            context.startActivity(ArticleActivity.buildIntent(context, new ArticleActivity.ArticleActivityArguments(link.getArticleId(), "conversation")));
                        }
                    }
                });
            }
            BackgroundUtils.setBackground(linearLayout, ContextCompat.getDrawable(context, R.drawable.intercom_conversation_card_background));
            BlockUtils.setMarginBottom(linearLayout, 8);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_link_padding);
            linearLayout.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            BlockUtils.setLayoutMarginsAndGravity(linearLayout, GravityCompat.START, z2);
        }
        return linearLayout;
    }

    private void setUpDescription(Link link, TextView textView) {
        String description = link.getDescription();
        if (TextUtils.isEmpty(description)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(description);
    }

    private void addAuthorDetails(Link link, ImageView imageView, TextView textView, String str) {
        imageView.setVisibility(0);
        textView.setVisibility(0);
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        textView.setText("Written by " + spannableString);
        AvatarUtils.createAvatar(Avatar.create(link.getAuthor().getAvatar(), ""), imageView, imageView.getResources().getDimensionPixelSize(R.dimen.intercom_avatar_size), this.appConfigProvider.get());
    }
}
