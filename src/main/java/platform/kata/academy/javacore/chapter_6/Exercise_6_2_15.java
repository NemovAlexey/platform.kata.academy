package platform.kata.academy.javacore.chapter_6;

/*
Практическая задача 6.2.15 Практическое задание «Вычисление факториала с помощью Stream API»

Цель: Вычислить факториал с помощью Stream API
Что нужно знать: Stream API

Задание:
Реализуйте метод, вычисляющий факториал, с помощью Stream API.
В тестовую систему импортирован весь пакет java.util.stream

Пример ввода 1: 1
Пример возвращаемого значения 1: 1

Пример ввода 2: 3
Пример возвращаемого значения 2: 6

Требования:
1. Метод должен быть public static.
2. Метод должен возвращать BigInteger.
3. Сигнатура метода factorial(int value).
4. Метод должен быть с использованием Stream API
*/

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Exercise_6_2_15 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(factorial(1));
        System.out.println(factorial(3));
    }

    public static BigInteger factorial(int value) {
        if (value <= 1) {
            return BigInteger.ONE;
        } else {
            return IntStream.rangeClosed(2, value).mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();
        }
    }
}
