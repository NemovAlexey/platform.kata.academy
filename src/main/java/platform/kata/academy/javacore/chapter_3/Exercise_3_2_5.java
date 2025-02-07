package platform.kata.academy.javacore.chapter_3;

/*
Практическая задача 3.2.5 Практическое задание «Практика обработки исключений в блоке catch/finally»

Создайте статический класс Car, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Машина закрывается...".
Try должен ловить все непроверяемые исключения и игнорировать их.
В методе main в блоке try вызови метод drive(). Метод drive должен выводить на экран сообщение "Машина поехала."

Требования:
1. Решение должно содержать статический класс Car.
2. Решение должно содержать метод main.
3. В решении должен использоваться try с ресурсами.
*/

public class Exercise_3_2_5 {
    public static void main(String[] args) {
        try (Car car = new Car()) {
            car.drive();
        } catch (Exception e) {
            //ignore
        }
    }

    public static class Car implements AutoCloseable {
        public void drive() {
            System.out.println("Машина поехала.");
        }

        @Override
        public void close() throws Exception {
            System.out.println("Машина закрывается...");
        }
    }
}
