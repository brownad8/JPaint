package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public class ShapeConfiguration {

    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;

    public ShapeConfiguration(ShapeType st, ShapeColor pc, ShapeColor sc, ShapeShadingType sst){
        this.shapeType = st;
        this.primaryColor = pc;
        this.secondaryColor = sc;
        this.shadingType = sst;
    }

    public ShapeType getShapeType(){return shapeType;}

    public ShapeColor getPrimaryColor(){return primaryColor;}

    public ShapeColor getSecondaryColor(){return secondaryColor;}

    public ShapeShadingType getShadingType(){return shadingType;}

}
