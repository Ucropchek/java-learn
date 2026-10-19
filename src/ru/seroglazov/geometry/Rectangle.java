package ru.seroglazov.geometry;

import ru.seroglazov.validation.Validate;

public class Rectangle extends Figure {
    private final static int DEFAULT_SIDE = 0;
    private int a;
    private int b;

    public Rectangle() {
        this(DEFAULT_SIDE, DEFAULT_SIDE);
    }

    public Rectangle(int a, int b) {
        super("Прямоугольник");
        Validate.isNegativeException("Ни одна из сторон прямоугольника не может быть отрицательной", a, b);
        this.a = a;
        this.b = b;
    }

    //region getters
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    //endregion

    //region setters
    public void setA(int a) {
        Validate.isNegativeException("Сторона прямоугольника не может быть отрицательной", a);
        this.a = a;
    }

    public void setB(int b) {
        Validate.isNegativeException("Сторона прямоуглольника не может быть отрицательной", b);
        this.b = b;
    }
    //endregion

    @Override
    public double area() {
        return (double) a * b;
    }

    public void draw() {
        for (int y = 0; y < b; y++) {
            for (int x = 0; x < a; x++) {
                if (x == 0 || x == a - 1 || y == 0 || y == b - 1) {
                    System.out.print("▓▓");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return getTitle() + " со сторонами " + a + " и " + b;
    }
}
