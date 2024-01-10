package io.intercom.android.sdk.blocks;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.intercom.commons.utilities.HtmlCompat;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.blocks.lib.interfaces.OrderedListBlock;
import io.intercom.android.sdk.blocks.lib.interfaces.UnorderedListBlock;
import io.intercom.android.sdk.blocks.lib.models.BlockMetadata;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.spans.OrderedListSpan;
import io.intercom.android.sdk.spans.UnorderedListSpan;
import io.intercom.android.sdk.utilities.BlockUtils;
import io.intercom.android.sdk.utilities.TrackingLinkMovementMethod;
import java.util.List;

class ListBlock implements OrderedListBlock, UnorderedListBlock {
    private static final int LARGE_TEXT_SIZE_SP = 16;
    private static final int SMALL_TEXT_SIZE_SP = 14;
    private final Provider<AppConfig> appConfigProvider;
    private final StyleType style;

    ListBlock(StyleType styleType, Provider<AppConfig> provider) {
        this.style = styleType;
        this.appConfigProvider = provider;
    }

    public View addOrderedList(List<String> list, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        String str;
        TextView listStyledTextView = getListStyledTextView(viewGroup.getContext(), blockMetadata);
        int dimension = (int) viewGroup.getResources().getDimension(R.dimen.intercom_list_indentation);
        int size = list.size();
        CharSequence charSequence = "";
        for (int i = 0; i < size; i++) {
            String str2 = list.get(i);
            if (!str2.isEmpty()) {
                if (i < size - 1) {
                    str = "<br />";
                } else {
                    str = "";
                }
                Spanned fromHtml = HtmlCompat.fromHtml(str2 + str);
                SpannableString spannableString = new SpannableString(fromHtml);
                spannableString.setSpan(new OrderedListSpan(dimension, (i + 1) + "."), 0, fromHtml.length(), 0);
                charSequence = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            }
        }
        listStyledTextView.setText(charSequence);
        BlockUtils.setLayoutMarginsAndGravity(listStyledTextView, GravityCompat.START, blockMetadata.isLastObject());
        return listStyledTextView;
    }

    public View addUnorderedList(List<String> list, BlockMetadata blockMetadata, ViewGroup viewGroup) {
        String str;
        Context context = viewGroup.getContext();
        TextView listStyledTextView = getListStyledTextView(context, blockMetadata);
        int dimension = (int) viewGroup.getResources().getDimension(R.dimen.intercom_list_indentation);
        int size = list.size();
        CharSequence charSequence = "";
        for (int i = 0; i < size; i++) {
            String str2 = list.get(i);
            if (!str2.isEmpty()) {
                if (i < size - 1) {
                    str = "<br />";
                } else {
                    str = "";
                }
                Spanned fromHtml = HtmlCompat.fromHtml(str2 + str);
                SpannableString spannableString = new SpannableString(fromHtml);
                spannableString.setSpan(new UnorderedListSpan(dimension, context), 0, fromHtml.length(), 0);
                charSequence = TextUtils.concat(new CharSequence[]{charSequence, spannableString});
            }
        }
        listStyledTextView.setText(charSequence);
        BlockUtils.setLayoutMarginsAndGravity(listStyledTextView, GravityCompat.START, blockMetadata.isLastObject());
        return listStyledTextView;
    }

    private TextView getListStyledTextView(Context context, BlockMetadata blockMetadata) {
        TextView textView = new TextView(context);
        textView.setLinkTextColor(this.appConfigProvider.get().getPrimaryColor());
        textView.setMovementMethod(new TrackingLinkMovementMethod());
        BlockUtils.createLayoutParams(textView, -2, -2);
        BlockUtils.setMarginLeft(textView, 4);
        switch (AnonymousClass1.$SwitchMap$io$intercom$android$sdk$blocks$StyleType[this.style.ordinal()]) {
            case 1:
                styleAsChatList(textView, ContextCompat.getColor(context, R.color.intercom_grey_800));
                break;
            case 2:
            case 3:
            case 4:
                styleAsAnnouncementList(textView, ContextCompat.getColor(context, R.color.intercom_grey_700));
                break;
            case 5:
                styleAsAnnouncementList(textView, ContextCompat.getColor(context, R.color.intercom_white));
                break;
            case 6:
                styleAsChatList(textView, ContextCompat.getColor(context, R.color.intercom_grey_800));
                textView.setMovementMethod((MovementMethod) null);
                break;
            case 7:
                textView.setTextSize(20.0f);
                String textColor = blockMetadata.getAppearance().getTextColor();
                if (!textColor.isEmpty()) {
                    int parseColor = Color.parseColor(textColor);
                    textView.setTextColor(parseColor);
                    textView.setLinkTextColor(parseColor);
                    break;
                }
                break;
            default:
                styleAsChatList(textView, ContextCompat.getColor(context, R.color.intercom_white));
                break;
        }
        return textView;
    }

    /* renamed from: io.intercom.android.sdk.blocks.ListBlock$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$intercom$android$sdk$blocks$StyleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.blocks.ListBlock.AnonymousClass1.<clinit>():void");
        }
    }

    private void styleAsChatList(TextView textView, int i) {
        textView.setTextSize(14.0f);
        textView.setTextColor(i);
        BlockUtils.setDefaultMarginBottom(textView);
        BlockUtils.setSmallLineSpacing(textView);
    }

    private void styleAsAnnouncementList(TextView textView, int i) {
        textView.setTextSize(16.0f);
        textView.setTextColor(i);
        BlockUtils.setMarginBottom(textView, 16);
        BlockUtils.setLargeLineSpacing(textView);
    }
}
