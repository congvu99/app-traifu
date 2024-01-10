package com.joanzapata.iconify.internal;

import android.widget.TextView;
import androidx.core.view.ViewCompat;

public interface HasOnViewAttachListener {

    public interface OnViewAttachListener {
        void onAttach();

        void onDetach();
    }

    void setOnViewAttachListener(OnViewAttachListener onViewAttachListener);

    public static class HasOnViewAttachListenerDelegate {
        private OnViewAttachListener listener;
        private final TextView view;

        public HasOnViewAttachListenerDelegate(TextView textView) {
            this.view = textView;
        }

        public void setOnViewAttachListener(OnViewAttachListener onViewAttachListener) {
            OnViewAttachListener onViewAttachListener2 = this.listener;
            if (onViewAttachListener2 != null) {
                onViewAttachListener2.onDetach();
            }
            this.listener = onViewAttachListener;
            if (ViewCompat.isAttachedToWindow(this.view) && onViewAttachListener != null) {
                onViewAttachListener.onAttach();
            }
        }

        public void onAttachedToWindow() {
            OnViewAttachListener onViewAttachListener = this.listener;
            if (onViewAttachListener != null) {
                onViewAttachListener.onAttach();
            }
        }

        public void onDetachedFromWindow() {
            OnViewAttachListener onViewAttachListener = this.listener;
            if (onViewAttachListener != null) {
                onViewAttachListener.onDetach();
            }
        }
    }
}
