package io.intercom.android.sdk.views.holder;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.ReplyOption;
import io.intercom.android.sdk.views.compose.MessageRowKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PartViewHolderCompose.kt */
final class PartViewHolderCompose$bind$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<ViewGroup> $legacyBlocks;
    final /* synthetic */ Part $part;
    final /* synthetic */ PartViewHolderCompose this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PartViewHolderCompose$bind$1(PartViewHolderCompose partViewHolderCompose, Part part, List<? extends ViewGroup> list) {
        super(2);
        this.this$0 = partViewHolderCompose;
        this.$part = part;
        this.$legacyBlocks = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final PartViewHolderCompose partViewHolderCompose = this.this$0;
            final Part part = this.$part;
            final List<ViewGroup> list = this.$legacyBlocks;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1127427676, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        final PartViewHolderCompose partViewHolderCompose = partViewHolderCompose;
                        final Part part = part;
                        final List<ViewGroup> list = list;
                        SurfaceKt.m1419SurfaceFjzlyU((Modifier) null, (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer, 245817312, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                List<ViewGroup> list;
                                CornerBasedShape cornerBasedShape;
                                Composer composer2 = composer;
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    int bindingAdapterPosition = partViewHolderCompose.getBindingAdapterPosition();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Resources resources = ((Context) consume).getResources();
                                    boolean access$isLastPart = partViewHolderCompose.isLastPart(part);
                                    boolean z = part.isAdmin() || (!Injector.isNotInitialised() && !part.getParticipant().isUserWithId(Injector.get().getUserIdentity().getIntercomId()));
                                    final Part part = part;
                                    final PartViewHolderCompose partViewHolderCompose = partViewHolderCompose;
                                    Function1 r14 = new Function1<ReplyOption, Unit>() {
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((ReplyOption) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(ReplyOption replyOption) {
                                            Intrinsics.checkNotNullParameter(replyOption, "it");
                                            partViewHolderCompose.conversationListener.onQuickReplyClicked(part.getParticipant(), part, replyOption);
                                        }
                                    };
                                    PartViewHolderCompose partViewHolderCompose2 = partViewHolderCompose;
                                    Part part2 = part;
                                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                                    String access$getMetaString = partViewHolderCompose2.getMetaString(part2, access$isLastPart, resources);
                                    Intrinsics.checkNotNullExpressionValue(access$getMetaString, "getMetaString(part, isLastPart, resources)");
                                    List<ViewGroup> list2 = list;
                                    if (MessageRowKt.hasTextBlockPart(part)) {
                                        composer2.startReplaceableGroup(-1145615199);
                                        list = list2;
                                        cornerBasedShape = partViewHolderCompose.concatBubbleShape(part, bindingAdapterPosition, z, composer, 4104);
                                        composer.endReplaceableGroup();
                                    } else {
                                        list = list2;
                                        composer2.startReplaceableGroup(-1145615079);
                                        cornerBasedShape = MaterialTheme.INSTANCE.getShapes(composer2, 8).getMedium();
                                        composer.endReplaceableGroup();
                                    }
                                    MessageRowKt.MessageRow((Modifier) null, part, access$isLastPart, r14, access$getMetaString, z, list, cornerBasedShape, true ^ partViewHolderCompose.hasNextConcatPart(part, bindingAdapterPosition), composer, 2097216, 1);
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 1572864, 63);
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
