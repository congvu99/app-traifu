package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.utilities.ColorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.home.topbars.ComposableSingletons$HomeHeaderBackdropKt$lambda-4$1  reason: invalid class name */
/* compiled from: HomeHeaderBackdrop.kt */
final class ComposableSingletons$HomeHeaderBackdropKt$lambda4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$HomeHeaderBackdropKt$lambda4$1 INSTANCE = new ComposableSingletons$HomeHeaderBackdropKt$lambda4$1();

    ComposableSingletons$HomeHeaderBackdropKt$lambda4$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            float r6 = Dp.m4704constructorimpl((float) 200);
            Iterable<String> listOf = CollectionsKt.listOf("#142C4D", "#0057FF", "#CAF4F7");
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
            for (String parseColor : listOf) {
                arrayList.add(Color.m1922boximpl(ColorKt.Color(ColorUtils.parseColor(parseColor))));
            }
            HomeHeaderBackdropKt.m5232HomeHeaderBackdroporJrPs(r6, new HeaderState.HeaderBackdropStyle.Gradient((List) arrayList, true), AnonymousClass2.INSTANCE, composer, 454);
            return;
        }
        composer.skipToGroupEnd();
    }
}
