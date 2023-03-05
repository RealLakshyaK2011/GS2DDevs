package test.client.entity;

import test.MainGame;
import test.common.entity.PlayerEntity;
import test.input.keyboard.BACKWARD;
import test.input.keyboard.DASH;
import test.input.keyboard.FORWARD;
import test.input.keyboard.SPRINT;

import java.util.Random;

public final class ClientPlayerEntity extends PlayerEntity {


    private final Random random = new Random();
    private int sprintRechargeLeft = 100;
    private long lastRecharged = 0;
    private long lastSprinted = 0;
    private boolean isRecharging = false;

    @Override
    public void onTickEvent() {
        super.onTickEvent();
        if (SPRINT.isPressed && isMoving() && sprintRechargeLeft != 0) {
            isRecharging = false;
            if (System.currentTimeMillis() - lastSprinted >= 50) {
                lastSprinted = System.currentTimeMillis();
                sprintRechargeLeft--;
            }
        } else {
            if (sprintRechargeLeft < 100 && !isRecharging && System.currentTimeMillis() - lastSprinted >= 3000) {
                isRecharging = true;
            }
            if (sprintRechargeLeft < 100 && isRecharging && System.currentTimeMillis() - lastRecharged >= 75) {
                lastRecharged = System.currentTimeMillis();
                sprintRechargeLeft++;
            }
        }
        if(MainGame.getGame().sprint_bar != null){
            MainGame.getGame().sprint_bar.setPercentageFilled(sprintRechargeLeft);
        }
    }

    @Override
    protected void handlePosition() {
        if (SPRINT.isPressed && sprintRechargeLeft != 0) {
            int r = 0;
            if(random != null){
                random.nextInt(-10, 10);
            }
            this.setPixelPerSecondSpeed(getSprintSpeed() + r);
        } else {
            this.setPixelPerSecondSpeed(staticSpeed);
        }

        if (DASH.isPressed && !isDashing()) {
            this.dash();
        }
        if (FORWARD.isPressed && !(getX() > 1000)) {
            this.setMoving(true);
            this.setAngleOfMovingDirection(0);
        } else if (BACKWARD.isPressed && !(getX() < 0)) {
            this.setMoving(true);
            this.setAngleOfMovingDirection(180);
        } else {
            this.setMoving(false);
        }
    }
}
