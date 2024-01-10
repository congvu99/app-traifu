package io.intercom.android.sdk.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.VideoView;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.imageloader.WallpaperLoader;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.video.AudioServiceContext;
import io.intercom.android.sdk.video.IntercomMediaController;
import io.intercom.android.sdk.views.IntercomToolbar;

public class IntercomVideoActivity extends IntercomBaseActivity implements IntercomToolbar.Listener, View.OnClickListener {
    private static final String PARCEL_VIDEO_URL = "parcel_video_url";
    private IntercomToolbar intercomToolbar;
    /* access modifiers changed from: private */
    public ProgressBar loadingView;
    /* access modifiers changed from: private */
    public MediaController mediaController;
    /* access modifiers changed from: private */
    public MetricTracker metricTracker;
    /* access modifiers changed from: private */
    public VideoView videoView;
    /* access modifiers changed from: private */
    public FrameLayout videoViewOverlay;
    private WallpaperLoader wallpaperLoader;

    public void onCloseClicked() {
    }

    public void onToolbarClicked() {
    }

    public static Intent buildIntent(Context context, String str) {
        Intent intent = new Intent(context, IntercomVideoActivity.class);
        intent.putExtra(PARCEL_VIDEO_URL, str);
        intent.addFlags(268435456);
        intent.addFlags(536870912);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_activity_video);
        this.loadingView = (ProgressBar) findViewById(R.id.loading_view);
        this.videoView = (VideoView) findViewById(R.id.video_view);
        this.intercomToolbar = (IntercomToolbar) findViewById(R.id.intercom_toolbar);
        this.videoViewOverlay = (FrameLayout) findViewById(R.id.video_view_overlay);
        Injector injector = Injector.get();
        Provider<AppConfig> appConfigProvider = injector.getAppConfigProvider();
        this.metricTracker = injector.getMetricTracker();
        setupToolbar(appConfigProvider);
        Bundle extras = getIntent().getExtras();
        String str = "";
        if (extras != null) {
            str = extras.getString(PARCEL_VIDEO_URL, str);
        }
        overridePendingTransition(R.anim.intercom_video_slide_up_in, 0);
        if (!TextUtils.isEmpty(str)) {
            initVideoPlayer(str);
        } else {
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.videoView.stopPlayback();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.intercomToolbar.closeWallpaperLoader(this.wallpaperLoader);
        super.onDestroy();
    }

    public void onBackPressed() {
        closeActivity();
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(AudioServiceContext.preventLeakOf(context));
    }

    private void initVideoPlayer(final String str) {
        IntercomMediaController intercomMediaController = new IntercomMediaController(this, this.intercomToolbar);
        this.mediaController = intercomMediaController;
        this.videoView.setMediaController(intercomMediaController);
        this.videoView.setVideoURI(Uri.parse(str));
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                IntercomVideoActivity.this.metricTracker.loadedVideo(str, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                IntercomVideoActivity.this.mediaController.show();
                IntercomVideoActivity intercomVideoActivity = IntercomVideoActivity.this;
                intercomVideoActivity.styleMediaController(intercomVideoActivity.mediaController);
                IntercomVideoActivity.this.videoView.start();
                IntercomVideoActivity.this.loadingView.setVisibility(8);
                IntercomVideoActivity.this.videoViewOverlay.postDelayed(new Runnable() {
                    public void run() {
                        IntercomVideoActivity.this.videoViewOverlay.setBackgroundColor(0);
                        IntercomVideoActivity.this.loadingView.setVisibility(8);
                    }
                }, 200);
            }
        });
        this.videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                IntercomVideoActivity.this.metricTracker.failedToPlayVideo(str);
                return false;
            }
        });
        this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                IntercomVideoActivity.this.metricTracker.completedVideo();
            }
        });
        this.videoViewOverlay.setOnClickListener(this);
    }

    private void setupToolbar(Provider<AppConfig> provider) {
        this.intercomToolbar.setBackgroundColor(provider.get().getSecondaryColor());
        this.intercomToolbar.setLeftNavigationItemVisibility(0);
        this.intercomToolbar.setCloseButtonVisibility(8);
        this.intercomToolbar.updateToolbarSize();
        WallpaperLoader create = WallpaperLoader.create(this, provider);
        this.wallpaperLoader = create;
        this.intercomToolbar.loadWallpaper(create);
        this.intercomToolbar.setListener(this);
    }

    public void onInboxClicked() {
        closeActivity();
    }

    public void onClick(View view) {
        if (this.mediaController.isShowing()) {
            this.mediaController.hide();
        } else {
            this.mediaController.show();
        }
    }

    private void closeActivity() {
        finish();
        overridePendingTransition(0, R.anim.intercom_video_slide_out_down);
    }

    /* access modifiers changed from: private */
    public void styleMediaController(View view) {
        int color = getResources().getColor(R.color.intercom_white);
        int i = 0;
        if (view instanceof MediaController) {
            MediaController mediaController2 = (MediaController) view;
            while (i < mediaController2.getChildCount()) {
                styleMediaController(mediaController2.getChildAt(i));
                i++;
            }
        } else if (view instanceof LinearLayout) {
            LinearLayout linearLayout = (LinearLayout) view;
            while (i < linearLayout.getChildCount()) {
                styleMediaController(linearLayout.getChildAt(i));
                i++;
            }
        } else if (view instanceof SeekBar) {
            SeekBar seekBar = (SeekBar) view;
            seekBar.getProgressDrawable().mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN);
            seekBar.getThumb().mutate().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
    }
}
