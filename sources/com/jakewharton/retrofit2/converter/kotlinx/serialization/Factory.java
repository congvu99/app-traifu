package com.jakewharton.retrofit2.converter.kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JI\u0010\u0007\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J9\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0002\b\u0003\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Factory;", "Lretrofit2/Converter$Factory;", "contentType", "Lokhttp3/MediaType;", "serializer", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "(Lokhttp3/MediaType;Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;)V", "requestBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "type", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "", "methodAnnotations", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "responseBodyConverter", "Lokhttp3/ResponseBody;", "annotations", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
@ExperimentalSerializationApi
/* compiled from: Factory.kt */
public final class Factory extends Converter.Factory {
    private final MediaType contentType;
    private final Serializer serializer;

    public Factory(MediaType mediaType, Serializer serializer2) {
        Intrinsics.checkNotNullParameter(mediaType, "contentType");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        this.contentType = mediaType;
        this.serializer = serializer2;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return new DeserializationStrategyConverter<>(this.serializer.serializer(type), this.serializer);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotationArr, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(annotationArr2, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        return new SerializationStrategyConverter<>(this.contentType, this.serializer.serializer(type), this.serializer);
    }
}