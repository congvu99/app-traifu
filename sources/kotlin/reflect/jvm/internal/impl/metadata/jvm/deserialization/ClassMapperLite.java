package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.JsonLexerKt;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    /* access modifiers changed from: private */

    /* renamed from: kotlin  reason: collision with root package name */
    public static final String f219kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    private static final Map<String, String> map;

    static {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        IntProgression step = RangesKt.step((IntProgression) CollectionsKt.getIndices(listOf), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                int i = first + 1;
                linkedHashMap.put(f219kotlin + '/' + ((String) listOf.get(first)), listOf.get(i));
                linkedHashMap.put(f219kotlin + '/' + ((String) listOf.get(first)) + "Array", JsonLexerKt.BEGIN_LIST + ((String) listOf.get(i)));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        linkedHashMap.put(f219kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        ClassMapperLite$map$1$1 classMapperLite$map$1$1 = new ClassMapperLite$map$1$1(linkedHashMap);
        classMapperLite$map$1$1.invoke("Any", "java/lang/Object");
        classMapperLite$map$1$1.invoke("Nothing", "java/lang/Void");
        classMapperLite$map$1$1.invoke("Annotation", "java/lang/annotation/Annotation");
        for (String str : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            classMapperLite$map$1$1.invoke(str, "java/lang/" + str);
        }
        for (String str2 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            classMapperLite$map$1$1.invoke("collections/" + str2, "java/util/" + str2);
            classMapperLite$map$1$1.invoke("collections/Mutable" + str2, "java/util/" + str2);
        }
        classMapperLite$map$1$1.invoke("collections/Iterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/MutableIterable", "java/lang/Iterable");
        classMapperLite$map$1$1.invoke("collections/Map.Entry", "java/util/Map$Entry");
        classMapperLite$map$1$1.invoke("collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i2 = 0; i2 <= 22; i2++) {
            classMapperLite$map$1$1.invoke("Function" + i2, f219kotlin + "/jvm/functions/Function" + i2);
            StringBuilder sb = new StringBuilder();
            sb.append("reflect/KFunction");
            sb.append(i2);
            classMapperLite$map$1$1.invoke(sb.toString(), f219kotlin + "/reflect/KFunction");
        }
        for (String str3 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            classMapperLite$map$1$1.invoke(str3 + ".Companion", f219kotlin + "/jvm/internal/" + str3 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return 'L' + StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null) + ';';
    }
}
