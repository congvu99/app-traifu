package com.uploadcare.android.widget.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgsLazy;
import com.google.android.material.snackbar.Snackbar;
import com.uploadcare.android.library.api.UploadcareFile;
import com.uploadcare.android.library.exceptions.UploadcareApiException;
import com.uploadcare.android.library.exceptions.UploadcareException;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.adapter.ToolbarSpinnerAdapter;
import com.uploadcare.android.widget.controller.UploadcareWidgetResult;
import com.uploadcare.android.widget.data.Chunk;
import com.uploadcare.android.widget.databinding.UcwFragmentFilesBinding;
import com.uploadcare.android.widget.dialogs.CancelUploadListener;
import com.uploadcare.android.widget.fragment.UploadcareChunkFragment;
import com.uploadcare.android.widget.utils.SingleLiveEvent;
import com.uploadcare.android.widget.viewmodels.ProgressData;
import com.uploadcare.android.widget.viewmodels.UploadcareFilesViewModel;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001CB\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u001e\u0010\u001a\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0012\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u0016H\u0016J0\u00101\u001a\u00020\u00122\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u0001032\b\u00104\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\u00020\u00122\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103H\u0016J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016J\u001e\u0010>\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0016H\u0002J.\u0010A\u001a\u00020\u00122\u0006\u00105\u001a\u0002062\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010B\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Lcom/uploadcare/android/widget/fragment/OnFileActionsListener;", "Lcom/uploadcare/android/widget/fragment/OnAuthListener;", "Lcom/uploadcare/android/widget/dialogs/CancelUploadListener;", "()V", "args", "Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragmentArgs;", "getArgs", "()Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "Lcom/uploadcare/android/widget/databinding/UcwFragmentFilesBinding;", "viewModel", "Lcom/uploadcare/android/widget/viewmodels/UploadcareFilesViewModel;", "checkBackStack", "", "onAuthError", "onAuthSuccess", "cookie", "", "onAuthorizationNeeded", "loginLink", "onCancelUpload", "onChunkSelected", "chunks", "", "Lcom/uploadcare/android/widget/data/Chunk;", "title", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onError", "exception", "Lcom/uploadcare/android/library/exceptions/UploadcareApiException;", "onFileSelected", "fileUrl", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "position", "", "id", "", "onNothingSelected", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "openChunk", "showError", "message", "updateChunk", "updateTitle", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareFilesFragment.kt */
public final class UploadcareFilesFragment extends Fragment implements AdapterView.OnItemSelectedListener, OnFileActionsListener, OnAuthListener, CancelUploadListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String authFragmentTag = "auth";
    private static final String fragmentTag = "latest";
    private HashMap _$_findViewCache;
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(UploadcareFilesFragmentArgs.class), new UploadcareFilesFragment$$special$$inlined$navArgs$1(this));
    private UcwFragmentFilesBinding binding;
    private UploadcareFilesViewModel viewModel;

    private final UploadcareFilesFragmentArgs getArgs() {
        return (UploadcareFilesFragmentArgs) this.args$delegate.getValue();
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

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        UcwFragmentFilesBinding inflate = UcwFragmentFilesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "UcwFragmentFilesBinding.…flater, container, false)");
        this.binding = inflate;
        ViewModel viewModel2 = new ViewModelProvider(this).get(UploadcareFilesViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "get(VM::class.java)");
        this.viewModel = (UploadcareFilesViewModel) viewModel2;
        UcwFragmentFilesBinding ucwFragmentFilesBinding = this.binding;
        if (ucwFragmentFilesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ucwFragmentFilesBinding.setLifecycleOwner(getViewLifecycleOwner());
        UcwFragmentFilesBinding ucwFragmentFilesBinding2 = this.binding;
        if (ucwFragmentFilesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
        if (uploadcareFilesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ucwFragmentFilesBinding2.setViewModel(uploadcareFilesViewModel);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            UcwFragmentFilesBinding ucwFragmentFilesBinding3 = this.binding;
            if (ucwFragmentFilesBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            appCompatActivity.setSupportActionBar(ucwFragmentFilesBinding3.ucwToolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayShowTitleEnabled(false);
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayHomeAsUpEnabled(false);
            }
            Context context = getContext();
            if (context != null) {
                UcwFragmentFilesBinding ucwFragmentFilesBinding4 = this.binding;
                if (ucwFragmentFilesBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                Spinner spinner = ucwFragmentFilesBinding4.ucwSpinner;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ToolbarSpinnerAdapter toolbarSpinnerAdapter = new ToolbarSpinnerAdapter(context);
                toolbarSpinnerAdapter.updateItems(getArgs().getSocialsource().getRootChunks());
                Unit unit = Unit.INSTANCE;
                spinner.setAdapter(toolbarSpinnerAdapter);
                spinner.setOnItemSelectedListener(this);
            }
            UploadcareFilesViewModel uploadcareFilesViewModel2 = this.viewModel;
            if (uploadcareFilesViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            SingleLiveEvent<ProgressData> progressDialogCommand = uploadcareFilesViewModel2.getProgressDialogCommand();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "this.viewLifecycleOwner");
            progressDialogCommand.observe(viewLifecycleOwner, (Observer<? super ProgressData>) new UploadcareFilesFragment$onCreateView$3(this));
            UploadcareFilesViewModel uploadcareFilesViewModel3 = this.viewModel;
            if (uploadcareFilesViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            uploadcareFilesViewModel3.getUploadProgress().observe(getViewLifecycleOwner(), new UploadcareFilesFragment$onCreateView$4(this));
            UploadcareFilesViewModel uploadcareFilesViewModel4 = this.viewModel;
            if (uploadcareFilesViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            SingleLiveEvent<UploadcareApiException> closeWidgetCommand = uploadcareFilesViewModel4.getCloseWidgetCommand();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "this.viewLifecycleOwner");
            closeWidgetCommand.observe(viewLifecycleOwner2, (Observer<? super UploadcareApiException>) new UploadcareFilesFragment$onCreateView$5(this));
            UploadcareFilesViewModel uploadcareFilesViewModel5 = this.viewModel;
            if (uploadcareFilesViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            SingleLiveEvent<UploadcareFile> uploadCompleteCommand = uploadcareFilesViewModel5.getUploadCompleteCommand();
            LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "this.viewLifecycleOwner");
            uploadCompleteCommand.observe(viewLifecycleOwner3, (Observer<? super UploadcareFile>) new UploadcareFilesFragment$onCreateView$6(this));
            UploadcareFilesViewModel uploadcareFilesViewModel6 = this.viewModel;
            if (uploadcareFilesViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            SingleLiveEvent<UUID> uploadingInBackgroundCommand = uploadcareFilesViewModel6.getUploadingInBackgroundCommand();
            LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "this.viewLifecycleOwner");
            uploadingInBackgroundCommand.observe(viewLifecycleOwner4, (Observer<? super UUID>) new UploadcareFilesFragment$onCreateView$7(this));
            UploadcareFilesViewModel uploadcareFilesViewModel7 = this.viewModel;
            if (uploadcareFilesViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            uploadcareFilesViewModel7.start(getArgs().getSocialsource(), getArgs().getStore(), getArgs().getCancelable(), getArgs().getShowProgress(), getArgs().getBackgroundUpload());
            getChildFragmentManager().addOnBackStackChangedListener(new UploadcareFilesFragment$onCreateView$8(this));
            if (bundle == null) {
                UploadcareChunkFragment.Companion companion = UploadcareChunkFragment.Companion;
                UcwFragmentFilesBinding ucwFragmentFilesBinding5 = this.binding;
                if (ucwFragmentFilesBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                Spinner spinner2 = ucwFragmentFilesBinding5.ucwSpinner;
                Intrinsics.checkNotNullExpressionValue(spinner2, "binding.ucwSpinner");
                getChildFragmentManager().beginTransaction().add(R.id.chunkHolder, (Fragment) UploadcareChunkFragment.Companion.newInstance$default(companion, spinner2.getSelectedItemPosition(), getArgs().getSocialsource(), getArgs().getSocialsource().getRootChunks(), (String) null, true, 8, (Object) null), fragmentTag).commit();
            }
            UcwFragmentFilesBinding ucwFragmentFilesBinding6 = this.binding;
            if (ucwFragmentFilesBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            View root = ucwFragmentFilesBinding6.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return root;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.ucw_social_actions, menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            checkBackStack();
            return true;
        } else if (itemId != R.id.ucw_action_sign_out) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
            if (uploadcareFilesViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            uploadcareFilesViewModel.signOut();
            return true;
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        updateChunk$default(this, i, (List) null, (String) null, 6, (Object) null);
    }

    public void onError(UploadcareApiException uploadcareApiException) {
        Intrinsics.checkNotNullParameter(uploadcareApiException, "exception");
        String message = uploadcareApiException.getMessage();
        if (message != null) {
            showError(message);
        }
    }

    public void onFileSelected(String str) {
        Intrinsics.checkNotNullParameter(str, "fileUrl");
        UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
        if (uploadcareFilesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareFilesViewModel.selectFile(str);
    }

    public void onAuthorizationNeeded(String str) {
        Intrinsics.checkNotNullParameter(str, "loginLink");
        getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.ucw_fragment_slide_left_enter, 0, 0, R.anim.ucw_fragment_slide_right_exit).replace(R.id.chunkHolder, (Fragment) UploadcareAuthFragment.Companion.newInstance(str), authFragmentTag).commit();
        updateTitle(getString(R.string.ucw_authorization_fragment_title));
    }

    public void onChunkSelected(List<Chunk> list, String str) {
        Intrinsics.checkNotNullParameter(list, "chunks");
        Intrinsics.checkNotNullParameter(str, "title");
        openChunk(list, str);
    }

    public void onAuthSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "cookie");
        UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
        if (uploadcareFilesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareFilesViewModel.saveCookie(str);
        UploadcareChunkFragment.Companion companion = UploadcareChunkFragment.Companion;
        UcwFragmentFilesBinding ucwFragmentFilesBinding = this.binding;
        if (ucwFragmentFilesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Spinner spinner = ucwFragmentFilesBinding.ucwSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner, "binding.ucwSpinner");
        getChildFragmentManager().beginTransaction().replace(R.id.chunkHolder, (Fragment) UploadcareChunkFragment.Companion.newInstance$default(companion, spinner.getSelectedItemPosition(), getArgs().getSocialsource(), getArgs().getSocialsource().getRootChunks(), (String) null, true, 8, (Object) null), fragmentTag).commit();
        updateTitle((String) null);
    }

    public void onAuthError() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("result", new UploadcareWidgetResult((UploadcareFile) null, (UUID) null, new UploadcareException("Auth error"), 3, (DefaultConstructorMarker) null));
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    public void onCancelUpload() {
        UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
        if (uploadcareFilesViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        uploadcareFilesViewModel.canlcelUpload();
    }

    /* access modifiers changed from: private */
    public final void updateTitle(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
            UploadcareFilesViewModel uploadcareFilesViewModel = this.viewModel;
            if (uploadcareFilesViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            uploadcareFilesViewModel.isRoot().setValue(Boolean.valueOf(str == null));
            if (str != null) {
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setTitle((CharSequence) str);
                    supportActionBar.setDisplayShowTitleEnabled(true);
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                } else {
                    supportActionBar = null;
                }
                if (supportActionBar != null) {
                    return;
                }
            }
            ActionBar supportActionBar2 = appCompatActivity.getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setDisplayShowTitleEnabled(false);
                supportActionBar2.setDisplayHomeAsUpEnabled(false);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
    }

    static /* synthetic */ void updateChunk$default(UploadcareFilesFragment uploadcareFilesFragment, int i, List list, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        if ((i2 & 4) != 0) {
            str = null;
        }
        uploadcareFilesFragment.updateChunk(i, list, str);
    }

    private final void updateChunk(int i, List<Chunk> list, String str) {
        if (list == null) {
            UploadcareChunkFragment uploadcareChunkFragment = (UploadcareChunkFragment) getChildFragmentManager().findFragmentByTag(fragmentTag);
            if (uploadcareChunkFragment != null && uploadcareChunkFragment.isAdded()) {
                uploadcareChunkFragment.changeChunk(i);
                return;
            }
            return;
        }
        getChildFragmentManager().beginTransaction().setCustomAnimations(R.anim.ucw_fragment_slide_left_enter, 0, 0, R.anim.ucw_fragment_slide_right_exit).add(R.id.chunkHolder, (Fragment) UploadcareChunkFragment.Companion.newInstance$default(UploadcareChunkFragment.Companion, i, getArgs().getSocialsource(), list, str, false, 16, (Object) null), fragmentTag).addToBackStack((String) null).commit();
    }

    private final void openChunk(List<Chunk> list, String str) {
        UcwFragmentFilesBinding ucwFragmentFilesBinding = this.binding;
        if (ucwFragmentFilesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Spinner spinner = ucwFragmentFilesBinding.ucwSpinner;
        Intrinsics.checkNotNullExpressionValue(spinner, "binding.ucwSpinner");
        updateChunk(spinner.getSelectedItemPosition(), list, str);
    }

    private final void showError(String str) {
        UcwFragmentFilesBinding ucwFragmentFilesBinding = this.binding;
        if (ucwFragmentFilesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Snackbar.make(ucwFragmentFilesBinding.getRoot(), (CharSequence) str, 0).show();
    }

    private final void checkBackStack() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.getBackStackEntryCount() > 0) {
            getChildFragmentManager().popBackStack();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/uploadcare/android/widget/fragment/UploadcareFilesFragment$Companion;", "", "()V", "authFragmentTag", "", "fragmentTag", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareFilesFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
