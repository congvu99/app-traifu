package com.uploadcare.android.widget.interfaces;

import com.uploadcare.android.widget.data.ChunkResponse;
import com.uploadcare.android.widget.data.SelectedFile;
import com.uploadcare.android.widget.data.SocialSourcesResponse;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H'J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¨\u0006\u0011"}, d2 = {"Lcom/uploadcare/android/widget/interfaces/SocialApi;", "", "getSourceChunk", "Lretrofit2/Call;", "Lcom/uploadcare/android/widget/data/ChunkResponse;", "authCookie", "", "sourceBase", "chunk", "loadMore", "getSources", "Lcom/uploadcare/android/widget/data/SocialSourcesResponse;", "selectFile", "Lcom/uploadcare/android/widget/data/SelectedFile;", "done", "fileUrl", "signOut", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialApi.kt */
public interface SocialApi {
    @GET("{base}/{chunk}/{offset}")
    Call<ChunkResponse> getSourceChunk(@Header("Cookie") String str, @Path("base") String str2, @Path("chunk") String str3, @Path("offset") String str4);

    @GET("sources")
    Call<SocialSourcesResponse> getSources();

    @FormUrlEncoded
    @POST("{done}")
    Call<SelectedFile> selectFile(@Header("Cookie") String str, @Path("done") String str2, @Field("file") String str3);

    @DELETE("{session}")
    Call<Object> signOut(@Header("Cookie") String str, @Path("session") String str2);
}
