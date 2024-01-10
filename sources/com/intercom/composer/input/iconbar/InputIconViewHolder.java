package com.intercom.composer.input.iconbar;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.composer.R;
import com.intercom.composer.input.Input;

class InputIconViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    final ImageView imageView;
    final InputClickedListener listener;

    InputIconViewHolder(View view, InputClickedListener inputClickedListener) {
        super(view);
        this.listener = inputClickedListener;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.input_icon_image_view);
        this.imageView = imageView2;
        imageView2.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    public void onClick(View view) {
        this.listener.onInputClicked(this);
    }

    /* access modifiers changed from: package-private */
    public void bind(Input input, boolean z) {
        ImageView imageView2 = this.imageView;
        imageView2.setImageDrawable(input.getIconDrawable(imageView2.getContext()));
        this.imageView.setSelected(z);
        this.imageView.setContentDescription(input.getUniqueIdentifier());
    }
}
