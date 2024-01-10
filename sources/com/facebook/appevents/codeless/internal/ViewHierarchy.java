package com.facebook.appevents.codeless.internal;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>((Object) null);
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static Method methodFindTouchTargetView = null;

    public static ViewGroup getParentOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || view == null) {
            return null;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                return (ViewGroup) parent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static List<View> getChildrenOfView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayList.add(viewGroup.getChildAt(i));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                String textOfView = getTextOfView(view);
                String hintOfView = getHintOfView(view);
                Object tag = view.getTag();
                CharSequence contentDescription = view.getContentDescription();
                jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
                jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
                jSONObject.put("id", view.getId());
                if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                    jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
                } else {
                    jSONObject.put("text", "");
                    jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
                }
                jSONObject.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
                if (tag != null) {
                    jSONObject.put(ViewHierarchyConstants.TAG_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
                }
                if (contentDescription != null) {
                    jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
                }
                jSONObject.put("dimension", getDimensionOfView(view));
            } catch (JSONException e) {
                Utility.logd(TAG, (Exception) e);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r2 = (android.widget.TextView) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void updateAppearanceOfView(android.view.View r7, org.json.JSONObject r8, float r9) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0086 }
            r1.<init>()     // Catch:{ JSONException -> 0x0086 }
            boolean r2 = r7 instanceof android.widget.TextView     // Catch:{ JSONException -> 0x0086 }
            if (r2 == 0) goto L_0x003c
            r2 = r7
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ JSONException -> 0x0086 }
            android.graphics.Typeface r3 = r2.getTypeface()     // Catch:{ JSONException -> 0x0086 }
            if (r3 == 0) goto L_0x003c
            java.lang.String r4 = "font_size"
            float r2 = r2.getTextSize()     // Catch:{ JSONException -> 0x0086 }
            double r5 = (double) r2     // Catch:{ JSONException -> 0x0086 }
            r1.put(r4, r5)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r2 = "is_bold"
            boolean r4 = r3.isBold()     // Catch:{ JSONException -> 0x0086 }
            r1.put(r2, r4)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r2 = "is_italic"
            boolean r3 = r3.isItalic()     // Catch:{ JSONException -> 0x0086 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r2 = "text_style"
            r8.put(r2, r1)     // Catch:{ JSONException -> 0x0086 }
        L_0x003c:
            boolean r1 = r7 instanceof android.widget.ImageView     // Catch:{ JSONException -> 0x0086 }
            if (r1 == 0) goto L_0x008c
            r1 = r7
            android.widget.ImageView r1 = (android.widget.ImageView) r1     // Catch:{ JSONException -> 0x0086 }
            android.graphics.drawable.Drawable r1 = r1.getDrawable()     // Catch:{ JSONException -> 0x0086 }
            boolean r2 = r1 instanceof android.graphics.drawable.BitmapDrawable     // Catch:{ JSONException -> 0x0086 }
            if (r2 == 0) goto L_0x008c
            int r2 = r7.getHeight()     // Catch:{ JSONException -> 0x0086 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x0086 }
            float r2 = r2 / r9
            r3 = 1110441984(0x42300000, float:44.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x008c
            int r7 = r7.getWidth()     // Catch:{ JSONException -> 0x0086 }
            float r7 = (float) r7     // Catch:{ JSONException -> 0x0086 }
            float r7 = r7 / r9
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L_0x008c
            android.graphics.drawable.BitmapDrawable r1 = (android.graphics.drawable.BitmapDrawable) r1     // Catch:{ JSONException -> 0x0086 }
            android.graphics.Bitmap r7 = r1.getBitmap()     // Catch:{ JSONException -> 0x0086 }
            if (r7 == 0) goto L_0x008c
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ JSONException -> 0x0086 }
            r9.<init>()     // Catch:{ JSONException -> 0x0086 }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ JSONException -> 0x0086 }
            r2 = 100
            r7.compress(r1, r2, r9)     // Catch:{ JSONException -> 0x0086 }
            byte[] r7 = r9.toByteArray()     // Catch:{ JSONException -> 0x0086 }
            r9 = 0
            java.lang.String r7 = android.util.Base64.encodeToString(r7, r9)     // Catch:{ JSONException -> 0x0086 }
            java.lang.String r9 = "icon_image"
            r8.put(r9, r7)     // Catch:{ JSONException -> 0x0086 }
            goto L_0x008c
        L_0x0084:
            r7 = move-exception
            goto L_0x008d
        L_0x0086:
            r7 = move-exception
            java.lang.String r8 = TAG     // Catch:{ all -> 0x0084 }
            com.facebook.internal.Utility.logd((java.lang.String) r8, (java.lang.Exception) r7)     // Catch:{ all -> 0x0084 }
        L_0x008c:
            return
        L_0x008d:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.updateAppearanceOfView(android.view.View, org.json.JSONObject, float):void");
    }

    public static JSONObject getDictionaryOfView(View view) {
        JSONObject jSONObject;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
                RCTRootViewReference = new WeakReference<>(view);
            }
            jSONObject = new JSONObject();
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            for (int i = 0; i < childrenOfView.size(); i++) {
                jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for view.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return jSONObject;
    }

    public static int getClassTypeBitmask(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            int i = view instanceof ImageView ? 2 : 0;
            if (view.isClickable()) {
                i |= 32;
            }
            if (isAdapterViewItem(view)) {
                i |= 512;
            }
            if (view instanceof TextView) {
                int i2 = i | 1024 | 1;
                if (view instanceof Button) {
                    i2 |= 4;
                    if (view instanceof Switch) {
                        i2 |= 8192;
                    } else if (view instanceof CheckBox) {
                        i2 |= 32768;
                    }
                }
                if (view instanceof EditText) {
                    return i2 | 2048;
                }
                return i2;
            }
            if (!(view instanceof Spinner)) {
                if (!(view instanceof DatePicker)) {
                    if (view instanceof RatingBar) {
                        return i | 65536;
                    }
                    if (view instanceof RadioGroup) {
                        return i | 16384;
                    }
                    return (!(view instanceof ViewGroup) || !isRCTButton(view, (View) RCTRootViewReference.get())) ? i : i | 64;
                }
            }
            return i | 4096;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof AdapterView) {
                return true;
            }
            Class<?> existingClass = getExistingClass("android.support.v4.view.NestedScrollingChild");
            if (existingClass != null && existingClass.isInstance(parent)) {
                return true;
            }
            Class<?> existingClass2 = getExistingClass("androidx.core.view.NestedScrollingChild");
            if (existingClass2 == null || !existingClass2.isInstance(parent)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da A[Catch:{ all -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd A[Catch:{ all -> 0x00e2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getTextOfView(android.view.View r9) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = r9 instanceof android.widget.TextView     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x0029
            r1 = r9
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ all -> 0x00e2 }
            java.lang.CharSequence r1 = r1.getText()     // Catch:{ all -> 0x00e2 }
            boolean r3 = r9 instanceof android.widget.Switch     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00d8
            android.widget.Switch r9 = (android.widget.Switch) r9     // Catch:{ all -> 0x00e2 }
            boolean r9 = r9.isChecked()     // Catch:{ all -> 0x00e2 }
            if (r9 == 0) goto L_0x0024
            java.lang.String r9 = "1"
            goto L_0x0026
        L_0x0024:
            java.lang.String r9 = "0"
        L_0x0026:
            r1 = r9
            goto L_0x00d8
        L_0x0029:
            boolean r1 = r9 instanceof android.widget.Spinner     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x0043
            r1 = r9
            android.widget.Spinner r1 = (android.widget.Spinner) r1     // Catch:{ all -> 0x00e2 }
            int r1 = r1.getCount()     // Catch:{ all -> 0x00e2 }
            if (r1 <= 0) goto L_0x00d7
            android.widget.Spinner r9 = (android.widget.Spinner) r9     // Catch:{ all -> 0x00e2 }
            java.lang.Object r9 = r9.getSelectedItem()     // Catch:{ all -> 0x00e2 }
            if (r9 == 0) goto L_0x00d7
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00e2 }
            goto L_0x0026
        L_0x0043:
            boolean r1 = r9 instanceof android.widget.DatePicker     // Catch:{ all -> 0x00e2 }
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0074
            android.widget.DatePicker r9 = (android.widget.DatePicker) r9     // Catch:{ all -> 0x00e2 }
            int r1 = r9.getYear()     // Catch:{ all -> 0x00e2 }
            int r6 = r9.getMonth()     // Catch:{ all -> 0x00e2 }
            int r9 = r9.getDayOfMonth()     // Catch:{ all -> 0x00e2 }
            java.lang.String r7 = "%04d-%02d-%02d"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00e2 }
            r8[r5] = r1     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00e2 }
            r8[r4] = r1     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00e2 }
            r8[r3] = r9     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d8
        L_0x0074:
            boolean r1 = r9 instanceof android.widget.TimePicker     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x009f
            android.widget.TimePicker r9 = (android.widget.TimePicker) r9     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r1 = r9.getCurrentHour()     // Catch:{ all -> 0x00e2 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = r9.getCurrentMinute()     // Catch:{ all -> 0x00e2 }
            int r9 = r9.intValue()     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = "%02d:%02d"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x00e2 }
            r3[r5] = r1     // Catch:{ all -> 0x00e2 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00e2 }
            r3[r4] = r9     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = java.lang.String.format(r6, r3)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d8
        L_0x009f:
            boolean r1 = r9 instanceof android.widget.RadioGroup     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00c8
            android.widget.RadioGroup r9 = (android.widget.RadioGroup) r9     // Catch:{ all -> 0x00e2 }
            int r1 = r9.getCheckedRadioButtonId()     // Catch:{ all -> 0x00e2 }
            int r3 = r9.getChildCount()     // Catch:{ all -> 0x00e2 }
        L_0x00ad:
            if (r5 >= r3) goto L_0x00d7
            android.view.View r4 = r9.getChildAt(r5)     // Catch:{ all -> 0x00e2 }
            int r6 = r4.getId()     // Catch:{ all -> 0x00e2 }
            if (r6 != r1) goto L_0x00c5
            boolean r6 = r4 instanceof android.widget.RadioButton     // Catch:{ all -> 0x00e2 }
            if (r6 == 0) goto L_0x00c5
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4     // Catch:{ all -> 0x00e2 }
            java.lang.CharSequence r9 = r4.getText()     // Catch:{ all -> 0x00e2 }
            goto L_0x0026
        L_0x00c5:
            int r5 = r5 + 1
            goto L_0x00ad
        L_0x00c8:
            boolean r1 = r9 instanceof android.widget.RatingBar     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00d7
            android.widget.RatingBar r9 = (android.widget.RatingBar) r9     // Catch:{ all -> 0x00e2 }
            float r9 = r9.getRating()     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x00e2 }
            goto L_0x00d8
        L_0x00d7:
            r1 = r2
        L_0x00d8:
            if (r1 != 0) goto L_0x00dd
            java.lang.String r9 = ""
            goto L_0x00e1
        L_0x00dd:
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00e2 }
        L_0x00e1:
            return r9
        L_0x00e2:
            r9 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(android.view.View):java.lang.String");
    }

    public static String getHintOfView(View view) {
        CharSequence charSequence;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                charSequence = ((EditText) view).getHint();
            } else {
                charSequence = view instanceof TextView ? ((TextView) view).getHint() : null;
            }
            if (charSequence == null) {
                return "";
            }
            return charSequence.toString();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            jSONObject = new JSONObject();
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return jSONObject;
    }

    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setOnClickListener(android.view.View r5, android.view.View.OnClickListener r6) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r0 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r1 == 0) goto L_0x0009
            return
        L_0x0009:
            r1 = 0
            java.lang.String r2 = "android.view.View"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0025 }
            java.lang.String r3 = "mListenerInfo"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0025 }
            java.lang.String r3 = "android.view.View$ListenerInfo"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0026 }
            java.lang.String r4 = "mOnClickListener"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0026 }
            goto L_0x0027
        L_0x0023:
            r5 = move-exception
            goto L_0x004a
        L_0x0025:
            r2 = r1
        L_0x0026:
            r3 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x0046
            if (r3 != 0) goto L_0x002c
            goto L_0x0046
        L_0x002c:
            r4 = 1
            r2.setAccessible(r4)     // Catch:{ Exception -> 0x004d, all -> 0x0023 }
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x004d, all -> 0x0023 }
            r2.setAccessible(r4)     // Catch:{ IllegalAccessException -> 0x003b }
            java.lang.Object r1 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x003b }
            goto L_0x003c
        L_0x003b:
        L_0x003c:
            if (r1 != 0) goto L_0x0042
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004d, all -> 0x0023 }
            return
        L_0x0042:
            r3.set(r1, r6)     // Catch:{ Exception -> 0x004d, all -> 0x0023 }
            goto L_0x004d
        L_0x0046:
            r5.setOnClickListener(r6)     // Catch:{ Exception -> 0x004d, all -> 0x0023 }
            return
        L_0x004a:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r0)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Field declaredField2 = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnTouchListener) declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            Utility.logd(TAG, (Exception) e);
        } catch (ClassNotFoundException e2) {
            Utility.logd(TAG, (Exception) e2);
        } catch (IllegalAccessException e3) {
            Utility.logd(TAG, (Exception) e3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return null;
    }

    public static View getTouchReactView(float[] fArr, View view) {
        View view2;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            initTouchTargetHelperMethods();
            if (!(methodFindTouchTargetView == null || view == null)) {
                View view3 = (View) methodFindTouchTargetView.invoke((Object) null, new Object[]{fArr, view});
                if (view3 == null || view3.getId() <= 0 || (view2 = (View) view3.getParent()) == null) {
                    return null;
                }
                return view2;
            }
        } catch (IllegalAccessException e) {
            Utility.logd(TAG, (Exception) e);
        } catch (InvocationTargetException e2) {
            Utility.logd(TAG, (Exception) e2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
        return null;
    }

    public static boolean isRCTButton(View view, View view2) {
        View touchReactView;
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (!view.getClass().getName().equals(CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static boolean isRCTRootView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static boolean isRCTTextView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static boolean isRCTViewGroup(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static View findRCTRootView(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        while (view != null) {
            try {
                if (!isRCTRootView(view)) {
                    ViewParent parent = view.getParent();
                    if (!(parent instanceof View)) {
                        break;
                    }
                    view = (View) parent;
                } else {
                    return view;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new float[]{(float) iArr[0], (float) iArr[1]};
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static void initTouchTargetHelperMethods() {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (methodFindTouchTargetView == null) {
                    Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                    methodFindTouchTargetView = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
            } catch (ClassNotFoundException e) {
                Utility.logd(TAG, (Exception) e);
            } catch (NoSuchMethodException e2) {
                Utility.logd(TAG, (Exception) e2);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static Class<?> getExistingClass(String str) {
        Class<ViewHierarchy> cls = ViewHierarchy.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
