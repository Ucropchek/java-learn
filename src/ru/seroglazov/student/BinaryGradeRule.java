package ru.seroglazov.student;

public class BinaryGradeRule implements GradeRule {
    @Override
    public boolean isCorrect(int grade) {
        return grade == 0 || grade == 1;
    }
}