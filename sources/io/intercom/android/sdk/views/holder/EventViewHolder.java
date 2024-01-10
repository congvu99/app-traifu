package io.intercom.android.sdk.views.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.AvatarIcon;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.EventData;
import io.intercom.android.sdk.models.EventParticipant;
import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.utilities.ColorUtils;

public class EventViewHolder extends RecyclerView.ViewHolder implements ConversationPartViewHolder {
    private final AvatarIcon avatar;
    private final TextView eventTitle;

    public EventViewHolder(View view) {
        super(view);
        this.eventTitle = (TextView) view.findViewById(R.id.event_name);
        this.avatar = (AvatarIcon) view.findViewById(R.id.avatar);
    }

    public void bind(Part part, ViewGroup viewGroup) {
        EventData eventData = part.getEventData();
        EventParticipant participant = eventData.getParticipant();
        this.eventTitle.setText(eventData.getEventAsPlainText());
        this.avatar.setAvatar(Avatar.create(participant.getAvatar().getImageUrl(), participant.getInitial()));
        this.avatar.setAvatarBackgroundColor(Integer.valueOf(ColorUtils.parseColor("#FFF1F1F1")));
    }
}
