package io.intercom.android.sdk.survey.ui.components.validation;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.survey.ValidationError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ValidationErrorComponent.kt */
final class ValidationErrorComponentKt$ValidationErrorComponent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $errorColor;
    final /* synthetic */ ValidationError.ValidationStringError $validationStringError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ValidationErrorComponentKt$ValidationErrorComponent$2(ValidationError.ValidationStringError validationStringError, long j, int i) {
        super(2);
        this.$validationStringError = validationStringError;
        this.$errorColor = j;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ValidationErrorComponentKt.m5314ValidationErrorComponentRPmYEkk(this.$validationStringError, this.$errorColor, composer, this.$$changed | 1);
    }
}
