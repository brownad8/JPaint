package controller;
import java.util.List;
import model.interfaces.IShape;
import model.persistence.ShapeList;
import model.interfaces.IApplicationState;

import model.persistence.ApplicationState;

public class DeleteShapeCommand implements ICommand {

    private IApplicationState appState;

    public DeleteShapeCommand(IApplicationState appState){
        this.appState = appState;
    }

    @Override
    public void run() {
        ShapeList selectedShapes = appState.getSelectedShapes();
        List<IShape> currentlySelectedShapes = selectedShapes.getIterable();

        for (IShape shape : currentlySelectedShapes)
            appState.removeFromShapeList(shape);

        appState.emptySelectedShapes();

    }
}
