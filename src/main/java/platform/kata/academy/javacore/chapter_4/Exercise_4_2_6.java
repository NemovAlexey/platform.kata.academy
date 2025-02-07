package platform.kata.academy.javacore.chapter_4;

/*
Практическая задача 4.2.6 Практическое задание «Написание метода void print(InputStream inputStream, OutputStream outputStream)»

Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и
OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.
Пример ввода: 3, 10, 4, 5, 7
Пример вывода: 10, 4

Требования:
1. Метод должен быть публичным.
2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)
*/

import java.io.*;

public class Exercise_4_2_6 {
    public static void main(String[] args) throws IOException {
        new Exercise_4_2_6().test();
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int b;
        while ((b = inputStream.read()) != -1) {
            if (b % 2 == 0) {
                outputStream.write(b);
            }
        }
        outputStream.flush();
    }

    public void test() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        print(inputStream, outputStream);
        for (byte b : outputStream.toByteArray()) {
            System.out.println(b);
        }
    }
}
