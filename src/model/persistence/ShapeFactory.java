package model.persistence;

import model.interfaces.IShape;

public class ShapeFactory {

    public static IShape createEllipse(Point startPoint, Point endPoint, ShapeConfiguration sc){
        return new Ellipse(startPoint, endPoint, sc);
    }

    public static IShape createRectangle(Point startPoint, Point endPoint, ShapeConfiguration sc){
        return new Rectangle(startPoint, endPoint, sc);
    }

    public static IShape createTriangle(Point startPoint, Point endPoint, ShapeConfiguration sc){
        return new Triangle(startPoint, endPoint, sc);
    }
}
