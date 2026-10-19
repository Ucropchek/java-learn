package ru.seroglazov.geometry;

import java.util.ArrayList;
import java.util.Arrays;

import ru.seroglazov.validation.Validate;

public class ClosedPolygonalLine extends PolygonalLine{
    public ClosedPolygonalLine() {}

    public ClosedPolygonalLine(ArrayList<Point> points) {
        super(points);
        close();
    }

    public ClosedPolygonalLine(Point... points) {
        super(points);
        close();
    }

    public ClosedPolygonalLine(int... cords) {
        super(cords);
        close();
    }

    @Override
    public void addPoints(Point... points) {
        Validate.isNullException("Передан points равный null", points);
        ArrayList<Point> gotPoints = getPoints();
        open(gotPoints);
        gotPoints.addAll(Arrays.asList(points));
        setPoints(gotPoints);
    }

    @Override
    public void addPoints(ArrayList<Point> points) {
        Validate.isNullException("Передан points равный null", points);
        addPoints(points.toArray(new Point[0]));
    }

    @Override
    public void setPoints(ArrayList<Point> points) {
        super.setPoints(points);
        close();
    }

    @Override
    public void setPoints(Point... points) {
        super.setPoints(points);
        close();
    }

    private void open(ArrayList<Point> gotPoints) {
        if (gotPoints.size() >= 2) gotPoints.removeLast();
    }

    private void close() {
        ArrayList<Point> gotPoints = getPoints();
        if (gotPoints.isEmpty()) return;
        Point first = gotPoints.getFirst();
        Point last = gotPoints.getLast();
        if (gotPoints.size() > 1 && first.equals(last)) return;
        super.addPoints(first);
    }

    @Override
    public String toString() {
        ArrayList<Point> points = getPoints();
        if (points.isEmpty()) return "Линия []";
        String pointsString = points.getFirst().toString();
        for (int i = 1; i < points.size(); i++) {
            pointsString += ", " + points.get(i);
        }
        return "Замкнутая линия [" + pointsString + "]";
    }
}
