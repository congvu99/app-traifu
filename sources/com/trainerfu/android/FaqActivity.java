package com.trainerfu.android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.trainerfu.utils.Tuple;
import java.util.ArrayList;

public class FaqActivity extends BaseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.faq_view);
        ((ListView) findViewById(R.id.faq_list)).setAdapter(new FaqAdapter(this, getFaq()));
    }

    private ArrayList<Tuple<String, String>> getFaq() {
        ArrayList<Tuple<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Tuple(getString(R.string.upgradeQ1), getString(R.string.upgradeA1)));
        arrayList.add(new Tuple(getString(R.string.upgradeQ2), getString(R.string.upgradeA2)));
        arrayList.add(new Tuple(getString(R.string.upgradeQ3), getString(R.string.upgradeA3)));
        return arrayList;
    }

    public class FaqAdapter extends ArrayAdapter<Tuple<String, String>> {
        public FaqAdapter(Context context, ArrayList<Tuple<String, String>> arrayList) {
            super(context, 0, arrayList);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Tuple tuple = (Tuple) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.faq_row_view, viewGroup, false);
            }
            ((TextView) view.findViewById(R.id.questionTV)).setText((CharSequence) tuple.x);
            ((TextView) view.findViewById(R.id.answerTV)).setText((CharSequence) tuple.y);
            return view;
        }
    }
}
