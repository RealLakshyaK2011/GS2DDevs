package net.chauhanDevs.gsquad.GS2DDevs.graphics.model;

import java.util.ArrayList;


public abstract class Model {
    protected final java.util.List<ModelPart> parts = new ArrayList<>();

    protected Model(){}

    public java.util.List<ModelPart> getParts(){
        return parts;
    }
}
