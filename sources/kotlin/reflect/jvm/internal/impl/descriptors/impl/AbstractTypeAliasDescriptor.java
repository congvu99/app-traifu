package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: AbstractTypeAliasDescriptor.kt */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    private final AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor = new AbstractTypeAliasDescriptor$typeConstructor$1(this);
    private final Visibility visibilityImpl;

    /* access modifiers changed from: protected */
    public abstract StorageManager getStorageManager();

    /* access modifiers changed from: protected */
    public abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    public boolean isActual() {
        return false;
    }

    public boolean isExpect() {
        return false;
    }

    public boolean isExternal() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement, Visibility visibility) {
        super(declarationDescriptor, annotations, name, sourceElement);
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics.checkNotNullParameter(visibility, "visibilityImpl");
        this.visibilityImpl = visibility;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, "declaredTypeParameters");
        this.declaredTypeParametersImpl = list;
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitTypeAliasDescriptor(this, d);
    }

    public boolean isInner() {
        return TypeUtils.contains(getUnderlyingType(), new AbstractTypeAliasDescriptor$isInner$1(this));
    }

    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "classDescriptor.constructors");
        Collection arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            Intrinsics.checkNotNullExpressionValue(classConstructorDescriptor, "it");
            TypeAliasConstructorDescriptor createIfAvailable = TypeAliasConstructorDescriptorImpl.Companion.createIfAvailable(getStorageManager(), this, classConstructorDescriptor);
            if (createIfAvailable != null) {
                arrayList.add(createIfAvailable);
            }
        }
        return (List) arrayList;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<? extends TypeParameterDescriptor> list = this.declaredTypeParametersImpl;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        }
        return list;
    }

    public Modality getModality() {
        return Modality.FINAL;
    }

    public Visibility getVisibility() {
        return this.visibilityImpl;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public String toString() {
        return "typealias " + getName().asString();
    }

    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource original = super.getOriginal();
        if (original != null) {
            return (TypeAliasDescriptor) original;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }

    /* access modifiers changed from: protected */
    public final SimpleType computeDefaultType() {
        MemberScope memberScope;
        ClassifierDescriptor classifierDescriptor = this;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null || (memberScope = classDescriptor.getUnsubstitutedMemberScope()) == null) {
            memberScope = MemberScope.Empty.INSTANCE;
        }
        SimpleType makeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(classifierDescriptor, memberScope, (Function1<KotlinTypeRefiner, SimpleType>) new AbstractTypeAliasDescriptor$computeDefaultType$1(this));
        Intrinsics.checkNotNullExpressionValue(makeUnsubstitutedType, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
        return makeUnsubstitutedType;
    }
}
