package com.uploadcare.android.library.conversion;

import com.uploadcare.android.library.api.UploadcareClient;
import com.uploadcare.android.library.urls.Urls;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0014¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/library/conversion/VideoConverter;", "Lcom/uploadcare/android/library/conversion/Converter;", "client", "Lcom/uploadcare/android/library/api/UploadcareClient;", "videoConversionJobs", "", "Lcom/uploadcare/android/library/conversion/VideoConversionJob;", "(Lcom/uploadcare/android/library/api/UploadcareClient;Ljava/util/List;)V", "getConversionStatusUri", "Ljava/net/URI;", "token", "", "getConversionUri", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: VideoConverter.kt */
public final class VideoConverter extends Converter {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoConverter(UploadcareClient uploadcareClient, List<VideoConversionJob> list) {
        super(uploadcareClient, list);
        Intrinsics.checkNotNullParameter(uploadcareClient, "client");
        Intrinsics.checkNotNullParameter(list, "videoConversionJobs");
    }

    /* access modifiers changed from: protected */
    public URI getConversionUri() {
        return Urls.Companion.apiConvertVideo();
    }

    /* access modifiers changed from: protected */
    public URI getConversionStatusUri(int i) {
        return Urls.Companion.apiConvertVideoStatus(i);
    }
}
