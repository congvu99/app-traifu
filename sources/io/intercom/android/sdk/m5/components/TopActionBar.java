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
import androidx.compose.ui.platform.AbstractComposeView;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010,\u001a\u00020\u001aH\u0017¢\u0006\u0002\u0010-R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00138F@FX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R;\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198F@FX\u0002¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0012\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010(\u001a\u00020!2\u0006\u0010\t\u001a\u00020!8F@FX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0012\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&¨\u0006."}, d2 = {"Lio/intercom/android/sdk/m5/components/TopActionBar;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "Lio/intercom/android/sdk/models/Avatar;", "avatars", "getAvatars", "()Ljava/util/List;", "setAvatars", "(Ljava/util/List;)V", "avatars$delegate", "Landroidx/compose/runtime/MutableState;", "", "isActive", "()Z", "setActive", "(Z)V", "isActive$delegate", "Lkotlin/Function0;", "", "onBackClick", "getOnBackClick", "()Lkotlin/jvm/functions/Function0;", "setOnBackClick", "(Lkotlin/jvm/functions/Function0;)V", "onBackClick$delegate", "", "subtitle", "getSubtitle", "()Ljava/lang/String;", "setSubtitle", "(Ljava/lang/String;)V", "subtitle$delegate", "title", "getTitle", "setTitle", "title$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopActionBar.kt */
public final class TopActionBar extends AbstractComposeView {
    private final MutableState avatars$delegate;
    private final MutableState isActive$delegate;
    private final MutableState onBackClick$delegate;
    private final MutableState subtitle$delegate;
    private final MutableState title$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopActionBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TopActionBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TopActionBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.subtitle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.avatars$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onBackClick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isActive$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title$delegate.setValue(str);
    }

    public final String getSubtitle() {
        return (String) this.subtitle$delegate.getValue();
    }

    public final void setSubtitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle$delegate.setValue(str);
    }

    public final List<Avatar> getAvatars() {
        return (List) this.avatars$delegate.getValue();
    }

    public final void setAvatars(List<? extends Avatar> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.avatars$delegate.setValue(list);
    }

    public final Function0<Unit> getOnBackClick() {
        return (Function0) this.onBackClick$delegate.getValue();
    }

    public final void setOnBackClick(Function0<Unit> function0) {
        this.onBackClick$delegate.setValue(function0);
    }

    public final boolean isActive() {
        return ((Boolean) this.isActive$delegate.getValue()).booleanValue();
    }

    public final void setActive(boolean z) {
        this.isActive$delegate.setValue(Boolean.valueOf(z));
    }

    public void Content(Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1923058969);
        ComposerKt.sourceInformation(startRestartGroup, "C(Content)");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1419609263, true, new TopActionBar$Content$1(this)), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TopActionBar$Content$2(this, i));
        }
    }
}
