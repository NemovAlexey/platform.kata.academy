package platform.kata.academy.javacore.chapter_6;

/*
Практическая задача 6.1.9 Практическое задание «Создайте функциональный интерфейс NumberGenerator»

Создайте функциональный интерфейс NumberGenerator, параметризованный таким образом, что принимает только наследников
класса Number, имеющий метод boolean cond(T arg).
Создайте в методе public static NumberGenerator<? super Number> getGenerator() с помощью лямбда выражения реализацию
NumberGenerator, которая возвращает true, если число в int эквиваленте больше 0.

Требования:
1. Должен быть метод public static NumberGenerator<? super Number> getGenerator()
2. Соблюдайте код стайл при параметризации.
3. Имя параметра должно быть "Т"
4. Метод должен возвращать корректную реализацию
*/

public class Exercise_6_1_9 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(getGenerator().cond(16));
    }

    @FunctionalInterface
    public interface NumberGenerator<T extends Number> {
        boolean cond(T arg);
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;
    }
}
