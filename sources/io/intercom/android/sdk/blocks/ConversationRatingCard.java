package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import coil.request.ImageRequest;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.lib.interfaces.ConversationRatingBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.blocks.lib.models.ConversationRating;
import io.intercom.android.sdk.blocks.lib.models.ConversationRatingOption;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.FontUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import io.intercom.android.sdk.views.ButtonSelector;
import java.util.ArrayList;
import java.util.List;

public class ConversationRatingCard implements ConversationRatingBlock {
    private static final long ANIMATION_DURATION_MS = 200;
    private static final float DESELECTED_RATING_SCALE = 1.0f;
    private static final float DIALOG_HORIZONTAL_MARGIN = 16.0f;
    private static final float RATING_HORIZONTAL_PADDING = 17.0f;
    private static final float RATING_VERTICAL_PADDING = 14.0f;
    private static final float SELECTED_RATING_SCALE = 1.2f;
    private final Api api;
    private final Provider<AppConfig> appConfigProvider;
    private final String conversationId;
    /* access modifiers changed from: private */
    public ConversationRating conversationRating;
    private final ColorFilter deselectedFilter;
    private final View.OnClickListener ratingClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            int indexOf = ConversationRatingCard.this.ratingViews.indexOf(view);
            if (indexOf != -1 && ConversationRatingCard.this.ratingViews.size() == ConversationRatingCard.this.conversationRating.getOptions().size()) {
                ConversationRatingCard conversationRatingCard = ConversationRatingCard.this;
                conversationRatingCard.rateConversation(conversationRatingCard.conversationRating, ConversationRatingCard.this.conversationRating.getOptions().get(indexOf));
                ConversationRatingCard.this.updateSelectedRating();
            }
        }
    };
    /* access modifiers changed from: private */
    public final List<ImageView> ratingViews;
    private LinearLayout rootLayout;

    ConversationRatingCard(Api api2, String str, Provider<AppConfig> provider) {
        this.api = api2;
        this.conversationId = str;
        this.appConfigProvider = provider;
        this.ratingViews = new ArrayList();
        this.deselectedFilter = ColorUtils.newGreyscaleFilter();
    }

    public View addConversationRatingBlock(ConversationRating conversationRating2, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        return createConversationRatingBlock(conversationRating2, viewGroup);
    }

    private View createConversationRatingBlock(ConversationRating conversationRating2, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        this.ratingViews.clear();
        this.conversationRating = conversationRating2;
        this.rootLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.intercom_conversation_rating_block, viewGroup, false);
        updateViewVisibility();
        Button button = (Button) this.rootLayout.findViewById(R.id.intercom_rating_tell_us_more_button);
        BackgroundUtils.setBackground(button, new ButtonSelector(context, R.drawable.intercom_border, this.appConfigProvider.get().getPrimaryColor()));
        FontUtils.setRobotoMediumTypeface(button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ConversationRatingCard.this.showRemarkDialog(view.getContext());
            }
        });
        setupRatingsLayout();
        updateSelectedRating();
        return this.rootLayout;
    }

    private void setupRatingsLayout() {
        LinearLayout linearLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_rating_options_layout);
        Context context = this.rootLayout.getContext();
        int dpToPx = ScreenUtils.dpToPx(14.0f, context);
        int dpToPx2 = ScreenUtils.dpToPx(RATING_HORIZONTAL_PADDING, context);
        for (int i = 0; i < this.conversationRating.getOptions().size(); i++) {
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setClipChildren(false);
            frameLayout.setClipToPadding(false);
            frameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            ImageView imageView = new ImageView(context);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.intercom_conversation_rating_size);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize, 17);
            layoutParams.setMargins(dpToPx2, dpToPx, dpToPx2, dpToPx);
            imageView.setLayoutParams(layoutParams);
            imageView.setLongClickable(false);
            IntercomCoilKt.loadIntercomImage(context, new ImageRequest.Builder(context).data(imageUrlForUnicode(this.conversationRating.getOptions().get(i).getUnicode())).target(imageView).build());
            imageView.setOnClickListener(this.ratingClickListener);
            frameLayout.addView(imageView);
            linearLayout.addView(frameLayout);
            this.ratingViews.add(imageView);
        }
    }

    private void updateViewVisibility() {
        if (this.rootLayout != null) {
            int i = 0;
            boolean z = this.conversationRating.getRatingIndex().intValue() != -1;
            boolean z2 = !TextUtils.isEmpty(this.conversationRating.getRemark());
            ((TextView) this.rootLayout.findViewById(R.id.rate_your_conversation_text_view)).setVisibility(z2 ? 8 : 0);
            ((LinearLayout) this.rootLayout.findViewById(R.id.intercom_rating_options_layout)).setVisibility(z2 ? 8 : 0);
            ((Button) this.rootLayout.findViewById(R.id.intercom_rating_tell_us_more_button)).setVisibility((!z || z2) ? 8 : 0);
            LinearLayout linearLayout = (LinearLayout) this.rootLayout.findViewById(R.id.intercom_you_rated_layout);
            if (!z2) {
                i = 8;
            }
            linearLayout.setVisibility(i);
            ConversationRatingOption findSelectedOption = findSelectedOption();
            if (findSelectedOption != null) {
                ImageView imageView = (ImageView) this.rootLayout.findViewById(R.id.intercom_you_rated_image_view);
                IntercomCoilKt.loadIntercomImage(imageView.getContext(), new ImageRequest.Builder(imageView.getContext()).data(imageUrlForUnicode(findSelectedOption.getUnicode())).target(imageView).build());
            }
        }
    }

    private ConversationRatingOption findSelectedOption() {
        for (ConversationRatingOption next : this.conversationRating.getOptions()) {
            if (next.getIndex().equals(this.conversationRating.getRatingIndex())) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void rateConversation(ConversationRating conversationRating2, ConversationRatingOption conversationRatingOption) {
        if (!conversationRating2.getRatingIndex().equals(conversationRatingOption.getIndex())) {
            conversationRating2.setRatingIndex(conversationRatingOption.getIndex().intValue());
            this.api.rateConversation(this.conversationId, conversationRatingOption.getIndex().intValue());
            updateViewVisibility();
        }
    }

    /* access modifiers changed from: package-private */
    public void addRemarkToConversation(ConversationRating conversationRating2, String str) {
        if (TextUtils.isEmpty(conversationRating2.getRemark())) {
            conversationRating2.setRemark(str);
            this.api.addConversationRatingRemark(this.conversationId, str);
            updateViewVisibility();
        }
    }

    /* access modifiers changed from: private */
    public void updateSelectedRating() {
        if (this.conversationRating.getOptions().size() == this.ratingViews.size()) {
            for (int i = 0; i < this.conversationRating.getOptions().size(); i++) {
                ConversationRatingOption conversationRatingOption = this.conversationRating.getOptions().get(i);
                ImageView imageView = this.ratingViews.get(i);
                if (this.conversationRating.getRatingIndex().intValue() == -1) {
                    selectView(1.0f, imageView);
                } else if (this.conversationRating.getRatingIndex().equals(conversationRatingOption.getIndex())) {
                    selectView(SELECTED_RATING_SCALE, imageView);
                } else {
                    deselectView(imageView);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void showRemarkDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.intercom_tell_us_more);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dpToPx = ScreenUtils.dpToPx(DIALOG_HORIZONTAL_MARGIN, context);
        layoutParams.setMargins(dpToPx, 0, dpToPx, 0);
        final EditText editText = new EditText(context);
        editText.getBackground().mutate().setColorFilter(this.appConfigProvider.get().getPrimaryColor(), PorterDuff.Mode.SRC_ATOP);
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        builder.setView((View) linearLayout);
        builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = editText.getText().toString();
                ConversationRatingCard conversationRatingCard = ConversationRatingCard.this;
                conversationRatingCard.addRemarkToConversation(conversationRatingCard.conversationRating, obj);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog create = builder.create();
        create.show();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z && create.getWindow() != null) {
                    create.getWindow().setSoftInputMode(5);
                }
            }
        });
        create.getButton(-1).setTextColor(this.appConfigProvider.get().getPrimaryColor());
        create.getButton(-2).setTextColor(this.appConfigProvider.get().getPrimaryColor());
    }

    private void selectView(float f, ImageView imageView) {
        imageView.animate().setInterpolator(new OvershootInterpolator(2.0f)).scaleX(f).scaleY(f).setDuration(ANIMATION_DURATION_MS).start();
        imageView.clearColorFilter();
    }

    private void deselectView(ImageView imageView) {
        imageView.animate().setInterpolator(new OvershootInterpolator(0.6f)).scaleX(1.0f).scaleY(1.0f).setDuration(ANIMATION_DURATION_MS).start();
        imageView.setColorFilter(this.deselectedFilter);
    }

    private static String imageUrlForUnicode(String str) {
        return "https://js.intercomcdn.com/images/stickers/" + str + ".png";
    }
}
