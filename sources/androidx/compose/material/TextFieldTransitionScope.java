package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ab, code lost:
        if (r8 != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01db, code lost:
        if (r8 != false) goto L_0x01e0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0236  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1494TransitionDTcfvLk(androidx.compose.material.InputPhase r27, long r28, long r30, kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r32, boolean r33, kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, int r36) {
        /*
            r26 = this;
            r2 = r27
            r7 = r32
            r8 = r33
            r5 = r34
            r6 = r36
            java.lang.String r0 = "inputState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "contentColor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1988729962(0x76899c6a, float:1.3955413E33)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Transition)P(3,2:c#ui.graphics.Color,5:c#ui.graphics.Color,1,4)276@11184L59,278@11285L325,289@11657L1101,317@12806L299,327@13151L186,333@13347L140:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r6 & 14
            if (r1 != 0) goto L_0x0036
            boolean r1 = r0.changed((java.lang.Object) r2)
            if (r1 == 0) goto L_0x0033
            r1 = 4
            goto L_0x0034
        L_0x0033:
            r1 = 2
        L_0x0034:
            r1 = r1 | r6
            goto L_0x0037
        L_0x0036:
            r1 = r6
        L_0x0037:
            r4 = r6 & 112(0x70, float:1.57E-43)
            r14 = r28
            if (r4 != 0) goto L_0x0049
            boolean r4 = r0.changed((long) r14)
            if (r4 == 0) goto L_0x0046
            r4 = 32
            goto L_0x0048
        L_0x0046:
            r4 = 16
        L_0x0048:
            r1 = r1 | r4
        L_0x0049:
            r4 = r6 & 896(0x380, float:1.256E-42)
            r12 = r30
            if (r4 != 0) goto L_0x005b
            boolean r4 = r0.changed((long) r12)
            if (r4 == 0) goto L_0x0058
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r1 = r1 | r4
        L_0x005b:
            r4 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x006b
            boolean r4 = r0.changed((java.lang.Object) r7)
            if (r4 == 0) goto L_0x0068
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x006a
        L_0x0068:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x006a:
            r1 = r1 | r4
        L_0x006b:
            r4 = 57344(0xe000, float:8.0356E-41)
            r9 = r6 & r4
            if (r9 != 0) goto L_0x007e
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007d
        L_0x007b:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x007d:
            r1 = r1 | r9
        L_0x007e:
            r17 = 458752(0x70000, float:6.42848E-40)
            r9 = r6 & r17
            if (r9 != 0) goto L_0x0090
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x008d
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x008f
        L_0x008d:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x008f:
            r1 = r1 | r9
        L_0x0090:
            r9 = 374491(0x5b6db, float:5.24774E-40)
            r9 = r9 & r1
            r10 = 74898(0x12492, float:1.04954E-40)
            if (r9 != r10) goto L_0x00a5
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x00a0
            goto L_0x00a5
        L_0x00a0:
            r0.skipToGroupEnd()
            goto L_0x03d6
        L_0x00a5:
            r9 = r1 & 14
            r9 = r9 | 48
            java.lang.String r10 = "TextFieldInputState"
            r11 = 0
            androidx.compose.animation.core.Transition r18 = androidx.compose.animation.core.TransitionKt.updateTransition(r2, (java.lang.String) r10, (androidx.compose.runtime.Composer) r0, (int) r9, (int) r11)
            androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelProgress$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r10)
            java.lang.String r4 = "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            kotlin.jvm.internal.FloatCompanionObject r16 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r16 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r16)
            r11 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r11)
            java.lang.String r3 = "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r21 = r18.getCurrentState()
            androidx.compose.material.InputPhase r21 = (androidx.compose.material.InputPhase) r21
            r10 = -1158004136(0xffffffffbafa4258, float:-0.0019093258)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            int[] r23 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r21 = r21.ordinal()
            r11 = r23[r21]
            r21 = 0
            r2 = 1
            r24 = 1065353216(0x3f800000, float:1.0)
            if (r11 == r2) goto L_0x00ff
            r2 = 2
            if (r11 == r2) goto L_0x00fd
            r2 = 3
            if (r11 != r2) goto L_0x00f7
            goto L_0x00ff
        L_0x00f7:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00fd:
            r2 = 0
            goto L_0x0101
        L_0x00ff:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0101:
            r0.endReplaceableGroup()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r11 = r18.getTargetState()
            androidx.compose.material.InputPhase r11 = (androidx.compose.material.InputPhase) r11
            r5 = -1158004136(0xffffffffbafa4258, float:-0.0019093258)
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            int[] r5 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r5 = r5[r11]
            r11 = 1
            if (r5 == r11) goto L_0x0131
            r11 = 2
            if (r5 == r11) goto L_0x012f
            r11 = 3
            if (r5 != r11) goto L_0x0129
            goto L_0x0131
        L_0x0129:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x012f:
            r5 = 0
            goto L_0x0133
        L_0x0131:
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x0133:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r5)
            androidx.compose.animation.core.Transition$Segment r5 = r18.getSegment()
            r19 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)
            java.lang.Object r5 = r9.invoke(r5, r0, r6)
            androidx.compose.animation.core.FiniteAnimationSpec r5 = (androidx.compose.animation.core.FiniteAnimationSpec) r5
            r6 = 196608(0x30000, float:2.75506E-40)
            java.lang.String r22 = "LabelProgress"
            r9 = r18
            r25 = r10
            r10 = r2
            r2 = 1847725064(0x6e220c08, float:1.2537779E28)
            r12 = r5
            r13 = r16
            r14 = r22
            r15 = r0
            r16 = r6
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$placeholderOpacity$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = 1399891485(0x5370a61d, float:1.03357907E12)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            kotlin.jvm.internal.FloatCompanionObject r4 = kotlin.jvm.internal.FloatCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r13 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.FloatCompanionObject) r4)
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r4 = r18.getCurrentState()
            androidx.compose.material.InputPhase r4 = (androidx.compose.material.InputPhase) r4
            r10 = -1376159017(0xffffffffadf97ad7, float:-2.8362574E-11)
            r0.startReplaceableGroup(r10)
            r15 = r25
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            int[] r11 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r11[r4]
            r11 = 1
            if (r4 == r11) goto L_0x01ae
            r11 = 2
            if (r4 == r11) goto L_0x01ab
            r11 = 3
            if (r4 != r11) goto L_0x01a5
        L_0x01a3:
            r4 = 0
            goto L_0x01b0
        L_0x01a5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01ab:
            if (r8 == 0) goto L_0x01ae
            goto L_0x01a3
        L_0x01ae:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x01b0:
            r0.endReplaceableGroup()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r11 = r18.getTargetState()
            androidx.compose.material.InputPhase r11 = (androidx.compose.material.InputPhase) r11
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            int[] r10 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r10 = r10[r11]
            r11 = 1
            if (r10 == r11) goto L_0x01de
            r11 = 2
            if (r10 == r11) goto L_0x01db
            r11 = 3
            if (r10 != r11) goto L_0x01d5
            goto L_0x01e0
        L_0x01d5:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x01db:
            if (r8 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r21 = 1065353216(0x3f800000, float:1.0)
        L_0x01e0:
            r0.endReplaceableGroup()
            java.lang.Float r11 = java.lang.Float.valueOf(r21)
            androidx.compose.animation.core.Transition$Segment r10 = r18.getSegment()
            r12 = 0
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)
            java.lang.Object r9 = r9.invoke(r10, r0, r14)
            r12 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            java.lang.String r14 = "PlaceholderOpacity"
            r9 = r18
            r10 = r4
            r4 = r15
            r15 = r0
            r16 = r6
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelTextStyleColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r15 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r0.startReplaceableGroup(r15)
            java.lang.String r14 = "C(animateColor)P(2)68@3224L31,69@3291L70,73@3374L70:Transition.kt#xbi5r1"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r10 = r18.getTargetState()
            androidx.compose.material.InputPhase r10 = (androidx.compose.material.InputPhase) r10
            r11 = -1490209928(0xffffffffa72d3378, float:-2.4036474E-15)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            int[] r12 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r12[r10]
            r12 = 1
            if (r10 != r12) goto L_0x0236
            r12 = r28
            goto L_0x0238
        L_0x0236:
            r12 = r30
        L_0x0238:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m1936getColorSpaceimpl(r12)
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r12 = r0.changed((java.lang.Object) r10)
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x025c
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x026c
        L_0x025c:
            androidx.compose.ui.graphics.Color$Companion r12 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r12 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r12)
            java.lang.Object r10 = r12.invoke(r10)
            r13 = r10
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r0.updateRememberedValue(r13)
        L_0x026c:
            r0.endReplaceableGroup()
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r10 = r18.getCurrentState()
            androidx.compose.material.InputPhase r10 = (androidx.compose.material.InputPhase) r10
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            int[] r12 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r12[r10]
            r12 = 1
            if (r10 != r12) goto L_0x0291
            r20 = r28
            goto L_0x0293
        L_0x0291:
            r20 = r30
        L_0x0293:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m1922boximpl(r20)
            java.lang.Object r12 = r18.getTargetState()
            androidx.compose.material.InputPhase r12 = (androidx.compose.material.InputPhase) r12
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            int[] r4 = androidx.compose.material.TextFieldTransitionScope.WhenMappings.$EnumSwitchMapping$0
            int r11 = r12.ordinal()
            r4 = r4[r11]
            r11 = 1
            if (r4 != r11) goto L_0x02b4
            r11 = r28
            goto L_0x02b6
        L_0x02b4:
            r11 = r30
        L_0x02b6:
            r0.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
            androidx.compose.animation.core.Transition$Segment r4 = r18.getSegment()
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.Object r4 = r9.invoke(r4, r0, r12)
            r12 = r4
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r16 = 229376(0x38000, float:3.21424E-40)
            java.lang.String r4 = "LabelTextStyleColor"
            r9 = r18
            r2 = r14
            r14 = r4
            r4 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r15 = r0
            androidx.compose.runtime.State r19 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2 r9 = androidx.compose.material.TextFieldTransitionScope$Transition$labelContentColor$2.INSTANCE
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r10 = r1 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | 384(0x180, float:5.38E-43)
            r0.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r2 = r18.getTargetState()
            int r4 = r10 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r2 = r7.invoke(r2, r0, r4)
            androidx.compose.ui.graphics.Color r2 = (androidx.compose.ui.graphics.Color) r2
            long r11 = r2.m1942unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r2 = androidx.compose.ui.graphics.Color.m1936getColorSpaceimpl(r11)
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            boolean r4 = r0.changed((java.lang.Object) r2)
            java.lang.Object r11 = r0.rememberedValue()
            if (r4 != 0) goto L_0x0329
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x0339
        L_0x0329:
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r4 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r4)
            java.lang.Object r2 = r4.invoke(r2)
            r11 = r2
            androidx.compose.animation.core.TwoWayConverter r11 = (androidx.compose.animation.core.TwoWayConverter) r11
            r0.updateRememberedValue(r11)
        L_0x0339:
            r0.endReplaceableGroup()
            r13 = r11
            androidx.compose.animation.core.TwoWayConverter r13 = (androidx.compose.animation.core.TwoWayConverter) r13
            r2 = r10 & 14
            r2 = r2 | 64
            r4 = 3
            int r10 = r10 << r4
            r4 = r10 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r4 = r10 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r4
            r2 = r2 | r10
            r4 = 1847725064(0x6e220c08, float:1.2537779E28)
            r0.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            java.lang.Object r3 = r18.getCurrentState()
            int r4 = r2 >> 9
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r4)
            java.lang.Object r10 = r7.invoke(r3, r0, r10)
            java.lang.Object r3 = r18.getTargetState()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r11 = r7.invoke(r3, r0, r4)
            androidx.compose.animation.core.Transition$Segment r3 = r18.getSegment()
            int r4 = r2 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r9.invoke(r3, r0, r4)
            r12 = r3
            androidx.compose.animation.core.FiniteAnimationSpec r12 = (androidx.compose.animation.core.FiniteAnimationSpec) r12
            r3 = r2 & 14
            int r4 = r2 << 9
            r9 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r9
            r3 = r3 | r4
            int r2 = r2 << 6
            r2 = r2 & r17
            r16 = r3 | r2
            java.lang.String r14 = "LabelContentColor"
            r9 = r18
            r15 = r0
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            float r3 = m1490Transition_DTcfvLk$lambda1(r5)
            java.lang.Float r10 = java.lang.Float.valueOf(r3)
            long r3 = m1492Transition_DTcfvLk$lambda5(r19)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1922boximpl(r3)
            long r2 = m1493Transition_DTcfvLk$lambda6(r2)
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m1922boximpl(r2)
            float r2 = m1491Transition_DTcfvLk$lambda3(r6)
            java.lang.Float r13 = java.lang.Float.valueOf(r2)
            r2 = 3
            int r1 = r1 >> r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r2
            java.lang.Integer r15 = java.lang.Integer.valueOf(r1)
            r9 = r34
            r14 = r0
            r9.invoke(r10, r11, r12, r13, r14, r15)
        L_0x03d6:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x03dd
            goto L_0x03f8
        L_0x03dd:
            androidx.compose.material.TextFieldTransitionScope$Transition$1 r12 = new androidx.compose.material.TextFieldTransitionScope$Transition$1
            r0 = r12
            r1 = r26
            r2 = r27
            r3 = r28
            r5 = r30
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x03f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1494TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: Transition_DTcfvLk$lambda-1  reason: not valid java name */
    private static final float m1490Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-3  reason: not valid java name */
    private static final float m1491Transition_DTcfvLk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: Transition_DTcfvLk$lambda-5  reason: not valid java name */
    private static final long m1492Transition_DTcfvLk$lambda5(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    /* renamed from: Transition_DTcfvLk$lambda-6  reason: not valid java name */
    private static final long m1493Transition_DTcfvLk$lambda6(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }
}
