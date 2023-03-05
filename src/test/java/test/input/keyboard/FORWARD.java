package test.input.keyboard;

import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBinding;
import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBoardInput;

import java.awt.event.KeyEvent;

public class FORWARD implements KeyBinding {
    public static boolean isPressed = false;

    public FORWARD(){
        KeyBoardInput.register(this);
    }

    @Override
    public int getKeyCode() {
        return KeyEvent.VK_D;
    }

    @Override
    public void onPress() {isPressed = true;}

    @Override
    public void onRelease() {isPressed = false;}
}
