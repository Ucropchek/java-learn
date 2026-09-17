class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2};
        DynamicArray arrDyn = new DynamicArray();
        System.out.println(arrDyn);
        arrDyn.value = new int[]{1, 2, 3, 4};
        arrDyn.addLast(55);
        System.out.println(arrDyn);
        System.out.println(arrDyn.sum());
    }
}

// ДОБАВИТЬ В КЛАСС МЕТОД ПРИНИМАЮЩИЙ ДВУМЕРНЫЙ МАССИВ ЧИСЕЛ
// И СОРТИРУЮЩИЙ ЕГО ТАК
// ЧТОБЫ СТРОКИ ШЛИ ПО ВОЗРАСТАНИЮ
// СУММЫ ЭЛЕМЕНТОВ СТРОКИ








