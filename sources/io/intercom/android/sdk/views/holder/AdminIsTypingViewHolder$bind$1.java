package io.intercom.android.sdk.views.holder;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.facebook.imageutils.JfifUtil;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.compose.MessageRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdminIsTypingViewHolder.kt */
final class AdminIsTypingViewHolder$bind$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ViewGroup $blocksLayout;
    final /* synthetic */ Part $part;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdminIsTypingViewHolder$bind$1(Part part, ViewGroup viewGroup) {
        super(2);
        this.$part = part;
        this.$blocksLayout = viewGroup;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final Part part = this.$part;
            final ViewGroup viewGroup = this.$blocksLayout;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, 1094182390, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        boolean isAdmin = part.isAdmin();
                        boolean isAdmin2 = part.isAdmin();
                        Avatar avatar = part.getParticipant().getAvatar();
                        final ViewGroup viewGroup = viewGroup;
                        MessageRowKt.MessageBubbleRow(isAdmin, isAdmin2, MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), (Modifier) null, (PaddingValues) null, avatar, (Function0<Unit>) null, false, ComposableLambdaKt.composableLambda(composer, 886425079, true, new Function4<ColumnScope, Color, Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                m5413invokeRPmYEkk((ColumnScope) obj, ((Color) obj2).m1942unboximpl(), (Composer) obj3, ((Number) obj4).intValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-RPmYEkk  reason: not valid java name */
                            public final void m5413invokeRPmYEkk(ColumnScope columnScope, long j, Composer composer, int i) {
                                Intrinsics.checkNotNullParameter(columnScope, "$this$MessageBubbleRow");
                                if ((i & 641) != 128 || !composer.getSkipping()) {
                                    final ViewGroup viewGroup = viewGroup;
                                    AndroidView_androidKt.AndroidView(new Function1<Context, ViewGroup>() {
                                        public final ViewGroup invoke(Context context) {
                                            Intrinsics.checkNotNullParameter(context, "it");
                                            return viewGroup;
                                        }
                                    }, PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, Dp.m4704constructorimpl((float) 16), 0.0f, 2, (Object) null), (Function1) null, composer, 48, 4);
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 100925440, JfifUtil.MARKER_SOI);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
