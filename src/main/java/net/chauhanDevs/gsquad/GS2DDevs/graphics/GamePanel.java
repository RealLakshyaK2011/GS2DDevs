package net.chauhanDevs.gsquad.GS2DDevs.graphics;

import net.chauhanDevs.gsquad.GS2DDevs.inputs.keyboard.KeyBoardInput;
import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderAbleObject;
import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderingEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class GamePanel extends JPanel {



    private static GamePanel gamePanel;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        RenderingEngine.render(g);
    }

    public GamePanel(Dimension size){
        gamePanel = this;
        this.setPreferredSize(size);
        addKeyListener(new KeyBoardInput());

    }



    public static GamePanel getGamePanel() {
        return gamePanel;
    }


}
