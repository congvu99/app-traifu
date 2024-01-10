package io.intercom.android.sdk.survey.block;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import io.intercom.android.sdk.blocks.lib.models.Block;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bz\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0019\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b'J\u0019\u0010(\u001a\u00020\u0011HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001cJ\u0019\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b+J\u0019\u0010,\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0016J\u0019\u0010.\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0016J\t\u00100\u001a\u00020\nHÆ\u0003J\u0019\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b2J\u0019\u00103\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0016J\u0019\u00105\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0016J\t\u00107\u001a\u00020\nHÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u001c\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Lio/intercom/android/sdk/survey/block/BlockRenderData;", "", "block", "Lio/intercom/android/sdk/blocks/lib/models/Block;", "textColor", "Landroidx/compose/ui/graphics/Color;", "subHeadingFontSize", "Landroidx/compose/ui/unit/TextUnit;", "subHeadingLineHeight", "subHeadingFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "subHeadingTextColor", "paragraphFontSize", "paragraphLineHeight", "paragraphFontWeight", "paragraphTextColor", "paragraphTextAlign", "Landroidx/compose/ui/text/style/TextAlign;", "(Lio/intercom/android/sdk/blocks/lib/models/Block;Landroidx/compose/ui/graphics/Color;JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/graphics/Color;JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/graphics/Color;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlock", "()Lio/intercom/android/sdk/blocks/lib/models/Block;", "getParagraphFontSize-XSAIIZE", "()J", "J", "getParagraphFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getParagraphLineHeight-XSAIIZE", "getParagraphTextAlign-e0LSkKk", "()I", "I", "getParagraphTextColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getSubHeadingFontSize-XSAIIZE", "getSubHeadingFontWeight", "getSubHeadingLineHeight-XSAIIZE", "getSubHeadingTextColor-QN2ZGVo", "getTextColor-QN2ZGVo", "component1", "component10", "component10-QN2ZGVo", "component11", "component11-e0LSkKk", "component2", "component2-QN2ZGVo", "component3", "component3-XSAIIZE", "component4", "component4-XSAIIZE", "component5", "component6", "component6-QN2ZGVo", "component7", "component7-XSAIIZE", "component8", "component8-XSAIIZE", "component9", "copy", "copy-NEjqQwY", "(Lio/intercom/android/sdk/blocks/lib/models/Block;Landroidx/compose/ui/graphics/Color;JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/graphics/Color;JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/graphics/Color;I)Lio/intercom/android/sdk/survey/block/BlockRenderData;", "equals", "", "other", "hashCode", "", "toString", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockRenderData.kt */
public final class BlockRenderData {
    private final Block block;
    private final long paragraphFontSize;
    private final FontWeight paragraphFontWeight;
    private final long paragraphLineHeight;
    private final int paragraphTextAlign;
    private final Color paragraphTextColor;
    private final long subHeadingFontSize;
    private final FontWeight subHeadingFontWeight;
    private final long subHeadingLineHeight;
    private final Color subHeadingTextColor;
    private final Color textColor;

    public /* synthetic */ BlockRenderData(Block block2, Color color, long j, long j2, FontWeight fontWeight, Color color2, long j3, long j4, FontWeight fontWeight2, Color color3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(block2, color, j, j2, fontWeight, color2, j3, j4, fontWeight2, color3, i);
    }

