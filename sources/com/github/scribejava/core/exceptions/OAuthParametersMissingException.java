package com.github.scribejava.core.exceptions;

import com.github.scribejava.core.model.AbstractRequest;

public class OAuthParametersMissingException extends OAuthException {
    private static final String MSG = "Could not find oauth parameters in request: %s. OAuth parameters must be specified with the addOAuthParameter() method";
    private static final long serialVersionUID = 1745308760111976671L;

    public OAuthParametersMissingException(AbstractRequest abstractRequest) {
        super(String.format(MSG, new Object[]{abstractRequest}));
    }
}
