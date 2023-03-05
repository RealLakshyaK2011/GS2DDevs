package net.chauhanDevs.gsquad.GS2DDevs.thread;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.GamePanel;
import net.chauhanDevs.gsquad.GS2DDevs.physics.engine.PhysicsEngine;


public class GameLoopThread extends Thread{

    protected static int maxFPS = 120;

    @Override
    public void run() {
        this.setName("GameLoop Thread");

        long lastLoopOn = 0;
        while (true){
            if(System.nanoTime() - lastLoopOn > 1000000000 / maxFPS){
                lastLoopOn = System.nanoTime();
                //Simulating Physics
                PhysicsEngine.simulate();

                //Forking GamePanel.repaint() so it will call paintComponent() in it and will call render Method();
                GamePanel.getGamePanel().repaint();
            }
        }
    }

    public static int getMaxFPS() {
        return maxFPS;
    }

    public static void setMaxFPS(int m) {
        maxFPS = m;
    }
}
