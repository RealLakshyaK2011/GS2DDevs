package test.input.keyboard;

import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBinding;
import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBoardInput;

import java.awt.event.KeyEvent;

public class BACKWARD implements KeyBinding {

    public BACKWARD(){
        KeyBoardInput.register(this);
    }

    public static boolean isPressed = false;
    @Override
    public int getKeyCode() {
        return KeyEvent.VK_A;
    }

    @Override
    public void onPress() {
        isPressed = true;
    }

    @Override
    public void onRelease() {
        isPressed = false;
    }
}
