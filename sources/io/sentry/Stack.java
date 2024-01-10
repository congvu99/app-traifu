package io.sentry;

import io.sentry.util.Objects;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

final class Stack {
    private final Deque<StackItem> items;
    private final ILogger logger;

    static final class StackItem {
        private volatile ISentryClient client;
        private final SentryOptions options;
        private volatile Scope scope;

        StackItem(SentryOptions sentryOptions, ISentryClient iSentryClient, Scope scope2) {
            this.client = (ISentryClient) Objects.requireNonNull(iSentryClient, "ISentryClient is required.");
            this.scope = (Scope) Objects.requireNonNull(scope2, "Scope is required.");
            this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "Options is required");
        }

        StackItem(StackItem stackItem) {
            this.options = stackItem.options;
            this.client = stackItem.client;
            try {
                this.scope = stackItem.scope.clone();
            } catch (CloneNotSupportedException unused) {
                this.options.getLogger().log(SentryLevel.ERROR, "Clone not supported", new Object[0]);
                this.scope = new Scope(stackItem.options);
            }
        }

        public ISentryClient getClient() {
            return this.client;
        }

        public void setClient(ISentryClient iSentryClient) {
            this.client = iSentryClient;
        }

        public Scope getScope() {
            return this.scope;
        }

        public SentryOptions getOptions() {
            return this.options;
        }
    }

    public Stack(ILogger iLogger, StackItem stackItem) {
        this.items = new LinkedBlockingDeque();
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "logger is required");
        this.items.push((StackItem) Objects.requireNonNull(stackItem, "rootStackItem is required"));
    }

    public Stack(Stack stack) {
        this(stack.logger, stack.items.getFirst());
        for (StackItem stackItem : stack.items) {
            push(new StackItem(stackItem));
        }
    }

    /* access modifiers changed from: package-private */
    public StackItem peek() {
        return this.items.peek();
    }

    /* access modifiers changed from: package-private */
    public void pop() {
        synchronized (this.items) {
            if (this.items.size() != 1) {
                this.items.pop();
            } else {
                this.logger.log(SentryLevel.WARNING, "Attempt to pop the root scope.", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void push(StackItem stackItem) {
        this.items.push(stackItem);
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.items.size();
    }
}
