package ru.seroglazov.birds;

public class Sparrow extends Bird {
    public Sparrow() {
        super("чирик");
    }

    @Override
    public String toString() {
        return "Воробей, издающий \"" + getSound() + "\"";
    }
}
