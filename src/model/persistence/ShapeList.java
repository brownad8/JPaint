package model.persistence;

import java.util.ArrayList;
import model.interfaces.IShape;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import controller.IObserver;

final public class ShapeList {

    private List<IShape> sl;
    private List<IObserver> observers = new LinkedList<IObserver>();

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

        for(IObserver observer : observers)
            observer.update();
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

    public void registerObserver(IObserver observer){
        observers.add(observer);
    }

    public List getIterable(){
        return sl;
    }

}
