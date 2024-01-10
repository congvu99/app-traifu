package io.intercom.android.sdk.blocks.views;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.StyleType;
import io.intercom.android.sdk.blocks.lib.BlockAlignment;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.ColorUtils;
import io.intercom.android.sdk.utilities.TrackingLinkMovementMethod;

public class ParagraphView extends AppCompatTextView {
    private static final int CAROUSEL_LINE_SPACING_DP = 8;
    private static final int DEFAULT_LINE_SPACING_DP = 2;
    private static final int POST_BOTTOM_MARGIN_DP = 24;
    private static final int POST_LINE_SPACING_DP = 4;
    private final BlockAlignment alignment;
    private final AppConfig appConfig;
    private final BlockMetadata blockMetadata;
    private final Context context;
    private final StyleType style;

    public ParagraphView(Context context2, StyleType styleType, BlockAlignment blockAlignment, AppConfig appConfig2, BlockMetadata blockMetadata2) {
        super(context2);
        this.context = context2;
        this.style = styleType;
        this.alignment = blockAlignment;
        this.appConfig = appConfig2;
        this.blockMetadata = blockMetadata2;
        applyParagraphStyle();
    }

    public ParagraphView(Context context2, StyleType styleType, BlockAlignment blockAlignment, AppConfig appConfig2) {
        this(context2, styleType, blockAlignment, appConfig2, BlockMetadata.NULL);
    }

    private void applyParagraphStyle() {
        BlockUtils.createLayoutParams(this, -2, -2);
        BlockUtils.setDefaultMarginBottom(this);
        setLineSpacing((float) ScreenUtils.dpToPx(2.0f, this.context), 1.0f);
        setTextSize(16.0f);
        setTextIsSelectable(false);
        setEllipsize(TextUtils.TruncateAt.END);
        setScrollContainer(false);
        setFocusable(false);
        setClickable(false);
        setLongClickable(false);
        setGravity(this.alignment.getGravity());
        setMovementMethod(new TrackingLinkMovementMethod());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int primaryColor = this.appConfig.getPrimaryColor();
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()]) {
            case 1:
                setTextColor(ContextCompat.getColor(this.context, R.color.intercom_grey_800));
                setLinkTextColor(ColorUtils.primaryOrBlackAccessibility(this.context, this.appConfig));
                return;
            case 2:
                setTextColor(ContextCompat.getColor(this.context, R.color.intercom_grey_700));
                setLinkTextColor(ColorUtils.primaryOrDarkColor(this.context, this.appConfig));
                return;
            case 3:
            case 4:
                setTextColor(ContextCompat.getColor(this.context, R.color.intercom_grey_700));
                setLinkTextColor(ColorUtils.primaryOrBlackAccessibility(this.context, this.appConfig));
                return;
            case 5:
                marginLayoutParams.bottomMargin = ScreenUtils.dpToPx(24.0f, this.context);
                setLineSpacing((float) ScreenUtils.dpToPx(4.0f, this.context), 1.0f);
                setTextColor(ContextCompat.getColor(this.context, R.color.intercom_white));
                setLinkTextColor(ColorUtils.lightenColor(primaryColor));
                return;
            case 6:
                setMovementMethod((MovementMethod) null);
                setTextSize(14.0f);
                setTextColor(ContextCompat.getColor(this.context, R.color.intercom_grey_600));
                setLinkTextColor(ColorUtils.primaryOrDarkColor(this.context, this.appConfig));
                return;
            case 7:
                setTextSize(20.0f);
                setLineSpacing((float) ScreenUtils.dpToPx(8.0f, this.context), 1.0f);
                String textColor = this.blockMetadata.getAppearance().getTextColor();
                if (!textColor.isEmpty()) {
                    int parseColor = Color.parseColor(textColor);
                    setTextColor(parseColor);
                    setLinkTextColor(parseColor);
                    return;
                }
                return;
            default:
                setIncludeFontPadding(false);
                ColorUtils.setTextColorWhiteOrDark(this, this.appConfig.primaryColorRenderDarkText());
                return;
        }
    }

    /* renamed from: io.intercom.android.sdk.blocks.views.ParagraphView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.intercom.android.sdk.blocks.StyleType[] r0 = io.intercom.android.sdk.blocks.StyleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$intercom$android$sdk$blocks$StyleType = r0
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.ADMIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.ARTICLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.NOTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.CONTAINER_CARD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.POST     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.CHAT_FULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.CAROUSEL     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$intercom$android$sdk$blocks$StyleType     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.intercom.android.sdk.blocks.StyleType r1 = io.intercom.android.sdk.blocks.StyleType.USER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.views.ParagraphView.AnonymousClass1.<clinit>():void");
        }
    }
}
