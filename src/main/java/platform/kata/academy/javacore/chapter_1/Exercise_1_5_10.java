package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.10 Практическое задание «Вернуть середину c помощью Arrays»

Цель: Вернуть середину массива.

Что нужно знать:
1. Массивы.
2. Класс Arrays.

Задание:
Дан массив произвольной длины. Необходимо вернуть центральную часть массива. Причем если массив четной длины, нужно вернуть массив из двух элементов, если нечетной — из одного элемента.
Пример ввода: {1, 5, 2, 17}
Пример вывода: [5, 2]
Пример ввода: {14, 16, 3}
Пример вывода: [16]
Пример ввода: {}
Пример вывода: []

Требования:
Метод должен быть public static.
Сигнатура метода getArrayMiddle(int[] numbers).
Использовать Arrays или System.arraycopy.
*/

import java.util.Arrays;

public class Exercise_1_5_10 {
    public static void main(String[] args) {
        test();
    }

    public static int[] getArrayMiddle(int[] numbers) {
        int l = numbers.length;
        if (l == 0) {
            return numbers;
        } else if (l % 2 == 1) {
            return Arrays.copyOfRange(numbers, l / 2, l / 2 + 1);
        } else {
            return Arrays.copyOfRange(numbers, l / 2 - 1, l / 2 + 1);
        }
    }

    public static void test() {
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{1, 5, 2, 17})));    //[5, 2]
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{14, 16, 3})));      //[16]
        System.out.println(Arrays.toString(getArrayMiddle(new int[]{})));               //[]
    }
}
