package model.interfaces;

import java.awt.*;

public interface IShape {

    String toString();

    void drawShape(Graphics2D graphics2D);

    Rectangle getBoundingBox();
}
