package ru.seroglazov.format;

import ru.seroglazov.validation.Validate;

public class SpaceReturn implements ReturnFormat {
    private StringBuilder formatted;
    private String[] strings;
    public SpaceReturn(String... strings) {
        Validate.isNullAllException("Нельзя отформатироавть пустой массив строк.\nПередайте строки в функцию.", strings);
        formatted = new StringBuilder();
        this.strings = strings;
        for (int i = 0; i < strings.length; i++) {
            this.strings[i] = strings[i];
        }
    }

    @Override
    public String output() {
        int idx = 0;
        while (idx < strings.length && (Validate.isNull(strings[idx]) || strings[idx].isBlank())) idx++;
        if (idx < strings.length) formatted.append(strings[idx++]);
        for (int i = idx; i < strings.length; i++) {
            if (!Validate.isNull(strings[i]) && !strings[i].isBlank()) {
                formatted.append(" " + strings[i]);
            }
        }
        return formatted.toString();
    }
}
