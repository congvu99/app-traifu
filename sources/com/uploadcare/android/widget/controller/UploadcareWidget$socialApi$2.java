package com.uploadcare.android.widget.controller;

import com.uploadcare.android.widget.BuildConfig;
import com.uploadcare.android.widget.interfaces.SocialApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/uploadcare/android/widget/interfaces/SocialApi;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadcareWidget.kt */
final class UploadcareWidget$socialApi$2 extends Lambda implements Function0<SocialApi> {
    final /* synthetic */ UploadcareWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadcareWidget$socialApi$2(UploadcareWidget uploadcareWidget) {
        super(0);
        this.this$0 = uploadcareWidget;
    }

    public final SocialApi invoke() {
        return (SocialApi) new Retrofit.Builder().baseUrl(BuildConfig.SOCIAL_API_ENDPOINT).client(this.this$0.getUploadcareClient().getHttpClient()).addConverterFactory(MoshiConverterFactory.create(this.this$0.getUploadcareClient().getObjectMapper().getMoshi())).build().create(SocialApi.class);
    }
}
