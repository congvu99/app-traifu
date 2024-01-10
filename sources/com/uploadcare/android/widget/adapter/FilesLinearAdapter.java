package com.uploadcare.android.widget.adapter;

import android.view.ViewGroup;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.Thing;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/uploadcare/android/widget/adapter/FilesLinearAdapter;", "Lcom/uploadcare/android/widget/adapter/FilesAdapter;", "Lcom/uploadcare/android/widget/adapter/ThingLinearViewHolder;", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "clickObserver", "Lkotlin/Function1;", "Lcom/uploadcare/android/widget/data/Thing;", "", "(Lcom/uploadcare/android/widget/controller/FileType;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesLinearAdapter.kt */
public final class FilesLinearAdapter extends FilesAdapter<ThingLinearViewHolder> {
    private final Function1<Thing, Unit> clickObserver;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilesLinearAdapter(FileType fileType, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileType, (i & 2) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilesLinearAdapter(FileType fileType, Function1<? super Thing, Unit> function1) {
        super(fileType);
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        this.clickObserver = function1;
    }

    public ThingLinearViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return ThingLinearViewHolder.Companion.build(viewGroup, this.clickObserver);
    }
}
