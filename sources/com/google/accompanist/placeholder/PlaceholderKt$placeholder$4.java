package com.google.accompanist.placeholder;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Placeholder.kt */
final class PlaceholderKt$placeholder$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ long $color;
    final /* synthetic */ Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> $contentFadeTransitionSpec;
    final /* synthetic */ PlaceholderHighlight $highlight;
    final /* synthetic */ Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> $placeholderFadeTransitionSpec;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $visible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaceholderKt$placeholder$4(Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function3, Function3<? super Transition.Segment<Boolean>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> function32, PlaceholderHighlight placeholderHighlight, boolean z, long j, Shape shape) {
        super(3);
        this.$placeholderFadeTransitionSpec = function3;
        this.$contentFadeTransitionSpec = function32;
        this.$highlight = placeholderHighlight;
        this.$visible = z;
        this.$color = j;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(-1214629560);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Ref();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Ref ref = (Ref) rememberedValue;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Ref();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Ref ref2 = (Ref) rememberedValue2;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Ref();
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Ref ref3 = (Ref) rememberedValue3;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue4;
        boolean z = this.$visible;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new MutableTransitionState(Boolean.valueOf(z));
            composer2.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        MutableTransitionState mutableTransitionState = (MutableTransitionState) rememberedValue5;
        mutableTransitionState.setTargetState(Boolean.valueOf(this.$visible));
        Unit unit = Unit.INSTANCE;
        Transition updateTransition = TransitionKt.updateTransition(mutableTransitionState, "placeholder_crossfade", composer2, MutableTransitionState.$stable | 48, 0);
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = this.$placeholderFadeTransitionSpec;
        composer2.startReplaceableGroup(1399891485);
        ComposerKt.sourceInformation(composer2, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        composer2.startReplaceableGroup(1847725064);
        ComposerKt.sourceInformation(composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
        boolean booleanValue = ((Boolean) updateTransition.getCurrentState()).booleanValue();
        composer2.startReplaceableGroup(-2085173843);
        float f = booleanValue ? 1.0f : 0.0f;
        composer.endReplaceableGroup();
        Float valueOf = Float.valueOf(f);
        boolean booleanValue2 = ((Boolean) updateTransition.getTargetState()).booleanValue();
        composer2.startReplaceableGroup(-2085173843);
        float f2 = booleanValue2 ? 1.0f : 0.0f;
        composer.endReplaceableGroup();
        MutableState mutableState2 = mutableState;
        State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f2), function3.invoke(updateTransition.getSegment(), composer2, 0), vectorConverter, "placeholder_fade", composer, 196608);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = this.$contentFadeTransitionSpec;
        composer2.startReplaceableGroup(1399891485);
        ComposerKt.sourceInformation(composer2, "C(animateFloat)P(2)925@36712L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        composer2.startReplaceableGroup(1847725064);
        ComposerKt.sourceInformation(composer2, "C(animateValue)P(3,2)843@33302L32,844@33357L31,845@33413L23,847@33449L89:Transition.kt#pdpnli");
        boolean booleanValue3 = ((Boolean) updateTransition.getCurrentState()).booleanValue();
        composer2.startReplaceableGroup(992792551);
        float f3 = booleanValue3 ? 0.0f : 1.0f;
        composer.endReplaceableGroup();
        Float valueOf2 = Float.valueOf(f3);
        boolean booleanValue4 = ((Boolean) updateTransition.getTargetState()).booleanValue();
        composer2.startReplaceableGroup(992792551);
        float f4 = booleanValue4 ? 0.0f : 1.0f;
        composer.endReplaceableGroup();
        State<Float> createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f4), function32.invoke(updateTransition.getSegment(), composer2, 0), vectorConverter2, "content_fade", composer, 196608);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        PlaceholderHighlight placeholderHighlight = this.$highlight;
        InfiniteRepeatableSpec<Float> animationSpec = placeholderHighlight != null ? placeholderHighlight.getAnimationSpec() : null;
        composer2.startReplaceableGroup(804161798);
        if (animationSpec != null && (this.$visible || m5072invoke$lambda9(createTransitionAnimation) >= 0.01f)) {
            m5071invoke$lambda5(mutableState2, InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition(composer2, 0), 0.0f, 1.0f, animationSpec, composer, (InfiniteRepeatableSpec.$stable << 9) | InfiniteTransition.$stable | 432).getValue().floatValue());
        }
        composer.endReplaceableGroup();
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = AndroidPaint_androidKt.Paint();
            composer2.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        Paint paint = (Paint) rememberedValue6;
        Color r2 = Color.m1922boximpl(this.$color);
        Shape shape = this.$shape;
        PlaceholderHighlight placeholderHighlight2 = this.$highlight;
        long j = this.$color;
        composer2.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) r2) | composer2.changed((Object) shape) | composer2.changed((Object) placeholderHighlight2);
        Object rememberedValue7 = composer.rememberedValue();
        if (changed || rememberedValue7 == Composer.Companion.getEmpty()) {
            rememberedValue7 = DrawModifierKt.drawWithContent(modifier, new PlaceholderKt$placeholder$4$1$1(paint, ref3, shape, j, placeholderHighlight2, ref2, ref, createTransitionAnimation2, createTransitionAnimation, mutableState2));
            composer2.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceableGroup();
        Modifier modifier2 = (Modifier) rememberedValue7;
        composer.endReplaceableGroup();
        return modifier2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final float m5070invoke$lambda4(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* renamed from: invoke$lambda-5  reason: not valid java name */
    private static final void m5071invoke$lambda5(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-9  reason: not valid java name */
    public static final float m5072invoke$lambda9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-11  reason: not valid java name */
    public static final float m5069invoke$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
