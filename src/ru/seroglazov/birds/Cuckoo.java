package ru.seroglazov.birds;

public class Cuckoo extends Bird {
    public Cuckoo() {
        super("ку-ку");
    }

    @Override
    public void sing() {
        int times = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < times; i++) {
            System.out.print(getSound() + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Кукушка, издающая \"" + getSound() + "\"";
    }
}
