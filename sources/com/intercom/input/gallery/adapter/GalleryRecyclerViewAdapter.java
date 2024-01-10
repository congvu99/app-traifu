package com.intercom.input.gallery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryImage;
import com.intercom.input.gallery.R;
import java.util.List;

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private final boolean expanded;
    private final List<GalleryImage> galleryImages;
    private final ImageLoader imageLoader;
    private final LayoutInflater layoutInflater;
    private final OnImageClickListener onImageClickListener;

    public GalleryRecyclerViewAdapter(LayoutInflater layoutInflater2, List<GalleryImage> list, boolean z, OnImageClickListener onImageClickListener2, ImageLoader imageLoader2) {
        this.layoutInflater = layoutInflater2;
        this.galleryImages = list;
        this.expanded = z;
        this.onImageClickListener = onImageClickListener2;
        this.imageLoader = imageLoader2;
    }

    public ImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int i2;
        if (this.expanded) {
            i2 = R.layout.intercom_composer_expanded_image_list_item;
        } else {
            i2 = R.layout.intercom_composer_image_list_item;
        }
        return new ImageViewHolder(this.layoutInflater.inflate(i2, viewGroup, false), this.onImageClickListener);
    }

    public void onBindViewHolder(ImageViewHolder imageViewHolder, int i) {
        GalleryImage galleryImage = this.galleryImages.get(i);
        this.imageLoader.loadImageIntoView(galleryImage, imageViewHolder.getImageView());
        imageViewHolder.bindPreview(galleryImage);
    }

    public int getItemCount() {
        return this.galleryImages.size();
    }

    public void onViewRecycled(ImageViewHolder imageViewHolder) {
        super.onViewRecycled(imageViewHolder);
        this.imageLoader.clear(imageViewHolder.getImageView());
    }

    public GalleryImage getItem(int i) {
        return this.galleryImages.get(i);
    }
}
