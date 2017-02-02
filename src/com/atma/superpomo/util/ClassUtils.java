package com.atma.superpomo.util;

import javax.imageio.ImageIO;
import javax.swing.*;
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

    public static BufferedImage[] splitImage(BufferedImage image, int rows, int cols, int width, int height, int initialOffsetX, int initialOffsetY) {

        BufferedImage[] sprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                sprites[(i * cols) + j] = image.getSubimage(
                        (j * width) + initialOffsetX,
                        (i * height) + initialOffsetY,
                        width,
                        height
                );
            }
        }

        return sprites;
    }

    public static void main(String[] args) throws Exception {
        BufferedImage[] sprites = splitImage(getResourceImage("images/signs_green.png"), 13, 8, 21, 21, 0, 0);

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 500);

        for (BufferedImage sprite : sprites) {
            sprite = sprite.getSubimage(0, 0, 13, 16);

            System.out.println("Sprite: "+sprite);
            JLabel label = new JLabel(new ImageIcon(sprite));
            label.setOpaque(true);
            label.setBackground(Color.BLACK);
            frame.getContentPane().add(label);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
