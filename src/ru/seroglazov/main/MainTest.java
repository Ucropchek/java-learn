package ru.seroglazov.main;

public class MainTest {
    public static String[] args;

    public static void section(Integer section_number, Float task_number){
        switch (section_number) {
            case 1: Section1.run(task_number);
            case 2: Section2.run(task_number);
            case 3: Section3.run(task_number);
        }
    }
}
