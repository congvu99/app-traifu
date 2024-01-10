package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.data.SpaceItemType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpacesCard.kt */
final class SpacesCardKt$SpacesCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ HomeCards.HomeSpacesData $homeSpacesData;
    final /* synthetic */ Function1<SpaceItemType, Unit> $onItemClick;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SpacesCard.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpaceItemType.values().length];
            iArr[SpaceItemType.MESSAGES.ordinal()] = 1;
            iArr[SpaceItemType.HELP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpacesCardKt$SpacesCard$1(HomeCards.HomeSpacesData homeSpacesData, Function1<? super SpaceItemType, Unit> function1, int i) {
        super(2);
        this.$homeSpacesData = homeSpacesData;
        this.$onItemClick = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r11 = r21
            r1 = r22 & 11
            r12 = 2
            if (r1 != r12) goto L_0x0015
            boolean r1 = r21.getSkipping()
            if (r1 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r21.skipToGroupEnd()
            goto L_0x0213
        L_0x0015:
            io.intercom.android.sdk.m5.home.data.HomeCards$HomeSpacesData r1 = r0.$homeSpacesData
            kotlin.jvm.functions.Function1<io.intercom.android.sdk.m5.home.data.SpaceItemType, kotlin.Unit> r13 = r0.$onItemClick
            r2 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.layout.Arrangement r3 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r3 = r3.getTop()
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r4 = r4.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r3, r4, r11, r14)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r4 = r11.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r21)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r7 = r11.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r21)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r5 = r11.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r21)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r8 = r21.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0094
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0094:
            r21.startReusableNode()
            boolean r8 = r21.getInserting()
            if (r8 == 0) goto L_0x00a1
            r11.createNode(r6)
            goto L_0x00a4
        L_0x00a1:
            r21.useNode()
        L_0x00a4:
            r21.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r21)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r4, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r7, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r3)
            r21.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r21)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r2.invoke(r3, r11, r4)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            java.util.List r1 = r1.getSpaceItems()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x0107:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0126
            java.lang.Object r3 = r1.next()
            r4 = r3
            io.intercom.android.sdk.m5.home.data.SpaceItem r4 = (io.intercom.android.sdk.m5.home.data.SpaceItem) r4
            io.intercom.android.sdk.m5.home.data.SpaceItemType[] r5 = io.intercom.android.sdk.m5.home.data.SpaceItemType.values()
            io.intercom.android.sdk.m5.home.data.SpaceItemType r4 = r4.getType()
            boolean r4 = kotlin.collections.ArraysKt.contains((T[]) r5, r4)
            if (r4 == 0) goto L_0x0107
            r2.add(r3)
            goto L_0x0107
        L_0x0126:
            r15 = r2
            java.util.List r15 = (java.util.List) r15
            r1 = r15
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r16 = r1.iterator()
            r10 = 0
        L_0x0131:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x0204
            java.lang.Object r1 = r16.next()
            int r17 = r10 + 1
            if (r10 >= 0) goto L_0x0142
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0142:
            io.intercom.android.sdk.m5.home.data.SpaceItem r1 = (io.intercom.android.sdk.m5.home.data.SpaceItem) r1
            io.intercom.android.sdk.m5.home.data.SpaceItemType r2 = r1.getType()
            int[] r3 = io.intercom.android.sdk.m5.home.components.SpacesCardKt$SpacesCard$1.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r9 = 1
            if (r2 == r9) goto L_0x015e
            if (r2 != r12) goto L_0x0158
            int r2 = io.intercom.android.sdk.R.drawable.intercom_help_centre_icon
            goto L_0x0160
        L_0x0158:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x015e:
            int r2 = io.intercom.android.sdk.R.drawable.intercom_messages_icon
        L_0x0160:
            java.lang.String r4 = r1.getLabel()
            io.intercom.android.sdk.m5.home.data.Badge r3 = r1.getBadge()
            if (r3 == 0) goto L_0x018c
            io.intercom.android.sdk.m5.home.data.Badge r3 = r1.getBadge()
            java.lang.String r3 = r3.getBadgeType()
            java.lang.String r5 = "unread"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x018c
            io.intercom.android.sdk.m5.home.data.Badge r3 = r1.getBadge()
            java.lang.String r3 = r3.getLabel()
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6 = r3
            goto L_0x018d
        L_0x018c:
            r6 = 0
        L_0x018d:
            r3 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r5 = 0
            r7 = 0
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            boolean r8 = r11.changed((java.lang.Object) r13)
            boolean r18 = r11.changed((java.lang.Object) r1)
            r8 = r8 | r18
            java.lang.Object r9 = r21.rememberedValue()
            if (r8 != 0) goto L_0x01b7
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x01c2
        L_0x01b7:
            io.intercom.android.sdk.m5.home.components.SpacesCardKt$SpacesCard$1$1$1$1$1 r8 = new io.intercom.android.sdk.m5.home.components.SpacesCardKt$SpacesCard$1$1$1$1$1
            r8.<init>(r13, r1)
            r9 = r8
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r11.updateRememberedValue(r9)
        L_0x01c2:
            r21.endReplaceableGroup()
            r8 = r9
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r9 = 0
            r19 = 21
            r1 = r3
            r3 = r5
            r5 = r7
            r7 = r8
            r14 = 0
            r8 = r21
            r12 = 1
            r14 = r10
            r10 = r19
            io.intercom.android.sdk.m5.components.HomeItemKt.HomeItem(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r15.size()
            int r1 = r1 - r12
            if (r14 == r1) goto L_0x01fc
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r2, r12, r3)
            r4 = 16
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r5 = 2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r1, r4, r2, r5, r3)
            r2 = 6
            r3 = 0
            io.intercom.android.sdk.m5.components.IntercomDividerKt.IntercomDivider(r1, r11, r2, r3)
            goto L_0x01fe
        L_0x01fc:
            r3 = 0
            r5 = 2
        L_0x01fe:
            r10 = r17
            r12 = 2
            r14 = 0
            goto L_0x0131
        L_0x0204:
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
        L_0x0213:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.components.SpacesCardKt$SpacesCard$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
