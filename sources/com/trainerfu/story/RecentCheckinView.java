package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.trainerfu.android.R;
import com.trainerfu.utils.DateUtils;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONObject;

public class RecentCheckinView extends SectionPartView {
    public RecentCheckinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecentCheckinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecentCheckinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    public void initializeViews(Context context) {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.recent_checkins_view, this);
    }

    public void setRecentCheckin(JSONObject jSONObject, int i) {
        try {
            String string = jSONObject.getString("dc");
            String string2 = jSONObject.getString("cd");
            TextView textView = (TextView) findViewById(R.id.checkin_date);
            TextView textView2 = (TextView) findViewById(R.id.checkin_value);
            TextView textView3 = (TextView) findViewById(R.id.border_top);
            if (i == 0) {
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
            textView.setText(DateUtils.getDisplayDate(getContext(), DateUtils.getDateFromISOFormat(string2)));
            if (string.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                textView2.setText("YES");
            }
            if (string.equals("false")) {
                textView2.setText("NO");
            }
            if (string.equals(JsonLexerKt.NULL)) {
                textView2.setText("DIDN'T CHECKIN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
