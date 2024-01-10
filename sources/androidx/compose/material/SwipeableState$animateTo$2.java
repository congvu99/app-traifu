package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$animateTo$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ AnimationSpec<Float> $anim;
    final /* synthetic */ T $targetValue;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$animateTo$2(T t, SwipeableState<T> swipeableState, AnimationSpec<Float> animationSpec) {
        this.$targetValue = t;
        this.this$0 = swipeableState;
        this.$anim = animationSpec;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.material.SwipeableState$animateTo$2$emit$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.material.SwipeableState$animateTo$2$emit$1 r0 = (androidx.compose.material.SwipeableState$animateTo$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SwipeableState$animateTo$2$emit$1 r0 = new androidx.compose.material.SwipeableState$animateTo$2$emit$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1056964608(0x3f000000, float:0.5)
            r5 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r5) goto L_0x0038
            java.lang.Object r9 = r0.L$1
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r0 = r0.L$0
            androidx.compose.material.SwipeableState$animateTo$2 r0 = (androidx.compose.material.SwipeableState$animateTo$2) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0035 }
            goto L_0x0061
        L_0x0035:
            r10 = move-exception
            goto L_0x00d8
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r10)
            T r10 = r8.$targetValue     // Catch:{ all -> 0x00d6 }
            java.lang.Float r10 = androidx.compose.material.SwipeableKt.getOffset(r9, r10)     // Catch:{ all -> 0x00d6 }
            if (r10 == 0) goto L_0x00ca
            androidx.compose.material.SwipeableState<T> r2 = r8.this$0     // Catch:{ all -> 0x00d6 }
            float r10 = r10.floatValue()     // Catch:{ all -> 0x00d6 }
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r6 = r8.$anim     // Catch:{ all -> 0x00d6 }
            r0.L$0 = r8     // Catch:{ all -> 0x00d6 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d6 }
            r0.label = r5     // Catch:{ all -> 0x00d6 }
            java.lang.Object r10 = r2.animateInternalToOffset(r10, r6, r0)     // Catch:{ all -> 0x00d6 }
            if (r10 != r1) goto L_0x0060
            return r1
        L_0x0060:
            r0 = r8
        L_0x0061:
            androidx.compose.material.SwipeableState<T> r10 = r0.this$0
            androidx.compose.runtime.MutableState r10 = r10.absoluteOffset
            java.lang.Object r10 = r10.getValue()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x007e:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00ae
            java.lang.Object r2 = r9.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r6 = r2.getKey()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r6 = r6 - r10
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x009f
            r6 = 1
            goto L_0x00a0
        L_0x009f:
            r6 = 0
        L_0x00a0:
            if (r6 == 0) goto L_0x007e
            java.lang.Object r6 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            r1.put(r6, r2)
            goto L_0x007e
        L_0x00ae:
            java.util.Map r1 = (java.util.Map) r1
            java.util.Collection r9 = r1.values()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            if (r9 != 0) goto L_0x00c2
            androidx.compose.material.SwipeableState<T> r9 = r0.this$0
            java.lang.Object r9 = r9.getCurrentValue()
        L_0x00c2:
            androidx.compose.material.SwipeableState<T> r10 = r0.this$0
            r10.setCurrentValue(r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x00ca:
            java.lang.String r10 = "The target value must have an associated anchor."
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d6 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00d6 }
            r0.<init>(r10)     // Catch:{ all -> 0x00d6 }
            throw r0     // Catch:{ all -> 0x00d6 }
        L_0x00d6:
            r10 = move-exception
            r0 = r8
        L_0x00d8:
            androidx.compose.material.SwipeableState<T> r1 = r0.this$0
            androidx.compose.runtime.MutableState r1 = r1.absoluteOffset
            java.lang.Object r1 = r1.getValue()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x00f5:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L_0x0125
            java.lang.Object r6 = r9.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            float r7 = r7 - r1
            float r7 = java.lang.Math.abs(r7)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0116
            r7 = 1
            goto L_0x0117
        L_0x0116:
            r7 = 0
        L_0x0117:
            if (r7 == 0) goto L_0x00f5
            java.lang.Object r7 = r6.getKey()
            java.lang.Object r6 = r6.getValue()
            r2.put(r7, r6)
            goto L_0x00f5
        L_0x0125:
            java.util.Map r2 = (java.util.Map) r2
            java.util.Collection r9 = r2.values()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r9 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            if (r9 != 0) goto L_0x0139
            androidx.compose.material.SwipeableState<T> r9 = r0.this$0
            java.lang.Object r9 = r9.getCurrentValue()
        L_0x0139:
            androidx.compose.material.SwipeableState<T> r0 = r0.this$0
            r0.setCurrentValue(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$animateTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
