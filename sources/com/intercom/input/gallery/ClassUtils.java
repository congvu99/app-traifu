package com.intercom.input.gallery;

import java.io.Serializable;

public class ClassUtils {
    public static <T> T instantiate(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Could not instantiate " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Could not instantiate" + cls + ", make sure the class is public and static", e2);
        }
    }

    public static <T> Class<? extends T> cast(Serializable serializable) {
        return (Class) serializable;
    }
}
