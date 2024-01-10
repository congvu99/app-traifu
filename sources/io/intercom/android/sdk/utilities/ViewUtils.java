package io.intercom.android.sdk.utilities;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.logger.LumberMill;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final Twig twig = LumberMill.getLogger();

    public static void removeGlobalLayoutListener(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void waitForViewAttachment(final View view, final Runnable runnable) {
        if (view.getHeight() == 0) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    ViewUtils.removeGlobalLayoutListener(view, this);
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    public static void setOverScrollColour(RecyclerView recyclerView, int i) {
        Class<RecyclerView> cls = RecyclerView.class;
        try {
            String[] strArr = {"ensureTopGlow", "ensureBottomGlow"};
            for (int i2 = 0; i2 < 2; i2++) {
                Method declaredMethod = cls.getDeclaredMethod(strArr[i2], new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, new Object[0]);
            }
            String[] strArr2 = {"mTopGlow", "mBottomGlow"};
            for (int i3 = 0; i3 < 2; i3++) {
                Field declaredField = cls.getDeclaredField(strArr2[i3]);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(recyclerView);
                Field declaredField2 = obj.getClass().getDeclaredField("mEdgeEffect");
                declaredField2.setAccessible(true);
                ((EdgeEffect) declaredField2.get(obj)).setColor(i);
            }
        } catch (Exception unused) {
            twig.d("Could not set overscroll colour", new Object[0]);
        }
    }

    public static void requestLayoutIfPossible(View view) {
        if (!view.isInLayout()) {
            view.requestLayout();
        }
    }
}
