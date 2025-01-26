package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.4 Практическое задание «Взятие части массива»

Дан массив возрастающих чисел. Даны два числа. Задача — написать метод, который из данного массива достанет ту часть, которая лежит между данными числами (включительно).

Что нужно знать:
1. Работа с массивами
2. Циклы
3. Условные операторы

Пример ввода: {1,3,5,6,9,11,24}, 4, 10
Пример вывода: [5, 6, 9]

Требования:
Метод должен быть public static.
Сигнатура метода getSubArrayBetween(int[] numbers, int start, int end.
*/

import java.util.Arrays;

public class Exercise_1_5_4 {
    public static void main(String[] args) {
        test();
    }

    public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        int count = 0;
        for (int num : numbers) {
            if (num >= start && num <= end) {
                count++;
            }
        }
        int[] res = new int[count];
        int i = 0;
        for (int num : numbers) {
            if (num >= start && num <= end) {
                res[i++] = num;
            }
        }
        return res;
    }

    public static void test() {
        System.out.println(Arrays.toString(getSubArrayBetween(new int[]{1, 3, 5, 6, 9, 11, 24}, 4, 10)));
        //[5, 6, 9]
    }
}
