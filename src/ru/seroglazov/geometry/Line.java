package ru.seroglazov.geometry;

import ru.seroglazov.validation.Validate;

public class Line implements Lengthable {
    private static final Point DEFAULT_POINT = new Point(0, 0);
    private Point start;
    private Point end;

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public Line(Point start, Point end) {
        this(check(start).getX(), check(start).getY(), check(end).getX(), check(end).getY());
    }

    private static Point check(Point point) {
        if (Validate.isNull(point)) {
            return DEFAULT_POINT;
        }
        return point;
    }

    //region getters

    public Point getStart() {
        return new Point(start.getX(), start.getY());
    }

    public Point getEnd() {
        return new Point(end.getX(), end.getY());
    }

    //endregion

    //region setters
    public void setStart(Point start) {
        this.setStart(check(start).getX(), check(start).getY());
    }

    public void setEnd(Point end) {
        this.setEnd(check(end).getX(), check(end).getY());
    }

    public void setStart(int x, int y) {
        this.start = new Point(x, y);
    }

    public void setEnd(int x, int y) {
        this.end = new Point(x, y);
    }

    public void setCoords(int... coords) {
        if (coords.length > 4 || coords.length == 0) throw new IllegalArgumentException("\nНевозможно изменить линию по координатам.\nПередайте координаты в кол-ве от 1 до 4.");
        start.setX(coords[0]);
        if (coords.length >= 2) {
            start.setY(coords[1]);
        }
        if (coords.length >= 3) {
            end.setX(coords[2]);
        }
        if (coords.length == 4) {
            end.setY(coords[3]);
        }
    }

    public void setNewCoords(int... coords) {
        if (coords.length != 4 && coords.length != 2) throw new IllegalArgumentException("\nНевозможно изменить линию по независимым координатам.\nПередайте координаты в кол-ве либо 2, либо 4.");
        if (coords[0] != start.getX() || coords[1] != start.getY()) {
            start = new Point(coords[0], coords[1]);
        }
        if (coords.length == 4 && (coords[2] != end.getX() || coords[3] != end.getY())) {
            end = new Point(coords[2], coords[3]);
        }
    }
    //endregion

    public double length() {
        return Math.round(Math.hypot(end.getX() - start.getX(), end.getY() - start.getY()));
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}