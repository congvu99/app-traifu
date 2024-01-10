package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    private static final float DividerThickness = Dp.m4704constructorimpl((float) 1);
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float IndicatorHeight = Dp.m4704constructorimpl((float) 2);
    private static final float ScrollableTabRowPadding = Dp.m4704constructorimpl((float) 52);

    private TabRowDefaults() {
    }

    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    public final void m1452Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        float f2;
        long j2;
        long j3;
        float f3;
        float f4;
        Modifier modifier3;
        int i4;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(910934799);
        ComposerKt.sourceInformation(startRestartGroup, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)366@16274L7,368@16353L66:TabRow.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i3 = i5;
        }
        if ((i5 & 112) == 0) {
            if ((i2 & 2) == 0) {
                f2 = f;
                if (startRestartGroup.changed(f2)) {
                    i4 = 32;
                    i3 |= i4;
                }
            } else {
                f2 = f;
            }
            i4 = 16;
            i3 |= i4;
        } else {
            f2 = f;
        }
        if ((i5 & 896) == 0) {
            j2 = j;
            i3 |= ((i2 & 4) != 0 || !startRestartGroup.changed(j2)) ? 128 : 256;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else {
            if ((i5 & 7168) == 0) {
                i3 |= startRestartGroup.changed((Object) this) ? 2048 : 1024;
            }
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    f4 = DividerThickness;
                    i3 &= -113;
                } else {
                    f4 = f2;
                }
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    j3 = Color.m1931copywmQWz5c$default(((Color) consume).m1942unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -897;
                    startRestartGroup.endDefaults();
                    DividerKt.m1254DivideroMI9zvI(modifier3, j3, f4, 0.0f, startRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | ((i3 << 3) & 896), 8);
                    f3 = f4;
                    modifier2 = modifier3;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier2;
                f4 = f2;
            }
            j3 = j2;
            startRestartGroup.endDefaults();
            DividerKt.m1254DivideroMI9zvI(modifier3, j3, f4, 0.0f, startRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | ((i3 << 3) & 896), 8);
            f3 = f4;
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            f3 = f2;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowDefaults$Divider$1(this, modifier2, f3, j3, i, i2));
        }
    }

    /* renamed from: Indicator-9IZ8Weo  reason: not valid java name */
    public final void m1453Indicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        float f2;
        long j2;
        long j3;
        float f3;
        float f4;
        Modifier modifier3;
        int i4;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(1499002201);
        ComposerKt.sourceInformation(startRestartGroup, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)383@16862L7,385@16886L142:TabRow.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i3 = i5;
        }
        if ((i5 & 112) == 0) {
            if ((i2 & 2) == 0) {
                f2 = f;
                if (startRestartGroup.changed(f2)) {
                    i4 = 32;
                    i3 |= i4;
                }
            } else {
                f2 = f;
            }
            i4 = 16;
            i3 |= i4;
        } else {
            f2 = f;
        }
        if ((i5 & 896) == 0) {
            j2 = j;
            i3 |= ((i2 & 4) != 0 || !startRestartGroup.changed(j2)) ? 128 : 256;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else {
            if ((i5 & 7168) == 0) {
                i3 |= startRestartGroup.changed((Object) this) ? 2048 : 1024;
            }
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
                f4 = (i2 & 2) != 0 ? IndicatorHeight : f2;
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    j2 = ((Color) consume).m1942unboximpl();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                int i7 = i2 & 2;
                int i8 = i2 & 4;
                modifier3 = modifier2;
                f4 = f2;
            }
            startRestartGroup.endDefaults();
            BoxKt.Box(BackgroundKt.m177backgroundbw27NRU$default(SizeKt.m568height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f4), j2, (Shape) null, 2, (Object) null), startRestartGroup, 0);
            f3 = f4;
            j3 = j2;
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            f3 = f2;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowDefaults$Indicator$1(this, modifier2, f3, j3, i, i2));
        }
    }

    /* renamed from: getDividerThickness-D9Ej5fM  reason: not valid java name */
    public final float m1454getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* renamed from: getIndicatorHeight-D9Ej5fM  reason: not valid java name */
    public final float m1455getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* renamed from: getScrollableTabRowPadding-D9Ej5fM  reason: not valid java name */
    public final float m1456getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    public final Modifier tabIndicatorOffset(Modifier modifier, TabPosition tabPosition) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(tabPosition, "currentTabPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(tabPosition) : InspectableValueKt.getNoInspectorInfo(), new TabRowDefaults$tabIndicatorOffset$2(tabPosition));
    }
}
