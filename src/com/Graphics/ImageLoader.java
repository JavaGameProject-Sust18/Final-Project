package com.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
            try {
                return ImageIO.read(ImageLoader.class.getResourceAsStream(path));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            return null;
        }
}
