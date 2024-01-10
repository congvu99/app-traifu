package io.intercom.android.sdk.utilities;

import android.app.Activity;
import androidx.collection.ArraySet;
import java.util.Set;

public class ActivityFinisher {
    private final Set<Activity> activities = new ArraySet();

    public void register(Activity activity) {
        this.activities.add(activity);
    }

    public void unregister(Activity activity) {
        this.activities.remove(activity);
    }

    public void finishActivities() {
        for (Activity finish : this.activities) {
            finish.finish();
        }
        this.activities.clear();
    }
}
