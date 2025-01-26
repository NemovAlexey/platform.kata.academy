package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.2.15 Практическое задание «Получение квадрата максимального long»

Цель: использовать арифметические операции с BigInteger

Что нужно знать:
1. класс BigInteger
2. класс Long

Задание:
Реализовать метод, выводящий на экран квадрат максимального значения, которое может содержаться в переменной long. Чтобы это значение уместилось, необходимо использовать класс BigInteger

Требования:
метод должен быть public static
сигнатура метода maxLongSqr()
*/

import java.math.BigInteger;

public class Exercise_1_2_15 {
    public static void main(String[] args) {
    }

    public static void maxLongSqr() {
        BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);
        System.out.println(maxLong.multiply(maxLong));
    }
}
