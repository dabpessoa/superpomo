package com.atma.superpomo.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

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

    public static InputStream getResourceStream(String resourcePath) {
        return getDefaultClassLoader(ClassUtils.class).getResourceAsStream(resourcePath);
    }

    public static byte[] getResourceBytes(String resourcePath) throws IOException {
        InputStream is = getResourceStream(resourcePath);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();
        buffer.close();
        return buffer.toByteArray();
    }

    public static BufferedImage getResourceImage(String resourcePath) throws IOException {
        return ImageIO.read(getResourceStream(resourcePath));
    }

}
