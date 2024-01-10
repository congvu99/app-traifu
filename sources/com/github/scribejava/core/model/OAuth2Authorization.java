package com.github.scribejava.core.model;

public class OAuth2Authorization {
    private String code;
    private String state;

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }
}
