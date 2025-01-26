package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.2.8 Практическое задание «Переиспользование методов»

Цель: переиспользование методов.

Что нужно знать:
1. if/else
2. Массивы
3. Циклы

Одним из принципов хорошего кода является DRY — Don’t repeat yourself (не повторяй себя). Его идея заключается в том,
что при написании кода программист не должен одинаково копировать логику/код в несколько разных мест,
вместо этого код нужно организовывать на такие логические куски, которые можно будет переиспользовать.
Подробнее об этом можно ознакомиться в статье
«Три ключевых принципа ПО, которые вы должны понимать» https://habr.com/ru/post/144611/.

Задание:
Реализуй три метода:
1. boolean isWeekend(String dayName) — метод принимает строку и отвечает,
является ли эта строка выходным днем. Выходным днем являются Sunday и Saturday. Реализацию можно взять из прошлых задач.
2. int weekendCount(String[] days) — метод принимает массив строк и возвращает количество выходных дней в этом массиве.
3. int weekdayCount(String[] days) — метод принимает массив строк и возвращает количество будних дней в этом массиве.

Требования:
Методы должны быть public static.
Сигнатура метода isWeekend(String dayName).
Метод возвращает boolean.
Сигнатура метода weekendCount(String[] days).
Метод возвращает int.
Сигнатура метода weekdayCount(String[] days).
Метод возвращает int.
Переиспользовать методы, не копировать код.
*/

public class Exercise_2_2_8 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isWeekend(String dayName) {
        return dayName.equalsIgnoreCase("Sunday") || dayName.equalsIgnoreCase("Saturday");
    }

    public static int weekendCount(String[] days) {
        int count = 0;
        for (String day : days) {
            if (isWeekend(day)) {
                count++;
            }
        }
        return count;
    }

    public static int weekdayCount(String[] days) {
        return days.length - weekendCount(days);
    }


    public static void test() {

    }
}
