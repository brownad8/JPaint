package model.persistence;

public class Point {

    private final Integer x;
    private final Integer y;

    public Point(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public String toString(){
        return "x = " + x + ", y = " + y;
    }

}
