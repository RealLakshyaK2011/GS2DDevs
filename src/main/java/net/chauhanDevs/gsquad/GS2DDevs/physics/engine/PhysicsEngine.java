package net.chauhanDevs.gsquad.GS2DDevs.physics.engine;

import net.chauhanDevs.gsquad.GS2DDevs.math.GSMath;
import net.chauhanDevs.gsquad.GS2DDevs.physics.PhysicsAffectedObject;
import net.chauhanDevs.gsquad.GS2DDevs.thread.GameLoopThread;

import java.util.ArrayList;
import java.util.List;

public final class PhysicsEngine {

    private static List<PhysicsAffectedObject> PhysicsAffectedObjects = new ArrayList<>();
    private static volatile PhysicsAffectedObject objectToRemove;
    private static volatile PhysicsAffectedObject objectToAdd;

    public static void simulate(){
        if(objectToAdd != null){
            PhysicsAffectedObjects.add(objectToAdd);
            objectToAdd = null;
        }
        if(objectToRemove != null){
            PhysicsAffectedObjects.remove(objectToRemove);
            objectToRemove = null;
        }
        for (PhysicsAffectedObject object : PhysicsAffectedObjects) {
            if(object != null){
                if(object.isMoving()){
                    move(object, object.getX(), object.getY(), object.getAngleOfMovingDirection(),
                            object.getPixelPerSecondSpeed() / GameLoopThread.getMaxFPS());
                }
                object.onTickEvent();
                resolveAndCheckForObjectCollisions();
            }
        }
    }

    public static boolean canMoveThere(PhysicsAffectedObject o, double x, double y){
        double tX = o.getX();
        double tY = o.getY();
        o.setX(x);
        o.setY(y);
        for (PhysicsAffectedObject obj : PhysicsAffectedObjects) {
            if(obj != o && !isCollidingWithOrIsInsideAnother(o, obj, true)){
                return true;
            }
        }
        o.setX(tX);
        o.setY(tY);
        return false;
    }

    public static void move(PhysicsAffectedObject object, double fromX, double fromY, int angleOfDirection, double distanceInPixel){
        double x = (fromX + (distanceInPixel * Math.cos(Math.toRadians(angleOfDirection))));
        double y = (fromY + (distanceInPixel * Math.sin(Math.toRadians(angleOfDirection))));
        if(object.canMoveAnywhere()) {
            object.setX(x);
            object.setY(y);
        }else{
            /*while (!canMoveThere(object, x, y)) {
                x = (fromX + (--distanceInPixel * Math.cos(Math.toRadians(angleOfDirection))));
                y = (fromY + (--distanceInPixel * Math.sin(Math.toRadians(angleOfDirection))));
            }*/
            object.setX(x);
            object.setY(y);
        }
    }

    public static void reflectOnSurface(PhysicsAffectedObject object, int surfaceAngle){
        int predictedAngle = (object.getAngleOfMovingDirection() - (object.getAngleOfMovingDirection()) * 2) - surfaceAngle * 2;
        if(predictedAngle < 0){
            object.setAngleOfMovingDirection(GSMath.negativeAngleToPositiveAngle(predictedAngle));
        }else{
            object.setAngleOfMovingDirection(predictedAngle);
        }
    }



    public static void resolveAndCheckForObjectCollisions(){
        for (var obj1 : PhysicsAffectedObjects) {
            for (var obj2 : PhysicsAffectedObjects) {
                if(obj1 != obj2 && isCollidingWithOrIsInsideAnother(obj1, obj2, false)){
                    resolveCollusion(obj1, obj2);
                    obj1.onCollusionEvent(obj2);
                    obj2.onCollusionEvent(obj1);
                }
            }
        }
    }
    
    public static boolean isCollidingWithOrIsInsideAnother(PhysicsAffectedObject obj1,
                                                           PhysicsAffectedObject obj2, boolean isInsideMethod){
        int _1X = (int) (obj1.getCollusionBox().getWidth() / 2);
        int _1Y = (int) (obj1.getCollusionBox().getHeight() / 2);
        int _2X = (int) (obj2.getCollusionBox().getWidth() / 2);
        int _2Y = (int) (obj2.getCollusionBox().getHeight() / 2);
        if(isInsideMethod){
            return (obj1.getY() + _1Y > obj2.getY() - _2Y
                    && obj1.getY() - _1Y < obj2.getY() + _2Y)
                    && (obj1.getX() + _1X > obj2.getX() - _2X
                    && obj1.getX() - _1X < obj2.getX() + _2X);
        }else {
            return (obj1.getY() + _1Y >= obj2.getY() - _2Y
                    && obj1.getY() - _1Y <= obj2.getY() + _2Y)
                    && (obj1.getX() + _1X >= obj2.getX() - _2X
                    && obj1.getX() - _1X <= obj2.getX() + _2X);
        }
    }

    public static void resolveCollusion(PhysicsAffectedObject obj1, PhysicsAffectedObject obj2){
        if(isCollidingWithOrIsInsideAnother(obj1, obj2, true)){
            PhysicsAffectedObject moveAble = obj1.isPhysicsMoveAble() ? obj1 : obj2;
            PhysicsAffectedObject nonMoveAble = obj1.isPhysicsMoveAble() ? obj2 : obj1;
            if(moveAble.isMoving()){
                do {
                    moveAble.setCanMoveAnywhere(true);
                    int angle = -moveAble.getAngleOfMovingDirection();
                    int finalAngle = angle > -1 ? angle : GSMath.negativeAngleToPositiveAngle(angle);
                    move(moveAble,moveAble.getX(),moveAble.getY(),
                            finalAngle,1);
                }while (isCollidingWithOrIsInsideAnother(obj1, obj2, true));
            }
        }
    }

    public static void register(PhysicsAffectedObject object){
        while (objectToAdd != null) Thread.onSpinWait();
        objectToAdd = object;
    }

    public static void unregister(PhysicsAffectedObject object){
        while (objectToRemove != null) Thread.onSpinWait();
        objectToRemove = object;
    }
}
