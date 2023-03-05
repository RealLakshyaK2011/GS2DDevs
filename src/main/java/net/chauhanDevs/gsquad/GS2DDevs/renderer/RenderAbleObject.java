package net.chauhanDevs.gsquad.GS2DDevs.renderer;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.GamePanel;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.model.Model;

public abstract class RenderAbleObject implements RenderAble{

    protected Model MODEL;

    protected double x = 0;
    protected double y = 0;

    protected RenderAbleObject(){
        RenderingEngine.register(this);
    }

    public Model getModel(){
        return MODEL;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
}
