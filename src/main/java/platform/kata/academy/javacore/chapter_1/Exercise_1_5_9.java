package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.9 Практическое задание «Вывод массива в консоль c помощью Arrays»

Цель: научиться выводить массив с его значениями в консоль.

Что нужно знать:
1. Методы класса System.
2. Arrays.

Задание:
Реализуйте метод, который будет принимать массив чисел, и выводить его значения в консоль c помощью методов класса Arrays
Пример ввода: {1,2,3,4,5,5,6,7,7}
Пример вывода: [1, 2, 3, 4, 5, 5, 6, 7, 7]
Пример ввода: {}
Пример вывода: []

Требования:
Метод должен быть public static.
Сигнатура метода printArray(int[] numbers).
Элементы массива должны быть заключены в квадратные скобки [].
Элементы массива отделены друг от друга запятой и пробелом.
*/

import java.util.Arrays;

public class Exercise_1_5_9 {
    public static void main(String[] args) {
        test();
    }

    public static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }

    public static void test() {
        printArray(new int[]{1,2,3,4,5,5,6,7,7});   //[1, 2, 3, 4, 5, 5, 6, 7, 7]
        printArray(new int[]{});                    //[]
    }
}
