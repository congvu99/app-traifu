package com.facebook.react.fabric.mounting;

import android.os.SystemClock;
import androidx.compose.animation.core.AnimationKt;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactIgnorableMountingException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MountItemDispatcher {
    private static final int FRAME_TIME_MS = 16;
    private static final int MAX_TIME_IN_FRAME_FOR_NON_BATCHED_OPERATIONS_MS = 8;
    private static final String TAG = "MountItemDispatcher";
    private long mBatchedExecutionTime = 0;
    private boolean mInDispatch = false;
    private final ItemDispatchListener mItemDispatchListener;
    private final ConcurrentLinkedQueue<MountItem> mMountItems = new ConcurrentLinkedQueue<>();
    private final MountingManager mMountingManager;
    private final ConcurrentLinkedQueue<PreAllocateViewMountItem> mPreMountItems = new ConcurrentLinkedQueue<>();
    private int mReDispatchCounter = 0;
    private long mRunStartTime = 0;
    private final ConcurrentLinkedQueue<DispatchCommandMountItem> mViewCommandMountItems = new ConcurrentLinkedQueue<>();

    public interface ItemDispatchListener {
        void didDispatchMountItems();
    }

    public MountItemDispatcher(MountingManager mountingManager, ItemDispatchListener itemDispatchListener) {
        this.mMountingManager = mountingManager;
        this.mItemDispatchListener = itemDispatchListener;
    }

    public void dispatchCommandMountItem(DispatchCommandMountItem dispatchCommandMountItem) {
        addViewCommandMountItem(dispatchCommandMountItem);
    }

    public void addMountItem(MountItem mountItem) {
        this.mMountItems.add(mountItem);
    }

    public void addPreAllocateMountItem(PreAllocateViewMountItem preAllocateViewMountItem) {
        if (!this.mMountingManager.surfaceIsStopped(preAllocateViewMountItem.getSurfaceId())) {
            this.mPreMountItems.add(preAllocateViewMountItem);
        }
    }

    public void addViewCommandMountItem(DispatchCommandMountItem dispatchCommandMountItem) {
        this.mViewCommandMountItems.add(dispatchCommandMountItem);
    }

    public boolean tryDispatchMountItems() {
        if (this.mInDispatch) {
            return false;
        }
        try {
            boolean dispatchMountItems = dispatchMountItems();
            this.mInDispatch = false;
            this.mItemDispatchListener.didDispatchMountItems();
            int i = this.mReDispatchCounter;
            if (i < 10 && dispatchMountItems) {
                if (i > 2) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Re-dispatched " + this.mReDispatchCounter + " times. This indicates setState (?) is likely being called too many times during mounting."));
                }
                this.mReDispatchCounter++;
                tryDispatchMountItems();
            }
            this.mReDispatchCounter = 0;
            return dispatchMountItems;
        } catch (Throwable th) {
            this.mInDispatch = false;
            throw th;
        }
    }

    public void dispatchMountItems(Queue<MountItem> queue) {
        while (!queue.isEmpty()) {
            MountItem poll = queue.poll();
            try {
                poll.execute(this.mMountingManager);
            } catch (RetryableMountingLayerException e) {
                if (poll instanceof DispatchCommandMountItem) {
                    DispatchCommandMountItem dispatchCommandMountItem = (DispatchCommandMountItem) poll;
                    if (dispatchCommandMountItem.getRetries() == 0) {
                        dispatchCommandMountItem.incrementRetries();
                        dispatchCommandMountItem(dispatchCommandMountItem);
                    }
                } else {
                    printMountItem(poll, "dispatchExternalMountItems: mounting failed with " + e.getMessage());
                }
            }
        }
    }

    private boolean dispatchMountItems() {
        if (this.mReDispatchCounter == 0) {
            this.mBatchedExecutionTime = 0;
        }
        this.mRunStartTime = SystemClock.uptimeMillis();
        List<DispatchCommandMountItem> andResetViewCommandMountItems = getAndResetViewCommandMountItems();
        List<MountItem> andResetMountItems = getAndResetMountItems();
        if (andResetMountItems == null && andResetViewCommandMountItems == null) {
            return false;
        }
        if (andResetViewCommandMountItems != null) {
            Systrace.beginSection(0, "FabricUIManager::mountViews viewCommandMountItems to execute: " + andResetViewCommandMountItems.size());
            for (DispatchCommandMountItem next : andResetViewCommandMountItems) {
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(next, "dispatchMountItems: Executing viewCommandMountItem");
                }
                try {
                    executeOrEnqueue(next);
                } catch (RetryableMountingLayerException e) {
                    if (next.getRetries() == 0) {
                        next.incrementRetries();
                        dispatchCommandMountItem(next);
                    } else {
                        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Caught exception executing ViewCommand: " + next.toString(), e));
                    }
                } catch (Throwable th) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("Caught exception executing ViewCommand: " + next.toString(), th));
                }
            }
            Systrace.endSection(0);
        }
        Collection<PreAllocateViewMountItem> andResetPreMountItems = getAndResetPreMountItems();
        if (andResetPreMountItems != null) {
            Systrace.beginSection(0, "FabricUIManager::mountViews preMountItems to execute: " + andResetPreMountItems.size());
            for (PreAllocateViewMountItem executeOrEnqueue : andResetPreMountItems) {
                executeOrEnqueue(executeOrEnqueue);
            }
            Systrace.endSection(0);
        }
        if (andResetMountItems != null) {
            Systrace.beginSection(0, "FabricUIManager::mountViews mountItems to execute: " + andResetMountItems.size());
            long uptimeMillis = SystemClock.uptimeMillis();
            for (MountItem next2 : andResetMountItems) {
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(next2, "dispatchMountItems: Executing mountItem");
                }
                try {
                    executeOrEnqueue(next2);
                } catch (Throwable th2) {
                    FLog.e(TAG, "dispatchMountItems: caught exception, displaying all MountItems", th2);
                    for (MountItem printMountItem : andResetMountItems) {
                        printMountItem(printMountItem, "dispatchMountItems: mountItem");
                    }
                    if (ReactIgnorableMountingException.isIgnorable(th2)) {
                        ReactSoftExceptionLogger.logSoftException(TAG, th2);
                    } else {
                        throw th2;
                    }
                }
            }
            this.mBatchedExecutionTime += SystemClock.uptimeMillis() - uptimeMillis;
        }
        Systrace.endSection(0);
        return true;
    }

    /* JADX INFO: finally extract failed */
    public void dispatchPreMountItems(long j) {
        Systrace.beginSection(0, "FabricUIManager::premountViews");
        this.mInDispatch = true;
        while (true) {
            try {
                if (haveExceededNonBatchedFrameTime(j)) {
                    break;
                }
                PreAllocateViewMountItem poll = this.mPreMountItems.poll();
                if (poll == null) {
                    break;
                }
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(poll, "dispatchPreMountItems: Dispatching PreAllocateViewMountItem");
                }
                executeOrEnqueue(poll);
            } catch (Throwable th) {
                this.mInDispatch = false;
                throw th;
            }
        }
        this.mInDispatch = false;
        Systrace.endSection(0);
    }

    private void executeOrEnqueue(MountItem mountItem) {
        if (this.mMountingManager.isWaitingForViewAttach(mountItem.getSurfaceId())) {
            if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                FLog.e(TAG, "executeOrEnqueue: Item execution delayed, surface %s is not ready yet", Integer.valueOf(mountItem.getSurfaceId()));
            }
            this.mMountingManager.getSurfaceManager(mountItem.getSurfaceId()).executeOnViewAttach(mountItem);
            return;
        }
        mountItem.execute(this.mMountingManager);
    }

    private static <E extends MountItem> List<E> drainConcurrentItemQueue(ConcurrentLinkedQueue<E> concurrentLinkedQueue) {
        ArrayList arrayList = new ArrayList();
        while (!concurrentLinkedQueue.isEmpty()) {
            MountItem mountItem = (MountItem) concurrentLinkedQueue.poll();
            if (mountItem != null) {
                arrayList.add(mountItem);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    private static boolean haveExceededNonBatchedFrameTime(long j) {
        return 16 - ((System.nanoTime() - j) / AnimationKt.MillisToNanos) < 8;
    }

    private List<DispatchCommandMountItem> getAndResetViewCommandMountItems() {
        return drainConcurrentItemQueue(this.mViewCommandMountItems);
    }

    private List<MountItem> getAndResetMountItems() {
        return drainConcurrentItemQueue(this.mMountItems);
    }

    private Collection<PreAllocateViewMountItem> getAndResetPreMountItems() {
        return drainConcurrentItemQueue(this.mPreMountItems);
    }

    public long getBatchedExecutionTime() {
        return this.mBatchedExecutionTime;
    }

    public long getRunStartTime() {
        return this.mRunStartTime;
    }

    private static void printMountItem(MountItem mountItem, String str) {
        for (String str2 : mountItem.toString().split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE)) {
            FLog.e(TAG, str + ": " + str2);
        }
    }
}
