package com.uploadcare.android.widget.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.squareup.picasso.Picasso;
import com.uploadcare.android.widget.BuildConfig;
import com.uploadcare.android.widget.data.Thing;
import com.uploadcare.android.widget.databinding.UcwFileLinearItemBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/uploadcare/android/widget/adapter/ThingLinearViewHolder;", "Lcom/uploadcare/android/widget/adapter/BaseViewHolder;", "Lcom/uploadcare/android/widget/data/Thing;", "binding", "Lcom/uploadcare/android/widget/databinding/UcwFileLinearItemBinding;", "clickObserver", "Lkotlin/Function1;", "", "(Lcom/uploadcare/android/widget/databinding/UcwFileLinearItemBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "data", "getBinding", "Landroidx/databinding/ViewDataBinding;", "select", "thing", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesLinearAdapter.kt */
public final class ThingLinearViewHolder extends BaseViewHolder<Thing> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final UcwFileLinearItemBinding binding;
    private final Function1<Thing, Unit> clickObserver;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThingLinearViewHolder(UcwFileLinearItemBinding ucwFileLinearItemBinding, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ucwFileLinearItemBinding, (i & 2) != 0 ? null : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ThingLinearViewHolder(com.uploadcare.android.widget.databinding.UcwFileLinearItemBinding r3, kotlin.jvm.functions.Function1<? super com.uploadcare.android.widget.data.Thing, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "binding.root"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.clickObserver = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.widget.adapter.ThingLinearViewHolder.<init>(com.uploadcare.android.widget.databinding.UcwFileLinearItemBinding, kotlin.jvm.functions.Function1):void");
    }

    public void bind(Thing thing) {
        Intrinsics.checkNotNullParameter(thing, "data");
        this.binding.setHandler(this);
        this.binding.setThing(thing);
        int linearPlaceHolderResource = BaseViewHolder.Companion.getLinearPlaceHolderResource(thing);
        String thumbnail = thing.getThumbnail();
        if (thumbnail != null) {
            if (!StringsKt.startsWith(thumbnail, "http", true) || !StringsKt.startsWith(thumbnail, "https", true)) {
                thumbnail = BuildConfig.SOCIAL_API_ENDPOINT + thumbnail;
            }
            Picasso.get().load(thumbnail).placeholder(linearPlaceHolderResource).into((ImageView) this.binding.ucwItemTb);
            return;
        }
        Picasso.get().load(linearPlaceHolderResource).into((ImageView) this.binding.ucwItemTb);
    }

    public ViewDataBinding getBinding() {
        return this.binding;
    }

    public final void select(Thing thing) {
        Intrinsics.checkNotNullParameter(thing, "thing");
        Function1<Thing, Unit> function1 = this.clickObserver;
        if (function1 != null) {
            function1.invoke(thing);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¨\u0006\u000b"}, d2 = {"Lcom/uploadcare/android/widget/adapter/ThingLinearViewHolder$Companion;", "", "()V", "build", "Lcom/uploadcare/android/widget/adapter/ThingLinearViewHolder;", "parent", "Landroid/view/ViewGroup;", "clickObserver", "Lkotlin/Function1;", "Lcom/uploadcare/android/widget/data/Thing;", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FilesLinearAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ThingLinearViewHolder build$default(Companion companion, ViewGroup viewGroup, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = null;
            }
            return companion.build(viewGroup, function1);
        }

        public final ThingLinearViewHolder build(ViewGroup viewGroup, Function1<? super Thing, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            UcwFileLinearItemBinding inflate = UcwFileLinearItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "UcwFileLinearItemBinding….context), parent, false)");
            return new ThingLinearViewHolder(inflate, function1);
        }
    }
}
