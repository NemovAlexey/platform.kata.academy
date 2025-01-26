package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.4.7 Практическое задание «Вычисление факториала заданного натурального числа»

Цель: использование условных операторов при вычислениях
Задание:
Реализуй метод factorial, вычисляющий факториал заданного натурального числа.
Факториал N вычисляется как 1 ⋅ 2 ⋅ ... ⋅ N.
Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
Воспользуйтесь представленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
Пример ввода 1: 1
Пример возвращаемого значения 1: 1
Пример ввода 2: 3
Пример возвращаемого значения 2: 6

Требования:
1. Метод должен быть public.
2. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.
4. Метод должен быть реализован через цикл.
*/

import java.math.BigInteger;

public class Exercise_1_4_7 {
    public static void main(String[] args) {
        test();
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void test() {
        System.out.println(factorial(1)); //1
        System.out.println(factorial(3)); //6
    }
}
