package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.5.6 Практическое задание «Напишите статический класс AsciiCharSequence»

Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
(их коды влезают в один байт) в массиве байт. По сравнению с классом String из Java 8, хранящим каждый символ как char,
AsciiCharSequence будет занимать в два раза меньше памяти

Класс AsciiCharSequence должен:
реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).
В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.
*/

import java.util.Arrays;

public class Exercise_2_5_6 {
    public static void main(String[] args) {
        test();
    }


    public static class AsciiCharSequence implements CharSequence {
        private final byte[] value;

        public AsciiCharSequence(byte[] bytes) {
            value = bytes;
        }

        @Override
        public int length() {
            return value.length;
        }

        @Override
        public char charAt(int index) {
            return (char) value[index];
        }

        @Override
        public AsciiCharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(value, start, end));
        }

        @Override
        public String toString() {
            return new String(value);
        }
    }

    public static void test() {
        AsciiCharSequence charSequence = new AsciiCharSequence(new byte[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'});
        System.out.println("toString: " + charSequence);
        System.out.println("Length: " + charSequence.length());
        System.out.println("charAt(3): " + charSequence.charAt(3));
        System.out.println("subSequence(2, 5): " + charSequence.subSequence(2, 5));
    }
}
