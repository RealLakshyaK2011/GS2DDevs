package test;

import test.common.events.GameOverEvent;
import test.event.EventBus;

public class EventHandler {

    public static void onGameOver(GameOverEvent event){
        System.out.println("WEEE, Someone Won!");
    }

    public static void init(){/*EventBus.registerEventMethod(EventHandler.class, "onGameOver");*/}
}
