package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontVariation;
import java.io.File;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0014\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\b\u0010\u0017\u001a\u00020\u0018H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "assetManager", "Landroid/content/res/AssetManager;", "path", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-wCLgNak", "(Landroid/content/res/AssetManager;Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "fileDescriptor", "Landroid/os/ParcelFileDescriptor;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-Ej4NQ78", "(Landroid/os/ParcelFileDescriptor;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "file", "Ljava/io/File;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "Font-MuC2MFs", "(Ljava/lang/String;Landroid/content/res/AssetManager;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "generateAndroidFontKtForApiCompatibility", "", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidFont.kt */
public final class AndroidFontKt {
    private static final void generateAndroidFontKtForApiCompatibility() {
    }

    /* renamed from: Font-wCLgNak$default  reason: not valid java name */
    public static /* synthetic */ Font m4256FontwCLgNak$default(AssetManager assetManager, String str, FontWeight fontWeight, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.Companion.m4313getNormal_LCdwA();
        }
        return m4255FontwCLgNak(assetManager, str, fontWeight, i);
    }

    @ExperimentalTextApi
    @Deprecated(level = DeprecationLevel.WARNING, message = "This experimental Font is replaced by Font(path, assetManager, ...)", replaceWith = @ReplaceWith(expression = "Font(path, assetManager, weight, style)", imports = {}))
    /* renamed from: Font-wCLgNak  reason: not valid java name */
    public static final Font m4255FontwCLgNak(AssetManager assetManager, String str, FontWeight fontWeight, int i) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new AndroidAssetFont(assetManager, str, fontWeight, i, FontVariation.INSTANCE.m4328Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]), (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-MuC2MFs$default  reason: not valid java name */
    public static /* synthetic */ Font m4254FontMuC2MFs$default(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 8) != 0) {
            i = FontStyle.Companion.m4313getNormal_LCdwA();
        }
        if ((i2 & 16) != 0) {
            settings = FontVariation.INSTANCE.m4328Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m4253FontMuC2MFs(str, assetManager, fontWeight, i, settings);
    }

    @ExperimentalTextApi
    /* renamed from: Font-MuC2MFs  reason: not valid java name */
    public static final Font m4253FontMuC2MFs(String str, AssetManager assetManager, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new AndroidAssetFont(assetManager, str, fontWeight, i, settings, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-Ej4NQ78$default  reason: not valid java name */
    public static /* synthetic */ Font m4252FontEj4NQ78$default(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4313getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = FontVariation.INSTANCE.m4328Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m4250FontEj4NQ78(file, fontWeight, i, settings);
    }

    @ExperimentalTextApi
    /* renamed from: Font-Ej4NQ78  reason: not valid java name */
    public static final Font m4250FontEj4NQ78(File file, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new AndroidFileFont(file, fontWeight, i, settings, (DefaultConstructorMarker) null);
    }

    /* renamed from: Font-Ej4NQ78$default  reason: not valid java name */
    public static /* synthetic */ Font m4251FontEj4NQ78$default(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation.Settings settings, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i2 & 4) != 0) {
            i = FontStyle.Companion.m4313getNormal_LCdwA();
        }
        if ((i2 & 8) != 0) {
            settings = FontVariation.INSTANCE.m4328Settings6EWAqTQ(fontWeight, i, new FontVariation.Setting[0]);
        }
        return m4249FontEj4NQ78(parcelFileDescriptor, fontWeight, i, settings);
    }

    @ExperimentalTextApi
    /* renamed from: Font-Ej4NQ78  reason: not valid java name */
    public static final Font m4249FontEj4NQ78(ParcelFileDescriptor parcelFileDescriptor, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "fileDescriptor");
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settings, "variationSettings");
        return new AndroidFileDescriptorFont(parcelFileDescriptor, fontWeight, i, settings, (DefaultConstructorMarker) null);
    }
}
