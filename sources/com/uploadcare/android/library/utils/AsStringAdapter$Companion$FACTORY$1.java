package com.uploadcare.android.library.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032,\u0010\u0005\u001a(\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\b0\u00062\u000e\u0010\t\u001a\n \u0004*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "annotations", "", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "create"}, k = 3, mv = {1, 4, 0})
/* compiled from: AsStringAdapter.kt */
final class AsStringAdapter$Companion$FACTORY$1 implements JsonAdapter.Factory {
    public static final AsStringAdapter$Companion$FACTORY$1 INSTANCE = new AsStringAdapter$Companion$FACTORY$1();

    AsStringAdapter$Companion$FACTORY$1() {
    }

    public final JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        Set<? extends Annotation> nextAnnotations = Types.nextAnnotations(set, AsString.class);
        if (nextAnnotations == null || (!nextAnnotations.isEmpty())) {
            return null;
        }
        return new AsStringAdapter();
    }
}
