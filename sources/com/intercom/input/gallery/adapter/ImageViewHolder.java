package com.intercom.input.gallery.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/intercom/input/gallery/adapter/ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onImageClickListener", "Lcom/intercom/input/gallery/adapter/OnImageClickListener;", "(Landroid/view/View;Lcom/intercom/input/gallery/adapter/OnImageClickListener;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "bindPreview", "", "image", "Lcom/intercom/input/gallery/GalleryImage;", "input-gallery_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ImageViewHolder.kt */
public final class ImageViewHolder extends RecyclerView.ViewHolder {
    private final ImageView imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageViewHolder(View view, OnImageClickListener onImageClickListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(onImageClickListener, "onImageClickListener");
        View findViewById = view.findViewById(R.id.thumbnail);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.thumbnail)");
        this.imageView = (ImageView) findViewById;
        view.setOnClickListener(new View.OnClickListener(this) {
            public final /* synthetic */ ImageViewHolder f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ImageViewHolder.m5090_init_$lambda0(OnImageClickListener.this, this.f$1, view);
            }
        });
    }

    public final ImageView getImageView() {
        return this.imageView;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m5090_init_$lambda0(OnImageClickListener onImageClickListener, ImageViewHolder imageViewHolder, View view) {
        Intrinsics.checkNotNullParameter(onImageClickListener, "$onImageClickListener");
        Intrinsics.checkNotNullParameter(imageViewHolder, "this$0");
        onImageClickListener.onImageClicked(imageViewHolder);
    }

    public final void bindPreview(GalleryImage galleryImage) {
        Intrinsics.checkNotNullParameter(galleryImage, "image");
        TextView textView = (TextView) this.itemView.findViewById(R.id.video_duration);
        View findViewById = this.itemView.findViewById(R.id.video_duration_shadow);
        if (galleryImage.isVideo()) {
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(galleryImage.getDuration());
            return;
        }
        findViewById.setVisibility(8);
        textView.setVisibility(8);
    }
}
