package io.intercom.android.sdk.m5.notification;

import android.content.Context;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\f\u001a\u0016\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0011"}, d2 = {"InAppNotificationCard", "", "conversation", "Lio/intercom/android/sdk/models/Conversation;", "(Lio/intercom/android/sdk/models/Conversation;Landroidx/compose/runtime/Composer;I)V", "InAppNotificationCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "InAppNotificationCardTicketPreview", "TicketInAppNotificationContent", "name", "", "ticketStatus", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "addNotificationToRoot", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "addTicketHeaderToCompose", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
public final class InAppNotificationCardKt {
    public static final void addNotificationToRoot(ComposeView composeView, Conversation conversation) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-426668883, true, new InAppNotificationCardKt$addNotificationToRoot$1$1(conversation)));
    }

    public static final void addTicketHeaderToCompose(ComposeView composeView, Conversation conversation) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-744078063, true, new InAppNotificationCardKt$addTicketHeaderToCompose$1$1(conversation)));
    }

    public static final void InAppNotificationCard(Conversation conversation, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Composer startRestartGroup = composer.startRestartGroup(-2019664678);
        IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1434330384, true, new InAppNotificationCardKt$InAppNotificationCard$1(conversation)), startRestartGroup, 3072, 7);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InAppNotificationCardKt$InAppNotificationCard$2(conversation, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void TicketInAppNotificationContent(String str, String str2, Composer composer, int i) {
        int i2;
        AnnotatedString annotatedString;
        String str3 = str;
        String str4 = str2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(2076215052);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) str4) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (str3 != null) {
                startRestartGroup.startReplaceableGroup(957313789);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                annotatedString = new AnnotatedString(Phrase.from((Context) consume, R.string.intercom_tickets_status_event_moved).put("teammate", (CharSequence) str3).put("status", (CharSequence) str4).format().toString(), (List) null, (List) null, 6, (DefaultConstructorMarker) null);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(957314074);
                annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.intercom_tickets_status_description_prefix_when_submitted, startRestartGroup, 0) + TokenParser.SP + str4, (List) null, (List) null, 6, (DefaultConstructorMarker) null);
                startRestartGroup.endReplaceableGroup();
            }
            TextKt.m1495Text4IGK_g(annotatedString, (Modifier) null, 0, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m4591getEllipsisgIe3tQ8(), false, 2, (Map<String, InlineTextContent>) null, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, 8).getSubtitle1(), startRestartGroup, 3072, 3120, 55286);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InAppNotificationCardKt$TicketInAppNotificationContent$1(str3, str4, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final void InAppNotificationCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2144100909);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InAppNotificationCardKt.INSTANCE.m5258getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InAppNotificationCardKt$InAppNotificationCardPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void InAppNotificationCardTicketPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-186124313);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InAppNotificationCardKt.INSTANCE.m5259getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InAppNotificationCardKt$InAppNotificationCardTicketPreview$1(i));
        }
    }
}
