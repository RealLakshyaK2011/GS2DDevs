package test.input.keyboard;

import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBinding;
import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBoardInput;

import java.awt.event.KeyEvent;

public class DASH implements KeyBinding {

    public DASH(){
        KeyBoardInput.register(this);
    }

    @Override
    public int getKeyCode() {
        return KeyEvent.VK_SPACE;
    }

    public static boolean isPressed = false;

    @Override
    public void onPress() {
        isPressed = true;
    }

    @Override
    public void onRelease() {
        isPressed = false;
    }
}
