package net.chauhanDevs.gsquad.GS2DDevs.graphics.image.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageUtils {
    protected static BufferedImage buffer;

    public static BufferedImage getImageFromResource(String res) throws IOException {
        var resource = new FileInputStream(res);
        buffer = ImageIO.read(resource);
        return buffer;
    }

    public enum FlipDirection{HOTIZONTAL,VERTICAL}

    public static BufferedImage flipImage(BufferedImage image, FlipDirection direction){
        int w = image.getWidth();
        int h = image.getHeight();

        buffer = new BufferedImage(w,h,image.getType());
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                switch (direction){
                    case HOTIZONTAL -> buffer.setRGB(w-1-x,y, image.getRGB(x,y));
                    case VERTICAL -> buffer.setRGB(x,h-1-y, image.getRGB(x,y));
                }
            }
        }
        return buffer;
    }
}
