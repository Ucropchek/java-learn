package ru.seroglazov.student;

public class AnyGradeRule implements GradeRule {
    @Override
    public boolean isCorrect(int grade) {
        return true;
    }
}