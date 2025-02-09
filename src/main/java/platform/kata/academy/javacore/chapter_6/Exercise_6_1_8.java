package platform.kata.academy.javacore.chapter_6;

/*
Практическая задача 6.1.8 Практическое задание «Напишите метод с названием sqrt»

Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator, который принимает целое число (тип int) и возвращает его квадрат.

Требования:
1. Должен быть метод public UnaryOperator sqrt()
2. Метод должен возвращать реализацию интерфейса UnaryOperator.
3. Реализация должна соответствовать условию
*/


import java.util.function.UnaryOperator;

public class Exercise_6_1_8 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Exercise_6_1_8().sqrt().apply(16));
    }


    public UnaryOperator<Integer> sqrt() {
        return x -> x * x;
    }
}
