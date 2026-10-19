package ru.seroglazov.birds;

import java.util.concurrent.ThreadLocalRandom;

public class Parrot extends Bird {
    public Parrot(String sound) {
        super(sound);
    }

    @Override
    public void sing() {
        String sound = getSound();
        int n = ThreadLocalRandom.current().nextInt(1, sound.length() + 1);
        System.out.println(sound.substring(0, n));
    }

    @Override
    public String toString() {
        return "Попугай, издающий \"" + getSound() + "\"";
    }
}

