package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.Util;

public class HelloActivity extends BaseActivity {
    private IconTextView loginBtn;
    private IconTextView registerBtn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.hello_view);
        IconTextView iconTextView = (IconTextView) findViewById(R.id.loginBtn);
        this.loginBtn = iconTextView;
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HelloActivity.this.startActivity(new Intent(HelloActivity.this, LoginActivity.class));
            }
        });
        IconTextView iconTextView2 = (IconTextView) findViewById(R.id.registerBtn);
        this.registerBtn = iconTextView2;
        iconTextView2.setText(getString(R.string.createNewTrainerAccount));
        this.registerBtn.setVisibility(0);
        this.registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HelloActivity.this, RegisterActivity.class);
                intent.putExtra("for_client_registration", false);
                HelloActivity.this.startActivity(intent);
            }
        });
        if (Util.checkIsTablet(this)) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.icon_view);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 50);
            linearLayout.setLayoutParams(layoutParams);
        }
        float deviceWidth = Util.getDeviceWidth(this);
        if (deviceWidth > 500.0f) {
            int i = (int) (deviceWidth - 500.0f);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.registerBtn.getLayoutParams();
            layoutParams2.setMargins(i, Util.sizeInPx(this, 27), i, Util.sizeInPx(this, 74));
            this.registerBtn.setLayoutParams(layoutParams2);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.loginBtn.getLayoutParams();
            layoutParams3.setMargins(i, Util.sizeInPx(this, 32), i, 0);
            this.loginBtn.setLayoutParams(layoutParams3);
        }
        getWindow().getDecorView().setSystemUiVisibility(16);
        getWindow().setStatusBarColor(getResources().getColor(R.color.tintColor));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.tintColor));
    }
}
