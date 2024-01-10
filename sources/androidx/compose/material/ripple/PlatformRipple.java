package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\fJI\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "findNearestViewGroup", "Landroid/view/ViewGroup;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/ViewGroup;", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Ripple.android.kt */
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z, float f, State state, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, f, state);
    }

    private PlatformRipple(boolean z, float f, State<Color> state) {
        super(z, f, state, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: androidx.compose.material.ripple.AndroidRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: androidx.compose.material.ripple.CommonRippleIndicationInstance} */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r15v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c6, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0054, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0056;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: rememberUpdatedRippleInstance-942rkJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.material.ripple.RippleIndicationInstance m1511rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource r9, boolean r10, float r11, androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> r12, androidx.compose.runtime.State<androidx.compose.material.ripple.RippleAlpha> r13, androidx.compose.runtime.Composer r14, int r15) {
        /*
            r8 = this;
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "color"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "rippleAlpha"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 331259447(0x13be9e37, float:4.8118755E-27)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)64@2484L22,90@3354L160:Ripple.android.kt#vhb33q"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            int r15 = r15 >> 15
            r15 = r15 & 14
            android.view.ViewGroup r15 = r8.findNearestViewGroup(r14, r15)
            r0 = 1643267286(0x61f244d6, float:5.5863403E20)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "67@2658L133"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            boolean r0 = r15.isInEditMode()
            if (r0 == 0) goto L_0x0072
            r15 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            boolean r9 = r14.changed((java.lang.Object) r9)
            boolean r15 = r14.changed((java.lang.Object) r8)
            r9 = r9 | r15
            java.lang.Object r15 = r14.rememberedValue()
            if (r9 != 0) goto L_0x0056
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r15 != r9) goto L_0x0064
        L_0x0056:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r15 = new androidx.compose.material.ripple.CommonRippleIndicationInstance
            r5 = 0
            r0 = r15
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r14.updateRememberedValue(r15)
        L_0x0064:
            r14.endReplaceableGroup()
            androidx.compose.material.ripple.CommonRippleIndicationInstance r15 = (androidx.compose.material.ripple.CommonRippleIndicationInstance) r15
            r14.endReplaceableGroup()
            r14.endReplaceableGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r15 = (androidx.compose.material.ripple.RippleIndicationInstance) r15
            return r15
        L_0x0072:
            r14.endReplaceableGroup()
            r0 = 0
            r1 = 0
            int r2 = r15.getChildCount()
        L_0x007b:
            if (r1 >= r2) goto L_0x008a
            android.view.View r3 = r15.getChildAt(r1)
            boolean r4 = r3 instanceof androidx.compose.material.ripple.RippleContainer
            if (r4 == 0) goto L_0x0087
            r0 = r3
            goto L_0x008a
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x007b
        L_0x008a:
            if (r0 != 0) goto L_0x00a1
            androidx.compose.material.ripple.RippleContainer r0 = new androidx.compose.material.ripple.RippleContainer
            android.content.Context r1 = r15.getContext()
            java.lang.String r2 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.<init>(r1)
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            r15.addView(r1)
        L_0x00a1:
            r15 = -3686095(0xffffffffffc7c131, float:NaN)
            r14.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            boolean r9 = r14.changed((java.lang.Object) r9)
            boolean r15 = r14.changed((java.lang.Object) r8)
            r9 = r9 | r15
            boolean r15 = r14.changed((java.lang.Object) r0)
            r9 = r9 | r15
            java.lang.Object r15 = r14.rememberedValue()
            if (r9 != 0) goto L_0x00c8
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r15 != r9) goto L_0x00d9
        L_0x00c8:
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r15 = new androidx.compose.material.ripple.AndroidRippleIndicationInstance
            r6 = r0
            androidx.compose.material.ripple.RippleContainer r6 = (androidx.compose.material.ripple.RippleContainer) r6
            r7 = 0
            r1 = r15
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r14.updateRememberedValue(r15)
        L_0x00d9:
            r14.endReplaceableGroup()
            androidx.compose.material.ripple.AndroidRippleIndicationInstance r15 = (androidx.compose.material.ripple.AndroidRippleIndicationInstance) r15
            r14.endReplaceableGroup()
            androidx.compose.material.ripple.RippleIndicationInstance r15 = (androidx.compose.material.ripple.RippleIndicationInstance) r15
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.PlatformRipple.m1511rememberUpdatedRippleInstance942rkJo(androidx.compose.foundation.interaction.InteractionSource, boolean, float, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.Composer, int):androidx.compose.material.ripple.RippleIndicationInstance");
    }

    private final ViewGroup findNearestViewGroup(Composer composer, int i) {
        composer.startReplaceableGroup(-1737891121);
        ComposerKt.sourceInformation(composer, "C(findNearestViewGroup)105@4003L7:Ripple.android.kt#vhb33q");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        while (!(consume instanceof ViewGroup)) {
            ViewParent parent = ((View) consume).getParent();
            if (parent instanceof View) {
                Intrinsics.checkNotNullExpressionValue(parent, "parent");
                consume = parent;
            } else {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + consume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
        }
        ViewGroup viewGroup = (ViewGroup) consume;
        composer.endReplaceableGroup();
        return viewGroup;
    }
}
