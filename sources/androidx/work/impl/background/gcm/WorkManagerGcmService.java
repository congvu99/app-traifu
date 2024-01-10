package androidx.work.impl.background.gcm;

import androidx.work.Logger;
import androidx.work.impl.utils.WorkTimer;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

public class WorkManagerGcmService extends GcmTaskService {
    private static final String TAG = "WorkManagerGcmService";
    private WorkManagerGcmDispatcher mGcmDispatcher;
    private boolean mIsShutdown;

    public void onCreate() {
        super.onCreate();
        initializeDispatcher();
    }

    public void onInitializeTasks() {
        checkDispatcher();
        this.mGcmDispatcher.onInitializeTasks();
    }

    public int onRunTask(TaskParams taskParams) {
        checkDispatcher();
        return this.mGcmDispatcher.onRunTask(taskParams);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mGcmDispatcher.onDestroy();
    }

    private void checkDispatcher() {
        if (this.mIsShutdown) {
            Logger.get().debug(TAG, "Re-initializing dispatcher after a request to shutdown", new Throwable[0]);
            initializeDispatcher();
        }
    }

    private void initializeDispatcher() {
        this.mIsShutdown = false;
        this.mGcmDispatcher = new WorkManagerGcmDispatcher(getApplicationContext(), new WorkTimer());
    }
}
