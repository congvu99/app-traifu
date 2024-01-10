package com.trainerfu.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.Util;

public class ShareView extends RelativeLayout {
    private Bitmap photo;
    private ShareType type;

    public void setAward(String str) {
    }

    public ShareView(Context context, ShareType shareType, Bitmap bitmap) {
        super(context, (AttributeSet) null, 0);
        this.type = shareType;
        this.photo = bitmap;
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.share_view, this);
        EditText editText = (EditText) findViewById(R.id.commentET);
        if (this.type == ShareType.PHOTO) {
            ImageView imageView = (ImageView) findViewById(R.id.photoIV);
            imageView.setVisibility(0);
            imageView.setImageBitmap(this.photo);
            editText.setHint(R.string.describePhoto);
            return;
        }
        findViewById(R.id.toolbarDivider).setVisibility(0);
        ((IconTextView) findViewById(R.id.addPhotoBtn)).setVisibility(0);
        if (this.type == ShareType.COMPLETED_WORKOUT) {
            editText.setHint(R.string.howDidItGo);
        } else {
            editText.setHint(R.string.whatDidYouDoToday);
        }
        final ImageView imageView2 = (ImageView) findViewById(R.id.photoIV);
        final ImageView imageView3 = (ImageView) findViewById(R.id.removePhotoBtn);
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                imageView3.setVisibility(8);
                imageView2.setVisibility(8);
                imageView2.setImageDrawable((Drawable) null);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setPhotoBitmap(final Context context, Bitmap bitmap) {
        ImageView imageView = (ImageView) findViewById(R.id.photoIV);
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        ((ImageView) findViewById(R.id.removePhotoBtn)).setVisibility(0);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        final int scrollY = scrollView.getScrollY();
        if (Util.sizeInDpi(context, ((EditText) findViewById(R.id.commentET)).getHeight()) > 70) {
            scrollView.post(new Runnable() {
                public void run() {
                    scrollView.smoothScrollTo(0, scrollY + Util.sizeInPx(context, 50));
                }
            });
        }
    }

    public void registerAddPhotoBtnForContextMenu(Activity activity, View.OnCreateContextMenuListener onCreateContextMenuListener) {
        IconTextView iconTextView = (IconTextView) findViewById(R.id.addPhotoBtn);
        activity.registerForContextMenu(iconTextView);
        iconTextView.setOnCreateContextMenuListener(onCreateContextMenuListener);
    }

    public void setAddPhotoBtnOnClickListener(View.OnClickListener onClickListener) {
        ((IconTextView) findViewById(R.id.addPhotoBtn)).setOnClickListener(onClickListener);
    }

    public void setCommentBoxTextWatcher(TextWatcher textWatcher) {
        ((EditText) findViewById(R.id.commentET)).addTextChangedListener(textWatcher);
    }

    public Bitmap getPhoto() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) ((ImageView) findViewById(R.id.photoIV)).getDrawable();
        if (bitmapDrawable == null) {
            return null;
        }
        return bitmapDrawable.getBitmap();
    }

    public String getComment() {
        String trim = ((EditText) findViewById(R.id.commentET)).getText().toString().trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }

    public boolean isShared() {
        return ((CheckBox) findViewById(R.id.share_cb)).isChecked();
    }
}
