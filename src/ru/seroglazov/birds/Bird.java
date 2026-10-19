package ru.seroglazov.birds;

import ru.seroglazov.validation.Validate;

abstract public class Bird {
    private final String sound;

    public Bird(String sound) {
        Validate.isNullException("Текст, который птица произносит не мможет быть null", sound);
        this.sound = sound;
    }

    public void sing() {
        System.out.println(sound);
    }

    public String getSound() {
        return sound;
    }
}
