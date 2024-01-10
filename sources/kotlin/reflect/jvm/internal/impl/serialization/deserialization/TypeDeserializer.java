package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer {
    /* access modifiers changed from: private */
    public final DeserializationContext c;
    private final Function1<Integer, ClassifierDescriptor> classifierDescriptors;
    private final String containerPresentableName;
    private final String debugName;
    private boolean experimentalSuspendFunctionTypeEncountered;
    private final TypeDeserializer parent;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;

    public TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> list, String str, String str2, boolean z) {
        Map<Integer, TypeParameterDescriptor> map;
        Intrinsics.checkNotNullParameter(deserializationContext, "c");
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics.checkNotNullParameter(str, "debugName");
        Intrinsics.checkNotNullParameter(str2, "containerPresentableName");
        this.c = deserializationContext;
        this.parent = typeDeserializer;
        this.debugName = str;
        this.containerPresentableName = str2;
        this.experimentalSuspendFunctionTypeEncountered = z;
        this.classifierDescriptors = deserializationContext.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$classifierDescriptors$1(this));
        this.typeAliasDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            map = MapsKt.emptyMap();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (ProtoBuf.TypeParameter typeParameter : list) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.c, typeParameter, i));
                i++;
            }
            map = linkedHashMap;
        }
        this.typeParameterDescriptors = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeDeserializer(DeserializationContext deserializationContext, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deserializationContext, typeDeserializer, list, str, str2, (i & 32) != 0 ? false : z);
    }

    public final boolean getExperimentalSuspendFunctionTypeEncountered() {
        return this.experimentalSuspendFunctionTypeEncountered;
    }

    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return CollectionsKt.toList(this.typeParameterDescriptors.values());
    }

    public final KotlinType type(ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "proto");
        if (!type.hasFlexibleTypeCapabilitiesId()) {
            return simpleType(type, true);
        }
        String string = this.c.getNameResolver().getString(type.getFlexibleTypeCapabilitiesId());
        SimpleType simpleType$default = simpleType$default(this, type, false, 2, (Object) null);
        ProtoBuf.Type flexibleUpperBound = ProtoTypeTableUtilKt.flexibleUpperBound(type, this.c.getTypeTable());
        Intrinsics.checkNotNull(flexibleUpperBound);
        return this.c.getComponents().getFlexibleTypeDeserializer().create(type, string, simpleType$default, simpleType$default(this, flexibleUpperBound, false, 2, (Object) null));
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return typeDeserializer.simpleType(type, z);
    }

    public final SimpleType simpleType(ProtoBuf.Type type, boolean z) {
        SimpleType simpleType;
        SimpleType simpleType2;
        SimpleType withAbbreviation;
        Intrinsics.checkNotNullParameter(type, "proto");
        if (type.hasClassName()) {
            simpleType = computeLocalClassifierReplacementType(type.getClassName());
        } else {
            simpleType = type.hasTypeAliasName() ? computeLocalClassifierReplacementType(type.getTypeAliasName()) : null;
        }
        if (simpleType != null) {
            return simpleType;
        }
        TypeConstructor typeConstructor = typeConstructor(type);
        if (ErrorUtils.isError(typeConstructor.getDeclarationDescriptor())) {
            SimpleType createErrorTypeWithCustomConstructor = ErrorUtils.createErrorTypeWithCustomConstructor(typeConstructor.toString(), typeConstructor);
            Intrinsics.checkNotNullExpressionValue(createErrorTypeWithCustomConstructor, "ErrorUtils.createErrorTy….toString(), constructor)");
            return createErrorTypeWithCustomConstructor;
        }
        DeserializedAnnotations deserializedAnnotations = new DeserializedAnnotations(this.c.getStorageManager(), new TypeDeserializer$simpleType$annotations$1(this, type));
        Iterable invoke = new TypeDeserializer$simpleType$1(this).invoke(type);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(invoke, 10));
        int i = 0;
        for (Object next : invoke) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
            arrayList.add(typeArgument((TypeParameterDescriptor) CollectionsKt.getOrNull(parameters, i), (ProtoBuf.Type.Argument) next));
            i = i2;
        }
        List list = CollectionsKt.toList((List) arrayList);
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (!z || !(declarationDescriptor instanceof TypeAliasDescriptor)) {
            Boolean bool = Flags.SUSPEND_TYPE.get(type.getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "Flags.SUSPEND_TYPE.get(proto.flags)");
            if (bool.booleanValue()) {
                simpleType2 = createSuspendFunctionType(deserializedAnnotations, typeConstructor, list, type.getNullable());
            } else {
                simpleType2 = KotlinTypeFactory.simpleType$default(deserializedAnnotations, typeConstructor, list, type.getNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
            }
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType computeExpandedType = KotlinTypeFactory.computeExpandedType((TypeAliasDescriptor) declarationDescriptor, list);
            simpleType2 = computeExpandedType.makeNullableAsSpecified(KotlinTypeKt.isNullable(computeExpandedType) || type.getNullable()).replaceAnnotations(Annotations.Companion.create(CollectionsKt.plus(deserializedAnnotations, (DeserializedAnnotations) computeExpandedType.getAnnotations())));
        }
        ProtoBuf.Type abbreviatedType = ProtoTypeTableUtilKt.abbreviatedType(type, this.c.getTypeTable());
        if (!(abbreviatedType == null || (withAbbreviation = SpecialTypesKt.withAbbreviation(simpleType2, simpleType(abbreviatedType, false))) == null)) {
            simpleType2 = withAbbreviation;
        }
        if (!type.hasClassName()) {
            return simpleType2;
        }
        return this.c.getComponents().getPlatformDependentTypeTransformer().transformPlatformType(NameResolverUtilKt.getClassId(this.c.getNameResolver(), type.getClassName()), simpleType2);
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type type) {
        Object obj;
        TypeConstructor typeConstructor;
        TypeConstructor typeConstructor2;
        TypeDeserializer$typeConstructor$1 typeDeserializer$typeConstructor$1 = new TypeDeserializer$typeConstructor$1(this, type);
        if (type.hasClassName()) {
            ClassifierDescriptor invoke = this.classifierDescriptors.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = typeDeserializer$typeConstructor$1.invoke(type.getClassName());
            }
            TypeConstructor typeConstructor3 = invoke.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor3, "(classifierDescriptors(p…assName)).typeConstructor");
            return typeConstructor3;
        } else if (type.hasTypeParameter()) {
            TypeConstructor typeParameterTypeConstructor = typeParameterTypeConstructor(type.getTypeParameter());
            if (typeParameterTypeConstructor != null) {
                return typeParameterTypeConstructor;
            }
            TypeConstructor createErrorTypeConstructor = ErrorUtils.createErrorTypeConstructor("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.containerPresentableName + '\"');
            Intrinsics.checkNotNullExpressionValue(createErrorTypeConstructor, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
            return createErrorTypeConstructor;
        } else if (type.hasTypeParameterName()) {
            DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
            String string = this.c.getNameResolver().getString(type.getTypeParameterName());
            Iterator it = getOwnTypeParameters().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((TypeParameterDescriptor) obj).getName().asString(), (Object) string)) {
                    break;
                }
            }
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) obj;
            if (typeParameterDescriptor == null || (typeConstructor2 = typeParameterDescriptor.getTypeConstructor()) == null) {
                typeConstructor = ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + string + " in " + containingDeclaration);
            } else {
                typeConstructor = typeConstructor2;
            }
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "parameter?.typeConstruct…ter $name in $container\")");
            return typeConstructor;
        } else if (type.hasTypeAliasName()) {
            ClassifierDescriptor invoke2 = this.typeAliasDescriptors.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke2 == null) {
                invoke2 = typeDeserializer$typeConstructor$1.invoke(type.getTypeAliasName());
            }
            TypeConstructor typeConstructor4 = invoke2.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor4, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
            return typeConstructor4;
        } else {
            TypeConstructor createErrorTypeConstructor2 = ErrorUtils.createErrorTypeConstructor("Unknown type");
            Intrinsics.checkNotNullExpressionValue(createErrorTypeConstructor2, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
            return createErrorTypeConstructor2;
        }
    }

    private final SimpleType createSuspendFunctionType(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        int size;
        int size2 = typeConstructor.getParameters().size() - list.size();
        SimpleType simpleType = null;
        if (size2 == 0) {
            simpleType = createSuspendFunctionTypeForBasicCase(annotations, typeConstructor, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            ClassDescriptor suspendFunction = typeConstructor.getBuiltIns().getSuspendFunction(size);
            Intrinsics.checkNotNullExpressionValue(suspendFunction, "functionTypeConstructor.…getSuspendFunction(arity)");
            TypeConstructor typeConstructor2 = suspendFunction.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor2, "functionTypeConstructor.…on(arity).typeConstructor");
            simpleType = KotlinTypeFactory.simpleType$default(annotations, typeConstructor2, list, z, (KotlinTypeRefiner) null, 16, (Object) null);
        }
        if (simpleType != null) {
            return simpleType;
        }
        SimpleType createErrorTypeWithArguments = ErrorUtils.createErrorTypeWithArguments("Bad suspend function in metadata with constructor: " + typeConstructor, list);
        Intrinsics.checkNotNullExpressionValue(createErrorTypeWithArguments, "ErrorUtils.createErrorTy…      arguments\n        )");
        return createErrorTypeWithArguments;
    }

    private final SimpleType createSuspendFunctionTypeForBasicCase(Annotations annotations, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        KotlinType simpleType$default = KotlinTypeFactory.simpleType$default(annotations, typeConstructor, list, z, (KotlinTypeRefiner) null, 16, (Object) null);
        if (!FunctionTypesKt.isFunctionType(simpleType$default)) {
            return null;
        }
        return transformRuntimeFunctionTypeToSuspendFunction(simpleType$default);
    }

    private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType kotlinType) {
        KotlinType type;
        boolean releaseCoroutines = this.c.getComponents().getConfiguration().getReleaseCoroutines();
        TypeProjection typeProjection = (TypeProjection) CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType));
        FqName fqName = null;
        if (typeProjection == null || (type = typeProjection.getType()) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(type, "funType.getValueParamete…ll()?.type ?: return null");
        ClassifierDescriptor declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
        FqName fqNameSafe = declarationDescriptor != null ? DescriptorUtilsKt.getFqNameSafe(declarationDescriptor) : null;
        boolean z = true;
        if (type.getArguments().size() != 1 || (!SuspendFunctionTypesKt.isContinuation(fqNameSafe, true) && !SuspendFunctionTypesKt.isContinuation(fqNameSafe, false))) {
            return (SimpleType) kotlinType;
        }
        KotlinType type2 = ((TypeProjection) CollectionsKt.single(type.getArguments())).getType();
        Intrinsics.checkNotNullExpressionValue(type2, "continuationArgumentType.arguments.single().type");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableDescriptor)) {
            containingDeclaration = null;
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        if (callableDescriptor != null) {
            fqName = DescriptorUtilsKt.fqNameOrNull(callableDescriptor);
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return createSimpleSuspendFunctionType(kotlinType, type2);
        }
        if (!this.experimentalSuspendFunctionTypeEncountered && (!releaseCoroutines || !SuspendFunctionTypesKt.isContinuation(fqNameSafe, !releaseCoroutines))) {
            z = false;
        }
        this.experimentalSuspendFunctionTypeEncountered = z;
        return createSimpleSuspendFunctionType(kotlinType, type2);
    }

    private final SimpleType createSimpleSuspendFunctionType(KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinBuiltIns builtIns = TypeUtilsKt.getBuiltIns(kotlinType);
        Annotations annotations = kotlinType.getAnnotations();
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        Iterable<TypeProjection> dropLast = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType), 1);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dropLast, 10));
        for (TypeProjection type : dropLast) {
            arrayList.add(type.getType());
        }
        return FunctionTypesKt.createFunctionType(builtIns, annotations, receiverTypeFromFunctionType, (List) arrayList, (List<Name>) null, kotlinType2, true).makeNullableAsSpecified(kotlinType.isMarkedNullable());
    }

    private final TypeConstructor typeParameterTypeConstructor(int i) {
        TypeConstructor typeConstructor;
        TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptors.get(Integer.valueOf(i));
        if (typeParameterDescriptor != null && (typeConstructor = typeParameterDescriptor.getTypeConstructor()) != null) {
            return typeConstructor;
        }
        TypeDeserializer typeDeserializer = this.parent;
        if (typeDeserializer != null) {
            return typeDeserializer.typeParameterTypeConstructor(i);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor computeClassifierDescriptor(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return this.c.getComponents().deserializeClass(classId);
        }
        return FindClassInModuleKt.findClassifierAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int i) {
        if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), i).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final ClassifierDescriptor computeTypeAliasDescriptor(int i) {
        ClassId classId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), i);
        if (classId.isLocal()) {
            return null;
        }
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), classId);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor typeParameterDescriptor, ProtoBuf.Type.Argument argument) {
        TypeProjectionBase typeProjectionBase;
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (typeParameterDescriptor == null) {
                typeProjectionBase = new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
            } else {
                typeProjectionBase = new StarProjectionImpl(typeParameterDescriptor);
            }
            return typeProjectionBase;
        }
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "typeArgumentProto.projection");
        Variance variance = protoEnumFlags.variance(projection);
        ProtoBuf.Type type = ProtoTypeTableUtilKt.type(argument, this.c.getTypeTable());
        if (type != null) {
            return new TypeProjectionImpl(variance, type(type));
        }
        return new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded"));
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.debugName);
        if (this.parent == null) {
            str = "";
        } else {
            str = ". Child of " + this.parent.debugName;
        }
        sb.append(str);
        return sb.toString();
    }
}
