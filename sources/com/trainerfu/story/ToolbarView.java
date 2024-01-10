package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.android.R;

public class ToolbarView extends SectionPartView implements View.OnClickListener {
    private IconTextView carrotView;
    private LinearLayout commentBtn;
    private EventListener eventListener;
    private LinearLayout likeBtn;
    private ImageView likeIcon;
    private ImageView likeSelectedIcon;
    private TextView likeText;
    private boolean liked;
    private IconTextView nextBtn;
    private boolean nextEnabled;
    private LinearLayout ppTooltipView;
    private IconTextView prevBtn;
    private boolean prevEnabled;
    private LinearLayout shareBtn;
    private int storyId;

    public interface EventListener {
        void onAddComment(int i);

        void onGoNext(int i);

        void onGoPrev(int i);

        void onLikeStory(int i);

        void onShare(int i);

        void onShowMoreOptions(int i, int i2);

        void onUnlikeStory(int i);
    }

    public ToolbarView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ToolbarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ToolbarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nextEnabled = true;
        this.prevEnabled = true;
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.section_toolbar_view, this);
        this.likeBtn = (LinearLayout) findViewById(R.id.like_btn);
        this.likeIcon = (ImageView) findViewById(R.id.like_icon);
        this.likeText = (TextView) findViewById(R.id.like);
        this.likeBtn.setOnClickListener(this);
        this.likeSelectedIcon = (ImageView) findViewById(R.id.like_selected_icon);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.comment_btn);
        this.commentBtn = linearLayout;
        linearLayout.setOnClickListener(this);
        IconTextView iconTextView = (IconTextView) findViewById(R.id.prev_btn);
        this.prevBtn = iconTextView;
        iconTextView.setOnClickListener(this);
        IconTextView iconTextView2 = (IconTextView) findViewById(R.id.next_btn);
        this.nextBtn = iconTextView2;
        iconTextView2.setOnClickListener(this);
        this.carrotView = (IconTextView) findViewById(R.id.carrot_view);
        this.ppTooltipView = (LinearLayout) findViewById(R.id.pp_tooltip_view);
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    public void setStoryId(int i) {
        this.storyId = i;
    }

    public void setShowPrevNextBtn(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            this.prevBtn.setVisibility(0);
            this.nextBtn.setVisibility(0);
        } else {
            this.prevBtn.setVisibility(8);
            this.nextBtn.setVisibility(8);
        }
        this.prevEnabled = z2;
        if (!z2 || !z) {
            this.prevBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.lightGrayColor));
        } else {
            this.prevBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.tintColor));
        }
        this.nextEnabled = z3;
        if (!z3 || !z) {
            this.nextBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.lightGrayColor));
        } else {
            this.nextBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.tintColor));
        }
        if (!z4 || !z4 || !z3) {
            this.carrotView.setVisibility(8);
            this.ppTooltipView.setVisibility(8);
            return;
        }
        this.carrotView.setVisibility(0);
        this.ppTooltipView.setVisibility(0);
    }

    public void setShowCommentBtn(boolean z) {
        if (z) {
            this.commentBtn.setVisibility(0);
        } else {
            this.commentBtn.setVisibility(8);
        }
    }

    public void setLiked(boolean z) {
        this.liked = z;
        if (z) {
            this.likeSelectedIcon.setVisibility(0);
            this.likeIcon.setVisibility(8);
            this.likeText.setTextColor(getResources().getColor(R.color.salmonColor));
            return;
        }
        this.likeSelectedIcon.setVisibility(8);
        this.likeIcon.setVisibility(0);
        this.likeText.setTextColor(getResources().getColor(R.color.lightBlack));
    }

    public boolean getLiked() {
        return this.liked;
    }

    public void onClick(View view) {
        if (this.eventListener != null) {
            int id = view.getId();
            if (id == R.id.like_btn) {
                if (getLiked()) {
                    this.eventListener.onUnlikeStory(this.storyId);
                } else {
                    this.eventListener.onLikeStory(this.storyId);
                }
            } else if (id == R.id.comment_btn) {
                this.eventListener.onAddComment(this.storyId);
            } else if (id == R.id.prev_btn) {
                if (this.prevEnabled) {
                    this.eventListener.onGoPrev(this.storyId);
                }
            } else if (id == R.id.next_btn && this.nextEnabled) {
                this.eventListener.onGoNext(this.storyId);
            }
        }
    }
}
