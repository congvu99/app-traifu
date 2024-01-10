package com.github.scribejava.core.model;

import com.github.scribejava.core.utils.OAuthEncoder;
import com.github.scribejava.core.utils.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

public class ParameterList {
    private static final String EMPTY_STRING = "";
    private static final String PAIR_SEPARATOR = "=";
    private static final String PARAM_SEPARATOR = "&";
    private static final char QUERY_STRING_SEPARATOR = '?';
    private final List<Parameter> params;

    public ParameterList() {
        this.params = new ArrayList();
    }

    ParameterList(List<Parameter> list) {
        this.params = new ArrayList(list);
    }

    public ParameterList(Map<String, String> map) {
        this();
        for (Map.Entry next : map.entrySet()) {
            this.params.add(new Parameter((String) next.getKey(), (String) next.getValue()));
        }
    }

    public void add(String str, String str2) {
        this.params.add(new Parameter(str, str2));
    }

    public String appendTo(String str) {
        Preconditions.checkNotNull(str, "Cannot append to null URL");
        String asFormUrlEncodedString = asFormUrlEncodedString();
        if (asFormUrlEncodedString.equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) == -1 ? Character.valueOf(QUERY_STRING_SEPARATOR) : PARAM_SEPARATOR);
        String sb2 = sb.toString();
        return sb2 + asFormUrlEncodedString;
    }

    public String asOauthBaseString() {
        return OAuthEncoder.encode(asFormUrlEncodedString());
    }

    public String asFormUrlEncodedString() {
        if (this.params.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Parameter asUrlEncodedPair : this.params) {
            sb.append(Typography.amp);
            sb.append(asUrlEncodedPair.asUrlEncodedPair());
        }
        return sb.toString().substring(1);
    }

    public void addAll(ParameterList parameterList) {
        this.params.addAll(parameterList.getParams());
    }

    public void addQuerystring(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split(PARAM_SEPARATOR)) {
                String[] split2 = split.split(PAIR_SEPARATOR);
                this.params.add(new Parameter(OAuthEncoder.decode(split2[0]), split2.length > 1 ? OAuthEncoder.decode(split2[1]) : ""));
            }
        }
    }

    public boolean contains(Parameter parameter) {
        return this.params.contains(parameter);
    }

    public int size() {
        return this.params.size();
    }

    public List<Parameter> getParams() {
        return this.params;
    }

    public ParameterList sort() {
        ParameterList parameterList = new ParameterList(this.params);
        Collections.sort(parameterList.getParams());
        return parameterList;
    }
}
