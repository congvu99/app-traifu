package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.sequences.SequencesKt;

/* compiled from: findClassInModule.kt */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findClassAcrossModuleDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof ClassDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (ClassDescriptor) findClassifierAcrossModuleDependencies;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findNonGenericClassAcrossDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "$this$findTypeAliasAcrossModuleDependencies");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (!(findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor)) {
            findClassifierAcrossModuleDependencies = null;
        }
        return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r10, kotlin.reflect.jvm.internal.impl.name.ClassId r11) {
        /*
            java.lang.String r0 = "$this$findClassifierAcrossModuleDependencies"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "classId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor$Capability r0 = kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt.getRESOLUTION_ANCHOR_PROVIDER_CAPABILITY()
            java.lang.Object r0 = r10.getCapability(r0)
            kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider r0 = (kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider) r0
            r1 = 0
            if (r0 == 0) goto L_0x001c
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r0 = r0.getResolutionAnchor(r10)
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            java.lang.String r2 = "name"
            r3 = 1
            java.lang.String r4 = "segments.first()"
            java.lang.String r5 = "classId.relativeClassName.pathSegments()"
            java.lang.String r6 = "classId.packageFqName"
            if (r0 != 0) goto L_0x0090
            kotlin.reflect.jvm.internal.impl.name.FqName r0 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r0)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r4 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r4 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r4)
            if (r10 == 0) goto L_0x0163
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r3, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0061:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00fa
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r3 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 != 0) goto L_0x0073
            goto L_0x0163
        L_0x0073:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r3 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 != 0) goto L_0x0089
            r10 = r1
        L_0x0089:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            if (r10 == 0) goto L_0x0163
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r10
            goto L_0x0061
        L_0x0090:
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r10.getPackage(r7)
            kotlin.reflect.jvm.internal.impl.name.FqName r7 = r11.getRelativeClassName()
            java.util.List r7 = r7.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r9 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r8, r9)
            if (r10 == 0) goto L_0x00f7
            int r8 = r7.size()
            java.util.List r7 = r7.subList(r3, r8)
            java.util.Iterator r7 = r7.iterator()
        L_0x00c9:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00f8
            java.lang.Object r8 = r7.next()
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            boolean r9 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r9 != 0) goto L_0x00da
            goto L_0x00f7
        L_0x00da:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r9 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r9 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r9
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r8, r9)
            boolean r8 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r8 != 0) goto L_0x00f0
            r10 = r1
        L_0x00f0:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            if (r10 == 0) goto L_0x00f7
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r10
            goto L_0x00c9
        L_0x00f7:
            r10 = r1
        L_0x00f8:
            if (r10 == 0) goto L_0x00fc
        L_0x00fa:
            r1 = r10
            goto L_0x0163
        L_0x00fc:
            kotlin.reflect.jvm.internal.impl.name.FqName r10 = r11.getPackageFqName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor r10 = r0.getPackage(r10)
            kotlin.reflect.jvm.internal.impl.name.FqName r11 = r11.getRelativeClassName()
            java.util.List r11 = r11.pathSegments()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r5)
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getMemberScope()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r4 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r4 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r4)
            if (r10 == 0) goto L_0x0163
            int r0 = r11.size()
            java.util.List r11 = r11.subList(r3, r0)
            java.util.Iterator r11 = r11.iterator()
        L_0x0135:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x00fa
            java.lang.Object r0 = r11.next()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = (kotlin.reflect.jvm.internal.impl.name.Name) r0
            boolean r3 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 != 0) goto L_0x0146
            goto L_0x0163
        L_0x0146:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r10 = r10.getUnsubstitutedInnerClassesScope()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r3 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r3 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = r10.getContributedClassifier(r0, r3)
            boolean r0 = r10 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 != 0) goto L_0x015c
            r10 = r1
        L_0x015c:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r10
            if (r10 == 0) goto L_0x0163
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r10 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) r10
            goto L_0x0135
        L_0x0163:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId):kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor");
    }
}
