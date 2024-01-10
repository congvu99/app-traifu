package io.sentry;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public final class Session {
    private final String distinctId;
    private Double duration;
    private final String environment;
    private final AtomicInteger errorCount;
    private Boolean init;
    private final String ipAddress;
    private final String release;
    private Long sequence;
    private final UUID sessionId;
    private final Object sessionLock;
    private final Date started;
    private State status;
    private Date timestamp;
    private String userAgent;

    public enum State {
        Ok,
        Exited,
        Crashed,
        Abnormal
    }

    public Session(State state, Date date, Date date2, int i, String str, UUID uuid, Boolean bool, Long l, Double d, String str2, String str3, String str4, String str5) {
        this.sessionLock = new Object();
        this.status = state;
        this.started = date;
        this.timestamp = date2;
        this.errorCount = new AtomicInteger(i);
        this.distinctId = str;
        this.sessionId = uuid;
        this.init = bool;
        this.sequence = l;
        this.duration = d;
        this.ipAddress = str2;
        this.userAgent = str3;
        this.environment = str4;
        this.release = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Session(java.lang.String r15, io.sentry.protocol.User r16, java.lang.String r17, java.lang.String r18) {
        /*
            r14 = this;
            io.sentry.Session$State r1 = io.sentry.Session.State.Ok
            java.util.Date r2 = io.sentry.DateUtils.getCurrentDateTime()
            java.util.Date r3 = io.sentry.DateUtils.getCurrentDateTime()
            java.util.UUID r6 = java.util.UUID.randomUUID()
            r0 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            if (r16 == 0) goto L_0x001a
            java.lang.String r0 = r16.getIpAddress()
            goto L_0x001b
        L_0x001a:
            r0 = 0
        L_0x001b:
            r10 = r0
            r11 = 0
            r4 = 0
            r8 = 0
            r9 = 0
            r0 = r14
            r5 = r15
            r12 = r17
            r13 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Session.<init>(java.lang.String, io.sentry.protocol.User, java.lang.String, java.lang.String):void");
    }

    public Date getStarted() {
        Date date = this.started;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getRelease() {
        return this.release;
    }

    public Boolean getInit() {
        return this.init;
    }

    public void setInitAsTrue() {
        this.init = true;
    }

    public int errorCount() {
        return this.errorCount.get();
    }

    public State getStatus() {
        return this.status;
    }

    public Long getSequence() {
        return this.sequence;
    }

    public Double getDuration() {
        return this.duration;
    }

    public Date getTimestamp() {
        Date date = this.timestamp;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void end() {
        end(DateUtils.getCurrentDateTime());
    }

    public void end(Date date) {
        synchronized (this.sessionLock) {
            this.init = null;
            if (this.status == State.Ok) {
                this.status = State.Exited;
            }
            if (date != null) {
                this.timestamp = date;
            } else {
                this.timestamp = DateUtils.getCurrentDateTime();
            }
            if (this.timestamp != null) {
                this.duration = Double.valueOf(calculateDurationTime(this.timestamp));
                this.sequence = Long.valueOf(getSequenceTimestamp(this.timestamp));
            }
        }
    }

    private double calculateDurationTime(Date date) {
        return ((double) Math.abs(date.getTime() - this.started.getTime())) / 1000.0d;
    }

    public boolean update(State state, String str, boolean z) {
        boolean z2;
        synchronized (this.sessionLock) {
            boolean z3 = false;
            z2 = true;
            if (state != null) {
                try {
                    this.status = state;
                    z3 = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (str != null) {
                this.userAgent = str;
                z3 = true;
            }
            if (z) {
                this.errorCount.addAndGet(1);
            } else {
                z2 = z3;
            }
            if (z2) {
                this.init = null;
                Date currentDateTime = DateUtils.getCurrentDateTime();
                this.timestamp = currentDateTime;
                if (currentDateTime != null) {
                    this.sequence = Long.valueOf(getSequenceTimestamp(currentDateTime));
                }
            }
        }
        return z2;
    }

    private long getSequenceTimestamp(Date date) {
        long time = date.getTime();
        return time < 0 ? Math.abs(time) : time;
    }

    public Session clone() {
        return new Session(this.status, this.started, this.timestamp, this.errorCount.get(), this.distinctId, this.sessionId, this.init, this.sequence, this.duration, this.ipAddress, this.userAgent, this.environment, this.release);
    }
}
