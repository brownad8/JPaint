package model.persistence;

import java.util.ArrayList;
import model.interfaces.IShape;

final public class ShapeList {

    final private ArrayList sl;

    public ShapeList(){
        sl = new ArrayList<IShape>();
    }

    public boolean isEmpty(){
        return sl.isEmpty();
    }

    public void addShape(IShape shape) throws IllegalArgumentException{
        if(shape == null)
            throw new IllegalArgumentException();
        sl.add(shape);
    }

    public void removeShape(IShape shape) throws IllegalArgumentException, IllegalStateException{
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
