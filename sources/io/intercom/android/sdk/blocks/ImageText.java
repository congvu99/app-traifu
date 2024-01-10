package io.intercom.android.sdk.blocks;

import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.ImageTextBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.utilities.FontUtils;

public class ImageText implements ImageTextBlock {
    private final StyleType style;
    private final UploadingImageCache uploadingImageCache;

    ImageText(StyleType styleType, UploadingImageCache uploadingImageCache2) {
        this.style = styleType;
        this.uploadingImageCache = uploadingImageCache2;
    }

    public View addImageText(Spanned spanned, Spanned spanned2, String str, String str2, int i, int i2, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_image_text_block, viewGroup, false);
        View addImage = new NetworkImage(this.style, this.uploadingImageCache, (ImageClickListener) null).addImage(str, "", str2, i, i2, BlockAlignment.LEFT, blockMetadata, linearLayout);
        ((LinearLayout.LayoutParams) addImage.getLayoutParams()).setMargins(0, 0, 0, 0);
        ((FrameLayout) linearLayout.findViewById(R.id.image_holder)).addView(addImage);
        TextView textView = (TextView) linearLayout.findViewById(R.id.title);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.text);
        Spanned spanned3 = spanned;
        textView.setText(spanned);
        Spanned spanned4 = spanned2;
        textView2.setText(spanned2);
        FontUtils.setRobotoMediumTypeface(textView);
        String textColor = blockMetadata.getAppearance().getTextColor();
        if (!TextUtils.isEmpty(textColor)) {
            int parseColor = Color.parseColor(textColor);
            textView.setTextColor(parseColor);
            textView2.setTextColor(parseColor);
        }
        return linearLayout;
    }
}
