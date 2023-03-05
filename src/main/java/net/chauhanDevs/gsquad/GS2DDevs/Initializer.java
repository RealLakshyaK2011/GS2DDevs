package net.chauhanDevs.gsquad.GS2DDevs;


import net.chauhanDevs.gsquad.GS2DDevs.thread.GameLoopThread;

public final class Initializer {
    public static void init(){
        System.out.println("Initializing And Starting RenderThread And Physics Thread Respectively...");
        new GameLoopThread().start();
    }
}
