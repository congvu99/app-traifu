package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import coil.decode.GifDecoder;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import coil.transform.RoundedCornersTransformation;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.intercom.commons.utilities.ScreenUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.interfaces.ImageBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.lightbox.LightBoxActivity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.AccessibilityUtils;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ImageUtils;
import io.intercom.android.sdk.utilities.IntercomCoilKt;
import io.intercom.android.sdk.utilities.coil.GrayscaleTransformation;
import io.intercom.android.sdk.utilities.coil.RoundedCornersAnimatedTransformation;
import io.intercom.android.sdk.views.IntercomShimmerLayout;
import io.intercom.android.sdk.views.ResizableImageView;

public class NetworkImage extends Image implements ImageBlock {
    /* access modifiers changed from: private */
    public final ImageClickListener listener;
    /* access modifiers changed from: private */
    public final Twig twig = LumberMill.getLogger();
    private final UploadingImageCache uploadingImageCache;

    NetworkImage(StyleType styleType, UploadingImageCache uploadingImageCache2, ImageClickListener imageClickListener) {
        super(styleType);
        this.uploadingImageCache = uploadingImageCache2;
        this.listener = imageClickListener;
    }

    public View addImage(String str, String str2, String str3, int i, int i2, BlockAlignment blockAlignment, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        int dpToPx = ScreenUtils.dpToPx((float) i, context);
        int dpToPx2 = ScreenUtils.dpToPx((float) i2, context);
        IntercomShimmerLayout intercomShimmerLayout = new IntercomShimmerLayout(context);
        BlockUtils.createLayoutParams(intercomShimmerLayout, -2, -2);
        BlockUtils.setDefaultMarginBottom(intercomShimmerLayout);
        ResizableImageView resizableImageView = new ResizableImageView(context);
        resizableImageView.setTransitionName(LightBoxActivity.TRANSITION_KEY);
        resizableImageView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        resizableImageView.setAdjustViewBounds(true);
        resizableImageView.setScaleType(ImageView.ScaleType.FIT_START);
        setBackground(resizableImageView);
        intercomShimmerLayout.addView(resizableImageView);
        loadImageFromUrl(str, str2, context, dpToPx, dpToPx2, resizableImageView, intercomShimmerLayout);
        BlockUtils.setLayoutMarginsAndGravity(intercomShimmerLayout, blockAlignment.getGravity(), blockMetadata.isLastObject());
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            AccessibilityUtils.INSTANCE.removeClickAbilityAnnouncement(resizableImageView);
        } else if (!TextUtils.isEmpty(str3)) {
            resizableImageView.setFocusable(true);
            String str4 = str3;
            resizableImageView.setContentDescription(str3);
        }
        return intercomShimmerLayout;
    }

    private void loadImageFromUrl(String str, String str2, Context context, int i, int i2, ResizableImageView resizableImageView, ShimmerFrameLayout shimmerFrameLayout) {
        String str3 = str;
        Context context2 = context;
        ResizableImageView resizableImageView2 = resizableImageView;
        if (TextUtils.isEmpty(str)) {
            hideLoadingState(shimmerFrameLayout, resizableImageView2);
            resizableImageView2.setImageResource(R.drawable.intercom_image_load_failed);
            resizableImageView2.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        ShimmerFrameLayout shimmerFrameLayout2 = shimmerFrameLayout;
        ImageRequest.Builder data = new ImageRequest.Builder(context2).error(R.drawable.intercom_image_load_failed).crossfade(true).target((ImageView) resizableImageView2).data(str);
        setImageViewBounds(i, i2, resizableImageView2, data);
        Resources resources = context.getResources();
        if (getStyle() != StyleType.CAROUSEL) {
            if (ImageUtils.isGif(str)) {
                data.setParameter(GifDecoder.ANIMATED_TRANSFORMATION_KEY, new RoundedCornersAnimatedTransformation((float) resources.getDimensionPixelSize(R.dimen.intercom_image_rounded_corners)));
            } else {
                data.transformations(new RoundedCornersTransformation((float) resources.getDimensionPixelSize(R.dimen.intercom_image_rounded_corners)));
            }
        }
        Uri localImageUriForRemoteUrl = this.uploadingImageCache.getLocalImageUriForRemoteUrl(str);
        if (localImageUriForRemoteUrl != null) {
            data.transformations(new GrayscaleTransformation()).data(localImageUriForRemoteUrl);
        }
        final ResizableImageView resizableImageView3 = resizableImageView;
        final ShimmerFrameLayout shimmerFrameLayout3 = shimmerFrameLayout;
        final Context context3 = context;
        final String str4 = str;
        final String str5 = str2;
        final int i3 = i;
        final int i4 = i2;
        data.listener(new ImageRequest.Listener() {
            public void onCancel(ImageRequest imageRequest) {
            }

            public void onStart(ImageRequest imageRequest) {
            }

            public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
                resizableImageView3.setScaleType(ImageView.ScaleType.CENTER);
                NetworkImage.this.hideLoadingState(shimmerFrameLayout3, resizableImageView3);
                NetworkImage.this.twig.internal("images", "FAILURE");
                resizableImageView3.setScaleType(ImageView.ScaleType.CENTER);
            }

            public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
                NetworkImage.this.twig.internal("images", "SUCCESS");
                NetworkImage.this.hideLoadingState(shimmerFrameLayout3, resizableImageView3);
                if (NetworkImage.this.getStyle() != StyleType.CHAT_FULL && NetworkImage.this.listener != null) {
                    resizableImageView3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            ((InputMethodManager) context3.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            NetworkImage.this.listener.onImageClicked(str4, str5, resizableImageView3, i3, i4);
                        }
                    });
                }
            }
        });
        IntercomCoilKt.loadIntercomImage(context2, data.build());
    }

    /* access modifiers changed from: package-private */
    public int getSampleSize(int i, int i2, DisplayMetrics displayMetrics) {
        if (i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) {
            return (int) Math.pow(2.0d, (double) ((int) Math.ceil(Math.log(((double) displayMetrics.widthPixels) / ((double) Math.max(i2, i))) / Math.log(0.5d))));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void hideLoadingState(ShimmerFrameLayout shimmerFrameLayout, ImageView imageView) {
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.hideShimmer();
            imageView.setBackgroundResource(17170445);
        }
    }
}
