package com.loopj.android.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams implements Serializable {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected String elapsedFieldInJsonStreamer;
    protected final ConcurrentHashMap<String, List<FileWrapper>> fileArrayParams;
    protected final ConcurrentHashMap<String, FileWrapper> fileParams;
    protected boolean forceMultipartEntity;
    protected boolean isRepeatable;
    protected final ConcurrentHashMap<String, StreamWrapper> streamParams;
    protected final ConcurrentHashMap<String, String> urlParams;
    protected final ConcurrentHashMap<String, Object> urlParamsWithObjects;
    protected boolean useJsonStreamer;

    public void setContentEncoding(String str) {
        if (str != null) {
            this.contentEncoding = str;
        } else {
            AsyncHttpClient.log.d(LOG_TAG, "setContentEncoding called with null attribute");
        }
    }

    public void setForceMultipartEntityContentType(boolean z) {
        this.forceMultipartEntity = z;
    }

    public RequestParams() {
        this((Map<String, String>) null);
    }

    public RequestParams(Map<String, String> map) {
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap<>();
        this.streamParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.fileArrayParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        this.contentEncoding = "UTF-8";
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public RequestParams(final String str, final String str2) {
        this((Map<String, String>) new HashMap<String, String>() {
            {
                put(str, str2);
            }
        });
    }

    public RequestParams(Object... objArr) {
        this.forceMultipartEntity = false;
        this.elapsedFieldInJsonStreamer = "_elapsed";
        this.urlParams = new ConcurrentHashMap<>();
        this.streamParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.fileArrayParams = new ConcurrentHashMap<>();
        this.urlParamsWithObjects = new ConcurrentHashMap<>();
        this.contentEncoding = "UTF-8";
        int length = objArr.length;
        if (length % 2 == 0) {
            for (int i = 0; i < length; i += 2) {
                put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
            }
            return;
        }
        throw new IllegalArgumentException("Supplied arguments must be even");
    }

    public void put(String str, String str2) {
        if (str != null && str2 != null) {
            this.urlParams.put(str, str2);
        }
    }

    public void put(String str, File[] fileArr) throws FileNotFoundException {
        put(str, fileArr, (String) null, (String) null);
    }

    public void put(String str, File[] fileArr, String str2, String str3) throws FileNotFoundException {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (File file : fileArr) {
                if (file == null || !file.exists()) {
                    throw new FileNotFoundException();
                }
                arrayList.add(new FileWrapper(file, str2, str3));
            }
            this.fileArrayParams.put(str, arrayList);
        }
    }

    public void put(String str, File file) throws FileNotFoundException {
        put(str, file, (String) null, (String) null);
    }

    public void put(String str, String str2, File file) throws FileNotFoundException {
        put(str, file, (String) null, str2);
    }

    public void put(String str, File file, String str2) throws FileNotFoundException {
        put(str, file, str2, (String) null);
    }

    public void put(String str, File file, String str2, String str3) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new FileNotFoundException();
        } else if (str != null) {
            this.fileParams.put(str, new FileWrapper(file, str2, str3));
        }
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, (String) null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        put(str, inputStream, str2, (String) null);
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        put(str, inputStream, str2, str3, this.autoCloseInputStreams);
    }

    public void put(String str, InputStream inputStream, String str2, String str3, boolean z) {
        if (str != null && inputStream != null) {
            this.streamParams.put(str, StreamWrapper.newInstance(inputStream, str2, str3, z));
        }
    }

    public void put(String str, Object obj) {
        if (str != null && obj != null) {
            this.urlParamsWithObjects.put(str, obj);
        }
    }

    public void put(String str, int i) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(i));
        }
    }

    public void put(String str, long j) {
        if (str != null) {
            this.urlParams.put(str, String.valueOf(j));
        }
    }

    public void add(String str, String str2) {
        if (str != null && str2 != null) {
            Object obj = this.urlParamsWithObjects.get(str);
            if (obj == null) {
                obj = new HashSet();
                put(str, obj);
            }
            if (obj instanceof List) {
                ((List) obj).add(str2);
            } else if (obj instanceof Set) {
                ((Set) obj).add(str2);
            }
        }
    }

    public void remove(String str) {
        this.urlParams.remove(str);
        this.streamParams.remove(str);
        this.fileParams.remove(str);
        this.urlParamsWithObjects.remove(str);
        this.fileArrayParams.remove(str);
    }

    public boolean has(String str) {
        return (this.urlParams.get(str) == null && this.streamParams.get(str) == null && this.fileParams.get(str) == null && this.urlParamsWithObjects.get(str) == null && this.fileArrayParams.get(str) == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : this.urlParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
        }
        for (Map.Entry next2 : this.streamParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) next2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry next3 : this.fileParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) next3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry next4 : this.fileArrayParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) next4.getKey());
            sb.append("=");
            sb.append("FILES(SIZE=");
            sb.append(((List) next4.getValue()).size());
            sb.append(")");
        }
        for (BasicNameValuePair next5 : getParamsList((String) null, this.urlParamsWithObjects)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next5.getName());
            sb.append("=");
            sb.append(next5.getValue());
        }
        return sb.toString();
    }

    public void setHttpEntityIsRepeatable(boolean z) {
        this.isRepeatable = z;
    }

    public void setUseJsonStreamer(boolean z) {
        this.useJsonStreamer = z;
    }

    public void setElapsedFieldInJsonStreamer(String str) {
        this.elapsedFieldInJsonStreamer = str;
    }

    public void setAutoCloseInputStreams(boolean z) {
        this.autoCloseInputStreams = z;
    }

    public HttpEntity getEntity(ResponseHandlerInterface responseHandlerInterface) throws IOException {
        if (this.useJsonStreamer) {
            return createJsonStreamerEntity(responseHandlerInterface);
        }
        if (this.forceMultipartEntity || !this.streamParams.isEmpty() || !this.fileParams.isEmpty() || !this.fileArrayParams.isEmpty()) {
            return createMultipartEntity(responseHandlerInterface);
        }
        return createFormEntity();
    }

    private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface) throws IOException {
        JsonStreamerEntity jsonStreamerEntity = new JsonStreamerEntity(responseHandlerInterface, !this.fileParams.isEmpty() || !this.streamParams.isEmpty(), this.elapsedFieldInJsonStreamer);
        for (Map.Entry next : this.urlParams.entrySet()) {
            jsonStreamerEntity.addPart((String) next.getKey(), next.getValue());
        }
        for (Map.Entry next2 : this.urlParamsWithObjects.entrySet()) {
            jsonStreamerEntity.addPart((String) next2.getKey(), next2.getValue());
        }
        for (Map.Entry next3 : this.fileParams.entrySet()) {
            jsonStreamerEntity.addPart((String) next3.getKey(), next3.getValue());
        }
        for (Map.Entry next4 : this.streamParams.entrySet()) {
            StreamWrapper streamWrapper = (StreamWrapper) next4.getValue();
            if (streamWrapper.inputStream != null) {
                jsonStreamerEntity.addPart((String) next4.getKey(), StreamWrapper.newInstance(streamWrapper.inputStream, streamWrapper.name, streamWrapper.contentType, streamWrapper.autoClose));
            }
        }
        return jsonStreamerEntity;
    }

    private HttpEntity createFormEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
        } catch (UnsupportedEncodingException e) {
            AsyncHttpClient.log.e(LOG_TAG, "createFormEntity failed", e);
            return null;
        }
    }

    private HttpEntity createMultipartEntity(ResponseHandlerInterface responseHandlerInterface) throws IOException {
        SimpleMultipartEntity simpleMultipartEntity = new SimpleMultipartEntity(responseHandlerInterface);
        simpleMultipartEntity.setIsRepeatable(this.isRepeatable);
        for (Map.Entry next : this.urlParams.entrySet()) {
            simpleMultipartEntity.addPartWithCharset((String) next.getKey(), (String) next.getValue(), this.contentEncoding);
        }
        for (BasicNameValuePair next2 : getParamsList((String) null, this.urlParamsWithObjects)) {
            simpleMultipartEntity.addPartWithCharset(next2.getName(), next2.getValue(), this.contentEncoding);
        }
        for (Map.Entry next3 : this.streamParams.entrySet()) {
            StreamWrapper streamWrapper = (StreamWrapper) next3.getValue();
            if (streamWrapper.inputStream != null) {
                simpleMultipartEntity.addPart((String) next3.getKey(), streamWrapper.name, streamWrapper.inputStream, streamWrapper.contentType);
            }
        }
        for (Map.Entry next4 : this.fileParams.entrySet()) {
            FileWrapper fileWrapper = (FileWrapper) next4.getValue();
            simpleMultipartEntity.addPart((String) next4.getKey(), fileWrapper.file, fileWrapper.contentType, fileWrapper.customFileName);
        }
        for (Map.Entry next5 : this.fileArrayParams.entrySet()) {
            for (FileWrapper fileWrapper2 : (List) next5.getValue()) {
                simpleMultipartEntity.addPart((String) next5.getKey(), fileWrapper2.file, fileWrapper2.contentType, fileWrapper2.customFileName);
            }
        }
        return simpleMultipartEntity;
    }

    /* access modifiers changed from: protected */
    public List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry next : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) next.getKey(), (String) next.getValue()));
        }
        linkedList.addAll(getParamsList((String) null, this.urlParamsWithObjects));
        return linkedList;
    }

    private List<BasicNameValuePair> getParamsList(String str, Object obj) {
        Object obj2;
        String str2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object next : arrayList) {
                if ((next instanceof String) && (obj2 = map.get(next)) != null) {
                    if (str == null) {
                        str2 = (String) next;
                    } else {
                        str2 = String.format(Locale.US, "%s[%s]", new Object[]{str, next});
                    }
                    linkedList.addAll(getParamsList(str2, obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{str, Integer.valueOf(i)}), list.get(i)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.addAll(getParamsList(String.format(Locale.US, "%s[%d]", new Object[]{str, Integer.valueOf(i2)}), objArr[i2]));
            }
        } else if (obj instanceof Set) {
            for (Object paramsList : (Set) obj) {
                linkedList.addAll(getParamsList(str, paramsList));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    /* access modifiers changed from: protected */
    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
    }

    public static class FileWrapper implements Serializable {
        public final String contentType;
        public final String customFileName;
        public final File file;

        public FileWrapper(File file2, String str, String str2) {
            this.file = file2;
            this.contentType = str;
            this.customFileName = str2;
        }
    }

    public static class StreamWrapper {
        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        public StreamWrapper(InputStream inputStream2, String str, String str2, boolean z) {
            this.inputStream = inputStream2;
            this.name = str;
            this.contentType = str2;
            this.autoClose = z;
        }

        static StreamWrapper newInstance(InputStream inputStream2, String str, String str2, boolean z) {
            if (str2 == null) {
                str2 = "application/octet-stream";
            }
            return new StreamWrapper(inputStream2, str, str2, z);
        }
    }
}
