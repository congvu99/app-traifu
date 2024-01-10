package net.hockeyapp.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.hockeyapp.android.utils.ConnectionManager;
import net.hockeyapp.android.utils.PrefsUtil;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class CrashManager {
    private static String identifier;
    private static String urlString;

    public static void register(Context context, String str) {
        register(context, Constants.BASE_URL, str, (CrashManagerListener) null);
    }

    public static void register(Context context, String str, CrashManagerListener crashManagerListener) {
        register(context, Constants.BASE_URL, str, crashManagerListener);
    }

    public static void register(Context context, String str, String str2, CrashManagerListener crashManagerListener) {
        initialize(context, str, str2, crashManagerListener, false);
        execute(context, crashManagerListener);
    }

    public static void initialize(Context context, String str, CrashManagerListener crashManagerListener) {
        initialize(context, Constants.BASE_URL, str, crashManagerListener, true);
    }

    public static void initialize(Context context, String str, String str2, CrashManagerListener crashManagerListener) {
        initialize(context, str, str2, crashManagerListener, true);
    }

    public static void execute(Context context, CrashManagerListener crashManagerListener) {
        Boolean valueOf = Boolean.valueOf(crashManagerListener != null && crashManagerListener.ignoreDefaultHandler());
        WeakReference weakReference = new WeakReference(context);
        int hasStackTraces = hasStackTraces(weakReference);
        if (hasStackTraces == 1) {
            Boolean bool = false;
            if (crashManagerListener != null) {
                bool = Boolean.valueOf(Boolean.valueOf(bool.booleanValue() | crashManagerListener.shouldAutoUploadCrashes()).booleanValue() | crashManagerListener.onCrashesFound());
                crashManagerListener.onNewCrashesFound();
            }
            if (!bool.booleanValue()) {
                showDialog(weakReference, crashManagerListener, valueOf.booleanValue());
            } else {
                sendCrashes(weakReference, crashManagerListener, valueOf.booleanValue());
            }
        } else if (hasStackTraces == 2) {
            if (crashManagerListener != null) {
                crashManagerListener.onConfirmedCrashesFound();
            }
            sendCrashes(weakReference, crashManagerListener, valueOf.booleanValue());
        } else {
            registerHandler(weakReference, crashManagerListener, valueOf.booleanValue());
        }
    }

    public static int hasStackTraces(WeakReference<Context> weakReference) {
        String[] searchForStackTraces = searchForStackTraces();
        if (searchForStackTraces == null || searchForStackTraces.length <= 0) {
            return 0;
        }
        List list = null;
        if (weakReference != null) {
            try {
                Context context = (Context) weakReference.get();
                if (context != null) {
                    list = Arrays.asList(context.getSharedPreferences(Constants.SDK_NAME, 0).getString("ConfirmedFilenames", "").split("\\|"));
                }
            } catch (Exception unused) {
            }
        }
        if (list == null) {
            return 1;
        }
        for (String contains : searchForStackTraces) {
            if (!list.contains(contains)) {
                return 1;
            }
        }
        return 2;
    }

    public static void submitStackTraces(WeakReference<Context> weakReference, CrashManagerListener crashManagerListener) {
        String[] searchForStackTraces = searchForStackTraces();
        Boolean bool = false;
        if (searchForStackTraces != null && searchForStackTraces.length > 0) {
            Log.d(Constants.TAG, "Found " + searchForStackTraces.length + " stacktrace(s).");
            for (int i = 0; i < searchForStackTraces.length; i++) {
                try {
                    String str = searchForStackTraces[i];
                    String contentsOfFile = contentsOfFile(weakReference, str);
                    if (contentsOfFile.length() > 0) {
                        Log.d(Constants.TAG, "Transmitting crash data: \n" + contentsOfFile);
                        HttpPost httpPost = new HttpPost(getURLString());
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new BasicNameValuePair("raw", contentsOfFile));
                        arrayList.add(new BasicNameValuePair(SDKConstants.PARAM_USER_ID, contentsOfFile(weakReference, str.replace(".stacktrace", ".user"))));
                        arrayList.add(new BasicNameValuePair("contact", contentsOfFile(weakReference, str.replace(".stacktrace", ".contact"))));
                        arrayList.add(new BasicNameValuePair("description", contentsOfFile(weakReference, str.replace(".stacktrace", ".description"))));
                        arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Constants.SDK_NAME));
                        arrayList.add(new BasicNameValuePair("sdk_version", Constants.SDK_VERSION));
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                        ConnectionManager.getInstance().getHttpClient().execute(httpPost);
                        bool = true;
                    }
                    if (bool.booleanValue()) {
                        deleteStackTrace(weakReference, searchForStackTraces[i]);
                        if (crashManagerListener == null) {
                        }
                        crashManagerListener.onCrashesSent();
                    } else {
                        if (crashManagerListener == null) {
                        }
                        crashManagerListener.onCrashesNotSent();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (bool.booleanValue()) {
                        deleteStackTrace(weakReference, searchForStackTraces[i]);
                        if (crashManagerListener == null) {
                        }
                    } else if (crashManagerListener == null) {
                    }
                } catch (Throwable th) {
                    if (bool.booleanValue()) {
                        deleteStackTrace(weakReference, searchForStackTraces[i]);
                        if (crashManagerListener != null) {
                            crashManagerListener.onCrashesSent();
                        }
                    } else if (crashManagerListener != null) {
                        crashManagerListener.onCrashesNotSent();
                    }
                    throw th;
                }
            }
        }
    }

    public static void deleteStackTraces(WeakReference<Context> weakReference) {
        String[] searchForStackTraces = searchForStackTraces();
        if (searchForStackTraces != null && searchForStackTraces.length > 0) {
            Log.d(Constants.TAG, "Found " + searchForStackTraces.length + " stacktrace(s).");
            for (int i = 0; i < searchForStackTraces.length; i++) {
                if (weakReference != null) {
                    try {
                        Log.d(Constants.TAG, "Delete stacktrace " + searchForStackTraces[i] + ".");
                        deleteStackTrace(weakReference, searchForStackTraces[i]);
                        Context context = (Context) weakReference.get();
                        if (context != null) {
                            context.deleteFile(searchForStackTraces[i]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void initialize(Context context, String str, String str2, CrashManagerListener crashManagerListener, boolean z) {
        if (context != null) {
            urlString = str;
            identifier = str2;
            Constants.loadFromContext(context);
            if (identifier == null) {
                identifier = Constants.APP_PACKAGE;
            }
            if (z) {
                registerHandler(new WeakReference(context), crashManagerListener, Boolean.valueOf(crashManagerListener != null && crashManagerListener.ignoreDefaultHandler()).booleanValue());
            }
        }
    }

    private static void showDialog(final WeakReference<Context> weakReference, final CrashManagerListener crashManagerListener, final boolean z) {
        Context context = weakReference != null ? (Context) weakReference.get() : null;
        if (context != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(Strings.get(crashManagerListener, 0));
            builder.setMessage(Strings.get(crashManagerListener, 1));
            builder.setNegativeButton(Strings.get(crashManagerListener, 2), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    CrashManagerListener crashManagerListener = crashManagerListener;
                    if (crashManagerListener != null) {
                        crashManagerListener.onUserDeniedCrashes();
                    }
                    CrashManager.deleteStackTraces(weakReference);
                    CrashManager.registerHandler(weakReference, crashManagerListener, z);
                }
            });
            builder.setPositiveButton(Strings.get(crashManagerListener, 3), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    CrashManager.sendCrashes(weakReference, crashManagerListener, z);
                }
            });
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public static void sendCrashes(final WeakReference<Context> weakReference, final CrashManagerListener crashManagerListener, final boolean z) {
        saveConfirmedStackTraces(weakReference);
        new Thread() {
            public void run() {
                CrashManager.submitStackTraces(weakReference, crashManagerListener);
                CrashManager.registerHandler(weakReference, crashManagerListener, z);
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public static void registerHandler(WeakReference<Context> weakReference, CrashManagerListener crashManagerListener, boolean z) {
        if (Constants.APP_VERSION == null || Constants.APP_PACKAGE == null) {
            Log.d(Constants.TAG, "Exception handler not set because version or package is null.");
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            Log.d(Constants.TAG, "Current handler class = " + defaultUncaughtExceptionHandler.getClass().getName());
        }
        if (defaultUncaughtExceptionHandler instanceof ExceptionHandler) {
            ((ExceptionHandler) defaultUncaughtExceptionHandler).setListener(crashManagerListener);
        } else {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(defaultUncaughtExceptionHandler, crashManagerListener, z));
        }
    }

    private static String getURLString() {
        return urlString + "api/2/apps/" + identifier + "/crashes/";
    }

    private static void deleteStackTrace(WeakReference<Context> weakReference, String str) {
        Context context;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            context.deleteFile(str);
            context.deleteFile(str.replace(".stacktrace", ".user"));
            context.deleteFile(str.replace(".stacktrace", ".contact"));
            context.deleteFile(str.replace(".stacktrace", ".description"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        if (r0 != null) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004b A[SYNTHETIC, Splitter:B:27:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String contentsOfFile(java.lang.ref.WeakReference<android.content.Context> r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            if (r4 == 0) goto L_0x0058
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            java.io.FileInputStream r4 = r4.openFileInput(r5)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x003f }
        L_0x001e:
            java.lang.String r4 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            if (r4 == 0) goto L_0x0031
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            java.lang.String r4 = "line.separator"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x003b, IOException -> 0x0038, all -> 0x0035 }
            goto L_0x001e
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0035:
            r4 = move-exception
            r0 = r2
            goto L_0x0049
        L_0x0038:
            r4 = move-exception
            r0 = r2
            goto L_0x0040
        L_0x003b:
            r0 = r2
            goto L_0x0050
        L_0x003d:
            r4 = move-exception
            goto L_0x0049
        L_0x003f:
            r4 = move-exception
        L_0x0040:
            r4.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0053
        L_0x0045:
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0053
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            throw r4
        L_0x004f:
        L_0x0050:
            if (r0 == 0) goto L_0x0053
            goto L_0x0045
        L_0x0053:
            java.lang.String r4 = r1.toString()
            return r4
        L_0x0058:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.CrashManager.contentsOfFile(java.lang.ref.WeakReference, java.lang.String):java.lang.String");
    }

    private static void saveConfirmedStackTraces(WeakReference<Context> weakReference) {
        Context context;
        if (weakReference != null && (context = (Context) weakReference.get()) != null) {
            try {
                String[] searchForStackTraces = searchForStackTraces();
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SDK_NAME, 0).edit();
                edit.putString("ConfirmedFilenames", joinArray(searchForStackTraces, "|"));
                PrefsUtil.applyChanges(edit);
            } catch (Exception unused) {
            }
        }
    }

    private static String joinArray(String[] strArr, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            stringBuffer.append(strArr[i]);
            if (i < strArr.length - 1) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    private static String[] searchForStackTraces() {
        if (Constants.FILES_PATH != null) {
            Log.d(Constants.TAG, "Looking for exceptions in: " + Constants.FILES_PATH);
            File file = new File(Constants.FILES_PATH + "/");
            if (file.mkdir() || file.exists()) {
                return file.list(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return str.endsWith(".stacktrace");
                    }
                });
            }
            return new String[0];
        }
        Log.d(Constants.TAG, "Can't search for exception as file path is null.");
        return null;
    }
}
