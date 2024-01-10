package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.animation.tooling.TransitionInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001UB\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010$\u001a\u00020\u0004J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u001c\u00101\u001a\b\u0012\u0004\u0012\u0002020&2\u0006\u0010(\u001a\u00020)2\u0006\u00103\u001a\u00020/J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H\u0015J\u0010\u00109\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H\u0015J\u000e\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020/J\u001a\u0010<\u001a\u00020\u00042\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020/0>J$\u0010?\u001a\u00020\u00042\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010B\u001a\u00020\u00042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010\fJ\u0016\u0010D\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u0001J\u001e\u0010F\u001a\u00020\u00042\u0006\u0010+\u001a\u00020)2\u0006\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u0001J&\u0010I\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u00030JR\u0006\u0012\u0002\b\u00030\f0&*\u0006\u0012\u0002\b\u00030\fH\u0002JB\u0010K\u001a\u000202\"\u0004\b\u0000\u0010L\"\b\b\u0001\u0010M*\u00020N\"\u0004\b\u0002\u0010O*\u0018\u0012\u0004\u0012\u0002HL\u0012\u0004\u0012\u0002HM0JR\b\u0012\u0004\u0012\u0002HO0\f2\b\b\u0002\u0010P\u001a\u00020/H\u0002J%\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070R*\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\bS\u0010TR\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000RG\u0010\n\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r0\u000bj\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r`\u000e8\u0000X\u0004ø\u0001\u0000¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R,\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR,\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u0015j\b\u0012\u0004\u0012\u00020\u001c`\u00178\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u001aRD\u0010\u001f\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020 0\u000bj\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020 `\u000e8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u000e\u0010#\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "setAnimationsTimeCallback", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "DEBUG", "", "TAG", "", "animatedVisibilityStates", "Ljava/util/HashMap;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState;", "Lkotlin/collections/HashMap;", "getAnimatedVisibilityStates$ui_tooling_release$annotations", "()V", "getAnimatedVisibilityStates$ui_tooling_release", "()Ljava/util/HashMap;", "animatedVisibilityStatesLock", "trackedAnimatedVisibility", "Ljava/util/HashSet;", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "Lkotlin/collections/HashSet;", "getTrackedAnimatedVisibility$ui_tooling_release$annotations", "getTrackedAnimatedVisibility$ui_tooling_release", "()Ljava/util/HashSet;", "trackedTransitions", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "getTrackedTransitions$ui_tooling_release$annotations", "getTrackedTransitions$ui_tooling_release", "transitionStates", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "getTransitionStates$ui_tooling_release$annotations", "getTransitionStates$ui_tooling_release", "transitionStatesLock", "dispose", "getAnimatedProperties", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "animation", "Landroidx/compose/animation/tooling/ComposeAnimation;", "getAnimatedVisibilityState", "composeAnimation", "getAnimatedVisibilityState-zrx7VqY", "(Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;)Ljava/lang/String;", "getMaxDuration", "", "getMaxDurationPerIteration", "getTransitions", "Landroidx/compose/animation/tooling/TransitionInfo;", "stepMillis", "millisToNanos", "timeMs", "nanosToMillis", "timeNs", "notifySubscribe", "notifyUnsubscribe", "setClockTime", "animationTimeMs", "setClockTimes", "animationTimeMillis", "", "trackAnimatedVisibility", "parent", "onSeek", "trackTransition", "transition", "updateAnimatedVisibilityState", "state", "updateFromAndToStates", "fromState", "toState", "allAnimations", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "createTransitionInfo", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "S", "stepMs", "toCurrentTargetPair", "Lkotlin/Pair;", "toCurrentTargetPair-RvB7uIg", "(Ljava/lang/String;)Lkotlin/Pair;", "TransitionState", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
public class PreviewAnimationClock {
    private final boolean DEBUG;
    private final String TAG;
    private final HashMap<Transition<Object>, AnimatedVisibilityState> animatedVisibilityStates;
    private final Object animatedVisibilityStatesLock;
    private final Function0<Unit> setAnimationsTimeCallback;
    private final HashSet<AnimatedVisibilityComposeAnimation> trackedAnimatedVisibility;
    private final HashSet<TransitionComposeAnimation> trackedTransitions;
    private final HashMap<Transition<Object>, TransitionState> transitionStates;
    private final Object transitionStatesLock;

    public PreviewAnimationClock() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getAnimatedVisibilityStates$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedAnimatedVisibility$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTrackedTransitions$ui_tooling_release$annotations() {
    }

