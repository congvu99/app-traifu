package io.sentry.android.core;

final class LoadClass implements ILoadClass {
    LoadClass() {
    }

    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }
}
