package controller;

import model.ShapeType;
import model.interfaces.IApplicationState;
import model.persistence.Point;
import model.persistence.ShapeConfiguration;
import model.persistence.ShapeList;
import model.persistence.Point;
import model.persistence.ShapeConfiguration;
import model.ShapeType;
import model.persistence.ShapeFactory;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import model.interfaces.IShape;

public class PasteShapeCommand implements ICommand, IUndoable {

    private IApplicationState appState;
    private List<IShape> pastedShapes;
    private List<IShape> forRedo;

    public PasteShapeCommand(IApplicationState appState){
        this.appState = appState;
        this.pastedShapes = new ArrayList<IShape>();
        this.forRedo = new ArrayList<IShape>();
    }

    @Override
    public void run() {
        ShapeList clipboard = appState.getClipboard();
        List<IShape> clipboardShapes = clipboard.getIterable();
        List<IShape> shapesToPaste = new ArrayList<IShape>();
        IShape shapeToPaste = null;
        Point newStartPoint = new Point(0, 0);

        for (IShape shape : clipboardShapes){
            int newEndX = (shape.getEndPoint().getX()) - (shape.getStartPoint().getX());
            int newEndY = (shape.getEndPoint().getY()) - (shape.getStartPoint().getY());
            Point newEndPoint = new Point(newEndX, newEndY);
            ShapeConfiguration sc = shape.getShapeConfiguration();

            if (shape.getShapeType() == ShapeType.ELLIPSE)
                shapeToPaste = ShapeFactory.createEllipse(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.RECTANGLE)
                shapeToPaste = ShapeFactory.createRectangle(newStartPoint, newEndPoint, sc);
            else if (shape.getShapeType() == ShapeType.TRIANGLE)
                shapeToPaste = ShapeFactory.createTriangle(newStartPoint, newEndPoint, sc);

            shapesToPaste.add(shapeToPaste);

        }

        for (IShape shape : shapesToPaste){
            appState.addToShapeList(shape);
            pastedShapes.add(shape);
        }

        CommandHistory.add(this);

    }

    @Override
    public void undo() {

        for (IShape shape : pastedShapes){
            appState.removeFromShapeList(shape);
            forRedo.add(shape);
        }
        pastedShapes.clear();
    }

    @Override
    public void redo() {

        for (IShape shape : forRedo){
            appState.addToShapeList(shape);
            pastedShapes.add(shape);
        }
        forRedo.clear();
    }
}
