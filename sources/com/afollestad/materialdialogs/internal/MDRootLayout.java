package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.util.DialogUtils;

public class MDRootLayout extends ViewGroup {
    private static final int INDEX_NEGATIVE = 1;
    private static final int INDEX_NEUTRAL = 0;
    private static final int INDEX_POSITIVE = 2;
    private ViewTreeObserver.OnScrollChangedListener mBottomOnScrollChangedListener;
    private int mButtonBarHeight;
    private GravityEnum mButtonGravity = GravityEnum.START;
    private int mButtonHorizontalEdgeMargin;
    private int mButtonPaddingFull;
    /* access modifiers changed from: private */
    public final MDButton[] mButtons = new MDButton[3];
    private View mContent;
    private Paint mDividerPaint;
    private int mDividerWidth;
    /* access modifiers changed from: private */
    public boolean mDrawBottomDivider = false;
    /* access modifiers changed from: private */
    public boolean mDrawTopDivider = false;
    private boolean mForceStack = false;
    private boolean mIsStacked = false;
    private boolean mNoTitleNoPadding;
    private int mNoTitlePaddingFull;
    private boolean mReducePaddingNoTitleNoButtons;
    private View mTitleBar;
    private ViewTreeObserver.OnScrollChangedListener mTopOnScrollChangedListener;
    private boolean mUseFullPadding = true;

