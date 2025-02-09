package platform.kata.academy.javacore.chapter_5;

/*
Практическая задача 5.2.15 Практическое задание «Программа System»

Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность
в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
Все import объявлены за вас.
Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercise_5_2_15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; input.hasNextInt(); i++) {
            if (i % 2 != 0) deque.addFirst(input.nextInt());
            else input.nextInt();
        }
        deque.forEach(v -> System.out.print(v + " "));
        test();
    }

    private static void test() {

    }

}
