package test.graphic;

import net.chauhanDevs.gsquad.GS2DDevs.graphics.image.RenderAbleImage;
import net.chauhanDevs.gsquad.GS2DDevs.math.GSMath;
import net.chauhanDevs.gsquad.GS2DDevs.renderer.RenderingEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class FillAbleBar{
    private final RenderAbleImage BarBackground;
    private final RenderAbleImage BarFilling;
    private final BufferedImage RealBarFilling;
    private final DecreasingSide decreasingSide;
    private final int xOffset;
    private final int yOffset;
    private int percentFilled = 100;

    public FillAbleBar(BufferedImage BarBackground, BufferedImage BarFillingImage, int x, int y, int xOffset, int yOffset, DecreasingSide decreasingSide, boolean autoRegister){
        this.decreasingSide = decreasingSide;
        this.BarBackground = new RenderAbleImage(x, y, BarBackground);
        this.BarFilling = new RenderAbleImage(x + xOffset, y + yOffset, BarFillingImage);
        this.RealBarFilling = BarFillingImage;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        if(autoRegister){
            RenderingEngine.register(this.BarBackground);
            RenderingEngine.register(this.BarFilling);
        }
        adjust();
    }

    public void increase(int percent){
        if(percent < 1){
            throw new IllegalArgumentException("Increased Percentage Cant Be Less Than 1");
        }
        if(!(percentFilled + percent > 100)){
            this.percentFilled += percent;
        }else{
            this.percentFilled = 100;
        }
        adjust();
    }

    public void decrease(int percent){
        System.out.println("DECREASE!");
        if(percent < 1){
            throw new IllegalArgumentException("Decreased Percentage Cant Be Less Than 1");
        }
        if(!(percentFilled - percent < 0)){
            this.percentFilled -= percent;
        }else{
            this.percentFilled = 0;
        }
        adjust();
    }

    public void setPercentageFilled(int percent){
        if(percent < 0 || percent > 100){
            throw new IllegalArgumentException("Percentage Can't Be Greater Than 100 Or Less Than 0,\nYou Have Given: " + percent);
        }
        this.percentFilled = percent;
        adjust();
    }

    public int getPercentageFilled() {
        return percentFilled;
    }

    public boolean isEmpty(){
        return percentFilled < 1;
    }

    private void adjust(){

        int leftAreaWidth = RealBarFilling.getWidth() - BarFilling.getImage().getWidth(null);
        int width = (int) GSMath.percentOf(percentFilled,RealBarFilling.getWidth());

        if(width <= 0){
            width = 1;
        }

        Image finalImage = RealBarFilling.getSubimage(0,0, width, RealBarFilling.getHeight());
        BarFilling.setImage(finalImage);
        if(decreasingSide == DecreasingSide.RIGHT_TO_LEFT) {
            BarFilling.setX((BarBackground.getX() + xOffset) - leftAreaWidth/2);
        }else if(decreasingSide == DecreasingSide.LEFT_TO_RIGHT){
            BarFilling.setX((BarBackground.getX() + xOffset) + leftAreaWidth/2);
        }
    }


    public enum DecreasingSide{
        LEFT_TO_RIGHT, RIGHT_TO_LEFT;
    }
}
