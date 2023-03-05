package net.chauhanDevs.gsquad.GS2DDevs.renderer;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.Model;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.ModelPart;

import java.awt.*;
import java.util.ArrayList;

public final class RenderingEngine {

    private static final java.util.List<RenderAble> renderAbleObjects = new ArrayList<>();

    public static void render(Graphics graphics){
        for (var renderAbleObject : renderAbleObjects) {
            if(renderAbleObject instanceof RenderAbleComponent component){
                component.render(graphics);
            }else if(renderAbleObject instanceof RenderAbleObject object) {
                Model objectModel = object.getModel();
                if (objectModel != null) {
                    for (ModelPart modelPart : objectModel.getParts()) {
                        if (modelPart != null) {
                            graphics.drawImage(modelPart.getImage(), (int) ((modelPart.getX() - modelPart.getPivotalX()) + object.getX()),
                                    (int) ((modelPart.getY() - modelPart.getPivotalY()) + object.getY()), null);
                        }
                    }
                }
            }
        }
    }

    public static void register(RenderAble object){
        renderAbleObjects.add(object);
    }
}
