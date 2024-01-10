package com.github.scribejava.core.extractors;

import com.github.scribejava.core.exceptions.OAuthParametersMissingException;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.ParameterList;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;

public class BaseStringExtractorImpl implements BaseStringExtractor {
    protected static final String AMPERSAND_SEPARATED_STRING = "%s&%s&%s";

    public String extract(AbstractRequest abstractRequest) {
        checkPreconditions(abstractRequest);
        return String.format(AMPERSAND_SEPARATED_STRING, new Object[]{OAuthEncoder.encode(getVerb(abstractRequest)), OAuthEncoder.encode(getUrl(abstractRequest)), getSortedAndEncodedParams(abstractRequest)});
    }

    /* access modifiers changed from: protected */
    public String getVerb(AbstractRequest abstractRequest) {
        return abstractRequest.getVerb().name();
    }

    /* access modifiers changed from: protected */
    public String getUrl(AbstractRequest abstractRequest) {
        return abstractRequest.getSanitizedUrl();
    }

    /* access modifiers changed from: protected */
    public String getSortedAndEncodedParams(AbstractRequest abstractRequest) {
        ParameterList parameterList = new ParameterList();
        parameterList.addAll(abstractRequest.getQueryStringParams());
        parameterList.addAll(abstractRequest.getBodyParams());
        parameterList.addAll(new ParameterList(abstractRequest.getOauthParameters()));
        return parameterList.sort().asOauthBaseString();
    }

    /* access modifiers changed from: protected */
    public void checkPreconditions(AbstractRequest abstractRequest) {
        Preconditions.checkNotNull(abstractRequest, "Cannot extract base string from a null object");
        if (abstractRequest.getOauthParameters() == null || abstractRequest.getOauthParameters().size() <= 0) {
            throw new OAuthParametersMissingException(abstractRequest);
        }
    }
}
