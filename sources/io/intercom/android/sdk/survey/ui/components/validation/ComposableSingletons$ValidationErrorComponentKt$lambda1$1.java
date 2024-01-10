package io.intercom.android.sdk.survey.ui.components.validation;

import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.survey.ValidationError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.survey.ui.components.validation.ComposableSingletons$ValidationErrorComponentKt$lambda-1$1  reason: invalid class name */
/* compiled from: ValidationErrorComponent.kt */
final class ComposableSingletons$ValidationErrorComponentKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ValidationErrorComponentKt$lambda1$1 INSTANCE = new ComposableSingletons$ValidationErrorComponentKt$lambda1$1();

    ComposableSingletons$ValidationErrorComponentKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ValidationErrorComponentKt.m5314ValidationErrorComponentRPmYEkk(new ValidationError.ValidationStringError(R.string.intercom_inbox_error_state_title, (List) null, 2, (DefaultConstructorMarker) null), MaterialTheme.INSTANCE.getColors(composer, 8).m1208getError0d7_KjU(), composer, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
