package io.intercom.android.sdk.blocks;

import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.ParagraphBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.views.ParagraphView;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.AccessibilityUtils;
import io.intercom.android.sdk.utilities.BlockUtils;

class Paragraph implements ParagraphBlock {
    private final Provider<AppConfig> appConfigProvider;
    private final StyleType style;

    Paragraph(StyleType styleType, Provider<AppConfig> provider) {
        this.style = styleType;
        this.appConfigProvider = provider;
    }

    public View addParagraph(Spanned spanned, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        ParagraphView paragraphView = new ParagraphView(viewGroup.getContext(), this.style, blockAlignment, this.appConfigProvider.get(), blockMetadata);
        if (StyleType.PREVIEW == this.style) {
            paragraphView.setText(spanned.toString());
        } else {
            paragraphView.setText(spanned);
        }
        BlockUtils.setLayoutMarginsAndGravity(paragraphView, blockAlignment.getGravity(), blockMetadata.isLastObject());
        AccessibilityUtils.INSTANCE.removeClickAbilityAnnouncement(paragraphView);
        return paragraphView;
    }
}
