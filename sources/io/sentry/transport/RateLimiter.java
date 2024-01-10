package io.sentry.transport;

import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.squareup.otto.Bus;
import io.sentry.ILogger;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.cache.EnvelopeCache;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class RateLimiter {
    private static final int HTTP_RETRY_AFTER_DEFAULT_DELAY_MILLIS = 60000;
    private final ICurrentDateProvider currentDateProvider;
    private final ILogger logger;
    private final Map<DataCategory, Date> sentryRetryAfterLimit;

    private enum DataCategory {
        All("__all__"),
        Default(Bus.DEFAULT_IDENTIFIER),
        Error("error"),
        Session(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE),
        Attachment(MessengerShareContentUtility.ATTACHMENT),
        Transaction("transaction"),
        Security("security"),
        Unknown("unknown");
        
        private final String category;

        private DataCategory(String str) {
            this.category = str;
        }

        public String getCategory() {
            return this.category;
        }
    }

    public RateLimiter(ICurrentDateProvider iCurrentDateProvider, ILogger iLogger) {
        this.sentryRetryAfterLimit = new ConcurrentHashMap();
        this.currentDateProvider = iCurrentDateProvider;
        this.logger = iLogger;
    }

    public RateLimiter(ILogger iLogger) {
        this(CurrentDateProvider.getInstance(), iLogger);
    }

    public SentryEnvelope filter(SentryEnvelope sentryEnvelope, Object obj) {
        ArrayList arrayList = null;
        for (SentryEnvelopeItem next : sentryEnvelope.getItems()) {
            if (isRetryAfter(next.getHeader().getType().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
            }
            if (arrayList != null) {
                this.logger.log(SentryLevel.INFO, "%d items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
            }
        }
        if (arrayList == null) {
            return sentryEnvelope;
        }
        ArrayList arrayList2 = new ArrayList();
        for (SentryEnvelopeItem next2 : sentryEnvelope.getItems()) {
            if (!arrayList.contains(next2)) {
                arrayList2.add(next2);
            }
        }
        if (!arrayList2.isEmpty()) {
            return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList2);
        }
        this.logger.log(SentryLevel.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
        markHintWhenSendingFailed(obj, false);
        return null;
    }

    private static void markHintWhenSendingFailed(Object obj, boolean z) {
        if (obj instanceof SubmissionResult) {
            ((SubmissionResult) obj).setResult(false);
        }
        if (obj instanceof Retryable) {
            ((Retryable) obj).setRetry(z);
        }
    }

    private boolean isRetryAfter(String str) {
        Date date;
        DataCategory categoryFromItemType = getCategoryFromItemType(str);
        Date date2 = new Date(this.currentDateProvider.getCurrentTimeMillis());
        Date date3 = this.sentryRetryAfterLimit.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (!DataCategory.Unknown.equals(categoryFromItemType) && (date = this.sentryRetryAfterLimit.get(categoryFromItemType)) != null) {
            return !date2.after(date);
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.transport.RateLimiter.DataCategory getCategoryFromItemType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1963501277: goto L_0x0029;
                case 96891546: goto L_0x001f;
                case 1984987798: goto L_0x0015;
                case 2141246174: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "transaction"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 3
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "session"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 1
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "event"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "attachment"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0033
            r5 = 2
            goto L_0x0034
        L_0x0033:
            r5 = -1
        L_0x0034:
            if (r5 == 0) goto L_0x0048
            if (r5 == r3) goto L_0x0045
            if (r5 == r2) goto L_0x0042
            if (r5 == r1) goto L_0x003f
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Unknown
            return r5
        L_0x003f:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Transaction
            return r5
        L_0x0042:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Attachment
            return r5
        L_0x0045:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Session
            return r5
        L_0x0048:
            io.sentry.transport.RateLimiter$DataCategory r5 = io.sentry.transport.RateLimiter.DataCategory.Error
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.RateLimiter.getCategoryFromItemType(java.lang.String):io.sentry.transport.RateLimiter$DataCategory");
    }

    public void updateRetryAfterLimits(String str, String str2, int i) {
        String str3 = str;
        if (str3 != null) {
            int i2 = -1;
            String[] split = str3.split(",", -1);
            int length = split.length;
            int i3 = 0;
            while (i3 < length) {
                String[] split2 = split[i3].replace(" ", "").split(CertificateUtil.DELIMITER, i2);
                if (split2.length > 0) {
                    long parseRetryAfterOrDefault = parseRetryAfterOrDefault(split2[0]);
                    if (split2.length > 1) {
                        String str4 = split2[1];
                        Date date = new Date(this.currentDateProvider.getCurrentTimeMillis() + parseRetryAfterOrDefault);
                        if (str4 == null || str4.isEmpty()) {
                            applyRetryAfterOnlyIfLonger(DataCategory.All, date);
                        } else {
                            for (String str5 : str4.split(";", i2)) {
                                DataCategory dataCategory = DataCategory.Unknown;
                                try {
                                    dataCategory = DataCategory.valueOf(StringUtils.capitalize(str5));
                                } catch (IllegalArgumentException e) {
                                    this.logger.log(SentryLevel.INFO, e, "Unknown category: %s", str5);
                                }
                                if (!DataCategory.Unknown.equals(dataCategory)) {
                                    applyRetryAfterOnlyIfLonger(dataCategory, date);
                                }
                            }
                        }
                    }
                }
                i3++;
                i2 = -1;
            }
        } else if (i == 429) {
            applyRetryAfterOnlyIfLonger(DataCategory.All, new Date(this.currentDateProvider.getCurrentTimeMillis() + parseRetryAfterOrDefault(str2)));
        }
    }

    private void applyRetryAfterOnlyIfLonger(DataCategory dataCategory, Date date) {
        Date date2 = this.sentryRetryAfterLimit.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.sentryRetryAfterLimit.put(dataCategory, date);
        }
    }

    private long parseRetryAfterOrDefault(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000;
    }
}
