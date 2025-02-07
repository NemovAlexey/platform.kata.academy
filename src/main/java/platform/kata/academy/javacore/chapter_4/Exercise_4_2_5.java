package platform.kata.academy.javacore.chapter_4;

/*
Практическая задача 4.2.5 Практическое задание «Метод intsumOfStream(InputStream inputStream)»

Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его элементов.
Пример ввода: 1, 2, 4, 10
Пример вывода: 17

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип InputStream.
3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)
*/

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Exercise_4_2_5 {
    public static void main(String[] args) throws IOException {
        new Exercise_4_2_5().test();
    }

    public int sumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        while (inputStream.available() > 0) {
            sum += (byte) inputStream.read();
        }
        return sum;
    }

    public void test() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{1, 2, 4, 10});
        System.out.println(sumOfStream(inputStream));
    }
}
