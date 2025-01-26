package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.4.10 Практическое задание «Метод Switch»
Цель: Работа с оператором switch

Что нужно знать:
1. Оператор switch

Задание:
Реализовать метод, который будет принимать строку с названием дня недели, и отвечать, является ли этот день выходным. Список дней недели:
"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday". Если строка не соответствует ни одному дню недели отправлять false.
Пример ввода: Monday
Пример вывода: false
Пример ввода: Saturday
Пример вывода: true

Требования:
метод должен быть public static;
сигнатура метода isWeekend(String weekday);
метод возвращает boolean;
решить с использованием оператора switch.
*/

public class Exercise_1_4_10 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isWeekend(String weekday) {
        return switch (weekday) {
            case "Saturday", "Sunday" -> true;
            default -> false;
        };
    }

    public static void test() {
        System.out.println(isWeekend("Monday"));    //false
        System.out.println(isWeekend("Saturday"));  //true
    }
}
