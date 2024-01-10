package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.trainerfu.android.R;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class BeforeAfterView extends SectionPartView {
    private String currentAfterPhotoUrl;
    private String currentBeforePhotoUrl;
    private EventListener eventListener;

    public interface EventListener {
        void onAddComment(int i);

        void onGoNext(int i);

        void onGoPrev(int i);

        void onLikeStory(int i);

        void onShare(int i);

        void onShowMoreOptions(int i);

        void onUnlikeStory(int i);
    }

    public BeforeAfterView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BeforeAfterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BeforeAfterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentBeforePhotoUrl = "";
        this.currentAfterPhotoUrl = "";
        initializeView(context);
    }

    public void setEventListener(EventListener eventListener2) {
        this.eventListener = eventListener2;
    }

    private void initializeView(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.before_after_view, this);
        int sizeInPx = Util.sizeInPx(getContext(), (int) (((double) SectionBaseViewModel.getSectionWidthInDpi(context)) * 0.7d));
        findViewById(R.id.before_view).getLayoutParams().height = sizeInPx;
        findViewById(R.id.after_view).getLayoutParams().height = sizeInPx;
    }

    public void setPhotos(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            int i = jSONObject.getInt("id");
            int i2 = jSONObject2.getInt("id");
            String urlForPhoto = Util.getUrlForPhoto(i);
            String urlForPhoto2 = Util.getUrlForPhoto(i2);
            if (!urlForPhoto.equals(this.currentBeforePhotoUrl)) {
                ImageView imageView = (ImageView) findViewById(R.id.before_view);
                imageView.setImageResource(17170445);
                ((RequestBuilder) Glide.with(getContext()).load(urlForPhoto).fitCenter()).into(imageView);
            }
            if (!urlForPhoto2.equals(this.currentAfterPhotoUrl)) {
                ImageView imageView2 = (ImageView) findViewById(R.id.after_view);
                imageView2.setImageResource(17170445);
                ((RequestBuilder) Glide.with(getContext()).load(urlForPhoto2).fitCenter()).into(imageView2);
            }
            int dateDifferenceInDays = (int) (((double) DateUtils.dateDifferenceInDays(DateUtils.getDateFromISOFormat(jSONObject.getString("d")), DateUtils.getDateFromISOFormat(jSONObject2.getString("d")))) / 7.0d);
            if (dateDifferenceInDays == 0) {
                dateDifferenceInDays = 1;
            }
            TextView textView = (TextView) findViewById(R.id.title_view);
            if (dateDifferenceInDays == 1) {
                textView.setText(getContext().getString(R.string.oneWeekTransformation));
                return;
            }
            textView.setText(String.format(getContext().getString(R.string.nWeeksTransformation), new Object[]{Integer.valueOf(dateDifferenceInDays)}));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
