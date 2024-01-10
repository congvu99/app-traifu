package com.trainerfu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.trainerfu.android.BuildConfig;
import com.trainerfu.android.R;
import io.intercom.android.sdk.models.Part;
import io.sentry.Sentry;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import org.apache.http.Header;
import org.json.JSONObject;

public class Util {
    private static final String BLOCK_USER_IDS = "BLOCK_USER_IDS";
    private static final String FLAG_STORY_IDS = "FLAG_STORY_IDS";
    private static final String PROPERTY_IS_TRAINER = "is_trainer";
    private static final String STEP = "step";
    private static final AtomicInteger c = new AtomicInteger(0);

    public static int sizeInPx(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sizeInDpi(Context context, int i) {
        return (int) ((((float) i) - 0.5f) / context.getResources().getDisplayMetrics().density);
    }

    public static int screenWidthInDpi(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return sizeInDpi(context, point.x);
    }

    public static int getUniqueNotificationId() {
        return c.incrementAndGet() + 100;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static String getUrlForPhoto(int i) {
        return String.format("%1$s/users_photos/%2$s", new Object[]{BuildConfig.ROOT_URL, String.valueOf(i)});
    }

    public static Bitmap scaledBitmapToFitSize(Bitmap bitmap, int i, int i2) {
        return ThumbnailUtils.extractThumbnail(bitmap, i, i2);
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmapForProfile(String str) {
        return scaledBitmapToFitSize(getBitmap(str), 256, 256);
    }

    public static Bitmap getBitmap(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            Bitmap decodeFile = BitmapFactory.decodeFile(str, new BitmapFactory.Options());
            if (attributeInt == 3) {
                return rotateImage(decodeFile, 180.0f);
            }
            if (attributeInt == 6) {
                return rotateImage(decodeFile, 90.0f);
            }
            if (attributeInt != 8) {
                return decodeFile;
            }
            return rotateImage(decodeFile, 270.0f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Bitmap scaleBitmapForStory(String str) {
        Bitmap bitmap = getBitmap(str);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 800 && height <= 800) {
            return bitmap;
        }
        double d = ((width > height ? (double) width : (double) height) * 1.0d) / 800.0d;
        return Bitmap.createScaledBitmap(bitmap, (int) ((((double) width) * 1.0d) / d), (int) ((((double) height) * 1.0d) / d), false);
    }

    public static String getUserIdForUrl(int i) {
        return i == 0 ? "myself" : String.valueOf(i);
    }

    public static void savePhoto(int i, int i2, Bitmap bitmap, String str, boolean z, final Runnable runnable) {
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("photo_type", Integer.valueOf(i2));
        if (str != null) {
            hashMap.put(Part.NOTE_MESSAGE_STYLE, str);
        }
        hashMap.put("is_public", Boolean.valueOf(z));
        hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
        baseHttpClient.postWithImage(String.format("/users/%s/photos/new", new Object[]{getUserIdForUrl(i)}), hashMap, bitmap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Runnable runnable = runnable;
                if (runnable == null) {
                    return true;
                }
                runnable.run();
                return true;
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                Runnable runnable = runnable;
                if (runnable == null) {
                    return false;
                }
                runnable.run();
                return false;
            }
        });
    }

    public static void sendGack(Throwable th) {
        Sentry.captureException(th);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            message = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("subject", message);
        hashMap.put("details", stringWriter2);
        new BaseHttpClient().put("gack", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public static void hideKeyboardFrom(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static float getDeviceWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = ((float) displayMetrics.heightPixels) / displayMetrics.density;
        float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.density;
        return f2 < f ? f2 : f;
    }

    public static void setMargins(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    public static int getId(String str, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            return declaredField.getInt(declaredField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: " + str + " / " + cls, e);
        }
    }

    public static void storeIsTrainerProperty(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Util.class.getSimpleName(), 0).edit();
        edit.putBoolean(PROPERTY_IS_TRAINER, z);
        edit.apply();
    }

    public static Boolean getIsTrainerProperty(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.class.getSimpleName(), 0);
        return Boolean.valueOf(sharedPreferences.contains(PROPERTY_IS_TRAINER) ? sharedPreferences.getBoolean(PROPERTY_IS_TRAINER, false) : true);
    }

    public static void storeStoryIds(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Util.class.getSimpleName(), 0).edit();
        edit.putString(FLAG_STORY_IDS, str);
        edit.apply();
    }

    public static String getStoryIds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.class.getSimpleName(), 0);
        return sharedPreferences.contains(FLAG_STORY_IDS) ? sharedPreferences.getString(FLAG_STORY_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static void storeUserIds(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Util.class.getSimpleName(), 0).edit();
        edit.putString(BLOCK_USER_IDS, str);
        edit.apply();
    }

    public static String getUserIds(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.class.getSimpleName(), 0);
        return sharedPreferences.contains(BLOCK_USER_IDS) ? sharedPreferences.getString(BLOCK_USER_IDS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI) : HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static void storeStep(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Util.class.getSimpleName(), 0).edit();
        edit.putInt(STEP, i);
        edit.apply();
    }

    public static Integer getStep(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Util.class.getSimpleName(), 0);
        int i = 1;
        if (sharedPreferences.contains(STEP)) {
            i = sharedPreferences.getInt(STEP, 1);
        }
        return Integer.valueOf(i);
    }

    public static String[] getMimeType(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension((lastIndexOf > 0 ? str.substring(lastIndexOf + 1) : "txt").toLowerCase());
        if (mimeTypeFromExtension == null) {
            return new String[]{"application", "octet-stream"};
        }
        return mimeTypeFromExtension.split("/");
    }

    public static boolean checkIsTablet(Context context) {
        Display defaultDisplay = ((AppCompatActivity) context).getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d || getDeviceWidth(context) > 500.0f;
    }

    public static void showToast(Context context, int i) {
        Toast makeText = Toast.makeText(context, context.getString(i), 0);
        View view = makeText.getView();
        if (view != null) {
            view.getBackground().setColorFilter(context.getResources().getColor(R.color.toastBackground), PorterDuff.Mode.SRC_IN);
            ((TextView) view.findViewById(16908299)).setTextColor(Color.parseColor("#ffffff"));
        }
        makeText.show();
    }
}
