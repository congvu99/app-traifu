package io.intercom.android.sdk.carousel;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class CarouselScreenPagerAdapter extends FragmentPagerAdapter {
    private List<CarouselScreenFragment> fragments;

    public CarouselScreenPagerAdapter(FragmentManager fragmentManager, List<CarouselScreenFragment> list) {
        super(fragmentManager);
        this.fragments = list;
    }

    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }

    public int getCount() {
        return this.fragments.size();
    }
}
