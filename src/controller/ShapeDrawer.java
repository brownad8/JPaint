package controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics2D;
import model.persistence.ShapeList;
import model.interfaces.IShape;

public class ShapeDrawer implements IObserver{

    private ShapeList shapeList;
    private Graphics2D graphics2D;

    public  ShapeDrawer(ShapeList shapeList, Graphics2D graphics2D){
        this.shapeList = shapeList;
        this.graphics2D = graphics2D;
    }

    @Override
    public void update() {
        List<IShape> iterableShapeList = shapeList.getIterable();

        for(IShape shape : iterableShapeList)
            shape.drawShape(graphics2D);
    }
}
