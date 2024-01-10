package io.intercom.android.sdk.views.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.blocks.lib.BlockType;
import io.intercom.android.sdk.models.Part;
import java.util.List;

public class ConversationItemDecoration extends RecyclerView.ItemDecoration {
    private static final int BIG_TICKET_SPACING = 12;
    private static final int COMPOSER_SUGGESTIONS_SPACING = 48;
    private static final int CONCAT_SPACING = 4;
    private static final int DIVIDER_BOTTOM_SPACING = 10;
    private static final int DIVIDER_TOP_SPACING = 16;
    private static final int MESSAGE_ROW_SHADOW_SPACING = 4;
    private static final int SHADOW_CONCAT_SPACING = 0;
    private static final int SHADOW_SPACING = 12;
    private static final int SPACING = 16;
    private static final int TEAM_PRESENCE_SPACING = 48;
    private static final int TOP_SPACING = 24;
    private final int bigTicketSpacing;
    private final int composerSuggestionsSpacing;
    private final int concatSpacing;
    private final int dividerBottomSpacing;
    private final int dividerTopSpacing;
    private final List<Part> parts;
    private final int shadowConcatSpacing;
    private final int shadowSpacing;
    private final int spacing;
    private final int teamPresenceSpacing;
    private final int topSpacing;

    public ConversationItemDecoration(Context context, List<Part> list) {
        this.parts = list;
        this.spacing = ScreenUtils.dpToPx(16.0f, context);
        this.topSpacing = ScreenUtils.dpToPx(24.0f, context);
        this.concatSpacing = ScreenUtils.dpToPx(4.0f, context);
        this.dividerTopSpacing = ScreenUtils.dpToPx(16.0f, context);
        this.dividerBottomSpacing = ScreenUtils.dpToPx(10.0f, context);
        this.shadowSpacing = ScreenUtils.dpToPx(12.0f, context);
        this.shadowConcatSpacing = ScreenUtils.dpToPx(0.0f, context);
        this.teamPresenceSpacing = ScreenUtils.dpToPx(48.0f, context);
        this.bigTicketSpacing = ScreenUtils.dpToPx(12.0f, context);
        this.composerSuggestionsSpacing = ScreenUtils.dpToPx(48.0f, context);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition != -1 && childLayoutPosition < this.parts.size()) {
            Part part = this.parts.get(childLayoutPosition);
            if (Part.DAY_DIVIDER_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, this.dividerTopSpacing, 0, this.dividerBottomSpacing);
            } else if (Part.BIG_TICKET_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, bigTicketTopSpacingAtPosition(childLayoutPosition), 0, 0);
            } else if (isSingleBlockPartWithShadow(part)) {
                rect.set(0, shadowTopSpacingAtPosition(childLayoutPosition), 0, 0);
            } else if (shouldConcatenate(part, childLayoutPosition) && nextPartIsSingleBlockPartWithShadow(childLayoutPosition)) {
                rect.set(0, topSpacingAtPosition(childLayoutPosition), 0, this.shadowConcatSpacing);
            } else if (shouldConcatenate(part, childLayoutPosition)) {
                rect.set(0, topSpacingAtPosition(childLayoutPosition), 0, this.concatSpacing);
            } else if (nextPartIsDivider(childLayoutPosition) && !Part.TEAM_PRESENCE_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, topSpacingAtPosition(childLayoutPosition), 0, 0);
            } else if (nextPartIsSingleBlockPartWithShadow(childLayoutPosition)) {
                rect.set(0, topSpacingAtPosition(childLayoutPosition), 0, this.shadowSpacing);
            } else if (Part.TEAM_PRESENCE_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, teamPresenceTopSpacingAtPosition(childLayoutPosition), 0, this.spacing);
            } else if (Part.COMPOSER_SUGGESTIONS_STYLE.equals(part.getMessageStyle())) {
                rect.set(0, composerSuggestionsTopSpacingAtPosition(childLayoutPosition), 0, this.spacing);
            } else {
                rect.set(0, topSpacingAtPosition(childLayoutPosition), 0, this.spacing);
            }
        }
    }

    private boolean isSingleBlockPartWithShadow(Part part) {
        return part.isSingleBlockPartOfType(BlockType.MESSENGERCARD) || part.isSingleBlockPartOfType(BlockType.CREATETICKETCARD);
    }

    private boolean nextPartIsSingleBlockPartWithShadow(int i) {
        int i2 = i + 1;
        if (i2 < this.parts.size()) {
            return isSingleBlockPartWithShadow(this.parts.get(i2));
        }
        return false;
    }

    private int topSpacingAtPosition(int i) {
        if (i == 0) {
            return this.topSpacing;
        }
        return 0;
    }

    private int teamPresenceTopSpacingAtPosition(int i) {
        return i == 0 ? this.teamPresenceSpacing : this.teamPresenceSpacing - this.spacing;
    }

    private int shadowTopSpacingAtPosition(int i) {
        if (i == 0) {
            return this.shadowSpacing;
        }
        return 0;
    }

    private int bigTicketTopSpacingAtPosition(int i) {
        if (i == 0) {
            return this.bigTicketSpacing;
        }
        return 0;
    }

    private int composerSuggestionsTopSpacingAtPosition(int i) {
        return i == 0 ? this.composerSuggestionsSpacing : this.composerSuggestionsSpacing - this.spacing;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldConcatenate(Part part, int i) {
        int i2 = i + 1;
        if (i2 < this.parts.size()) {
            return Part.shouldConcatenate(part, this.parts.get(i2));
        }
        return false;
    }

    private boolean nextPartIsDivider(int i) {
        int i2 = i + 1;
        return i2 < this.parts.size() && Part.DAY_DIVIDER_STYLE.equals(this.parts.get(i2).getMessageStyle());
    }
}