    /* renamed from: copy-NEjqQwY$default  reason: not valid java name */
    public static /* synthetic */ BlockRenderData m5279copyNEjqQwY$default(BlockRenderData blockRenderData, Block block2, Color color, long j, long j2, FontWeight fontWeight, Color color2, long j3, long j4, FontWeight fontWeight2, Color color3, int i, int i2, Object obj) {
        BlockRenderData blockRenderData2 = blockRenderData;
        int i3 = i2;
        return blockRenderData.m5288copyNEjqQwY((i3 & 1) != 0 ? blockRenderData2.block : block2, (i3 & 2) != 0 ? blockRenderData2.textColor : color, (i3 & 4) != 0 ? blockRenderData2.subHeadingFontSize : j, (i3 & 8) != 0 ? blockRenderData2.subHeadingLineHeight : j2, (i3 & 16) != 0 ? blockRenderData2.subHeadingFontWeight : fontWeight, (i3 & 32) != 0 ? blockRenderData2.subHeadingTextColor : color2, (i3 & 64) != 0 ? blockRenderData2.paragraphFontSize : j3, (i3 & 128) != 0 ? blockRenderData2.paragraphLineHeight : j4, (i3 & 256) != 0 ? blockRenderData2.paragraphFontWeight : fontWeight2, (i3 & 512) != 0 ? blockRenderData2.paragraphTextColor : color3, (i3 & 1024) != 0 ? blockRenderData2.paragraphTextAlign : i);
    }

    public final Block component1() {
        return this.block;
    }

    /* renamed from: component10-QN2ZGVo  reason: not valid java name */
    public final Color m5280component10QN2ZGVo() {
        return this.paragraphTextColor;
    }

    /* renamed from: component11-e0LSkKk  reason: not valid java name */
    public final int m5281component11e0LSkKk() {
        return this.paragraphTextAlign;
    }

    /* renamed from: component2-QN2ZGVo  reason: not valid java name */
    public final Color m5282component2QN2ZGVo() {
        return this.textColor;
    }

    /* renamed from: component3-XSAIIZE  reason: not valid java name */
    public final long m5283component3XSAIIZE() {
        return this.subHeadingFontSize;
    }

    /* renamed from: component4-XSAIIZE  reason: not valid java name */
    public final long m5284component4XSAIIZE() {
        return this.subHeadingLineHeight;
    }

    public final FontWeight component5() {
        return this.subHeadingFontWeight;
    }

    /* renamed from: component6-QN2ZGVo  reason: not valid java name */
    public final Color m5285component6QN2ZGVo() {
        return this.subHeadingTextColor;
    }

    /* renamed from: component7-XSAIIZE  reason: not valid java name */
    public final long m5286component7XSAIIZE() {
        return this.paragraphFontSize;
    }

    /* renamed from: component8-XSAIIZE  reason: not valid java name */
    public final long m5287component8XSAIIZE() {
        return this.paragraphLineHeight;
    }

    public final FontWeight component9() {
        return this.paragraphFontWeight;
    }

