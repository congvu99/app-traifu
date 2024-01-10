package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "kotlin.jvm.PlatformType", "awaitLoad", "Landroid/graphics/Typeface;", "font", "Landroidx/compose/ui/text/font/Font;", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBlocking", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidFontLoader.android.kt */
public final class AndroidFontLoader implements PlatformFontLoader {
    private final Object cacheKey;
    private final Context context;

    public AndroidFontLoader(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2.getApplicationContext();
    }

    public Typeface loadBlocking(Font font) {
        Typeface typeface;
        Object obj;
        Intrinsics.checkNotNullParameter(font, "font");
        Object obj2 = null;
        if (font instanceof AndroidFont) {
            AndroidFont androidFont = (AndroidFont) font;
            AndroidFont.TypefaceLoader typefaceLoader = androidFont.getTypefaceLoader();
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            return typefaceLoader.loadBlocking(context2, androidFont);
        } else if (!(font instanceof ResourceFont)) {
            return null;
        } else {
            int r0 = font.m4280getLoadingStrategyPKNRLFQ();
            if (FontLoadingStrategy.m4295equalsimpl0(r0, FontLoadingStrategy.Companion.m4300getBlockingPKNRLFQ())) {
                Context context3 = this.context;
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                typeface = AndroidFontLoader_androidKt.load((ResourceFont) font, context3);
            } else if (FontLoadingStrategy.m4295equalsimpl0(r0, FontLoadingStrategy.Companion.m4301getOptionalLocalPKNRLFQ())) {
                try {
                    Result.Companion companion = Result.Companion;
                    Context context4 = this.context;
                    Intrinsics.checkNotNullExpressionValue(context4, "context");
                    obj = Result.m5428constructorimpl(AndroidFontLoader_androidKt.load((ResourceFont) font, context4));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m5428constructorimpl(ResultKt.createFailure(th));
                }
                if (!Result.m5434isFailureimpl(obj)) {
                    obj2 = obj;
                }
                typeface = (Typeface) obj2;
            } else if (FontLoadingStrategy.m4295equalsimpl0(r0, FontLoadingStrategy.Companion.m4299getAsyncPKNRLFQ())) {
                throw new UnsupportedOperationException("Unsupported Async font load path");
            } else {
                throw new IllegalArgumentException("Unknown loading type " + FontLoadingStrategy.m4297toStringimpl(font.m4280getLoadingStrategyPKNRLFQ()));
            }
            FontVariation.Settings variationSettings = ((ResourceFont) font).getVariationSettings();
            Context context5 = this.context;
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            return PlatformTypefacesKt.setFontVariationSettings(typeface, variationSettings, context5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object awaitLoad(androidx.compose.ui.text.font.Font r7, kotlin.coroutines.Continuation<? super android.graphics.Typeface> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = (androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1 r0 = new androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            java.lang.String r5 = "context"
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r7 = r0.L$1
            androidx.compose.ui.text.font.Font r7 = (androidx.compose.ui.text.font.Font) r7
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.AndroidFontLoader r0 = (androidx.compose.ui.text.font.AndroidFontLoader) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005e
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7 instanceof androidx.compose.ui.text.font.AndroidFont
            if (r8 == 0) goto L_0x005f
            androidx.compose.ui.text.font.AndroidFont r7 = (androidx.compose.ui.text.font.AndroidFont) r7
            androidx.compose.ui.text.font.AndroidFont$TypefaceLoader r8 = r7.getTypefaceLoader()
            android.content.Context r2 = r6.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r0.label = r4
            java.lang.Object r8 = r8.awaitLoad(r2, r7, r0)
            if (r8 != r1) goto L_0x005e
            return r1
        L_0x005e:
            return r8
        L_0x005f:
            boolean r8 = r7 instanceof androidx.compose.ui.text.font.ResourceFont
            if (r8 == 0) goto L_0x008b
            r8 = r7
            androidx.compose.ui.text.font.ResourceFont r8 = (androidx.compose.ui.text.font.ResourceFont) r8
            android.content.Context r2 = r6.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = androidx.compose.ui.text.font.AndroidFontLoader_androidKt.loadAsync(r8, r2, r0)
            if (r8 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r0 = r6
        L_0x0079:
            android.graphics.Typeface r8 = (android.graphics.Typeface) r8
            androidx.compose.ui.text.font.ResourceFont r7 = (androidx.compose.ui.text.font.ResourceFont) r7
            androidx.compose.ui.text.font.FontVariation$Settings r7 = r7.getVariationSettings()
            android.content.Context r0 = r0.context
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            android.graphics.Typeface r7 = androidx.compose.ui.text.font.PlatformTypefacesKt.setFontVariationSettings(r8, r7, r0)
            return r7
        L_0x008b:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown font type: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AndroidFontLoader.awaitLoad(androidx.compose.ui.text.font.Font, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getCacheKey() {
        return this.cacheKey;
    }
}
