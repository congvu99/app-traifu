package com.afollestad.materialdialogs.folderselector;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.MimeTypeMap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.webkit.ProxyConfig;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.anggrayudi.storage.file.MimeType;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {
    private static final String DEFAULT_TAG = "[MD_FILE_SELECTOR]";
    private boolean canGoUp = true;
    private FileCallback mCallback;
    private File[] parentContents;
    private File parentFolder;

    public interface FileCallback {
        void onFileSelection(FileChooserDialog fileChooserDialog, File file);
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
    public File[] listFiles(String str) {
        File[] listFiles = this.parentFolder.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            } else if (fileIsMimeType(file, str, singleton)) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new FileSorter());
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* access modifiers changed from: package-private */
    public boolean fileIsMimeType(File file, String str, MimeTypeMap mimeTypeMap) {
        String mimeTypeFromExtension;
        int lastIndexOf;
        if (str == null || str.equals(MimeType.UNKNOWN)) {
            return true;
        }
        String uri = file.toURI().toString();
        int lastIndexOf2 = uri.lastIndexOf(46);
        if (lastIndexOf2 == -1 || (mimeTypeFromExtension = mimeTypeMap.getMimeTypeFromExtension(uri.substring(lastIndexOf2 + 1))) == null) {
            return false;
        }
        if (mimeTypeFromExtension.equals(str)) {
            return true;
        }
        int lastIndexOf3 = str.lastIndexOf(47);
        if (lastIndexOf3 == -1) {
            return false;
        }
        String substring = str.substring(0, lastIndexOf3);
        if (str.substring(lastIndexOf3 + 1).equals(ProxyConfig.MATCH_ALL_SCHEMES) && (lastIndexOf = mimeTypeFromExtension.lastIndexOf(47)) != -1 && mimeTypeFromExtension.substring(0, lastIndexOf).equals(substring)) {
            return true;
        }
        return false;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return new MaterialDialog.Builder(getActivity()).title(R.string.md_error_label).content(R.string.md_storage_perm_error).positiveText(17039370).build();
        }
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            throw new IllegalStateException("You must create a FileChooserDialog using the Builder.");
        }
        if (!getArguments().containsKey("current_path")) {
            getArguments().putString("current_path", getBuilder().mInitialPath);
        }
        this.parentFolder = new File(getArguments().getString("current_path"));
        this.parentContents = listFiles(getBuilder().mMimeType);
        return new MaterialDialog.Builder(getActivity()).title((CharSequence) this.parentFolder.getAbsolutePath()).items((CharSequence[]) getContentsArray()).itemsCallback(this).onNegative(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                materialDialog.dismiss();
            }
        }).autoDismiss(false).negativeText(getBuilder().mCancelButton).positiveText(getBuilder().mChooseButton).build();
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
        if (this.parentFolder.isFile()) {
            this.mCallback.onFileSelection(this, this.parentFolder);
            dismiss();
            return;
        }
        this.parentContents = listFiles(getBuilder().mMimeType);
        MaterialDialog materialDialog2 = (MaterialDialog) getDialog();
        materialDialog2.setTitle((CharSequence) this.parentFolder.getAbsolutePath());
        getArguments().putString("current_path", this.parentFolder.getAbsolutePath());
        materialDialog2.setItems(getContentsArray());
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mCallback = (FileCallback) activity;
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
        protected String mMimeType = null;
        protected String mTag;

        public <ActivityType extends AppCompatActivity & FileCallback> Builder(ActivityType activitytype) {
            this.mContext = activitytype;
        }

        public Builder cancelButton(int i) {
            this.mCancelButton = i;
            return this;
        }

        public Builder chooseButton(int i) {
            this.mChooseButton = i;
            return this;
        }

        public Builder initialPath(String str) {
            if (str == null) {
                str = File.separator;
            }
            this.mInitialPath = str;
            return this;
        }

        public Builder mimeType(String str) {
            this.mMimeType = str;
            return this;
        }

        public Builder tag(String str) {
            if (str == null) {
                str = FileChooserDialog.DEFAULT_TAG;
            }
            this.mTag = str;
            return this;
        }

        public FileChooserDialog build() {
            FileChooserDialog fileChooserDialog = new FileChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            fileChooserDialog.setArguments(bundle);
            return fileChooserDialog;
        }

        public FileChooserDialog show() {
            FileChooserDialog build = build();
            build.show(this.mContext);
            return build;
        }
    }

    public String getInitialPath() {
        return getBuilder().mInitialPath;
    }

    private Builder getBuilder() {
        return (Builder) getArguments().getSerializable("builder");
    }

    private static class FileSorter implements Comparator<File> {
        private FileSorter() {
        }

        public int compare(File file, File file2) {
            if (file.isDirectory() && !file2.isDirectory()) {
                return -1;
            }
            if (file.isDirectory() || !file2.isDirectory()) {
                return file.getName().compareTo(file2.getName());
            }
            return 1;
        }
    }
}
