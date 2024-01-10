package com.jakewharton.retrofit2.converter.kotlinx.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J1\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\t0\u00182\u0006\u0010\u0019\u001a\u0002H\tH&¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "", "()V", "format", "Lkotlinx/serialization/SerialFormat;", "getFormat$annotations", "getFormat", "()Lkotlinx/serialization/SerialFormat;", "fromResponseBody", "T", "loader", "Lkotlinx/serialization/DeserializationStrategy;", "body", "Lokhttp3/ResponseBody;", "(Lkotlinx/serialization/DeserializationStrategy;Lokhttp3/ResponseBody;)Ljava/lang/Object;", "serializer", "Lkotlinx/serialization/KSerializer;", "type", "Ljava/lang/reflect/Type;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "saver", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lokhttp3/RequestBody;", "FromBytes", "FromString", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer$FromString;", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer$FromBytes;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
/* compiled from: Serializer.kt */
public abstract class Serializer {
    protected static /* synthetic */ void getFormat$annotations() {
    }

    public abstract <T> T fromResponseBody(DeserializationStrategy<T> deserializationStrategy, ResponseBody responseBody);

    /* access modifiers changed from: protected */
    public abstract SerialFormat getFormat();

    public abstract <T> RequestBody toRequestBody(MediaType mediaType, SerializationStrategy<? super T> serializationStrategy, T t);

    private Serializer() {
    }

    public /* synthetic */ Serializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @ExperimentalSerializationApi
    public final KSerializer<Object> serializer(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(getFormat().getSerializersModule(), type);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u00132\u0006\u0010\u0014\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer$FromString;", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "format", "Lkotlinx/serialization/StringFormat;", "(Lkotlinx/serialization/StringFormat;)V", "getFormat", "()Lkotlinx/serialization/StringFormat;", "fromResponseBody", "T", "loader", "Lkotlinx/serialization/DeserializationStrategy;", "body", "Lokhttp3/ResponseBody;", "(Lkotlinx/serialization/DeserializationStrategy;Lokhttp3/ResponseBody;)Ljava/lang/Object;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "saver", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lokhttp3/RequestBody;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Serializer.kt */
    public static final class FromString extends Serializer {
        private final StringFormat format;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FromString(StringFormat stringFormat) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(stringFormat, "format");
            this.format = stringFormat;
        }

        /* access modifiers changed from: protected */
        public StringFormat getFormat() {
            return this.format;
        }

        public <T> T fromResponseBody(DeserializationStrategy<T> deserializationStrategy, ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "loader");
            Intrinsics.checkNotNullParameter(responseBody, SDKConstants.PARAM_A2U_BODY);
            String string = responseBody.string();
            Intrinsics.checkNotNullExpressionValue(string, "body.string()");
            return getFormat().decodeFromString(deserializationStrategy, string);
        }

        public <T> RequestBody toRequestBody(MediaType mediaType, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(mediaType, "contentType");
            Intrinsics.checkNotNullParameter(serializationStrategy, "saver");
            RequestBody create = RequestBody.create(mediaType, getFormat().encodeToString(serializationStrategy, t));
            Intrinsics.checkNotNullExpressionValue(create, "RequestBody.create(contentType, string)");
            return create;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u00132\u0006\u0010\u0014\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer$FromBytes;", "Lcom/jakewharton/retrofit2/converter/kotlinx/serialization/Serializer;", "format", "Lkotlinx/serialization/BinaryFormat;", "(Lkotlinx/serialization/BinaryFormat;)V", "getFormat", "()Lkotlinx/serialization/BinaryFormat;", "fromResponseBody", "T", "loader", "Lkotlinx/serialization/DeserializationStrategy;", "body", "Lokhttp3/ResponseBody;", "(Lkotlinx/serialization/DeserializationStrategy;Lokhttp3/ResponseBody;)Ljava/lang/Object;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "saver", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lokhttp3/RequestBody;", "retrofit2-kotlinx-serialization-converter"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Serializer.kt */
    public static final class FromBytes extends Serializer {
        private final BinaryFormat format;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FromBytes(BinaryFormat binaryFormat) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(binaryFormat, "format");
            this.format = binaryFormat;
        }

        /* access modifiers changed from: protected */
        public BinaryFormat getFormat() {
            return this.format;
        }

        public <T> T fromResponseBody(DeserializationStrategy<T> deserializationStrategy, ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(deserializationStrategy, "loader");
            Intrinsics.checkNotNullParameter(responseBody, SDKConstants.PARAM_A2U_BODY);
            byte[] bytes = responseBody.bytes();
            Intrinsics.checkNotNullExpressionValue(bytes, "body.bytes()");
            return getFormat().decodeFromByteArray(deserializationStrategy, bytes);
        }

        public <T> RequestBody toRequestBody(MediaType mediaType, SerializationStrategy<? super T> serializationStrategy, T t) {
            Intrinsics.checkNotNullParameter(mediaType, "contentType");
            Intrinsics.checkNotNullParameter(serializationStrategy, "saver");
            RequestBody create = RequestBody.create(mediaType, getFormat().encodeToByteArray(serializationStrategy, t));
            Intrinsics.checkNotNullExpressionValue(create, "RequestBody.create(contentType, bytes)");
            return create;
        }
    }
}
