package com.trainerfu.story;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.trainerfu.utils.Util;
import java.util.List;

public abstract class SectionBaseViewModel {
    private Context context;

    public abstract List<SectionPartDefinition> getParts();

    public SectionBaseViewModel(Context context2) {
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }

    public void addSectionSeparator(List<SectionPartDefinition> list) {
        list.add(new SectionPartDefinition(SeparatorView.class, new SeparatorBinder(getContext(), 20, 17170445)));
    }

    public void addWhiteSpace(List<SectionPartDefinition> list, int i) {
        list.add(new SectionPartDefinition(SeparatorView.class, new SeparatorBinder(getContext(), i, 17170443)));
    }

    public static int getSectionWidthInDpi(Context context2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return Util.sizeInDpi(context2, displayMetrics.widthPixels) - 20;
    }

    public boolean checkIsTablet() {
        Display defaultDisplay = ((AppCompatActivity) getContext()).getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d || Util.getDeviceWidth(getContext()) > 500.0f;
    }
}
