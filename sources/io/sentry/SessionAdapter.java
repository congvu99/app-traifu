package io.sentry;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.sentry.Session;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public final class SessionAdapter extends TypeAdapter<Session> {
    private final ILogger logger;

    public SessionAdapter(ILogger iLogger) {
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "The Logger is required.");
    }

    public void write(JsonWriter jsonWriter, Session session) throws IOException {
        if (session == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (session.getSessionId() != null) {
            jsonWriter.name("sid").value(session.getSessionId().toString());
        }
        if (session.getDistinctId() != null) {
            jsonWriter.name("did").value(session.getDistinctId());
        }
        if (session.getInit() != null) {
            jsonWriter.name("init").value(session.getInit());
        }
        Date started = session.getStarted();
        if (started != null) {
            jsonWriter.name(MetricTracker.Action.STARTED).value(DateUtils.getTimestamp(started));
        }
        Session.State status = session.getStatus();
        if (status != null) {
            jsonWriter.name("status").value(status.name().toLowerCase(Locale.ROOT));
        }
        if (session.getSequence() != null) {
            jsonWriter.name("seq").value((Number) session.getSequence());
        }
        int errorCount = session.errorCount();
        if (errorCount > 0) {
            jsonWriter.name("errors").value((long) errorCount);
        }
        if (session.getDuration() != null) {
            jsonWriter.name("duration").value((Number) session.getDuration());
        }
        if (session.getTimestamp() != null) {
            jsonWriter.name("timestamp").value(DateUtils.getTimestamp(session.getTimestamp()));
        }
        boolean initAttrs = initAttrs(jsonWriter, false);
        jsonWriter.name("release").value(session.getRelease());
        if (session.getEnvironment() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name("environment").value(session.getEnvironment());
        }
        if (session.getIpAddress() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name("ip_address").value(session.getIpAddress());
        }
        if (session.getUserAgent() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name("user_agent").value(session.getUserAgent());
        }
        if (initAttrs) {
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    private boolean initAttrs(JsonWriter jsonWriter, boolean z) throws IOException {
        if (z) {
            return true;
        }
        jsonWriter.name("attrs").beginObject();
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.Session read(com.google.gson.stream.JsonReader r21) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            com.google.gson.stream.JsonToken r1 = r21.peek()
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NULL
            r3 = 0
            if (r1 != r2) goto L_0x000f
            r21.nextNull()
            return r3
        L_0x000f:
            r21.beginObject()
            r5 = r3
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r8 = 0
        L_0x0021:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x0183
            java.lang.String r2 = r21.nextName()
            int r4 = r2.hashCode()
            java.lang.String r3 = "timestamp"
            java.lang.String r1 = "started"
            r18 = -1
            r19 = r15
            r15 = 1
            switch(r4) {
                case -1992012396: goto L_0x0095;
                case -1897185151: goto L_0x008d;
                case -1294635157: goto L_0x0083;
                case -892481550: goto L_0x0079;
                case 99455: goto L_0x006f;
                case 113759: goto L_0x0065;
                case 113870: goto L_0x005b;
                case 3237136: goto L_0x0051;
                case 55126294: goto L_0x0048;
                case 93152418: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x009f
        L_0x003d:
            java.lang.String r4 = "attrs"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 9
            goto L_0x00a0
        L_0x0048:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x009f
            r2 = 8
            goto L_0x00a0
        L_0x0051:
            java.lang.String r4 = "init"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 2
            goto L_0x00a0
        L_0x005b:
            java.lang.String r4 = "sid"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 0
            goto L_0x00a0
        L_0x0065:
            java.lang.String r4 = "seq"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 6
            goto L_0x00a0
        L_0x006f:
            java.lang.String r4 = "did"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 1
            goto L_0x00a0
        L_0x0079:
            java.lang.String r4 = "status"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 4
            goto L_0x00a0
        L_0x0083:
            java.lang.String r4 = "errors"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 5
            goto L_0x00a0
        L_0x008d:
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x009f
            r2 = 3
            goto L_0x00a0
        L_0x0095:
            java.lang.String r4 = "duration"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x009f
            r2 = 7
            goto L_0x00a0
        L_0x009f:
            r2 = -1
        L_0x00a0:
            switch(r2) {
                case 0: goto L_0x0167;
                case 1: goto L_0x0160;
                case 2: goto L_0x0157;
                case 3: goto L_0x014e;
                case 4: goto L_0x0131;
                case 5: goto L_0x012c;
                case 6: goto L_0x0123;
                case 7: goto L_0x011a;
                case 8: goto L_0x0111;
                case 9: goto L_0x00a8;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            r21.skipValue()
            goto L_0x0164
        L_0x00a8:
            r21.beginObject()
        L_0x00ab:
            boolean r1 = r21.hasNext()
            if (r1 == 0) goto L_0x010d
            java.lang.String r1 = r21.nextName()
            int r2 = r1.hashCode()
            switch(r2) {
                case -85904877: goto L_0x00db;
                case 1090594823: goto L_0x00d1;
                case 1480014044: goto L_0x00c7;
                case 1917799825: goto L_0x00bd;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x00e5
        L_0x00bd:
            java.lang.String r2 = "user_agent"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e5
            r1 = 3
            goto L_0x00e6
        L_0x00c7:
            java.lang.String r2 = "ip_address"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e5
            r1 = 2
            goto L_0x00e6
        L_0x00d1:
            java.lang.String r2 = "release"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e5
            r1 = 0
            goto L_0x00e6
        L_0x00db:
            java.lang.String r2 = "environment"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00e5
            r1 = 1
            goto L_0x00e6
        L_0x00e5:
            r1 = -1
        L_0x00e6:
            if (r1 == 0) goto L_0x0106
            if (r1 == r15) goto L_0x00ff
            r2 = 2
            if (r1 == r2) goto L_0x00f9
            r3 = 3
            if (r1 == r3) goto L_0x00f4
            r21.skipValue()
            goto L_0x00ab
        L_0x00f4:
            java.lang.String r19 = r21.nextString()
            goto L_0x00ab
        L_0x00f9:
            r3 = 3
            java.lang.String r14 = r21.nextString()
            goto L_0x00ab
        L_0x00ff:
            r2 = 2
            r3 = 3
            java.lang.String r16 = r21.nextString()
            goto L_0x00ab
        L_0x0106:
            r2 = 2
            r3 = 3
            java.lang.String r17 = r21.nextString()
            goto L_0x00ab
        L_0x010d:
            r21.endObject()
            goto L_0x0164
        L_0x0111:
            java.lang.String r1 = r21.nextString()
            java.util.Date r7 = r0.converTimeStamp(r1, r3)
            goto L_0x0164
        L_0x011a:
            double r1 = r21.nextDouble()
            java.lang.Double r13 = java.lang.Double.valueOf(r1)
            goto L_0x0164
        L_0x0123:
            long r1 = r21.nextLong()
            java.lang.Long r12 = java.lang.Long.valueOf(r1)
            goto L_0x0164
        L_0x012c:
            int r8 = r21.nextInt()
            goto L_0x0164
        L_0x0131:
            java.lang.String r1 = r21.nextString()     // Catch:{ IllegalArgumentException -> 0x013e }
            java.lang.String r1 = io.sentry.util.StringUtils.capitalize(r1)     // Catch:{ IllegalArgumentException -> 0x013e }
            io.sentry.Session$State r5 = io.sentry.Session.State.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x013f }
            goto L_0x0164
        L_0x013e:
            r1 = 0
        L_0x013f:
            io.sentry.ILogger r2 = r0.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r15 = 0
            r4[r15] = r1
            java.lang.String r1 = "%s status is not valid."
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r1, (java.lang.Object[]) r4)
            goto L_0x0164
        L_0x014e:
            java.lang.String r2 = r21.nextString()
            java.util.Date r6 = r0.converTimeStamp(r2, r1)
            goto L_0x0164
        L_0x0157:
            boolean r1 = r21.nextBoolean()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r1)
            goto L_0x0164
        L_0x0160:
            java.lang.String r9 = r21.nextString()
        L_0x0164:
            r15 = r19
            goto L_0x0180
        L_0x0167:
            java.lang.String r1 = r21.nextString()     // Catch:{ IllegalArgumentException -> 0x0170 }
            java.util.UUID r10 = java.util.UUID.fromString(r1)     // Catch:{ IllegalArgumentException -> 0x0171 }
            goto L_0x0164
        L_0x0170:
            r1 = 0
        L_0x0171:
            io.sentry.ILogger r2 = r0.logger
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r15 = 0
            r4[r15] = r1
            java.lang.String r1 = "%s sid is not valid."
            r2.log((io.sentry.SentryLevel) r3, (java.lang.String) r1, (java.lang.Object[]) r4)
            goto L_0x0164
        L_0x0180:
            r3 = 0
            goto L_0x0021
        L_0x0183:
            r19 = r15
            r21.endObject()
            if (r5 == 0) goto L_0x019e
            if (r6 == 0) goto L_0x019e
            if (r17 == 0) goto L_0x019e
            boolean r1 = r17.isEmpty()
            if (r1 == 0) goto L_0x0195
            goto L_0x019e
        L_0x0195:
            io.sentry.Session r1 = new io.sentry.Session
            r4 = r1
            r15 = r19
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x019e:
            io.sentry.ILogger r1 = r0.logger
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "Session is gonna be dropped due to invalid fields."
            r1.log((io.sentry.SentryLevel) r2, (java.lang.String) r4, (java.lang.Object[]) r3)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SessionAdapter.read(com.google.gson.stream.JsonReader):io.sentry.Session");
    }

    private Date converTimeStamp(String str, String str2) {
        try {
            return DateUtils.getDateTime(str);
        } catch (IllegalArgumentException e) {
            this.logger.log(SentryLevel.ERROR, e, "Error converting session (%s) field.", str2);
            return null;
        }
    }
}
