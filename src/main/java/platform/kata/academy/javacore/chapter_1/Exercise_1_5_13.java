package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.5.13 Практическое задание «Работа с массивами и условными операторами»

Задание:
Напиши метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него, через запятую. Конец вывода должен перевести курсор на новую строку.
Пример ввода: [3,5,20,8,7,3,100]
Пример вывода: 3,5,7,3

Требования:
Сигнатура метода должна быть: printOddNumbers(int[] arr)
*/

public class Exercise_1_5_13 {
    public static void main(String[] args) {
        test();
    }

    public static void printOddNumbers(int[] arr) {
        if (arr.length == 0) {
            System.out.println();
            return;
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] % 2 != 0) {
                b.append(arr[i]).append(",");
            }
        }
        if (!b.isEmpty()) {
            b.deleteCharAt(b.length() - 1);
            System.out.print(b);
        }
        System.out.println();
    }

    public static void test() {
        printOddNumbers(new int[]{3, 5, 20, 8, 7, 3, 100});   //3,5,7,3
    }
}
