package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* compiled from: ClassicTypeCheckerContext.kt */
public class ClassicTypeCheckerContext extends AbstractTypeCheckerContext implements ClassicTypeSystemContext {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean allowedTypeVariable;
    private final boolean errorTypeEqualsToAnything;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final boolean stubTypeEqualsToAnything;

    public int argumentsCount(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$argumentsCount");
        return ClassicTypeSystemContext.DefaultImpls.argumentsCount(this, kotlinTypeMarker);
    }

    public TypeArgumentListMarker asArgumentList(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$asArgumentList");
        return ClassicTypeSystemContext.DefaultImpls.asArgumentList(this, simpleTypeMarker);
    }

    public CapturedTypeMarker asCapturedType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$asCapturedType");
        return ClassicTypeSystemContext.DefaultImpls.asCapturedType(this, simpleTypeMarker);
    }

    public DefinitelyNotNullTypeMarker asDefinitelyNotNullType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$asDefinitelyNotNullType");
        return ClassicTypeSystemContext.DefaultImpls.asDefinitelyNotNullType(this, simpleTypeMarker);
    }

    public DynamicTypeMarker asDynamicType(FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$this$asDynamicType");
        return ClassicTypeSystemContext.DefaultImpls.asDynamicType(this, flexibleTypeMarker);
    }

    public FlexibleTypeMarker asFlexibleType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$asFlexibleType");
        return ClassicTypeSystemContext.DefaultImpls.asFlexibleType(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker asSimpleType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$asSimpleType");
        return ClassicTypeSystemContext.DefaultImpls.asSimpleType(this, kotlinTypeMarker);
    }

    public TypeArgumentMarker asTypeArgument(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$asTypeArgument");
        return ClassicTypeSystemContext.DefaultImpls.asTypeArgument(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker captureFromArguments(SimpleTypeMarker simpleTypeMarker, CaptureStatus captureStatus) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
        Intrinsics.checkNotNullParameter(captureStatus, "status");
        return ClassicTypeSystemContext.DefaultImpls.captureFromArguments(this, simpleTypeMarker, captureStatus);
    }

    public List<SimpleTypeMarker> fastCorrespondingSupertypes(SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$fastCorrespondingSupertypes");
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "constructor");
        return ClassicTypeSystemContext.DefaultImpls.fastCorrespondingSupertypes(this, simpleTypeMarker, typeConstructorMarker);
    }

    public TypeArgumentMarker get(TypeArgumentListMarker typeArgumentListMarker, int i) {
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$this$get");
        return ClassicTypeSystemContext.DefaultImpls.get(this, typeArgumentListMarker, i);
    }

    public TypeArgumentMarker getArgument(KotlinTypeMarker kotlinTypeMarker, int i) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$getArgument");
        return ClassicTypeSystemContext.DefaultImpls.getArgument(this, kotlinTypeMarker, i);
    }

    public TypeArgumentMarker getArgumentOrNull(SimpleTypeMarker simpleTypeMarker, int i) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$getArgumentOrNull");
        return ClassicTypeSystemContext.DefaultImpls.getArgumentOrNull(this, simpleTypeMarker, i);
    }

    public FqNameUnsafe getClassFqNameUnsafe(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$getClassFqNameUnsafe");
        return ClassicTypeSystemContext.DefaultImpls.getClassFqNameUnsafe(this, typeConstructorMarker);
    }

    public TypeParameterMarker getParameter(TypeConstructorMarker typeConstructorMarker, int i) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$getParameter");
        return ClassicTypeSystemContext.DefaultImpls.getParameter(this, typeConstructorMarker, i);
    }

    public PrimitiveType getPrimitiveArrayType(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$getPrimitiveArrayType");
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveArrayType(this, typeConstructorMarker);
    }

    public PrimitiveType getPrimitiveType(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$getPrimitiveType");
        return ClassicTypeSystemContext.DefaultImpls.getPrimitiveType(this, typeConstructorMarker);
    }

    public KotlinTypeMarker getRepresentativeUpperBound(TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(typeParameterMarker, "$this$getRepresentativeUpperBound");
        return ClassicTypeSystemContext.DefaultImpls.getRepresentativeUpperBound(this, typeParameterMarker);
    }

    public KotlinTypeMarker getSubstitutedUnderlyingType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$getSubstitutedUnderlyingType");
        return ClassicTypeSystemContext.DefaultImpls.getSubstitutedUnderlyingType(this, kotlinTypeMarker);
    }

    public KotlinTypeMarker getType(TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "$this$getType");
        return ClassicTypeSystemContext.DefaultImpls.getType(this, typeArgumentMarker);
    }

    public TypeParameterMarker getTypeParameterClassifier(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$getTypeParameterClassifier");
        return ClassicTypeSystemContext.DefaultImpls.getTypeParameterClassifier(this, typeConstructorMarker);
    }

    public TypeVariance getVariance(TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "$this$getVariance");
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeArgumentMarker);
    }

    public TypeVariance getVariance(TypeParameterMarker typeParameterMarker) {
        Intrinsics.checkNotNullParameter(typeParameterMarker, "$this$getVariance");
        return ClassicTypeSystemContext.DefaultImpls.getVariance((ClassicTypeSystemContext) this, typeParameterMarker);
    }

    public boolean hasAnnotation(KotlinTypeMarker kotlinTypeMarker, FqName fqName) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$hasAnnotation");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return ClassicTypeSystemContext.DefaultImpls.hasAnnotation(this, kotlinTypeMarker, fqName);
    }

    public boolean hasFlexibleNullability(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$hasFlexibleNullability");
        return ClassicTypeSystemContext.DefaultImpls.hasFlexibleNullability(this, kotlinTypeMarker);
    }

    public boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "a");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "b");
        return ClassicTypeSystemContext.DefaultImpls.identicalArguments(this, simpleTypeMarker, simpleTypeMarker2);
    }

    public KotlinTypeMarker intersectTypes(List<? extends KotlinTypeMarker> list) {
        Intrinsics.checkNotNullParameter(list, "types");
        return ClassicTypeSystemContext.DefaultImpls.intersectTypes(this, list);
    }

    public boolean isAnyConstructor(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isAnyConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isAnyConstructor(this, typeConstructorMarker);
    }

    public boolean isClassType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isClassType");
        return ClassicTypeSystemContext.DefaultImpls.isClassType(this, simpleTypeMarker);
    }

    public boolean isClassTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isClassTypeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isClassTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isCommonFinalClassConstructor(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isCommonFinalClassConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isCommonFinalClassConstructor(this, typeConstructorMarker);
    }

    public boolean isDefinitelyNotNullType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isDefinitelyNotNullType");
        return ClassicTypeSystemContext.DefaultImpls.isDefinitelyNotNullType(this, kotlinTypeMarker);
    }

    public boolean isDenotable(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isDenotable");
        return ClassicTypeSystemContext.DefaultImpls.isDenotable(this, typeConstructorMarker);
    }

    public boolean isDynamic(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isDynamic");
        return ClassicTypeSystemContext.DefaultImpls.isDynamic(this, kotlinTypeMarker);
    }

    public boolean isEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "c1");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "c2");
        return ClassicTypeSystemContext.DefaultImpls.isEqualTypeConstructors(this, typeConstructorMarker, typeConstructorMarker2);
    }

    public boolean isError(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isError");
        return ClassicTypeSystemContext.DefaultImpls.isError(this, kotlinTypeMarker);
    }

    public boolean isInlineClass(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isInlineClass");
        return ClassicTypeSystemContext.DefaultImpls.isInlineClass(this, typeConstructorMarker);
    }

    public boolean isIntegerLiteralType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isIntegerLiteralType");
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralType(this, simpleTypeMarker);
    }

    public boolean isIntegerLiteralTypeConstructor(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isIntegerLiteralTypeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isIntegerLiteralTypeConstructor(this, typeConstructorMarker);
    }

    public boolean isIntersection(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isIntersection");
        return ClassicTypeSystemContext.DefaultImpls.isIntersection(this, typeConstructorMarker);
    }

    public boolean isMarkedNullable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isMarkedNullable");
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable((ClassicTypeSystemContext) this, kotlinTypeMarker);
    }

    public boolean isMarkedNullable(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isMarkedNullable");
        return ClassicTypeSystemContext.DefaultImpls.isMarkedNullable((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    public boolean isNothing(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isNothing");
        return ClassicTypeSystemContext.DefaultImpls.isNothing(this, kotlinTypeMarker);
    }

    public boolean isNothingConstructor(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isNothingConstructor");
        return ClassicTypeSystemContext.DefaultImpls.isNothingConstructor(this, typeConstructorMarker);
    }

    public boolean isNullableType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isNullableType");
        return ClassicTypeSystemContext.DefaultImpls.isNullableType(this, kotlinTypeMarker);
    }

    public boolean isPrimitiveType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isPrimitiveType");
        return ClassicTypeSystemContext.DefaultImpls.isPrimitiveType(this, simpleTypeMarker);
    }

    public boolean isProjectionNotNull(CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "$this$isProjectionNotNull");
        return ClassicTypeSystemContext.DefaultImpls.isProjectionNotNull(this, capturedTypeMarker);
    }

    public boolean isSingleClassifierType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isSingleClassifierType");
        return ClassicTypeSystemContext.DefaultImpls.isSingleClassifierType(this, simpleTypeMarker);
    }

    public boolean isStarProjection(TypeArgumentMarker typeArgumentMarker) {
        Intrinsics.checkNotNullParameter(typeArgumentMarker, "$this$isStarProjection");
        return ClassicTypeSystemContext.DefaultImpls.isStarProjection(this, typeArgumentMarker);
    }

    public boolean isStubType(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$isStubType");
        return ClassicTypeSystemContext.DefaultImpls.isStubType(this, simpleTypeMarker);
    }

    public boolean isUnderKotlinPackage(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$isUnderKotlinPackage");
        return ClassicTypeSystemContext.DefaultImpls.isUnderKotlinPackage(this, typeConstructorMarker);
    }

    public SimpleTypeMarker lowerBound(FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$this$lowerBound");
        return ClassicTypeSystemContext.DefaultImpls.lowerBound(this, flexibleTypeMarker);
    }

    public SimpleTypeMarker lowerBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$lowerBoundIfFlexible");
        return ClassicTypeSystemContext.DefaultImpls.lowerBoundIfFlexible(this, kotlinTypeMarker);
    }

    public KotlinTypeMarker lowerType(CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "$this$lowerType");
        return ClassicTypeSystemContext.DefaultImpls.lowerType(this, capturedTypeMarker);
    }

    public KotlinTypeMarker makeNullable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$makeNullable");
        return ClassicTypeSystemContext.DefaultImpls.makeNullable(this, kotlinTypeMarker);
    }

    public int parametersCount(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$parametersCount");
        return ClassicTypeSystemContext.DefaultImpls.parametersCount(this, typeConstructorMarker);
    }

    public Collection<KotlinTypeMarker> possibleIntegerTypes(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$possibleIntegerTypes");
        return ClassicTypeSystemContext.DefaultImpls.possibleIntegerTypes(this, simpleTypeMarker);
    }

    public int size(TypeArgumentListMarker typeArgumentListMarker) {
        Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$this$size");
        return ClassicTypeSystemContext.DefaultImpls.size(this, typeArgumentListMarker);
    }

    public Collection<KotlinTypeMarker> supertypes(TypeConstructorMarker typeConstructorMarker) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "$this$supertypes");
        return ClassicTypeSystemContext.DefaultImpls.supertypes(this, typeConstructorMarker);
    }

    public TypeConstructorMarker typeConstructor(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$typeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, kotlinTypeMarker);
    }

    public TypeConstructorMarker typeConstructor(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$typeConstructor");
        return ClassicTypeSystemContext.DefaultImpls.typeConstructor((ClassicTypeSystemContext) this, simpleTypeMarker);
    }

    public SimpleTypeMarker upperBound(FlexibleTypeMarker flexibleTypeMarker) {
        Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$this$upperBound");
        return ClassicTypeSystemContext.DefaultImpls.upperBound(this, flexibleTypeMarker);
    }

    public SimpleTypeMarker upperBoundIfFlexible(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$upperBoundIfFlexible");
        return ClassicTypeSystemContext.DefaultImpls.upperBoundIfFlexible(this, kotlinTypeMarker);
    }

    public SimpleTypeMarker withNullability(SimpleTypeMarker simpleTypeMarker, boolean z) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "$this$withNullability");
        return ClassicTypeSystemContext.DefaultImpls.withNullability(this, simpleTypeMarker, z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassicTypeCheckerContext(boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? KotlinTypeRefiner.Default.INSTANCE : kotlinTypeRefiner2);
    }

    public ClassicTypeCheckerContext(boolean z, boolean z2, boolean z3, KotlinTypeRefiner kotlinTypeRefiner2) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        this.errorTypeEqualsToAnything = z;
        this.stubTypeEqualsToAnything = z2;
        this.allowedTypeVariable = z3;
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
    }

    public KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            return NewKotlinTypeChecker.Companion.getDefault().transformToNewType(((KotlinType) kotlinTypeMarker).unwrap());
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(kotlinTypeMarker).toString());
    }

    public KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        if (kotlinTypeMarker instanceof KotlinType) {
            return this.kotlinTypeRefiner.refineType((KotlinType) kotlinTypeMarker);
        }
        throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(kotlinTypeMarker).toString());
    }

    public boolean isErrorTypeEqualsToAnything() {
        return this.errorTypeEqualsToAnything;
    }

    public boolean isStubTypeEqualsToAnything() {
        return this.stubTypeEqualsToAnything;
    }

    public boolean areEqualTypeConstructors(TypeConstructorMarker typeConstructorMarker, TypeConstructorMarker typeConstructorMarker2) {
        Intrinsics.checkNotNullParameter(typeConstructorMarker, "a");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "b");
        if (!(typeConstructorMarker instanceof TypeConstructor)) {
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(typeConstructorMarker).toString());
        } else if (typeConstructorMarker2 instanceof TypeConstructor) {
            return areEqualTypeConstructors((TypeConstructor) typeConstructorMarker, (TypeConstructor) typeConstructorMarker2);
        } else {
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(typeConstructorMarker2).toString());
        }
    }

    public boolean areEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics.checkNotNullParameter(typeConstructor, "a");
        Intrinsics.checkNotNullParameter(typeConstructor2, "b");
        if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor).checkConstructor(typeConstructor2);
        }
        if (typeConstructor2 instanceof IntegerLiteralTypeConstructor) {
            return ((IntegerLiteralTypeConstructor) typeConstructor2).checkConstructor(typeConstructor);
        }
        return Intrinsics.areEqual((Object) typeConstructor, (Object) typeConstructor2);
    }

    public AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform substitutionSupertypePolicy(SimpleTypeMarker simpleTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
        return Companion.classicSubstitutionSupertypePolicy(this, simpleTypeMarker);
    }

    public boolean isAllowedTypeVariable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$this$isAllowedTypeVariable");
        return (kotlinTypeMarker instanceof UnwrappedType) && this.allowedTypeVariable && (((UnwrappedType) kotlinTypeMarker).getConstructor() instanceof NewTypeVariableConstructor);
    }

    /* compiled from: ClassicTypeCheckerContext.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform classicSubstitutionSupertypePolicy(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(classicTypeSystemContext, "$this$classicSubstitutionSupertypePolicy");
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
            if (simpleTypeMarker instanceof SimpleType) {
                return new ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2(classicTypeSystemContext, TypeConstructorSubstitution.Companion.create((KotlinType) simpleTypeMarker).buildSubstitutor());
            }
            throw new IllegalArgumentException(ClassicTypeCheckerContextKt.errorMessage(simpleTypeMarker).toString());
        }
    }
}
