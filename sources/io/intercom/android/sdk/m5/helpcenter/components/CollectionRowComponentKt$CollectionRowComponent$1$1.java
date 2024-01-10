package io.intercom.android.sdk.m5.helpcenter.components;

import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CollectionRowComponent.kt */
final class CollectionRowComponentKt$CollectionRowComponent$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<String, Unit> $onClick;
    final /* synthetic */ CollectionListRow.CollectionRow $rowData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionRowComponentKt$CollectionRowComponent$1$1(Function1<? super String, Unit> function1, CollectionListRow.CollectionRow collectionRow) {
        super(0);
        this.$onClick = function1;
        this.$rowData = collectionRow;
    }

    public final void invoke() {
        this.$onClick.invoke(this.$rowData.getId());
    }
}
