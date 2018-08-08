package model.persistence;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IShape;
import model.persistence.ShapeConfiguration;

import java.awt.*;
import java.awt.Rectangle;

class Triangle implements IShape {

    private Point startPoint;
    private Point endPoint;
    private ShapeType shapeType;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private ShapeShadingType shadingType;
    private Rectangle boundingBox;
    private ShapeConfiguration shapeConfiguration;

    public Triangle(Point startPoint, Point endPoint, ShapeConfiguration sc){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeType = sc.getShapeType();
        this.primaryColor = sc.getPrimaryColor();
        this.secondaryColor = sc.getSecondaryColor();
        this.shadingType = sc.getShadingType();
        this.boundingBox = new Rectangle(startPoint.getX(), startPoint.getY(),
                endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
        this.shapeConfiguration = sc;
    }

    public String toString(){
        return "Triangle";
    }

    public Point getStartPoint() { return startPoint; }

    public Point getEndPoint() {return endPoint;}

    public ShapeConfiguration getShapeConfiguration() { return shapeConfiguration;}

    public ShapeType getShapeType() { return shapeType;}

    public Rectangle getBoundingBox() { return boundingBox; }

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

        graphics2D.setColor(primaryColorConverted);
        graphics2D.setStroke(new BasicStroke(5));

        if(shadingType == ShapeShadingType.FILLED_IN)
            graphics2D.fillPolygon(xPoints, yPoints, nPoints);
        else if(shadingType == ShapeShadingType.OUTLINE)
            graphics2D.drawPolygon(xPoints, yPoints, nPoints);
        else if(shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN){
            graphics2D.fillPolygon(xPoints, yPoints, nPoints);
            graphics2D.setColor(secondaryColorConverted);
            graphics2D.drawPolygon(xPoints, yPoints, nPoints);
        }
    }

}
