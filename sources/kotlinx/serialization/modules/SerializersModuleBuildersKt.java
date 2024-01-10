package kotlinx.serialization.modules;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u001a,\u0010\u0007\u001a\u00020\u0001\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r\u001a#\u0010\u0007\u001a\u00020\u0001\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH\b\u001a'\u0010\u000e\u001a\u00020\u0005\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\t*\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\rH\b\u001a[\u0010\u000f\u001a\u00020\u0005\"\b\b\u0000\u0010\u0010*\u00020\t*\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000b2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\r2\u001f\b\u0002\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"SerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "", "Lkotlin/ExtensionFunctionType;", "serializersModuleOf", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "contextual", "polymorphic", "Base", "baseClass", "baseSerializer", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerializersModuleBuilders.kt */
public final class SerializersModuleBuildersKt {
    public static final /* synthetic */ <T> SerializersModule serializersModuleOf(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return serializersModuleOf(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    public static final SerializersModule SerializersModule(Function1<? super SerializersModuleBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        function1.invoke(serializersModuleBuilder);
        return serializersModuleBuilder.build();
    }

    public static final /* synthetic */ <T> void contextual(SerializersModuleBuilder serializersModuleBuilder, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(serializersModuleBuilder, "<this>");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        serializersModuleBuilder.contextual(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    public static /* synthetic */ void polymorphic$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KSerializer kSerializer, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            kSerializer = null;
        }
        if ((i & 4) != 0) {
            function1 = SerializersModuleBuildersKt$polymorphic$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(serializersModuleBuilder, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(kClass, kSerializer);
        function1.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
    }

    public static final <Base> void polymorphic(SerializersModuleBuilder serializersModuleBuilder, KClass<Base> kClass, KSerializer<Base> kSerializer, Function1<? super PolymorphicModuleBuilder<? super Base>, Unit> function1) {
        Intrinsics.checkNotNullParameter(serializersModuleBuilder, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(kClass, kSerializer);
        function1.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
    }

    public static final <T> SerializersModule serializersModuleOf(KClass<T> kClass, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        serializersModuleBuilder.contextual(kClass, kSerializer);
        return serializersModuleBuilder.build();
    }
}
