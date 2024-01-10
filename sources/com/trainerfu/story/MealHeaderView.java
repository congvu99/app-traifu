package com.trainerfu.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.trainerfu.android.R;
import org.json.JSONException;
import org.json.JSONObject;

public class MealHeaderView extends SectionPartView {
    public MealHeaderView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MealHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MealHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.meal_header_view, this);
    }

    public void setMealDetails(JSONObject jSONObject) {
        try {
            TextView textView = (TextView) findViewById(R.id.servings_view);
            TextView textView2 = (TextView) findViewById(R.id.carbs_view);
            TextView textView3 = (TextView) findViewById(R.id.protein_view);
            TextView textView4 = (TextView) findViewById(R.id.fats_view);
            TextView textView5 = (TextView) findViewById(R.id.calories_view);
            if (jSONObject != null) {
                textView.setText(String.format("%s", new Object[]{jSONObject.getString("se")}));
                textView2.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(jSONObject.getInt("ca"))}));
                textView3.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(jSONObject.getInt("pr"))}));
                textView4.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(jSONObject.getInt("fa"))}));
                textView5.setText(String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(jSONObject.getInt("cl"))}));
                return;
            }
            textView.setText(getResources().getString(R.string.Servings));
            textView2.setText(getResources().getString(R.string.Carbs));
            textView3.setText(getResources().getString(R.string.Protein));
            textView4.setText(getResources().getString(R.string.Fats));
            textView5.setText(getResources().getString(R.string.Calories));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
