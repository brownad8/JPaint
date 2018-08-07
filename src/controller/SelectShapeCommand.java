package controller;

import model.persistence.ApplicationState;
import model.persistence.Point;
import model.interfaces.IShape;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import model.persistence.ShapeList;

public class SelectShapeCommand implements ICommand {

    private ApplicationState appState;
    private Point startPoint;
    private Point endPoint;
    private Rectangle selectedArea;

    public SelectShapeCommand(ApplicationState appState, Point startPoint, Point endPoint){
        this.appState = appState;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.selectedArea = new Rectangle(startPoint.getX(), startPoint.getY(),
                endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }

    @Override
    public void run() {
        List<IShape> currentSelectedShapes = new ArrayList<IShape>();
        List<IShape> shapesOnCanvas = appState.shapeList.getIterable();
        ShapeList newGlobalSelectedShapesShapeList = new ShapeList();

        for(IShape shape : shapesOnCanvas)
            if(shape.getBoundingBox().intersects(selectedArea))
                currentSelectedShapes.add(shape);

        for(IShape shape : currentSelectedShapes)
            newGlobalSelectedShapesShapeList.addShape(shape);

        appState.selectedShapes = newGlobalSelectedShapesShapeList;

        //for(IShape shape : currentSelectedShapes)
        //    System.out.println(shape.toString());

        //if(newGlobalSelectedShapesShapeList.isEmpty())
        //    System.out.println("List empty, shapes deselected with click");
    }
}
