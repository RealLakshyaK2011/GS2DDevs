package net.chauhanDevs.gsquad.GS2DDevs.graphics.image;

import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderAbleComponent;

import java.awt.*;

public final class RenderAbleImage implements RenderAbleComponent {


    public RenderAbleImage(Image image){
        this(0,0,image);
    }

    public RenderAbleImage(int x, int y, Image image){
        this.image = image;
        this.x = x;
        this.y = y;
    }

    private Image image;
    private int x = 0;
    private int y = 0;

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image, x - (image.getWidth(null) / 2), y - (image.getHeight(null) / 2), null );
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
