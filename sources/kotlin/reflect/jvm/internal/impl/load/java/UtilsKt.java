package kotlin.reflect.jvm.internal.impl.load.java;

/* compiled from: utils.kt */
public final class UtilsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00be, code lost:
        if (kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4) != false) goto L_0x00c2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue lexicalCastFrom(kotlin.reflect.jvm.internal.impl.types.KotlinType r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "$this$lexicalCastFrom"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r0 = r0.getDeclarationDescriptor()
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            r2 = 0
            if (r1 == 0) goto L_0x004c
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r1 = r0.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS
            if (r1 != r3) goto L_0x004c
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r4 = r0.getUnsubstitutedInnerClassesScope()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r5)
            java.lang.String r0 = "Name.identifier(value)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r0 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BACKEND
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r0 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r0
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getContributedClassifier(r5, r0)
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x0049
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r4.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY
            if (r5 != r0) goto L_0x0049
            kotlin.reflect.jvm.internal.impl.load.java.EnumEntry r2 = new kotlin.reflect.jvm.internal.impl.load.java.EnumEntry
            r2.<init>(r4)
        L_0x0049:
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue r2 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue) r2
            return r2
        L_0x004c:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.makeNotNullable(r4)
            kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix r0 = kotlin.reflect.jvm.internal.impl.utils.NumbersKt.extractRadix(r5)
            java.lang.String r1 = r0.component1()
            int r0 = r0.component2()
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBoolean(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x006b
            boolean r4 = java.lang.Boolean.parseBoolean(r5)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x006b:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isChar(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x0078
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ IllegalArgumentException -> 0x00c1 }
            java.lang.Character r5 = kotlin.text.StringsKt.singleOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x0078:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isByte(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x0083
            java.lang.Byte r5 = kotlin.text.StringsKt.toByteOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x0083:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isShort(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x008e
            java.lang.Short r5 = kotlin.text.StringsKt.toShortOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x008e:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isInt(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x0099
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x0099:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isLong(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r3 == 0) goto L_0x00a4
            java.lang.Long r5 = kotlin.text.StringsKt.toLongOrNull(r1, r0)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x00a4:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isFloat(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r0 == 0) goto L_0x00af
            java.lang.Float r5 = kotlin.text.StringsKt.toFloatOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x00af:
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDouble(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r0 == 0) goto L_0x00ba
            java.lang.Double r5 = kotlin.text.StringsKt.toDoubleOrNull(r5)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            goto L_0x00c2
        L_0x00ba:
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isString(r4)     // Catch:{ IllegalArgumentException -> 0x00c1 }
            if (r4 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r5 = r2
        L_0x00c2:
            if (r5 == 0) goto L_0x00c9
            kotlin.reflect.jvm.internal.impl.load.java.Constant r2 = new kotlin.reflect.jvm.internal.impl.load.java.Constant
            r2.<init>(r5)
        L_0x00c9:
            kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue r2 = (kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.UtilsKt.lexicalCastFrom(kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.String):kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultValue");
    }
}
