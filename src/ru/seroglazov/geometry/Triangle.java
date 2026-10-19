package ru.seroglazov.geometry;

import java.util.Arrays;

import ru.seroglazov.validation.Validate;

public class Triangle extends Figure {
    private final static int DEFAULT_SIDE = 0;
    private int a;
    private int b;
    private int c;

    public Triangle() {
        this(DEFAULT_SIDE, DEFAULT_SIDE + 1, DEFAULT_SIDE + 1);
    }

    public Triangle(int a, int b, int c) {
        super("Треугольник");
        Validate.isNegativeException("Ни одна из сторон не может быть отрицательной", a, b, c);
        Validate.isTriangleException(null, a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //region getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
    //endregion

    //region setters
    public void setSides(int a, int b, int c) {
        Validate.isNegativeException("Стороны не могут быть отрицательными", a, b, c);
        Validate.isTriangleException(null, a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //endregion

    @Override
    public double area() {
        double p = ((double) a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void draw() {
        if (a + b <= c || a + c <= b || b + c <= a) return;

        double xC = (double) (a * a + b * b - c * c) / (2 * a);
        double yC = Math.sqrt(Math.max(0.0, b * b - xC * xC));

        double minX = Math.min(0, xC);
        double minY = Math.min(0, yC);

        int xA = (int) Math.round(-minX),         yA = (int) Math.round(-minY);
        int xB = (int) Math.round(a - minX),      yB = (int) Math.round(-minY);
        int xC_int = (int) Math.round(xC - minX), yC_int = (int) Math.round(yC - minY);

        int maxX = Math.max(xA, Math.max(xB, xC_int));
        int maxY = Math.max(yA, Math.max(yB, yC_int));

        String[][] grid = new String[maxY + 1][maxX + 1];
        for (String[] row : grid) Arrays.fill(row, "  ");

        drawLine(xA, yA, xB, yB, grid);
        drawLine(xB, yB, xC_int, yC_int, grid);
        drawLine(xC_int, yC_int, xA, yA, grid);

        for (int i = grid.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (String cell : grid[i]) sb.append(cell);
            System.out.println(sb);
        }
    }

    private void drawLine(int x0, int y0, int x1, int y1, String[][] grid) {
        int dx = Math.abs(x1 - x0), dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1, sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            if (y0 >= 0 && y0 < grid.length && x0 >= 0 && x0 < grid[y0].length) {
                grid[y0][x0] = "▓▓";
            }
            if (x0 == x1 && y0 == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x0 += sx; }
            if (e2 < dx) { err += dx; y0 += sy; }
        }
    }

    @Override
    public String toString() {
        return getTitle() + " со сторонами " + a + " и " + b + " и " + c;
    }
}





































