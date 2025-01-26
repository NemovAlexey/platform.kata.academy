package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.1.6 Кодовая задача «Работа с Enum»

Цель: научиться создавать перечисления (Enum).

Что нужно знать:
1. Enum

Задание:
Реализовать Enum Day, который будет отвечать за дни недели. Этот Enum должен содержать следующие элементы:
MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
Также в этом Enum должны быть реализованы два метода:
1. public boolean isWeekend() — метод, отвечающий на вопрос, является ли конкретный элемент выходным днем. Выходными днями являются только суббота и воскресенье.
2. public String getRusName() — метод, возвращающий русское название дня недели.

Требования:
Enum должен иметь название Day.
Enum должен содержать элементы на каждый день недели.
Сигнатура метода isWeekend().
метод isWeekend возвращает boolean.
Сигнатура метода getRusName().
Метод getRusName возвращает String.
*/

public class Exercise_2_1_6 {
    public static void main(String[] args) {
        test();
    }

    public enum Day {
        MONDAY(false, "понедельник"),
        TUESDAY(false, "вторник"),
        WEDNESDAY(false, "среда"),
        THURSDAY(false, "четверг"),
        FRIDAY(false, "пятница"),
        SATURDAY(true, "суббота"),
        SUNDAY(true, "воскресенье");
        private final boolean isWeekend;
        private final String rusName;

        Day(boolean isWeekend, String rusName) {
            this.isWeekend = isWeekend;
            this.rusName = rusName;
        }

        public boolean isWeekend() {
            return isWeekend;
        }

        public String getRusName() {
            return rusName;
        }
    }

    public static void test() {
        System.out.println(Day.MONDAY.isWeekend);
        System.out.println(Day.MONDAY.rusName);
        System.out.println(Day.SUNDAY.isWeekend);
        System.out.println(Day.SUNDAY.rusName);
    }
}
