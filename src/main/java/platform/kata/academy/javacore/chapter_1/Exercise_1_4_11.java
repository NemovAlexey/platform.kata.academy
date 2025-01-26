package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.4.11 Практическое задание «Метод IF/Else»

Цель: Работа с оператором if/else

Что нужно знать:
1. Оператор if

Задание:
Реализовать метод, который будет принимать строку с названием дня недели, и отвечать, является ли этот день выходным. Список дней недели:
"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday". Если строка не соответствует ни одному дню недели отправлять false.
Пример ввода: Monday
Пример вывода: false
Пример ввода: Saturday
Пример вывода: true

Требования:
метод должен быть public static;
сигнатура метода isWeekend(int weekDayNumber);
метод возвращает boolean;
решить с использованием оператора if.
*/

public class Exercise_1_4_11 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isWeekend(String weekday) {
        if (weekday.equals("Saturday") || weekday.equals("Sunday")) {
            return true;
        } else {
            return false;
        }
    }

    public static void test() {
        System.out.println(isWeekend("Monday"));    //false
        System.out.println(isWeekend("Saturday"));  //true
    }
}