    public MDRootLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    public MDRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MDRootLayout, i, 0);
        this.mReducePaddingNoTitleNoButtons = obtainStyledAttributes.getBoolean(R.styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        obtainStyledAttributes.recycle();
        this.mNoTitlePaddingFull = resources.getDimensionPixelSize(R.dimen.md_notitle_vertical_padding);
        this.mButtonPaddingFull = resources.getDimensionPixelSize(R.dimen.md_button_frame_vertical_padding);
        this.mButtonHorizontalEdgeMargin = resources.getDimensionPixelSize(R.dimen.md_button_padding_frame_side);
        this.mButtonBarHeight = resources.getDimensionPixelSize(R.dimen.md_button_height);
        this.mDividerPaint = new Paint();
        this.mDividerWidth = resources.getDimensionPixelSize(R.dimen.md_divider_height);
        this.mDividerPaint.setColor(DialogUtils.resolveColor(context, R.attr.md_divider_color));
        setWillNotDraw(false);
    }

    public void noTitleNoPadding() {
        this.mNoTitleNoPadding = true;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() == R.id.titleFrame) {
                this.mTitleBar = childAt;
            } else if (childAt.getId() == R.id.buttonDefaultNeutral) {
                this.mButtons[0] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.buttonDefaultNegative) {
                this.mButtons[1] = (MDButton) childAt;
            } else if (childAt.getId() == R.id.buttonDefaultPositive) {
                this.mButtons[2] = (MDButton) childAt;
            } else {
                this.mContent = childAt;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0103  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r0 = android.view.View.MeasureSpec.getSize(r12)
            int r1 = android.view.View.MeasureSpec.getSize(r13)
            r2 = 1
            r11.mUseFullPadding = r2
            boolean r3 = r11.mForceStack
            r4 = 0
            if (r3 != 0) goto L_0x0049
            com.afollestad.materialdialogs.internal.MDButton[] r3 = r11.mButtons
            int r5 = r3.length
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0016:
            if (r6 >= r5) goto L_0x0031
            r9 = r3[r6]
            if (r9 == 0) goto L_0x002e
            boolean r10 = isVisible(r9)
            if (r10 == 0) goto L_0x002e
            r9.setStacked(r4, r4)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredWidth()
            int r7 = r7 + r8
            r8 = 1
        L_0x002e:
            int r6 = r6 + 1
            goto L_0x0016
        L_0x0031:
            android.content.Context r3 = r11.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r5 = com.afollestad.materialdialogs.R.dimen.md_neutral_button_margin
            int r3 = r3.getDimensionPixelSize(r5)
            int r3 = r3 * 2
            int r3 = r0 - r3
            if (r7 <= r3) goto L_0x0047
            r3 = 1
            goto L_0x004b
        L_0x0047:
            r3 = 0
            goto L_0x004b
        L_0x0049:
            r3 = 1
            r8 = 0
        L_0x004b:
            r11.mIsStacked = r3
            if (r3 == 0) goto L_0x006f
            com.afollestad.materialdialogs.internal.MDButton[] r3 = r11.mButtons
            int r5 = r3.length
            r6 = 0
            r7 = 0
        L_0x0054:
            if (r6 >= r5) goto L_0x0070
            r9 = r3[r6]
            if (r9 == 0) goto L_0x006c
            boolean r10 = isVisible(r9)
            if (r10 == 0) goto L_0x006c
            r9.setStacked(r2, r4)
            r11.measureChild(r9, r12, r13)
            int r8 = r9.getMeasuredHeight()
            int r7 = r7 + r8
            r8 = 1
        L_0x006c:
            int r6 = r6 + 1
            goto L_0x0054
        L_0x006f:
            r7 = 0
        L_0x0070:
            if (r8 == 0) goto L_0x008c
            boolean r12 = r11.mIsStacked
            if (r12 == 0) goto L_0x0081
            int r12 = r1 - r7
            int r13 = r11.mButtonPaddingFull
            int r3 = r13 * 2
            int r3 = r3 + r4
            int r13 = r13 * 2
            int r13 = r13 + r4
            goto L_0x0094
        L_0x0081:
            int r12 = r11.mButtonBarHeight
            int r12 = r1 - r12
            int r13 = r11.mButtonPaddingFull
            int r13 = r13 * 2
            int r3 = r13 + 0
            goto L_0x0093
        L_0x008c:
            int r12 = r11.mButtonPaddingFull
            int r12 = r12 * 2
            int r3 = r12 + 0
            r12 = r1
        L_0x0093:
            r13 = 0
        L_0x0094:
            android.view.View r5 = r11.mTitleBar
            boolean r5 = isVisible(r5)
            r6 = 1073741824(0x40000000, float:2.0)
            if (r5 == 0) goto L_0x00af
            android.view.View r5 = r11.mTitleBar
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            r5.measure(r7, r4)
            android.view.View r5 = r11.mTitleBar
            int r5 = r5.getMeasuredHeight()
            int r12 = r12 - r5
            goto L_0x00b6
        L_0x00af:
            boolean r5 = r11.mNoTitleNoPadding
            if (r5 != 0) goto L_0x00b6
            int r5 = r11.mNoTitlePaddingFull
            int r3 = r3 + r5
        L_0x00b6:
            android.view.View r5 = r11.mContent
            boolean r5 = isVisible(r5)
            if (r5 == 0) goto L_0x0103
            android.view.View r5 = r11.mContent
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r6)
            int r7 = r12 - r13
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            r5.measure(r6, r7)
            android.view.View r5 = r11.mContent
            int r5 = r5.getMeasuredHeight()
            int r6 = r12 - r3
            if (r5 > r6) goto L_0x0100
            boolean r5 = r11.mReducePaddingNoTitleNoButtons
            if (r5 == 0) goto L_0x00f4
            android.view.View r5 = r11.mTitleBar
            boolean r5 = isVisible(r5)
            if (r5 != 0) goto L_0x00f4
            if (r8 == 0) goto L_0x00e8
            goto L_0x00f4
        L_0x00e8:
            r11.mUseFullPadding = r4
            android.view.View r2 = r11.mContent
            int r2 = r2.getMeasuredHeight()
            int r2 = r2 + r13
            int r4 = r12 - r2
            goto L_0x0104
        L_0x00f4:
            r11.mUseFullPadding = r2
            android.view.View r13 = r11.mContent
            int r13 = r13.getMeasuredHeight()
            int r13 = r13 + r3
            int r4 = r12 - r13
            goto L_0x0104
        L_0x0100:
            r11.mUseFullPadding = r4
            goto L_0x0104
        L_0x0103:
            r4 = r12
        L_0x0104:
            int r1 = r1 - r4
            r11.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    private static boolean isVisible(View view) {
        boolean z = true;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!z2 || !(view instanceof MDButton)) {
            return z2;
        }
        if (((MDButton) view).getText().toString().trim().length() <= 0) {
            z = false;
        }
        return z;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.mContent;
        if (view != null) {
            if (this.mDrawTopDivider) {
                int top = view.getTop();
                canvas.drawRect(0.0f, (float) (top - this.mDividerWidth), (float) getMeasuredWidth(), (float) top, this.mDividerPaint);
            }
            if (this.mDrawBottomDivider) {
                int bottom = this.mContent.getBottom();
                canvas.drawRect(0.0f, (float) bottom, (float) getMeasuredWidth(), (float) (bottom + this.mDividerWidth), this.mDividerPaint);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        if (isVisible(this.mTitleBar)) {
            int measuredHeight = this.mTitleBar.getMeasuredHeight() + i2;
            this.mTitleBar.layout(i, i2, i3, measuredHeight);
            i2 = measuredHeight;
        } else if (!this.mNoTitleNoPadding && this.mUseFullPadding) {
            i2 += this.mNoTitlePaddingFull;
        }
        if (isVisible(this.mContent)) {
            View view = this.mContent;
            view.layout(i, i2, i3, view.getMeasuredHeight() + i2);
        }
        if (this.mIsStacked) {
            int i14 = i4 - this.mButtonPaddingFull;
            for (MDButton mDButton : this.mButtons) {
                if (isVisible(mDButton)) {
                    mDButton.layout(i, i14 - mDButton.getMeasuredHeight(), i3, i14);
                    i14 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            if (this.mUseFullPadding) {
                i4 -= this.mButtonPaddingFull;
            }
            int i15 = i4 - this.mButtonBarHeight;
            int i16 = this.mButtonHorizontalEdgeMargin;
            if (isVisible(this.mButtons[2])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    i13 = i + i16;
                    i12 = this.mButtons[2].getMeasuredWidth() + i13;
                    i5 = -1;
                } else {
                    int i17 = i3 - i16;
                    i13 = i17 - this.mButtons[2].getMeasuredWidth();
                    i12 = i17;
                    i5 = i13;
                }
                this.mButtons[2].layout(i13, i15, i12, i4);
                i16 += this.mButtons[2].getMeasuredWidth();
            } else {
                i5 = -1;
            }
            if (isVisible(this.mButtons[1])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    i11 = i16 + i;
                    i10 = this.mButtons[1].getMeasuredWidth() + i11;
                } else if (this.mButtonGravity == GravityEnum.START) {
                    i10 = i3 - i16;
                    i11 = i10 - this.mButtons[1].getMeasuredWidth();
                } else {
                    i11 = this.mButtonHorizontalEdgeMargin + i;
                    i10 = this.mButtons[1].getMeasuredWidth() + i11;
                    i6 = i10;
                    this.mButtons[1].layout(i11, i15, i10, i4);
                }
                i6 = -1;
                this.mButtons[1].layout(i11, i15, i10, i4);
            } else {
                i6 = -1;
            }
            if (isVisible(this.mButtons[0])) {
                if (this.mButtonGravity == GravityEnum.END) {
                    i7 = i3 - this.mButtonHorizontalEdgeMargin;
                    i8 = i7 - this.mButtons[0].getMeasuredWidth();
                } else if (this.mButtonGravity == GravityEnum.START) {
                    i8 = i + this.mButtonHorizontalEdgeMargin;
                    i7 = this.mButtons[0].getMeasuredWidth() + i8;
                } else {
                    if (i6 != -1 || i5 == -1) {
                        if (i5 == -1 && i6 != -1) {
                            i9 = this.mButtons[0].getMeasuredWidth();
                        } else if (i5 == -1) {
                            i6 = ((i3 - i) / 2) - (this.mButtons[0].getMeasuredWidth() / 2);
                            i9 = this.mButtons[0].getMeasuredWidth();
                        }
                        i5 = i6 + i9;
                    } else {
                        i6 = i5 - this.mButtons[0].getMeasuredWidth();
                    }
                    i7 = i5;
                    i8 = i6;
                }
                this.mButtons[0].layout(i8, i15, i7, i4);
            }
        }
        setUpDividersVisibility(this.mContent, true, true);
    }

    public void setForceStack(boolean z) {
        this.mForceStack = z;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.mDividerPaint.setColor(i);
        invalidate();
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.mButtonGravity = gravityEnum;
        invertGravityIfNecessary();
    }

    private void invertGravityIfNecessary() {
        if (Build.VERSION.SDK_INT >= 17 && getResources().getConfiguration().getLayoutDirection() == 1) {
            int i = AnonymousClass3.$SwitchMap$com$afollestad$materialdialogs$GravityEnum[this.mButtonGravity.ordinal()];
            if (i == 1) {
                this.mButtonGravity = GravityEnum.END;
            } else if (i == 2) {
                this.mButtonGravity = GravityEnum.START;
            }
        }
    }

    /* renamed from: com.afollestad.materialdialogs.internal.MDRootLayout$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$GravityEnum;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.afollestad.materialdialogs.GravityEnum[] r0 = com.afollestad.materialdialogs.GravityEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$afollestad$materialdialogs$GravityEnum = r0
                com.afollestad.materialdialogs.GravityEnum r1 = com.afollestad.materialdialogs.GravityEnum.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$afollestad$materialdialogs$GravityEnum     // Catch:{ NoSuchFieldError -> 0x001d }
                com.afollestad.materialdialogs.GravityEnum r1 = com.afollestad.materialdialogs.GravityEnum.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.AnonymousClass3.<clinit>():void");
        }
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        for (MDButton mDButton : this.mButtons) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    private void setUpDividersVisibility(final View view, final boolean z, final boolean z2) {
        if (view != null) {
            if (view instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) view;
                if (canScrollViewScroll(scrollView)) {
                    addScrollListener(scrollView, z, z2);
                    return;
                }
                if (z) {
                    this.mDrawTopDivider = false;
                }
                if (z2) {
                    this.mDrawBottomDivider = false;
                }
            } else if (view instanceof AdapterView) {
                AdapterView adapterView = (AdapterView) view;
                if (canAdapterViewScroll(adapterView)) {
                    addScrollListener(adapterView, z, z2);
                    return;
                }
                if (z) {
                    this.mDrawTopDivider = false;
                }
                if (z2) {
                    this.mDrawBottomDivider = false;
                }
            } else if (view instanceof WebView) {
                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    public boolean onPreDraw() {
                        if (view.getMeasuredHeight() == 0) {
                            return true;
                        }
                        if (!MDRootLayout.canWebViewScroll((WebView) view)) {
                            if (z) {
                                boolean unused = MDRootLayout.this.mDrawTopDivider = false;
                            }
                            if (z2) {
                                boolean unused2 = MDRootLayout.this.mDrawBottomDivider = false;
                            }
                        } else {
                            MDRootLayout.this.addScrollListener((ViewGroup) view, z, z2);
                        }
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        return true;
                    }
                });
            } else if (view instanceof RecyclerView) {
                boolean canRecyclerViewScroll = canRecyclerViewScroll((RecyclerView) view);
                if (z) {
                    this.mDrawTopDivider = canRecyclerViewScroll;
                }
                if (z2) {
                    this.mDrawBottomDivider = canRecyclerViewScroll;
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                View topView = getTopView(viewGroup);
                setUpDividersVisibility(topView, z, z2);
                View bottomView = getBottomView(viewGroup);
                if (bottomView != topView) {
                    setUpDividersVisibility(bottomView, false, true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void addScrollListener(final ViewGroup viewGroup, final boolean z, final boolean z2) {
        if ((!z2 && this.mTopOnScrollChangedListener == null) || (z2 && this.mBottomOnScrollChangedListener == null)) {
            AnonymousClass2 r0 = new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    MDButton[] access$400 = MDRootLayout.this.mButtons;
                    int length = access$400.length;
                    boolean z = false;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            MDButton mDButton = access$400[i];
                            if (mDButton != null && mDButton.getVisibility() != 8) {
                                z = true;
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    ViewGroup viewGroup = viewGroup;
                    if (viewGroup instanceof WebView) {
                        MDRootLayout.this.invalidateDividersForWebView((WebView) viewGroup, z, z2, z);
                    } else {
                        MDRootLayout.this.invalidateDividersForScrollingView(viewGroup, z, z2, z);
                    }
                    MDRootLayout.this.invalidate();
                }
            };
            if (!z2) {
                this.mTopOnScrollChangedListener = r0;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mTopOnScrollChangedListener);
            } else {
                this.mBottomOnScrollChangedListener = r0;
                viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.mBottomOnScrollChangedListener);
            }
            r0.onScrollChanged();
        }
    }

    /* access modifiers changed from: private */
    public void invalidateDividersForScrollingView(ViewGroup viewGroup, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z && viewGroup.getChildCount() > 0) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || viewGroup.getScrollY() + viewGroup.getPaddingTop() <= viewGroup.getChildAt(0).getTop()) ? false : true;
        }
        if (z2 && viewGroup.getChildCount() > 0) {
            if (!z3 || (viewGroup.getScrollY() + viewGroup.getHeight()) - viewGroup.getPaddingBottom() >= viewGroup.getChildAt(viewGroup.getChildCount() - 1).getBottom()) {
                z4 = false;
            }
            this.mDrawBottomDivider = z4;
        }
    }

    /* access modifiers changed from: private */
    public void invalidateDividersForWebView(WebView webView, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        if (z) {
            View view = this.mTitleBar;
            this.mDrawTopDivider = (view == null || view.getVisibility() == 8 || webView.getScrollY() + webView.getPaddingTop() <= 0) ? false : true;
        }
        if (z2) {
            if (!z3 || ((float) ((webView.getScrollY() + webView.getMeasuredHeight()) - webView.getPaddingBottom())) >= ((float) webView.getContentHeight()) * webView.getScale()) {
                z4 = false;
            }
            this.mDrawBottomDivider = z4;
        }
    }

    public static boolean canRecyclerViewScroll(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getAdapter() == null || recyclerView.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            if (findLastVisibleItemPosition == -1) {
                return false;
            }
            if (!(findLastVisibleItemPosition == itemCount - 1) || (recyclerView.getChildCount() > 0 && recyclerView.getChildAt(recyclerView.getChildCount() - 1).getBottom() > recyclerView.getHeight() - recyclerView.getPaddingBottom())) {
                return true;
            }
            return false;
        }
        throw new MaterialDialog.NotImplementedException("Material Dialogs currently only supports LinearLayoutManager. Please report any new layout managers.");
    }

    private static boolean canScrollViewScroll(ScrollView scrollView) {
        if (scrollView.getChildCount() != 0 && (scrollView.getMeasuredHeight() - scrollView.getPaddingTop()) - scrollView.getPaddingBottom() < scrollView.getChildAt(0).getMeasuredHeight()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean canWebViewScroll(WebView webView) {
        return ((float) webView.getMeasuredHeight()) < ((float) webView.getContentHeight()) * webView.getScale();
    }

    private static boolean canAdapterViewScroll(AdapterView adapterView) {
        if (adapterView.getLastVisiblePosition() == -1) {
            return false;
        }
        boolean z = adapterView.getFirstVisiblePosition() == 0;
        boolean z2 = adapterView.getLastVisiblePosition() == adapterView.getCount() - 1;
        if (!z || !z2 || adapterView.getChildCount() <= 0 || adapterView.getChildAt(0).getTop() < adapterView.getPaddingTop() || adapterView.getChildAt(adapterView.getChildCount() - 1).getBottom() > adapterView.getHeight() - adapterView.getPaddingBottom()) {
            return true;
        }
        return false;
    }

    private static View getBottomView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getBottom() == viewGroup.getMeasuredHeight()) {
                return childAt;
            }
        }
        return null;
    }

    private static View getTopView(ViewGroup viewGroup) {
        if (viewGroup == null || viewGroup.getChildCount() == 0) {
            return null;
        }
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt.getVisibility() == 0 && childAt.getTop() == 0) {
                return childAt;
            }
        }
        return null;
    }
}
