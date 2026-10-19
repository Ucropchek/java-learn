package ru.seroglazov.geometry;

import ru.seroglazov.validation.Validate;

public class Square extends Figure {
    private final static int DEFAULT_SIDE = 0;
    private int a;

    public Square() {
        this(DEFAULT_SIDE);
    }

    public Square(int a) {
        super("Квадрат");
        Validate.isNegativeException("Сторона квадрата не может быть отрицательной", a);
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        Validate.isNegativeException("Сторона квадрата не может быть отрицательной", a);
        this.a = a;
    }

    @Override
    public double area() {
        return (double) a * a;
    }

    public void draw() {
        for (int y = 0; y < a; y++) {
            for (int x = 0; x < a; x++) {
                if (x == 0 || x == a - 1 || y == 0 || y == a - 1) {
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
        return getTitle() + " со стороной " + a;
    }
}
