package com.jakewharton.retrofit2.converter.kotlinx.serialization;

import com.jakewharton.retrofit2.converter.kotlinx.serialization.Serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.StringFormat;
import okhttp3.MediaType;
import retrofit2.Converter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"asConverterFactory", "Lretrofit2/Converter$Factory;", "Lkotlinx/serialization/BinaryFormat;", "contentType", "Lokhttp3/MediaType;", "create", "Lkotlinx/serialization/StringFormat;", "retrofit2-kotlinx-serialization-converter"}, k = 2, mv = {1, 4, 0})
/* compiled from: Factory.kt */
public final class KotlinSerializationConverterFactory {
    @ExperimentalSerializationApi
    public static final Converter.Factory create(StringFormat stringFormat, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(stringFormat, "$this$asConverterFactory");
        Intrinsics.checkNotNullParameter(mediaType, "contentType");
        return new Factory(mediaType, new Serializer.FromString(stringFormat));
    }

    @ExperimentalSerializationApi
    public static final Converter.Factory create(BinaryFormat binaryFormat, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(binaryFormat, "$this$asConverterFactory");
        Intrinsics.checkNotNullParameter(mediaType, "contentType");
        return new Factory(mediaType, new Serializer.FromBytes(binaryFormat));
    }
}
