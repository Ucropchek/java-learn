package ru.seroglazov.main;

import java.util.Arrays;

import ru.seroglazov.weapon.AssaultRifle;
import ru.seroglazov.student.AverageCompare;
import ru.seroglazov.student.BinaryGradeRule;
import ru.seroglazov.birds.Bird;
import ru.seroglazov.meow.Cat;
import ru.seroglazov.geometry.Circle;
import ru.seroglazov.birds.Cuckoo;
import ru.seroglazov.student.EvenGradeRule;
import ru.seroglazov.geometry.Figure;
import ru.seroglazov.math.Fraction;
import ru.seroglazov.geometry.Lengthable;
import ru.seroglazov.geometry.Line;
import ru.seroglazov.meow.Meowable;
import ru.seroglazov.weapon.NoWeapon;
import ru.seroglazov.birds.Parrot;
import ru.seroglazov.weapon.Pistol;
import ru.seroglazov.geometry.PolyLinable;
import ru.seroglazov.geometry.PolygonalChain;
import ru.seroglazov.geometry.PolygonalLine;
import ru.seroglazov.weapon.Shooter;
import ru.seroglazov.birds.Sparrow;
import ru.seroglazov.geometry.Square;
import ru.seroglazov.student.Student;
import ru.seroglazov.geometry.Triangle;
import ru.seroglazov.validation.Validate;

public class Section2 {
    public static void run(Float number) {
        //region task 2.2.3
        if (number == 22.3f) {
            Bird parrot = new Parrot("ХИхИХиха");
            Bird sparrow = new Sparrow();
            Bird cuckoo = new Cuckoo();
            sparrow.sing();
            cuckoo.sing();
            System.out.print("                           .\n" +
                    "                          | \\/|\n" +
                    "                          ) )|/|\n" +
                    "                    _----. /.'.'\n" +
                    ".-._________..      .' @ _\\  .'\n" +
                    "'.._______.   '.   /    (_| .')        "
                    );
            parrot.sing();
            System.out.println(" '._____.  /   '-/      | _.'\n" +
                    "   '.______ (         ) ) \\\n" +
                    "     '..____ '._       )  )\n" +
                    "        .' __.--\\  , ,  // ((\n" +
                    "        '.'  mrf|  \\/   (_.'(\n" +
                    "                '   \\ .'\n" +
                    "                 \\   (\n" +
                    "                  \\   '.\n" +
                    "                   \\ \\ '.)\n" +
                    "                    '-'-'");
        }
        //endregion
        //region task 2.2.4
        if (number == 22.4f) {
            Figure fig = new Triangle(15, 16, 20);
            fig.draw();
        }
        //endregion

        //region task 2.3.1
        if (number == 23.1f) {
            Number[] nums = {
                    1,
                    new Fraction(1, 2),
                    1.3f,
                    new Fraction(1, 4)
            };
            System.out.println(sum(nums[0], nums[1]));
            System.out.println(sum(nums[2], nums[1], nums[0], nums[3]));
            System.out.println(sum(nums[3], nums[0]));
        }
        //endregion
        //region task 2.3.2
        if (number == 23.2f) {
            Bird[] birds = {
                    new Sparrow(),
                    new Sparrow(),
                    new Cuckoo(),
                    new Cuckoo(),
                    new Cuckoo(),
                    new Parrot("Ауу..."),
                    new Parrot("ну"),
                    new Parrot("ладно")
            };
            birdsSing(birds);
        }
        //endregion
        //region task 2.3.3
        if (number == 23.3f) {
            Figure[] figures = {
                    new Square(3),
                    new Circle(12),
                    new Square(1),
                    new Square(8),
                    new Circle(12),
                    new Circle(2)
            };
            System.out.println(sumAreas(figures));
        }
        //endregion
        //region task 2.3.4
        if (number == 23.4f) {
            Cat[] cats = {
                    new Cat("Каспер"),
                    new Cat("Мурзик"),
                    new Cat("*****"),
                    new Cat("Ральф")
            };
            meowAll(cats);
        }
        //endregion
        //region task 2.3.5
        if (number == 23.5f) {
            double total = sumLengths(new Line(0, 0, 3, 4), new PolygonalLine(0, 0, 3, 4, 6, 0));
            System.out.println(total);
        }
        //endregion
        //region task 2.3.6
        if (number == 23.6f) {
            PolygonalChain square = new PolygonalChain(1, 1, 10);
            System.out.println(square.getPolyLine());
        }
        //endregion
        //region task 2.3.7
        if (number == 23.7f) {
            PolygonalLine totalLine = makeUnitedLine(new PolygonalChain(0, 0, 3),
                    new PolygonalChain(1, 1, 3));
            System.out.println(totalLine);
        }
        //endregion
        //region task 2.3.8
        if (number == 23.8f) {
            Shooter pete = new Shooter("Петя", new AssaultRifle(30, 5));
            Shooter vasya = new Shooter("Вася", new NoWeapon());
            Shooter anton = new Shooter("Антон", new Pistol(10, 10));
            pete.shoot();
            vasya.shoot();
            anton.shoot();
        }
        //endregion
        //region task 2.3.9
        if (number == 23.9f) {
            Student pete = new Student("Петя", new EvenGradeRule());
            Student vasya = new Student("Вася", new BinaryGradeRule());
        }
        //endregion

        //region test
        if (number == 66.6f) {
            Student[] stds = {
                    new Student("1", 4, 5, 5),
                    new Student("2", 1, 1, 1),
                    new Student("3", 8, 8, 8),
            };
            stds = sortByGrade(stds);
            System.out.println(Arrays.toString(stds));
        }
        //endregion
    }

    public static double sum(Number... nums) {
        Validate.isNullException("Передайте не null массив", nums);
        double total = 0;
        for (Number num : nums) {
            total += num.doubleValue();
        }
        return total;
    }

    public static void birdsSing(Bird... birds) {
        Validate.isNullException("Птицы не могут петь на null рынке", birds);
        for (Bird bird : birds) {
            bird.sing();
        }
    }

    public static double sumAreas(Figure... figures) {
        Validate.isNullException("Список обрабатываемых фигур и сами фигуры должны существовать", figures);
        double total = 0;
        for (Figure fig : figures) {
            total += fig.area();
        }
        return total;
    }

    public static void meowAll(Meowable... animals) {
        Validate.isNullException("Список мяукающих животных должен быть не null ", animals);
        for (Meowable animal : animals) {
            animal.meow();
        }
    }

    public static double sumLengths(Lengthable... objs) {
        double total = 0;
        for (Lengthable obj : objs) {
            total += obj.length();
        }
        return total;
    }

    public static Lengthable maxLength(Lengthable... objs) {
        Validate.isNullException("Передайте не null список объектов", objs);
        Lengthable maxLen = objs[0];
        double localMax = objs[0].length();
        for (int i = 1; i < objs.length; i++) {
            double currentLen = objs[i].length();
            if (currentLen > localMax) {
                localMax = currentLen;
                maxLen = objs[i];
            }
        }
        return maxLen;
    }

    public static PolygonalLine makeUnitedLine(PolyLinable... objs) {
        Validate.isNullException("Передайте не null список объектов и не содержащий null", objs);
        PolygonalLine returnLine = new PolygonalLine();
        for (int i = 0; i < objs.length; i++) {
            returnLine.addPoints(objs[i].getPolyLine().getPoints());
        }
        return returnLine;
    }

    public static Student[] sortByGrade(Student... students) {
        Arrays.asList(students).sort(new AverageCompare());
        return students;
    }
}