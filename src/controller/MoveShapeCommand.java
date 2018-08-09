package controller;

import model.persistence.*;

import java.util.List;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.ShapeType;

public class MoveShapeCommand implements ICommand {

    private ApplicationState appState;

    public MoveShapeCommand(ApplicationState appState){
        this.appState = appState;
    }

    @Override
    public void run() {

        List<IShape> movedShapes = new ArrayList<IShape>();
        List<IShape> shapesOnCanvas = appState.shapeList.getIterable();
        List<IShape> currentlySelectedShapes = appState.selectedShapes.getIterable();
        IShape shapeToMove = null;


        for (IShape shape : currentlySelectedShapes) {
            int newStartX = shape.getStartPoint().getX() + 50;
            int newStartY = shape.getStartPoint().getY() + 50;
            int newEndX = shape.getEndPoint().getX() + 50;
            int newEndY = shape.getEndPoint().getY() + 50;
            Point newStartPoint = new Point(newStartX, newStartY);
            Point newEndPoint = new Point(newEndX, newEndY);
            ShapeConfiguration sc = shape.getShapeConfiguration();

            if (shape.getShapeType() == ShapeType.ELLIPSE)
                shapeToMove = ShapeFactory.createEllipse(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.RECTANGLE)
                shapeToMove = ShapeFactory.createRectangle(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.TRIANGLE)
                shapeToMove = ShapeFactory.createTriangle(newStartPoint, newEndPoint, sc);

            movedShapes.add(shapeToMove);

        }

        for (IShape shape : currentlySelectedShapes)
            appState.shapeList.removeShape(shape);

        for (IShape shape : movedShapes)
            appState.shapeList.addShape(shape);

        appState.selectedShapes = new ShapeList();

        //for (IShape shape : movedShapes)
        //    appState.selectedShapes.addShape(shape);
    }
}
