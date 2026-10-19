package ru.seroglazov.time;

import ru.seroglazov.format.ReturnFormat;
import ru.seroglazov.format.TimeReturn;
import ru.seroglazov.validation.Validate;

public class Time {
    private int seconds;
    private ReturnFormat formatted;
    public Time(int seconds) {
        Validate.isNegativeException("Время отсчитывается только вперед! Введите неотрицательное число.", seconds);
        this.seconds = seconds;
        this.formatted = new TimeReturn(calculateFormat());
    }

    private int[] calculateFormat() {
        int seconds =    this.seconds % 60;
        int minutes = this.seconds / 60 % 60;
        int hours = this.seconds / 60 / 60 % 24;
        int[] calculated = {hours, minutes, seconds};
        return calculated;
    }

    public String toString() {
        return formatted.output();
    }
}
