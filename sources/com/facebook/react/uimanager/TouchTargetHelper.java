package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import java.util.EnumSet;

public class TouchTargetHelper {
    private static final float[] mEventCoords = new float[2];
    private static final Matrix mInverseMatrix = new Matrix();
    private static final float[] mMatrixTransformCoords = new float[2];
    private static final PointF mTempPoint = new PointF();

    private enum TouchTargetReturnType {
        SELF,
        CHILD
    }

    public static int findTargetTagForTouch(float f, float f2, ViewGroup viewGroup) {
        return findTargetTagAndCoordinatesForTouch(f, f2, viewGroup, mEventCoords, (int[]) null);
    }

    public static int findTargetTagForTouch(float f, float f2, ViewGroup viewGroup, int[] iArr) {
        return findTargetTagAndCoordinatesForTouch(f, f2, viewGroup, mEventCoords, iArr);
    }

    public static int findTargetTagAndCoordinatesForTouch(float f, float f2, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        View findClosestReactAncestor;
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f;
        fArr[1] = f2;
        View findTouchTargetViewWithPointerEvents = findTouchTargetViewWithPointerEvents(fArr, viewGroup);
        if (findTouchTargetViewWithPointerEvents == null || (findClosestReactAncestor = findClosestReactAncestor(findTouchTargetViewWithPointerEvents)) == null) {
            return id;
        }
        if (iArr != null) {
            iArr[0] = findClosestReactAncestor.getId();
        }
        return getTouchTargetForView(findClosestReactAncestor, fArr[0], fArr[1]);
    }

