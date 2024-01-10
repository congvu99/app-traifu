package androidx.work.impl.background.gcm;

import androidx.work.Constraints;
import androidx.work.impl.model.WorkSpec;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.Task;
import java.util.concurrent.TimeUnit;

public class GcmTaskConverter {
    public static final long EXECUTION_WINDOW_SIZE_IN_SECONDS = 5;

    /* access modifiers changed from: package-private */
    public OneoffTask convert(WorkSpec workSpec) {
        OneoffTask.Builder builder = new OneoffTask.Builder();
        builder.setService((Class<? extends GcmTaskService>) WorkManagerGcmService.class).setTag(workSpec.id).setUpdateCurrent(true).setPersisted(false);
        long max = Math.max(TimeUnit.SECONDS.convert(workSpec.calculateNextRunTime(), TimeUnit.MILLISECONDS) - TimeUnit.SECONDS.convert(now(), TimeUnit.MILLISECONDS), 0);
        builder.setExecutionWindow(max, 5 + max);
        applyConstraints(builder, workSpec);
        return builder.build();
    }

    public long now() {
        return System.currentTimeMillis();
    }

    private static Task.Builder applyConstraints(Task.Builder builder, WorkSpec workSpec) {
        builder.setRequiresCharging(false);
        builder.setRequiredNetwork(2);
        if (workSpec.hasConstraints()) {
            Constraints constraints = workSpec.constraints;
            int i = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[constraints.getRequiredNetworkType().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                builder.setRequiredNetwork(0);
            } else if (i == 4) {
                builder.setRequiredNetwork(1);
            } else if (i == 5) {
                builder.setRequiredNetwork(2);
            }
            if (constraints.requiresCharging()) {
                builder.setRequiresCharging(true);
            } else {
                builder.setRequiresCharging(false);
            }
        }
        return builder;
    }

    /* renamed from: androidx.work.impl.background.gcm.GcmTaskConverter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$work$NetworkType = r0
                androidx.work.NetworkType r1 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$work$NetworkType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.work.NetworkType r1 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.gcm.GcmTaskConverter.AnonymousClass1.<clinit>():void");
        }
    }
}
