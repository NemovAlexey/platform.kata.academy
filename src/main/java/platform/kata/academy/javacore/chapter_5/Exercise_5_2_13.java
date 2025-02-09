package platform.kata.academy.javacore.chapter_5;

/*
Практическая задача 5.2.13 Практическое задание «Реализуйте метод symmetricDifference»

Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств.
Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]

Требования:
1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
2. метод symmetricDifference не должен изменять исходные множества
3. метод symmetricDifference должен возвращать корректный результат
*/


import java.util.HashSet;
import java.util.Set;

public class Exercise_5_2_13 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Set<Integer> set1 = new HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Set.of(0, 1, 2));

        System.out.println(symmetricDifference(set1, set2));
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        result.removeIf(item -> set1.contains(item) && set2.contains(item));
        return result;
    }
}
