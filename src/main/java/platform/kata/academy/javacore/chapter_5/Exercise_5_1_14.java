package platform.kata.academy.javacore.chapter_5;

/*
Практическая задача 5.1.14 Практическое задание «Метод java.util.Arrays»

Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который хранит
в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и извлечения
T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый, большего размера.
Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
воспользоваться методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе.
Добавлять его явно не нужно

Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
4. класс DynamicArray должен иметь публичный конструктор по умолчанию
5. работа методов должна соответствовать условию
*/


import java.util.Arrays;

public class Exercise_5_1_14 {
    public static void main(String[] args) {

    }

    public static class DynamicArray<T> {
        private int size = 0;
        private T[] array = (T[]) new Object[16];

        public void add(T el) {
            if (size == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            array[size++] = el;
        }

        public void remove(int index) {
            System.arraycopy(array, index + 1, array, index, size-- - index);
        }

        public T get(int index) {
            return array[index];
        }
    }
}
