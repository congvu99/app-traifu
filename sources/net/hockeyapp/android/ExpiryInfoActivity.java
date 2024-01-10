package net.hockeyapp.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import net.hockeyapp.android.views.ExpiryInfoView;

public class ExpiryInfoActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getStringResource(13));
        setContentView(getLayoutView());
    }

    /* access modifiers changed from: protected */
    public View getLayoutView() {
        return new ExpiryInfoView(this, getStringResource(14));
    }

    /* access modifiers changed from: protected */
    public String getStringResource(int i) {
        return Strings.get(UpdateManager.getLastListener(), i);
    }
}
