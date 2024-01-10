package com.intercom.input.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.intercom.composer.WindowUtil;

public class GalleryLightBoxActivity extends AppCompatActivity {
    private static final String KEY_FRAGMENT_CLASS = "fragment_class";
    private Class<? extends GalleryLightBoxFragment> fragmentClass;
    FragmentManager fragmentManager;
    GalleryImage galleryImage;

    public static Intent createIntent(Context context, GalleryImage galleryImage2, Class<? extends GalleryLightBoxFragment> cls) {
        return new Intent(context, GalleryLightBoxActivity.class).putExtra(GalleryInputFullScreenActivity.GALLERY_IMAGE, galleryImage2).putExtra(KEY_FRAGMENT_CLASS, cls);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        super.onCreate(bundle);
        setContentView(R.layout.intercom_composer_activity_gallery_lightbox);
        WindowUtil.setFullscreenWindow(window, R.color.intercom_composer_status_bar);
        Intent intent = getIntent();
        this.galleryImage = (GalleryImage) intent.getParcelableExtra(GalleryInputFullScreenActivity.GALLERY_IMAGE);
        this.fragmentClass = ClassUtils.cast(intent.getSerializableExtra(KEY_FRAGMENT_CLASS));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            GalleryLightBoxFragment galleryLightBoxFragment = (GalleryLightBoxFragment) ClassUtils.instantiate(this.fragmentClass);
            galleryLightBoxFragment.setArguments(GalleryLightBoxFragment.createArgs(this.galleryImage));
            this.fragmentManager.beginTransaction().replace(R.id.fragment_container, galleryLightBoxFragment).commit();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.intercom_composer_stay, R.anim.intercom_composer_slide_down);
    }
}
