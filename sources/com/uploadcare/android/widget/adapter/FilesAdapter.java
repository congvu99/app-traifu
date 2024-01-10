package com.uploadcare.android.widget.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.uploadcare.android.widget.adapter.BaseViewHolder;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.data.Thing;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u0002J\u0006\u0010\u000e\u001a\u00020\u000bJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001d\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/uploadcare/android/widget/adapter/FilesAdapter;", "VH", "Lcom/uploadcare/android/widget/adapter/BaseViewHolder;", "Lcom/uploadcare/android/widget/data/Thing;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "(Lcom/uploadcare/android/widget/controller/FileType;)V", "dataList", "", "addItems", "", "data", "", "clear", "getData", "getItemCount", "", "onBindViewHolder", "holder", "position", "(Lcom/uploadcare/android/widget/adapter/BaseViewHolder;I)V", "updateItems", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: FilesAdapter.kt */
public abstract class FilesAdapter<VH extends BaseViewHolder<? super Thing>> extends RecyclerView.Adapter<VH> {
    private final List<Thing> dataList = new ArrayList();
    private final FileType fileType;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FileType.any.ordinal()] = 1;
            $EnumSwitchMapping$0[FileType.video.ordinal()] = 2;
            $EnumSwitchMapping$0[FileType.image.ordinal()] = 3;
        }
    }

    public FilesAdapter(FileType fileType2) {
        Intrinsics.checkNotNullParameter(fileType2, "fileType");
        this.fileType = fileType2;
    }

    public void onBindViewHolder(VH vh, int i) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        vh.bind(this.dataList.get(i));
        vh.getBinding().executePendingBindings();
    }

    public int getItemCount() {
        return this.dataList.size();
    }

    public final List<Thing> getData() {
        return this.dataList;
    }

    public final void clear() {
        this.dataList.clear();
        notifyDataSetChanged();
    }

    public final void updateItems(List<Thing> list) {
        clear();
        addItems(list);
    }

    private final void addItems(List<Thing> list) {
        if (list != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.fileType.ordinal()];
            if (i == 1) {
                this.dataList.addAll(list);
                notifyDataSetChanged();
            } else if (i == 2 || i == 3) {
                for (Thing next : list) {
                    if (StringsKt.equals(next.getObjectType(), Thing.TYPE_ALBUM, true) || StringsKt.equals(next.getObjectType(), Thing.TYPE_FOLDER, true)) {
                        this.dataList.add(next);
                        notifyItemInserted(this.dataList.size() - 1);
                    } else {
                        String mimetype = next.getMimetype();
                        if (mimetype != null && StringsKt.startsWith(mimetype, this.fileType.name(), true)) {
                            this.dataList.add(next);
                            notifyItemInserted(this.dataList.size() - 1);
                        }
                    }
                }
            }
        }
    }
}
