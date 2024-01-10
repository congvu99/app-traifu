package io.intercom.android.sdk.utilities;

import android.content.Context;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.models.Participant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000e"}, d2 = {"Lio/intercom/android/sdk/utilities/GroupConversationTextFormatter;", "", "()V", "groupConversationLabel", "", "context", "Landroid/content/Context;", "otherParticipants", "", "Lio/intercom/android/sdk/models/Participant;", "groupConversationTitle", "firstName", "", "", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GroupConversationTextFormatter.kt */
public final class GroupConversationTextFormatter {
    public static final GroupConversationTextFormatter INSTANCE = new GroupConversationTextFormatter();

    private GroupConversationTextFormatter() {
    }

    @JvmStatic
    public static final CharSequence groupConversationTitle(String str, int i, Context context) {
        Intrinsics.checkNotNullParameter(str, "firstName");
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == 1) {
            return str + context.getString(R.string.intercom_group_conversation_1_other_participant_count_short);
        } else if (i <= 1) {
            return str;
        } else {
            return str + Phrase.from(context, R.string.intercom_group_conversation_multiple_other_participant_count_short).put("other_participant_count", i).format();
        }
    }

    @JvmStatic
    public static final CharSequence groupConversationLabel(Context context, List<? extends Participant> list) {
        Phrase phrase;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "otherParticipants");
        int size = list.size();
        if (size == 1) {
            String name = ((Participant) CollectionsKt.first(list)).getName();
            Intrinsics.checkNotNullExpressionValue(name, "otherParticipants.first().name");
            if (!StringsKt.isBlank(name)) {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_name_also_participating).put("participant_name", (CharSequence) ((Participant) CollectionsKt.first(list)).getName());
            } else {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_one_person_also_participating);
            }
        } else if (size != 2) {
            String name2 = ((Participant) CollectionsKt.first(list)).getName();
            Intrinsics.checkNotNullExpressionValue(name2, "otherParticipants.first().name");
            if (!StringsKt.isBlank(name2)) {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_name_and_multiple_others_also_participating).put("participant_name", (CharSequence) ((Participant) CollectionsKt.first(list)).getName()).put("other_participant_count", size - 1);
            } else {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_multiple_person_also_participating).put("other_participant_count", size);
            }
        } else {
            String name3 = ((Participant) CollectionsKt.first(list)).getName();
            Intrinsics.checkNotNullExpressionValue(name3, "otherParticipants.first().name");
            if (!StringsKt.isBlank(name3)) {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_name_and_1_other_also_particiapting).put("participant_name", (CharSequence) ((Participant) CollectionsKt.first(list)).getName());
            } else {
                phrase = Phrase.from(context, R.string.intercom_group_conversation_multiple_person_also_participating).put("other_participant_count", size);
            }
        }
        CharSequence format = phrase.format();
        Intrinsics.checkNotNullExpressionValue(format, "when (otherParticipantsS…     }\n        }.format()");
        return format;
    }
}
