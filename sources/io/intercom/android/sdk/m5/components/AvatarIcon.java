package io.intercom.android.sdk.m5.components;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010,\u001a\u00020-H\u0017¢\u0006\u0002\u0010.R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\u00188F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR/\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\u001e8F@FX\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R4\u0010&\u001a\u00020%2\u0006\u0010\t\u001a\u00020%8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Lio/intercom/android/sdk/m5/components/AvatarIcon;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lio/intercom/android/sdk/models/Avatar;", "avatar", "getAvatar", "()Lio/intercom/android/sdk/models/Avatar;", "setAvatar", "(Lio/intercom/android/sdk/models/Avatar;)V", "avatar$delegate", "Landroidx/compose/runtime/MutableState;", "avatarBackgroundColor", "getAvatarBackgroundColor", "()Ljava/lang/Integer;", "setAvatarBackgroundColor", "(Ljava/lang/Integer;)V", "avatarBackgroundColor$delegate", "", "isActive", "()Z", "setActive", "(Z)V", "isActive$delegate", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "shape$delegate", "Landroidx/compose/ui/unit/Dp;", "size", "getSize-D9Ej5fM", "()F", "setSize-0680j_4", "(F)V", "size$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarIcon.kt */
public final class AvatarIcon extends AbstractComposeView {
    private final MutableState avatar$delegate;
    private final MutableState avatarBackgroundColor$delegate;
    private final MutableState isActive$delegate;
    private final MutableState shape$delegate;
    private final MutableState size$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarIcon(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarIcon(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvatarIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Avatar avatar = Avatar.NULL;
        Intrinsics.checkNotNullExpressionValue(avatar, "NULL");
        this.avatar$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(avatar, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.shape$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.avatarBackgroundColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isActive$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.size$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m4702boximpl(Dp.m4704constructorimpl((float) 36)), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final Avatar getAvatar() {
        return (Avatar) this.avatar$delegate.getValue();
    }

    public final void setAvatar(Avatar avatar) {
        Intrinsics.checkNotNullParameter(avatar, "<set-?>");
        this.avatar$delegate.setValue(avatar);
    }

    public final Shape getShape() {
        return (Shape) this.shape$delegate.getValue();
    }

    public final void setShape(Shape shape) {
        this.shape$delegate.setValue(shape);
    }

    public final Integer getAvatarBackgroundColor() {
        return (Integer) this.avatarBackgroundColor$delegate.getValue();
    }

    public final void setAvatarBackgroundColor(Integer num) {
        this.avatarBackgroundColor$delegate.setValue(num);
    }

    public final boolean isActive() {
        return ((Boolean) this.isActive$delegate.getValue()).booleanValue();
    }

    public final void setActive(boolean z) {
        this.isActive$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: getSize-D9Ej5fM  reason: not valid java name */
    public final float m5122getSizeD9Ej5fM() {
        return ((Dp) this.size$delegate.getValue()).m4718unboximpl();
    }

    /* renamed from: setSize-0680j_4  reason: not valid java name */
    public final void m5123setSize0680j_4(float f) {
        this.size$delegate.setValue(Dp.m4702boximpl(f));
    }

    public void Content(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1956018181);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(startRestartGroup, -398742885, true, new AvatarIcon$Content$1(this)), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AvatarIcon$Content$2(this, i));
        }
    }
}
