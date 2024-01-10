package com.uploadcare.android.widget.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.databinding.UcwActivityUploadcareBinding;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/uploadcare/android/widget/activity/UploadcareActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/uploadcare/android/widget/databinding/UcwActivityUploadcareBinding;", "applyStyle", "", "bundle", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onPause", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareActivity.kt */
public final class UploadcareActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private UcwActivityUploadcareBinding binding;

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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, SDKConstants.PARAM_INTENT);
        applyStyle(intent.getExtras());
        super.onCreate(bundle);
        setResult(0);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.ucw_activity_uploadcare);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte….ucw_activity_uploadcare)");
        this.binding = (UcwActivityUploadcareBinding) contentView;
    }

    private final void applyStyle(Bundle bundle) {
        int i = bundle != null ? bundle.getInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE) : -1;
        if (i != -1) {
            getTheme().applyStyle(i, true);
        } else {
            getTheme().applyStyle(R.style.UploadcareStyle, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}
