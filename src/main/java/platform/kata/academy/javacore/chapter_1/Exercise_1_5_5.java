package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.5 Практическое задание «Вернуть середину массива»

Цель: вернуть середину массива

Что нужно знать:
1. Массивы
2. Условные операторы
3. Циклы

Задание:
Дан массив произвольной длины. Необходимо вернуть центральную часть массива. Причем если массив четной длины,
то нужно вернуть массив из двух элементов, если нечетной — из одного элемента.
Пример ввода: {1, 5, 2, 17}
Пример вывода: [5, 2]
Пример ввода: {14, 16, 3}
Пример вывода: [16]
Пример ввода: {}
Пример вывода: []

Требования:
Метод должен быть public static.
Сигнатура метода getArrayMiddle(int[] numbers).
Не использовать Arrays, System.arraycopy.
*/

import java.util.Arrays;

public class Exercise_1_5_5 {
    public static void main(String[] args) {
        test();
    }

    public static int[] getArrayMiddle(int[] numbers) {
        int l = numbers.length;
        if (l == 0) {
            return numbers;
        } else if (l % 2 == 1) {
            return new int[]{numbers[l / 2]};
        } else {
            return new int[]{numbers[l / 2 - 1], numbers[l / 2]};
        }
    }

    public static void test() {
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{1, 5, 2, 17})));    //[5, 2]
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{14, 16, 3})));      //[16]
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{})));               //[]
    }
}
