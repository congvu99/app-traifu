package io.intercom.android.sdk.conversation;

import io.intercom.android.sdk.models.Part;
import io.intercom.android.sdk.models.Suggestion;

interface SuggestionsClickListener {
    void onSuggestionClicked(Part part, Suggestion suggestion);
}
