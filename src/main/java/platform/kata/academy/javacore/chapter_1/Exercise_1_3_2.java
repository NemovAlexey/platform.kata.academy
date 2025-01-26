package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.3.2 Практическое задание «Преобразование базовых типов данных»

Цель: работа с целочисленными данными

Задание:
Реализуй метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии а. В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
1. Сигнатура метода должна быть: charExpression(int a)
*/

public class Exercise_1_3_2 {
    public static void main(String[] args) {
    }

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
