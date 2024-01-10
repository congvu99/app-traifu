package com.intercom.composer.pager;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.intercom.composer.input.Input;
import java.util.List;

public class ComposerPagerAdapter extends FragmentPagerAdapter {
    private final List<? extends Input> inputs;

    public ComposerPagerAdapter(FragmentManager fragmentManager, List<? extends Input> list) {
        super(fragmentManager);
        this.inputs = list;
    }

    public int getCount() {
        return this.inputs.size();
    }

    public Fragment getItem(int i) {
        return ((Input) this.inputs.get(i)).createFragment();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.instantiateItem(viewGroup, i);
        ((Input) this.inputs.get(i)).setFragmentTag(fragment.getTag());
        return fragment;
    }
}
