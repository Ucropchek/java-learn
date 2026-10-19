package ru.seroglazov.geometry;

import java.util.ArrayList;
import java.util.Arrays;

import ru.seroglazov.validation.EvennessCountOfArgumentsException;
import ru.seroglazov.validation.Validate;

public class PolygonalLine implements Lengthable{
    private ArrayList<Point> points;

    public PolygonalLine() {
        this.points = new ArrayList<>();
    }

    public PolygonalLine(ArrayList<Point> points) {
        this();
        Validate.isNullException("Передайте массив точек, в котором нет null и который не null", points);
        this.points.addAll(points);
    }

    public PolygonalLine(Point... points) {
        this();
        Validate.isNullException("Передайте массив точек, в котором нет null и который не null", points);
        this.points.addAll(Arrays.asList(points));
    }

    public PolygonalLine(int... cords) {
        this();
        if (cords.length % 2 != 0 || cords.length == 0) throw new EvennessCountOfArgumentsException("Чтобы координаты были парными передайте четное количество");
        for (int i = 0; i < cords.length; i += 2) {
            this.points.add(new Point(cords[i], cords[i + 1]));
        }
    }

    public PolygonalLine(PolygonalLine other) {
        Validate.isNullException("Нельзя скопировать или линию содержащую null", other);
        this.points = new ArrayList<>(other.points);
    }

    //region getters

    public ArrayList<Point> getPoints() {
        return new ArrayList<>(points);
    }

    //endregion

    //region setters

    public void setPoints(ArrayList<Point> points) {
        Validate.isNullException("Передайте массив точек не являющийся null и не содержащий null", points);
        this.points = new ArrayList<>(points);
    }

    public void setPoints(Point... points) {
        Validate.isNullException("Передайте массив точек не являющийся null и не содержащий null", points);
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    //endregion

    public double length() {
        double length = 0;
        for (int i = 1; i < points.size(); i++) {
            Point previous = points.get(i - 1);
            Point current = points.get(i);
            length += Math.hypot(current.getX() - previous.getX(), current.getY() - previous.getY());
        }
        return length;
    }

    public void addPoints(ArrayList<Point> points) {
        Validate.isNullException("Передайте массив точек не являющийся null", points);
        Validate.isNullException("Передайте массив точек не содержащий null", points.toArray());
        this.points.addAll(points);
    }

    public void addPoints(Point... points) {
        Validate.isNullException("Передайте массив точек не содержащий null", points);
        this.points.addAll(Arrays.asList(points));
    }

    @Override
    public String toString() {
        if (points.isEmpty()) return "Линия []";
        String pointsString = points.getFirst().toString();
        for (int i = 1; i < points.size(); i++) {
            pointsString += ", " + points.get(i);
        }
        return "Линия [" + pointsString + "]";
    }
}