package model.interfaces;

import model.ShapeType;
import model.persistence.ShapeConfiguration;
import model.persistence.Point;

import java.awt.*;

public interface IShape {

    String toString();

    void drawShape(Graphics2D graphics2D);

    Point getStartPoint();

    Point getEndPoint();

    ShapeConfiguration getShapeConfiguration();

    ShapeType getShapeType();

    Rectangle getBoundingBox();
}
