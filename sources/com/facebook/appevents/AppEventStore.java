package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    AppEventStore() {
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    saveEventsToDisk(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        Class<AppEventStore> cls = AppEventStore.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                        readAndClearStore.addEvents(next, appEventCollection.get(next).getEventsToPersist());
                    }
                    saveEventsToDisk(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0091 A[Catch:{ Exception -> 0x0036, all -> 0x0098 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)     // Catch:{ all -> 0x009e }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)
            return r2
        L_0x000c:
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x0098 }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x007a, Exception -> 0x0044, all -> 0x0041 }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x007a, Exception -> 0x0044, all -> 0x0041 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x007a, Exception -> 0x0044, all -> 0x0041 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x007a, Exception -> 0x0044, all -> 0x0041 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x007a, Exception -> 0x0044, all -> 0x0041 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x007b, Exception -> 0x003f }
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x007b, Exception -> 0x003f }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0036 }
            r1.delete()     // Catch:{ Exception -> 0x0036 }
            goto L_0x008f
        L_0x0036:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x0098 }
            goto L_0x008f
        L_0x003f:
            r3 = move-exception
            goto L_0x0046
        L_0x0041:
            r3 = move-exception
            r4 = r2
            goto L_0x0064
        L_0x0044:
            r3 = move-exception
            r4 = r2
        L_0x0046:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x0063 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x005a }
            r1.delete()     // Catch:{ Exception -> 0x005a }
            goto L_0x008e
        L_0x005a:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L_0x005f:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x0098 }
            goto L_0x008e
        L_0x0063:
            r3 = move-exception
        L_0x0064:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0071 }
            r1.delete()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0079
        L_0x0071:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x0098 }
        L_0x0079:
            throw r3     // Catch:{ all -> 0x0098 }
        L_0x007a:
            r4 = r2
        L_0x007b:
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0098 }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0088 }
            r1.delete()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008e
        L_0x0088:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0098 }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L_0x005f
        L_0x008e:
            r3 = r2
        L_0x008f:
            if (r3 != 0) goto L_0x0096
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x0098 }
            r3.<init>()     // Catch:{ all -> 0x0098 }
        L_0x0096:
            monitor-exit(r0)
            return r3
        L_0x0098:
            r1 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r0)     // Catch:{ all -> 0x009e }
            monitor-exit(r0)
            return r2
        L_0x009e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0038 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static void saveEventsToDisk(com.facebook.appevents.PersistedEvents r7) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            r2 = 0
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0041 }
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0029 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0029 }
            r6 = 0
            java.io.FileOutputStream r6 = r3.openFileOutput(r0, r6)     // Catch:{ all -> 0x0029 }
            r5.<init>(r6)     // Catch:{ all -> 0x0029 }
            r4.<init>(r5)     // Catch:{ all -> 0x0029 }
            r4.writeObject(r7)     // Catch:{ all -> 0x0026 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0041 }
            goto L_0x003b
        L_0x0026:
            r7 = move-exception
            r2 = r4
            goto L_0x002a
        L_0x0029:
            r7 = move-exception
        L_0x002a:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "Got unexpected exception while persisting events: "
            android.util.Log.w(r4, r5, r7)     // Catch:{ all -> 0x003c }
            java.io.File r7 = r3.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0038 }
            r7.delete()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x0041 }
        L_0x003b:
            return
        L_0x003c:
            r7 = move-exception
            com.facebook.internal.Utility.closeQuietly(r2)     // Catch:{ all -> 0x0041 }
            throw r7     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk(com.facebook.appevents.PersistedEvents):void");
    }

    private static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME) ? ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class) : readClassDescriptor;
        }
    }
}
