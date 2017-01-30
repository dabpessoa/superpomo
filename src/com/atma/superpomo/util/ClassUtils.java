package com.atma.superpomo.util;

/**
 * Created by diego.pessoa on 30/01/2017.
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(Class<?> clazz) {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable var2) {}

        if(cl == null) {
            cl = clazz.getClass().getClassLoader();
        }

        return cl;
    }

}
