package test.graphic;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.AbstractGameWindow;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends AbstractGameWindow {
    public GameWindow(){
        Dimension dimension = new Dimension(1000, 650);
        this.setResizable(false);
        this.add(new GamePanel(dimension));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
