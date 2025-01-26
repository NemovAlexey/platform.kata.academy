package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.3 Практическое задание «Печать массива в консоль»

Цель: научиться выводить массив с его значениями в консоль.

Что нужно знать:
1. Методы класса System
2. Циклы

Задание:
В java для вывода информации в консоль используются методы System.out.print(), System.out.println().
Однако если мы захотим вывести на экране массив с его значениями, просто поместив его в этот метод, например так:
int[] numbers = {1, 2 ,3 ,4 ,5};
System.out.println(numbers);
то в консоли мы увидим что-то подобное:
[I@7ba4f24f
Все потому что по умолчанию в массивах используется метод toString, определенный в классе Object.
Поэтому для вывода значения массива в консоль нам понадобится написать свой метод.
Реализуй метод, который будет принимать массив чисел, и выводить его значения в консоль.
Пример ввода: {1,2,3,4,5,5,6,7,7}
Пример вывода: [1, 2, 3, 4, 5, 5, 6, 7, 7]
Пример ввода: {}
Пример вывода: []

Требования:
Метод должен быть public static.
Сигнатура метода printArray(int[] numbers).
Элементы массива должны быть заключены в квадратные скобки [].
Элементы массива отделены друг от друга запятой и пробелом.
Не использовать класс Arrays.
*/

public class Exercise_1_5_3 {
    public static void main(String[] args) {
        test();
    }

    public static void printArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            System.out.println("[]");
            return;
        }
        int iMax = numbers.length - 1;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; ; i++) {
            sb.append(numbers[i]);
            if (i == iMax) {
                sb.append("]");
                System.out.println(sb);
                return;
            }
            sb.append(", ");
        }
    }

    public static void test() {
        printArray(new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7});   //[1, 2, 3, 4, 5, 5, 6, 7, 7]
        printArray(new int[]{});                            //[]
    }
}
