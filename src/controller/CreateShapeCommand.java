package controller;

import model.persistence.ApplicationState;
import model.persistence.Point;
import model.persistence.ShapeConfiguration;
import model.interfaces.IShape;
import model.ShapeType;
import model.persistence.ShapeFactory;

public class CreateShapeCommand implements ICommand{

    private ApplicationState appState;
    private Point startPoint;
    private Point endPoint;
    private  ShapeConfiguration shapeConfiguration;

    public CreateShapeCommand(ApplicationState appState, Point startPoint, Point endPoint){
        this.appState = appState;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeConfiguration = appState.getCurrentShapeConfiguration();
    }

    @Override
    public void run() {
        IShape shape = null;

        if(appState.getActiveShapeType() == ShapeType.ELLIPSE){
            shape = ShapeFactory.createEllipse(startPoint, endPoint, shapeConfiguration);
        }else if(appState.getActiveShapeType() == ShapeType.RECTANGLE){
            shape = ShapeFactory.createRectangle(startPoint, endPoint, shapeConfiguration);
        }else if (appState.getActiveShapeType() == ShapeType.TRIANGLE){
            shape = ShapeFactory.createTriangle(startPoint, endPoint, shapeConfiguration);
        }
        appState.shapeList.addShape(shape);
    }
}
