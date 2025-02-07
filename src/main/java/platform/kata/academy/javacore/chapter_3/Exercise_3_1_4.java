package platform.kata.academy.javacore.chapter_3;

/*
Практическая задача 3.1.4 Практическое задание «Метод testExp()»

Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(), который выбрасывает MyNewException при вызове.

Требования:
1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
2. Класс исключения должен иметь модификатор доступа по умолчанию.
3. Метод testExp() расположите вне класса исключения.
*/

public class Exercise_3_1_4 {
    public static void main(String[] args) throws MyNewException {
        new Exercise_3_1_4().testExp();
    }

    public class MyNewException extends Exception {

    }

    public void testExp() throws MyNewException {
        throw new MyNewException();
    }
}
