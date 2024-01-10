package com.uploadcare.android.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.compose.DialogNavigator;
import com.uploadcare.android.widget.databinding.UcwActivityUploadcareBindingImpl;
import com.uploadcare.android.widget.databinding.UcwDialogNetworkItemBindingImpl;
import com.uploadcare.android.widget.databinding.UcwDialogProgressHorizontalBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFileItemBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFileLinearItemBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFragmentAuthBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFragmentChunkBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFragmentFilesBindingImpl;
import com.uploadcare.android.widget.databinding.UcwFragmentUploadcareBindingImpl;
import com.uploadcare.android.widget.databinding.UcwSpinnerRowBindingImpl;
import com.uploadcare.android.widget.databinding.UcwToolbarSpinnerItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_UCWACTIVITYUPLOADCARE = 1;
    private static final int LAYOUT_UCWDIALOGNETWORKITEM = 2;
    private static final int LAYOUT_UCWDIALOGPROGRESSHORIZONTAL = 3;
    private static final int LAYOUT_UCWFILEITEM = 4;
    private static final int LAYOUT_UCWFILELINEARITEM = 5;
    private static final int LAYOUT_UCWFRAGMENTAUTH = 6;
    private static final int LAYOUT_UCWFRAGMENTCHUNK = 7;
    private static final int LAYOUT_UCWFRAGMENTFILES = 8;
    private static final int LAYOUT_UCWFRAGMENTUPLOADCARE = 9;
    private static final int LAYOUT_UCWSPINNERROW = 10;
    private static final int LAYOUT_UCWTOOLBARSPINNERITEM = 11;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(11);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.ucw_activity_uploadcare, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_dialog_network_item, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_dialog_progress_horizontal, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_file_item, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_file_linear_item, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_fragment_auth, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_fragment_chunk, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_fragment_files, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_fragment_uploadcare, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_spinner_row, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.ucw_toolbar_spinner_item, 11);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/ucw_activity_uploadcare_0".equals(tag)) {
                        return new UcwActivityUploadcareBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_activity_uploadcare is invalid. Received: " + tag);
                case 2:
                    if ("layout/ucw_dialog_network_item_0".equals(tag)) {
                        return new UcwDialogNetworkItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_dialog_network_item is invalid. Received: " + tag);
                case 3:
                    if ("layout/ucw_dialog_progress_horizontal_0".equals(tag)) {
                        return new UcwDialogProgressHorizontalBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_dialog_progress_horizontal is invalid. Received: " + tag);
                case 4:
                    if ("layout/ucw_file_item_0".equals(tag)) {
                        return new UcwFileItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_file_item is invalid. Received: " + tag);
                case 5:
                    if ("layout/ucw_file_linear_item_0".equals(tag)) {
                        return new UcwFileLinearItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_file_linear_item is invalid. Received: " + tag);
                case 6:
                    if ("layout/ucw_fragment_auth_0".equals(tag)) {
                        return new UcwFragmentAuthBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_fragment_auth is invalid. Received: " + tag);
                case 7:
                    if ("layout/ucw_fragment_chunk_0".equals(tag)) {
                        return new UcwFragmentChunkBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_fragment_chunk is invalid. Received: " + tag);
                case 8:
                    if ("layout/ucw_fragment_files_0".equals(tag)) {
                        return new UcwFragmentFilesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_fragment_files is invalid. Received: " + tag);
                case 9:
                    if ("layout/ucw_fragment_uploadcare_0".equals(tag)) {
                        return new UcwFragmentUploadcareBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_fragment_uploadcare is invalid. Received: " + tag);
                case 10:
                    if ("layout/ucw_spinner_row_0".equals(tag)) {
                        return new UcwSpinnerRowBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_spinner_row is invalid. Received: " + tag);
                case 11:
                    if ("layout/ucw_toolbar_spinner_item_0".equals(tag)) {
                        return new UcwToolbarSpinnerItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for ucw_toolbar_spinner_item is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
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
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
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
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(11);
            sKeys = hashMap;
            hashMap.put("layout/ucw_activity_uploadcare_0", Integer.valueOf(R.layout.ucw_activity_uploadcare));
            sKeys.put("layout/ucw_dialog_network_item_0", Integer.valueOf(R.layout.ucw_dialog_network_item));
            sKeys.put("layout/ucw_dialog_progress_horizontal_0", Integer.valueOf(R.layout.ucw_dialog_progress_horizontal));
            sKeys.put("layout/ucw_file_item_0", Integer.valueOf(R.layout.ucw_file_item));
            sKeys.put("layout/ucw_file_linear_item_0", Integer.valueOf(R.layout.ucw_file_linear_item));
            sKeys.put("layout/ucw_fragment_auth_0", Integer.valueOf(R.layout.ucw_fragment_auth));
            sKeys.put("layout/ucw_fragment_chunk_0", Integer.valueOf(R.layout.ucw_fragment_chunk));
            sKeys.put("layout/ucw_fragment_files_0", Integer.valueOf(R.layout.ucw_fragment_files));
            sKeys.put("layout/ucw_fragment_uploadcare_0", Integer.valueOf(R.layout.ucw_fragment_uploadcare));
            sKeys.put("layout/ucw_spinner_row_0", Integer.valueOf(R.layout.ucw_spinner_row));
            sKeys.put("layout/ucw_toolbar_spinner_item_0", Integer.valueOf(R.layout.ucw_toolbar_spinner_item));
        }
    }
}
