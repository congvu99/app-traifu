package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    JdkPattern(Pattern pattern2) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern2);
    }

    /* access modifiers changed from: package-private */
    public CommonMatcher matcher(CharSequence charSequence) {
        return new JdkMatcher(this.pattern.matcher(charSequence));
    }

    /* access modifiers changed from: package-private */
    public String pattern() {
        return this.pattern.pattern();
    }

    /* access modifiers changed from: package-private */
    public int flags() {
        return this.pattern.flags();
    }

    public String toString() {
        return this.pattern.toString();
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JdkPattern)) {
            return false;
        }
        return this.pattern.equals(((JdkPattern) obj).pattern);
    }

    private static final class JdkMatcher extends CommonMatcher {
        final Matcher matcher;

        JdkMatcher(Matcher matcher2) {
            this.matcher = (Matcher) Preconditions.checkNotNull(matcher2);
        }

        /* access modifiers changed from: package-private */
        public boolean matches() {
            return this.matcher.matches();
        }

        /* access modifiers changed from: package-private */
        public boolean find() {
            return this.matcher.find();
        }

        /* access modifiers changed from: package-private */
        public boolean find(int i) {
            return this.matcher.find(i);
        }

        /* access modifiers changed from: package-private */
        public String replaceAll(String str) {
            return this.matcher.replaceAll(str);
        }

        /* access modifiers changed from: package-private */
        public int end() {
            return this.matcher.end();
        }

        /* access modifiers changed from: package-private */
        public int start() {
            return this.matcher.start();
        }
    }
}
