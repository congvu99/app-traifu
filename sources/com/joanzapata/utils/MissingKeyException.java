package com.joanzapata.utils;

public class MissingKeyException extends RuntimeException {
    public MissingKeyException(String str) {
        super("You didn't pass an arg for key " + str);
    }
}
