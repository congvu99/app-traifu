package io.intercom.android.sdk.survey.ui;

import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import io.intercom.android.sdk.survey.CloseEventTrigger;
import io.intercom.android.sdk.survey.SurveyState;
import io.intercom.android.sdk.survey.SurveyViewModel;
import io.intercom.android.sdk.survey.ui.components.SurveyComponentKt;
import io.intercom.android.sdk.utilities.ApplyStatusBarColorKt;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import io.intercom.android.sdk.utilities.LinkOpener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomSurveyActivity.kt */
final class IntercomSurveyActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IntercomSurveyActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomSurveyActivity$onCreate$1(IntercomSurveyActivity intercomSurveyActivity) {
        super(2);
        this.this$0 = intercomSurveyActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final IntercomSurveyActivity intercomSurveyActivity = this.this$0;
            ThemeKt.IntercomSurveyTheme(false, ComposableLambdaKt.composableLambda(composer, 606171514, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        State collectAsState = SnapshotStateKt.collectAsState(intercomSurveyActivity.getViewModel().getState(), (CoroutineContext) null, composer, 8, 1);
                        ApplyStatusBarColorKt.m5394applyStatusBarColor4WTKRHQ(SystemUiControllerKt.rememberSystemUiController((Window) null, composer, 0, 1), ColorExtensionsKt.m5395darken8_81llA(((SurveyState) collectAsState.getValue()).getSurveyUiColors().m5273getBackground0d7_KjU()));
                        final IntercomSurveyActivity intercomSurveyActivity = intercomSurveyActivity;
                        final IntercomSurveyActivity intercomSurveyActivity2 = intercomSurveyActivity;
                        SurveyComponentKt.SurveyComponent((SurveyState) collectAsState.getValue(), new Function1<CoroutineScope, Unit>(intercomSurveyActivity.getViewModel()) {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((CoroutineScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(CoroutineScope coroutineScope) {
                                ((SurveyViewModel) this.receiver).continueClicked(coroutineScope);
                            }
                        }, new Function0<Unit>() {
                            public final void invoke() {
                                intercomSurveyActivity.getViewModel().onCloseClicked(CloseEventTrigger.CLOSE_BUTTON);
                            }
                        }, new Function0<Unit>(intercomSurveyActivity.getViewModel()) {
                            public final void invoke() {
                                ((SurveyViewModel) this.receiver).onAnswerUpdated();
                            }
                        }, new Function1<SurveyState.Content.SecondaryCta, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SurveyState.Content.SecondaryCta) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SurveyState.Content.SecondaryCta secondaryCta) {
                                Intrinsics.checkNotNullParameter(secondaryCta, "it");
                                intercomSurveyActivity2.getViewModel().onSecondaryCtaClicked(secondaryCta);
                                String destination = secondaryCta.getDestination();
                                IntercomSurveyActivity intercomSurveyActivity = intercomSurveyActivity2;
                                LinkOpener.handleUrl(destination, intercomSurveyActivity, intercomSurveyActivity.injector.getApi());
                            }
                        }, composer, 0, 0);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 1);
            return;
        }
        composer.skipToGroupEnd();
    }
}
