package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.2.14 Практическое задание «Вычисление радиуса окружности»

Цель: вычисление радиуса окружности по площади с использованием класса Math.

Что нужно знать:
Класс Math (методы и константы)
Базовая арифметика
System.out.printf

Задание:
Реализовать метод calcCircleRadius(double area), который вычисляет радиус окружности по заданной площади и выводит его
на экран. Точность — три знака после запятой. Для указания количества знаков после запятой используй метод
для форматированного вывода System.out.printf
Пример ввода: 123
Пример вывода: 6.257
Пример ввода: 10
Пример вывода: 1.784

Требования:
метод должен быть public static
сигнатура метода calcCircleRadius(double area)
на экран выводится число с тремя знаками после запятой
*/

public class Exercise_1_2_14 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        calcCircleRadius(123); //6.257
        System.out.println();
        calcCircleRadius(10); //1.784
    }

    public static void calcCircleRadius(double area) {
        System.out.printf("%.3f", Math.sqrt(area / Math.PI));
    }
}
