package ru.seroglazov.meow;

import ru.seroglazov.validation.Validate;

public class Cat implements Meowable {
    private String name;

    public Cat(String name) {
        Validate.isNullException("Передайте имя кота", name);
        if (name.isBlank()) throw new IllegalArgumentException("Имя кота не может быть пустым");
        this.name = name;
    }

    //region getters

    public String getName() {
        return name;
    }

    //endregion

    public void meow() {
        meow(1);
    }

    public void meow(int count) {
        Validate.isZeroNegativeException("Количество мяуканий должно быть положительным", count);
        System.out.println(name + ": мяу" + "-мяу".repeat(count - 1) + "!");
    }

    @Override
    public String toString() {
        return "кот: " + name;
    }
}
