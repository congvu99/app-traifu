package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.SentryId;
import java.util.List;

public interface ITransaction extends ISpan {
    Contexts getContexts();

    SentryId getEventId();

    Span getLatestActiveSpan();

    String getName();

    Request getRequest();

    List<Span> getSpans();

    String getTransaction();

    Boolean isSampled();

    void setName(String str);

    void setRequest(Request request);
}
