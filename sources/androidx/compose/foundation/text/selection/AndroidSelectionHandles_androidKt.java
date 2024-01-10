package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a$\u0010\u001f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DefaultSelectionHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/runtime/Composer;I)V", "HandlePopup", "position", "Landroidx/compose/ui/geometry/Offset;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "HandlePopup-ULxng0E", "(JLandroidx/compose/foundation/text/selection/HandleReferencePoint;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "SelectionHandle-8fL75-g", "(JZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isHandleLtrDirection", "areHandlesCrossed", "isLeft", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
public final class AndroidSelectionHandles_androidKt {
    /* renamed from: SelectionHandle-8fL75-g  reason: not valid java name */
    public static final void m978SelectionHandle8fL75g(long j, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        HandleReferencePoint handleReferencePoint;
        ResolvedTextDirection resolvedTextDirection2 = resolvedTextDirection;
        Modifier modifier2 = modifier;
        int i3 = i;
        Intrinsics.checkNotNullParameter(resolvedTextDirection2, "direction");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-616295642);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionHandle)P(5:c#ui.geometry.Offset,3,1,2,4)69@2795L823:AndroidSelectionHandles.android.kt#eksfi3");
        long j2 = j;
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        boolean z3 = z;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) resolvedTextDirection2) ? 256 : 128;
        }
        boolean z4 = z2;
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 2048 : 1024;
        }
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 16384 : 8192;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 131072 : 65536;
        }
        int i4 = i2;
        if ((374491 & i4) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616295642, i4, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:53)");
            }
            if (isLeft(z, resolvedTextDirection, z2)) {
                handleReferencePoint = HandleReferencePoint.TopRight;
            } else {
                handleReferencePoint = HandleReferencePoint.TopLeft;
            }
            HandleReferencePoint handleReferencePoint2 = handleReferencePoint;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$1 = r0;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$12 = new AndroidSelectionHandles_androidKt$SelectionHandle$1(function2, modifier, z, j, i4, resolvedTextDirection, z2);
            m977HandlePopupULxng0E(j, handleReferencePoint2, ComposableLambdaKt.composableLambda(startRestartGroup, 732099485, true, androidSelectionHandles_androidKt$SelectionHandle$1), startRestartGroup, (i4 & 14) | BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandle$2(j, z, resolvedTextDirection, z2, modifier, function2, i));
        }
    }

    public static final void DefaultSelectionHandle(Modifier modifier, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        Composer startRestartGroup = composer.startRestartGroup(47957398);
        ComposerKt.sourceInformation(startRestartGroup, "C(DefaultSelectionHandle)P(3,2)101@3820L137:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) resolvedTextDirection) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47957398, i, -1, "androidx.compose.foundation.text.selection.DefaultSelectionHandle (AndroidSelectionHandles.android.kt:95)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m584sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), z, resolvedTextDirection, z2), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1(modifier, z, resolvedTextDirection, z2, i));
        }
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new AndroidSelectionHandles_androidKt$drawSelectionHandle$1(z, resolvedTextDirection, z2), 1, (Object) null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        CacheDrawScope cacheDrawScope2 = cacheDrawScope;
        float f2 = f;
        Intrinsics.checkNotNullParameter(cacheDrawScope2, "<this>");
        int ceil = ((int) ((float) Math.ceil((double) f2))) * 2;
        ImageBitmap imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope canvasDrawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || ceil > imageBitmap.getWidth() || ceil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m2128ImageBitmapx__hDU$default(ceil, ceil, ImageBitmapConfig.Companion.m2122getAlpha8_sVssgQ(), false, (ColorSpace) null, 24, (Object) null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            HandleImageCache.INSTANCE.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long Size = androidx.compose.ui.geometry.SizeKt.Size((float) imageBitmap2.getWidth(), (float) imageBitmap2.getHeight());
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r8 = drawParams.m2413component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope2);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m2416setSizeuvyYCjk(Size);
        canvas2.save();
        DrawScope drawScope = canvasDrawScope2;
        DrawScope drawScope2 = drawScope;
        DrawScope.CC.m2514drawRectnJ9OG0$default(drawScope2, Color.Companion.m1958getBlack0d7_KjU(), 0, drawScope.m2478getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m1837getClear0nO6VwU(), 58, (Object) null);
        DrawScope.CC.m2514drawRectnJ9OG0$default(drawScope2, ColorKt.Color(4278190080L), Offset.Companion.m1699getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        ImageBitmap imageBitmap3 = imageBitmap2;
        DrawScope.CC.m2501drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(4278190080L), f, OffsetKt.Offset(f2, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m2416setSizeuvyYCjk(r8);
        return imageBitmap3;
    }

    /* renamed from: HandlePopup-ULxng0E  reason: not valid java name */
    public static final void m977HandlePopupULxng0E(long j, HandleReferencePoint handleReferencePoint, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        HandleReferencePoint handleReferencePoint2 = handleReferencePoint;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Intrinsics.checkNotNullParameter(handleReferencePoint2, "handleReferencePoint");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1409050158);
        ComposerKt.sourceInformation(startRestartGroup, "C(HandlePopup)P(2:c#ui.geometry.Offset,1)231@8057L113,235@8176L217:AndroidSelectionHandles.android.kt#eksfi3");
        long j2 = j;
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) handleReferencePoint2) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1409050158, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:224)");
            }
            long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m1683getXimpl(j)), MathKt.roundToInt(Offset.m1684getYimpl(j)));
            IntOffset r0 = IntOffset.m4813boximpl(IntOffset);
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) r0) | startRestartGroup.changed((Object) handleReferencePoint2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new HandlePositionProvider(handleReferencePoint2, IntOffset, (DefaultConstructorMarker) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidPopup_androidKt.Popup((HandlePositionProvider) rememberedValue, (Function0<Unit>) null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, startRestartGroup, (i2 << 3) & 7168, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$HandlePopup$1(j, handleReferencePoint, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean isLeft(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        if (z) {
            return isHandleLtrDirection(resolvedTextDirection, z2);
        }
        return !isHandleLtrDirection(resolvedTextDirection, z2);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection resolvedTextDirection, boolean z) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        return (resolvedTextDirection == ResolvedTextDirection.Ltr && !z) || (resolvedTextDirection == ResolvedTextDirection.Rtl && z);
    }
}
