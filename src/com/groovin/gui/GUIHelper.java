package com.groovin.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GUIHelper {
    
    public static BufferedImage getImage(String name) {
        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(ImageIO.createImageInputStream(Objects.requireNonNull(GUIHelper.class.getResourceAsStream(name))));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myPicture;
    }
}