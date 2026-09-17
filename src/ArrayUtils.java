// добавить сюда JavaDoc (на каждый класс повесить описание методов и сгенерировать html. ArrayUtils это библиотека, которую мы закинем в репозиторий)

public class ArrayUtils {
    public static double sum(int[] arr) {
        if (arr == null) return Double.NaN;
        double total = 0;
        for (int el : arr) {
            total += el;
        }
        return total;
    }

    public static String toString(int []arr) {
        if (arr == null) return "null";
        if (arr.length == 0) return "[]";

        String returnString;
        returnString = "[" + arr[0];
        for (int i = 1; i < arr.length; i++) {
            returnString += ", " + arr[i];
        }
        returnString += "]";
        return returnString;
    }

    public static int[] addLast(int []arr, int num) {
        if (arr == null) return new int[]{num};
        int[] arr2 = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        arr2[arr.length] = num;
        return arr2;
    }

    public static void print2DArr(int [][]arr) {
        System.out.println("[");
        for (int[] arr1D : arr) {
            System.out.println("    " + toString(arr1D) + ",");
        }
        System.out.println("]");
    }

    public static void printArr(int []arr) {
        System.out.print(toString(arr));
    }

    public static void sort2D(int [][]arr) {
        int lenArr = arr.length;
        if (lenArr < 2) return;
        int[] sums = new int[lenArr];
        for (int i = 0; i < lenArr; i++) {
            sums[i] = (int) sum(arr[i]);
        }
        qSortBySum(arr, sums, 0, lenArr - 1);
    }

    private static void qSortBySum(int [][]arr, int []sortBy, int start, int end) {
        if (start > end) return;

        int r = end;
        int l = start;
        int mid = (r - l) / 2 + l;
        int pivot = sortBy[l];
        int pivot_idx = l;
        if (sortBy[r] > sortBy[l] && sortBy[r] <= sortBy[mid]
         || sortBy[r] < sortBy[l] && sortBy[r] > sortBy[mid]) {
            pivot = sortBy[r];
            pivot_idx = r;
        }
        else if (sortBy[mid] > sortBy[l] && sortBy[mid] <= sortBy[r]
              || sortBy[mid] <= sortBy[l] && sortBy[mid] > sortBy[r]) {
            pivot = sortBy[mid];
            pivot_idx = mid;
        }
        int tempSumPivot = sortBy[pivot_idx];
        int[] tempLinkPivot = arr[pivot_idx];
        sortBy[pivot_idx] = sortBy[start];
        arr[pivot_idx] = arr[start];
        sortBy[start] = tempSumPivot;
        arr[start] = tempLinkPivot;
        l++;

        while (l <= r) {
            while (sortBy[l] <= pivot) {
                l++;
            }
            while (sortBy[r] >= pivot && r >= l) {
                r--;
            }
            if (l < r) {
                int tempSum = sortBy[r];
                int[] tempLink = arr[r];
                sortBy[r] = sortBy[l];
                arr[r--] = arr[l];
                sortBy[l] = tempSum;
                arr[l++] = tempLink;
            }
        }

        tempSumPivot = sortBy[start];
        tempLinkPivot = arr[start];
        sortBy[start] = sortBy[r];
        arr[start] = arr[r];
        sortBy[r] = tempSumPivot;
        arr[r] = tempLinkPivot;

        qSortBySum(arr, sortBy, start, r - 1);
        qSortBySum(arr, sortBy, r + 1, end);
    }
}
