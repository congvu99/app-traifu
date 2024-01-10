package com.facebook.react.views.text;

import android.os.Build;
import android.text.TextUtils;
import androidx.room.FtsOptions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;

public class TextAttributeProps {
    private static final int DEFAULT_BREAK_STRATEGY;
    private static final int DEFAULT_JUSTIFICATION_MODE = 0;
    private static final int DEFAULT_TEXT_SHADOW_COLOR = 1426063360;
    private static final String PROP_SHADOW_COLOR = "textShadowColor";
    private static final String PROP_SHADOW_OFFSET = "textShadowOffset";
    private static final String PROP_SHADOW_OFFSET_HEIGHT = "height";
    private static final String PROP_SHADOW_OFFSET_WIDTH = "width";
    private static final String PROP_SHADOW_RADIUS = "textShadowRadius";
    private static final String PROP_TEXT_TRANSFORM = "textTransform";
    public static final short TA_KEY_ACCESSIBILITY_ROLE = 22;
    public static final short TA_KEY_ALIGNMENT = 12;
    public static final short TA_KEY_ALLOW_FONT_SCALING = 9;
    public static final short TA_KEY_BACKGROUND_COLOR = 1;
    public static final short TA_KEY_BEST_WRITING_DIRECTION = 13;
    public static final short TA_KEY_FONT_FAMILY = 3;
    public static final short TA_KEY_FONT_SIZE = 4;
    public static final short TA_KEY_FONT_SIZE_MULTIPLIER = 5;
    public static final short TA_KEY_FONT_STYLE = 7;
    public static final short TA_KEY_FONT_VARIANT = 8;
    public static final short TA_KEY_FONT_WEIGHT = 6;
    public static final short TA_KEY_FOREGROUND_COLOR = 0;
    public static final short TA_KEY_IS_HIGHLIGHTED = 20;
    public static final short TA_KEY_LAYOUT_DIRECTION = 21;
    public static final short TA_KEY_LETTER_SPACING = 10;
    public static final short TA_KEY_LINE_HEIGHT = 11;
    public static final short TA_KEY_OPACITY = 2;
    public static final short TA_KEY_TEXT_DECORATION_COLOR = 14;
    public static final short TA_KEY_TEXT_DECORATION_LINE = 15;
    public static final short TA_KEY_TEXT_DECORATION_LINE_PATTERN = 17;
    public static final short TA_KEY_TEXT_DECORATION_LINE_STYLE = 16;
    public static final short TA_KEY_TEXT_SHADOW_COLOR = 19;
    public static final short TA_KEY_TEXT_SHADOW_RAIDUS = 18;
    public static final int UNSET = -1;
    protected ReactAccessibilityDelegate.AccessibilityRole mAccessibilityRole = null;
    protected boolean mAllowFontScaling = true;
    protected int mBackgroundColor;
    protected int mColor;
    protected boolean mContainsImages = false;
    protected String mFontFamily = null;
    protected String mFontFeatureSettings = null;
    protected int mFontSize = -1;
    protected float mFontSizeInput = -1.0f;
    protected int mFontStyle = -1;
    protected int mFontWeight = -1;
    protected float mHeightOfTallestInlineImage = Float.NaN;
    protected boolean mIncludeFontPadding = true;
    protected boolean mIsAccessibilityRoleSet = false;
    protected boolean mIsBackgroundColorSet = false;
    protected boolean mIsColorSet = false;
    protected boolean mIsLineThroughTextDecorationSet = false;
    protected boolean mIsUnderlineTextDecorationSet = false;
    protected int mLayoutDirection = -1;
    protected float mLetterSpacingInput = Float.NaN;
    protected float mLineHeight = Float.NaN;
    protected float mLineHeightInput = -1.0f;
    protected int mNumberOfLines = -1;
    protected int mTextAlign = 0;
    protected int mTextShadowColor = 1426063360;
    protected float mTextShadowOffsetDx = 0.0f;
    protected float mTextShadowOffsetDy = 0.0f;
    protected float mTextShadowRadius = 1.0f;
    protected TextTransform mTextTransform = TextTransform.NONE;

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 23) {
            i2 = 1;
        }
        DEFAULT_BREAK_STRATEGY = i2;
    }

    private TextAttributeProps() {
    }

    public static TextAttributeProps fromReadableMapBuffer(ReadableMapBuffer readableMapBuffer) {
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        Iterator<ReadableMapBuffer.MapBufferEntry> it = readableMapBuffer.iterator();
        while (it.hasNext()) {
            ReadableMapBuffer.MapBufferEntry next = it.next();
            short key = next.getKey();
            if (key == 0) {
                textAttributeProps.setColor(Integer.valueOf(next.getInt(0)));
            } else if (key == 1) {
                textAttributeProps.setBackgroundColor(Integer.valueOf(next.getInt(0)));
            } else if (key == 3) {
                textAttributeProps.setFontFamily(next.getString());
            } else if (key == 4) {
                textAttributeProps.setFontSize((float) next.getDouble(-1.0d));
            } else if (key == 15) {
                textAttributeProps.setTextDecorationLine(next.getString());
            } else if (key == 18) {
                textAttributeProps.setTextShadowRadius((float) next.getInt(1));
            } else if (key == 19) {
                textAttributeProps.setTextShadowColor(next.getInt(1426063360));
            } else if (key == 21) {
                textAttributeProps.setLayoutDirection(next.getString());
            } else if (key != 22) {
                switch (key) {
                    case 6:
                        textAttributeProps.setFontWeight(next.getString());
                        break;
                    case 7:
                        textAttributeProps.setFontStyle(next.getString());
                        break;
                    case 8:
                        textAttributeProps.setFontVariant(next.getReadableMapBuffer());
                        break;
                    case 9:
                        textAttributeProps.setAllowFontScaling(next.getBoolean(true));
                        break;
                    case 10:
                        textAttributeProps.setLetterSpacing((float) next.getDouble(Double.NaN));
                        break;
                    case 11:
                        textAttributeProps.setLineHeight((float) next.getDouble(-1.0d));
                        break;
                }
            } else {
                textAttributeProps.setAccessibilityRole(next.getString());
            }
        }
        return textAttributeProps;
    }

    public static TextAttributeProps fromReadableMap(ReactStylesDiffMap reactStylesDiffMap) {
        TextAttributeProps textAttributeProps = new TextAttributeProps();
        textAttributeProps.setNumberOfLines(getIntProp(reactStylesDiffMap, ViewProps.NUMBER_OF_LINES, -1));
        textAttributeProps.setLineHeight(getFloatProp(reactStylesDiffMap, ViewProps.LINE_HEIGHT, -1.0f));
        textAttributeProps.setLetterSpacing(getFloatProp(reactStylesDiffMap, ViewProps.LETTER_SPACING, Float.NaN));
        textAttributeProps.setAllowFontScaling(getBooleanProp(reactStylesDiffMap, ViewProps.ALLOW_FONT_SCALING, true));
        textAttributeProps.setFontSize(getFloatProp(reactStylesDiffMap, ViewProps.FONT_SIZE, -1.0f));
        ReadableMap readableMap = null;
        textAttributeProps.setColor(reactStylesDiffMap.hasKey("color") ? Integer.valueOf(reactStylesDiffMap.getInt("color", 0)) : null);
        textAttributeProps.setColor(reactStylesDiffMap.hasKey(ViewProps.FOREGROUND_COLOR) ? Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.FOREGROUND_COLOR, 0)) : null);
        textAttributeProps.setBackgroundColor(reactStylesDiffMap.hasKey(ViewProps.BACKGROUND_COLOR) ? Integer.valueOf(reactStylesDiffMap.getInt(ViewProps.BACKGROUND_COLOR, 0)) : null);
        textAttributeProps.setFontFamily(getStringProp(reactStylesDiffMap, ViewProps.FONT_FAMILY));
        textAttributeProps.setFontWeight(getStringProp(reactStylesDiffMap, ViewProps.FONT_WEIGHT));
        textAttributeProps.setFontStyle(getStringProp(reactStylesDiffMap, ViewProps.FONT_STYLE));
        textAttributeProps.setFontVariant(getArrayProp(reactStylesDiffMap, ViewProps.FONT_VARIANT));
        textAttributeProps.setIncludeFontPadding(getBooleanProp(reactStylesDiffMap, ViewProps.INCLUDE_FONT_PADDING, true));
        textAttributeProps.setTextDecorationLine(getStringProp(reactStylesDiffMap, ViewProps.TEXT_DECORATION_LINE));
        if (reactStylesDiffMap.hasKey("textShadowOffset")) {
            readableMap = reactStylesDiffMap.getMap("textShadowOffset");
        }
        textAttributeProps.setTextShadowOffset(readableMap);
        textAttributeProps.setTextShadowRadius((float) getIntProp(reactStylesDiffMap, "textShadowRadius", 1));
        textAttributeProps.setTextShadowColor(getIntProp(reactStylesDiffMap, "textShadowColor", 1426063360));
        textAttributeProps.setTextTransform(getStringProp(reactStylesDiffMap, "textTransform"));
        textAttributeProps.setLayoutDirection(getStringProp(reactStylesDiffMap, ViewProps.LAYOUT_DIRECTION));
        textAttributeProps.setAccessibilityRole(getStringProp(reactStylesDiffMap, ViewProps.ACCESSIBILITY_ROLE));
        return textAttributeProps;
    }

    public static int getTextAlignment(ReactStylesDiffMap reactStylesDiffMap, boolean z) {
        String string = reactStylesDiffMap.hasKey(ViewProps.TEXT_ALIGN) ? reactStylesDiffMap.getString(ViewProps.TEXT_ALIGN) : null;
        if ("justify".equals(string)) {
            return 3;
        }
        if (string == null || "auto".equals(string)) {
            return 0;
        }
        if ("left".equals(string)) {
            if (z) {
                return 5;
            }
            return 3;
        } else if ("right".equals(string)) {
            if (z) {
                return 3;
            }
        } else if ("center".equals(string)) {
            return 1;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + string);
        }
        return 5;
    }

    public static int getJustificationMode(ReactStylesDiffMap reactStylesDiffMap) {
        if (!"justify".equals(reactStylesDiffMap.hasKey(ViewProps.TEXT_ALIGN) ? reactStylesDiffMap.getString(ViewProps.TEXT_ALIGN) : null) || Build.VERSION.SDK_INT < 26) {
            return DEFAULT_JUSTIFICATION_MODE;
        }
        return 1;
    }

    private static boolean getBooleanProp(ReactStylesDiffMap reactStylesDiffMap, String str, boolean z) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getBoolean(str, z) : z;
    }

    private static String getStringProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getString(str);
        }
        return null;
    }

    private static int getIntProp(ReactStylesDiffMap reactStylesDiffMap, String str, int i) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getInt(str, i) : i;
    }

    private static float getFloatProp(ReactStylesDiffMap reactStylesDiffMap, String str, float f) {
        return reactStylesDiffMap.hasKey(str) ? reactStylesDiffMap.getFloat(str, f) : f;
    }

    private static ReadableArray getArrayProp(ReactStylesDiffMap reactStylesDiffMap, String str) {
        if (reactStylesDiffMap.hasKey(str)) {
            return reactStylesDiffMap.getArray(str);
        }
        return null;
    }

    public float getEffectiveLineHeight() {
        return !Float.isNaN(this.mLineHeight) && !Float.isNaN(this.mHeightOfTallestInlineImage) && (this.mHeightOfTallestInlineImage > this.mLineHeight ? 1 : (this.mHeightOfTallestInlineImage == this.mLineHeight ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineImage : this.mLineHeight;
    }

    private void setNumberOfLines(int i) {
        if (i == 0) {
            i = -1;
        }
        this.mNumberOfLines = i;
    }

    private void setLineHeight(float f) {
        float f2;
        this.mLineHeightInput = f;
        if (f == -1.0f) {
            this.mLineHeight = Float.NaN;
            return;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(f);
        } else {
            f2 = PixelUtil.toPixelFromDIP(f);
        }
        this.mLineHeight = f2;
    }

    private void setLetterSpacing(float f) {
        this.mLetterSpacingInput = f;
    }

    public float getLetterSpacing() {
        float f;
        if (this.mAllowFontScaling) {
            f = PixelUtil.toPixelFromSP(this.mLetterSpacingInput);
        } else {
            f = PixelUtil.toPixelFromDIP(this.mLetterSpacingInput);
        }
        int i = this.mFontSize;
        if (i > 0) {
            return f / ((float) i);
        }
        throw new IllegalArgumentException("FontSize should be a positive value. Current value: " + this.mFontSize);
    }

    private void setAllowFontScaling(boolean z) {
        if (z != this.mAllowFontScaling) {
            this.mAllowFontScaling = z;
            setFontSize(this.mFontSizeInput);
            setLineHeight(this.mLineHeightInput);
            setLetterSpacing(this.mLetterSpacingInput);
        }
    }

    private void setFontSize(float f) {
        double d;
        this.mFontSizeInput = f;
        if (f != -1.0f) {
            if (this.mAllowFontScaling) {
                d = Math.ceil((double) PixelUtil.toPixelFromSP(f));
            } else {
                d = Math.ceil((double) PixelUtil.toPixelFromDIP(f));
            }
            f = (float) d;
        }
        this.mFontSize = (int) f;
    }

    private void setColor(Integer num) {
        boolean z = num != null;
        this.mIsColorSet = z;
        if (z) {
            this.mColor = num.intValue();
        }
    }

    private void setBackgroundColor(Integer num) {
        boolean z = num != null;
        this.mIsBackgroundColorSet = z;
        if (z) {
            this.mBackgroundColor = num.intValue();
        }
    }

    private void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    private void setFontVariant(ReadableArray readableArray) {
        this.mFontFeatureSettings = ReactTypefaceUtils.parseFontVariant(readableArray);
    }

    private void setFontVariant(ReadableMapBuffer readableMapBuffer) {
        if (readableMapBuffer == null || readableMapBuffer.getCount() == 0) {
            this.mFontFeatureSettings = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ReadableMapBuffer.MapBufferEntry> it = readableMapBuffer.iterator();
        while (it.hasNext()) {
            String string = it.next().getString();
            if (string != null) {
                char c = 65535;
                switch (string.hashCode()) {
                    case -1195362251:
                        if (string.equals("proportional-nums")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1061392823:
                        if (string.equals("lining-nums")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -771984547:
                        if (string.equals("tabular-nums")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -659678800:
                        if (string.equals("oldstyle-nums")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1183323111:
                        if (string.equals("small-caps")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    arrayList.add("'smcp'");
                } else if (c == 1) {
                    arrayList.add("'onum'");
                } else if (c == 2) {
                    arrayList.add("'lnum'");
                } else if (c == 3) {
                    arrayList.add("'tnum'");
                } else if (c == 4) {
                    arrayList.add("'pnum'");
                }
            }
        }
        this.mFontFeatureSettings = TextUtils.join(", ", arrayList);
    }

    private void setFontWeight(String str) {
        this.mFontWeight = ReactTypefaceUtils.parseFontWeight(str);
    }

    private void setFontStyle(String str) {
        this.mFontStyle = ReactTypefaceUtils.parseFontStyle(str);
    }

    private void setIncludeFontPadding(boolean z) {
        this.mIncludeFontPadding = z;
    }

    private void setTextDecorationLine(String str) {
        this.mIsUnderlineTextDecorationSet = false;
        this.mIsLineThroughTextDecorationSet = false;
        if (str != null) {
            for (String str2 : str.split("-")) {
                if ("underline".equals(str2)) {
                    this.mIsUnderlineTextDecorationSet = true;
                } else if ("strikethrough".equals(str2)) {
                    this.mIsLineThroughTextDecorationSet = true;
                }
            }
        }
    }

    private void setTextShadowOffset(ReadableMap readableMap) {
        this.mTextShadowOffsetDx = 0.0f;
        this.mTextShadowOffsetDy = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.mTextShadowOffsetDx = PixelUtil.toPixelFromDIP(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.mTextShadowOffsetDy = PixelUtil.toPixelFromDIP(readableMap.getDouble("height"));
            }
        }
    }

    public static int getLayoutDirection(String str) {
        if (str == null || "undefined".equals(str)) {
            return -1;
        }
        if ("rtl".equals(str)) {
            return 1;
        }
        if ("ltr".equals(str)) {
            return 0;
        }
        throw new JSApplicationIllegalArgumentException("Invalid layoutDirection: " + str);
    }

    private void setLayoutDirection(String str) {
        this.mLayoutDirection = getLayoutDirection(str);
    }

    private void setTextShadowRadius(float f) {
        if (f != this.mTextShadowRadius) {
            this.mTextShadowRadius = f;
        }
    }

    private void setTextShadowColor(int i) {
        if (i != this.mTextShadowColor) {
            this.mTextShadowColor = i;
        }
    }

    private void setTextTransform(String str) {
        if (str == null || "none".equals(str)) {
            this.mTextTransform = TextTransform.NONE;
        } else if ("uppercase".equals(str)) {
            this.mTextTransform = TextTransform.UPPERCASE;
        } else if ("lowercase".equals(str)) {
            this.mTextTransform = TextTransform.LOWERCASE;
        } else if ("capitalize".equals(str)) {
            this.mTextTransform = TextTransform.CAPITALIZE;
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
        }
    }

    private void setAccessibilityRole(String str) {
        if (str != null) {
            this.mIsAccessibilityRoleSet = str != null;
            this.mAccessibilityRole = ReactAccessibilityDelegate.AccessibilityRole.fromValue(str);
        }
    }

    public static int getTextBreakStrategy(String str) {
        int i = DEFAULT_BREAK_STRATEGY;
        if (str == null) {
            return i;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1924829944) {
            if (hashCode == -902286926 && str.equals(FtsOptions.TOKENIZER_SIMPLE)) {
                c = 0;
            }
        } else if (str.equals("balanced")) {
            c = 1;
        }
        if (c != 0) {
            return c != 1 ? 1 : 2;
        }
        return 0;
    }
}
