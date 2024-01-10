package io.intercom.android.sdk.views.holder;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.views.PartMetadataFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00182\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\u001e\u001a\u00020\u0015*\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u001f\u001a\u00020\u0015*\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lio/intercom/android/sdk/views/holder/PartViewHolderCompose;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "conversationListener", "Lio/intercom/android/sdk/views/holder/ConversationListener;", "partMetadataFormatter", "Lio/intercom/android/sdk/views/PartMetadataFormatter;", "(Landroid/view/View;Lio/intercom/android/sdk/views/holder/ConversationListener;Lio/intercom/android/sdk/views/PartMetadataFormatter;)V", "bind", "", "part", "Lio/intercom/android/sdk/models/Part;", "legacyBlocks", "", "Landroid/view/ViewGroup;", "concatBubbleShape", "Landroidx/compose/foundation/shape/CornerBasedShape;", "position", "", "isAdminOrAltParticipant", "", "(Lio/intercom/android/sdk/models/Part;IZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "getMetaString", "", "kotlin.jvm.PlatformType", "conversationPart", "isLastPart", "resources", "Landroid/content/res/Resources;", "hasNextConcatPart", "hasPreviousConcatPart", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PartViewHolderCompose.kt */
public final class PartViewHolderCompose extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    public final ConversationListener conversationListener;
    private final PartMetadataFormatter partMetadataFormatter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PartViewHolderCompose(View view, ConversationListener conversationListener2, PartMetadataFormatter partMetadataFormatter2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(conversationListener2, "conversationListener");
        Intrinsics.checkNotNullParameter(partMetadataFormatter2, "partMetadataFormatter");
        this.conversationListener = conversationListener2;
        this.partMetadataFormatter = partMetadataFormatter2;
    }

    public final void bind(Part part, List<? extends ViewGroup> list) {
        Intrinsics.checkNotNullParameter(part, "part");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        ((ComposeView) view).setContent(ComposableLambdaKt.composableLambdaInstance(217598202, true, new PartViewHolderCompose$bind$1(this, part, list)));
    }

    /* access modifiers changed from: private */
    public final CornerBasedShape concatBubbleShape(Part part, int i, boolean z, Composer composer, int i2) {
        CornerBasedShape cornerBasedShape;
        composer.startReplaceableGroup(1726054636);
        if (hasNextConcatPart(part, i) && hasPreviousConcatPart(part, i) && z) {
            composer.startReplaceableGroup(100408681);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), CornerSizeKt.getZeroCornerSize(), (CornerSize) null, (CornerSize) null, CornerSizeKt.getZeroCornerSize(), 6, (Object) null);
            composer.endReplaceableGroup();
        } else if (hasNextConcatPart(part, i) && hasPreviousConcatPart(part, i)) {
            composer.startReplaceableGroup(100408867);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), (CornerSize) null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), (CornerSize) null, 9, (Object) null);
            composer.endReplaceableGroup();
        } else if (hasNextConcatPart(part, i) && z) {
            composer.startReplaceableGroup(100409036);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), (CornerSize) null, (CornerSize) null, (CornerSize) null, CornerSizeKt.getZeroCornerSize(), 7, (Object) null);
            composer.endReplaceableGroup();
        } else if (hasNextConcatPart(part, i)) {
            composer.startReplaceableGroup(100409155);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), (CornerSize) null, (CornerSize) null, CornerSizeKt.getZeroCornerSize(), (CornerSize) null, 11, (Object) null);
            composer.endReplaceableGroup();
        } else if (hasPreviousConcatPart(part, i) && z) {
            composer.startReplaceableGroup(100409303);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), CornerSizeKt.getZeroCornerSize(), (CornerSize) null, (CornerSize) null, (CornerSize) null, 14, (Object) null);
            composer.endReplaceableGroup();
        } else if (hasPreviousConcatPart(part, i)) {
            composer.startReplaceableGroup(100409423);
            cornerBasedShape = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium(), (CornerSize) null, CornerSizeKt.getZeroCornerSize(), (CornerSize) null, (CornerSize) null, 13, (Object) null);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(100409490);
            cornerBasedShape = MaterialTheme.INSTANCE.getShapes(composer, 8).getMedium();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return cornerBasedShape;
    }

    private final boolean hasPreviousConcatPart(Part part, int i) {
        return i > 0 && Part.shouldConcatenate(part, this.conversationListener.getPart(i - 1));
    }

    /* access modifiers changed from: private */
    public final boolean hasNextConcatPart(Part part, int i) {
        int i2 = i + 1;
        return i2 < this.conversationListener.getCount() && Part.shouldConcatenate(part, this.conversationListener.getPart(i2));
    }

    /* access modifiers changed from: private */
    public final String getMetaString(Part part, boolean z, Resources resources) {
        return this.partMetadataFormatter.getMetadataString(part, z, resources);
    }

    /* access modifiers changed from: private */
    public final boolean isLastPart(Part part) {
        ConversationListener conversationListener2 = this.conversationListener;
        if (part != conversationListener2.getPart(conversationListener2.getCount() - 1) || Intrinsics.areEqual((Object) Part.ADMIN_IS_TYPING_STYLE, (Object) part.getMessageStyle())) {
            return false;
        }
        return true;
    }
}
