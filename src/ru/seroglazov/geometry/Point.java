package ru.seroglazov.geometry;

public class Point {
    private int x;
    private int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }


    //region getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    //endregion

    //region setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    //endregion


    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Point other)) return false;
        return other.x == this.x && other.y == this.y;
    }

    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }
}
