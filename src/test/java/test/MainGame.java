package test;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.GamePanel;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.RenderAbleImage;
import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderingEngine;
import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.utils.ImageUtils;
import test.client.entity.ClientPlayerEntity;
import test.client.entity.Enviroment;
import test.client.entity.OpponentPlayerEntity;
import test.common.entity.BallEntity;
import test.graphic.FillAbleBar;
import test.graphic.GameWindow;
import net.chauhanDevs.gsquad.GS2DDevs.Initializer;
import test.input.keyboard.BACKWARD;
import test.input.keyboard.DASH;
import test.input.keyboard.FORWARD;
import test.input.keyboard.SPRINT;

import java.awt.image.BufferedImage;
import java.io.IOException;

public final class MainGame{

    private static MainGame game;
    private static GameWindow window;

    public ClientPlayerEntity localPlayer;
    public BallEntity ballEntity;
    public FillAbleBar sprint_bar;

    private MainGame(){
        System.out.println("Initialising Game...");
        game = this;
        window = new GameWindow();

        Initializer.init();

        initControls();
        initEntities();
        initImages();
        Enviroment.init();
        EventHandler.init();

        GamePanel.getGamePanel().requestFocus();
    }

    private void initControls(){
        new BACKWARD();
        new FORWARD();
        new DASH();
        new SPRINT();
    }

    private void initEntities(){
        localPlayer = new ClientPlayerEntity();
        ballEntity = new BallEntity();
        RenderingEngine.register(localPlayer);
        RenderingEngine.register(ballEntity);
        RenderingEngine.register(new OpponentPlayerEntity());
    }

    private void initImages(){
        BufferedImage sbImage;
        try {
            sbImage = ImageUtils.getImageFromResource("sprites/sprint_bar.png");
        } catch (IOException e) {
            throw new RuntimeException("Can't Load Images");
        }

        //Registering
        sprint_bar = new FillAbleBar(sbImage.getSubimage(0,0,192,32),
                sbImage.getSubimage(0,34,150,24), 908-20,30, 17,0, FillAbleBar.DecreasingSide.RIGHT_TO_LEFT, true);
    }

    public static MainGame getGame() {return game;}

    public static GameWindow getWindow() {return window;}

    public static void main(String[] args) {new MainGame();}
}
