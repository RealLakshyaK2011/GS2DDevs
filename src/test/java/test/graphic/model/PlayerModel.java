package test.graphic.model;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.Model;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.ModelPart;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.utils.ImageUtils;

import java.io.IOException;

public class PlayerModel extends Model {

    private ModelPart BODY = null;

    public PlayerModel(){

        try {
            BODY = new ModelPart(ImageUtils.getImageFromResource("sprites/player.png")
                    .getSubimage(0, 0, 16, 5).getScaledInstance(128, 32, 0));
        } catch (IOException e) {
            System.out.println("Error While Finding Image, Stopping");
            System.exit(4);
        }

        BODY.setPivotalX(BODY.getImage().getWidth(null) / 2);
        BODY.setPivotalY(BODY.getImage().getHeight(null) / 2);

        parts.add(BODY);
    }
}
