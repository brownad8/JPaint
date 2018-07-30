package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

class Rectangle implements IShape {

    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;

    public Rectangle(Point startPoint, Point endPoint, ShapeConfiguration sc){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = sc.getShapeType();
        this.primaryColor = sc.getPrimaryColor();
        this.secondaryColor = sc.getSecondaryColor();
        this.shadingType = sc.getShadingType();
    }

    public String toString(){
        return "Rectangle";
    }

    public void drawShape(){
        //to be implemented
    }

}