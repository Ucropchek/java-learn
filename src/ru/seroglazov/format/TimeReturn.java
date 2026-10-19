package ru.seroglazov.format;

import ru.seroglazov.validation.Validate;

public class TimeReturn implements ReturnFormat {
    private StringBuilder formatted;
    private int[] convertedToFormat;

    public TimeReturn(int[] convertedToFormat) {
        Validate.isNullAllException("Передан пустой массив! Нечего конвертировать. Передайте не null массив", convertedToFormat);
        this.convertedToFormat = convertedToFormat;
        this.formatted = new StringBuilder();
    }

    private void isNeedZero(int i) {
        Validate.isNegativeException("Нельзя добавить значимые нули к отрицательному числу!", i);
        if (i >= 100) throw new IllegalArgumentException("в формате ЧЧ:ММ:СС недопустимы числа больше 2-х разрядов!");
        if (convertedToFormat[i] < 10) {
            formatted.append("0");
        }
    }

    @Override
    public String output() {
        isNeedZero(0);
        formatted.append(convertedToFormat[0]);
        for (int i = 1; i < convertedToFormat.length; i++) {
            formatted.append(":");
            isNeedZero(i);
            formatted.append(convertedToFormat[i]);
        }
        return formatted.toString();
    }
}