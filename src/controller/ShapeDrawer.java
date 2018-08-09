package controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics2D;
import model.persistence.ShapeList;
import model.interfaces.IShape;
import model.ShapeType;
import model.ShapeColor;
import model.ShapeShadingType;
import model.persistence.ShapeConfiguration;
import model.persistence.Point;
import model.persistence.ShapeFactory;

public class ShapeDrawer implements IObserver{

    private ShapeList shapeList;
    private Graphics2D graphics2D;

    public  ShapeDrawer(ShapeList shapeList, Graphics2D graphics2D){
        this.shapeList = shapeList;
        this.graphics2D = graphics2D;
    }

    @Override
    public void update() {

        ShapeType st = ShapeType.RECTANGLE;
        ShapeColor pc = ShapeColor.WHITE;
        ShapeColor sc = ShapeColor.WHITE;
        ShapeShadingType sst = ShapeShadingType.FILLED_IN;
        ShapeConfiguration shapeConfiguration = new ShapeConfiguration(st, pc, sc, sst);
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(800, 1200);

        IShape clearCanvas = ShapeFactory.createRectangle(startPoint, endPoint, shapeConfiguration);
        clearCanvas.drawShape(graphics2D);

        List<IShape> iterableShapeList = shapeList.getIterable();

        for(IShape shape : iterableShapeList)
            shape.drawShape(graphics2D);
    }
}
