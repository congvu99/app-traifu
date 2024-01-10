package coil.compose;

import android.graphics.drawable.Drawable;
import coil.transition.TransitionTarget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"coil/compose/AsyncImagePainterKt$FakeTransitionTarget$1", "Lcoil/transition/TransitionTarget;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "view", "", "getView", "()Ljava/lang/Void;", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AsyncImagePainter.kt */
public final class AsyncImagePainterKt$FakeTransitionTarget$1 implements TransitionTarget {
    public Drawable getDrawable() {
        return null;
    }

    AsyncImagePainterKt$FakeTransitionTarget$1() {
    }

    public void onError(Drawable drawable) {
        TransitionTarget.DefaultImpls.onError(this, drawable);
    }

    public void onStart(Drawable drawable) {
        TransitionTarget.DefaultImpls.onStart(this, drawable);
    }

    public void onSuccess(Drawable drawable) {
        TransitionTarget.DefaultImpls.onSuccess(this, drawable);
    }

    public Void getView() {
        throw new UnsupportedOperationException();
    }
}
