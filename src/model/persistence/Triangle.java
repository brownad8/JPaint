package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;

import java.awt.*;

class Triangle implements IShape {

    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;

    public Triangle(Point startPoint, Point endPoint, ShapeConfiguration sc){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = sc.getShapeType();
        this.primaryColor = sc.getPrimaryColor();
        this.secondaryColor = sc.getSecondaryColor();
        this.shadingType = sc.getShadingType();
    }

    public String toString(){
        return "Triangle";
    }

    public void drawShape(Graphics2D graphics2D){

        int startX = startPoint.getX();
        int startY = startPoint.getY();
        int endX = endPoint.getX();
        int endY = endPoint.getY();
        int[] xPoints = {startX, endX, startX};
        int[] yPoints = {startY, endY, endY};
        int nPoints = 3;
        Color primaryColorConverted = ShapeColorMap.getMappingForShapeColor(primaryColor);
        Color secondaryColorConverted = ShapeColorMap.getMappingForShapeColor(secondaryColor);

        if(shadingType != ShapeShadingType.OUTLINE) {
            graphics2D.setColor(primaryColorConverted);
            graphics2D.fillPolygon(xPoints, yPoints, nPoints);
        }

        if(shadingType != ShapeShadingType.FILLED_IN) {
            graphics2D.setStroke(new BasicStroke(5));
            graphics2D.setColor(secondaryColorConverted);
            graphics2D.drawPolygon(xPoints, yPoints, nPoints);
        }
    }

}
