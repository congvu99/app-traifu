package com.trainerfu.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.facebook.appevents.AppEventsConstants;
import com.joanzapata.iconify.widget.IconTextView;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoryView extends RelativeLayout {
    private static Drawable commentDrawable;
    private static Drawable likeDrawable;
    private static Drawable lockDrawable;
    private static Drawable moreDrawable;
    private static Drawable profilePlaceholderDrawable;
    private boolean canSeeCommentsOfOthers;
    private boolean canSeeWorkoutDetailsOfOthers;
    private String currentPhotoUrl;
    private String currentProfilePicUrl;
    /* access modifiers changed from: private */
    public StoryViewEventListener eventListener;
    private boolean forNotification;
    private boolean isViewedByTrainer;
    private ArrayList<JSONObject> likes;
    private int myUserId;
    private Integer profilePicId;
    /* access modifiers changed from: private */
    public JSONObject story;

    static {
        Context appContext = MyApplication.getAppContext();
        Drawable drawable = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.profile, (Resources.Theme) null);
        profilePlaceholderDrawable = drawable;
        drawable.setColorFilter(Color.argb(255, 230, 230, 230), PorterDuff.Mode.SRC_IN);
        Drawable drawable2 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.ic_chat_bubble_black_24dp, (Resources.Theme) null);
        commentDrawable = drawable2;
        drawable2.setColorFilter(ContextCompat.getColor(appContext, R.color.lightGrayColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable3 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.ic_favorite_black_24dp, (Resources.Theme) null);
        likeDrawable = drawable3;
        drawable3.setColorFilter(ContextCompat.getColor(appContext, R.color.lightGrayColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable4 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.ic_lock_black_24dp, (Resources.Theme) null);
        lockDrawable = drawable4;
        drawable4.setColorFilter(ContextCompat.getColor(appContext, R.color.lightGrayColor), PorterDuff.Mode.SRC_IN);
        Drawable drawable5 = ResourcesCompat.getDrawable(appContext.getResources(), R.drawable.ic_more_vert_black_24dp, (Resources.Theme) null);
        moreDrawable = drawable5;
        drawable5.setColorFilter(ContextCompat.getColor(appContext, R.color.lightGrayColor), PorterDuff.Mode.SRC_IN);
    }

    public StoryView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentProfilePicUrl = null;
        this.currentPhotoUrl = null;
        this.canSeeCommentsOfOthers = false;
        this.canSeeWorkoutDetailsOfOthers = false;
        this.isViewedByTrainer = false;
        this.forNotification = false;
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.story_view, this);
        ((ImageView) findViewById(R.id.lockIV)).setImageDrawable(lockDrawable);
        ((ImageView) findViewById(R.id.moreBtn)).setImageDrawable(moreDrawable);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void registerMoreBtnForContextMenu(Activity activity, View.OnCreateContextMenuListener onCreateContextMenuListener, int i) {
        ImageView imageView = (ImageView) findViewById(R.id.moreBtn);
        activity.registerForContextMenu(imageView);
        imageView.setOnCreateContextMenuListener(onCreateContextMenuListener);
        imageView.setTag(Integer.valueOf(i));
    }

    public void setStory(JSONObject jSONObject, int i, boolean z, Integer num, boolean z2, boolean z3, boolean z4) {
        this.story = jSONObject;
        this.myUserId = i;
        this.profilePicId = num;
        this.canSeeCommentsOfOthers = z2;
        this.canSeeWorkoutDetailsOfOthers = z3;
        this.forNotification = z4;
        this.isViewedByTrainer = z;
        this.forNotification = z4;
        bind();
    }

    public void setLikes(ArrayList<JSONObject> arrayList) {
        this.likes = arrayList;
        bind();
    }

    public void setEventListener(StoryViewEventListener storyViewEventListener) {
        this.eventListener = storyViewEventListener;
    }

    public void bind() {
        String str;
        Pair<Boolean, String> pair;
        String str2;
        if (this.story != null) {
            try {
                StoryType storyType = getStoryType();
                int i = this.story.getInt("user_id");
                String string = this.story.getString("first_name");
                String storyViewDisplayDate = DateUtils.getStoryViewDisplayDate(getContext(), DateUtils.getDateFromISOFormat(this.story.getString("date")));
                SmartImageView smartImageView = (SmartImageView) findViewById(R.id.profileIV);
                if (this.profilePicId != null) {
                    String urlForPhoto = Util.getUrlForPhoto(this.profilePicId.intValue());
                    if (this.currentProfilePicUrl == null || !this.currentProfilePicUrl.equals(urlForPhoto)) {
                        smartImageView.setImageUrl(urlForPhoto);
                    }
                    this.currentPhotoUrl = urlForPhoto;
                } else {
                    smartImageView.setImageDrawable(profilePlaceholderDrawable);
                }
                TextView textView = (TextView) findViewById(R.id.titleTV);
                if (getStoryType() == StoryType.WORKOUT_LOG) {
                    str = String.format(getContext().getString(R.string.loggedAWorkout), new Object[]{string});
                } else {
                    str = String.format(getContext().getString(R.string.addedAPhoto), new Object[]{string});
                }
                int indexOf = str.indexOf(string);
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new StyleSpan(1), indexOf, string.length() + indexOf, 0);
                textView.setText(spannableString);
                ((TextView) findViewById(R.id.dateTV)).setText(storyViewDisplayDate);
                ImageView imageView = (ImageView) findViewById(R.id.lockIV);
                if (this.story.getBoolean("is_public")) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                SmartImageView smartImageView2 = (SmartImageView) findViewById(R.id.photoIV);
                if (!this.story.has("photo_id") || this.story.isNull("photo_id")) {
                    smartImageView2.setVisibility(8);
                } else {
                    String urlForPhoto2 = Util.getUrlForPhoto(this.story.getInt("photo_id"));
                    if (this.currentPhotoUrl == null || !urlForPhoto2.equals(this.currentPhotoUrl)) {
                        smartImageView2.setImageUrl(urlForPhoto2);
                        smartImageView2.setVisibility(0);
                    }
                    this.currentPhotoUrl = urlForPhoto2;
                }
                String storyNote = getStoryNote();
                TextView textView2 = (TextView) findViewById(R.id.noteTV);
                if (storyNote == null) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(storyNote);
                    textView2.setVisibility(0);
                }
                final String str3 = null;
                if (storyType == StoryType.WORKOUT_LOG) {
                    str2 = getWorkoutSummary();
                    pair = getWorkoutDetails();
                } else {
                    str2 = null;
                    pair = null;
                }
                if (str2 != null) {
                    str3 = (String) pair.second;
                }
                final TextView textView3 = (TextView) findViewById(R.id.workoutTV);
                if (str2 != null) {
                    textView3.setVisibility(0);
                    if (((Boolean) pair.first).booleanValue()) {
                        if (str2.length() > 70) {
                            str2 = str2.substring(0, 70);
                        }
                        textView3.setMovementMethod(LinkMovementMethod.getInstance());
                        SpannableString spannableString2 = new SpannableString(String.format("%s ..%s", new Object[]{str2, getContext().getString(R.string.seeDetails)}));
                        spannableString2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.tintColor)), str2.length(), spannableString2.length(), 33);
                        spannableString2.setSpan(new ClickableSpan() {
                            public void onClick(View view) {
                                textView3.setText(str3);
                            }

                            public void updateDrawState(TextPaint textPaint) {
                                textPaint.setUnderlineText(false);
                            }
                        }, str2.length(), spannableString2.length(), 33);
                        textView3.setText(spannableString2);
                    } else {
                        textView3.setText(str2);
                    }
                } else {
                    textView3.setVisibility(8);
                }
                loadCommentSection();
                final boolean loadLikeSection = loadLikeSection();
                Resources resources = getContext().getResources();
                IconTextView iconTextView = (IconTextView) findViewById(R.id.likeitBtn);
                if (loadLikeSection) {
                    iconTextView.setBackground(getContext().getResources().getDrawable(R.drawable.rounded_denim_button_with_border));
                    iconTextView.setTextColor(resources.getColor(R.color.white));
                } else {
                    iconTextView.setBackground(getContext().getResources().getDrawable(R.drawable.rounded_white_button_with_border));
                    iconTextView.setTextColor(resources.getColor(R.color.darkGrayColor));
                }
                iconTextView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (StoryView.this.eventListener != null) {
                            StoryView.this.eventListener.likeitClicked(StoryView.this.story, !loadLikeSection);
                        }
                    }
                });
                IconTextView iconTextView2 = (IconTextView) findViewById(R.id.commentBtn);
                if (this.isViewedByTrainer || i == this.myUserId || this.canSeeCommentsOfOthers) {
                    iconTextView2.setVisibility(0);
                } else {
                    iconTextView2.setVisibility(8);
                }
                iconTextView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (StoryView.this.eventListener != null) {
                            StoryView.this.eventListener.addCommentClicked(StoryView.this.story);
                        }
                    }
                });
                ImageView imageView2 = (ImageView) findViewById(R.id.moreBtn);
                if ((this.isViewedByTrainer || i == this.myUserId) && !this.forNotification) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
                imageView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        StoryView.this.eventListener.showMoreOptionsClicked(view, StoryView.this.story);
                    }
                });
                invalidate();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean loadLikeSection() {
        View findViewById = findViewById(R.id.likesWrapperV);
        int i = 0;
        if (this.likes != null) {
            findViewById.setVisibility(0);
            ((ImageView) findViewById(R.id.likeIV)).setImageDrawable(likeDrawable);
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            while (i < this.likes.size()) {
                try {
                    JSONObject jSONObject = this.likes.get(i);
                    int length = sb.length();
                    sb.append(jSONObject.getString("favorited_by"));
                    int length2 = sb.length();
                    if (i < this.likes.size() - 1) {
                        sb.append(", ");
                    }
                    arrayList.add(new Pair(Integer.valueOf(length), Integer.valueOf(length2)));
                    if (this.myUserId == jSONObject.getInt("favorited_by_id")) {
                        z = true;
                    }
                    i++;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            SpannableString spannableString = new SpannableString(sb.toString());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.tintColor)), ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 33);
                spannableString.setSpan(new StyleSpan(1), ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 33);
            }
            ((TextView) findViewById(R.id.likesTV)).setText(spannableString);
            return z;
        }
        findViewById.setVisibility(8);
        return false;
    }

    public void loadCommentSection() {
        View findViewById = findViewById(R.id.commentsWrapperV);
        try {
            if (this.isViewedByTrainer || this.story.getInt("user_id") == this.myUserId || this.canSeeCommentsOfOthers) {
                JSONArray jSONArray = this.story.getJSONArray("comments");
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!jSONObject.getBoolean("is_featured") || z) {
                        String string = jSONObject.getString("first_name");
                        String string2 = jSONObject.getString("comment");
                        int length = sb.length();
                        sb.append(string);
                        arrayList.add(new Pair(Integer.valueOf(length), Integer.valueOf(sb.length())));
                        sb.append(": ");
                        sb.append(string2);
                        if (i < jSONArray.length() - 1) {
                            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                        }
                    } else {
                        z = true;
                    }
                }
                if (sb.length() == 0) {
                    findViewById.setVisibility(8);
                    return;
                }
                findViewById.setVisibility(0);
                ((ImageView) findViewById(R.id.commentIV)).setImageDrawable(commentDrawable);
                TextView textView = (TextView) findViewById(R.id.commentTV);
                SpannableString spannableString = new SpannableString(sb.toString());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.tintColor)), ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 33);
                    spannableString.setSpan(new StyleSpan(1), ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), 33);
                }
                textView.setText(spannableString);
                return;
            }
            findViewById.setVisibility(8);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getStoryNote() throws org.json.JSONException {
        /*
            r5 = this;
            com.trainerfu.android.StoryType r0 = r5.getStoryType()
            com.trainerfu.android.StoryType r1 = com.trainerfu.android.StoryType.WORKOUT_LOG
            r2 = 0
            if (r0 != r1) goto L_0x0034
            org.json.JSONObject r0 = r5.story
            java.lang.String r1 = "comments"
            org.json.JSONArray r0 = r0.getJSONArray(r1)
            r1 = 0
        L_0x0012:
            int r3 = r0.length()
            if (r1 >= r3) goto L_0x0049
            java.lang.Object r3 = r0.get(r1)
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            java.lang.String r4 = "is_featured"
            boolean r4 = r3.getBoolean(r4)
            if (r4 == 0) goto L_0x0031
            java.lang.String r0 = "comment"
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r0 = r0.trim()
            goto L_0x004a
        L_0x0031:
            int r1 = r1 + 1
            goto L_0x0012
        L_0x0034:
            org.json.JSONObject r0 = r5.story
            java.lang.String r1 = "note"
            boolean r0 = r0.isNull(r1)
            if (r0 != 0) goto L_0x0049
            org.json.JSONObject r0 = r5.story
            java.lang.String r0 = r0.getString(r1)
            java.lang.String r0 = r0.trim()
            goto L_0x004a
        L_0x0049:
            r0 = r2
        L_0x004a:
            if (r0 == 0) goto L_0x0054
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = r0
        L_0x0054:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.StoryView.getStoryNote():java.lang.String");
    }

    private StoryType getStoryType() throws JSONException {
        return StoryType.getStoryType(this.story.getInt("story_type"));
    }

    private String getWorkoutSummary() throws JSONException {
        if (!this.isViewedByTrainer && this.story.getInt("user_id") != this.myUserId && !this.canSeeWorkoutDetailsOfOthers) {
            return null;
        }
        JSONArray jSONArray = this.story.getJSONArray("drills");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getJSONObject(i).getString("exercise_name"));
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return TextUtils.join(", ", arrayList);
    }

    private Pair<Boolean, String> getWorkoutDetails() throws JSONException {
        if (!this.isViewedByTrainer && this.story.getInt("user_id") != this.myUserId && !this.canSeeWorkoutDetailsOfOthers) {
            return new Pair<>(false, (Object) null);
        }
        JSONArray jSONArray = this.story.getJSONArray("drills");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            Pair<Boolean, String> detailsForDrill = getDetailsForDrill(jSONArray.getJSONObject(i));
            arrayList.add(detailsForDrill.second);
            if (((Boolean) detailsForDrill.first).booleanValue()) {
                z = true;
            }
        }
        if (arrayList.size() == 0) {
            return new Pair<>(false, (Object) null);
        }
        return new Pair<>(z, TextUtils.join(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, arrayList));
    }

    private Pair<Boolean, String> getDetailsForDrill(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        JSONArray jSONArray = jSONObject.getJSONArray("measures");
        for (int i = 0; i < 5; i++) {
            String string = jSONArray.getString(i);
            if (!string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO) && !string.equals("0.0")) {
                z = true;
                if (i == 0) {
                    arrayList.add(String.format("%s: %s", new Object[]{getContext().getString(R.string.sets), string}));
                } else if (i == 1) {
                    arrayList.add(String.format("%s: %s", new Object[]{getContext().getString(R.string.reps), string}));
                } else if (i == 2) {
                    arrayList.add(String.format("%s: %s", new Object[]{getContext().getString(R.string.weight), string}));
                } else if (i == 3) {
                    arrayList.add(String.format("%s: %s", new Object[]{getContext().getString(R.string.distance), string}));
                } else if (i == 4) {
                    arrayList.add(String.format("%s: %s", new Object[]{getContext().getString(R.string.duration), string}));
                }
            }
        }
        String string2 = jSONObject.getString("exercise_name");
        if (arrayList.size() != 0) {
            string2 = String.format("%s- %s", new Object[]{string2, TextUtils.join(", ", arrayList)});
        }
        return new Pair<>(z, string2);
    }
}
