package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$5 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextField$5(TextFieldValue textFieldValue, boolean z, boolean z2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors textFieldColors, int i, int i2, Shape shape) {
        super(3);
        this.$value = textFieldValue;
        this.$enabled = z;
        this.$singleLine = z2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$isError = z3;
        this.$label = function2;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$colors = textFieldColors;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(function22, "innerTextField");
        ComposerKt.sourceInformation(composer2, "C327@17161L839:OutlinedTextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = i | (composer2.changed((Object) function22) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 91) != 18 || !composer.getSkipping()) {
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String text = this.$value.getText();
            boolean z = this.$enabled;
            boolean z2 = this.$singleLine;
            VisualTransformation visualTransformation = this.$visualTransformation;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            boolean z3 = this.$isError;
            boolean z4 = z3;
            Function2<Composer, Integer, Unit> function23 = this.$label;
            Function2<Composer, Integer, Unit> function24 = this.$placeholder;
            Function2<Composer, Integer, Unit> function25 = this.$leadingIcon;
            final boolean z5 = z3;
            Function2<Composer, Integer, Unit> function26 = this.$trailingIcon;
            TextFieldColors textFieldColors = this.$colors;
            final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            TextFieldColors textFieldColors2 = textFieldColors;
            final boolean z6 = z;
            TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
            String str = text;
            final TextFieldColors textFieldColors3 = textFieldColors;
            final Shape shape = this.$shape;
            final int i3 = this.$$dirty;
            final int i4 = this.$$dirty1;
            Function2 composableLambda = ComposableLambdaKt.composableLambda(composer2, 1225313536, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C341@17765L203:OutlinedTextField.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TextFieldColors textFieldColors = textFieldColors3;
                        Shape shape = shape;
                        int i2 = 12582912 | ((i3 >> 9) & 14);
                        int i3 = i4;
                        TextFieldDefaults.INSTANCE.m1467BorderBoxnbWgWpA(z6, z5, mutableInteractionSource2, textFieldColors, shape, 0.0f, 0.0f, composer, i2 | ((i3 << 3) & 112) | ((i3 >> 12) & 896) | ((i3 >> 15) & 7168) | ((i3 >> 9) & 57344), 96);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i5 = this.$$dirty;
            int i6 = this.$$dirty1;
            int i7 = ((i2 << 3) & 112) | ((i5 >> 3) & 896) | ((i6 >> 3) & 7168) | (57344 & (i6 << 9)) | (458752 & (i6 >> 3)) | (3670016 & (i6 << 18)) | (29360128 & (i5 << 3)) | (234881024 & (i5 << 3)) | (1879048192 & (i5 << 3));
            int i8 = ((i5 >> 27) & 14) | 27648 | ((i6 >> 21) & 112);
            textFieldDefaults2.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, mutableInteractionSource, z4, function23, function24, function25, function26, textFieldColors2, (PaddingValues) null, composableLambda, composer, i7, i8, 4096);
            return;
        }
        composer.skipToGroupEnd();
    }
}
