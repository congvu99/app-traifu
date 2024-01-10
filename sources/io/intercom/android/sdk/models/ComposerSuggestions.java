package io.intercom.android.sdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.intercom.commons.utilities.CollectionUtils;
import io.intercom.android.sdk.models.Prompt;
import io.intercom.android.sdk.models.Suggestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ComposerSuggestions implements Parcelable {
    public static final Parcelable.Creator<ComposerSuggestions> CREATOR = new Parcelable.Creator<ComposerSuggestions>() {
        public ComposerSuggestions createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, Suggestion.class.getClassLoader());
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            return ComposerSuggestions.create(readString, arrayList, z, false);
        }

        public ComposerSuggestions[] newArray(int i) {
            return new ComposerSuggestions[i];
        }
    };
    public static final ComposerSuggestions NULL = create("", Collections.emptyList(), false, false);
    public static final ComposerSuggestions UNKNOWN = create("unknown", Collections.emptyList(), true, true);

    public int describeContents() {
        return 0;
    }

    public abstract String getPrompt();

    public abstract List<Suggestion> getSuggestions();

    public abstract boolean isComposerDisabled();

    public abstract boolean isLoading();

    public static ComposerSuggestions create(String str, List<Suggestion> list, boolean z, boolean z2) {
        return new AutoValue_ComposerSuggestions(str, list, z, z2);
    }

    public static final class Builder {
        boolean composer_disabled;
        List<Prompt.Builder> prompt;
        List<Suggestion.Builder> suggestions;

        public Builder withPrompts(List<Prompt.Builder> list) {
            this.prompt = list;
            return this;
        }

        public Builder withSuggestions(List<Suggestion.Builder> list) {
            this.suggestions = list;
            return this;
        }

        public Builder withComposerDisabled(boolean z) {
            this.composer_disabled = z;
            return this;
        }

        public ComposerSuggestions build() {
            ArrayList arrayList = new ArrayList(CollectionUtils.capacityFor(this.prompt));
            ArrayList arrayList2 = new ArrayList(CollectionUtils.capacityFor(this.suggestions));
            List<Prompt.Builder> list = this.prompt;
            if (list != null) {
                for (Prompt.Builder next : list) {
                    if (next != null) {
                        arrayList.add(next.build());
                    }
                }
            }
            List<Suggestion.Builder> list2 = this.suggestions;
            if (list2 != null) {
                for (Suggestion.Builder next2 : list2) {
                    if (next2 != null) {
                        arrayList2.add(next2.build());
                    }
                }
            }
            return ComposerSuggestions.create(arrayList.isEmpty() ? "" : ((Prompt) arrayList.get(0)).getPromptText(), arrayList2, this.composer_disabled, false);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getPrompt());
        parcel.writeList(getSuggestions());
        parcel.writeInt(isComposerDisabled() ? 1 : 0);
    }
}
