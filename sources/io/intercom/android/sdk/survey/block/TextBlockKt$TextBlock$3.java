package io.intercom.android.sdk.survey.block;

import android.content.Context;
import android.text.Spanned;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextBlock.kt */
final class TextBlockKt$TextBlock$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ AnnotatedString $annotatedText;
    final /* synthetic */ Context $currentContext;
    final /* synthetic */ Ref.LongRef $fontSize;
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Ref.LongRef $lineHeight;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Spanned $spannedText;
    final /* synthetic */ SuffixText $suffixText;
    final /* synthetic */ Ref.IntRef $textAlign;
    final /* synthetic */ Ref.LongRef $textColor;
    final /* synthetic */ Ref.ObjectRef<TextStyle> $textStyle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextBlockKt$TextBlock$3(Ref.LongRef longRef, Ref.LongRef longRef2, Ref.ObjectRef<TextStyle> objectRef, Ref.IntRef intRef, Ref.LongRef longRef3, Modifier modifier, AnnotatedString annotatedString, MutableState<TextLayoutResult> mutableState, Spanned spanned, SuffixText suffixText, Context context) {
        super(2);
        this.$fontSize = longRef;
        this.$textColor = longRef2;
        this.$textStyle = objectRef;
        this.$textAlign = intRef;
        this.$lineHeight = longRef3;
        this.$modifier = modifier;
        this.$annotatedText = annotatedString;
        this.$layoutResult = mutableState;
        this.$spannedText = spanned;
        this.$suffixText = suffixText;
        this.$currentContext = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
        /*
            r28 = this;
            r0 = r28
            r14 = r29
            r1 = r30 & 11
            r2 = 2
            if (r1 != r2) goto L_0x0015
            boolean r1 = r29.getSkipping()
            if (r1 != 0) goto L_0x0010
            goto L_0x0015
        L_0x0010:
            r29.skipToGroupEnd()
            goto L_0x00b6
        L_0x0015:
            kotlin.jvm.internal.Ref$LongRef r1 = r0.$fontSize
            long r5 = r1.element
            kotlin.jvm.internal.Ref$LongRef r1 = r0.$textColor
            long r3 = r1.element
            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.text.TextStyle> r1 = r0.$textStyle
            T r1 = r1.element
            r21 = r1
            androidx.compose.ui.text.TextStyle r21 = (androidx.compose.ui.text.TextStyle) r21
            kotlin.jvm.internal.Ref$IntRef r1 = r0.$textAlign
            int r1 = r1.element
            kotlin.jvm.internal.Ref$LongRef r2 = r0.$lineHeight
            long r12 = r2.element
            androidx.compose.ui.Modifier r2 = r0.$modifier
            r7 = 0
            io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$1 r8 = new io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$1
            android.text.Spanned r9 = r0.$spannedText
            io.intercom.android.sdk.survey.block.SuffixText r10 = r0.$suffixText
            r8.<init>(r9, r10)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r9 = 1
            r10 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r7, r8, r9, r10)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$2 r8 = new io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$2
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.TextLayoutResult> r9 = r0.$layoutResult
            androidx.compose.ui.text.AnnotatedString r11 = r0.$annotatedText
            android.content.Context r15 = r0.$currentContext
            r8.<init>(r9, r11, r15, r10)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r2, (java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8)
            androidx.compose.ui.text.AnnotatedString r7 = r0.$annotatedText
            r8 = 0
            r9 = 0
            r17 = 0
            androidx.compose.ui.text.style.TextAlign r18 = androidx.compose.ui.text.style.TextAlign.m4547boximpl(r1)
            r19 = 0
            r22 = 0
            r26 = 0
            r27 = 0
            androidx.compose.runtime.MutableState<androidx.compose.ui.text.TextLayoutResult> r1 = r0.$layoutResult
            r11 = 1157296644(0x44faf204, float:2007.563)
            r14.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r11)
            boolean r11 = r14.changed((java.lang.Object) r1)
            java.lang.Object r15 = r29.rememberedValue()
            if (r11 != 0) goto L_0x0085
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r15 != r11) goto L_0x0090
        L_0x0085:
            io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$3$1 r11 = new io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3$3$1
            r11.<init>(r1)
            r15 = r11
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r14.updateRememberedValue(r15)
        L_0x0090:
            r29.endReplaceableGroup()
            r20 = r15
            kotlin.jvm.functions.Function1 r20 = (kotlin.jvm.functions.Function1) r20
            r23 = 0
            r24 = 0
            r25 = 31216(0x79f0, float:4.3743E-41)
            r1 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = 0
            r15 = r12
            r12 = r17
            r13 = r18
            r14 = r15
            r16 = r19
            r17 = r22
            r18 = r26
            r19 = r27
            r22 = r29
            androidx.compose.material.TextKt.m1495Text4IGK_g(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.block.TextBlockKt$TextBlock$3.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
