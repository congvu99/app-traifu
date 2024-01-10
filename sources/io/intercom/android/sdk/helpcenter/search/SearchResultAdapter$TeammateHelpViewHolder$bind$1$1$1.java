package io.intercom.android.sdk.helpcenter.search;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.helpcenter.components.TeamPresenceComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SearchResultAdapter.kt */
final class SearchResultAdapter$TeammateHelpViewHolder$bind$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ArticleSearchResultRow.TeammateHelpRow $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultAdapter$TeammateHelpViewHolder$bind$1$1$1(ArticleSearchResultRow.TeammateHelpRow teammateHelpRow) {
        super(2);
        this.$this_with = teammateHelpRow;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final ArticleSearchResultRow.TeammateHelpRow teammateHelpRow = this.$this_with;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1443588870, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        TeamPresenceComponentKt.TeamPresenceComponent(teammateHelpRow.getTeamPresenceState(), composer, 8);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }
}
