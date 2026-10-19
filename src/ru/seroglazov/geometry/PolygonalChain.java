package ru.seroglazov.geometry;

import ru.seroglazov.validation.Validate;

public class PolygonalChain implements PolyLinable {
    private Point topLeft;
    private int side;

    public PolygonalChain(Point topLeft, int side) {
        Validate.isNullException("Передайте существующую точку левого верхнего угла.", topLeft);
        Validate.isZeroNegativeException("Сторона квадрата должна быть положительной.", side);
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.side = side;
    }

    public PolygonalChain(int x, int y, int side) {
        this(new Point(x, y), side);
    }

    //region getters

    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    public int getSide() {
        return side;
    }

    //endregion

    //region setters

    public void setSide(int side) {
        Validate.isZeroNegativeException("Сторона квадрата должна быть положительной.", side);
        this.side = side;
    }

    //endregion

    public PolygonalLine getPolyLine() {
        int x = topLeft.getX();
        int y = topLeft.getY();
        return new ClosedPolygonalLine(
                new Point(x, y),
                new Point(x + side, y),
                new Point(x + side, y + side),
                new Point(x, y + side));
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + side;
    }
}