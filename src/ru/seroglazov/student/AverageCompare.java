package ru.seroglazov.student;

import java.util.Comparator;

public class AverageCompare implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        return (int) (o1.average() - o2.average());
    }
}
