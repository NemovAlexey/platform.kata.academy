package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.2.8 Практическое задание «Арифметические операции»

Задача:
Напиши публичный метод priceCalculation, который считает стоимость товара.
В метод передается цена товара (может быть дробной) и количество товара, метод должен возвращать итоговую цену покупки.
Пример ввода: 8.50, 2
Пример вывода: 17.0

Требования:
Сигнатура метода должна быть: priceCalculation(double price, int count)
*/

public class Exercise_1_2_8 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(new Exercise_1_2_8().priceCalculation(8.5, 2)); //17.0
    }

    public double priceCalculation(double price, int count) {
        return price * count;
    }
}
