package net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard;


public interface KeyBinding {
    /**
     * @return Returns The Key For This KeyBind<br>If You Don't know About The Keycode For Key, Then You May Do Like This For Eg:<br>
     * return KeyEvent.VK_TAB; for Tab Key
     */
    int getKeyCode();

    /**
     * Method Called When Key Is Pressed
     */
    void onPress();

    /**
     * Method Called When Key Is Released
     */
    void onRelease();
}
