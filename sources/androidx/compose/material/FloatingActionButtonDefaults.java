package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* renamed from: elevation-ixp7dh8  reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1308elevationixp7dh8(float f, float f2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-654132828);
        ComposerKt.sourceInformation(composer, "C(elevation)P(0:c#ui.unit.Dp,1:c#ui.unit.Dp)219@9593L134:FloatingActionButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            f = Dp.m4704constructorimpl((float) 6);
        }
        float f3 = f;
        if ((i2 & 2) != 0) {
            f2 = Dp.m4704constructorimpl((float) 12);
        }
        float f4 = (float) 8;
        FloatingActionButtonElevation r11 = m1309elevationxZ9QkE(f3, f2, Dp.m4704constructorimpl(f4), Dp.m4704constructorimpl(f4), composer, (i & 14) | 3456 | (i & 112) | (57344 & (i << 6)), 0);
        composer.endReplaceableGroup();
        return r11;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: androidx.compose.material.DefaultFloatingActionButtonElevation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.material.DefaultFloatingActionButtonElevation} */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        if (r7 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x007d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: elevation-xZ9-QkE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.material.FloatingActionButtonElevation m1309elevationxZ9QkE(float r7, float r8, float r9, float r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r6 = this;
            r12 = 380403812(0x16ac8064, float:2.7869125E-25)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)247@10589L367:FloatingActionButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r12 = r13 & 1
            if (r12 == 0) goto L_0x0015
            r7 = 6
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
        L_0x0015:
            r1 = r7
            r7 = r13 & 2
            if (r7 == 0) goto L_0x0021
            r7 = 12
            float r7 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
        L_0x0021:
            r2 = r8
            r7 = r13 & 4
            r8 = 8
            if (r7 == 0) goto L_0x002d
            float r7 = (float) r8
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
        L_0x002d:
            r3 = r9
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0037
            float r7 = (float) r8
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
        L_0x0037:
            r4 = r10
            r7 = 4
            java.lang.Object[] r8 = new java.lang.Object[r7]
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m4702boximpl(r1)
            r10 = 0
            r8[r10] = r9
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m4702boximpl(r2)
            r12 = 1
            r8[r12] = r9
            androidx.compose.ui.unit.Dp r9 = androidx.compose.ui.unit.Dp.m4702boximpl(r3)
            r12 = 2
            r8[r12] = r9
            r9 = 3
            androidx.compose.ui.unit.Dp r12 = androidx.compose.ui.unit.Dp.m4702boximpl(r4)
            r8[r9] = r12
            r9 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r9 = 0
        L_0x0063:
            if (r10 >= r7) goto L_0x006f
            r12 = r8[r10]
            boolean r12 = r11.changed((java.lang.Object) r12)
            r9 = r9 | r12
            int r10 = r10 + 1
            goto L_0x0063
        L_0x006f:
            java.lang.Object r7 = r11.rememberedValue()
            if (r9 != 0) goto L_0x007d
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r7 != r8) goto L_0x0087
        L_0x007d:
            androidx.compose.material.DefaultFloatingActionButtonElevation r7 = new androidx.compose.material.DefaultFloatingActionButtonElevation
            r5 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r11.updateRememberedValue(r7)
        L_0x0087:
            r11.endReplaceableGroup()
            androidx.compose.material.DefaultFloatingActionButtonElevation r7 = (androidx.compose.material.DefaultFloatingActionButtonElevation) r7
            r11.endReplaceableGroup()
            androidx.compose.material.FloatingActionButtonElevation r7 = (androidx.compose.material.FloatingActionButtonElevation) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.FloatingActionButtonDefaults.m1309elevationxZ9QkE(float, float, float, float, androidx.compose.runtime.Composer, int, int):androidx.compose.material.FloatingActionButtonElevation");
    }
}
