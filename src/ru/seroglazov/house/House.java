package ru.seroglazov.house;

import ru.seroglazov.validation.Validate;

public class House {
    private final int countFloors;

    public House(int count) {
        Validate.isZeroNegativeException("Нельзя создать дом с неположительным кол-ом этажей!", count);
        countFloors = count;
    }

    private String stringEnd() {
        int lastDigitCount = countFloors % 10;
        if (countFloors % 100 == 11) return "ами";
        if (lastDigitCount >= 2 || lastDigitCount == 0) return "ами";
        return "ом";
    }

    @Override
    public String toString() {
        return "дом с " + countFloors + " этаж" + stringEnd();
    }
}