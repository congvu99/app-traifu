package com.mattyork.colours;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.FacebookRequestErrorClassification;
import org.apache.http.HttpStatus;

public class Colour extends Color {

    public enum ColorScheme {
        ColorSchemeAnalagous,
        ColorSchemeMonochromatic,
        ColorSchemeTriad,
        ColorSchemeComplementary
    }

    public static float addDegrees(float f, float f2) {
        float f3 = f2 + f;
        return f3 > 360.0f ? f3 - 360.0f : f3 < 0.0f ? f3 * -1.0f : f3;
    }

    public static int[] colorSchemeOfType(int i, ColorScheme colorScheme) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        int i2 = AnonymousClass1.$SwitchMap$com$mattyork$colours$Colour$ColorScheme[colorScheme.ordinal()];
        if (i2 == 1) {
            return analagousColors(fArr);
        }
        if (i2 == 2) {
            return monochromaticColors(fArr);
        }
        if (i2 == 3) {
            return triadColors(fArr);
        }
        if (i2 != 4) {
            return null;
        }
        return complementaryColors(fArr);
    }

    /* renamed from: com.mattyork.colours.Colour$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$mattyork$colours$Colour$ColorScheme;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mattyork.colours.Colour$ColorScheme[] r0 = com.mattyork.colours.Colour.ColorScheme.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mattyork$colours$Colour$ColorScheme = r0
                com.mattyork.colours.Colour$ColorScheme r1 = com.mattyork.colours.Colour.ColorScheme.ColorSchemeAnalagous     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mattyork$colours$Colour$ColorScheme     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mattyork.colours.Colour$ColorScheme r1 = com.mattyork.colours.Colour.ColorScheme.ColorSchemeMonochromatic     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mattyork$colours$Colour$ColorScheme     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mattyork.colours.Colour$ColorScheme r1 = com.mattyork.colours.Colour.ColorScheme.ColorSchemeTriad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$mattyork$colours$Colour$ColorScheme     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mattyork.colours.Colour$ColorScheme r1 = com.mattyork.colours.Colour.ColorScheme.ColorSchemeComplementary     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mattyork.colours.Colour.AnonymousClass1.<clinit>():void");
        }
    }

    public static int[] analagousColors(float[] fArr) {
        return new int[]{Color.HSVToColor(new float[]{addDegrees(fArr[0], 15.0f), (float) (((double) fArr[1]) - 0.05d), (float) (((double) fArr[2]) - 0.05d)}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 30.0f), (float) (((double) fArr[1]) - 0.05d), (float) (((double) fArr[2]) - 0.1d)}), Color.HSVToColor(new float[]{addDegrees(fArr[0], -15.0f), (float) (((double) fArr[1]) - 0.05d), (float) (((double) fArr[2]) - 0.05d)}), Color.HSVToColor(new float[]{addDegrees(fArr[0], -30.0f), (float) (((double) fArr[1]) - 0.05d), (float) (((double) fArr[2]) - 0.1d)})};
    }

    public static int[] monochromaticColors(float[] fArr) {
        return new int[]{Color.HSVToColor(new float[]{fArr[0], fArr[1], fArr[2] / 2.0f}), Color.HSVToColor(new float[]{fArr[0], fArr[1] / 2.0f, fArr[2] / 3.0f}), Color.HSVToColor(new float[]{fArr[0], fArr[1] / 3.0f, (fArr[2] * 2.0f) / 3.0f}), Color.HSVToColor(new float[]{fArr[0], fArr[1], (fArr[2] * 4.0f) / 5.0f})};
    }

    public static int[] triadColors(float[] fArr) {
        return new int[]{Color.HSVToColor(new float[]{addDegrees(fArr[0], 120.0f), fArr[1], fArr[2]}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 120.0f), (fArr[1] * 7.0f) / 6.0f, (float) (((double) fArr[2]) - 0.05d)}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 240.0f), fArr[1], fArr[2]}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 240.0f), (fArr[1] * 7.0f) / 6.0f, (float) (((double) fArr[2]) - 0.05d)})};
    }

    public static int[] complementaryColors(float[] fArr) {
        return new int[]{Color.HSVToColor(new float[]{fArr[0], (fArr[1] * 5.0f) / 7.0f, fArr[2]}), Color.HSVToColor(new float[]{fArr[0], fArr[1], (fArr[2] * 4.0f) / 5.0f}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 180.0f), fArr[1], fArr[2]}), Color.HSVToColor(new float[]{addDegrees(fArr[0], 180.0f), (fArr[1] * 5.0f) / 7.0f, fArr[2]})};
    }

    public static int blackOrWhiteContrastingColor(int i) {
        int[] iArr = {red(i), green(i), blue(i)};
        if (1.0d - (((((double) iArr[0]) * 0.00299d) + (((double) iArr[1]) * 0.00587d)) + (((double) iArr[2]) * 0.00114d)) < 0.5d) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return -1;
    }

    public static int complementaryColor(int i) {
        float[] fArr = new float[3];
        colorToHSV(i, fArr);
        fArr[0] = addDegrees(180.0f, fArr[0]);
        return HSVToColor(fArr);
    }

    public static int infoBlueColor() {
        return rgb(47, 112, JfifUtil.MARKER_APP1);
    }

    public static int successColor() {
        return rgb(83, JfifUtil.MARKER_RST7, 106);
    }

    public static int warningColor() {
        return rgb(221, 170, 59);
    }

    public static int dangerColor() {
        return rgb(229, 0, 15);
    }

    public static int antiqueWhiteColor() {
        return rgb(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 235, JfifUtil.MARKER_RST7);
    }

    public static int oldLaceColor() {
        return rgb(253, 245, 230);
    }

    public static int ivoryColor() {
        return rgb(255, 255, 240);
    }

    public static int seashellColor() {
        return rgb(255, 245, 238);
    }

    public static int ghostWhiteColor() {
        return rgb(248, 248, 255);
    }

    public static int snowColor() {
        return rgb(255, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public static int linenColor() {
        return rgb(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 240, 230);
    }

    public static int black25PercentColor() {
        return rgb(64, 64, 64);
    }

    public static int black50PercentColor() {
        return rgb(128, 128, 128);
    }

    public static int black75PercentColor() {
        return rgb(JfifUtil.MARKER_SOFn, JfifUtil.MARKER_SOFn, JfifUtil.MARKER_SOFn);
    }

    public static int warmGrayColor() {
        return rgb(133, 117, 112);
    }

    public static int coolGrayColor() {
        return rgb(118, 122, 133);
    }

    public static int charcoalColor() {
        return rgb(34, 34, 34);
    }

    public static int tealColor() {
        return rgb(28, 160, 170);
    }

    public static int steelBlueColor() {
        return rgb(103, 153, 170);
    }

    public static int robinEggColor() {
        return rgb(141, JfifUtil.MARKER_SOS, 247);
    }

    public static int pastelBlueColor() {
        return rgb(99, 161, 247);
    }

    public static int turquoiseColor() {
        return rgb(112, 219, 219);
    }

    public static int skyBlueColor() {
        return rgb(0, 178, 238);
    }

    public static int indigoColor() {
        return rgb(13, 79, 139);
    }

    public static int denimColor() {
        return rgb(67, 114, 170);
    }

    public static int blueberryColor() {
        return rgb(89, 113, 173);
    }

    public static int cornflowerColor() {
        return rgb(100, 149, 237);
    }

    public static int babyBlueColor() {
        return rgb(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 220, 230);
    }

    public static int midnightBlueColor() {
        return rgb(13, 26, 35);
    }

    public static int fadedBlueColor() {
        return rgb(23, 137, 155);
    }

    public static int icebergColor() {
        return rgb(200, 213, 219);
    }

    public static int waveColor() {
        return rgb(102, 169, 251);
    }

    public static int emeraldColor() {
        return rgb(1, 152, 117);
    }

    public static int grassColor() {
        return rgb(99, 214, 74);
    }

    public static int pastelGreenColor() {
        return rgb(126, 242, 124);
    }

    public static int seafoamColor() {
        return rgb(77, 226, 140);
    }

    public static int paleGreenColor() {
        return rgb(176, 226, 172);
    }

    public static int cactusGreenColor() {
        return rgb(99, 111, 87);
    }

    public static int chartreuseColor() {
        return rgb(69, 139, 0);
    }

    public static int hollyGreenColor() {
        return rgb(32, 87, 14);
    }

    public static int oliveColor() {
        return rgb(91, 114, 34);
    }

    public static int oliveDrabColor() {
        return rgb(107, 142, 35);
    }

    public static int moneyGreenColor() {
        return rgb(134, 198, 124);
    }

    public static int honeydewColor() {
        return rgb(JfifUtil.MARKER_SOI, 255, 231);
    }

    public static int limeColor() {
        return rgb(56, 237, 56);
    }

    public static int cardTableColor() {
        return rgb(87, 121, 107);
    }

    public static int salmonColor() {
        return rgb(233, 87, 95);
    }

    public static int brickRedColor() {
        return rgb(151, 27, 16);
    }

    public static int easterPinkColor() {
        return rgb(241, 167, 162);
    }

    public static int grapefruitColor() {
        return rgb(228, 31, 54);
    }

    public static int pinkColor() {
        return rgb(255, 95, 154);
    }

    public static int indianRedColor() {
        return rgb(HttpStatus.SC_RESET_CONTENT, 92, 92);
    }

    public static int strawberryColor() {
        return rgb(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 38, 37);
    }

    public static int coralColor() {
        return rgb(240, 128, 128);
    }

    public static int maroonColor() {
        return rgb(80, 4, 28);
    }

    public static int watermelonColor() {
        return rgb(242, 71, 63);
    }

    public static int tomatoColor() {
        return rgb(255, 99, 71);
    }

    public static int pinkLipstickColor() {
        return rgb(255, 105, RotationOptions.ROTATE_180);
    }

    public static int paleRoseColor() {
        return rgb(255, 228, JfifUtil.MARKER_APP1);
    }

    public static int crimsonColor() {
        return rgb(187, 18, 36);
    }

    public static int eggplantColor() {
        return rgb(105, 5, 98);
    }

    public static int pastelPurpleColor() {
        return rgb(207, 100, 235);
    }

    public static int palePurpleColor() {
        return rgb(229, RotationOptions.ROTATE_180, 235);
    }

    public static int coolPurpleColor() {
        return rgb(140, 93, 228);
    }

    public static int violetColor() {
        return rgb(191, 95, 255);
    }

    public static int plumColor() {
        return rgb(139, 102, 139);
    }

    public static int lavenderColor() {
        return rgb(204, 153, 204);
    }

    public static int raspberryColor() {
        return rgb(135, 38, 87);
    }

    public static int fuschiaColor() {
        return rgb(255, 20, 147);
    }

    public static int grapeColor() {
        return rgb(54, 11, 88);
    }

    public static int periwinkleColor() {
        return rgb(135, 159, 237);
    }

    public static int orchidColor() {
        return rgb(JfifUtil.MARKER_SOS, 112, 214);
    }

    public static int goldenrodColor() {
        return rgb(JfifUtil.MARKER_RST7, 170, 51);
    }

    public static int yellowGreenColor() {
        return rgb(JfifUtil.MARKER_SOFn, 242, 39);
    }

    public static int bananaColor() {
        return rgb(229, 227, 58);
    }

    public static int mustardColor() {
        return rgb(HttpStatus.SC_RESET_CONTENT, 171, 45);
    }

    public static int buttermilkColor() {
        return rgb(254, 241, 181);
    }

    public static int goldColor() {
        return rgb(139, 117, 18);
    }

    public static int creamColor() {
        return rgb(240, 226, 187);
    }

    public static int lightCreamColor() {
        return rgb(240, 238, JfifUtil.MARKER_RST7);
    }

    public static int wheatColor() {
        return rgb(240, 238, JfifUtil.MARKER_RST7);
    }

    public static int beigeColor() {
        return rgb(245, 245, 220);
    }

    public static int peachColor() {
        return rgb(242, 187, 97);
    }

    public static int burntOrangeColor() {
        return rgb(184, 102, 37);
    }

    public static int pastelOrangeColor() {
        return rgb(248, 197, 143);
    }

    public static int cantaloupeColor() {
        return rgb(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 154, 79);
    }

    public static int carrotColor() {
        return rgb(237, 145, 33);
    }

    public static int mandarinColor() {
        return rgb(247, 145, 55);
    }

    public static int chiliPowderColor() {
        return rgb(199, 63, 23);
    }

    public static int burntSiennaColor() {
        return rgb(138, 54, 15);
    }

    public static int chocolateColor() {
        return rgb(94, 38, 5);
    }

    public static int coffeeColor() {
        return rgb(141, 60, 15);
    }

    public static int cinnamonColor() {
        return rgb(123, 63, 9);
    }

    public static int almondColor() {
        return rgb(196, 142, 72);
    }

    public static int eggshellColor() {
        return rgb(252, 230, 201);
    }

    public static int sandColor() {
        return rgb(222, 182, 151);
    }

    public static int mudColor() {
        return rgb(70, 45, 29);
    }

    public static int siennaColor() {
        return rgb(160, 82, 45);
    }

    public static int dustColor() {
        return rgb(236, 214, 197);
    }
}
