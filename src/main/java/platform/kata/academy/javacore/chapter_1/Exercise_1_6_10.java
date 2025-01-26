package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.6.10 Практическое задание «Работа с регулярными выражениями»

Цель: работа с регулярными выражениями.

Что нужно знать:
1. Классы String, Pattern, Matcher.
2. Регулярные выражения.

Задание:
Реализовать метод, который будет принимать целочисленное строку и отвечать, соответствует ли эта строка почтовому ящику
сервисов Google (gmail.com) или Microsoft (outlook.com). Будем считать,
что в корректном почтовом ящике можно использовать только цифры и буквы.
Пример ввода: "kata12@gmail.com"
Пример вывода: true
Пример ввода: "@outlook.com"
Пример вывода: false

Требования:
Метод должен быть public static.
Сигнатура метода isGmailOrOutlook(String email).
Метод возвращает boolean.
*/

import java.util.regex.Pattern;

public class Exercise_1_6_10 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isGmailOrOutlook(String email) {
        if (!(email.endsWith("@outlook.com") || email.endsWith("@gmail.com"))) {
            return false;
        }
        return Pattern.compile("\\w+")
                .matcher(email.substring(0, email.lastIndexOf("@")))
                .matches();
    }

    public static void test() {
        System.out.println(isGmailOrOutlook("kata12@gmail.com"));   //true
        System.out.println(isGmailOrOutlook("@outlook.com"));       //false
    }
}
