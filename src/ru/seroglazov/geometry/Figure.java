package ru.seroglazov.geometry;

abstract public class Figure {
    private final String title;

    public Figure(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double area();

    public void draw() {}

    @Override
    public String toString() {
        return title;
    }
}
