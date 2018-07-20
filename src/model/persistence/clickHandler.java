package model.persistence;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clickHandler extends MouseAdapter {

    @Override
    public void mousePressed(MouseEvent e){

        Point start = new Point(e.getX(), e.getY());
        System.out.println("Starting point: x = " + start.getX() + ", y = " + start.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e){

        Point end = new Point(e.getX(), e.getY());
        System.out.println("Ending point: x = " + end.getX() + ", y = " + end.getY());
    }
}
