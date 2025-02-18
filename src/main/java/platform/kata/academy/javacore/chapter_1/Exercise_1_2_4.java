package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.2.4 Практическое задание «Объявление примитивных типов данных»

Цель: научиться объявлять переменные
Задание: В методе main (точка входа в программу) объяви переменные всех простых (примитивных) типов. Проинициализируй их значениями, отличными от значений по умолчанию (измените значение переменных).

Требования:
1. Переменные должны находиться внутри метода main.
2. В методе main должны быть переменные всех простых типов.
3. В методе main должны быть переменные только простых типов.
4. Значения переменных должны отличаться от значений по умолчанию.
5. Переменные должны иметь имя var + тип примитива без пробелов и подчеркиваний, например, переменная типа int должна называться varint
*/

public class Exercise_1_2_4 {
    public static void main(String[] args) {
        byte varbyte = 1;
        short varshort = 1;
        int varint = 1;
        long varlong = 1L;
        float varfloat = 1.0f;
        double vardouble = 1.0d;
        char varchar = 65; //'A'
        boolean varboolean = true;
    }
}