    public static /* synthetic */ void getTransitionStates$ui_tooling_release$annotations() {
    }

    /* access modifiers changed from: private */
    public final long millisToNanos(long j) {
        return j * AnimationKt.MillisToNanos;
    }

    /* access modifiers changed from: protected */
    public void notifySubscribe(ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
    }

    /* access modifiers changed from: protected */
    public void notifyUnsubscribe(ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
    }

    public PreviewAnimationClock(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = function0;
        this.TAG = "PreviewAnimationClock";
        this.trackedTransitions = new HashSet<>();
        this.trackedAnimatedVisibility = new HashSet<>();
        this.transitionStates = new HashMap<>();
        this.transitionStatesLock = new Object();
        this.animatedVisibilityStates = new HashMap<>();
        this.animatedVisibilityStatesLock = new Object();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviewAnimationClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public final HashSet<TransitionComposeAnimation> getTrackedTransitions$ui_tooling_release() {
        return this.trackedTransitions;
    }

    public final HashSet<AnimatedVisibilityComposeAnimation> getTrackedAnimatedVisibility$ui_tooling_release() {
        return this.trackedAnimatedVisibility;
    }

    public final HashMap<Transition<Object>, TransitionState> getTransitionStates$ui_tooling_release() {
        return this.transitionStates;
    }

    public final HashMap<Transition<Object>, AnimatedVisibilityState> getAnimatedVisibilityStates$ui_tooling_release() {
        return this.animatedVisibilityStates;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r5.DEBUG == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        r0 = r5.TAG;
        android.util.Log.d(r0, "Transition " + r6 + " is now tracked");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
        r6 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parse(r6);
        r5.trackedTransitions.add(r6);
        notifySubscribe(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0076, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackTransition(androidx.compose.animation.core.Transition<java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "transition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r5.transitionStatesLock
            monitor-enter(r0)
            java.util.HashMap<androidx.compose.animation.core.Transition<java.lang.Object>, androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState> r1 = r5.transitionStates     // Catch:{ all -> 0x0077 }
            boolean r1 = r1.containsKey(r6)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0032
            boolean r1 = r5.DEBUG     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r5.TAG     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r2.<init>()     // Catch:{ all -> 0x0077 }
            java.lang.String r3 = "Transition "
            r2.append(r3)     // Catch:{ all -> 0x0077 }
            r2.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = " is already being tracked"
            r2.append(r6)     // Catch:{ all -> 0x0077 }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0077 }
            android.util.Log.d(r1, r6)     // Catch:{ all -> 0x0077 }
        L_0x0030:
            monitor-exit(r0)
            return
        L_0x0032:
            java.util.HashMap<androidx.compose.animation.core.Transition<java.lang.Object>, androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState> r1 = r5.transitionStates     // Catch:{ all -> 0x0077 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x0077 }
            androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState r2 = new androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState     // Catch:{ all -> 0x0077 }
            java.lang.Object r3 = r6.getCurrentState()     // Catch:{ all -> 0x0077 }
            java.lang.Object r4 = r6.getTargetState()     // Catch:{ all -> 0x0077 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0077 }
            r1.put(r6, r2)     // Catch:{ all -> 0x0077 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0077 }
            monitor-exit(r0)
            boolean r0 = r5.DEBUG
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = r5.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Transition "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " is now tracked"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x0068:
            androidx.compose.ui.tooling.animation.TransitionComposeAnimation r6 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parse(r6)
            java.util.HashSet<androidx.compose.ui.tooling.animation.TransitionComposeAnimation> r0 = r5.trackedTransitions
            r0.add(r6)
            androidx.compose.animation.tooling.ComposeAnimation r6 = (androidx.compose.animation.tooling.ComposeAnimation) r6
            r5.notifySubscribe(r6)
            return
        L_0x0077:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.trackTransition(androidx.compose.animation.core.Transition):void");
    }

    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = PreviewAnimationClock$trackAnimatedVisibility$1.INSTANCE;
            }
            previewAnimationClock.trackAnimatedVisibility(transition, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        if (r5.DEBUG == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        r0 = r5.TAG;
        android.util.Log.d(r0, "AnimatedVisibility transition " + r6 + " is now tracked");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        r0 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parseAnimatedVisibility(r6);
        r1 = r5.animatedVisibilityStates.get(r6);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = m4609toCurrentTargetPairRvB7uIg(r1.m4603unboximpl());
        r6.seek(java.lang.Boolean.valueOf(r1.component1().booleanValue()), java.lang.Boolean.valueOf(r1.component2().booleanValue()), 0);
        r7.invoke();
        r5.trackedAnimatedVisibility.add(r0);
        notifySubscribe(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c2, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackAnimatedVisibility(androidx.compose.animation.core.Transition<java.lang.Object> r6, kotlin.jvm.functions.Function0<kotlin.Unit> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "onSeek"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Object r0 = r5.animatedVisibilityStatesLock
            monitor-enter(r0)
            java.util.HashMap<androidx.compose.animation.core.Transition<java.lang.Object>, androidx.compose.ui.tooling.animation.AnimatedVisibilityState> r1 = r5.animatedVisibilityStates     // Catch:{ all -> 0x00c3 }
            boolean r1 = r1.containsKey(r6)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0037
            boolean r7 = r5.DEBUG     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x0035
            java.lang.String r7 = r5.TAG     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r1.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "AnimatedVisibility transition "
            r1.append(r2)     // Catch:{ all -> 0x00c3 }
            r1.append(r6)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = " is already being tracked"
            r1.append(r6)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00c3 }
            android.util.Log.d(r7, r6)     // Catch:{ all -> 0x00c3 }
        L_0x0035:
            monitor-exit(r0)
            return
        L_0x0037:
            java.util.HashMap<androidx.compose.animation.core.Transition<java.lang.Object>, androidx.compose.ui.tooling.animation.AnimatedVisibilityState> r1 = r5.animatedVisibilityStates     // Catch:{ all -> 0x00c3 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x00c3 }
            java.lang.Object r2 = r6.getCurrentState()     // Catch:{ all -> 0x00c3 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00c3 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x004e
            androidx.compose.ui.tooling.animation.AnimatedVisibilityState$Companion r2 = androidx.compose.ui.tooling.animation.AnimatedVisibilityState.Companion     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r2.m4605getExitq9NwIk0()     // Catch:{ all -> 0x00c3 }
            goto L_0x0054
        L_0x004e:
            androidx.compose.ui.tooling.animation.AnimatedVisibilityState$Companion r2 = androidx.compose.ui.tooling.animation.AnimatedVisibilityState.Companion     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r2.m4604getEnterq9NwIk0()     // Catch:{ all -> 0x00c3 }
        L_0x0054:
            androidx.compose.ui.tooling.animation.AnimatedVisibilityState r2 = androidx.compose.ui.tooling.animation.AnimatedVisibilityState.m4597boximpl(r2)     // Catch:{ all -> 0x00c3 }
            r1.put(r6, r2)     // Catch:{ all -> 0x00c3 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c3 }
            monitor-exit(r0)
            boolean r0 = r5.DEBUG
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = r5.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "AnimatedVisibility transition "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " is now tracked"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        L_0x007d:
            androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation r0 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parseAnimatedVisibility(r6)
            java.util.HashMap<androidx.compose.animation.core.Transition<java.lang.Object>, androidx.compose.ui.tooling.animation.AnimatedVisibilityState> r1 = r5.animatedVisibilityStates
            java.lang.Object r1 = r1.get(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            androidx.compose.ui.tooling.animation.AnimatedVisibilityState r1 = (androidx.compose.ui.tooling.animation.AnimatedVisibilityState) r1
            java.lang.String r1 = r1.m4603unboximpl()
            kotlin.Pair r1 = r5.m4609toCurrentTargetPairRvB7uIg(r1)
            java.lang.Object r2 = r1.component1()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.Object r1 = r1.component2()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r3 = 0
            r6.seek(r2, r1, r3)
            r7.invoke()
            java.util.HashSet<androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation> r6 = r5.trackedAnimatedVisibility
            r6.add(r0)
            androidx.compose.animation.tooling.ComposeAnimation r0 = (androidx.compose.animation.tooling.ComposeAnimation) r0
            r5.notifySubscribe(r0)
            return
        L_0x00c3:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.trackAnimatedVisibility(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function0):void");
    }

    public final void updateFromAndToStates(ComposeAnimation composeAnimation, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(obj, "fromState");
        Intrinsics.checkNotNullParameter(obj2, "toState");
        if (composeAnimation.getType() == ComposeAnimationType.TRANSITION_ANIMATION && CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            TransitionComposeAnimation transitionComposeAnimation = (TransitionComposeAnimation) composeAnimation;
            synchronized (this.transitionStatesLock) {
                this.transitionStates.put(transitionComposeAnimation.getAnimationObject(), new TransitionState(obj, obj2));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void updateAnimatedVisibilityState(AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation, Object obj) {
        Intrinsics.checkNotNullParameter(animatedVisibilityComposeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(obj, "state");
        if (this.trackedAnimatedVisibility.contains(animatedVisibilityComposeAnimation)) {
            synchronized (this.animatedVisibilityStatesLock) {
                this.animatedVisibilityStates.put(animatedVisibilityComposeAnimation.getAnimationObject(), (AnimatedVisibilityState) obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* renamed from: getAnimatedVisibilityState-zrx7VqY  reason: not valid java name */
    public final String m4610getAnimatedVisibilityStatezrx7VqY(AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation) {
        Intrinsics.checkNotNullParameter(animatedVisibilityComposeAnimation, "composeAnimation");
        AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(animatedVisibilityComposeAnimation.getAnimationObject());
        String r2 = animatedVisibilityState != null ? animatedVisibilityState.m4603unboximpl() : null;
        return r2 == null ? AnimatedVisibilityState.Companion.m4604getEnterq9NwIk0() : r2;
    }

    public final long getMaxDuration() {
        Iterable<TransitionComposeAnimation> iterable = this.trackedTransitions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TransitionComposeAnimation animationObject : iterable) {
            arrayList.add(Long.valueOf(nanosToMillis(animationObject.getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull((List) arrayList);
        long j = -1;
        long longValue = l != null ? l.longValue() : -1;
        Iterable<AnimatedVisibilityComposeAnimation> iterable2 = this.trackedAnimatedVisibility;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (AnimatedVisibilityComposeAnimation childTransition : iterable2) {
            Transition<Object> childTransition2 = childTransition.getChildTransition();
            arrayList2.add(Long.valueOf(childTransition2 != null ? nanosToMillis(childTransition2.getTotalDurationNanos()) : -1));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull((List) arrayList2);
        if (l2 != null) {
            j = l2.longValue();
        }
        return Math.max(longValue, j);
    }

    public final long getMaxDurationPerIteration() {
        Iterable<TransitionComposeAnimation> iterable = this.trackedTransitions;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TransitionComposeAnimation animationObject : iterable) {
            arrayList.add(Long.valueOf(nanosToMillis(animationObject.getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull((List) arrayList);
        long j = -1;
        long longValue = l != null ? l.longValue() : -1;
        Iterable<AnimatedVisibilityComposeAnimation> iterable2 = this.trackedAnimatedVisibility;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (AnimatedVisibilityComposeAnimation childTransition : iterable2) {
            Transition<Object> childTransition2 = childTransition.getChildTransition();
            arrayList2.add(Long.valueOf(childTransition2 != null ? nanosToMillis(childTransition2.getTotalDurationNanos()) : -1));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull((List) arrayList2);
        if (l2 != null) {
            j = l2.longValue();
        }
        return Math.max(longValue, j);
    }

    public final List<ComposeAnimatedProperty> getAnimatedProperties(ComposeAnimation composeAnimation) {
        Transition childTransition;
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            Collection arrayList = new ArrayList();
            for (Transition.TransitionAnimationState transitionAnimationState : allAnimations(((TransitionComposeAnimation) composeAnimation).getAnimationObject())) {
                String label = transitionAnimationState.getLabel();
                Object value = transitionAnimationState.getValue();
                ComposeAnimatedProperty composeAnimatedProperty = value == null ? null : new ComposeAnimatedProperty(label, value);
                if (composeAnimatedProperty != null) {
                    arrayList.add(composeAnimatedProperty);
                }
            }
            return (List) arrayList;
        } else if (!CollectionsKt.contains(this.trackedAnimatedVisibility, composeAnimation) || (childTransition = ((AnimatedVisibilityComposeAnimation) composeAnimation).getChildTransition()) == null) {
            return CollectionsKt.emptyList();
        } else {
            Collection arrayList2 = new ArrayList();
            for (Transition.TransitionAnimationState transitionAnimationState2 : allAnimations(childTransition)) {
                String label2 = transitionAnimationState2.getLabel();
                Object value2 = transitionAnimationState2.getValue();
                ComposeAnimatedProperty composeAnimatedProperty2 = value2 == null ? null : new ComposeAnimatedProperty(label2, value2);
                if (composeAnimatedProperty2 != null) {
                    arrayList2.add(composeAnimatedProperty2);
                }
            }
            return (List) arrayList2;
        }
    }

    public final List<TransitionInfo> getTransitions(ComposeAnimation composeAnimation, long j) {
        Transition childTransition;
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            Iterable<Transition.TransitionAnimationState> allAnimations = allAnimations(((TransitionComposeAnimation) composeAnimation).getAnimationObject());
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allAnimations, 10));
            for (Transition.TransitionAnimationState createTransitionInfo : allAnimations) {
                arrayList.add(createTransitionInfo(createTransitionInfo, j));
            }
            return (List) arrayList;
        } else if (!CollectionsKt.contains(this.trackedAnimatedVisibility, composeAnimation) || (childTransition = ((AnimatedVisibilityComposeAnimation) composeAnimation).getChildTransition()) == null) {
            return CollectionsKt.emptyList();
        } else {
            Iterable<Transition.TransitionAnimationState> allAnimations2 = allAnimations(childTransition);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(allAnimations2, 10));
            for (Transition.TransitionAnimationState createTransitionInfo2 : allAnimations2) {
                arrayList2.add(createTransitionInfo(createTransitionInfo2, j));
            }
            return (List) arrayList2;
        }
    }

    public final void setClockTime(long j) {
        Iterable plus = SetsKt.plus(this.trackedTransitions, this.trackedAnimatedVisibility);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(plus, 10)), 16));
        for (Object next : plus) {
            ComposeAnimation composeAnimation = (ComposeAnimation) next;
            linkedHashMap.put(next, Long.valueOf(j));
        }
        setClockTimes(linkedHashMap);
    }

    public final void dispose() {
        Iterator it = this.trackedTransitions.iterator();
        while (it.hasNext()) {
            notifyUnsubscribe((TransitionComposeAnimation) it.next());
        }
        Iterator it2 = this.trackedAnimatedVisibility.iterator();
        while (it2.hasNext()) {
            notifyUnsubscribe((AnimatedVisibilityComposeAnimation) it2.next());
        }
        this.trackedAnimatedVisibility.clear();
        this.trackedTransitions.clear();
        this.animatedVisibilityStates.clear();
        this.transitionStates.clear();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "", "current", "target", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getCurrent", "()Ljava/lang/Object;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreviewAnimationClock.kt */
    public static final class TransitionState {
        private final Object current;
        private final Object target;

        public static /* synthetic */ TransitionState copy$default(TransitionState transitionState, Object obj, Object obj2, int i, Object obj3) {
            if ((i & 1) != 0) {
                obj = transitionState.current;
            }
            if ((i & 2) != 0) {
                obj2 = transitionState.target;
            }
            return transitionState.copy(obj, obj2);
        }

        public final Object component1() {
            return this.current;
        }

        public final Object component2() {
            return this.target;
        }

        public final TransitionState copy(Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(obj2, "target");
            return new TransitionState(obj, obj2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransitionState)) {
                return false;
            }
            TransitionState transitionState = (TransitionState) obj;
            return Intrinsics.areEqual(this.current, transitionState.current) && Intrinsics.areEqual(this.target, transitionState.target);
        }

        public int hashCode() {
            return (this.current.hashCode() * 31) + this.target.hashCode();
        }

        public String toString() {
            return "TransitionState(current=" + this.current + ", target=" + this.target + ')';
        }

        public TransitionState(Object obj, Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(obj2, "target");
            this.current = obj;
            this.target = obj2;
        }

        public final Object getCurrent() {
            return this.current;
        }

        public final Object getTarget() {
            return this.target;
        }
    }

    static /* synthetic */ TransitionInfo createTransitionInfo$default(PreviewAnimationClock previewAnimationClock, Transition.TransitionAnimationState transitionAnimationState, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 1;
            }
            return previewAnimationClock.createTransitionInfo(transitionAnimationState, j);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTransitionInfo");
    }

    private final <T, V extends AnimationVector, S> TransitionInfo createTransitionInfo(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, long j) {
        long nanosToMillis = nanosToMillis(transitionAnimationState.getAnimation().getDurationNanos());
        Lazy lazy = LazyKt.lazy(new PreviewAnimationClock$createTransitionInfo$startTimeMs$2(transitionAnimationState));
        Lazy lazy2 = LazyKt.lazy(new PreviewAnimationClock$createTransitionInfo$values$2(transitionAnimationState, this, nanosToMillis, j, lazy));
        String label = transitionAnimationState.getLabel();
        String name = transitionAnimationState.getAnimationSpec().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.animationSpec.javaClass.name");
        return new TransitionInfo(label, name, m4607createTransitionInfo$lambda20(lazy), nanosToMillis, m4608createTransitionInfo$lambda21(lazy2));
    }

    /* access modifiers changed from: private */
    /* renamed from: createTransitionInfo$lambda-20  reason: not valid java name */
    public static final long m4607createTransitionInfo$lambda20(Lazy<Long> lazy) {
        return lazy.getValue().longValue();
    }

    /* renamed from: createTransitionInfo$lambda-21  reason: not valid java name */
    private static final <T> Map<Long, T> m4608createTransitionInfo$lambda21(Lazy<? extends Map<Long, T>> lazy) {
        return (Map) lazy.getValue();
    }

    private final long nanosToMillis(long j) {
        return (j + ((long) 999999)) / ((long) DurationKt.NANOS_IN_MILLIS);
    }

    /* renamed from: toCurrentTargetPair-RvB7uIg  reason: not valid java name */
    private final Pair<Boolean, Boolean> m4609toCurrentTargetPairRvB7uIg(String str) {
        return AnimatedVisibilityState.m4600equalsimpl0(str, AnimatedVisibilityState.Companion.m4604getEnterq9NwIk0()) ? TuplesKt.to(false, true) : TuplesKt.to(true, false);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.compose.animation.core.Transition, androidx.compose.animation.core.Transition<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<androidx.compose.animation.core.Transition<?>.TransitionAnimationState<?, ?>> allAnimations(androidx.compose.animation.core.Transition<?> r4) {
        /*
            r3 = this;
            java.util.List r0 = r4.getTransitions()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0027
            java.lang.Object r2 = r0.next()
            androidx.compose.animation.core.Transition r2 = (androidx.compose.animation.core.Transition) r2
            java.util.List r2 = r3.allAnimations(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.collections.CollectionsKt.addAll(r1, r2)
            goto L_0x0011
        L_0x0027:
            java.util.List r1 = (java.util.List) r1
            java.util.List r4 = r4.getAnimations()
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r4 = kotlin.collections.CollectionsKt.plus(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.allAnimations(androidx.compose.animation.core.Transition):java.util.List");
    }

    public final void setClockTimes(Map<ComposeAnimation, Long> map) {
        Intrinsics.checkNotNullParameter(map, "animationTimeMillis");
        for (Map.Entry next : map.entrySet()) {
            TransitionComposeAnimation transitionComposeAnimation = (ComposeAnimation) next.getKey();
            long nanos = TimeUnit.MILLISECONDS.toNanos(((Number) next.getValue()).longValue());
            if (CollectionsKt.contains(this.trackedTransitions, transitionComposeAnimation)) {
                Transition<Object> animationObject = transitionComposeAnimation.getAnimationObject();
                TransitionState transitionState = this.transitionStates.get(animationObject);
                if (transitionState != null) {
                    Intrinsics.checkNotNullExpressionValue(transitionState, "transitionStates[it] ?: return@let");
                    animationObject.seek(transitionState.getCurrent(), transitionState.getTarget(), nanos);
                }
            } else if (CollectionsKt.contains(this.trackedAnimatedVisibility, transitionComposeAnimation)) {
                Transition<Object> animationObject2 = ((AnimatedVisibilityComposeAnimation) transitionComposeAnimation).getAnimationObject();
                AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(animationObject2);
                AnimatedVisibilityState animatedVisibilityState2 = null;
                String r1 = animatedVisibilityState != null ? animatedVisibilityState.m4603unboximpl() : null;
                if (r1 != null) {
                    if (r1 != null) {
                        animatedVisibilityState2 = AnimatedVisibilityState.m4597boximpl(r1);
                    }
                    Intrinsics.checkNotNullExpressionValue(animatedVisibilityState2, "animatedVisibilityStates[it]");
                    Pair<Boolean, Boolean> r12 = m4609toCurrentTargetPairRvB7uIg(r1);
                    if (r12 != null) {
                        animationObject2.seek(Boolean.valueOf(r12.component1().booleanValue()), Boolean.valueOf(r12.component2().booleanValue()), nanos);
                    }
                }
            }
        }
        this.setAnimationsTimeCallback.invoke();
    }
}
