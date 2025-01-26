package platform.kata.academy.javacore.chapter_1;

/*
Практическая задача 1.6.9 Практическое задание «Преобразование строки в число в Java»

Реализуй метод, проверяющий, является ли заданная строка палиндромом.
Палиндромом называется строка, которая читается одинаково слева направо и справа налево, в том числе пустая.
При определении палиндромности строки должны учитываться только буквы и цифры. А пробелы, знаки препинания,
а также регистр символов должны игнорироваться. Гарантируется, что в метод попадают только строки,
состоящие из символов ASCII: цифры, латинские буквы, знаки препинания. То есть русских, китайских и прочих
экзотических символов в строке не будет.
Для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться регулярным выражением
"[^a-zA-Z0-9]".
Найди в классе String метод, выполняющий замену по регулярному выражению и воспользуйся им.
Воспользуйся представленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
Пример ввода 1: Was it a cat I saw?
Пример вывода 1: true
Пример ввода 2: A palindrome is a word, number, phrase, or other sequence of characters which reads the same
backward as forward, such as madam or race car or the number 10801.
Пример вывода 2: false

Требования:
1. Должен быть доступный статический метод boolean isPalindrome(String text).
2. Работа метода должна удовлетворять условию, указанному ниже.
*/

public class Exercise_1_6_9 {
    public static void main(String[] args) {
        test();
    }

    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return text.equals(String.valueOf(new StringBuilder(text).reverse()));
    }

    public static void test() {
        System.out.println(isPalindrome("Was it a cat I saw?"));    //true
        System.out.println(isPalindrome("A palindrome is a word, number, phrase, " +
                "or other sequence of characters which reads the same backward as forward, " +
                "such as madam or racecar or the number 10801."));    //false
    }
}
