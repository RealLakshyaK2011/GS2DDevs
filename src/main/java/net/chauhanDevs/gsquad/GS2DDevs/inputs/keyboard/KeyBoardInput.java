package net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyBoardInput implements KeyListener {

    private static final List<KeyBinding> KEY_BINDINGS = new ArrayList<>();

    public static void register(KeyBinding keyBinding){
        KEY_BINDINGS.add(keyBinding);
    }

    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        for (var kb : KEY_BINDINGS) {
            if(kb.getKeyCode() == e.getKeyCode()){
                kb.onPress();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (var kb : KEY_BINDINGS) {
            if(kb.getKeyCode() == e.getKeyCode()){
                kb.onRelease();
            }
        }
    }
}
