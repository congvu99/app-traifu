package com.anggrayudi.storage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/ComponentWrapper;", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComponentWrapper.kt */
public interface ComponentWrapper {
    Activity getActivity();

    Context getContext();

    boolean startActivityForResult(Intent intent, int i);
}
