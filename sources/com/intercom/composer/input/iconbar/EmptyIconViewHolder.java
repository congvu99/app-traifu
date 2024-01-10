package com.intercom.composer.input.iconbar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class EmptyIconViewHolder extends RecyclerView.ViewHolder {
    EmptyIconViewHolder(View view) {
        super(view);
        view.setEnabled(false);
    }
}
