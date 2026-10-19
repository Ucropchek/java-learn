package ru.seroglazov.geometry;

public class Ruler implements Lengthable {
    private final double length;

    public Ruler(double length) {
        this.length = length;
    }

    @Override
    public double length() {
        return length;
    }

    @Override
    public String toString() {
        return "Линейка с длиной " + length;
    }
}
