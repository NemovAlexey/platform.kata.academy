package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.11 Практическое задание «Слияние массивов c помощью Arrays»

Цель: Слить два произвольных массива в один отсортированный

Что нужно знать:
1. Массивы
2. Циклы
3. Условные операторы

Задание:
Реализовать метод mergeAndSort(int[] firstArray, int[] secondArray), который принимает, соединяет и сортирует два произвольных массива чисел
Пример ввода: {1, 3, 7, 5}, {8, 4, 2, 4}
Пример вывода: [1, 2, 3, 4, 4, 5, 7, 8]
Пример ввода: {} {1, 4, 3}
Пример вывода: [1, 3, 4]

Требования:
Метод должен быть public static.
Сигнатура метода mergeAndSort(int[] firstArray, int[] secondArray).
*/

import java.util.Arrays;

public class Exercise_1_5_11 {
    public static void main(String[] args) {
        test();
    }

    public static int[] mergeAndSort(int[] firstArray, int[] secondArray) {
        int[] res = Arrays.copyOf(firstArray, firstArray.length + secondArray.length);
        System.arraycopy(secondArray, 0, res, firstArray.length, secondArray.length);
        Arrays.sort(res);
        return res;
    }

    public static void test() {
        System.out.println(Arrays.toString(mergeAndSort(new int[]{1, 3, 7, 5}, new int[]{8, 4, 2, 4})));    //[1, 2, 3, 4, 4, 5, 7, 8]
        System.out.println(Arrays.toString(mergeAndSort(new int[]{}, new int[]{1, 4, 3})));                 //[1, 3, 4]
    }
}
