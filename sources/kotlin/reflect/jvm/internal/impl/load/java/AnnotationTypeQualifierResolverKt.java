package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.NullabilityQualifierWithApplicability;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolverKt {
    private static final Map<FqName, NullabilityQualifierWithApplicability> BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS = MapsKt.mapOf(TuplesKt.to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new NullabilityQualifierWithApplicability(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER))), TuplesKt.to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new NullabilityQualifierWithApplicability(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NOT_NULL, false, 2, (DefaultConstructorMarker) null), CollectionsKt.listOf(AnnotationTypeQualifierResolver.QualifierApplicabilityType.VALUE_PARAMETER))));
    private static final Set<FqName> BUILT_IN_TYPE_QUALIFIER_FQ_NAMES = SetsKt.setOf(JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION());
    private static final FqName MIGRATION_ANNOTATION_FQNAME = new FqName("kotlin.annotations.jvm.UnderMigration");
    private static final FqName TYPE_QUALIFIER_DEFAULT_FQNAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
    private static final FqName TYPE_QUALIFIER_FQNAME = new FqName("javax.annotation.meta.TypeQualifier");
    private static final FqName TYPE_QUALIFIER_NICKNAME_FQNAME = new FqName("javax.annotation.meta.TypeQualifierNickname");

    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return TYPE_QUALIFIER_NICKNAME_FQNAME;
    }

    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return TYPE_QUALIFIER_DEFAULT_FQNAME;
    }

    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return MIGRATION_ANNOTATION_FQNAME;
    }

    public static final Map<FqName, NullabilityQualifierWithApplicability> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS;
    }

    /* access modifiers changed from: private */
    public static final boolean isAnnotatedWithTypeQualifier(ClassDescriptor classDescriptor) {
        return BUILT_IN_TYPE_QUALIFIER_FQ_NAMES.contains(DescriptorUtilsKt.getFqNameSafe(classDescriptor)) || classDescriptor.getAnnotations().hasAnnotation(TYPE_QUALIFIER_FQNAME);
    }
}
