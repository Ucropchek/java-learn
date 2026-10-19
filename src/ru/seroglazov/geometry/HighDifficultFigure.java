package ru.seroglazov.geometry;

import java.util.ArrayList;

public interface HighDifficultFigure {
    ArrayList<Point> getContourPoints();

    default double area() {
        ArrayList<Point> points = getContourPoints();
        int n = points.size();
        if (n < 3) return 0.0;

        double area = 0.0;
        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }
        return Math.abs(area) / 2.0;
    }
}
