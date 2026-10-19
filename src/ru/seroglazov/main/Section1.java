package ru.seroglazov.main;

import java.util.ArrayList;

import ru.seroglazov.meow.Cat;
import ru.seroglazov.company.Department;
import ru.seroglazov.company.Employee;
import ru.seroglazov.math.Fraction;
import ru.seroglazov.house.House;
import ru.seroglazov.human.Human;
import ru.seroglazov.geometry.Line;
import ru.seroglazov.human.Login;
import ru.seroglazov.weapon.Pistol;
import ru.seroglazov.geometry.Point;
import ru.seroglazov.geometry.PolygonalChain;
import ru.seroglazov.geometry.PolygonalLine;
import ru.seroglazov.student.Student;
import ru.seroglazov.time.Time;
import ru.seroglazov.city.Town;
import ru.seroglazov.city.Way;

public class Section1 {
    public static void run(Float number){
        //region task 1.1.1
        if (number == 11.1f) {
            ArrayList<Point> points = new ArrayList<>();
            int[][] coords = {
                    {1, 0},
                    {10, 21},
                    {-1, 0}
            };
            for (int i=0; i < coords.length; i++) {
                points.add(new Point(coords[i][0], coords[i][1]));
                System.out.println(points.get(i));
            }
        }
        //endregion
        //region task 1.1.2
        if (number == 11.2f) {
            ArrayList<Human> people = new ArrayList<>();
            String[] names = {
                    "Клеопатра",
                    "Пушкин",
                    "Александр"
            };
            int[] heights = {
                    152,
                    167,
                    189
            };
            for (int i=0; i < heights.length; i++) {
                people.add(new Human(heights[i], names));
                System.out.println(people.get(i));
            }
        }
        //endregion
        //region task 1.1.3
        if (number == 11.3f) {
            ArrayList<Login> logins = new ArrayList<>();
            String[][] names = {
                    {"", "Клеопатра", ""},
                    {"Пушкин", "", "Сергеевич"},
                    {"Маяковский", "Владимир", ""}
            };

            for (int i = 0; i < names.length; i++) {
                logins.add(new Login(names[i][0], names[i][1], names[i][2]));
                System.out.println(logins.get(i));
            }
        }
        //endregion
        //region task 1.1.4
        if (number == 11.4f) {
            ArrayList<Time> clocks = new ArrayList<>();
            int[] times = new int[]{10, 10000, 100000, 12000};
            for (int i=0; i < times.length; i++) {
                clocks.add(new Time(times[i]));
                System.out.println(clocks.get(i).toString());
            }
        }
        //endregion
        //region task 1.1.5
        if (number == 11.5f) {
            ArrayList<House> houses = new ArrayList<>();
            int[] houseNumbers = {1, 3, 5, 41, 111};
            for (int i = 0; i < houseNumbers.length; i++) {
                houses.add(new House(houseNumbers[i]));
                System.out.println(houses.get(i).toString());
            }
        }
        //endregion

        //region task 1.2.1
        if (number == 12.1f) {
            Point start1 = new Point(1, 3);
            Point end1 = new Point(23, 8);
            Point start2 = new Point(5, 10);
            Point end2 = new Point(25, 10);

            Line line1 = new Line(start1, end1);
            Line line2 = new Line(start2, end2);
            Line line3 = new Line(start1, end2);

            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);

            line1.setCoords(1, 2, 3, 4);
            line2.setCoords(4, 3, 2, 1);

            System.out.println("\n" + line1);
            System.out.println(line2);
            System.out.println(line3);

            line1.setNewCoords(5, 6, 3, 4);
            System.out.println("\n" + line1);
            System.out.println(line2);
            System.out.println(line3);
        }
        //endregion
        //region task 1.2.2
        if (number == 12.2f) {
            Human kleo = new Human(152, "", "Клеопатра", "");
            Human pushkin = new Human(167, "Пушкин", "Александр", "Сергеевич");
            Human mayak = new Human(189, "Маяковский", "Владимир", "");
            System.out.println(kleo);
            System.out.println(pushkin);
            System.out.println(mayak);
        }
        //endregion
        //region task 1.2.3
        if (number == 12.3f) {
            Human chIv = new Human(150, "Чудов", "Иван", "");
            Human chPet = new Human(150, "Чудов", "Петр", "");
            Human boris = new Human(150, "", "Борис", "");

            System.out.println(chIv);
            System.out.println(chPet);
            System.out.println(boris);

            chPet = new Human(150, chIv, new Login("", "Петр", ""));
            boris = new Human(150, chPet, new Login("", "Борис", ""));

            System.out.println("\n" + chIv);
            System.out.println(chPet);
            System.out.println(boris);
        }
        //endregion
        // region task 1.2.4
        if (number == 12.4f) {
            Department itDep = new Department("IT", null);
            Employee pet = new Employee("Петрова", itDep);
            Employee koz = new Employee("Козлова", itDep);
            Employee sid = new Employee("Сидорова", itDep);

            System.out.println(pet);
            System.out.println(koz);
            System.out.println(sid);

            itDep.setBoss(koz);

            System.out.println("\n" + pet);
            System.out.println(koz);
            System.out.println(sid);
        }
        //endregion

