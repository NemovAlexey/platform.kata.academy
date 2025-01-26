package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.4.8 Практическое задание «Вычисление с рекурсией»

Задание:
Реализуй предыдущую задачу с использованием рекурсии.
Пример ввода 1: 1
Пример возвращаемого значения 1: 1
Пример ввода 2: 3
Пример возвращаемого значения 2: 6

Требования:
1. Метод должен быть public.
2. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.
4. Реализация метода должна быть через рекурсию.
*/

import java.math.BigInteger;

public class Exercise_1_4_8 {
    public static void main(String[] args) {
        test();
    }

    public static BigInteger factorial(int value) {
        return value <= 1 ? BigInteger.ONE : BigInteger.valueOf(value).multiply(factorial(--value));
    }

    public static void test() {
        System.out.println(factorial(1)); //1
        System.out.println(factorial(3)); //6
    }
}
