package ru.seroglazov.student;

import java.util.ArrayList;

import ru.seroglazov.validation.IllegalGradeException;
import ru.seroglazov.validation.Validate;

public class Student{
    private String name;
    private ArrayList<Integer> grades;
    private GradeRule rule;

    public Student(String name, int... grades) {
        this(name, new AnyGradeRule(), grades);
    }

    public Student(String name, GradeRule rule, int... grades) {
        Validate.isNullException("Передайте правило проверки оценок", rule);
        Validate.isNullException("Передайте не null. Если у студента нет оценок, не передавайте ничего третьим аргументом.", grades);
        if (Validate.isNull(name) || name.isBlank()) name = "unknown";
        this.rule = rule;
        for (int grade : grades) {
            checkGrade(grade);
        }
        this.name = name;
        this.grades = new ArrayList<>();
        for (int grade : grades) {
            this.grades.add(grade);
        }
    }

    private void checkGrade(int grade) {
        if (!rule.isCorrect(grade)) {
            throw new IllegalGradeException("Оценка не соответствует правилу студента! Передано: " + grade);
        }
    }

    //region getters

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        ArrayList<Integer> copyGrades = new ArrayList<>(grades);
        return copyGrades;
    }

    //endregion

    //region setters

    public void setName(String name) {
        Validate.isNullException("Передайте ненулевое имя студента!", name);
        this.name = name;
    }

    public void setGrades(ArrayList<Integer> grades) {
        Validate.isNullException("Передайте ненулевой список оценок!", grades);
        for (int grade : grades) {
            checkGrade(grade);
        }
        this.grades = new ArrayList<>(grades);
    }

    public void setGrades(int... grades) {
        Validate.isNullException("Передайте ненулевой список оценок!", grades);
        for (int grade : grades) {
            checkGrade(grade);
        }
        this.grades = new ArrayList<>();
        for (int grade : grades) {
            this.grades.add(grade);
        }
    }

    //endregion

    public double average() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public boolean isExcellent(int excellentGrade) {
        if (grades.isEmpty()) return false;
        for (int grade : grades) {
            if (grade != excellentGrade) return false;
        }
        return true;
    }

    public void addGrades(ArrayList<Integer> grades) {
        Validate.isNullException("Передайте ненулевой список оценок!", grades);
        for (int grade : grades) {
            checkGrade(grade);
        }
        this.grades.addAll(grades);
    }

    public void addGrades(int... grades) {
        Validate.isNullException("Передайте ненулевой список оценок!", grades);
        for (int grade : grades) {
            checkGrade(grade);
        }
        for (int grade : grades) {
            this.grades.add(grade);
        }
    }

    @Override
    public String toString() {
        String returnString = name + ": [";
        if (!Validate.isNull(grades) && !grades.isEmpty()) {
            returnString += grades.getFirst();
            for (int i = 1; i < grades.toArray().length; i++) {
                returnString += ", " + grades.get(i);
            }
        }
        returnString += "]";
        return returnString;
    }
}