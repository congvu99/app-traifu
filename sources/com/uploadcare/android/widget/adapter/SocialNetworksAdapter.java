package com.uploadcare.android.widget.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.databinding.DataBindingUtil;
import com.uploadcare.android.widget.R;
import com.uploadcare.android.widget.controller.FileType;
import com.uploadcare.android.widget.controller.SocialNetwork;
import com.uploadcare.android.widget.data.SocialSource;
import com.uploadcare.android.widget.data.Urls;
import com.uploadcare.android.widget.databinding.UcwDialogNetworkItemBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\"\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/uploadcare/android/widget/adapter/SocialNetworksAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/uploadcare/android/widget/data/SocialSource;", "context", "Landroid/content/Context;", "fileType", "Lcom/uploadcare/android/widget/controller/FileType;", "sources", "", "clickObserver", "Lkotlin/Function1;", "", "(Landroid/content/Context;Lcom/uploadcare/android/widget/controller/FileType;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "inflater", "Landroid/view/LayoutInflater;", "clear", "getCount", "", "getItem", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "isEmpty", "", "onSocialSourceSelected", "socialSource", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: SocialNetworksAdapter.kt */
public final class SocialNetworksAdapter extends ArrayAdapter<SocialSource> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final SocialSource socialFile = new SocialSource(CollectionsKt.emptyList(), SocialNetwork.SOCIAL_NETWORK_FILE.getRawValue(), new Urls("", "", ""));
    private static final SocialSource socialImages = new SocialSource(CollectionsKt.emptyList(), SocialNetwork.SOCIAL_NETWORK_CAMERA.getRawValue(), new Urls("", "", ""));
    private static final SocialSource socialVideos = new SocialSource(CollectionsKt.emptyList(), SocialNetwork.SOCIAL_NETWORK_VIDEOCAM.getRawValue(), new Urls("", "", ""));
    private final Function1<SocialSource, Unit> clickObserver;
    private final LayoutInflater inflater;
    private final List<SocialSource> sources;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FileType.image.ordinal()] = 1;
            $EnumSwitchMapping$0[FileType.video.ordinal()] = 2;
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialNetworksAdapter(Context context, FileType fileType, List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? FileType.any : fileType, list, (i & 8) != 0 ? null : function1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialNetworksAdapter(Context context, FileType fileType, List<SocialSource> list, Function1<? super SocialSource, Unit> function1) {
        super(context, R.layout.ucw_dialog_network_item);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "sources");
        this.sources = list;
        this.clickObserver = function1;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            this.inflater = (LayoutInflater) systemService;
            List<SocialSource> list2 = this.sources;
            if (list2.size() > 1) {
                CollectionsKt.sortWith(list2, new SocialNetworksAdapter$$special$$inlined$sortBy$1());
            }
            this.sources.add(0, socialFile);
            if (context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                if (fileType != null) {
                    int i = WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()];
                    if (i == 1) {
                        this.sources.add(0, socialImages);
                        return;
                    } else if (i == 2) {
                        this.sources.add(0, socialVideos);
                        return;
                    }
                }
                this.sources.add(0, socialVideos);
                this.sources.add(0, socialImages);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        UcwDialogNetworkItemBinding ucwDialogNetworkItemBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null || (ucwDialogNetworkItemBinding = (UcwDialogNetworkItemBinding) DataBindingUtil.getBinding(view)) == null) {
            ucwDialogNetworkItemBinding = UcwDialogNetworkItemBinding.inflate(this.inflater, viewGroup, false);
        }
        Intrinsics.checkNotNullExpressionValue(ucwDialogNetworkItemBinding, "convertView?.let {\n     …(inflater, parent, false)");
        ucwDialogNetworkItemBinding.setAdapter(this);
        ucwDialogNetworkItemBinding.setSocialSource(getItem(i));
        ucwDialogNetworkItemBinding.executePendingBindings();
        ucwDialogNetworkItemBinding.invalidateAll();
        View root = ucwDialogNetworkItemBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void onSocialSourceSelected(SocialSource socialSource) {
        Intrinsics.checkNotNullParameter(socialSource, "socialSource");
        Function1<SocialSource, Unit> function1 = this.clickObserver;
        if (function1 != null) {
            function1.invoke(socialSource);
        }
    }

    public SocialSource getItem(int i) {
        return this.sources.get(i);
    }

    public boolean isEmpty() {
        return this.sources.isEmpty();
    }

    public int getCount() {
        return this.sources.size();
    }

    public void clear() {
        super.clear();
        this.sources.clear();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/uploadcare/android/widget/adapter/SocialNetworksAdapter$Companion;", "", "()V", "socialFile", "Lcom/uploadcare/android/widget/data/SocialSource;", "socialImages", "socialVideos", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: SocialNetworksAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
