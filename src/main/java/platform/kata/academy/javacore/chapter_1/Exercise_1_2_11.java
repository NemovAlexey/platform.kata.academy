package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.2.11 Практическое задание «Вещественные числа и класс Math»

Задача: Реализуй метод, возвращающий ответ на вопрос: правда ли, что a + b = c ?
Допустимая погрешность — 0.0001 (1E-4)
Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
В качестве примера написано заведомо неправильное выражение. Исправь его.

Требования:
Метод должен иметь сигнатуру doubleExpression(double a, double b, double c)
*/

public class Exercise_1_2_11 {
    public static void main(String[] args) {
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }
}
