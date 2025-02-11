package platform.kata.academy.javacore.chapter_6;

import java.util.stream.IntStream;

/*
Практическая задача 6.2.11 Практическое задание «Напишите метод IntStream»

Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
Первый элемент последовательности устанавливается равным этому числу.
Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn^2), где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.
Пример ввода: 13
Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

Требования:
1. Должен быть метод public static IntStream pseudoRandomStream(int seed)
2. Метод должен возвращать поток, удовлетворяющий условию
*/


public class Exercise_6_2_11 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        IntStream stream = pseudoRandomStream(13);
        stream.limit(10).forEach(x -> System.out.print(x + " "));
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n % 10000 / 10);
    }
}
