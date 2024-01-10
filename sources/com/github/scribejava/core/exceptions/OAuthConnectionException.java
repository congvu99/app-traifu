package com.github.scribejava.core.exceptions;

public class OAuthConnectionException extends OAuthException {
    private static final String MSG = "There was a problem while creating a connection to the remote service: ";
    private static final long serialVersionUID = 6901269342236961310L;

    public OAuthConnectionException(String str, Exception exc) {
        super(MSG + str, exc);
    }
}
