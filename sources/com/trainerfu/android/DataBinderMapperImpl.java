package com.trainerfu.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.compose.DialogNavigator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.uploadcare.android.widget.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(8);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sKeys.put(1, "adapter");
            sKeys.put(2, DialogNavigator.NAME);
            sKeys.put(3, "handler");
            sKeys.put(4, "socialSource");
            sKeys.put(5, "text");
            sKeys.put(6, "thing");
            sKeys.put(7, "viewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
    }
}