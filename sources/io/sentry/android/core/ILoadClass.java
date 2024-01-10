package io.sentry.android.core;

interface ILoadClass {
    Class<?> loadClass(String str) throws ClassNotFoundException;
}
