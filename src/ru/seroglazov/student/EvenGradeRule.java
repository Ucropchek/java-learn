package ru.seroglazov.student;

public class EvenGradeRule implements GradeRule {
    @Override
    public boolean isCorrect(int grade) {
        return grade % 2 == 0;
    }
}