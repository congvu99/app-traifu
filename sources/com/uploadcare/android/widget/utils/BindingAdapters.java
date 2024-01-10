package com.uploadcare.android.widget.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/uploadcare/android/widget/utils/BindingAdapters;", "", "()V", "Companion", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: BindingAdapters.kt */
public final class BindingAdapters {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    @BindingAdapter({"errorText"})
    public static final void setErrorMessage(TextInputLayout textInputLayout, String str) {
        Companion.setErrorMessage(textInputLayout, str);
    }

    @JvmStatic
    @BindingAdapter({"imageDrawable"})
    public static final void setImageBitmap(ImageView imageView, Integer num) {
        Companion.setImageBitmap(imageView, num);
    }

    @JvmStatic
    @BindingAdapter({"isVisible"})
    public static final void setIsVisible(View view, boolean z) {
        Companion.setIsVisible(view, z);
    }

    private BindingAdapters() {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, d2 = {"Lcom/uploadcare/android/widget/utils/BindingAdapters$Companion;", "", "()V", "setErrorMessage", "", "view", "Lcom/google/android/material/textfield/TextInputLayout;", "errorMessage", "", "setImageBitmap", "Landroid/widget/ImageView;", "drawableRes", "", "(Landroid/widget/ImageView;Ljava/lang/Integer;)V", "setIsVisible", "Landroid/view/View;", "isVisible", "", "widget_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: BindingAdapters.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @BindingAdapter({"imageDrawable"})
        public final void setImageBitmap(ImageView imageView, Integer num) {
            Intrinsics.checkNotNullParameter(imageView, ViewHierarchyConstants.VIEW_KEY);
            if (num != null) {
                imageView.setImageResource(num.intValue());
                imageView.requestLayout();
                return;
            }
            imageView.setImageDrawable((Drawable) null);
        }

        @JvmStatic
        @BindingAdapter({"errorText"})
        public final void setErrorMessage(TextInputLayout textInputLayout, String str) {
            Intrinsics.checkNotNullParameter(textInputLayout, ViewHierarchyConstants.VIEW_KEY);
            textInputLayout.setError(str);
        }

        @JvmStatic
        @BindingAdapter({"isVisible"})
        public final void setIsVisible(View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            view.setVisibility(z ? 0 : 8);
        }
    }
}
