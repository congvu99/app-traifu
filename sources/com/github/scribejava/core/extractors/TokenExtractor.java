package com.github.scribejava.core.extractors;

import com.github.scribejava.core.model.Token;

public interface TokenExtractor<T extends Token> {
    T extract(String str);
}
