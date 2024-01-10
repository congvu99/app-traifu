package com.github.scribejava.core.extractors;

import com.github.scribejava.core.model.AbstractRequest;

public interface HeaderExtractor {
    String extract(AbstractRequest abstractRequest);
}
