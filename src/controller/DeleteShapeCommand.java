package controller;
import java.util.List;
import model.interfaces.IShape;
import model.persistence.ShapeList;
import model.interfaces.IApplicationState;
import java.util.List;
import java.util.ArrayList;

import model.persistence.ApplicationState;

public class DeleteShapeCommand implements ICommand, IUndoable {

    private IApplicationState appState;
    private List<IShape> deletedShapes;
    private List<IShape> forRedo;

    public DeleteShapeCommand(IApplicationState appState){
        this.appState = appState;
        this.deletedShapes = new ArrayList<IShape>();
        this.forRedo = new ArrayList<IShape>();
    }

    @Override
    public void run() {
        ShapeList selectedShapes = appState.getSelectedShapes();
        List<IShape> currentlySelectedShapes = selectedShapes.getIterable();

        for (IShape shape : currentlySelectedShapes){
            appState.removeFromShapeList(shape);
            deletedShapes.add(shape);
        }

        appState.emptySelectedShapes();
        CommandHistory.add(this);

    }

    @Override
    public void undo() {
        for (IShape shape : deletedShapes){
            appState.addToShapeList(shape);
            forRedo.add(shape);
        }
        deletedShapes.clear();
    }

    @Override
    public void redo() {
        for (IShape shape : forRedo){
            appState.removeFromShapeList(shape);
            deletedShapes.add(shape);
        }
        forRedo.clear();
    }
}
