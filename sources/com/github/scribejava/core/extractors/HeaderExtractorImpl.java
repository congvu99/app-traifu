package com.github.scribejava.core.extractors;

import com.github.scribejava.core.exceptions.OAuthParametersMissingException;
import com.github.scribejava.core.model.AbstractRequest;
import com.github.scribejava.core.model.OAuthConstants;
import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import java.util.Map;

public class HeaderExtractorImpl implements HeaderExtractor {
    public static final int ESTIMATED_PARAM_LENGTH = 20;
    private static final String PARAM_SEPARATOR = ", ";
    private static final String PREAMBLE = "OAuth ";

    public String extract(AbstractRequest abstractRequest) {
        checkPreconditions(abstractRequest);
        Map<String, String> oauthParameters = abstractRequest.getOauthParameters();
        StringBuilder sb = new StringBuilder(oauthParameters.size() * 20);
        sb.append(PREAMBLE);
        for (Map.Entry next : oauthParameters.entrySet()) {
            if (sb.length() > 6) {
                sb.append(PARAM_SEPARATOR);
            }
            sb.append(String.format("%s=\"%s\"", new Object[]{next.getKey(), OAuthEncoder.encode((String) next.getValue())}));
        }
        if (abstractRequest.getRealm() != null && !abstractRequest.getRealm().isEmpty()) {
            sb.append(PARAM_SEPARATOR);
            sb.append(String.format("%s=\"%s\"", new Object[]{OAuthConstants.REALM, abstractRequest.getRealm()}));
        }
        return sb.toString();
    }

    private void checkPreconditions(AbstractRequest abstractRequest) {
        Preconditions.checkNotNull(abstractRequest, "Cannot extract a header from a null object");
        if (abstractRequest.getOauthParameters() == null || abstractRequest.getOauthParameters().size() <= 0) {
            throw new OAuthParametersMissingException(abstractRequest);
        }
    }
}
