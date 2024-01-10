package io.intercom.android.sdk.post;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.DividerKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.Shapes;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import io.intercom.android.sdk.survey.block.BlockViewKt;
import io.intercom.android.sdk.survey.block.SuffixText;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostActivityV2.kt */
final class PostActivityV2$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ PostActivityV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostActivityV2$onCreate$1(PostActivityV2 postActivityV2) {
        super(2);
        this.this$0 = postActivityV2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, composer, 0, 1);
            final PostActivityV2 postActivityV2 = this.this$0;
            MaterialThemeKt.MaterialTheme((Colors) null, (Typography) null, (Shapes) null, ComposableLambdaKt.composableLambda(composer, 386473602, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        final PostActivityV2 postActivityV2 = postActivityV2;
                        EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer2, 70);
                        Part access$getPart = postActivityV2.getPart();
                        if (access$getPart == null) {
                            access$getPart = new Part();
                        }
                        final Part part = access$getPart;
                        long r19 = Color.Companion.m1958getBlack0d7_KjU();
                        final PostActivityV2 postActivityV22 = postActivityV2;
                        final PostActivityV2 postActivityV23 = postActivityV2;
                        final Part part2 = part;
                        final ScrollState scrollState = rememberScrollState;
                        ScaffoldKt.m1388Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, ComposableLambdaKt.composableLambda(composer2, -668879075, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    CharSequence format = Phrase.from((Context) consume, R.string.intercom_teammate_from_company).put("name", (CharSequence) part.getParticipant().getForename()).put("company", (CharSequence) ((AppConfig) postActivityV22.getAppConfigProvider().get()).getName()).format();
                                    Avatar avatar = part.getParticipant().getAvatar();
                                    Intrinsics.checkNotNullExpressionValue(avatar, "part.participant.avatar");
                                    String obj = format.toString();
                                    String access$getUserStatus = postActivityV22.getUserStatus();
                                    final PostActivityV2 postActivityV2 = postActivityV22;
                                    PostActivityV2Kt.TopBar(Modifier.Companion, avatar, obj, access$getUserStatus, new Function0<Unit>() {
                                        public final void invoke() {
                                            postActivityV2.finish();
                                        }
                                    }, composer, 70);
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(composer2, 1041771772, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                if ((i & 11) == 2 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                } else if (postActivityV23.isPreview()) {
                                    Part part = part;
                                    PostActivityV2 postActivityV2 = postActivityV23;
                                    composer.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
                                    composer.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                                    if (!(composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer.createNode(constructor);
                                    } else {
                                        composer.useNode();
                                    }
                                    composer.disableReusing();
                                    Composer r6 = Updater.m1543constructorimpl(composer);
                                    Updater.m1550setimpl(r6, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1550setimpl(r6, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1550setimpl(r6, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1550setimpl(r6, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer, 0);
                                    composer.startReplaceableGroup(2058660585);
                                    composer.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation(composer, "C79@4027L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                    DividerKt.m1254DivideroMI9zvI((Modifier) null, ColorKt.Color(2594086558L), Dp.m4704constructorimpl((float) 0.65d), 0.0f, composer, 432, 9);
                                    PostActivityV2Kt.BottomBarContent(Modifier.Companion, ComposableLambdaKt.composableLambda(composer, 356338756, true, new PostActivityV2$onCreate$1$1$3$1$1(part, postActivityV2)), composer, 54);
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                }
                            }
                        }), (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, r19, 0, ComposableLambdaKt.composableLambda(composer2, 1108863492, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
                                int i2;
                                PaddingValues paddingValues2 = paddingValues;
                                Composer composer2 = composer;
                                Intrinsics.checkNotNullParameter(paddingValues2, "it");
                                if ((i & 14) == 0) {
                                    i2 = i | (composer2.changed((Object) paddingValues2) ? 4 : 2);
                                } else {
                                    i2 = i;
                                }
                                if ((i2 & 91) != 18 || !composer.getSkipping()) {
                                    paddingValues.m520calculateBottomPaddingD9Ej5fM();
                                    int i3 = 16;
                                    float f = (float) 16;
                                    Modifier r1 = PaddingKt.m514paddingqDBjuR0$default(ScrollKt.verticalScroll$default(Modifier.Companion, scrollState, true, (FlingBehavior) null, false, 12, (Object) null), Dp.m4704constructorimpl(f), 0.0f, Dp.m4704constructorimpl(f), Dp.m4704constructorimpl((float) 56), 2, (Object) null);
                                    Part part = part2;
                                    composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer2, "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    Density density = (Density) consume;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd(composer);
                                    ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r1);
                                    if (!(composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer.useNode();
                                    }
                                    composer.disableReusing();
                                    Composer r7 = Updater.m1543constructorimpl(composer);
                                    Updater.m1550setimpl(r7, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m1550setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
                                    Updater.m1550setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                                    Updater.m1550setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                                    composer.enableReusing();
                                    materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(composer)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    composer2.startReplaceableGroup(-1163856341);
                                    ComposerKt.sourceInformation(composer2, "C79@4027L9:Column.kt#2w3rfo");
                                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                    SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 8)), composer2, 6);
                                    List<Block> blocks = part.getBlocks();
                                    if (blocks == null) {
                                        blocks = CollectionsKt.emptyList();
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(blocks, "part.blocks ?: emptyList()");
                                    }
                                    for (Block block : blocks) {
                                        composer2.startReplaceableGroup(-730708613);
                                        if (block.getType() == BlockType.SUBHEADING) {
                                            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 32)), composer2, 6);
                                        }
                                        composer.endReplaceableGroup();
                                        long r2 = Color.Companion.m1969getWhite0d7_KjU();
                                        FontWeight normal = FontWeight.Companion.getNormal();
                                        long sp = TextUnitKt.getSp(i3);
                                        long sp2 = TextUnitKt.getSp(36);
                                        long sp3 = TextUnitKt.getSp(i3);
                                        long sp4 = TextUnitKt.getSp(24);
                                        long r4 = Color.Companion.m1969getWhite0d7_KjU();
                                        int r30 = TextAlign.Companion.m4556getJustifye0LSkKk();
                                        Intrinsics.checkNotNullExpressionValue(block, "it");
                                        BlockViewKt.m5297BlockViewFU0evQE((Modifier) null, new BlockRenderData(block, (Color) null, sp, sp2, normal, Color.m1922boximpl(r2), sp3, sp4, (FontWeight) null, Color.m1922boximpl(r4), r30, 258, (DefaultConstructorMarker) null), Color.Companion.m1969getWhite0d7_KjU(), (SuffixText) null, false, (ViewGroup) null, composer, 448, 57);
                                        if (block.getType() == BlockType.SUBHEADING) {
                                            SpacerKt.Spacer(SizeKt.m568height3ABfNKs(Modifier.Companion, Dp.m4704constructorimpl((float) 32)), composer2, 6);
                                        }
                                        i3 = 16;
                                    }
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    composer.endNode();
                                    composer.endReplaceableGroup();
                                    composer.endReplaceableGroup();
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 3456, 12779520, 98291);
                        return;
                    }
                    composer.skipToGroupEnd();
                }

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "io.intercom.android.sdk.post.PostActivityV2$onCreate$1$1$1", f = "PostActivityV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: io.intercom.android.sdk.post.PostActivityV2$onCreate$1$1$1  reason: invalid class name */
                /* compiled from: PostActivityV2.kt */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(postActivityV2, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            postActivityV2.sendPostAsRead();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
