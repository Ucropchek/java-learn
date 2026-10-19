package ru.seroglazov.geometry;

import ru.seroglazov.validation.Validate;
import ru.seroglazov.validation.ZeroValueException;

public class Circle extends Figure{
    private final static int DEFAULT_RADIUS = 1;
    private int r;

    public Circle() {
        this(DEFAULT_RADIUS);
    }

    public Circle(int r) {
        super("Круг");
        if (r == 0) throw new ZeroValueException("Передайте радиус не равный 0");
        if (Validate.isNegative(r)) r = -r;
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    public void draw() {
        for (int y = -r; y <= r; y++) {
            for (int x = -r; x <= r; x++) {
                double distance = Math.sqrt(x * x + y * y);
                if (distance >= r - 0.5 && distance <= r + 0.5) {
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
        return getTitle() + " с радиусом " + r;
    }
}
