package androidx.work.impl.background.gcm;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.WorkTimer;
import java.util.concurrent.CountDownLatch;

public class WorkManagerGcmDispatcher {
    private static final long AWAIT_TIME_IN_MILLISECONDS = 600000;
    private static final long AWAIT_TIME_IN_MINUTES = 10;
    static final String TAG = Logger.tagWithPrefix("WrkMgrGcmDispatcher");
    private final Context mContext;
    WorkManagerImpl mWorkManagerImpl;
    private final WorkTimer mWorkTimer;

    public WorkManagerGcmDispatcher(Context context, WorkTimer workTimer) {
        this.mContext = context.getApplicationContext();
        this.mWorkTimer = workTimer;
        this.mWorkManagerImpl = WorkManagerImpl.getInstance(context);
    }

    public void onInitializeTasks() {
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnBackgroundThread(new Runnable() {
            public void run() {
                Logger.get().debug(WorkManagerGcmDispatcher.TAG, "onInitializeTasks(): Rescheduling work", new Throwable[0]);
                WorkManagerGcmDispatcher.this.mWorkManagerImpl.rescheduleEligibleWork();
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:30|31|32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        androidx.work.Logger.get().debug(TAG, java.lang.String.format("Rescheduling WorkSpec %s", new java.lang.Object[]{r12}), new java.lang.Throwable[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x012e, code lost:
        return reschedule(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012f, code lost:
        r6.removeExecutionListener(r2);
        r11.mWorkTimer.stopTimer(r12);
        r7.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013a, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x010c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onRunTask(com.google.android.gms.gcm.TaskParams r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Rescheduling WorkSpec %s"
            androidx.work.Logger r1 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            r4[r5] = r12
            java.lang.String r6 = "Handling task %s"
            java.lang.String r4 = java.lang.String.format(r6, r4)
            java.lang.Throwable[] r6 = new java.lang.Throwable[r5]
            r1.debug(r2, r4, r6)
            java.lang.String r12 = r12.getTag()
            r1 = 2
            if (r12 == 0) goto L_0x013b
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto L_0x0028
            goto L_0x013b
        L_0x0028:
            androidx.work.impl.background.gcm.WorkManagerGcmDispatcher$WorkSpecExecutionListener r2 = new androidx.work.impl.background.gcm.WorkManagerGcmDispatcher$WorkSpecExecutionListener
            r2.<init>(r12)
            androidx.work.impl.background.gcm.WorkManagerGcmDispatcher$WorkSpecTimeLimitExceededListener r4 = new androidx.work.impl.background.gcm.WorkManagerGcmDispatcher$WorkSpecTimeLimitExceededListener
            androidx.work.impl.WorkManagerImpl r6 = r11.mWorkManagerImpl
            r4.<init>(r6)
            androidx.work.impl.WorkManagerImpl r6 = r11.mWorkManagerImpl
            androidx.work.impl.Processor r6 = r6.getProcessor()
            r6.addExecutionListener(r2)
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r7[r5] = r12
            java.lang.String r8 = "WorkGcm-onRunTask (%s)"
            java.lang.String r7 = java.lang.String.format(r8, r7)
            android.content.Context r8 = r11.mContext
            android.os.PowerManager$WakeLock r7 = androidx.work.impl.utils.WakeLocks.newWakeLock(r8, r7)
            androidx.work.impl.WorkManagerImpl r8 = r11.mWorkManagerImpl
            r8.startWork(r12)
            androidx.work.impl.utils.WorkTimer r8 = r11.mWorkTimer
            r9 = 600000(0x927c0, double:2.964394E-318)
            r8.startTimer(r12, r9, r4)
            r7.acquire()     // Catch:{ InterruptedException -> 0x010c }
            java.util.concurrent.CountDownLatch r4 = r2.getLatch()     // Catch:{ InterruptedException -> 0x010c }
            r8 = 10
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ InterruptedException -> 0x010c }
            r4.await(r8, r10)     // Catch:{ InterruptedException -> 0x010c }
            r6.removeExecutionListener(r2)
            androidx.work.impl.utils.WorkTimer r4 = r11.mWorkTimer
            r4.stopTimer(r12)
            r7.release()
            boolean r2 = r2.needsReschedule()
            if (r2 == 0) goto L_0x0091
            androidx.work.Logger r1 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r12
            java.lang.String r0 = java.lang.String.format(r0, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
            r1.debug(r2, r0, r3)
            int r12 = r11.reschedule(r12)
            return r12
        L_0x0091:
            androidx.work.impl.WorkManagerImpl r0 = r11.mWorkManagerImpl
            androidx.work.impl.WorkDatabase r0 = r0.getWorkDatabase()
            androidx.work.impl.model.WorkSpecDao r0 = r0.workSpecDao()
            androidx.work.impl.model.WorkSpec r0 = r0.getWorkSpec(r12)
            if (r0 == 0) goto L_0x00a4
            androidx.work.WorkInfo$State r0 = r0.state
            goto L_0x00a5
        L_0x00a4:
            r0 = 0
        L_0x00a5:
            if (r0 != 0) goto L_0x00bd
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r12
            java.lang.String r12 = "WorkSpec %s does not exist"
            java.lang.String r12 = java.lang.String.format(r12, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
            r0.debug(r2, r12, r3)
            return r1
        L_0x00bd:
            int[] r2 = androidx.work.impl.background.gcm.WorkManagerGcmDispatcher.AnonymousClass3.$SwitchMap$androidx$work$WorkInfo$State
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r3) goto L_0x00f4
            if (r0 == r1) goto L_0x00f4
            r2 = 3
            if (r0 == r2) goto L_0x00de
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Throwable[] r2 = new java.lang.Throwable[r5]
            java.lang.String r3 = "Rescheduling eligible work."
            r0.debug(r1, r3, r2)
            int r12 = r11.reschedule(r12)
            return r12
        L_0x00de:
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r2 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r12
            java.lang.String r12 = "Returning RESULT_FAILURE for WorkSpec %s"
            java.lang.String r12 = java.lang.String.format(r12, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r5]
            r0.debug(r2, r12, r3)
            return r1
        L_0x00f4:
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r12
            java.lang.String r12 = "Returning RESULT_SUCCESS for WorkSpec %s"
            java.lang.String r12 = java.lang.String.format(r12, r2)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r5]
            r0.debug(r1, r12, r2)
            return r5
        L_0x010a:
            r0 = move-exception
            goto L_0x012f
        L_0x010c:
            androidx.work.Logger r1 = androidx.work.Logger.get()     // Catch:{ all -> 0x010a }
            java.lang.String r4 = TAG     // Catch:{ all -> 0x010a }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x010a }
            r3[r5] = r12     // Catch:{ all -> 0x010a }
            java.lang.String r0 = java.lang.String.format(r0, r3)     // Catch:{ all -> 0x010a }
            java.lang.Throwable[] r3 = new java.lang.Throwable[r5]     // Catch:{ all -> 0x010a }
            r1.debug(r4, r0, r3)     // Catch:{ all -> 0x010a }
            int r0 = r11.reschedule(r12)     // Catch:{ all -> 0x010a }
            r6.removeExecutionListener(r2)
            androidx.work.impl.utils.WorkTimer r1 = r11.mWorkTimer
            r1.stopTimer(r12)
            r7.release()
            return r0
        L_0x012f:
            r6.removeExecutionListener(r2)
            androidx.work.impl.utils.WorkTimer r1 = r11.mWorkTimer
            r1.stopTimer(r12)
            r7.release()
            throw r0
        L_0x013b:
            androidx.work.Logger r12 = androidx.work.Logger.get()
            java.lang.String r0 = TAG
            java.lang.Throwable[] r2 = new java.lang.Throwable[r5]
            java.lang.String r3 = "Bad request. No workSpecId."
            r12.debug(r0, r3, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.gcm.WorkManagerGcmDispatcher.onRunTask(com.google.android.gms.gcm.TaskParams):int");
    }

    /* renamed from: androidx.work.impl.background.gcm.WorkManagerGcmDispatcher$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$WorkInfo$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$WorkInfo$State = r0
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$work$WorkInfo$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.gcm.WorkManagerGcmDispatcher.AnonymousClass3.<clinit>():void");
        }
    }

    public void onDestroy() {
        this.mWorkTimer.onDestroy();
    }

    private int reschedule(final String str) {
        final WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        workDatabase.runInTransaction((Runnable) new Runnable() {
            public void run() {
                workDatabase.workSpecDao().markWorkSpecScheduled(str, -1);
                Schedulers.schedule(WorkManagerGcmDispatcher.this.mWorkManagerImpl.getConfiguration(), WorkManagerGcmDispatcher.this.mWorkManagerImpl.getWorkDatabase(), WorkManagerGcmDispatcher.this.mWorkManagerImpl.getSchedulers());
            }
        });
        Logger.get().debug(TAG, String.format("Returning RESULT_SUCCESS for WorkSpec %s", new Object[]{str}), new Throwable[0]);
        return 0;
    }

    static class WorkSpecTimeLimitExceededListener implements WorkTimer.TimeLimitExceededListener {
        private static final String TAG = Logger.tagWithPrefix("WrkTimeLimitExceededLstnr");
        private final WorkManagerImpl mWorkManager;

        WorkSpecTimeLimitExceededListener(WorkManagerImpl workManagerImpl) {
            this.mWorkManager = workManagerImpl;
        }

        public void onTimeLimitExceeded(String str) {
            Logger.get().debug(TAG, String.format("WorkSpec time limit exceeded %s", new Object[]{str}), new Throwable[0]);
            this.mWorkManager.stopWork(str);
        }
    }

    static class WorkSpecExecutionListener implements ExecutionListener {
        private static final String TAG = Logger.tagWithPrefix("WorkSpecExecutionListener");
        private final CountDownLatch mLatch = new CountDownLatch(1);
        private boolean mNeedsReschedule = false;
        private final String mWorkSpecId;

        WorkSpecExecutionListener(String str) {
            this.mWorkSpecId = str;
        }

        /* access modifiers changed from: package-private */
        public boolean needsReschedule() {
            return this.mNeedsReschedule;
        }

        /* access modifiers changed from: package-private */
        public CountDownLatch getLatch() {
            return this.mLatch;
        }

        public void onExecuted(String str, boolean z) {
            if (!this.mWorkSpecId.equals(str)) {
                Logger.get().warning(TAG, String.format("Notified for %s, but was looking for %s", new Object[]{str, this.mWorkSpecId}), new Throwable[0]);
                return;
            }
            this.mNeedsReschedule = z;
            this.mLatch.countDown();
        }
    }
}
