package com.afollestad.materialdialogs.simplelist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.util.DialogUtils;

public class MaterialSimpleListItem {
    private final Builder mBuilder;

    private MaterialSimpleListItem(Builder builder) {
        this.mBuilder = builder;
    }

    public Drawable getIcon() {
        return this.mBuilder.mIcon;
    }

    public CharSequence getContent() {
        return this.mBuilder.mContent;
    }

    public int getIconPadding() {
        return this.mBuilder.mIconPadding;
    }

    public int getBackgroundColor() {
        return this.mBuilder.mBackgroundColor;
    }

    public long getId() {
        return this.mBuilder.mId;
    }

    public Object getTag() {
        return this.mBuilder.mTag;
    }

    public static class Builder {
        protected int mBackgroundColor = Color.parseColor("#BCBCBC");
        protected CharSequence mContent;
        private final Context mContext;
        protected Drawable mIcon;
        protected int mIconPadding;
        protected long mId;
        protected Object mTag;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder icon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }

        public Builder icon(int i) {
            return icon(ContextCompat.getDrawable(this.mContext, i));
        }

        public Builder iconPadding(int i) {
            this.mIconPadding = i;
            return this;
        }

        public Builder iconPaddingDp(int i) {
            this.mIconPadding = (int) TypedValue.applyDimension(1, (float) i, this.mContext.getResources().getDisplayMetrics());
            return this;
        }

        public Builder iconPaddingRes(int i) {
            return iconPadding(this.mContext.getResources().getDimensionPixelSize(i));
        }

        public Builder content(CharSequence charSequence) {
            this.mContent = charSequence;
            return this;
        }

        public Builder content(int i) {
            return content((CharSequence) this.mContext.getString(i));
        }

        public Builder backgroundColor(int i) {
            this.mBackgroundColor = i;
            return this;
        }

        public Builder backgroundColorRes(int i) {
            return backgroundColor(DialogUtils.getColor(this.mContext, i));
        }

        public Builder backgroundColorAttr(int i) {
            return backgroundColor(DialogUtils.resolveColor(this.mContext, i));
        }

        public Builder id(long j) {
            this.mId = j;
            return this;
        }

        public Builder tag(Object obj) {
            this.mTag = obj;
            return this;
        }

        public MaterialSimpleListItem build() {
            return new MaterialSimpleListItem(this);
        }
    }

    public String toString() {
        return getContent() != null ? getContent().toString() : "(no content)";
    }
}
