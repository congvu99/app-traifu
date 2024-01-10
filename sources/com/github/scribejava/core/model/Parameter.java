package com.github.scribejava.core.model;

import com.github.scribejava.core.utils.OAuthEncoder;

public class Parameter implements Comparable<Parameter> {
    private final String key;
    private final String value;

    public Parameter(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String asUrlEncodedPair() {
        return OAuthEncoder.encode(this.key).concat("=").concat(OAuthEncoder.encode(this.value));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Parameter)) {
            return false;
        }
        Parameter parameter = (Parameter) obj;
        if (!parameter.getKey().equals(this.key) || !parameter.getValue().equals(this.value)) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.key.hashCode() + this.value.hashCode();
    }

    public int compareTo(Parameter parameter) {
        int compareTo = this.key.compareTo(parameter.getKey());
        return compareTo == 0 ? this.value.compareTo(parameter.getValue()) : compareTo;
    }
}
