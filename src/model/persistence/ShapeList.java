package model.persistence;

import java.util.ArrayList;
import java.awt.*;

final public class ShapeList {

    final private ArrayList sl;

    public ShapeList(){
        sl = new ArrayList<Shape>();
    }

    public boolean isEmpty(){
        return sl.isEmpty();
    }

    public void addShape(Shape shape) throws IllegalArgumentException{
        if(shape == null)
            throw new IllegalArgumentException();
        sl.add(shape);
    }

    public void removeShape(Shape shape) throws IllegalArgumentException, IllegalStateException{
        if(!sl.contains(shape))
            throw new IllegalArgumentException();
        if(sl.isEmpty())
            throw new IllegalStateException();
        sl.remove(shape);
    }

    public int numShapes(){
        return sl.size();
    }
}
