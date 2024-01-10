package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {
    final /* synthetic */ Density $density;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ MutableState<Integer> $width$delegate;

    ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(Density density, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        this.$density = density;
        this.$menuHeight$delegate = mutableState;
        this.$width$delegate = mutableState2;
    }

    public void ExposedDropdownMenu(boolean z, Function0<Unit> function0, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(this, z, function0, modifier, function3, composer, i, i2);
    }

    public Modifier exposedDropdownSize(Modifier modifier, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Density density = this.$density;
        MutableState<Integer> mutableState = this.$menuHeight$delegate;
        MutableState<Integer> mutableState2 = this.$width$delegate;
        Modifier r7 = SizeKt.m570heightInVpY3zN4$default(modifier, 0.0f, density.m4646toDpu2uoSUM(ExposedDropdownMenuKt.m1290ExposedDropdownMenuBox$lambda4(mutableState)), 1, (Object) null);
        return z ? SizeKt.m587width3ABfNKs(r7, density.m4646toDpu2uoSUM(ExposedDropdownMenuKt.m1288ExposedDropdownMenuBox$lambda1(mutableState2))) : r7;
    }
}
