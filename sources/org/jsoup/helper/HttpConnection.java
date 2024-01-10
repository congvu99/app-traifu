package org.jsoup.helper;

import com.google.common.net.HttpHeaders;
import com.loopj.android.http.AsyncHttpClient;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Typography;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.parser.TokenQueue;

public class HttpConnection implements Connection {
    public static final String CONTENT_ENCODING = "Content-Encoding";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private Connection.Request req = new Request();
    private Connection.Response res = new Response();

    public static Connection connect(String str) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(str);
        return httpConnection;
    }

    public static Connection connect(URL url) {
        HttpConnection httpConnection = new HttpConnection();
        httpConnection.url(url);
        return httpConnection;
    }

    /* access modifiers changed from: private */
    public static String encodeUrl(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(" ", "%20");
    }

    /* access modifiers changed from: private */
    public static String encodeMimeName(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\"", "%22");
    }

    private HttpConnection() {
    }

    public Connection url(URL url) {
        this.req.url(url);
        return this;
    }

    public Connection url(String str) {
        Validate.notEmpty(str, "Must supply a valid URL");
        try {
            this.req.url(new URL(encodeUrl(str)));
            return this;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Malformed URL: " + str, e);
        }
    }

    public Connection userAgent(String str) {
        Validate.notNull(str, "User agent must not be null");
        this.req.header("User-Agent", str);
        return this;
    }

    public Connection timeout(int i) {
        this.req.timeout(i);
        return this;
    }

    public Connection maxBodySize(int i) {
        this.req.maxBodySize(i);
        return this;
    }

    public Connection followRedirects(boolean z) {
        this.req.followRedirects(z);
        return this;
    }

    public Connection referrer(String str) {
        Validate.notNull(str, "Referrer must not be null");
        this.req.header("Referer", str);
        return this;
    }

    public Connection method(Connection.Method method) {
        this.req.method(method);
        return this;
    }

    public Connection ignoreHttpErrors(boolean z) {
        this.req.ignoreHttpErrors(z);
        return this;
    }

    public Connection ignoreContentType(boolean z) {
        this.req.ignoreContentType(z);
        return this;
    }

    public Connection validateTLSCertificates(boolean z) {
        this.req.validateTLSCertificates(z);
        return this;
    }

    public Connection data(String str, String str2) {
        this.req.data(KeyVal.create(str, str2));
        return this;
    }

    public Connection data(String str, String str2, InputStream inputStream) {
        this.req.data(KeyVal.create(str, str2, inputStream));
        return this;
    }

    public Connection data(Map<String, String> map) {
        Validate.notNull(map, "Data map must not be null");
        for (Map.Entry next : map.entrySet()) {
            this.req.data(KeyVal.create((String) next.getKey(), (String) next.getValue()));
        }
        return this;
    }

    public Connection data(String... strArr) {
        Validate.notNull(strArr, "Data key value pairs must not be null");
        Validate.isTrue(strArr.length % 2 == 0, "Must supply an even number of key value pairs");
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            Validate.notEmpty(str, "Data key must not be empty");
            Validate.notNull(str2, "Data value must not be null");
            this.req.data(KeyVal.create(str, str2));
        }
        return this;
    }

    public Connection data(Collection<Connection.KeyVal> collection) {
        Validate.notNull(collection, "Data collection must not be null");
        for (Connection.KeyVal data : collection) {
            this.req.data(data);
        }
        return this;
    }

    public Connection header(String str, String str2) {
        this.req.header(str, str2);
        return this;
    }

    public Connection cookie(String str, String str2) {
        this.req.cookie(str, str2);
        return this;
    }

    public Connection cookies(Map<String, String> map) {
        Validate.notNull(map, "Cookie map must not be null");
        for (Map.Entry next : map.entrySet()) {
            this.req.cookie((String) next.getKey(), (String) next.getValue());
        }
        return this;
    }

    public Connection parser(Parser parser) {
        this.req.parser(parser);
        return this;
    }

    public Document get() throws IOException {
        this.req.method(Connection.Method.GET);
        execute();
        return this.res.parse();
    }

    public Document post() throws IOException {
        this.req.method(Connection.Method.POST);
        execute();
        return this.res.parse();
    }

    public Connection.Response execute() throws IOException {
        Response execute = Response.execute(this.req);
        this.res = execute;
        return execute;
    }

    public Connection.Request request() {
        return this.req;
    }

    public Connection request(Connection.Request request) {
        this.req = request;
        return this;
    }

    public Connection.Response response() {
        return this.res;
    }

    public Connection response(Connection.Response response) {
        this.res = response;
        return this;
    }

    public Connection postDataCharset(String str) {
        this.req.postDataCharset(str);
        return this;
    }

    private static abstract class Base<T extends Connection.Base> implements Connection.Base<T> {
        Map<String, String> cookies;
        Map<String, String> headers;
        Connection.Method method;
        URL url;

        private Base() {
            this.headers = new LinkedHashMap();
            this.cookies = new LinkedHashMap();
        }

        public URL url() {
            return this.url;
        }

        public T url(URL url2) {
            Validate.notNull(url2, "URL must not be null");
            this.url = url2;
            return this;
        }

        public Connection.Method method() {
            return this.method;
        }

        public T method(Connection.Method method2) {
            Validate.notNull(method2, "Method must not be null");
            this.method = method2;
            return this;
        }

        public String header(String str) {
            Validate.notNull(str, "Header name must not be null");
            return getHeaderCaseInsensitive(str);
        }

        public T header(String str, String str2) {
            Validate.notEmpty(str, "Header name must not be empty");
            Validate.notNull(str2, "Header value must not be null");
            removeHeader(str);
            this.headers.put(str, str2);
            return this;
        }

        public boolean hasHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            return getHeaderCaseInsensitive(str) != null;
        }

        public boolean hasHeaderWithValue(String str, String str2) {
            return hasHeader(str) && header(str).equalsIgnoreCase(str2);
        }

        public T removeHeader(String str) {
            Validate.notEmpty(str, "Header name must not be empty");
            Map.Entry<String, String> scanHeaders = scanHeaders(str);
            if (scanHeaders != null) {
                this.headers.remove(scanHeaders.getKey());
            }
            return this;
        }

        public Map<String, String> headers() {
            return this.headers;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001d, code lost:
            r3 = scanHeaders(r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String getHeaderCaseInsensitive(java.lang.String r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Header name must not be null"
                org.jsoup.helper.Validate.notNull(r3, r0)
                java.util.Map<java.lang.String, java.lang.String> r0 = r2.headers
                java.lang.Object r0 = r0.get(r3)
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto L_0x001b
                java.util.Map<java.lang.String, java.lang.String> r0 = r2.headers
                java.lang.String r1 = r3.toLowerCase()
                java.lang.Object r0 = r0.get(r1)
                java.lang.String r0 = (java.lang.String) r0
            L_0x001b:
                if (r0 != 0) goto L_0x002a
                java.util.Map$Entry r3 = r2.scanHeaders(r3)
                if (r3 == 0) goto L_0x002a
                java.lang.Object r3 = r3.getValue()
                r0 = r3
                java.lang.String r0 = (java.lang.String) r0
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Base.getHeaderCaseInsensitive(java.lang.String):java.lang.String");
        }

        private Map.Entry<String, String> scanHeaders(String str) {
            String lowerCase = str.toLowerCase();
            for (Map.Entry<String, String> next : this.headers.entrySet()) {
                if (next.getKey().toLowerCase().equals(lowerCase)) {
                    return next;
                }
            }
            return null;
        }

        public String cookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.get(str);
        }

        public T cookie(String str, String str2) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            Validate.notNull(str2, "Cookie value must not be null");
            this.cookies.put(str, str2);
            return this;
        }

        public boolean hasCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            return this.cookies.containsKey(str);
        }

        public T removeCookie(String str) {
            Validate.notEmpty(str, "Cookie name must not be empty");
            this.cookies.remove(str);
            return this;
        }

        public Map<String, String> cookies() {
            return this.cookies;
        }
    }

    public static class Request extends Base<Connection.Request> implements Connection.Request {
        private Collection<Connection.KeyVal> data;
        private boolean followRedirects;
        private boolean ignoreContentType;
        private boolean ignoreHttpErrors;
        private int maxBodySizeBytes;
        private Parser parser;
        /* access modifiers changed from: private */
        public boolean parserDefined;
        private String postDataCharset;
        private int timeoutMilliseconds;
        private boolean validateTSLCertificates;

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        private Request() {
            super();
            this.ignoreHttpErrors = false;
            this.ignoreContentType = false;
            this.parserDefined = false;
            this.validateTSLCertificates = true;
            this.postDataCharset = "UTF-8";
            this.timeoutMilliseconds = 3000;
            this.maxBodySizeBytes = 1048576;
            this.followRedirects = true;
            this.data = new ArrayList();
            this.method = Connection.Method.GET;
            this.headers.put("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            this.parser = Parser.htmlParser();
        }

        public int timeout() {
            return this.timeoutMilliseconds;
        }

        public Request timeout(int i) {
            Validate.isTrue(i >= 0, "Timeout milliseconds must be 0 (infinite) or greater");
            this.timeoutMilliseconds = i;
            return this;
        }

        public int maxBodySize() {
            return this.maxBodySizeBytes;
        }

        public Connection.Request maxBodySize(int i) {
            Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
            this.maxBodySizeBytes = i;
            return this;
        }

        public boolean followRedirects() {
            return this.followRedirects;
        }

        public Connection.Request followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public boolean ignoreHttpErrors() {
            return this.ignoreHttpErrors;
        }

        public boolean validateTLSCertificates() {
            return this.validateTSLCertificates;
        }

        public void validateTLSCertificates(boolean z) {
            this.validateTSLCertificates = z;
        }

        public Connection.Request ignoreHttpErrors(boolean z) {
            this.ignoreHttpErrors = z;
            return this;
        }

        public boolean ignoreContentType() {
            return this.ignoreContentType;
        }

        public Connection.Request ignoreContentType(boolean z) {
            this.ignoreContentType = z;
            return this;
        }

        public Request data(Connection.KeyVal keyVal) {
            Validate.notNull(keyVal, "Key val must not be null");
            this.data.add(keyVal);
            return this;
        }

        public Collection<Connection.KeyVal> data() {
            return this.data;
        }

        public Request parser(Parser parser2) {
            this.parser = parser2;
            this.parserDefined = true;
            return this;
        }

        public Parser parser() {
            return this.parser;
        }

        public Connection.Request postDataCharset(String str) {
            Validate.notNull(str, "Charset must not be null");
            if (Charset.isSupported(str)) {
                this.postDataCharset = str;
                return this;
            }
            throw new IllegalCharsetNameException(str);
        }

        public String postDataCharset() {
            return this.postDataCharset;
        }
    }

    public static class Response extends Base<Connection.Response> implements Connection.Response {
        private static final String LOCATION = "Location";
        private static final int MAX_REDIRECTS = 20;
        private static SSLSocketFactory sslSocketFactory;
        private static final Pattern xmlContentTypeRxp = Pattern.compile("(application|text)/\\w*\\+?xml.*");
        private ByteBuffer byteData;
        private String charset;
        private String contentType;
        private boolean executed = false;
        private int numRedirects = 0;
        private Connection.Request req;
        private int statusCode;
        private String statusMessage;

        public /* bridge */ /* synthetic */ String cookie(String str) {
            return super.cookie(str);
        }

        public /* bridge */ /* synthetic */ Map cookies() {
            return super.cookies();
        }

        public /* bridge */ /* synthetic */ boolean hasCookie(String str) {
            return super.hasCookie(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeader(String str) {
            return super.hasHeader(str);
        }

        public /* bridge */ /* synthetic */ boolean hasHeaderWithValue(String str, String str2) {
            return super.hasHeaderWithValue(str, str2);
        }

        public /* bridge */ /* synthetic */ String header(String str) {
            return super.header(str);
        }

        public /* bridge */ /* synthetic */ Map headers() {
            return super.headers();
        }

        public /* bridge */ /* synthetic */ Connection.Method method() {
            return super.method();
        }

        public /* bridge */ /* synthetic */ URL url() {
            return super.url();
        }

        Response() {
            super();
        }

        private Response(Response response) throws IOException {
            super();
            if (response != null) {
                int i = response.numRedirects + 1;
                this.numRedirects = i;
                if (i >= 20) {
                    throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[]{response.url()}));
                }
            }
        }

        static Response execute(Connection.Request request) throws IOException {
            return execute(request, (Response) null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A[Catch:{ all -> 0x018f, all -> 0x01bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[Catch:{ all -> 0x018f, all -> 0x01bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00e3  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0195 A[Catch:{ all -> 0x018f, all -> 0x01bb }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x019a A[Catch:{ all -> 0x018f, all -> 0x01bb }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static org.jsoup.helper.HttpConnection.Response execute(org.jsoup.Connection.Request r5, org.jsoup.helper.HttpConnection.Response r6) throws java.io.IOException {
            /*
                java.lang.String r0 = "Location"
                java.lang.String r1 = "Request must not be null"
                org.jsoup.helper.Validate.notNull(r5, r1)
                java.net.URL r1 = r5.url()
                java.lang.String r1 = r1.getProtocol()
                java.lang.String r2 = "http"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0028
                java.lang.String r2 = "https"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x0020
                goto L_0x0028
            L_0x0020:
                java.net.MalformedURLException r5 = new java.net.MalformedURLException
                java.lang.String r6 = "Only http & https protocols supported"
                r5.<init>(r6)
                throw r5
            L_0x0028:
                org.jsoup.Connection$Method r1 = r5.method()
                boolean r1 = r1.hasBody()
                r2 = 0
                if (r1 != 0) goto L_0x0041
                java.util.Collection r1 = r5.data()
                int r1 = r1.size()
                if (r1 <= 0) goto L_0x0041
                serialiseRequestUrl(r5)
                goto L_0x0050
            L_0x0041:
                org.jsoup.Connection$Method r1 = r5.method()
                boolean r1 = r1.hasBody()
                if (r1 == 0) goto L_0x0050
                java.lang.String r1 = setOutputContentType(r5)
                goto L_0x0051
            L_0x0050:
                r1 = r2
            L_0x0051:
                java.net.HttpURLConnection r3 = createConnection(r5)
                r3.connect()     // Catch:{ all -> 0x01bb }
                boolean r4 = r3.getDoOutput()     // Catch:{ all -> 0x01bb }
                if (r4 == 0) goto L_0x0065
                java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ all -> 0x01bb }
                writePost(r5, r4, r1)     // Catch:{ all -> 0x01bb }
            L_0x0065:
                int r1 = r3.getResponseCode()     // Catch:{ all -> 0x01bb }
                org.jsoup.helper.HttpConnection$Response r4 = new org.jsoup.helper.HttpConnection$Response     // Catch:{ all -> 0x01bb }
                r4.<init>(r6)     // Catch:{ all -> 0x01bb }
                r4.setupFromConnection(r3, r6)     // Catch:{ all -> 0x01bb }
                r4.req = r5     // Catch:{ all -> 0x01bb }
                boolean r6 = r4.hasHeader(r0)     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x00e3
                boolean r6 = r5.followRedirects()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x00e3
                org.jsoup.Connection$Method r6 = org.jsoup.Connection.Method.GET     // Catch:{ all -> 0x01bb }
                r5.method(r6)     // Catch:{ all -> 0x01bb }
                java.util.Collection r6 = r5.data()     // Catch:{ all -> 0x01bb }
                r6.clear()     // Catch:{ all -> 0x01bb }
                java.lang.String r6 = r4.header(r0)     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x00a6
                java.lang.String r0 = "http:/"
                boolean r0 = r6.startsWith(r0)     // Catch:{ all -> 0x01bb }
                if (r0 == 0) goto L_0x00a6
                r0 = 6
                char r1 = r6.charAt(r0)     // Catch:{ all -> 0x01bb }
                r2 = 47
                if (r1 == r2) goto L_0x00a6
                java.lang.String r6 = r6.substring(r0)     // Catch:{ all -> 0x01bb }
            L_0x00a6:
                java.net.URL r0 = r5.url()     // Catch:{ all -> 0x01bb }
                java.lang.String r6 = org.jsoup.helper.HttpConnection.encodeUrl(r6)     // Catch:{ all -> 0x01bb }
                java.net.URL r6 = org.jsoup.helper.StringUtil.resolve((java.net.URL) r0, (java.lang.String) r6)     // Catch:{ all -> 0x01bb }
                r5.url(r6)     // Catch:{ all -> 0x01bb }
                java.util.Map r6 = r4.cookies     // Catch:{ all -> 0x01bb }
                java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x01bb }
                java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x01bb }
            L_0x00bf:
                boolean r0 = r6.hasNext()     // Catch:{ all -> 0x01bb }
                if (r0 == 0) goto L_0x00db
                java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x01bb }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x01bb }
                java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x01bb }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01bb }
                java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x01bb }
                java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x01bb }
                r5.cookie(r1, r0)     // Catch:{ all -> 0x01bb }
                goto L_0x00bf
            L_0x00db:
                org.jsoup.helper.HttpConnection$Response r5 = execute(r5, r4)     // Catch:{ all -> 0x01bb }
                r3.disconnect()
                return r5
            L_0x00e3:
                r6 = 200(0xc8, float:2.8E-43)
                if (r1 < r6) goto L_0x00eb
                r6 = 400(0x190, float:5.6E-43)
                if (r1 < r6) goto L_0x00f1
            L_0x00eb:
                boolean r6 = r5.ignoreHttpErrors()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x01ab
            L_0x00f1:
                java.lang.String r6 = r4.contentType()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x0122
                boolean r0 = r5.ignoreContentType()     // Catch:{ all -> 0x01bb }
                if (r0 != 0) goto L_0x0122
                java.lang.String r0 = "text/"
                boolean r0 = r6.startsWith(r0)     // Catch:{ all -> 0x01bb }
                if (r0 != 0) goto L_0x0122
                java.util.regex.Pattern r0 = xmlContentTypeRxp     // Catch:{ all -> 0x01bb }
                java.util.regex.Matcher r0 = r0.matcher(r6)     // Catch:{ all -> 0x01bb }
                boolean r0 = r0.matches()     // Catch:{ all -> 0x01bb }
                if (r0 == 0) goto L_0x0112
                goto L_0x0122
            L_0x0112:
                org.jsoup.UnsupportedMimeTypeException r0 = new org.jsoup.UnsupportedMimeTypeException     // Catch:{ all -> 0x01bb }
                java.lang.String r1 = "Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml"
                java.net.URL r5 = r5.url()     // Catch:{ all -> 0x01bb }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01bb }
                r0.<init>(r1, r6, r5)     // Catch:{ all -> 0x01bb }
                throw r0     // Catch:{ all -> 0x01bb }
            L_0x0122:
                if (r6 == 0) goto L_0x0144
                java.util.regex.Pattern r0 = xmlContentTypeRxp     // Catch:{ all -> 0x01bb }
                java.util.regex.Matcher r6 = r0.matcher(r6)     // Catch:{ all -> 0x01bb }
                boolean r6 = r6.matches()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x0144
                boolean r6 = r5 instanceof org.jsoup.helper.HttpConnection.Request     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x0144
                r6 = r5
                org.jsoup.helper.HttpConnection$Request r6 = (org.jsoup.helper.HttpConnection.Request) r6     // Catch:{ all -> 0x01bb }
                boolean r6 = r6.parserDefined     // Catch:{ all -> 0x01bb }
                if (r6 != 0) goto L_0x0144
                org.jsoup.parser.Parser r6 = org.jsoup.parser.Parser.xmlParser()     // Catch:{ all -> 0x01bb }
                r5.parser(r6)     // Catch:{ all -> 0x01bb }
            L_0x0144:
                java.lang.String r6 = r4.contentType     // Catch:{ all -> 0x01bb }
                java.lang.String r6 = org.jsoup.helper.DataUtil.getCharsetFromContentType(r6)     // Catch:{ all -> 0x01bb }
                r4.charset = r6     // Catch:{ all -> 0x01bb }
                int r6 = r3.getContentLength()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x019e
                java.io.InputStream r6 = r3.getErrorStream()     // Catch:{ all -> 0x0191 }
                if (r6 == 0) goto L_0x015d
                java.io.InputStream r6 = r3.getErrorStream()     // Catch:{ all -> 0x0191 }
                goto L_0x0161
            L_0x015d:
                java.io.InputStream r6 = r3.getInputStream()     // Catch:{ all -> 0x0191 }
            L_0x0161:
                java.lang.String r0 = "Content-Encoding"
                java.lang.String r1 = "gzip"
                boolean r0 = r4.hasHeaderWithValue(r0, r1)     // Catch:{ all -> 0x018f }
                if (r0 == 0) goto L_0x0176
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x018f }
                java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x018f }
                r1.<init>(r6)     // Catch:{ all -> 0x018f }
                r0.<init>(r1)     // Catch:{ all -> 0x018f }
                goto L_0x017b
            L_0x0176:
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ all -> 0x018f }
                r0.<init>(r6)     // Catch:{ all -> 0x018f }
            L_0x017b:
                r2 = r0
                int r5 = r5.maxBodySize()     // Catch:{ all -> 0x018f }
                java.nio.ByteBuffer r5 = org.jsoup.helper.DataUtil.readToByteBuffer(r2, r5)     // Catch:{ all -> 0x018f }
                r4.byteData = r5     // Catch:{ all -> 0x018f }
                r2.close()     // Catch:{ all -> 0x01bb }
                if (r6 == 0) goto L_0x01a4
                r6.close()     // Catch:{ all -> 0x01bb }
                goto L_0x01a4
            L_0x018f:
                r5 = move-exception
                goto L_0x0193
            L_0x0191:
                r5 = move-exception
                r6 = r2
            L_0x0193:
                if (r2 == 0) goto L_0x0198
                r2.close()     // Catch:{ all -> 0x01bb }
            L_0x0198:
                if (r6 == 0) goto L_0x019d
                r6.close()     // Catch:{ all -> 0x01bb }
            L_0x019d:
                throw r5     // Catch:{ all -> 0x01bb }
            L_0x019e:
                java.nio.ByteBuffer r5 = org.jsoup.helper.DataUtil.emptyByteBuffer()     // Catch:{ all -> 0x01bb }
                r4.byteData = r5     // Catch:{ all -> 0x01bb }
            L_0x01a4:
                r3.disconnect()
                r5 = 1
                r4.executed = r5
                return r4
            L_0x01ab:
                org.jsoup.HttpStatusException r6 = new org.jsoup.HttpStatusException     // Catch:{ all -> 0x01bb }
                java.lang.String r0 = "HTTP error fetching URL"
                java.net.URL r5 = r5.url()     // Catch:{ all -> 0x01bb }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01bb }
                r6.<init>(r0, r1, r5)     // Catch:{ all -> 0x01bb }
                throw r6     // Catch:{ all -> 0x01bb }
            L_0x01bb:
                r5 = move-exception
                r3.disconnect()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.execute(org.jsoup.Connection$Request, org.jsoup.helper.HttpConnection$Response):org.jsoup.helper.HttpConnection$Response");
        }

        public int statusCode() {
            return this.statusCode;
        }

        public String statusMessage() {
            return this.statusMessage;
        }

        public String charset() {
            return this.charset;
        }

        public String contentType() {
            return this.contentType;
        }

        public Document parse() throws IOException {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
            Document parseByteData = DataUtil.parseByteData(this.byteData, this.charset, this.url.toExternalForm(), this.req.parser());
            this.byteData.rewind();
            this.charset = parseByteData.outputSettings().charset().name();
            return parseByteData;
        }

        public String body() {
            String str;
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            String str2 = this.charset;
            if (str2 == null) {
                str = Charset.forName("UTF-8").decode(this.byteData).toString();
            } else {
                str = Charset.forName(str2).decode(this.byteData).toString();
            }
            this.byteData.rewind();
            return str;
        }

        public byte[] bodyAsBytes() {
            Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
            return this.byteData.array();
        }

        private static HttpURLConnection createConnection(Connection.Request request) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) request.url().openConnection();
            httpURLConnection.setRequestMethod(request.method().name());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setConnectTimeout(request.timeout());
            httpURLConnection.setReadTimeout(request.timeout());
            if ((httpURLConnection instanceof HttpsURLConnection) && !request.validateTLSCertificates()) {
                initUnSecureTSL();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                httpsURLConnection.setSSLSocketFactory(sslSocketFactory);
                httpsURLConnection.setHostnameVerifier(getInsecureVerifier());
            }
            if (request.method().hasBody()) {
                httpURLConnection.setDoOutput(true);
            }
            if (request.cookies().size() > 0) {
                httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, getRequestCookieString(request));
            }
            for (Map.Entry next : request.headers().entrySet()) {
                httpURLConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            return httpURLConnection;
        }

        private static HostnameVerifier getInsecureVerifier() {
            return new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static synchronized void initUnSecureTSL() throws java.io.IOException {
            /*
                java.lang.Class<org.jsoup.helper.HttpConnection$Response> r0 = org.jsoup.helper.HttpConnection.Response.class
                monitor-enter(r0)
                javax.net.ssl.SSLSocketFactory r1 = sslSocketFactory     // Catch:{ all -> 0x003a }
                if (r1 != 0) goto L_0x0038
                r1 = 1
                javax.net.ssl.TrustManager[] r1 = new javax.net.ssl.TrustManager[r1]     // Catch:{ all -> 0x003a }
                r2 = 0
                org.jsoup.helper.HttpConnection$Response$2 r3 = new org.jsoup.helper.HttpConnection$Response$2     // Catch:{ all -> 0x003a }
                r3.<init>()     // Catch:{ all -> 0x003a }
                r1[r2] = r3     // Catch:{ all -> 0x003a }
                java.lang.String r2 = "SSL"
                javax.net.ssl.SSLContext r2 = javax.net.ssl.SSLContext.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                r3 = 0
                java.security.SecureRandom r4 = new java.security.SecureRandom     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                r4.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                r2.init(r3, r1, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                javax.net.ssl.SSLSocketFactory r1 = r2.getSocketFactory()     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                sslSocketFactory = r1     // Catch:{ NoSuchAlgorithmException -> 0x0030, KeyManagementException -> 0x0028 }
                goto L_0x0038
            L_0x0028:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x003a }
                java.lang.String r2 = "Can't create unsecure trust manager"
                r1.<init>(r2)     // Catch:{ all -> 0x003a }
                throw r1     // Catch:{ all -> 0x003a }
            L_0x0030:
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x003a }
                java.lang.String r2 = "Can't create unsecure trust manager"
                r1.<init>(r2)     // Catch:{ all -> 0x003a }
                throw r1     // Catch:{ all -> 0x003a }
            L_0x0038:
                monitor-exit(r0)
                return
            L_0x003a:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.HttpConnection.Response.initUnSecureTSL():void");
        }

        private void setupFromConnection(HttpURLConnection httpURLConnection, Connection.Response response) throws IOException {
            this.method = Connection.Method.valueOf(httpURLConnection.getRequestMethod());
            this.url = httpURLConnection.getURL();
            this.statusCode = httpURLConnection.getResponseCode();
            this.statusMessage = httpURLConnection.getResponseMessage();
            this.contentType = httpURLConnection.getContentType();
            processResponseHeaders(httpURLConnection.getHeaderFields());
            if (response != null) {
                for (Map.Entry next : response.cookies().entrySet()) {
                    if (!hasCookie((String) next.getKey())) {
                        cookie((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void processResponseHeaders(Map<String, List<String>> map) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (str != null) {
                    List<String> list = (List) next.getValue();
                    if (str.equalsIgnoreCase(HttpHeaders.SET_COOKIE)) {
                        for (String str2 : list) {
                            if (str2 != null) {
                                TokenQueue tokenQueue = new TokenQueue(str2);
                                String trim = tokenQueue.chompTo("=").trim();
                                String trim2 = tokenQueue.consumeTo(";").trim();
                                if (trim.length() > 0) {
                                    cookie(trim, trim2);
                                }
                            }
                        }
                    } else if (!list.isEmpty()) {
                        header(str, (String) list.get(0));
                    }
                }
            }
        }

        private static String setOutputContentType(Connection.Request request) {
            boolean z;
            Iterator<Connection.KeyVal> it = request.data().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().hasInputStream()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                String mimeBoundary = DataUtil.mimeBoundary();
                request.header("Content-Type", "multipart/form-data; boundary=" + mimeBoundary);
                return mimeBoundary;
            }
            request.header("Content-Type", "application/x-www-form-urlencoded; charset=" + request.postDataCharset());
            return null;
        }

        private static void writePost(Connection.Request request, OutputStream outputStream, String str) throws IOException {
            Collection<Connection.KeyVal> data = request.data();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            if (str != null) {
                for (Connection.KeyVal next : data) {
                    bufferedWriter.write("--");
                    bufferedWriter.write(str);
                    bufferedWriter.write("\r\n");
                    bufferedWriter.write("Content-Disposition: form-data; name=\"");
                    bufferedWriter.write(HttpConnection.encodeMimeName(next.key()));
                    bufferedWriter.write("\"");
                    if (next.hasInputStream()) {
                        bufferedWriter.write("; filename=\"");
                        bufferedWriter.write(HttpConnection.encodeMimeName(next.value()));
                        bufferedWriter.write("\"\r\nContent-Type: application/octet-stream\r\n\r\n");
                        bufferedWriter.flush();
                        DataUtil.crossStreams(next.inputStream(), outputStream);
                        outputStream.flush();
                    } else {
                        bufferedWriter.write("\r\n\r\n");
                        bufferedWriter.write(next.value());
                    }
                    bufferedWriter.write("\r\n");
                }
                bufferedWriter.write("--");
                bufferedWriter.write(str);
                bufferedWriter.write("--");
            } else {
                boolean z = true;
                for (Connection.KeyVal next2 : data) {
                    if (!z) {
                        bufferedWriter.append(Typography.amp);
                    } else {
                        z = false;
                    }
                    bufferedWriter.write(URLEncoder.encode(next2.key(), request.postDataCharset()));
                    bufferedWriter.write(61);
                    bufferedWriter.write(URLEncoder.encode(next2.value(), request.postDataCharset()));
                }
            }
            bufferedWriter.close();
        }

        private static String getRequestCookieString(Connection.Request request) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry next : request.cookies().entrySet()) {
                if (!z) {
                    sb.append("; ");
                } else {
                    z = false;
                }
                sb.append((String) next.getKey());
                sb.append('=');
                sb.append((String) next.getValue());
            }
            return sb.toString();
        }

        private static void serialiseRequestUrl(Connection.Request request) throws IOException {
            boolean z;
            URL url = request.url();
            StringBuilder sb = new StringBuilder();
            sb.append(url.getProtocol());
            sb.append("://");
            sb.append(url.getAuthority());
            sb.append(url.getPath());
            sb.append("?");
            if (url.getQuery() != null) {
                sb.append(url.getQuery());
                z = false;
            } else {
                z = true;
            }
            for (Connection.KeyVal next : request.data()) {
                if (!z) {
                    sb.append(Typography.amp);
                } else {
                    z = false;
                }
                sb.append(URLEncoder.encode(next.key(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(next.value(), "UTF-8"));
            }
            request.url(new URL(sb.toString()));
            request.data().clear();
        }
    }

    public static class KeyVal implements Connection.KeyVal {
        private String key;
        private InputStream stream;
        private String value;

        public static KeyVal create(String str, String str2) {
            return new KeyVal().key(str).value(str2);
        }

        public static KeyVal create(String str, String str2, InputStream inputStream) {
            return new KeyVal().key(str).value(str2).inputStream(inputStream);
        }

        private KeyVal() {
        }

        public KeyVal key(String str) {
            Validate.notEmpty(str, "Data key must not be empty");
            this.key = str;
            return this;
        }

        public String key() {
            return this.key;
        }

        public KeyVal value(String str) {
            Validate.notNull(str, "Data value must not be null");
            this.value = str;
            return this;
        }

        public String value() {
            return this.value;
        }

        public KeyVal inputStream(InputStream inputStream) {
            Validate.notNull(this.value, "Data input stream must not be null");
            this.stream = inputStream;
            return this;
        }

        public InputStream inputStream() {
            return this.stream;
        }

        public boolean hasInputStream() {
            return this.stream != null;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}
