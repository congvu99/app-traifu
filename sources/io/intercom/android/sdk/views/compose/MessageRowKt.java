package io.intercom.android.sdk.views.compose;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.blocks.lib.models.TicketType;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Part;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\u001a\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\f21\u0010\u0019\u001a-\u0012\u0004\u0012\u00020\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\n0\u001a¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001f\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001ay\u0010'\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\f2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\n0,2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u0001¢\u0006\u0002\u00100\u001a\r\u00101\u001a\u00020\nH\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\fH\u0001¢\u0006\u0002\u00106\u001a\f\u00107\u001a\u00020\f*\u00020)H\u0002\u001a\f\u00108\u001a\u00020\f*\u00020)H\u0000\u001a1\u00109\u001a\u00020\u0011*\u00020\u00112\u0006\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u000fH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"createTicketBlock", "Lio/intercom/android/sdk/blocks/lib/models/Block$Builder;", "kotlin.jvm.PlatformType", "longParagraphBlock", "paragraphBlock", "shadowBlockTypes", "", "Lio/intercom/android/sdk/blocks/lib/BlockType;", "textBlockTypes", "MessageBubbleRow", "", "isAdmin", "", "isAdminOrAltParticipant", "bubbleShape", "Landroidx/compose/ui/graphics/Shape;", "modifier", "Landroidx/compose/ui/Modifier;", "bubbleContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "avatar", "Lio/intercom/android/sdk/models/Avatar;", "onClick", "Lkotlin/Function0;", "showAvatarIfAvailable", "bubbleContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "contentColor", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Lio/intercom/android/sdk/models/Avatar;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "MessageMeta", "metaString", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "MessageRow", "conversationPart", "Lio/intercom/android/sdk/models/Part;", "isLastPart", "onReplyClicked", "Lkotlin/Function1;", "Lio/intercom/android/sdk/models/ReplyOption;", "legacyBlocks", "Landroid/view/ViewGroup;", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/models/Part;ZLkotlin/jvm/functions/Function1;Ljava/lang/String;ZLjava/util/List;Landroidx/compose/ui/graphics/Shape;ZLandroidx/compose/runtime/Composer;II)V", "MessagesPreview", "(Landroidx/compose/runtime/Composer;I)V", "contentAlpha", "", "enabled", "(ZLandroidx/compose/runtime/Composer;I)F", "hasSingleBlockPartWithShadow", "hasTextBlockPart", "messageBorder", "isUserMessage", "color", "shape", "messageBorder-9LQNqLg", "(Landroidx/compose/ui/Modifier;ZJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
public final class MessageRowKt {
    /* access modifiers changed from: private */
    public static final Block.Builder createTicketBlock = new Block.Builder().withTitle("Create ticket").withTicketType(new TicketType(-1, "Bug", "", CollectionsKt.emptyList())).withType(BlockType.CREATETICKETCARD.getSerializedName());
    /* access modifiers changed from: private */
    public static final Block.Builder longParagraphBlock = new Block.Builder().withText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.").withType(BlockType.PARAGRAPH.getSerializedName());
    /* access modifiers changed from: private */
    public static final Block.Builder paragraphBlock = new Block.Builder().withText("Hey").withType(BlockType.PARAGRAPH.getSerializedName());
    private static final List<BlockType> shadowBlockTypes = CollectionsKt.listOf(BlockType.MESSENGERCARD, BlockType.CREATETICKETCARD);
    private static final List<BlockType> textBlockTypes = CollectionsKt.listOf(BlockType.PARAGRAPH, BlockType.HEADING, BlockType.SUBHEADING);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x031a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MessageRow(androidx.compose.ui.Modifier r29, io.intercom.android.sdk.models.Part r30, boolean r31, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.models.ReplyOption, kotlin.Unit> r32, java.lang.String r33, boolean r34, java.util.List<? extends android.view.ViewGroup> r35, androidx.compose.ui.graphics.Shape r36, boolean r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r2 = r30
            r11 = r40
            java.lang.String r0 = "conversationPart"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 2123362067(0x7e8fef13, float:9.566047E37)
            r1 = r38
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x001b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x001d
        L_0x001b:
            r1 = r29
        L_0x001d:
            r3 = r11 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0026
        L_0x0024:
            r3 = r31
        L_0x0026:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x002f
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$1 r5 = io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$1.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            goto L_0x0031
        L_0x002f:
            r5 = r32
        L_0x0031:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0038
            java.lang.String r6 = ""
            goto L_0x003a
        L_0x0038:
            r6 = r33
        L_0x003a:
            r7 = r11 & 32
            if (r7 == 0) goto L_0x0048
            boolean r7 = r30.isAdmin()
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r8 = r39 & r8
            goto L_0x004c
        L_0x0048:
            r7 = r34
            r8 = r39
        L_0x004c:
            r9 = r11 & 64
            r10 = 0
            if (r9 == 0) goto L_0x0053
            r9 = r10
            goto L_0x0055
        L_0x0053:
            r9 = r35
        L_0x0055:
            r12 = r11 & 128(0x80, float:1.794E-43)
            r15 = 8
            if (r12 == 0) goto L_0x006f
            androidx.compose.material.MaterialTheme r12 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r12 = r12.getShapes(r0, r15)
            androidx.compose.foundation.shape.CornerBasedShape r12 = r12.getMedium()
            androidx.compose.ui.graphics.Shape r12 = (androidx.compose.ui.graphics.Shape) r12
            r13 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r8 = r8 & r13
            r24 = r8
            r8 = r12
            goto L_0x0073
        L_0x006f:
            r24 = r8
            r8 = r36
        L_0x0073:
            r12 = r11 & 256(0x100, float:3.59E-43)
            r14 = 1
            if (r12 == 0) goto L_0x007b
            r25 = 1
            goto L_0x007d
        L_0x007b:
            r25 = r37
        L_0x007d:
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            java.lang.Object r12 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r12 != r13) goto L_0x00a0
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r3)
            r13 = 2
            androidx.compose.runtime.MutableState r12 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r12, r10, r13, r10)
            r0.updateRememberedValue(r12)
        L_0x00a0:
            r0.endReplaceableGroup()
            r13 = r12
            androidx.compose.runtime.MutableState r13 = (androidx.compose.runtime.MutableState) r13
            java.util.List r12 = r30.getBlocks()
            java.lang.String r15 = "conversationPart.blocks"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r15)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r15 = r12 instanceof java.util.Collection
            if (r15 == 0) goto L_0x00c0
            r15 = r12
            java.util.Collection r15 = (java.util.Collection) r15
            boolean r15 = r15.isEmpty()
            if (r15 == 0) goto L_0x00c0
        L_0x00be:
            r10 = 0
            goto L_0x00e1
        L_0x00c0:
            java.util.Iterator r12 = r12.iterator()
        L_0x00c4:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x00be
            java.lang.Object r15 = r12.next()
            io.intercom.android.sdk.blocks.lib.models.Block r15 = (io.intercom.android.sdk.blocks.lib.models.Block) r15
            io.intercom.android.sdk.blocks.lib.BlockType r15 = r15.getType()
            io.intercom.android.sdk.blocks.lib.BlockType r10 = io.intercom.android.sdk.blocks.lib.BlockType.CREATETICKETCARD
            if (r15 != r10) goto L_0x00da
            r10 = 1
            goto L_0x00db
        L_0x00da:
            r10 = 0
        L_0x00db:
            if (r10 == 0) goto L_0x00df
            r10 = 1
            goto L_0x00e1
        L_0x00df:
            r10 = 0
            goto L_0x00c4
        L_0x00e1:
            if (r10 == 0) goto L_0x00fa
            io.intercom.android.sdk.models.Conversation r10 = r30.getParentConversation()
            io.intercom.android.sdk.models.Ticket r10 = r10.getTicket()
            io.intercom.android.sdk.models.Ticket$Companion r12 = io.intercom.android.sdk.models.Ticket.Companion
            io.intercom.android.sdk.models.Ticket r12 = r12.getNULL()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x00f8
            goto L_0x00fa
        L_0x00f8:
            r10 = 0
            goto L_0x00fb
        L_0x00fa:
            r10 = 1
        L_0x00fb:
            boolean r12 = hasTextBlockPart(r30)
            r15 = 16
            if (r12 == 0) goto L_0x0114
            float r12 = (float) r15
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            r15 = 12
            float r15 = (float) r15
            float r15 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r15)
            androidx.compose.foundation.layout.PaddingValues r12 = androidx.compose.foundation.layout.PaddingKt.m504PaddingValuesYgX7TsA(r12, r15)
            goto L_0x011d
        L_0x0114:
            float r12 = (float) r4
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            androidx.compose.foundation.layout.PaddingValues r12 = androidx.compose.foundation.layout.PaddingKt.m503PaddingValues0680j_4(r12)
        L_0x011d:
            r16 = r12
            boolean r12 = hasSingleBlockPartWithShadow(r30)
            r15 = 4
            if (r12 == 0) goto L_0x0128
            float r12 = (float) r15
            goto L_0x0129
        L_0x0128:
            float r12 = (float) r4
        L_0x0129:
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            androidx.compose.ui.Modifier$Companion r17 = androidx.compose.ui.Modifier.Companion
            r15 = r17
            androidx.compose.ui.Modifier r15 = (androidx.compose.ui.Modifier) r15
            r4 = 0
            r11 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r15, r4, r14, r11)
            r15 = 3
            androidx.compose.ui.Modifier r4 = androidx.compose.animation.AnimationModifierKt.animateContentSize$default(r4, r11, r11, r15, r11)
            r15 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r15)
            java.lang.String r15 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.foundation.layout.Arrangement r15 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r15 = r15.getTop()
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r11 = r17.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r15, r11, r0, r14)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r26 = r1
            java.lang.String r1 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r1)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r27 = r5
            r5 = r17
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r1)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r28 = r3
            r3 = r17
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r1)
            java.lang.Object r1 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r3 = r3.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x01bf
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01bf:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x01cc
            r0.createNode(r3)
            goto L_0x01cf
        L_0x01cc:
            r0.useNode()
        L_0x01cf:
            r0.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r1, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r3 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r4.invoke(r1, r0, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r12)
            r4 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r0, r4)
            boolean r3 = r30.isAdmin()
            if (r7 == 0) goto L_0x023f
            io.intercom.android.sdk.models.Participant r4 = r30.getParticipant()
            io.intercom.android.sdk.models.Avatar r4 = r4.getAvatar()
            r17 = r4
            goto L_0x0241
        L_0x023f:
            r17 = 0
        L_0x0241:
            r15 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            boolean r4 = r0.changed((java.lang.Object) r13)
            java.lang.Object r5 = r0.rememberedValue()
            if (r4 != 0) goto L_0x025f
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x026a
        L_0x025f:
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$2$1$1 r4 = new io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$2$1$1
            r4.<init>(r13)
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r0.updateRememberedValue(r5)
        L_0x026a:
            r0.endReplaceableGroup()
            r18 = r5
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r4 = -1407073954(0xffffffffac21c15e, float:-2.2986816E-12)
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$2$2 r5 = new io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$2$2
            r5.<init>(r2, r8, r9, r10)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r4, r10, r5)
            r20 = r4
            kotlin.jvm.functions.Function4 r20 = (kotlin.jvm.functions.Function4) r20
            r4 = 100925440(0x6040000, float:2.482644E-35)
            int r5 = r24 >> 12
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r24 >> 15
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            r5 = 29360128(0x1c00000, float:7.052966E-38)
            int r11 = r24 >> 3
            r5 = r5 & r11
            r22 = r4 | r5
            r23 = 8
            r4 = r12
            r12 = r3
            r3 = r13
            r13 = r7
            r5 = 1
            r14 = r8
            r10 = 16
            r11 = 4
            r19 = r25
            r21 = r0
            MessageBubbleRow(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r12 = -180404842(0xfffffffff53f3d96, float:-2.4242622E32)
            r0.startReplaceableGroup(r12)
            boolean r3 = m5407MessageRow$lambda1(r3)
            r12 = 6
            if (r3 == 0) goto L_0x030f
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r11)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r3, r0, r12)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r11 = 80
            if (r7 == 0) goto L_0x02d0
            r13 = 60
            float r13 = (float) r13
            goto L_0x02d1
        L_0x02d0:
            float r13 = (float) r11
        L_0x02d1:
            float r13 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r13)
            r14 = 0
            if (r7 == 0) goto L_0x02da
            float r11 = (float) r11
            goto L_0x02db
        L_0x02da:
            float r11 = (float) r10
        L_0x02db:
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            r15 = 0
            r16 = 10
            r17 = 0
            r31 = r3
            r32 = r13
            r33 = r14
            r34 = r11
            r35 = r15
            r36 = r16
            r37 = r17
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r31, r32, r33, r34, r35, r36, r37)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            if (r7 == 0) goto L_0x02ff
            androidx.compose.ui.Alignment$Horizontal r11 = r11.getStart()
            goto L_0x0303
        L_0x02ff:
            androidx.compose.ui.Alignment$Horizontal r11 = r11.getEnd()
        L_0x0303:
            androidx.compose.ui.Modifier r1 = r1.align(r3, r11)
            int r3 = r24 >> 9
            r3 = r3 & 112(0x70, float:1.57E-43)
            r11 = 0
            MessageMeta(r1, r6, r0, r3, r11)
        L_0x030f:
            r0.endReplaceableGroup()
            r1 = -180404299(0xfffffffff53f3fb5, float:-2.4243673E32)
            r0.startReplaceableGroup(r1)
            if (r28 == 0) goto L_0x0353
            java.util.List r1 = r30.getReplyOptions()
            java.lang.String r3 = "conversationPart.replyOptions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x0353
            if (r7 == 0) goto L_0x0353
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r5 = (float) r10
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r5)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r12)
            java.util.List r1 = r30.getReplyOptions()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            int r3 = r24 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r5 = 8
            r3 = r3 | r5
            r5 = r27
            r10 = 0
            io.intercom.android.sdk.views.compose.ReplyOptionsLayoutKt.ReplyOptionsLayout(r1, r5, r0, r3, r10)
            goto L_0x0356
        L_0x0353:
            r5 = r27
            r10 = 0
        L_0x0356:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r4)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r10)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x037a
            goto L_0x0395
        L_0x037a:
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$3 r13 = new io.intercom.android.sdk.views.compose.MessageRowKt$MessageRow$3
            r0 = r13
            r1 = r26
            r2 = r30
            r3 = r28
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r9
            r9 = r25
            r10 = r39
            r11 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x0395:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.compose.MessageRowKt.MessageRow(androidx.compose.ui.Modifier, io.intercom.android.sdk.models.Part, boolean, kotlin.jvm.functions.Function1, java.lang.String, boolean, java.util.List, androidx.compose.ui.graphics.Shape, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: MessageRow$lambda-1  reason: not valid java name */
    public static final boolean m5407MessageRow$lambda1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: MessageRow$lambda-2  reason: not valid java name */
    public static final void m5408MessageRow$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean hasSingleBlockPartWithShadow(Part part) {
        if (part.getBlocks().size() == 1) {
            List<BlockType> list = shadowBlockTypes;
            List<Block> blocks = part.getBlocks();
            Intrinsics.checkNotNullExpressionValue(blocks, "blocks");
            if (list.contains(((Block) CollectionsKt.first(blocks)).getType())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasTextBlockPart(Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        List<Block> blocks = part.getBlocks();
        Intrinsics.checkNotNullExpressionValue(blocks, "blocks");
        Iterable<Block> iterable = blocks;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Block type : iterable) {
            if (textBlockTypes.contains(type.getType())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r38v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void MessageBubbleRow(boolean r41, boolean r42, androidx.compose.ui.graphics.Shape r43, androidx.compose.ui.Modifier r44, androidx.compose.foundation.layout.PaddingValues r45, io.intercom.android.sdk.models.Avatar r46, kotlin.jvm.functions.Function0<kotlin.Unit> r47, boolean r48, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            r1 = r41
            r2 = r42
            r3 = r43
            r9 = r49
            r10 = r51
            r11 = r52
            java.lang.String r0 = "bubbleShape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "bubbleContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 412081982(0x188fdf3e, float:3.719005E-24)
            r4 = r50
            androidx.compose.runtime.Composer r0 = r4.startRestartGroup(r0)
            r4 = r11 & 1
            if (r4 == 0) goto L_0x0026
            r4 = r10 | 6
            goto L_0x0036
        L_0x0026:
            r4 = r10 & 14
            if (r4 != 0) goto L_0x0035
            boolean r4 = r0.changed((boolean) r1)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r4 = r4 | r10
            goto L_0x0036
        L_0x0035:
            r4 = r10
        L_0x0036:
            r6 = r11 & 2
            if (r6 == 0) goto L_0x003d
            r4 = r4 | 48
            goto L_0x004d
        L_0x003d:
            r6 = r10 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004d
            boolean r6 = r0.changed((boolean) r2)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x004a:
            r6 = 16
        L_0x004c:
            r4 = r4 | r6
        L_0x004d:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0054
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0054:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0064
            boolean r6 = r0.changed((java.lang.Object) r3)
            if (r6 == 0) goto L_0x0061
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r4 = r4 | r6
        L_0x0064:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x006b
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x007e
            r12 = r44
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x007a
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r4 = r4 | r13
            goto L_0x0080
        L_0x007e:
            r12 = r44
        L_0x0080:
            r13 = r11 & 16
            if (r13 == 0) goto L_0x0087
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0087:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x009c
            r14 = r45
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0098
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r4 = r4 | r15
            goto L_0x009e
        L_0x009c:
            r14 = r45
        L_0x009e:
            r15 = r11 & 32
            if (r15 == 0) goto L_0x00a6
            r16 = 65536(0x10000, float:9.18355E-41)
            r4 = r4 | r16
        L_0x00a6:
            r16 = r11 & 64
            if (r16 == 0) goto L_0x00b1
            r17 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r17
            r5 = r47
            goto L_0x00c6
        L_0x00b1:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r17
            r5 = r47
            if (r17 != 0) goto L_0x00c6
            boolean r17 = r0.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x00c2
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c4
        L_0x00c2:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00c4:
            r4 = r4 | r17
        L_0x00c6:
            r8 = r11 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x00d1
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r18
            r7 = r48
            goto L_0x00e6
        L_0x00d1:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r10 & r18
            r7 = r48
            if (r18 != 0) goto L_0x00e6
            boolean r19 = r0.changed((boolean) r7)
            if (r19 == 0) goto L_0x00e2
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e4
        L_0x00e2:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x00e4:
            r4 = r4 | r19
        L_0x00e6:
            r5 = r11 & 256(0x100, float:3.59E-43)
            if (r5 == 0) goto L_0x00ee
            r5 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x00ec:
            r4 = r4 | r5
            goto L_0x00ff
        L_0x00ee:
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r10
            if (r5 != 0) goto L_0x00ff
            boolean r5 = r0.changed((java.lang.Object) r9)
            if (r5 == 0) goto L_0x00fc
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00ec
        L_0x00fc:
            r5 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x00ec
        L_0x00ff:
            r5 = 32
            if (r15 != r5) goto L_0x0120
            r5 = 191739611(0xb6db6db, float:4.5782105E-32)
            r5 = r5 & r4
            r7 = 38347922(0x2492492, float:1.4777643E-37)
            if (r5 != r7) goto L_0x0120
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x0113
            goto L_0x0120
        L_0x0113:
            r0.skipToGroupEnd()
            r6 = r46
            r7 = r47
            r8 = r48
            r4 = r12
            r5 = r14
            goto L_0x04dc
        L_0x0120:
            if (r6 == 0) goto L_0x0127
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x0128
        L_0x0127:
            r5 = r12
        L_0x0128:
            r6 = 0
            if (r13 == 0) goto L_0x0135
            float r7 = (float) r6
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            androidx.compose.foundation.layout.PaddingValues r7 = androidx.compose.foundation.layout.PaddingKt.m503PaddingValues0680j_4(r7)
            goto L_0x0136
        L_0x0135:
            r7 = r14
        L_0x0136:
            r12 = 0
            if (r15 == 0) goto L_0x013c
            r22 = r12
            goto L_0x013e
        L_0x013c:
            r22 = r46
        L_0x013e:
            if (r16 == 0) goto L_0x0142
            r15 = r12
            goto L_0x0144
        L_0x0142:
            r15 = r47
        L_0x0144:
            r13 = 1
            if (r8 == 0) goto L_0x0149
            r8 = 1
            goto L_0x014b
        L_0x0149:
            r8 = r48
        L_0x014b:
            if (r2 == 0) goto L_0x0168
            r14 = 16
            float r14 = (float) r14
            float r14 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r14)
            androidx.compose.ui.unit.Dp r14 = androidx.compose.ui.unit.Dp.m4702boximpl(r14)
            r6 = 60
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.unit.Dp r6 = androidx.compose.ui.unit.Dp.m4702boximpl(r6)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r14, r6)
            goto L_0x0182
        L_0x0168:
            r6 = 80
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.unit.Dp r6 = androidx.compose.ui.unit.Dp.m4702boximpl(r6)
            r14 = 16
            float r14 = (float) r14
            float r14 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r14)
            androidx.compose.ui.unit.Dp r14 = androidx.compose.ui.unit.Dp.m4702boximpl(r14)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r6, r14)
        L_0x0182:
            java.lang.Object r14 = r6.component1()
            androidx.compose.ui.unit.Dp r14 = (androidx.compose.ui.unit.Dp) r14
            float r24 = r14.m4718unboximpl()
            java.lang.Object r6 = r6.component2()
            androidx.compose.ui.unit.Dp r6 = (androidx.compose.ui.unit.Dp) r6
            float r26 = r6.m4718unboximpl()
            r6 = -1534479426(0xffffffffa489b3be, float:-5.9718774E-17)
            r0.startReplaceableGroup(r6)
            r6 = 8
            if (r2 == 0) goto L_0x01aa
            r16 = 4294111986(0xfff2f2f2, double:2.1215732117E-314)
            long r16 = androidx.compose.ui.graphics.ColorKt.Color((long) r16)
            goto L_0x01b4
        L_0x01aa:
            androidx.compose.material.MaterialTheme r14 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r14 = r14.getColors(r0, r6)
            long r16 = r14.m1214getPrimary0d7_KjU()
        L_0x01b4:
            r30 = r16
            r0.endReplaceableGroup()
            r14 = 0
            androidx.compose.ui.Modifier r32 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r5, r14, r13, r12)
            if (r15 == 0) goto L_0x01c3
            r35 = 1
            goto L_0x01c5
        L_0x01c3:
            r35 = 0
        L_0x01c5:
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            java.lang.Object r13 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x01e3
            androidx.compose.foundation.interaction.MutableInteractionSource r13 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r13)
        L_0x01e3:
            r0.endReplaceableGroup()
            r33 = r13
            androidx.compose.foundation.interaction.MutableInteractionSource r33 = (androidx.compose.foundation.interaction.MutableInteractionSource) r33
            r34 = 0
            r36 = 0
            r37 = 0
            int r4 = r4 >> 18
            r13 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            boolean r13 = r0.changed((java.lang.Object) r15)
            java.lang.Object r14 = r0.rememberedValue()
            if (r13 != 0) goto L_0x020f
            androidx.compose.runtime.Composer$Companion r13 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r13.getEmpty()
            if (r14 != r13) goto L_0x021a
        L_0x020f:
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageBubbleRow$2$1 r13 = new io.intercom.android.sdk.views.compose.MessageRowKt$MessageBubbleRow$2$1
            r13.<init>(r15)
            r14 = r13
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r0.updateRememberedValue(r14)
        L_0x021a:
            r0.endReplaceableGroup()
            r38 = r14
            kotlin.jvm.functions.Function0 r38 = (kotlin.jvm.functions.Function0) r38
            r39 = 24
            r40 = 0
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r25 = 0
            r27 = 0
            r28 = 10
            r29 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.ui.Alignment$Companion r14 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r14 = r14.getBottom()
            androidx.compose.foundation.layout.Arrangement r16 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            if (r2 == 0) goto L_0x0244
            androidx.compose.foundation.layout.Arrangement$Horizontal r16 = r16.getStart()
            goto L_0x0248
        L_0x0244:
            androidx.compose.foundation.layout.Arrangement$Horizontal r16 = r16.getEnd()
        L_0x0248:
            r12 = r16
            r6 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r6 = 48
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r12, r14, r0, r6)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            java.lang.String r12 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r16 = r15
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            r23 = r5
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r10 = r17
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r11 = r17
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r5)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.materializerOf(r13)
            r17 = r12
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x02c2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02c2:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x02cf
            r0.createNode(r15)
            goto L_0x02d2
        L_0x02cf:
            r0.useNode()
        L_0x02d2:
            r0.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r6, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r14, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r10, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r11, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r6)
            r10 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r13.invoke(r6, r0, r11)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r6)
            r10 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            androidx.compose.foundation.layout.RowScopeInstance r10 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r10 = (androidx.compose.foundation.layout.RowScope) r10
            r10 = 810357442(0x304d12c2, float:7.460522E-10)
            r0.startReplaceableGroup(r10)
            r10 = 6
            if (r2 == 0) goto L_0x03a3
            if (r22 == 0) goto L_0x03a3
            r11 = 36
            if (r8 == 0) goto L_0x0373
            r12 = 810357530(0x304d131a, float:7.460571E-10)
            r0.startReplaceableGroup(r12)
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r12, r11)
            r14 = 0
            r15 = 0
            r18 = 0
            if (r1 == 0) goto L_0x034f
            r11 = 0
            goto L_0x035c
        L_0x034f:
            r11 = 4294046193(0xfff1f1f1, double:2.1215407056E-314)
            long r11 = androidx.compose.ui.graphics.ColorKt.Color((long) r11)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1922boximpl(r11)
        L_0x035c:
            r20 = 56
            r21 = 28
            r6 = r17
            r12 = r22
            r24 = r16
            r16 = r18
            r18 = r11
            r19 = r0
            io.intercom.android.sdk.m5.components.AvatarIconKt.m5124AvatarIconRd90Nhg(r12, r13, r14, r15, r16, r18, r19, r20, r21)
            r0.endReplaceableGroup()
            goto L_0x0390
        L_0x0373:
            r24 = r16
            r6 = r17
            r12 = 810357772(0x304d140c, float:7.4607054E-10)
            r0.startReplaceableGroup(r12)
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r12, r11)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r11, r0, r10)
            r0.endReplaceableGroup()
        L_0x0390:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            r12 = 8
            float r12 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r12)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r11, r12)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r11, r0, r10)
            goto L_0x03a7
        L_0x03a3:
            r24 = r16
            r6 = r17
        L_0x03a7:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            r12 = r30
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r11, r12, r3)
            r14 = r2 ^ 1
            r15 = 4292993505(0xffe1e1e1, double:2.1210206086E-314)
            long r1 = androidx.compose.ui.graphics.ColorKt.Color((long) r15)
            androidx.compose.ui.Modifier r1 = m5411messageBorder9LQNqLg(r11, r14, r1, r3)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.padding(r1, r7)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r11 = 4
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r2 = r2.m407spacedBy0680j_4(r11)
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = (androidx.compose.foundation.layout.Arrangement.Vertical) r2
            r11 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r11 = r11.getStart()
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r2, r11, r0, r10)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r5 = r0.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0441
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0441:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x044e
            r0.createNode(r11)
            goto L_0x0451
        L_0x044e:
            r0.useNode()
        L_0x0451:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r2, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r5, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r1.invoke(r2, r0, r6)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r2 = 0
            long r5 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r12, r0, r2)
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1922boximpl(r5)
            r4 = r4 & 896(0x380, float:1.256E-42)
            r4 = r4 | r10
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r9.invoke(r1, r2, r0, r4)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r5 = r7
            r6 = r22
            r4 = r23
            r7 = r24
        L_0x04dc:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x04e3
            goto L_0x04fa
        L_0x04e3:
            io.intercom.android.sdk.views.compose.MessageRowKt$MessageBubbleRow$4 r13 = new io.intercom.android.sdk.views.compose.MessageRowKt$MessageBubbleRow$4
            r0 = r13
            r1 = r41
            r2 = r42
            r3 = r43
            r9 = r49
            r10 = r51
            r11 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x04fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.views.compose.MessageRowKt.MessageBubbleRow(boolean, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, io.intercom.android.sdk.models.Avatar, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void MessageMeta(Modifier modifier, String str, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        String str2 = str;
        int i4 = i;
        int i5 = i2;
        Composer startRestartGroup = composer.startRestartGroup(1091292163);
        int i6 = i5 & 1;
        if (i6 != 0) {
            i3 = i4 | 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i4;
        } else {
            modifier2 = modifier;
            i3 = i4;
        }
        if ((i5 & 2) != 0) {
            i3 |= 48;
        } else if ((i4 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) str2) ? 32 : 16;
        }
        int i7 = i3;
        if ((i7 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
            composer2 = startRestartGroup;
            TextKt.m1496TextfLXpl1I(str, PaddingKt.m512paddingVpY3zN4$default(modifier3, 0.0f, Dp.m4704constructorimpl((float) 2), 1, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getCaption(), composer2, (i7 >> 3) & 14, 0, 32764);
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MessageRowKt$MessageMeta$1(modifier2, str, i, i2));
        }
    }

    public static final float contentAlpha(boolean z, Composer composer, int i) {
        float f;
        composer.startReplaceableGroup(-1686479602);
        if (z) {
            composer.startReplaceableGroup(-1151775444);
            f = ContentAlpha.INSTANCE.getHigh(composer, 8);
        } else {
            composer.startReplaceableGroup(-1151775421);
            f = ContentAlpha.INSTANCE.getDisabled(composer, 8);
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return f;
    }

    public static final void MessagesPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(961075041);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$MessageRowKt.INSTANCE.m5405getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MessageRowKt$MessagesPreview$1(i));
        }
    }

    /* renamed from: messageBorder-9LQNqLg  reason: not valid java name */
    public static final Modifier m5411messageBorder9LQNqLg(Modifier modifier, boolean z, long j, Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$messageBorder");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return z ? BorderKt.m182borderxT4_qwU(modifier, Dp.m4704constructorimpl((float) 1), j, shape) : modifier;
    }
}
