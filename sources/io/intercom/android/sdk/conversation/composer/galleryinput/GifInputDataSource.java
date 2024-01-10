package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.net.Uri;
import android.text.TextUtils;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.GalleryInputDataSource;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.GifResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class GifInputDataSource implements GalleryInputDataSource {
    private static final long DEBOUNCE_DELAY_MS = 300;
    /* access modifiers changed from: private */
    public final Api api;
    private int currentCount = 0;
    private final Debouncer debouncer = new Debouncer();
    /* access modifiers changed from: private */
    public String lastQuery;
    /* access modifiers changed from: private */
    public GalleryInputDataSource.Listener listener;
    /* access modifiers changed from: private */
    public boolean loading;
    private final MetricTracker metricTracker;

    public int getPermissionStatus() {
        return 0;
    }

    public void requestPermission() {
    }

    GifInputDataSource(Api api2, MetricTracker metricTracker2) {
        this.api = api2;
        this.metricTracker = metricTracker2;
    }

    public void setListener(GalleryInputDataSource.Listener listener2) {
        this.listener = listener2;
    }

    public void getImages(int i, String str) {
        this.loading = true;
        this.lastQuery = str;
        if (TextUtils.isEmpty(str)) {
            loadDefaultGifs();
        } else {
            searchGifs(str);
        }
    }

    private void loadDefaultGifs() {
        this.api.fetchDefaultGifs(new Callback<GifResponse>() {
            public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                boolean unused = GifInputDataSource.this.loading = false;
                GifInputDataSource.this.handleGifResponse(response);
            }

            public void onFailure(Call<GifResponse> call, Throwable th) {
                boolean unused = GifInputDataSource.this.loading = false;
                GifInputDataSource.this.listener.onError();
            }
        });
    }

    private void searchGifs(final String str) {
        this.metricTracker.searchedGifInput(str);
        this.debouncer.call(new Runnable() {
            public void run() {
                GifInputDataSource.this.api.fetchGifs(str, new Callback<GifResponse>() {
                    public void onResponse(Call<GifResponse> call, Response<GifResponse> response) {
                        boolean unused = GifInputDataSource.this.loading = false;
                        if (str.equals(GifInputDataSource.this.lastQuery)) {
                            GifInputDataSource.this.handleGifResponse(response);
                        }
                    }

                    public void onFailure(Call<GifResponse> call, Throwable th) {
                        boolean unused = GifInputDataSource.this.loading = false;
                        GifInputDataSource.this.listener.onError();
                    }
                });
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    public void handleGifResponse(Response<GifResponse> response) {
        GifResponse body = response.body();
        if (body != null) {
            this.listener.onSuccess(getImagesFromResponse(body.results()));
            return;
        }
        this.listener.onError();
    }

    /* access modifiers changed from: package-private */
    public List<GalleryImage> getImagesFromResponse(List<Block> list) {
        this.currentCount = list.size();
        ArrayList arrayList = new ArrayList(this.currentCount);
        for (Block next : list) {
            GalleryImage galleryImage = r4;
            GalleryImage galleryImage2 = new GalleryImage("", "", Uri.parse(next.getUrl()), next.getPreviewUrl(), next.getAttribution(), next.getWidth(), next.getHeight(), 0, true, false, "");
            arrayList.add(galleryImage);
        }
        return arrayList;
    }

    public int getCount() {
        return this.currentCount;
    }

    public boolean isLoading() {
        return this.loading;
    }
}