    private static View findClosestReactAncestor(View view) {
        while (view != null && view.getId() <= 0) {
            view = (View) view.getParent();
        }
        return view;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0070 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.View findTouchTargetView(float[] r11, android.view.View r12, java.util.EnumSet<com.facebook.react.uimanager.TouchTargetHelper.TouchTargetReturnType> r13) {
        /*
            com.facebook.react.uimanager.TouchTargetHelper$TouchTargetReturnType r0 = com.facebook.react.uimanager.TouchTargetHelper.TouchTargetReturnType.CHILD
            boolean r0 = r13.contains(r0)
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0077
            boolean r0 = r12 instanceof android.view.ViewGroup
            if (r0 == 0) goto L_0x0077
            r0 = r12
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r4 = r0.getChildCount()
            boolean r5 = r0 instanceof com.facebook.react.uimanager.ReactZIndexedViewGroup
            if (r5 == 0) goto L_0x001e
            r5 = r0
            com.facebook.react.uimanager.ReactZIndexedViewGroup r5 = (com.facebook.react.uimanager.ReactZIndexedViewGroup) r5
            goto L_0x001f
        L_0x001e:
            r5 = r1
        L_0x001f:
            int r4 = r4 - r3
        L_0x0020:
            if (r4 < 0) goto L_0x0077
            if (r5 == 0) goto L_0x0029
            int r6 = r5.getZIndexMappedChildIndex(r4)
            goto L_0x002a
        L_0x0029:
            r6 = r4
        L_0x002a:
            android.view.View r6 = r0.getChildAt(r6)
            android.graphics.PointF r7 = mTempPoint
            r8 = r11[r2]
            r9 = r11[r3]
            getChildPoint(r8, r9, r0, r6, r7)
            r8 = r11[r2]
            r9 = r11[r3]
            float r10 = r7.x
            r11[r2] = r10
            float r7 = r7.y
            r11[r3] = r7
            android.view.View r6 = findTouchTargetViewWithPointerEvents(r11, r6)
            if (r6 == 0) goto L_0x0070
            boolean r7 = r0 instanceof com.facebook.react.uimanager.ReactOverflowView
            if (r7 == 0) goto L_0x006c
            r7 = r0
            com.facebook.react.uimanager.ReactOverflowView r7 = (com.facebook.react.uimanager.ReactOverflowView) r7
            java.lang.String r7 = r7.getOverflow()
            java.lang.String r10 = "hidden"
            boolean r10 = r10.equals(r7)
            if (r10 != 0) goto L_0x0064
            java.lang.String r10 = "scroll"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x006c
        L_0x0064:
            boolean r7 = isTouchPointInView(r8, r9, r12)
            if (r7 != 0) goto L_0x006c
            r7 = 0
            goto L_0x006d
        L_0x006c:
            r7 = 1
        L_0x006d:
            if (r7 == 0) goto L_0x0070
            return r6
        L_0x0070:
            r11[r2] = r8
            r11[r3] = r9
            int r4 = r4 + -1
            goto L_0x0020
        L_0x0077:
            com.facebook.react.uimanager.TouchTargetHelper$TouchTargetReturnType r0 = com.facebook.react.uimanager.TouchTargetHelper.TouchTargetReturnType.SELF
            boolean r13 = r13.contains(r0)
            if (r13 == 0) goto L_0x008a
            r13 = r11[r2]
            r11 = r11[r3]
            boolean r11 = isTouchPointInView(r13, r11, r12)
            if (r11 == 0) goto L_0x008a
            return r12
        L_0x008a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.TouchTargetHelper.findTouchTargetView(float[], android.view.View, java.util.EnumSet):android.view.View");
    }

    private static boolean isTouchPointInView(float f, float f2, View view) {
        if (view instanceof ReactHitSlopView) {
            ReactHitSlopView reactHitSlopView = (ReactHitSlopView) view;
            if (reactHitSlopView.getHitSlopRect() != null) {
                Rect hitSlopRect = reactHitSlopView.getHitSlopRect();
                return f >= ((float) (-hitSlopRect.left)) && f < ((float) (view.getWidth() + hitSlopRect.right)) && f2 >= ((float) (-hitSlopRect.top)) && f2 < ((float) (view.getHeight() + hitSlopRect.bottom));
            }
        }
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    private static void getChildPoint(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        float scrollY = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = mMatrixTransformCoords;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = mInverseMatrix;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f3 = fArr[0];
            scrollY = fArr[1];
            scrollX = f3;
        }
        pointF.set(scrollX, scrollY);
    }

    private static View findTouchTargetViewWithPointerEvents(float[] fArr, View view) {
        PointerEvents pointerEvents = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : PointerEvents.AUTO;
        if (!view.isEnabled()) {
            if (pointerEvents == PointerEvents.AUTO) {
                pointerEvents = PointerEvents.BOX_NONE;
            } else if (pointerEvents == PointerEvents.BOX_ONLY) {
                pointerEvents = PointerEvents.NONE;
            }
        }
        if (pointerEvents == PointerEvents.NONE) {
            return null;
        }
        if (pointerEvents == PointerEvents.BOX_ONLY) {
            return findTouchTargetView(fArr, view, EnumSet.of(TouchTargetReturnType.SELF));
        }
        if (pointerEvents == PointerEvents.BOX_NONE) {
            View findTouchTargetView = findTouchTargetView(fArr, view, EnumSet.of(TouchTargetReturnType.CHILD));
            if (findTouchTargetView != null) {
                return findTouchTargetView;
            }
            if (!(view instanceof ReactCompoundView) || !isTouchPointInView(fArr[0], fArr[1], view) || ((ReactCompoundView) view).reactTagForTouch(fArr[0], fArr[1]) == view.getId()) {
                return null;
            }
            return view;
        } else if (pointerEvents != PointerEvents.AUTO) {
            throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + pointerEvents.toString());
        } else if (!(view instanceof ReactCompoundViewGroup) || !isTouchPointInView(fArr[0], fArr[1], view) || !((ReactCompoundViewGroup) view).interceptsTouchEvent(fArr[0], fArr[1])) {
            return findTouchTargetView(fArr, view, EnumSet.of(TouchTargetReturnType.SELF, TouchTargetReturnType.CHILD));
        } else {
            return view;
        }
    }

    private static int getTouchTargetForView(View view, float f, float f2) {
        if (view instanceof ReactCompoundView) {
            return ((ReactCompoundView) view).reactTagForTouch(f, f2);
        }
        return view.getId();
    }
}
