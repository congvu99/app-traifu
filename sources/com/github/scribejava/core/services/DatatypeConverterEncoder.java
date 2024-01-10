package com.github.scribejava.core.services;

import javax.xml.bind.DatatypeConverter;

public class DatatypeConverterEncoder extends Base64Encoder {
    public String getType() {
        return "DatatypeConverter";
    }

    public String encode(byte[] bArr) {
        return DatatypeConverter.printBase64Binary(bArr);
    }
}
