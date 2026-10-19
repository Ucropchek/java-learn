package ru.seroglazov.main;

import java.math.BigInteger;
import ru.seroglazov.validation.IllegalNumberException;
import static ru.seroglazov.main.MainTest.args;
import static ru.seroglazov.main.Section2.sum;
import static java.lang.Math.pow;
import static java.lang.Integer.parseInt;
import ru.seroglazov.geometry.Point;

public class Section3 {
    public static void run(Float number) {
        //region task 3.1.3
        if (number == 31.3f) {
            Number[] nums = {7, 113, 3.21, new BigInteger("12345678912345678912")};
            System.out.println(sum(nums));
        }
        //endregion
        //region task 3.1.4
        if (number == 31.4f) {
            System.out.println(powNumber(args[0], args[1]));
        }
        //endregion
        //region task 3.1.5
        if (number == 31.5f) {
            Point pMy = new Point(4, 6);
            java.awt.Point pJv = new java.awt.Point(1, 1);
            System.out.println(pMy);
            System.out.println(pJv);
        }
        //endregion
    }
    
    public static Number powNumber(String x, String y) {
        if (!isInt(x) || !isInt(y)) {
            throw new IllegalNumberException("Передано null или не число");
        }
        return pow(parseInt(x), parseInt(y));
    }

    private static boolean isInt(String str) {
        if (str == null || str.isEmpty() || str.equals("-")) return false;

        String digits = str;
        String limit = "2147483647";
        if (str.charAt(0) == '-') {
            digits = str.substring(1);
            limit = "2147483648";
        }

        int i = 0;
        while (i < digits.length()) {
            char ch = digits.charAt(i);
            if (ch < '0' || ch > '9') return false;
            i++;
        }

        if (digits.length() > 10) return false;
        if (digits.length() < 10) return true;
        return digits.compareTo(limit) <= 0;
    }
}
