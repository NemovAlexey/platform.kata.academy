package platform.kata.academy.javacore.chapter_4;

/*
Практическая задача 4.3.6 Практическое задание «Метод InputStream и кодировка»

Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)
*/

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Exercise_4_3_6 {
    public static void main(String[] args) throws IOException {
        test();
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = inputStreamReader.read()) != -1) {
            sb.append((char) b);
        }
        return sb.toString();
    }

    public static void test() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }
}
