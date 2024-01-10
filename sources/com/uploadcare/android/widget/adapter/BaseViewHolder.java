package com.uploadcare.android.widget.adapter;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.data.Action;
import com.uploadcare.android.widget.data.Thing;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/widget/adapter/BaseViewHolder;", "M", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "data", "(Ljava/lang/Object;)V", "getBinding", "Landroidx/databinding/ViewDataBinding;", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesAdapter.kt */
public abstract class BaseViewHolder<M> extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public abstract void bind(M m);

    public abstract ViewDataBinding getBinding();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/uploadcare/android/widget/adapter/BaseViewHolder$Companion;", "", "()V", "getLinearPlaceHolderResource", "", "thing", "Lcom/uploadcare/android/widget/data/Thing;", "getPlaceHolderResource", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: FilesAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getPlaceHolderResource(Thing thing) {
            String url;
            Intrinsics.checkNotNullParameter(thing, "thing");
            int i = R.drawable.ucw_ic_file_grey_48dp;
            if (StringsKt.equals(thing.getObjectType(), Thing.TYPE_ALBUM, true) || StringsKt.equals(thing.getObjectType(), Thing.TYPE_FOLDER, true)) {
                return R.drawable.ucw_ic_folder_grey_48dp;
            }
            if (!StringsKt.equals(thing.getObjectType(), "photo", true) || thing.getThumbnail() == null || (!StringsKt.contains((CharSequence) thing.getThumbnail(), (CharSequence) "http", true) && !StringsKt.contains((CharSequence) thing.getThumbnail(), (CharSequence) "https", true))) {
                Action action = thing.getAction();
                if (!Intrinsics.areEqual((Object) action != null ? action.getAction() : null, (Object) Action.ACTION_SELECT_FILE) || (url = thing.getAction().getUrl()) == null) {
                    return i;
                }
                if (!Regex.Companion.fromLiteral(".*((\\.jpg)|(\\.png)).*").matches(url)) {
                    return i;
                }
            }
            return R.drawable.ucw_ic_photo_grey_48dp;
        }

        public final int getLinearPlaceHolderResource(Thing thing) {
            String url;
            Intrinsics.checkNotNullParameter(thing, "thing");
            int i = R.drawable.ucw_ic_file_grey_24dp;
            if (StringsKt.equals(thing.getObjectType(), Thing.TYPE_ALBUM, true) || StringsKt.equals(thing.getObjectType(), Thing.TYPE_FOLDER, true)) {
                return R.drawable.ucw_ic_folder_grey_24dp;
            }
            if (!StringsKt.equals(thing.getObjectType(), "photo", true) || thing.getThumbnail() == null || (!StringsKt.contains((CharSequence) thing.getThumbnail(), (CharSequence) "http", true) && !StringsKt.contains((CharSequence) thing.getThumbnail(), (CharSequence) "https", true))) {
                Action action = thing.getAction();
                if (!Intrinsics.areEqual((Object) action != null ? action.getAction() : null, (Object) Action.ACTION_SELECT_FILE) || (url = thing.getAction().getUrl()) == null) {
                    return i;
                }
                if (!Regex.Companion.fromLiteral(".*((\\.jpg)|(\\.png)).*").matches(url)) {
                    return i;
                }
            }
            return R.drawable.ucw_ic_photo_grey_24dp;
        }
    }
}
