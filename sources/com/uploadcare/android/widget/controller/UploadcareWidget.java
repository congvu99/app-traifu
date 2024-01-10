package com.uploadcare.android.widget.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.facebook.internal.AnalyticsEvents;
import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.activity.UploadcareActivity;
import com.uploadcare.android.widget.interfaces.SocialApi;
import com.uploadcare.android.widget.utils.SingletonHolder;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bR\u001b\u0010\u0005\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/uploadcare/android/widget/controller/UploadcareWidget;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "socialApi", "Lcom/uploadcare/android/widget/interfaces/SocialApi;", "getSocialApi$widget_release", "()Lcom/uploadcare/android/widget/interfaces/SocialApi;", "socialApi$delegate", "Lkotlin/Lazy;", "uploadcareClient", "Lcom/uploadcare/android/library/api/UploadcareClient;", "getUploadcareClient", "()Lcom/uploadcare/android/library/api/UploadcareClient;", "backgroundUploadResult", "Landroidx/lifecycle/LiveData;", "Lcom/uploadcare/android/widget/controller/UploadcareWidgetResult;", "uuid", "Ljava/util/UUID;", "cancelBackgroundUpload", "", "selectFile", "Lcom/uploadcare/android/widget/controller/UploadcareWidget$Builder;", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "Builder", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareWidget.kt */
public final class UploadcareWidget {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int UPLOADCARE_REQUEST_CODE = 431;
    private final Lazy socialApi$delegate;
    private final UploadcareClient uploadcareClient;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 1;
            $EnumSwitchMapping$0[WorkInfo.State.FAILED.ordinal()] = 2;
            $EnumSwitchMapping$0[WorkInfo.State.CANCELLED.ordinal()] = 3;
        }
    }

    @JvmStatic
    public static UploadcareWidget getInstance() {
        return Companion.getInstance();
    }

    public static final int getUPLOADCARE_REQUEST_CODE() {
        return UPLOADCARE_REQUEST_CODE;
    }

    @JvmStatic
    public static UploadcareWidget init$widget_release(Context context) {
        return Companion.init$widget_release(context);
    }

    public final SocialApi getSocialApi$widget_release() {
        return (SocialApi) this.socialApi$delegate.getValue();
    }

    private UploadcareWidget(Context context) {
        String string = context.getString(R.string.uploadcare_public_key);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.uploadcare_public_key)");
        String string2 = context.getString(R.string.uploadcare_private_key);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.uploadcare_private_key)");
        this.uploadcareClient = new UploadcareClient(string, string2.length() > 0 ? context.getString(R.string.uploadcare_private_key) : null, false, 4, (DefaultConstructorMarker) null);
        this.socialApi$delegate = LazyKt.lazy(new UploadcareWidget$socialApi$2(this));
    }

    public /* synthetic */ UploadcareWidget(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final UploadcareClient getUploadcareClient() {
        return this.uploadcareClient;
    }

    public final Builder selectFile(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new Builder(activity);
    }

    public final Builder selectFile(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return new Builder(fragment);
    }

    public final void cancelBackgroundUpload(Context context, UUID uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        WorkManager.getInstance(context).cancelWorkById(uuid);
    }

    public final LiveData<UploadcareWidgetResult> backgroundUploadResult(Context context, UUID uuid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        LiveData<WorkInfo> workInfoByIdLiveData = WorkManager.getInstance(context).getWorkInfoByIdLiveData(uuid);
        Intrinsics.checkNotNullExpressionValue(workInfoByIdLiveData, "WorkManager.getInstance(…orkInfoByIdLiveData(uuid)");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(workInfoByIdLiveData, new UploadcareWidget$backgroundUploadResult$1(this, mediatorLiveData, workInfoByIdLiveData, uuid));
        return mediatorLiveData;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nJ\u0016\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0013R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/uploadcare/android/widget/controller/UploadcareWidget$Builder;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "(Landroidx/fragment/app/Fragment;Landroid/app/Activity;)V", "backgroundUpload", "", "cancelable", "expire", "", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "network", "Lcom/uploadcare/android/widget/controller/SocialNetwork;", "requestCode", "", "showProgress", "signature", "storeUponUpload", "style", "enabled", "from", "launch", "", "resultRequestCode", "signedUpload", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareWidget.kt */
    public static final class Builder {
        private final Activity activity;
        private boolean backgroundUpload;
        private boolean cancelable;
        private String expire;
        private FileType fileType;
        private final Fragment fragment;
        private SocialNetwork network;
        private int requestCode;
        private boolean showProgress;
        private String signature;
        private boolean storeUponUpload;
        private int style;

        private Builder(Fragment fragment2, Activity activity2) {
            this.fragment = fragment2;
            this.activity = activity2;
            this.storeUponUpload = true;
            this.requestCode = UploadcareWidget.Companion.getUPLOADCARE_REQUEST_CODE();
            this.fileType = FileType.any;
            this.style = -1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ Builder(Fragment fragment2, Activity activity2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fragment2, (i & 2) != 0 ? null : activity2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity2) {
            this((Fragment) null, activity2);
            Intrinsics.checkNotNullParameter(activity2, "activity");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(Fragment fragment2) {
            this(fragment2, (Activity) null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
        }

        public final Builder storeUponUpload(boolean z) {
            Builder builder = this;
            builder.storeUponUpload = z;
            return builder;
        }

        public final Builder resultRequestCode(int i) {
            Builder builder = this;
            builder.requestCode = i;
            return builder;
        }

        public final Builder fileType(FileType fileType2) {
            Intrinsics.checkNotNullParameter(fileType2, "fileType");
            Builder builder = this;
            builder.fileType = fileType2;
            return builder;
        }

        public final Builder signedUpload(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "signature");
            Intrinsics.checkNotNullParameter(str2, "expire");
            Builder builder = this;
            builder.signature = str;
            builder.expire = str2;
            return builder;
        }

        public final Builder from(SocialNetwork socialNetwork) {
            Intrinsics.checkNotNullParameter(socialNetwork, "network");
            Builder builder = this;
            builder.network = socialNetwork;
            return builder;
        }

        public final Builder style(int i) {
            Builder builder = this;
            builder.style = i;
            return builder;
        }

        public final Builder cancelable(boolean z) {
            Builder builder = this;
            builder.cancelable = z;
            return builder;
        }

        public final Builder showProgress(boolean z) {
            Builder builder = this;
            builder.showProgress = z;
            return builder;
        }

        public final Builder backgroundUpload() {
            Builder builder = this;
            builder.backgroundUpload = true;
            return builder;
        }

        public final void launch() {
            Fragment fragment2 = this.fragment;
            if (fragment2 != null) {
                Intent intent = new Intent(this.fragment.getActivity(), UploadcareActivity.class);
                SocialNetwork socialNetwork = this.network;
                if (socialNetwork != null) {
                    intent.putExtra("network", socialNetwork.getRawValue());
                }
                intent.putExtra("fileType", this.fileType.name());
                intent.putExtra("store", this.storeUponUpload);
                intent.putExtra(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.style);
                intent.putExtra("signature", this.signature);
                intent.putExtra("expire", this.expire);
                intent.putExtra("cancelable", this.cancelable);
                intent.putExtra("showProgress", this.showProgress);
                intent.putExtra("backgroundUpload", this.backgroundUpload);
                Unit unit = Unit.INSTANCE;
                fragment2.startActivityForResult(intent, this.requestCode);
                return;
            }
            Activity activity2 = this.activity;
            if (activity2 != null) {
                Intent intent2 = new Intent(this.activity, UploadcareActivity.class);
                SocialNetwork socialNetwork2 = this.network;
                if (socialNetwork2 != null) {
                    intent2.putExtra("network", socialNetwork2.getRawValue());
                }
                intent2.putExtra("fileType", this.fileType.name());
                intent2.putExtra("store", this.storeUponUpload);
                intent2.putExtra(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, this.style);
                intent2.putExtra("signature", this.signature);
                intent2.putExtra("expire", this.expire);
                intent2.putExtra("cancelable", this.cancelable);
                intent2.putExtra("showProgress", this.showProgress);
                intent2.putExtra("backgroundUpload", this.backgroundUpload);
                Unit unit2 = Unit.INSTANCE;
                activity2.startActivityForResult(intent2, this.requestCode);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u0002H\u0017J\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0011¢\u0006\u0002\b\rR\u001c\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/uploadcare/android/widget/controller/UploadcareWidget$Companion;", "Lcom/uploadcare/android/widget/utils/SingletonHolder;", "Lcom/uploadcare/android/widget/controller/UploadcareWidget;", "Landroid/content/Context;", "()V", "UPLOADCARE_REQUEST_CODE", "", "getUPLOADCARE_REQUEST_CODE$annotations", "getUPLOADCARE_REQUEST_CODE", "()I", "getInstance", "init", "arg", "init$widget_release", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadcareWidget.kt */
    public static final class Companion extends SingletonHolder<UploadcareWidget, Context> {
        @JvmStatic
        public static /* synthetic */ void getUPLOADCARE_REQUEST_CODE$annotations() {
        }

        private Companion() {
            super(AnonymousClass1.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getUPLOADCARE_REQUEST_CODE() {
            return UploadcareWidget.UPLOADCARE_REQUEST_CODE;
        }

        @JvmStatic
        public UploadcareWidget init$widget_release(Context context) {
            Intrinsics.checkNotNullParameter(context, "arg");
            return (UploadcareWidget) super.init$widget_release(context);
        }

        @JvmStatic
        public UploadcareWidget getInstance() {
            return (UploadcareWidget) super.getInstance();
        }
    }
}
