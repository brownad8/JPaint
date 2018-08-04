package model.persistence;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.CreateShapeCommand;
import controller.ICommand;
import model.StartAndEndPointMode;

public class clickHandler extends MouseAdapter {
    Point mousePressedPoint;
    Point mouseResleasedPoint;
    Point startPoint;
    Point endPoint;
    ApplicationState appState;

    public clickHandler(ApplicationState appState){
        this.appState = appState;
    }

    @Override
    public void mousePressed(MouseEvent e){

        mousePressedPoint = new Point(e.getX(), e.getY());
        //System.out.println("Mouse pressed: x = " + mousePressedPoint.getX() + ", y = " + mousePressedPoint.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){

        ICommand command = null;
        StartAndEndPointMode startAndEndPointMode = appState.getActiveStartAndEndPointMode();
        mouseResleasedPoint = new Point(e.getX(), e.getY());
        int minX; int minY; int maxX; int maxY;

        if(mousePressedPoint.getX() < mouseResleasedPoint.getX()){
            minX = mousePressedPoint.getX();
            maxX = mouseResleasedPoint.getX();
        }else{
            minX = mouseResleasedPoint.getX();
            maxX = mousePressedPoint.getX();
        }

        if(mousePressedPoint.getY() < mouseResleasedPoint.getY()){
            minY = mousePressedPoint.getY();
            maxY = mouseResleasedPoint.getY();
        }else{
            minY = mouseResleasedPoint.getY();
            maxY = mousePressedPoint.getY();
        }

        startPoint = new Point(minX, minY);
        endPoint = new Point(maxX, maxY);

        if(startAndEndPointMode == StartAndEndPointMode.DRAW){
            command = new CreateShapeCommand(appState, startPoint, endPoint);
        }

        command.run();

        //System.out.println("Mouse released: x = " + mouseResleasedPoint.getX() + ", y = " + mouseResleasedPoint.getY());
        //System.out.println("Start Point: x = " + startPoint.getX() + ", y = " + startPoint.getY());
        //System.out.println("End Point: x = " + endPoint.getX() + ", y = " + endPoint.getY());
        //System.out.print("\n");
        //Graphics2D graphics2D = (Graphics2D)e.getComponent().getGraphics();
        //graphics2D.setColor(Color.black);
        //graphics2D.fillRect(12, 13, 200, 400);
        //graphics2D.setStroke(new BasicStroke(5));
        //graphics2D.setColor(Color.blue);
        //graphics2D.drawRect(12,13, 200, 400);
    }
}
