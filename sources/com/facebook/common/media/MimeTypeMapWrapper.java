package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import coil.util.Utils;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

public class MimeTypeMapWrapper {
    private static final Map<String, String> sExtensionToMimeTypeMap = ImmutableMap.of("heif", Utils.MIME_TYPE_HEIF, "heic", Utils.MIME_TYPE_HEIC);
    private static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();
    private static final Map<String, String> sMimeTypeToExtensionMap = ImmutableMap.of(Utils.MIME_TYPE_HEIF, "heif", Utils.MIME_TYPE_HEIC, "heic");

    public static String getExtensionFromMimeType(String str) {
        String str2 = sMimeTypeToExtensionMap.get(str);
        if (str2 != null) {
            return str2;
        }
        return sMimeTypeMap.getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        String str2 = sExtensionToMimeTypeMap.get(str);
        if (str2 != null) {
            return str2;
        }
        return sMimeTypeMap.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(String str) {
        return sExtensionToMimeTypeMap.containsKey(str) || sMimeTypeMap.hasExtension(str);
    }

    public static boolean hasMimeType(String str) {
        return sMimeTypeToExtensionMap.containsKey(str) || sMimeTypeMap.hasMimeType(str);
    }
}
