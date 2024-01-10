package com.trainerfu.story;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.trainerfu.android.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class LikesDetailBinder extends SectionPartBinder {
    private Context context;
    /* access modifiers changed from: private */
    public EventListener eventListener;
    private StoryBaseViewModel storyViewModel;

    public interface EventListener {
        void onShowLikes(JSONArray jSONArray);
    }

    public LikesDetailBinder(Context context2, StoryBaseViewModel storyBaseViewModel, EventListener eventListener2) {
        super(context2);
        this.context = context2;
        this.storyViewModel = storyBaseViewModel;
        this.eventListener = eventListener2;
    }

    public void bind(SectionPartView sectionPartView) {
        super.bind(sectionPartView);
        if (sectionPartView instanceof SectionIconTextView) {
            final JSONArray likes = this.storyViewModel.getLikes();
            int myUserId = this.storyViewModel.getMyUserId();
            new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append("Liked by ");
            int i = 0;
            while (true) {
                if (i >= likes.length()) {
                    break;
                }
                try {
                    if (likes.getJSONObject(i).getInt("user_id") == myUserId) {
                        spannableStringBuilder.append("You");
                    } else {
                        spannableStringBuilder.append(likes.getJSONObject(i).getString("first_name"));
                    }
                    if (i < likes.length() - 1) {
                        if (i == likes.length() - 2) {
                            spannableStringBuilder.append(" and ");
                        } else {
                            spannableStringBuilder.append(", ");
                        }
                    }
                    if (i != 4 || likes.length() <= 5) {
                        i++;
                    } else {
                        int length = likes.length() - 5;
                        String str = "other";
                        if (length > 1) {
                            str = "others";
                        }
                        SpannableString spannableString = new SpannableString(String.format("%d %s", new Object[]{Integer.valueOf(length), str}));
                        spannableString.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                if (LikesDetailBinder.this.eventListener != null) {
                                    LikesDetailBinder.this.eventListener.onShowLikes(likes);
                                }
                            }

                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setUnderlineText(false);
                            }
                        }, 0, spannableString.length(), 33);
                        spannableString.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.tintColor)), 0, spannableString.length(), 33);
                        spannableStringBuilder.append(spannableString);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            ((SectionIconTextView) sectionPartView).setText(spannableStringBuilder);
            return;
        }
        throw new IllegalArgumentException("Invalid view");
    }
}
