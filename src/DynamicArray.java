// 1) добавить сюда JavaDoc (на каждый класс повесить описание методов и сгенерировать html. ArrayUtils это библиотека, которую мы закинем в репозиторий)

// 2) добавить в начало, в указанную позицию, удаление соответственно
// 2*) (для тех кто осилит) сделать нормальный дин. массив у которого size и capacity не одно и тоже

// 3) Реализовать задания 1.1 из задачинка

import java.util.Arrays;

public class DynamicArray {
    int[] value;
    
    public double sum() {
        if (value == null) return Double.NaN;
        double total = 0;
        for (int el : value) {
            total += el;
        }
        return total;
    }

    public String toString() {
        if (value == null) return "null";
        if (value.length == 0) return "[]";

        String returnString;
        returnString = "[" + value[0];
        for (int i = 1; i < value.length; i++) {
            returnString += ", " + value[i];
        }
        returnString += "]";
        return returnString;
    }

    public void addLast(int num) {
        if (value == null) {
            value = new int[]{num};
            return;
        }
        int[] arr2 = new int[value.length + 1];
        for (int i = 0; i < value.length; i++) {
            arr2[i] = value[i];
        }
        arr2[value.length] = num;
        value = arr2;
    }
}