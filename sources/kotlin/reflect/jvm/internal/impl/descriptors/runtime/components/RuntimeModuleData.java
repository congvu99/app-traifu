package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.text.Typography;

/* compiled from: RuntimeModuleData.kt */
public final class RuntimeModuleData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeserializationComponents deserialization;
    private final PackagePartScopeCache packagePartScopeCache;

    private RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache2) {
        this.deserialization = deserializationComponents;
        this.packagePartScopeCache = packagePartScopeCache2;
    }

    public /* synthetic */ RuntimeModuleData(DeserializationComponents deserializationComponents, PackagePartScopeCache packagePartScopeCache2, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationComponents, packagePartScopeCache2);
    }

    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.packagePartScopeCache;
    }

    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    /* compiled from: RuntimeModuleData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            ClassLoader classLoader2 = classLoader;
            Intrinsics.checkNotNullParameter(classLoader2, "classLoader");
            StorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special("<runtime module for " + classLoader2 + Typography.greater);
            Intrinsics.checkNotNullExpressionValue(special, "Name.special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, (TargetPlatform) null, (Map) null, (Name) null, 56, (DefaultConstructorMarker) null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            ModuleDescriptor moduleDescriptor = moduleDescriptorImpl;
            jvmBuiltIns.initialize(moduleDescriptor, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader2);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptor);
            KotlinClassFinder kotlinClassFinder = reflectKotlinClassFinder;
            NotFoundClasses notFoundClasses2 = notFoundClasses;
            ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            StorageManager storageManager = lockBasedStorageManager;
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider$default = RuntimeModuleDataKt.makeLazyJavaPackageFragmentFromClassLoaderProvider$default(classLoader2, moduleDescriptor, lockBasedStorageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, singleModuleClassResolver, (PackagePartProvider) null, 128, (Object) null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = RuntimeModuleDataKt.makeDeserializationComponentsForJava(moduleDescriptor, storageManager, notFoundClasses2, makeLazyJavaPackageFragmentFromClassLoaderProvider$default, kotlinClassFinder, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(javaResolverCache, "JavaResolverCache.EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentFromClassLoaderProvider$default, javaResolverCache);
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            ClassLoader classLoader3 = Unit.class.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader3, "stdlibClassLoader");
            StorageManager storageManager2 = storageManager;
            DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
            StorageManager storageManager3 = storageManager2;
            ReflectKotlinClassFinder reflectKotlinClassFinder2 = reflectKotlinClassFinder;
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(storageManager3, new ReflectKotlinClassFinder(classLoader3), moduleDescriptor, notFoundClasses2, jvmBuiltIns.getSettings(), jvmBuiltIns.getSettings(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(storageManager2, CollectionsKt.emptyList()));
            ModuleDescriptorImpl moduleDescriptorImpl3 = moduleDescriptorImpl2;
            moduleDescriptorImpl3.setDependencies(moduleDescriptorImpl3);
            moduleDescriptorImpl3.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider)));
            return new RuntimeModuleData(makeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver2, reflectKotlinClassFinder2), (DefaultConstructorMarker) null);
        }
    }
}
