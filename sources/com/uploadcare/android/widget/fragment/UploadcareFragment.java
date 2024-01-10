package com.uploadcare.android.widget.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.anggrayudi.storage.file.MimeType;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.databinding.UcwFragmentUploadcareBinding;
import com.uploadcare.android.widget.dialogs.CancelUploadListener;
import com.uploadcare.android.widget.dialogs.SocialSourcesListener;
import com.uploadcare.android.widget.utils.SingleLiveEvent;
import com.uploadcare.android.widget.viewmodels.MediaType;
import com.uploadcare.android.widget.viewmodels.ProgressData;
import com.uploadcare.android.widget.viewmodels.SocialData;
import com.uploadcare.android.widget.viewmodels.UploadcareViewModel;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/uploadcare/android/widget/dialogs/SocialSourcesListener;", "Lcom/uploadcare/android/widget/dialogs/CancelUploadListener;", "()V", "binding", "Lcom/uploadcare/android/widget/databinding/UcwFragmentUploadcareBinding;", "viewModel", "Lcom/uploadcare/android/widget/viewmodels/UploadcareViewModel;", "getTypeForFileChooser", "", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "launchCamera", "", "uri", "Landroid/net/Uri;", "mediaType", "Lcom/uploadcare/android/widget/viewmodels/MediaType;", "launchFilePicker", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancelUpload", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "onSelectSourceCanceled", "onSocialSourceSelected", "socialSource", "Lcom/uploadcare/android/widget/data/SocialSource;", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFragment.kt */
public final class UploadcareFragment extends Fragment implements SocialSourcesListener, CancelUploadListener {
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    private static final int CHOOSE_FILE_ACTIVITY_REQUEST_CODE = 300;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private UcwFragmentUploadcareBinding binding;
    private UploadcareViewModel viewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MediaType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaType.IMAGE.ordinal()] = 1;
            int[] iArr2 = new int[FileType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[FileType.image.ordinal()] = 1;
            $EnumSwitchMapping$1[FileType.video.ordinal()] = 2;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UcwFragmentUploadcareBinding inflate = UcwFragmentUploadcareBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UcwFragmentUploadcareBin…flater, container, false)");
        this.binding = inflate;
        ViewModel viewModel2 = new ViewModelProvider(this).get(UploadcareViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "get(VM::class.java)");
        UploadcareViewModel uploadcareViewModel = (UploadcareViewModel) viewModel2;
        this.viewModel = uploadcareViewModel;
        if (uploadcareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<ProgressData> progressDialogCommand = uploadcareViewModel.getProgressDialogCommand();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "this.viewLifecycleOwner");
        progressDialogCommand.observe(viewLifecycleOwner, (Observer<? super ProgressData>) new UploadcareFragment$onCreateView$1(this));
        UploadcareViewModel uploadcareViewModel2 = this.viewModel;
        if (uploadcareViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareViewModel2.getUploadProgress().observe(getViewLifecycleOwner(), new UploadcareFragment$onCreateView$2(this));
        UploadcareViewModel uploadcareViewModel3 = this.viewModel;
        if (uploadcareViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Pair<List<SocialSource>, FileType>> showSocialSourcesCommand = uploadcareViewModel3.getShowSocialSourcesCommand();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "this.viewLifecycleOwner");
        showSocialSourcesCommand.observe(viewLifecycleOwner2, (Observer<? super Pair<List<SocialSource>, FileType>>) new UploadcareFragment$onCreateView$3(this));
        UploadcareViewModel uploadcareViewModel4 = this.viewModel;
        if (uploadcareViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<SocialData> launchSocialSourceCommand = uploadcareViewModel4.getLaunchSocialSourceCommand();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "this.viewLifecycleOwner");
        launchSocialSourceCommand.observe(viewLifecycleOwner3, (Observer<? super SocialData>) new UploadcareFragment$onCreateView$4(this));
        UploadcareViewModel uploadcareViewModel5 = this.viewModel;
        if (uploadcareViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<Pair<Uri, MediaType>> launchCamera = uploadcareViewModel5.getLaunchCamera();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "this.viewLifecycleOwner");
        launchCamera.observe(viewLifecycleOwner4, (Observer<? super Pair<Uri, MediaType>>) new UploadcareFragment$onCreateView$5(this));
        UploadcareViewModel uploadcareViewModel6 = this.viewModel;
        if (uploadcareViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<FileType> launchFilePicker = uploadcareViewModel6.getLaunchFilePicker();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "this.viewLifecycleOwner");
        launchFilePicker.observe(viewLifecycleOwner5, (Observer<? super FileType>) new UploadcareFragment$onCreateView$6(this));
        UploadcareViewModel uploadcareViewModel7 = this.viewModel;
        if (uploadcareViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<UploadcareApiException> closeWidgetCommand = uploadcareViewModel7.getCloseWidgetCommand();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "this.viewLifecycleOwner");
        closeWidgetCommand.observe(viewLifecycleOwner6, (Observer<? super UploadcareApiException>) new UploadcareFragment$onCreateView$7(this));
        UploadcareViewModel uploadcareViewModel8 = this.viewModel;
        if (uploadcareViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<UploadcareFile> uploadCompleteCommand = uploadcareViewModel8.getUploadCompleteCommand();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "this.viewLifecycleOwner");
        uploadCompleteCommand.observe(viewLifecycleOwner7, (Observer<? super UploadcareFile>) new UploadcareFragment$onCreateView$8(this));
        UploadcareViewModel uploadcareViewModel9 = this.viewModel;
        if (uploadcareViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SingleLiveEvent<UUID> uploadingInBackgroundCommand = uploadcareViewModel9.getUploadingInBackgroundCommand();
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "this.viewLifecycleOwner");
        uploadingInBackgroundCommand.observe(viewLifecycleOwner8, (Observer<? super UUID>) new UploadcareFragment$onCreateView$9(this));
        if (bundle != null) {
            UploadcareViewModel uploadcareViewModel10 = this.viewModel;
            if (uploadcareViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            uploadcareViewModel10.onRestoreInstanceState(bundle);
        }
        FragmentActivity activity = getActivity();
        if (!(activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null)) {
            UploadcareViewModel uploadcareViewModel11 = this.viewModel;
            if (uploadcareViewModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            Intrinsics.checkNotNullExpressionValue(extras, "it");
            uploadcareViewModel11.start(extras);
        }
        UcwFragmentUploadcareBinding ucwFragmentUploadcareBinding = this.binding;
        if (ucwFragmentUploadcareBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = ucwFragmentUploadcareBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        UploadcareViewModel uploadcareViewModel = this.viewModel;
        if (uploadcareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareViewModel.onSaveInstanceState(bundle);
    }

    public void onSocialSourceSelected(SocialSource socialSource) {
        Intrinsics.checkNotNullParameter(socialSource, "socialSource");
        UploadcareViewModel uploadcareViewModel = this.viewModel;
        if (uploadcareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareViewModel.sourceSelected(socialSource);
    }

    public void onSelectSourceCanceled() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void onCancelUpload() {
        UploadcareViewModel uploadcareViewModel = this.viewModel;
        if (uploadcareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareViewModel.canlcelUpload();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context context;
        ContentResolver contentResolver;
        if (i2 != -1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            super.onActivityResult(i, i2, intent);
            return;
        }
        Uri uri = null;
        if (i == 100 || i == 200) {
            UploadcareViewModel uploadcareViewModel = this.viewModel;
            if (uploadcareViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            UploadcareViewModel.uploadFile$default(uploadcareViewModel, (Uri) null, 1, (Object) null);
        } else if (i == 300) {
            if (intent != null) {
                uri = intent.getData();
            }
            if (!(uri == null || (context = getContext()) == null || (contentResolver = context.getContentResolver()) == null)) {
                contentResolver.takePersistableUriPermission(uri, 3);
            }
            if (uri != null) {
                UploadcareViewModel uploadcareViewModel2 = this.viewModel;
                if (uploadcareViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                uploadcareViewModel2.uploadFile(uri);
                return;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void launchCamera(Uri uri, MediaType mediaType) {
        if (WhenMappings.$EnumSwitchMapping$0[mediaType.ordinal()] != 1) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            intent.putExtra("output", uri);
            intent.putExtra("android.intent.extra.videoQuality", 1);
            startActivityForResult(intent, 200);
            return;
        }
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        intent2.putExtra("output", uri);
        startActivityForResult(intent2, 100);
    }

    /* access modifiers changed from: private */
    public final void launchFilePicker(FileType fileType) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType(getTypeForFileChooser(fileType));
        intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
        startActivityForResult(Intent.createChooser(intent, getString(R.string.ucw_choose_file)), 300);
    }

    private final String getTypeForFileChooser(FileType fileType) {
        int i = WhenMappings.$EnumSwitchMapping$1[fileType.ordinal()];
        if (i != 1) {
            return i != 2 ? MimeType.UNKNOWN : MimeType.VIDEO;
        }
        return MimeType.IMAGE;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFragment$Companion;", "", "()V", "CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE", "", "CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE", "CHOOSE_FILE_ACTIVITY_REQUEST_CODE", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
