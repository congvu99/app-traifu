package androidx.work.impl.background.gcm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;

public class GcmScheduler implements Scheduler {
    private static final String TAG = Logger.tagWithPrefix("GcmScheduler");
    private final GcmNetworkManager mNetworkManager;
    private final GcmTaskConverter mTaskConverter;

    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    public GcmScheduler(Context context) {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
            this.mNetworkManager = GcmNetworkManager.getInstance(context);
            this.mTaskConverter = new GcmTaskConverter();
            return;
        }
        throw new IllegalStateException("Google Play Services not available");
    }

    public void schedule(WorkSpec... workSpecArr) {
        for (WorkSpec workSpec : workSpecArr) {
            OneoffTask convert = this.mTaskConverter.convert(workSpec);
            Logger.get().debug(TAG, String.format("Scheduling %s with %s", new Object[]{workSpec, convert}), new Throwable[0]);
            this.mNetworkManager.schedule(convert);
        }
    }

    public void cancel(String str) {
        Logger.get().debug(TAG, String.format("Cancelling %s", new Object[]{str}), new Throwable[0]);
        this.mNetworkManager.cancelTask(str, WorkManagerGcmService.class);
    }
}
