package platform.kata.academy.javacore.chapter_2;

/*
Практическая задача 2.1.8 Практическое задание «Реализация equals() и hashCode()»

Дан класс ComplexNumber. Переопредели в нем методы equals() и hashCode() так, чтобы equals() сравнивал
экземпляры ComplexNumber по содержимому полей re и im, а hashCode() был согласованным с реализацией equals().
Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

Пример
ComplexNumber a = new ComplexNumber(1, 1);
ComplexNumber b = new ComplexNumber(1, 1);
// a.equals(b) must return true
// a.hashCode() must be equal to b.hashCode()

Подсказка 1. Поищи в классе java.lang.Double статический метод, который поможет в решении задачи.
Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет сама генерировать equals() и hashCode(). Если ты воспользовался помощью IDE, разберись, что было сгенерировано и почему оно выглядит именно так. Когда тебя на собеседовании попросят на бумажке реализовать equals() и hashCode() для какого-нибудь простого класса, то среда разработки помочь не сможет.

Требования:
1. Должен быть класс public static class ComplexNumber.
2. Класс ComplexNumber должен иметь поля re и im типа double.
3. Класс ComplexNumber должен переопределять public boolean equals(Object o) и public int hashCode().
4. equals и hashcode должны корректно работать.
*/

public class Exercise_2_1_8 {
    public static void main(String[] args) {
        test();
    }

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber that = (ComplexNumber) o;
            return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(re);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(im);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    public static void test() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        System.out.println(a.equals(b));    //must return true
        System.out.println(a.hashCode());   //must be equal to b.hashCode()
        System.out.println(b.hashCode());   //must be equal to a.hashCode()
    }
}
