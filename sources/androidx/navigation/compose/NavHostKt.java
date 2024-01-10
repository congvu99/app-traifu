package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"NavHost", "", "navController", "Landroidx/navigation/NavHostController;", "graph", "Landroidx/navigation/NavGraph;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/navigation/NavHostController;Landroidx/navigation/NavGraph;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDestination", "", "route", "builder", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/navigation/NavHostController;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "navigation-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavHost.kt */
public final class NavHostKt {
    public static final void NavHost(NavHostController navHostController, String str, Modifier modifier, String str2, Function1<? super NavGraphBuilder, Unit> function1, Composer composer, int i, int i2) {
        NavHostController navHostController2 = navHostController;
        String str3 = str;
        Function1<? super NavGraphBuilder, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(navHostController, "navController");
        Intrinsics.checkNotNullParameter(str, "startDestination");
        Intrinsics.checkNotNullParameter(function12, "builder");
        Composer startRestartGroup = composer.startRestartGroup(141827520);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavHost)P(2,4,1,3)68@2616L126,66@2576L190:NavHost.kt#opm8kd");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        String str4 = (i2 & 8) != 0 ? null : str2;
        startRestartGroup.startReplaceableGroup(-3686095);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) str4) | startRestartGroup.changed((Object) str) | startRestartGroup.changed((Object) function12);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController2.getNavigatorProvider(), str, str4);
            function12.invoke(navGraphBuilder);
            rememberedValue = navGraphBuilder.build();
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        NavHost(navHostController, (NavGraph) rememberedValue, modifier2, startRestartGroup, (i & 896) | 72, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavHostKt$NavHost$2(navHostController, str, modifier2, str4, function1, i, i2));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: kotlinx.coroutines.flow.Flow} */
    /* JADX WARNING: type inference failed for: r3v18, types: [androidx.navigation.Navigator] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavHost(androidx.navigation.NavHostController r15, androidx.navigation.NavGraph r16, androidx.compose.ui.Modifier r17, androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r1 = r15
            java.lang.String r0 = "navController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "graph"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -957014592(0xffffffffc6f51dc0, float:-31374.875)
            r3 = r18
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(NavHost)P(2)94@3456L7,*95@3532L7,98@3715L7,109@4219L170,119@4480L29,126@4829L223,132@5053L27,136@5164L33,172@6646L27:NavHost.kt#opm8kd"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r20 & 4
            if (r3 == 0) goto L_0x0025
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r10 = r3
            goto L_0x0027
        L_0x0025:
            r10 = r17
        L_0x0027:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r5)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.lifecycle.LifecycleOwner r3 = (androidx.lifecycle.LifecycleOwner) r3
            androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner r4 = androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.INSTANCE
            r5 = 8
            androidx.lifecycle.ViewModelStoreOwner r4 = r4.getCurrent(r0, r5)
            if (r4 == 0) goto L_0x01a4
            androidx.activity.compose.LocalOnBackPressedDispatcherOwner r6 = androidx.activity.compose.LocalOnBackPressedDispatcherOwner.INSTANCE
            androidx.activity.OnBackPressedDispatcherOwner r6 = r6.getCurrent(r0, r5)
            r11 = 0
            if (r6 == 0) goto L_0x0056
            androidx.activity.OnBackPressedDispatcher r6 = r6.getOnBackPressedDispatcher()
            goto L_0x0057
        L_0x0056:
            r6 = r11
        L_0x0057:
            r15.setLifecycleOwner(r3)
            androidx.lifecycle.ViewModelStore r3 = r4.getViewModelStore()
            java.lang.String r4 = "viewModelStoreOwner.viewModelStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r15.setViewModelStore(r3)
            if (r6 == 0) goto L_0x006c
            r15.setOnBackPressedDispatcher(r6)
        L_0x006c:
            androidx.navigation.compose.NavHostKt$NavHost$3 r3 = new androidx.navigation.compose.NavHostKt$NavHost$3
            r3.<init>(r15)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r15, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r3, (androidx.compose.runtime.Composer) r0, (int) r5)
            r15.setGraph((androidx.navigation.NavGraph) r16)
            r12 = 0
            androidx.compose.runtime.saveable.SaveableStateHolder r9 = androidx.compose.runtime.saveable.SaveableStateHolderKt.rememberSaveableStateHolder(r0, r12)
            androidx.navigation.NavigatorProvider r3 = r15.getNavigatorProvider()
            java.lang.String r4 = "composable"
            androidx.navigation.Navigator r3 = r3.getNavigator((java.lang.String) r4)
            boolean r4 = r3 instanceof androidx.navigation.compose.ComposeNavigator
            if (r4 == 0) goto L_0x0090
            androidx.navigation.compose.ComposeNavigator r3 = (androidx.navigation.compose.ComposeNavigator) r3
            r13 = r3
            goto L_0x0091
        L_0x0090:
            r13 = r11
        L_0x0091:
            if (r13 != 0) goto L_0x00ae
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x009a
            goto L_0x00ad
        L_0x009a:
            androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1 r7 = new androidx.navigation.compose.NavHostKt$NavHost$composeNavigator$1
            r0 = r7
            r1 = r15
            r2 = r16
            r3 = r10
            r4 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x00ad:
            return
        L_0x00ae:
            kotlinx.coroutines.flow.StateFlow r3 = r15.getVisibleEntries()
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            boolean r3 = r0.changed((java.lang.Object) r3)
            java.lang.Object r4 = r0.rememberedValue()
            if (r3 != 0) goto L_0x00cf
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x00df
        L_0x00cf:
            kotlinx.coroutines.flow.StateFlow r3 = r15.getVisibleEntries()
            kotlinx.coroutines.flow.Flow r3 = (kotlinx.coroutines.flow.Flow) r3
            androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1 r4 = new androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1
            r4.<init>(r3)
            kotlinx.coroutines.flow.Flow r4 = (kotlinx.coroutines.flow.Flow) r4
            r0.updateRememberedValue(r4)
        L_0x00df:
            r0.endReplaceableGroup()
            r3 = r4
            kotlinx.coroutines.flow.Flow r3 = (kotlinx.coroutines.flow.Flow) r3
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            r5 = 0
            r7 = 8
            r8 = 2
            r6 = r0
            androidx.compose.runtime.State r3 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r3, r4, r5, r6, r7, r8)
            java.util.List r4 = m4978NavHost$lambda5(r3)
            java.lang.Object r4 = kotlin.collections.CollectionsKt.lastOrNull(r4)
            androidx.navigation.NavBackStackEntry r4 = (androidx.navigation.NavBackStackEntry) r4
            r5 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            java.lang.Object r5 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            r7 = 1
            if (r5 != r6) goto L_0x0120
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)
            r6 = 2
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r11, r6, r11)
            r0.updateRememberedValue(r5)
        L_0x0120:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r6 = 1822173528(0x6c9c2958, float:1.5103013E27)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "140@5379L1059"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            if (r4 == 0) goto L_0x0155
            java.lang.String r4 = r4.getId()
            r6 = 0
            r8 = 1319254703(0x4ea23aaf, float:1.36087744E9)
            androidx.navigation.compose.NavHostKt$NavHost$4 r14 = new androidx.navigation.compose.NavHostKt$NavHost$4
            r14.<init>(r5, r3, r13, r9)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r7, r14)
            r7 = r3
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            int r3 = r19 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r8 = r3 | 3072(0xc00, float:4.305E-42)
            r9 = 4
            r3 = r4
            r4 = r10
            r5 = r6
            r6 = r7
            r7 = r0
            androidx.compose.animation.CrossfadeKt.Crossfade(r3, r4, r5, r6, r7, r8, r9)
        L_0x0155:
            r0.endReplaceableGroup()
            androidx.navigation.NavigatorProvider r3 = r15.getNavigatorProvider()
            java.lang.String r4 = "dialog"
            androidx.navigation.Navigator r3 = r3.getNavigator((java.lang.String) r4)
            boolean r4 = r3 instanceof androidx.navigation.compose.DialogNavigator
            if (r4 == 0) goto L_0x0169
            r11 = r3
            androidx.navigation.compose.DialogNavigator r11 = (androidx.navigation.compose.DialogNavigator) r11
        L_0x0169:
            if (r11 != 0) goto L_0x0186
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0172
            goto L_0x0185
        L_0x0172:
            androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1 r7 = new androidx.navigation.compose.NavHostKt$NavHost$dialogNavigator$1
            r0 = r7
            r1 = r15
            r2 = r16
            r3 = r10
            r4 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x0185:
            return
        L_0x0186:
            androidx.navigation.compose.DialogHostKt.DialogHost(r11, r0, r12)
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0190
            goto L_0x01a3
        L_0x0190:
            androidx.navigation.compose.NavHostKt$NavHost$5 r7 = new androidx.navigation.compose.NavHostKt$NavHost$5
            r0 = r7
            r1 = r15
            r2 = r16
            r3 = r10
            r4 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x01a3:
            return
        L_0x01a4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt.NavHost(androidx.navigation.NavHostController, androidx.navigation.NavGraph, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-7  reason: not valid java name */
    public static final boolean m4979NavHost$lambda7(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-8  reason: not valid java name */
    public static final void m4980NavHost$lambda8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    /* renamed from: NavHost$lambda-5  reason: not valid java name */
    public static final List<NavBackStackEntry> m4978NavHost$lambda5(State<? extends List<NavBackStackEntry>> state) {
        return (List) state.getValue();
    }
}
