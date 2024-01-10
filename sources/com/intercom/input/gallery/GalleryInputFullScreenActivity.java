package com.intercom.input.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.intercom.composer.WindowUtil;

public class GalleryInputFullScreenActivity extends AppCompatActivity implements GalleryOutputListener {
    public static final String GALLERY_IMAGE = "gallery_image";
    private static final String KEY_FRAGMENT_ARGS = "fragment_args";
    private static final String KEY_FRAGMENT_CLASS = "fragment_class";
    private Bundle fragmentArgs;
    private Class<? extends GalleryInputFragment> fragmentClass;

    public static Intent createIntent(Context context, Class<? extends GalleryInputFragment> cls, Bundle bundle) {
        return new Intent(context, GalleryInputFullScreenActivity.class).putExtra(KEY_FRAGMENT_CLASS, cls).putExtra(KEY_FRAGMENT_ARGS, bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.intercom_composer_activity_input_full_screen);
        WindowUtil.setFullscreenWindow(getWindow(), R.color.intercom_composer_status_bar);
        Intent intent = getIntent();
        this.fragmentClass = ClassUtils.cast(intent.getSerializableExtra(KEY_FRAGMENT_CLASS));
        this.fragmentArgs = intent.getBundleExtra(KEY_FRAGMENT_ARGS);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        String name = GalleryInputFragment.class.getName();
        if (supportFragmentManager.findFragmentByTag(name) == null) {
            GalleryInputFragment galleryInputFragment = (GalleryInputFragment) ClassUtils.instantiate(this.fragmentClass);
            Bundle bundle2 = this.fragmentArgs == null ? new Bundle() : new Bundle(this.fragmentArgs);
            bundle2.putAll(GalleryInputFragment.createArguments(true));
            galleryInputFragment.setArguments(bundle2);
            galleryInputFragment.setGalleryListener(this);
            supportFragmentManager.beginTransaction().replace(R.id.expanded_fragment, (Fragment) galleryInputFragment, name).commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        overridePendingTransition(R.anim.intercom_composer_stay, R.anim.intercom_composer_slide_down);
    }

    public void onGalleryOutputReceived(GalleryImage galleryImage) {
        Intent intent = new Intent();
        intent.putExtra(GALLERY_IMAGE, galleryImage);
        setResult(-1, intent);
        onBackPressed();
    }
}
