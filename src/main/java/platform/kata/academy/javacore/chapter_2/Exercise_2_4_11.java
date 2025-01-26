package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.4.11 Практическое задание «Наследование»

Цель: Создание класса наследника (Задача Переопределение метода)

Что нужно знать:
1. Как создавать классов наследников в Java
2. Переопределение метода

Задание:
Помнишь наших студентов из прошлой задачи? Так вот, не все студенты трудолюбивые. Некоторый, бывают, ленятся.
Создай на основе класса Student класс LazyStudent, которому лень учится.

Требования:
1. класс LazyStudent должен быть public static
2. класс LazyStudent должен быть наследником Student.
3. класс LazyStudent должен иметь только один публичный конструктор - конструктор без параметров.
4. класс LazyStudent должен переопределять метод study.
5. Метод study() вызванный у объектов LazyStudent должен выводить в консоль сообщение "Сегодня не учусь, мне лень."
*/

public class Exercise_2_4_11 {
    public static void main(String[] args) {
        test();
    }

    public static class Student {
        protected final String studying;

        protected Student(String work) {
            this.studying = work;
        }

        public Student() {
            this.studying = "Прохожу тестовое задание.";
        }

        public void study() {
            System.out.println("Я очень занят. " + studying);
        }
    }

    public static class LazyStudent extends Student {
        public LazyStudent() {
            super();
        }

        @Override
        public void study() {
            System.out.println("Сегодня не учусь, мне лень.");
        }
    }

    public static void test() {
        new LazyStudent().study();
    }
}
