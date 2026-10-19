package ru.seroglazov.human;

import ru.seroglazov.format.ReturnFormat;
import ru.seroglazov.format.SpaceReturn;
import ru.seroglazov.validation.Validate;

public class Login {
    private final String secondName;
    private final String firstName;
    private final String patronymicName;


    public Login(String secondName, String firstName, String patronymicName) {
        if (isEmpty(secondName) && isEmpty(firstName) && isEmpty(patronymicName)) {
            throw new IllegalArgumentException("Передайте хотя бы одну часть имени, которая не null и не пустая строка.");
        }
        this.secondName = secondName;
        this.firstName = firstName;
        this.patronymicName = patronymicName;
    }

    public Login(String firstName) {
        this(null, firstName, null);
    }

    public Login(String firstName, String secondName) {
        this(secondName, firstName, null);
    }

    public Login(Login other) {
        Validate.isNullException("Вы пытаетесь скопировать пустое имя", other);
        this.secondName = other.secondName;
        this.firstName = other.firstName;
        this.patronymicName = other.patronymicName;

    }

    private static boolean isEmpty(String part) {
        return Validate.isNull(part) || part.isBlank();
    }

    //region getters
    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }
    //endregion

    public String toString() {
        ReturnFormat formatted;
        if (Validate.isNullAll(secondName, firstName, patronymicName)) {
            formatted = new SpaceReturn("unknown");
        }
        else formatted = new SpaceReturn(
                secondName,
                firstName,
                patronymicName);
        return formatted.output();
    }
}