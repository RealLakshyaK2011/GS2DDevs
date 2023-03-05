package test.common.entity;

import net.chauhanDevs.gsquad.GS2DDevs.physics.PhysicsAffectedObject;
import test.MainGame;
import test.graphic.model.PlayerModel;

public abstract class PlayerEntity extends PhysicsAffectedObject {



    protected boolean isDashing = false;
    protected long onLastDashStart = 0;
    protected int dashPosY;
    protected int sprintSpeed = 600;
    protected final int staticPosY;
    protected final int staticSpeed;

    public PlayerEntity(){
        super();
        MODEL = new PlayerModel();
        this.y = MainGame.getWindow().getHeight()-200;
        this.x = MainGame.getWindow().getWidth() / 2F;
        this.dashPosY = (int) (y + 15);
        this.staticPosY = (int) y;

        COLLUSION_BOX.height = 32;
        COLLUSION_BOX.width = 128;
        this.setPixelPerSecondSpeed(350);
        this.staticSpeed = (int) getPixelPerSecondSpeed();

        setPhysicsMoveAble(false);
        setCanMoveAnywhere(true);
    }

    @Override
    public void onTickEvent() {
        handlePosition();
        if(isDashing() && System.currentTimeMillis() - getOnLastDashStart() >= 1000){
            setDashing(false);
            this.setY(getStaticPosY());
        }
    }

    public int getDashPosY() {
        return dashPosY;
    }

    public int getSprintSpeed() {
        return sprintSpeed;
    }

    public int getStaticPosY() {
        return staticPosY;
    }

    public long getOnLastDashStart() {
        return onLastDashStart;
    }

    public boolean isDashing() {
        return isDashing;
    }

    public void setDashing(boolean dashing) {
        setOnLastDashStart(System.currentTimeMillis());
        isDashing = dashing;
    }

    public void dash(){
        if(!isDashing()){
            setDashing(true);
            this.setY(getDashPosY());
        }
    }

    public void setSprintSpeed(int sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public void setOnLastDashStart(long onLastDashStart) {
        this.onLastDashStart = onLastDashStart;
    }

    @Override
    public void onCollusionEvent(PhysicsAffectedObject objectCollidedWith) {
        if(objectCollidedWith instanceof BallEntity && isDashing()){
            this.setY(getStaticPosY());
        }
    }

    protected abstract void handlePosition();
}
