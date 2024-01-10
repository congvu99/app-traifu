package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"findOwner", "T", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "activity-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityComposeUtils.kt */
public final class ActivityComposeUtilsKt {
    public static final /* synthetic */ <T> T findOwner(T t) {
        Intrinsics.checkNotNullParameter(t, "context");
        while (t instanceof ContextWrapper) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (t instanceof Object) {
                return t;
            }
            T baseContext = ((ContextWrapper) t).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "innerContext.baseContext");
            t = (Context) baseContext;
        }
        return null;
    }
}
