package net.chauhanDevs.gsquad.GS2DDevs.graphics.model;

import java.awt.*;

public final class ModelPart {

    private Image image;
    private int x = 0;
    private int y = 0;
    private int pivotalX = 0;
    private int pivotalY = 0;

    public ModelPart(Image imageResource){
        image = imageResource;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPivotalX(int pivotalX) {
        this.pivotalX = pivotalX;
    }

    public void setPivotalY(int pivotalY) {
        this.pivotalY = pivotalY;
    }

    public int getPivotalX() {
        return pivotalX;
    }

    public int getPivotalY() {
        return pivotalY;
    }
}
