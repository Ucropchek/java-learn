package ru.seroglazov.human;

import ru.seroglazov.validation.Validate;

public class Human {
    private Login name;
    private int height;
    private final Human father;

    public Human(String firstName) {
        this(0, null, new Login(firstName));
    }

    public Human(Login login) {
        this(0, null, login);
    }

    public Human(Human father, String firstName) {
        this(0, father, new Login(firstName));
    }

    public Human(Human father, Login login) {
        this(0, father, login);
    }

    public Human(int height, String... nameParts){
        if (nameParts.length != 3) throw new IllegalArgumentException("Передайте имя в формате Ф. И. О.\nЕсли нет какой-то части имени, то введите вместо этого \"\"");
        this(height, null, new Login(nameParts[0], nameParts[1], nameParts[2]));
    }

    public Human(int height, Login login){
        this(height, null, login);
    }

    public Human(int height, Human father, String... nameParts) {
        Validate.isNullException("Нельзя сделать отцом null.", father);
        Login login = new Login(nameParts[0], nameParts[1], nameParts[2]);
        this(height, father, login);
    }

    public Human(int height, Human father, Login login) {
        Validate.isNullException("Передайте существующий объект Login или имя в формате Ф. И. О.", login);
        this.height = height;
        this.father = father;
        this.name = inheritFromFather(father, login);
    }

    //region getters
    public Login getName() {
        return name;
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getPatronymicName() {
        return name.getPatronymicName();
    }

    public int getHeight() {
        return height;
    }

    public Human getFather() {
        return father;
    }
    //endregion

    //region setters

    public void setName(Login name) {
        Validate.isNullException("Передайте имя в формате Ф. И. О.\nЕсли нет какой-то части имени, то введите вместо этого \"\"", name);
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //endregion

    private static boolean isEmpty(String part) {
        return Validate.isNull(part) || part.isBlank();
    }

    private static Login inheritFromFather(Human father, Login login) {
        if (Validate.isNull(father)) return login;

        String secondName = login.getSecondName();
        String patronymicName = login.getPatronymicName();
        String fatherSecondName = father.findSecondName();
        String fatherName = father.getFirstName();

        if (isEmpty(secondName) && !isEmpty(fatherSecondName)) {
            secondName = fatherSecondName;
        }

        if (isEmpty(patronymicName) && !isEmpty(fatherName)) {
            patronymicName = fatherName + "ович";
        }
        return new Login(secondName, login.getFirstName(), patronymicName);
    }

    public String findSecondName() {
        Human current = this;
        while (!Validate.isNull(current)) {
            String secondName = current.name.getSecondName();
            if (!isEmpty(secondName)) return secondName;
            current = current.father;
        }
        return null;
    }

    public String toString(){
        return new Login(findSecondName(), name.getFirstName(), name.getPatronymicName()).toString();
    }
}