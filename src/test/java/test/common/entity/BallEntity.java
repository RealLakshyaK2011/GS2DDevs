package test.common.entity;

import net.chauhanDevs.gsquad.GS2DDevs.physics.PhysicsAffectedObject;
import net.chauhanDevs.gsquad.GS2DDevs.physics.engine.PhysicsEngine;
import test.MainGame;
import test.client.entity.ClientPlayerEntity;
import test.graphic.model.BallModel;

import javax.sound.midi.spi.SoundbankReader;
import java.util.Random;

public final class BallEntity extends PhysicsAffectedObject {

    private final Random random = new Random();
    private long lastSpeedUp = 0;
    private int totalSpeedUps = 0;

    public BallEntity() {
        super();
        MODEL = new BallModel();
        this.y = this.x = 250;

        COLLUSION_BOX.width = 32;
        COLLUSION_BOX.height = 32;

        this.isMoving = true;
        this.angleOfMovingDirection = 95;
        this.setPixelPerSecondSpeed(275);
    }

    @Override
    public void onTickEvent() {
        if(totalSpeedUps > 0 && System.currentTimeMillis() - lastSpeedUp > 5000){
            lastSpeedUp = System.currentTimeMillis();
            totalSpeedUps--;
            this.setPixelPerSecondSpeed(this.getPixelPerSecondSpeed() - 150);
            System.out.println("Total Speed Ups: " + totalSpeedUps);
        }
        if(x >= 1000 - 16){
            PhysicsEngine.reflectOnSurface(this, 90 + random.nextInt( 7));
        }
        if(x <= 16){
            PhysicsEngine.reflectOnSurface(this, 90 + random.nextInt( 7));
        }
        if(y <= 0){
            PhysicsEngine.reflectOnSurface(this, random.nextInt(-7, 7));
        }
        if(y >= 700){
            //PhysicsEngine.reflectOnSurface(this, random.nextInt(-7, 7));
            System.out.println("GAME OVER!");
            //EventBus.post(new GameOverEvent(MainGame.getGame().localPlayer));
            PhysicsEngine.unregister(this);
        }

    }

    @Override
    public void onCollusionEvent(PhysicsAffectedObject objectCollidedWith) {
        System.out.println("COLLUSION WITH PLAYER");
        if(objectCollidedWith instanceof PlayerEntity e){
            if(e.isDashing() && System.currentTimeMillis() - lastSpeedUp >= 1000){

                lastSpeedUp = System.currentTimeMillis();
                this.totalSpeedUps++;
                this.setPixelPerSecondSpeed(this.getPixelPerSecondSpeed() + 150);
                if(e instanceof ClientPlayerEntity){
                    this.y -= 50;
                }else{
                    this.y += 50;
                }
            }
            int distFromCenter = (int) (e.getX() - getX());
            PhysicsEngine.reflectOnSurface(this, (int) (random.nextInt(-3, 3) + distFromCenter / 2.5));
        }
    }
}
