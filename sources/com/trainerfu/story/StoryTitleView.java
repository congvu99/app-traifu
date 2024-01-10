package com.trainerfu.story;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.joanzapata.iconify.widget.IconTextView;
import com.squareup.picasso.Picasso;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;
import de.hdodenhof.circleimageview.CircleImageView;

public class StoryTitleView extends StoryBasePartView implements View.OnClickListener {
    private static Drawable profilePlaceholderDrawable;
    /* access modifiers changed from: private */
    public EventListener eventListener;
    private boolean hasMoreOptions;
    private LinearLayout moreBtn;
    private int storyId;
    /* access modifiers changed from: private */
    public int userId;
    /* access modifiers changed from: private */
    public String userName;

    public interface EventListener {
        void onNameClick(int i, String str);

        void onShowMoreOptions(int i, int i2);
    }

    public enum Icon {
        PINNED,
        PRIVATE,
        SHOWN_TO_EVERYONE,
        NONE
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    public void setStoryId(int i) {
        this.storyId = i;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    static {
        Drawable drawable = ResourcesCompat.getDrawable(MyApplication.getAppContext().getResources(), R.drawable.profile, (Resources.Theme) null);
        profilePlaceholderDrawable = drawable;
        drawable.setColorFilter(Color.argb(255, 230, 230, 230), PorterDuff.Mode.SRC_IN);
    }

    public StoryTitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StoryTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.story_title_view, this);
        ((ImageView) findViewById(R.id.placeholder_photo_view)).setImageDrawable(profilePlaceholderDrawable);
        this.moreBtn = (LinearLayout) findViewById(R.id.more_btn);
    }

    public void setTitle(Spanned spanned, Boolean bool) {
        TextView textView = (TextView) findViewById(R.id.title_view);
        if (bool.booleanValue()) {
            SpannableString spannableString = new SpannableString(spanned);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    StoryTitleView.this.eventListener.onNameClick(StoryTitleView.this.userId, StoryTitleView.this.userName);
                }

                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setUnderlineText(false);
                }
            }, 0, this.userName.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.tintColor)), 0, this.userName.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        textView.setText(spanned);
    }

    public void setSubtitle(String str) {
        ((TextView) findViewById(R.id.sub_title_view)).setText(str);
    }

    public void setPhoto(int i) {
        if (i == 0) {
            findViewById(R.id.placeholder_photo_view).setVisibility(0);
            findViewById(R.id.photo_view).setVisibility(8);
            return;
        }
        findViewById(R.id.placeholder_photo_view).setVisibility(8);
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.photo_view);
        circleImageView.setVisibility(0);
        Picasso.get().load(Util.getUrlForPhoto(i)).error((int) R.drawable.profile).into((ImageView) circleImageView);
    }

    public void setIcon(Icon icon) {
        IconTextView iconTextView = (IconTextView) findViewById(R.id.icon_view);
        IconTextView iconTextView2 = (IconTextView) findViewById(R.id.lock_icon_view);
        if (icon == Icon.PINNED) {
            iconTextView.setVisibility(0);
            iconTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.pinned));
            iconTextView.setText("{fa-thumb-tack}");
        } else if (icon == Icon.PRIVATE) {
            iconTextView2.setVisibility(0);
            iconTextView2.setTextColor(ContextCompat.getColor(getContext(), R.color.lightGrayColor));
            iconTextView2.setText("{md-lock}");
        } else {
            iconTextView2.setVisibility(8);
            iconTextView.setVisibility(8);
        }
    }

    public void setHasMoreOptions(boolean z) {
        this.hasMoreOptions = z;
        if (z) {
            this.moreBtn.setVisibility(0);
            this.moreBtn.setOnClickListener(this);
            return;
        }
        this.moreBtn.setVisibility(8);
    }

    public void togglePinnedBorder(Boolean bool) {
        findViewById(R.id.pinned_border).setVisibility(bool.booleanValue() ? 0 : 8);
    }

    public void onClick(View view) {
        if (this.eventListener != null && view.getId() == R.id.more_btn) {
            this.eventListener.onShowMoreOptions(this.storyId, this.userId);
        }
    }
}