        //region task 1.3.1
        if (number == 13.1f) {
            Student vas = new Student("Вася", 3, 4, 5);
            Student pet = new Student("Петя");
            pet.setGrades(vas.getGrades());
            System.out.println(vas);
            System.out.println(pet);

            ArrayList<Integer> grades = pet.getGrades();
            grades.set(0, 5);
            pet.setGrades(grades);

            System.out.println("\n" + vas);
            System.out.println(pet);

            Student andrey = new Student("Андрей");
            pet.setGrades(vas.getGrades());
            System.out.println("\n" + vas);
            System.out.println(pet);
            System.out.println(andrey);
        }
        //endregion
        //region task 1.3.2
        if (number == 13.2f) {
            Point[] foreyPoints = {new Point(1, 5), new Point(2, 8), new Point(5, 3), new Point(2, -5), new Point(4, -8)};
            PolygonalLine polLine1 = new PolygonalLine(foreyPoints[0], foreyPoints[1], foreyPoints[2]);
            PolygonalLine polLine2 = new PolygonalLine(foreyPoints[0], foreyPoints[3], foreyPoints[4], foreyPoints[2]);

            System.out.println(polLine1);
            System.out.println(polLine2);

            foreyPoints[0].setX(0);
            foreyPoints[0].setY(0);

            System.out.println(polLine1);
            System.out.println(polLine2);
        }
        //endregion
        //region task 1.3.3
        if (number == 13.3f) {
            Town a = new Town("A");
            Town b = new Town("B");
            Town c = new Town("C");
            Town d = new Town("D");
            Town e = new Town("E");
            Town f = new Town("F");

            Way ab = new Way(b, 5);
            Way ba = new Way(a, 5);
            Way af = new Way(f, 1);
            Way ad = new Way(d, 6);
            Way da = new Way(a, 6);
            Way fb = new Way(b, 1);
            Way fe = new Way(e, 2);
            Way ef = new Way(f, 2);
            Way de = new Way(e, 2);
            Way dc = new Way(c, 4);
            Way cd = new Way(d, 4);
            Way cb = new Way(b, 3);
            Way bc = new Way(c, 3);

            a.setWays(ab, ad, af);
            b.setWays(ba, bc);
            c.setWays(cb, cd);
            d.setWays(da, de, dc);
            f.setWays(fb, fe);
            e.setWays(ef);

            System.out.println(a);
            System.out.println("\n" + b);
            System.out.println("\n" + c);
            System.out.println("\n" + d);
            System.out.println("\n" + e);
            System.out.println("\n" + f);

        }
        //endregion
        //region task 1.3.4
        if (number == 13.4f) {
            Department itDep = new Department("IT", null);
            Employee pet = new Employee("Петрова", itDep);
            Employee koz = new Employee("Козлова", itDep);
            Employee sid = new Employee("Сидорова", itDep);

            Department test = pet.getDepartment();
            System.out.println(test.getEmployees());
        }
        //endregion

