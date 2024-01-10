package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import io.intercom.android.sdk.models.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String STAGING_PARAM = "file";

    static /* synthetic */ NativeAppCallAttachmentStore.Attachment access$000(UUID uuid, ShareMedia shareMedia) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return getAttachment(uuid, shareMedia);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (exc instanceof FacebookException) {
                    invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
                    return;
                }
                invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exc.getLocalizedMessage());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                invokeOnErrorCallback(facebookCallback, str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    String errorMessage = error.getErrorMessage();
                    if (Utility.isNullOrEmpty(errorMessage)) {
                        errorMessage = "Unexpected error sharing.";
                    }
                    invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
                    return;
                }
                invokeOnSuccessCallback(facebookCallback, str);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
                return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
            }
            return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static String getShareDialogPostId(Bundle bundle) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
                return bundle.getString(ShareConstants.RESULT_POST_ID);
            }
            if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
                return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
            }
            return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static boolean handleActivityResult(int i, int i2, Intent intent, ResultProcessor resultProcessor) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            AppCall appCallFromActivityResult = getAppCallFromActivityResult(i, i2, intent);
            if (appCallFromActivityResult == null) {
                return false;
            }
            NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
            if (resultProcessor == null) {
                return true;
            }
            FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
            if (exceptionFromErrorData == null) {
                resultProcessor.onSuccess(appCallFromActivityResult, NativeProtocol.getSuccessResultsFromIntent(intent));
            } else if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
                resultProcessor.onCancel(appCallFromActivityResult);
            } else {
                resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> facebookCallback) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return new ResultProcessor(facebookCallback) {
                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle != null) {
                        String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                        if (nativeDialogCompletionGesture == null || Part.POST_MESSAGE_STYLE.equalsIgnoreCase(nativeDialogCompletionGesture)) {
                            ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
                        } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                            ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                        } else {
                            ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) facebookCallback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                        }
                    }
                }

                public void onCancel(AppCall appCall) {
                    ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                }

                public void onError(AppCall appCall, FacebookException facebookException) {
                    ShareInternalUtility.invokeOnErrorCallback((FacebookCallback<Sharer.Result>) facebookCallback, facebookException);
                }
            };
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
            if (callIdFromIntent == null) {
                return null;
            }
            return AppCall.finishPendingCall(callIdFromIntent, i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static void registerStaticShareCallback(final int i) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                CallbackManagerImpl.registerStaticCallback(i, new CallbackManagerImpl.Callback() {
                    public boolean onActivityResult(int i, Intent intent) {
                        return ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor((FacebookCallback<Sharer.Result>) null));
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static void registerSharerCallback(final int i, CallbackManager callbackManager, final FacebookCallback<Sharer.Result> facebookCallback) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (callbackManager instanceof CallbackManagerImpl) {
                    ((CallbackManagerImpl) callbackManager).registerCallback(i, new CallbackManagerImpl.Callback() {
                        public boolean onActivityResult(int i, Intent intent) {
                            return ShareInternalUtility.handleActivityResult(i, i, intent, ShareInternalUtility.getShareResultProcessor(facebookCallback));
                        }
                    });
                    return;
                }
                throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, final UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && sharePhotoContent != null) {
            try {
                List<SharePhoto> photos = sharePhotoContent.getPhotos();
                if (photos != null) {
                    List<K> map = Utility.map(photos, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() {
                        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                            return ShareInternalUtility.access$000(uuid, sharePhoto);
                        }
                    });
                    List<String> map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String>() {
                        public String apply(NativeAppCallAttachmentStore.Attachment attachment) {
                            return attachment.getAttachmentUrl();
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(map);
                    return map2;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && shareVideoContent != null) {
            try {
                if (shareVideoContent.getVideo() != null) {
                    NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(createAttachment);
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return createAttachment.getAttachmentUrl();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, final UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && shareMediaContent != null) {
            try {
                List<ShareMedia> media = shareMediaContent.getMedia();
                if (media != null) {
                    final ArrayList arrayList = new ArrayList();
                    List<Bundle> map = Utility.map(media, new Utility.Mapper<ShareMedia, Bundle>() {
                        public Bundle apply(ShareMedia shareMedia) {
                            NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                            arrayList.add(access$000);
                            Bundle bundle = new Bundle();
                            bundle.putString("type", shareMedia.getMediaType().name());
                            bundle.putString("uri", access$000.getAttachmentUrl());
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return map;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && shareCameraEffectContent != null) {
            try {
                CameraEffectTextures textures = shareCameraEffectContent.getTextures();
                if (textures != null) {
                    Bundle bundle = new Bundle();
                    ArrayList arrayList = new ArrayList();
                    for (String next : textures.keySet()) {
                        NativeAppCallAttachmentStore.Attachment attachment = getAttachment(uuid, textures.getTextureUri(next), textures.getTextureBitmap(next));
                        arrayList.add(attachment);
                        bundle.putString(next, attachment.getAttachmentUrl());
                    }
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return bundle;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static JSONObject toJSONObjectForCall(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Set set;
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            ShareOpenGraphAction action = shareOpenGraphContent.getAction();
            final ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = OpenGraphJSONUtility.toJSONObject(action, (OpenGraphJSONUtility.PhotoJSONProcessor) new OpenGraphJSONUtility.PhotoJSONProcessor() {
                public JSONObject toJSONObject(SharePhoto sharePhoto) {
                    NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                    if (access$000 == null) {
                        return null;
                    }
                    arrayList.add(access$000);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", access$000.getAttachmentUrl());
                        if (sharePhoto.getUserGenerated()) {
                            jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                        }
                        return jSONObject;
                    } catch (JSONException e) {
                        throw new FacebookException("Unable to attach images", (Throwable) e);
                    }
                }
            });
            NativeAppCallAttachmentStore.addAttachments(arrayList);
            if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(jSONObject.optString("place"))) {
                jSONObject.put("place", shareOpenGraphContent.getPlaceId());
            }
            if (shareOpenGraphContent.getPeopleIds() != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                if (optJSONArray == null) {
                    set = new HashSet();
                } else {
                    set = Utility.jsonArrayToSet(optJSONArray);
                }
                for (String add : shareOpenGraphContent.getPeopleIds()) {
                    set.add(add);
                }
                jSONObject.put("tags", new JSONArray(set));
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), (OpenGraphJSONUtility.PhotoJSONProcessor) new OpenGraphJSONUtility.PhotoJSONProcessor() {
                public JSONObject toJSONObject(SharePhoto sharePhoto) {
                    Uri imageUrl = sharePhoto.getImageUrl();
                    if (Utility.isWebUri(imageUrl)) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", imageUrl.toString());
                            return jSONObject;
                        } catch (JSONException e) {
                            throw new FacebookException("Unable to attach images", (Throwable) e);
                        }
                    } else {
                        throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) throws JSONException {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
                }
                jSONArray2.put(obj);
            }
            return jSONArray2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        throw new com.facebook.FacebookException("Failed to create json object from share content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0099, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009c, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0091 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject removeNamespacesFromOGJsonObject(org.json.JSONObject r11, boolean r12) {
        /*
            java.lang.Class<com.facebook.share.internal.ShareInternalUtility> r0 = com.facebook.share.internal.ShareInternalUtility.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            if (r11 != 0) goto L_0x000d
            return r2
        L_0x000d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r1.<init>()     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r3.<init>()     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONArray r4 = r11.names()     // Catch:{ JSONException -> 0x0091 }
            r5 = 0
        L_0x001c:
            int r6 = r4.length()     // Catch:{ JSONException -> 0x0091 }
            if (r5 >= r6) goto L_0x0083
            java.lang.String r6 = r4.getString(r5)     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r7 = r11.get(r6)     // Catch:{ JSONException -> 0x0091 }
            boolean r8 = r7 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0091 }
            r9 = 1
            if (r8 == 0) goto L_0x0036
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONObject r7 = removeNamespacesFromOGJsonObject(r7, r9)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0040
        L_0x0036:
            boolean r8 = r7 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x0091 }
            if (r8 == 0) goto L_0x0040
            org.json.JSONArray r7 = (org.json.JSONArray) r7     // Catch:{ JSONException -> 0x0091 }
            org.json.JSONArray r7 = removeNamespacesFromOGJsonArray(r7, r9)     // Catch:{ JSONException -> 0x0091 }
        L_0x0040:
            android.util.Pair r8 = getFieldNameAndNamespaceFromFullName(r6)     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r9 = r8.first     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x0091 }
            java.lang.Object r8 = r8.second     // Catch:{ JSONException -> 0x0091 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ JSONException -> 0x0091 }
            if (r12 == 0) goto L_0x006f
            if (r9 == 0) goto L_0x005c
            java.lang.String r10 = "fbsdk"
            boolean r10 = r9.equals(r10)     // Catch:{ JSONException -> 0x0091 }
            if (r10 == 0) goto L_0x005c
            r1.put(r6, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0080
        L_0x005c:
            if (r9 == 0) goto L_0x006b
            java.lang.String r6 = "og"
            boolean r6 = r9.equals(r6)     // Catch:{ JSONException -> 0x0091 }
            if (r6 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            r3.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0080
        L_0x006b:
            r1.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0080
        L_0x006f:
            if (r9 == 0) goto L_0x007d
            java.lang.String r10 = "fb"
            boolean r9 = r9.equals(r10)     // Catch:{ JSONException -> 0x0091 }
            if (r9 == 0) goto L_0x007d
            r1.put(r6, r7)     // Catch:{ JSONException -> 0x0091 }
            goto L_0x0080
        L_0x007d:
            r1.put(r8, r7)     // Catch:{ JSONException -> 0x0091 }
        L_0x0080:
            int r5 = r5 + 1
            goto L_0x001c
        L_0x0083:
            int r11 = r3.length()     // Catch:{ JSONException -> 0x0091 }
            if (r11 <= 0) goto L_0x008e
            java.lang.String r11 = "data"
            r1.put(r11, r3)     // Catch:{ JSONException -> 0x0091 }
        L_0x008e:
            return r1
        L_0x008f:
            r11 = move-exception
            goto L_0x0099
        L_0x0091:
            com.facebook.FacebookException r11 = new com.facebook.FacebookException     // Catch:{ all -> 0x008f }
            java.lang.String r12 = "Failed to create json object from share content"
            r11.<init>((java.lang.String) r12)     // Catch:{ all -> 0x008f }
            throw r11     // Catch:{ all -> 0x008f }
        L_0x0099:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r11, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.ShareInternalUtility.removeNamespacesFromOGJsonObject(org.json.JSONObject, boolean):org.json.JSONObject");
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        String str2;
        int i;
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || str.length() <= (i = indexOf + 1)) {
                str2 = null;
            } else {
                str2 = str.substring(0, indexOf);
                str = str.substring(i);
            }
            return new Pair<>(str2, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (shareMedia instanceof SharePhoto) {
                SharePhoto sharePhoto = (SharePhoto) shareMedia;
                bitmap = sharePhoto.getBitmap();
                uri = sharePhoto.getImageUrl();
            } else if (shareMedia instanceof ShareVideo) {
                uri = ((ShareVideo) shareMedia).getLocalUrl();
                bitmap = null;
            } else {
                uri = null;
                bitmap = null;
            }
            return getAttachment(uuid, uri, bitmap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        if (bitmap != null) {
            try {
                return NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        } else if (uri != null) {
            return NativeAppCallAttachmentStore.createAttachment(uuid, uri);
        } else {
            return null;
        }
    }

    static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, (String) null);
                if (facebookCallback != null) {
                    facebookCallback.onCancel();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, (String) null);
                if (facebookCallback != null) {
                    facebookCallback.onSuccess(new Sharer.Result(str));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                logShareResult("error", str);
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                logShareResult("error", str);
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookException(str));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                logShareResult("error", facebookException.getMessage());
                if (facebookCallback != null) {
                    facebookCallback.onError(facebookException);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void logShareResult(String str, String str2) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
                Bundle bundle = new Bundle();
                bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
                if (str2 != null) {
                    bundle.putString("error_message", str2);
                }
                internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", bitmap);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("file", parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            if (Utility.isFileUri(uri)) {
                return newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
            }
            if (Utility.isContentUri(uri)) {
                GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("file", parcelableResourceWithMimeType);
                return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
            }
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        if (objectType == objectType2) {
            return objectType;
        }
        try {
            if (objectType == LikeView.ObjectType.UNKNOWN) {
                return objectType2;
            }
            if (objectType2 == LikeView.ObjectType.UNKNOWN) {
                return objectType;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static Bundle getStickerUrl(ShareStoryContent shareStoryContent, final UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && shareStoryContent != null) {
            try {
                if (shareStoryContent.getStickerAsset() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.getStickerAsset());
                    List map = Utility.map(arrayList, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() {
                        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                            return ShareInternalUtility.access$000(uuid, sharePhoto);
                        }
                    });
                    List map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle>() {
                        public Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
                            Bundle bundle = new Bundle();
                            bundle.putString("uri", attachment.getAttachmentUrl());
                            String uriExtension = ShareInternalUtility.getUriExtension(attachment.getOriginalUri());
                            if (uriExtension != null) {
                                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                            }
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(map);
                    return (Bundle) map2.get(0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, final UUID uuid) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (!CrashShieldHandler.isObjectCrashing(cls) && shareStoryContent != null) {
            try {
                if (shareStoryContent.getBackgroundAsset() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.getBackgroundAsset());
                    final ArrayList arrayList2 = new ArrayList();
                    List map = Utility.map(arrayList, new Utility.Mapper<ShareMedia, Bundle>() {
                        public Bundle apply(ShareMedia shareMedia) {
                            NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                            arrayList2.add(access$000);
                            Bundle bundle = new Bundle();
                            bundle.putString("type", shareMedia.getMediaType().name());
                            bundle.putString("uri", access$000.getAttachmentUrl());
                            String uriExtension = ShareInternalUtility.getUriExtension(access$000.getOriginalUri());
                            if (uriExtension != null) {
                                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                            }
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(arrayList2);
                    return (Bundle) map.get(0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        return null;
    }

    public static String getUriExtension(Uri uri) {
        Class<ShareInternalUtility> cls = ShareInternalUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || uri == null) {
            return null;
        }
        try {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return null;
            }
            return uri2.substring(lastIndexOf);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }
}
