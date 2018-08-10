package controller;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.ShapeList;
import java.util.List;

public class CopyShapeCommand implements ICommand {
    private IApplicationState appState;

    public CopyShapeCommand(IApplicationState appState){
        this.appState = appState;
    }

    @Override
    public void run() {
        ShapeList selectedShapes = appState.getSelectedShapes();
        List<IShape> currentlySelectedShapes = selectedShapes.getIterable();

        appState.emptyClipboard();

        for (IShape shape : currentlySelectedShapes)
            appState.addToClipboard(shape);
    }
}
