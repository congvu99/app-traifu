package com.intercom.input.gallery;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.composer.ImageLoader;
import com.intercom.composer.input.InputFragment;
import com.intercom.input.gallery.GalleryInputDataSource;
import com.intercom.input.gallery.adapter.EndlessRecyclerScrollListener;
import com.intercom.input.gallery.adapter.EndlessScrollListener;
import com.intercom.input.gallery.adapter.GalleryRecyclerViewAdapter;
import com.intercom.input.gallery.adapter.OnImageClickListener;
import java.util.ArrayList;
import java.util.List;

public abstract class GalleryInputFragment extends InputFragment implements GalleryInputScreen, OnImageClickListener, EndlessScrollListener {
    private static final String ARG_EXPANDED = "expanded";
    public static final int GALLERY_FULL_SCREEN_REQUEST_CODE = 14;
    FrameLayout contentLayout;
    final GalleryInputDataSource.Listener dataListener = new GalleryInputDataSource.Listener() {
        public void onSuccess(List<GalleryImage> list) {
            GalleryInputFragment.this.galleryImages.clear();
            GalleryInputFragment.this.galleryImages.addAll(list);
            GalleryInputFragment.this.endlessRecyclerScrollListener.setMaxCount(GalleryInputFragment.this.dataSource.getCount());
            GalleryInputFragment.this.recyclerAdapter.notifyDataSetChanged();
            if (GalleryInputFragment.this.isAdded()) {
                GalleryInputFragment.this.showEmptyOrPermissionScreen(0);
            }
        }

        public void onError() {
            if (GalleryInputFragment.this.isAdded()) {
                GalleryInputFragment.this.showErrorScreen();
            }
        }
    };
    GalleryInputDataSource dataSource;
    EmptyView emptyLayout;
    EndlessRecyclerScrollListener endlessRecyclerScrollListener;
    boolean expanded;
    private final View.OnClickListener expanderClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            if (GalleryInputFragment.this.galleryInputExpandedListener != null) {
                GalleryInputFragment.this.galleryInputExpandedListener.onInputExpanded();
            }
            GalleryInputFragment.this.startActivityForResult(GalleryInputFullScreenActivity.createIntent(GalleryInputFragment.this.getActivity(), GalleryInputFragment.this.getClass(), GalleryInputFragment.this.getArguments()), 14, ActivityOptionsCompat.makeCustomAnimation(GalleryInputFragment.this.getActivity(), R.anim.intercom_composer_slide_up, R.anim.intercom_composer_stay).toBundle());
        }
    };
    final List<GalleryImage> galleryImages = new ArrayList();
    GalleryInputExpandedListener galleryInputExpandedListener;
    GalleryOutputListener galleryOutputListener;
    private ImageLoader imageLoader;
    Injector injector;
    LinearLayoutManager layoutManager;
    GalleryRecyclerViewAdapter recyclerAdapter;
    RecyclerView recyclerView;

    public interface Injector {
        GalleryInputDataSource getDataSource(GalleryInputFragment galleryInputFragment);

        String getEmptyViewSubtitle(Resources resources);

        String getEmptyViewTitle(Resources resources);

        String getErrorViewSubtitle(Resources resources);

        String getErrorViewTitle(Resources resources);

        View getExpanderButton(ViewGroup viewGroup);

        ImageLoader getImageLoader(GalleryInputFragment galleryInputFragment);

        Class<? extends GalleryLightBoxFragment> getLightBoxFragmentClass(GalleryInputFragment galleryInputFragment);

        View getSearchView(ViewGroup viewGroup);

        int getThemeColor(Context context);

        Toolbar getToolbar(ViewGroup viewGroup);
    }

    /* access modifiers changed from: protected */
    public abstract Injector getInjector(GalleryInputFragment galleryInputFragment);

    public void onInputDeselected() {
    }

    public void onInputReselected() {
    }

    /* access modifiers changed from: protected */
    public void passDataOnViewCreated(Bundle bundle) {
    }

    public static Bundle createArguments(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(ARG_EXPANDED, z);
        return bundle;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GalleryOutputListener) {
            this.galleryOutputListener = (GalleryOutputListener) context;
        }
        if (context instanceof GalleryInputExpandedListener) {
            this.galleryInputExpandedListener = (GalleryInputExpandedListener) context;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.expanded = arguments.getBoolean(ARG_EXPANDED, false);
        }
        if (this.expanded) {
            this.layoutManager = new GridLayoutManager(getContext(), getResources().getInteger(R.integer.intercom_composer_expanded_column_count));
        } else {
            this.layoutManager = new LinearLayoutManager(getContext(), 0, false);
        }
        Injector injector2 = getInjector(this);
        this.injector = injector2;
        GalleryInputDataSource dataSource2 = injector2.getDataSource(this);
        this.dataSource = dataSource2;
        dataSource2.setListener(this.dataListener);
        this.imageLoader = this.injector.getImageLoader(this);
        this.endlessRecyclerScrollListener = new EndlessRecyclerScrollListener(this.layoutManager, this);
        this.recyclerAdapter = new GalleryRecyclerViewAdapter(LayoutInflater.from(getContext()), this.galleryImages, this.expanded, this, this.imageLoader);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutRes(), viewGroup, false);
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.gallery_root_view);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.gallery_recycler_view);
        this.emptyLayout = (EmptyView) inflate.findViewById(R.id.gallery_empty_view);
        this.contentLayout = (FrameLayout) inflate.findViewById(R.id.gallery_content_layout);
        if (this.expanded) {
            setUpAppBar(this.injector, viewGroup2);
            this.recyclerView.addItemDecoration(new HeadingMarginDecoration(R.dimen.intercom_composer_toolbar_height));
        } else {
            setUpPreviewViews(this.injector, viewGroup2);
        }
        this.emptyLayout.setActionButtonClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int permissionStatus = GalleryInputFragment.this.dataSource.getPermissionStatus();
                if (permissionStatus != 1) {
                    if (permissionStatus == 2) {
                        GalleryInputFragment.this.showPermissionPermanentlyDeniedDialog();
                        return;
                    } else if (permissionStatus != 3) {
                        return;
                    }
                }
                GalleryInputFragment.this.dataSource.requestPermission();
            }
        });
        this.emptyLayout.setThemeColor(this.injector.getThemeColor(getContext()));
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setUpAppBar(Injector injector2, ViewGroup viewGroup) {
        Toolbar toolbar = injector2.getToolbar(viewGroup);
        viewGroup.addView(toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setUpPreviewViews(Injector injector2, ViewGroup viewGroup) {
        ImageButton imageButton = (ImageButton) injector2.getExpanderButton(this.contentLayout);
        if (imageButton != null) {
            this.contentLayout.addView(imageButton);
            imageButton.setOnClickListener(this.expanderClickListener);
        }
        View searchView = injector2.getSearchView(this.contentLayout);
        if (searchView != null) {
            searchView.setOnClickListener(this.expanderClickListener);
            viewGroup.addView(searchView, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public int getLayoutRes() {
        if (this.expanded) {
            return R.layout.intercom_composer_fragment_composer_gallery_expanded;
        }
        return R.layout.intercom_composer_fragment_composer_gallery;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.recyclerAdapter);
        this.recyclerView.addOnScrollListener(this.endlessRecyclerScrollListener);
        if (this.expanded) {
            onInputSelected();
        }
        this.endlessRecyclerScrollListener.setMaxCount(this.dataSource.getCount());
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.recyclerView.removeOnScrollListener(this.endlessRecyclerScrollListener);
        this.recyclerView.setLayoutManager((RecyclerView.LayoutManager) null);
    }

    public void onLoadMore() {
        if (!this.galleryImages.isEmpty() && !this.dataSource.isLoading()) {
            this.dataSource.getImages(this.galleryImages.size(), (String) null);
        }
    }

    public void onImageClicked(RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition > -1 && adapterPosition < this.recyclerAdapter.getItemCount()) {
            launchLightBoxActivity(this.recyclerAdapter.getItem(adapterPosition));
        }
    }

    /* access modifiers changed from: package-private */
    public void launchLightBoxActivity(GalleryImage galleryImage) {
        FragmentActivity activity = getActivity();
        startActivityForResult(GalleryLightBoxActivity.createIntent(activity, galleryImage, getInjector(this).getLightBoxFragmentClass(this)), 14, ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.intercom_composer_slide_up, R.anim.intercom_composer_stay).toBundle());
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        checkPermissionAndFetchImages(false);
    }

    /* access modifiers changed from: package-private */
    public void showEmptyOrPermissionScreen(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                this.emptyLayout.setVisibility(0);
                this.emptyLayout.setTitle(R.string.intercom_photo_access_denied);
                this.emptyLayout.setSubtitle(R.string.intercom_allow_storage_access);
                this.emptyLayout.setActionButtonVisibility(0);
                this.contentLayout.setVisibility(8);
            } else if (i == 3) {
                this.emptyLayout.setVisibility(0);
                this.emptyLayout.setTitle(R.string.intercom_access_photos);
                this.emptyLayout.setSubtitle(R.string.intercom_storage_access_request);
                this.emptyLayout.setActionButtonVisibility(8);
                this.contentLayout.setVisibility(8);
            }
        } else if (this.galleryImages.isEmpty()) {
            this.emptyLayout.setVisibility(0);
            this.emptyLayout.setActionButtonVisibility(8);
            this.emptyLayout.setTitle((CharSequence) this.injector.getEmptyViewTitle(getResources()));
            this.emptyLayout.setSubtitle((CharSequence) this.injector.getEmptyViewSubtitle(getResources()));
            this.contentLayout.setVisibility(8);
        } else {
            this.emptyLayout.setVisibility(8);
            this.contentLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void showErrorScreen() {
        this.emptyLayout.setVisibility(0);
        this.emptyLayout.setActionButtonVisibility(8);
        this.emptyLayout.setTitle((CharSequence) this.injector.getErrorViewTitle(getResources()));
        this.emptyLayout.setSubtitle((CharSequence) this.injector.getErrorViewSubtitle(getResources()));
        this.contentLayout.setVisibility(8);
    }

    public void onInputSelected() {
        checkPermissionAndFetchImages(true);
    }

    /* access modifiers changed from: package-private */
    public void checkPermissionAndFetchImages(boolean z) {
        int permissionStatus = this.dataSource.getPermissionStatus();
        if (permissionStatus != 1) {
            if (permissionStatus == 2) {
                showEmptyOrPermissionScreen(permissionStatus);
                if (z) {
                    showPermissionPermanentlyDeniedDialog();
                    return;
                }
                return;
            } else if (permissionStatus != 3) {
                fetchImagesIfNotFetched();
                return;
            }
        }
        showEmptyOrPermissionScreen(permissionStatus);
        if (z) {
            this.dataSource.requestPermission();
        }
    }

    /* access modifiers changed from: private */
    public void showPermissionPermanentlyDeniedDialog() {
        new AlertDialog.Builder(getActivity()).setTitle(R.string.intercom_photo_access_denied).setMessage(R.string.intercom_go_to_device_settings).setPositiveButton(R.string.intercom_app_settings, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                GalleryInputFragment.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", GalleryInputFragment.this.getActivity().getPackageName(), (String) null)));
            }
        }).setNegativeButton(R.string.intercom_not_now, (DialogInterface.OnClickListener) null).show();
    }

    public void setGalleryListener(GalleryOutputListener galleryOutputListener2) {
        this.galleryOutputListener = galleryOutputListener2;
    }

    public void setGalleryExpandedListener(GalleryInputExpandedListener galleryInputExpandedListener2) {
        this.galleryInputExpandedListener = galleryInputExpandedListener2;
    }

    /* access modifiers changed from: package-private */
    public void fetchImagesIfNotFetched() {
        if (this.galleryImages.isEmpty()) {
            this.dataSource.getImages(0, (String) null);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 14 || i2 != -1) {
            super.onActivityResult(i, i2, intent);
        } else if (this.galleryOutputListener != null) {
            this.galleryOutputListener.onGalleryOutputReceived((GalleryImage) intent.getParcelableExtra(GalleryInputFullScreenActivity.GALLERY_IMAGE));
        }
    }
}
