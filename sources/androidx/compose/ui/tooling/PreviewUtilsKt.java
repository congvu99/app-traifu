package androidx.compose.ui.tooling;

import android.util.Log;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001a\u001a\u0010\t\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004*\u00020\nH\u0000\u001a)\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"getPreviewProviderParameters", "", "", "parameterProviderClass", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "asPreviewProviderClass", "", "toArray", "Lkotlin/sequences/Sequence;", "size", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewUtils.kt */
public final class PreviewUtilsKt {
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Class<?> cls = Class.forName(str);
            if (cls instanceof Class) {
                return cls;
            }
            return null;
        } catch (ClassNotFoundException e) {
            Log.e("PreviewProvider", "Unable to find provider '" + str + '\'', e);
            return null;
        }
    }

    public static final Object[] getPreviewProviderParameters(Class<? extends PreviewParameterProvider<?>> cls, int i) {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor[] constructors = cls.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "parameterProviderClass.constructors");
            Object[] objArr = (Object[]) constructors;
            int length = objArr.length;
            Constructor constructor = null;
            Constructor constructor2 = null;
            int i2 = 0;
            boolean z = false;
            while (true) {
                if (i2 < length) {
                    Object obj = objArr[i2];
                    Class[] parameterTypes = ((Constructor) obj).getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (((Object[]) parameterTypes).length == 0) {
                        if (z) {
                            break;
                        }
                        constructor2 = obj;
                        z = true;
                    }
                    i2++;
                } else if (z) {
                    constructor = constructor2;
                }
            }
            Constructor constructor3 = constructor;
            if (constructor3 != null) {
                constructor3.setAccessible(true);
                Object newInstance = constructor3.newInstance(new Object[0]);
                if (newInstance != null) {
                    PreviewParameterProvider previewParameterProvider = (PreviewParameterProvider) newInstance;
                    if (i < 0) {
                        return toArray(previewParameterProvider.getValues(), previewParameterProvider.getCount());
                    }
                    return new Object[]{SequencesKt.elementAt(previewParameterProvider.getValues(), i)};
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            }
            throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
        } catch (KotlinReflectionNotSupportedError unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int i) {
        Iterator<? extends Object> it = sequence.iterator();
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = it.next();
        }
        return objArr;
    }
}
