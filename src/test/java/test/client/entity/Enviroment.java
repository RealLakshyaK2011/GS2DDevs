package test.client.entity;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.RenderAbleImage;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.utils.ImageUtils;
import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderingEngine;
import test.graphic.FillAbleBar;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Enviroment {
    public static void init(){
        RenderAbleImage goalImage;
        RenderAbleImage goal2Image;
        try {
            goalImage = new RenderAbleImage(ImageUtils.getImageFromResource("sprites/goal_blue.png").getScaledInstance(1000, 131, 0));
            goal2Image = new RenderAbleImage(ImageUtils.flipImage(ImageUtils.getImageFromResource("sprites/goal_red.png"),
                    ImageUtils.FlipDirection.VERTICAL).getScaledInstance(1000, 131, 0));
        } catch (IOException e) {
            throw new RuntimeException("Can't Load Images");
        }

        //Locating
        goalImage.setX(500);
        goalImage.setY(goalImage.getY()+131/2);

        goal2Image.setX(500);
        goal2Image.setY(650-goal2Image.getImage().getHeight(null)/2);

        //Registering
        RenderingEngine.register(goalImage);
        RenderingEngine.register(goal2Image);
    }
}
