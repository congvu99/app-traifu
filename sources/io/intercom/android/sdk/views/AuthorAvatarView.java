package io.intercom.android.sdk.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.utilities.AvatarUtils;
import java.util.List;

public class AuthorAvatarView extends FrameLayout {
    private final ActiveStatePresenter activeStatePresenter;
    private final int activeStateSize;
    private final View activeStateView;
    private final int imageViewSize;
    private final ImageView leftImageView;
    private final ImageView rightImageView;
    private final int teamAvatarPadding;
    private final ImageView topImageView;

    public AuthorAvatarView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX INFO: finally extract failed */
    public AuthorAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.activeStatePresenter = new ActiveStatePresenter();
        this.rightImageView = new ImageView(context);
        this.topImageView = new ImageView(context);
        this.leftImageView = new ImageView(context);
        this.activeStateView = new View(context);
        addView(this.rightImageView);
        addView(this.topImageView);
        addView(this.leftImageView);
        addView(this.activeStateView);
        this.leftImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.rightImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.topImageView.setBackgroundResource(R.drawable.intercom_solid_circle);
        this.activeStateView.setVisibility(8);
        int dpToPx = ScreenUtils.dpToPx(1.0f, context);
        this.teamAvatarPadding = dpToPx;
        this.leftImageView.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        ImageView imageView = this.rightImageView;
        int i = this.teamAvatarPadding;
        imageView.setPadding(i, i, i, i);
        ImageView imageView2 = this.topImageView;
        int i2 = this.teamAvatarPadding;
        imageView2.setPadding(i2, i2, i2, i2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AuthorAvatarView, 0, 0);
        try {
            this.imageViewSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AuthorAvatarView_avatarSize, 0);
            this.activeStateSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AuthorAvatarView_activeStateSize, 0);
            obtainStyledAttributes.recycle();
            View view = this.activeStateView;
            int i3 = this.activeStateSize;
            view.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 8388693));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void loadAvatars(List<Participant> list, AppConfig appConfig) {
        int size = list.size();
        if (size == 0) {
            loadDefaultDrawable(appConfig);
        } else if (size == 1) {
            loadAvatar(list.get(0).getAvatar(), appConfig);
        } else if (size != 2) {
            loadThreeAvatars(list.get(0), list.get(1), list.get(2), appConfig);
        } else {
            loadTwoAvatars(list.get(0), list.get(1), appConfig);
        }
    }

    public void hideActiveStateIndicator(Boolean bool) {
        if (bool.booleanValue()) {
            this.activeStateView.setVisibility(0);
        } else {
            this.activeStateView.setVisibility(8);
        }
    }

    private void loadDefaultDrawable(AppConfig appConfig) {
        this.leftImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStateView.setVisibility(8);
        requestLayout();
        ImageView imageView = this.leftImageView;
        imageView.setImageDrawable(AvatarUtils.getDefaultDrawable(imageView.getContext(), appConfig));
    }

    public void loadAvatar(Avatar avatar, AppConfig appConfig) {
        this.leftImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStateView.setVisibility(8);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(avatar, this.leftImageView, appConfig);
    }

    public void loadAvatarWithActiveState(Avatar avatar, boolean z, AppConfig appConfig) {
        this.leftImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.leftImageView.setPadding(0, 0, 0, 0);
        setNumberOfVisibleAvatars(1);
        this.activeStatePresenter.presentStateDot(z, this.activeStateView, appConfig);
        this.activeStateView.setVisibility(0);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(avatar, this.leftImageView, appConfig);
    }

    private void loadTwoAvatars(Participant participant, Participant participant2, AppConfig appConfig) {
        ImageView imageView = this.leftImageView;
        int i = this.imageViewSize;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(i, i, 8388627));
        ImageView imageView2 = this.leftImageView;
        int i2 = this.teamAvatarPadding;
        imageView2.setPadding(i2, i2, i2, i2);
        ImageView imageView3 = this.rightImageView;
        int i3 = this.imageViewSize;
        imageView3.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 8388629));
        setNumberOfVisibleAvatars(2);
        this.activeStateView.setVisibility(8);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.leftImageView, appConfig);
        AvatarUtils.loadAvatarIntoView(participant2.getAvatar(), this.rightImageView, appConfig);
    }

    private void loadThreeAvatars(Participant participant, Participant participant2, Participant participant3, AppConfig appConfig) {
        ImageView imageView = this.leftImageView;
        int i = this.imageViewSize;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(i, i, 8388691));
        ImageView imageView2 = this.leftImageView;
        int i2 = this.teamAvatarPadding;
        imageView2.setPadding(i2, i2, i2, i2);
        ImageView imageView3 = this.rightImageView;
        int i3 = this.imageViewSize;
        imageView3.setLayoutParams(new FrameLayout.LayoutParams(i3, i3, 8388693));
        ImageView imageView4 = this.topImageView;
        int i4 = this.imageViewSize;
        imageView4.setLayoutParams(new FrameLayout.LayoutParams(i4, i4, 49));
        this.activeStateView.setVisibility(8);
        setNumberOfVisibleAvatars(3);
        requestLayout();
        AvatarUtils.loadAvatarIntoView(participant.getAvatar(), this.leftImageView, appConfig);
        AvatarUtils.loadAvatarIntoView(participant2.getAvatar(), this.rightImageView, appConfig);
        AvatarUtils.loadAvatarIntoView(participant3.getAvatar(), this.topImageView, appConfig);
    }

    private void setNumberOfVisibleAvatars(int i) {
        int i2 = 0;
        this.leftImageView.setVisibility(i >= 1 ? 0 : 8);
        this.rightImageView.setVisibility(i >= 2 ? 0 : 8);
        ImageView imageView = this.topImageView;
        if (i < 3) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }
}
