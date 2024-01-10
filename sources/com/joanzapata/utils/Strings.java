package com.joanzapata.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {
    private Strings() {
    }

    public static Builder format(String str) {
        return new Builder(str);
    }

    public static Builder format(String str, String str2, String str3) {
        return new Builder(str, str2, str3);
    }

    public static class Builder {
        private String baseString;
        private final Pattern pattern;
        private String prefix;
        private boolean strictMode;
        private String suffix;

        private Builder(String str) {
            this(str, "{", "}");
        }

        private Builder(String str, String str2, String str3) {
            this.strictMode = true;
            this.baseString = str;
            this.prefix = str2;
            this.suffix = str3;
            this.pattern = Pattern.compile(Pattern.quote(str2) + ".*?" + Pattern.quote(str3));
        }

        public Builder strictMode(boolean z) {
            this.strictMode = z;
            return this;
        }

        public Builder with(String str, Object obj) {
            if (obj == null) {
                obj = "";
            }
            if (this.strictMode) {
                String str2 = this.baseString;
                if (!str2.contains(this.prefix + str + this.suffix)) {
                    throw new KeyNotFoundException(str, this.baseString);
                }
            }
            String str3 = this.baseString;
            this.baseString = str3.replace(this.prefix + str + this.suffix, obj.toString());
            return this;
        }

        public String build() {
            Matcher matcher = this.pattern.matcher(this.baseString);
            if (!this.strictMode || !matcher.find()) {
                return this.baseString;
            }
            throw new MissingKeyException(matcher.group());
        }
    }
}
