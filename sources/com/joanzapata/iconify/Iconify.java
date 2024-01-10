package com.joanzapata.iconify;

import android.content.Context;
import android.widget.TextView;
import com.joanzapata.iconify.internal.IconFontDescriptorWrapper;
import com.joanzapata.iconify.internal.ParsingUtil;
import java.util.ArrayList;
import java.util.List;

public class Iconify {
    private static List<IconFontDescriptorWrapper> iconFontDescriptors = new ArrayList();

    public static IconifyInitializer with(IconFontDescriptor iconFontDescriptor) {
        return new IconifyInitializer(iconFontDescriptor);
    }

    public static void addIcons(TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setText(compute(textView.getContext(), textView.getText(), textView));
            }
        }
    }

    /* access modifiers changed from: private */
    public static void addIconFontDescriptor(IconFontDescriptor iconFontDescriptor) {
        for (IconFontDescriptorWrapper iconFontDescriptor2 : iconFontDescriptors) {
            if (iconFontDescriptor2.getIconFontDescriptor().ttfFileName().equals(iconFontDescriptor.ttfFileName())) {
                return;
            }
        }
        iconFontDescriptors.add(new IconFontDescriptorWrapper(iconFontDescriptor));
    }

    public static CharSequence compute(Context context, CharSequence charSequence) {
        return compute(context, charSequence, (TextView) null);
    }

    public static CharSequence compute(Context context, CharSequence charSequence, TextView textView) {
        return ParsingUtil.parse(context, iconFontDescriptors, charSequence, textView);
    }

    public static class IconifyInitializer {
        public IconifyInitializer(IconFontDescriptor iconFontDescriptor) {
            Iconify.addIconFontDescriptor(iconFontDescriptor);
        }

        public IconifyInitializer with(IconFontDescriptor iconFontDescriptor) {
            Iconify.addIconFontDescriptor(iconFontDescriptor);
            return this;
        }
    }

    public static IconFontDescriptorWrapper findTypefaceOf(Icon icon) {
        for (IconFontDescriptorWrapper next : iconFontDescriptors) {
            if (next.hasIcon(icon)) {
                return next;
            }
        }
        return null;
    }

    public static Icon findIconForKey(String str) {
        int size = iconFontDescriptors.size();
        for (int i = 0; i < size; i++) {
            Icon icon = iconFontDescriptors.get(i).getIcon(str);
            if (icon != null) {
                return icon;
            }
        }
        return null;
    }
}
