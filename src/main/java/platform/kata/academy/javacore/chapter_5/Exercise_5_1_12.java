package platform.kata.academy.javacore.chapter_5;

/*
Практическая задача 5.1.12 Практическое задание «Generics Метод getBox()»

В классе Box из прошлой задачи нужно добавить статический метод getBox(), который возвращает пустой параметризованный объект типа Box.

Требования:
1. Класс должен быть параметризован T.
2. Поле должно быть приватным с именем object.
3. Класс должен иметь публичный модификатор доступа.
4. Класс должен иметь публичный статический метод getBox().
5. метод getBox() должен работать согласно условию
6. Класс Box должен быть статическим.
*/


public class Exercise_5_1_12 {
    public static void main(String[] args) {

    }

    public static class Box<T> {
        private T object;

        public static <T> Box<T> getBox() {
            return new Box<>();
        }
    }
}
