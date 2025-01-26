package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.6.8 Практическое задание «Преобразование строки в число в Java»

Цель: преобразование строки в число.

Что нужно знать:
1. Класс String.
2. Класс Integer.

Задание:
Реализовать метод, который будет принимать целочисленное (Integer) число в строковом виде (например, "14213123"),
преобразовать его в тип Integer, затем вывести результат деления этого числа на 2 в консоль.
Пример ввода: "64"
Пример вывода: 32
Пример ввода: "111"
Пример вывода: 55

Требования:
Сигнатура метода parseAndPrintNumber(String number).
Метод должен быть void.
*/

public class Exercise_1_6_8 {
    public static void main(String[] args) {
        test();
    }

    public void parseAndPrintNumber(String str) {
        System.out.println((Integer.parseInt(str) / 2));
    }

    public static void test() {
        new Exercise_1_6_8().parseAndPrintNumber("64"); //32
        new Exercise_1_6_8().parseAndPrintNumber("111"); //55
    }
}
