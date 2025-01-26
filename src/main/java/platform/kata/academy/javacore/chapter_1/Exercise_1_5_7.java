package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.7 Практическое задание «Сортировка массива»

Цель: Слить два произвольных массива в один отсортированный.

Что нужно знать:
1. Массивы
2. Циклы
3. Условные операторы

Задание:
Реализовать метод mergeAndSort(int[] firstArray, int[] secondArray), который принимает, соединяет и сортирует два произвольных массива чисел.
Пример ввода: {1, 3, 7, 5}, {8, 4, 2, 4}
Пример вывода: [1, 2, 3, 4, 4, 5, 7, 8]
Пример ввода: {} {1, 4, 3}
Пример вывода: [1, 3, 4]

Требования:
1. Метод должен быть public static.
2. Сигнатура метода mergeAndSort(int[] firstArray, int[] secondArray).
3. Не использовать Arrays.
*/

import java.util.Arrays;

public class Exercise_1_5_7 {
    public static void main(String[] args) {
        test();
    }

    public static int[] mergeAndSort(int[] firstArray, int[] secondArray) {
        int[] res = new int[firstArray.length + secondArray.length];
        int i = 0;
        while (i < res.length) {
            for (int k : firstArray) {
                res[i++] = k;
            }
            for (int k : secondArray) {
                res[i++] = k;
            }
        }
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int j = 1; j < res.length; j++) {
                if (res[j] < res[j - 1]) {
                    int temp = res[j];
                    res[j] = res[j - 1];
                    res[j - 1] = temp;
                    notSorted = true;
                }
            }
        }
        return res;
    }

    public static void test() {
        System.out.println(Arrays.toString(mergeAndSort(new int[]{1, 3, 7, 5}, new int[]{8, 4, 2, 4})));
        //[1, 2, 3, 4, 4, 5, 7, 8]
        System.out.println(Arrays.toString(mergeAndSort(new int[]{}, new int[]{1, 4, 3})));
        //[1, 3, 4]
    }
}
