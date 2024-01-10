package com.afollestad.materialdialogs.folderselector;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FolderChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {
    private static final String DEFAULT_TAG = "[MD_FOLDER_SELECTOR]";
    private boolean canGoUp = true;
    /* access modifiers changed from: private */
    public FolderCallback mCallback;
    private File[] parentContents;
    /* access modifiers changed from: private */
    public File parentFolder;

    public interface FolderCallback {
        void onFolderSelection(FolderChooserDialog folderChooserDialog, File file);
    }

    /* access modifiers changed from: package-private */
    public String[] getContentsArray() {
        File[] fileArr = this.parentContents;
        if (fileArr == null) {
            return new String[0];
        }
        int length = fileArr.length;
        boolean z = this.canGoUp;
        String[] strArr = new String[(length + (z ? 1 : 0))];
        if (z) {
            strArr[0] = "...";
        }
        for (int i = 0; i < this.parentContents.length; i++) {
            strArr[this.canGoUp ? i + 1 : i] = this.parentContents[i].getName();
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    public File[] listFiles() {
        File[] listFiles = this.parentFolder.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new FolderSorter());
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return new MaterialDialog.Builder(getActivity()).title(R.string.md_error_label).content(R.string.md_storage_perm_error).positiveText(17039370).build();
        }
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            throw new IllegalStateException("You must create a FolderChooserDialog using the Builder.");
        }
        if (!getArguments().containsKey("current_path")) {
            getArguments().putString("current_path", getBuilder().mInitialPath);
        }
        this.parentFolder = new File(getArguments().getString("current_path"));
        this.parentContents = listFiles();
        return new MaterialDialog.Builder(getActivity()).title((CharSequence) this.parentFolder.getAbsolutePath()).items((CharSequence[]) getContentsArray()).itemsCallback(this).onPositive(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
                FolderCallback access$200 = FolderChooserDialog.this.mCallback;
                FolderChooserDialog folderChooserDialog = FolderChooserDialog.this;
                access$200.onFolderSelection(folderChooserDialog, folderChooserDialog.parentFolder);
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
            }
        }).autoDismiss(false).positiveText(getBuilder().mChooseButton).negativeText(getBuilder().mCancelButton).build();
    }

    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
        boolean z = true;
        if (!this.canGoUp || i != 0) {
            File[] fileArr = this.parentContents;
            if (this.canGoUp) {
                i--;
            }
            File file = fileArr[i];
            this.parentFolder = file;
            this.canGoUp = true;
            if (file.getAbsolutePath().equals("/storage/emulated")) {
                this.parentFolder = Environment.getExternalStorageDirectory();
            }
        } else {
            File parentFile = this.parentFolder.getParentFile();
            this.parentFolder = parentFile;
            if (parentFile.getAbsolutePath().equals("/storage/emulated")) {
                this.parentFolder = this.parentFolder.getParentFile();
            }
            if (this.parentFolder.getParent() == null) {
                z = false;
            }
            this.canGoUp = z;
        }
        this.parentContents = listFiles();
        MaterialDialog materialDialog2 = (MaterialDialog) getDialog();
        materialDialog2.setTitle((CharSequence) this.parentFolder.getAbsolutePath());
        getArguments().putString("current_path", this.parentFolder.getAbsolutePath());
        materialDialog2.setItems(getContentsArray());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mCallback = (FolderCallback) activity;
    }

    public void show(FragmentActivity fragmentActivity) {
        String str = getBuilder().mTag;
        Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
            fragmentActivity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
        }
        show(fragmentActivity.getSupportFragmentManager(), str);
    }

    public static class Builder implements Serializable {
        protected int mCancelButton = 17039360;
        protected int mChooseButton = R.string.md_choose_label;
        protected final transient AppCompatActivity mContext;
        protected String mInitialPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        protected String mTag;

        public <ActivityType extends AppCompatActivity & FolderCallback> Builder(ActivityType activitytype) {
            this.mContext = activitytype;
        }

        public Builder chooseButton(int i) {
            this.mChooseButton = i;
            return this;
        }

        public Builder cancelButton(int i) {
            this.mCancelButton = i;
            return this;
        }

        public Builder initialPath(String str) {
            if (str == null) {
                str = File.separator;
            }
            this.mInitialPath = str;
            return this;
        }

        public Builder tag(String str) {
            if (str == null) {
                str = FolderChooserDialog.DEFAULT_TAG;
            }
            this.mTag = str;
            return this;
        }

        public FolderChooserDialog build() {
            FolderChooserDialog folderChooserDialog = new FolderChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            folderChooserDialog.setArguments(bundle);
            return folderChooserDialog;
        }

        public FolderChooserDialog show() {
            FolderChooserDialog build = build();
            build.show(this.mContext);
            return build;
        }
    }

    private Builder getBuilder() {
        return (Builder) getArguments().getSerializable("builder");
    }

    private static class FolderSorter implements Comparator<File> {
        private FolderSorter() {
        }

        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }
}
