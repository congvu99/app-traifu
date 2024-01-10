package com.facebook.internal.logging.dumpsys;

import android.content.res.Resources;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.logging.dumpsys.AndroidRootResolver;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.App;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class EndToEndDumpsysHelper {
    private static final String ALL_ROOTS_ARGUMENT = "all-roots";
    private static final String E2E_ARGUMENT = "e2e";
    private static final String LITHO_VIEW_CLASS = "com.facebook.litho.LithoView";
    private static final String LITHO_VIEW_TEST_HELPER_CLASS = "com.facebook.litho.LithoViewTestHelper";
    private static final String LITHO_VIEW_TO_STRING_METHOD = "viewToStringForE2E";
    private static final String RC_TEXT_VIEW_SIMPLE_CLASS_NAME = "RCTextView";
    private static final String TOP_ROOT_ARGUMENT = "top-root";
    private static final String WITH_PROPS_ARGUMENT = "props";
    private static final String WITH_WEBVIEW_ARGUMENT = "webview";
    private static EndToEndDumpsysHelper mInstance;
    private static Method sRcTextViewGetTextMethod;
    private Method mLithoViewToStringMethod;
    private final AndroidRootResolver mRootResolver = new AndroidRootResolver();
    private final WebViewDumpHelper mWebViewDumpHelper = new WebViewDumpHelper();

    public static boolean maybeDump(String str, PrintWriter printWriter, String[] strArr) {
        if (strArr == null || strArr.length <= 0 || !"e2e".equals(strArr[0])) {
            return false;
        }
        if (mInstance == null) {
            mInstance = new EndToEndDumpsysHelper();
        }
        mInstance.dumpViewHierarchy(str, printWriter, strArr);
        return true;
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, String[] strArr) {
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        String[] strArr2 = strArr;
        printWriter2.print(str2);
        printWriter2.println("Top Level Window View Hierarchy:");
        boolean hasArgument = hasArgument(strArr2, ALL_ROOTS_ARGUMENT);
        boolean hasArgument2 = hasArgument(strArr2, TOP_ROOT_ARGUMENT);
        boolean hasArgument3 = hasArgument(strArr2, WITH_WEBVIEW_ARGUMENT);
        boolean hasArgument4 = hasArgument(strArr2, WITH_PROPS_ARGUMENT);
        try {
            List<AndroidRootResolver.Root> listActiveRoots = this.mRootResolver.listActiveRoots();
            if (listActiveRoots == null) {
                return;
            }
            if (!listActiveRoots.isEmpty()) {
                Collections.reverse(listActiveRoots);
                WindowManager.LayoutParams layoutParams = null;
                Iterator<AndroidRootResolver.Root> it = listActiveRoots.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AndroidRootResolver.Root next = it.next();
                    if (next.getView().getVisibility() == 0) {
                        if (!hasArgument && layoutParams != null && Math.abs(next.getParam().type - layoutParams.type) != 1) {
                            break;
                        }
                        dumpViewHierarchy(str2 + "  ", printWriter, next.getView(), 0, 0, hasArgument3, hasArgument4);
                        layoutParams = next.getParam();
                        if (hasArgument2) {
                            break;
                        }
                    }
                }
                this.mWebViewDumpHelper.dump(printWriter2);
            }
        } catch (Exception e) {
            printWriter2.println("Failure in view hierarchy dump: " + e.getMessage());
        }
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view, int i, int i2, boolean z, boolean z2) {
        ViewGroup viewGroup;
        int childCount;
        String str2 = str;
        PrintWriter printWriter2 = printWriter;
        View view2 = view;
        boolean z3 = z2;
        printWriter2.print(str2);
        if (view2 == null) {
            printWriter2.println(JsonLexerKt.NULL);
            return;
        }
        printWriter2.print(view.getClass().getName());
        printWriter2.print("{");
        printWriter2.print(Integer.toHexString(view.hashCode()));
        writeViewFlags(printWriter, view);
        writeViewBounds(printWriter, view, i, i2);
        writeViewTestId(printWriter, view);
        writeViewText(printWriter, view);
        if (z3 && Build.VERSION.SDK_INT >= 21) {
            Api21Utils.writeExtraProps(printWriter, view);
        }
        printWriter2.println("}");
        if (isExtendsLithoView(view)) {
            writeLithoViewSubHierarchy(printWriter2, view2, str2, z3);
        }
        if (z && (view2 instanceof WebView)) {
            this.mWebViewDumpHelper.handle((WebView) view2);
        }
        if ((view2 instanceof ViewGroup) && (childCount = viewGroup.getChildCount()) > 0) {
            String str3 = str2 + "  ";
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            for (int i3 = 0; i3 < childCount; i3++) {
                dumpViewHierarchy(str3, printWriter, (viewGroup = (ViewGroup) view2).getChildAt(i3), iArr[0], iArr[1], z, z2);
            }
        }
    }

    private static boolean isExtendsLithoView(View view) {
        for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (cls.getName().equals(LITHO_VIEW_CLASS)) {
                return true;
            }
        }
        return false;
    }

    private void writeLithoViewSubHierarchy(PrintWriter printWriter, View view, String str, boolean z) {
        try {
            if (this.mLithoViewToStringMethod == null) {
                this.mLithoViewToStringMethod = Class.forName(LITHO_VIEW_TEST_HELPER_CLASS).getDeclaredMethod(LITHO_VIEW_TO_STRING_METHOD, new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            }
            printWriter.append((String) this.mLithoViewToStringMethod.invoke((Object) null, new Object[]{view, Integer.valueOf((str.length() / 2) + 1), Boolean.valueOf(z)}));
        } catch (Exception e) {
            printWriter.append(str).append("Failed litho view sub hierarch dump: ").append(fixString(e.getMessage(), 100)).println();
        }
    }

    private static void writeViewFlags(PrintWriter printWriter, View view) {
        printWriter.print(" ");
        int visibility = view.getVisibility();
        String str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        String str2 = ".";
        if (visibility == 0) {
            printWriter.print(str);
        } else if (visibility == 4) {
            printWriter.print("I");
        } else if (visibility != 8) {
            printWriter.print(str2);
        } else {
            printWriter.print("G");
        }
        String str3 = "F";
        printWriter.print(view.isFocusable() ? str3 : str2);
        printWriter.print(view.isEnabled() ? ExifInterface.LONGITUDE_EAST : str2);
        printWriter.print(str2);
        String str4 = "H";
        printWriter.print(view.isHorizontalScrollBarEnabled() ? str4 : str2);
        if (!view.isVerticalScrollBarEnabled()) {
            str = str2;
        }
        printWriter.print(str);
        printWriter.print(view.isClickable() ? "C" : str2);
        printWriter.print(view.isLongClickable() ? "L" : str2);
        printWriter.print(" ");
        if (!view.isFocused()) {
            str3 = str2;
        }
        printWriter.print(str3);
        printWriter.print(view.isSelected() ? ExifInterface.LATITUDE_SOUTH : str2);
        if (!view.isHovered()) {
            str4 = str2;
        }
        printWriter.print(str4);
        printWriter.print(view.isActivated() ? ExifInterface.GPS_MEASUREMENT_IN_PROGRESS : str2);
        if (view.isDirty()) {
            str2 = "D";
        }
        printWriter.print(str2);
    }

    private static void writeViewBounds(PrintWriter printWriter, View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        printWriter.print(" ");
        printWriter.print(iArr[0] - i);
        printWriter.print(",");
        printWriter.print(iArr[1] - i2);
        printWriter.print("-");
        printWriter.print((iArr[0] + view.getWidth()) - i);
        printWriter.print(",");
        printWriter.print((iArr[1] + view.getHeight()) - i2);
    }

    private static void writeViewTestId(PrintWriter printWriter, View view) {
        try {
            int id = view.getId();
            if (id == -1) {
                maybeWriteViewTestIdFromTag(printWriter, view);
                return;
            }
            printWriter.append(" #");
            printWriter.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (id > 0) {
                if (resources != null) {
                    int i = -16777216 & id;
                    String resourcePackageName = i != 16777216 ? i != 2130706432 ? resources.getResourcePackageName(id) : App.TYPE : Constants.PLATFORM;
                    printWriter.print(" ");
                    printWriter.print(resourcePackageName);
                    printWriter.print(CertificateUtil.DELIMITER);
                    printWriter.print(resources.getResourceTypeName(id));
                    printWriter.print("/");
                    printWriter.print(resources.getResourceEntryName(id));
                    return;
                }
            }
            maybeWriteViewTestIdFromTag(printWriter, view);
        } catch (Exception unused) {
            maybeWriteViewTestIdFromTag(printWriter, view);
        }
    }

    private static void maybeWriteViewTestIdFromTag(PrintWriter printWriter, View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            String str = (String) tag;
            if (str.length() > 0) {
                printWriter.print(" app:tag/");
                printWriter.print(fixString(str, 60));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        r4 = r4.getTag();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void writeViewText(java.io.PrintWriter r3, android.view.View r4) {
        /*
            r0 = 0
            boolean r1 = r4 instanceof android.widget.TextView     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x0010
            android.widget.TextView r4 = (android.widget.TextView) r4     // Catch:{ Exception -> 0x0064 }
            java.lang.CharSequence r4 = r4.getText()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0047
        L_0x0010:
            java.lang.Class r1 = r4.getClass()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r1 = r1.getSimpleName()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = "RCTextView"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x0025
            java.lang.String r4 = getTextFromRcTextView(r4)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0047
        L_0x0025:
            java.lang.CharSequence r1 = r4.getContentDescription()     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x002f
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0064 }
        L_0x002f:
            if (r0 == 0) goto L_0x0037
            boolean r1 = r0.isEmpty()     // Catch:{ Exception -> 0x0064 }
            if (r1 == 0) goto L_0x0046
        L_0x0037:
            java.lang.Object r4 = r4.getTag()     // Catch:{ Exception -> 0x0064 }
            if (r4 == 0) goto L_0x0046
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0047
        L_0x0046:
            r4 = r0
        L_0x0047:
            if (r4 == 0) goto L_0x0064
            boolean r0 = r4.isEmpty()     // Catch:{ Exception -> 0x0064 }
            if (r0 == 0) goto L_0x0050
            goto L_0x0064
        L_0x0050:
            java.lang.String r0 = " text=\""
            r3.print(r0)     // Catch:{ Exception -> 0x0064 }
            r0 = 600(0x258, float:8.41E-43)
            java.lang.String r4 = fixString(r4, r0)     // Catch:{ Exception -> 0x0064 }
            r3.print(r4)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r4 = "\""
            r3.print(r4)     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.logging.dumpsys.EndToEndDumpsysHelper.writeViewText(java.io.PrintWriter, android.view.View):void");
    }

    private static String getTextFromRcTextView(View view) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (sRcTextViewGetTextMethod == null) {
            sRcTextViewGetTextMethod = view.getClass().getDeclaredMethod("getText", new Class[0]);
        }
        Object invoke = sRcTextViewGetTextMethod.invoke(view, new Object[0]);
        if (invoke != null) {
            return invoke.toString();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static String fixString(CharSequence charSequence, int i) {
        if (charSequence == null || charSequence.length() < 1) {
            return "";
        }
        String replace = charSequence.toString().replace(" \n", " ").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, " ").replace("\"", "");
        if (charSequence.length() <= i) {
            return replace;
        }
        return replace.substring(0, i) + "...";
    }

    private static boolean hasArgument(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String equalsIgnoreCase : strArr) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static AccessibilityNodeInfo createNodeInfoFromView(View view) {
        if (view == null) {
            return null;
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        try {
            view.onInitializeAccessibilityNodeInfo(obtain);
            return obtain;
        } catch (NullPointerException unused) {
            if (obtain != null) {
                obtain.recycle();
            }
            return null;
        }
    }

    private static class Api21Utils {
        private static Field mKeyedTagsField;

        private Api21Utils() {
        }

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                mKeyedTagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
        }

        static void writeExtraProps(PrintWriter printWriter, View view) {
            AccessibilityNodeInfo access$000;
            if (Build.VERSION.SDK_INT >= 21 && (access$000 = EndToEndDumpsysHelper.createNodeInfoFromView(view)) != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        jSONObject.put("textColor", textView.getTextColors().getDefaultColor());
                        jSONObject.put("textSize", (double) textView.getTextSize());
                        jSONObject.put(ViewHierarchyConstants.HINT_KEY, EndToEndDumpsysHelper.fixString(textView.getHint(), 100));
                    }
                    JSONObject tags = getTags(view);
                    if (tags != null) {
                        jSONObject.put("keyedTags", tags);
                    }
                    JSONArray jSONArray = new JSONArray();
                    for (AccessibilityNodeInfo.AccessibilityAction label : access$000.getActionList()) {
                        String str = (String) label.getLabel();
                        if (str != null) {
                            jSONArray.put(EndToEndDumpsysHelper.fixString(str, 50));
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("actions", jSONArray);
                    }
                    String access$100 = EndToEndDumpsysHelper.fixString(access$000.getContentDescription(), 50);
                    if (access$100 != null && access$100.length() > 0) {
                        jSONObject.put("content-description", access$100);
                    }
                    jSONObject.put("accessibility-focused", access$000.isAccessibilityFocused()).put("checkable", access$000.isCheckable()).put("checked", access$000.isChecked()).put("class-name", EndToEndDumpsysHelper.fixString(access$000.getClassName(), 50)).put("clickable", access$000.isClickable()).put("content-invalid", access$000.isContentInvalid()).put("dismissable", access$000.isDismissable()).put("editable", access$000.isEditable()).put(ViewProps.ENABLED, access$000.isEnabled()).put("focusable", access$000.isFocusable()).put("focused", access$000.isFocused()).put("long-clickable", access$000.isLongClickable()).put("multiline", access$000.isMultiLine()).put("password", access$000.isPassword()).put("scrollable", access$000.isScrollable()).put("selected", access$000.isSelected()).put("visible-to-user", access$000.isVisibleToUser());
                    if (Build.VERSION.SDK_INT >= 24) {
                        Api24Utils.addExtraProps(jSONObject, access$000);
                    }
                } catch (Exception e) {
                    try {
                        jSONObject.put("DUMP-ERROR", EndToEndDumpsysHelper.fixString(e.getMessage(), 50));
                    } catch (JSONException unused) {
                    }
                }
                printWriter.append(" props=\"").append(jSONObject.toString()).append("\"");
            }
        }

        private static JSONObject getTags(View view) {
            try {
                if (mKeyedTagsField == null) {
                    Field declaredField = View.class.getDeclaredField("mKeyedTags");
                    mKeyedTagsField = declaredField;
                    declaredField.setAccessible(true);
                }
                SparseArray sparseArray = (SparseArray) mKeyedTagsField.get(view);
                if (sparseArray == null || sparseArray.size() <= 0) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    int size = sparseArray.size();
                    for (int i = 0; i < size; i++) {
                        try {
                            jSONObject.put(ResourcesUtil.getIdStringQuietly(view.getResources(), sparseArray.keyAt(i)), sparseArray.valueAt(i));
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                return jSONObject;
            } catch (Exception unused3) {
                return null;
            }
        }
    }

    private static class Api24Utils {
        private Api24Utils() {
        }

        static void addExtraProps(JSONObject jSONObject, AccessibilityNodeInfo accessibilityNodeInfo) throws JSONException {
            if (Build.VERSION.SDK_INT >= 24) {
                jSONObject.put("context-clickable", accessibilityNodeInfo.isContextClickable()).put("drawing-order", accessibilityNodeInfo.getDrawingOrder()).put("important-for-accessibility", accessibilityNodeInfo.isImportantForAccessibility());
            }
        }
    }
}
