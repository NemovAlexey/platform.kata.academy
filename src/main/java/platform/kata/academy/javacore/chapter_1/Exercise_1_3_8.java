package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.3.8 Практическое задание «Метод isPowerOfTwo»

Цель: работа с двоичной системой счисления

Задание:
Реализуй метод isPowerOfTwo, проверяющий, является ли заданное число по абсолютной величине степенью двойки.
Решать можно разными способами:
Воспользовавшись одним удобным статическим методом из класса java.lang.Integer.
Применив пару трюков из двоичной арифметики.
Написав решение «в лоб» с циклом и условными операторами. Можешь вернуться к этой задаче после просмотра соответствующих уроков.
Пример ввода 1: 0
Пример возвращаемого значения 1: false
Пример ввода 2: 1
Пример возвращаемого значения 2: true
Пример ввода 3: -2
Пример возвращаемого значения 3: true

Требования:
1. Метод должен быть public.
2. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.
*/

public class Exercise_1_3_8 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }

    public static void test() {
        System.out.println(isPowerOfTwo(0)); //false
        System.out.println(isPowerOfTwo(1)); //true
        System.out.println(isPowerOfTwo(-2)); //true
    }
}
