package net.chauhanDevs.gsquad.GS2DDevs.physics;


import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderAbleObject;
import net.chauhanDevs.gsquad.GS2DDevs.physics.engine.PhysicsEngine;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public abstract class PhysicsAffectedObject extends RenderAbleObject {

    protected @NotNull Dimension COLLUSION_BOX = new Dimension((int) (getX() - 10), (int) (getY() - 10));

    protected boolean isPhysicsMoveAble = true;
    protected boolean canMoveAnywhere = false;
    protected boolean isMoving = false;
    protected int angleOfMovingDirection = 0;
    protected double pixelPerSecondSpeed = 0;

    protected PhysicsAffectedObject(){
        super();
        PhysicsEngine.register(this);
    }

    public boolean isPhysicsMoveAble() {
        return isPhysicsMoveAble;
    }

    public boolean canMoveAnywhere() {
        return canMoveAnywhere;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getAngleOfMovingDirection() {
        return angleOfMovingDirection;
    }

    public double getPixelPerSecondSpeed() {
        return pixelPerSecondSpeed;
    }

    public Dimension getCollusionBox() {
        return COLLUSION_BOX;
    }

    public void setPhysicsMoveAble(boolean physicsMoveAble) {
        isPhysicsMoveAble = physicsMoveAble;
    }

    public void setCanMoveAnywhere(boolean canMoveAnywhere) {
        this.canMoveAnywhere = canMoveAnywhere;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setAngleOfMovingDirection(int angleOfMovingDirection) {
        this.angleOfMovingDirection = angleOfMovingDirection;
    }

    public void setPixelPerSecondSpeed(double pixelPerSecondSpeed) {
        this.pixelPerSecondSpeed = pixelPerSecondSpeed;
    }

    /**
     * EVENTS!
     */


    public void onTickEvent(){};
    public void onCollusionEvent(PhysicsAffectedObject objectCollidedWith){}

}
