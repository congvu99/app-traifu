package com.joanzapata.utils;

public class KeyNotFoundException extends RuntimeException {
    public KeyNotFoundException(String str, String str2) {
        super("Couldn't find key \"" + str + "\" in string \"" + str2 + "\".");
    }
}
