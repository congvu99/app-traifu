package com.github.scribejava.core.exceptions;

public class OAuthSignatureException extends OAuthException {
    private static final String MSG = "Error while signing string: %s";
    private static final long serialVersionUID = 1;

    public OAuthSignatureException(String str, Exception exc) {
        super(String.format(MSG, new Object[]{str}), exc);
    }
}
