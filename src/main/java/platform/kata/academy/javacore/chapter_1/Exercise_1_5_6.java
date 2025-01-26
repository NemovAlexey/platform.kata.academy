package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.6 Практическое задание «Инверсия массива»

Цель: Развернуть данный массив

Что нужно знать:
1. Работа с массивами
2. Циклы

Задание:
Написать метод, который принимает массив, разворачивает его и возвращает.

Пример ввода: {1, 4, 6, 7}
Пример вывода: [7, 6, 4, 1]
Пример ввода: {}
Пример вывода: []

Требования:
Метод должен быть public static.
Сигнатура метода inverseArray(int[] numbers).
*/

import java.util.Arrays;

public class Exercise_1_5_6 {
    public static void main(String[] args) {
        test();
    }

    public static int[] inverseArray(int[] numbers) {
        int l = numbers.length;
        if (l == 0) {
            return numbers;
        }
        for (int left = 0, right = l - 1; left < right; left++, right--) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
        }
        return numbers;
    }

    public static void test() {
        System.out.println(Arrays.toString(inverseArray(new int[]{1, 4, 6, 7})));      //[7, 6, 4, 1]
        System.out.println(Arrays.toString(inverseArray(new int[]{})));               //[]
    }
}
