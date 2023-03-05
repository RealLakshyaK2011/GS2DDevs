package test.client.entity;

import net.chauhanDevs.gsquad.GS2DDevs.math.GSMath;
import net.chauhanDevs.gsquad.GS2DDevs.physics.PhysicsAffectedObject;
import net.chauhanDevs.gsquad.GS2DDevs.physics.engine.PhysicsEngine;
import test.MainGame;
import test.common.entity.PlayerEntity;

import java.util.Random;

public final class OpponentPlayerEntity extends PlayerEntity {

    private final Random rank = new Random();
    private boolean canContinue = true;

    @Override
    protected void handlePosition() {
        this.setY(100);
        if(rank!=null) {
            if(MainGame.getGame().ballEntity.getY() > 650F / 2F || rank.nextInt(100) < 10) {
                if (MainGame.getGame().ballEntity.getX() - 16 > getX() + 64 - rank.nextInt(24) && canContinue) {
                    this.setMoving(true);
                } else if (MainGame.getGame().ballEntity.getX() + 16 < getX() - 64 + rank.nextInt(25) && canContinue) {
                    this.setMoving(true);
                } else {
                    this.setMoving(false);
                }
            }
        }else System.out.println("RANDOM IS NULL");
        this.setAngleOfMovingDirection(MainGame.getGame().ballEntity.getX() < getX() ? 180 : 0);
    }

    @Override
    public void onCollusionEvent(PhysicsAffectedObject objectCollidedWith) {
        canContinue = true;
    }
}