    /* renamed from: copy-NEjqQwY  reason: not valid java name */
    public final BlockRenderData m5288copyNEjqQwY(Block block2, Color color, long j, long j2, FontWeight fontWeight, Color color2, long j3, long j4, FontWeight fontWeight2, Color color3, int i) {
        Block block3 = block2;
        Intrinsics.checkNotNullParameter(block3, "block");
        Intrinsics.checkNotNullParameter(fontWeight, "subHeadingFontWeight");
        Intrinsics.checkNotNullParameter(fontWeight2, "paragraphFontWeight");
        return new BlockRenderData(block3, color, j, j2, fontWeight, color2, j3, j4, fontWeight2, color3, i, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockRenderData)) {
            return false;
        }
        BlockRenderData blockRenderData = (BlockRenderData) obj;
        return Intrinsics.areEqual((Object) this.block, (Object) blockRenderData.block) && Intrinsics.areEqual((Object) this.textColor, (Object) blockRenderData.textColor) && TextUnit.m4882equalsimpl0(this.subHeadingFontSize, blockRenderData.subHeadingFontSize) && TextUnit.m4882equalsimpl0(this.subHeadingLineHeight, blockRenderData.subHeadingLineHeight) && Intrinsics.areEqual((Object) this.subHeadingFontWeight, (Object) blockRenderData.subHeadingFontWeight) && Intrinsics.areEqual((Object) this.subHeadingTextColor, (Object) blockRenderData.subHeadingTextColor) && TextUnit.m4882equalsimpl0(this.paragraphFontSize, blockRenderData.paragraphFontSize) && TextUnit.m4882equalsimpl0(this.paragraphLineHeight, blockRenderData.paragraphLineHeight) && Intrinsics.areEqual((Object) this.paragraphFontWeight, (Object) blockRenderData.paragraphFontWeight) && Intrinsics.areEqual((Object) this.paragraphTextColor, (Object) blockRenderData.paragraphTextColor) && TextAlign.m4550equalsimpl0(this.paragraphTextAlign, blockRenderData.paragraphTextAlign);
    }

    public int hashCode() {
        int hashCode = this.block.hashCode() * 31;
        Color color = this.textColor;
        int i = 0;
        int r0 = (((((((hashCode + (color == null ? 0 : Color.m1939hashCodeimpl(color.m1942unboximpl()))) * 31) + TextUnit.m4886hashCodeimpl(this.subHeadingFontSize)) * 31) + TextUnit.m4886hashCodeimpl(this.subHeadingLineHeight)) * 31) + this.subHeadingFontWeight.hashCode()) * 31;
        Color color2 = this.subHeadingTextColor;
        int r02 = (((((((r0 + (color2 == null ? 0 : Color.m1939hashCodeimpl(color2.m1942unboximpl()))) * 31) + TextUnit.m4886hashCodeimpl(this.paragraphFontSize)) * 31) + TextUnit.m4886hashCodeimpl(this.paragraphLineHeight)) * 31) + this.paragraphFontWeight.hashCode()) * 31;
        Color color3 = this.paragraphTextColor;
        if (color3 != null) {
            i = Color.m1939hashCodeimpl(color3.m1942unboximpl());
        }
        return ((r02 + i) * 31) + TextAlign.m4551hashCodeimpl(this.paragraphTextAlign);
    }

    public String toString() {
        return "BlockRenderData(block=" + this.block + ", textColor=" + this.textColor + ", subHeadingFontSize=" + TextUnit.m4892toStringimpl(this.subHeadingFontSize) + ", subHeadingLineHeight=" + TextUnit.m4892toStringimpl(this.subHeadingLineHeight) + ", subHeadingFontWeight=" + this.subHeadingFontWeight + ", subHeadingTextColor=" + this.subHeadingTextColor + ", paragraphFontSize=" + TextUnit.m4892toStringimpl(this.paragraphFontSize) + ", paragraphLineHeight=" + TextUnit.m4892toStringimpl(this.paragraphLineHeight) + ", paragraphFontWeight=" + this.paragraphFontWeight + ", paragraphTextColor=" + this.paragraphTextColor + ", paragraphTextAlign=" + TextAlign.m4552toStringimpl(this.paragraphTextAlign) + ')';
    }

    private BlockRenderData(Block block2, Color color, long j, long j2, FontWeight fontWeight, Color color2, long j3, long j4, FontWeight fontWeight2, Color color3, int i) {
        this.block = block2;
        this.textColor = color;
        this.subHeadingFontSize = j;
        this.subHeadingLineHeight = j2;
        this.subHeadingFontWeight = fontWeight;
        this.subHeadingTextColor = color2;
        this.paragraphFontSize = j3;
        this.paragraphLineHeight = j4;
        this.paragraphFontWeight = fontWeight2;
        this.paragraphTextColor = color3;
        this.paragraphTextAlign = i;
    }

    public final Block getBlock() {
        return this.block;
    }

    /* renamed from: getTextColor-QN2ZGVo  reason: not valid java name */
    public final Color m5296getTextColorQN2ZGVo() {
        return this.textColor;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BlockRenderData(io.intercom.android.sdk.blocks.lib.models.Block r20, androidx.compose.ui.graphics.Color r21, long r22, long r24, androidx.compose.ui.text.font.FontWeight r26, androidx.compose.ui.graphics.Color r27, long r28, long r30, androidx.compose.ui.text.font.FontWeight r32, androidx.compose.ui.graphics.Color r33, int r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r4 = r1
            goto L_0x000b
        L_0x0009:
            r4 = r21
        L_0x000b:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0017
            r1 = 36
            long r1 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r1)
            r5 = r1
            goto L_0x0019
        L_0x0017:
            r5 = r22
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0025
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m4896getUnspecifiedXSAIIZE()
            r7 = r1
            goto L_0x0027
        L_0x0025:
            r7 = r24
        L_0x0027:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0033
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r1 = r1.getSemiBold()
            r9 = r1
            goto L_0x0035
        L_0x0033:
            r9 = r26
        L_0x0035:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x003b
            r10 = r4
            goto L_0x003d
        L_0x003b:
            r10 = r27
        L_0x003d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0049
            r1 = 16
            long r1 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r1)
            r11 = r1
            goto L_0x004b
        L_0x0049:
            r11 = r28
        L_0x004b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0057
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m4896getUnspecifiedXSAIIZE()
            r13 = r1
            goto L_0x0059
        L_0x0057:
            r13 = r30
        L_0x0059:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0065
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r1 = r1.getNormal()
            r15 = r1
            goto L_0x0067
        L_0x0065:
            r15 = r32
        L_0x0067:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x006e
            r16 = r4
            goto L_0x0070
        L_0x006e:
            r16 = r33
        L_0x0070:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0084
            io.intercom.android.sdk.blocks.lib.BlockAlignment r0 = r20.getAlign()
            java.lang.String r1 = "block.align"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r0 = io.intercom.android.sdk.survey.block.BlockExtensionsKt.getTextAlign(r0)
            r17 = r0
            goto L_0x0086
        L_0x0084:
            r17 = r34
        L_0x0086:
            r18 = 0
            r2 = r19
            r3 = r20
            r2.<init>(r3, r4, r5, r7, r9, r10, r11, r13, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.block.BlockRenderData.<init>(io.intercom.android.sdk.blocks.lib.models.Block, androidx.compose.ui.graphics.Color, long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.graphics.Color, long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.graphics.Color, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getSubHeadingFontSize-XSAIIZE  reason: not valid java name */
    public final long m5293getSubHeadingFontSizeXSAIIZE() {
        return this.subHeadingFontSize;
    }

    /* renamed from: getSubHeadingLineHeight-XSAIIZE  reason: not valid java name */
    public final long m5294getSubHeadingLineHeightXSAIIZE() {
        return this.subHeadingLineHeight;
    }

    public final FontWeight getSubHeadingFontWeight() {
        return this.subHeadingFontWeight;
    }

    /* renamed from: getSubHeadingTextColor-QN2ZGVo  reason: not valid java name */
    public final Color m5295getSubHeadingTextColorQN2ZGVo() {
        return this.subHeadingTextColor;
    }

    /* renamed from: getParagraphFontSize-XSAIIZE  reason: not valid java name */
    public final long m5289getParagraphFontSizeXSAIIZE() {
        return this.paragraphFontSize;
    }

    /* renamed from: getParagraphLineHeight-XSAIIZE  reason: not valid java name */
    public final long m5290getParagraphLineHeightXSAIIZE() {
        return this.paragraphLineHeight;
    }

    public final FontWeight getParagraphFontWeight() {
        return this.paragraphFontWeight;
    }

    /* renamed from: getParagraphTextColor-QN2ZGVo  reason: not valid java name */
    public final Color m5292getParagraphTextColorQN2ZGVo() {
        return this.paragraphTextColor;
    }

    /* renamed from: getParagraphTextAlign-e0LSkKk  reason: not valid java name */
    public final int m5291getParagraphTextAligne0LSkKk() {
        return this.paragraphTextAlign;
    }
}
