package test.graphic.model;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.Model;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.ModelPart;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.utils.ImageUtils;

import java.io.IOException;

public class BallModel extends Model {

    private ModelPart BODY = null;

    public BallModel(){
        try {
            BODY = new ModelPart(ImageUtils.getImageFromResource("sprites/ball.png").getScaledInstance(32, 32, 0));
        } catch (IOException e) {
            System.out.println("Error While Finding Image, Stopping");
            System.exit(3);
        }

        BODY.setPivotalX(BODY.getImage().getWidth(null) / 2);
        BODY.setPivotalY(BODY.getImage().getHeight(null) / 2);

        parts.add(BODY);
    }
}
