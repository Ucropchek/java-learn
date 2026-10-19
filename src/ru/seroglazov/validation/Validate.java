package ru.seroglazov.validation;

public class Validate {
    public static boolean isNull(Object... objs) {
        if (objs == null) return true;
        boolean ret = false;
        for (Object obj : objs) {
            if (obj == null) return true;
        }
        return false;
    }

    public static boolean isNullAll(Object... objs) {
        if (objs == null) return true;
        boolean ret = true;
        for (Object obj : objs) {
            ret = ret && isNull(obj);
        }
        return ret;
    }

    public static boolean isNegative(Number... objs) {
        isNullException("Вы пытаятесь проверить null!", objs);
        boolean ret = false;
        for (var num : objs) {
            isNullException("Передайте валидное число. Передан null.", num);
            ret = ret || num.doubleValue() < 0;
        }
        return ret;
    }

    public static boolean isZeroNegative(Number... objs) {
        isNullException("Вы пытаятесь проверить null!", objs);
        boolean ret = false;
        for (Number num : objs) {
            isNullException("Передайте валидное число. Передан null.", num);
            ret = ret || num.doubleValue() <= 0;
        }
        return ret;
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (long) a + b > c && (long) a + c > b && (long) b + c > a;
    }

    public static void isNullException(String errorMessage, Object... objs) {
        if (isNull(errorMessage)) errorMessage = "Передано пустое значение";
        if (isNull(objs)) throw new IllegalArgumentException(errorMessage);
    }

    public static void isNullAllException(String errorMessage, Object... objs) {
        if (isNull(errorMessage)) errorMessage = "Передано пустое значение";
        if (isNullAll(objs)) throw new IllegalArgumentException(errorMessage);
    }

    public static void isNegativeException(String errorMessage, Number... objs) {
        isNullException(null, objs);
        if (isNull(errorMessage)) errorMessage = "Передано отрицательное число";
        if (isNegative(objs)) throw new NegativeValueException(errorMessage);
    }

    public static void isZeroNegativeException(String errorMessage, Number... objs) {
        isNullException(null, objs);
        if (isNull(errorMessage)) errorMessage = "Передано неположительное число";
        if (isZeroNegative(objs)) throw new ZeroOrNegativeValueException(errorMessage);
    }

    public static void isTriangleException(String errorMessage, int a, int b, int c) {
        if (isNull(errorMessage)) errorMessage = "Не выполнено неравенство треугльника";
        if (!isTriangle(a, b, c)) throw new TriangleInequalityException("Не выполнено неравенство треугльника");
    }
}
