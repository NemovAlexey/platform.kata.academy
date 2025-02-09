package platform.kata.academy.javacore.chapter_5;

/*
Практическая задача 5.2.14 Практическое задание «Напишите метод Map getSalesMap(Reader reader)»

Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма всех его продаж.

Пример ввода:
Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

Требования:
1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
2. Работа метода getSalesMap должна удовлетворять условию
*/


import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_5_2_14 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Reader reader = new StringReader("""
                Алексей 3000
                Дмитрий 9000
                Антон 3000
                Алексей 7000
                Антон 8000""");
        System.out.println(getSalesMap(reader));
    }

    public static Map<String, Long> getSalesMap(Reader reader) {
        Scanner scanner = new Scanner(reader);
        Map<String, Long> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            map.merge(scanner.next(), scanner.nextLong(), Long::sum);
        }
        return map;
    }
}