        //region task 1.4.1
        if (number == 14.1f) {
            System.out.println(new Point(3, 5));
            System.out.println(new Point(25, 6));
            System.out.println(new Point(7, 8));
        }
        //endregion
        //region task 1.4.2
        if (number == 14.2f) {
            Line line1 = new Line(1, 3, 23, 8);
            Line line2 = new Line(5, 10, 25, 10);
            Line line3 = new Line(line1.getStart(), line2.getEnd());
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }
        //endregion
        //region task 1.4.3
        if (number == 14.3f) {
            PolygonalLine empty = new PolygonalLine();
            PolygonalLine line = new PolygonalLine(new Point(3, 5), new Point(25, 6), new Point(7, 8));
            System.out.println(line);
        }
        //endregion
        //region task 1.4.4
        if (number == 14.4f) {
            House house1 = new House(2);
            House house2 = new House(35);
            House house3 = new House(91);

            System.out.println(house1);
            System.out.println(house2);
            System.out.println(house3);

//            house1.setCountFloors(10);
//            house1.countFloors = 10;

            System.out.println(house1);
        }
        //endregion
        //region task 1.4.5
        if (number == 14.5f) {
            Login name1 = new Login("Клеопатра");
            Login name2 = new Login("Пушкин", "Александр", "Сергеевич");
            Login name3 = new Login("Маяковский", "Владимир");
            Login name4 = new Login("Бонифатьевич", "Христофор");

            System.out.println(name1);
            System.out.println(name2);
            System.out.println(name3);
            System.out.println(name4);
        }
        //endregion
        //region task 1.4.6
        if (number == 14.6f) {
            Human lev = new Human("Лев");
            Human sergey = new Human(lev, new Login("Пушкин", "Сергей"));
            Human alexander = new Human(sergey, "Александр");

            System.out.println(lev);
            System.out.println(sergey);
            System.out.println(alexander);
        }
        //endregion
        //region task 1.4.7
        if (number == 14.7f) {
            Student vasya = new Student("Вася", 3, 4, 5);
            Student maxim = new Student("Максим");

            System.out.println(vasya);
            System.out.println(maxim);
        }
        //endregion
        //region task 1.4.8
        if (number == 14.8f) {
            Town a = new Town("A");
            Town b = new Town("B", new Way(a, 5));
            Town c = new Town("C", new Way(a, 3), new Way(b, 7));

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
        //endregion

        //region task 1.5.1
        if (number == 15.1f) {
            Pistol pistol = new Pistol(3);
            for (int i = 0; i < 5; i++) {
                pistol.shoot();
            }
        }
        //endregion
        //region task 1.5.2
        if (number == 15.2f) {
            Cat cat = new Cat("Барсик");
            System.out.println(cat);
            cat.meow();
            cat.meow(3);
        }
        //endregion
        //region task 1.5.3
        if (number == 15.3f) {
            Line line = new Line(new Point(1, 1), new Point(10, 15));
            System.out.println(line);
            System.out.println("Длина: " + line.length());
        }
        //endregion
        //region task 1.5.4
        if (number == 15.4f) {
            Human grandfather = new Human(180, new Login("Иванов", "Иван", "Петрович"));
            Human father = new Human(178, grandfather, new Login("Пётр"));
            Human son = new Human(175, father, new Login("Сергей"));
            System.out.println(son);
            System.out.println("Личное имя: " + son.getFirstName());
            System.out.println("Отчество: " + son.getPatronymicName());
            System.out.println("Фамилия: " + son.findSecondName());

            // Своя фамилия приоритетнее, без неё берётся ближайшая у предков
            son.setName(new Login("Сидоров", "Сергей", "Петрович"));
            System.out.println(son + " | фамилия: " + son.findSecondName());
            son.setName(new Login("Алексей"));
            System.out.println(son + " | фамилия: " + son.findSecondName());
        }
        //endregion
        //region task 1.5.5
        if (number == 15.5f) {
            Fraction f1 = new Fraction(1, 3);
            Fraction f2 = new Fraction(2, 3);
            Fraction f3 = new Fraction(3, 4);
            System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
            System.out.println(f1 + " + " + 5 + " = " + f1.sum(5));
            System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
            System.out.println(f1 + " - " + 5 + " = " + f1.minus(5));
            System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
            System.out.println(f1 + " * " + 5 + " = " + f1.mult(5));
            System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
            System.out.println(f1 + " / " + 5 + " = " + f1.div(5));
            System.out.println("f1.sum(f2).div(f3).minus(5) = " + f1.sum(f2).div(f3).minus(5));
        }
        //endregion
        //region task 1.5.6
//        if (number == 15.6f) {
//            Student vasya = new Student("Вася", 3, 4, 5, 4);
//            Student petya = new Student("Петя", 5, 5, 5, 5);
//            for (Student student : new Student[]{vasya, petya}) {
//                System.out.println(student.getName() + ": средний балл " + student.average() + ", отличник: " + student.isExcellent());
//            }
//        }
        //endregion
        //region task 1.5.7
        if (number == 15.7f) {
            PolygonalLine line = new PolygonalLine(new Point(1, 5), new Point(2, 8), new Point(5, 3));
            System.out.println(line + ", длина: " + line.length());
            line.addPoints(new Point(5, 15), new Point(8, 10));
            System.out.println(line + ", длина: " + line.length());
        }
        //endregion
        //region task 1.5.8
        if (number == 15.8f) {
            PolygonalChain square = new PolygonalChain(new Point(5, 3), 23);
            System.out.println(square);
            PolygonalLine line = square.getPolyLine();
            System.out.println(line + ", длина: " + line.length());
            Point last = line.getPoints().getLast();
            last.setX(15);
            last.setY(25);
            System.out.println(line + ", длина: " + line.length());
            System.out.println(square);
        }
        //endregion

        //region task 1.6.1
        if (number == 16.1f) {
            System.out.println(new House(1));
            System.out.println(new House(5));
//          new House(0);
//          new House(-3);
        }
        //endregion
        //region task 1.6.2
        if (number == 16.2f) {
            System.out.println(new Login("Иван"));
            System.out.println(new Login("Иванов", "Иван", ""));
//          new Login(null, null, null);
//          new Login("", " ", null);
//          new Login((String) null);
        }
        //endregion
        //region task 1.6.3
        if (number == 16.3f) {
            PolygonalChain square = new PolygonalChain(1, 2, 10);
            System.out.println(square);
            square.setSide(4);
            System.out.println(square + ", сторона: " + square.getSide());
//          new Square(1, 2, 0);
//          new Square(1, 2, -5);
//          square.setSide(0);
//          square.setSide(-1);
            System.out.println(square);
        }
        //endregion
        //region task 1.6.4
        if (number == 16.4f) {
            System.out.println(new Fraction(1, -2));
            System.out.println(new Fraction(-1, -2));
            System.out.println(new Fraction(-3, 4));
            Fraction a = new Fraction(1, 2);
            Fraction b = a.sum(new Fraction(1, 3));
            System.out.println(a + " и " + b + " (исходная дробь не изменилась)");
//          new Fraction(1, 0);
//          a.div(0);
        }
        //endregion
        //region task 1.6.5
        if (number == 16.5f) {
            Pistol pistol = new Pistol(0, 7);
            System.out.println("Вместимость: " + pistol.getMaxAmmo() + ", заряжен: " + pistol.isLoaded());
            pistol.reload(3);
            for (int i = 0; i < 5; i++) pistol.shoot();
            int rest = pistol.reload(8);
            System.out.println("Не поместилось: " + rest + ", патронов: " + pistol.getAmmo());
            for (int i = 0; i < 2; i++) pistol.shoot();
            System.out.println("Разряжено патронов: " + pistol.unload());
            pistol.shoot();
//          pistol.reload(-1);
        }
        //endregion
        //region task 1.6.6
        if (number == 16.6f) {
            Point common = new Point(1, 1);
            Line a = new Line(common, new Point(5, 5));
            Line b = new Line(common, new Point(7, 7));
            common.setX(100);
            System.out.println(a);
            System.out.println(b);
            a.getStart().setX(50);
            System.out.println(a + " (через getStart() линию не изменить)");
            System.out.println("Общая ссылка на точку: " + (a.getStart() == b.getStart()));
            a.setStart(new Point(2, 2));
            a.setEnd(9, 9);
            System.out.println(a + ", начало: " + a.getStart() + ", конец: " + a.getEnd());
            a.setNewCoords(3, 3);
            System.out.println(a);
        }
        //endregion
        //region task 1.6.7
        if (number == 16.7f) {
            Human father = new Human(180, new Login("Иванов", "Иван", "Петрович"));
            Human son = new Human(175, father, new Login("Пётр"));
            System.out.println(son.getFather() == father);
            Login name = son.getName();
            System.out.println(name);
            System.out.println(son);
        }
        //endregion
        //region task 1.6.8
        if (number == 16.8f) {
            Student student = new Student("Вася", 3, 4);
            student.addGrades(5, 2);
            System.out.println(student);
//          student.addGrades(1);
//          student.addGrades(6);
//          student.setGrades(4, 7);
//          new Student("Петя", 5, 0);
            ArrayList<Integer> copy = student.getGrades();
            copy.add(1);
            System.out.println(student + " (список из getGrades() - копия)");
        }
        //endregion
        //region task 1.6.9
        if (number == 16.9f) {
            Town a = new Town("A");
            Town b = new Town("B");
            Town c = new Town("C");
            a.addWay(new Way(b, 10));
            a.addWay(new Way(c, 7));
            System.out.println(a);
            a.addWay(new Way(b, 15));
            System.out.println(a);
            System.out.println("Удалена дорога в B: " + a.removeWay(b));
            System.out.println("Удалена дорога в B ещё раз: " + a.removeWay(b));
            System.out.println(a);
            Town d = new Town("D", new Way(a, 1), new Way(a, 2));
            System.out.println(d);
            a.getWays().getFirst().setCost(999);
            System.out.println(a + " (getWays() возвращает копии)");
        }
        //endregion
        //region task 1.6.10
        if (number == 16.101f) {
            Department it = new Department("IT", null);
            Employee ivan = new Employee("Иван", it);
            it.setBoss(ivan);
            Employee petr = new Employee("Пётр", it);
            System.out.println(ivan);
            System.out.println(petr);
            System.out.println("Начальник в отделе: " + (it.getBoss().getDepartment() == it));

            Department hr = new Department("HR", null);
            ivan.setDepartment(hr);
            System.out.println(it.getBoss() + " | отдел начальника тот же: " + (it.getBoss().getDepartment() == it));
            System.out.println(ivan);

            hr.setBoss(petr);
            System.out.println(petr + " | " + petr.getDepartment().getTitle());
            System.out.println(it.getBoss());

            Department empty = new Department(null, null);
            empty.setTitle(null);
            empty.setBoss(null);
            empty.addEmployees((Employee) null);
            empty.removeEmployees((Employee) null);
            empty.setEmployees((Employee[]) null);
            petr.setDepartment(null);
            System.out.println(empty + " | " + petr);
        }
        //endregion

        //region test
        if (number == 666.f) {
            System.out.println("GET OUT OF TEST SECTION");
        }
        //endregion
    }
}