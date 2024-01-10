package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.interfaces.CodeBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.utilities.BlockUtils;

class Code implements CodeBlock {
    Code() {
    }

    public View addCode(Spanned spanned, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        TextView codeBlockView = getCodeBlockView(spanned, viewGroup.getContext());
        BlockUtils.setLayoutMarginsAndGravity(codeBlockView, GravityCompat.START, blockMetadata.isLastObject());
        return codeBlockView;
    }

    private TextView getCodeBlockView(Spanned spanned, Context context) {
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, R.color.intercom_white));
        textView.setTextSize(14.0f);
        textView.setText(spanned);
        textView.setPadding(ScreenUtils.dpToPx(14.0f, context), ScreenUtils.dpToPx(12.0f, context), ScreenUtils.dpToPx(14.0f, context), ScreenUtils.dpToPx(14.0f, context));
        textView.setBackgroundResource(R.color.intercom_slate_grey_two);
        textView.setTypeface(Typeface.MONOSPACE);
        BlockUtils.createLayoutParams(textView, -2, -2);
        BlockUtils.setDefaultMarginBottom(textView);
        return textView;
    }
}
