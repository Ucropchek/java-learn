package ru.seroglazov.main;

import ru.seroglazov.company.Department;
import ru.seroglazov.company.Employee;
import ru.seroglazov.geometry.Line;
import ru.seroglazov.geometry.Point;
import ru.seroglazov.geometry.Point3D;
import ru.seroglazov.geometry.PolygonalLine;
import ru.seroglazov.math.Fraction;
import ru.seroglazov.student.Student;

public class Section5 {
    public static void run(Float number) {
        //region task 5.1.1
        if (number == 51.1f) {
            fractionEquals();
        }
        //endregion
        //region task 5.1.2
        if (number == 51.2f) {
            pointEquals();
        }
        //endregion
        //region task 5.1.3
        if (number == 51.3f) {
            lineEquals();
        }
        //endregion
        //region task 5.1.4
        if (number == 51.4f) {
            polygonalLineEquals();
        }
        //endregion
        //region task 5.1.5
        if (number == 51.5f) {
            employeeEquals();
        }
        //endregion
        //region task 5.1.6
        if (number == 51.6f) {
            departmentEquals();
        }
        //endregion

        //region task 5.2.1
        if (number == 52.1f) {
            pointClone();
        }
        //endregion
        //region task 5.2.3
        if (number == 52.3f) {
            polygonalLineClone();
        }
        //endregion
        //region task 5.2.4
        if (number == 52.4f) {
            studentClone();
        }
        //endregion
    }

    private static void fractionEquals() {
        Fraction half = new Fraction(1, 2);
        Fraction same = new Fraction(1, 2);
        Fraction unreduced = new Fraction(2, 4);
        System.out.println(half.equals(same) + ", hash " + half.hashCode() + " и " + same.hashCode());
        System.out.println(half.equals(unreduced) + ", hash " + unreduced.hashCode());
        System.out.println(new Fraction(1, -2).equals(new Fraction(-1, 2)));
        System.out.println(half.equals(null));
    }

    private static void pointEquals() {
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        Point other = new Point(1, 3);
        Point3D flat = new Point3D(1, 2, 0);
        Point3D raised = new Point3D(1, 2, 3);
        System.out.println(a.equals(b));
        System.out.println(a.equals(other));
        System.out.println(a.equals(flat) + " и " + flat.equals(a));
        System.out.println(flat.equals(raised) + " и " + raised.equals(flat));
    }

    private static void lineEquals() {
        Line forward = new Line(0, 0, 3, 4);
        Line same = new Line(0, 0, 3, 4);
        Line backward = new Line(3, 4, 0, 0);
        Line different = new Line(0, 0, 1, 1);
        System.out.println(forward.equals(same) + ", hash " + forward.hashCode() + " и " + same.hashCode());
        System.out.println(forward.equals(backward) + ", hash " + backward.hashCode());
        System.out.println(forward.equals(different));
        System.out.println(forward.equals(null));
    }

    private static void polygonalLineEquals() {
        PolygonalLine one = new PolygonalLine(0, 0, 1, 1);
        PolygonalLine same = new PolygonalLine(0, 0, 1, 1);
        PolygonalLine other = new PolygonalLine(2, 2, 3, 3);
        System.out.println(one.equals(same));
        System.out.println(one.equals(other));
        System.out.println(one.equals(null));
    }

    private static void employeeEquals() {
        Department it = new Department("IT");
        Employee ivan = new Employee("Иван", it);
        Employee same = new Employee("Иван", it);
        Employee otherName = new Employee("Пётр", it);
        Department hr = new Department("HR");
        Employee otherDepartment = new Employee("Иван", hr);
        System.out.println(ivan.equals(same));
        System.out.println(ivan.equals(otherName));
        System.out.println(ivan.equals(otherDepartment));
        System.out.println(ivan.equals(null));
    }

    private static void departmentEquals() {
        Department it = new Department("IT");
        Department same = new Department("IT");
        Department hr = new Department("HR");
        System.out.println(it.equals(same));
        System.out.println(it.equals(hr));
        System.out.println(it.equals(null));
    }

    private static void pointClone() {
        Point origin = new Point(1, 1);
        Point copy = origin.clone();
        origin.setX(999);
        System.out.println(origin);
        System.out.println(copy);
    }

    private static void polygonalLineClone() {
        PolygonalLine line = new PolygonalLine(0, 0, 3, 4);
        try {
            PolygonalLine copy = line.clone();
            line.getPoints().getFirst().setX(9);
            System.out.println(line);
            System.out.println(copy);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void studentClone() {
        Student vasya = new Student("Вася", 3, 4, 5);
        Student copy = vasya.clone();
        copy.addGrades(2);
        System.out.println(vasya);
        System.out.println(copy);
    }
}
