package platform.kata.academy.javacore.chapter_1;

/*
В спортивном центре есть три возрастные группы для занятий волейболом. Первая — от 7 до 13 лет, вторая — от 14 до 17 лет, третья — от 18 до 65 лет.

Задание:
Напиши публичный не статичный метод determineGroup, который принимает возраст человека и возвращает целое число,
обозначающее номер группы, в которую его надо определить. Если подходящей группы нет, верни -1.
Пример ввода: 10
Пример вывода: 1
Пример ввода: 60
Пример вывода: 3
Пример ввода: 77
Пример вывода: -1

Требования:
Сигнатура метода должна быть: determineGroup(int age)
Метод должен возвращать int
Метод не должен быть статическим
*/

public class Exercise_1_4_9 {
    public static void main(String[] args) {
        test();
    }

    public int determineGroup(int age) {
        return (age >= 7 && age <= 13) ? 1 :
                (age >= 14 && age <= 17) ? 2 :
                        (age >= 18 && age <= 65) ? 3 : -1;
    }

    public static void test() {
        System.out.println(new Exercise_1_4_9().determineGroup(10)); //1
        System.out.println(new Exercise_1_4_9().determineGroup(60)); //3
        System.out.println(new Exercise_1_4_9().determineGroup(77)); //-1
    }
}
