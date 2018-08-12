package controller;

import model.persistence.*;

import java.util.List;
import java.util.ArrayList;
import model.interfaces.IShape;
import model.ShapeType;

public class MoveShapeCommand implements ICommand, IUndoable {

    private ApplicationState appState;
    private List<IShape> originalShapes;
    private List<IShape> newShapes;

    public MoveShapeCommand(ApplicationState appState){
        this.appState = appState;
        this.originalShapes = new ArrayList<IShape>();
        this.newShapes = new ArrayList<IShape>();
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

            originalShapes.add(shape);

            if (shape.getShapeType() == ShapeType.ELLIPSE)
                shapeToMove = ShapeFactory.createEllipse(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.RECTANGLE)
                shapeToMove = ShapeFactory.createRectangle(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.TRIANGLE)
                shapeToMove = ShapeFactory.createTriangle(newStartPoint, newEndPoint, sc);

            movedShapes.add(shapeToMove);
            newShapes.add(shapeToMove);
        }

        for (IShape shape : currentlySelectedShapes)
            appState.shapeList.removeShape(shape);

        for (IShape shape : movedShapes)
            appState.shapeList.addShape(shape);

        appState.selectedShapes = new ShapeList();

        //for (IShape shape : movedShapes)
        //    appState.selectedShapes.addShape(shape);

        CommandHistory.add(this);
    }

    @Override
    public void undo() {

        for (IShape shape : newShapes)
            appState.shapeList.removeShape(shape);

        for (IShape shape : originalShapes)
            appState.shapeList.addShape(shape);
    }

    @Override
    public void redo() {

        for (IShape shape : originalShapes)
            appState.shapeList.removeShape(shape);

        for (IShape shape : newShapes)
            appState.shapeList.addShape(shape);
    }
}
