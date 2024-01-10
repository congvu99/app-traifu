package io.intercom.android.sdk.m5.helpcenter.components;

import android.content.Context;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.utilities.Phrase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"ArticleCountComponent", "", "modifier", "Landroidx/compose/ui/Modifier;", "noOfArticles", "", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "ArticleCountComponentPreview", "(Landroidx/compose/runtime/Composer;I)V", "SingleArticleCountComponentPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArticleCountComponent.kt */
public final class ArticleCountComponentKt {
    public static final void ArticleCountComponent(Modifier modifier, int i, Composer composer, int i2, int i3) {
        int i4;
        Modifier modifier2;
        CharSequence charSequence;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        Composer startRestartGroup = composer.startRestartGroup(1912232704);
        int i8 = i7 & 1;
        if (i8 != 0) {
            i4 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 14) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i4 = i6;
        }
        if ((i7 & 2) != 0) {
            i4 |= 48;
        } else if ((i6 & 112) == 0) {
            i4 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        int i9 = i4;
        if ((i9 & 91) != 18 || !startRestartGroup.getSkipping()) {
            Modifier modifier3 = i8 != 0 ? Modifier.Companion : modifier2;
            if (i5 == 1) {
                startRestartGroup.startReplaceableGroup(-1867918208);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                charSequence = Phrase.from((Context) consume, R.string.intercom_single_article).format();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1867918110);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                charSequence = Phrase.from((Context) consume2, R.string.intercom_multiple_articles).put("total_articles", i5).format();
                startRestartGroup.endReplaceableGroup();
            }
            modifier2 = modifier3;
            TextKt.m1496TextfLXpl1I(charSequence.toString(), modifier2, ColorKt.Color(4285887861L), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getBody2(), startRestartGroup, ((i9 << 3) & 112) | BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 0, 32760);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleCountComponentKt$ArticleCountComponent$1(modifier2, i5, i6, i7));
        }
    }

    public static final void ArticleCountComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1952874410);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ArticleCountComponentKt.INSTANCE.m5192getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleCountComponentKt$ArticleCountComponentPreview$1(i));
        }
    }

    public static final void SingleArticleCountComponentPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1537092926);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ArticleCountComponentKt.INSTANCE.m5193getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ArticleCountComponentKt$SingleArticleCountComponentPreview$1(i));
        }
    }
}
