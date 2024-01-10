package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.github.mikephil.charting.utils.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\bæ\u0001ç\u0001è\u0001é\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010'\u001a\u00020\u001e\"\u0004\b\u0000\u0010(2\b\u0010)\u001a\u0004\u0018\u0001H(2\b\u0010*\u001a\u0004\u0018\u0001H(H\u0007¢\u0006\u0002\u0010+J7\u0010,\u001a\u0012\u0012\u0004\u0012\u0002H(0-j\b\u0012\u0004\u0012\u0002H(`.\"\u0004\b\u0000\u0010(2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002H(00\"\u0002H(H\u0007¢\u0006\u0002\u00101J-\u00102\u001a\b\u0012\u0004\u0012\u0002H(03\"\u0004\b\u0000\u0010(2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u0002H(00\"\u0002H(H\u0007¢\u0006\u0002\u00105J\u0012\u00106\u001a\u0004\u0018\u00010\u00182\u0006\u00107\u001a\u00020\u0004H\u0007J&\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00042\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010<\u001a\u0004\u0018\u00010=H\u0007J\b\u0010>\u001a\u00020?H\u0007J\u0018\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0004H\u0002J\u0010\u0010D\u001a\u00020?2\u0006\u0010A\u001a\u00020BH\u0007J\u0012\u0010E\u001a\u00020?2\b\u0010F\u001a\u0004\u0018\u00010GH\u0007J\u001e\u0010H\u001a\u0004\u0018\u00010\u00042\b\u0010I\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020MH\u0002J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020\u0004032\u0006\u0010O\u001a\u00020PH\u0007J\u001c\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010R2\u0006\u0010S\u001a\u00020\u0018H\u0007J\u001c\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040R2\u0006\u0010S\u001a\u00020\u0018H\u0007J\u001a\u0010U\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020YH\u0007J\u0012\u0010Z\u001a\u00020?2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0007J\u0012\u0010]\u001a\u00020?2\b\u0010^\u001a\u0004\u0018\u00010_H\u0007J\b\u0010`\u001a\u00020\u001eH\u0002J4\u0010a\u001a\n\u0012\u0004\u0012\u0002H(\u0018\u000103\"\u0004\b\u0000\u0010(2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u0002H(\u0018\u0001032\f\u0010c\u001a\b\u0012\u0004\u0012\u0002H(0dH\u0007J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u0006H\u0007J\u0012\u0010g\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u0010\u0010h\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0007J\n\u0010i\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010j\u001a\u0004\u0018\u00010k2\b\u0010l\u001a\u0004\u0018\u00010=2\b\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010n\u001a\u00020kH\u0007J\u0010\u0010o\u001a\u00020\u00112\u0006\u0010p\u001a\u000209H\u0007J\u0010\u0010q\u001a\u00020r2\u0006\u00107\u001a\u00020\u0004H\u0002J\u0018\u0010s\u001a\u00020?2\u0006\u00107\u001a\u00020\u00042\u0006\u0010t\u001a\u00020uH\u0007J\u0012\u0010v\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010BH\u0007JC\u0010w\u001a\u0004\u0018\u00010x2\n\u0010y\u001a\u0006\u0012\u0002\b\u00030z2\u0006\u0010{\u001a\u00020\u00042\u001e\u0010|\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010z00\"\b\u0012\u0002\b\u0003\u0018\u00010zH\u0007¢\u0006\u0002\u0010}J?\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010~\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00042\u001e\u0010|\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010z00\"\b\u0012\u0002\b\u0003\u0018\u00010zH\u0007¢\u0006\u0002\u0010J(\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010S\u001a\u00020\u00182\b\u0010m\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0007J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0007J\u001d\u0010\u0001\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u00182\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0007J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010L\u001a\u00030\u0001H\u0002J;\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u0002H(0\u0001j\t\u0012\u0004\u0012\u0002H(`\u0001\"\u0004\b\u0000\u0010(2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002H(00\"\u0002H(H\u0007¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010L\u001a\u00030\u0001H\u0002J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0002J$\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J>\u0010\u0001\u001a\u0004\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020x2\u0017\u0010\u0001\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000100\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BH\u0007J\u0011\u0010\u0001\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BH\u0007J\u0014\u0010\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0007J\u0015\u0010\u0001\u001a\u00020\u001e2\n\u0010\u0001\u001a\u0005\u0018\u00010 \u0001H\u0007J\u0014\u0010¡\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0007J\u0013\u0010¢\u0001\u001a\u00020\u001e2\b\u0010I\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010¢\u0001\u001a\u00020\u001e\"\u0004\b\u0000\u0010(2\u0010\u0010£\u0001\u001a\u000b\u0012\u0004\u0012\u0002H(\u0018\u00010¤\u0001H\u0007J3\u0010¥\u0001\u001a\u00020\u001e\"\u0004\b\u0000\u0010(2\u0010\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u0002H(\u0018\u00010¤\u00012\u0010\u0010§\u0001\u001a\u000b\u0012\u0004\u0012\u0002H(\u0018\u00010¤\u0001H\u0007J\u0014\u0010¨\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0007J\u0018\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040ª\u00012\u0006\u0010O\u001a\u00020PH\u0007J\u0017\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004032\u0006\u0010O\u001a\u00020PH\u0007J\u001e\u0010¬\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040R2\u0007\u0010­\u0001\u001a\u00020\u0004H\u0007J'\u0010®\u0001\u001a\u00020?2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\u0011\u0010°\u0001\u001a\f\u0018\u00010±\u0001j\u0005\u0018\u0001`²\u0001H\u0007J\u001f\u0010®\u0001\u001a\u00020?2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010³\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J+\u0010®\u0001\u001a\u00020?2\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0007JF\u0010¶\u0001\u001a\u000b\u0012\u0005\u0012\u0003H·\u0001\u0018\u000103\"\u0004\b\u0000\u0010(\"\u0005\b\u0001\u0010·\u00012\u000e\u0010b\u001a\n\u0012\u0004\u0012\u0002H(\u0018\u0001032\u0015\u0010¸\u0001\u001a\u0010\u0012\u0004\u0012\u0002H(\u0012\u0005\u0012\u0003H·\u00010¹\u0001H\u0007J\"\u0010º\u0001\u001a\u00020\u00042\u0017\u0010¶\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040RH\u0007J\u0013\u0010»\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010m\u001a\u00020\u0004H\u0007J\u0011\u0010¼\u0001\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020BH\u0007J\u0014\u0010½\u0001\u001a\u00020=2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010¿\u0001\u001a\u00020?2\u0006\u0010*\u001a\u00020=2\b\u0010m\u001a\u0004\u0018\u00010\u00042\u0011\u0010À\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u000103H\u0007J&\u0010Á\u0001\u001a\u00020\u001e2\u0006\u0010l\u001a\u00020=2\b\u0010m\u001a\u0004\u0018\u00010\u00042\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010Ã\u0001\u001a\u00020?2\u0006\u0010*\u001a\u00020=2\b\u0010m\u001a\u0004\u0018\u00010\u00042\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010Ä\u0001\u001a\u00020?2\u0006\u0010*\u001a\u00020=2\b\u0010m\u001a\u0004\u0018\u00010\u00042\t\u0010\u0001\u001a\u0004\u0018\u000109H\u0007J\u0013\u0010Å\u0001\u001a\u00020\u00042\b\u0010V\u001a\u0004\u0018\u00010WH\u0007J%\u0010Æ\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010R2\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0007J\t\u0010É\u0001\u001a\u00020?H\u0002J\t\u0010Ê\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010Ë\u0001\u001a\u00020?2\u0007\u0010Ì\u0001\u001a\u00020BH\u0002J\u0012\u0010Í\u0001\u001a\u00020?2\u0007\u0010Ì\u0001\u001a\u00020BH\u0002J\t\u0010Î\u0001\u001a\u00020?H\u0002J\t\u0010Ï\u0001\u001a\u00020?H\u0002J\u0015\u0010Ð\u0001\u001a\u00020?2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ò\u0001H\u0007J\u001f\u0010Ó\u0001\u001a\u00020\u00042\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J2\u0010Ö\u0001\u001a\u00020?2\u0007\u0010×\u0001\u001a\u00020\u00182\n\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u00012\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Û\u0001\u001a\u00020\u001eH\u0007J\u001b\u0010Ü\u0001\u001a\u00020?2\u0007\u0010×\u0001\u001a\u00020\u00182\u0007\u0010Ì\u0001\u001a\u00020BH\u0007J\u0014\u0010Ý\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010L\u001a\u00030\u0001H\u0007J\u0013\u0010Ý\u0001\u001a\u0004\u0018\u00010\u00042\u0006\u0010m\u001a\u00020\u0004H\u0007J\u0016\u0010Þ\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010L\u001a\u0005\u0018\u00010\u0001H\u0007J\u0015\u0010Þ\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010m\u001a\u0004\u0018\u00010\u0004H\u0007J\u001d\u0010ß\u0001\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010à\u0001\u001a\u0004\u0018\u00010P2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010á\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J!\u0010â\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u00182\t\u0010á\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J0\u0010ã\u0001\u001a\t\u0012\u0004\u0012\u0002H(0¤\u0001\"\u0004\b\u0000\u0010(2\u0012\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u0002H(00\"\u0002H(H\u0007¢\u0006\u0003\u0010ä\u0001J.\u0010å\u0001\u001a\u00020?2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0019\u0010¶\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010RH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001e8FX\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b\u001d\u0010 R\u0011\u0010!\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\b!\u0010 R\u000e\u0010\"\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010\u00148G¢\u0006\u0006\u001a\u0004\b$\u0010\u0016R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006ê\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "()V", "ARC_DEVICE_PATTERN", "", "DEFAULT_STREAM_BUFFER_SIZE", "", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "LOG_TAG", "NO_CARRIER", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "URL_SCHEME", "UTF8", "availableExternalStorageGB", "", "carrierName", "currentLocale", "Ljava/util/Locale;", "getCurrentLocale", "()Ljava/util/Locale;", "dataProcessingOptions", "Lorg/json/JSONObject;", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "deviceTimeZoneName", "deviceTimezoneAbbreviation", "isAutoAppLinkSetup", "", "isAutoAppLinkSetup$annotations", "()Z", "isDataProcessingRestricted", "numCPUCores", "resourceLocale", "getResourceLocale", "timestampOfLastCheck", "totalExternalStorageGB", "areObjectsEqual", "T", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "arrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ts", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "asListNoNulls", "", "array", "([Ljava/lang/Object;)Ljava/util/List;", "awaitGetGraphMeRequestWithCache", "accessToken", "buildUri", "Landroid/net/Uri;", "authority", "path", "parameters", "Landroid/os/Bundle;", "clearCaches", "", "clearCookiesForDomain", "context", "Landroid/content/Context;", "domain", "clearFacebookCookies", "closeQuietly", "closeable", "Ljava/io/Closeable;", "coerceValueIfNullOrEmpty", "s", "valueIfNullOrEmpty", "convertBytesToGB", "bytes", "", "convertJSONArrayToList", "jsonArray", "Lorg/json/JSONArray;", "convertJSONObjectToHashMap", "", "jsonObject", "convertJSONObjectToStringMap", "copyAndCloseInputStream", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "deleteDirectory", "directoryOrFile", "Ljava/io/File;", "disconnectQuietly", "connection", "Ljava/net/URLConnection;", "externalStorageExists", "filter", "target", "predicate", "Lcom/facebook/internal/Utility$Predicate;", "generateRandomString", "length", "getActivityName", "getAppName", "getAppVersion", "getBundleLongAsDate", "Ljava/util/Date;", "bundle", "key", "dateBase", "getContentSize", "contentUri", "getGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCacheAsync", "callback", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "getMetadataApplicationId", "getMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "Ljava/lang/Class;", "methodName", "parameterTypes", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getStringPropertyAsJSON", "nonJSONPropertyKey", "getUriString", "uri", "handlePermissionResponse", "Lcom/facebook/internal/Utility$PermissionsLists;", "result", "hasSameId", "hashBytes", "hash", "Ljava/security/MessageDigest;", "", "hashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "hashWithAlgorithm", "algorithm", "intersectRanges", "", "range1", "range2", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "isAutofillAvailable", "isChromeOS", "isContentUri", "isCurrentAccessToken", "token", "Lcom/facebook/AccessToken;", "isFileUri", "isNullOrEmpty", "c", "", "isSubset", "subset", "superset", "isWebUri", "jsonArrayToSet", "", "jsonArrayToStringList", "jsonStrToMap", "str", "logd", "tag", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "t", "", "map", "K", "mapper", "Lcom/facebook/internal/Utility$Mapper;", "mapToJsonStr", "md5hash", "mustFixWindowParamsForAutofill", "parseUrlQueryString", "queryString", "putCommaSeparatedStringList", "list", "putJSONValueInBundle", "value", "putNonEmptyString", "putUri", "readStreamToString", "readStringMapFromParcel", "parcel", "Landroid/os/Parcel;", "refreshAvailableExternalStorage", "refreshBestGuessNumberOfCPUCores", "refreshCarrierName", "appContext", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshTotalExternalStorage", "runOnNonUiThread", "runnable", "Ljava/lang/Runnable;", "safeGetStringFromResponse", "response", "propertyName", "setAppEventAttributionParameters", "params", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventExtendedDeviceInfoParameters", "sha1hash", "sha256hash", "stringsEqualOrEmpty", "tryGetJSONArrayFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "unmodifiableCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "writeStringMapToParcel", "GraphMeRequestWithCacheCallback", "Mapper", "PermissionsLists", "Predicate", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Utility.kt */
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    public static final Utility INSTANCE = new Utility();
    public static final String LOG_TAG = "FacebookSDK";
    private static final String NO_CARRIER = "NoCarrier";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = NO_CARRIER;
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static int numCPUCores;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Utility.kt */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Mapper;", "T", "K", "", "apply", "item", "(Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Utility.kt */
    public interface Mapper<T, K> {
        K apply(T t);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/Utility$Predicate;", "T", "", "apply", "", "item", "(Ljava/lang/Object;)Z", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Utility.kt */
    public interface Predicate<T> {
        boolean apply(T t);
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    private Utility() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x000e A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] intersectRanges(int[] r10, int[] r11) {
        /*
            if (r10 != 0) goto L_0x0003
            return r11
        L_0x0003:
            if (r11 != 0) goto L_0x0006
            return r10
        L_0x0006:
            int r0 = r10.length
            int r1 = r11.length
            int r0 = r0 + r1
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x000e:
            int r4 = r10.length
            if (r1 >= r4) goto L_0x0068
            int r4 = r11.length
            if (r2 >= r4) goto L_0x0068
            r4 = r10[r1]
            r5 = r11[r2]
            int r6 = r10.length
            int r6 = r6 + -1
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L_0x0025
            int r6 = r1 + 1
            r6 = r10[r6]
            goto L_0x0028
        L_0x0025:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x0028:
            int r8 = r11.length
            int r8 = r8 + -1
            if (r2 >= r8) goto L_0x0032
            int r8 = r2 + 1
            r8 = r11[r8]
            goto L_0x0035
        L_0x0032:
            r8 = 2147483647(0x7fffffff, float:NaN)
        L_0x0035:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 >= r5) goto L_0x0048
            if (r6 <= r5) goto L_0x0045
            if (r6 <= r8) goto L_0x0041
            int r2 = r2 + 2
            r4 = r5
            goto L_0x0051
        L_0x0041:
            int r1 = r1 + 2
            r4 = r5
            goto L_0x005a
        L_0x0045:
            int r1 = r1 + 2
            goto L_0x0055
        L_0x0048:
            if (r8 <= r4) goto L_0x0053
            if (r8 <= r6) goto L_0x004f
            int r1 = r1 + 2
            goto L_0x005a
        L_0x004f:
            int r2 = r2 + 2
        L_0x0051:
            r6 = r8
            goto L_0x005a
        L_0x0053:
            int r2 = r2 + 2
        L_0x0055:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x005a:
            if (r4 == r9) goto L_0x000e
            int r5 = r3 + 1
            r0[r3] = r4
            if (r6 == r7) goto L_0x0067
            int r3 = r5 + 1
            r0[r5] = r6
            goto L_0x000e
        L_0x0067:
            r3 = r5
        L_0x0068:
            int[] r10 = java.util.Arrays.copyOf(r0, r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.intersectRanges(int[], int[]):int[]");
    }

    @JvmStatic
    public static final <T> boolean isSubset(Collection<? extends T> collection, Collection<? extends T> collection2) {
        if (collection2 != null && !collection2.isEmpty()) {
            HashSet hashSet = new HashSet(collection2);
            if (collection != null) {
                for (Object contains : collection) {
                    if (!hashSet.contains(contains)) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (collection == null || collection.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @JvmStatic
    public static final <T> boolean isNullOrEmpty(Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(String str) {
        if (str != null) {
            return str.length() == 0;
        }
    }

    @JvmStatic
    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    @JvmStatic
    public static final <T> Collection<T> unmodifiableCollection(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "ts");
        Collection<T> unmodifiableCollection = Collections.unmodifiableCollection(Arrays.asList(Arrays.copyOf(tArr, tArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableCollection, "Collections.unmodifiable…ction(Arrays.asList(*ts))");
        return unmodifiableCollection;
    }

    @JvmStatic
    public static final <T> ArrayList<T> arrayList(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "ts");
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @JvmStatic
    public static final <T> HashSet<T> hashSet(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "ts");
        HashSet<T> hashSet = new HashSet<>(tArr.length);
        for (T add : tArr) {
            hashSet.add(add);
        }
        return hashSet;
    }

    @JvmStatic
    public static final String md5hash(String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, str);
    }

    @JvmStatic
    public static final String sha1hash(String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, str);
    }

    @JvmStatic
    public static final String sha1hash(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bArr);
    }

    @JvmStatic
    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, str);
    }

    @JvmStatic
    public static final String sha256hash(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, bArr);
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = Charsets.UTF_8;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return hashWithAlgorithm(str, bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(instance, "hash");
            return hashBytes(instance, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toHexString((b >> 4) & 15));
            sb.append(Integer.toHexString((b >> 0) & 15));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    @JvmStatic
    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    @JvmStatic
    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        Object[] array2 = StringsKt.split$default((CharSequence) strArr[i], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e) {
                                logd(LOG_TAG, (Exception) e);
                            }
                            i++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putNonEmptyString(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
                sb.append(",");
            }
            bundle.putString(str, sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
        }
    }

    @JvmStatic
    public static final void putUri(Bundle bundle, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(bundle, "b");
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (!(obj instanceof JSONObject)) {
            return false;
        } else {
            bundle.putString(str, obj.toString());
            return true;
        }
    }

    @JvmStatic
    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    @JvmStatic
    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        String applicationId = FacebookSdk.getApplicationId();
        Intrinsics.checkNotNullExpressionValue(applicationId, "FacebookSdk.getApplicationId()");
        return applicationId;
    }

    @JvmStatic
    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        JSONArray names = jSONObject.names();
        int length = names.length();
        for (int i = 0; i < length; i++) {
            try {
                String string = names.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                Object obj = jSONObject.get(string);
                if (obj instanceof JSONObject) {
                    obj = convertJSONObjectToHashMap((JSONObject) obj);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "value");
                hashMap.put(string, obj);
            } catch (JSONException unused) {
            }
        }
        return hashMap;
    }

    @JvmStatic
    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                Intrinsics.checkNotNullExpressionValue(next, SDKConstants.PARAM_KEY);
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    @JvmStatic
    public static final List<String> convertJSONArrayToList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        try {
            List<String> arrayList = new ArrayList<>();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList<>();
        }
    }

    @JvmStatic
    public static final Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    @JvmStatic
    public static final String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader2 = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream2);
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream2;
                InputStreamReader inputStreamReader3 = inputStreamReader2;
                th = th;
                inputStreamReader = inputStreamReader3;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                char[] cArr = new char[2048];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        String sb2 = sb.toString();
                        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
                        closeQuietly(bufferedInputStream2);
                        closeQuietly(inputStreamReader);
                        return sb2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            InputStreamReader inputStreamReader32 = inputStreamReader2;
            th = th;
            inputStreamReader = inputStreamReader32;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033  */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r0 = (java.io.BufferedInputStream) r0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r6)     // Catch:{ all -> 0x002b }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0028 }
            r2 = 0
            r3 = 0
        L_0x0013:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0028 }
            r5 = -1
            if (r4 == r5) goto L_0x001f
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0028 }
            int r3 = r3 + r4
            goto L_0x0013
        L_0x001f:
            r1.close()
            if (r6 == 0) goto L_0x0027
            r6.close()
        L_0x0027:
            return r3
        L_0x0028:
            r7 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r7 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            if (r6 == 0) goto L_0x0036
            r6.close()
        L_0x0036:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(String str, String str2) {
        CharSequence charSequence = str;
        boolean z = charSequence == null || charSequence.length() == 0;
        CharSequence charSequence2 = str2;
        boolean z2 = charSequence2 == null || charSequence2.length() == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array = StringsKt.split$default((CharSequence) cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    Object[] array2 = StringsKt.split$default((CharSequence) strArr[i], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = (String[]) array2;
                        if (strArr2.length > 0) {
                            StringBuilder sb = new StringBuilder();
                            CharSequence charSequence = strArr2[0];
                            int length2 = charSequence.length() - 1;
                            int i2 = 0;
                            boolean z = false;
                            while (i2 <= length2) {
                                boolean z2 = Intrinsics.compare((int) charSequence.charAt(!z ? i2 : length2), 32) <= 0;
                                if (!z) {
                                    if (!z2) {
                                        z = true;
                                    } else {
                                        i2++;
                                    }
                                } else if (!z2) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            sb.append(charSequence.subSequence(i2, length2 + 1).toString());
                            sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                            instance.setCookie(str, sb.toString());
                        }
                        i++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    @JvmStatic
    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.clearCookiesForDomain(context, "facebook.com");
        INSTANCE.clearCookiesForDomain(context, ".facebook.com");
        INSTANCE.clearCookiesForDomain(context, "https://facebook.com");
        INSTANCE.clearCookiesForDomain(context, "https://.facebook.com");
    }

    @JvmStatic
    public static final void logd(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
        }
    }

    @JvmStatic
    public static final void logd(String str, String str2) {
        if (FacebookSdk.isDebugEnabled() && str != null && str2 != null) {
            Log.d(str, str2);
        }
    }

    @JvmStatic
    public static final void logd(String str, String str2, Throwable th) {
        if (FacebookSdk.isDebugEnabled() && !isNullOrEmpty(str)) {
            Log.d(str, str2, th);
        }
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return Intrinsics.areEqual((Object) t, (Object) t2);
    }

    @JvmStatic
    public static final boolean hasSameId(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null || !jSONObject.has("id") || !jSONObject2.has("id")) {
            return false;
        }
        if (Intrinsics.areEqual((Object) jSONObject, (Object) jSONObject2)) {
            return true;
        }
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject2.optString("id");
        if (optString == null || optString2 == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) optString, (Object) optString2);
    }

    @JvmStatic
    public static final String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        String optString = jSONObject.optString(str, "");
        Intrinsics.checkNotNullExpressionValue(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    @JvmStatic
    public static final JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    @JvmStatic
    public static final JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    @JvmStatic
    public static final void clearCaches() {
        ImageDownloader.clearCache();
    }

    @JvmStatic
    public static final void deleteDirectory(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File deleteDirectory : listFiles) {
                    deleteDirectory(deleteDirectory);
                }
            }
            file.delete();
        }
    }

    @JvmStatic
    public static final <T> List<T> asListNoNulls(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final List<String> jsonArrayToStringList(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    @JvmStatic
    public static final Set<String> jsonArrayToSet(JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        Set<String> hashSet = new HashSet<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    @JvmStatic
    public static final String mapToJsonStr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), (String) next.getValue());
                }
                str = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(str, "try {\n        val jsonOb…ion) {\n        \"\"\n      }");
        }
        return str;
    }

    @JvmStatic
    public static final Map<String, String> jsonStrToMap(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap<>();
        }
        try {
            Map<String, String> hashMap = new HashMap<>();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, SDKConstants.PARAM_KEY);
                String string = jSONObject.getString(next);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap<>();
        }
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        jSONObject.put("anon_id", str);
        boolean z2 = true;
        jSONObject.put("application_tracking_enabled", !z);
        jSONObject.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (attributionIdentifiers.getAttributionId() != null) {
                jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                Intrinsics.checkNotNullExpressionValue(allHashedUserData, "userData");
                if (allHashedUserData.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    jSONObject.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                jSONObject.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    @JvmStatic
    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext != null) {
            try {
                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
                if (packageInfo != null) {
                    return packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i;
        Intrinsics.checkNotNullParameter(jSONObject, NativeProtocol.WEB_DIALOG_PARAMS);
        Intrinsics.checkNotNullParameter(context, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i2 = 0;
        int i3 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                i3 = packageInfo.versionCode;
                str = packageInfo.versionName;
                jSONArray.put(packageName);
                jSONArray.put(i3);
                jSONArray.put(str);
                jSONArray.put(Build.VERSION.RELEASE);
                jSONArray.put(Build.MODEL);
                try {
                    Resources resources = context.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
                    locale = resources.getConfiguration().locale;
                } catch (Exception unused) {
                    locale = Locale.getDefault();
                }
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(locale, "locale");
                sb.append(locale.getLanguage());
                sb.append("_");
                sb.append(locale.getCountry());
                jSONArray.put(sb.toString());
                jSONArray.put(deviceTimezoneAbbreviation);
                jSONArray.put(carrierName);
                double d = Utils.DOUBLE_EPSILON;
                try {
                    Object systemService = context.getSystemService("window");
                    if (systemService != null) {
                        WindowManager windowManager = (WindowManager) systemService;
                        if (windowManager != null) {
                            Display defaultDisplay = windowManager.getDefaultDisplay();
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            defaultDisplay.getMetrics(displayMetrics);
                            int i4 = displayMetrics.widthPixels;
                            try {
                                int i5 = displayMetrics.heightPixels;
                                try {
                                    d = (double) displayMetrics.density;
                                } catch (Exception unused2) {
                                }
                                int i6 = i5;
                                i2 = i4;
                                i = i6;
                            } catch (Exception unused3) {
                                i2 = i4;
                            }
                            jSONArray.put(i2);
                            jSONArray.put(i);
                            jSONArray.put(new DecimalFormat("#.##").format(d));
                            jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                            jSONArray.put(totalExternalStorageGB);
                            jSONArray.put(availableExternalStorageGB);
                            jSONArray.put(deviceTimeZoneName);
                            jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                            return;
                        }
                        i = 0;
                        jSONArray.put(i2);
                        jSONArray.put(i);
                        jSONArray.put(new DecimalFormat("#.##").format(d));
                        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
                        jSONArray.put(totalExternalStorageGB);
                        jSONArray.put(availableExternalStorageGB);
                        jSONArray.put(deviceTimeZoneName);
                        jSONObject.put(Constants.EXTINFO, jSONArray.toString());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
                } catch (Exception unused4) {
                }
            }
        } catch (PackageManager.NameNotFoundException unused5) {
            str = "";
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "Class.forName(className)");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Intrinsics.checkNotNullParameter(method, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final String getActivityName(Context context) {
        if (context == null) {
            return JsonLexerKt.NULL;
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "context.javaClass.simpleName");
        return simpleName;
    }

    @JvmStatic
    public static final <T> List<T> filter(List<? extends T> list, Predicate<T> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (list == null) {
            return null;
        }
        List<T> arrayList = new ArrayList<>();
        for (Object next : list) {
            if (predicate.apply(next)) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @JvmStatic
    public static final <T, K> List<K> map(List<? extends T> list, Mapper<T, K> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        if (list == null) {
            return null;
        }
        List<K> arrayList = new ArrayList<>();
        for (Object apply : list) {
            K apply2 = mapper.apply(apply);
            if (apply2 != null) {
                arrayList.add(apply2);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @JvmStatic
    public static final String getUriString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @JvmStatic
    public static final boolean isWebUri(Uri uri) {
        if (uri == null || (!StringsKt.equals("http", uri.getScheme(), true) && !StringsKt.equals("https", uri.getScheme(), true) && !StringsKt.equals("fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean isContentUri(Uri uri) {
        return uri != null && StringsKt.equals("content", uri.getScheme(), true);
    }

    @JvmStatic
    public static final boolean isFileUri(Uri uri) {
        return uri != null && StringsKt.equals("file", uri.getScheme(), true);
    }

    @JvmStatic
    public static final long getContentSize(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        Cursor cursor = null;
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "FacebookSdk.getApplicationContext()");
            Cursor query = applicationContext.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return 0;
            }
            int columnIndex = query.getColumnIndex("_size");
            query.moveToFirst();
            long j = query.getLong(columnIndex);
            query.close();
            return j;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j;
        Intrinsics.checkNotNullParameter(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (j * 1000));
    }

    @JvmStatic
    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    @JvmStatic
    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < readInt; i++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && Intrinsics.areEqual((Object) accessToken, (Object) AccessToken.getCurrentAccessToken());
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        Intrinsics.checkNotNullParameter(graphMeRequestWithCacheCallback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(new Utility$getGraphMeRequestWithCacheAsync$graphCallback$1(graphMeRequestWithCacheCallback, str));
        graphMeRequestWithCache.executeAsync();
    }

    @JvmStatic
    public static final JSONObject awaitGetGraphMeRequestWithCache(String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_ACCESS_TOKEN);
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        Intrinsics.checkNotNullExpressionValue(executeAndWait, "response");
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJSONObject();
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(GraphRequest.FIELDS_PARAM, "id,name,first_name,middle_name,last_name");
        bundle.putString("access_token", str);
        return new GraphRequest((AccessToken) null, "me", bundle, HttpMethod.GET, (GraphRequest.Callback) null);
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i = numCPUCores;
        if (i > 0) {
            return i;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(Utility$refreshBestGuessNumberOfCPUCores$cpuFiles$1.INSTANCE);
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= ((long) REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS)) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            Intrinsics.checkNotNullExpressionValue(timeZone, "tz");
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshCarrierName(Context context) {
        if (Intrinsics.areEqual((Object) carrierName, (Object) NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual((Object) "mounted", (Object) Environment.getExternalStorageState());
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "path");
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final long convertBytesToGB(double d) {
        return Math.round(d / 1.073741824E9d);
    }

    @JvmStatic
    public static final PermissionsLists handlePermissionResponse(JSONObject jSONObject) throws JSONException {
        String optString;
        Intrinsics.checkNotNullParameter(jSONObject, "result");
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        List arrayList = new ArrayList(jSONArray.length());
        List arrayList2 = new ArrayList(jSONArray.length());
        List arrayList3 = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString2 = optJSONObject.optString("permission");
            if (!(optString2 == null || Intrinsics.areEqual((Object) optString2, (Object) "installed") || (optString = optJSONObject.optString("status")) == null)) {
                if (Intrinsics.areEqual((Object) optString, (Object) "granted")) {
                    arrayList.add(optString2);
                } else if (Intrinsics.areEqual((Object) optString, (Object) "declined")) {
                    arrayList2.add(optString2);
                } else if (Intrinsics.areEqual((Object) optString, (Object) "expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new PermissionsLists(arrayList, arrayList2, arrayList3);
    }

    @JvmStatic
    public static final String generateRandomString(int i) {
        String bigInteger = new BigInteger(i * 5, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        if (Build.DEVICE != null) {
            String str = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(str, "Build.DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).matches(str)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Locale getResourceLocale() {
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "FacebookSdk.getApplicationContext()");
            Resources resources = applicationContext.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "FacebookSdk.getApplicationContext().resources");
            return resources.getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        return locale;
    }

    @JvmStatic
    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format));
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "ctx");
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (Intrinsics.areEqual((Object) packageName, (Object) resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @JvmStatic
    public static final JSONObject getDataProcessingOptions() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, (String) null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isDataProcessingRestricted() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                try {
                    JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                    int length = jSONArray.length();
                    int i = 0;
                    while (i < length) {
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        if (string != null) {
                            String lowerCase = string.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            if (Intrinsics.areEqual((Object) lowerCase, (Object) "ldu")) {
                                return true;
                            }
                            i++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/Utility$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-core_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: Utility.kt */
    public static final class PermissionsLists {
        private List<String> declinedPermissions;
        private List<String> expiredPermissions;
        private List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            Intrinsics.checkNotNullParameter(list, "grantedPermissions");
            Intrinsics.checkNotNullParameter(list2, SDKConstants.PARAM_DECLINED_PERMISSIONS);
            Intrinsics.checkNotNullParameter(list3, SDKConstants.PARAM_EXPIRED_PERMISSIONS);
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setGrantedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.grantedPermissions = list;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final void setExpiredPermissions(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.expiredPermissions = list;
        }
    }
}
