package platform.kata.academy.javacore.chapter_6;

/*
Практическая задача 6.2.13 Практическое задание «Stream API. Мама мыла раму»

Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 и в конце выводящую 10 наиболее часто встречающихся слов.
Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
Выводите слова в нижнем регистре.
Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

Пример ввода 1:
Мама мыла-мыла-мыла раму!
Пример вывода 1:
мыла
мама
раму

Пример ввода 2:
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem.
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
Пример вывода 2:
consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi

Требования:
1. Должен быть метод public static void main(String[] args)
2. Программа должна читать данные с консоли
2. Программа должна писать данные в консоль
*/


import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercise_6_2_13 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        StringReader sr1 = new StringReader("Мама мыла-мыла-мыла раму!");
        StringReader sr2 = new StringReader("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. " +
                "Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt " +
                "efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac " +
                "auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi " +
                "tempor dignissim.");
        countWordFrequency(sr1);
        countWordFrequency(sr2);
//        countWordFrequency(new InputStreamReader(System.in));
    }

    public static void countWordFrequency(Reader reader) {
        new BufferedReader(reader)
                .lines()
                .map(line -> line.toLowerCase().split("[^a-zа-я0-9']+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }
}
