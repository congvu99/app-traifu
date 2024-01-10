package io.intercom.android.sdk.survey.ui.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.shimmer.ShimmerFrameLayout;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.views.IntercomShimmerLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a/\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"SurveyLoading", "", "state", "Lio/intercom/android/sdk/survey/SurveyState$Loading;", "(Lio/intercom/android/sdk/survey/SurveyState$Loading;Landroidx/compose/runtime/Composer;I)V", "buildLoadingContainer", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "context", "Landroid/content/Context;", "buildLoadingContent", "Landroid/view/View;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "resId", "", "buildLoadingContent-bw27NRU", "(Landroid/content/Context;JI)Landroid/view/View;", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: LoadingComponent.kt */
public final class LoadingComponentKt {
    public static final void SurveyLoading(SurveyState.Loading loading, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(loading, "state");
        Composer startRestartGroup = composer.startRestartGroup(-2064900679);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) loading) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) loading);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LoadingComponentKt$SurveyLoading$1$1(loading);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) rememberedValue, fillMaxSize$default, (Function1) null, startRestartGroup, 48, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LoadingComponentKt$SurveyLoading$2(loading, i));
        }
    }

    public static final ShimmerFrameLayout buildLoadingContainer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ShimmerFrameLayout intercomShimmerLayout = new IntercomShimmerLayout(context);
        intercomShimmerLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        intercomShimmerLayout.setClickable(true);
        intercomShimmerLayout.setFocusable(true);
        return intercomShimmerLayout;
    }

    /* renamed from: buildLoadingContent-bw27NRU  reason: not valid java name */
    public static final View m5310buildLoadingContentbw27NRU(Context context, long j, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        int r2 = (int) Dp.m4704constructorimpl(Dp.m4704constructorimpl((float) 20) * context.getResources().getDisplayMetrics().density);
        layoutParams.setMarginStart(r2);
        layoutParams.setMarginEnd(r2);
        layoutParams.topMargin = r2;
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i, (Resources.Theme) null);
        if (drawable != null) {
            DrawableCompat.setTint(drawable, ColorKt.m1987toArgb8_81llA(j));
            imageView.setImageDrawable(drawable);
        }
        return imageView;
    }
}
