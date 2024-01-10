package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.utilities.GroupConversationTextFormatter;
import io.intercom.android.sdk.utilities.TimeFormatter;

public class InboxRowLayout extends RelativeLayout {
    private final AuthorAvatarView authorAvatar;
    private final TextView authorName;
    private final ConstraintLayout inboxRowLayout;
    private final TextView summary;
    private final TextView timeStamp;
    private final ImageView unreadDot;

    public InboxRowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public InboxRowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), R.layout.intercom_row_inbox, this);
        this.authorAvatar = (AuthorAvatarView) findViewById(R.id.intercom_author_avatar);
        this.authorName = (TextView) findViewById(R.id.intercom_user_name);
        this.timeStamp = (TextView) findViewById(R.id.intercom_time_stamp);
        this.summary = (TextView) findViewById(R.id.intercom_message_summary);
        this.unreadDot = (ImageView) findViewById(R.id.intercom_unread_dot);
        this.inboxRowLayout = (ConstraintLayout) findViewById(R.id.intercom_inbox_row_layout);
    }

    public void updateVerticalPadding(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        ConstraintLayout constraintLayout = this.inboxRowLayout;
        constraintLayout.setPadding(constraintLayout.getPaddingLeft(), dimensionPixelSize, this.inboxRowLayout.getPaddingRight(), dimensionPixelSize);
    }

    public void updateConversation(Conversation conversation, UserIdentity userIdentity, AppConfig appConfig, TeamPresence teamPresence, TimeFormatter timeFormatter) {
        Part lastNonEventPart = conversation.getLastNonEventPart();
        Part lastPart = conversation.getLastPart();
        Context context = getContext();
        if (lastNonEventPart.getParticipant().isUserWithId(userIdentity.getIntercomId())) {
            TextView textView = this.summary;
            textView.setText(context.getString(R.string.intercom_you) + ": " + lastNonEventPart.getSummary());
        } else {
            this.summary.setText(lastNonEventPart.getSummary());
        }
        this.timeStamp.setText(timeFormatter.getFormattedTime(lastPart.getCreatedAt()));
        setRowParticipantDetails(conversation, appConfig.getName(), teamPresence, appConfig);
        if (!conversation.isRead()) {
            this.authorName.setTypeface(Typeface.SANS_SERIF, 1);
            this.summary.setTypeface(Typeface.SANS_SERIF, 1);
            this.authorName.setTextColor(ContextCompat.getColor(context, R.color.intercom_accessibility_black));
            this.unreadDot.setVisibility(8);
        } else {
            this.authorName.setTypeface(Typeface.SANS_SERIF, 0);
            this.summary.setTypeface(Typeface.SANS_SERIF, 0);
            this.authorName.setTextColor(ContextCompat.getColor(context, R.color.intercom_accessibility_grey));
            this.unreadDot.setVisibility(8);
        }
        this.authorAvatar.hideActiveStateIndicator(false);
    }

    private void setRowParticipantDetails(Conversation conversation, String str, TeamPresence teamPresence, AppConfig appConfig) {
        LastParticipatingAdmin lastParticipatingAdmin = conversation.getLastParticipatingAdmin();
        if (!TextUtils.isEmpty(lastParticipatingAdmin.getFirstName())) {
            this.authorAvatar.loadAvatarWithActiveState(lastParticipatingAdmin.getAvatar(), lastParticipatingAdmin.isActive(), appConfig);
            this.authorName.setText(GroupConversationTextFormatter.groupConversationTitle(lastParticipatingAdmin.getFirstName(), conversation.getGroupConversationParticipants().size(), this.authorName.getContext()));
        } else if (teamPresence.isEmpty()) {
            this.authorAvatar.loadAvatar(lastParticipatingAdmin.getAvatar(), appConfig);
            this.authorName.setText(str);
        } else {
            this.authorAvatar.loadAvatars(teamPresence.getActiveAdmins(), appConfig);
            this.authorName.setText(str);
        }
    }
}
