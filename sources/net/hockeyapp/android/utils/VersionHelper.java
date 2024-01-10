package net.hockeyapp.android.utils;

import com.facebook.internal.ServerProtocol;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import net.hockeyapp.android.UpdateInfoListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VersionHelper {
    UpdateInfoListener listener;
    JSONObject newest;
    ArrayList<JSONObject> sortedVersions;

    private Object getSeparator() {
        return "<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />";
    }

    public VersionHelper(String str, UpdateInfoListener updateInfoListener) {
        this.listener = updateInfoListener;
        loadVersions(str);
        sortVersions();
    }

    private void loadVersions(String str) {
        this.newest = new JSONObject();
        this.sortedVersions = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int currentVersionCode = this.listener.getCurrentVersionCode();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION) > currentVersionCode) {
                    this.newest = jSONObject;
                    currentVersionCode = jSONObject.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                }
                this.sortedVersions.add(jSONObject);
            }
        } catch (NullPointerException | JSONException unused) {
        }
    }

    private void sortVersions() {
        Collections.sort(this.sortedVersions, new Comparator<JSONObject>() {
            public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                try {
                    if (jSONObject.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION) > jSONObject2.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                    }
                } catch (NullPointerException | JSONException unused) {
                }
                return 0;
            }
        });
    }

    public String getVersionString() {
        return failSafeGetStringFromJSON(this.newest, "shortversion", "") + " (" + failSafeGetStringFromJSON(this.newest, ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "") + ")";
    }

    public String getFileInfoString() {
        int failSafeGetIntFromJSON = failSafeGetIntFromJSON(this.newest, "appsize", 0);
        Date date = new Date(((long) failSafeGetIntFromJSON(this.newest, "timestamp", 0)) * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(date) + " - " + String.format("%.2f", new Object[]{Float.valueOf((((float) failSafeGetIntFromJSON) / 1024.0f) / 1024.0f)}) + " MB";
    }

    private static String failSafeGetStringFromJSON(JSONObject jSONObject, String str, String str2) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return str2;
        }
    }

    private static int failSafeGetIntFromJSON(JSONObject jSONObject, String str, int i) {
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return i;
        }
    }

    public String getReleaseNotes(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<body style='padding: 0px 0px 20px 0px'>");
        Iterator<JSONObject> it = this.sortedVersions.iterator();
        int i = 0;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (i > 0) {
                sb.append(getSeparator());
                if (z) {
                    sb.append(getRestoreButton(i, next));
                }
            }
            sb.append(getVersionLine(i, next));
            sb.append(getVersionNotes(i, next));
            i++;
        }
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    private String getRestoreButton(int i, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        String versionID = getVersionID(jSONObject);
        if (versionID.length() > 0) {
            sb.append("<a href='restore:" + versionID + "'  style='background: #c8c8c8; color: #000; display: block; float: right; padding: 7px; margin: 0px 10px 10px; text-decoration: none;'>Restore</a>");
        }
        return sb.toString();
    }

    private String getVersionID(JSONObject jSONObject) {
        try {
            return jSONObject.getString("id");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String getVersionLine(int i, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        int versionCode = getVersionCode(jSONObject);
        String versionName = getVersionName(jSONObject);
        sb.append("<div style='padding: 20px 10px 10px;'><strong>");
        if (i == 0) {
            sb.append("Newest version:");
        } else {
            int currentVersionCode = this.listener.getCurrentVersionCode();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Version ");
            sb2.append(versionName);
            sb2.append(" (");
            sb2.append(versionCode);
            sb2.append("): ");
            sb2.append(versionCode == currentVersionCode ? "[INSTALLED]" : "");
            sb.append(sb2.toString());
        }
        sb.append("</strong></div>");
        return sb.toString();
    }

    private int getVersionCode(JSONObject jSONObject) {
        try {
            return jSONObject.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        } catch (JSONException unused) {
            return 0;
        }
    }

    private String getVersionName(JSONObject jSONObject) {
        try {
            return jSONObject.getString("shortversion");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String getVersionNotes(int i, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        String failSafeGetStringFromJSON = failSafeGetStringFromJSON(jSONObject, "notes", "");
        sb.append("<div style='padding: 0px 10px;'>");
        if (failSafeGetStringFromJSON.trim().length() == 0) {
            sb.append("<em>No information.</em>");
        } else {
            sb.append(failSafeGetStringFromJSON);
        }
        sb.append("</div>");
        return sb.toString();
    }

    public static int compareVersionStrings(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                Scanner scanner = new Scanner(str.replaceAll("\\-.*", ""));
                Scanner scanner2 = new Scanner(str2.replaceAll("\\-.*", ""));
                scanner.useDelimiter("\\.");
                scanner2.useDelimiter("\\.");
                while (scanner.hasNextInt() && scanner2.hasNextInt()) {
                    int nextInt = scanner.nextInt();
                    int nextInt2 = scanner2.nextInt();
                    if (nextInt < nextInt2) {
                        return -1;
                    }
                    if (nextInt > nextInt2) {
                        return 1;
                    }
                }
                if (scanner.hasNextInt()) {
                    return 1;
                }
                if (scanner2.hasNextInt()) {
                    return -1;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
