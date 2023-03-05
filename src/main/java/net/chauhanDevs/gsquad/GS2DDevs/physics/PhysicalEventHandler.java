package net.chauhanDevs.gsquad.GS2DDevs.physics;

/**
 * These All Are The Physical Events Like Collusion Event,
 * You May Code Your Own In Game Events Your Self In Your Own Style, For Instance: onEnemyDied();
 */
public final class PhysicalEventHandler {

    public void handleCollusionEvent(PhysicsAffectedObject object){
        object.onCollusionEvent(object);
    }
}
