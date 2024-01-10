package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.trainerfu.android.ComposeFragment;
import java.net.MalformedURLException;
import java.net.URL;

public class ComposeActivity extends BaseActivity implements ComposeFragment.EventListener {
    private AppCompatActivity act;
    private TextView subTitleView;
    private TextView titleView;
    private Toolbar toolbar;

    public ComposeActivity() {
        super(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        ComposeType composeType = ComposeType.LINK_STORY;
        if (intent.hasExtra("compose_type")) {
            composeType = ComposeType.getComposeType(intent.getIntExtra("compose_type", 0));
        }
        String str = null;
        if (composeType == ComposeType.LINK_STORY) {
            String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
            try {
                new URL(stringExtra);
                str = stringExtra;
            } catch (MalformedURLException unused) {
                composeType = ComposeType.POST_STORY;
            }
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("compose_type", composeType.getMask());
        if (composeType == ComposeType.LINK_STORY) {
            getSupportActionBar().setTitle((CharSequence) getString(R.string.SharePage));
            bundle2.putString("url", str);
        } else if (composeType == ComposeType.POST_STORY) {
            bundle2.putBoolean("is_trainer", getIntent().getBooleanExtra("is_trainer", false));
            bundle2.putString("first_name", getIntent().getStringExtra("first_name"));
            getSupportActionBar().setTitle((CharSequence) getString(R.string.NewPost));
            getSupportActionBar().setSubtitle((int) R.string.visibleToEveryone);
        } else if (composeType == ComposeType.WORKOUT_FEEDBACK) {
            bundle2.putInt("client_id", intent.getIntExtra("client_id", 0));
            getSupportActionBar().setTitle((CharSequence) getString(R.string.WellDone));
        } else if (composeType == ComposeType.PROGRESS_PHOTO) {
            bundle2.putInt("client_id", intent.getIntExtra("client_id", 0));
            bundle2.putString("photo_file_path", intent.getStringExtra("photo_file_path"));
            getSupportActionBar().setTitle((CharSequence) getString(R.string.ProgressPhoto));
        }
        if (bundle == null) {
            ComposeFragment composeFragment = new ComposeFragment();
            composeFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) composeFragment, "cf").commit();
            composeFragment.setupSimpleStorage(bundle);
            return;
        }
        getCF().setupSimpleStorage(bundle);
    }

    public void composeObjectSaved() {
        Intent intent = new Intent();
        intent.putExtra("action", "compose_object_saved");
        setResult(-1, intent);
        finish();
    }

    public void composeCancelled() {
        Intent intent = new Intent();
        intent.putExtra("action", "compose_cancelled");
        setResult(-1, intent);
        finish();
    }

    public void focusEditText(View view) {
        getCF().focusEditText(view);
    }

    private ComposeFragment getCF() {
        return (ComposeFragment) getSupportFragmentManager().findFragmentByTag("cf");
    }

    public void onBackPressed() {
        if (!getCF().onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        getCF().storageHelper.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        getCF().storageHelper.onRestoreInstanceState(bundle);
    }

    private void setTitle(String str) {
        this.titleView.setText(str);
    }

    private void setSubTitle(String str) {
        this.subTitleView.setText("hello how are you");
    }
}
