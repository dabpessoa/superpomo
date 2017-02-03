package com.atma.superpomo.service;

import com.atma.superpomo.util.ClassUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by diego.pessoa on 01/02/2017.
 */
public class NumberSpriteLoader {

    private JLabel[] spriteLabels;

    public NumberSpriteLoader(String path) {
        spriteLabels = getNumberSpriteLabels(path);
    }

    public JLabel getNumberSprite(int number) {
        if (number < 0 || number > getSpriteLabels().length) {
            return null;
        }
        return getSpriteLabels()[number];
    }

    public JLabel[] getSpriteLabels() {
        return spriteLabels;
    }

    public void setSpriteLabels(JLabel[] spriteLabels) {
        this.spriteLabels = spriteLabels;
    }

    public JLabel[] getNumberSpriteLabels(String path) {
        BufferedImage[] sprites = getNumberSprites(path);
        JLabel[] spriteLabels = new JLabel[sprites.length];
        for (int i = 0 ; i < sprites.length ; i++) {
            BufferedImage sprite = sprites[i];
            sprite = sprite.getSubimage(0, 0, 13, 16);
            JLabel label = new JLabel(new ImageIcon(sprite));
            label.setOpaque(true);
            label.setBackground(Color.BLACK);
            spriteLabels[i] = label;
        }
        return spriteLabels;
    }

    public BufferedImage[] getNumberSprites(String path) {
        BufferedImage[] sprites = new BufferedImage[0];
        try {
            sprites = ClassUtils.splitImage(ClassUtils.getResourceImage(path), 13, 8, 21, 21, 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage[] numberSprites = new BufferedImage[10];

        numberSprites[0] = sprites[41];
        numberSprites[1] = sprites[32];
        numberSprites[2] = sprites[33];
        numberSprites[3] = sprites[34];
        numberSprites[4] = sprites[35];
        numberSprites[5] = sprites[36];
        numberSprites[6] = sprites[37];
        numberSprites[7] = sprites[38];
        numberSprites[8] = sprites[39];
        numberSprites[9] = sprites[40];

        return numberSprites;

    }

    public static void main(String[] args) throws Exception {

        NumberSpriteLoader numberSpriteLoader = new NumberSpriteLoader("images/signs_green.png");

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(500, 500);

        JLabel[] spriteLabels = numberSpriteLoader.getSpriteLabels();

        for (JLabel spriteLabel : spriteLabels) {
            frame.getContentPane().add(spriteLabel);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


//        BufferedImage[] sprites = ClassUtils.splitImage(ClassUtils.getResourceImage("images/signs_green.png"), 13, 8, 21, 21, 0, 0);
//
//        JFrame frame = new JFrame();
//        frame.getContentPane().setLayout(new FlowLayout());
//        frame.setSize(500, 500);
//
//        for (BufferedImage sprite : sprites) {
//            sprite = sprite.getSubimage(0, 0, 13, 16);
//
//            System.out.println("Sprite: "+sprite);
//            JLabel label = new JLabel(new ImageIcon(sprite));
//            label.setOpaque(true);
//            label.setBackground(Color.BLACK);
//            frame.getContentPane().add(label);
//        }
//
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }

}
