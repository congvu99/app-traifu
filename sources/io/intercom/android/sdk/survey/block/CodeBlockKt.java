package io.intercom.android.sdk.survey.block;

import android.text.Spanned;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.text.HtmlCompat;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"CodeBlock", "", "block", "Lio/intercom/android/sdk/blocks/lib/models/Block;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lio/intercom/android/sdk/blocks/lib/models/Block;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CodeBlockPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodeBlock.kt */
public final class CodeBlockKt {
    public static final void CodeBlock(Block block, Modifier modifier, Composer composer, int i, int i2) {
        Block block2 = block;
        int i3 = i2;
        Intrinsics.checkNotNullParameter(block2, "block");
        Composer startRestartGroup = composer.startRestartGroup(-427324651);
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        Spanned fromHtml = HtmlCompat.fromHtml(block.getText(), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(block.text, Htm…at.FROM_HTML_MODE_LEGACY)");
        AnnotatedString annotatedString$default = BlockExtensionsKt.toAnnotatedString$default(fromHtml, (SpanStyle) null, 1, (Object) null);
        long r5 = Color.Companion.m1969getWhite0d7_KjU();
        long sp = TextUnitKt.getSp(14);
        TextStyle textStyle = r24;
        TextStyle textStyle2 = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) FontFamily.Companion.getMonospace(), (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (DefaultConstructorMarker) null);
        Modifier modifier3 = modifier2;
        TextKt.m1495Text4IGK_g(annotatedString$default, BackgroundKt.m177backgroundbw27NRU$default(PaddingKt.m511paddingVpY3zN4(modifier2, Dp.m4704constructorimpl((float) 16), Dp.m4704constructorimpl((float) 12)), ColorKt.Color(4285098354L), (Shape) null, 2, (Object) null), r5, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Map<String, InlineTextContent>) null, (Function1<? super TextLayoutResult, Unit>) null, textStyle, startRestartGroup, 3456, 0, 65520);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CodeBlockKt$CodeBlock$1(block2, modifier3, i, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void CodeBlockPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1610207419);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$CodeBlockKt.INSTANCE.m5299getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CodeBlockKt$CodeBlockPreview$1(i));
        }
    }
}
