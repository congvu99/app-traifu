package io.intercom.android.sdk.views.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment;
import com.google.accompanist.flowlayout.FlowKt;
import com.google.accompanist.flowlayout.MainAxisAlignment;
import com.google.accompanist.flowlayout.SizeMode;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.utilities.ColorUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ReplyOptionsLayout", "", "replyOptions", "", "Lio/intercom/android/sdk/models/ReplyOption;", "onReplyClicked", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ReplyOptionsLayoutPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReplyOptionsLayout.kt */
public final class ReplyOptionsLayoutKt {
    public static final void ReplyOptionsLayout(List<? extends ReplyOption> list, Function1<? super ReplyOption, Unit> function1, Composer composer, int i, int i2) {
        List<? extends ReplyOption> list2 = list;
        int i3 = i2;
        Intrinsics.checkNotNullParameter(list2, "replyOptions");
        Composer startRestartGroup = composer.startRestartGroup(325969187);
        Function1<? super ReplyOption, Unit> function12 = (i3 & 2) != 0 ? ReplyOptionsLayoutKt$ReplyOptionsLayout$1.INSTANCE : function1;
        float f = (float) 8;
        FlowKt.m5050FlowRow07r0xoM(PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, Dp.m4704constructorimpl((float) 60), 0.0f, 0.0f, 0.0f, 14, (Object) null), (SizeMode) null, MainAxisAlignment.End, Dp.m4704constructorimpl(f), (FlowCrossAxisAlignment) null, Dp.m4704constructorimpl(f), (MainAxisAlignment) null, ComposableLambdaKt.composableLambda(startRestartGroup, -195566819, true, new ReplyOptionsLayoutKt$ReplyOptionsLayout$2(list2, ColorUtils.buttonBackgroundColorVariant(ColorKt.m1987toArgb8_81llA(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU())), ColorUtils.buttonTextColorVariant(ColorKt.m1987toArgb8_81llA(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1214getPrimary0d7_KjU())), function12)), startRestartGroup, 12782982, 82);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ReplyOptionsLayoutKt$ReplyOptionsLayout$3(list2, function12, i, i3));
        }
    }

    public static final void ReplyOptionsLayoutPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-535728248);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ReplyOptionsLayoutKt.INSTANCE.m5406getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ReplyOptionsLayoutKt$ReplyOptionsLayoutPreview$1(i));
        }
    }
}
